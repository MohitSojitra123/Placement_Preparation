
/* ============================================================
   SQL SERVER VIEW - COMPLETE DEMO
   SQL SERVER MANAGEMENT STUDIO (SSMS)

   Topics Covered:
   1. What is a VIEW?
   2. CREATE VIEW
   3. DQL using VIEW
   4. VIEW with WHERE
   5. VIEW with JOIN
   6. VIEW with GROUP BY
   7. DML through VIEW
   8. ALTER VIEW
   9. DROP VIEW
   ============================================================ */


/* ============================================================
   STEP 1: CREATE DATABASE
   ============================================================ */

CREATE DATABASE ViewDemoDB;
GO

USE ViewDemoDB;
GO


/* ============================================================
   STEP 2: CREATE DEPARTMENT TABLE
   ============================================================ */

CREATE TABLE Department
(
    DepartmentID INT PRIMARY KEY,
    DepartmentName VARCHAR(50)
);
GO


/* ============================================================
   STEP 3: INSERT DEPARTMENT DATA
   ============================================================ */

INSERT INTO Department
(
    DepartmentID,
    DepartmentName
)
VALUES
(1, 'IT'),
(2, 'HR'),
(3, 'Finance'),
(4, 'Sales');
GO


/* ============================================================
   STEP 4: CREATE EMPLOYEE TABLE
   ============================================================ */

CREATE TABLE Employee
(
    EmployeeID INT IDENTITY(1,1) PRIMARY KEY,
    EmployeeName VARCHAR(50),
    Email VARCHAR(100),
    DepartmentID INT,
    Salary DECIMAL(10,2),

    CONSTRAINT FK_Employee_Department
        FOREIGN KEY (DepartmentID)
        REFERENCES Department(DepartmentID)
);
GO


/* ============================================================
   STEP 5: INSERT EMPLOYEE DATA
   ============================================================ */

INSERT INTO Employee
(
    EmployeeName,
    Email,
    DepartmentID,
    Salary
)
VALUES
('Mohit', 'mohit@gmail.com', 1, 50000),
('Rahul', 'rahul@gmail.com', 2, 45000),
('Amit', 'amit@gmail.com', 3, 55000),
('Jay', 'jay@gmail.com', 1, 60000),
('Karan', 'karan@gmail.com', 4, 48000),
('Tirth', 'tirth@gmail.com', 1, 52000);
GO


/* ============================================================
   STEP 6: VIEW ORIGINAL TABLE DATA
   ============================================================ */

SELECT *
FROM Employee;
GO

SELECT *
FROM Department;
GO


/* ============================================================
   ============================================================
   PART 1: WHAT IS A VIEW?
   ============================================================

   A VIEW is a virtual table based on a SELECT query.

   A VIEW normally does not store a separate copy of the
   underlying table data.

   Syntax:

       CREATE VIEW ViewName
       AS
       SELECT ...
       FROM ...;

   Think of a VIEW as a saved SELECT query.
   ============================================================
   ============================================================ */


/* ============================================================
   PART 2: CREATE SIMPLE VIEW
   ============================================================ */


/* ------------------------------------------------------------
   This View displays basic employee information.
   ------------------------------------------------------------ */

CREATE VIEW EmployeeView
AS
SELECT
    EmployeeID,
    EmployeeName,
    Email,
    DepartmentID,
    Salary
FROM Employee;
GO


/* ============================================================
   PART 3: DQL USING VIEW
   ============================================================ */


/* ------------------------------------------------------------
   SELECT is DQL.

   Instead of writing:

       SELECT *
       FROM Employee;

   We can write:

       SELECT *
       FROM EmployeeView;

   ------------------------------------------------------------ */

SELECT *
FROM EmployeeView;
GO


/* ============================================================
   PART 4: SELECT SPECIFIC COLUMNS FROM VIEW
   ============================================================ */

SELECT
    EmployeeID,
    EmployeeName,
    Salary
FROM EmployeeView;
GO


/* ============================================================
   PART 5: VIEW WITH WHERE CONDITION
   ============================================================ */


