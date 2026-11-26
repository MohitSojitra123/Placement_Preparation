/* ============================================================
   JOINING 3 AND MORE TABLES IN SQL SERVER
   ============================================================

   DATABASE:
       Student Management System

   TABLES:

       1. Student
       2. Enrollment
       3. Course
       4. Teacher


   RELATIONSHIP:

       Student
          |
          | StudentID
          ↓
       Enrollment
          |
          | CourseID
          ↓
       Course
          |
          | TeacherID
          ↓
       Teacher


   We will learn:

       1. Join 2 tables
       2. Join 3 tables
       3. Join 4 tables
       4. INNER JOIN
       5. LEFT JOIN with multiple tables
       6. WHERE with multiple joins
       7. GROUP BY with multiple joins
       8. Real-world query
   ============================================================ */


/* ============================================================
   1. CREATE DATABASE
   ============================================================ */

CREATE DATABASE MultiTableJoinDemo;
GO

USE MultiTableJoinDemo;
GO


/* ============================================================
   2. CREATE STUDENT TABLE
   ============================================================ */

CREATE TABLE Student
(
    StudentID INT PRIMARY KEY,
    StudentName VARCHAR(50) NOT NULL,
    Email VARCHAR(100),
    City VARCHAR(50)
);
GO


/* ============================================================
   3. CREATE TEACHER TABLE
   ============================================================ */

CREATE TABLE Teacher
(
    TeacherID INT PRIMARY KEY,
    TeacherName VARCHAR(50) NOT NULL,
    Department VARCHAR(50)
);
GO


/* ============================================================
   4. CREATE COURSE TABLE
   ============================================================ */

CREATE TABLE Course
(
    CourseID INT PRIMARY KEY,
    CourseName VARCHAR(100) NOT NULL,
    CourseFee DECIMAL(10,2),
    TeacherID INT,

    CONSTRAINT FK_Course_Teacher
        FOREIGN KEY (TeacherID)
        REFERENCES Teacher(TeacherID)
);
GO


/* ============================================================
   5. CREATE ENROLLMENT TABLE
   ============================================================

   Enrollment connects Student and Course.

   StudentID -> Student
   CourseID  -> Course
   ============================================================ */

CREATE TABLE Enrollment
(
    EnrollmentID INT PRIMARY KEY,
    StudentID INT,
    CourseID INT,
    EnrollmentDate DATE,
    Marks INT,

    CONSTRAINT FK_Enrollment_Student
        FOREIGN KEY (StudentID)
        REFERENCES Student(StudentID),

    CONSTRAINT FK_Enrollment_Course
        FOREIGN KEY (CourseID)
        REFERENCES Course(CourseID)
);
GO


/* ============================================================
   6. INSERT STUDENT DATA
   ============================================================ */

INSERT INTO Student
(StudentID, StudentName, Email, City)
VALUES
(1, 'Mohit', 'mohit@gmail.com', 'Rajkot'),
(2, 'Rahul', 'rahul@gmail.com', 'Ahmedabad'),
(3, 'Amit', 'amit@gmail.com', 'Surat'),
(4, 'Tirth', 'tirth@gmail.com', 'Rajkot'),
(5, 'Jay', 'jay@gmail.com', 'Vadodara');
GO


/* ============================================================
   7. INSERT TEACHER DATA
   ============================================================ */

INSERT INTO Teacher
(TeacherID, TeacherName, Department)
VALUES
(101, 'Dr. Sharma', 'Computer Science'),
(102, 'Prof. Patel', 'Mathematics'),
(103, 'Dr. Mehta', 'Database');
GO


/* ============================================================
   8. INSERT COURSE DATA
   ============================================================ */

INSERT INTO Course
(CourseID, CourseName, CourseFee, TeacherID)
VALUES
(201, 'Java Programming', 15000, 101),
(202, 'SQL Server',      12000, 103),
(203, 'Mathematics',     10000, 102),
(204, 'Web Development', 18000, 101);
GO


/* ============================================================
   9. INSERT ENROLLMENT DATA
   ============================================================ */

INSERT INTO Enrollment
(EnrollmentID, StudentID, CourseID, EnrollmentDate, Marks)
VALUES
(1, 1, 201, '2026-01-10', 85),
(2, 1, 202, '2026-01-15', 90),
(3, 2, 202, '2026-01-20', 78),
(4, 2, 203, '2026-01-25', 88),
(5, 3, 201, '2026-02-01', 92),
(6, 4, 204, '2026-02-05', 81);
GO


