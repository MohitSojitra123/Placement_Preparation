Department
    |
    | 1-to-many
    ↓
Employee
    |
    | many-to-many
    ↓
EmployeeProject
    |
    ↓
Project



CREATE TABLE Department
(
    DepartmentId INT PRIMARY KEY,
    DepartmentName VARCHAR(100) NOT NULL,
    Location VARCHAR(100)
);



CREATE TABLE Employee
(
    EmployeeId INT PRIMARY KEY,
    EmployeeName VARCHAR(100) NOT NULL,
    Salary DECIMAL(10,2),
    DepartmentId INT,
    ManagerId INT NULL,

    FOREIGN KEY (DepartmentId)
        REFERENCES Department(DepartmentId)
);

CREATE TABLE Project
(
    ProjectId INT PRIMARY KEY,
    ProjectName VARCHAR(100) NOT NULL,
    Budget DECIMAL(12,2),
    DepartmentId INT,

    FOREIGN KEY (DepartmentId)
        REFERENCES Department(DepartmentId)
);

INSERT INTO Department
VALUES
(1, 'IT', 'Rajkot'),
(2, 'HR', 'Ahmedabad'),
(3, 'Finance', 'Surat'),
(4, 'Marketing', 'Vadodara'),
(5, 'Sales', 'Rajkot');


INSERT INTO Employee
VALUES
(101, 'Rahul', 75000, 1, NULL),
(102, 'Amit', 60000, 1, 101),
(103, 'Priya', 55000, 2, NULL),
(104, 'Neha', 80000, 3, NULL),
(105, 'Raj', 45000, 4, NULL),
(106, 'Karan', 70000, 1, 101),
(107, 'Pooja', 50000, 5, NULL),
(108, 'Vivek', 90000, 3, 104);


INSERT INTO Project
VALUES
(201, 'Banking System', 500000, 1),
(202, 'HR Portal', 200000, 2),
(203, 'Finance Management', 700000, 3),
(204, 'Marketing Website', 300000, 4),
(205, 'E-Commerce', 900000, 1),
(206, 'Sales Dashboard', 400000, 5);

select * from Employee
select * from Department
select * from Project

--Employee with Department

SELECT
    e.EmployeeName,
    d.DepartmentName
FROM Employee e
INNER JOIN Department d
    ON e.DepartmentId = d.DepartmentId;


-- Employee, Department and Project

SELECT
    e.EmployeeName,
    d.DepartmentName,
    p.ProjectName
FROM Employee e
INNER JOIN Department d
    ON e.DepartmentId = d.DepartmentId
INNER JOIN Project p
    ON d.DepartmentId = p.DepartmentId;


-- Employees Working in IT Projects

SELECT
    e.EmployeeName,
    d.DepartmentName,
    p.ProjectName
FROM Employee e
INNER JOIN Department d
    ON e.DepartmentId = d.DepartmentId
INNER JOIN Project p
    ON d.DepartmentId = p.DepartmentId
WHERE d.DepartmentName = 'IT';




--Employee Salary and Project Budget


SELECT
    e.EmployeeName,
    e.Salary,
    d.DepartmentName,
    p.ProjectName,
    p.Budget
FROM Employee e
INNER JOIN Department d
    ON e.DepartmentId = d.DepartmentId
INNER JOIN Project p
    ON d.DepartmentId = p.DepartmentId;


--Projects in Rajkot

SELECT
    d.DepartmentName,
    d.Location,
    p.ProjectName,
    p.Budget
FROM Department d
INNER JOIN Employee e
    ON d.DepartmentId = e.DepartmentId
INNER JOIN Project p
    ON d.DepartmentId = p.DepartmentId
WHERE d.Location = 'Rajkot';


--Employees Having Salary > 60,000 

SELECT
    e.EmployeeName,
    e.Salary,
    d.DepartmentName,
    p.ProjectName
FROM Employee e
INNER JOIN Department d
    ON e.DepartmentId = d.DepartmentId
INNER JOIN Project p
    ON d.DepartmentId = p.DepartmentId
WHERE e.Salary > 60000;


