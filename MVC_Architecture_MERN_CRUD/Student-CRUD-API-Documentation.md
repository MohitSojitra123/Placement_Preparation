# Student Database CRUD API — Full Documentation
### Express.js · Node.js · Mongoose · bcrypt · MVC Architecture

---

## 1. Overview

This document describes a complete **CRUD (Create, Read, Update, Delete) REST API** for managing a **Student Database**, built with:

| Technology | Purpose |
|---|---|
| **Node.js** | JavaScript runtime that executes the server |
| **Express.js** | Web framework used to build REST routes/middleware |
| **Mongoose** | ODM (Object Data Modeling) library for MongoDB — defines schemas & handles queries |
| **bcrypt** | Hashes student passwords before storing them (never store plain-text passwords) |
| **MVC Architecture** | Separates the app into **Model** (data/schema), **View** (JSON response, since this is an API), and **Controller** (business logic) |

The API implements **7 core operations**:

1. `InsertOneStudent()` — Create a single student
2. `InsertManyStudent()` — Bulk-create multiple students
3. `GetAllStudent()` — Fetch all students
4. `GetOneStudent()` — Fetch a single student by ID
5. `UpdateStudent()` — Update a student's details
6. `DeleteOneStudent()` — Delete a single student
7. `DeleteAllStudent()` — Delete all students

---

## 2. Why MVC Architecture?

MVC keeps code **organized, testable, and scalable** — a common interview topic.

```
Client Request
      │
      ▼
   Router (defines the URL + HTTP verb, points to a Controller function)
      │
      ▼
 Controller (business logic: validation, calling the Model, formatting response)
      │
      ▼
   Model (Mongoose schema — talks directly to MongoDB)
      │
      ▼
   MongoDB (actual data storage)
      │
      ▼
 Controller sends JSON response back to Client
```

**Interview Talking Point:** MVC decouples *how data is shaped* (Model) from *how it is processed* (Controller) from *how it's exposed* (Router). This means you can change the database, the validation logic, or the API routes independently without breaking the others — a key example of **separation of concerns**.

---

## 3. Project Folder Structure

```
student-crud-api/
│
├── config/
│   └── db.js                 # MongoDB connection logic
│
├── models/
│   └── Student.js             # Mongoose Schema + Model (with bcrypt hook)
│
├── controllers/
│   └── studentController.js   # All business logic (the 7 CRUD functions)
│
├── routes/
│   └── studentRoutes.js       # Express Router — maps URLs to controllers
│
├── .env                        # Environment variables (DB URI, PORT)
├── server.js                   # Entry point — starts Express app
└── package.json
```

---

## 4. Package Setup

```bash
npm init -y
npm install express mongoose bcrypt dotenv
npm install --save-dev nodemon
```

**package.json** (relevant scripts section)

```json
{
  "name": "student-crud-api",
  "version": "1.0.0",
  "main": "server.js",
  "scripts": {
    "start": "node server.js",
    "dev": "nodemon server.js"
  },
  "dependencies": {
    "bcrypt": "^5.1.1",
    "dotenv": "^16.4.5",
    "express": "^4.19.2",
    "mongoose": "^8.5.0"
  }
}
```

---

## 5. Database Connection — `config/db.js`

```javascript
const mongoose = require("mongoose");

const connectDB = async () => {
  try {
    const conn = await mongoose.connect(process.env.MONGO_URI, {
      // Modern Mongoose (6+) no longer needs useNewUrlParser/useUnifiedTopology,
      // but they're harmless if included for clarity in interviews.
    });
    console.log(`MongoDB Connected: ${conn.connection.host}`);
  } catch (error) {
    console.error(`Error connecting to MongoDB: ${error.message}`);
    process.exit(1); // Exit process with failure
  }
};

module.exports = connectDB;
```

**Explanation:** `mongoose.connect()` returns a Promise. Wrapping it in `try/catch` with `async/await` is the standard modern pattern (avoids callback hell) and ensures the app fails fast (`process.exit(1)`) if the DB is unreachable — a good production practice.

---

## 6. Model (Schema) — `models/Student.js`

