/* ============================================================
   OFFSET AND FETCH IN SQL SERVER
   ============================================================

   OFFSET  -> Skips rows
   FETCH   -> Limits/returns rows after OFFSET

   IMPORTANT:
   OFFSET and FETCH are normally used with ORDER BY.
   ============================================================ */


/* ============================================================
   1. CREATE DATABASE
   ============================================================ */

CREATE DATABASE OffsetFetchDemo;
GO

USE OffsetFetchDemo;
GO


/* ============================================================
   2. CREATE TABLE
   ============================================================ */

CREATE TABLE Employee
(
    EmployeeID INT IDENTITY(1,1) PRIMARY KEY,
    EmployeeName VARCHAR(50),
    Department VARCHAR(50),
    Salary DECIMAL(10,2),
    City VARCHAR(50)
);
GO


/* ============================================================
   3. INSERT SAMPLE DATA
   ============================================================ */

INSERT INTO Employee
(EmployeeName, Department, Salary, City)
VALUES
('Mohit',  'IT',       80000, 'Rajkot'),
('Rahul',  'IT',       70000, 'Ahmedabad'),
('Amit',   'IT',       90000, 'Surat'),
('Jay',    'HR',       75000, 'Rajkot'),
('Karan',  'HR',       60000, 'Ahmedabad'),
('Tirth',  'Finance',  85000, 'Vadodara'),
('Raj',    'Finance',  65000, 'Rajkot'),
('Vishal', 'Sales',    72000, 'Surat'),
('Dev',    'Marketing',68000, 'Ahmedabad'),
('Ravi',   'IT',       95000, 'Rajkot'),
('Akash',  'Sales',    78000, 'Vadodara'),
('Nikhil', 'HR',       62000, 'Surat');
GO


/* ============================================================
   4. DISPLAY ALL DATA
   ============================================================ */

SELECT *
FROM Employee
ORDER BY EmployeeID;


/*
RESULT:

EmployeeID  EmployeeName  Department   Salary
------------------------------------------------
1           Mohit         IT           80000
2           Rahul         IT           70000
3           Amit          IT           90000
4           Jay           HR           75000
5           Karan         HR           60000
6           Tirth         Finance      85000
7           Raj           Finance      65000
8           Vishal        Sales        72000
9           Dev           Marketing    68000
10          Ravi          IT           95000
11          Akash         Sales        78000
12          Nikhil        HR           62000
*/


/* ============================================================
   5. OFFSET ONLY
   ============================================================

   OFFSET 5 ROWS

   Means:
   Skip the first 5 rows.

   Since FETCH is not used, SQL Server returns all
   remaining rows after the skipped rows.
   ============================================================ */

SELECT *
FROM Employee
ORDER BY EmployeeID
OFFSET 5 ROWS;


/*
SKIPPED:
1, 2, 3, 4, 5

RETURNED:
6, 7, 8, 9, 10, 11, 12
*/


/* ============================================================
   6. OFFSET + FETCH
   ============================================================

   Skip 5 rows
   Return next 3 rows
   ============================================================ */

SELECT *
FROM Employee
ORDER BY EmployeeID
OFFSET 5 ROWS
FETCH NEXT 3 ROWS ONLY;


/*
RESULT:

EmployeeID  EmployeeName
-------------------------
6           Tirth
7           Raj
8           Vishal

Explanation:

OFFSET 5
    ↓
Skip EmployeeID 1 to 5

FETCH NEXT 3
    ↓
Return EmployeeID 6, 7, 8
*/


/* ============================================================
   7. FETCH FIRST 5 ROWS
   ============================================================

   OFFSET 0 means:
   Do not skip anything.

   FETCH NEXT 5 means:
   Return first 5 rows.
   ============================================================ */

SELECT *
FROM Employee
ORDER BY EmployeeID
OFFSET 0 ROWS
FETCH NEXT 5 ROWS ONLY;


/*
RESULT:

1  Mohit
2  Rahul
3  Amit
4  Jay
5  Karan
*/


