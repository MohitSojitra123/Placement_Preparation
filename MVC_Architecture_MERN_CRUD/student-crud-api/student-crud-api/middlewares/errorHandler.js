// middlewares/errorHandler.js
// -----------------------------------------------------------------------------
// Centralised error handler. Express recognises this as an "error-handling
// middleware" because it takes FOUR arguments (err, req, res, next).
// Every asyncHandler()-wrapped controller that throws lands here via next(err).
// -----------------------------------------------------------------------------

const errorHandler = (err, req, res, next) => {
  console.error("🔥 Error:", err.message);

  // Mongoose bad ObjectId (e.g., malformed :id in URL)
  if (err.name === "CastError") {
    return res.status(400).json({
      success: false,
      message: `Invalid ID format: ${err.value}`,
    });
  }

  // Mongoose validation errors (required fields, minlength, enum, etc.)
  if (err.name === "ValidationError") {
    const messages = Object.values(err.errors).map((val) => val.message);
    return res.status(400).json({
      success: false,
      message: messages.join(", "),
    });
  }

  // Duplicate key error (e.g., unique email/rollNumber already exists)
  if (err.code === 11000) {
    const field = Object.keys(err.keyValue)[0];
    return res.status(409).json({
      success: false,
      message: `Duplicate value for field '${field}': '${err.keyValue[field]}' already exists`,
    });
  }

  // Fallback: generic 500 Internal Server Error
  res.status(err.statusCode || 500).json({
    success: false,
    message: err.message || "Internal Server Error",
  });
};

module.exports = errorHandler;
