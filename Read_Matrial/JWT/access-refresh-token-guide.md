# Access Token & Refresh Token — Complete Guide with MERN Employee Management App

> A full reference covering JWT structure, generation, refresh token rotation, reuse detection, and a production-style MERN application built on MVC architecture.

---

## Table of Contents

1. [Why Two Tokens?](#1-why-two-tokens)
2. [Structure of an Access Token](#2-structure-of-an-access-token)
3. [Structure of a Refresh Token](#3-structure-of-a-refresh-token)
4. [What Is Needed to Create a Refresh Token](#4-what-is-needed-to-create-a-refresh-token)
5. [How Tokens Are Generated — Step by Step](#5-how-tokens-are-generated--step-by-step)
6. [Refresh Token Rotation — Working Flow](#6-refresh-token-rotation--working-flow)
7. [Why Token Rotation Is Needed](#7-why-token-rotation-is-needed)
8. [Employee Management Application — Full Code](#8-employee-management-application--full-code)
9. [Testing the API](#9-testing-the-api)
10. [Security Checklist](#10-security-checklist)

---

## 1. Why Two Tokens?

HTTP is stateless. Every request must carry proof of identity. There are two competing pressures:

| Pressure | Implication |
|---|---|
| Security | If a token leaks, the damage window should be tiny. |
| User experience | Nobody wants to log in every 15 minutes. |

A single token cannot satisfy both. So the responsibility is split:

| | Access Token | Refresh Token |
|---|---|---|
| **Purpose** | Prove identity on every API call | Obtain a new access token |
| **Lifetime** | Short — 5 to 15 minutes | Long — 7 to 30 days |
| **Sent to** | Every protected endpoint | Only `/api/auth/refresh` |
| **Stored where** | Memory / React state (never localStorage) | `httpOnly` `Secure` cookie |
| **Stored in DB?** | No — stateless | Yes — hashed, so it can be revoked |
| **Revocable?** | No (until it expires) | Yes, immediately |
| **Contains** | `userId`, `email`, `role` | `userId`, `jti`, `family` |

The access token is a **disposable day pass**. The refresh token is the **membership card** kept in the safe.

### The core trade-off

```
Access token long-lived  →  convenient, but a leaked token = long-lived breach
Access token short-lived →  secure, but user logs in constantly
Access short + Refresh long →  secure AND convenient
```

---

## 2. Structure of an Access Token

An access token is almost always a **JWT (JSON Web Token)** — three Base64URL-encoded segments joined by dots:

```
xxxxx.yyyyy.zzzzz
  │      │      │
  │      │      └── Signature
  │      └───────── Payload  (claims)
  └──────────────── Header   (metadata)
```

### Real example

```
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWYxYTJiM2M0ZDVlNmY3YTh
iOWMwZDEiLCJlbWFpbCI6ImFkbWluQGNvbXBhbnkuY29tIiwicm9sZSI6ImFkbWluIiwiaWF
0IjoxNzE3NTAwMDAwLCJleHAiOjE3MTc1MDA5MDB9.K3xQ9vN2mT8pL1sR4wY7hB6cA0dF5g
```

### 2.1 Header

Describes *how* the token is signed.

```json
{
  "alg": "HS256",
  "typ": "JWT"
}
```

| Field | Meaning |
|---|---|
| `alg` | Signing algorithm — `HS256` (shared secret) or `RS256` (public/private key pair) |
| `typ` | Token type, always `JWT` |
| `kid` | *(optional)* Key ID — used when you rotate signing keys |

### 2.2 Payload

The actual data. **Base64 is encoding, not encryption** — anyone can decode this. Never put passwords, OTPs, or card numbers here.

```json
{
  "_id": "65f1a2b3c4d5e6f7a8b9c0d1",
  "email": "admin@company.com",
  "role": "admin",
  "iat": 1717500000,
  "exp": 1717500900,
  "iss": "employee-management-api",
  "aud": "employee-management-client"
}
```

**Registered (standard) claims:**

| Claim | Full name | Purpose |
|---|---|---|
| `iss` | Issuer | Who created the token |
| `sub` | Subject | Who the token is about (user ID) |
| `aud` | Audience | Who the token is intended for |
| `exp` | Expiration Time | Unix timestamp after which token is invalid |
| `nbf` | Not Before | Token is not valid before this time |
| `iat` | Issued At | When the token was created |
| `jti` | JWT ID | Unique identifier for this specific token |

**Custom claims** are yours: `role`, `permissions`, `tenantId`, etc. Keep the payload small — it travels on every single request.

### 2.3 Signature

This is what makes the token tamper-proof:

```
HMACSHA256(
  base64UrlEncode(header) + "." + base64UrlEncode(payload),
  ACCESS_TOKEN_SECRET
)
```

If an attacker changes `"role": "user"` to `"role": "admin"`, the payload changes, so the recomputed signature no longer matches. Verification fails. The attacker cannot forge a valid signature without the secret.

**Important:** the signature guarantees *integrity*, not *confidentiality*. The contents are public.

---

## 3. Structure of a Refresh Token

There are two valid designs. This guide uses the **hybrid** approach, which is the strongest.

### Design A — Opaque Random String

```js
crypto.randomBytes(64).toString('hex')
// → "a3f8e91c7b2d4e6f..."
```

- Carries no information. Meaningless to an attacker.
- Server must look it up in the database every time.
- Fully revocable.

### Design B — JWT Refresh Token

```json
{
  "_id": "65f1a2b3c4d5e6f7a8b9c0d1",
  "jti": "9f2a4c6e-8b1d-4f3a-a7c5-2e9d0b8f1a3c",
  "family": "d4b8e2f1-6a3c-4e7b-9f0d-1c5a8e2b4d6f",
  "iat": 1717500000,
  "exp": 1718104800
}
```

| Claim | Why it exists |
|---|---|
| `_id` | Which user this belongs to |
| `jti` | Unique ID for **this one token** — lets you revoke exactly one token |
| `family` | Groups all tokens descended from one login — used for reuse detection |
| `exp` | Hard expiry (e.g. 7 days) |

### Design C — Hybrid (recommended, used in this app)

Issue a **JWT** to the client, but also store a **SHA-256 hash** of it in MongoDB.

```
Client holds:  eyJhbGci...  (the JWT, in an httpOnly cookie)
Database holds: sha256(token) + family + revoked flag + expiry + device info
```

You get stateless verification *and* instant revocation.

### Database record shape

```js
{
  _id:         ObjectId("..."),
  user:        ObjectId("65f1a2b3c4d5e6f7a8b9c0d1"),
  tokenHash:   "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
  family:      "d4b8e2f1-6a3c-4e7b-9f0d-1c5a8e2b4d6f",
  jti:         "9f2a4c6e-8b1d-4f3a-a7c5-2e9d0b8f1a3c",
  revoked:     false,
  replacedBy:  null,
  expiresAt:   ISODate("2026-09-25T10:00:00Z"),
  ipAddress:   "203.0.113.45",
  userAgent:   "Mozilla/5.0 ...",
  createdAt:   ISODate("2026-09-18T10:00:00Z")
}
```

**Why store a hash and not the raw token?** If your database is dumped, raw refresh tokens would let an attacker impersonate every user. Hashes are useless to them. Same reasoning as password hashing.

---

## 4. What Is Needed to Create a Refresh Token

This is the detailed answer to "what do I actually need?"

### 4.1 A separate secret

```env
ACCESS_TOKEN_SECRET=f4a8...   # 64+ random bytes
REFRESH_TOKEN_SECRET=9c2e...  # DIFFERENT 64+ random bytes
```

**Never reuse the same secret for both.** If they share a secret, a stolen access token could be replayed against the refresh endpoint, and vice versa. Generate them with:

```bash
node -e "console.log(require('crypto').randomBytes(64).toString('hex'))"
```

### 4.2 A long expiry, but not infinite

```env
REFRESH_TOKEN_EXPIRY=7d
```

7 days is a sensible default for a business app. Banking apps use 15–30 minutes of inactivity. "Remember me" flows may use 30 days. Never use `never`.

### 4.3 A unique token identifier (`jti`)

Without a `jti`, you can only revoke *all* of a user's tokens, never a single one. With it, you can log out one device and leave the others alone.

```js
import { randomUUID } from 'crypto';
const jti = randomUUID();
```

### 4.4 A family identifier

All tokens that descend from one login share a `family` ID. When token #1 is rotated into token #2, both carry the same family. This is the mechanism that makes reuse detection possible — see §6.

### 4.5 Persistent storage with revocation state

You need a collection that records, for each issued refresh token:

- who it belongs to
- whether it has been revoked
- what replaced it
- when it expires

A TTL index on `expiresAt` lets MongoDB auto-delete expired rows so the collection does not grow forever.

```js
refreshTokenSchema.index({ expiresAt: 1 }, { expireAfterSeconds: 0 });
```

### 4.6 A secure transport mechanism

Refresh tokens must travel in an `httpOnly` cookie, never in a JSON response body that JavaScript can read:

```js
res.cookie('refreshToken', token, {
  httpOnly: true,                                  // JS cannot read it → blocks XSS theft
  secure: process.env.NODE_ENV === 'production',   // HTTPS only
  sameSite: 'strict',                              // blocks CSRF
  path: '/api/auth',                               // only sent to auth routes
  maxAge: 7 * 24 * 60 * 60 * 1000
});
```

### 4.7 Device / context metadata

Storing IP and user-agent lets you build a "Active Sessions" screen and detect suspicious refreshes from a new country.

### 4.8 A rotation + reuse-detection policy

Covered fully in §6 and §7.

### Summary checklist

- [ ] Separate `REFRESH_TOKEN_SECRET`
- [ ] Finite expiry (`7d`)
- [ ] Unique `jti` per token
- [ ] `family` ID per login session
- [ ] DB collection storing the **hash**, not the token
- [ ] TTL index for auto-cleanup
- [ ] `httpOnly` + `Secure` + `SameSite` cookie
- [ ] IP / user-agent captured
- [ ] Rotation on every use
- [ ] Reuse detection that kills the whole family

---

## 5. How Tokens Are Generated — Step by Step

### Login flow

```
1. Client POSTs { email, password } to /api/auth/login
         │
2. Server finds user by email
         │
3. bcrypt.compare(plainPassword, user.password)
         │
4. ✗ mismatch → 401 Invalid credentials
   ✓ match    → continue
         │
5. Generate ACCESS token
      payload: { _id, email, role }
      secret:  ACCESS_TOKEN_SECRET
      expiry:  15m
         │
6. Generate REFRESH token
      jti    = randomUUID()
      family = randomUUID()          ← new family, this is a fresh login
      payload: { _id, jti, family }
      secret:  REFRESH_TOKEN_SECRET
      expiry:  7d
         │
7. Store sha256(refreshToken) + family + jti + expiry + IP + UA in MongoDB
         │
8. Respond:
      Set-Cookie: refreshToken=...; HttpOnly; Secure; SameSite=Strict
      Body: { accessToken, user }
```

### Refresh flow

```
1. Access token expires → API returns 401
         │
2. Axios interceptor catches 401, calls POST /api/auth/refresh
   (cookie is sent automatically — no JS involvement)
         │
3. Server verifies JWT signature + expiry
         │
4. Server hashes the token and looks it up in DB
         │
5. ┌─ Not found     → 401, clear cookie
   ├─ revoked=true  → 🚨 REUSE DETECTED → revoke entire family → 401
   └─ valid         → continue
         │
6. Mark old token revoked=true, replacedBy=<new jti>
         │
7. Issue NEW access token + NEW refresh token (same family, new jti)
         │
8. Store new hash, set new cookie, return new access token
         │
9. Interceptor retries the original failed request
```

---

## 6. Refresh Token Rotation — Working Flow

**Rotation** means: a refresh token can be used **exactly once**. Every time it is redeemed, it is destroyed and a brand-new one is issued in its place.

### Normal life of a session

```
Login
  └─ RT₁  (family = F, jti = 1)  ── issued ──► browser cookie

15 min later, access token expires
  └─ browser sends RT₁
       ├─ RT₁ marked revoked, replacedBy = 2
       └─ RT₂  (family = F, jti = 2)  ── issued ──► browser cookie

15 min later
  └─ browser sends RT₂
       ├─ RT₂ marked revoked, replacedBy = 3
       └─ RT₃  (family = F, jti = 3)  ── issued ──► browser cookie

... and so on. Only the newest token in family F is ever valid.
```

### Attack scenario — without rotation

```
Attacker steals RT via XSS / malware / network capture

  Attacker uses RT  → gets access token ✓
  User uses RT      → gets access token ✓
  Attacker uses RT  → gets access token ✓
  ...

Both parties use the SAME token forever.
The server sees nothing unusual. Breach lasts until RT expires (7 days).
```

### Attack scenario — with rotation and reuse detection

```
t=0   User logs in                        → RT₁ issued
t=1   Attacker steals RT₁
t=2   Attacker redeems RT₁                → RT₁ revoked, RT₂ issued to ATTACKER
t=3   User's access token expires,
      browser redeems RT₁ (its stale copy)
         │
         └─► Server: RT₁ found, but revoked = true
                  🚨 A REVOKED TOKEN WAS REPLAYED
                  This can only mean two parties hold tokens from family F
                  → REVOKE ALL TOKENS IN FAMILY F (including attacker's RT₂)
                  → Force re-login
                  → Log security event / alert user

Attacker's RT₂ is now dead. Breach window ≈ minutes, not days.
```

This works symmetrically: whether the attacker or the legitimate user refreshes second, the replay is caught.

### Visual state machine

```
                    ┌──────────┐
       login ──────►│  ACTIVE  │
                    └────┬─────┘
                         │ redeemed
                         ▼
                    ┌──────────┐      replayed      ┌──────────────────┐
                    │ REVOKED  │ ─────────────────► │ FAMILY COMPROMISED│
                    │ (used)   │                    │  revoke all       │
                    └──────────┘                    └──────────────────┘
                         │
                         │ issues
                         ▼
                    ┌──────────┐
                    │ ACTIVE   │  (new jti, same family)
                    └──────────┘
```

---

## 7. Why Token Rotation Is Needed

### 7.1 It shrinks the breach window

Without rotation, a stolen refresh token is valid for its full lifetime — potentially 30 days of silent, undetectable access. With rotation, the token dies the moment it is used once.

### 7.2 It makes theft *detectable*

This is the real prize. Ordinarily a server cannot distinguish a legitimate user from an attacker holding a valid token — both present identical credentials. Rotation creates an observable signal: **a token being used twice is physically impossible for a single honest client.** The moment you see it, you know something is wrong.

### 7.3 It enables automatic remediation

Detection alone is not enough. Because tokens are grouped by `family`, one replay lets you revoke the attacker's token, the user's token, and every descendant, in a single atomic operation — without waiting for a human to notice.

### 7.4 It limits blast radius

Family-scoped revocation means a compromise on one device does not log the user out of the others. Their phone session (family G) is untouched when their laptop session (family F) is burned.

### 7.5 It reduces the value of stale backups and logs

Refresh tokens often leak through proxy logs, browser history, crash dumps, and old database backups. With rotation, any token found in such a source is almost certainly already revoked — worthless.

### 7.6 Compliance and standards

Rotation is an explicit recommendation of **OAuth 2.0 Security Best Current Practice (RFC 9700)** for public clients such as SPAs and mobile apps, which cannot hold a client secret. Many audit frameworks now expect it.

### What rotation does *not* solve

Be clear-eyed about the limits:

- It does not stop the initial theft — fix XSS, use CSP, use `httpOnly`.
- It does not protect against a compromised device that keeps refreshing faster than the user.
- It requires careful handling of **race conditions**: two parallel tabs may both try to refresh with the same token. Mitigate with a short grace period (e.g. accept a just-revoked token for 10 seconds) or a client-side refresh mutex. This guide uses a client-side mutex in the axios interceptor.

| Threat | Without rotation | With rotation |
|---|---|---|
| Stolen refresh token | Valid for full lifetime | Valid for one use |
| Theft detection | Impossible | Automatic on replay |
| Response time | Manual, after user reports | Instant, automated |
| Blast radius | All sessions or none | One family |

---

## 8. Employee Management Application — Full Code

### 8.1 Project Structure (MVC)

```
employee-management/
│
├── backend/
│   ├── src/
│   │   ├── config/
│   │   │   └── db.js
│   │   │
│   │   ├── models/                  ← M (Model)
│   │   │   ├── user.model.js
│   │   │   ├── refreshToken.model.js
│   │   │   └── employee.model.js
│   │   │
│   │   ├── controllers/             ← C (Controller)
│   │   │   ├── auth.controller.js
│   │   │   └── employee.controller.js
│   │   │
│   │   ├── routes/                  ← Route layer
│   │   │   ├── auth.routes.js
│   │   │   └── employee.routes.js
│   │   │
│   │   ├── middlewares/             ← Middleware folder
│   │   │   ├── auth.middleware.js
│   │   │   ├── role.middleware.js
│   │   │   └── error.middleware.js
│   │   │
│   │   ├── utils/
│   │   │   ├── ApiError.js
│   │   │   ├── ApiResponse.js
│   │   │   ├── asyncHandler.js
│   │   │   └── token.util.js
│   │   │
│   │   ├── app.js
│   │   └── server.js
│   │
│   ├── .env
│   ├── .env.example
│   ├── .gitignore
│   └── package.json
│
└── frontend/
    ├── src/
    │   ├── api/
    │   │   └── axios.js
    │   ├── context/
    │   │   └── AuthContext.jsx
    │   ├── components/
    │   │   ├── ProtectedRoute.jsx
    │   │   └── EmployeeForm.jsx
    │   ├── pages/
    │   │   ├── Login.jsx
    │   │   ├── Register.jsx
    │   │   └── Dashboard.jsx
    │   ├── App.jsx
    │   └── main.jsx
    └── package.json
```

---

### 8.2 Backend Setup

```bash
mkdir -p employee-management/backend && cd employee-management/backend
npm init -y
npm install express mongoose bcryptjs jsonwebtoken cookie-parser cors dotenv express-rate-limit
npm install -D nodemon
```

**`backend/package.json`**

```json
{
  "name": "employee-management-backend",
  "version": "1.0.0",
  "type": "module",
  "main": "src/server.js",
  "scripts": {
    "dev": "nodemon src/server.js",
    "start": "node src/server.js"
  },
  "dependencies": {
    "bcryptjs": "^2.4.3",
    "cookie-parser": "^1.4.6",
    "cors": "^2.8.5",
    "dotenv": "^16.4.5",
    "express": "^4.19.2",
    "express-rate-limit": "^7.2.0",
    "jsonwebtoken": "^9.0.2",
    "mongoose": "^8.3.1"
  },
  "devDependencies": {
    "nodemon": "^3.1.0"
  }
}
```

---

### 8.3 `backend/.env`

```env
# ---------- Server ----------
PORT=8000
NODE_ENV=development

# ---------- Database ----------
MONGODB_URI=mongodb://127.0.0.1:27017
DB_NAME=employee_management

# ---------- CORS ----------
CORS_ORIGIN=http://localhost:5173

# ---------- Access Token ----------
# Generate: node -e "console.log(require('crypto').randomBytes(64).toString('hex'))"
ACCESS_TOKEN_SECRET=b7f4c2a9e1d83f560c47a2be91d05e38f6c14a7b2e93d85f01c6a47be2d93f85
ACCESS_TOKEN_EXPIRY=15m

# ---------- Refresh Token ----------
# MUST be different from ACCESS_TOKEN_SECRET
REFRESH_TOKEN_SECRET=9e2c48a7f1b03d65e8a49c27bf310d5e74a82c96b1e5d73f08c2a64be97d31f50
REFRESH_TOKEN_EXPIRY=7d
REFRESH_TOKEN_COOKIE_MAX_AGE=604800000

# ---------- Security ----------
BCRYPT_SALT_ROUNDS=12
```

**`backend/.gitignore`**

```
node_modules/
.env
*.log
dist/
```

> Commit `.env.example` with empty values. **Never** commit `.env`.

---

### 8.4 `backend/src/config/db.js`

```js
import mongoose from 'mongoose';

const connectDB = async () => {
  try {
    const conn = await mongoose.connect(
      `${process.env.MONGODB_URI}/${process.env.DB_NAME}`
    );
    console.log(`✅ MongoDB connected: ${conn.connection.host}`);
  } catch (error) {
    console.error('❌ MongoDB connection failed:', error.message);
    process.exit(1);
  }
};

export default connectDB;
```

---

### 8.5 Utilities

**`backend/src/utils/ApiError.js`**

```js
class ApiError extends Error {
  constructor(statusCode, message = 'Something went wrong', errors = []) {
    super(message);
    this.statusCode = statusCode;
    this.message = message;
    this.errors = errors;
    this.success = false;
    Error.captureStackTrace(this, this.constructor);
  }
}

export default ApiError;
```

**`backend/src/utils/ApiResponse.js`**

```js
class ApiResponse {
  constructor(statusCode, data, message = 'Success') {
    this.statusCode = statusCode;
    this.data = data;
    this.message = message;
    this.success = statusCode < 400;
  }
}

export default ApiResponse;
```

**`backend/src/utils/asyncHandler.js`**

```js
const asyncHandler = (requestHandler) => (req, res, next) => {
  Promise.resolve(requestHandler(req, res, next)).catch(next);
};

export default asyncHandler;
```

**`backend/src/utils/token.util.js`**

```js
import jwt from 'jsonwebtoken';
import crypto, { randomUUID } from 'crypto';
import RefreshToken from '../models/refreshToken.model.js';

/**
 * Hash a refresh token before storing it.
 * We never store the raw token — a DB leak must not expose usable credentials.
 */
export const hashToken = (token) =>
  crypto.createHash('sha256').update(token).digest('hex');

/**
 * ACCESS TOKEN
 * Short-lived, stateless, sent on every request.
 */
export const generateAccessToken = (user) =>
  jwt.sign(
    {
      _id: user._id,
      email: user.email,
      fullName: user.fullName,
      role: user.role,
    },
    process.env.ACCESS_TOKEN_SECRET,
    {
      expiresIn: process.env.ACCESS_TOKEN_EXPIRY,
      issuer: 'employee-management-api',
      audience: 'employee-management-client',
    }
  );

/**
 * REFRESH TOKEN
 * Long-lived, stored (hashed) in DB, rotated on every use.
 *
 * @param {Object}  user
 * @param {String}  family  Reuse the family on rotation; omit on fresh login.
 */
export const generateRefreshToken = (user, family = null) => {
  const jti = randomUUID();
  const tokenFamily = family || randomUUID();

  const token = jwt.sign(
    { _id: user._id, jti, family: tokenFamily },
    process.env.REFRESH_TOKEN_SECRET,
    {
      expiresIn: process.env.REFRESH_TOKEN_EXPIRY,
      issuer: 'employee-management-api',
    }
  );

  return { token, jti, family: tokenFamily };
};

/**
 * Persist the refresh token's hash + metadata.
 */
export const persistRefreshToken = async ({ token, jti, family, user, req }) => {
  const decoded = jwt.decode(token);

  return RefreshToken.create({
    user: user._id,
    tokenHash: hashToken(token),
    jti,
    family,
    expiresAt: new Date(decoded.exp * 1000),
    ipAddress: req.ip,
    userAgent: req.get('user-agent') || 'unknown',
  });
};

/**
 * Issue a fresh access + refresh pair and save the refresh token.
 */
export const issueTokenPair = async (user, req, family = null) => {
  const accessToken = generateAccessToken(user);
  const refresh = generateRefreshToken(user, family);

  await persistRefreshToken({ ...refresh, user, req });

  return { accessToken, refreshToken: refresh.token, jti: refresh.jti };
};

/**
 * Cookie options for the refresh token.
 */
export const refreshCookieOptions = () => ({
  httpOnly: true,
  secure: process.env.NODE_ENV === 'production',
  sameSite: process.env.NODE_ENV === 'production' ? 'strict' : 'lax',
  path: '/api/v1/auth',
  maxAge: Number(process.env.REFRESH_TOKEN_COOKIE_MAX_AGE),
});
```

---

### 8.6 Models

**`backend/src/models/user.model.js`**

```js
import mongoose from 'mongoose';
import bcrypt from 'bcryptjs';

const userSchema = new mongoose.Schema(
  {
    fullName: {
      type: String,
      required: [true, 'Full name is required'],
      trim: true,
      minlength: 3,
    },
    email: {
      type: String,
      required: [true, 'Email is required'],
      unique: true,
      lowercase: true,
      trim: true,
      match: [/^\S+@\S+\.\S+$/, 'Please provide a valid email'],
    },
    password: {
      type: String,
      required: [true, 'Password is required'],
      minlength: [8, 'Password must be at least 8 characters'],
      select: false, // never returned by default
    },
    role: {
      type: String,
      enum: ['admin', 'hr', 'employee'],
      default: 'employee',
    },
    isActive: {
      type: Boolean,
      default: true,
    },
  },
  { timestamps: true }
);

// Hash password before saving
userSchema.pre('save', async function (next) {
  if (!this.isModified('password')) return next();
  this.password = await bcrypt.hash(
    this.password,
    Number(process.env.BCRYPT_SALT_ROUNDS) || 12
  );
  next();
});

userSchema.methods.isPasswordCorrect = async function (plainPassword) {
  return bcrypt.compare(plainPassword, this.password);
};

export default mongoose.model('User', userSchema);
```

**`backend/src/models/refreshToken.model.js`**

```js
import mongoose from 'mongoose';

const refreshTokenSchema = new mongoose.Schema(
  {
    user: {
      type: mongoose.Schema.Types.ObjectId,
      ref: 'User',
      required: true,
      index: true,
    },
    // SHA-256 hash — the raw token is never stored
    tokenHash: {
      type: String,
      required: true,
      unique: true,
      index: true,
    },
    // Unique ID for THIS token — allows single-token revocation
    jti: {
      type: String,
      required: true,
      unique: true,
    },
    // Groups every token descended from one login — enables reuse detection
    family: {
      type: String,
      required: true,
      index: true,
    },
    revoked: {
      type: Boolean,
      default: false,
    },
    revokedAt: Date,
    // jti of the token that replaced this one (audit trail)
    replacedBy: {
      type: String,
      default: null,
    },
    expiresAt: {
      type: Date,
      required: true,
    },
    ipAddress: String,
    userAgent: String,
  },
  { timestamps: true }
);

// TTL index — MongoDB auto-deletes documents once expiresAt passes
refreshTokenSchema.index({ expiresAt: 1 }, { expireAfterSeconds: 0 });

export default mongoose.model('RefreshToken', refreshTokenSchema);
```

**`backend/src/models/employee.model.js`**

```js
import mongoose from 'mongoose';

const employeeSchema = new mongoose.Schema(
  {
    employeeId: {
      type: String,
      required: true,
      unique: true,
      uppercase: true,
      trim: true,
    },
    fullName: {
      type: String,
      required: [true, 'Employee name is required'],
      trim: true,
    },
    email: {
      type: String,
      required: true,
      unique: true,
      lowercase: true,
      trim: true,
    },
    phone: {
      type: String,
      required: true,
      match: [/^[0-9]{10}$/, 'Phone must be 10 digits'],
    },
    department: {
      type: String,
      required: true,
      enum: ['Engineering', 'HR', 'Sales', 'Finance', 'Marketing', 'Operations'],
    },
    designation: {
      type: String,
      required: true,
      trim: true,
    },
    salary: {
      type: Number,
      required: true,
      min: [0, 'Salary cannot be negative'],
    },
    dateOfJoining: {
      type: Date,
      required: true,
      default: Date.now,
    },
    status: {
      type: String,
      enum: ['active', 'on-leave', 'resigned', 'terminated'],
      default: 'active',
    },
    address: {
      street: String,
      city: String,
      state: String,
      pincode: String,
    },
    createdBy: {
      type: mongoose.Schema.Types.ObjectId,
      ref: 'User',
      required: true,
    },
  },
  { timestamps: true }
);

employeeSchema.index({ fullName: 'text', email: 'text', employeeId: 'text' });

export default mongoose.model('Employee', employeeSchema);
```

---

### 8.7 Middlewares

**`backend/src/middlewares/auth.middleware.js`**

```js
import jwt from 'jsonwebtoken';
import User from '../models/user.model.js';
import ApiError from '../utils/ApiError.js';
import asyncHandler from '../utils/asyncHandler.js';

/**
 * Verifies the ACCESS token from the Authorization header.
 * Attaches req.user on success.
 */
export const verifyJWT = asyncHandler(async (req, _res, next) => {
  const header = req.header('Authorization') || '';
  const token = header.startsWith('Bearer ') ? header.slice(7) : null;

  if (!token) {
    throw new ApiError(401, 'Unauthorized — access token missing');
  }

  let decoded;
  try {
    decoded = jwt.verify(token, process.env.ACCESS_TOKEN_SECRET, {
      issuer: 'employee-management-api',
      audience: 'employee-management-client',
    });
  } catch (err) {
    if (err.name === 'TokenExpiredError') {
      // The client interceptor watches for this code to trigger a refresh
      throw new ApiError(401, 'Access token expired');
    }
    throw new ApiError(401, 'Invalid access token');
  }

  const user = await User.findById(decoded._id).select('-password');
  if (!user || !user.isActive) {
    throw new ApiError(401, 'User no longer exists or is deactivated');
  }

  req.user = user;
  next();
});
```

**`backend/src/middlewares/role.middleware.js`**

```js
import ApiError from '../utils/ApiError.js';

/**
 * Usage: router.post('/', verifyJWT, authorizeRoles('admin', 'hr'), handler)
 */
export const authorizeRoles = (...allowedRoles) => (req, _res, next) => {
  if (!req.user) {
    return next(new ApiError(401, 'Authentication required'));
  }
  if (!allowedRoles.includes(req.user.role)) {
    return next(
      new ApiError(403, `Role '${req.user.role}' is not permitted on this route`)
    );
  }
  next();
};
```

**`backend/src/middlewares/error.middleware.js`**

```js
import ApiError from '../utils/ApiError.js';

export const errorHandler = (err, _req, res, _next) => {
  let error = err;

  if (!(error instanceof ApiError)) {
    const statusCode = error.statusCode || (error.name === 'ValidationError' ? 400 : 500);
    error = new ApiError(statusCode, error.message || 'Internal server error');
  }

  // Duplicate key
  if (err.code === 11000) {
    const field = Object.keys(err.keyValue)[0];
    error = new ApiError(409, `${field} already exists`);
  }

  res.status(error.statusCode).json({
    success: false,
    message: error.message,
    errors: error.errors,
    ...(process.env.NODE_ENV === 'development' && { stack: err.stack }),
  });
};

export const notFound = (req, _res, next) => {
  next(new ApiError(404, `Route ${req.originalUrl} not found`));
};
```

---

### 8.8 Auth Controller — the heart of the system

**`backend/src/controllers/auth.controller.js`**

```js
import jwt from 'jsonwebtoken';
import User from '../models/user.model.js';
import RefreshToken from '../models/refreshToken.model.js';
import ApiError from '../utils/ApiError.js';
import ApiResponse from '../utils/ApiResponse.js';
import asyncHandler from '../utils/asyncHandler.js';
import {
  hashToken,
  issueTokenPair,
  refreshCookieOptions,
} from '../utils/token.util.js';

/* ------------------------------------------------------------------
   REGISTER
------------------------------------------------------------------ */
export const register = asyncHandler(async (req, res) => {
  const { fullName, email, password, role } = req.body;

  if (!fullName || !email || !password) {
    throw new ApiError(400, 'fullName, email and password are required');
  }

  if (await User.findOne({ email: email.toLowerCase() })) {
    throw new ApiError(409, 'A user with this email already exists');
  }

  const user = await User.create({
    fullName,
    email,
    password,
    role: role || 'employee',
  });

  const created = await User.findById(user._id);

  return res
    .status(201)
    .json(new ApiResponse(201, created, 'User registered successfully'));
});

/* ------------------------------------------------------------------
   LOGIN  →  issues a NEW token family
------------------------------------------------------------------ */
export const login = asyncHandler(async (req, res) => {
  const { email, password } = req.body;

  if (!email || !password) {
    throw new ApiError(400, 'Email and password are required');
  }

  const user = await User.findOne({ email: email.toLowerCase() }).select('+password');

  // Same message for both cases — do not leak which emails exist
  if (!user || !(await user.isPasswordCorrect(password))) {
    throw new ApiError(401, 'Invalid credentials');
  }

  if (!user.isActive) {
    throw new ApiError(403, 'Account is deactivated. Contact your administrator.');
  }

  // family = null → generateRefreshToken creates a brand-new family
  const { accessToken, refreshToken } = await issueTokenPair(user, req, null);

  const safeUser = {
    _id: user._id,
    fullName: user.fullName,
    email: user.email,
    role: user.role,
  };

  return res
    .status(200)
    .cookie('refreshToken', refreshToken, refreshCookieOptions())
    .json(
      new ApiResponse(200, { user: safeUser, accessToken }, 'Login successful')
    );
});

/* ------------------------------------------------------------------
   REFRESH  →  ROTATION + REUSE DETECTION
------------------------------------------------------------------ */
export const refreshAccessToken = asyncHandler(async (req, res) => {
  const incoming = req.cookies?.refreshToken || req.body?.refreshToken;

  if (!incoming) {
    throw new ApiError(401, 'Refresh token missing');
  }

  // --- Step 1: verify signature & expiry ---
  let decoded;
  try {
    decoded = jwt.verify(incoming, process.env.REFRESH_TOKEN_SECRET);
  } catch {
    res.clearCookie('refreshToken', refreshCookieOptions());
    throw new ApiError(401, 'Invalid or expired refresh token');
  }

  // --- Step 2: look up the stored hash ---
  const stored = await RefreshToken.findOne({ tokenHash: hashToken(incoming) });

  if (!stored) {
    res.clearCookie('refreshToken', refreshCookieOptions());
    throw new ApiError(401, 'Refresh token not recognised');
  }

  /* --- Step 3: 🚨 REUSE DETECTION 🚨 -------------------------------
     A revoked token was presented. Since rotation guarantees a token
     is redeemed exactly once, this means two parties hold tokens from
     this family — one of them is an attacker. Burn the whole family. */
  if (stored.revoked) {
    await RefreshToken.updateMany(
      { family: stored.family, revoked: false },
      { $set: { revoked: true, revokedAt: new Date() } }
    );

    console.warn(
      `🚨 REFRESH TOKEN REUSE DETECTED — user=${stored.user} family=${stored.family} ip=${req.ip}`
    );

    res.clearCookie('refreshToken', refreshCookieOptions());
    throw new ApiError(
      401,
      'Security alert: token reuse detected. All sessions have been revoked. Please log in again.'
    );
  }

  // --- Step 4: validate the user still exists ---
  const user = await User.findById(decoded._id);
  if (!user || !user.isActive) {
    await RefreshToken.updateMany(
      { family: stored.family },
      { $set: { revoked: true, revokedAt: new Date() } }
    );
    res.clearCookie('refreshToken', refreshCookieOptions());
    throw new ApiError(401, 'User no longer active');
  }

  // --- Step 5: ROTATE — issue a new pair in the SAME family ---
  const { accessToken, refreshToken, jti } = await issueTokenPair(
    user,
    req,
    stored.family
  );

  // --- Step 6: retire the old token, leaving an audit trail ---
  stored.revoked = true;
  stored.revokedAt = new Date();
  stored.replacedBy = jti;
  await stored.save();

  return res
    .status(200)
    .cookie('refreshToken', refreshToken, refreshCookieOptions())
    .json(new ApiResponse(200, { accessToken }, 'Access token refreshed'));
});

/* ------------------------------------------------------------------
   LOGOUT  →  revoke only this family (other devices stay logged in)
------------------------------------------------------------------ */
export const logout = asyncHandler(async (req, res) => {
  const incoming = req.cookies?.refreshToken;

  if (incoming) {
    const stored = await RefreshToken.findOne({ tokenHash: hashToken(incoming) });
    if (stored) {
      await RefreshToken.updateMany(
        { family: stored.family },
        { $set: { revoked: true, revokedAt: new Date() } }
      );
    }
  }

  return res
    .status(200)
    .clearCookie('refreshToken', refreshCookieOptions())
    .json(new ApiResponse(200, {}, 'Logged out successfully'));
});

/* ------------------------------------------------------------------
   LOGOUT ALL DEVICES
------------------------------------------------------------------ */
export const logoutAllDevices = asyncHandler(async (req, res) => {
  await RefreshToken.updateMany(
    { user: req.user._id, revoked: false },
    { $set: { revoked: true, revokedAt: new Date() } }
  );

  return res
    .status(200)
    .clearCookie('refreshToken', refreshCookieOptions())
    .json(new ApiResponse(200, {}, 'Logged out from all devices'));
});

/* ------------------------------------------------------------------
   ACTIVE SESSIONS
------------------------------------------------------------------ */
export const getActiveSessions = asyncHandler(async (req, res) => {
  const sessions = await RefreshToken.find({
    user: req.user._id,
    revoked: false,
    expiresAt: { $gt: new Date() },
  }).select('family ipAddress userAgent createdAt expiresAt');

  return res
    .status(200)
    .json(new ApiResponse(200, sessions, 'Active sessions fetched'));
});

/* ------------------------------------------------------------------
   CURRENT USER
------------------------------------------------------------------ */
export const getCurrentUser = asyncHandler(async (req, res) =>
  res.status(200).json(new ApiResponse(200, req.user, 'Current user fetched'))
);
```

---

### 8.9 Employee Controller

**`backend/src/controllers/employee.controller.js`**

```js
import Employee from '../models/employee.model.js';
import ApiError from '../utils/ApiError.js';
import ApiResponse from '../utils/ApiResponse.js';
import asyncHandler from '../utils/asyncHandler.js';

/* CREATE */
export const createEmployee = asyncHandler(async (req, res) => {
  const {
    employeeId, fullName, email, phone,
    department, designation, salary, dateOfJoining, address,
  } = req.body;

  if (!employeeId || !fullName || !email || !phone || !department || !designation || salary == null) {
    throw new ApiError(400, 'All required fields must be provided');
  }

  const exists = await Employee.findOne({
    $or: [{ employeeId: employeeId.toUpperCase() }, { email: email.toLowerCase() }],
  });
  if (exists) {
    throw new ApiError(409, 'Employee with this ID or email already exists');
  }

  const employee = await Employee.create({
    employeeId, fullName, email, phone, department,
    designation, salary, dateOfJoining, address,
    createdBy: req.user._id,
  });

  return res
    .status(201)
    .json(new ApiResponse(201, employee, 'Employee created successfully'));
});

/* READ ALL — paginated, searchable, filterable */
export const getAllEmployees = asyncHandler(async (req, res) => {
  const page  = Math.max(1, parseInt(req.query.page)  || 1);
  const limit = Math.min(100, parseInt(req.query.limit) || 10);
  const { search, department, status, sortBy = '-createdAt' } = req.query;

  const filter = {};
  if (department) filter.department = department;
  if (status) filter.status = status;
  if (search) {
    filter.$or = [
      { fullName:   { $regex: search, $options: 'i' } },
      { email:      { $regex: search, $options: 'i' } },
      { employeeId: { $regex: search, $options: 'i' } },
    ];
  }

  const [employees, total] = await Promise.all([
    Employee.find(filter)
      .populate('createdBy', 'fullName email')
      .sort(sortBy)
      .skip((page - 1) * limit)
      .limit(limit),
    Employee.countDocuments(filter),
  ]);

  return res.status(200).json(
    new ApiResponse(200, {
      employees,
      pagination: {
        page, limit, total,
        totalPages: Math.ceil(total / limit),
        hasNext: page * limit < total,
        hasPrev: page > 1,
      },
    }, 'Employees fetched successfully')
  );
});

/* READ ONE */
export const getEmployeeById = asyncHandler(async (req, res) => {
  const employee = await Employee.findById(req.params.id)
    .populate('createdBy', 'fullName email');

  if (!employee) throw new ApiError(404, 'Employee not found');

  return res
    .status(200)
    .json(new ApiResponse(200, employee, 'Employee fetched successfully'));
});

/* UPDATE */
export const updateEmployee = asyncHandler(async (req, res) => {
  const allowed = [
    'fullName', 'phone', 'department', 'designation',
    'salary', 'status', 'address',
  ];
  const updates = {};
  for (const key of allowed) {
    if (req.body[key] !== undefined) updates[key] = req.body[key];
  }

  if (!Object.keys(updates).length) {
    throw new ApiError(400, 'No valid fields provided for update');
  }

  const employee = await Employee.findByIdAndUpdate(
    req.params.id,
    { $set: updates },
    { new: true, runValidators: true }
  );

  if (!employee) throw new ApiError(404, 'Employee not found');

  return res
    .status(200)
    .json(new ApiResponse(200, employee, 'Employee updated successfully'));
});

/* DELETE */
export const deleteEmployee = asyncHandler(async (req, res) => {
  const employee = await Employee.findByIdAndDelete(req.params.id);
  if (!employee) throw new ApiError(404, 'Employee not found');

  return res
    .status(200)
    .json(new ApiResponse(200, { _id: employee._id }, 'Employee deleted successfully'));
});

/* STATS — aggregation */
export const getEmployeeStats = asyncHandler(async (_req, res) => {
  const stats = await Employee.aggregate([
    {
      $group: {
        _id: '$department',
        count: { $sum: 1 },
        avgSalary: { $avg: '$salary' },
        totalSalary: { $sum: '$salary' },
      },
    },
    { $sort: { count: -1 } },
  ]);

  const total = await Employee.countDocuments();

  return res
    .status(200)
    .json(new ApiResponse(200, { total, byDepartment: stats }, 'Stats fetched'));
});
```

---

### 8.10 Routes

**`backend/src/routes/auth.routes.js`**

```js
import { Router } from 'express';
import rateLimit from 'express-rate-limit';
import {
  register,
  login,
  refreshAccessToken,
  logout,
  logoutAllDevices,
  getActiveSessions,
  getCurrentUser,
} from '../controllers/auth.controller.js';
import { verifyJWT } from '../middlewares/auth.middleware.js';

const router = Router();

// Brute-force protection on credential endpoints
const authLimiter = rateLimit({
  windowMs: 15 * 60 * 1000,
  max: 10,
  message: { success: false, message: 'Too many attempts. Try again in 15 minutes.' },
  standardHeaders: true,
  legacyHeaders: false,
});

// ---------- Public ----------
router.post('/register', authLimiter, register);
router.post('/login',    authLimiter, login);
router.post('/refresh',  refreshAccessToken);

// ---------- Protected ----------
router.post('/logout',          logout);
router.post('/logout-all',      verifyJWT, logoutAllDevices);
router.get('/sessions',         verifyJWT, getActiveSessions);
router.get('/me',               verifyJWT, getCurrentUser);

export default router;
```

**`backend/src/routes/employee.routes.js`**

```js
import { Router } from 'express';
import {
  createEmployee,
  getAllEmployees,
  getEmployeeById,
  updateEmployee,
  deleteEmployee,
  getEmployeeStats,
} from '../controllers/employee.controller.js';
import { verifyJWT } from '../middlewares/auth.middleware.js';
import { authorizeRoles } from '../middlewares/role.middleware.js';

const router = Router();

// Every employee route requires a valid ACCESS token
router.use(verifyJWT);

router.route('/')
  .get(getAllEmployees)
  .post(authorizeRoles('admin', 'hr'), createEmployee);

router.get('/stats', authorizeRoles('admin', 'hr'), getEmployeeStats);

router.route('/:id')
  .get(getEmployeeById)
  .patch(authorizeRoles('admin', 'hr'), updateEmployee)
  .delete(authorizeRoles('admin'), deleteEmployee);

export default router;
```

---

### 8.11 App & Server

**`backend/src/app.js`**

```js
import express from 'express';
import cors from 'cors';
import cookieParser from 'cookie-parser';

import authRoutes from './routes/auth.routes.js';
import employeeRoutes from './routes/employee.routes.js';
import { errorHandler, notFound } from './middlewares/error.middleware.js';

const app = express();

app.use(
  cors({
    origin: process.env.CORS_ORIGIN,
    credentials: true, // REQUIRED so the browser sends the refresh cookie
  })
);

app.use(express.json({ limit: '16kb' }));
app.use(express.urlencoded({ extended: true, limit: '16kb' }));
app.use(cookieParser());
app.set('trust proxy', 1); // correct req.ip behind a reverse proxy

app.get('/api/v1/health', (_req, res) =>
  res.status(200).json({ success: true, message: 'Server is healthy' })
);

app.use('/api/v1/auth', authRoutes);
app.use('/api/v1/employees', employeeRoutes);

app.use(notFound);
app.use(errorHandler);

export default app;
```

**`backend/src/server.js`**

```js
import dotenv from 'dotenv';
dotenv.config();

import app from './app.js';
import connectDB from './config/db.js';

const PORT = process.env.PORT || 8000;

connectDB()
  .then(() => {
    app.listen(PORT, () =>
      console.log(`🚀 Server running on http://localhost:${PORT}`)
    );
  })
  .catch((err) => {
    console.error('Failed to start server:', err);
    process.exit(1);
  });
```

---

### 8.12 Frontend — React

```bash
cd employee-management
npm create vite@latest frontend -- --template react
cd frontend
npm install axios react-router-dom
```

**`frontend/src/api/axios.js`** — the interceptor that makes refresh invisible to the user

```js
import axios from 'axios';

const BASE_URL = 'http://localhost:8000/api/v1';

const api = axios.create({
  baseURL: BASE_URL,
  withCredentials: true, // sends the httpOnly refresh cookie
  headers: { 'Content-Type': 'application/json' },
});

/* Access token lives in memory only — never localStorage.
   localStorage is readable by any injected script (XSS). */
let accessToken = null;
export const setAccessToken = (t) => { accessToken = t; };
export const getAccessToken = () => accessToken;

/* ---- Request interceptor: attach the access token ---- */
api.interceptors.request.use(
  (config) => {
    if (accessToken) {
      config.headers.Authorization = `Bearer ${accessToken}`;
    }
    return config;
  },
  (error) => Promise.reject(error)
);

/* ---- Refresh mutex ----------------------------------------------
   If 5 requests fail with 401 at once, we must NOT fire 5 refresh
   calls — with rotation, the first would succeed and the other four
   would present an already-revoked token, triggering false reuse
   detection and logging the user out. So we queue them. */
let isRefreshing = false;
let queue = [];

const processQueue = (error, token = null) => {
  queue.forEach(({ resolve, reject }) => (error ? reject(error) : resolve(token)));
  queue = [];
};

/* ---- Response interceptor: auto-refresh on 401 ---- */
api.interceptors.response.use(
  (response) => response,
  async (error) => {
    const original = error.config;

    if (error.response?.status !== 401 || original._retry) {
      return Promise.reject(error);
    }

    // Never try to refresh the refresh call itself
    if (original.url?.includes('/auth/refresh')) {
      setAccessToken(null);
      window.location.href = '/login';
      return Promise.reject(error);
    }

    if (isRefreshing) {
      // Wait for the in-flight refresh, then retry
      return new Promise((resolve, reject) => {
        queue.push({ resolve, reject });
      })
        .then((token) => {
          original.headers.Authorization = `Bearer ${token}`;
          return api(original);
        })
        .catch((err) => Promise.reject(err));
    }

    original._retry = true;
    isRefreshing = true;

    try {
      const { data } = await axios.post(
        `${BASE_URL}/auth/refresh`,
        {},
        { withCredentials: true }
      );

      const newToken = data.data.accessToken;
      setAccessToken(newToken);
      processQueue(null, newToken);

      original.headers.Authorization = `Bearer ${newToken}`;
      return api(original);
    } catch (refreshError) {
      processQueue(refreshError, null);
      setAccessToken(null);
      window.location.href = '/login';
      return Promise.reject(refreshError);
    } finally {
      isRefreshing = false;
    }
  }
);

export default api;
```

**`frontend/src/context/AuthContext.jsx`**

```jsx
import { createContext, useContext, useState, useEffect, useCallback } from 'react';
import api, { setAccessToken } from '../api/axios';

const AuthContext = createContext(null);

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);

  /* On mount, try a silent refresh.
     If the httpOnly cookie is still valid, the user stays logged in
     across page reloads — even though the access token was lost. */
  const bootstrap = useCallback(async () => {
    try {
      const { data } = await api.post('/auth/refresh');
      setAccessToken(data.data.accessToken);
      const me = await api.get('/auth/me');
      setUser(me.data.data);
    } catch {
      setUser(null);
      setAccessToken(null);
    } finally {
      setLoading(false);
    }
  }, []);

  useEffect(() => { bootstrap(); }, [bootstrap]);

  const login = async (email, password) => {
    const { data } = await api.post('/auth/login', { email, password });
    setAccessToken(data.data.accessToken);
    setUser(data.data.user);
    return data.data.user;
  };

  const logout = async () => {
    try { await api.post('/auth/logout'); } catch { /* ignore */ }
    setAccessToken(null);
    setUser(null);
  };

  return (
    <AuthContext.Provider value={{ user, loading, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = () => {
  const ctx = useContext(AuthContext);
  if (!ctx) throw new Error('useAuth must be used inside AuthProvider');
  return ctx;
};
```

**`frontend/src/components/ProtectedRoute.jsx`**

```jsx
import { Navigate, useLocation } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';

const ProtectedRoute = ({ children, allowedRoles }) => {
  const { user, loading } = useAuth();
  const location = useLocation();

  if (loading) return <div style={{ padding: 40 }}>Loading…</div>;

  if (!user) {
    return <Navigate to="/login" state={{ from: location }} replace />;
  }

  if (allowedRoles && !allowedRoles.includes(user.role)) {
    return <Navigate to="/unauthorized" replace />;
  }

  return children;
};

export default ProtectedRoute;
```

**`frontend/src/pages/Login.jsx`**

```jsx
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';

export default function Login() {
  const [form, setForm] = useState({ email: '', password: '' });
  const [error, setError] = useState('');
  const [busy, setBusy] = useState(false);
  const { login } = useAuth();
  const navigate = useNavigate();

  const handleChange = (e) =>
    setForm({ ...form, [e.target.name]: e.target.value });

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError('');
    setBusy(true);
    try {
      await login(form.email, form.password);
      navigate('/dashboard', { replace: true });
    } catch (err) {
      setError(err.response?.data?.message || 'Login failed');
    } finally {
      setBusy(false);
    }
  };

  return (
    <div style={{ maxWidth: 380, margin: '80px auto', fontFamily: 'system-ui' }}>
      <h2>Employee Management — Sign in</h2>
      {error && <p style={{ color: '#c0392b' }}>{error}</p>}
      <form onSubmit={handleSubmit}>
        <input
          name="email" type="email" value={form.email} onChange={handleChange}
          placeholder="Email" required
          style={{ width: '100%', padding: 10, marginBottom: 10 }}
        />
        <input
          name="password" type="password" value={form.password} onChange={handleChange}
          placeholder="Password" required
          style={{ width: '100%', padding: 10, marginBottom: 14 }}
        />
        <button type="submit" disabled={busy} style={{ width: '100%', padding: 10 }}>
          {busy ? 'Signing in…' : 'Sign in'}
        </button>
      </form>
    </div>
  );
}
```

**`frontend/src/pages/Dashboard.jsx`**

```jsx
import { useEffect, useState } from 'react';
import api from '../api/axios';
import { useAuth } from '../context/AuthContext';

export default function Dashboard() {
  const { user, logout } = useAuth();
  const [employees, setEmployees] = useState([]);
  const [search, setSearch] = useState('');
  const [page, setPage] = useState(1);
  const [pagination, setPagination] = useState({});
  const [loading, setLoading] = useState(true);

  const fetchEmployees = async () => {
    setLoading(true);
    try {
      const { data } = await api.get('/employees', {
        params: { page, limit: 10, search },
      });
      setEmployees(data.data.employees);
      setPagination(data.data.pagination);
    } catch (err) {
      console.error(err);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    const t = setTimeout(fetchEmployees, 300); // debounce search
    return () => clearTimeout(t);
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [page, search]);

  const handleDelete = async (id) => {
    if (!window.confirm('Delete this employee?')) return;
    await api.delete(`/employees/${id}`);
    fetchEmployees();
  };

  return (
    <div style={{ padding: 24, fontFamily: 'system-ui' }}>
      <header style={{ display: 'flex', justifyContent: 'space-between' }}>
        <h2>Employees</h2>
        <div>
          <span style={{ marginRight: 12 }}>
            {user?.fullName} ({user?.role})
          </span>
          <button onClick={logout}>Logout</button>
        </div>
      </header>

      <input
        value={search}
        onChange={(e) => { setPage(1); setSearch(e.target.value); }}
        placeholder="Search by name, email or ID…"
        style={{ padding: 8, width: 320, margin: '16px 0' }}
      />

      {loading ? <p>Loading…</p> : (
        <table width="100%" cellPadding="8" style={{ borderCollapse: 'collapse' }}>
          <thead>
            <tr style={{ background: '#f4f4f4', textAlign: 'left' }}>
              <th>ID</th><th>Name</th><th>Department</th>
              <th>Designation</th><th>Salary</th><th>Status</th>
              {user?.role === 'admin' && <th>Actions</th>}
            </tr>
          </thead>
          <tbody>
            {employees.map((e) => (
              <tr key={e._id} style={{ borderBottom: '1px solid #eee' }}>
                <td>{e.employeeId}</td>
                <td>{e.fullName}</td>
                <td>{e.department}</td>
                <td>{e.designation}</td>
                <td>₹{e.salary.toLocaleString('en-IN')}</td>
                <td>{e.status}</td>
                {user?.role === 'admin' && (
                  <td><button onClick={() => handleDelete(e._id)}>Delete</button></td>
                )}
              </tr>
            ))}
          </tbody>
        </table>
      )}

      <div style={{ marginTop: 16 }}>
        <button disabled={!pagination.hasPrev} onClick={() => setPage(p => p - 1)}>
          Previous
        </button>
        <span style={{ margin: '0 12px' }}>
          Page {pagination.page} of {pagination.totalPages}
        </span>
        <button disabled={!pagination.hasNext} onClick={() => setPage(p => p + 1)}>
          Next
        </button>
      </div>
    </div>
  );
}
```

**`frontend/src/App.jsx`**

```jsx
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import { AuthProvider } from './context/AuthContext';
import ProtectedRoute from './components/ProtectedRoute';
import Login from './pages/Login';
import Register from './pages/Register';
import Dashboard from './pages/Dashboard';

export default function App() {
  return (
    <BrowserRouter>
      <AuthProvider>
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route
            path="/dashboard"
            element={
              <ProtectedRoute>
                <Dashboard />
              </ProtectedRoute>
            }
          />
          <Route path="/unauthorized" element={<h2>403 — Not authorized</h2>} />
          <Route path="*" element={<Navigate to="/dashboard" replace />} />
        </Routes>
      </AuthProvider>
    </BrowserRouter>
  );
}
```

---

## 9. Testing the API

### Register

```bash
curl -X POST http://localhost:8000/api/v1/auth/register \
  -H "Content-Type: application/json" \
  -d '{"fullName":"Ravi Patel","email":"ravi@company.com","password":"Str0ngPass!23","role":"admin"}'
```

### Login (save the cookie)

```bash
curl -X POST http://localhost:8000/api/v1/auth/login \
  -H "Content-Type: application/json" \
  -c cookies.txt \
  -d '{"email":"ravi@company.com","password":"Str0ngPass!23"}'
```

Response:

```json
{
  "statusCode": 200,
  "data": {
    "user": { "_id": "...", "fullName": "Ravi Patel", "role": "admin" },
    "accessToken": "eyJhbGciOiJIUzI1NiIs..."
  },
  "message": "Login successful",
  "success": true
}
```

### Call a protected route

```bash
curl http://localhost:8000/api/v1/employees \
  -H "Authorization: Bearer <ACCESS_TOKEN>"
```

### Refresh (rotation happens here)

```bash
curl -X POST http://localhost:8000/api/v1/auth/refresh \
  -b cookies.txt -c cookies.txt
```

### Prove reuse detection works

```bash
# 1. Save the current refresh token value
cp cookies.txt old-cookies.txt

# 2. Refresh once — this rotates the token
curl -X POST http://localhost:8000/api/v1/auth/refresh -b cookies.txt -c cookies.txt

# 3. Now replay the OLD token
curl -X POST http://localhost:8000/api/v1/auth/refresh -b old-cookies.txt
```

Expected:

```json
{
  "success": false,
  "message": "Security alert: token reuse detected. All sessions have been revoked. Please log in again."
}
```

And the server logs:

```
🚨 REFRESH TOKEN REUSE DETECTED — user=65f1... family=d4b8... ip=::1
```

---

## 10. Security Checklist

| # | Practice | Why |
|---|---|---|
| 1 | Separate secrets for access and refresh tokens | Prevents cross-replay between endpoints |
| 2 | Secrets ≥ 64 random bytes, from `.env`, never committed | Brute-forcing the signature becomes infeasible |
| 3 | Access token 15 min or less | Limits damage from a leaked access token |
| 4 | Access token in **memory**, never `localStorage` | `localStorage` is readable by any XSS payload |
| 5 | Refresh token in `httpOnly` + `Secure` + `SameSite` cookie | JS cannot read it; CSRF is blocked |
| 6 | Store **hashed** refresh tokens | A DB dump yields nothing usable |
| 7 | Rotate on every refresh | One-time use; enables detection |
| 8 | Reuse detection → revoke the whole family | Automatic remediation of a theft |
| 9 | TTL index on `expiresAt` | Collection cleans itself |
| 10 | Rate-limit `/login` and `/register` | Blocks credential stuffing |
| 11 | Identical error for wrong email and wrong password | Prevents user enumeration |
| 12 | bcrypt cost factor 12+ | Slows offline password cracking |
| 13 | Never put secrets in the JWT payload | Payload is Base64, not encrypted |
| 14 | `credentials: true` on both CORS and axios | Otherwise the cookie is silently dropped |
| 15 | Validate the user still exists on every refresh | Deactivated accounts lose access immediately |
| 16 | Refresh mutex on the client | Prevents parallel refreshes causing false reuse alerts |
| 17 | HTTPS in production, always | Cookies and tokens must never cross plaintext |
| 18 | Log every reuse-detection event and alert the user | Turns detection into an actionable signal |

---

## Quick Reference

```
┌─────────────────────────────────────────────────────────────┐
│  LOGIN                                                       │
│    → Access Token  (15m, memory)                             │
│    → Refresh Token (7d, httpOnly cookie, new family)         │
├─────────────────────────────────────────────────────────────┤
│  EVERY API CALL                                              │
│    Authorization: Bearer <access token>                      │
├─────────────────────────────────────────────────────────────┤
│  ON 401                                                      │
│    → POST /auth/refresh (cookie sent automatically)          │
│    → Old refresh token revoked, new one issued (same family) │
│    → Retry original request with new access token            │
├─────────────────────────────────────────────────────────────┤
│  REVOKED TOKEN REPLAYED                                      │
│    → 🚨 Revoke entire family → force re-login                │
├─────────────────────────────────────────────────────────────┤
│  LOGOUT                                                      │
│    → Revoke this family only; other devices unaffected       │
└─────────────────────────────────────────────────────────────┘
```

---

*Built with the MERN stack: MongoDB · Express · React · Node.js*
