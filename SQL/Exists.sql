
/* ============================================================
   SQL SERVER EXISTS OPERATOR
   ============================================================

   EXISTS is used to check whether a subquery returns
   at least ONE row.

   If the subquery returns:

       1 or more rows -> EXISTS = TRUE
       0 rows         -> EXISTS = FALSE

   EXISTS is commonly used with correlated subqueries.

   REAL-WORLD EXAMPLE:

       Customer
           |
           | CustomerID
           |
           v
       Orders

   Question:

       Which customers have placed at least one order?
   ============================================================ */


/* ============================================================
   1. CREATE DATABASE
   ============================================================ */

CREATE DATABASE ExistsDemoDB;
GO

USE ExistsDemoDB;
GO


/* ============================================================
   2. CREATE CUSTOMER TABLE
   ============================================================ */

CREATE TABLE Customer
(
    CustomerID INT IDENTITY(1,1) PRIMARY KEY,
    CustomerName VARCHAR(50) NOT NULL,
    Email VARCHAR(100),
    City VARCHAR(50)
);
GO


/* ============================================================
   3. CREATE ORDERS TABLE
   ============================================================ */

CREATE TABLE Orders
(
    OrderID INT IDENTITY(101,1) PRIMARY KEY,
    CustomerID INT,
    OrderDate DATE,
    OrderAmount DECIMAL(10,2),

    CONSTRAINT FK_Orders_Customer
    FOREIGN KEY (CustomerID)
    REFERENCES Customer(CustomerID)
);
GO


/* ============================================================
   4. INSERT CUSTOMER DATA
   ============================================================ */

INSERT INTO Customer
(CustomerName, Email, City)
VALUES
('Mohit',  'mohit@gmail.com',  'Rajkot'),
('Rahul',  'rahul@gmail.com',  'Ahmedabad'),
('Amit',   'amit@gmail.com',   'Surat'),
('Jay',    'jay@gmail.com',    'Rajkot'),
('Karan',  'karan@gmail.com',  'Vadodara'),
('Tirth',  'tirth@gmail.com',  'Rajkot'),
('Raj',    'raj@gmail.com',    'Ahmedabad');
GO


/* ============================================================
   5. INSERT ORDER DATA
   ============================================================ */

INSERT INTO Orders
(CustomerID, OrderDate, OrderAmount)
VALUES
(1, '2026-01-10', 5000),
(1, '2026-02-15', 2500),

(2, '2026-01-20', 7000),

(3, '2026-03-01', 3000),
(3, '2026-03-15', 4500),

(6, '2026-02-10', 8000);
GO


/* ============================================================
   CUSTOMER DATA

   CustomerID
   -------------------------------
   1  Mohit
   2  Rahul
   3  Amit
   4  Jay
   5  Karan
   6  Tirth
   7  Raj


   ORDER DATA

   OrderID   CustomerID   Amount
   --------------------------------
   101       1            5000
   102       1            2500
   103       2            7000
   104       3            3000
   105       3            4500
   106       6            8000


   Customers who have orders:

       Mohit
       Rahul
       Amit
       Tirth


   Customers without orders:

       Jay
       Karan
       Raj
   ============================================================ */


/* ============================================================
   6. DISPLAY ALL CUSTOMERS
   ============================================================ */

SELECT *
FROM Customer;


/* ============================================================
   7. DISPLAY ALL ORDERS
   ============================================================ */

SELECT *
FROM Orders;


/* ============================================================
   8. BASIC EXISTS EXAMPLE

   QUESTION:

       Find customers who have placed at least one order.
   ============================================================ */

SELECT
    C.CustomerID,
    C.CustomerName,
    C.Email,
    C.City
FROM Customer AS C
WHERE EXISTS
(
    SELECT *
    FROM Orders AS O
    WHERE O.CustomerID = C.CustomerID
);


/*
RESULT:

CustomerID   CustomerName
-------------------------
1            Mohit
2            Rahul
3            Amit
6            Tirth


HOW IT WORKS:

For Mohit:

    Does an order exist where
    O.CustomerID = 1 ?

    YES

    Therefore Mohit is returned.


For Jay:

    Does an order exist where
    O.CustomerID = 4 ?

    NO

    Therefore Jay is NOT returned.
*/


/* ============================================================
   9. EXISTS WITH SELECT *

   SELECT 1 is commonly used because we only care whether
   a matching row exists.

   SELECT * also works.
   ============================================================ */

SELECT
    C.CustomerID,
    C.CustomerName
FROM Customer AS C
WHERE EXISTS
(
    SELECT *
    FROM Orders AS O
    WHERE O.CustomerID = C.CustomerID
);


/*
Both of these are checking existence:

    SELECT 1
    SELECT *

The actual value returned by the subquery is not important.
*/


/* ============================================================
   10. NOT EXISTS

   NOT EXISTS is used to find records where NO matching
   record exists.

   QUESTION:

       Find customers who have NEVER placed an order.
   ============================================================ */

SELECT
    C.CustomerID,
    C.CustomerName,
    C.City
