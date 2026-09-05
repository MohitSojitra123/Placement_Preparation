-- ============================================================
-- SQL SERVER / SSMS
-- LAG() AND LEAD()
-- COMPLETE REAL-WORLD EXAMPLE
-- ============================================================
--
-- REAL-WORLD USE CASE:
-- Employee Salary History
--
-- We want to answer questions like:
--
-- 1. What was the employee's previous salary?
-- 2. What will be the employee's next salary?
-- 3. How much did the salary increase?
-- 4. How much did the salary decrease?
-- 5. What was the previous department?
-- 6. What is the employee's next department?
--
-- LAG()  = Get value from PREVIOUS row
-- LEAD() = Get value from NEXT row
--
-- ============================================================



-- ------------------------------------------------------------
-- EmployeeSalaryHistory
--
-- This table stores salary changes of employees over time.
--
-- Each row represents the employee's salary at a particular
-- point in time.
-- ------------------------------------------------------------

CREATE TABLE EmployeeSalaryHistory
(
    SalaryHistoryID INT IDENTITY(1,1) PRIMARY KEY,

    EmployeeID INT,

    EmployeeName VARCHAR(50),

    Department VARCHAR(50),

    Salary DECIMAL(10,2),

    EffectiveDate DATE
);


-- ------------------------------------------------------------
-- Employee: Mohit
--
-- Salary history:
--
-- 2024 -> 40000
-- 2025 -> 45000
-- 2026 -> 52000
--
-- ------------------------------------------------------------

INSERT INTO EmployeeSalaryHistory
(
    EmployeeID,
    EmployeeName,
    Department,
    Salary,
    EffectiveDate
)
VALUES
(101, 'Mohit', 'IT', 40000, '2024-01-01'),
(101, 'Mohit', 'IT', 45000, '2025-01-01'),
(101, 'Mohit', 'IT', 52000, '2026-01-01');


-- ------------------------------------------------------------
-- Employee: Rahul
--
-- Salary history:
--
-- 2024 -> 35000
-- 2025 -> 40000
-- 2026 -> 46000
-- ------------------------------------------------------------

INSERT INTO EmployeeSalaryHistory
(
    EmployeeID,
    EmployeeName,
    Department,
    Salary,
    EffectiveDate
)
VALUES
(102, 'Rahul', 'HR', 35000, '2024-01-01'),
(102, 'Rahul', 'HR', 40000, '2025-01-01'),
(102, 'Rahul', 'HR', 46000, '2026-01-01');


-- ------------------------------------------------------------
-- Employee: Amit
--
-- Salary history:
--
-- 2024 -> 50000
-- 2025 -> 48000
-- 2026 -> 55000
--
-- Notice that Amit's salary DECREASED in 2025.
-- ------------------------------------------------------------

INSERT INTO EmployeeSalaryHistory
(
    EmployeeID,
    EmployeeName,
    Department,
    Salary,
    EffectiveDate
)
VALUES
(103, 'Amit', 'Finance', 50000, '2024-01-01'),
(103, 'Amit', 'Finance', 48000, '2025-01-01'),
(103, 'Amit', 'Finance', 55000, '2026-01-01');


-- ------------------------------------------------------------
-- Employee: Jay
--
-- Salary history:
--
-- 2024 -> 30000
-- 2025 -> 36000
-- 2026 -> 42000
-- ------------------------------------------------------------

INSERT INTO EmployeeSalaryHistory
(
    EmployeeID,
    EmployeeName,
    Department,
    Salary,
    EffectiveDate
)
VALUES
(104, 'Jay', 'IT', 30000, '2024-01-01'),
(104, 'Jay', 'IT', 36000, '2025-01-01'),
(104, 'Jay', 'IT', 42000, '2026-01-01');




SELECT *
FROM EmployeeSalaryHistory
ORDER BY EmployeeID, EffectiveDate;


-- ------------------------------------------------------------
-- LAG()
--
-- LAG() gets a value from the PREVIOUS row.
--
-- Syntax:
--
-- LAG(column_name)
-- OVER
-- (
--     PARTITION BY column
--     ORDER BY column
-- )
--
-- ------------------------------------------------------------


-- Example:
--
-- Find the employee's PREVIOUS salary.

SELECT
    EmployeeID,
    EmployeeName,
    EffectiveDate,
    Salary,

    LAG(Salary)
    OVER
    (
        PARTITION BY EmployeeID
        ORDER BY EffectiveDate
    ) AS PreviousSalary

