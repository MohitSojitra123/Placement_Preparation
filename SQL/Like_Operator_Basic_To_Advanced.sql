CREATE DATABASE LikeOperatorInterviewDB;


USE LikeOperatorInterviewDB;


-- ==========================================
-- DEPARTMENT TABLE
-- ==========================================

CREATE TABLE Departments
(
    DepartmentId INT PRIMARY KEY,
    DepartmentName VARCHAR(100) NOT NULL,
    Location VARCHAR(100)
);

-- ==========================================
-- EMPLOYEE TABLE
-- ==========================================

CREATE TABLE Employees
(
    EmployeeId INT PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Email VARCHAR(100),
    Phone VARCHAR(20),
    City VARCHAR(50),
    JobTitle VARCHAR(100),
    Salary DECIMAL(10,2),
    DepartmentId INT,
    HireDate DATE,

    FOREIGN KEY (DepartmentId)
        REFERENCES Departments(DepartmentId)
);

-- ==========================================
-- CUSTOMER TABLE
-- ==========================================

CREATE TABLE Customers
(
    CustomerId INT PRIMARY KEY,
    CustomerName VARCHAR(100),
    Email VARCHAR(100),
    Phone VARCHAR(20),
    City VARCHAR(50),
    Address VARCHAR(200)
);

-- ==========================================
-- PRODUCTS TABLE
-- ==========================================

CREATE TABLE Products
(
    ProductId INT PRIMARY KEY,
    ProductName VARCHAR(100),
    Category VARCHAR(50),
    Brand VARCHAR(50),
    Price DECIMAL(10,2),
    ProductCode VARCHAR(30)
);



-- ==========================================
-- DEPARTMENTS
-- ==========================================

INSERT INTO Departments
VALUES
(1, 'Information Technology', 'Ahmedabad'),
(2, 'Human Resources', 'Rajkot'),
(3, 'Finance', 'Surat'),
(4, 'Marketing', 'Vadodara'),
(5, 'Sales', 'Mumbai'),
(6, 'Administration', 'Gandhinagar'),
(7, 'Research and Development', 'Pune');
GO


-- ==========================================
-- EMPLOYEES
-- ==========================================

INSERT INTO Employees
VALUES
(1, 'Rahul', 'Patel', 'rahul.patel@gmail.com',
 '9876543210', 'Ahmedabad', 'Software Developer',
 65000, 1, '2022-01-15'),

(2, 'Amit', 'Joshi', 'amit.joshi@gmail.com',
 '9876501234', 'Rajkot', 'Senior Software Engineer',
 85000, 1, '2021-03-10'),

(3, 'Neha', 'Shah', 'neha.shah@yahoo.com',
 '9825012345', 'Surat', 'HR Manager',
 72000, 2, '2020-07-20'),

(4, 'Priya', 'Desai', 'priya.desai@gmail.com',
 '9876123456', 'Ahmedabad', 'Software Engineer',
 70000, 1, '2023-02-11'),

(5, 'Rohit', 'Mehta', 'rohit.mehta@gmail.com',
 '9898012345', 'Vadodara', 'Marketing Executive',
 55000, 4, '2022-09-12'),

(6, 'Karan', 'Patel', 'karan.patel@hotmail.com',
 '9876011111', 'Rajkot', 'Sales Manager',
 78000, 5, '2019-05-18'),

(7, 'Sneha', 'Joshi', 'sneha.joshi@gmail.com',
 '9825011111', 'Mumbai', 'Accountant',
 60000, 3, '2021-11-25'),

(8, 'Vivek', 'Shah', 'vivek.shah@gmail.com',
 '9898122222', 'Pune', 'Data Analyst',
 68000, 7, '2023-06-15'),

(9, 'Anjali', 'Patel', 'anjali.patel@gmail.com',
 '9876033333', 'Ahmedabad', 'Project Manager',
 95000, 1, '2018-08-01'),

(10, 'Jay', 'Mehta', 'jay.mehta@yahoo.com',
 '9825044444', 'Surat', 'Business Analyst',
 73000, 7, '2020-10-10'),

(11, 'Mohit', 'Sojitra', 'mohit.sojitra@gmail.com',
 '9876055555', 'Rajkot', 'Full Stack Developer',
 82000, 1, '2024-01-10'),

(12, 'Hetal', 'Shah', 'hetal.shah@gmail.com',
 '9898066666', 'Gandhinagar', 'HR Executive',
 52000, 2, '2022-04-22'),

(13, 'Nitin', 'Patel', 'nitin.patel@gmail.com',
 '9876077777', 'Ahmedabad', 'DevOps Engineer',
 88000, 1, '2021-01-05'),

(14, 'Pooja', 'Desai', 'pooja.desai@hotmail.com',
 '9825088888', 'Vadodara', 'Sales Executive',
 48000, 5, '2023-08-14'),

