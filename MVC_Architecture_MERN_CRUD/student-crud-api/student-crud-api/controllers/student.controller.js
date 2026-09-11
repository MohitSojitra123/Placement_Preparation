// controllers/student.controller.js
// -----------------------------------------------------------------------------
// The "C" in MVC — contains business logic. Routes call these functions;
// these functions talk to the Model (Mongoose) and shape the HTTP response.
// Every function follows the same defensive pattern:
//   1. Read input (params / query / body)
//   2. Validate/guard
//   3. Talk to the DB via the Model
//   4. Send a consistent JSON response shape: { success, message, data }
//   5. Catch + forward errors in a try/catch (or asyncHandler wrapper)
// -----------------------------------------------------------------------------

const bcrypt = require("bcrypt");
const Student = require("../models/student.model");

// Small helper to avoid repeating try/catch in every controller (optional pattern)
const asyncHandler = (fn) => (req, res, next) =>
  Promise.resolve(fn(req, res, next)).catch(next);

/**
 * @desc    Create ONE new student
 * @route   POST /api/students
 * @access  Public (add auth middleware for production)
 * @body    { name, email, password, rollNumber, age, course, ... }
 */
const insertOneStudent = asyncHandler(async (req, res) => {
  const { name, email, password, rollNumber } = req.body;

  if (!name || !email || !password || !rollNumber) {
    return res.status(400).json({
      success: false,
      message: "name, email, password and rollNumber are required fields",
    });
  }

  // Password hashing happens automatically in the model's pre('save') hook.
  const student = await Student.create(req.body);

  res.status(201).json({
    success: true,
    message: "Student created successfully",
    data: student,
  });
});

/**
 * @desc    Create MULTIPLE students in a single request (bulk insert)
 * @route   POST /api/students/bulk
 * @access  Public
 * @body    [ { name, email, password, rollNumber, ... }, { ... }, ... ]
 *
 * NOTE: Mongoose's insertMany() does NOT trigger 'save' middleware by default
 * (pre-Mongoose 5 behaviour differs by version/flags). To guarantee every
 * password gets hashed, we hash manually before calling insertMany().
 */
const insertManyStudents = asyncHandler(async (req, res) => {
  const students = req.body;

  if (!Array.isArray(students) || students.length === 0) {
    return res.status(400).json({
      success: false,
      message: "Request body must be a non-empty array of student objects",
    });
  }

  const saltRounds = Number(process.env.BCRYPT_SALT_ROUNDS) || 10;

  // Hash each student's password before insertion
  const studentsWithHashedPasswords = await Promise.all(
    students.map(async (student) => {
      if (!student.password) {
        throw new Error(`Password missing for student: ${student.email || "unknown"}`);
      }
      const hashedPassword = await bcrypt.hash(student.password, saltRounds);
      return { ...student, password: hashedPassword };
    })
  );

  // { ordered: false } => if one document fails validation (e.g. duplicate email),
  // Mongo skips it and continues inserting the rest, instead of stopping entirely.
  const createdStudents = await Student.insertMany(studentsWithHashedPasswords, {
    ordered: false,
  });

  res.status(201).json({
    success: true,
    message: `${createdStudents.length} students created successfully`,
    data: createdStudents,
  });
});

/**
 * @desc    Get ALL students (supports pagination, search & field selection)
 * @route   GET /api/students?page=1&limit=10&search=john
 * @access  Public
 */
const getAllStudents = asyncHandler(async (req, res) => {
  const page = Math.max(parseInt(req.query.page) || 1, 1);
  const limit = Math.max(parseInt(req.query.limit) || 10, 1);
  const skip = (page - 1) * limit;
  const { search } = req.query;

  // Simple case-insensitive search across name/email/rollNumber
  const filter = search
    ? {
        $or: [
          { name: { $regex: search, $options: "i" } },
          { email: { $regex: search, $options: "i" } },
          { rollNumber: { $regex: search, $options: "i" } },
        ],
      }
    : {};

  const [students, total] = await Promise.all([
    Student.find(filter).skip(skip).limit(limit).sort({ createdAt: -1 }),
    Student.countDocuments(filter),
  ]);

  res.status(200).json({
    success: true,
    message: "Students fetched successfully",
    count: students.length,
    total,
    totalPages: Math.ceil(total / limit),
    currentPage: page,
    data: students,
  });
});

/**
 * @desc    Get ONE student by MongoDB _id
 * @route   GET /api/students/:id
 * @access  Public
 */
const getOneStudent = asyncHandler(async (req, res) => {
  const { id } = req.params;

  const student = await Student.findById(id);

  if (!student) {
    return res.status(404).json({
      success: false,
      message: `No student found with id: ${id}`,
    });
  }

  res.status(200).json({
    success: true,
    message: "Student fetched successfully",
    data: student,
  });
});

/**
 * @desc    Update ONE student by _id (partial update supported)
 * @route   PUT /api/students/:id
 * @access  Public
 * @body    Any subset of student fields, e.g. { course: "MCA" }
 */
const updateStudent = asyncHandler(async (req, res) => {
  const { id } = req.params;
  const updates = { ...req.body };

  // findOneAndUpdate/findByIdAndUpdate skips 'pre save' hooks,
  // so we must manually re-hash the password IF it's being updated.
  if (updates.password) {
    const saltRounds = Number(process.env.BCRYPT_SALT_ROUNDS) || 10;
    updates.password = await bcrypt.hash(updates.password, saltRounds);
  }

  const student = await Student.findByIdAndUpdate(id, updates, {
    new: true, // return the UPDATED document, not the old one
    runValidators: true, // re-run schema validation rules on update
  });

  if (!student) {
    return res.status(404).json({
      success: false,
      message: `No student found with id: ${id}`,
    });
  }

  res.status(200).json({
    success: true,
    message: "Student updated successfully",
    data: student,
  });
});

/**
 * @desc    Delete ONE student by _id
 * @route   DELETE /api/students/:id
 * @access  Public
 */
const deleteOneStudent = asyncHandler(async (req, res) => {
  const { id } = req.params;

  const student = await Student.findByIdAndDelete(id);

  if (!student) {
    return res.status(404).json({
      success: false,
      message: `No student found with id: ${id}`,
    });
  }

  res.status(200).json({
    success: true,
    message: "Student deleted successfully",
    data: student,
  });
});

/**
 * @desc    Delete ALL students (irreversible — protect this in production!)
 * @route   DELETE /api/students
 * @access  Should be Admin-only in real applications
 */
const deleteAllStudents = asyncHandler(async (req, res) => {
  const result = await Student.deleteMany({});

  res.status(200).json({
    success: true,
    message: `${result.deletedCount} students deleted successfully`,
    data: result,
  });
});

module.exports = {
  insertOneStudent,
  insertManyStudents,
  getAllStudents,
  getOneStudent,
  updateStudent,
  deleteOneStudent,
  deleteAllStudents,
};
