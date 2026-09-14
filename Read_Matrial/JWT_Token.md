# JWT (JSON Web Token) — Complete Guide

---

## 1. What is JWT?

**JWT (JSON Web Token)** is an open standard (**RFC 7519**) that defines a compact, self-contained, and URL-safe way to transmit information between two parties (usually a client and a server) as a **JSON object**. This information is **digitally signed**, so it can be verified and trusted.

A JWT is essentially a string that looks like this:

```
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjEyMyIsIm5hbWUiOiJSYWh1bCIsImlhdCI6MTcxNjAwMDAwMH0.4Rk3nD9x2f8pQwYtZs7L1hV6mJcXAeBoT3gN0kIySdU
```

It is made of **three parts separated by dots (`.`)**:

```
HEADER.PAYLOAD.SIGNATURE
```

Key characteristics:
- **Self-contained**: All the required user info is inside the token itself (no need to query the database every time).
- **Stateless**: The server does not need to store session data.
- **Compact**: Small enough to be sent via URL, POST parameter, or inside an HTTP header.
- **Signed, not necessarily encrypted**: Anyone can read the payload (it's just Base64), but only the server (holding the secret/private key) can verify it was not tampered with.

---

## 2. Why Do We Need JWT?

Before JWT, most web apps used **session-based authentication**:
- Server creates a session and stores it in memory/DB/Redis.
- Server sends a `session_id` to the client via a cookie.
- Every request, the server looks up the session in storage to check if the user is authenticated.

**Problems with session-based auth:**
1. Server has to store session state → doesn't scale well horizontally (needs shared session store like Redis).
2. Difficult to use across multiple domains / mobile apps / microservices.
3. Every request requires a DB/cache lookup.

**JWT solves these problems because:**
1. **Stateless authentication** — server doesn't need to store anything; it just verifies the signature.
2. **Scalable** — works great with microservices and distributed systems (any service with the secret key can verify the token).
3. **Cross-domain / Cross-platform** — works well with mobile apps, SPAs (React, Angular), and third-party APIs.
4. **Self-contained data** — you can embed user id, role, permissions directly in the token.

---

## 3. When To Use JWT?

Use JWT when:
- Building **REST APIs** that need stateless authentication.
- Building **Single Page Applications (React, Angular, Vue)** that talk to a backend API.
- Building **microservices** where multiple services need to verify a user's identity without a shared session store.
- You need **cross-domain authentication** (e.g., API used by web + mobile + third-party clients).
- You want to implement **role-based access control (RBAC)** — embed roles/permissions in the token.

Avoid / be careful when:
- You need to **instantly revoke** a token (JWTs are valid until expiry unless you build a blacklist mechanism).
- Storing **very sensitive data** in the payload (payload is only Base64 encoded, NOT encrypted — anyone can decode and read it).
- Building simple traditional server-rendered apps where cookie-based sessions are simpler and sufficient.

---

## 4. How To Use JWT (Conceptual Flow)

```
1. User logs in with email/password
2. Server validates credentials
3. Server creates a JWT (signs it with a secret key) and sends it to the client
4. Client stores the JWT (localStorage / httpOnly cookie / memory)
5. Client sends the JWT in the Authorization header on every subsequent request:
      Authorization: Bearer <token>
6. Server verifies the token's signature & expiry on each request
7. If valid → request proceeds; If invalid/expired → 401 Unauthorized
```

---

## 5. Benefits of Using JWT

| Benefit | Explanation |
|---|---|
| **Stateless** | No server-side session storage needed |
| **Scalable** | Works easily across multiple servers/microservices |
| **Cross-platform** | Same token logic works for web, mobile, third-party APIs |
| **Self-contained** | Carries user info & claims, reducing DB calls |
| **Standardized** | RFC 7519, supported by almost every language/framework |
| **Secure (when done right)** | Signature ensures data integrity — token can't be tampered with |
| **Flexible expiry control** | You control how long a token stays valid |

**Drawbacks to keep in mind:**
- Cannot be easily revoked before expiry (needs extra logic like blacklist/DB check).
- Payload is readable by anyone (never store passwords/secrets inside it).
- If the secret key leaks, attackers can forge tokens.
- Larger than a simple session ID (slightly more data sent per request).

---

## 6. Types of JWT Tokens

### 6.1 Access Token
- **Purpose**: Used to access protected resources/APIs.
- **Lifespan**: Short-lived (typically **15 minutes to 1 hour**).
- **Where sent**: In the `Authorization: Bearer <token>` header on every API request.
- **Why short-lived**: If stolen, the damage window is small.

### 6.2 Refresh Token
- **Purpose**: Used only to generate a **new Access Token** when the old one expires — user doesn't have to log in again.
- **Lifespan**: Long-lived (typically **7 days to 30 days**, sometimes longer).
- **Where stored**: Usually in an **httpOnly, Secure cookie** (never in localStorage, to reduce XSS risk) or securely in DB.
- **Where sent**: Only to a dedicated `/refresh-token` endpoint, NOT sent with every API call.
- **Important**: Refresh tokens are typically stored in the database (or Redis) so they can be **revoked/invalidated** (e.g., on logout).

### 6.3 Token Rotation
- **What it is**: A security technique where **every time a refresh token is used, it is invalidated and a brand-new refresh token is issued** along with the new access token.
- **Why**: Prevents "replay attacks" — if an old refresh token is reused (e.g., stolen and used by attacker after the real user already rotated it), the server detects reuse and can invalidate **all** tokens for that user (forcing re-login everywhere).
- **Flow**:
  1. Client sends Refresh Token → Server verifies it.
  2. Server issues a **new Access Token + new Refresh Token**.
  3. Old Refresh Token is immediately marked invalid/removed from DB.
  4. If someone tries to reuse the old (now invalid) refresh token → server flags it as a potential theft and can revoke the entire token family.

### 6.4 Other Common Token Types

| Token Type | Purpose |
|---|---|
| **ID Token** (used in OAuth2/OpenID Connect) | Contains identity info about the authenticated user (used by Google/Facebook login, etc.) — not for API authorization, just to identify "who is this user" |
| **Email Verification Token** | Short-lived JWT sent via email link to verify user's email address |
| **Password Reset Token** | Short-lived JWT (usually 10–15 min) used in "forgot password" flow |
| **CSRF Token** (not JWT, but related) | Used alongside cookie-based JWT auth to prevent Cross-Site Request Forgery |
| **API Key / Service Token** | Long-lived token used for server-to-server (machine-to-machine) communication |

---

## 7. When To Use Which Token — Detailed Comparison

| Scenario | Token To Use | Reason |
|---|---|---|
| User calling a protected API (`GET /profile`) | **Access Token** | Short-lived, sent every request |
| Access token expired, user still wants to stay logged in | **Refresh Token** | Used only at `/refresh` endpoint to get new access token |
| High-security apps (banking, fintech) | **Access Token + Refresh Token + Rotation** | Detects token theft/replay attacks |
| Verifying user's email after signup | **Email Verification Token** (JWT with short expiry, e.g., 1 hour) | One-time-use, purpose-specific |
| "Forgot Password" flow | **Password Reset Token** (JWT, 10–15 min expiry) | Very short-lived for security |
| Server-to-server communication (e.g., microservice A calling microservice B) | **Service/API Token** | Long-lived, scoped permissions, not tied to a human session |
| Social login (Google/Facebook) | **ID Token** | Identifies the user; exchanged for your own app's Access + Refresh token afterward |
| Logging out a user | Invalidate stored **Refresh Token** in DB | Access token will simply expire naturally in a few minutes |

**General rule of thumb:**
- **Access Token** → used constantly, kept short-lived, never stored long-term.
- **Refresh Token** → used rarely (only to renew), stored securely (httpOnly cookie / DB), long-lived.
- **Rotation** → add this when your app has higher security requirements (detect stolen refresh tokens).

---

## 8. JWT Token Structure (In Detail)

A JWT always has 3 parts:

```
HEADER . PAYLOAD . SIGNATURE
```

### 8.1 Header
Contains metadata about the token — the type of token and signing algorithm.

```json
{
  "alg": "HS256",
  "typ": "JWT"
}
```
This JSON is then **Base64Url encoded** to form the first part of the token.

### 8.2 Payload (Claims)
Contains the actual data ("claims") — user info, permissions, expiry, etc.

There are 3 categories of claims:
- **Registered claims** (standard, recommended): `iss` (issuer), `exp` (expiry time), `sub` (subject/user id), `iat` (issued at), `aud` (audience)
- **Public claims**: custom claims agreed upon by parties (e.g., `role`, `email`)
- **Private claims**: custom claims specific to your app (e.g., `cartId`, `shopId`)

Example payload for an **Access Token**:
```json
{
  "id": "64f1a2b3c9d4e5f6a7b8c9d0",
  "name": "Rahul Sharma",
  "role": "admin",
  "iat": 1716000000,
  "exp": 1716000900
}
```

Example payload for a **Refresh Token** (kept minimal — only what's needed to identify the user):
```json
{
  "id": "64f1a2b3c9d4e5f6a7b8c9d0",
  "tokenVersion": 3,
  "iat": 1716000000,
  "exp": 1718592000
}
```

This JSON is also **Base64Url encoded** to form the second part.

⚠️ **Important**: Base64 is NOT encryption. Anyone can decode the payload at [jwt.io](https://jwt.io) and read it. Never put passwords, credit card numbers, or secrets in the payload.

### 8.3 Signature
This is what makes the JWT **tamper-proof**. It's created like this (for HMAC-based algorithm `HS256`):

```
signature = HMACSHA256(
  base64UrlEncode(header) + "." + base64UrlEncode(payload),
  SECRET_KEY
)
```

- If **anyone modifies the payload** (e.g., changes `"role": "user"` to `"role": "admin"`), the signature will no longer match when the server re-computes it → server rejects the token.
- The `SECRET_KEY` (for HMAC) or **private key** (for RSA/ECDSA — asymmetric signing) is known only to the server(s) that issue and verify tokens.

### 8.4 Common Signing Algorithms

| Algorithm | Type | Use Case |
|---|---|---|
| **HS256** (HMAC + SHA256) | Symmetric (same secret to sign & verify) | Simple apps, single backend |
| **RS256** (RSA + SHA256) | Asymmetric (private key signs, public key verifies) | Microservices — one service signs, many services verify using public key |
| **ES256** (ECDSA) | Asymmetric | Similar to RS256 but smaller keys, faster |

### 8.5 Full Example Decoded

**Encoded Token:**
```
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY0ZjFhMmIzYzlkNGU1ZjZhN2I4YzlkMCIsIm5hbWUiOiJSYWh1bCIsInJvbGUiOiJhZG1pbiIsImlhdCI6MTcxNjAwMDAwMCwiZXhwIjoxNzE2MDAwOTAwfQ.QwErTyUiOpAsDfGhJkLzXcVbNmQwErTyUiOpAsDfGhJkL
```

**Decoded:**
```
HEADER:    { "alg": "HS256", "typ": "JWT" }
PAYLOAD:   { "id": "64f1a2b3c9d4e5f6a7b8c9d0", "name": "Rahul", "role": "admin", "iat": 1716000000, "exp": 1716000900 }
SIGNATURE: HMACSHA256(header.payload, "your-secret-key")
```

---

## 9. Real-World MERN Stack Example (Express + Node.js + Mongoose + React)

Below is a **basic structural example** showing how to **generate (sign)** and **validate (verify)** JWTs — covering both Access Token and Refresh Token, purely to understand the core idea (not full production code).

### 9.1 Project Structure
```
mern-jwt-app/
│
├── backend/
│   ├── models/
│   │   └── User.js
│   ├── utils/
│   │   └── generateTokens.js
│   ├── middleware/
│   │   └── verifyToken.js
│   ├── routes/
│   │   ├── authRoutes.js
│   │   └── userRoutes.js
│   ├── server.js
│   └── .env
│
└── frontend/ (React)
    ├── src/
    │   ├── api/
    │   │   └── axiosInstance.js
    │   ├── context/
    │   │   └── AuthContext.jsx
    │   └── pages/
    │       └── Login.jsx
```

---

### 9.2 Backend: Install Dependencies

```bash
npm install express mongoose jsonwebtoken bcryptjs dotenv cookie-parser cors
```

---

### 9.3 `.env` (Secret Keys)

```env
ACCESS_TOKEN_SECRET=access_super_secret_key_123
REFRESH_TOKEN_SECRET=refresh_super_secret_key_456
MONGO_URI=mongodb://localhost:27017/mern_jwt_demo
PORT=5000
```

---

### 9.4 `models/User.js` (Mongoose Schema)

```javascript
const mongoose = require("mongoose");

const userSchema = new mongoose.Schema({
  name: { type: String, required: true },
  email: { type: String, required: true, unique: true },
  password: { type: String, required: true },
  role: { type: String, default: "user" },
  refreshToken: { type: String }, // store latest refresh token for rotation/revocation
});

module.exports = mongoose.model("User", userSchema);
```

---

### 9.5 `utils/generateTokens.js` (SIGN — Creating Tokens)

```javascript
const jwt = require("jsonwebtoken");

// Generate short-lived Access Token
const generateAccessToken = (user) => {
  return jwt.sign(
    { id: user._id, role: user.role },       // payload
    process.env.ACCESS_TOKEN_SECRET,          // secret key
    { expiresIn: "15m" }                      // options
  );
};

// Generate long-lived Refresh Token
const generateRefreshToken = (user) => {
  return jwt.sign(
    { id: user._id },
    process.env.REFRESH_TOKEN_SECRET,
    { expiresIn: "7d" }
  );
};

module.exports = { generateAccessToken, generateRefreshToken };
```

---

### 9.6 `routes/authRoutes.js` (Login → Set Tokens)

```javascript
const express = require("express");
const bcrypt = require("bcryptjs");
const jwt = require("jsonwebtoken");
const User = require("../models/User");
const { generateAccessToken, generateRefreshToken } = require("../utils/generateTokens");

const router = express.Router();

// LOGIN — generate & send tokens
router.post("/login", async (req, res) => {
  const { email, password } = req.body;
  const user = await User.findOne({ email });
  if (!user) return res.status(400).json({ message: "Invalid credentials" });

  const isMatch = await bcrypt.compare(password, user.password);
  if (!isMatch) return res.status(400).json({ message: "Invalid credentials" });

  const accessToken = generateAccessToken(user);
  const refreshToken = generateRefreshToken(user);

  // Store refresh token in DB (needed for rotation/revocation)
  user.refreshToken = refreshToken;
  await user.save();

  // Send refresh token as httpOnly cookie (safer than localStorage)
  res.cookie("refreshToken", refreshToken, {
    httpOnly: true,
    secure: true,       // use HTTPS in production
    sameSite: "strict",
    maxAge: 7 * 24 * 60 * 60 * 1000, // 7 days
  });

  // Send access token in response body (frontend keeps it in memory/state)
  res.json({ accessToken, user: { id: user._id, name: user.name, role: user.role } });
});

// REFRESH — verify refresh token & rotate
router.post("/refresh-token", async (req, res) => {
  const oldRefreshToken = req.cookies.refreshToken;
  if (!oldRefreshToken) return res.status(401).json({ message: "No token provided" });

  const user = await User.findOne({ refreshToken: oldRefreshToken });
  if (!user) return res.status(403).json({ message: "Invalid refresh token — possible reuse detected" });

  jwt.verify(oldRefreshToken, process.env.REFRESH_TOKEN_SECRET, async (err, decoded) => {
    if (err) return res.status(403).json({ message: "Refresh token expired/invalid" });

    // TOKEN ROTATION: issue brand new access + refresh tokens
    const newAccessToken = generateAccessToken(user);
    const newRefreshToken = generateRefreshToken(user);

    user.refreshToken = newRefreshToken; // old one is now invalidated
    await user.save();

    res.cookie("refreshToken", newRefreshToken, {
      httpOnly: true,
      secure: true,
      sameSite: "strict",
      maxAge: 7 * 24 * 60 * 60 * 1000,
    });

    res.json({ accessToken: newAccessToken });
  });
});

// LOGOUT — invalidate refresh token
router.post("/logout", async (req, res) => {
  const refreshToken = req.cookies.refreshToken;
  await User.findOneAndUpdate({ refreshToken }, { refreshToken: "" });
  res.clearCookie("refreshToken");
  res.json({ message: "Logged out" });
});

module.exports = router;
```

---

### 9.7 `middleware/verifyToken.js` (VERIFY — Protecting Routes)

```javascript
const jwt = require("jsonwebtoken");

const verifyAccessToken = (req, res, next) => {
  const authHeader = req.headers["authorization"]; // "Bearer <token>"
  const token = authHeader && authHeader.split(" ")[1];

  if (!token) return res.status(401).json({ message: "No token provided" });

  jwt.verify(token, process.env.ACCESS_TOKEN_SECRET, (err, decoded) => {
    if (err) return res.status(403).json({ message: "Invalid or expired access token" });

    req.user = decoded; // { id, role }
    next();
  });
};

module.exports = verifyAccessToken;
```

---

### 9.8 `routes/userRoutes.js` (Protected Route Example)

```javascript
const express = require("express");
const verifyAccessToken = require("../middleware/verifyToken");

const router = express.Router();

router.get("/profile", verifyAccessToken, (req, res) => {
  res.json({ message: "Protected data", user: req.user });
});

module.exports = router;
```

---

### 9.9 `server.js`

```javascript
const express = require("express");
const mongoose = require("mongoose");
const cookieParser = require("cookie-parser");
const cors = require("cors");
require("dotenv").config();

const authRoutes = require("./routes/authRoutes");
const userRoutes = require("./routes/userRoutes");

const app = express();
app.use(express.json());
app.use(cookieParser());
app.use(cors({ origin: "http://localhost:3000", credentials: true }));

app.use("/api/auth", authRoutes);
app.use("/api/user", userRoutes);

mongoose.connect(process.env.MONGO_URI).then(() => {
  app.listen(process.env.PORT, () => console.log(`Server running on port ${process.env.PORT}`));
});
```

---

### 9.10 Frontend (React) — `api/axiosInstance.js`

```javascript
import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:5000/api",
  withCredentials: true, // sends the httpOnly refresh token cookie automatically
});

// Attach access token to every request
api.interceptors.request.use((config) => {
  const token = localStorage.getItem("accessToken"); // or from React Context/state
  if (token) config.headers.Authorization = `Bearer ${token}`;
  return config;
});

// Auto-refresh access token if expired (401 response)
api.interceptors.response.use(
  (res) => res,
  async (error) => {
    const originalRequest = error.config;
    if (error.response?.status === 401 && !originalRequest._retry) {
      originalRequest._retry = true;
      const res = await axios.post(
        "http://localhost:5000/api/auth/refresh-token",
        {},
        { withCredentials: true }
      );
      localStorage.setItem("accessToken", res.data.accessToken);
      originalRequest.headers.Authorization = `Bearer ${res.data.accessToken}`;
      return api(originalRequest);
    }
    return Promise.reject(error);
  }
);

export default api;
```

---

### 9.11 Frontend (React) — `pages/Login.jsx` (Simplified)

```jsx
import { useState } from "react";
import axios from "axios";

function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = async (e) => {
    e.preventDefault();
    const res = await axios.post(
      "http://localhost:5000/api/auth/login",
      { email, password },
      { withCredentials: true } // needed to receive the httpOnly refresh cookie
    );
    localStorage.setItem("accessToken", res.data.accessToken);
    console.log("Logged in user:", res.data.user);
  };

  return (
    <form onSubmit={handleLogin}>
      <input value={email} onChange={(e) => setEmail(e.target.value)} placeholder="Email" />
      <input value={password} onChange={(e) => setPassword(e.target.value)} type="password" placeholder="Password" />
      <button type="submit">Login</button>
    </form>
  );
}

export default Login;
```

---

## 10. Summary Flow (End to End)

```
[React Login Form]
       |
       v
POST /api/auth/login  --------->  Server validates credentials
       |                                  |
       |                                  v
       |                    jwt.sign() → Access Token (15m)
       |                    jwt.sign() → Refresh Token (7d) → saved in DB + httpOnly cookie
       v
[React stores Access Token in memory/localStorage]
       |
       v
GET /api/user/profile  (Authorization: Bearer <accessToken>)
       |
       v
Middleware → jwt.verify() → if valid → allow access
       |
       v
[If Access Token expired] → POST /api/auth/refresh-token (cookie sent automatically)
       |
       v
Server verifies old Refresh Token → issues NEW Access + Refresh Token (ROTATION)
       |
       v
Old Refresh Token invalidated in DB → New tokens sent back to client
```

---

## 11. Quick Reference Cheat Sheet

| Concept | Key Point |
|---|---|
| **JWT** | Header.Payload.Signature — self-contained, stateless auth |
| **Access Token** | Short-lived, sent on every API call via `Authorization` header |
| **Refresh Token** | Long-lived, stored in httpOnly cookie/DB, used only to renew access token |
| **Token Rotation** | New refresh token issued every time old one is used; prevents replay attacks |
| **jwt.sign()** | Creates/generates a token |
| **jwt.verify()** | Validates a token's signature & expiry |
| **Never store** | Passwords or sensitive data inside JWT payload |
| **Best storage practice** | Access Token → memory/state; Refresh Token → httpOnly Secure cookie |

---

*This guide covers the conceptual and structural fundamentals of JWT-based authentication. Production systems should add additional protections such as HTTPS enforcement, rate limiting, CSRF protection alongside cookies, token blacklisting, and proper error handling.*