```javascript
const mongoose = require("mongoose");
const bcrypt = require("bcrypt");

const studentSchema = new mongoose.Schema(
  {
    name: {
      type: String,
      required: [true, "Student name is required"],
      trim: true,
    },
    email: {
      type: String,
      required: [true, "Email is required"],
      unique: true,
      lowercase: true,
      trim: true,
    },
    password: {
      type: String,
      required: [true, "Password is required"],
      minlength: 6,
      select: false, // Excludes password from query results by default
    },
    rollNumber: {
      type: String,
      required: true,
      unique: true,
    },
    department: {
      type: String,
      required: true,
    },
    age: {
      type: Number,
      min: 15,
      max: 100,
    },
  },
  { timestamps: true } // Adds createdAt & updatedAt automatically
);

// --- Mongoose Pre-save Hook: Hash password before saving ---
studentSchema.pre("save", async function (next) {
  // Only hash the password if it has been modified (or is new)
  if (!this.isModified("password")) return next();

  try {
    const salt = await bcrypt.genSalt(10); // 10 salt rounds — industry standard balance of speed/security
    this.password = await bcrypt.hash(this.password, salt);
    next();
  } catch (error) {
    next(error);
  }
});

// --- Instance method to compare entered password with hashed password ---
studentSchema.methods.comparePassword = async function (enteredPassword) {
  return await bcrypt.compare(enteredPassword, this.password);
};

module.exports = mongoose.model("Student", studentSchema);
```

**Explanation of bcrypt usage:**

| Step | What Happens |
|---|---|
| `bcrypt.genSalt(10)` | Generates a random "salt" — extra random data added to the password before hashing, so two identical passwords never produce the same hash |
| `bcrypt.hash(password, salt)` | Runs the password through a one-way hashing algorithm (Blowfish cipher based) — it **cannot be reversed** back to plain text |
| `pre("save")` hook | A Mongoose **middleware** that automatically runs *before* a document is saved — guarantees passwords are **never** stored as plain text, even if a developer forgets to hash manually elsewhere |
| `comparePassword()` | Used during login — compares plain-text input against the stored hash using `bcrypt.compare()`, which re-hashes the input with the same salt and checks for a match |

**Interview Talking Point:** Why not use MD5/SHA256 for passwords? Because those are *fast* hash algorithms, making them vulnerable to brute-force/rainbow-table attacks. bcrypt is intentionally **slow** and includes **salting**, making brute-forcing computationally expensive.

---

## 7. Controller — `controllers/studentController.js`

This file contains **all 7 CRUD functions**. Each follows the same pattern: `try/catch` → interact with Model → send JSON response with proper HTTP status code.

