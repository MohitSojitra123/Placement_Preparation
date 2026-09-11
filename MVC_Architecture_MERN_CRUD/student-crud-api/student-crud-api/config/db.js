// config/db.js
// -----------------------------------------------------------------------------
// Responsible ONLY for opening the Mongoose connection to MongoDB.
// Keeping this isolated (instead of writing it inside server.js) follows the
// "Separation of Concerns" principle used across the MVC structure.
// -----------------------------------------------------------------------------

const mongoose = require("mongoose");

const connectDB = async () => {
  try {
    const conn = await mongoose.connect(process.env.MONGO_URI, {
      // Modern mongoose (6+/8+) no longer needs useNewUrlParser / useUnifiedTopology,
      // they are kept here (harmless if ignored) for interview clarity on older versions.
    });

    console.log(`✅ MongoDB Connected: ${conn.connection.host}`);
  } catch (error) {
    console.error(`❌ MongoDB Connection Error: ${error.message}`);
    // Exit process with failure if DB connection fails — the API is useless without it.
    process.exit(1);
  }
};

module.exports = connectDB;
