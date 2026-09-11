// routes/student.routes.js
// -----------------------------------------------------------------------------
// The Router layer (the "glue" of MVC) — maps HTTP method + URL path pairs
// to controller functions. This file has ZERO business logic; it only wires
// endpoints to their handlers. Using express.Router() lets us keep this
// separate from app.js and mount it under a common prefix ("/api/students").
// -----------------------------------------------------------------------------

const express = require("express");
const router = express.Router();

const {
  insertOneStudent,
  insertManyStudents,
  getAllStudents,
  getOneStudent,
  updateStudent,
  deleteOneStudent,
  deleteAllStudents,
} = require("../controllers/student.controller");

// -----------------------------------------------------------------------------
// IMPORTANT: Order matters in Express routing.
// "/bulk" (a static path) MUST be declared BEFORE "/:id" (a dynamic path).
// Otherwise Express would treat the literal word "bulk" as an :id value.
// -----------------------------------------------------------------------------

// POST   /api/students/bulk      -> InsertManyStudent()
router.post("/bulk", insertManyStudents);

// POST   /api/students           -> InsertOneStudent()
router.post("/", insertOneStudent);

// GET    /api/students           -> GetAllStudent()
router.get("/", getAllStudents);

// GET    /api/students/:id       -> GetOneStudent()
router.get("/:id", getOneStudent);

// PUT    /api/students/:id       -> UpdateStudent()
router.put("/:id", updateStudent);

// DELETE /api/students           -> DeleteAllStudent()
router.delete("/", deleteAllStudents);

// DELETE /api/students/:id       -> DeleteOneStudent()
router.delete("/:id", deleteOneStudent);

module.exports = router;