/* ============================================================
   8. PAGINATION EXAMPLE
   ============================================================

   Suppose a website displays:

   Page Size = 5

   PAGE 1:
   Skip 0 rows
   Return 5 rows

   PAGE 2:
   Skip 5 rows
   Return 5 rows

   PAGE 3:
   Skip 10 rows
   Return 5 rows
   ============================================================ */


/* -------------------------
   PAGE 1
   ------------------------- */

SELECT *
FROM Employee
ORDER BY EmployeeID
OFFSET 0 ROWS
FETCH NEXT 5 ROWS ONLY;


/* -------------------------
   PAGE 2
   ------------------------- */

SELECT *
FROM Employee
ORDER BY EmployeeID
OFFSET 5 ROWS
FETCH NEXT 5 ROWS ONLY;


/* -------------------------
   PAGE 3
   ------------------------- */

SELECT *
FROM Employee
ORDER BY EmployeeID
OFFSET 10 ROWS
FETCH NEXT 5 ROWS ONLY;


/*
PAGE 1:
1, 2, 3, 4, 5

PAGE 2:
6, 7, 8, 9, 10

PAGE 3:
11, 12
*/


/* ============================================================
   9. OFFSET/FETCH WITH SALARY SORTING
   ============================================================

   We can use OFFSET/FETCH after sorting by Salary.

   Here:
   Highest salaries are displayed first.

   Skip the first 2 highest-paid employees
   and return the next 3 employees.
   ============================================================ */

SELECT
    EmployeeID,
    EmployeeName,
    Department,
    Salary
FROM Employee
ORDER BY Salary DESC
OFFSET 2 ROWS
FETCH NEXT 3 ROWS ONLY;


/*
Salary DESC:

95000
90000
85000
80000
78000
...

OFFSET 2:
Skip 95000 and 90000

FETCH 3:
Return:

85000
80000
78000
*/


/* ============================================================
   10. OFFSET/FETCH WITH WHERE
   ============================================================

   First filter the data using WHERE.

   Then sort the filtered result.

   Then OFFSET/FETCH is applied.
   ============================================================ */

SELECT
    EmployeeID,
    EmployeeName,
    Department,
    Salary
FROM Employee
WHERE Department = 'IT'
ORDER BY Salary DESC
OFFSET 1 ROWS
FETCH NEXT 2 ROWS ONLY;


/*
IT employees:

Ravi    95000
Amit    90000
Mohit   80000
Rahul   70000

OFFSET 1:
Skip Ravi (95000)

FETCH 2:
Return:

Amit    90000
Mohit   80000
*/


/* ============================================================
   11. OFFSET/FETCH USING VARIABLES
   ============================================================

   This is useful for dynamic pagination.
   ============================================================ */

DECLARE @PageNumber INT = 2;
DECLARE @PageSize INT = 5;

SELECT *
FROM Employee
ORDER BY EmployeeID
OFFSET (@PageNumber - 1) * @PageSize ROWS
FETCH NEXT @PageSize ROWS ONLY;


/*
Formula:

OFFSET = (PageNumber - 1) * PageSize

For Page 2:

OFFSET = (2 - 1) * 5
       = 5

FETCH = 5

Therefore:

Skip 5 rows
Return next 5 rows
*/


/* ============================================================
   12. CHANGE PAGE NUMBER
   ============================================================ */

DECLARE @PageNumber INT = 3;
DECLARE @PageSize INT = 5;

SELECT *
FROM Employee
ORDER BY EmployeeID
OFFSET (@PageNumber - 1) * @PageSize ROWS
FETCH NEXT @PageSize ROWS ONLY;


/*
PAGE 3:

OFFSET = (3 - 1) * 5
       = 10

FETCH = 5

Result:

EmployeeID 11
EmployeeID 12
*/


/* ============================================================
   13. PAGINATION WITH TOTAL RECORD COUNT
   ============================================================

   Often an application needs:

   1. Current page records
   2. Total number of records

   Example:
   ============================================================ */

SELECT
    EmployeeID,
    EmployeeName,
    Department,
    Salary,

    -- Total number of employees
    COUNT(*) OVER() AS TotalEmployees

