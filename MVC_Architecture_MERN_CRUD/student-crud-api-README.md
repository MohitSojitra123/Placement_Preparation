# 🎓 Student CRUD API — Express.js + Node.js + Mongoose + bcrypt

A complete, production-style **CRUD REST API** for managing Student records, built using
**MVC (Model-View-Controller) architecture** and Express's **Router** module.

This document is written specifically to help you **explain this project confidently in a technical interview** — covering not just *what* the code does, but *why* it's structured this way, what problems each design decision solves, and how a request flows through the system end-to-end.

---

## 1. Tech Stack & Why Each Tool Was Chosen

| Technology | Role | Why it's used |
|---|---|---|
| **Node.js** | JS runtime | Non-blocking, event-driven — ideal for I/O-heavy REST APIs |
| **Express.js** | Web framework | Minimal, unopinionated routing + middleware pipeline on top of Node's `http` module |
| **MongoDB** | Database | Schema-flexible NoSQL store, natural fit for document-style records like Students |
| **Mongoose** | ODM (Object Data Modeling) | Adds schemas, validation, hooks/middleware, and query helpers on top of the raw MongoDB driver |
| **bcrypt** | Password hashing | One-way, salted hashing algorithm — protects stored passwords even if the DB is leaked |
| **dotenv** | Config management | Keeps secrets (DB URI, salt rounds) out of source code |

---

## 2. Project Structure (MVC Architecture)

```
student-crud-api/
│
├── config/
│   └── db.js                  # MongoDB connection logic (Mongoose.connect)
│
├── models/
│   └── student.model.js       # Schema definition + bcrypt hooks (the "M" in MVC)
│
├── controllers/
│   └── student.controller.js  # Business logic for all 7 CRUD operations (the "C" in MVC)
│
├── routes/
│   └── student.routes.js      # Maps URL + HTTP verb → controller function (the "Router")
│
├── middlewares/
│   └── errorHandler.js        # Centralised error-handling middleware
│
├── app.js                     # Express app setup: global middleware + route mounting
├── server.js                  # Entry point: connects DB, then starts the HTTP server
├── .env.example                # Sample environment variables
└── package.json
```

### Why split it this way? (Common interview question)

> "MVC separates **data** (Model), **business logic** (Controller), and in a REST API
> the **View is the JSON response itself** — there's no HTML template layer.
> Routes act as the wiring between an incoming HTTP request and the right controller function.
> This separation means:
> - You can change your database (Model) without touching route definitions.
> - You can add new routes without duplicating business logic.
> - Controllers are unit-testable independent of Express (in principle)."

---

## 3. The Student Schema (`models/student.model.js`)

Key design decisions to mention in an interview:

1. **`select: false` on `password`** — Mongoose will *never* return the password field
   in a normal `.find()`/`.findById()` unless you explicitly request it with `.select('+password')`.
   This is a defense-in-depth habit even though we also strip it in `toJSON()`.

2. **`unique: true` on `email` and `rollNumber`** — creates a MongoDB unique index,
   so duplicate inserts fail at the database level (caught and formatted nicely by
   `errorHandler.js`, returning HTTP `409 Conflict`).

3. **`pre('save')` middleware (a Mongoose "hook")**:
   ```js
   studentSchema.pre("save", async function (next) {
     if (!this.isModified("password")) return next();
     this.password = await bcrypt.hash(this.password, salt);
     next();
   });
   ```
   This runs **automatically** before every `.save()` / `.create()` call — so the
   controller layer never has to remember to hash passwords manually for single inserts.

4. **`comparePassword()` instance method** — wraps `bcrypt.compare()`, ready to be used
   later for a login/authentication endpoint (bcrypt hashes are one-way; you never
   "decrypt" them, you re-hash the input and compare hashes).

5. **`toJSON()` override** — strips `password` and `__v` from every JSON response,
   as a second safety net beyond `select: false`.

> ⚠️ **Important gotcha to mention in interviews:** Mongoose's `pre('save')` hook does
> **NOT** run on `findByIdAndUpdate()` or `insertMany()` by default. That's why the
> controller manually re-hashes the password in `updateStudent()` and
> `insertManyStudents()` — a classic bcrypt + Mongoose interview trap.

---

## 4. The 7 CRUD Operations — What Each One Does

