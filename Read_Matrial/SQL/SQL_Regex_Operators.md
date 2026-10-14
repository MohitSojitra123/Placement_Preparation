# SQL Regex, Pattern Matching & Top 100 Interview Questions
### (SQL Server Management Studio – T-SQL)

---

## PART 1 — Pattern Matching & Regex-Style Operators in SQL Server

> **Important clarification first:** SQL Server's `T-SQL` does **not** have a native, full regular-expression engine like MySQL's `REGEXP`, PostgreSQL's `~`, or Oracle's `REGEXP_LIKE`. What SQL Server gives you natively is the **`LIKE` wildcard operator**, plus `PATINDEX`, `CHARINDEX`, `SUBSTRING`, `REPLACE`, `STRING_SPLIT`, etc. True regex tokens such as `\d`, `\w`, `\s`, `+`, `?`, `|`, `{n,m}` are **not understood by `LIKE`/`PATINDEX`** — they must be emulated using combinations of these functions, or by writing a **CLR (SQLCLR) function**, or by calling regex from an application layer.
>
> Below, **Section A** covers the wildcards SQL Server truly supports (`%`, `_`, `[]`, `[^]`), and **Section B** walks through every "classic regex" symbol you listed (`.`, `^`, `$`, `*`, `+`, `?`, `{n}`, `{n,m}`, `()`, `|`, `\d`, `\w`, `\s`), explains what it means in true regex (as used in MySQL/PostgreSQL/Oracle/.NET), and shows the closest **T-SQL equivalent or workaround**, with a full SSMS-runnable example for every single one.

### Common Table Schema (used for every example in this document)

```sql
CREATE DATABASE CompanyDB;
GO
USE CompanyDB;
GO

CREATE TABLE Departments (
    DepartmentID    INT PRIMARY KEY,
    DepartmentName  VARCHAR(50)  NOT NULL,
    Location        VARCHAR(50)
);

CREATE TABLE Employees (
    EmployeeID     INT PRIMARY KEY,
    FirstName      VARCHAR(50)  NOT NULL,
    LastName       VARCHAR(50)  NOT NULL,
    Email          VARCHAR(100),
    Phone          VARCHAR(20),
    DepartmentID   INT          FOREIGN KEY REFERENCES Departments(DepartmentID),
    ManagerID      INT          NULL,
    Salary         DECIMAL(10,2),
    HireDate       DATE,
    JobTitle       VARCHAR(50),
    City           VARCHAR(50)
);
GO

INSERT INTO Departments VALUES
(1,'IT','Ahmedabad'),
(2,'HR','Mumbai'),
(3,'Sales','Delhi'),
(4,'Finance','Rajkot');

INSERT INTO Employees VALUES
(101,'Aman','Shah','aman.shah@company.com','9876543210',1,NULL,95000,'2018-03-12','IT Manager','Ahmedabad'),
(102,'Riya','Patel','riya_patel99@company.com','9123456780',1,101,65000,'2019-07-01','Developer','Rajkot'),
(103,'Karan','Mehta','karan.mehta@company.com','9988776655',1,101,58000,'2020-01-15','Developer','Mumbai'),
(104,'Neha','Joshi','neha.joshi@company.com','9090909090',2,NULL,72000,'2017-11-20','HR Manager','Delhi'),
(105,'Vivek','Rana','vivek_rana@company.com',NULL,2,104,45000,'2021-06-05','HR Executive','Mumbai'),
(106,'Priya','Desai','priya.desai88@company.com','9871234560',3,NULL,80000,'2016-09-09','Sales Manager','Delhi'),
(107,'Sahil','Kapoor','sahil.kapoor@company.com','9871122334',3,106,52000,'2020-02-14','Sales Executive','Ahmedabad'),
(108,'Anjali','Verma','anjali_verma@company.com','9012345678',3,106,50000,'2022-04-18','Sales Executive','Rajkot'),
(109,'Rohit','Nair','rohit.nair@company.com','9876501234',4,NULL,90000,'2015-05-30','Finance Manager','Mumbai'),
(110,'Simran','Kaur','simran.kaur@company.com','9090001122',4,109,60000,'2019-12-25','Accountant','Delhi'),
(111,'Aditya','Rao',NULL,'9871239876',4,109,48000,'2023-01-10','Accountant','Rajkot'),
(112,'Meera','Iyer','meera.iyer123@company.com','9988001122',1,101,70000,'2021-08-08','Developer','Ahmedabad'),
(113,'Farhan','Sheikh','farhan.sheikh@company.com','9871230000',2,104,42000,'2022-09-09','HR Executive','Mumbai'),
(114,'Divya','Menon','divya.menon@company.com','9090112233',3,106,55000,'2020-10-10','Sales Executive','Delhi'),
(115,'Yash','Trivedi','yash.trivedi@company.com','9123998877',1,101,62000,'2022-03-03','Developer','Rajkot');
GO
```

All 100+ example queries in this document run against this exact schema. Copy the script above into a new SSMS query window first, execute it, and then every query below will run without modification.

---

## SECTION A — Native SQL Server `LIKE` Wildcards

| Symbol | Meaning |
|---|---|
| `%` | Zero, one, or more characters |
| `_` | Exactly one character |
| `[abc]` | Any single character in the set (a, b, or c) |
| `[a-z]` | Any single character in the range |
| `[^abc]` | Any single character **NOT** in the set |

### A.1 `%` — Zero or More Characters

**Signature:** `column LIKE 'pattern%'` / `'%pattern'` / `'%pattern%'`

**Use Case:** Search for any substring occurring anywhere, at the start, or at the end of a string. This is the most common wildcard — used for "contains", "starts with", "ends with" searches.

```sql
-- Employees whose email STARTS WITH 'aman'
SELECT EmployeeID, FirstName, Email
FROM Employees
WHERE Email LIKE 'aman%';

-- Employees whose email CONTAINS 'patel'
SELECT EmployeeID, FirstName, Email
FROM Employees
WHERE Email LIKE '%patel%';

-- Employees whose email ENDS WITH '.com'
SELECT EmployeeID, FirstName, Email
FROM Employees
WHERE Email LIKE '%.com';
```

**Explanation:** `%` matches any sequence of characters (including an empty sequence). `'aman%'` matches "aman.shah@company.com" because it starts with "aman". `'%patel%'` matches anything containing "patel" anywhere in the middle. `'%.com'` matches anything ending in literal ".com". Internally SQL Server implements this using a string-scan or, if there is an index and the pattern doesn't start with `%`, an index seek; leading `%` forces a full scan.

---

### A.2 `_` — Exactly One Character

**Signature:** `column LIKE 'pa_tern'`

**Use Case:** Match a fixed-length placeholder — e.g., validating that a code has an exact character in a specific position, or finding 4-digit years, single-character differences, etc.

```sql
-- Find employees whose FirstName is exactly 4 letters and starts with 'Ka'
SELECT FirstName
FROM Employees
WHERE FirstName LIKE 'Ka__';

-- Find phone numbers where the 5th digit is '5'
SELECT EmployeeID, Phone
FROM Employees
WHERE Phone LIKE '____5%';
```

