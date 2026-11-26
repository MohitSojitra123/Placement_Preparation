
-- ============================================================
-- SQL SERVER / SSMS
-- SINGLE COLUMN PRIMARY KEY & COMPOSITE PRIMARY KEY
-- ============================================================

use demo_1


CREATE TABLE Student
(
    StudentID INT PRIMARY KEY,          -- Single Column Primary Key
    StudentName VARCHAR(50),
    Email VARCHAR(100),
    Course VARCHAR(50)
);



INSERT INTO Student
VALUES
(101, 'Mohit', 'mohit@gmail.com', 'MCA'),
(102, 'Rahul', 'rahul@gmail.com', 'BCA'),
(103, 'Amit', 'amit@gmail.com', 'MCA'),
(104, 'Jay', 'jay@gmail.com', 'BBA'),
(105, 'Karan', 'karan@gmail.com', 'BCA');


SELECT *
FROM Student;


-- ============================================================
-- SINGLE COLUMN PRIMARY KEY EXPLANATION
-- ============================================================

-- StudentID is the Primary Key.
--
-- Therefore:
-- 1. StudentID cannot contain NULL.
-- 2. StudentID must be unique.
-- 3. Duplicate StudentID values are NOT allowed.
--
-- Example:
--
-- INSERT INTO Student
-- VALUES
-- (101, 'Tirth', 'tirth@gmail.com', 'MCA');
--
-- This will produce a PRIMARY KEY violation because
-- StudentID 101 already exists.


-- ============================================================
-- PART 2: COMPOSITE PRIMARY KEY
-- ============================================================

-- ------------------------------------------------------------
-- Create Student_Course table
--
-- StudentID alone is NOT the Primary Key.
-- CourseID alone is NOT the Primary Key.
--
-- StudentID + CourseID together form ONE Primary Key.
-- This is called a COMPOSITE PRIMARY KEY.
-- ------------------------------------------------------------

CREATE TABLE Student_Course
(
    StudentID INT,
    CourseID INT,
    EnrollmentDate DATE,
    Grade VARCHAR(5),

    -- --------------------------------------------------------
    -- Composite Primary Key
    -- Two columns together form ONE Primary Key
    -- --------------------------------------------------------

    CONSTRAINT PK_Student_Course
    PRIMARY KEY (StudentID, CourseID)
);



INSERT INTO Student_Course
VALUES
(101, 1, '2026-06-01', 'A'),
(101, 2, '2026-06-02', 'B'),
(102, 1, '2026-06-01', 'A'),
(102, 3, '2026-06-03', 'A+'),
(103, 2, '2026-06-04', 'B'),
(104, 1, '2026-06-05', 'A'),
(105, 3, '2026-06-06', 'A+');



SELECT *
FROM Student_Course;


-- ============================================================
-- COMPOSITE PRIMARY KEY EXPLANATION
-- ============================================================

-- The Primary Key is:
--
-- StudentID + CourseID
--
-- Together they must be UNIQUE.
--
-- For example:
--
-- (101, 1)  --> Valid
-- (101, 2)  --> Valid
-- (102, 1)  --> Valid
--
-- StudentID 101 can appear more than once.
-- CourseID 1 can appear more than once.
--
-- But the SAME combination cannot appear twice.


-- ============================================================
-- INVALID COMPOSITE PRIMARY KEY EXAMPLE
-- ============================================================

-- The following query will generate a PRIMARY KEY violation
-- because (101, 1) already exists.

-- INSERT INTO Student_Course
-- VALUES
-- (101, 1, '2026-07-01', 'A+');


-- ============================================================
-- VALID COMPOSITE PRIMARY KEY EXAMPLE
-- ============================================================

-- This is valid because (101, 3) does not already exist.

INSERT INTO Student_Course
VALUES
(101, 3, '2026-07-01', 'A');


-- Display updated table

SELECT *
FROM Student_Course;



-- ============================================================
-- IMPORTANT RULES
-- ============================================================

-- RULE 1:
-- A table can have ONLY ONE Primary Key constraint.
--
-- RULE 2:
-- A Primary Key can contain ONE column.
--
-- Example:
--
-- PRIMARY KEY (StudentID)
--
--
-- RULE 3:
-- A Primary Key can contain MULTIPLE columns.
--
-- Example:
--
-- PRIMARY KEY (StudentID, CourseID)
--
--
-- RULE 4:
-- Multiple Primary Key constraints are NOT allowed.
--
-- WRONG:
--
-- PRIMARY KEY (StudentID),
-- PRIMARY KEY (CourseID)
--
--
-- CORRECT:
--
-- PRIMARY KEY (StudentID, CourseID)
--
--
-- This is ONE Composite Primary Key.


-- ============================================================
-- FINAL CONCEPT
-- ============================================================

-- SINGLE COLUMN PRIMARY KEY
--
-- Student
-- --------------------------------
-- StudentID       <-- PRIMARY KEY
-- StudentName
-- Email
-- Course
--
--
-- COMPOSITE PRIMARY KEY
--
-- Student_Course
-- --------------------------------
-- StudentID       <-- Part of PK
-- CourseID        <-- Part of PK
-- EnrollmentDate
-- Grade
--
-- StudentID + CourseID
--        |
--        +---- ONE COMPOSITE PRIMARY KEY
--
-- ============================================================