/* ============================================================
   10. CHECK ALL TABLES
   ============================================================ */

SELECT *
FROM Student;

SELECT *
FROM Teacher;

SELECT *
FROM Course;

SELECT *
FROM Enrollment;


/* ============================================================
   DATA RELATIONSHIP

   STUDENT

   StudentID   StudentName
   -----------------------
   1           Mohit
   2           Rahul
   3           Amit
   4           Tirth
   5           Jay


   ENROLLMENT

   StudentID   CourseID
   --------------------
   1           201
   1           202
   2           202
   2           203
   3           201
   4           204


   COURSE

   CourseID   CourseName        TeacherID
   ---------------------------------------
   201        Java Programming  101
   202        SQL Server        103
   203        Mathematics       102
   204        Web Development   101


   TEACHER

   TeacherID   TeacherName
   -----------------------
   101         Dr. Sharma
   102         Prof. Patel
   103         Dr. Mehta
   ============================================================ */


/* ============================================================
   11. JOIN TWO TABLES

   Student + Enrollment

   We can find which student is enrolled in which course ID.
   ============================================================ */

SELECT
    S.StudentID,
    S.StudentName,
    E.CourseID,
    E.Marks
FROM Student AS S
INNER JOIN Enrollment AS E
    ON S.StudentID = E.StudentID;


/*
RESULT:

StudentID   StudentName   CourseID   Marks
-------------------------------------------
1           Mohit         201        85
1           Mohit         202        90
2           Rahul         202        78
2           Rahul         203        88
3           Amit          201        92
4           Tirth         204        81
*/


/* ============================================================
   12. JOIN THREE TABLES

   Student
      ↓
   Enrollment
      ↓
   Course


   QUESTION:

       Display student name and course name.
   ============================================================ */

SELECT
    S.StudentID,
    S.StudentName,
    C.CourseID,
    C.CourseName,
    E.Marks
FROM Student AS S

INNER JOIN Enrollment AS E
    ON S.StudentID = E.StudentID

INNER JOIN Course AS C
    ON E.CourseID = C.CourseID;


/*
RESULT:

Student   Course              Marks
------------------------------------
Mohit     Java Programming    85
Mohit     SQL Server          90
Rahul     SQL Server          78
Rahul     Mathematics         88
Amit      Java Programming    92
Tirth     Web Development     81
*/


/* ============================================================
   IMPORTANT:

   This is a 3-TABLE JOIN.

   FROM Student
          |
          ↓
   JOIN Enrollment
          |
          ↓
   JOIN Course


   Each JOIN connects the previous result to another table.
   ============================================================ */


/* ============================================================
   13. JOIN FOUR TABLES

   Now we will add Teacher.

   Student
      ↓
   Enrollment
      ↓
   Course
      ↓
   Teacher


   QUESTION:

       Display:

       Student Name
       Course Name
       Teacher Name
       Marks
   ============================================================ */

SELECT
    S.StudentID,
    S.StudentName,

    C.CourseID,
    C.CourseName,

    T.TeacherID,
    T.TeacherName,

    E.Marks,
    E.EnrollmentDate

FROM Student AS S

INNER JOIN Enrollment AS E
    ON S.StudentID = E.StudentID

INNER JOIN Course AS C
    ON E.CourseID = C.CourseID

INNER JOIN Teacher AS T
    ON C.TeacherID = T.TeacherID;


/*
RESULT:

Student   Course              Teacher       Marks
--------------------------------------------------
Mohit     Java Programming    Dr. Sharma    85
Mohit     SQL Server          Dr. Mehta     90
Rahul     SQL Server          Dr. Mehta     78
Rahul     Mathematics         Prof. Patel   88
Amit      Java Programming    Dr. Sharma    92
Tirth     Web Development     Dr. Sharma    81
*/


/* ============================================================
   14. UNDERSTANDING THE JOIN STEP BY STEP

   STEP 1:

       Student
          +
       Enrollment


       S.StudentID = E.StudentID


   STEP 2:

       Result of Step 1
          +
       Course


       E.CourseID = C.CourseID


   STEP 3:

       Result of Step 2
          +
       Teacher


       C.TeacherID = T.TeacherID


   FINAL:

       Student
          ↓
       Enrollment
          ↓
       Course
          ↓
       Teacher
   ============================================================ */


/* ============================================================
   15. USING WHERE WITH 4 TABLES

   QUESTION:

       Find students who scored more than 85 marks.
   ============================================================ */