```javascript
const Student = require("../models/Student");

// ========================================================
// @desc    Create (Insert) a single student
// @route   POST /api/students
// ========================================================
exports.InsertOneStudent = async (req, res) => {
  try {
    const { name, email, password, rollNumber, department, age } = req.body;

    const student = await Student.create({
      name,
      email,
      password,
      rollNumber,
      department,
      age,
    });

    // Remove password from the response object for safety
    const studentResponse = student.toObject();
    delete studentResponse.password;

    res.status(201).json({
      success: true,
      message: "Student created successfully",
      data: studentResponse,
    });
  } catch (error) {
    res.status(400).json({
      success: false,
      message: "Failed to create student",
      error: error.message,
    });
  }
};

// ========================================================
// @desc    Create (Insert) multiple students at once
// @route   POST /api/students/bulk
// ========================================================
exports.InsertManyStudent = async (req, res) => {
  try {
    const studentsArray = req.body; // Expects an array of student objects

    if (!Array.isArray(studentsArray) || studentsArray.length === 0) {
      return res.status(400).json({
        success: false,
        message: "Request body must be a non-empty array of students",
      });
    }

    // NOTE: insertMany() does NOT trigger the pre('save') hook by default,
    // so passwords must be hashed manually before bulk insert.
    const bcrypt = require("bcrypt");
    for (let s of studentsArray) {
      const salt = await bcrypt.genSalt(10);
      s.password = await bcrypt.hash(s.password, salt);
    }

    const students = await Student.insertMany(studentsArray, {
      ordered: false, // Continues inserting remaining docs even if one fails
    });

    res.status(201).json({
      success: true,
      message: `${students.length} students inserted successfully`,
      count: students.length,
    });
  } catch (error) {
    res.status(400).json({
      success: false,
      message: "Failed to insert students in bulk",
      error: error.message,
    });
  }
};

// ========================================================
// @desc    Get all students
// @route   GET /api/students
// ========================================================
exports.GetAllStudent = async (req, res) => {
  try {
    // Basic pagination support via query params: ?page=1&limit=10
    const page = parseInt(req.query.page) || 1;
    const limit = parseInt(req.query.limit) || 10;
    const skip = (page - 1) * limit;

    const students = await Student.find()
      .skip(skip)
      .limit(limit)
      .sort({ createdAt: -1 }); // newest first

    const total = await Student.countDocuments();

    res.status(200).json({
      success: true,
      count: students.length,
      total,
      page,
      totalPages: Math.ceil(total / limit),
      data: students,
    });
  } catch (error) {
    res.status(500).json({
      success: false,
      message: "Failed to fetch students",
      error: error.message,
    });
  }
};

// ========================================================
// @desc    Get a single student by ID
// @route   GET /api/students/:id
// ========================================================
exports.GetOneStudent = async (req, res) => {
  try {
    const student = await Student.findById(req.params.id);

    if (!student) {
      return res.status(404).json({
        success: false,
        message: "Student not found",
      });
    }

    res.status(200).json({
      success: true,
      data: student,
    });
  } catch (error) {
    // Handles malformed MongoDB ObjectId errors gracefully
    res.status(400).json({
      success: false,
      message: "Invalid student ID or fetch error",
      error: error.message,
    });
  }
};

// ========================================================
// @desc    Update a student's details
// @route   PUT /api/students/:id
// ========================================================
exports.UpdateStudent = async (req, res) => {
  try {
    const { password, ...otherFields } = req.body;

    let updateData = { ...otherFields };

    // If password is being updated, hash it manually
    // (findByIdAndUpdate does NOT trigger pre('save') hooks by default)
    if (password) {
      const bcrypt = require("bcrypt");
      const salt = await bcrypt.genSalt(10);
      updateData.password = await bcrypt.hash(password, salt);
    }

    const student = await Student.findByIdAndUpdate(
      req.params.id,
      updateData,
      {
        new: true,          // return the UPDATED document, not the old one
        runValidators: true, // re-run schema validation on update
      }
    );

    if (!student) {
      return res.status(404).json({
        success: false,
        message: "Student not found",
      });
    }

    res.status(200).json({
      success: true,
      message: "Student updated successfully",
      data: student,
    });
  } catch (error) {
    res.status(400).json({
      success: false,
      message: "Failed to update student",
      error: error.message,
    });
  }
};

// ========================================================
// @desc    Delete a single student
// @route   DELETE /api/students/:id
// ========================================================
exports.DeleteOneStudent = async (req, res) => {
  try {
    const student = await Student.findByIdAndDelete(req.params.id);

    if (!student) {
      return res.status(404).json({
        success: false,
        message: "Student not found",
      });
    }

    res.status(200).json({
      success: true,
      message: "Student deleted successfully",
    });
  } catch (error) {
    res.status(400).json({
      success: false,
      message: "Failed to delete student",
      error: error.message,
    });
  }
};

// ========================================================
// @desc    Delete ALL students
// @route   DELETE /api/students
// ========================================================
exports.DeleteAllStudent = async (req, res) => {
  try {
    const result = await Student.deleteMany({});

    res.status(200).json({
      success: true,
      message: `${result.deletedCount} students deleted successfully`,
    });
  } catch (error) {
    res.status(500).json({
      success: false,
      message: "Failed to delete all students",
      error: error.message,
    });
  }
};
```

---

## 8. Router — `routes/studentRoutes.js`

```javascript
const express = require("express");
const router = express.Router();

const {
  InsertOneStudent,
  InsertManyStudent,
  GetAllStudent,
  GetOneStudent,
  UpdateStudent,
  DeleteOneStudent,
  DeleteAllStudent,
} = require("../controllers/studentController");

// ---------- Bulk routes (must be defined BEFORE '/:id' routes) ----------
router.post("/bulk", InsertManyStudent);
router.delete("/", DeleteAllStudent);

// ---------- Standard CRUD routes ----------
router.route("/")
  .get(GetAllStudent)       // GET    /api/students
  .post(InsertOneStudent);  // POST   /api/students

router.route("/:id")
  .get(GetOneStudent)       // GET    /api/students/:id
  .put(UpdateStudent)       // PUT    /api/students/:id
  .delete(DeleteOneStudent); // DELETE /api/students/:id

module.exports = router;
```

