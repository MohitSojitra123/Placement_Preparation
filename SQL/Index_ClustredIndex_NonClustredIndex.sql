/* ============================================================
   SQL SERVER INDEX - COMPLETE DEMO
   SQL SERVER MANAGEMENT STUDIO (SSMS)

   Topics Covered:
   1. What is an INDEX?
   2. Why do we use INDEX?
   3. Clustered Index
   4. Nonclustered Index
   5. Unique Index
   6. Composite Index
   7. Filtered Index
   8. Index with INCLUDE
   9. View Existing Indexes
   10. Rebuild Index
   11. Reorganize Index
   12. Drop Index
   ============================================================ */


/* ============================================================
   STEP 1: CREATE DATABASE
   ============================================================ */

CREATE DATABASE IndexDemoDB;
GO

USE IndexDemoDB;
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
(4, 'Sales'),
(5, 'Marketing');
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
    City VARCHAR(50),
    Status VARCHAR(20),

    CONSTRAINT FK_Employee_Department
        FOREIGN KEY (DepartmentID)
        REFERENCES Department(DepartmentID)
);
GO


/* ============================================================
   STEP 5: INSERT SAMPLE DATA
   ============================================================ */

INSERT INTO Employee
(
    EmployeeName,
    Email,
    DepartmentID,
    Salary,
    City,
    Status
)
VALUES
('Mohit', 'mohit@gmail.com', 1, 50000, 'Rajkot', 'Active'),
('Rahul', 'rahul@gmail.com', 2, 45000, 'Ahmedabad', 'Active'),
('Amit', 'amit@gmail.com', 3, 55000, 'Surat', 'Active'),
('Jay', 'jay@gmail.com', 1, 60000, 'Rajkot', 'Active'),
('Karan', 'karan@gmail.com', 4, 48000, 'Vadodara', 'Inactive'),
('Tirth', 'tirth@gmail.com', 1, 52000, 'Rajkot', 'Active'),
('Dev', 'dev@gmail.com', 5, 47000, 'Ahmedabad', 'Active'),
('Raj', 'raj@gmail.com', 3, 65000, 'Surat', 'Active');
GO


/* ============================================================
   STEP 6: CHECK TABLE DATA
   ============================================================ */

SELECT *
FROM Employee;
GO


/* ============================================================
   ============================================================
   PART 1: WHAT IS AN INDEX?
   ============================================================
   
   An INDEX is a database object used to make data retrieval
   faster.

   Without a suitable index:

       Query
         ↓
       Table
         ↓
   Search many rows
         ↓
      Result


   With an index:

       Query
         ↓
       INDEX
         ↓
    Find matching rows
         ↓
       Table
         ↓
      Result


   Real-world example:

   A book has 1000 pages.

   Without an index:
       You may need to search page by page.

   With an index:
       You can quickly find the required topic/page.


   Database INDEX works with a similar idea.

   ============================================================
   ============================================================ */


/* ============================================================
   PART 2: CLUSTERED INDEX
   ============================================================

   A Clustered Index determines the physical/logical ordering
   of rows in the table's data structure.

   Important:
       A table can have ONLY ONE clustered index.

   A PRIMARY KEY is commonly implemented as a clustered index
   by default in SQL Server, unless another choice is specified.

   Our Employee table already has:

       EmployeeID INT IDENTITY PRIMARY KEY

   Therefore SQL Server normally creates a clustered index
   for the Primary Key.

   ============================================================ */


/* ============================================================
   CHECK PRIMARY KEY / CLUSTERED INDEX
   ============================================================ */

EXEC sp_helpindex 'Employee';
GO


/* ============================================================
   CREATE ANOTHER CLUSTERED INDEX
   ============================================================

   IMPORTANT:
   Employee already has a clustered index through its
   Primary Key.

   Therefore, the following command will NOT work unless
   the existing clustered index is removed/changed.

   Example syntax:

       CREATE CLUSTERED INDEX IX_Employee_EmployeeName
       ON Employee(EmployeeName);

   A table can have only ONE clustered index.

   ============================================================ */


/* ============================================================
   PART 3: NONCLUSTERED INDEX
   ============================================================

   A Nonclustered Index is a separate index structure that
   stores indexed key values and references to the actual rows.

   A table can have MULTIPLE nonclustered indexes.

   Example:
   We frequently search employees by DepartmentID.

   ============================================================ */

CREATE NONCLUSTERED INDEX IX_Employee_DepartmentID
ON Employee(DepartmentID);
GO


/* ============================================================
   USE NONCLUSTERED INDEX

   This query searches employees by DepartmentID.

   SQL Server's optimizer may choose the index when it is
   beneficial based on the data and query.
   ============================================================ */

SELECT *
FROM Employee
WHERE DepartmentID = 1;
GO