FROM Employee
ORDER BY EmployeeID
OFFSET 5 ROWS
FETCH NEXT 5 ROWS ONLY;


/*
Each returned row will contain:

EmployeeID
EmployeeName
Department
Salary
TotalEmployees

TotalEmployees = 12

This is useful for creating:

Previous | 1 | 2 | 3 | Next

pagination controls.
*/


/* ============================================================
   14. OFFSET/FETCH WITH DISTINCT
   ============================================================ */

SELECT DISTINCT Department
FROM Employee
ORDER BY Department
OFFSET 1 ROWS
FETCH NEXT 2 ROWS ONLY;


/*
First SQL Server creates the distinct department result,
then ORDER BY sorts it,
then OFFSET/FETCH skips and limits the result.
*/


/* ============================================================
   15. IMPORTANT DIFFERENCE
   ============================================================

   TOP:
       Returns a fixed number from the beginning.

   OFFSET + FETCH:
       Allows us to SKIP rows and then RETURN a fixed number.

   Example:
   ============================================================ */


/* TOP */

SELECT TOP 5 *
FROM Employee
ORDER BY EmployeeID;


/* OFFSET + FETCH */

SELECT *
FROM Employee
ORDER BY EmployeeID
OFFSET 5 ROWS
FETCH NEXT 5 ROWS ONLY;


/*
TOP 5:
Returns rows 1-5.

OFFSET/FETCH:
Skips rows 1-5
Returns rows 6-10.
*/


/* ============================================================
   16. IMPORTANT RULE
   ============================================================

   OFFSET/FETCH should be used with ORDER BY.

   Correct:

   SELECT *
   FROM Employee
   ORDER BY EmployeeID
   OFFSET 5 ROWS
   FETCH NEXT 5 ROWS ONLY;


   The ORDER BY is important because without a deterministic
   ordering, there is no reliable concept of "first", "next",
   or "page".
   ============================================================ */


/* ============================================================
   17. REAL-WORLD EXAMPLE
   ============================================================

   Imagine an e-commerce website.

   There are 1,000 products.

   The website displays 20 products per page.

   PAGE 1:

   OFFSET = (1 - 1) * 20
          = 0

   FETCH = 20


   PAGE 2:

   OFFSET = (2 - 1) * 20
          = 20

   FETCH = 20


   PAGE 3:

   OFFSET = (3 - 1) * 20
          = 40

   FETCH = 20

   SQL:
   ============================================================ */

DECLARE @PageNumber INT = 3;
DECLARE @PageSize INT = 20;

SELECT *
FROM Employee
ORDER BY EmployeeID
OFFSET (@PageNumber - 1) * @PageSize ROWS
FETCH NEXT @PageSize ROWS ONLY;


/* ============================================================
   FINAL SUMMARY
   ============================================================

   OFFSET
   -------
   Specifies how many rows to SKIP.

   FETCH NEXT
   ----------
   Specifies how many rows to RETURN.

   Example:

   OFFSET 10 ROWS
   FETCH NEXT 5 ROWS ONLY;

   Meaning:

   Skip 10 rows
   Return the next 5 rows.


   PAGINATION FORMULA
   ------------------

   OFFSET = (PageNumber - 1) * PageSize

   FETCH = PageSize


   Example:

   PageNumber = 4
   PageSize   = 10

   OFFSET = (4 - 1) * 10
          = 30

   FETCH = 10

   Therefore:

   Skip 30 rows
   Return rows 31-40
   ============================================================ */



--| Statement                               | Meaning              |
--| --------------------------------------- | -------------------- |
--| `TOP 5`                                 | Give me first 5 rows |
--| `OFFSET 5 ROWS`                         | Skip first 5 rows    |
--| `FETCH NEXT 5 ROWS ONLY`                | Give me next 5 rows  |
--| `OFFSET 5 ROWS FETCH NEXT 5 ROWS ONLY`  | Skip 5, then give 5  |
--| `OFFSET 0 ROWS FETCH NEXT 5 ROWS ONLY`  | Give first 5         |
--| `OFFSET 10 ROWS FETCH NEXT 5 ROWS ONLY` | Skip 10, give next 5 |
