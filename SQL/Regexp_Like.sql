CREATE DATABASE RegexInterviewDB;

USE RegexInterviewDB;


CREATE TABLE Employees
(
    EmployeeID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Email VARCHAR(100),
    Phone VARCHAR(20),
    Salary DECIMAL(10,2),
    Department VARCHAR(50),
    City VARCHAR(50),
    EmployeeCode VARCHAR(30),
    Website VARCHAR(200),
    Address VARCHAR(200),
    Skills VARCHAR(300),
    JoiningDate DATE
);


INSERT INTO Employees
(EmployeeID, FirstName, LastName, Email, Phone, Salary, Department,
 City, EmployeeCode, Website, Address, Skills, JoiningDate)
VALUES
(1, 'Mohit', 'Sojitra', 'mohit@gmail.com', '9876543210',
 45000, 'IT', 'Rajkot', 'EMP-IT-001',
 'https://google.com', 'Rajkot Gujarat', 'Java,SQL,React', '2024-01-15'),

(2, 'Rahul', 'Patel', 'rahul.patel@gmail.com', '9876512345',
 55000, 'HR', 'Ahmedabad', 'EMP-HR-002',
 'https://linkedin.com', 'Ahmedabad Gujarat', 'Excel,HR,SQL', '2023-05-20'),

(3, 'Priya', 'Shah', 'priya123@yahoo.com', '9123456780',
 65000, 'IT', 'Surat', 'EMP-IT-003',
 'https://github.com', 'Surat Gujarat', 'Java,Python,SQL', '2022-09-10'),

(4, 'Amit', 'Joshi', 'amit@company.org', '8123456789',
 40000, 'Finance', 'Vadodara', 'EMP-FN-004',
 'https://company.org', 'Vadodara Gujarat', 'Excel,Accounting', '2024-03-12'),

(5, 'Neha', 'Mehta', 'neha.mehta@gmail.com', '9988776655',
 72000, 'IT', 'Rajkot', 'EMP-IT-005',
 'https://example.com', 'Rajkot Gujarat', 'C#,SQL,.NET', '2021-07-18'),

(6, 'Ravi', 'Patel', 'ravi99@hotmail.com', '9090909090',
 38000, 'Support', 'Jamnagar', 'EMP-SP-006',
 'http://support.com', 'Jamnagar Gujarat', 'Networking,Linux', '2024-06-01'),

(7, 'Kiran', 'Desai', 'kiran.desai@gmail.com', '7000012345',
 50000, 'Sales', 'Bhavnagar', 'EMP-SL-007',
 'https://sales.in', 'Bhavnagar Gujarat', 'Sales,Communication', '2023-11-25'),

(8, 'Anjali', 'Patel', 'anjali@company.net', '8888888888',
 62000, 'IT', 'Rajkot', 'EMP-IT-008',
 'https://company.net', 'Rajkot Gujarat', 'JavaScript,React,Node', '2022-12-05'),

(9, 'Vivek', 'Sharma', 'vivek2024@gmail.com', '7666554433',
 47000, 'Admin', 'Gandhinagar', 'EMP-AD-009',
 'https://admin.com', 'Gandhinagar Gujarat', 'Management,Excel', '2024-02-14'),

(10, 'Pooja', 'Rana', 'pooja.rana@yahoo.com', '9555555555',
 58000, 'HR', 'Rajkot', 'EMP-HR-010',
 'https://hr.org', 'Rajkot Gujarat', 'Recruitment,SQL', '2023-08-22');


select * from Employees

--PATINDEX returns the starting position of the first occurrence of a pattern, unlike LIKE, which simply performs matching.



-- Find position of @ in email.
SELECT Email,
       PATINDEX('%@%', Email) AS AtPosition
FROM Employees;


--Find position of .com.
SELECT Email,
       PATINDEX('%.com%', Email) AS Position
FROM Employees;


--Find names containing a.
SELECT *
FROM Employees
WHERE PATINDEX('%a%', FirstName) > 0;

SELECT FirstName , PATINDEX('%a%',FirstName) As Search FROM Employees


-- Find names containing h.
SELECT *
FROM Employees
WHERE PATINDEX('%h%', FirstName) > 0;


--Find emails containing a digit.
SELECT *
FROM Employees
WHERE PATINDEX('%[0-9]%', Email) > 0;


--Find names containing a number.
SELECT *
FROM Employees
WHERE PATINDEX('%[0-9]%', FirstName) > 0;


--Find names containing a special character.
SELECT *
FROM Employees
WHERE PATINDEX('%[^A-Za-z]%', FirstName) > 0;



--Find employee codes containing a non-alphanumeric character.
SELECT *
FROM Employees
WHERE PATINDEX('%[^A-Za-z0-9]%', EmployeeCode) > 0;


--Find first non-digit character in phone.
SELECT Phone,
       PATINDEX('%[^0-9]%', Phone) AS InvalidPosition
FROM Employees;


--Validate that phone contains only digits.
SELECT *
FROM Employees
WHERE PATINDEX('%[^0-9]%', Phone) = 0;


--REGEXP_LIKE