/* ============================================================
   ANOTHER NONCLUSTERED INDEX

   Suppose we frequently search by City.
   ============================================================ */

CREATE NONCLUSTERED INDEX IX_Employee_City
ON Employee(City);
GO


/* ============================================================
   SEARCH USING CITY
   ============================================================ */

SELECT *
FROM Employee
WHERE City = 'Rajkot';
GO


/* ============================================================
   PART 4: UNIQUE INDEX
   ============================================================

   A UNIQUE INDEX prevents duplicate values in the indexed
   key columns.

   Email should normally be unique for employees.

   ============================================================ */

CREATE UNIQUE NONCLUSTERED INDEX IX_Employee_Email
ON Employee(Email);
GO


/* ============================================================
   TEST UNIQUE INDEX

   The following INSERT should fail because the email already
   exists.

   Uncomment to test:

   INSERT INTO Employee
   (
       EmployeeName,
       Email,
       DepartmentID,
       Salary,
       City,
       Status
   )
   VALUES
   (
       'Test User',
       'mohit@gmail.com',
       1,
       50000,
       'Rajkot',
       'Active'
   );

   SQL Server will report a duplicate-key error.
   ============================================================ */


/* ============================================================
   PART 5: COMPOSITE INDEX
   ============================================================

   A Composite Index uses MORE THAN ONE column.

   Example:

       DepartmentID + Salary

   ============================================================ */

CREATE NONCLUSTERED INDEX IX_Employee_Department_Salary
ON Employee
(
    DepartmentID,
    Salary
);
GO


/* ============================================================
   QUERY USING COMPOSITE INDEX
   ============================================================ */

SELECT
    EmployeeID,
    EmployeeName,
    DepartmentID,
    Salary
FROM Employee
WHERE DepartmentID = 1
AND Salary > 50000;
GO


/* ============================================================
   IMPORTANT:
   COLUMN ORDER MATTERS IN A COMPOSITE INDEX.

   Index:

       (DepartmentID, Salary)

   is especially useful for queries beginning with:

       DepartmentID

   For example:

       WHERE DepartmentID = 1

   or:

       WHERE DepartmentID = 1
       AND Salary > 50000

   ============================================================ */


/* ============================================================
   PART 6: FILTERED INDEX
   ============================================================

   A Filtered Index contains only rows satisfying a WHERE
   condition.

   Example:

   We frequently search ACTIVE employees.

   Instead of indexing every employee, create an index
   containing only Active employees.

   ============================================================ */

CREATE NONCLUSTERED INDEX IX_Employee_Active
ON Employee(EmployeeName)
WHERE Status = 'Active';
GO


/* ============================================================
   QUERY FOR ACTIVE EMPLOYEES
   ============================================================ */

SELECT
    EmployeeID,
    EmployeeName,
    Email,
    DepartmentID,
    Salary
FROM Employee
WHERE Status = 'Active'
AND EmployeeName = 'Mohit';
GO


/* ============================================================
   PART 7: INDEX WITH INCLUDE
   ============================================================

   INCLUDE allows additional non-key columns to be stored
   in the leaf level of a nonclustered index.

   Example:

       Search by DepartmentID

   but return:

       EmployeeName
       Salary
       Email

   ============================================================ */

CREATE NONCLUSTERED INDEX IX_Employee_Department
ON Employee(DepartmentID)
INCLUDE
(
    EmployeeName,
    Salary,
    Email
);
GO


/* ============================================================
   QUERY USING INDEX WITH INCLUDE
   ============================================================ */

SELECT
    EmployeeName,
    Salary,
    Email
FROM Employee
WHERE DepartmentID = 1;
GO


/* ============================================================
   PART 8: INDEX FOR SORTING
   ============================================================

   Indexes can also help queries involving ORDER BY,
   depending on the query and execution plan.

   Example:
   Find employees ordered by salary.
   ============================================================ */

CREATE NONCLUSTERED INDEX IX_Employee_Salary
ON Employee(Salary);
GO


SELECT
    EmployeeID,
    EmployeeName,
    Salary
FROM Employee
ORDER BY Salary;
GO


/* ============================================================
   PART 9: DESCENDING INDEX
   ============================================================

   We can specify ASC or DESC for index key ordering.

   ============================================================ */

CREATE NONCLUSTERED INDEX IX_Employee_Salary_DESC
ON Employee(Salary DESC);
GO


/* ============================================================
   PART 10: VIEW ALL INDEXES
   ============================================================ */


/* Method 1: sp_helpindex */

EXEC sp_helpindex 'Employee';
GO


/* Method 2: sys.indexes */

SELECT
    name AS IndexName,
    type_desc AS IndexType,
    is_unique AS IsUnique,
    is_primary_key AS IsPrimaryKey,
    is_disabled AS IsDisabled
FROM sys.indexes
WHERE object_id = OBJECT_ID('Employee');
GO


