use demo_1

CREATE TABLE Student_2025
(
    StudentID INT,
    StudentName VARCHAR(50),
    Course VARCHAR(50)
);


CREATE TABLE Student_2026
(
    StudentID INT,
    StudentName VARCHAR(50),
    Course VARCHAR(50)
);

INSERT INTO Student_2025
VALUES
(1, 'Mohit', 'MCA'),
(2, 'Rahul', 'BCA'),
(3, 'Amit', 'MCA'),
(4, 'Jay', 'BCA'),
(5, 'Karan', 'BBA');


INSERT INTO Student_2026
VALUES
(3, 'Amit', 'MCA'),
(4, 'Jay', 'BCA'),
(5, 'Karan', 'BBA'),
(6, 'Tirth', 'MCA'),
(7, 'Raj', 'BCA');


--UNION combines the results of two SELECT queries and removes duplicate rows.

SELECT StudentID, StudentName, Course
FROM Student_2025

UNION

SELECT StudentID, StudentName, Course
FROM Student_2026;

--UNION ALL combines the results of two queries but does NOT remove duplicates.

SELECT StudentID, StudentName, Course
FROM Student_2025

UNION ALL

SELECT StudentID, StudentName, Course
FROM Student_2026;

--EXCEPT returns rows that exist in the first SELECT but NOT in the second SELECT.

SELECT StudentID, StudentName, Course
FROM Student_2025

EXCEPT

SELECT StudentID, StudentName, Course
FROM Student_2026;


--INTERSECT returns only the rows that exist in both SELECT queries.

SELECT StudentID, StudentName, Course
FROM Student_2025

INTERSECT

SELECT StudentID, StudentName, Course
FROM Student_2026;

----------------------------------------------------------------
--| Operator    | What it does              | Duplicate rows   |
--| ----------- | ------------------------- | --------------   |
--| `UNION`     | Combines two results      | ❌ Removes      |
--| `UNION ALL` | Combines two results      | ✅ Keeps        |
--| `EXCEPT`    | First result minus second | ❌ Removes      |
--| `INTERSECT` | Common rows               | ❌ Removes      |
-------------------------------------------------------------------