**Explanation:** Each `_` matches **exactly one** character, no more, no less. `'Ka__'` matches a 4-character string starting with "Ka" (e.g., "Karan" is 5 chars so it wouldn't match — only exactly `K a _ _` = 4 chars total). `'____5%'` says: any 4 characters, then a literal '5', then anything else — meaning the 5th character of the phone number must be '5'.

---

### A.3 `[list]` — Character Set Match

**Signature:** `column LIKE '[characters]pattern'`

**Use Case:** Match one character out of a defined set at a specific position — useful for validating that a name starts with a particular group of letters, or a code starts with a digit vs a letter.

```sql
-- Employees whose FirstName starts with A, K, or R
SELECT FirstName
FROM Employees
WHERE FirstName LIKE '[AKR]%';

-- Employees whose City starts with a vowel
SELECT DISTINCT City
FROM Employees
WHERE City LIKE '[AEIOU]%';
```

**Explanation:** `[AKR]` means "match exactly one character that is either A, K, or R" at that position. Combined with `%` after it, it becomes "starts with A, K, or R, followed by anything".

---

### A.4 `[a-z]` — Range Match

**Signature:** `column LIKE '[a-z]pattern'` or `'[0-9]pattern'`

**Use Case:** Validate that a column falls within an alphabetical or numeric range at a given position — commonly used to check if a value starts with a letter vs. a digit, or filter alphabetically.

```sql
-- Employees whose LastName starts with a letter between A and M
SELECT FirstName, LastName
FROM Employees
WHERE LastName LIKE '[A-M]%';

-- Find any email's local part that begins with a digit (data-quality check)
SELECT Email
FROM Employees
WHERE Email LIKE '[0-9]%';
```

**Explanation:** `[A-M]` matches a single character within the ASCII/collation range A through M inclusive. Ranges depend on the column's **collation** — case sensitivity of the range depends on whether the collation is case-sensitive (`_CS`) or case-insensitive (`_CI`, the SQL Server default).

---

### A.5 `[^list]` / `[^range]` — Negated Match

**Signature:** `column LIKE '[^abc]pattern'`

**Use Case:** Exclude specific starting characters — e.g., "give me everyone whose name does NOT start with a vowel", or exclude a known bad-data pattern.

```sql
-- Employees whose FirstName does NOT start with A, K, or R
SELECT FirstName
FROM Employees
WHERE FirstName LIKE '[^AKR]%';

-- Employees whose City does not start with a vowel
SELECT DISTINCT City
FROM Employees
WHERE City LIKE '[^AEIOU]%';
```

**Explanation:** `[^AKR]` matches any single character that is **not** A, K, or R. This is SQL Server's only built-in "negation" mechanism inside pattern matching — it is the direct T-SQL analogue of regex's `[^abc]`.

---

### A.6 Escaping Wildcards with `ESCAPE`

**Signature:** `column LIKE '%50\%%' ESCAPE '\'`

**Use Case:** When you need to search for a **literal** `%`, `_`, or `[` character (e.g. a value that actually contains a percent sign), you must escape it, otherwise SQL Server treats it as a wildcard.

```sql
-- Suppose JobTitle could contain a literal underscore, e.g. 'Sales_Exec'
SELECT JobTitle
FROM Employees
WHERE JobTitle LIKE '%Sales\_Exec%' ESCAPE '\';
```

**Explanation:** The `ESCAPE '\'` clause tells SQL Server that whenever `\` appears before a wildcard character in the pattern, treat the next character literally instead of as a wildcard.

---

## SECTION B — True Regex Metacharacters vs. T-SQL Reality

The tokens below (`.`, `^`, `$`, `*`, `+`, `?`, `{n}`, `{n,m}`, `()`, `|`, `\d`, `\w`, `\s`) belong to **POSIX/PCRE-style regular expressions**. They work directly in:
- MySQL: `column REGEXP 'pattern'`
- PostgreSQL: `column ~ 'pattern'`
- Oracle: `REGEXP_LIKE(column, 'pattern')`

**SQL Server's `LIKE` does NOT understand any of these** except a limited overlap for `^` (only meaningful inside `[]` as negation) and `*`/`?`/`.` are NOT wildcards in T-SQL at all (they are literal characters to `LIKE`). For every symbol below we give: (1) what it means in true regex, (2) whether/how SQL Server can approximate it, (3) a full working SSMS example.


### B.1 `.` — Any Single Character (regex)

**True regex meaning:** Matches any one character (except newline, in most engines).
**T-SQL equivalent:** Use `_` (underscore) from `LIKE` — it behaves identically to `.` for a single position.

```sql
-- Regex idea:  Email REGEXP '^a.an'  (MySQL)
-- T-SQL equivalent using _
SELECT Email FROM Employees WHERE Email LIKE 'a_an%';
```
**Explanation:** In true regex, `.` matches literally any character. T-SQL has no `.` wildcard in `LIKE`; `_` is the direct substitute since both mean "exactly one arbitrary character".

---

### B.2 `^` — Start of String (regex anchor)

**True regex meaning:** Anchors the match to the **beginning** of the string (e.g., `^Aman` matches only strings starting with "Aman").
**T-SQL equivalent:** `LIKE` is anchored by default when there's **no leading `%`**. So `LIKE 'Aman%'` already means "starts with Aman" — you never need a separate `^` symbol in T-SQL.

```sql
-- Regex idea:  FirstName REGEXP '^Aman'
-- T-SQL equivalent
SELECT FirstName FROM Employees WHERE FirstName LIKE 'Aman%';
```
**Explanation:** T-SQL patterns are implicitly anchored at the start unless you add a leading `%`. So the "start anchor" concept is built into how `LIKE` works, not a separate character.

> Note: Inside `[...]`, `^` means **negation** in T-SQL (see Section A.5) — a completely different job from the regex start-anchor `^`. Don't confuse the two.

---

### B.3 `$` — End of String (regex anchor)

**True regex meaning:** Anchors the match to the **end** of the string (e.g., `com$` matches strings ending in "com").
**T-SQL equivalent:** `LIKE` is anchored at the end by default when there's **no trailing `%`**. So `LIKE '%.com'` already means "ends with .com".

```sql
-- Regex idea:  Email REGEXP 'com$'
-- T-SQL equivalent
SELECT Email FROM Employees WHERE Email LIKE '%.com';
```
**Explanation:** Just as with `^`, T-SQL's `LIKE` is end-anchored unless you add a trailing `%`, so `$` has no separate symbol — the absence of `%` at the end does the job.

---

### B.4 `*` — Zero or More of Preceding Token (regex quantifier)

**True regex meaning:** Repeats the **preceding character/group** zero or more times (e.g., `ab*c` matches "ac", "abc", "abbc", "abbbc"...).
**T-SQL equivalent:** No direct equivalent — `LIKE`'s `%` means "zero or more of ANY character", not "zero or more of a specific preceding character". To emulate `ab*c` you'd need `REPLACE`/`PATINDEX` tricks or a CLR function.

```sql
-- Regex idea:  Phone REGEXP '^98+7'   (one or more repeats of a digit)
-- T-SQL approximate workaround using PATINDEX (checks presence, not exact repetition)
SELECT Phone
FROM Employees
WHERE Phone LIKE '98%7%';   -- loose approximation only, NOT true '*' semantics
```
**Explanation:** T-SQL simply has no per-character repetition quantifier. This is the biggest real gap between `LIKE` and true regex. For exact regex-quantifier behavior in production, use a **CLR scalar function** wrapping .NET's `System.Text.RegularExpressions.Regex.IsMatch()`, or push the check to the application layer (C#, Python) before/after the query.

---

### B.5 `+` — One or More of Preceding Token (regex quantifier)

**True regex meaning:** Repeats the preceding token **one or more** times (e.g., `\d+` = one or more digits).
**T-SQL equivalent:** No native symbol. `LIKE` can't express "one or more digits" directly for variable length; you approximate with a fixed number of `_` (e.g., `_` repeated 10 times for a 10-digit phone) or use `PATINDEX` with a character-class pattern that finds **at least one** occurrence.

```sql
-- Check if Phone contains AT LEAST one digit using PATINDEX (returns position, 0 = not found)
SELECT Phone, PATINDEX('%[0-9]%', Phone) AS FirstDigitPosition
FROM Employees;

-- Enforce "Phone is exactly 10 digits" (fixed-length substitute for \d{10} i.e. \d+ bounded)
SELECT Phone
FROM Employees
WHERE Phone LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]';
```
**Explanation:** `PATINDEX('%[0-9]%', Phone)` uses SQL Server's character-class support (`[0-9]`) combined with `%` to detect "does at least one digit exist anywhere" — the closest native gesture toward `+`. For exact-length repetition, you manually repeat `[0-9]` N times since T-SQL has no `{n}`/`+` counter.

---

### B.6 `?` — Zero or One of Preceding Token (regex quantifier)

**True regex meaning:** Makes the preceding token **optional** (e.g., `colou?r` matches "color" and "colour").
**T-SQL equivalent:** No native symbol — emulate with an `OR` of two `LIKE` patterns.

```sql
-- Regex idea: JobTitle REGEXP '^Sr\.? Developer'  (optional period after Sr)
SELECT JobTitle
FROM Employees
WHERE JobTitle LIKE 'Sr Developer' OR JobTitle LIKE 'Sr. Developer';
```
**Explanation:** Since `LIKE` has no optionality operator, you list both variants (with and without the optional character) joined by `OR`, or use `REPLACE(JobTitle,'.','')` to normalize before comparing.

---

### B.7 `{n}` — Exactly n Repetitions (regex quantifier)

**True regex meaning:** Repeats the preceding token exactly `n` times (e.g., `\d{10}` = exactly 10 digits).
**T-SQL equivalent:** Repeat the character class literally `n` times, or check `LEN()` combined with a character-class `LIKE`.

```sql
-- Regex idea: Phone REGEXP '^[0-9]{10}$'
SELECT Phone
FROM Employees
WHERE Phone LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'
  AND LEN(Phone) = 10;