/* ------------------------------------------------------------
   We can use WHERE while selecting from a View.

   Example:
   Find employees whose salary is greater than 50000.
   ------------------------------------------------------------ */

SELECT
    EmployeeID,
    EmployeeName,
    Salary
FROM EmployeeView
WHERE Salary > 50000;
GO


/* ============================================================
   PART 6: VIEW WITH JOIN
   ============================================================ */


/* ------------------------------------------------------------
   A View can contain JOINs.

   Here we combine:

       Employee
           +
       Department

   So the View displays DepartmentName instead of only
   DepartmentID.
   ------------------------------------------------------------ */

CREATE VIEW EmployeeDepartmentView
AS
SELECT
    E.EmployeeID,
    E.EmployeeName,
    E.Email,
    D.DepartmentName,
    E.Salary
FROM Employee AS E
INNER JOIN Department AS D
    ON E.DepartmentID = D.DepartmentID;
GO


/* ------------------------------------------------------------
   Use the JOIN View
   ------------------------------------------------------------ */

SELECT *
FROM EmployeeDepartmentView;
GO


/* ------------------------------------------------------------
   Find only IT employees
   ------------------------------------------------------------ */

SELECT *
FROM EmployeeDepartmentView
WHERE DepartmentName = 'IT';
GO


/* ------------------------------------------------------------
   Find employees with salary greater than 50000
   ------------------------------------------------------------ */

SELECT
    EmployeeName,
    DepartmentName,
    Salary
FROM EmployeeDepartmentView
WHERE Salary > 50000;
GO


/* ============================================================
   PART 7: VIEW WITH GROUP BY
   ============================================================ */


/* ------------------------------------------------------------
   This View calculates:

       Department
       Total Employees
       Average Salary
       Maximum Salary
       Minimum Salary

   GROUP BY creates one result row for each department.
   ------------------------------------------------------------ */

CREATE VIEW DepartmentSummaryView
AS
SELECT
    D.DepartmentName,

    COUNT(E.EmployeeID) AS TotalEmployees,

    AVG(E.Salary) AS AverageSalary,

    MAX(E.Salary) AS MaximumSalary,

    MIN(E.Salary) AS MinimumSalary

FROM Department AS D

LEFT JOIN Employee AS E
    ON D.DepartmentID = E.DepartmentID

GROUP BY
    D.DepartmentName;
GO


/* ------------------------------------------------------------
   Display department summary
   ------------------------------------------------------------ */

SELECT *
FROM DepartmentSummaryView;
GO


/* ============================================================
   PART 8: DML THROUGH VIEW
   ============================================================

   A simple View can sometimes be used for:

       INSERT
       UPDATE
       DELETE

   But not every View is updatable.

   Views containing things such as GROUP BY, aggregate
   functions, DISTINCT, UNION, etc. generally cannot be
   directly modified in the same way as a simple single-table
   View.
   ============================================================ */


/* ============================================================
   PART 9: UPDATE DATA THROUGH SIMPLE VIEW
   ============================================================ */


/* ------------------------------------------------------------
   EmployeeView is based on one table:

       Employee

   Therefore, this simple View can be used for an UPDATE.

   Change Mohit's salary from 50000 to 55000.
   ------------------------------------------------------------ */

UPDATE EmployeeView
SET Salary = 55000
WHERE EmployeeID = 1;
GO


/* ------------------------------------------------------------
   Check the original table.

   The underlying Employee table is changed because the View
   represents data from Employee.
   ------------------------------------------------------------ */

SELECT *
FROM Employee
WHERE EmployeeID = 1;
GO


/* ============================================================
   PART 10: INSERT THROUGH VIEW
   ============================================================ */


/* ------------------------------------------------------------
   Because EmployeeView contains columns from the Employee
   table, we can insert a new employee through the View.

   EmployeeID is an IDENTITY column, so we don't provide it.
   ------------------------------------------------------------ */

INSERT INTO EmployeeView
(
    EmployeeName,
    Email,
    DepartmentID,
    Salary
)
VALUES
(
    'Dev',
    'dev@gmail.com',
    2,
    47000
);
GO


