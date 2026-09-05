use demo_1


/* ============================================================
   FIND Nth HIGHEST SALARY
   SQL SERVER / SSMS

   Topics Covered:
   1. Sample Employee Table
   2. Find Highest Salary
   3. Find 2nd Highest Salary
   4. Find Nth Highest Salary using SUBQUERY
   5. Find Nth Highest Salary using ROW_NUMBER()
   6. Find Nth Highest Salary using DENSE_RANK()
   7. Difference between ROW_NUMBER, RANK and DENSE_RANK
   ============================================================ */


/* ============================================================
   STEP 1: CREATE DATABASE
   ============================================================ */

CREATE DATABASE NthHighestSalaryDB;
GO

USE NthHighestSalaryDB;
GO


/* ============================================================
   STEP 2: CREATE EMPLOYEE TABLE
   ============================================================ */

CREATE TABLE Employee
(
    EmployeeID INT IDENTITY(1,1) PRIMARY KEY,
    EmployeeName VARCHAR(50),
    Department VARCHAR(50),
    Salary DECIMAL(10,2)
);
GO


/* ============================================================
   STEP 3: INSERT SAMPLE DATA
   ============================================================ */

INSERT INTO Employee
(
    EmployeeName,
    Department,
    Salary
)
VALUES
('Mohit', 'IT', 80000),
('Rahul', 'HR', 70000),
('Amit', 'Finance', 90000),
('Jay', 'IT', 75000),
('Karan', 'Sales', 60000),
('Tirth', 'IT', 90000),
('Dev', 'HR', 70000),
('Raj', 'Finance', 65000);
GO


/* ============================================================
   STEP 4: DISPLAY ALL EMPLOYEES
   ============================================================ */

SELECT *
FROM Employee
ORDER BY Salary DESC;
GO


/* ============================================================
   PART 1:
   FIND HIGHEST SALARY
   ============================================================ */

SELECT MAX(Salary) AS HighestSalary
FROM Employee;
GO


/* ============================================================
   PART 2:
   FIND 2nd HIGHEST SALARY USING SUBQUERY
   ============================================================

   First:
       Find MAX(Salary)

   Then:
       Find the maximum salary that is less than
       the highest salary.

   ============================================================ */

SELECT MAX(Salary) AS SecondHighestSalary
FROM Employee
WHERE Salary <
(
    SELECT MAX(Salary)
    FROM Employee
);
GO


/* ============================================================
   PART 3:
   FIND Nth HIGHEST SALARY USING SUBQUERY

   Example:
       N = 3

   We use DISTINCT because multiple employees may have
   the same salary.

   ORDER BY Salary DESC
       Highest salary comes first.

   OFFSET 2
       Skip first 2 different salaries.

   FETCH NEXT 1 ROW
       Return the 3rd salary.

   ============================================================ */

SELECT DISTINCT Salary
FROM Employee
ORDER BY Salary DESC
OFFSET 2 ROWS
FETCH NEXT 1 ROW ONLY;
GO


/* ============================================================
   PART 4:
   Nth HIGHEST SALARY USING ROW_NUMBER()
   ============================================================

   ROW_NUMBER() gives a unique number to every row.

   Example:

   Salary     RowNumber
   --------------------
   90000         1
   90000         2
   80000         3
   75000         4
   70000         5
   70000         6
   65000         7
   60000         8

   IMPORTANT:
   ROW_NUMBER() treats duplicate salaries as separate rows.
   ============================================================ */

SELECT
    EmployeeID,
    EmployeeName,
    Salary,

    ROW_NUMBER() OVER
    (
        ORDER BY Salary DESC
    ) AS RowNumber

FROM Employee;
GO


/* ============================================================
   PART 5:
   FIND 3rd HIGHEST SALARY USING ROW_NUMBER()
   ============================================================

   Because SQL Server cannot normally filter a window-function
   alias in the same SELECT's WHERE clause, use a subquery.

   ============================================================ */

SELECT
    EmployeeID,
    EmployeeName,
    Department,
    Salary
FROM
(
    SELECT
        EmployeeID,
        EmployeeName,
        Department,
        Salary,

        ROW_NUMBER() OVER
        (
            ORDER BY Salary DESC
        ) AS RowNumber

    FROM Employee
) AS SalaryData

WHERE RowNumber = 3;
GO


/* ============================================================
   RESULT:

   If salaries are:

       90000
       90000
       80000
       75000
       70000
       70000
       65000
       60000

   ROW_NUMBER():

       90000 -> 1
       90000 -> 2
       80000 -> 3

   Therefore 3rd row = 80000.


   ============================================================
   PART 6:
   FIND Nth DISTINCT HIGHEST SALARY USING DENSE_RANK()
   ============================================================

   DENSE_RANK() gives the SAME rank to duplicate salaries.

   Example:

   Salary     DenseRank
   --------------------
   90000          1
   90000          1
   80000          2
   75000          3
   70000          4
   70000          4
   65000          5
   60000          6

   Therefore:

       1st highest = 90000
       2nd highest = 80000
       3rd highest = 75000

   ============================================================ */

SELECT
    EmployeeID,
    EmployeeName,
    Department,
    Salary,

    DENSE_RANK() OVER
    (
        ORDER BY Salary DESC
    ) AS SalaryRank

FROM Employee;
GO


/* ============================================================
   PART 7:
   FIND 3rd HIGHEST DISTINCT SALARY USING DENSE_RANK()
   ============================================================ */

