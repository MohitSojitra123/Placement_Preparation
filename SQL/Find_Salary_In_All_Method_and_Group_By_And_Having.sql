CREATE DATABASE EmployeePracticeDB;

USE EmployeePracticeDB;

CREATE TABLE Departments
(
    DepartmentId INT PRIMARY KEY,
    DepartmentName VARCHAR(100) NOT NULL
);

CREATE TABLE Employees
(
    EmployeeId INT PRIMARY KEY,
    EmployeeName VARCHAR(100) NOT NULL,
    Salary DECIMAL(10,2) NOT NULL,
    DepartmentId INT NOT NULL,
    ManagerId INT NULL,

    CONSTRAINT FK_Employees_Department
        FOREIGN KEY (DepartmentId)
        REFERENCES Departments(DepartmentId),

    CONSTRAINT FK_Employees_Manager
        FOREIGN KEY (ManagerId)
        REFERENCES Employees(EmployeeId)
);


INSERT INTO Departments (DepartmentId, DepartmentName)
VALUES
(1, 'IT'),
(2, 'HR'),
(3, 'Finance'),
(4, 'Sales'),
(5, 'Marketing');

INSERT INTO Employees
(EmployeeId, EmployeeName, Salary, DepartmentId, ManagerId)
VALUES
(1, 'Rajesh Patel', 120000, 1, NULL),
(2, 'Amit Shah',     95000, 2, NULL),
(3, 'Neha Mehta',   110000, 3, NULL),
(4, 'Karan Joshi',  100000, 4, NULL),
(5, 'Priya Desai',   90000, 5, NULL),
(6,  'Rahul Patel',   80000, 1, 1),
(7,  'Vivek Shah',    75000, 1, 1),
(8,  'Riya Joshi',    75000, 1, 1),
(9,  'Mohit Mehta',   60000, 1, 6),
(10, 'Anjali Patel',  70000, 2, 2),
(11, 'Dhruv Shah',    65000, 2, 2),
(12, 'Pooja Mehta',   65000, 2, 2),
(13, 'Jay Patel',     85000, 3, 3),
(14, 'Het Shah',      80000, 3, 3),
(15, 'Krisha Joshi',  80000, 3, 3),
(16, 'Arjun Patel',   90000, 4, 4),
(17, 'Nisha Shah',     70000, 4, 4),
(18, 'Dev Mehta',     110000, 4, 4),
(19, 'Mansi Patel',   75000, 5, 5),
(20, 'Yash Shah',     60000, 5, 5);

select * from Employees
select * from Departments


--Join Two Table  Three Table Join 

SELECT
    E.EmployeeId,
    E.EmployeeName,
    E.Salary,
    D.DepartmentName,
    E.ManagerId,
    M.EmployeeName AS ManagerName
FROM Employees E
JOIN Departments D
    ON E.DepartmentId = D.DepartmentId
LEFT JOIN Employees M
    ON E.ManagerId = M.EmployeeId
ORDER BY E.EmployeeId;


-- Find the second-highest salary
select max(salary) from Employees where Salary < (select max(Salary) from Employees)



-- Find the Third-highest salary
select max(salary) from Employees where salary < (select max(Salary) from Employees where salary < (select max(salary) from Employees))



-- Find the Third-highest salary
select DISTINCT(salary) from Employees order by Salary desc OFFSET 2 Rows FETCH NEXT 1 ROWS ONLY    



-- Find the Third-highest salary

SELECT DISTINCT Salary
FROM
(
    SELECT
        Salary,
        DENSE_RANK() OVER (ORDER BY Salary DESC) AS SalaryRank
    FROM Employees
) AS T
WHERE SalaryRank = 3;




-- Find the Nth-highest salary

DECLARE @N INT = 5;

SELECT DISTINCT Salary
FROM
(
    SELECT
        Salary,
        DENSE_RANK() OVER (ORDER BY Salary DESC) AS SalaryRank
    FROM Employees
) AS T
WHERE SalaryRank = @N;


-- Find employees having the same salary

-- Print Employee Count Only with an Salary only 

SELECT
     *,
    COUNT(*) AS EmployeeCount
FROM Employees
GROUP BY Salary
HAVING COUNT(*) > 1;

--Print Employee All Detaile

SELECT * 
FROM Employees 
WHERE Salary IN (
    SELECT Salary 
    FROM Employees 
    GROUP BY Salary 
    HAVING COUNT(*) > 1
);


--Find the highest salary in each department

SELECT
    DepartmentId,
    MAX(Salary) AS HighestSalary
FROM Employees
GROUP BY DepartmentId;

--Print With Department Name 

SELECT
    D.DepartmentName,
    MAX(E.Salary) AS HighestSalary
FROM Employees E
JOIN Departments D
    ON E.DepartmentId = D.DepartmentId
GROUP BY D.DepartmentName , E.DepartmentId;


-- Find the second-highest salary in each department



SELECT
    d.DepartmentId,
    d.DepartmentName,
    COUNT(e.EmployeeId) AS EmployeeCount
FROM Employees e
INNER JOIN Departments d
    ON d.DepartmentId = e.DepartmentId
GROUP BY
    d.DepartmentId,
    d.DepartmentName;





SELECT
    DepartmentName,
    Salary
FROM
(
    SELECT
        D.DepartmentName,
        E.Salary,
        DENSE_RANK() OVER
        (
            PARTITION BY E.DepartmentId
            ORDER BY E.Salary DESC
        ) AS SalaryRank
    FROM Employees E
    JOIN Departments D
        ON E.DepartmentId = D.DepartmentId
) AS T
WHERE SalaryRank = 2


--Find employees earning more than their manager

SELECT
    E.EmployeeName,
    E.Salary AS EmployeeSalary,
    M.EmployeeName AS ManagerName,
    M.Salary AS ManagerSalary
FROM Employees E
JOIN Employees M
    ON E.ManagerId = M.EmployeeId
WHERE E.Salary > M.Salary;


-- Find employees who don't have a manager

SELECT
    EmployeeId,
    EmployeeName,
    Salary
FROM Employees
WHERE ManagerId IS NULL;
