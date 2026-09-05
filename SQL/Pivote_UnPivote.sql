```sql
/* ============================================================
   PIVOT AND UNPIVOT DEMO
   SQL SERVER / SSMS
   ============================================================ */


/* ============================================================
   STEP 1: CREATE DATABASE
   ============================================================ */

CREATE DATABASE PivotUnpivotDemo;
GO

USE PivotUnpivotDemo;
GO


/* ============================================================
   STEP 2: CREATE TABLE
   ============================================================ */

CREATE TABLE EmployeeSalary
(
    EmployeeID INT IDENTITY(1,1) PRIMARY KEY,

    EmployeeName VARCHAR(50),

    Department VARCHAR(50),

    SalaryYear INT,

    Salary DECIMAL(10,2)
);
GO


/* ============================================================
   STEP 3: INSERT SAMPLE DATA
   ============================================================ */

INSERT INTO EmployeeSalary
(
    EmployeeName,
    Department,
    SalaryYear,
    Salary
)
VALUES
('Mohit', 'IT',      2024, 50000),
('Mohit', 'IT',      2025, 60000),
('Mohit', 'IT',      2026, 70000),

('Rahul', 'HR',      2024, 45000),
('Rahul', 'HR',      2025, 50000),
('Rahul', 'HR',      2026, 55000),

('Amit',  'Finance', 2024, 55000),
('Amit',  'Finance', 2025, 65000),
('Amit',  'Finance', 2026, 75000),

('Jay',   'Sales',   2024, 40000),
('Jay',   'Sales',   2025, 45000),
('Jay',   'Sales',   2026, 50000);
GO


/* ============================================================
   STEP 4: VIEW ORIGINAL DATA
   ============================================================ */

SELECT *
FROM EmployeeSalary
ORDER BY EmployeeName, SalaryYear;


/*
OUTPUT:

EmployeeName    Department    SalaryYear    Salary
---------------------------------------------------
Amit            Finance       2024          55000
Amit            Finance       2025          65000
Amit            Finance       2026          75000

Jay             Sales         2024          40000
Jay             Sales         2025          45000
Jay             Sales         2026          50000

Mohit           IT            2024          50000
Mohit           IT            2025          60000
Mohit           IT            2026          70000

Rahul           HR            2024          45000
Rahul           HR            2025          50000
Rahul           HR            2026          55000
*/


/* ============================================================
   STEP 5: BASIC PIVOT
   ============================================================

   We want:

   SalaryYear
       2024
       2025
       2026

   to become:

       2024 | 2025 | 2026

   Salary is the value that we want to display.
*/


SELECT
    EmployeeName,
    Department,
    [2024],
    [2025],
    [2026]
FROM
(
    SELECT
        EmployeeName,
        Department,
        SalaryYear,
        Salary
    FROM EmployeeSalary
) AS SourceTable
PIVOT
(
    MAX(Salary)
    FOR SalaryYear IN
    (
        [2024],
        [2025],
        [2026]
    )
) AS PivotTable
ORDER BY EmployeeName;


/*
OUTPUT:

EmployeeName    Department    2024     2025     2026
-------------------------------------------------------
Amit            Finance       55000    65000    75000
Jay             Sales         40000    45000    50000
Mohit           IT            50000    60000    70000
Rahul           HR            45000    50000    55000
*/


/* ============================================================
   HOW PIVOT WORKS
   ============================================================

   PIVOT
   (
       MAX(Salary)
       FOR SalaryYear IN ([2024], [2025], [2026])
   )


   MAX(Salary)
   ------------
   This is the aggregate function.

   Salary
   -------
   This is the value that we want to put into the
   new columns.


   FOR SalaryYear
   ---------------
   SalaryYear is the column whose values will become
   new columns.


   IN ([2024], [2025], [2026])
   ----------------------------
   These are the columns that we want to create.


   So:

   SalaryYear       Salary
   2024             50000
   2025             60000
   2026             70000

               ↓ PIVOT

   2024       2025       2026
   50000      60000      70000
*/


/* ============================================================
   STEP 6: PIVOT WITH SUM
   ============================================================

   PIVOT does not require only MAX().

   We can use:

   SUM()
   AVG()
   COUNT()
   MAX()
   MIN()

   etc.
*/


SELECT
    Department,
    [2024],
    [2025],
    [2026]
FROM
(
    SELECT
        Department,
        SalaryYear,
        Salary
    FROM EmployeeSalary
) AS SourceTable
PIVOT
(
    SUM(Salary)
    FOR SalaryYear IN
    (
        [2024],
        [2025],
        [2026]
    )
) AS PivotTable
ORDER BY Department;


/*
OUTPUT:

Department    2024     2025     2026
---------------------------------------
Finance       55000    65000    75000
HR            45000    50000    55000
IT            50000    60000    70000
Sales         40000    45000    50000
*/


/* ============================================================
   STEP 7: PIVOT WITH COUNT
   ============================================================

   Suppose we want to count how many salary records
   each department has for each year.
*/


SELECT
    Department,
    [2024],
    [2025],
    [2026]
FROM
(
    SELECT
        Department,
        SalaryYear,
        EmployeeID
    FROM EmployeeSalary
) AS SourceTable
PIVOT
(
    COUNT(EmployeeID)
    FOR SalaryYear IN
    (
        [2024],
        [2025],
        [2026]
    )
) AS PivotTable
ORDER BY Department;


/*
OUTPUT:

Department    2024    2025    2026
------------------------------------
Finance          1       1       1
HR               1       1       1
IT               1       1       1
Sales            1       1       1
*/


/* ============================================================
   ============================================================
   UNPIVOT
   ============================================================
   ============================================================ */


/* ============================================================
   STEP 8: CREATE A PIVOTED TABLE
   ============================================================

   This table already has years as columns.

   This is a common format for reports.
*/


CREATE TABLE EmployeeSalaryReport
(
    EmployeeID INT,
    EmployeeName VARCHAR(50),
    Department VARCHAR(50),

    [2024] DECIMAL(10,2),

    [2025] DECIMAL(10,2),

    [2026] DECIMAL(10,2)
);
GO


/* ============================================================
   STEP 9: INSERT PIVOTED DATA
   ============================================================ */

INSERT INTO EmployeeSalaryReport
(
    EmployeeID,
    EmployeeName,
    Department,
    [2024],
    [2025],
    [2026]
)
VALUES
(1, 'Mohit', 'IT',      50000, 60000, 70000),
(2, 'Rahul', 'HR',      45000, 50000, 55000),
(3, 'Amit',  'Finance', 55000, 65000, 75000),
(4, 'Jay',   'Sales',   40000, 45000, 50000);
GO


/* ============================================================
   STEP 10: VIEW PIVOTED TABLE
   ============================================================ */

SELECT *
FROM EmployeeSalaryReport;


/*
OUTPUT:

EmployeeID    EmployeeName    Department    2024    2025    2026
------------------------------------------------------------------
1             Mohit           IT            50000   60000   70000
2             Rahul           HR            45000   50000   55000
3             Amit            Finance        55000   65000   75000
4             Jay             Sales          40000   45000   50000
*/


/* ============================================================
   STEP 11: UNPIVOT
   ============================================================

   UNPIVOT does the opposite of PIVOT.

   PIVOT:

   2024 | 2025 | 2026
     ↓      ↓      ↓
              Columns


   UNPIVOT:

   Columns
     ↓
   Rows
*/


SELECT
    EmployeeID,
    EmployeeName,
    Department,
    SalaryYear,
    Salary
FROM
(
    SELECT
        EmployeeID,
        EmployeeName,
        Department,
        [2024],
        [2025],
        [2026]
    FROM EmployeeSalaryReport
) AS SourceTable
UNPIVOT
(
    Salary
    FOR SalaryYear IN
    (
        [2024],
        [2025],
        [2026]
    )
) AS UnpivotTable
ORDER BY EmployeeName, SalaryYear;


/*
OUTPUT:

EmployeeID    EmployeeName    Department    SalaryYear    Salary
------------------------------------------------------------------
3             Amit            Finance       2024          55000
3             Amit            Finance       2025          65000
3             Amit            Finance       2026          75000

4             Jay             Sales         2024          40000
4             Jay             Sales         2025          45000
4             Jay             Sales         2026          50000

1             Mohit           IT            2024          50000
1             Mohit           IT            2025          60000
1             Mohit           IT            2026          70000

2             Rahul           HR            2024          45000
2             Rahul           HR            2025          50000
2             Rahul           HR            2026          55000
*/


/* ============================================================
   STEP 12: PIVOT vs UNPIVOT
   ============================================================

   PIVOT:

   ROWS
     ↓
   COLUMNS


   UNPIVOT:

   COLUMNS
     ↓
   ROWS


   PIVOT example:

   Employee   Year    Salary
   Mohit      2024    50000
   Mohit      2025    60000
   Mohit      2026    70000

            ↓

   Employee   2024    2025    2026
   Mohit      50000   60000   70000


   UNPIVOT example:

   Employee   2024    2025    2026
   Mohit      50000   60000   70000

            ↓

   Employee   Year    Salary
   Mohit      2024    50000
   Mohit      2025    60000
   Mohit      2026    70000
*/


/* ============================================================
   STEP 13: REAL-WORLD EXAMPLE - MONTHLY SALES
   ============================================================ */


CREATE TABLE Sales
(
    SaleID INT IDENTITY(1,1) PRIMARY KEY,

    ProductName VARCHAR(50),

    SaleMonth VARCHAR(20),

    Amount DECIMAL(10,2)
);
GO


INSERT INTO Sales
(
    ProductName,
    SaleMonth,
    Amount
)
VALUES
('Laptop', 'January', 50000),
('Laptop', 'February', 60000),
('Laptop', 'March', 70000),

('Mobile', 'January', 30000),
('Mobile', 'February', 40000),
('Mobile', 'March', 45000),

('Tablet', 'January', 20000),
('Tablet', 'February', 25000),
('Tablet', 'March', 30000);
GO


/* ============================================================
   SALES PIVOT
   ============================================================ */

SELECT
    ProductName,
    [January],
    [February],
    [March]
FROM
(
    SELECT
        ProductName,
        SaleMonth,
        Amount
    FROM Sales
) AS SourceTable
PIVOT
(
    SUM(Amount)
    FOR SaleMonth IN
    (
        [January],
        [February],
        [March]
    )
) AS PivotTable
ORDER BY ProductName;


/*
OUTPUT:

ProductName    January    February    March
---------------------------------------------
Laptop         50000      60000       70000
Mobile         30000      40000       45000
Tablet         20000      25000       30000


This is useful for a sales report/dashboard.
*/


/* ============================================================
   STEP 14: IMPORTANT PIVOT RULE
   ============================================================

   PIVOT generally has three important parts:

   1. Aggregate function
      SUM()
      COUNT()
      AVG()
      MAX()
      MIN()

   2. Column that becomes the new columns
      FOR SaleMonth

   3. Values that become actual column names
      IN ([January], [February], [March])


   General syntax:

   SELECT ...
   FROM
   (
       SELECT
           RowColumn,
           PivotColumn,
           ValueColumn
       FROM TableName
   ) AS SourceTable
   PIVOT
   (
       AggregateFunction(ValueColumn)
       FOR PivotColumn IN
       (
           [Value1],
           [Value2],
           [Value3]
       )
   ) AS PivotTable;
*/


/* ============================================================
   STEP 15: IMPORTANT UNPIVOT RULE
   ============================================================

   General syntax:

   SELECT ...
   FROM
   (
       SELECT
           ID,
           [Column1],
           [Column2],
           [Column3]
       FROM TableName
   ) AS SourceTable
   UNPIVOT
   (
       ValueColumn
       FOR NameColumn IN
       (
           [Column1],
           [Column2],
           [Column3]
       )
   ) AS UnpivotTable;


   PIVOT:

       FOR SalaryYear IN ([2024], [2025], [2026])


   UNPIVOT:

       FOR SalaryYear IN ([2024], [2025], [2026])

   Notice that the syntax looks similar, but their
   purpose is opposite.
*/


/* ============================================================
   FINAL SUMMARY
   ============================================================

   PIVOT
   -----------------------------
   Converts ROWS into COLUMNS.

   Example:

   Year       Salary
   2024       50000
   2025       60000
   2026       70000

          ↓ PIVOT

   2024    2025    2026
   50000   60000   70000


   UNPIVOT
   -----------------------------
   Converts COLUMNS into ROWS.

   Example:

   2024    2025    2026
   50000   60000   70000

          ↓ UNPIVOT

   Year       Salary
   2024       50000
   2025       60000
   2026       70000


   EASY MEMORY:

   PIVOT   = ROW → COLUMN
   UNPIVOT = COLUMN → ROW
   ============================================================ */
GO


--| Feature      | PIVOT                 | UNPIVOT                |
--| ------------ | --------------------- | ---------------------- |
--| Direction    | Rows → Columns        | Columns → Rows         |
--| Main purpose | Create summary/report | Normalize/reshape data |
--| Common use   | Reports               | Data transformation    |
--| Aggregate    | Required              | Not used               |
--| Example      | Months become columns | Months become rows     |