FROM Customer AS C
WHERE NOT EXISTS
(
    SELECT 1
    FROM Orders AS O
    WHERE O.CustomerID = C.CustomerID
);


/*
RESULT:

CustomerID   CustomerName
-------------------------
4            Jay
5            Karan
7            Raj


Meaning:

There is NO order for these customers.
*/


/* ============================================================
   11. EXISTS WITH WHERE CONDITION

   EXISTS can have additional conditions inside the
   subquery.

   QUESTION:

       Find customers who have placed an order greater
       than 5000.
   ============================================================ */

SELECT
    C.CustomerID,
    C.CustomerName
FROM Customer AS C
WHERE EXISTS
(
    SELECT *
    FROM Orders AS O
    WHERE O.CustomerID = C.CustomerID
      AND O.OrderAmount > 5000
);


/*
RESULT:

Rahul  -> 7000
Tirth  -> 8000

Mohit:
    Orders = 5000, 2500

    No order > 5000
    Therefore Mohit is not returned.

Amit:
    Orders = 3000, 4500

    No order > 5000
    Therefore Amit is not returned.
*/


/* ============================================================
   12. EXISTS WITH DATE CONDITION

   QUESTION:

       Find customers who placed an order in March 2026.
   ============================================================ */

SELECT
    C.CustomerID,
    C.CustomerName
FROM Customer AS C
WHERE EXISTS
(
    SELECT 1
    FROM Orders AS O
    WHERE O.CustomerID = C.CustomerID
      AND O.OrderDate >= '2026-03-01'
      AND O.OrderDate <  '2026-04-01'
);


/*
RESULT:

Amit

Amit has orders:

2026-03-01
2026-03-15
*/


/* ============================================================
   13. EXISTS VS JOIN

   We can solve the same problem using JOIN.

   QUESTION:

       Find customers who have orders.
   ============================================================ */

SELECT DISTINCT
    C.CustomerID,
    C.CustomerName
FROM Customer AS C
INNER JOIN Orders AS O
    ON C.CustomerID = O.CustomerID;


/*
Because one customer can have multiple orders,
JOIN may produce duplicate customer rows.

DISTINCT is therefore used.
*/


/* ============================================================
   EXISTS VERSION
   ============================================================ */

SELECT
    C.CustomerID,
    C.CustomerName
FROM Customer AS C
WHERE EXISTS
(
    SELECT 1
    FROM Orders AS O
    WHERE O.CustomerID = C.CustomerID
);


/*
EXISTS naturally answers:

    "Does at least one matching record exist?"

It does not return one customer multiple times just
because that customer has multiple matching orders.
*/


/* ============================================================
   14. EXISTS VS IN

   EXISTS can also be compared with IN.

   Using IN:

       Find customers who have orders.
   ============================================================ */

SELECT
    C.CustomerID,
    C.CustomerName
FROM Customer AS C
WHERE C.CustomerID IN
(
    SELECT O.CustomerID
    FROM Orders AS O
);


/* ============================================================
   Same query using EXISTS
   ============================================================ */

SELECT
    C.CustomerID,
    C.CustomerName
FROM Customer AS C
WHERE EXISTS
(
    SELECT 1
    FROM Orders AS O
    WHERE O.CustomerID = C.CustomerID
);


/*
Both can produce the same result.

However, EXISTS is particularly natural when the question is:

    "Does a related record exist?"
*/


/* ============================================================
   15. CORRELATED EXISTS

   This is one of the most important concepts.

   The inner query refers to the outer query:

       O.CustomerID = C.CustomerID

   Therefore the subquery is evaluated in relation to
   the current customer.

   Example:
   ============================================================ */

SELECT
    C.CustomerName
FROM Customer AS C
WHERE EXISTS
(
    SELECT *
    FROM Orders AS O
    WHERE O.CustomerID = C.CustomerID
);


/*
For every customer, SQL Server checks:

    Customer 1 -> Is there an Order for Customer 1?
    Customer 2 -> Is there an Order for Customer 2?
    Customer 3 -> Is there an Order for Customer 3?
    Customer 4 -> Is there an Order for Customer 4?
    ...

This is called a CORRELATED SUBQUERY.
*/


/* ============================================================
   16. EXISTS WITH UPDATE

   EXISTS can also be used with DML.

   QUESTION:

       Give a 10% bonus to customers who have placed
       at least one order.

   NOTE:
       This is just an example to demonstrate EXISTS with
       UPDATE. In a real system, bonus logic would normally
       be stored in a dedicated customer/loyalty column.
   ============================================================ */


/*
First add a CustomerType column.
*/

ALTER TABLE Customer
ADD CustomerType VARCHAR(20) DEFAULT 'Regular';
GO


/* ============================================================
   UPDATE USING EXISTS
   ============================================================ */

UPDATE C
SET CustomerType = 'Active'
FROM Customer AS C
WHERE EXISTS
(
    SELECT 1
    FROM Orders AS O
    WHERE O.CustomerID = C.CustomerID
);


/*
Customers with at least one order become:

    Active


Customers without orders remain:

    Regular
*/


