use demo_1

-- ============================================================
-- SQL SERVER / SSMS
-- GROUP BY AND PARTITION BY
-- DEPARTMENT-WISE EMPLOYEE COUNT
-- ============================================================
--
-- REAL-WORLD USE CASE:
-- Company Employee Database
--
-- We want to find:
--
-- 1. Total employees in each department
-- 2. Employee count using GROUP BY
-- 3. Employee count using PARTITION BY
-- 4. Difference between GROUP BY and PARTITION BY
-- 5. Department-wise employee count along with employee details
-- 6. Total employees in the entire company
--
-- ============================================================


CREATE TABLE Employee
(
    EmployeeID INT PRIMARY KEY,

    EmployeeName VARCHAR(50),

    Department VARCHAR(50),

    Salary DECIMAL(10,2),

    JoiningDate DATE
);


INSERT INTO Employee
(
    EmployeeID,
    EmployeeName,
    Department,
    Salary,
    JoiningDate
)
VALUES
(101, 'Mohit', 'IT',      50000, '2024-01-10'),
(102, 'Rahul', 'IT',      55000, '2024-02-15'),
(103, 'Amit',  'IT',      60000, '2024-03-20'),

(104, 'Jay',   'HR',      40000, '2024-01-05'),
(105, 'Karan', 'HR',      45000, '2024-04-10'),

(106, 'Tirth', 'Finance', 65000, '2024-02-01'),
(107, 'Raj',   'Finance', 70000, '2024-05-15'),

(108, 'Vishal','Sales',   35000, '2024-03-01'),

(109, 'Dev',   'Marketing', 45000, '2024-06-10');



SELECT *
FROM Employee;


-- ============================================================
-- EXPECTED DATA
-- ============================================================
--
-- EmployeeID   EmployeeName   Department    Salary
-- ---------------------------------------------------
-- 101          Mohit          IT            50000
-- 102          Rahul          IT            55000
-- 103          Amit           IT            60000
-- 104          Jay            HR            40000
-- 105          Karan          HR            45000
-- 106          Tirth          Finance       65000
-- 107          Raj            Finance       70000
-- 108          Vishal         Sales         35000
-- 109          Dev            Marketing     45000
--
--
-- Department employee count:
--
-- IT         = 3
-- HR         = 2
-- Finance    = 2
-- Sales      = 1
-- Marketing  = 1
--
-- ============================================================


-- ------------------------------------------------------------
-- GROUP BY combines rows having the same Department.
--
-- COUNT(*) counts employees in each department.
-- ------------------------------------------------------------

SELECT
    Department,
    COUNT(*) AS TotalEmployees

FROM Employee

GROUP BY Department;


-- ============================================================
-- OUTPUT
-- ============================================================
--
-- Department       TotalEmployees
-- -------------------------------
-- Finance          2
-- HR               2
-- IT               3
-- Marketing        1
-- Sales            1
--
-- ============================================================


-- ============================================================
-- PART 6: GROUP BY WITH EMPLOYEE COUNT
-- ============================================================

SELECT
    Department,
    COUNT(EmployeeID) AS TotalEmployees

FROM Employee

GROUP BY Department;


-- ------------------------------------------------------------
-- COUNT(EmployeeID) and COUNT(*) both work here because
-- EmployeeID is NOT NULL due to PRIMARY KEY.
-- ------------------------------------------------------------


-- ============================================================
-- PART 7: GROUP BY WITH SUM OF SALARY
-- ============================================================

-- ------------------------------------------------------------
-- Real-world requirement:
--
-- "How much total salary does each department pay?"
-- ------------------------------------------------------------

SELECT
    Department,

    COUNT(*) AS TotalEmployees,

    SUM(Salary) AS TotalDepartmentSalary,

    AVG(Salary) AS AverageSalary

FROM Employee

GROUP BY Department;


-- ============================================================
-- OUTPUT CONCEPT
-- ============================================================
--
-- Department    Employees    Total Salary    Average Salary
-- ----------------------------------------------------------
-- Finance       2            135000          67500
-- HR            2             85000          42500
-- IT            3            165000          55000
-- Marketing     1             45000          45000
-- Sales         1             35000          35000
--
-- ============================================================


-- ============================================================
-- PART 8: PARTITION BY
-- DEPARTMENT-WISE EMPLOYEE COUNT
-- ============================================================

-- ------------------------------------------------------------
-- PARTITION BY is used with WINDOW FUNCTIONS.
--
-- Unlike GROUP BY:
--
-- GROUP BY       -> reduces rows
--
-- PARTITION BY   -> keeps individual rows
--
-- ------------------------------------------------------------