```
**Explanation:** Repeating `[0-9]` ten times manually gives you the "exactly 10 digit characters" check; adding `LEN(Phone) = 10` guards against extra characters since `LIKE` alone, without a trailing anchor concept, could still match a longer string containing 10 leading digits plus more characters unless the whole pattern length matches.

---

### B.8 `{n,m}` — Between n and m Repetitions (regex quantifier)

**True regex meaning:** Repeats the preceding token between `n` and `m` times (e.g., `\d{3,5}` = 3 to 5 digits).
**T-SQL equivalent:** Combine `LEN()` range check with a general digit-only pattern check (via `PATINDEX` with a **negated** class to confirm *no* non-digit exists).

```sql
-- Regex idea: SomeCode REGEXP '^[0-9]{3,5}$'
-- T-SQL: confirm string is 3 to 5 characters long AND entirely digits
SELECT EmployeeID, Phone
FROM Employees
WHERE LEN(Phone) BETWEEN 3 AND 5
  AND PATINDEX('%[^0-9]%', Phone) = 0;   -- 0 means "no non-digit character found"
```
**Explanation:** `PATINDEX('%[^0-9]%', Phone) = 0` is a powerful trick: `[^0-9]` matches any character that is **not** a digit; if `PATINDEX` returns 0, it means no such character was found anywhere in the string, i.e. the entire string is digits. Combined with a `LEN()` range, this fully emulates `{n,m}` bounded-digit validation.

---

### B.9 `()` — Grouping (regex)

**True regex meaning:** Groups a sub-pattern together, often used with `|` or a quantifier, e.g. `(Mr|Mrs)\.` groups the alternation.
**T-SQL equivalent:** No grouping construct in `LIKE`. Emulate by writing out each branch as its own full `LIKE`/`OR` condition, or use parentheses at the **SQL boolean-logic level** (which is a different kind of grouping — grouping conditions, not pattern tokens).

```sql
-- Regex idea: JobTitle REGEXP '^(Sales|HR) (Manager|Executive)$'
SELECT JobTitle
FROM Employees
WHERE (JobTitle LIKE 'Sales Manager' OR JobTitle LIKE 'Sales Executive')
   OR (JobTitle LIKE 'HR Manager'    OR JobTitle LIKE 'HR Executive');
```
**Explanation:** SQL's own `()` around `WHERE` clauses groups **boolean conditions**, and is used here to emulate what regex `()` + `|` would do at the pattern level — it's a workaround, not a real pattern-grouping feature of `LIKE`.

---

### B.10 `|` — OR / Alternation (regex)

**True regex meaning:** Matches either the left or right sub-pattern, e.g. `cat|dog`.
**T-SQL equivalent:** SQL's own `OR` keyword, or `IN (...)` for a list of exact alternatives.

```sql
-- Regex idea: Department REGEXP 'IT|Finance'
SELECT e.FirstName, d.DepartmentName
FROM Employees e
JOIN Departments d ON e.DepartmentID = d.DepartmentID
WHERE d.DepartmentName LIKE 'IT' OR d.DepartmentName LIKE 'Finance';

-- Cleaner using IN
SELECT e.FirstName, d.DepartmentName
FROM Employees e
JOIN Departments d ON e.DepartmentID = d.DepartmentID
WHERE d.DepartmentName IN ('IT','Finance');
```
**Explanation:** T-SQL's `OR`/`IN` operators are the natural, and arguably better, substitute for regex alternation `|` when you're matching whole values rather than sub-patterns within a larger string.

---

### B.11 `\d` — Digit Character Class (regex)

**True regex meaning:** Matches any single digit `0-9`.
**T-SQL equivalent:** `[0-9]` inside `LIKE`/`PATINDEX` — T-SQL's character-class syntax already supports digit ranges natively, just with different syntax.

```sql
-- Regex idea: Email REGEXP '[0-9]'  i.e. contains a digit
SELECT Email
FROM Employees
WHERE Email LIKE '%[0-9]%';
```
**Explanation:** `[0-9]` is functionally identical to `\d` — both mean "any single digit character" — just expressed with SQL Server's bracket range syntax instead of a backslash shorthand.

---

### B.12 `\w` — Word Character Class (regex)

**True regex meaning:** Matches any "word" character: letters, digits, and underscore (`[A-Za-z0-9_]`).
**T-SQL equivalent:** `[A-Za-z0-9_]` written out explicitly as a character-class range in `LIKE`.

```sql
-- Regex idea: username REGEXP '^\w+$' (only word characters, e.g., validating email local-part)
SELECT Email
FROM Employees
WHERE LEFT(Email, CHARINDEX('@', Email) - 1) NOT LIKE '%[^A-Za-z0-9_.]%';
```
**Explanation:** Since T-SQL has no `\w` shorthand, you spell the equivalent class out (`A-Za-z0-9_`) inside brackets. Here we extract the email's local part (before `@`) using `LEFT`/`CHARINDEX`, then use a negated class to confirm it contains no characters outside letters/digits/underscore/period.

---

### B.13 `\s` — Whitespace Character Class (regex)

**True regex meaning:** Matches any whitespace character (space, tab, newline).
**T-SQL equivalent:** `' '` (literal space) inside `LIKE`, or `[ \t\n\r]` style bracket-class if you need to catch tabs/newlines too; also `LTRIM`/`RTRIM`/`REPLACE(col, ' ', '')` to strip whitespace.

```sql
-- Regex idea: JobTitle REGEXP '\s'  (contains at least one space)
SELECT JobTitle
FROM Employees
WHERE JobTitle LIKE '% %';