--Check whether first name starts with M.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(FirstName, '^M');


--Check whether first name ends with a.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(FirstName, 'a$');


--Find names beginning with A and ending with t.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(FirstName, '^A.*t$');


--Find names containing only alphabets.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(FirstName, '^[A-Za-z]+$');

^      beginning
[A-Za-z] letters
+       one or more
$       ending


--Validate phone containing exactly 10 digits.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(Phone, '^[0-9]{10}$');


--Validate phone starting with 9.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(Phone, '^9[0-9]{9}$');


--Validate Indian-style mobile number beginning 6–9.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(Phone, '^[6-9][0-9]{9}$');


--Find emails containing gmail.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(Email, 'gmail');


--Validate basic email format.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(
    Email,
    '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$'
);


--Find emails ending in .com.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(Email, '\.com$');


--Find names containing a vowel.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(FirstName, '[AEIOUaeiou]');


--Find names containing a digit.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(FirstName, '[0-9]');


--Find names containing no digits.
SELECT *
FROM Employees
WHERE NOT REGEXP_LIKE(FirstName, '[0-9]');

--Find names containing only uppercase letters.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(FirstName, '^[A-Z]+$');


--Find strings containing uppercase letters.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(FirstName, '[A-Z]');


--Find strings containing lowercase letters.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(FirstName, '[a-z]');


--Find values containing special characters.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(EmployeeCode, '[^A-Za-z0-9]');


--Find values containing whitespace.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(Address, '\s');


--Find values containing only alphanumeric characters.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(EmployeeCode, '^[A-Za-z0-9]+$');


--Find exactly 5-digit numbers.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(Phone, '^[0-9]{5}$');


--Find strings containing at least 5 digits.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(Phone, '[0-9]{5,}');


--Find strings containing 5 to 10 digits.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(Phone, '[0-9]{5,10}');


--Find names with 3 or more characters.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(FirstName, '^[A-Za-z]{3,}$');



--Find names with exactly 5 characters.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(FirstName, '^[A-Za-z]{5}$');


--Find strings containing one or more digits.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(EmployeeCode, '[0-9]+');


--Find strings containing zero or more digits.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(EmployeeCode, '[0-9]*');


--Find employee codes having exactly three digits at the end.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(EmployeeCode, '[0-9]{3}$');


--Validate employee code format EMP-XX-999.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(
    EmployeeCode,
    '^EMP-[A-Z]{2}-[0-9]{3}$'
);

--Find employees from IT or HR.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(Department, '^(IT|HR)$');



--Find emails from Gmail or Yahoo.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(
    Email,
    '@(gmail|yahoo)\.'
);


--Find .com, .org, or .net.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(
    Website,
    '\.(com|org|net)$'
);


--Find employee codes for IT, HR, or Finance.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(
    EmployeeCode,
    '^EMP-(IT|HR|FN)-[0-9]{3}$'
);

--Find names beginning with Mohit or Rahul.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(
    FirstName,
    '^(Mohit|Rahul)$'
);


--Find cities Rajkot or Surat.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(
    City,
    '^(Rajkot|Surat)$'
);


--Find domains Gmail, Yahoo, or Hotmail.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(
    Email,
    '@(gmail|yahoo|hotmail)\.'
);


--Find URLs using HTTP or HTTPS.
--s? (Optional Character): The ? quantifier means the preceding character (s) is optional. It matches either "http" or "https".
SELECT *
FROM Employees
WHERE REGEXP_LIKE(
    Website,
    '^https?://'
);


--SQL Server's REGEXP_LIKE supports i for case-insensitive matching and c for case-sensitive matching.

--Case-insensitive search for mohit.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(FirstName, '^mohit$', 'i');

--Case-sensitive search for Mohit.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(FirstName, '^Mohit$', 'c');


--Case-insensitive search for IT department.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(Department, '^it$', 'i');


--Find Gmail regardless of case.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(Email, '@gmail\.com$', 'i');



--SQL Server 2025 provides multiple regex functions, not just REGEXP_LIKE.

--Extract the first number using REGEXP_SUBSTR.
SELECT REGEXP_SUBSTR(
    'Employee 123 belongs to IT',
    '[0-9]+'
) AS NumberValue;

--Result:
--123


--Replace digits with X.
SELECT REGEXP_REPLACE(
    Phone,
    '[0-9]',
    'X'
) AS MaskedPhone
FROM Employees;

--Example:
--9876543210
--XXXXXXXXXX


--Mask the last four digits.
SELECT REGEXP_REPLACE(
    Phone,
    '[0-9]{4}$',
    'XXXX'
) AS MaskedPhone
FROM Employees;


--Replace multiple spaces with one space.
SELECT REGEXP_REPLACE(
    Address,
    '\s+',
    ' '
) AS CleanAddress
FROM Employees;


--Remove all non-numeric characters.
SELECT REGEXP_REPLACE(
    Phone,
    '[^0-9]',
    ''
) AS OnlyNumbers
FROM Employees;


--Remove all special characters.
SELECT REGEXP_REPLACE(
    EmployeeCode,
    '[^A-Za-z0-9]',
    ''
) AS CleanCode
FROM Employees;