(15, 'Darshan', 'Joshi', 'darshan.joshi@gmail.com',
 '9898099999', 'Rajkot', 'Database Administrator',
 90000, 1, '2019-12-20'),

(16, 'Rakesh', 'Mehta', 'rakesh.mehta@gmail.com',
 '9876000001', 'Mumbai', 'Finance Manager',
 91000, 3, '2017-06-10'),

(17, 'Komal', 'Patel', 'komal.patel@gmail.com',
 '9876000002', 'Surat', 'UI UX Designer',
 64000, 4, '2022-02-15'),

(18, 'Manish', 'Shah', 'manish.shah@yahoo.com',
 '9876000003', 'Pune', 'Software Tester',
 58000, 1, '2024-03-12'),

(19, 'Divya', 'Mehta', 'divya.mehta@gmail.com',
 '9876000004', 'Ahmedabad', 'Data Scientist',
 99000, 7, '2020-09-09'),

(20, 'Akash', 'Patel', 'akash.patel@gmail.com',
 '9876000005', 'Rajkot', 'Backend Developer',
 76000, 1, '2023-11-11');
GO


-- ==========================================
-- CUSTOMERS
-- ==========================================

INSERT INTO Customers
VALUES
(1, 'Rahul Patel', 'rahul@gmail.com', '9876543210',
 'Ahmedabad', 'Satellite Road'),

(2, 'Amit Shah', 'amit@yahoo.com', '9825011111',
 'Rajkot', 'Kalawad Road'),

(3, 'Neha Joshi', 'neha@gmail.com', '9876123456',
 'Surat', 'Adajan'),

(4, 'Priya Mehta', 'priya@hotmail.com', '9898012345',
 'Vadodara', 'Alkapuri'),

(5, 'Rohit Patel', 'rohit@gmail.com', '9876012345',
 'Ahmedabad', 'Bopal'),

(6, 'Sneha Desai', 'sneha@yahoo.com', '9825023456',
 'Mumbai', 'Andheri'),

(7, 'Mohit Sojitra', 'mohit@gmail.com', '9876055555',
 'Rajkot', 'University Road'),

(8, 'Anjali Shah', 'anjali@gmail.com', '9898067890',
 'Pune', 'Kothrud'),

(9, 'Karan Patel', 'karan@hotmail.com', '9876078901',
 'Surat', 'Vesu'),

(10, 'Jay Mehta', 'jay@gmail.com', '9825089012',
 'Ahmedabad', 'Maninagar');
GO


-- ==========================================
-- PRODUCTS
-- ==========================================

INSERT INTO Products
VALUES
(1, 'Laptop Dell Inspiron', 'Laptop', 'Dell', 65000, 'LAP-DELL-001'),

(2, 'Laptop HP Pavilion', 'Laptop', 'HP', 72000, 'LAP-HP-002'),

(3, 'Laptop Lenovo ThinkPad', 'Laptop', 'Lenovo', 85000, 'LAP-LEN-003'),

(4, 'iPhone 15', 'Mobile', 'Apple', 70000, 'MOB-APP-004'),

(5, 'iPhone 15 Pro', 'Mobile', 'Apple', 120000, 'MOB-APP-005'),

(6, 'Samsung Galaxy S24', 'Mobile', 'Samsung', 80000, 'MOB-SAM-006'),

(7, 'Samsung Galaxy A55', 'Mobile', 'Samsung', 42000, 'MOB-SAM-007'),

(8, 'Dell Monitor 24 Inch', 'Monitor', 'Dell', 15000, 'MON-DELL-008'),

(9, 'Logitech Wireless Mouse', 'Accessories', 'Logitech', 1200, 'ACC-LOG-009'),

(10, 'Logitech Keyboard', 'Accessories', 'Logitech', 1800, 'ACC-LOG-010'),

(11, 'HP Wireless Mouse', 'Accessories', 'HP', 1000, 'ACC-HP-011'),

(12, 'Apple Magic Keyboard', 'Accessories', 'Apple', 12000, 'ACC-APP-012'),

(13, 'Lenovo USB Hub', 'Accessories', 'Lenovo', 2500, 'ACC-LEN-013'),

(14, 'Dell Gaming Laptop', 'Laptop', 'Dell', 110000, 'LAP-DELL-014'),

(15, 'Samsung Monitor 27 Inch', 'Monitor', 'Samsung', 22000, 'MON-SAM-015');



select * from Employees
select * from Departments
select * from Products



-- Find employees whose first name is exactly Rahul

SELECT *
FROM Employees
WHERE FirstName LIKE 'Rahul';


-- Find employees whose first name starts with A

SELECT *
FROM Employees
WHERE FirstName LIKE 'A%';


-- Find employees whose first name ends with a
SELECT *
FROM Employees
WHERE FirstName LIKE '%a';


-- Find employees whose first name contains a
SELECT *
FROM Employees
WHERE FirstName LIKE '%a%';