SELECT
    S.StudentName,
    C.CourseName,
    T.TeacherName,
    E.Marks
FROM Student AS S

INNER JOIN Enrollment AS E
    ON S.StudentID = E.StudentID

INNER JOIN Course AS C
    ON E.CourseID = C.CourseID

INNER JOIN Teacher AS T
    ON C.TeacherID = T.TeacherID

WHERE E.Marks > 85;


/*
RESULT:

Mohit   SQL Server       Dr. Mehta      90
Rahul   Mathematics      Prof. Patel    88
Amit    Java Programming Dr. Sharma     92
*/


/* ============================================================
   16. USING WHERE WITH MULTIPLE CONDITIONS

   QUESTION:

       Find students from Rajkot who scored more than 80.
   ============================================================ */

SELECT
    S.StudentName,
    S.City,
    C.CourseName,
    E.Marks
FROM Student AS S

INNER JOIN Enrollment AS E
    ON S.StudentID = E.StudentID

INNER JOIN Course AS C
    ON E.CourseID = C.CourseID

WHERE S.City = 'Rajkot'
  AND E.Marks > 80;


/*
RESULT:

Mohit   Rajkot   Java Programming   85
Mohit   Rajkot   SQL Server         90
Tirth   Rajkot   Web Development    81
*/


/* ============================================================
   17. FOUR TABLE JOIN + GROUP BY

   QUESTION:

       Calculate average marks for every course.
   ============================================================ */

SELECT
    C.CourseID,
    C.CourseName,
    AVG(E.Marks) AS AverageMarks
FROM Course AS C

INNER JOIN Enrollment AS E
    ON C.CourseID = E.CourseID

GROUP BY
    C.CourseID,
    C.CourseName;


/*
Example result:

Java Programming    88.50
SQL Server           84.00
Mathematics          88.00
Web Development      81.00
*/


/* ============================================================
   18. COUNT STUDENTS PER COURSE

   QUESTION:

       How many students are enrolled in each course?
   ============================================================ */

SELECT
    C.CourseID,
    C.CourseName,
    COUNT(E.StudentID) AS TotalStudents
FROM Course AS C

LEFT JOIN Enrollment AS E
    ON C.CourseID = E.CourseID

GROUP BY
    C.CourseID,
    C.CourseName;


/*
LEFT JOIN is used here because we also want courses that
currently have ZERO students.
*/


/* ============================================================
   19. LEFT JOIN WITH MULTIPLE TABLES

   QUESTION:

       Display ALL students, even if they have not enrolled
       in any course.
   ============================================================ */

SELECT
    S.StudentID,
    S.StudentName,
    C.CourseName,
    T.TeacherName,
    E.Marks
FROM Student AS S

LEFT JOIN Enrollment AS E
    ON S.StudentID = E.StudentID

LEFT JOIN Course AS C
    ON E.CourseID = C.CourseID

LEFT JOIN Teacher AS T
    ON C.TeacherID = T.TeacherID;


/*
Jay will also appear.

Jay has no enrollment.

Therefore:

Student = Jay
Course  = NULL
Teacher = NULL
Marks   = NULL
*/


/* ============================================================
   20. FIND STUDENTS WITHOUT ANY COURSE

   This is a useful real-world query.

   We use LEFT JOIN and check for NULL.
   ============================================================ */

SELECT
    S.StudentID,
    S.StudentName
FROM Student AS S

LEFT JOIN Enrollment AS E
    ON S.StudentID = E.StudentID

WHERE E.StudentID IS NULL;


/*
RESULT:

5    Jay


Meaning:

Jay is not enrolled in any course.
*/


/* ============================================================
   21. JOIN WITH ORDER BY

   QUESTION:

       Display students ordered by highest marks.
   ============================================================ */

SELECT
    S.StudentName,
    C.CourseName,
    T.TeacherName,
    E.Marks
FROM Student AS S

INNER JOIN Enrollment AS E
    ON S.StudentID = E.StudentID

INNER JOIN Course AS C
    ON E.CourseID = C.CourseID

INNER JOIN Teacher AS T
    ON C.TeacherID = T.TeacherID

ORDER BY E.Marks DESC;


/* ============================================================
   22. JOIN 3 TABLES WITH DISTINCT

   QUESTION:

       Find teachers who teach students.

   DISTINCT prevents the same teacher from appearing
       multiple times.
   ============================================================ */

SELECT DISTINCT
    T.TeacherID,
    T.TeacherName
FROM Teacher AS T

INNER JOIN Course AS C
    ON T.TeacherID = C.TeacherID