/* ------------------------------------------------------------
   Check the underlying table.
   ------------------------------------------------------------ */

SELECT *
FROM Employee;
GO


/* ============================================================
   PART 11: DELETE THROUGH VIEW
   ============================================================ */


/* ------------------------------------------------------------
   Delete Dev through the View.

   Because EmployeeView represents Employee directly,
   this DELETE affects the underlying Employee table.
   ------------------------------------------------------------ */

DELETE FROM EmployeeView
WHERE EmployeeName = 'Dev';
GO


/* ------------------------------------------------------------
   Check the table after DELETE.
   ------------------------------------------------------------ */

SELECT *
FROM Employee;
GO


/* ============================================================
   PART 12: ALTER VIEW
   ============================================================ */


/* ------------------------------------------------------------
   ALTER VIEW is used to change an existing View.

   Here we modify EmployeeView and add a calculated column:

       SalaryCategory

   Salary >= 50000 -> High Salary
   Salary < 50000  -> Normal Salary
   ------------------------------------------------------------ */

ALTER VIEW EmployeeView
AS
SELECT
    EmployeeID,
    EmployeeName,
    Email,
    DepartmentID,
    Salary,

    CASE
        WHEN Salary >= 50000 THEN 'High Salary'
        ELSE 'Normal Salary'
    END AS SalaryCategory

FROM Employee;
GO


/* ------------------------------------------------------------
   Check modified View
   ------------------------------------------------------------ */

SELECT *
FROM EmployeeView;
GO


/* ============================================================
   PART 13: CREATE VIEW WITH WHERE
   ============================================================ */


/* ------------------------------------------------------------
   This View displays only IT employees.

   NOTE:
   The DepartmentID for IT is 1 in our sample data.
   ------------------------------------------------------------ */

CREATE VIEW ITEmployeeView
AS
SELECT
    EmployeeID,
    EmployeeName,
    Email,
    DepartmentID,
    Salary
FROM Employee
WHERE DepartmentID = 1;
GO


/* ------------------------------------------------------------
   Display IT employees
   ------------------------------------------------------------ */

SELECT *
FROM ITEmployeeView;
GO


/* ============================================================
   PART 14: VIEW DEFINITION
   ============================================================ */


/* ------------------------------------------------------------
   sp_helptext displays the definition/query of a View.
   ------------------------------------------------------------ */

EXEC sp_helptext 'EmployeeView';
GO


/* ============================================================
   PART 15: LIST ALL VIEWS
   ============================================================ */

SELECT
    TABLE_NAME
FROM INFORMATION_SCHEMA.VIEWS;
GO


/* ============================================================
   PART 16: DROP VIEW
   ============================================================ */


/* ------------------------------------------------------------
   DROP VIEW permanently removes the View definition.

   IMPORTANT:
   Dropping a View does NOT normally delete the underlying
   table data.

   We are demonstrating the command with ITEmployeeView.
   ------------------------------------------------------------ */

DROP VIEW ITEmployeeView;
GO


/* ============================================================
   FINAL CHECK
   ============================================================ */

SELECT *
FROM EmployeeView;
GO

SELECT *
FROM EmployeeDepartmentView;
GO

SELECT *
FROM DepartmentSummaryView;
GO


/* ============================================================
   FINAL SUMMARY
   ============================================================

   VIEW:
       A saved SELECT query / virtual table.

   CREATE VIEW:
       Creates a new View.

   SELECT FROM VIEW:
       Used for DQL.

   UPDATE VIEW:
       Can modify underlying data when the View is updatable.

   INSERT INTO VIEW:
       Can insert into the underlying table when the View
       satisfies SQL Server's updatability rules.

   DELETE FROM VIEW:
       Can delete from the underlying table when the View
       is updatable.

   ALTER VIEW:
       Changes an existing View.

   DROP VIEW:
       Removes the View definition.

   JOIN VIEW:
       Combines data from multiple tables.

   GROUP BY VIEW:
       Can provide summary/reporting information.

   IMPORTANT:
       Not every View can be used for INSERT, UPDATE or DELETE.
       Complex Views may be read-only for practical purposes.

   ============================================================ */