--REGEXP_COUNT
--Count digits in phone.
SELECT Phone,
       REGEXP_COUNT(Phone, '[0-9]') AS DigitCount
FROM Employees;


--Count vowels in first name.
SELECT FirstName,
       REGEXP_COUNT(FirstName, '[AEIOUaeiou]') AS VowelCount
FROM Employees;


--Count occurrences of a.
SELECT FirstName,
       REGEXP_COUNT(FirstName, 'a', 1, 'i') AS ACount
FROM Employees;

--Count dots in email.
SELECT Email,
       REGEXP_COUNT(Email, '\.') AS DotCount
FROM Employees;


--Count digits in employee code.
SELECT EmployeeCode,
       REGEXP_COUNT(EmployeeCode, '[0-9]') AS DigitCount
FROM Employees;


--Find invalid phone numbers.
SELECT *
FROM Employees
WHERE NOT REGEXP_LIKE(
    Phone,
    '^[6-9][0-9]{9}$'
);


--Find invalid emails.
SELECT *
FROM Employees
WHERE NOT REGEXP_LIKE(
    Email,
    '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$'
);

--Find invalid employee codes.
SELECT *
FROM Employees
WHERE NOT REGEXP_LIKE(
    EmployeeCode,
    '^EMP-[A-Z]{2}-[0-9]{3}$'
);

--Find websites that are not HTTP/HTTPS.
SELECT *
FROM Employees
WHERE NOT REGEXP_LIKE(
    Website,
    '^https?://'
);


--Find employee names containing numbers or special characters.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(
    FirstName,
    '[^A-Za-z]'
);



--Validate an email completely.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(
    Email,
    '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$'
);

--Breakdown:

^                       Start
[A-Za-z0-9._%+-]+       Username
@                       Required @
[A-Za-z0-9.-]+          Domain
\.                      Literal dot
[A-Za-z]{2,}            TLD, minimum 2 characters
$                       End



--Validate Indian mobile number with optional country code.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(
    Phone,
    '^(\+91[- ]?)?[6-9][0-9]{9}$'
);

--Matches patterns such as:

9876543210
+919876543210
+91 9876543210
+91-9876543210


--Validate employee code with three allowed departments.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(
    EmployeeCode,
    '^EMP-(IT|HR|FN)-[0-9]{3}$'
);


--Find employee codes containing exactly three digits.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(
    EmployeeCode,
    '[0-9]{3}'
);

--Find strings starting with a digit.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(
    EmployeeCode,
    '^[0-9]'
);

--Find strings ending with a digit.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(
    EmployeeCode,
    '[0-9]$'
);

--Find strings containing only digits.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(
    Phone,
    '^[0-9]+$'
);


--Find employee records where email username contains at least one digit.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(
    Email,
    '^[^@]*[0-9][^@]*@'
);

--Logic:

^[^@]*      username characters
[0-9]       at least one digit
[^@]*       remaining username
@           email separator


--Find valid employee records using multiple regex validations.
SELECT *
FROM Employees
WHERE REGEXP_LIKE(
          FirstName,
          '^[A-Za-z]+$'
      )
  AND REGEXP_LIKE(
          Phone,
          '^[6-9][0-9]{9}$'
      )
  AND REGEXP_LIKE(
          Email,
          '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$'
      )
  AND REGEXP_LIKE(
          EmployeeCode,
          '^EMP-[A-Z]{2}-[0-9]{3}$'
      );






























| Regex    | Meaning            | Example       |      |       |
| -------- | ------------------ | ------------- | ---- | ----- |
| `.`      | Any character      | `a.c`         |      |       |
| `^`      | Beginning          | `^A`          |      |       |
| `$`      | End                | `com$`        |      |       |
| `*`      | 0 or more          | `ab*`         |      |       |
| `+`      | 1 or more          | `ab+`         |      |       |
| `?`      | 0 or 1             | `colou?r`     |      |       |
| `{n}`    | Exactly n          | `[0-9]{10}`   |      |       |
| `{n,}`   | At least n         | `[0-9]{5,}`   |      |       |
| `{n,m}`  | Between n and m    | `[0-9]{5,10}` |      |       |
| `[abc]`  | a/b/c              | `[aeiou]`     |      |       |
| `[a-z]`  | Range              | `[a-z]`       |      |       |
| `[^abc]` | Not a/b/c          | `[^0-9]`      |      |       |
| `()`     | Capturing group    | `(SQL)`       |      |       |
| `        | `                  | OR            | `SQL | Java` |
| `\d`     | Digit              | `\d+`         |      |       |
| `\D`     | Non-digit          | `\D+`         |      |       |
| `\w`     | Word character     | `\w+`         |      |       |
| `\W`     | Non-word character | `\W+`         |      |       |
| `\s`     | Whitespace         | `\s+`         |      |       |
| `\S`     | Non-whitespace     | `\S+`         |      |       |
| `\.`     | Literal dot        | `\.`          |      |       |
| `\+`     | Literal plus       | `\+`          |      |       |
| `\[`     | Literal `[`        | `\[`          |      |       |