**Interview Talking Point:** Route order matters in Express. `/bulk` and the bare `/` DELETE route are defined before `/:id` so Express doesn't mistakenly treat `"bulk"` as an `:id` parameter.

---

## 9. Entry Point — `server.js`

```javascript
require("dotenv").config();
const express = require("express");
const connectDB = require("./config/db");
const studentRoutes = require("./routes/studentRoutes");

const app = express();

// ---------- Connect to MongoDB ----------
connectDB();

// ---------- Middleware ----------
app.use(express.json());               // Parses incoming JSON request bodies
app.use(express.urlencoded({ extended: true }));

// ---------- Routes (Mounting) ----------
app.use("/api/students", studentRoutes);

// ---------- Root health check ----------
app.get("/", (req, res) => {
  res.send("Student CRUD API is running...");
});

// ---------- Global Error Handler (catches anything unhandled) ----------
app.use((err, req, res, next) => {
  console.error(err.stack);
  res.status(500).json({ success: false, message: "Server Error" });
});

const PORT = process.env.PORT || 5000;
app.listen(PORT, () => console.log(`Server running on port ${PORT}`));
```

**.env file:**

```
MONGO_URI=mongodb://127.0.0.1:27017/studentDB
PORT=5000
```

---

## 10. Full API Endpoint Reference

| Function | HTTP Method | Endpoint | Description |
|---|---|---|---|
| `InsertOneStudent()` | `POST` | `/api/students` | Creates one new student (password auto-hashed via pre-save hook) |
| `InsertManyStudent()` | `POST` | `/api/students/bulk` | Bulk inserts an array of students |
| `GetAllStudent()` | `GET` | `/api/students?page=1&limit=10` | Fetches all students with pagination |
| `GetOneStudent()` | `GET` | `/api/students/:id` | Fetches one student by MongoDB `_id` |
| `UpdateStudent()` | `PUT` | `/api/students/:id` | Updates one or more fields of a student |
| `DeleteOneStudent()` | `DELETE` | `/api/students/:id` | Deletes a single student by ID |
| `DeleteAllStudent()` | `DELETE` | `/api/students` | Deletes every student document in the collection |

---

## 11. Sample Request/Response Examples

**Create Student — `POST /api/students`**

Request body:
```json
{
  "name": "Rahul Sharma",
  "email": "rahul@example.com",
  "password": "SecurePass123",
  "rollNumber": "CS101",
  "department": "Computer Science",
  "age": 20
}
```

Response (`201 Created`):
```json
{
  "success": true,
  "message": "Student created successfully",
  "data": {
    "_id": "66f1a2b3c4d5e6f7a8b9c0d1",
    "name": "Rahul Sharma",
    "email": "rahul@example.com",
    "rollNumber": "CS101",
    "department": "Computer Science",
    "age": 20,
    "createdAt": "2026-09-11T10:00:00.000Z",
    "updatedAt": "2026-09-11T10:00:00.000Z"
  }
}
```

*(Note: `password` is deliberately excluded from the response.)*

---

## 12. Full Request Lifecycle (Working Flow)

```
1. Client sends HTTP request
   e.g. POST /api/students  with JSON body
          │
          ▼
2. server.js receives it — Express middleware runs first:
   express.json() parses the body into req.body
          │
          ▼
3. Express matches the URL + method against studentRoutes.js
   (app.use("/api/students", studentRoutes) mounts the router)
          │
          ▼
4. Router forwards the request to the matching Controller function
   (e.g. InsertOneStudent)
          │
          ▼
5. Controller extracts req.body data and calls the Mongoose Model
   Student.create({...})
          │
          ▼
6. Model layer runs schema validation (required fields, types, etc.)
   → Mongoose pre('save') hook fires → bcrypt hashes the password
          │
          ▼
7. Mongoose sends the write operation to MongoDB via the driver
          │
          ▼
8. MongoDB stores the document and returns the saved doc (with _id)
          │
          ▼
9. Controller strips sensitive data (password) and sends
   res.status(201).json({...}) back to the client
          │
          ▼
10. Client receives the JSON response
```