SELECT
    EmployeeID,
    EmployeeName,
    Department,
    Salary,

    COUNT(*)
    OVER
    (
        PARTITION BY Department
    ) AS DepartmentEmployeeCount

FROM Employee

ORDER BY Department, EmployeeID;


-- ============================================================
-- OUTPUT
-- ============================================================
--
-- EmployeeID   Name      Department    Salary    Count
-- ------------------------------------------------------
-- 104          Jay       HR            40000       2
-- 105          Karan     HR            45000       2
--
-- 106          Tirth     Finance       65000       2
-- 107          Raj       Finance       70000       2
--
-- 101          Mohit     IT            50000       3
-- 102          Rahul     IT            55000       3
-- 103          Amit      IT            60000       3
--
-- 109          Dev       Marketing      45000       1
--
-- 108          Vishal    Sales          35000       1
--
--
-- NOTICE:
--
-- Every employee row is still present.
--
-- ============================================================


-- ============================================================
-- PART 9: GROUP BY VS PARTITION BY
-- ============================================================


-- ------------------------------------------------------------
-- GROUP BY
-- ------------------------------------------------------------

SELECT
    Department,
    COUNT(*) AS TotalEmployees

FROM Employee

GROUP BY Department;


-- GROUP BY RESULT:
--
-- IT          3
-- HR          2
-- Finance     2
-- Sales       1
-- Marketing   1
--
--
-- It returns ONE ROW per department.
--
-- ============================================================


-- ------------------------------------------------------------
-- PARTITION BY
-- ------------------------------------------------------------

SELECT
    EmployeeID,
    EmployeeName,
    Department,

    COUNT(*)
    OVER
    (
        PARTITION BY Department
    ) AS DepartmentEmployeeCount

FROM Employee;


-- PARTITION BY RESULT:
--
-- Mohit      IT       3
-- Rahul      IT       3
-- Amit       IT       3
-- Jay        HR       2
-- Karan      HR       2
-- Tirth      Finance  2
-- Raj        Finance  2
-- Vishal     Sales    1
-- Dev        Marketing 1
--
--
-- Every employee remains visible.
--
-- ============================================================


-- ============================================================
-- PART 10: MOST IMPORTANT DIFFERENCE
-- ============================================================

-- GROUP BY:
--
-- Department
--       ↓
-- Group rows
--       ↓
-- One result per group
--
--
-- PARTITION BY:
--
-- Department
--       ↓
-- Create logical groups
--       ↓
-- Perform window calculation
--       ↓
-- Keep every original row
--
-- ============================================================


-- ============================================================
-- PART 11: DEPARTMENT COUNT + EMPLOYEE DETAILS
-- ============================================================

-- ------------------------------------------------------------
-- This is a common real-world requirement.
--
-- "Show every employee and also show how many employees
--  are working in their department."
-- ------------------------------------------------------------

SELECT
    EmployeeID,
    EmployeeName,
    Department,
    Salary,

    COUNT(*)
    OVER
    (
        PARTITION BY Department
    ) AS TotalEmployeesInDepartment

FROM Employee

ORDER BY Department, EmployeeID;


-- ============================================================
-- PART 12: DEPARTMENT COUNT + TOTAL COMPANY EMPLOYEES
-- ============================================================

-- ------------------------------------------------------------
-- We can use PARTITION BY for department count.
--
-- We can use OVER() without PARTITION BY for total company
-- employee count.
-- ------------------------------------------------------------

SELECT
    EmployeeID,
    EmployeeName,
    Department,

    -- Department-wise employee count
    COUNT(*)
    OVER
    (
        PARTITION BY Department
    ) AS DepartmentEmployeeCount,

    -- Total employees in entire company
    COUNT(*)
    OVER
    () AS TotalCompanyEmployees

FROM Employee

ORDER BY Department, EmployeeID;


-- ============================================================
-- EXAMPLE OUTPUT
-- ============================================================
--
-- Employee   Department    DeptCount    CompanyTotal
-- ----------------------------------------------------
-- Mohit      IT            3            9
-- Rahul      IT            3            9
-- Amit       IT            3            9
-- Jay        HR            2            9
-- Karan      HR            2            9
-- Tirth      Finance       2            9
-- Raj        Finance       2            9
-- Vishal     Sales         1            9
-- Dev        Marketing     1            9
--
-- ============================================================


-- ============================================================
-- PART 13: DEPARTMENT-WISE TOTAL SALARY USING PARTITION BY
-- ============================================================

SELECT
    EmployeeID,
    EmployeeName,
    Department,
    Salary,

    SUM(Salary)
    OVER
    (
        PARTITION BY Department
    ) AS DepartmentTotalSalary