--Department-wise Employee Count

SELECT
    d.DepartmentName,
    COUNT(e.EmployeeId) AS EmployeeCount,
    p.ProjectName
FROM Department d
INNER JOIN Employee e
    ON d.DepartmentId = e.DepartmentId
INNER JOIN Project p
    ON d.DepartmentId = p.DepartmentId
GROUP BY
    d.DepartmentName,
    p.ProjectName;


--Departments Having Average Salary > 60,000

SELECT
    d.DepartmentName,
    AVG(e.Salary) AS AverageSalary,
    p.ProjectName
FROM Department d
INNER JOIN Employee e
    ON d.DepartmentId = e.DepartmentId
INNER JOIN Project p
    ON d.DepartmentId = p.DepartmentId
GROUP BY
    d.DepartmentName,
    p.ProjectName
HAVING AVG(e.Salary) > 60000;


-- Highest Paid Employee in Each Department

select EmployeeName,Salary from
(select EmployeeName,Salary, row_number() over(partition by departmentId order by salary desc) as rnk from Employee)  as temp_table
where rnk = 1


--Projects with Budget Greater Than 400,000

SELECT
    e.EmployeeName,
    d.DepartmentName,
    p.ProjectName,
    p.Budget
FROM Employee e
INNER JOIN Department d
    ON e.DepartmentId = d.DepartmentId
INNER JOIN Project p
    ON d.DepartmentId = p.DepartmentId
WHERE p.Budget > 400000;

-- Department Having Maximum Average Salary

SELECT TOP 1
    d.DepartmentName,
    AVG(e.Salary) AS AverageSalary,
    p.ProjectName
FROM Department d
INNER JOIN Employee e
    ON d.DepartmentId = e.DepartmentId
INNER JOIN Project p
    ON d.DepartmentId = p.DepartmentId
GROUP BY
    d.DepartmentName,
    p.ProjectName
ORDER BY AVG(e.Salary) DESC;


-- Employees Whose Salary Is Greater Than Department Average

SELECT e1.EmployeeName , e1.Salary 
FROM Employee e1 
WHERE e1.Salary > (
    SELECT AVG(e2.Salary) 
    FROM Employee e2 
    WHERE e2.DepartmentId = e1.DepartmentId
);

-- Department With Highest Project Budget

select DepartmentName from Department where DepartmentId=
(select top 1 DepartmentId  from Project order by Budget desc)


SELECT
    d.DepartmentName,
    p.ProjectName,
    p.Budget
FROM Department d
INNER JOIN Employee e
    ON d.DepartmentId = e.DepartmentId
INNER JOIN Project p
    ON d.DepartmentId = p.DepartmentId
WHERE p.Budget =
(
    SELECT MAX(p2.Budget)
    FROM Project p2
);


--Second Highest Salary Employee With Project

SELECT
    e.EmployeeName,
    e.Salary,
    d.DepartmentName,
    p.ProjectName
FROM Employee e
INNER JOIN Department d
    ON e.DepartmentId = d.DepartmentId
INNER JOIN Project p
    ON d.DepartmentId = p.DepartmentId
WHERE e.Salary =
(
    SELECT MAX(Salary)
    FROM Employee
    WHERE Salary <
    (
        SELECT MAX(Salary)
        FROM Employee
    )
);

-- Department Salary and Project Analysis

--Find departments where:

--Average employee salary > 60,000
--Project budget > 400,000
--Show total employees
--Show average salary
--Show project budget

SELECT
    d.DepartmentName,
    COUNT(e.EmployeeId) AS TotalEmployees,
    AVG(e.Salary) AS AverageSalary,
    p.ProjectName,
    p.Budget
FROM Department d
INNER JOIN Employee e
    ON d.DepartmentId = e.DepartmentId
INNER JOIN Project p
    ON d.DepartmentId = p.DepartmentId
GROUP BY
    d.DepartmentName,
    p.ProjectName,
    p.Budget
HAVING
    AVG(e.Salary) > 60000
    AND p.Budget > 400000;


use StudentProjectDb 
select * from Employee
select * from Department
select * from Project