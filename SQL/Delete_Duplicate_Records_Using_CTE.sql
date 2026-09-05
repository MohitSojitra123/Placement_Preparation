use demo_1

CREATE TABLE Employee
(
    EmployeeID INT IDENTITY(1,1) PRIMARY KEY,

    EmployeeName VARCHAR(50),

    Email VARCHAR(100),

    Department VARCHAR(50),

    Salary DECIMAL(10,2)
);


INSERT INTO Employee
(
    EmployeeName,
    Email,
    Department,
    Salary
)
VALUES
('Mohit', 'mohit@gmail.com', 'IT', 50000),
('Mohit', 'mohit@gmail.com', 'IT', 50000),

('Rahul', 'rahul@gmail.com', 'HR', 45000),
('Rahul', 'rahul@gmail.com', 'HR', 45000),

('Amit', 'amit@gmail.com', 'Finance', 60000),
('Amit', 'amit@gmail.com', 'Finance', 60000),

('Jay', 'jay@gmail.com', 'IT', 55000),

('Karan', 'karan@gmail.com', 'Sales', 40000);




SELECT *
FROM Employee;


-- ============================================================
-- ORIGINAL DATA
-- ============================================================
--
-- EmployeeID   Name      Email              Department
-- --------------------------------------------------------
-- 1             Mohit     mohit@gmail.com     IT
-- 2             Mohit     mohit@gmail.com     IT
-- 3             Rahul     rahul@gmail.com     HR
-- 4             Rahul     rahul@gmail.com     HR
-- 5             Amit      amit@gmail.com      Finance
-- 6             Amit      amit@gmail.com      Finance
-- 7             Jay       jay@gmail.com       IT
-- 8             Karan     karan@gmail.com     Sales
--
-- ============================================================


-- ============================================================
-- PART 5: FIND DUPLICATE RECORDS
-- ============================================================

-- ------------------------------------------------------------
-- We consider records duplicates when:
--
-- EmployeeName + Email + Department + Salary
--
-- are the same.
--
-- EmployeeID is NOT included because it is unique.
-- ------------------------------------------------------------

SELECT
    EmployeeName,
    Email,
    Department,
    Salary,

    COUNT(*) AS DuplicateCount

FROM Employee

GROUP BY
    EmployeeName,
    Email,
    Department,
    Salary

HAVING COUNT(*) > 1;


-- ============================================================
-- RESULT
-- ============================================================
--
-- Mohit   mohit@gmail.com   IT       50000    2
-- Rahul   rahul@gmail.com   HR       45000    2
-- Amit    amit@gmail.com    Finance  60000    2
--
-- ============================================================


-- ============================================================
-- PART 6: CTE + ROW_NUMBER()
-- FIND DUPLICATES
-- ============================================================

-- ------------------------------------------------------------
-- CTE = Common Table Expression
--
-- ROW_NUMBER() gives a number to every row.
--
-- PARTITION BY groups duplicate records.
--
-- ORDER BY EmployeeID decides which record we keep.
-- ------------------------------------------------------------

WITH DuplicateRecords AS
(
    SELECT

        EmployeeID,
        EmployeeName,
        Email,
        Department,
        Salary,

        ROW_NUMBER()
        OVER
        (
            PARTITION BY
                EmployeeName,
                Email,
                Department,
                Salary

            ORDER BY EmployeeID
        ) AS RowNumber

    FROM Employee
)

SELECT *
FROM DuplicateRecords;


-- ============================================================
-- RESULT
-- ============================================================
--
-- EmployeeID   Name      RowNumber
-- --------------------------------
-- 1            Mohit        1
-- 2            Mohit        2
--
-- 3            Rahul        1
-- 4            Rahul        2
--
-- 5            Amit         1
-- 6            Amit         2
--
-- 7            Jay          1
--
-- 8            Karan        1
--
--
-- RowNumber = 1
--      ↓
-- KEEP
--
-- RowNumber > 1
--      ↓
-- DELETE
--
-- ============================================================


-- ============================================================
-- PART 7: SHOW ONLY DUPLICATE RECORDS
-- ============================================================

WITH DuplicateRecords AS
(
    SELECT

        EmployeeID,
        EmployeeName,
        Email,
        Department,
        Salary,

        ROW_NUMBER()
        OVER
        (
            PARTITION BY
                EmployeeName,
                Email,
                Department,
                Salary

            ORDER BY EmployeeID
        ) AS RowNumber

    FROM Employee
)

SELECT *
FROM DuplicateRecords
WHERE RowNumber > 1;


-- ============================================================
-- RESULT
-- ============================================================
--
-- EmployeeID   Name      RowNumber
-- --------------------------------
-- 2            Mohit        2
-- 4            Rahul        2
-- 6            Amit         2
--
-- These are the records that will be deleted.
--
-- ============================================================