-- Find employees whose last name starts with Pat
SELECT *
FROM Employees
WHERE LastName LIKE 'Pat%';


-- Find employees whose last name ends with el
SELECT *
FROM Employees
WHERE LastName LIKE '%el';


-- Find employees whose email contains gmail
SELECT *
FROM Employees
WHERE Email LIKE '%gmail%';


-- Find employees having Gmail addresses
SELECT *
FROM Employees
WHERE Email LIKE '%@gmail.com';



-- Find employees from Ahmedabad
SELECT *
FROM Employees
WHERE City LIKE 'Ahmedabad';



-- Find employees whose city starts with A
SELECT *
FROM Employees
WHERE City LIKE 'A%';


-- Find employees whose job title contains Developer
SELECT *
FROM Employees
WHERE JobTitle LIKE '%Developer%';


-- Find employees whose job title ends with Manager
SELECT *
FROM Employees
WHERE JobTitle LIKE '%Manager';


-- Find products containing the word Laptop
SELECT *
FROM Products
WHERE ProductName LIKE '%Laptop%';


-- Find products whose name starts with Samsung
SELECT *
FROM Products
WHERE ProductName LIKE 'Samsung%';


-- Find names where the second character is a
SELECT *
FROM Employees
WHERE FirstName LIKE '_a%';


-- Find names having exactly 5 characters
SELECT *
FROM Employees
WHERE FirstName LIKE '_____';


-- Find employees whose first name starts with A and has exactly 5 characters
SELECT *
FROM Employees
WHERE FirstName LIKE 'A____';


--Find employees whose name starts with A and second character is n
SELECT *
FROM Employees
WHERE FirstName LIKE 'An%';



-- Find employees whose first name has h as the third character
SELECT *
FROM Employees
WHERE FirstName LIKE '__h%';


-- Find employees whose email does NOT use Gmail
SELECT *
FROM Employees
WHERE Email NOT LIKE '%@gmail.com';


--Find employees whose first name starts with either A, R, or M
SELECT *
FROM Employees
WHERE FirstName LIKE '[ARM]%';


-- Find employees whose first name starts with any letter from A to M
SELECT *
FROM Employees
WHERE FirstName LIKE '[A-M]%';

--Find employees whose first name does NOT start with A
SELECT *
FROM Employees
WHERE FirstName NOT LIKE 'A%';


-- Find employees whose first name starts with a letter other than A, B, or C
SELECT *
FROM Employees
WHERE FirstName LIKE '[^ABC]%';


-- Find products whose product code starts with LAP
SELECT *
FROM Products
WHERE ProductCode LIKE 'LAP%';


--Find products whose code starts with MOB and ends with a number
SELECT *
FROM Products
WHERE ProductCode LIKE 'MOB%[0-9]';


-- Find products where the second character of ProductCode is A
SELECT *
FROM Products
WHERE ProductCode LIKE '_A%';


--Find employees from cities starting with either A, R, or S
SELECT *
FROM Employees
WHERE City LIKE '[ARS]%';


-- Find employees whose first name starts with A-M and contains a
SELECT *
FROM Employees
WHERE FirstName LIKE '[A-M]%'
  AND FirstName LIKE '%a%';


-- Find employees whose first name starts with A and contains exactly one a
SELECT *
FROM Employees
WHERE FirstName LIKE 'A%'
  AND FirstName NOT LIKE '%a%a%';


-- Find employees whose email is Gmail OR Yahoo
SELECT *
FROM Employees
WHERE Email LIKE '%@gmail.com'
   OR Email LIKE '%@yahoo.com';


-- Find employees whose email is NOT Gmail, Yahoo, or Hotmail
SELECT *
FROM Employees
WHERE Email NOT LIKE '%@gmail.com'
  AND Email NOT LIKE '%@yahoo.com'
  AND Email NOT LIKE '%@hotmail.com';


-- Find employees whose first name contains a but does not start with A
SELECT *
FROM Employees
WHERE FirstName LIKE '%a%'
  AND FirstName NOT LIKE 'A%';


-- Find products where the name contains both Dell and Laptop
SELECT *
FROM Products
WHERE ProductName LIKE '%Dell%'
  AND ProductName LIKE '%Laptop%';


--Find products whose name contains either Laptop or Mobile
SELECT *
FROM Products
WHERE ProductName LIKE '%Laptop%'
   OR ProductName LIKE '%Mobile%';


-- Find employees whose phone starts with 987 and ends with 10
SELECT *
FROM Employees
WHERE Phone LIKE '987%10';



-- Find employees whose name has a as the second character and t somewhere after it
SELECT *
FROM Employees
WHERE FirstName LIKE '_a%t%';


-- Find employees whose email follows the pattern:
SELECT *
FROM Employees
WHERE Email LIKE '%.%@gmail.com';


%       .       %       @gmail.com
│       │       │          │
anything dot anything    Gmail



























