
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
('Mohit', 'mohit@gmail.com', 'IT', 50000),      -- Duplicate
('Mohit', 'mohit@gmail.com', 'IT', 50000),      -- Duplicate

('Rahul', 'rahul@gmail.com', 'HR', 45000),
('Rahul', 'rahul@gmail.com', 'HR', 45000),      -- Duplicate

('Amit', 'amit@gmail.com', 'Finance', 55000),
('Amit', 'amit@gmail.com', 'Finance', 55000),   -- Duplicate

('Jay', 'jay@gmail.com', 'IT', 60000),
('Karan', 'karan@gmail.com', 'Sales', 48000);



SELECT *
FROM Employee
ORDER BY EmployeeID;



/* ============================================================
   STEP 5: FIND DUPLICATES USING SELF JOIN

   Employee E1 = First copy of the table
   Employee E2 = Second copy of the table

   E1.EmployeeID > E2.EmployeeID
   means:

   Keep the smaller EmployeeID
   Delete the larger EmployeeID
   ============================================================ */

SELECT
    E1.EmployeeID AS DuplicateID,
    E1.EmployeeName,
    E1.Email,
    E1.Department,
    E1.Salary,

    E2.EmployeeID AS OriginalID

FROM Employee AS E1

INNER JOIN Employee AS E2
    ON E1.EmployeeName = E2.EmployeeName
    AND E1.Email = E2.Email
    AND E1.Department = E2.Department
    AND E1.Salary = E2.Salary

    -- Do not compare a row with itself
    AND E1.EmployeeID > E2.EmployeeID

ORDER BY E1.EmployeeID;
GO


/* ============================================================
   STEP 6: DELETE DUPLICATES USING ONLY SELF JOIN
   ============================================================ */

DELETE E1

FROM Employee AS E1

INNER JOIN Employee AS E2
    ON E1.EmployeeName = E2.EmployeeName
    AND E1.Email = E2.Email
    AND E1.Department = E2.Department
    AND E1.Salary = E2.Salary

    -- Delete the record having the larger EmployeeID
    AND E1.EmployeeID > E2.EmployeeID;
GO


/* ============================================================
   STEP 7: CHECK DATA AFTER DELETE
   ============================================================ */

SELECT *
FROM Employee
ORDER BY EmployeeID;
GO


/* ============================================================
   EXPECTED RESULT AFTER DELETE

   EmployeeID | EmployeeName | Email           | Department | Salary
   -----------------------------------------------------------------
   1           Mohit          mohit@gmail.com   IT           50000
   4           Rahul          rahul@gmail.com   HR           45000
   6           Amit           amit@gmail.com    Finance      55000
   8           Jay            jay@gmail.com     IT           60000
   9           Karan          karan@gmail.com   Sales        48000

   Only one record from each duplicate group remains.
   ============================================================ */


/* ============================================================
   HOW IT WORKS

   Suppose we have:

   EmployeeID | Name
   ------------------
   1           Mohit
   2           Mohit
   3           Mohit


   Self JOIN compares:

   E1 = ID 2    E2 = ID 1
   E1 = ID 3    E2 = ID 1
   E1 = ID 3    E2 = ID 2


   Because we use:

   E1.EmployeeID > E2.EmployeeID

   ID 1 is never deleted.

   ID 2 and ID 3 are identified as duplicates
   and are deleted.


   ============================================================
   IMPORTANT

   To KEEP the oldest record:

       E1.EmployeeID > E2.EmployeeID


   To KEEP the newest record, you can reverse the condition:

       E1.EmployeeID < E2.EmployeeID

   ============================================================ */