FROM Employee

ORDER BY Department, EmployeeID;


-- ============================================================
-- EXAMPLE
-- ============================================================
--
-- IT:
--
-- Mohit    50000
-- Rahul    55000
-- Amit     60000
--
-- Department Total = 165000
--
-- The value 165000 will appear on all IT employee rows.
--
-- ============================================================


-- ============================================================
-- PART 14: DEPARTMENT AVERAGE SALARY
-- ============================================================

SELECT
    EmployeeID,
    EmployeeName,
    Department,
    Salary,

    AVG(Salary)
    OVER
    (
        PARTITION BY Department
    ) AS DepartmentAverageSalary

FROM Employee

ORDER BY Department, EmployeeID;


-- ============================================================
-- PART 15: EMPLOYEE SALARY VS DEPARTMENT AVERAGE
-- ============================================================

-- ------------------------------------------------------------
-- Real-world requirement:
--
-- "Is an employee's salary above or below the department
--  average?"
-- ------------------------------------------------------------

SELECT
    EmployeeID,
    EmployeeName,
    Department,
    Salary,

    AVG(Salary)
    OVER
    (
        PARTITION BY Department
    ) AS DepartmentAverageSalary,

    Salary -
    AVG(Salary)
    OVER
    (
        PARTITION BY Department
    ) AS DifferenceFromAverage

FROM Employee

ORDER BY Department, EmployeeID;


-- ============================================================
-- PART 16: CASE + PARTITION BY
-- ============================================================

-- ------------------------------------------------------------
-- Classify employee salary:
--
-- Above Department Average
-- Below Department Average
-- Equal to Department Average
-- ------------------------------------------------------------

SELECT
    EmployeeID,
    EmployeeName,
    Department,
    Salary,

    AVG(Salary)
    OVER
    (
        PARTITION BY Department
    ) AS DepartmentAverageSalary,

    CASE

        WHEN Salary >
             AVG(Salary)
             OVER
             (
                 PARTITION BY Department
             )
        THEN 'Above Department Average'

        WHEN Salary <
             AVG(Salary)
             OVER
             (
                 PARTITION BY Department
             )
        THEN 'Below Department Average'

        ELSE 'Equal to Department Average'

    END AS SalaryStatus

FROM Employee

ORDER BY Department, EmployeeID;


-- ============================================================
-- PART 17: DEPARTMENT-WISE EMPLOYEE NUMBER
-- ============================================================

-- ------------------------------------------------------------
-- ROW_NUMBER() + PARTITION BY
--
-- This gives each employee a number inside their department.
-- ------------------------------------------------------------

SELECT
    EmployeeID,
    EmployeeName,
    Department,
    Salary,

    ROW_NUMBER()
    OVER
    (
        PARTITION BY Department
        ORDER BY Salary DESC
    ) AS EmployeeNumberInDepartment

FROM Employee

ORDER BY Department, EmployeeNumberInDepartment;


-- ============================================================
-- EXAMPLE
-- ============================================================
--
-- IT:
--
-- Amit     60000    1
-- Rahul    55000    2
-- Mohit    50000    3
--
-- HR:
--
-- Karan    45000    1
-- Jay      40000    2
--
-- ============================================================


-- ============================================================
-- PART 18: DEPARTMENT-WISE HIGHEST SALARY
-- ============================================================

-- ------------------------------------------------------------
-- MAX() + PARTITION BY
--
-- Shows the highest salary of the employee's department
-- on every employee row.
-- ------------------------------------------------------------

SELECT
    EmployeeID,
    EmployeeName,
    Department,
    Salary,

    MAX(Salary)
    OVER
    (
        PARTITION BY Department
    ) AS HighestDepartmentSalary

FROM Employee

ORDER BY Department, EmployeeID;


-- ============================================================
-- PART 19: FIND HIGHEST PAID EMPLOYEE IN EACH DEPARTMENT
-- ============================================================

-- ------------------------------------------------------------
-- ROW_NUMBER() assigns rank inside each department.
--
-- Salary DESC means highest salary gets number 1.
-- ------------------------------------------------------------

WITH DepartmentEmployees AS
(
    SELECT
        EmployeeID,
        EmployeeName,
        Department,
        Salary,

        ROW_NUMBER()
        OVER
        (
            PARTITION BY Department
            ORDER BY Salary DESC
        ) AS EmployeeRank

    FROM Employee
)

SELECT
    EmployeeID,
    EmployeeName,
    Department,
    Salary

FROM DepartmentEmployees