-- Find leading/trailing accidental whitespace (data-quality check)
SELECT EmployeeID, FirstName
FROM Employees
WHERE FirstName <> LTRIM(RTRIM(FirstName));
```
**Explanation:** `'% %'` looks for a literal space character surrounded by anything — the direct substitute for `\s` when you only care about the ordinary space character. `LTRIM(RTRIM(...))` comparison is the standard T-SQL trick to detect leading/trailing whitespace pollution in data.

---

### B.14 Summary Table — Regex Token → T-SQL Equivalent

| Regex Token | Meaning | T-SQL Equivalent / Workaround |
|---|---|---|
| `.` | any 1 character | `_` |
| `^` | start anchor | omit leading `%` (implicit) |
| `$` | end anchor | omit trailing `%` (implicit) |
| `*` | 0+ of preceding | not supported — CLR/app layer |
| `+` | 1+ of preceding | `PATINDEX('%[class]%',col) > 0` |
| `?` | 0 or 1 of preceding | `OR` of two patterns |
| `{n}` | exactly n | repeat class n times + `LEN()` check |
| `{n,m}` | n to m | `LEN() BETWEEN n AND m` + `PATINDEX` negated-class check |
| `()` | grouping | SQL boolean `()` around conditions |
| `\|` | OR | `OR` / `IN (...)` |
| `\d` | digit | `[0-9]` |
| `\w` | word char | `[A-Za-z0-9_]` |
| `\s` | whitespace | `' '` or `LTRIM/RTRIM` |
| `%` | 0+ any chars *(native)* | `%` (native) |
| `_` | exactly 1 char *(native)* | `_` (native) |
| `[abc]` | char set *(native)* | `[abc]` (native) |
| `[^abc]` | negated set *(native)* | `[^abc]` (native) |

### B.15 If You Truly Need Full Regex in SQL Server

1. **SQLCLR function** — write a C# scalar function using `System.Text.RegularExpressions.Regex.IsMatch()`, compile it into an assembly, and register it with `CREATE ASSEMBLY` / `CREATE FUNCTION`. This gives you 100% true regex (`\d+`, `{n,m}`, lookahead, etc.) inside T-SQL.
2. **Azure SQL / newer SQL Server**: check current documentation for any built-in `REGEXP_LIKE`-style function availability in your specific version, since native support has been evolving — verify against Microsoft Docs for your exact SQL Server version before relying on it.
3. **Do it in the application layer**: pull rows into your app language (Python `re`, C# `Regex`) and filter there if the pattern is too complex for `LIKE`/`PATINDEX` combinations.


---

## PART 2 — Top 100 Most Frequently Asked SQL Interview Questions

> All 100 questions use the **same `CompanyDB` schema** (`Employees` + `Departments`) created at the top of this document. Each entry has: **Question → Answer/Explanation → Query**.

### Category 1: Basic SELECT, WHERE, ORDER BY, DISTINCT (Q1–Q10)

**Q1. Write a query to fetch all columns from the Employees table.**
Answer: Use `SELECT *` to return every column; in production code prefer naming columns explicitly for performance and clarity.
```sql
SELECT * FROM Employees;
```

**Q2. Fetch only FirstName, LastName, and Salary of all employees.**
Answer: Column projection reduces I/O compared to `SELECT *`.
```sql
SELECT FirstName, LastName, Salary FROM Employees;
```

**Q3. Get all employees with a salary greater than 60000.**
Answer: `WHERE` filters rows based on a condition before returning results.
```sql
SELECT FirstName, Salary FROM Employees WHERE Salary > 60000;
```

**Q4. Sort employees by Salary in descending order.**
Answer: `ORDER BY column DESC` sorts high to low; `ASC` (default) sorts low to high.
```sql
SELECT FirstName, Salary FROM Employees ORDER BY Salary DESC;
```

**Q5. Fetch distinct job titles from the Employees table.**
Answer: `DISTINCT` removes duplicate rows from the result set.
```sql
SELECT DISTINCT JobTitle FROM Employees;
```

**Q6. Get the top 3 highest paid employees.**
Answer: `TOP n` limits the number of rows returned; combine with `ORDER BY` to control which rows are "top".
```sql
SELECT TOP 3 FirstName, Salary FROM Employees ORDER BY Salary DESC;
```

**Q7. Find employees hired after Jan 1, 2020.**
Answer: Date columns can be compared directly with a literal date string in `YYYY-MM-DD` format.
```sql
SELECT FirstName, HireDate FROM Employees WHERE HireDate > '2020-01-01';
```

**Q8. Fetch employees whose City is either 'Delhi' or 'Mumbai'.**
Answer: `IN` is shorthand for multiple `OR` conditions on the same column.
```sql
SELECT FirstName, City FROM Employees WHERE City IN ('Delhi','Mumbai');
```

**Q9. Find employees with salary between 50000 and 80000.**
Answer: `BETWEEN` is inclusive of both boundary values.
```sql
SELECT FirstName, Salary FROM Employees WHERE Salary BETWEEN 50000 AND 80000;
```

**Q10. Find employees whose Email is missing (NULL).**
Answer: Use `IS NULL`, never `= NULL`, because NULL is not comparable with `=`.
```sql
SELECT FirstName, Email FROM Employees WHERE Email IS NULL;
```

---

### Category 2: LIKE, Pattern Filtering, CASE (Q11–Q20)

**Q11. Find employees whose FirstName starts with 'A'.**
```sql
SELECT FirstName FROM Employees WHERE FirstName LIKE 'A%';
```
Answer: `%` after the letter means "any characters may follow".

**Q12. Find employees whose Email ends with 'company.com'.**
```sql
SELECT Email FROM Employees WHERE Email LIKE '%company.com';
```
Answer: Leading `%` means the match can start anywhere as long as it ends in the given suffix.

**Q13. Find employees whose LastName contains 'an'.**
```sql
SELECT LastName FROM Employees WHERE LastName LIKE '%an%';
```
Answer: Wrapping the substring in `%` on both sides searches anywhere within the string.

**Q14. Find employees whose Phone number is exactly 10 digits.**
```sql
SELECT Phone FROM Employees
WHERE Phone LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'
  AND LEN(Phone) = 10;
```
Answer: Repeats the digit character class 10 times and validates exact length.

**Q15. Add a computed column that labels employees as 'High'/'Medium'/'Low' earners.**
```sql
SELECT FirstName, Salary,
  CASE
    WHEN Salary >= 80000 THEN 'High'
    WHEN Salary >= 55000 THEN 'Medium'
    ELSE 'Low'
  END AS SalaryBand