| # | Function | HTTP Method & Route | Purpose |
|---|---|---|---|
| 1 | `InsertOneStudent()` | `POST /api/students` | Create a single student (password auto-hashed via model hook) |
| 2 | `InsertManyStudent()` | `POST /api/students/bulk` | Bulk-create students; passwords hashed manually before `insertMany()` |
| 3 | `GetAllStudent()` | `GET /api/students` | Fetch students with pagination (`?page=&limit=`) + search (`?search=`) |
| 4 | `GetOneStudent()` | `GET /api/students/:id` | Fetch a single student by MongoDB `_id` |
| 5 | `UpdateStudent()` | `PUT /api/students/:id` | Partial update; re-hashes password if included in the body |
| 6 | `DeleteOneStudent()` | `DELETE /api/students/:id` | Delete a single student by `_id` |
| 7 | `DeleteAllStudent()` | `DELETE /api/students` | Wipe the entire collection (should be admin-protected in production) |

### Consistent Response Shape

Every endpoint returns the same envelope, which is a common REST API best practice:

```json
{
  "success": true,
  "message": "Human-readable description",
  "data": { }
}
```

This consistency lets frontend code write one generic response handler instead of
guessing the shape per-endpoint.

---

## 5. Full Request Lifecycle (Working Flow)

Walking through **`POST /api/students`** (Create Student) end-to-end — this is the
kind of "trace the request" explanation interviewers love:

```
CLIENT (Postman/Frontend)
   │  POST /api/students
   │  Body: { name, email, password, rollNumber, ... }
   ▼
server.js
   │  (already running — DB connected via connectDB() before app.listen())
   ▼
app.js — Global Middleware Pipeline
   │  1. express.json()        → parses raw body into req.body
   │  2. custom logger          → logs method + URL + timestamp
   │  3. app.use("/api/students", studentRoutes)  → matched, hands off to Router
   ▼
routes/student.routes.js
   │  router.post("/", insertOneStudent)   → exact path match, calls controller
   ▼
controllers/student.controller.js → insertOneStudent()
   │  1. Destructure & validate required fields from req.body
   │  2. Student.create(req.body)   → hands data to Mongoose
   ▼
models/student.model.js
   │  1. Mongoose validates fields against schema rules (required, minlength, enum...)
   │  2. pre('save') hook fires → bcrypt.hash(password, salt) → password overwritten with hash
   │  3. Document is written to MongoDB (unique index checked on email/rollNumber)
   ▼
MongoDB
   │  Document persisted, returns the saved doc (with hashed password + generated _id)
   ▲
controllers/student.controller.js
   │  toJSON() override strips password → res.status(201).json({ success, message, data })
   ▲
CLIENT
      Receives: 201 Created + student object (NO password field visible)
```

### What happens on an error at any step?

Every controller function is wrapped in `asyncHandler()`, which catches rejected
Promises and forwards them via `next(err)` to `middlewares/errorHandler.js`
(registered LAST in `app.js`, so Express treats it as the error-handling middleware).
That file inspects the error type and returns the correct status code:

| Error Type | Cause | HTTP Status |
|---|---|---|
| `CastError` | Malformed MongoDB `_id` in the URL | `400 Bad Request` |
| `ValidationError` | Missing/invalid field per schema rules | `400 Bad Request` |
| `code === 11000` | Duplicate `email`/`rollNumber` (unique index violation) | `409 Conflict` |
| Anything else | Unexpected server-side failure | `500 Internal Server Error` |

---

## 6. Why `insertMany()` Needs Special Handling (Common Interview Trap)

```js
// insertManyStudents() controller — simplified
const hashed = await Promise.all(
  students.map(async (s) => ({ ...s, password: await bcrypt.hash(s.password, saltRounds) }))
);
await Student.insertMany(hashed, { ordered: false });
```

- `insertMany()` bypasses document middleware (`pre('save')`) for performance reasons —
  it talks to MongoDB in a more direct, bulk-optimized way.
- So passwords must be hashed **before** calling it, in the controller layer.
- `{ ordered: false }` tells MongoDB: "if document #3 fails validation (e.g., duplicate
  email), skip it and keep inserting the rest" — instead of aborting the entire batch
  at the first failure (which is the default `ordered: true` behavior).

---

## 7. Pagination & Search Design (`GetAllStudent`)

```
GET /api/students?page=2&limit=5&search=priya
```

- `page` / `limit` → converted to a MongoDB `.skip()` / `.limit()` pair:
  `skip = (page - 1) * limit`
- `search` → built into a `$or` + `$regex` (case-insensitive, `$options: "i"`) filter
  across `name`, `email`, and `rollNumber`.
- Response includes `total`, `totalPages`, and `currentPage` so the frontend can
  render pagination controls without a second API call.

