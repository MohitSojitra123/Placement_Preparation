use demo_1

CREATE TABLE Employees
(
    EmployeeID INT PRIMARY KEY IDENTITY(1,1),

    EmployeeName VARCHAR(100) NOT NULL,

    Department VARCHAR(50) NOT NULL,

    Salary DECIMAL(10,2) NOT NULL,

    Age INT NOT NULL,

    PerformanceScore INT NOT NULL,

    ExperienceYears INT NOT NULL,

    JoiningDate DATE NOT NULL,

    IsActive BIT NOT NULL DEFAULT 1
);


INSERT INTO Employees
(
    EmployeeName,
    Department,
    Salary,
    Age,
    PerformanceScore,
    ExperienceYears,
    JoiningDate,
    IsActive
)
VALUES
('Rahul', 'IT', 75000, 25, 90, 3, '2022-06-15', 1),

('Priya', 'HR', 55000, 28, 75, 5, '2020-03-10', 1),

('Amit', 'IT', 45000, 23, 60, 1, '2024-01-20', 1),

('Neha', 'Finance', 85000, 32, 95, 8, '2018-07-12', 1),

('Raj', 'Sales', 40000, 26, 45, 2, '2023-09-05', 1),

('Kiran', 'IT', 65000, 30, 80, 6, '2019-11-25', 1),

('Meena', 'HR', 35000, 24, 50, 1, '2024-05-15', 1),

('Vijay', 'Sales', 90000, 35, 88, 10, '2015-02-18', 1);


select * from Employees

SELECT
    EmployeeID,
    EmployeeName,
    Salary,

    CASE  
        WHEN Salary >= 80000 THEN 'High Salary'
        WHEN Salary >= 50000 THEN 'Medium Salary'
        ELSE 'Low Salary'
    END AS SalaryCategory

FROM Employees;