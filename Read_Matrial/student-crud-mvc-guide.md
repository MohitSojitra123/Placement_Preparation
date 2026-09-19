# Student Management — MVC CRUD with Node.js, Express, Mongoose & React

> A complete build guide covering MVC architecture, all six CRUD operations, an exhaustive Mongoose method reference, and a React frontend that consumes the API.

---

## Table of Contents

1. [What MVC Actually Means](#1-what-mvc-actually-means)
2. [Complete Folder Structure — Every File Explained](#2-complete-folder-structure--every-file-explained)
3. [Project Setup](#3-project-setup)
4. [The `.env` File](#4-the-env-file)
5. [Database Configuration](#5-database-configuration)
6. [MODEL — The Student Schema](#6-model--the-student-schema)
7. [CONTROLLER — All Six Operations](#7-controller--all-six-operations)
8. [ROUTE — Wiring URLs to Controllers](#8-route--wiring-urls-to-controllers)
9. [Middleware](#9-middleware)
10. [App & Server Entry Points](#10-app--server-entry-points)
11. [Complete Mongoose Method Reference](#11-complete-mongoose-method-reference)
12. [VIEW — React Frontend](#12-view--react-frontend)
13. [API Testing](#13-api-testing)
14. [Common Errors & Fixes](#14-common-errors--fixes)

---

## 1. What MVC Actually Means

MVC splits an application into three responsibilities so that changing one does not break the others.

```
        ┌──────────────────────────────────────────────┐
        │                  CLIENT                       │
        │            (Browser / Postman)                │
        └──────────────────┬───────────────────────────┘
                           │  HTTP Request
                           ▼
        ┌──────────────────────────────────────────────┐
        │                  ROUTE                        │
        │   "Which controller handles POST /students?"  │
        └──────────────────┬───────────────────────────┘
                           │
                           ▼
        ┌──────────────────────────────────────────────┐
        │               MIDDLEWARE                      │
        │   Validate · Authenticate · Log · Parse       │
        └──────────────────┬───────────────────────────┘
                           │
                           ▼
        ┌──────────────────────────────────────────────┐
        │               CONTROLLER                      │
        │   Business logic. Reads req, calls Model,     │
        │   shapes the response. Knows NOTHING about    │
        │   how data is physically stored.              │
        └──────────────────┬───────────────────────────┘
                           │
                           ▼
        ┌──────────────────────────────────────────────┐
        │                 MODEL                         │
        │   Schema, validation, DB queries.             │
        │   Knows NOTHING about HTTP.                   │
        └──────────────────┬───────────────────────────┘
                           │
                           ▼
        ┌──────────────────────────────────────────────┐
        │                 MongoDB                       │
        └──────────────────────────────────────────────┘
                           │
                           │  JSON Response
                           ▼
        ┌──────────────────────────────────────────────┐
        │                  VIEW                         │
        │   React components render the data            │
        └──────────────────────────────────────────────┘
```

### The three layers

| Layer | Responsibility | Must NOT do |
|---|---|---|
| **Model** | Define data shape, validation rules, DB operations | Touch `req` or `res` |
| **View** | Display data, capture user input | Contain business rules |
| **Controller** | Orchestrate: read request → call model → send response | Contain raw DB driver code |

### Why this matters in practice

```js
// ❌ BAD — everything crammed into the route
app.post('/students', async (req, res) => {
  const db = client.db('school');
  await db.collection('students').insertOne(req.body);
  res.send('ok');
});
```

No validation, no error handling, no reuse, untestable, and swapping MongoDB for PostgreSQL means rewriting the route.

```js
// ✅ GOOD — separated
router.post('/', createStudent);           // route
export const createStudent = asyncHandler( // controller
  async (req, res) => {
    const student = await Student.create(req.body);  // model
    res.status(201).json(new ApiResponse(201, student));
  }
);
```

---

## 2. Complete Folder Structure — Every File Explained

```
student-management/
│
├── backend/
│   │
│   ├── src/
│   │   │
│   │   ├── config/
│   │   │   └── db.js                    # MongoDB connection logic
│   │   │
│   │   ├── models/                      ← M
│   │   │   └── student.model.js         # Schema, validation, hooks, methods
│   │   │
│   │   ├── controllers/                 ← C
│   │   │   └── student.controller.js    # All 6 CRUD handler functions
│   │   │
│   │   ├── routes/
│   │   │   └── student.routes.js        # URL → controller mapping
│   │   │
│   │   ├── middlewares/
│   │   │   ├── validate.middleware.js   # Body/param validation
│   │   │   ├── logger.middleware.js     # Request logging
│   │   │   └── error.middleware.js      # Central error handler + 404
│   │   │
│   │   ├── utils/
│   │   │   ├── ApiError.js              # Custom error class
│   │   │   ├── ApiResponse.js           # Uniform success envelope
│   │   │   └── asyncHandler.js          # try/catch wrapper
│   │   │
│   │   ├── app.js                       # Express app: middleware + routes
│   │   └── server.js                    # Entry point: env, DB, listen
│   │
│   ├── .env                             # Secrets — NEVER commit
│   ├── .env.example                     # Template — safe to commit
│   ├── .gitignore
│   └── package.json
│
└── frontend/                            ← V
    ├── src/
    │   ├── api/
    │   │   └── studentApi.js            # Axios instance + all API calls
    │   ├── components/
    │   │   ├── StudentList.jsx          # Table of all students
    │   │   ├── StudentForm.jsx          # Add / Edit form
    │   │   ├── StudentDetail.jsx        # Single student view
    │   │   └── Navbar.jsx
    │   ├── pages/
    │   │   ├── Home.jsx
    │   │   ├── AddStudent.jsx
    │   │   ├── EditStudent.jsx
    │   │   └── ViewStudent.jsx
    │   ├── App.jsx                      # Router setup
    │   ├── main.jsx                     # ReactDOM entry
    │   └── index.css
    ├── .env                             # VITE_API_URL
    └── package.json
```

### File-by-file purpose

| File | What lives here | What must never live here |
|---|---|---|
| `config/db.js` | `mongoose.connect()`, connection event listeners | Business logic |
| `models/student.model.js` | Schema fields, validators, indexes, virtuals, hooks | `req` / `res` |
| `controllers/student.controller.js` | Request parsing, calling model methods, status codes | Raw MongoDB driver calls |
| `routes/student.routes.js` | `router.get()`, `router.post()` … | Function bodies — only references |
| `middlewares/` | Cross-cutting concerns that run *between* route and controller | Route definitions |
| `utils/` | Pure, reusable helpers with no side effects | DB or HTTP code |
| `app.js` | Express instance, global middleware, route mounting | `app.listen()` |
| `server.js` | `dotenv.config()`, `connectDB()`, `app.listen()` | Route or middleware definitions |

**Why `app.js` and `server.js` are separate:** `app.js` exports a configured Express app with no side effects, which makes it importable by test suites (Supertest) without starting a real server on a port.

---

## 3. Project Setup

```bash
mkdir student-management && cd student-management
mkdir backend && cd backend
npm init -y
npm install express mongoose dotenv cors
npm install -D nodemon
```

**`backend/package.json`**

```json
{
  "name": "student-management-backend",
  "version": "1.0.0",
  "type": "module",
  "main": "src/server.js",
  "scripts": {
    "dev": "nodemon src/server.js",
    "start": "node src/server.js"
  },
  "dependencies": {
    "cors": "^2.8.5",
    "dotenv": "^16.4.5",
    "express": "^4.19.2",
    "mongoose": "^8.3.1"
  },
  "devDependencies": {
    "nodemon": "^3.1.0"
  }
}
```

> `"type": "module"` enables `import`/`export` syntax. Without it you must use `require()`.

**`backend/.gitignore`**

```
node_modules/
.env
*.log
dist/
.DS_Store
```

---

## 4. The `.env` File

Environment variables keep configuration out of source code. The same codebase then runs in development, staging, and production with different values.

**`backend/.env`**

```env
# ---------- Server ----------
PORT=8000
NODE_ENV=development

# ---------- Database ----------
MONGODB_URI=mongodb://127.0.0.1:27017
DB_NAME=student_management

# For MongoDB Atlas instead:
# MONGODB_URI=mongodb+srv://<username>:<password>@cluster0.xxxxx.mongodb.net

# ---------- CORS ----------
CORS_ORIGIN=http://localhost:5173

# ---------- Pagination defaults ----------
DEFAULT_PAGE_LIMIT=10
MAX_PAGE_LIMIT=100
```

**`backend/.env.example`** (commit this one)

```env
PORT=
NODE_ENV=
MONGODB_URI=
DB_NAME=
CORS_ORIGIN=
DEFAULT_PAGE_LIMIT=
MAX_PAGE_LIMIT=
```

### Rules for `.env`

| Rule | Reason |
|---|---|
| Never commit `.env` | Credentials in Git history are permanent |
| Always commit `.env.example` | New developers know which keys are required |
| Call `dotenv.config()` **first**, before any other import that reads env | Otherwise `process.env.X` is `undefined` at import time |
| Use `127.0.0.1` not `localhost` for local Mongo | Node 18+ may resolve `localhost` to IPv6 `::1`, which Mongo isn't listening on |
| No quotes around values | `PORT="8000"` gives you the string `"8000"` including quotes |

**Frontend `.env`** (Vite requires the `VITE_` prefix):

```env
VITE_API_URL=http://localhost:8000/api/v1
```

---

## 5. Database Configuration

**`backend/src/config/db.js`**

```js
import mongoose from 'mongoose';

const connectDB = async () => {
  try {
    const connectionInstance = await mongoose.connect(
      `${process.env.MONGODB_URI}/${process.env.DB_NAME}`
    );

    console.log(`✅ MongoDB connected → ${connectionInstance.connection.host}`);
    console.log(`📦 Database → ${connectionInstance.connection.name}`);
  } catch (error) {
    console.error('❌ MongoDB connection FAILED:', error.message);
    process.exit(1); // exit code 1 = failure; stops the app cleanly
  }
};

// ---- Connection lifecycle events ----
mongoose.connection.on('connected', () => console.log('Mongoose: connected'));
mongoose.connection.on('error',     (err) => console.error('Mongoose error:', err));
mongoose.connection.on('disconnected', () => console.log('Mongoose: disconnected'));

// Close the connection cleanly on Ctrl+C
process.on('SIGINT', async () => {
  await mongoose.connection.close();
  console.log('Mongoose connection closed due to app termination');
  process.exit(0);
});

export default connectDB;
```

### Why `process.exit(1)`?

If the database is unreachable, the app is useless. Exiting lets your process manager (PM2, Docker, Kubernetes) restart it rather than leaving a zombie server that 500s on every request.

---

## 6. MODEL — The Student Schema

**`backend/src/models/student.model.js`**

```js
import mongoose from 'mongoose';

const studentSchema = new mongoose.Schema(
  {
    rollNumber: {
      type: String,
      required: [true, 'Roll number is required'],
      unique: true,
      trim: true,
      uppercase: true,
      match: [/^[A-Z0-9-]{3,15}$/, 'Roll number format is invalid'],
    },

    fullName: {
      type: String,
      required: [true, 'Full name is required'],
      trim: true,
      minlength: [3, 'Name must be at least 3 characters'],
      maxlength: [60, 'Name cannot exceed 60 characters'],
    },

    email: {
      type: String,
      required: [true, 'Email is required'],
      unique: true,
      lowercase: true,
      trim: true,
      match: [/^\S+@\S+\.\S+$/, 'Please provide a valid email address'],
    },

    phone: {
      type: String,
      required: [true, 'Phone number is required'],
      match: [/^[6-9]\d{9}$/, 'Phone must be a valid 10-digit number'],
    },

    age: {
      type: Number,
      required: [true, 'Age is required'],
      min: [15, 'Student must be at least 15'],
      max: [60, 'Age cannot exceed 60'],
    },

    gender: {
      type: String,
      required: true,
      enum: {
        values: ['male', 'female', 'other'],
        message: '{VALUE} is not a valid gender',
      },
      lowercase: true,
    },

    course: {
      type: String,
      required: [true, 'Course is required'],
      enum: ['BCA', 'MCA', 'BSc-IT', 'BTech', 'MTech', 'BBA', 'MBA'],
    },

    semester: {
      type: Number,
      required: true,
      min: 1,
      max: 8,
    },

    marks: {
      type: Number,
      default: 0,
      min: [0, 'Marks cannot be negative'],
      max: [100, 'Marks cannot exceed 100'],
    },

    address: {
      city:    { type: String, trim: true },
      state:   { type: String, trim: true, default: 'Gujarat' },
      pincode: { type: String, match: [/^\d{6}$/, 'Pincode must be 6 digits'] },
    },

    subjects: [
      {
        type: String,
        trim: true,
      },
    ],

    admissionDate: {
      type: Date,
      default: Date.now,
    },

    isActive: {
      type: Boolean,
      default: true,
    },
  },
  {
    timestamps: true,        // adds createdAt & updatedAt automatically
    versionKey: false,       // removes the __v field
    toJSON: { virtuals: true },
    toObject: { virtuals: true },
  }
);

/* ---------------- VIRTUAL FIELD ----------------
   Computed, not stored in MongoDB. */
studentSchema.virtual('grade').get(function () {
  if (this.marks >= 90) return 'A+';
  if (this.marks >= 80) return 'A';
  if (this.marks >= 70) return 'B';
  if (this.marks >= 60) return 'C';
  if (this.marks >= 40) return 'D';
  return 'F';
});

/* ---------------- INDEXES ----------------
   Text index enables $text search; compound index speeds up filters. */
studentSchema.index({ fullName: 'text', email: 'text', rollNumber: 'text' });
studentSchema.index({ course: 1, semester: 1 });

/* ---------------- PRE HOOK (middleware) ----------------
   Runs BEFORE .save(). Not triggered by findByIdAndUpdate. */
studentSchema.pre('save', function (next) {
  if (this.fullName) {
    this.fullName = this.fullName
      .split(' ')
      .map((w) => w.charAt(0).toUpperCase() + w.slice(1).toLowerCase())
      .join(' ');
  }
  next();
});

/* ---------------- POST HOOK ---------------- */
studentSchema.post('save', function (doc, next) {
  console.log(`📘 Student saved → ${doc.rollNumber}`);
  next();
});

/* ---------------- INSTANCE METHOD ----------------
   Available on a single document: student.isPassing() */
studentSchema.methods.isPassing = function () {
  return this.marks >= 40;
};

/* ---------------- STATIC METHOD ----------------
   Available on the Model: Student.findByCourse('BCA') */
studentSchema.statics.findByCourse = function (course) {
  return this.find({ course, isActive: true });
};

/* ---------------- QUERY HELPER ----------------
   Chainable: Student.find().activeOnly() */
studentSchema.query.activeOnly = function () {
  return this.where({ isActive: true });
};

const Student = mongoose.model('Student', studentSchema);

export default Student;
```

### Schema options explained

| Option | Effect |
|---|---|
| `timestamps: true` | Auto-adds `createdAt`, `updatedAt` and maintains them |
| `versionKey: false` | Removes Mongoose's internal `__v` counter from output |
| `toJSON: { virtuals: true }` | Includes virtual fields like `grade` when converting to JSON |
| `trim: true` | Strips leading/trailing whitespace before saving |
| `lowercase` / `uppercase` | Normalises case before saving |
| `unique: true` | Creates a unique **index** — this is not a validator, it produces error code `11000` |
| `default` | Value used when the field is omitted |
| `select: false` | Field is excluded from query results unless explicitly requested |

### Model name → collection name

```js
mongoose.model('Student', studentSchema)
//              ↓
//        collection: "students"   (lowercased + pluralised automatically)
```

---

## 7. CONTROLLER — All Six Operations

### Utilities first

**`backend/src/utils/asyncHandler.js`**

```js
/**
 * Wraps an async route handler so rejected promises
 * are forwarded to Express's error middleware.
 * Without this, every controller needs its own try/catch.
 */
const asyncHandler = (requestHandler) => (req, res, next) => {
  Promise.resolve(requestHandler(req, res, next)).catch(next);
};

export default asyncHandler;
```

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

---

### `backend/src/controllers/student.controller.js`

```js
import mongoose from 'mongoose';
import Student from '../models/student.model.js';
import ApiError from '../utils/ApiError.js';
import ApiResponse from '../utils/ApiResponse.js';
import asyncHandler from '../utils/asyncHandler.js';

/* ==================================================================
   1) GET ALL STUDENTS
   GET /api/v1/students
   Supports: ?page=1&limit=10&search=ravi&course=BCA&sort=-createdAt
================================================================== */
export const getAllStudents = asyncHandler(async (req, res) => {
  const page  = Math.max(1, parseInt(req.query.page) || 1);
  const limit = Math.min(
    Number(process.env.MAX_PAGE_LIMIT) || 100,
    parseInt(req.query.limit) || Number(process.env.DEFAULT_PAGE_LIMIT) || 10
  );
  const skip = (page - 1) * limit;

  const { search, course, semester, gender, sort = '-createdAt' } = req.query;

  // ---- Build the filter object dynamically ----
  const filter = { isActive: true };

  if (course)   filter.course = course;
  if (semester) filter.semester = Number(semester);
  if (gender)   filter.gender = gender.toLowerCase();

  if (search) {
    filter.$or = [
      { fullName:   { $regex: search, $options: 'i' } },
      { email:      { $regex: search, $options: 'i' } },
      { rollNumber: { $regex: search, $options: 'i' } },
    ];
  }

  // ---- Run count and find in parallel ----
  const [students, totalStudents] = await Promise.all([
    Student.find(filter).sort(sort).skip(skip).limit(limit).lean({ virtuals: true }),
    Student.countDocuments(filter),
  ]);

  const totalPages = Math.ceil(totalStudents / limit);

  return res.status(200).json(
    new ApiResponse(
      200,
      {
        students,
        pagination: {
          currentPage: page,
          totalPages,
          totalStudents,
          limit,
          hasNextPage: page < totalPages,
          hasPrevPage: page > 1,
        },
      },
      students.length
        ? 'Students fetched successfully'
        : 'No students found'
    )
  );
});

/* ==================================================================
   2) GET ONE STUDENT
   GET /api/v1/students/:id
================================================================== */
export const getStudentById = asyncHandler(async (req, res) => {
  const { id } = req.params;

  // Guard: an invalid ObjectId would throw a CastError
  if (!mongoose.Types.ObjectId.isValid(id)) {
    throw new ApiError(400, 'Invalid student ID format');
  }

  const student = await Student.findById(id);

  if (!student) {
    throw new ApiError(404, 'Student not found');
  }

  return res
    .status(200)
    .json(new ApiResponse(200, student, 'Student fetched successfully'));
});

/* ==================================================================
   3) ADD STUDENT
   POST /api/v1/students
================================================================== */
export const createStudent = asyncHandler(async (req, res) => {
  const {
    rollNumber, fullName, email, phone, age,
    gender, course, semester, marks, address, subjects,
  } = req.body;

  // ---- Required-field check ----
  const required = { rollNumber, fullName, email, phone, age, gender, course, semester };
  const missing = Object.entries(required)
    .filter(([, v]) => v === undefined || v === null || v === '')
    .map(([k]) => k);

  if (missing.length) {
    throw new ApiError(400, `Missing required fields: ${missing.join(', ')}`);
  }

  // ---- Duplicate check ----
  const existing = await Student.findOne({
    $or: [
      { rollNumber: rollNumber.toUpperCase() },
      { email: email.toLowerCase() },
    ],
  });

  if (existing) {
    const field = existing.email === email.toLowerCase() ? 'email' : 'roll number';
    throw new ApiError(409, `A student with this ${field} already exists`);
  }

  // ---- Create ----
  const student = await Student.create({
    rollNumber, fullName, email, phone, age,
    gender, course, semester, marks, address, subjects,
  });

  return res
    .status(201)
    .json(new ApiResponse(201, student, 'Student added successfully'));
});

/* ==================================================================
   4) DELETE ONE STUDENT
   DELETE /api/v1/students/:id
================================================================== */
export const deleteStudent = asyncHandler(async (req, res) => {
  const { id } = req.params;

  if (!mongoose.Types.ObjectId.isValid(id)) {
    throw new ApiError(400, 'Invalid student ID format');
  }

  const student = await Student.findByIdAndDelete(id);

  if (!student) {
    throw new ApiError(404, 'Student not found');
  }

  return res.status(200).json(
    new ApiResponse(
      200,
      { _id: student._id, rollNumber: student.rollNumber },
      'Student deleted successfully'
    )
  );
});

/* ==================================================================
   5) DELETE ALL STUDENTS
   DELETE /api/v1/students
   Requires ?confirm=true to prevent accidental wipes
================================================================== */
export const deleteAllStudents = asyncHandler(async (req, res) => {
  if (req.query.confirm !== 'true') {
    throw new ApiError(
      400,
      'This will delete ALL students. Add ?confirm=true to proceed.'
    );
  }

  const { course } = req.query; // optional scoped delete
  const filter = course ? { course } : {};

  const result = await Student.deleteMany(filter);

  if (result.deletedCount === 0) {
    throw new ApiError(404, 'No students found to delete');
  }

  return res.status(200).json(
    new ApiResponse(
      200,
      { deletedCount: result.deletedCount },
      `${result.deletedCount} student(s) deleted successfully`
    )
  );
});

/* ==================================================================
   6) UPDATE STUDENT
   PUT  /api/v1/students/:id   → full replace
   PATCH /api/v1/students/:id  → partial update
================================================================== */
export const updateStudent = asyncHandler(async (req, res) => {
  const { id } = req.params;

  if (!mongoose.Types.ObjectId.isValid(id)) {
    throw new ApiError(400, 'Invalid student ID format');
  }

  // Whitelist — never let a client set arbitrary fields
  const allowedFields = [
    'fullName', 'email', 'phone', 'age', 'gender',
    'course', 'semester', 'marks', 'address', 'subjects', 'isActive',
  ];

  const updates = {};
  for (const field of allowedFields) {
    if (req.body[field] !== undefined) updates[field] = req.body[field];
  }

  if (Object.keys(updates).length === 0) {
    throw new ApiError(400, 'No valid fields provided for update');
  }

  // If email is changing, make sure it isn't taken by someone else
  if (updates.email) {
    const clash = await Student.findOne({
      email: updates.email.toLowerCase(),
      _id: { $ne: id },
    });
    if (clash) throw new ApiError(409, 'This email is already in use');
  }

  const student = await Student.findByIdAndUpdate(
    id,
    { $set: updates },
    {
      new: true,            // return the UPDATED document, not the original
      runValidators: true,  // enforce schema validators on update
    }
  );

  if (!student) {
    throw new ApiError(404, 'Student not found');
  }

  return res
    .status(200)
    .json(new ApiResponse(200, student, 'Student updated successfully'));
});

/* ==================================================================
   BONUS) STATISTICS — aggregation pipeline
   GET /api/v1/students/stats
================================================================== */
export const getStudentStats = asyncHandler(async (_req, res) => {
  const stats = await Student.aggregate([
    { $match: { isActive: true } },
    {
      $group: {
        _id: '$course',
        totalStudents: { $sum: 1 },
        averageMarks:  { $avg: '$marks' },
        highestMarks:  { $max: '$marks' },
        lowestMarks:   { $min: '$marks' },
        averageAge:    { $avg: '$age' },
      },
    },
    {
      $project: {
        _id: 0,
        course: '$_id',
        totalStudents: 1,
        averageMarks: { $round: ['$averageMarks', 2] },
        highestMarks: 1,
        lowestMarks: 1,
        averageAge: { $round: ['$averageAge', 1] },
      },
    },
    { $sort: { totalStudents: -1 } },
  ]);

  const overall = await Student.countDocuments({ isActive: true });

  return res
    .status(200)
    .json(new ApiResponse(200, { overall, byCourse: stats }, 'Stats fetched'));
});
```

---

## 8. ROUTE — Wiring URLs to Controllers

**`backend/src/routes/student.routes.js`**

```js
import { Router } from 'express';
import {
  getAllStudents,
  getStudentById,
  createStudent,
  updateStudent,
  deleteStudent,
  deleteAllStudents,
  getStudentStats,
} from '../controllers/student.controller.js';
import { validateObjectId } from '../middlewares/validate.middleware.js';

const router = Router();

/* IMPORTANT: specific routes BEFORE parameterised ones.
   If '/:id' came first, a request to '/stats' would be
   interpreted as id === 'stats'. */
router.get('/stats', getStudentStats);

router
  .route('/')
  .get(getAllStudents)        // 1) GET ALL
  .post(createStudent)        // 3) ADD
  .delete(deleteAllStudents); // 5) DELETE ALL

router
  .route('/:id')
  .get(validateObjectId, getStudentById)      // 2) GET ONE
  .put(validateObjectId, updateStudent)       // 6) UPDATE (full)
  .patch(validateObjectId, updateStudent)     // 6) UPDATE (partial)
  .delete(validateObjectId, deleteStudent);   // 4) DELETE ONE

export default router;
```

### Complete API surface

| # | Operation | Method | Endpoint | Success Code |
|---|---|---|---|---|
| 1 | Get all students | `GET` | `/api/v1/students` | 200 |
| 2 | Get one student | `GET` | `/api/v1/students/:id` | 200 |
| 3 | Add student | `POST` | `/api/v1/students` | 201 |
| 4 | Delete student | `DELETE` | `/api/v1/students/:id` | 200 |
| 5 | Delete all students | `DELETE` | `/api/v1/students?confirm=true` | 200 |
| 6 | Update student | `PUT` / `PATCH` | `/api/v1/students/:id` | 200 |
| — | Statistics | `GET` | `/api/v1/students/stats` | 200 |

### PUT vs PATCH

| | PUT | PATCH |
|---|---|---|
| Semantics | Replace the whole resource | Modify specific fields |
| Missing fields | Should be reset/removed | Left untouched |
| Idempotent | Yes | Usually |

---

## 9. Middleware

**`backend/src/middlewares/validate.middleware.js`**

```js
import mongoose from 'mongoose';
import ApiError from '../utils/ApiError.js';

/**
 * Rejects malformed ObjectIds before they reach the controller.
 * Prevents Mongoose CastErrors leaking as 500s.
 */
export const validateObjectId = (req, _res, next) => {
  const { id } = req.params;

  if (!mongoose.Types.ObjectId.isValid(id)) {
    return next(new ApiError(400, `'${id}' is not a valid student ID`));
  }
  next();
};

/**
 * Generic required-field checker.
 * Usage: router.post('/', requireFields('fullName','email'), createStudent)
 */
export const requireFields = (...fields) => (req, _res, next) => {
  const missing = fields.filter(
    (f) => req.body[f] === undefined || req.body[f] === null || req.body[f] === ''
  );

  if (missing.length) {
    return next(new ApiError(400, `Missing required fields: ${missing.join(', ')}`));
  }
  next();
};
```

**`backend/src/middlewares/logger.middleware.js`**

```js
export const requestLogger = (req, res, next) => {
  const start = Date.now();

  res.on('finish', () => {
    const ms = Date.now() - start;
    const colour = res.statusCode >= 400 ? '\x1b[31m' : '\x1b[32m';
    console.log(
      `${colour}${req.method}\x1b[0m ${req.originalUrl} → ${res.statusCode} (${ms}ms)`
    );
  });

  next();
};
```

**`backend/src/middlewares/error.middleware.js`**

```js
import ApiError from '../utils/ApiError.js';

/* 404 handler — runs when no route matched */
export const notFound = (req, _res, next) => {
  next(new ApiError(404, `Route ${req.method} ${req.originalUrl} not found`));
};

/* Central error handler — MUST have 4 parameters for Express to recognise it */
export const errorHandler = (err, _req, res, _next) => {
  let error = err;

  // --- Mongoose: invalid ObjectId ---
  if (err.name === 'CastError') {
    error = new ApiError(400, `Invalid ${err.path}: ${err.value}`);
  }

  // --- Mongoose: schema validation failed ---
  if (err.name === 'ValidationError') {
    const messages = Object.values(err.errors).map((e) => e.message);
    error = new ApiError(400, 'Validation failed', messages);
  }

  // --- MongoDB: duplicate key ---
  if (err.code === 11000) {
    const field = Object.keys(err.keyValue)[0];
    const value = err.keyValue[field];
    error = new ApiError(409, `${field} '${value}' already exists`);
  }

  // --- Anything else ---
  if (!(error instanceof ApiError)) {
    error = new ApiError(err.statusCode || 500, err.message || 'Internal server error');
  }

  res.status(error.statusCode).json({
    success: false,
    statusCode: error.statusCode,
    message: error.message,
    errors: error.errors,
    ...(process.env.NODE_ENV === 'development' && { stack: err.stack }),
  });
};
```

### Middleware execution order

```
express.json()  →  cors()  →  requestLogger  →  routes  →  notFound  →  errorHandler
```

Order matters. `notFound` must come **after** all routes; `errorHandler` must be **last**.

---

## 10. App & Server Entry Points

**`backend/src/app.js`**

```js
import express from 'express';
import cors from 'cors';

import studentRoutes from './routes/student.routes.js';
import { requestLogger } from './middlewares/logger.middleware.js';
import { errorHandler, notFound } from './middlewares/error.middleware.js';

const app = express();

/* ---- Global middleware ---- */
app.use(
  cors({
    origin: process.env.CORS_ORIGIN || '*',
    credentials: true,
  })
);

app.use(express.json({ limit: '16kb' }));            // parse JSON bodies
app.use(express.urlencoded({ extended: true }));      // parse form bodies
app.use(express.static('public'));                    // serve static files
app.use(requestLogger);

/* ---- Health check ---- */
app.get('/api/v1/health', (_req, res) =>
  res.status(200).json({
    success: true,
    message: 'Server is running',
    timestamp: new Date().toISOString(),
  })
);

/* ---- Routes ---- */
app.use('/api/v1/students', studentRoutes);

/* ---- Error handling (must be last) ---- */
app.use(notFound);
app.use(errorHandler);

export default app;
```

**`backend/src/server.js`**

```js
import dotenv from 'dotenv';
dotenv.config();               // MUST be first

import app from './app.js';
import connectDB from './config/db.js';

const PORT = process.env.PORT || 8000;

connectDB()
  .then(() => {
    const server = app.listen(PORT, () => {
      console.log(`🚀 Server running on http://localhost:${PORT}`);
      console.log(`📡 API base → http://localhost:${PORT}/api/v1/students`);
    });

    server.on('error', (err) => {
      console.error('Server error:', err);
      process.exit(1);
    });
  })
  .catch((err) => {
    console.error('❌ Failed to start:', err);
    process.exit(1);
  });
```

---

## 11. Complete Mongoose Method Reference

This is the section you will return to most. Every method is grouped by purpose.

---

### 11.1 CREATE methods

#### `Model.create(doc)` / `Model.create([docs])`

Builds a document, runs validators, saves it, and returns the saved document.

```js
const student = await Student.create({
  rollNumber: 'BCA-101',
  fullName: 'Ravi Patel',
  email: 'ravi@college.edu',
  age: 20,
});

// Multiple at once
const students = await Student.create([{ ... }, { ... }]);
```

| Runs validators | Runs `pre('save')` hooks | Returns |
|---|---|---|
| ✅ Yes | ✅ Yes | The created document(s) |

#### `new Model()` + `.save()`

Two-step. Useful when you need to modify the document before saving.

```js
const student = new Student({ rollNumber: 'BCA-102', fullName: 'Priya Shah' });
student.marks = 85;
student.subjects.push('Database Systems');
await student.save();
```

`.save()` also **updates** an existing document if it was loaded from the DB:

```js
const student = await Student.findById(id);
student.marks = 92;
await student.save();   // UPDATE, not insert — runs all hooks and validators
```

#### `Model.insertMany([docs])`

Bulk insert. Much faster than looping `create()` because it issues a single DB command.

```js
const result = await Student.insertMany(
  [{ ... }, { ... }, { ... }],
  { ordered: false }   // continue past failures instead of stopping
);
```

| Runs validators | Runs `save` hooks | Speed |
|---|---|---|
| ✅ Yes | ❌ **No** | Very fast |

> `ordered: false` is important for seeding — one duplicate won't abort the entire batch.

---

### 11.2 READ methods

#### `Model.find(filter)`

Returns an **array** — empty `[]` if nothing matches (never `null`).

```js
await Student.find();                                 // all documents
await Student.find({ course: 'BCA' });                // filtered
await Student.find({ age: { $gte: 18, $lte: 25 } });  // range
await Student.find({ course: { $in: ['BCA', 'MCA'] } });
await Student.find({ marks: { $gt: 75 }, isActive: true });
```

#### `Model.findOne(filter)`

Returns the **first matching document** or `null`.

```js
const student = await Student.findOne({ email: 'ravi@college.edu' });
if (!student) throw new ApiError(404, 'Not found');
```

#### `Model.findById(id)`

Shorthand for `findOne({ _id: id })`. Returns a document or `null`.

```js
const student = await Student.findById('65f1a2b3c4d5e6f7a8b9c0d1');
```

> Throws a `CastError` if `id` isn't a valid 24-character hex ObjectId. Always guard with `mongoose.Types.ObjectId.isValid(id)`.

#### `Model.countDocuments(filter)`

```js
const total  = await Student.countDocuments();
const bcaCnt = await Student.countDocuments({ course: 'BCA' });
```

#### `Model.distinct(field)`

```js
const courses = await Student.distinct('course');
// → ['BCA', 'MCA', 'BTech']
```

#### `Model.exists(filter)`

Cheaper than `findOne` when you only need a yes/no.

```js
const found = await Student.exists({ email: 'ravi@college.edu' });
// → { _id: ... }  or  null
```

---

### 11.3 Query chaining methods

These build the query; nothing executes until you `await` it.

| Method | Purpose | Example |
|---|---|---|
| `.select()` | Choose fields | `.select('fullName email -_id')` |
| `.sort()` | Order results | `.sort('-marks fullName')` |
| `.skip()` | Offset | `.skip(20)` |
| `.limit()` | Cap results | `.limit(10)` |
| `.where()` | Fluent filter | `.where('age').gte(18)` |
| `.populate()` | Join referenced docs | `.populate('department', 'name')` |
| `.lean()` | Return plain JS objects | `.lean()` |
| `.exec()` | Explicitly execute | `.exec()` |

```js
const students = await Student
  .find({ course: 'BCA' })
  .select('fullName rollNumber marks')
  .sort({ marks: -1 })      // -1 descending, 1 ascending
  .skip(0)
  .limit(10)
  .lean();
```

#### `.select()` syntax

```js
.select('fullName email')     // include ONLY these (+ _id)
.select('-password -__v')     // exclude these
.select('fullName -_id')      // include fullName, exclude _id
.select('+password')          // force-include a select:false field
```

> You cannot mix inclusion and exclusion, except for `-_id`.

#### `.sort()` syntax

```js
.sort('marks')        // ascending
.sort('-marks')       // descending
.sort('-marks name')  // marks desc, then name asc
.sort({ marks: -1, fullName: 1 })  // object form
```

#### `.lean()` — the performance switch

```js
const docs = await Student.find().lean();
```

| | Normal | `.lean()` |
|---|---|---|
| Returns | Mongoose Documents | Plain JS objects |
| Has `.save()`, virtuals, getters | ✅ | ❌ (unless `lean({ virtuals: true })` with a plugin) |
| Memory & speed | Slower | **Up to 5× faster** |

Use `.lean()` for read-only endpoints. Do **not** use it if you plan to call `.save()` on the result.

#### `.populate()` — joining collections

Given a reference:

```js
department: { type: mongoose.Schema.Types.ObjectId, ref: 'Department' }
```

```js
// Basic
await Student.find().populate('department');

// Select specific fields from the joined doc
await Student.find().populate('department', 'name code');

// Full options object
await Student.find().populate({
  path: 'department',
  select: 'name code',
  match: { isActive: true },
  options: { sort: { name: 1 } },
});

// Nested populate
await Student.find().populate({
  path: 'department',
  populate: { path: 'head', select: 'fullName' },
});
```

---

### 11.4 UPDATE methods

#### `Model.findByIdAndUpdate(id, update, options)`

The most commonly used update. Finds, updates, and returns in one round trip.

```js
const student = await Student.findByIdAndUpdate(
  id,
  { $set: { marks: 95, semester: 5 } },
  { new: true, runValidators: true }
);
```

**Critical options:**

| Option | Default | Effect |
|---|---|---|
| `new` | `false` | `true` returns the **updated** doc; `false` returns the **original** |
| `runValidators` | `false` | `true` enforces schema validators |
| `upsert` | `false` | `true` creates the doc if it doesn't exist |
| `select` | — | Restrict returned fields |
| `context: 'query'` | — | Needed for custom validators to see the update |

> ⚠️ **The two most common bugs:** forgetting `new: true` (you get the stale document back) and forgetting `runValidators: true` (invalid data silently saves).

#### `Model.findOneAndUpdate(filter, update, options)`

Same as above but with an arbitrary filter.

```js
await Student.findOneAndUpdate(
  { rollNumber: 'BCA-101' },
  { $inc: { marks: 5 } },
  { new: true }
);
```

#### `Model.updateOne(filter, update)`

Updates the first match. Returns a **result summary**, not the document.

```js
const result = await Student.updateOne(
  { _id: id },
  { $set: { isActive: false } }
);
// → { acknowledged: true, matchedCount: 1, modifiedCount: 1, upsertedId: null }
```

#### `Model.updateMany(filter, update)`

```js
const result = await Student.updateMany(
  { course: 'BCA', semester: 4 },
  { $inc: { semester: 1 } }
);
console.log(`${result.modifiedCount} students promoted`);
```

#### `document.save()` for updates

```js
const student = await Student.findById(id);
student.marks = 95;
await student.save();
```

| Approach | `pre('save')` hooks | Validators | Round trips |
|---|---|---|---|
| `findByIdAndUpdate` | ❌ Skipped | Only with `runValidators` | 1 |
| `find` + `save` | ✅ Run | ✅ Always | 2 |

> If your schema has `pre('save')` hooks doing important work (hashing, formatting), use find + save.

#### MongoDB update operators

| Operator | Purpose | Example |
|---|---|---|
| `$set` | Set field value | `{ $set: { marks: 90 } }` |
| `$unset` | Remove field | `{ $unset: { tempNote: '' } }` |
| `$inc` | Increment/decrement | `{ $inc: { marks: 5, semester: 1 } }` |
| `$mul` | Multiply | `{ $mul: { marks: 1.1 } }` |
| `$min` / `$max` | Update only if smaller/larger | `{ $max: { highScore: 95 } }` |
| `$rename` | Rename a field | `{ $rename: { name: 'fullName' } }` |
| `$push` | Append to array | `{ $push: { subjects: 'AI' } }` |
| `$addToSet` | Append only if absent | `{ $addToSet: { subjects: 'AI' } }` |
| `$pull` | Remove matching array items | `{ $pull: { subjects: 'AI' } }` |
| `$pop` | Remove first (`-1`) or last (`1`) | `{ $pop: { subjects: 1 } }` |
| `$each` | Push multiple | `{ $push: { subjects: { $each: ['AI','ML'] } } }` |

---

### 11.5 DELETE methods

#### `Model.findByIdAndDelete(id)`

Deletes and returns the deleted document (or `null`).

```js
const deleted = await Student.findByIdAndDelete(id);
if (!deleted) throw new ApiError(404, 'Student not found');
```

#### `Model.findOneAndDelete(filter)`

```js
const deleted = await Student.findOneAndDelete({ rollNumber: 'BCA-101' });
```

#### `Model.deleteOne(filter)`

Returns a summary, not the document.

```js
const result = await Student.deleteOne({ _id: id });
// → { acknowledged: true, deletedCount: 1 }
```

#### `Model.deleteMany(filter)`

```js
await Student.deleteMany({ course: 'BCA' });  // scoped
await Student.deleteMany({});                 // ⚠️ DELETES EVERYTHING
```

#### `document.deleteOne()`

```js
const student = await Student.findById(id);
await student.deleteOne();
```

### Delete method comparison

| Method | Returns | Use when |
|---|---|---|
| `findByIdAndDelete` | Deleted doc or `null` | You need the deleted data (logging, response) |
| `findOneAndDelete` | Deleted doc or `null` | Deleting by a non-`_id` field |
| `deleteOne` | `{ deletedCount }` | You only need confirmation |
| `deleteMany` | `{ deletedCount }` | Bulk removal |

### Soft delete — the safer pattern

Instead of destroying data, flag it:

```js
// "Delete"
await Student.findByIdAndUpdate(id, {
  $set: { isActive: false, deletedAt: new Date() },
});

// All read queries then filter it out
await Student.find({ isActive: true });
```

This preserves audit history and makes recovery trivial.

---

### 11.6 Query operators reference

**Comparison**

| Operator | Meaning | Example |
|---|---|---|
| `$eq` | Equals | `{ age: { $eq: 20 } }` |
| `$ne` | Not equals | `{ course: { $ne: 'BCA' } }` |
| `$gt` / `$gte` | Greater than / or equal | `{ marks: { $gte: 40 } }` |
| `$lt` / `$lte` | Less than / or equal | `{ age: { $lt: 25 } }` |
| `$in` | Matches any in array | `{ course: { $in: ['BCA','MCA'] } }` |
| `$nin` | Matches none in array | `{ course: { $nin: ['MBA'] } }` |

**Logical**

```js
// AND (implicit)
{ course: 'BCA', semester: 3 }

// AND (explicit)
{ $and: [{ marks: { $gte: 60 } }, { marks: { $lte: 90 } }] }

// OR
{ $or: [{ course: 'BCA' }, { marks: { $gt: 90 } }] }

// NOR — matches neither
{ $nor: [{ course: 'BCA' }, { semester: 1 }] }

// NOT
{ marks: { $not: { $lt: 40 } } }
```

**Element & evaluation**

| Operator | Purpose | Example |
|---|---|---|
| `$exists` | Field present? | `{ phone: { $exists: true } }` |
| `$type` | BSON type check | `{ marks: { $type: 'number' } }` |
| `$regex` | Pattern match | `{ fullName: { $regex: 'rav', $options: 'i' } }` |
| `$text` | Full-text search | `{ $text: { $search: 'ravi patel' } }` |
| `$expr` | Compare two fields | `{ $expr: { $gt: ['$marks', '$passMark'] } }` |

**Array**

```js
{ subjects: 'AI' }                        // array contains 'AI'
{ subjects: { $all: ['AI', 'ML'] } }      // contains both
{ subjects: { $size: 3 } }                // exactly 3 elements
{ subjects: { $elemMatch: { $eq: 'AI' } } }
```

---

### 11.7 Aggregation pipeline

For grouping, computing, and reshaping data the query API can't handle.

```js
const result = await Student.aggregate([
  { $match: { isActive: true } },                    // filter (use indexes — put first)
  { $group: {                                        // group & compute
      _id: '$course',
      count: { $sum: 1 },
      avgMarks: { $avg: '$marks' },
      maxMarks: { $max: '$marks' },
      names: { $push: '$fullName' },
  }},
  { $project: {                                      // reshape output
      _id: 0,
      course: '$_id',
      count: 1,
      avgMarks: { $round: ['$avgMarks', 2] },
  }},
  { $sort: { count: -1 } },                          // order
  { $limit: 5 },                                     // cap
]);
```

**Common stages**

| Stage | Purpose |
|---|---|
| `$match` | Filter documents (equivalent to `find`) |
| `$group` | Group by a key and compute aggregates |
| `$project` | Include/exclude/compute fields |
| `$sort` | Order documents |
| `$limit` / `$skip` | Pagination |
| `$lookup` | Left outer join to another collection |
| `$unwind` | Deconstruct an array into one doc per element |
| `$count` | Count documents in the pipeline |
| `$addFields` | Add computed fields, keeping existing ones |
| `$facet` | Run multiple sub-pipelines at once |

**Accumulators for `$group`:** `$sum`, `$avg`, `$min`, `$max`, `$first`, `$last`, `$push`, `$addToSet`.

---

### 11.8 Schema hooks (middleware)

```js
// Runs before .save() and before .create()
schema.pre('save', function (next) {
  console.log('about to save', this.rollNumber);
  next();
});

// Runs after
schema.post('save', function (doc, next) { next(); });

// Query middleware — 'this' is the QUERY, not the document
schema.pre('find', function (next) {
  this.where({ isActive: true });   // auto-filter every find()
  next();
});

schema.pre('findOneAndUpdate', function (next) {
  this.set({ updatedAt: new Date() });
  next();
});

// Aggregate middleware
schema.pre('aggregate', function (next) {
  this.pipeline().unshift({ $match: { isActive: true } });
  next();
});
```

> `this` refers to the **document** in `save` hooks but the **query** in `find`/`update` hooks. Never use arrow functions in hooks — they break `this` binding.

---

### 11.9 Method cheat sheet

| Goal | Method |
|---|---|
| Insert one | `Model.create()` |
| Insert many | `Model.insertMany()` |
| Get all | `Model.find()` |
| Get one by ID | `Model.findById()` |
| Get one by field | `Model.findOne()` |
| Count | `Model.countDocuments()` |
| Update + get new doc | `Model.findByIdAndUpdate(id, u, { new: true })` |
| Update, don't need doc | `Model.updateOne()` |
| Update many | `Model.updateMany()` |
| Delete + get deleted doc | `Model.findByIdAndDelete()` |
| Delete, don't need doc | `Model.deleteOne()` |
| Delete many | `Model.deleteMany()` |
| Group / compute | `Model.aggregate()` |
| Unique values | `Model.distinct()` |

---

## 12. VIEW — React Frontend

```bash
cd student-management
npm create vite@latest frontend -- --template react
cd frontend
npm install axios react-router-dom
```

**`frontend/.env`**

```env
VITE_API_URL=http://localhost:8000/api/v1
```

---

### `frontend/src/api/studentApi.js`

```js
import axios from 'axios';

const api = axios.create({
  baseURL: import.meta.env.VITE_API_URL,
  headers: { 'Content-Type': 'application/json' },
  timeout: 10000,
});

/* Normalise every error into a plain message string */
api.interceptors.response.use(
  (response) => response,
  (error) => {
    const message =
      error.response?.data?.message ||
      error.message ||
      'Something went wrong';
    return Promise.reject(new Error(message));
  }
);

/* ---------- 1) GET ALL STUDENTS ---------- */
export const getAllStudents = async (params = {}) => {
  const { data } = await api.get('/students', { params });
  return data.data; // { students, pagination }
};

/* ---------- 2) GET ONE STUDENT ---------- */
export const getStudentById = async (id) => {
  const { data } = await api.get(`/students/${id}`);
  return data.data;
};

/* ---------- 3) ADD STUDENT ---------- */
export const addStudent = async (studentData) => {
  const { data } = await api.post('/students', studentData);
  return data.data;
};

/* ---------- 4) DELETE ONE STUDENT ---------- */
export const deleteStudent = async (id) => {
  const { data } = await api.delete(`/students/${id}`);
  return data.data;
};

/* ---------- 5) DELETE ALL STUDENTS ---------- */
export const deleteAllStudents = async () => {
  const { data } = await api.delete('/students', {
    params: { confirm: 'true' },
  });
  return data.data;
};

/* ---------- 6) UPDATE STUDENT ---------- */
export const updateStudent = async (id, updates) => {
  const { data } = await api.patch(`/students/${id}`, updates);
  return data.data;
};

/* ---------- BONUS: STATS ---------- */
export const getStudentStats = async () => {
  const { data } = await api.get('/students/stats');
  return data.data;
};

export default api;
```

---

### `frontend/src/components/StudentList.jsx`

```jsx
import { useState, useEffect, useCallback } from 'react';
import { Link } from 'react-router-dom';
import {
  getAllStudents,
  deleteStudent,
  deleteAllStudents,
} from '../api/studentApi';

export default function StudentList() {
  const [students, setStudents]   = useState([]);
  const [pagination, setPagination] = useState({});
  const [loading, setLoading]     = useState(true);
  const [error, setError]         = useState('');
  const [search, setSearch]       = useState('');
  const [course, setCourse]       = useState('');
  const [page, setPage]           = useState(1);

  /* ---- 1) GET ALL ---- */
  const fetchStudents = useCallback(async () => {
    setLoading(true);
    setError('');
    try {
      const data = await getAllStudents({ page, limit: 10, search, course });
      setStudents(data.students);
      setPagination(data.pagination);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  }, [page, search, course]);

  useEffect(() => {
    const timer = setTimeout(fetchStudents, 300); // debounce typing
    return () => clearTimeout(timer);
  }, [fetchStudents]);

  /* ---- 4) DELETE ONE ---- */
  const handleDelete = async (id, name) => {
    if (!window.confirm(`Delete ${name}?`)) return;
    try {
      await deleteStudent(id);
      fetchStudents();
    } catch (err) {
      alert(err.message);
    }
  };

  /* ---- 5) DELETE ALL ---- */
  const handleDeleteAll = async () => {
    if (!window.confirm('Delete ALL students? This cannot be undone.')) return;
    try {
      const result = await deleteAllStudents();
      alert(`${result.deletedCount} students deleted`);
      setPage(1);
      fetchStudents();
    } catch (err) {
      alert(err.message);
    }
  };

  return (
    <div style={{ padding: 24, fontFamily: 'system-ui' }}>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
        <h2>Students ({pagination.totalStudents ?? 0})</h2>
        <div>
          <Link to="/add">
            <button style={{ marginRight: 8 }}>+ Add Student</button>
          </Link>
          <button onClick={handleDeleteAll} style={{ color: '#c0392b' }}>
            Delete All
          </button>
        </div>
      </div>

      {/* Filters */}
      <div style={{ margin: '16px 0', display: 'flex', gap: 8 }}>
        <input
          value={search}
          onChange={(e) => { setPage(1); setSearch(e.target.value); }}
          placeholder="Search name, email or roll no…"
          style={{ padding: 8, flex: 1 }}
        />
        <select
          value={course}
          onChange={(e) => { setPage(1); setCourse(e.target.value); }}
          style={{ padding: 8 }}
        >
          <option value="">All Courses</option>
          {['BCA', 'MCA', 'BSc-IT', 'BTech', 'MTech', 'BBA', 'MBA'].map((c) => (
            <option key={c} value={c}>{c}</option>
          ))}
        </select>
      </div>

      {error && <p style={{ color: '#c0392b' }}>⚠️ {error}</p>}
      {loading && <p>Loading…</p>}

      {!loading && students.length === 0 && <p>No students found.</p>}

      {!loading && students.length > 0 && (
        <table width="100%" cellPadding="10" style={{ borderCollapse: 'collapse' }}>
          <thead>
            <tr style={{ background: '#f5f5f5', textAlign: 'left' }}>
              <th>Roll No</th><th>Name</th><th>Email</th>
              <th>Course</th><th>Sem</th><th>Marks</th><th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {students.map((s) => (
              <tr key={s._id} style={{ borderBottom: '1px solid #eee' }}>
                <td>{s.rollNumber}</td>
                <td>{s.fullName}</td>
                <td>{s.email}</td>
                <td>{s.course}</td>
                <td>{s.semester}</td>
                <td>{s.marks}</td>
                <td style={{ whiteSpace: 'nowrap' }}>
                  <Link to={`/view/${s._id}`}><button>View</button></Link>{' '}
                  <Link to={`/edit/${s._id}`}><button>Edit</button></Link>{' '}
                  <button
                    onClick={() => handleDelete(s._id, s.fullName)}
                    style={{ color: '#c0392b' }}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}

      {/* Pagination */}
      {pagination.totalPages > 1 && (
        <div style={{ marginTop: 16, display: 'flex', gap: 12, alignItems: 'center' }}>
          <button disabled={!pagination.hasPrevPage} onClick={() => setPage((p) => p - 1)}>
            ← Previous
          </button>
          <span>Page {pagination.currentPage} of {pagination.totalPages}</span>
          <button disabled={!pagination.hasNextPage} onClick={() => setPage((p) => p + 1)}>
            Next →
          </button>
        </div>
      )}
    </div>
  );
}
```

---

### `frontend/src/components/StudentForm.jsx`

Handles both **Add (3)** and **Update (6)**.

```jsx
import { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { addStudent, getStudentById, updateStudent } from '../api/studentApi';

const EMPTY = {
  rollNumber: '', fullName: '', email: '', phone: '',
  age: '', gender: '', course: '', semester: '', marks: '',
  address: { city: '', state: 'Gujarat', pincode: '' },
};

export default function StudentForm() {
  const { id } = useParams();
  const isEdit = Boolean(id);
  const navigate = useNavigate();

  const [form, setForm]       = useState(EMPTY);
  const [error, setError]     = useState('');
  const [saving, setSaving]   = useState(false);
  const [loading, setLoading] = useState(isEdit);

  /* ---- 2) GET ONE (prefill on edit) ---- */
  useEffect(() => {
    if (!isEdit) return;
    (async () => {
      try {
        const data = await getStudentById(id);
        setForm({ ...EMPTY, ...data, address: { ...EMPTY.address, ...data.address } });
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    })();
  }, [id, isEdit]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    if (name.startsWith('address.')) {
      const key = name.split('.')[1];
      setForm((f) => ({ ...f, address: { ...f.address, [key]: value } }));
    } else {
      setForm((f) => ({ ...f, [name]: value }));
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError('');
    setSaving(true);

    const payload = {
      ...form,
      age: Number(form.age),
      semester: Number(form.semester),
      marks: Number(form.marks || 0),
    };

    try {
      if (isEdit) {
        delete payload.rollNumber; // roll number is immutable
        await updateStudent(id, payload);   // ---- 6) UPDATE ----
      } else {
        await addStudent(payload);          // ---- 3) ADD ----
      }
      navigate('/');
    } catch (err) {
      setError(err.message);
    } finally {
      setSaving(false);
    }
  };

  if (loading) return <p style={{ padding: 24 }}>Loading…</p>;

  const input = { width: '100%', padding: 8, marginBottom: 12 };

  return (
    <div style={{ maxWidth: 520, margin: '32px auto', fontFamily: 'system-ui' }}>
      <h2>{isEdit ? 'Edit Student' : 'Add Student'}</h2>
      {error && <p style={{ color: '#c0392b' }}>⚠️ {error}</p>}

      <form onSubmit={handleSubmit}>
        <input
          name="rollNumber" value={form.rollNumber} onChange={handleChange}
          placeholder="Roll Number (e.g. BCA-101)" required
          disabled={isEdit} style={input}
        />
        <input
          name="fullName" value={form.fullName} onChange={handleChange}
          placeholder="Full Name" required minLength={3} style={input}
        />
        <input
          name="email" type="email" value={form.email} onChange={handleChange}
          placeholder="Email" required style={input}
        />
        <input
          name="phone" value={form.phone} onChange={handleChange}
          placeholder="Phone (10 digits)" required pattern="[6-9][0-9]{9}" style={input}
        />
        <input
          name="age" type="number" value={form.age} onChange={handleChange}
          placeholder="Age" required min={15} max={60} style={input}
        />

        <select name="gender" value={form.gender} onChange={handleChange} required style={input}>
          <option value="">Select Gender</option>
          <option value="male">Male</option>
          <option value="female">Female</option>
          <option value="other">Other</option>
        </select>

        <select name="course" value={form.course} onChange={handleChange} required style={input}>
          <option value="">Select Course</option>
          {['BCA', 'MCA', 'BSc-IT', 'BTech', 'MTech', 'BBA', 'MBA'].map((c) => (
            <option key={c} value={c}>{c}</option>
          ))}
        </select>

        <input
          name="semester" type="number" value={form.semester} onChange={handleChange}
          placeholder="Semester (1-8)" required min={1} max={8} style={input}
        />
        <input
          name="marks" type="number" value={form.marks} onChange={handleChange}
          placeholder="Marks (0-100)" min={0} max={100} style={input}
        />

        <input
          name="address.city" value={form.address.city} onChange={handleChange}
          placeholder="City" style={input}
        />
        <input
          name="address.pincode" value={form.address.pincode} onChange={handleChange}
          placeholder="Pincode (6 digits)" pattern="[0-9]{6}" style={input}
        />

        <button type="submit" disabled={saving} style={{ padding: 10, marginRight: 8 }}>
          {saving ? 'Saving…' : isEdit ? 'Update Student' : 'Add Student'}
        </button>
        <button type="button" onClick={() => navigate('/')} style={{ padding: 10 }}>
          Cancel
        </button>
      </form>
    </div>
  );
}
```

---

### `frontend/src/components/StudentDetail.jsx`

```jsx
import { useState, useEffect } from 'react';
import { useParams, Link } from 'react-router-dom';
import { getStudentById } from '../api/studentApi';

export default function StudentDetail() {
  const { id } = useParams();
  const [student, setStudent] = useState(null);
  const [error, setError]     = useState('');
  const [loading, setLoading] = useState(true);

  /* ---- 2) GET ONE STUDENT ---- */
  useEffect(() => {
    (async () => {
      try {
        setStudent(await getStudentById(id));
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    })();
  }, [id]);

  if (loading) return <p style={{ padding: 24 }}>Loading…</p>;
  if (error)   return <p style={{ padding: 24, color: '#c0392b' }}>⚠️ {error}</p>;

  const Row = ({ label, value }) => (
    <tr style={{ borderBottom: '1px solid #eee' }}>
      <td style={{ padding: 8, fontWeight: 600, width: 160 }}>{label}</td>
      <td style={{ padding: 8 }}>{value ?? '—'}</td>
    </tr>
  );

  return (
    <div style={{ maxWidth: 560, margin: '32px auto', fontFamily: 'system-ui' }}>
      <h2>{student.fullName}</h2>
      <table width="100%" style={{ borderCollapse: 'collapse' }}>
        <tbody>
          <Row label="Roll Number" value={student.rollNumber} />
          <Row label="Email"       value={student.email} />
          <Row label="Phone"       value={student.phone} />
          <Row label="Age"         value={student.age} />
          <Row label="Gender"      value={student.gender} />
          <Row label="Course"      value={student.course} />
          <Row label="Semester"    value={student.semester} />
          <Row label="Marks"       value={student.marks} />
          <Row label="Grade"       value={student.grade} />
          <Row
            label="City"
            value={student.address?.city}
          />
          <Row
            label="Admission"
            value={new Date(student.admissionDate).toLocaleDateString('en-IN')}
          />
        </tbody>
      </table>

      <div style={{ marginTop: 16 }}>
        <Link to={`/edit/${student._id}`}><button>Edit</button></Link>{' '}
        <Link to="/"><button>Back to List</button></Link>
      </div>
    </div>
  );
}
```

---

### `frontend/src/App.jsx`

```jsx
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import StudentList from './components/StudentList';
import StudentForm from './components/StudentForm';
import StudentDetail from './components/StudentDetail';

export default function App() {
  return (
    <BrowserRouter>
      <nav style={{ padding: 16, borderBottom: '1px solid #ddd', fontFamily: 'system-ui' }}>
        <Link to="/" style={{ marginRight: 16, fontWeight: 600 }}>
          🎓 Student Management
        </Link>
        <Link to="/add">Add Student</Link>
      </nav>

      <Routes>
        <Route path="/"          element={<StudentList />} />
        <Route path="/add"       element={<StudentForm />} />
        <Route path="/edit/:id"  element={<StudentForm />} />
        <Route path="/view/:id"  element={<StudentDetail />} />
        <Route path="*"          element={<h2 style={{ padding: 24 }}>404 — Page not found</h2>} />
      </Routes>
    </BrowserRouter>
  );
}
```

**`frontend/src/main.jsx`**

```jsx
import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App.jsx';
import './index.css';

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
```

---

## 13. API Testing

### 3) Add a student

```bash
curl -X POST http://localhost:8000/api/v1/students \
  -H "Content-Type: application/json" \
  -d '{
    "rollNumber": "BCA-101",
    "fullName": "ravi patel",
    "email": "ravi@college.edu",
    "phone": "9876543210",
    "age": 20,
    "gender": "male",
    "course": "BCA",
    "semester": 3,
    "marks": 85,
    "address": { "city": "Morvi", "state": "Gujarat", "pincode": "363641" }
  }'
```

Response (note `fullName` was title-cased by the `pre('save')` hook):

```json
{
  "statusCode": 201,
  "data": {
    "_id": "65f1a2b3c4d5e6f7a8b9c0d1",
    "rollNumber": "BCA-101",
    "fullName": "Ravi Patel",
    "email": "ravi@college.edu",
    "marks": 85,
    "grade": "A",
    "createdAt": "2026-09-18T10:30:00.000Z"
  },
  "message": "Student added successfully",
  "success": true
}
```

### 1) Get all students

```bash
curl "http://localhost:8000/api/v1/students?page=1&limit=10&course=BCA&search=ravi"
```

### 2) Get one student

```bash
curl http://localhost:8000/api/v1/students/65f1a2b3c4d5e6f7a8b9c0d1
```

### 6) Update a student

```bash
curl -X PATCH http://localhost:8000/api/v1/students/65f1a2b3c4d5e6f7a8b9c0d1 \
  -H "Content-Type: application/json" \
  -d '{ "marks": 95, "semester": 4 }'
```

### 4) Delete one student

```bash
curl -X DELETE http://localhost:8000/api/v1/students/65f1a2b3c4d5e6f7a8b9c0d1
```

### 5) Delete all students

```bash
# Without confirmation → 400
curl -X DELETE http://localhost:8000/api/v1/students

# With confirmation → 200
curl -X DELETE "http://localhost:8000/api/v1/students?confirm=true"
```

### Statistics

```bash
curl http://localhost:8000/api/v1/students/stats
```

---

## 14. Common Errors & Fixes

| Error | Cause | Fix |
|---|---|---|
| `MongooseServerSelectionError` | MongoDB not running, or IPv6 resolution | Start `mongod`; use `127.0.0.1` not `localhost` |
| `E11000 duplicate key error` | `unique: true` violated | Catch `err.code === 11000`, return 409 |
| `CastError: Cast to ObjectId failed` | Malformed `:id` | Guard with `mongoose.Types.ObjectId.isValid(id)` |
| `ValidationError` | Schema rules broken | Return 400 with `Object.values(err.errors).map(e => e.message)` |
| `req.body is undefined` | Missing body parser | Add `app.use(express.json())` **before** routes |
| CORS blocked in browser | Origin not allowed | `app.use(cors({ origin: 'http://localhost:5173' }))` |
| `Cannot use import outside a module` | ESM not enabled | Add `"type": "module"` to `package.json` |
| Update returns the OLD document | Missing option | Add `{ new: true }` |
| Invalid data saved on update | Validators skipped | Add `{ runValidators: true }` |
| `pre('save')` hook never fires | Used `findByIdAndUpdate` | Use `findById()` + `.save()` instead |
| `process.env.X` is `undefined` | `dotenv.config()` called too late | Make it the very first line of `server.js` |
| `/stats` returns "Invalid ID" | Route order | Define `/stats` **before** `/:id` |

---

## Quick Start

```bash
# Terminal 1 — Backend
cd backend
npm install
npm run dev          # → http://localhost:8000

# Terminal 2 — Frontend
cd frontend
npm install
npm run dev          # → http://localhost:5173
```

---

## Summary

```
┌──────────────────────────────────────────────────────────────────┐
│  MODEL       models/student.model.js                             │
│              Schema · validators · hooks · virtuals · indexes    │
├──────────────────────────────────────────────────────────────────┤
│  VIEW        frontend/src/components/                            │
│              StudentList · StudentForm · StudentDetail           │
├──────────────────────────────────────────────────────────────────┤
│  CONTROLLER  controllers/student.controller.js                   │
│              6 handlers: getAll · getOne · create · update       │
│                          · deleteOne · deleteAll                 │
├──────────────────────────────────────────────────────────────────┤
│  ROUTE       routes/student.routes.js                            │
│              URL → controller mapping only                       │
├──────────────────────────────────────────────────────────────────┤
│  MIDDLEWARE  middlewares/                                        │
│              validate · logger · error handler                   │
├──────────────────────────────────────────────────────────────────┤
│  CONFIG      .env · config/db.js                                 │
└──────────────────────────────────────────────────────────────────┘
```

*Built with the MERN stack: MongoDB · Express · React · Node.js*