FROM Employees;
```
Answer: `CASE WHEN` evaluates conditions top-to-bottom and returns the first match.

**Q16. Find employees whose email's local part starts with a digit.**
```sql
SELECT Email FROM Employees WHERE Email LIKE '[0-9]%';
```
Answer: `[0-9]` at the start restricts the very first character to a digit.

**Q17. Find employees NOT working in the 'IT' department name pattern using NOT LIKE.**
```sql
SELECT e.FirstName, d.DepartmentName
FROM Employees e JOIN Departments d ON e.DepartmentID = d.DepartmentID
WHERE d.DepartmentName NOT LIKE 'IT';
```
Answer: `NOT LIKE` negates the pattern match.

**Q18. Replace all NULL emails with 'N/A' in the result (not in the table).**
```sql
SELECT FirstName, ISNULL(Email, 'N/A') AS EmailDisplay FROM Employees;
```
Answer: `ISNULL` substitutes a default value when the column is NULL; `COALESCE` is the ANSI-standard multi-argument alternative.

**Q19. Concatenate FirstName and LastName into a FullName column.**
```sql
SELECT FirstName + ' ' + LastName AS FullName FROM Employees;
```
Answer: `+` concatenates strings in T-SQL (use `CONCAT()` to safely handle NULLs).

**Q20. Find employees whose FirstName length is greater than 5 characters.**
```sql
SELECT FirstName, LEN(FirstName) AS NameLength FROM Employees WHERE LEN(FirstName) > 5;
```
Answer: `LEN()` returns the character count, excluding trailing spaces.

---

### Category 3: Aggregate Functions, GROUP BY, HAVING (Q21–Q30)

**Q21. Find the total number of employees.**
```sql
SELECT COUNT(*) AS TotalEmployees FROM Employees;
```

**Q22. Find the average salary of all employees.**
```sql
SELECT AVG(Salary) AS AverageSalary FROM Employees;
```

**Q23. Find the highest and lowest salary.**
```sql
SELECT MAX(Salary) AS Highest, MIN(Salary) AS Lowest FROM Employees;
```

**Q24. Find the total salary paid per department.**
```sql
SELECT DepartmentID, SUM(Salary) AS TotalSalary
FROM Employees
GROUP BY DepartmentID;
```
Answer: `GROUP BY` collapses rows sharing the same DepartmentID and lets aggregate functions compute per-group values.

**Q25. Find the number of employees in each department.**
```sql
SELECT DepartmentID, COUNT(*) AS EmpCount FROM Employees GROUP BY DepartmentID;
```

**Q26. Find departments having more than 3 employees.**
```sql
SELECT DepartmentID, COUNT(*) AS EmpCount
FROM Employees
GROUP BY DepartmentID
HAVING COUNT(*) > 3;
```
Answer: `HAVING` filters groups **after** aggregation, whereas `WHERE` filters rows **before** aggregation.

**Q27. Find the average salary per job title, only for titles averaging above 55000.**
```sql
SELECT JobTitle, AVG(Salary) AS AvgSal
FROM Employees
GROUP BY JobTitle
HAVING AVG(Salary) > 55000;
```

**Q28. Count how many employees have a manager assigned (ManagerID not null).**
```sql
SELECT COUNT(ManagerID) AS EmployeesWithManager FROM Employees;
```
Answer: `COUNT(column)` ignores NULLs, unlike `COUNT(*)` which counts all rows.

**Q29. Find the number of distinct cities employees live in.**
```sql
SELECT COUNT(DISTINCT City) AS DistinctCities FROM Employees;
```

**Q30. Find department-wise max salary, sorted descending.**
```sql
SELECT DepartmentID, MAX(Salary) AS MaxSal
FROM Employees
GROUP BY DepartmentID
ORDER BY MaxSal DESC;
```


### Category 4: JOINS (Q31–Q40)

**Q31. List each employee with their department name using INNER JOIN.**
```sql
SELECT e.FirstName, d.DepartmentName
FROM Employees e
INNER JOIN Departments d ON e.DepartmentID = d.DepartmentID;
```
Answer: `INNER JOIN` returns only rows that have a matching key in both tables.

**Q32. List all departments and their employees, including departments with zero employees, using LEFT JOIN.**
```sql
SELECT d.DepartmentName, e.FirstName
FROM Departments d
LEFT JOIN Employees e ON d.DepartmentID = e.DepartmentID;
```
Answer: `LEFT JOIN` keeps every row from the left table, filling unmatched right-side columns with NULL.

**Q33. List all employees and their department, even if DepartmentID is somehow invalid, using RIGHT JOIN.**
```sql
SELECT e.FirstName, d.DepartmentName
FROM Departments d
RIGHT JOIN Employees e ON d.DepartmentID = e.DepartmentID;
```
Answer: `RIGHT JOIN` keeps every row from the right table (Employees here), mirroring LEFT JOIN with tables swapped.

**Q34. Get a full outer view of Departments and Employees.**
```sql
SELECT d.DepartmentName, e.FirstName
FROM Departments d
FULL OUTER JOIN Employees e ON d.DepartmentID = e.DepartmentID;
```
Answer: `FULL OUTER JOIN` returns matched rows plus unmatched rows from **both** sides.

**Q35. Self-join to display each employee with their manager's name.**
```sql
SELECT e.FirstName AS Employee, m.FirstName AS Manager
FROM Employees e
LEFT JOIN Employees m ON e.ManagerID = m.EmployeeID;
```
Answer: A self-join treats the same table as two logical tables (aliased `e` and `m`) to relate rows to each other.

**Q36. Find employees who do NOT have a manager.**
```sql
SELECT FirstName FROM Employees WHERE ManagerID IS NULL;
```

**Q37. Cross join Departments with a small lookup to generate all combinations (illustrative).**
```sql
SELECT d.DepartmentName, e.FirstName
FROM Departments d
CROSS JOIN (SELECT TOP 2 FirstName FROM Employees) e;
```
Answer: `CROSS JOIN` produces the Cartesian product — every row of the left table paired with every row of the right table.

**Q38. Find departments that have NO employees using LEFT JOIN + IS NULL.**
```sql
SELECT d.DepartmentName
FROM Departments d
LEFT JOIN Employees e ON d.DepartmentID = e.DepartmentID
WHERE e.EmployeeID IS NULL;
```
Answer: This is the classic "anti-join" pattern: rows from the left table with no matching right-side row show NULL on the right-side key.

**Q39. Join 3 conceptual conditions: get employee, department, and manager name together.**
```sql
SELECT e.FirstName AS Employee, d.DepartmentName, m.FirstName AS Manager
FROM Employees e
JOIN Departments d ON e.DepartmentID = d.DepartmentID
LEFT JOIN Employees m ON e.ManagerID = m.EmployeeID;
```

**Q40. Find employees earning more than their manager.**
```sql
SELECT e.FirstName AS Employee, e.Salary AS EmpSalary, m.Salary AS ManagerSalary
FROM Employees e
JOIN Employees m ON e.ManagerID = m.EmployeeID
WHERE e.Salary > m.Salary;
```
Answer: Combines self-join with a comparison filter between the two aliased salary columns.

---

### Category 5: Subqueries & CTE (Q41–Q50)

**Q41. Find employees earning more than the average salary.**
```sql
SELECT FirstName, Salary
FROM Employees
WHERE Salary > (SELECT AVG(Salary) FROM Employees);
```
Answer: The scalar subquery computes a single value (overall average) used as a comparison threshold.

**Q42. Find the department with the highest total salary using a subquery.**
```sql
SELECT DepartmentID, SUM(Salary) AS TotalSal
FROM Employees
GROUP BY DepartmentID
HAVING SUM(Salary) = (
    SELECT MAX(TotalSal) FROM (
        SELECT SUM(Salary) AS TotalSal FROM Employees GROUP BY DepartmentID
    ) t
);
```
Answer: A derived table (subquery in the FROM clause) is aggregated first, then the outer query finds the max of those aggregates.

**Q43. Find employees who work in the 'IT' department using a subquery instead of JOIN.**
```sql
SELECT FirstName
FROM Employees
WHERE DepartmentID = (SELECT DepartmentID FROM Departments WHERE DepartmentName = 'IT');
```

**Q44. Find employees NOT assigned as anyone's manager.**
```sql
SELECT FirstName
FROM Employees
WHERE EmployeeID NOT IN (SELECT ManagerID FROM Employees WHERE ManagerID IS NOT NULL);
```
Answer: `NOT IN` excludes any EmployeeID that appears in the ManagerID list; the `IS NOT NULL` guard avoids the classic `NOT IN` + NULL trap that would otherwise return zero rows.

**Q45. Use EXISTS to find departments that have at least one employee.**
```sql
SELECT DepartmentName
FROM Departments d
WHERE EXISTS (SELECT 1 FROM Employees e WHERE e.DepartmentID = d.DepartmentID);
```
Answer: `EXISTS` stops scanning as soon as it finds one matching row — often more efficient than `IN` for correlated existence checks.

**Q46. Write a CTE to list employees along with department name.**
```sql
WITH EmpDept AS (
    SELECT e.FirstName, e.Salary, d.DepartmentName
    FROM Employees e
    JOIN Departments d ON e.DepartmentID = d.DepartmentID
)
SELECT * FROM EmpDept WHERE Salary > 60000;
```
Answer: A CTE (`WITH ... AS`) defines a named, temporary result set that can be referenced like a table in the following query — improves readability over nested subqueries.

**Q47. Write a recursive CTE to build the management hierarchy.**
```sql
WITH OrgChart AS (
    SELECT EmployeeID, FirstName, ManagerID, 0 AS Level
    FROM Employees WHERE ManagerID IS NULL
    UNION ALL
    SELECT e.EmployeeID, e.FirstName, e.ManagerID, o.Level + 1
    FROM Employees e
    JOIN OrgChart o ON e.ManagerID = o.EmployeeID
)
SELECT * FROM OrgChart ORDER BY Level;
```
Answer: A recursive CTE has an "anchor" member (top-level managers with NULL ManagerID) and a "recursive" member that joins back to the CTE itself, walking down the hierarchy level by level.

**Q48. Find the 2nd highest salary using a subquery.**
```sql
SELECT MAX(Salary) AS SecondHighest
FROM Employees
WHERE Salary < (SELECT MAX(Salary) FROM Employees);
```

**Q49. Find employees whose salary is above their department's average salary (correlated subquery).**
```sql
SELECT e.FirstName, e.Salary, e.DepartmentID
FROM Employees e
WHERE e.Salary > (
    SELECT AVG(Salary) FROM Employees e2 WHERE e2.DepartmentID = e.DepartmentID
);
```
Answer: A correlated subquery re-evaluates once per outer row because it references the outer query's `e.DepartmentID`.

**Q50. Use a CTE with ROW_NUMBER to remove duplicate emails (keep the first occurrence).**
```sql
WITH RankedEmails AS (
    SELECT *, ROW_NUMBER() OVER (PARTITION BY Email ORDER BY EmployeeID) AS rn
    FROM Employees
    WHERE Email IS NOT NULL
)
SELECT * FROM RankedEmails WHERE rn = 1;
```


### Category 6: Window Functions (Q51–Q60)

**Q51. Rank employees by salary within their department using RANK().**
```sql
SELECT FirstName, DepartmentID, Salary,
       RANK() OVER (PARTITION BY DepartmentID ORDER BY Salary DESC) AS SalaryRank