/* ============================================================
   PART 11: VIEW INDEX COLUMNS
   ============================================================ */

SELECT
    I.name AS IndexName,
    C.name AS ColumnName,
    IC.key_ordinal AS KeyOrder
FROM sys.indexes AS I
INNER JOIN sys.index_columns AS IC
    ON I.object_id = IC.object_id
    AND I.index_id = IC.index_id
INNER JOIN sys.columns AS C
    ON IC.object_id = C.object_id
    AND IC.column_id = C.column_id
WHERE I.object_id = OBJECT_ID('Employee')
ORDER BY
    I.name,
    IC.key_ordinal;
GO


/* ============================================================
   PART 12: REBUILD INDEX
   ============================================================

   REBUILD recreates the index.

   It can be used as part of index maintenance when
   fragmentation warrants it.

   ============================================================ */

ALTER INDEX IX_Employee_City
ON Employee
REBUILD;
GO


/* ============================================================
   PART 13: REORGANIZE INDEX
   ============================================================

   REORGANIZE performs a lighter online index maintenance
   operation.

   ============================================================ */

ALTER INDEX IX_Employee_DepartmentID
ON Employee
REORGANIZE;
GO


/* ============================================================
   PART 14: REBUILD ALL INDEXES
   ============================================================ */

ALTER INDEX ALL
ON Employee
REBUILD;
GO


/* ============================================================
   PART 15: DROP AN INDEX
   ============================================================

   If an index is no longer required, it can be removed.

   Syntax:

       DROP INDEX IndexName
       ON TableName;

   ============================================================ */

DROP INDEX IX_Employee_City
ON Employee;
GO


/* ============================================================
   PART 16: CHECK EXECUTION PLAN
   ============================================================

   In SSMS, you can use:

       Ctrl + M

   to enable the Actual Execution Plan.

   Then execute a query such as:

       SELECT *
       FROM Employee
       WHERE DepartmentID = 1;

   SSMS can show whether SQL Server used an Index Seek,
   Index Scan, Table Scan, etc.

   ============================================================ */

SELECT *
FROM Employee
WHERE DepartmentID = 1;
GO


/* ============================================================
   PART 17: DROP OTHER DEMO INDEXES
   ============================================================

   These commands are optional.

   They are included so the database can be cleaned up after
   practicing the examples.

   ============================================================ */

DROP INDEX IX_Employee_Salary
ON Employee;
GO

DROP INDEX IX_Employee_Salary_DESC
ON Employee;
GO

DROP INDEX IX_Employee_Active
ON Employee;
GO

DROP INDEX IX_Employee_Department_Salary
ON Employee;
GO

DROP INDEX IX_Employee_Department
ON Employee;
GO

DROP INDEX IX_Employee_Email
ON Employee;
GO


/* ============================================================
   FINAL INDEX CHECK
   ============================================================ */

EXEC sp_helpindex 'Employee';
GO


/* ============================================================
   FINAL SUMMARY
   ============================================================

   1. CLUSTERED INDEX
   ------------------
   Determines the ordering of table data.

   One table can have only ONE clustered index.

   Example:

       CREATE CLUSTERED INDEX IX_Name
       ON Employee(EmployeeName);


   2. NONCLUSTERED INDEX
   ---------------------
   Separate index structure pointing to table rows.

   Multiple nonclustered indexes can exist.

   Example:

       CREATE NONCLUSTERED INDEX IX_Name
       ON Employee(EmployeeName);


   3. UNIQUE INDEX
   ----------------
   Prevents duplicate values.

   Example:

       CREATE UNIQUE INDEX IX_Email
       ON Employee(Email);


   4. COMPOSITE INDEX
   ------------------
   Index on multiple columns.

   Example:

       CREATE INDEX IX_Department_Salary
       ON Employee(DepartmentID, Salary);


   5. FILTERED INDEX
   -----------------
   Index contains only rows matching a condition.

   Example:

       CREATE INDEX IX_Active
       ON Employee(EmployeeName)
       WHERE Status = 'Active';


   6. INDEX WITH INCLUDE
   ---------------------
   Adds non-key columns to the index.

   Example:

       CREATE INDEX IX_Department
       ON Employee(DepartmentID)
       INCLUDE(EmployeeName, Salary);


   7. REBUILD
   ----------
   Recreates an index to address fragmentation when
   appropriate.


   8. REORGANIZE
   -------------
   Performs lighter index maintenance.


   ============================================================
   IMPORTANT POINTS
   ============================================================

   INDEX improves READ/SEARCH performance in appropriate
   scenarios.

   But too many indexes can increase the cost of:

       INSERT
       UPDATE
       DELETE

   because indexes may also need to be maintained.

   Therefore:

       Don't create an index on every column.

   Create indexes based on actual query patterns,
   constraints, and execution plans.

   ============================================================ */
