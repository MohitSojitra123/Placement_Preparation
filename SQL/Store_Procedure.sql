/* ============================================================
   STORED PROCEDURE DEMO
   SQL SERVER / SSMS

   Topics Covered:
   1. What is Stored Procedure?
   2. DQL - SELECT
   3. DML - INSERT
   4. DML - UPDATE
   5. DML - DELETE
   6. IN Parameter
   7. OUT Parameter
   8. INOUT Parameter
   ============================================================ */


/* ============================================================
   STEP 1: CREATE DATABASE
   ============================================================ */

CREATE DATABASE StoreProcedureDemo;
GO

USE StoreProcedureDemo;
GO


/* ============================================================
   STEP 2: CREATE TABLE
   ============================================================ */

CREATE TABLE Employee
(
    EmployeeID INT IDENTITY(1,1) PRIMARY KEY,
    EmployeeName VARCHAR(50),
    Email VARCHAR(100),
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
    Email,
    Department,
    Salary
)
VALUES
('Mohit', 'mohit@gmail.com', 'IT', 50000),
('Rahul', 'rahul@gmail.com', 'HR', 45000),
('Amit', 'amit@gmail.com', 'Finance', 55000),
('Jay', 'jay@gmail.com', 'IT', 60000),
('Karan', 'karan@gmail.com', 'Sales', 48000);
GO


/* ============================================================
   ============================================================
   PART 1: DQL STORED PROCEDURE
   ============================================================
   DQL = Data Query Language

   Main DQL command:
       SELECT

   Purpose:
       Retrieve data from the database.
   ============================================================
   ============================================================ */


/* ============================================================
   PROCEDURE 1: SELECT ALL EMPLOYEES

   This procedure does not require any parameter.
   ============================================================ */

CREATE PROCEDURE GetAllEmployees
AS
BEGIN

    -- SELECT is a DQL command.
    -- It retrieves all employee records.

    SELECT
        EmployeeID,
        EmployeeName,
        Email,
        Department,
        Salary
    FROM Employee;

END;
GO


/* Execute the procedure */

EXEC GetAllEmployees;
GO


/* ============================================================
   PART 2: DQL WITH INPUT PARAMETER
   ============================================================ */


/* ============================================================
   PROCEDURE 2: FIND EMPLOYEE BY DEPARTMENT

   @Department is an INPUT parameter.

   User supplies:
       IT

   Procedure returns:
       Employees belonging to IT.
   ============================================================ */

CREATE PROCEDURE GetEmployeesByDepartment
    @Department VARCHAR(50)
AS
BEGIN

    -- @Department receives a value from the user.

    SELECT
        EmployeeID,
        EmployeeName,
        Email,
        Department,
        Salary
    FROM Employee
    WHERE Department = @Department;

END;
GO


/* Execute with INPUT parameter */

EXEC GetEmployeesByDepartment
    @Department = 'IT';
GO


/* ============================================================
   PART 3: DML - INSERT STORED PROCEDURE
   ============================================================ */


/* ============================================================
   PROCEDURE 3: INSERT EMPLOYEE

   DML commands include:
       INSERT
       UPDATE
       DELETE

   All values are received through INPUT parameters.
   ============================================================ */

CREATE PROCEDURE AddEmployee
    @EmployeeName VARCHAR(50),
    @Email VARCHAR(100),
    @Department VARCHAR(50),
    @Salary DECIMAL(10,2)
AS
BEGIN

    -- INSERT is a DML command.

    INSERT INTO Employee
    (
        EmployeeName,
        Email,
        Department,
        Salary
    )
    VALUES
    (
        @EmployeeName,
        @Email,
        @Department,
        @Salary
    );

END;
GO


/* Execute INSERT procedure */

EXEC AddEmployee
    @EmployeeName = 'Tirth',
    @Email = 'tirth@gmail.com',
    @Department = 'IT',
    @Salary = 52000;
GO


/* Check inserted data */

SELECT *
FROM Employee;
GO


/* ============================================================
   PART 4: DML - UPDATE STORED PROCEDURE
   ============================================================ */


/* ============================================================
   PROCEDURE 4: UPDATE EMPLOYEE SALARY

   @EmployeeID = INPUT parameter
   @NewSalary  = INPUT parameter
   ============================================================ */

CREATE PROCEDURE UpdateEmployeeSalary
    @EmployeeID INT,
    @NewSalary DECIMAL(10,2)
AS
BEGIN

    -- UPDATE is a DML command.

    UPDATE Employee
    SET Salary = @NewSalary
    WHERE EmployeeID = @EmployeeID;

END;
GO


/* Execute UPDATE procedure */

EXEC UpdateEmployeeSalary
    @EmployeeID = 1,
    @NewSalary = 60000;
GO


/* Check updated record */

SELECT *
FROM Employee
WHERE EmployeeID = 1;
GO


/* ============================================================
   PART 5: DML - DELETE STORED PROCEDURE
   ============================================================ */


/* ============================================================
   PROCEDURE 5: DELETE EMPLOYEE

   @EmployeeID is an INPUT parameter.
   ============================================================ */

CREATE PROCEDURE DeleteEmployee
    @EmployeeID INT
AS
BEGIN

    -- DELETE is a DML command.

    DELETE FROM Employee
    WHERE EmployeeID = @EmployeeID;

END;
GO


/* Execute DELETE procedure */

EXEC DeleteEmployee
    @EmployeeID = 6;
GO


/* Check remaining records */

SELECT *
FROM Employee;
GO


/* ============================================================
   PART 6: OUT PARAMETER
   ============================================================ */


/* ============================================================
   WHAT IS OUT PARAMETER?

   OUT parameter is used when the Stored Procedure needs
   to RETURN a value back to the calling program.

   Example:
       Count total employees.

   @TotalEmployees OUTPUT
   receives the result from the procedure.
   ============================================================ */