> Interview talking point: for large collections, `$regex` search is not index-friendly.
> A production system would use MongoDB **Atlas Search** or a text index
> (`db.students.createIndex({ name: "text" })`) instead.

---

## 8. Security Notes (Good to Mention Proactively)

- Passwords are **never** stored or returned in plaintext (bcrypt + `select:false` + `toJSON()` stripping).
- `runValidators: true` on updates ensures partial updates still respect schema rules
  (e.g., can't set `age` to a negative number via `PUT`).
- `DeleteAllStudent()` is intentionally dangerous — in a real app this route would sit
  behind authentication + role-based authorization (e.g., `isAdmin` middleware), not
  exposed publicly as it is in this demo.
- `.env` keeps `MONGO_URI` and `BCRYPT_SALT_ROUNDS` out of version control.

---

## 9. How to Run This Project

```bash
# 1. Install dependencies
npm install

# 2. Copy environment variables
cp .env.example .env
# then edit .env with your real MongoDB URI

# 3. Start MongoDB locally (or use MongoDB Atlas URI in .env)

# 4. Run the server
npm run dev      # with nodemon (auto-restart on change)
# or
npm start        # plain node
```

Server boots at: `http://localhost:5000`

### Sample API Calls (using curl)

```bash
# Create one student
curl -X POST http://localhost:5000/api/students \
  -H "Content-Type: application/json" \
  -d '{"name":"Rahul Sharma","email":"rahul@example.com","password":"secret123","rollNumber":"CS101","age":20,"course":"B.Tech CSE"}'

# Get all students (page 1, 5 per page)
curl "http://localhost:5000/api/students?page=1&limit=5"

# Get one student
curl http://localhost:5000/api/students/<studentId>

# Update a student
curl -X PUT http://localhost:5000/api/students/<studentId> \
  -H "Content-Type: application/json" \
  -d '{"course":"M.Tech CSE"}'

# Delete one student
curl -X DELETE http://localhost:5000/api/students/<studentId>

# Bulk insert
curl -X POST http://localhost:5000/api/students/bulk \
  -H "Content-Type: application/json" \
  -d '[{"name":"A","email":"a@x.com","password":"pass123","rollNumber":"CS102"},{"name":"B","email":"b@x.com","password":"pass456","rollNumber":"CS103"}]'

# Delete ALL students
curl -X DELETE http://localhost:5000/api/students
```

---

## 10. Likely Interview Questions & Short Answers

**Q: Why use Mongoose instead of the native MongoDB driver?**
A: Mongoose adds schema validation, hooks/middleware (like password hashing), and a
cleaner query API, catching data-shape bugs before they hit the database.

**Q: Why is `password` hashed in a `pre('save')` hook instead of the controller?**
A: Centralizing it in the model guarantees it happens for *every* code path that calls
`.save()`, even future ones — the controller can't "forget" to hash it.

**Q: What's the difference between `PUT` and `PATCH` here, and why did you use `PUT`?**
A: Semantically `PATCH` is for partial updates and `PUT` for full replacement, but in
practice many REST APIs (including this one) use `PUT` loosely for partial updates too.
Because `findByIdAndUpdate` only touches fields present in the body, it behaves like a
`PATCH` even though the route is named `PUT` — worth mentioning you're aware of the distinction.

**Q: How would you add authentication to this later?**
A: Use `comparePassword()` in a new `/login` route to verify credentials, then issue a
JWT. Add an `authMiddleware` that verifies the JWT on protected routes (e.g., delete-all).

**Q: How does Express know which function handles an error vs a normal request?**
A: By the number of parameters — Express treats any middleware function with exactly
4 parameters `(err, req, res, next)` as an error handler, and only invokes it when
`next(err)` is called somewhere upstream.

**Q: Why keep `app.js` and `server.js` separate?**
A: `app.js` exports a pure, testable Express instance (great for integration tests with
`supertest`, since you never actually bind a port). `server.js` handles the
side-effecting parts: reading env vars, connecting to the DB, and calling `app.listen()`.

---

## 11. Possible Extensions (if asked "what would you improve?")

- Add JWT-based authentication & role-based authorization.
- Add request validation with `joi` or `express-validator` instead of relying solely on Mongoose schema validation.
- Add rate limiting (`express-rate-limit`) on public write endpoints.
- Add automated tests (Jest + Supertest) hitting `app.js` directly with an in-memory MongoDB (`mongodb-memory-server`).
- Add Swagger/OpenAPI documentation for the API.
- Replace `$regex` search with a proper MongoDB text index for scalability.