FROM EmployeeSalaryHistory

ORDER BY EmployeeID, EffectiveDate;


-- ============================================================
-- EXPECTED RESULT
-- ============================================================
--
-- Employee   Date          Salary     PreviousSalary
--
-- Mohit      2024          40000      NULL
-- Mohit      2025          45000      40000
-- Mohit      2026          52000      45000
--
-- Rahul      2024          35000      NULL
-- Rahul      2025          40000      35000
-- Rahul      2026          46000      40000
--
-- Amit       2024          50000      NULL
-- Amit       2025          48000      50000
-- Amit       2026          55000      48000
--
-- Jay        2024          30000      NULL
-- Jay        2025          36000      30000
-- Jay        2026          42000      36000
--
-- ============================================================



-- ------------------------------------------------------------
-- Real-world requirement:
--
-- "How much did the employee's salary change compared
--  with the previous salary?"
--
-- Formula:
--
-- Current Salary - Previous Salary
--
-- ------------------------------------------------------------

SELECT
    EmployeeID,
    EmployeeName,
    EffectiveDate,
    Salary,

    LAG(Salary)
    OVER
    (
        PARTITION BY EmployeeID
        ORDER BY EffectiveDate
    ) AS PreviousSalary,

    Salary -
    LAG(Salary)
    OVER
    (
        PARTITION BY EmployeeID
        ORDER BY EffectiveDate
    ) AS SalaryDifference

FROM EmployeeSalaryHistory

ORDER BY EmployeeID, EffectiveDate;


-- ============================================================
-- RESULT EXAMPLE
-- ============================================================
--
-- Mohit:
--
-- 2024   40000   NULL    NULL
-- 2025   45000   40000   5000
-- 2026   52000   45000   7000
--
-- Therefore:
--
-- 2025 salary increase = 5000
-- 2026 salary increase = 7000
--
-- ============================================================




-- ============================================================
-- PART 8: UNDERSTANDING LEAD()
-- ============================================================

-- ------------------------------------------------------------
-- LEAD()
--
-- LEAD() gets a value from the NEXT row.
--
-- Syntax:
--
-- LEAD(column_name)
-- OVER
-- (
--     PARTITION BY column
--     ORDER BY column
-- )
--
-- ------------------------------------------------------------


-- Example:
--
-- Find the employee's NEXT salary.

SELECT
    EmployeeID,
    EmployeeName,
    EffectiveDate,
    Salary,

    LEAD(Salary)
    OVER
    (
        PARTITION BY EmployeeID
        ORDER BY EffectiveDate
    ) AS NextSalary

FROM EmployeeSalaryHistory

ORDER BY EmployeeID, EffectiveDate;


-- ============================================================
-- EXPECTED RESULT
-- ============================================================
--
-- Employee   Date       Salary     NextSalary
--
-- Mohit      2024       40000      45000
-- Mohit      2025       45000      52000
-- Mohit      2026       52000      NULL
--
-- Rahul      2024       35000      40000
-- Rahul      2025       40000      46000
-- Rahul      2026       46000      NULL
--
-- ============================================================


-- ============================================================
-- PART 9: LEAD() WITH FUTURE SALARY DIFFERENCE
-- ============================================================

-- ------------------------------------------------------------
-- Real-world requirement:
--
-- "How much will the salary change in the next record?"
--
-- Formula:
--
-- Next Salary - Current Salary
-- ------------------------------------------------------------

SELECT
    EmployeeID,
    EmployeeName,
    EffectiveDate,
    Salary,

    LEAD(Salary)
    OVER
    (
        PARTITION BY EmployeeID
        ORDER BY EffectiveDate
    ) AS NextSalary,

    LEAD(Salary)
    OVER
    (
        PARTITION BY EmployeeID
        ORDER BY EffectiveDate
    ) - Salary AS FutureSalaryDifference

FROM EmployeeSalaryHistory

ORDER BY EmployeeID, EffectiveDate;


-- ============================================================
-- PART 10: LAG() AND LEAD() TOGETHER
-- ============================================================

-- ------------------------------------------------------------
-- This is one of the most useful examples.
--
-- We can see:
--
-- Previous Salary
-- Current Salary
-- Next Salary
--
-- in a single result.
-- ------------------------------------------------------------