-- ============================================================
-- PART 8: DELETE DUPLICATE RECORDS USING CTE
-- ============================================================

-- ------------------------------------------------------------
-- IMPORTANT:
--
-- RowNumber = 1  --> Keep
--
-- RowNumber > 1  --> Delete
--
-- ------------------------------------------------------------

WITH DuplicateRecords AS
(
    SELECT

        EmployeeID,

        ROW_NUMBER()
        OVER
        (
            PARTITION BY
                EmployeeName,
                Email,
                Department,
                Salary

            ORDER BY EmployeeID
        ) AS RowNumber

    FROM Employee
)

DELETE FROM DuplicateRecords
WHERE RowNumber > 1;


select * from Employee


-- ============================================================
-- WHAT HAPPENS?
-- ============================================================
--
-- Before:
--
-- Mohit    ID 1
-- Mohit    ID 2
--
-- Rahul    ID 3
-- Rahul    ID 4
--
-- Amit     ID 5
-- Amit     ID 6
--
--
-- After DELETE:
--
-- Mohit    ID 1    <-- KEEP
--
-- Rahul    ID 3    <-- KEEP
--
-- Amit     ID 5    <-- KEEP
--
-- Jay      ID 7
-- Karan    ID 8
--
-- ============================================================


-- ============================================================
-- PART 9: VERIFY THE RESULT
-- ============================================================

SELECT *
FROM Employee

ORDER BY EmployeeID;


-- ============================================================
-- FINAL RESULT
-- ============================================================
--
-- EmployeeID   Name      Email              Department
-- --------------------------------------------------------
-- 1             Mohit     mohit@gmail.com     IT
-- 3             Rahul     rahul@gmail.com     HR
-- 5             Amit      amit@gmail.com      Finance
-- 7             Jay       jay@gmail.com       IT
-- 8             Karan     karan@gmail.com     Sales
--
-- Duplicate records have been removed.
--
-- ============================================================


-- ============================================================
-- PART 10: DELETE DUPLICATES USING CTE + JOIN
-- ============================================================

-- ------------------------------------------------------------
-- Another common approach is:
--
-- CTE + JOIN
--
-- First identify the duplicate EmployeeID values,
-- then DELETE them from the original table.
--
-- ------------------------------------------------------------

-- IMPORTANT:
-- The previous DELETE already removed duplicates.
--
-- Therefore, this example is shown as an alternative
-- approach and should be executed on a fresh copy of the
-- original data.
--
-- ============================================================


-- ============================================================
-- EXAMPLE OF CTE + JOIN LOGIC
-- ============================================================

/*

WITH DuplicateRecords AS
(
    SELECT

        EmployeeID,

        ROW_NUMBER()
        OVER
        (
            PARTITION BY
                EmployeeName,
                Email,
                Department,
                Salary

            ORDER BY EmployeeID
        ) AS RowNumber

    FROM Employee
)

DELETE E

FROM Employee E

INNER JOIN DuplicateRecords D
    ON E.EmployeeID = D.EmployeeID

WHERE D.RowNumber > 1;

*/


-- ============================================================
-- HOW CTE + JOIN WORKS
-- ============================================================

-- Step 1:
--
-- CTE identifies duplicate rows.
--
-- Example:
--
-- EmployeeID    RowNumber
-- -----------------------
-- 1                1
-- 2                2
-- 3                1
-- 4                2
-- 5                1
-- 6                2
--
--
-- Step 2:
--
-- JOIN CTE with Employee table using EmployeeID.
--
-- Employee E
--      |
--      | JOIN
--      ↓
-- DuplicateRecords D
--
--
-- Step 3:
--
-- WHERE D.RowNumber > 1
--
-- identifies:
--
-- EmployeeID 2
-- EmployeeID 4
-- EmployeeID 6
--
--
-- Step 4:
--
-- DELETE those records.
--
-- ============================================================


-- ============================================================
-- PART 11: COMPLETE CTE + JOIN DELETE QUERY
-- ============================================================

/*

WITH DuplicateRecords AS
(
    SELECT

        EmployeeID,

        ROW_NUMBER()
        OVER
        (
            PARTITION BY
                EmployeeName,
                Email,
                Department,
                Salary

            ORDER BY EmployeeID
        ) AS RowNumber

    FROM Employee
)

DELETE E

FROM Employee AS E

INNER JOIN DuplicateRecords AS D
    ON E.EmployeeID = D.EmployeeID

WHERE D.RowNumber > 1;

*/


-- ============================================================
-- PART 12: REAL-WORLD CASE
-- DUPLICATE EMAIL
-- ============================================================

-- ------------------------------------------------------------
-- Sometimes you only consider Email to identify duplicates.
--
-- For example:
--
-- Two records having the same Email are considered duplicates.
--
-- ------------------------------------------------------------