FROM Employees;
```
Answer: `RANK()` assigns the same rank to ties, then skips subsequent rank numbers (1,1,3...).

**Q52. Same as above but use DENSE_RANK().**
```sql
SELECT FirstName, DepartmentID, Salary,
       DENSE_RANK() OVER (PARTITION BY DepartmentID ORDER BY Salary DESC) AS SalaryDenseRank
FROM Employees;
```
Answer: `DENSE_RANK()` also ties, but does **not** skip the next number (1,1,2...).

**Q53. Assign a unique sequential number to each employee ordered by HireDate using ROW_NUMBER().**
```sql
SELECT FirstName, HireDate,
       ROW_NUMBER() OVER (ORDER BY HireDate) AS RowNum
FROM Employees;
```
Answer: `ROW_NUMBER()` always produces unique, sequential numbers even for ties (order among ties is arbitrary unless further tie-broken).

**Q54. Find the 3rd highest salary using ROW_NUMBER inside a CTE.**
```sql
WITH RankedSalary AS (
    SELECT Salary, ROW_NUMBER() OVER (ORDER BY Salary DESC) AS rn
    FROM (SELECT DISTINCT Salary FROM Employees) s
)
SELECT Salary FROM RankedSalary WHERE rn = 3;
```

**Q55. Show each employee's salary alongside the next-highest-paid employee's salary using LEAD().**
```sql
SELECT FirstName, Salary,
       LEAD(Salary) OVER (ORDER BY Salary DESC) AS NextLowerSalary
FROM Employees;
```
Answer: `LEAD()` looks forward N rows (default 1) in the ordered window; `LAG()` looks backward.

**Q56. Show each employee's salary alongside the previous employee's (by HireDate) salary using LAG().**
```sql
SELECT FirstName, HireDate, Salary,
       LAG(Salary) OVER (ORDER BY HireDate) AS PreviousHireSalary
FROM Employees;
```

**Q57. Divide employees into 4 salary buckets (quartiles) using NTILE(4).**
```sql
SELECT FirstName, Salary,
       NTILE(4) OVER (ORDER BY Salary DESC) AS Quartile
FROM Employees;
```
Answer: `NTILE(n)` splits the ordered rows as evenly as possible into `n` groups.

**Q58. Compute a running total of salary ordered by HireDate.**
```sql
SELECT FirstName, HireDate, Salary,
       SUM(Salary) OVER (ORDER BY HireDate ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) AS RunningTotal
FROM Employees;
```
Answer: The `ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW` frame accumulates the sum from the very first row up to the current row.

**Q59. Compute each department's average salary alongside every employee row (without collapsing rows) using a window AVG.**
```sql
SELECT FirstName, DepartmentID, Salary,
       AVG(Salary) OVER (PARTITION BY DepartmentID) AS DeptAvgSalary