SELECT
    EmployeeID,
    EmployeeName,
    EffectiveDate,

    -- Current Salary
    Salary AS CurrentSalary,

    -- Previous Salary
    LAG(Salary)
    OVER
    (
        PARTITION BY EmployeeID
        ORDER BY EffectiveDate
    ) AS PreviousSalary,

    -- Next Salary
    LEAD(Salary)
    OVER
    (
        PARTITION BY EmployeeID
        ORDER BY EffectiveDate
    ) AS NextSalary

FROM EmployeeSalaryHistory

ORDER BY EmployeeID, EffectiveDate;



-- ============================================================
-- PART 19: LAG() AND LEAD() WITH DEPARTMENT
-- ============================================================

-- ------------------------------------------------------------
-- LAG() and LEAD() are not limited to numbers.
--
-- They can also work with VARCHAR columns.
--
-- Here we check previous and next department.
-- ------------------------------------------------------------

SELECT
    EmployeeID,
    EmployeeName,
    EffectiveDate,
    Department,

    LAG(Department)
    OVER
    (
        PARTITION BY EmployeeID
        ORDER BY EffectiveDate
    ) AS PreviousDepartment,

    LEAD(Department)
    OVER
    (
        PARTITION BY EmployeeID
        ORDER BY EffectiveDate
    ) AS NextDepartment

FROM EmployeeSalaryHistory

ORDER BY EmployeeID, EffectiveDate;


-- ============================================================
-- PART 20: SIMPLE LAG() EXAMPLE
-- ============================================================

SELECT
    EmployeeName,
    Salary,

    LAG(Salary)
    OVER
    (
        ORDER BY SalaryHistoryID
    ) AS PreviousRowSalary

FROM EmployeeSalaryHistory;


-- ============================================================
-- PART 21: SIMPLE LEAD() EXAMPLE
-- ============================================================

SELECT
    EmployeeName,
    Salary,

    LEAD(Salary)
    OVER
    (
        ORDER BY SalaryHistoryID
    ) AS NextRowSalary

FROM EmployeeSalaryHistory;


-- ============================================================
-- FINAL SUMMARY
-- ============================================================

-- ============================================================
-- LAG()
-- ============================================================
--
-- LAG() looks BACKWARD.
--
-- Current Row
--     |
--     ↓
-- Previous Row
--
-- Example:
--
-- 40000
-- 45000
-- 52000
--
-- LAG():
--
-- 40000  -> NULL
-- 45000  -> 40000
-- 52000  -> 45000
--
--
-- ============================================================
-- LEAD()
-- ============================================================
--
-- LEAD() looks FORWARD.
--
-- Current Row
--     |
--     ↓
-- Next Row
--
-- Example:
--
-- 40000
-- 45000
-- 52000
--
-- LEAD():
--
-- 40000  -> 45000
-- 45000  -> 52000
-- 52000  -> NULL
--
--
-- ============================================================
-- IMPORTANT DIFFERENCE
-- ============================================================
--
-- LAG()  = Previous Row
--
-- LEAD() = Next Row
--
--
-- LAG()  → ← ←
-- Current
-- LEAD() → → →
--
--
-- ============================================================
-- PARTITION BY
-- ============================================================
--
-- PARTITION BY EmployeeID means:
--
-- Each employee's records are analyzed separately.
--
-- Without PARTITION BY:
--
-- SQL Server could compare one employee's salary
-- with another employee's salary.
--
-- With PARTITION BY:
--
-- Mohit → Mohit's previous salary
-- Rahul → Rahul's previous salary
-- Amit  → Amit's previous salary
-- Jay   → Jay's previous salary
--
--
-- ============================================================
-- ORDER BY
-- ============================================================
--
-- ORDER BY EffectiveDate tells SQL Server the order
-- in which rows should be considered.
--
-- Therefore:
--
-- 2024 → 2025 → 2026
--
-- LAG() uses the previous date.
-- LEAD() uses the next date.
--
--
-- ============================================================
-- FINAL CHEAT SHEET
-- ============================================================
--
-- LAG()
-- --------------------------------
-- Gets previous row value.
--
-- LEAD()
-- --------------------------------
-- Gets next row value.
--
-- PARTITION BY
-- --------------------------------
-- Separates data into groups.
--
-- ORDER BY
-- --------------------------------
-- Defines the row sequence.
--
-- LAG(column, 1)
-- --------------------------------
-- Previous row.
--
-- LAG(column, 2)
-- --------------------------------
-- Two rows before.
--
-- LEAD(column, 1)
-- --------------------------------
-- Next row.
--
-- LEAD(column, 2)
-- --------------------------------
-- Two rows after.
--
-- ============================================================