INNER JOIN Enrollment AS E
    ON C.CourseID = E.CourseID;


/*
RESULT:

Dr. Sharma
Dr. Mehta
Prof. Patel
*/


/* ============================================================
   23. REAL-WORLD QUERY

   REQUIREMENT:

       Display complete enrollment information:

       Student Name
       Student City
       Course Name
       Course Fee
       Teacher Name
       Teacher Department
       Marks
       Enrollment Date


   This requires 4 tables.
   ============================================================ */

SELECT
    S.StudentName,
    S.City,

    C.CourseName,
    C.CourseFee,

    T.TeacherName,
    T.Department AS TeacherDepartment,

    E.Marks,
    E.EnrollmentDate

FROM Student AS S

INNER JOIN Enrollment AS E
    ON S.StudentID = E.StudentID

INNER JOIN Course AS C
    ON E.CourseID = C.CourseID

INNER JOIN Teacher AS T
    ON C.TeacherID = T.TeacherID

ORDER BY
    S.StudentName;


/*
This is a typical real-world multi-table query.

The application can use this result to display:

---------------------------------------------------------------
Student | City | Course | Fee | Teacher | Department | Marks
---------------------------------------------------------------
*/


/* ============================================================
   24. REAL-WORLD USE CASE

   STUDENT MANAGEMENT SYSTEM

   Imagine a college application.

   TABLE 1:
       Student

       Stores student information.


   TABLE 2:
       Enrollment

       Stores which student joined which course.


   TABLE 3:
       Course

       Stores course information.


   TABLE 4:
       Teacher

       Stores teacher information.


   When an administrator opens:

       "Student Course Report"

   The application needs information from all 4 tables.


   Therefore:

       Student
          ↓
       Enrollment
          ↓
       Course
          ↓
       Teacher


   SQL joins these tables and creates one useful report.
   ============================================================ */


/* ============================================================
   25. IMPORTANT JOIN RULE

   When joining multiple tables, identify the relationship
   between the tables first.

   Example:

   Student.StudentID
           =
   Enrollment.StudentID


   Enrollment.CourseID
           =
   Course.CourseID


   Course.TeacherID
           =
   Teacher.TeacherID


   Then write the JOIN conditions.
   ============================================================ */


/* ============================================================
   26. GENERAL TEMPLATE FOR 3 TABLES

   SELECT
       columns
   FROM Table1 AS T1

   INNER JOIN Table2 AS T2
       ON T1.Key = T2.ForeignKey

   INNER JOIN Table3 AS T3
       ON T2.Key = T3.ForeignKey;
   ============================================================ */


/* ============================================================
   27. GENERAL TEMPLATE FOR 4 TABLES

   SELECT
       columns
   FROM Table1 AS T1

   INNER JOIN Table2 AS T2
       ON T1.Key = T2.ForeignKey

   INNER JOIN Table3 AS T3
       ON T2.Key = T3.ForeignKey

   INNER JOIN Table4 AS T4
       ON T3.Key = T4.ForeignKey;
   ============================================================ */


/* ============================================================
   28. GENERAL TEMPLATE FOR 5 TABLES

   SELECT
       columns
   FROM Table1 AS T1

   INNER JOIN Table2 AS T2
       ON T1.Key = T2.ForeignKey

   INNER JOIN Table3 AS T3
       ON T2.Key = T3.ForeignKey

   INNER JOIN Table4 AS T4
       ON T3.Key = T4.ForeignKey

   INNER JOIN Table5 AS T5
       ON T4.Key = T5.ForeignKey;
   ============================================================ */


/* ============================================================
   FINAL SUMMARY

   3 TABLES:

       Table1
          ↓ JOIN
       Table2
          ↓ JOIN
       Table3


   4 TABLES:

       Table1
          ↓ JOIN
       Table2
          ↓ JOIN
       Table3
          ↓ JOIN
       Table4


   5 TABLES:

       Table1
          ↓ JOIN
       Table2
          ↓ JOIN
       Table3
          ↓ JOIN
       Table4
          ↓ JOIN
       Table5


   KEY POINT:

       For every additional table, add another JOIN
       and specify its ON condition.

   Example:

       FROM Student S

       JOIN Enrollment E
           ON S.StudentID = E.StudentID

       JOIN Course C
           ON E.CourseID = C.CourseID

       JOIN Teacher T
           ON C.TeacherID = T.TeacherID;


   This is how SQL Server joins 3, 4, 5, or more tables.
   ============================================================ */