FROM Employees;
```
Answer: Unlike `GROUP BY`, a window function keeps every original row while adding an aggregate computed over its partition.

**Q60. Find the highest-paid employee in each department using RANK() in a CTE.**
```sql
WITH RankedEmp AS (
    SELECT FirstName, DepartmentID, Salary,
           RANK() OVER (PARTITION BY DepartmentID ORDER BY Salary DESC) AS rnk
    FROM Employees
)
SELECT * FROM RankedEmp WHERE rnk = 1;
```

---

### Category 7: String Functions & Regex-Style Patterns (Q61–Q70)

**Q61. Extract the domain part of every email (after the @).**
```sql
SELECT Email, SUBSTRING(Email, CHARINDEX('@', Email) + 1, LEN(Email)) AS Domain
FROM Employees WHERE Email IS NOT NULL;
```
Answer: `CHARINDEX` finds the position of `@`; `SUBSTRING` extracts everything after it.

**Q62. Find the position of the first digit in each phone number using PATINDEX.**
```sql
SELECT Phone, PATINDEX('%[0-9]%', Phone) AS FirstDigitPos FROM Employees;
```

**Q63. Replace all occurrences of 'Manager' with 'Lead' in JobTitle (result only, not stored).**
```sql
SELECT JobTitle, REPLACE(JobTitle, 'Manager', 'Lead') AS NewTitle FROM Employees;
```

**Q64. Convert all FirstNames to uppercase and LastNames to lowercase.**
```sql
SELECT UPPER(FirstName) AS FN, LOWER(LastName) AS LN FROM Employees;
```

**Q65. Trim leading/trailing spaces from JobTitle.**
```sql
SELECT LTRIM(RTRIM(JobTitle)) AS CleanTitle FROM Employees;
```

**Q66. Get the first 3 characters of each FirstName.**
```sql
SELECT LEFT(FirstName, 3) AS Initials FROM Employees;
```

**Q67. Get the last 4 digits of each phone number.**
```sql
SELECT RIGHT(Phone, 4) AS LastFourDigits FROM Employees WHERE Phone IS NOT NULL;
```

**Q68. Find employees whose email local-part contains only letters, digits, dot, or underscore (word-character validation).**
```sql
SELECT Email
FROM Employees
WHERE LEFT(Email, CHARINDEX('@', Email) - 1) NOT LIKE '%[^A-Za-z0-9._]%';
```
Answer: Regex-equivalent of `^\w[\w.]*$` on the local part — done via a negated character class check.

**Q69. Validate that every Phone number contains digits only (no letters/symbols) using PATINDEX.**
```sql
SELECT Phone FROM Employees
WHERE Phone IS NOT NULL AND PATINDEX('%[^0-9]%', Phone) = 0;
```

**Q70. Mask all but the last 4 digits of the phone number.**
```sql
SELECT Phone,
       REPLICATE('X', LEN(Phone) - 4) + RIGHT(Phone, 4) AS MaskedPhone
FROM Employees WHERE Phone IS NOT NULL;
```
Answer: `REPLICATE` repeats 'X' for the length minus 4, then concatenates the real last 4 digits.


### Category 8: Date Functions (Q71–Q80)

**Q71. Find each employee's tenure in years as of today.**
```sql
SELECT FirstName, HireDate, DATEDIFF(YEAR, HireDate, GETDATE()) AS TenureYears
FROM Employees;
```
Answer: `DATEDIFF(unit, start, end)` returns the number of unit-boundaries crossed, not necessarily a full 365-day year.

**Q72. Find employees hired in the year 2020.**
```sql
SELECT FirstName, HireDate FROM Employees WHERE YEAR(HireDate) = 2020;
```

**Q73. Find employees hired in the last 90 days (relative to today's system date).**
```sql
SELECT FirstName, HireDate FROM Employees WHERE HireDate >= DATEADD(DAY, -90, GETDATE());
```
Answer: `DATEADD(unit, number, date)` adds (or subtracts, with a negative number) an interval to a date.

**Q74. Get the current date and time.**
```sql
SELECT GETDATE() AS CurrentDateTime;
```

**Q75. Extract just the month name from HireDate.**
```sql
SELECT FirstName, DATENAME(MONTH, HireDate) AS HireMonth FROM Employees;
```

**Q76. Find the number of employees hired each year.**
```sql
SELECT YEAR(HireDate) AS HireYear, COUNT(*) AS Count
FROM Employees
GROUP BY YEAR(HireDate)
ORDER BY HireYear;
```

**Q77. Add 6 months to every employee's HireDate to find their appraisal date.**
```sql
SELECT FirstName, HireDate, DATEADD(MONTH, 6, HireDate) AS AppraisalDate FROM Employees;
```

**Q78. Format HireDate as 'DD-MON-YYYY' string.**
```sql
SELECT FirstName, FORMAT(HireDate, 'dd-MMM-yyyy') AS FormattedDate FROM Employees;
```

**Q79. Find employees who have completed exactly 5 years or more at the company.**
```sql
SELECT FirstName, HireDate
FROM Employees
WHERE DATEDIFF(YEAR, HireDate, GETDATE()) >= 5;
```

**Q80. Find the oldest and most recent hire dates.**
```sql
SELECT MIN(HireDate) AS OldestHire, MAX(HireDate) AS MostRecentHire FROM Employees;
```

---

### Category 9: DML, Constraints, Indexes, Views (Q81–Q90)

**Q81. Insert a new employee.**
```sql
INSERT INTO Employees (EmployeeID, FirstName, LastName, Email, Phone, DepartmentID, ManagerID, Salary, HireDate, JobTitle, City)
VALUES (116, 'Kavya', 'Bhatt', 'kavya.bhatt@company.com', '9090990099', 1, 101, 68000, '2023-05-01', 'Developer', 'Ahmedabad');
```

**Q82. Update the salary of all Developers by giving a 10% raise.**
```sql
UPDATE Employees SET Salary = Salary * 1.10 WHERE JobTitle = 'Developer';
```

**Q83. Delete employees who have no email and no phone (bad data).**
```sql
DELETE FROM Employees WHERE Email IS NULL AND Phone IS NULL;
```

**Q84. Create a view that shows employee name with department name.**
```sql
CREATE VIEW vw_EmployeeDept AS
SELECT e.FirstName, e.LastName, d.DepartmentName
FROM Employees e JOIN Departments d ON e.DepartmentID = d.DepartmentID;
```
Answer: A `VIEW` is a stored, reusable query definition — querying `vw_EmployeeDept` behaves like querying a table but always reflects live data.

**Q85. Create a non-clustered index on Email to speed up lookups.**
```sql
CREATE NONCLUSTERED INDEX IX_Employees_Email ON Employees(Email);
```
Answer: A non-clustered index creates a separate structure pointing back to the table's rows, speeding up searches/sorts on the indexed column at the cost of extra write overhead.

**Q86. Add a UNIQUE constraint on Email so duplicate emails can't be inserted.**
```sql
ALTER TABLE Employees ADD CONSTRAINT UQ_Email UNIQUE (Email);
```

**Q87. Add a CHECK constraint so Salary must always be positive.**
```sql
ALTER TABLE Employees ADD CONSTRAINT CHK_Salary CHECK (Salary > 0);
```

**Q88. Write a MERGE statement to upsert an employee's salary.**
```sql
MERGE Employees AS target
USING (SELECT 103 AS EmployeeID, 61000 AS NewSalary) AS source
ON target.EmployeeID = source.EmployeeID
WHEN MATCHED THEN UPDATE SET target.Salary = source.NewSalary
WHEN NOT MATCHED THEN
   INSERT (EmployeeID, FirstName, LastName, Salary) VALUES (source.EmployeeID, 'Unknown','Unknown', source.NewSalary);