---

## 13. Common Technical Interview Q&A

**Q1: Why use MVC in a Node.js/Express project?**
A: It separates data logic (Model), request handling (Controller), and routing (Router), making the codebase easier to test, scale, and maintain — especially as the number of endpoints grows.

**Q2: Why does the Model use a `pre("save")` hook instead of hashing in the Controller?**
A: Centralizing the hashing logic in the Model guarantees that **any** code path that saves a student (including future features) automatically hashes the password — it can't be forgotten or bypassed.

**Q3: Why does `insertMany()` and `findByIdAndUpdate()` need manual hashing?**
A: Mongoose's `pre("save")` hook only fires on `.save()` (i.e., `Student.create()` for a single new document). Methods like `insertMany()`, `findByIdAndUpdate()`, and `updateOne()` bypass `.save()` for performance, so password hashing must be handled explicitly in those code paths.

**Q4: Why use `select: false` on the password field?**
A: It prevents the password hash from being returned in normal `find()`/`findById()` queries by default, reducing the chance of accidentally leaking it in an API response. It must be explicitly requested with `.select("+password")` when actually needed (e.g., during login).

**Q5: What's the difference between `PUT` and `PATCH`, and why was `PUT` chosen here?**
A: `PUT` conventionally replaces/updates a full resource, while `PATCH` updates partial fields. This API uses `PUT` for simplicity, but since `findByIdAndUpdate` only touches provided fields, it technically behaves like a `PATCH`. In a stricter REST design, `PATCH` would be more semantically correct here.

**Q6: What does `runValidators: true` do in `findByIdAndUpdate`?**
A: By default, Mongoose does NOT run schema validation on update operations. Setting `runValidators: true` forces Mongoose to validate the updated fields against the schema rules (e.g., `minlength`, `required`, `unique`).

**Q7: Why is `ordered: false` used in `insertMany()`?**
A: With `ordered: true` (the default), if one document fails validation, MongoDB stops inserting the rest. Setting it to `false` allows MongoDB to skip the failed document and continue inserting the remaining valid ones — useful for bulk imports.

**Q8: How does bcrypt protect against rainbow table attacks?**
A: Each password gets a unique, randomly generated **salt** before hashing. This means identical passwords produce different hashes, so precomputed rainbow tables (which map common password hashes to plaintext) become ineffective.

**Q9: How would you secure these routes further?**
A: Add authentication middleware (JWT-based), rate limiting (`express-rate-limit`), input sanitization (`express-validator` / `express-mongo-sanitize`), and HTTPS in production.

---

## 14. Testing the API (Postman / cURL)

```bash
# Get all students
curl -X GET http://localhost:5000/api/students

# Get one student
curl -X GET http://localhost:5000/api/students/66f1a2b3c4d5e6f7a8b9c0d1

# Create a student
curl -X POST http://localhost:5000/api/students \
  -H "Content-Type: application/json" \
  -d '{"name":"Rahul Sharma","email":"rahul@example.com","password":"SecurePass123","rollNumber":"CS101","department":"CSE","age":20}'

# Update a student
curl -X PUT http://localhost:5000/api/students/66f1a2b3c4d5e6f7a8b9c0d1 \
  -H "Content-Type: application/json" \
  -d '{"age":21}'

# Delete one student
curl -X DELETE http://localhost:5000/api/students/66f1a2b3c4d5e6f7a8b9c0d1

# Delete all students
curl -X DELETE http://localhost:5000/api/students
```

---

## 15. Summary

This project demonstrates a production-style **Node.js + Express + Mongoose + bcrypt** REST API following **MVC architecture**:

- **Models** define data shape and security rules (password hashing via bcrypt).
- **Controllers** hold all business logic for the 7 CRUD operations.
- **Routers** map clean RESTful URLs to controller functions.
- **server.js** wires everything together and starts the app.

This structure is exactly what interviewers look for: clear separation of concerns, secure password handling, proper HTTP status codes, and predictable RESTful endpoint design.
