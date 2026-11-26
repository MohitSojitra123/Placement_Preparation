use demo_1


CREATE TABLE EmployeePerformance
(
    PerformanceID INT PRIMARY KEY IDENTITY(1,1),

    EmployeeID INT,

    EmployeeName VARCHAR(100),

    PerformanceScore INT,

    PerformanceGrade VARCHAR(30)
);


INSERT INTO EmployeePerformance
(
    EmployeeID,
    EmployeeName,
    PerformanceScore,
    PerformanceGrade
)
VALUES
(1, 'Rahul', 90, 'Excellent'),

(2, 'Priya', 75, 'Very Good'),

(3, 'Amit', 60, 'Good'),

(4, 'Neha', 95, 'Excellent'),

(5, 'Raj', 45, 'Poor'),

(6, 'Kiran', 80, 'Very Good'),

(7, 'Meena', 50, 'Average'),

(8, 'Vijay', 88, 'Very Good');


select * from EmployeePerformance

UPDATE EmployeePerformance
SET PerformanceGrade =
    CASE
        WHEN PerformanceGrade = 'Excellent' THEN 'EX'
        WHEN PerformanceGrade = 'Very Good' THEN 'VG'
        WHEN PerformanceGrade = 'Good' THEN 'GD'
        WHEN PerformanceGrade = 'Average' THEN 'AV'
        WHEN PerformanceGrade = 'Poor' THEN 'PR'
        ELSE PerformanceGrade
    END;

select * from EmployeePerformance






SELECT
    EmployeeID,
    EmployeeName,
    Department,
    PerformanceScore,

    CASE

        WHEN PerformanceScore >= 90
            THEN 'Top Performer'

        WHEN PerformanceScore >= 75
            THEN 'Good Performer'

        WHEN PerformanceScore >= 60
            THEN 'Average Performer'

        WHEN PerformanceScore >= 50
            THEN 'Needs Improvement'

        ELSE
            'Poor Performer'

    END AS PerformanceStatus

FROM Employees;


