// models/student.model.js
// -----------------------------------------------------------------------------
// The "M" in MVC — defines the Schema/Shape of a Student document in MongoDB,
// plus data-level behaviour: password hashing (bcrypt) and a password-check
// instance method. Keeping hashing logic INSIDE the model (via Mongoose
// middleware/hooks) means controllers never have to remember to hash passwords
// manually — it happens automatically before every save.
// -----------------------------------------------------------------------------

const mongoose = require("mongoose");
const bcrypt = require("bcrypt");

const { Schema } = mongoose;

const studentSchema = new Schema(
  {
    name: {
      type: String,
      required: [true, "Student name is required"],
      trim: true,
      minlength: 2,
      maxlength: 100,
    },
    email: {
      type: String,
      required: [true, "Email is required"],
      unique: true, // creates a unique index at the DB level
      lowercase: true,
      trim: true,
      match: [/^\S+@\S+\.\S+$/, "Please enter a valid email address"],
    },
    password: {
      type: String,
      required: [true, "Password is required"],
      minlength: 6,
      select: false, // never return password field by default in queries
    },
    rollNumber: {
      type: String,
      required: [true, "Roll number is required"],
      unique: true,
      trim: true,
    },
    age: {
      type: Number,
      min: 3,
      max: 100,
    },
    course: {
      type: String,
      trim: true,
      default: "Not Assigned",
    },
    department: {
      type: String,
      trim: true,
    },
    gender: {
      type: String,
      enum: ["Male", "Female", "Other"],
    },
    address: {
      city: { type: String, trim: true },
      state: { type: String, trim: true },
      country: { type: String, trim: true, default: "India" },
    },
    isActive: {
      type: Boolean,
      default: true,
    },
  },
  {
    timestamps: true, // adds createdAt & updatedAt automatically
  }
);

/**
 * MONGOOSE PRE-SAVE HOOK (Middleware)
 * ------------------------------------------------------------------
 * Runs automatically before a document is saved via .save() or .create().
 * NOTE: This does NOT run on findOneAndUpdate() by default — that's why
 * the controller/service layer for "update" manually hashes the password
 * if it is present in the update payload (see student.controller.js).
 */
studentSchema.pre("save", async function (next) {
  // "this" refers to the document about to be saved
  if (!this.isModified("password")) {
    return next(); // skip re-hashing if password wasn't changed
  }

  try {
    const saltRounds = Number(process.env.BCRYPT_SALT_ROUNDS) || 10;
    const salt = await bcrypt.genSalt(saltRounds);
    this.password = await bcrypt.hash(this.password, salt);
    next();
  } catch (error) {
    next(error);
  }
});

/**
 * INSTANCE METHOD: comparePassword
 * ------------------------------------------------------------------
 * Available on every document instance: student.comparePassword("plainPwd")
 * Uses bcrypt.compare to safely check a plaintext password against the
 * stored hash without ever decrypting the hash (hashing is one-way).
 */
studentSchema.methods.comparePassword = async function (candidatePassword) {
  return bcrypt.compare(candidatePassword, this.password);
};

/**
 * Hide sensitive/internal fields whenever a document is converted to JSON
 * (e.g., when sent in an API response with res.json(student)).
 */
studentSchema.methods.toJSON = function () {
  const studentObject = this.toObject();
  delete studentObject.password;
  delete studentObject.__v;
  return studentObject;
};

module.exports = mongoose.model("Student", studentSchema);