/*

WITH DuplicateEmails AS
(
    SELECT

        EmployeeID,
        EmployeeName,
        Email,

        ROW_NUMBER()
        OVER
        (
            PARTITION BY Email
            ORDER BY EmployeeID
        ) AS RowNumber

    FROM Employee
)

SELECT *
FROM DuplicateEmails
WHERE RowNumber > 1;

*/


-- ============================================================
-- DELETE DUPLICATE EMAIL RECORDS
-- ============================================================

/*

WITH DuplicateEmails AS
(
    SELECT

        EmployeeID,

        ROW_NUMBER()
        OVER
        (
            PARTITION BY Email
            ORDER BY EmployeeID
        ) AS RowNumber

    FROM Employee
)

DELETE E

FROM Employee E

INNER JOIN DuplicateEmails D
    ON E.EmployeeID = D.EmployeeID

WHERE D.RowNumber > 1;

*/


-- ============================================================
-- PART 13: WHY ORDER BY EmployeeID?
-- ============================================================

-- ------------------------------------------------------------
-- ORDER BY EmployeeID
--
-- determines which duplicate record is kept.
--
-- Example:
--
-- ID 1 -> RowNumber 1 -> KEEP
-- ID 2 -> RowNumber 2 -> DELETE
--
-- Therefore the OLDEST record is kept.
--
-- ------------------------------------------------------------


-- ============================================================
-- KEEP THE NEWEST RECORD INSTEAD
-- ============================================================

-- ------------------------------------------------------------
-- If you want to keep the newest record:
--
-- ORDER BY EmployeeID DESC
--
-- ------------------------------------------------------------

/*

WITH DuplicateRecords AS
(
    SELECT

        EmployeeID,

        ROW_NUMBER()
        OVER
        (
            PARTITION BY
                EmployeeName,
                Email,
                Department,
                Salary

            ORDER BY EmployeeID DESC
        ) AS RowNumber

    FROM Employee
)

DELETE E

FROM Employee E

INNER JOIN DuplicateRecords D
    ON E.EmployeeID = D.EmployeeID

WHERE D.RowNumber > 1;

*/


-- ============================================================
-- PART 14: VERY IMPORTANT
-- ALWAYS CHECK BEFORE DELETE
-- ============================================================

-- ------------------------------------------------------------
-- Before executing DELETE, run the SELECT first.
--
-- This lets you see exactly which records will be deleted.
-- ------------------------------------------------------------

WITH DuplicateRecords AS
(
    SELECT

        EmployeeID,
        EmployeeName,
        Email,
        Department,
        Salary,

        ROW_NUMBER()
        OVER
        (
            PARTITION BY
                EmployeeName,
                Email,
                Department,
                Salary

            ORDER BY EmployeeID
        ) AS RowNumber

    FROM Employee
)

SELECT *

FROM DuplicateRecords

WHERE RowNumber > 1;


-- If the result is correct,
-- then use DELETE.
--
-- ============================================================


-- ============================================================
-- FINAL CONCEPT
-- ============================================================

-- CTE
-- ---------------------------------------------
-- Temporarily stores the result of a query.
--
--
-- ROW_NUMBER()
-- ---------------------------------------------
-- Gives sequential numbers to rows.
--
--
-- PARTITION BY
-- ---------------------------------------------
-- Creates groups of duplicate records.
--
--
-- ORDER BY
-- ---------------------------------------------
-- Determines which record gets RowNumber = 1.
--
--
-- RowNumber = 1
-- ---------------------------------------------
-- KEEP THIS RECORD.
--
--
-- RowNumber > 1
-- ---------------------------------------------
-- DUPLICATE RECORD -> DELETE.
--
-- ============================================================


-- ============================================================
-- MOST IMPORTANT QUERY
-- ============================================================

/*

WITH DuplicateRecords AS
(
    SELECT

        EmployeeID,

        ROW_NUMBER()
        OVER
        (
            PARTITION BY
                EmployeeName,
                Email,
                Department,
                Salary

            ORDER BY EmployeeID
        ) AS RowNumber

    FROM Employee
)

DELETE E

FROM Employee AS E

INNER JOIN DuplicateRecords AS D

    ON E.EmployeeID = D.EmployeeID

WHERE D.RowNumber > 1;

*/


-- ============================================================
-- EASY TO REMEMBER
-- ============================================================

--              DUPLICATE DATA
--                    |
--                    ↓
--             PARTITION BY
--                    |
--                    ↓
--              ROW_NUMBER()
--                    |
--                    ↓
--       ┌────────────┴────────────┐
--       ↓                         ↓
-- RowNumber = 1             RowNumber > 1
--       ↓                         ↓
--     KEEP                     DELETE
--
-- ============================================================