SELECT
    EmployeeID,
    EmployeeName,
    Department,
    Salary
FROM
(
    SELECT
        EmployeeID,
        EmployeeName,
        Department,
        Salary,

        DENSE_RANK() OVER
        (
            ORDER BY Salary DESC
        ) AS SalaryRank

    FROM Employee
) AS SalaryData

WHERE SalaryRank = 3;
GO


/* ============================================================
   RESULT:

   Salary:

       90000 -> Rank 1
       90000 -> Rank 1
       80000 -> Rank 2
       75000 -> Rank 3

   Therefore:

       3rd Highest Salary = 75000

   Employee:

       Jay

   ============================================================ */


/* ============================================================
   PART 8:
   USING A VARIABLE FOR Nth HIGHEST SALARY
   ============================================================

   Instead of hard-coding 3, we can use a variable.

   ============================================================ */

DECLARE @N INT = 3;

SELECT
    EmployeeID,
    EmployeeName,
    Department,
    Salary
FROM
(
    SELECT
        EmployeeID,
        EmployeeName,
        Department,
        Salary,

        DENSE_RANK() OVER
        (
            ORDER BY Salary DESC
        ) AS SalaryRank

    FROM Employee
) AS SalaryData

WHERE SalaryRank = @N;
GO


/* ============================================================
   PART 9:
   Nth HIGHEST SALARY USING SUBQUERY WITH NOT EXISTS
   ============================================================

   Another logical approach:

   A salary is the Nth highest when there are N-1 distinct
   salaries greater than it.

   This example finds the 3rd highest DISTINCT salary.

   ============================================================ */

SELECT DISTINCT E1.Salary
FROM Employee AS E1
WHERE
(
    SELECT COUNT(DISTINCT E2.Salary)
    FROM Employee AS E2
    WHERE E2.Salary > E1.Salary
) = 2;
GO


/* ============================================================
   PART 10:
   ROW_NUMBER vs RANK vs DENSE_RANK
   ============================================================ */


/* ------------------------------------------------------------
   Display all three window functions together.
   ------------------------------------------------------------ */

SELECT
    EmployeeName,
    Salary,

    ROW_NUMBER() OVER
    (
        ORDER BY Salary DESC
    ) AS RowNumber,

    RANK() OVER
    (
        ORDER BY Salary DESC
    ) AS RankNumber,

    DENSE_RANK() OVER
    (
        ORDER BY Salary DESC
    ) AS DenseRankNumber

FROM Employee;
GO


/* ============================================================
   EXPECTED CONCEPTUAL RESULT

   Salary     ROW_NUMBER    RANK    DENSE_RANK
   ---------------------------------------------
   90000          1           1          1
   90000          2           1          1
   80000          3           3          2
   75000          4           4          3
   70000          5           5          4
   70000          6           5          4
   65000          7           7          5
   60000          8           8          6


   IMPORTANT:

   ROW_NUMBER()
       Duplicate values receive DIFFERENT numbers.

   RANK()
       Duplicate values receive SAME rank,
       but ranks can have gaps.

   DENSE_RANK()
       Duplicate values receive SAME rank,
       and ranks do NOT have gaps.


   ============================================================
   PART 11:
   Nth HIGHEST SALARY - WHICH ONE SHOULD YOU USE?
   ============================================================

   If duplicate salaries should be treated as separate rows:

       ROW_NUMBER()

   If duplicate salaries should share the same rank
   and ranking gaps are acceptable:

       RANK()

   If duplicate salaries should share the same rank
   and you want consecutive ranks:

       DENSE_RANK()


   For the common interview question:

       "Find the Nth highest salary"

   DENSE_RANK() is often the clearest choice when
   "Nth highest" means Nth DISTINCT salary.


   ============================================================
   PART 12:
   FIND HIGHEST, 2nd, 3rd AND 4th HIGHEST SALARY
   ============================================================ */

SELECT
    SalaryRank,
    Salary
FROM
(
    SELECT
        Salary,

        DENSE_RANK() OVER
        (
            ORDER BY Salary DESC
        ) AS SalaryRank

    FROM Employee
) AS SalaryData

WHERE SalaryRank <= 4
GROUP BY
    SalaryRank,
    Salary
ORDER BY SalaryRank;
GO


/* ============================================================
   FINAL SUMMARY
   ============================================================

   METHOD 1: SUBQUERY
   ------------------

   SELECT MAX(Salary)
   FROM Employee
   WHERE Salary <
   (
       SELECT MAX(Salary)
       FROM Employee
   );


   METHOD 2: ROW_NUMBER()
   ----------------------

   ROW_NUMBER() OVER
   (
       ORDER BY Salary DESC
   )


   METHOD 3: DENSE_RANK()
   ----------------------

   DENSE_RANK() OVER
   (
       ORDER BY Salary DESC
   )


   METHOD 4: OFFSET / FETCH
   ------------------------

   SELECT DISTINCT Salary
   FROM Employee
   ORDER BY Salary DESC
   OFFSET N-1 ROWS
   FETCH NEXT 1 ROW ONLY;


   ============================================================
   EASY FORMULA
   ============================================================

   Nth Highest DISTINCT Salary
          ↓
   DENSE_RANK()
          ↓
   ORDER BY Salary DESC
          ↓
   WHERE SalaryRank = N


   Example:

       N = 3

       DENSE_RANK()
              ↓
       Salary DESC
              ↓
       SalaryRank = 3
              ↓
       3rd Highest Salary


   ============================================================ */