WHERE EmployeeRank = 1

ORDER BY Department;


-- ============================================================
-- PART 20: DEPARTMENT-WISE TOTAL EMPLOYEE COUNT
-- WITH GROUP BY
-- ============================================================

SELECT
    Department,
    COUNT(*) AS TotalEmployees

FROM Employee

GROUP BY Department

ORDER BY TotalEmployees DESC;


-- ============================================================
-- PART 21: DEPARTMENT-WISE COUNT
-- WITH PARTITION BY
-- ============================================================

SELECT
    EmployeeID,
    EmployeeName,
    Department,

    COUNT(*)
    OVER
    (
        PARTITION BY Department
    ) AS TotalEmployees

FROM Employee

ORDER BY Department, EmployeeID;


-- ============================================================
-- PART 22: COMPLETE REAL-WORLD REPORT
-- ============================================================

-- ------------------------------------------------------------
-- This report displays:
--
-- Employee ID
-- Employee Name
-- Department
-- Salary
-- Number of employees in department
-- Total department salary
-- Average department salary
-- Highest department salary
-- Employee number inside department
--
-- ------------------------------------------------------------

SELECT

    EmployeeID,

    EmployeeName,

    Department,

    Salary,

    -- Number of employees in department
    COUNT(*)
    OVER
    (
        PARTITION BY Department
    ) AS DepartmentEmployeeCount,

    -- Total salary of department
    SUM(Salary)
    OVER
    (
        PARTITION BY Department
    ) AS DepartmentTotalSalary,

    -- Average salary of department
    AVG(Salary)
    OVER
    (
        PARTITION BY Department
    ) AS DepartmentAverageSalary,

    -- Highest salary in department
    MAX(Salary)
    OVER
    (
        PARTITION BY Department
    ) AS DepartmentHighestSalary,

    -- Employee number according to salary
    ROW_NUMBER()
    OVER
    (
        PARTITION BY Department
        ORDER BY Salary DESC
    ) AS EmployeeRank

FROM Employee

ORDER BY Department, EmployeeRank;


-- ============================================================
-- FINAL SUMMARY
-- ============================================================


-- ============================================================
-- GROUP BY
-- ============================================================

-- Use GROUP BY when you want to REDUCE rows.
--
-- Example:
--
-- SELECT
--     Department,
--     COUNT(*) AS TotalEmployees
-- FROM Employee
-- GROUP BY Department;
--
--
-- Result:
--
-- IT          3
-- HR          2
-- Finance     2
-- Sales       1
-- Marketing   1
--
-- ONE ROW PER DEPARTMENT.
--
-- ============================================================


-- ============================================================
-- PARTITION BY
-- ============================================================

-- Use PARTITION BY when you want to calculate something
-- separately for each group BUT KEEP EVERY ROW.
--
-- Example:
--
-- SELECT
--     EmployeeName,
--     Department,
--
--     COUNT(*)
--     OVER
--     (
--         PARTITION BY Department
--     ) AS DepartmentEmployeeCount
--
-- FROM Employee;
--
--
-- Result:
--
-- Mohit      IT          3
-- Rahul      IT          3
-- Amit       IT          3
-- Jay        HR          2
-- Karan      HR          2
-- Tirth      Finance     2
-- Raj        Finance     2
-- Vishal     Sales       1
-- Dev        Marketing   1
--
-- EVERY EMPLOYEE ROW IS KEPT.
--
-- ============================================================


-- ============================================================
-- EASY WAY TO REMEMBER
-- ============================================================

-- GROUP BY
-- --------------------------------------------
-- Group rows
-- Reduce rows
-- One result per group
--
--
-- PARTITION BY
-- --------------------------------------------
-- Divide rows into logical groups
-- Keep rows
-- Perform calculation over each group
--
--
-- ============================================================
-- IMPORTANT EXAMPLES
-- ============================================================
--
-- Department-wise COUNT:
--
-- COUNT(*)
-- OVER
-- (
--     PARTITION BY Department
-- )
--
--
-- Department-wise SUM:
--
-- SUM(Salary)
-- OVER
-- (
--     PARTITION BY Department
-- )
--
--
-- Department-wise AVERAGE:
--
-- AVG(Salary)
-- OVER
-- (
--     PARTITION BY Department
-- )
--
--
-- Department-wise MAX:
--
-- MAX(Salary)
-- OVER
-- (
--     PARTITION BY Department
-- )
--
--
-- Department-wise employee ranking:
--
-- ROW_NUMBER()
-- OVER
-- (
--     PARTITION BY Department
--     ORDER BY Salary DESC
-- )
--
-- ============================================================