/* ============================================================
   17. EXISTS WITH DELETE

   IMPORTANT:
   DELETE should be used carefully.

   Example requirement:

       Delete customers who have NEVER placed an order.

   ============================================================ */

DELETE FROM Customer
WHERE NOT EXISTS
(
    SELECT 1
    FROM Orders AS O
    WHERE O.CustomerID = Customer.CustomerID
);


/*
WARNING:

The above deletes:

    Jay
    Karan
    Raj

Because they have no orders.

In a real production database, always verify the
SELECT version before executing DELETE.
*/


/* ============================================================
   18. SAFE WAY TO TEST DELETE

   First run:

   SELECT *
   FROM Customer
   WHERE NOT EXISTS
   (
       SELECT 1
       FROM Orders AS O
       WHERE O.CustomerID = Customer.CustomerID
   );

   Check the rows.

   Only then perform DELETE.
   ============================================================ */


/* ============================================================
   19. REAL-WORLD USE CASE #1
       E-COMMERCE
   ============================================================

   Requirement:

       Find customers who have purchased a product.
   ============================================================ */

SELECT
    C.CustomerID,
    C.CustomerName
FROM Customer AS C
WHERE EXISTS
(
    SELECT 1
    FROM Orders AS O
    WHERE O.CustomerID = C.CustomerID
);


/*
Business meaning:

    "Show me customers who have made at least one purchase."
*/


/* ============================================================
   20. REAL-WORLD USE CASE #2
       STUDENT MANAGEMENT SYSTEM
   ============================================================

   Suppose:

       Student
       Enrollment

   We want:

       Students who are enrolled in at least one course.

   Example query:
   ============================================================ */

/*

SELECT
    S.StudentID,
    S.StudentName
FROM Student AS S
WHERE EXISTS
(
    SELECT 1
    FROM Enrollment AS E
    WHERE E.StudentID = S.StudentID
);

*/


/* ============================================================
   21. REAL-WORLD USE CASE #3
       BANKING SYSTEM
   ============================================================

   Find customers who have at least one active account.

   Example:
   ============================================================ */

/*

SELECT
    C.CustomerID,
    C.CustomerName
FROM Customer AS C
WHERE EXISTS
(
    SELECT 1
    FROM BankAccount AS A
    WHERE A.CustomerID = C.CustomerID
      AND A.Status = 'Active'
);

*/


/* ============================================================
   22. REAL-WORLD USE CASE #4
       EMPLOYEE SYSTEM
   ============================================================

   Find employees who have submitted at least one expense
   claim.

   Example:
   ============================================================ */

/*

SELECT
    E.EmployeeID,
    E.EmployeeName
FROM Employee AS E
WHERE EXISTS
(
    SELECT 1
    FROM ExpenseClaim AS EC
    WHERE EC.EmployeeID = E.EmployeeID
);

*/


/* ============================================================
   23. REAL-WORLD USE CASE #5
       PRODUCT SYSTEM
   ============================================================

   Find products that have been ordered at least once.

   Example:
   ============================================================ */

/*

SELECT
    P.ProductID,
    P.ProductName
FROM Product AS P
WHERE EXISTS
(
    SELECT 1
    FROM OrderDetails AS OD
    WHERE OD.ProductID = P.ProductID
);

*/


/* ============================================================
   24. EXISTS WITH MULTIPLE CONDITIONS

   QUESTION:

       Find customers who have placed an order above 5000
       in Rajkot-related business logic.

   Example structure:
   ============================================================ */

/*

SELECT
    C.CustomerID,
    C.CustomerName
FROM Customer AS C
WHERE C.City = 'Rajkot'
AND EXISTS
(
    SELECT 1
    FROM Orders AS O
    WHERE O.CustomerID = C.CustomerID
      AND O.OrderAmount > 5000
);

*/


/* ============================================================
   25. IMPORTANT DIFFERENCE

   EXISTS:

       Checks whether at least one row exists.

   NOT EXISTS:

       Checks whether no matching row exists.

   IN:

       Checks whether a value is present in a result set.

   JOIN:

       Combines rows from two or more tables.
   ============================================================ */


/* ============================================================
   26. SIMPLE VISUAL EXPLANATION

   CUSTOMER TABLE
   ----------------------------

   1  Mohit
   2  Rahul
   3  Amit
   4  Jay


   ORDERS TABLE
   ----------------------------

   CustomerID
   ----------
   1
   1
   2
   3


   EXISTS CHECK:

   Mohit  -> Order exists? YES -> RETURN
   Rahul  -> Order exists? YES -> RETURN
   Amit   -> Order exists? YES -> RETURN
   Jay    -> Order exists? NO  -> IGNORE


   FINAL RESULT:

   Mohit
   Rahul
   Amit
   ============================================================ */


/* ============================================================
   27. MOST IMPORTANT SYNTAX TO REMEMBER

   ============================================================

   SELECT columns
   FROM ParentTable P
   WHERE EXISTS
   (
       SELECT 1
       FROM ChildTable C
       WHERE C.ForeignKey = P.PrimaryKey
   );


   Think:

       "Give me records from ParentTable
        WHERE a related record EXISTS
        in ChildTable."
   ============================================================ */
```
