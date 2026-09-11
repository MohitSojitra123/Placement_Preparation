// server.js
// -----------------------------------------------------------------------------
// The actual entry point run via `node server.js`. Responsible ONLY for:
//   1. Loading environment variables
//   2. Connecting to the database
//   3. Starting the HTTP server (app.listen)
// -----------------------------------------------------------------------------

require("dotenv").config();
const app = require("./app");
const connectDB = require("./config/db");

const PORT = process.env.PORT || 5000;

// Connect to MongoDB first, THEN start listening for HTTP requests.
// This avoids accepting API traffic before the DB is actually ready.
connectDB().then(() => {
  app.listen(PORT, () => {
    console.log(`🚀 Server running at http://localhost:${PORT}`);
  });
});

// ---- Safety Nets for Production ---------------------------------------------
process.on("unhandledRejection", (err) => {
  console.error(`Unhandled Rejection: ${err.message}`);
  process.exit(1);
});
