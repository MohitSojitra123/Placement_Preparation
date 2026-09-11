// app.js
// -----------------------------------------------------------------------------
// Configures the Express application: global middleware + route mounting.
// Kept separate from server.js so the app instance can be imported and tested
// (e.g., with supertest) WITHOUT actually starting a live server/port.
// -----------------------------------------------------------------------------

const express = require("express");
const studentRoutes = require("./routes/student.routes");
const errorHandler = require("./middlewares/errorHandler");

const app = express();

// ---- Global Middleware -------------------------------------------------
app.use(express.json()); // parses incoming JSON request bodies -> req.body
app.use(express.urlencoded({ extended: true })); // parses URL-encoded form bodies

// Simple request logger (interview talking point: custom middleware)
app.use((req, res, next) => {
  console.log(`${new Date().toISOString()} | ${req.method} ${req.originalUrl}`);
  next();
});

// ---- Health Check --------------------------------------------------------
app.get("/", (req, res) => {
  res.status(200).json({ success: true, message: "Student CRUD API is running 🚀" });
});

// ---- Routes (Mounting) -----------------------------------------------------
// All routes defined in student.routes.js are now prefixed with /api/students
app.use("/api/students", studentRoutes);

// ---- 404 Handler (unmatched routes) ---------------------------------------
app.use((req, res) => {
  res.status(404).json({ success: false, message: "Route not found" });
});

// ---- Centralised Error Handler (must be LAST middleware) -------------------
app.use(errorHandler);

module.exports = app;