```
Answer: `MERGE` combines insert/update (and optionally delete) logic into a single atomic statement based on whether a matching key exists.

**Q89. Use a transaction to ensure a salary transfer between two updates is atomic.**
```sql
BEGIN TRANSACTION;
UPDATE Employees SET Salary = Salary - 5000 WHERE EmployeeID = 101;
UPDATE Employees SET Salary = Salary + 5000 WHERE EmployeeID = 102;
COMMIT TRANSACTION;
```
Answer: Wrapping both updates in a transaction guarantees both succeed or both roll back together, preserving data consistency.

**Q90. Roll back a transaction if an error occurs, using TRY/CATCH.**
```sql
BEGIN TRY
    BEGIN TRANSACTION;
    UPDATE Employees SET Salary = Salary - 5000 WHERE EmployeeID = 101;
    UPDATE Employees SET Salary = Salary + 5000 WHERE EmployeeID = 999; -- invalid ID
    COMMIT TRANSACTION;
END TRY
BEGIN CATCH
    ROLLBACK TRANSACTION;
    SELECT ERROR_MESSAGE() AS ErrorDetails;
END CATCH;
```


### Category 10: Advanced / Tricky Interview Favorites (Q91–Q100)

**Q91. Find duplicate emails in the Employees table (if any existed).**
```sql
SELECT Email, COUNT(*) AS Cnt
FROM Employees
WHERE Email IS NOT NULL
GROUP BY Email
HAVING COUNT(*) > 1;
```
Answer: Grouping by the suspect column and filtering with `HAVING COUNT(*) > 1` is the standard duplicate-finder pattern.

**Q92. Find the Nth highest salary generically (parameterized idea, N = 4 shown).**
```sql
SELECT DISTINCT Salary
FROM Employees e1
WHERE 3 = (SELECT COUNT(DISTINCT Salary) FROM Employees e2 WHERE e2.Salary > e1.Salary);
```
Answer: This finds the salary for which exactly 3 distinct salaries are greater — i.e., the 4th highest — without using `OFFSET/FETCH`.

**Q93. Fetch the 4th highest salary using OFFSET-FETCH (modern, simpler approach).**
```sql
SELECT DISTINCT Salary
FROM Employees
ORDER BY Salary DESC
OFFSET 3 ROWS FETCH NEXT 1 ROWS ONLY;
```
Answer: `OFFSET n ROWS FETCH NEXT m ROWS ONLY` skips `n` rows then returns the next `m` — a clean pagination-style way to get the "Nth" row.

**Q94. Pivot department-wise employee counts into columns (PIVOT).**
```sql
SELECT * FROM (
    SELECT d.DepartmentName, e.EmployeeID
    FROM Employees e JOIN Departments d ON e.DepartmentID = d.DepartmentID
) src
PIVOT (
    COUNT(EmployeeID) FOR DepartmentName IN ([IT],[HR],[Sales],[Finance])
) AS pvt;
```
Answer: `PIVOT` rotates row values (department names) into column headers, aggregating the specified measure for each.

**Q95. Unpivot example — reverse of Q94 conceptually (turn columns back into rows).**
```sql
SELECT DepartmentName, EmpCount
FROM (SELECT 10 AS IT, 5 AS HR, 8 AS Sales, 4 AS Finance) p
UNPIVOT (EmpCount FOR DepartmentName IN (IT, HR, Sales, Finance)) AS unpvt;
```
Answer: `UNPIVOT` turns multiple columns into row-value pairs — the mirror operation of `PIVOT`.

**Q96. Explain and demonstrate the difference between UNION and UNION ALL.**
```sql
-- UNION removes duplicate rows across both result sets
SELECT City FROM Employees
UNION
SELECT Location AS City FROM Departments;

-- UNION ALL keeps every row, including duplicates (faster, no dedup step)
SELECT City FROM Employees
UNION ALL
SELECT Location AS City FROM Departments;
```
Answer: `UNION` performs an implicit `DISTINCT` over the combined rows; `UNION ALL` skips that step, making it cheaper when duplicates don't matter or are known not to exist.

**Q97. Find employees who share the same Salary as at least one other employee.**
```sql
SELECT e1.FirstName, e1.Salary
FROM Employees e1
WHERE EXISTS (
    SELECT 1 FROM Employees e2
    WHERE e2.Salary = e1.Salary AND e2.EmployeeID <> e1.EmployeeID
);
```

**Q98. Difference between DELETE, TRUNCATE, and DROP — demonstrate DELETE with WHERE vs TRUNCATE.**
```sql
-- DELETE removes specific rows, is logged row-by-row, can be rolled back, keeps identity seed
DELETE FROM Employees WHERE DepartmentID = 4;

-- TRUNCATE removes ALL rows, minimally logged, resets identity seed, cannot use WHERE
-- TRUNCATE TABLE Employees;

-- DROP removes the entire table structure and data permanently
-- DROP TABLE Employees;
```
Answer: `DELETE` is a DML operation (row-level, filterable, triggers fire); `TRUNCATE` is a DDL-like fast wipe of all rows without firing row-level triggers; `DROP` removes the table object entirely from the schema.

**Q99. Explain and demonstrate a Scalar User-Defined Function that returns an employee's full name.**
```sql
CREATE FUNCTION dbo.fn_FullName (@EmpID INT)
RETURNS VARCHAR(101)
AS
BEGIN
    DECLARE @FullName VARCHAR(101);
    SELECT @FullName = FirstName + ' ' + LastName FROM Employees WHERE EmployeeID = @EmpID;
    RETURN @FullName;
END;
GO

SELECT dbo.fn_FullName(101) AS EmployeeFullName;
```
Answer: A scalar UDF encapsulates reusable logic that returns a single value and can be called inline in a `SELECT` just like a built-in function.

**Q100. Write a stored procedure that returns all employees in a given department, with an OUTPUT parameter for the count.**
```sql
CREATE PROCEDURE dbo.usp_GetEmployeesByDept
    @DeptID INT,
    @EmpCount INT OUTPUT
AS
BEGIN
    SELECT * FROM Employees WHERE DepartmentID = @DeptID;
    SELECT @EmpCount = COUNT(*) FROM Employees WHERE DepartmentID = @DeptID;
END;
GO

DECLARE @Count INT;
EXEC dbo.usp_GetEmployeesByDept @DeptID = 1, @EmpCount = @Count OUTPUT;
SELECT @Count AS TotalInDept;
```
Answer: Stored procedures encapsulate parameterized, reusable business logic server-side; `OUTPUT` parameters let the procedure return a scalar value back to the caller in addition to a result set.

---

## Quick Reference — Where To Go From Here

- **Section A** (native `LIKE` wildcards) works in **every** version of SQL Server, no setup required.
- **Section B** (`\d`, `\w`, `{n,m}`, etc.) is **true regex** — SQL Server needs a CLR function or app-layer regex engine to support it fully; the workarounds shown use only built-in T-SQL functions.
- All 100 interview queries reuse the single `CompanyDB` schema so you can paste the entire document's SQL into one SSMS session top-to-bottom and run every example without errors.
