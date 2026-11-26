CREATE DATABASE SelfJoinDB;

USE SelfJoinDB;


CREATE TABLE Employees
(
    EmployeeId INT PRIMARY KEY,
    EmployeeName VARCHAR(100) NOT NULL,
    JobTitle VARCHAR(100),
    Salary DECIMAL(10,2),
    Department VARCHAR(100),
    ManagerId INT NULL,
    JoiningDate DATE,

    CONSTRAINT FK_Employee_Manager
        FOREIGN KEY (ManagerId)
        REFERENCES Employees(EmployeeId)
);


INSERT INTO Employees
(EmployeeId, EmployeeName, JobTitle, Salary, Department, ManagerId, JoiningDate)
VALUES
(1, 'Raj Patel', 'CEO', 150000, 'Management', NULL, '2015-01-10'),

(2, 'Amit Shah', 'CTO', 120000, 'IT', 1, '2017-03-15'),
(3, 'Neha Mehta', 'CFO', 115000, 'Finance', 1, '2017-06-20'),

(4, 'Rahul Joshi', 'Senior Developer', 90000, 'IT', 2, '2019-01-12'),
(5, 'Priya Desai', 'Senior Developer', 85000, 'IT', 2, '2019-04-18'),
(6, 'Karan Shah', 'Developer', 60000, 'IT', 4, '2021-07-10'),
(7, 'Pooja Patel', 'Developer', 58000, 'IT', 4, '2022-02-15'),

(8, 'Vivek Kumar', 'Accountant', 65000, 'Finance', 3, '2020-05-20'),
(9, 'Sneha Joshi', 'Accountant', 62000, 'Finance', 3, '2021-08-12'),

(10, 'Rohan Mehta', 'Intern', 30000, 'IT', 6, '2024-01-10'),
(11, 'Anjali Shah', 'Intern', 28000, 'IT', 7, '2024-02-15'),

(12, 'Manish Patel', 'HR Manager', 95000, 'HR', 1, '2018-09-10'),
(13, 'Komal Shah', 'HR Executive', 55000, 'HR', 12, '2021-03-12');


select * from Employees


--Employee and Their Manager

SELECT
    e.EmployeeName AS Employee,
    m.EmployeeName AS Manager
FROM Employees e
LEFT JOIN Employees m
    ON e.ManagerId = m.EmployeeId;


-- Employees Who Have a Manager

SELECT 
   e1.EmployeeName , e2.EmployeeName
   FROM Employees e1
   LEFT JOIN 
   Employees e2
   ON e1.ManagerId=e2.EmployeeId
WHERE e2.EmployeeId IS NOT NULL


SELECT
    e.EmployeeName AS Employee,
    m.EmployeeName AS Manager
FROM Employees e
INNER JOIN Employees m
    ON e.ManagerId = m.EmployeeId;


-- Employees Earning More Than Their Manager

SELECT * FROM Employees e1
WHERE e1.Salary > (SELECT Salary FROM Employees WHERE EmployeeId=e1.ManagerId)


SELECT
    e.EmployeeName AS Employee,
    e.Salary AS EmployeeSalary,
    m.EmployeeName AS Manager,
    m.Salary AS ManagerSalary
FROM Employees e
JOIN Employees m
    ON e.ManagerId = m.EmployeeId
WHERE e.Salary > m.Salary;


-- Find All Employees Under Each Manager

SELECT e1.ManagerId as ManagerId , COUNT(e1.ManagerId) AS Total_Employee_Under_Work FROM 
Employees e1 
INNER JOIN 
Employees e2
ON e1.ManagerId=e2.EmployeeId
GROUP BY e1.ManagerId


SELECT (select EmployeeName from Employees where EmployeeId=e1.ManagerId) as Manager_Name,COUNT(e1.ManagerId) AS Total_Employee_Under_Work FROM 
Employees e1 
INNER JOIN 
Employees e2
ON e1.ManagerId=e2.EmployeeId
GROUP BY e1.ManagerId


SELECT
    m.EmployeeName AS Manager,
    COUNT(e.EmployeeId) AS EmployeeCount
FROM Employees m
JOIN Employees e
    ON e.ManagerId = m.EmployeeId
GROUP BY m.EmployeeId, m.EmployeeName
ORDER BY EmployeeCount DESC;


-- Find Employees Who Have the Same Manager

SELECT
    e1.EmployeeName AS Employee1,
    e2.EmployeeName AS Employee2,
    m.EmployeeName AS CommonManager
FROM Employees e1
JOIN Employees e2
    ON e1.ManagerId = e2.ManagerId
    AND e1.EmployeeId < e2.EmployeeId
JOIN Employees m
    ON e1.ManagerId = m.EmployeeId
ORDER BY CommonManager;


-- Find Employees Whose Manager Has a Manager
-- Employee → Manager → Manager's Manager

SELECT
    e.EmployeeName AS Employee,
    m.EmployeeName AS Manager,
    gm.EmployeeName AS GrandManager
FROM Employees e
JOIN Employees m
    ON e.ManagerId = m.EmployeeId
JOIN Employees gm
    ON m.ManagerId = gm.EmployeeId;


-- Find Managers Whose Salary Is Less Than at Least One Employee

SELECT DISTINCT
    m.EmployeeName AS Manager,
    m.Salary AS ManagerSalary,
    e.EmployeeName AS Employee,
    e.Salary AS EmployeeSalary
FROM Employees m
JOIN Employees e
    ON e.ManagerId = m.EmployeeId
WHERE e.Salary > m.Salary;


-- Find Employees Who Are Managers

SELECT DISTINCT
    m.EmployeeId,
    m.EmployeeName,
    m.JobTitle
FROM Employees m
JOIN Employees e
    ON e.ManagerId = m.EmployeeId;