/* ============================================================
   PROCEDURE 6: GET TOTAL EMPLOYEE COUNT
   ============================================================ */

CREATE PROCEDURE GetTotalEmployeeCount
    @TotalEmployees INT OUTPUT
AS
BEGIN

    -- COUNT() calculates the number of employees.

    SELECT
        @TotalEmployees = COUNT(*)
    FROM Employee;

END;
GO


/* ============================================================
   CALL PROCEDURE WITH OUTPUT PARAMETER
   ============================================================ */

DECLARE @Total INT;


/* OUTPUT keyword is required when calling an OUTPUT parameter */

EXEC GetTotalEmployeeCount
    @TotalEmployees = @Total OUTPUT;


/* Display returned value */

SELECT @Total AS TotalEmployees;
GO


/* ============================================================
   PART 7: INOUT PARAMETER
   ============================================================ */


/* ============================================================
   WHAT IS INOUT?

   INOUT means:

       IN  -> Send a value INTO the procedure
       OUT -> Receive a modified value FROM the procedure

   SQL Server does not have an "INOUT" keyword.

   Instead, we use:

       OUTPUT

   on a parameter.

   Example:

       Input:
           @Salary = 50000

       Procedure:
           Increase salary by 10%

       Output:
           @Salary = 55000
   ============================================================ */


/* ============================================================
   PROCEDURE 7: INOUT-STYLE SALARY INCREASE
   ============================================================ */

CREATE PROCEDURE IncreaseSalary
    @Salary DECIMAL(10,2) OUTPUT
AS
BEGIN

    -- The procedure receives the current salary.
    -- Therefore @Salary works as an INPUT.

    -- Increase salary by 10%.
    SET @Salary = @Salary + (@Salary * 10 / 100);

    -- Because @Salary is OUTPUT,
    -- the changed value is returned to the caller.

END;
GO


/* ============================================================
   CALL INOUT-STYLE PROCEDURE
   ============================================================ */

DECLARE @CurrentSalary DECIMAL(10,2);


/* Initial value = INPUT */

SET @CurrentSalary = 50000;


/* Send value INTO procedure
   and receive modified value OUT */

EXEC IncreaseSalary
    @Salary = @CurrentSalary OUTPUT;


/* Display returned value */

SELECT
    @CurrentSalary AS SalaryAfter10PercentIncrease;
GO


/* ============================================================
   EXPECTED RESULT

   Before:

       @CurrentSalary = 50000


   Procedure calculates:

       50000 + (50000 * 10 / 100)

       = 50000 + 5000

       = 55000


   After:

       @CurrentSalary = 55000
   ============================================================ */


/* ============================================================
   PART 8: INOUT WITH EMPLOYEE SALARY
   ============================================================ */


/* ============================================================
   PROCEDURE 8: GET AND INCREASE EMPLOYEE SALARY

   @EmployeeID:
       INPUT parameter

   @Salary:
       INOUT-style OUTPUT parameter

   First we pass salary into the procedure.
   Then the procedure modifies it.
   Finally it returns the modified salary.
   ============================================================ */

CREATE PROCEDURE IncreaseEmployeeSalary
    @EmployeeID INT,
    @Salary DECIMAL(10,2) OUTPUT
AS
BEGIN

    /* --------------------------------------------------------
       Step 1:
       Get current salary from Employee table.
       -------------------------------------------------------- */

    SELECT
        @Salary = Salary
    FROM Employee
    WHERE EmployeeID = @EmployeeID;


    /* --------------------------------------------------------
       Step 2:
       Increase salary by 10%.
       -------------------------------------------------------- */

    SET @Salary = @Salary + (@Salary * 10 / 100);


    /* --------------------------------------------------------
       Step 3:
       Update the employee's salary in the table.
       -------------------------------------------------------- */

    UPDATE Employee
    SET Salary = @Salary
    WHERE EmployeeID = @EmployeeID;

END;
GO


/* ============================================================
   EXECUTE INOUT-STYLE PROCEDURE
   ============================================================ */

DECLARE @NewSalary DECIMAL(10,2);


/* Procedure will place the employee's salary into
   @NewSalary and then modify it. */

EXEC IncreaseEmployeeSalary
    @EmployeeID = 1,
    @Salary = @NewSalary OUTPUT;


/* Display the returned salary */

SELECT
    @NewSalary AS NewSalary;
GO


/* ============================================================
   FINAL CHECK
   ============================================================ */

SELECT *
FROM Employee
ORDER BY EmployeeID;
GO


/* ============================================================
   FINAL SUMMARY
   ============================================================

   1. DQL STORED PROCEDURE
   -----------------------

   SELECT data.

   Example:

       CREATE PROCEDURE GetAllEmployees
       AS
       BEGIN
           SELECT * FROM Employee;
       END;


   2. DML STORED PROCEDURE
   -----------------------

   INSERT:
       Adds data.

   UPDATE:
       Changes data.

   DELETE:
       Removes data.


   3. INPUT PARAMETER
   ------------------

   SQL Server default parameter type.

   Example:

       @EmployeeID INT

   Value is sent INTO the procedure.

   Example:

       EXEC ProcedureName
           @EmployeeID = 1;


   4. OUTPUT PARAMETER
   -------------------

   Returns a value FROM the procedure.

   Example:

       @TotalEmployees INT OUTPUT


   5. INOUT PARAMETER
   ------------------

   SQL Server uses OUTPUT parameters to achieve
   INOUT-style behavior.

   Value:

       Caller
          ↓
       Procedure
          ↓
       Modified Value
          ↓
       Caller

   Example:

       @Salary DECIMAL(10,2) OUTPUT


   ============================================================ */
