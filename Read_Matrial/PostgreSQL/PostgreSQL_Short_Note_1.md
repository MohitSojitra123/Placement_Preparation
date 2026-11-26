# PostgreSQL Placement / Interview Preparation Guide

> All 200 questions + 20 practical query challenges, explained in **simple words with examples**.
> Tip: Read the answer, then **type the example yourself** in `psql` or pgAdmin. Typing is what makes it stick.

## Table of Contents
- [Practice Database Setup (run this first)](#practice-database-setup)
- [Level 1: Basic (Q1–60)](#level-1-basic-postgresql-questions-160)
- [Level 2: Intermediate (Q61–140)](#level-2-intermediate-postgresql-questions-61140)
- [Level 3: Hard (Q141–200)](#level-3-hard-postgresql-questions-141200)
- [Practical SQL Round (20 challenges)](#practical-sql-interview-round)
- [Topic Checklist and Interview Advice](#complete-topic-coverage-checklist)

---

## Practice Database Setup

Run this once. Most examples below use these tables.

```sql
CREATE TABLE departments (
    department_id   INT PRIMARY KEY,
    department_name VARCHAR(100)
);

CREATE TABLE employees (
    employee_id   INT PRIMARY KEY,
    employee_name VARCHAR(100),
    email         VARCHAR(150),
    salary        NUMERIC(10,2),
    department_id INT REFERENCES departments(department_id),
    manager_id    INT,
    joining_date  DATE
);

CREATE TABLE projects (
    project_id   INT PRIMARY KEY,
    project_name VARCHAR(100),
    budget       NUMERIC(12,2)
);

CREATE TABLE employee_projects (
    employee_id   INT REFERENCES employees(employee_id),
    project_id    INT REFERENCES projects(project_id),
    assigned_date DATE
);

INSERT INTO departments VALUES (1,'IT'),(2,'HR'),(3,'Sales'),(4,'Finance');

INSERT INTO employees VALUES
(1,'Asha',   'asha@x.com',   90000, 1, NULL, '2020-01-10'),
(2,'Bob',    'bob@x.com',    70000, 1, 1,    '2021-03-15'),
(3,'Alice',  'alice@x.com',  70000, 1, 1,    '2019-07-01'),
(4,'Carl',   'carl@x.com',   50000, 2, 1,    '2022-05-20'),
(5,'Diana',  'diana@x.com',  60000, 2, 4,    '2023-02-11'),
(6,'Eve',    'eve@x.com',    45000, 3, 1,    '2026-01-05'),
(7,'Frank',  'frank@x.com',  45000, 3, 6,    '2018-09-09'),
(8,'Gina',   'bob@x.com',    30000, NULL, 6, '2024-04-04');   -- duplicate email, no department

INSERT INTO projects VALUES (1,'Website',100000),(2,'App',200000),(3,'Audit',50000);

INSERT INTO employee_projects VALUES
(1,1,'2024-01-01'),(2,1,'2024-01-02'),(2,2,'2024-02-01'),(3,2,'2024-02-05');
```

---

# Level 1: Basic PostgreSQL Questions (1–60)

## Section 1: Introduction to PostgreSQL

### 1. What is PostgreSQL?
PostgreSQL (also called **Postgres**) is a free, open-source **relational database**. It stores data in tables (rows and columns) and you talk to it using **SQL**.
Think of it as a very smart, very safe Excel that many users can use at the same time.

### 2. What are the main features of PostgreSQL?
- Open source and free
- **ACID** compliant (safe and reliable transactions)
- **MVCC** (many users read and write without blocking each other)
- Rich data types: JSON/JSONB, arrays, UUID, geometric, range types
- Powerful indexes (B-tree, Hash, GIN, GiST, BRIN)
- Window functions, CTEs, recursive queries
- Views, materialized views, triggers, stored procedures
- Table partitioning, replication, full-text search
- Extensible (you can add extensions like PostGIS)

### 3. Why is PostgreSQL called an Object-Relational Database Management System (ORDBMS)?
Because it is **relational** (tables) **plus** it has some **object features**:
- Custom data types (`CREATE TYPE`)
- Table inheritance (a child table inherits columns from a parent)
- Arrays and composite types
- User-defined functions and operators

```sql
CREATE TYPE address AS (city TEXT, pincode TEXT);
CREATE TABLE customer (id INT, home address);
```

### 4. What is the difference between PostgreSQL and MySQL?
| Point | PostgreSQL | MySQL |
|---|---|---|
| Type | Object-relational | Relational |
| Standards | Follows SQL standard very closely | Slightly less strict |
| Data types | Very rich (JSONB, arrays, ranges) | Fewer |
| Features | Window functions, CTE, full-text, advanced indexes | Added later, fewer index types |
| Concurrency | MVCC everywhere | MVCC (InnoDB engine) |
| Best for | Complex queries, analytics, data integrity | Simple, read-heavy web apps |

### 5. What is the difference between PostgreSQL and SQL?
- **SQL** = the *language* used to talk to databases (`SELECT`, `INSERT`...).
- **PostgreSQL** = the *software* (database system) that understands SQL.

Example: English is a language (SQL); a person who speaks English is PostgreSQL.

### 6. What are the advantages and disadvantages of PostgreSQL?
**Advantages:** free, reliable, powerful features, supports JSON, highly extensible, strong community.
**Disadvantages:** can need tuning for best speed, a bit more memory use per connection (one process per connection), fewer "easy GUI tools" than some competitors, and replication/setup is more manual than some cloud-first databases.

### 7. Is PostgreSQL open-source or commercial?
**Open source.** It uses the PostgreSQL License (similar to MIT/BSD). You can use it free, even in commercial products. Companies (AWS, Azure, EnterpriseDB) sell *paid hosting and support*, but the database itself is free.

### 8. What is the default port number of PostgreSQL?
**5432**

```bash
psql -h localhost -p 5432 -U postgres
```

### 9. What is the difference between PostgreSQL and SQL Server?
| Point | PostgreSQL | SQL Server |
|---|---|---|
| Owner | Community (open source) | Microsoft (commercial) |
| Cost | Free | Paid licence |
| OS | Linux, Windows, macOS | Windows (and Linux now) |
| Procedural language | PL/pgSQL (and others) | T-SQL |
| Limit/paging | `LIMIT ... OFFSET` | `TOP` / `OFFSET FETCH` |

### 10. Explain the PostgreSQL architecture at a high level.
PostgreSQL uses a **client–server** model:
1. **Client** (your app, psql) sends a request.
2. **Postmaster** (main process) listens on port 5432 and starts a new **backend process** for each client connection.
3. The backend parses, plans, and runs the query.
4. Data is read through **shared buffers** (memory cache).
5. Every change is first written to the **WAL** (Write-Ahead Log) for safety, then to data files on disk.
6. **Background processes** help: checkpointer, background writer, WAL writer, autovacuum launcher.

---

## Section 2: Database Fundamentals

### 11. What is a database?
An organized collection of data stored so it can be easily read, added, changed, and deleted. Example: a `company_db` database holds employee, department, and project data.

```sql
CREATE DATABASE company_db;
```

### 12. What is a schema in PostgreSQL?
A schema is a **folder inside a database** that holds tables, views, functions, etc. The default schema is `public`.

```sql
CREATE SCHEMA hr;
CREATE TABLE hr.staff (id INT, name TEXT);
SELECT * FROM hr.staff;
```

### 13. What is the difference between a database and a schema?
- **Database** = the whole building.
- **Schema** = a floor/room inside that building.

One database has many schemas; one schema has many tables. You connect to **one database** at a time, but can query across schemas inside it.

### 14. What is a table?
A table stores data in **rows and columns** about one thing (employees, orders...).

```sql
CREATE TABLE students (id INT, name TEXT, age INT);
```

### 15. What are rows and columns?
- **Column** (field) = one attribute, e.g. `name`. It has a data type.
- **Row** (record/tuple) = one full entry, e.g. `(1, 'Asha', 21)`.

### 16. What is a primary key?
A column (or set of columns) that **uniquely identifies each row**. It can't be `NULL` and can't repeat. A table can have only **one** primary key.

```sql
CREATE TABLE users (id INT PRIMARY KEY, name TEXT);
```

### 17. What is a foreign key?
A column that **points to the primary key of another table**. It keeps data consistent (you can't add an employee in a department that doesn't exist).

```sql
CREATE TABLE employees (
  id INT PRIMARY KEY,
  department_id INT REFERENCES departments(department_id)
);
```

### 18. What is a unique constraint?
It makes sure **no two rows have the same value** in that column.

```sql
CREATE TABLE users (email VARCHAR(100) UNIQUE);
```

### 19. What is a NOT NULL constraint?
It forces a column to always have a value (empty not allowed).

```sql
CREATE TABLE users (name TEXT NOT NULL);
INSERT INTO users VALUES (NULL);   -- ERROR
```

### 20. What is the difference between PRIMARY KEY and UNIQUE?
| PRIMARY KEY | UNIQUE |
|---|---|
| Only **one** per table | **Many** per table |
| Cannot be NULL | Can contain NULL (and many NULLs are allowed) |
| Identifies the row | Just prevents duplicates |

---

## Section 3: PostgreSQL Data Types

### 21. What are the different data types available in PostgreSQL?
- **Numbers:** `SMALLINT`, `INTEGER`, `BIGINT`, `NUMERIC`, `REAL`, `DOUBLE PRECISION`, `SERIAL`
- **Text:** `CHAR(n)`, `VARCHAR(n)`, `TEXT`
- **Date/Time:** `DATE`, `TIME`, `TIMESTAMP`, `TIMESTAMPTZ`, `INTERVAL`
- **Boolean:** `BOOLEAN`
- **JSON:** `JSON`, `JSONB`
- **Others:** `UUID`, arrays (`INT[]`), `BYTEA`, `INET`, range types, enums

### 22. What is the difference between CHAR, VARCHAR, and TEXT?
| Type | Meaning | Example |
|---|---|---|
| `CHAR(5)` | Fixed length, padded with spaces | 'ab' becomes `'ab   '` |
| `VARCHAR(5)` | Variable length, max 5 characters | 'ab' stays `'ab'` |
| `TEXT` | Variable length, no limit | any length |

In PostgreSQL, `VARCHAR` and `TEXT` perform the same. Use `TEXT` unless you need a length rule.

### 23. What is the difference between INTEGER, BIGINT, and SMALLINT?
| Type | Size | Range (approx.) |
|---|---|---|
| `SMALLINT` | 2 bytes | -32,768 to 32,767 |
| `INTEGER` | 4 bytes | about ±2.1 billion |
| `BIGINT` | 8 bytes | about ±9.2 × 10¹⁸ |

Pick the smallest that safely fits. Use `BIGINT` for IDs that may grow very large.

### 24. What is the difference between NUMERIC and REAL?
- `NUMERIC(10,2)` = **exact** decimal (use for **money**). 10 digits total, 2 after the point.
- `REAL` = **approximate** floating-point (4 bytes). Can give tiny errors.

```sql
SELECT 0.1::REAL + 0.2::REAL;      -- may show 0.3 with tiny error internally
SELECT 0.1::NUMERIC + 0.2::NUMERIC; -- exactly 0.3
```

### 25. What is the difference between DATE, TIME, and TIMESTAMP?
- `DATE` → only date: `2026-11-25`
- `TIME` → only time: `17:43:00`
- `TIMESTAMP` → date + time: `2026-11-25 17:43:00`
- `TIMESTAMPTZ` → timestamp **with time zone** (best for apps).

### 26. What is the BOOLEAN data type?
Stores `TRUE`, `FALSE`, or `NULL`.

```sql
CREATE TABLE tasks (id INT, done BOOLEAN DEFAULT FALSE);
SELECT * FROM tasks WHERE done;
```

### 27. What is the JSON data type?
Stores JSON text (like `{"name":"Asha","age":21}`) in a column. It keeps the text **exactly as typed** (spaces, order, duplicate keys).

```sql
CREATE TABLE logs (data JSON);
INSERT INTO logs VALUES ('{"user":"Asha","age":21}');
SELECT data->>'user' FROM logs;   -- Asha
```

### 28. What is the difference between JSON and JSONB?
| JSON | JSONB |
|---|---|
| Stored as plain text | Stored in **binary** form |
| Slower to query | **Faster** to query |
| **Cannot** be indexed well | Supports **GIN indexes** |
| Keeps spaces and key order | Removes extra spaces, no key order, removes duplicate keys |

Rule: **almost always use JSONB**.

### 29. What is the UUID data type?
A 128-bit unique ID like `550e8400-e29b-41d4-a716-446655440000`. Good for IDs that must be unique across systems.

```sql
CREATE TABLE orders (id UUID DEFAULT gen_random_uuid() PRIMARY KEY);
```

### 30. What is the purpose of the ARRAY data type?
Stores a **list of values in one column**.

```sql
CREATE TABLE students (name TEXT, marks INT[]);
INSERT INTO students VALUES ('Asha', ARRAY[80,90,70]);
SELECT marks[1] FROM students;   -- 80 (arrays start at 1)
```

---

## Section 4: Basic SQL Commands

### 31. What is SQL, and what are its different command categories?
SQL (Structured Query Language) is the language used to create, read, update, and delete data. Categories: **DDL, DML, DQL, DCL, TCL** (see next question).

### 32. What is the difference between DDL, DML, DQL, DCL, and TCL?
| Category | Full form | Purpose | Commands |
|---|---|---|---|
| DDL | Data Definition | Change structure | `CREATE`, `ALTER`, `DROP`, `TRUNCATE` |
| DML | Data Manipulation | Change data | `INSERT`, `UPDATE`, `DELETE` |
| DQL | Data Query | Read data | `SELECT` |
| DCL | Data Control | Permissions | `GRANT`, `REVOKE` |
| TCL | Transaction Control | Manage transactions | `BEGIN`, `COMMIT`, `ROLLBACK`, `SAVEPOINT` |

### 33. What is the difference between CREATE, ALTER, and DROP?
- `CREATE` → make a new object.
- `ALTER` → change an existing object.
- `DROP` → delete the object completely.

```sql
CREATE TABLE t (id INT);
ALTER TABLE t ADD COLUMN name TEXT;
DROP TABLE t;
```

### 34. What is the difference between DELETE, TRUNCATE, and DROP?
| | DELETE | TRUNCATE | DROP |
|---|---|---|---|
| What it removes | Chosen rows | All rows | Whole table |
| `WHERE` allowed | Yes | No | No |
| Table structure stays | Yes | Yes | **No** |
| Speed | Slower | Very fast | Fast |
| Type | DML | DDL | DDL |
| Rollback in PostgreSQL | Yes | **Yes** (inside a transaction) | Yes (inside a transaction) |

```sql
DELETE FROM employees WHERE employee_id = 8;
TRUNCATE TABLE employee_projects;
DROP TABLE employee_projects;
```

### 35. How do you create a database in PostgreSQL?
```sql
CREATE DATABASE company_db;
-- or from the command line:
-- createdb company_db
\c company_db      -- connect to it in psql
```

### 36. How do you create a table in PostgreSQL?
```sql
CREATE TABLE students (
    id    SERIAL PRIMARY KEY,
    name  VARCHAR(100) NOT NULL,
    age   INT CHECK (age > 0),
    email VARCHAR(150) UNIQUE
);
```

### 37. How do you insert records into a table?
```sql
INSERT INTO students (name, age, email) VALUES ('Asha', 21, 'asha@x.com');

-- many rows at once
INSERT INTO students (name, age, email) VALUES
 ('Bob', 22, 'bob@x.com'),
 ('Carl', 23, 'carl@x.com');
```

### 38. How do you retrieve all records from a table?
```sql
SELECT * FROM students;
```
In real projects, list the columns you need (`SELECT name, age ...`) instead of `*`.

### 39. How do you update existing records?
```sql
UPDATE students SET age = 22 WHERE name = 'Asha';
```
⚠️ Without `WHERE`, **all rows** are updated.

### 40. How do you delete a specific record?
```sql
DELETE FROM students WHERE id = 3;
```
⚠️ Without `WHERE`, all rows are deleted.

---

## Section 5: Basic Query Writing

### 41. What is the purpose of the WHERE clause?
It **filters rows** before they are returned.
```sql
SELECT * FROM employees WHERE salary > 50000;
```

### 42. What is the difference between WHERE and HAVING?
- `WHERE` filters **rows** *before* grouping. Cannot use aggregates like `SUM`.
- `HAVING` filters **groups** *after* `GROUP BY`. Can use aggregates.

```sql
SELECT department_id, COUNT(*)
FROM employees
WHERE salary > 40000          -- filter rows first
GROUP BY department_id
HAVING COUNT(*) > 1;          -- then filter groups
```

### 43. What is the purpose of ORDER BY?
Sorts the result.
```sql
SELECT * FROM employees ORDER BY salary;
```

### 44. What is the difference between ASC and DESC?
- `ASC` = small to big (A to Z). **Default.**
- `DESC` = big to small (Z to A).

```sql
SELECT * FROM employees ORDER BY salary DESC, employee_name ASC;
```

### 45. What is the purpose of LIMIT?
Returns only the first N rows.
```sql
SELECT * FROM employees ORDER BY salary DESC LIMIT 3;   -- top 3 earners
```

### 46. What is the purpose of OFFSET?
Skips N rows first. Used with `LIMIT` for **pagination**.
```sql
SELECT * FROM employees ORDER BY employee_id LIMIT 10 OFFSET 20;  -- page 3 (rows 21–30)
```

### 47. What is the difference between DISTINCT and GROUP BY?
Both can remove duplicates.
- `DISTINCT` just removes duplicate rows.
- `GROUP BY` groups rows so you can also use aggregates (`COUNT`, `SUM`).

```sql
SELECT DISTINCT department_id FROM employees;
SELECT department_id, COUNT(*) FROM employees GROUP BY department_id;
```

### 48. What is the purpose of the LIKE operator?
Pattern matching on text. `%` = any number of characters, `_` = exactly one character.
```sql
SELECT * FROM employees WHERE employee_name LIKE 'A%';    -- starts with A
SELECT * FROM employees WHERE employee_name LIKE '%a';    -- ends with a
SELECT * FROM employees WHERE employee_name LIKE '_ob';   -- Bob
```

### 49. What is the difference between LIKE and ILIKE?
- `LIKE` is **case-sensitive**.
- `ILIKE` is **case-insensitive** (PostgreSQL only).

```sql
SELECT * FROM employees WHERE employee_name LIKE  'a%';  -- no match for Asha
SELECT * FROM employees WHERE employee_name ILIKE 'a%';  -- matches Asha, Alice
```

### 50. What is the purpose of the BETWEEN operator?
Checks a value is within a range, **including both ends**.
```sql
SELECT * FROM employees WHERE salary BETWEEN 40000 AND 70000;
-- same as: salary >= 40000 AND salary <= 70000
```

---

## Section 6: Basic Functions and Constraints

### 51. What are aggregate functions in PostgreSQL?
Functions that take **many rows and return one value**: `COUNT`, `SUM`, `AVG`, `MIN`, `MAX`.

### 52. Explain COUNT(), SUM(), AVG(), MIN(), and MAX().
```sql
SELECT COUNT(*)    FROM employees;  -- number of rows
SELECT SUM(salary) FROM employees;  -- total salary
SELECT AVG(salary) FROM employees;  -- average salary
SELECT MIN(salary) FROM employees;  -- lowest
SELECT MAX(salary) FROM employees;  -- highest
```
They ignore `NULL` values (except `COUNT(*)`).

### 53. What is the difference between COUNT(*) and COUNT(column_name)?
- `COUNT(*)` counts **all rows**.
- `COUNT(column)` counts only rows where that column is **NOT NULL**.

```sql
SELECT COUNT(*), COUNT(department_id) FROM employees;
-- 8 rows total, 7 have a department (Gina has NULL) → 8 | 7
```

### 54. What is the purpose of the COALESCE() function?
Returns the **first non-NULL** value. Used to give a default for NULL.
```sql
SELECT employee_name, COALESCE(department_id::text, 'No Dept') FROM employees;
```

### 55. What is the difference between NULL and zero?
- `0` is a real number.
- `NULL` means **unknown / no value**.

`NULL + 5` = `NULL`, not 5. `NULL = NULL` is not true.

### 56. What is the difference between IS NULL and = NULL?
`= NULL` **never works** (result is unknown, so no rows). Use `IS NULL`.
```sql
SELECT * FROM employees WHERE department_id IS NULL;   -- ✅ correct
SELECT * FROM employees WHERE department_id = NULL;    -- ❌ returns nothing
```

### 57. What is the purpose of the DEFAULT constraint?
Gives a column an automatic value if none is supplied.
```sql
CREATE TABLE orders (id INT, status TEXT DEFAULT 'pending', created_at TIMESTAMP DEFAULT NOW());
INSERT INTO orders (id) VALUES (1);   -- status = 'pending'
```

### 58. What is the CHECK constraint?
Forces a rule on the values.
```sql
CREATE TABLE employees2 (
  id INT,
  salary NUMERIC CHECK (salary > 0),
  age INT CHECK (age BETWEEN 18 AND 60)
);
```

### 59. What is the purpose of the SERIAL data type?
An **auto-increment** number (1, 2, 3...). Behind the scenes PostgreSQL creates a **sequence** and sets it as the default.
```sql
CREATE TABLE users (id SERIAL PRIMARY KEY, name TEXT);
INSERT INTO users (name) VALUES ('Asha');   -- id = 1 automatically
```

### 60. What is the difference between SERIAL and GENERATED AS IDENTITY?
| SERIAL | GENERATED AS IDENTITY |
|---|---|
| Older PostgreSQL style | **SQL-standard**, modern, recommended |
| Shortcut that makes a sequence + default | Real identity column, owned by the column |
| You can still insert your own value freely | `ALWAYS` blocks manual values unless you use `OVERRIDING` |

```sql
CREATE TABLE t (id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, name TEXT);
```


---

# Level 2: Intermediate PostgreSQL Questions (61–140)

## Section 7: Joins and Relationships

### 61. What is a JOIN in PostgreSQL?
A JOIN **combines rows from two or more tables** using a related column (usually primary key = foreign key).
```sql
SELECT e.employee_name, d.department_name
FROM employees e
JOIN departments d ON e.department_id = d.department_id;
```

### 62. Explain INNER JOIN with an example.
Returns only rows that **match in both tables**.
```sql
SELECT e.employee_name, d.department_name
FROM employees e
INNER JOIN departments d ON e.department_id = d.department_id;
```
Gina (no department) is **not** shown. The Finance department (no employees) is **not** shown.

### 63. Explain LEFT JOIN with an example.
Returns **all rows from the left table** + matching rows from the right. No match → right side is `NULL`.
```sql
SELECT e.employee_name, d.department_name
FROM employees e
LEFT JOIN departments d ON e.department_id = d.department_id;
```
Gina is shown with `department_name = NULL`.

### 64. Explain RIGHT JOIN with an example.
Returns **all rows from the right table** + matching rows from the left.
```sql
SELECT e.employee_name, d.department_name
FROM employees e
RIGHT JOIN departments d ON e.department_id = d.department_id;
```
Finance is shown with `employee_name = NULL`.

### 65. What is a FULL OUTER JOIN?
Returns **all rows from both tables**; unmatched sides are `NULL`.
```sql
SELECT e.employee_name, d.department_name
FROM employees e
FULL OUTER JOIN departments d ON e.department_id = d.department_id;
```
Shows both Gina (no dept) and Finance (no employee).

### 66. What is a CROSS JOIN?
Pairs **every row of table A with every row of table B** (Cartesian product). 4 departments × 8 employees = 32 rows.
```sql
SELECT e.employee_name, d.department_name
FROM employees e CROSS JOIN departments d;
```
Useful for generating combinations (sizes × colours).

### 67. What is a SELF JOIN?
A table joined **with itself** (use two different aliases). Typical use: employee → manager.
```sql
SELECT e.employee_name AS employee, m.employee_name AS manager
FROM employees e
LEFT JOIN employees m ON e.manager_id = m.employee_id;
```

### 68. What is the difference between INNER JOIN and LEFT JOIN?
- `INNER JOIN` → only matching rows.
- `LEFT JOIN` → all left rows, even without a match.

Use `LEFT JOIN` when you don't want to lose rows (e.g. "all employees, even those without a department").

### 69. What is the difference between LEFT JOIN and RIGHT JOIN?
They are mirror images. `A LEFT JOIN B` = `B RIGHT JOIN A`. Most developers use only `LEFT JOIN` to keep queries easy to read.

### 70. What is the difference between UNION and JOIN?
- **JOIN** adds **columns** side by side (horizontal).
- **UNION** stacks **rows** on top of each other (vertical). Both queries need the same number and type of columns.

```sql
SELECT employee_name FROM employees
UNION
SELECT project_name FROM projects;
```

### 71. How do you join three or more tables?
Keep adding `JOIN`s.
```sql
SELECT e.employee_name, p.project_name, d.department_name
FROM employees e
JOIN employee_projects ep ON e.employee_id = ep.employee_id
JOIN projects p           ON ep.project_id = p.project_id
JOIN departments d        ON e.department_id = d.department_id;
```

### 72. What is a NATURAL JOIN?
Automatically joins on **all columns that have the same name** in both tables. Risky: if someone adds a same-named column later, results silently change. Prefer an explicit `JOIN ... ON`.
```sql
SELECT * FROM employees NATURAL JOIN departments;  -- joins on department_id
```

### 73. What is the difference between one-to-one, one-to-many, and many-to-many relationships?
| Type | Meaning | Example |
|---|---|---|
| One-to-one | 1 row ↔ 1 row | Person ↔ Passport |
| One-to-many | 1 row ↔ many rows | 1 Department ↔ many Employees |
| Many-to-many | many ↔ many | Employees ↔ Projects |

### 74. How do you implement a many-to-many relationship using a junction table?
Make a **third table** that holds the two foreign keys. In our database it is `employee_projects`.
```sql
CREATE TABLE employee_projects (
  employee_id INT REFERENCES employees(employee_id),
  project_id  INT REFERENCES projects(project_id),
  PRIMARY KEY (employee_id, project_id)
);
```

### 75. How do you find records in one table that do not exist in another table?
Three common ways:
```sql
-- 1) LEFT JOIN + IS NULL
SELECT e.* FROM employees e
LEFT JOIN employee_projects ep ON e.employee_id = ep.employee_id
WHERE ep.employee_id IS NULL;

-- 2) NOT EXISTS (safest)
SELECT * FROM employees e
WHERE NOT EXISTS (SELECT 1 FROM employee_projects ep WHERE ep.employee_id = e.employee_id);

-- 3) NOT IN (careful with NULLs)
SELECT * FROM employees
WHERE employee_id NOT IN (SELECT employee_id FROM employee_projects);
```

---

## Section 8: Subqueries and Set Operations

### 76. What is a subquery in PostgreSQL?
A query **inside another query**, written in parentheses.
```sql
SELECT * FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);
```

### 77. What is the difference between a subquery and a JOIN?
- **Subquery**: easier to read for "filter by result of another query".
- **JOIN**: lets you show columns from both tables and is often faster.

Subquery cannot return columns from the inner table to the outer result; a JOIN can.

### 78. What is a correlated subquery?
A subquery that **uses a column from the outer query**, so it runs once **per outer row**.
```sql
SELECT e.employee_name, e.salary
FROM employees e
WHERE e.salary > (SELECT AVG(salary) FROM employees WHERE department_id = e.department_id);
```

### 79. What is the difference between correlated and non-correlated subqueries?
| Non-correlated | Correlated |
|---|---|
| Independent, runs **once** | Depends on outer row, runs **many times** |
| Faster | Usually slower |
| `WHERE salary > (SELECT AVG(salary) FROM employees)` | `WHERE salary > (SELECT AVG(salary) ... WHERE dept = e.dept)` |

### 80. What is the purpose of the EXISTS operator?
Checks whether the subquery returns **at least one row**. Returns `TRUE`/`FALSE`. It stops at the first match, so it is fast.
```sql
SELECT d.department_name FROM departments d
WHERE EXISTS (SELECT 1 FROM employees e WHERE e.department_id = d.department_id);
```

### 81. What is the difference between IN and EXISTS?
- `IN` compares a value with a **list** of values.
- `EXISTS` only checks **if any row exists**.

`EXISTS` is usually better for large subquery results and handles `NULL` safely. Modern PostgreSQL often plans both the same way.

### 82. What is the difference between NOT IN and NOT EXISTS, especially when NULL values are present?
**Big trap!** If the subquery list contains even one `NULL`, `NOT IN` returns **no rows**.
```sql
SELECT 1 WHERE 5 NOT IN (1, 2, NULL);   -- returns NOTHING (unknown)
```
`NOT EXISTS` is not affected by NULLs. **Always prefer `NOT EXISTS`.**

### 83. What is the purpose of ANY and ALL?
- `> ANY (list)` → greater than **at least one** value in the list.
- `> ALL (list)` → greater than **every** value in the list.

```sql
SELECT * FROM employees
WHERE salary > ALL (SELECT salary FROM employees WHERE department_id = 2);  -- more than everyone in HR
```

### 84. What is the difference between UNION and UNION ALL?
- `UNION` → combines and **removes duplicates** (slower).
- `UNION ALL` → combines and **keeps duplicates** (faster).

```sql
SELECT 1 UNION SELECT 1;       -- 1 row
SELECT 1 UNION ALL SELECT 1;   -- 2 rows
```

### 85. What is the difference between INTERSECT and EXCEPT?
- `INTERSECT` → rows present in **both** queries.
- `EXCEPT` → rows in the first query but **not** in the second.

```sql
-- employees who are on projects
SELECT employee_id FROM employees
INTERSECT
SELECT employee_id FROM employee_projects;

-- employees NOT on projects
SELECT employee_id FROM employees
EXCEPT
SELECT employee_id FROM employee_projects;
```

---

## Section 9: Aggregate Functions and Grouping

### 86. What is the purpose of GROUP BY?
Groups rows with the same value so you can run an aggregate on each group.
```sql
SELECT department_id, AVG(salary) FROM employees GROUP BY department_id;
```
Rule: every selected column must be either in `GROUP BY` or inside an aggregate.

### 87. What is the difference between GROUP BY and ORDER BY?
- `GROUP BY` → **combines** rows into groups.
- `ORDER BY` → **sorts** the final result.

### 88. How does the HAVING clause work?
It filters **after** grouping.
```sql
SELECT department_id, SUM(salary) AS total
FROM employees
GROUP BY department_id
HAVING SUM(salary) > 100000;
```

### 89. Can we use aggregate functions inside the WHERE clause?
**No.** `WHERE` runs before grouping. Use `HAVING`, or a subquery.
```sql
-- ❌ WHERE salary > AVG(salary)
-- ✅
SELECT * FROM employees WHERE salary > (SELECT AVG(salary) FROM employees);
```

### 90. How do you find duplicate records in a table?
```sql
SELECT email, COUNT(*)
FROM employees
GROUP BY email
HAVING COUNT(*) > 1;
```
Result: `bob@x.com | 2`.

### 91. How do you find the second-highest salary?
```sql
-- Method 1: subquery
SELECT MAX(salary) FROM employees
WHERE salary < (SELECT MAX(salary) FROM employees);

-- Method 2: LIMIT/OFFSET
SELECT DISTINCT salary FROM employees ORDER BY salary DESC LIMIT 1 OFFSET 1;

-- Method 3: DENSE_RANK
SELECT salary FROM (
  SELECT salary, DENSE_RANK() OVER (ORDER BY salary DESC) AS rnk FROM employees
) t WHERE rnk = 2 LIMIT 1;
```

### 92. How do you find the third-highest salary?
```sql
SELECT DISTINCT salary FROM employees ORDER BY salary DESC LIMIT 1 OFFSET 2;
```
Change `OFFSET` to N-1 for the Nth highest.

### 93. How do you find the highest salary in each department?
```sql
SELECT department_id, MAX(salary) FROM employees GROUP BY department_id;
```

### 94. How do you count employees department-wise?
```sql
SELECT d.department_name, COUNT(e.employee_id) AS total_employees
FROM departments d
LEFT JOIN employees e ON e.department_id = d.department_id
GROUP BY d.department_name;
```
`LEFT JOIN` keeps departments with 0 employees (Finance shows 0).

### 95. How do you find departments having more than five employees?
```sql
SELECT department_id, COUNT(*) FROM employees
GROUP BY department_id
HAVING COUNT(*) > 5;
```

---

## Section 10: String, Date and Numeric Functions

### 96. Explain LENGTH() and CHAR_LENGTH().
Both return the number of **characters** in text in PostgreSQL.
```sql
SELECT LENGTH('Hello'), CHAR_LENGTH('Hello');   -- 5 | 5
```
(`OCTET_LENGTH` gives bytes.)

### 97. What is the purpose of UPPER() and LOWER()?
Change text case.
```sql
SELECT UPPER('asha'), LOWER('ASHA');   -- ASHA | asha
```

### 98. What is the difference between CONCAT() and CONCAT_WS()?
- `CONCAT(a,b,c)` joins values.
- `CONCAT_WS(sep, a,b,c)` joins **with a separator**.

```sql
SELECT CONCAT('Hi', ' ', 'Asha');           -- Hi Asha
SELECT CONCAT_WS('-', '2026', '11', '25');  -- 2026-11-25
```
Both treat `NULL` as empty (unlike `||`, which gives NULL).

### 99. What is the purpose of SUBSTRING()?
Extracts part of a text.
```sql
SELECT SUBSTRING('PostgreSQL' FROM 1 FOR 4);   -- Post
SELECT SUBSTRING('PostgreSQL', 5);             -- greSQL
```

### 100. What is the purpose of TRIM(), LTRIM(), and RTRIM()?
Removes spaces (or chosen characters).
```sql
SELECT TRIM('  hi  ');    -- 'hi'  (both sides)
SELECT LTRIM('  hi  ');   -- 'hi  ' (left)
SELECT RTRIM('  hi  ');   -- '  hi' (right)
```

### 101. What is the purpose of REPLACE()?
Replaces all occurrences of a text with another.
```sql
SELECT REPLACE('I like Java', 'Java', 'SQL');   -- I like SQL
```

### 102. What is the purpose of POSITION() and STRPOS()?
Find the position (1-based) of a smaller text inside a bigger one. 0 means not found.
```sql
SELECT POSITION('SQL' IN 'PostgreSQL');   -- 8
SELECT STRPOS('PostgreSQL', 'SQL');       -- 8
```

### 103. How do you extract the year, month, and day from a date?
```sql
SELECT EXTRACT(YEAR  FROM joining_date),
       EXTRACT(MONTH FROM joining_date),
       EXTRACT(DAY   FROM joining_date)
FROM employees;
```

### 104. What is the difference between CURRENT_DATE, CURRENT_TIME, and NOW()?
```sql
SELECT CURRENT_DATE;   -- 2026-11-25                       (date only)
SELECT CURRENT_TIME;   -- 17:43:10+05:30                   (time only, with zone)
SELECT NOW();          -- 2026-11-25 17:43:10+05:30        (date + time)
```
`NOW()` stays the same during one transaction. `clock_timestamp()` gives the real, changing time.

### 105. What is the purpose of AGE() and DATE_PART()?
- `AGE(date)` → gives the difference as years, months, days.
- `DATE_PART('field', date)` → pulls out one part (like `EXTRACT`).

```sql
SELECT AGE(DATE '2000-01-01');            -- 26 years 10 mons 24 days
SELECT DATE_PART('year', NOW());          -- 2026
```

### 106. How do you calculate the difference between two dates?
```sql
SELECT DATE '2026-12-25' - DATE '2026-11-25';        -- 30 (days, integer)
SELECT AGE('2026-12-25', '2026-11-25');              -- 1 mon
SELECT CURRENT_DATE - joining_date AS days_worked FROM employees;
```

### 107. What is the purpose of ROUND(), CEIL(), and FLOOR()?
```sql
SELECT ROUND(4.567, 2);  -- 4.57
SELECT CEIL(4.1);        -- 5  (round up)
SELECT FLOOR(4.9);       -- 4  (round down)
```

### 108. What is the purpose of ABS() and POWER()?
```sql
SELECT ABS(-10);       -- 10
SELECT POWER(2, 3);    -- 8
```

### 109. How do you convert one data type into another using CAST()?
```sql
SELECT CAST('123' AS INTEGER);     -- 123
SELECT CAST('2026-11-25' AS DATE);
SELECT CAST(salary AS INT) FROM employees;
```

### 110. What is the difference between CAST() and the :: operator?
Same result. `CAST` is the **SQL standard**; `::` is PostgreSQL's **short-hand**.
```sql
SELECT CAST('10' AS INT);
SELECT '10'::INT;
```

---

## Section 11: Constraints and Database Objects

### 111. What is the difference between a PRIMARY KEY and a FOREIGN KEY?
| PRIMARY KEY | FOREIGN KEY |
|---|---|
| Uniquely identifies a row **in its own table** | Points to a primary key **in another table** |
| No duplicates, no NULL | Duplicates and NULL allowed |
| One per table | Many per table |

### 112. What is a composite primary key?
A primary key made of **two or more columns** together.
```sql
CREATE TABLE enrollments (
  student_id INT,
  course_id  INT,
  PRIMARY KEY (student_id, course_id)
);
```
Each student can take a course only once, but the same student can take many courses.

### 113. What is a composite unique constraint?
Unique across a **combination** of columns.
```sql
CREATE TABLE bookings (room INT, day DATE, UNIQUE (room, day));
```
Same room on a different day is fine; same room on the same day is not.

### 114. What is the purpose of ON DELETE CASCADE?
When the **parent row is deleted, child rows are deleted automatically**.
```sql
CREATE TABLE orders (
  id INT PRIMARY KEY,
  customer_id INT REFERENCES customers(id) ON DELETE CASCADE
);
-- deleting a customer also deletes all of their orders
```

### 115. What is the difference between ON DELETE CASCADE, SET NULL, and RESTRICT?
| Option | What happens when parent is deleted |
|---|---|
| `CASCADE` | Child rows are **deleted** too |
| `SET NULL` | Child's foreign key becomes **NULL** |
| `RESTRICT` | Delete is **blocked** if children exist |
| `NO ACTION` (default) | Similar to RESTRICT (checked at the end of statement) |

### 116. What is the difference between ON UPDATE CASCADE and ON DELETE CASCADE?
- `ON UPDATE CASCADE` → if the parent's **key value changes**, children's keys change too.
- `ON DELETE CASCADE` → if the parent row is **deleted**, children are deleted.

### 117. What is an index in PostgreSQL?
A separate data structure that helps PostgreSQL **find rows fast** without reading the whole table. Like the index at the back of a book.
```sql
CREATE INDEX idx_emp_name ON employees (employee_name);
```

### 118. Why do we create indexes?
- Faster `WHERE`, `JOIN`, `ORDER BY`, `GROUP BY`.
- Enforce uniqueness (unique indexes).

**Cost:** slower `INSERT/UPDATE/DELETE` and extra disk space. So index only columns you search often.

### 119. What is the difference between a clustered index concept and PostgreSQL's physical table storage?
- In SQL Server/MySQL InnoDB, a **clustered index** *is* the table: rows are stored in key order.
- In PostgreSQL, the table is a **heap** (unordered). **All indexes are separate** from the table.
- `CLUSTER table USING index` reorders the table **once**, but it is **not maintained** afterwards.

### 120. What is the difference between a B-tree index and a Hash index?
| B-tree (default) | Hash |
|---|---|
| Works for `=`, `<`, `>`, `BETWEEN`, `ORDER BY`, `LIKE 'abc%'` | Only `=` |
| Most commonly used | Rarely needed |

```sql
CREATE INDEX idx_hash ON employees USING HASH (email);
```

### 121. What is a composite index?
An index on **multiple columns**. Column order matters: it helps queries that use the **leftmost column(s)**.
```sql
CREATE INDEX idx_dept_sal ON employees (department_id, salary);
-- helps: WHERE department_id = 1
-- helps: WHERE department_id = 1 AND salary > 5000
-- does NOT help much: WHERE salary > 5000  (alone)
```

### 122. What is a unique index?
An index that also **prevents duplicate values**. A `UNIQUE` constraint creates one automatically.
```sql
CREATE UNIQUE INDEX idx_email ON employees (email);
```

### 123. What is a partial index?
An index on **only some rows** (with a `WHERE`). Smaller and faster.
```sql
CREATE INDEX idx_active_users ON users (email) WHERE active = TRUE;
```

### 124. What is an expression index?
An index on the **result of a function/expression**.
```sql
CREATE INDEX idx_lower_email ON employees (LOWER(email));
-- now this query can use the index:
SELECT * FROM employees WHERE LOWER(email) = 'asha@x.com';
```

### 125. What is the difference between an index and a constraint?
- **Constraint** = a **rule** about the data (PK, UNIQUE, FK, CHECK).
- **Index** = a **speed-up structure**.

`PRIMARY KEY` and `UNIQUE` constraints *use* an index internally to enforce the rule.

---

## Section 12: Views, Functions and Procedures

### 126. What is a view in PostgreSQL?
A **saved query** that behaves like a virtual table. It doesn't store data; it runs the query each time.

### 127. How do you create a view?
```sql
CREATE VIEW it_employees AS
SELECT employee_id, employee_name, salary
FROM employees WHERE department_id = 1;

SELECT * FROM it_employees;
```

### 128. What are the advantages and disadvantages of views?
**Advantages:** simplify complex queries, hide sensitive columns (security), reusable.
**Disadvantages:** don't store data (no speed gain), complex views can be slow, limited updates on complex views.

### 129. What is the difference between a normal view and a materialized view?
| View | Materialized View |
|---|---|
| Runs the query every time | **Stores the result** on disk |
| Always fresh | Must be **refreshed** |
| No extra storage | Uses storage |
| Slower for heavy queries | **Much faster** to read |

```sql
CREATE MATERIALIZED VIEW dept_totals AS
SELECT department_id, SUM(salary) AS total FROM employees GROUP BY department_id;
```

### 130. How do you refresh a materialized view?
```sql
REFRESH MATERIALIZED VIEW dept_totals;                  -- locks reads while refreshing
REFRESH MATERIALIZED VIEW CONCURRENTLY dept_totals;     -- no read lock; needs a unique index
```

### 131. What is a stored function in PostgreSQL?
Reusable code stored in the database that **returns a value** and can be used inside `SELECT`.
```sql
CREATE FUNCTION add_tax(price NUMERIC) RETURNS NUMERIC AS $$
BEGIN
  RETURN price * 1.18;
END;
$$ LANGUAGE plpgsql;

SELECT add_tax(100);   -- 118
```

### 132. What is a stored procedure?
Reusable code called with `CALL`. It can **control transactions** (`COMMIT`/`ROLLBACK` inside). Added in PostgreSQL 11.
```sql
CREATE PROCEDURE give_raise(emp INT, pct NUMERIC) AS $$
BEGIN
  UPDATE employees SET salary = salary * (1 + pct/100) WHERE employee_id = emp;
  COMMIT;
END;
$$ LANGUAGE plpgsql;

CALL give_raise(1, 10);
```

### 133. What is the difference between a function and a procedure?
| Function | Procedure |
|---|---|
| Called with `SELECT` | Called with `CALL` |
| **Must** return a value | Doesn't need to return a value |
| Cannot commit/rollback inside | **Can** commit/rollback inside |
| Can be used in queries | Cannot be used in queries |

### 134. What is PL/pgSQL?
PostgreSQL's **procedural language** (like programming inside SQL): variables, `IF`, loops, exceptions. Used to write functions, procedures, and triggers.
```sql
DO $$
DECLARE total INT;
BEGIN
  SELECT COUNT(*) INTO total FROM employees;
  IF total > 5 THEN RAISE NOTICE 'Big team: %', total; END IF;
END $$;
```

### 135. What are the different types of parameters in PostgreSQL functions?
- `IN` (default): input only
- `OUT`: output only
- `INOUT`: input and output
- `VARIADIC`: accepts a variable number of arguments

```sql
CREATE FUNCTION calc(IN a INT, IN b INT, OUT sum INT, OUT product INT) AS $$
BEGIN sum := a + b; product := a * b; END; $$ LANGUAGE plpgsql;
SELECT * FROM calc(3, 4);   -- 7 | 12
```

### 136. What is a trigger in PostgreSQL?
Code that runs **automatically** when `INSERT`, `UPDATE`, or `DELETE` happens on a table. Example: log every salary change.
```sql
CREATE TABLE salary_log (emp_id INT, old_salary NUMERIC, new_salary NUMERIC, changed_at TIMESTAMP DEFAULT NOW());

CREATE FUNCTION log_salary() RETURNS TRIGGER AS $$
BEGIN
  INSERT INTO salary_log (emp_id, old_salary, new_salary)
  VALUES (OLD.employee_id, OLD.salary, NEW.salary);
  RETURN NEW;
END; $$ LANGUAGE plpgsql;

CREATE TRIGGER trg_salary
AFTER UPDATE OF salary ON employees
FOR EACH ROW EXECUTE FUNCTION log_salary();
```

### 137. What are BEFORE, AFTER, and INSTEAD OF triggers?
- `BEFORE` → runs **before** the change; can modify or cancel the row (validation).
- `AFTER` → runs **after** the change (logging, auditing).
- `INSTEAD OF` → **replaces** the action; used on **views** only.

### 138. What is the difference between ROW-level and STATEMENT-level triggers?
- `FOR EACH ROW` → fires **once per affected row** (updating 10 rows = 10 times).
- `FOR EACH STATEMENT` → fires **once per SQL statement**, no matter how many rows.

### 139. What is a sequence in PostgreSQL?
A database object that **generates unique numbers** in order. Used for IDs.
```sql
CREATE SEQUENCE order_seq START 1000 INCREMENT 1;
SELECT NEXTVAL('order_seq');   -- 1000
SELECT NEXTVAL('order_seq');   -- 1001
SELECT CURRVAL('order_seq');   -- 1001
```

### 140. What is the difference between a sequence and an identity column?
- A **sequence** is a separate object you can share between tables.
- An **identity column** is a column feature that **creates and owns its own sequence automatically**, and is SQL-standard.

Use identity columns for normal auto-numbering; use sequences when you need custom or shared numbering.


---

# Level 3: Hard PostgreSQL Questions (141–200)

## Section 13: Advanced SQL and Window Functions

### 141. What are window functions in PostgreSQL?
Functions that do a calculation across a **set of related rows** but **keep every row** in the result. They use `OVER (...)`.
```sql
SELECT employee_name, salary,
       AVG(salary) OVER () AS company_avg
FROM employees;
```
Every employee row is shown, with the overall average beside it.

### 142. What is the difference between aggregate functions and window functions?
| Aggregate (`GROUP BY`) | Window (`OVER`) |
|---|---|
| Collapses rows into **one row per group** | **Keeps all rows** |
| Can't show row details with the total | Shows row details + calculation |

```sql
SELECT department_id, AVG(salary) FROM employees GROUP BY department_id;          -- 1 row per dept
SELECT employee_name, AVG(salary) OVER (PARTITION BY department_id) FROM employees; -- every employee
```

### 143. Explain ROW_NUMBER() with an example.
Gives each row a **unique number** (1, 2, 3...) in the order you choose. No ties: equal values still get different numbers.
```sql
SELECT employee_name, salary,
       ROW_NUMBER() OVER (ORDER BY salary DESC) AS rn
FROM employees;
```

### 144. What is the difference between ROW_NUMBER(), RANK(), and DENSE_RANK()?
For salaries 90, 70, 70, 60:

| Salary | ROW_NUMBER | RANK | DENSE_RANK |
|---|---|---|---|
| 90 | 1 | 1 | 1 |
| 70 | 2 | 2 | 2 |
| 70 | 3 | 2 | 2 |
| 60 | 4 | **4** (gap) | **3** (no gap) |

```sql
SELECT employee_name, salary,
  ROW_NUMBER() OVER (ORDER BY salary DESC) rn,
  RANK()       OVER (ORDER BY salary DESC) rnk,
  DENSE_RANK() OVER (ORDER BY salary DESC) drnk
FROM employees;
```

### 145. What is the purpose of PARTITION BY?
It splits rows into **groups (partitions)**; the window function restarts for each group.
```sql
SELECT employee_name, department_id, salary,
       RANK() OVER (PARTITION BY department_id ORDER BY salary DESC) AS dept_rank
FROM employees;
```

### 146. What is the difference between PARTITION BY and GROUP BY?
- `GROUP BY` **reduces** rows (1 per group).
- `PARTITION BY` only **defines the groups for the window calculation** and keeps all rows.

### 147. What is the purpose of LAG() and LEAD()?
- `LAG(col)` → value from the **previous** row.
- `LEAD(col)` → value from the **next** row.

```sql
SELECT employee_name, salary,
       LAG(salary)  OVER (ORDER BY salary) AS prev_salary,
       LEAD(salary) OVER (ORDER BY salary) AS next_salary
FROM employees;
```
Great for month-over-month change: `sales - LAG(sales) OVER (ORDER BY month)`.

### 148. What is the purpose of FIRST_VALUE() and LAST_VALUE()?
Return the **first / last value in the window**.
```sql
SELECT employee_name, department_id, salary,
  FIRST_VALUE(employee_name) OVER (PARTITION BY department_id ORDER BY salary DESC) AS top_earner
FROM employees;
```
⚠️ `LAST_VALUE` with default frame only goes to the *current row*. Add `ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING` to get the real last value.

### 149. What is a window frame in PostgreSQL?
The **sub-range of rows** inside a partition used for the calculation relative to the current row.
```sql
SUM(salary) OVER (ORDER BY joining_date
                  ROWS BETWEEN 2 PRECEDING AND CURRENT ROW)
-- = sum of this row and the 2 rows before it
```
Common pieces: `UNBOUNDED PRECEDING`, `n PRECEDING`, `CURRENT ROW`, `n FOLLOWING`, `UNBOUNDED FOLLOWING`.

### 150. What is the difference between ROWS and RANGE in window functions?
- `ROWS` counts **physical rows**.
- `RANGE` includes all rows with the **same ORDER BY value (peers)** as the current row.

With salaries 70, 70 and a running sum: `ROWS` adds the two 70s one by one; `RANGE` treats both 70s as one step, so both show the same running total. (Default frame with `ORDER BY` is `RANGE ... CURRENT ROW`.)

### 151. How do you find the top three highest-paid employees in each department?
```sql
SELECT * FROM (
  SELECT employee_name, department_id, salary,
         DENSE_RANK() OVER (PARTITION BY department_id ORDER BY salary DESC) AS rnk
  FROM employees
) t
WHERE rnk <= 3;
```
Use `ROW_NUMBER()` for exactly 3 rows per dept, `DENSE_RANK()` to include ties.

### 152. How do you find the Nth highest salary without using LIMIT and OFFSET?
```sql
-- Window function (N = 3)
SELECT DISTINCT salary FROM (
  SELECT salary, DENSE_RANK() OVER (ORDER BY salary DESC) AS rnk FROM employees
) t WHERE rnk = 3;

-- Correlated subquery
SELECT DISTINCT e1.salary FROM employees e1
WHERE 3 - 1 = (SELECT COUNT(DISTINCT e2.salary) FROM employees e2 WHERE e2.salary > e1.salary);
```

### 153. How do you calculate a running total using window functions?
```sql
SELECT employee_name, joining_date, salary,
       SUM(salary) OVER (ORDER BY joining_date, employee_id) AS running_total
FROM employees;
```

### 154. How do you calculate a moving average?
Use a frame. 3-row moving average:
```sql
SELECT joining_date, salary,
       AVG(salary) OVER (ORDER BY joining_date
                         ROWS BETWEEN 2 PRECEDING AND CURRENT ROW) AS moving_avg
FROM employees;
```

### 155. How do you identify consecutive records using window functions?
**Trick:** `value - ROW_NUMBER()` stays the same for a consecutive run.
```sql
-- consecutive login days per user
SELECT user_id, MIN(login_date) AS start_day, MAX(login_date) AS end_day, COUNT(*) AS streak
FROM (
  SELECT user_id, login_date,
         login_date - (ROW_NUMBER() OVER (PARTITION BY user_id ORDER BY login_date))::int AS grp
  FROM logins
) t
GROUP BY user_id, grp;
```
For numbers: `id - ROW_NUMBER() OVER (ORDER BY id)` gives the same value for consecutive ids.

---

## Section 14: CTE and Recursive Queries

### 156. What is a Common Table Expression (CTE)?
A **named temporary result** defined with `WITH`, used inside one query. It makes long queries readable.
```sql
WITH high_paid AS (
  SELECT * FROM employees WHERE salary > 60000
)
SELECT employee_name FROM high_paid;
```

### 157. What is the difference between a CTE and a subquery?
- Both give a temporary result.
- **CTE**: named, can be used **many times**, can be **recursive**, easier to read.
- **Subquery**: written inline, used once.

### 158. What is a recursive CTE?
A CTE that **calls itself** to walk through hierarchical data (org charts, folders, categories). It has two parts joined with `UNION ALL`:
1. **Anchor** (starting rows)
2. **Recursive part** (repeats until no new rows)

```sql
WITH RECURSIVE numbers AS (
  SELECT 1 AS n                 -- anchor
  UNION ALL
  SELECT n + 1 FROM numbers WHERE n < 5   -- recursion
)
SELECT * FROM numbers;   -- 1,2,3,4,5
```

### 159. How do you implement hierarchical data using recursive CTEs?
Store the parent id in each row (`manager_id`) and walk down from the top.
```sql
WITH RECURSIVE org AS (
  SELECT employee_id, employee_name, manager_id, 1 AS level
  FROM employees WHERE manager_id IS NULL
  UNION ALL
  SELECT e.employee_id, e.employee_name, e.manager_id, o.level + 1
  FROM employees e JOIN org o ON e.manager_id = o.employee_id
)
SELECT * FROM org ORDER BY level;
```

### 160. What is the purpose of the WITH clause?
It starts a CTE. It lets you **name a step** and reuse it. You can also use it with `INSERT/UPDATE/DELETE ... RETURNING` (data-modifying CTEs).
```sql
WITH deleted AS (DELETE FROM employees WHERE salary < 35000 RETURNING *)
INSERT INTO employee_archive SELECT * FROM deleted;
```

### 161. What is the difference between MATERIALIZED and NOT MATERIALIZED CTEs?
(PostgreSQL 12+)
- `MATERIALIZED` → CTE is computed **once and stored**, acts as an optimization fence.
- `NOT MATERIALIZED` → CTE is **inlined** into the main query so the planner can optimize it together.

```sql
WITH x AS MATERIALIZED     (SELECT * FROM employees WHERE salary > 1000) SELECT * FROM x;
WITH x AS NOT MATERIALIZED (SELECT * FROM employees WHERE salary > 1000) SELECT * FROM x WHERE employee_id = 5;
```
By default, a CTE used **once** and not recursive is inlined; a CTE used **many times** is materialized.

### 162. How can you use multiple CTEs in a single SQL query?
Separate them with commas; later CTEs can use earlier ones.
```sql
WITH dept_avg AS (
  SELECT department_id, AVG(salary) AS avg_sal FROM employees GROUP BY department_id
),
above_avg AS (
  SELECT e.* FROM employees e JOIN dept_avg d USING (department_id)
  WHERE e.salary > d.avg_sal
)
SELECT employee_name, salary FROM above_avg;
```

### 163. How do you retrieve an employee's complete reporting hierarchy?
Walk **upwards** from the employee to the top boss.
```sql
WITH RECURSIVE chain AS (
  SELECT employee_id, employee_name, manager_id, 0 AS level
  FROM employees WHERE employee_id = 8
  UNION ALL
  SELECT m.employee_id, m.employee_name, m.manager_id, c.level + 1
  FROM employees m JOIN chain c ON m.employee_id = c.manager_id
)
SELECT * FROM chain;    -- Gina → Eve → Asha
```

### 164. How do you find all child categories of a parent category using a recursive query?
```sql
WITH RECURSIVE sub AS (
  SELECT id, name, parent_id FROM categories WHERE id = 1       -- the parent
  UNION ALL
  SELECT c.id, c.name, c.parent_id
  FROM categories c JOIN sub s ON c.parent_id = s.id
)
SELECT * FROM sub;
```

### 165. How do you prevent infinite recursion in a recursive CTE?
Infinite loops happen when data has a cycle (A → B → A). Ways to stop it:
1. Add a **depth limit**: `WHERE level < 10`.
2. Use `UNION` instead of `UNION ALL` (removes repeated rows).
3. Keep a **path array** and skip rows already visited: `WHERE NOT c.id = ANY(path)`.
4. Use the `CYCLE` clause (PostgreSQL 14+):
```sql
WITH RECURSIVE t(id, parent_id) AS (
  SELECT id, parent_id FROM categories WHERE id = 1
  UNION ALL
  SELECT c.id, c.parent_id FROM categories c JOIN t ON c.parent_id = t.id
) CYCLE id SET is_cycle USING path
SELECT * FROM t WHERE NOT is_cycle;
```

---

## Section 15: PostgreSQL Architecture and Performance

### 166. Explain PostgreSQL architecture, including the postmaster process and backend processes.
- **Postmaster**: the main (parent) process. Starts at server start, listens on port 5432, **forks a new backend process for every client connection**, and restarts crashed helpers.
- **Backend process**: handles one client: parse → plan → execute → return results.
- **Shared memory**: `shared_buffers` (cache), WAL buffers, lock tables.
- **Background processes**: 
  - *Checkpointer* – flushes dirty pages to disk periodically
  - *Background writer* – writes dirty buffers gradually
  - *WAL writer* – writes WAL to disk
  - *Autovacuum launcher/workers* – clean dead rows
  - *Stats collector / logger* – statistics and logs
- **Storage**: data files + WAL files.

Because each connection is a process, use a **connection pooler (PgBouncer)** for many clients.

### 167. What is MVCC (Multi-Version Concurrency Control)?
Instead of locking a row while someone updates it, PostgreSQL keeps **multiple versions** of the row. Each transaction sees a **snapshot** of data as it was when it started.
**Result: readers never block writers, and writers never block readers.**

Example: Session A updates Bob's salary (not yet committed). Session B still reads the **old** salary until A commits.

### 168. How does PostgreSQL handle concurrent transactions?
Using **MVCC** (snapshots) + **locks** for write–write conflicts + **isolation levels**. Each row version has hidden columns `xmin` (creator transaction) and `xmax` (deleter transaction). A transaction decides which version is visible by checking those ids. If two transactions update the same row, the second **waits** for the first to commit or roll back.

### 169. What is VACUUM in PostgreSQL?
Because of MVCC, `UPDATE`/`DELETE` leave **dead rows** (old versions). `VACUUM` finds them and marks the space **reusable**. It also prevents transaction-id wraparound and updates the visibility map.
```sql
VACUUM employees;
VACUUM (VERBOSE, ANALYZE) employees;
```

### 170. What is the difference between VACUUM and VACUUM FULL?
| VACUUM | VACUUM FULL |
|---|---|
| Marks space reusable **inside the table** | **Rewrites the table** into a new file, returns space to the OS |
| Does **not** lock the table for reads/writes | Takes an **ACCESS EXCLUSIVE lock** (blocks everything) |
| Fast, safe for production | Slow; use rarely, in a maintenance window |

### 171. What is ANALYZE in PostgreSQL?
Collects **statistics** about table data (row counts, value distribution). The **query planner** uses these to choose the best plan.
```sql
ANALYZE employees;
VACUUM ANALYZE employees;   -- both together
```

### 172. What is autovacuum, and why is it important?
A background worker that **automatically runs VACUUM and ANALYZE** when enough rows change. Without it, tables bloat, queries slow down, and eventually the database can hit **transaction ID wraparound** (a serious outage). Don't turn it off; tune it for busy tables.

### 173. What is table bloat?
Wasted space in a table or index caused by **dead rows that were not cleaned**. The table becomes bigger than the real data, so scans are slower and cache is wasted.
Causes: heavy updates/deletes, autovacuum falling behind, long-running transactions.
Fix: tune autovacuum, `VACUUM`, `pg_repack`, or `VACUUM FULL` in a maintenance window.

### 174. What is the purpose of EXPLAIN?
Shows the **execution plan**: how PostgreSQL *plans* to run the query (scan type, join type, estimated cost and rows) **without running it**.
```sql
EXPLAIN SELECT * FROM employees WHERE employee_id = 5;
```

### 175. What is the difference between EXPLAIN and EXPLAIN ANALYZE?
- `EXPLAIN` → **estimated** plan only (query is not run).
- `EXPLAIN ANALYZE` → **actually runs** the query and shows **real** time and row counts.

⚠️ `EXPLAIN ANALYZE` on `UPDATE/DELETE` really changes data. Wrap in `BEGIN; ... ROLLBACK;`.
```sql
EXPLAIN (ANALYZE, BUFFERS) SELECT * FROM employees WHERE salary > 50000;
```

### 176. How do you identify a slow-running query?
1. **`pg_stat_statements`** extension: shows total/average time per query.
2. **`pg_stat_activity`**: see currently running queries and how long.
3. **`log_min_duration_statement`**: log any query slower than e.g. 500 ms.
4. **`EXPLAIN (ANALYZE)`** to see why.

```sql
SELECT pid, now() - query_start AS duration, query
FROM pg_stat_activity
WHERE state = 'active'
ORDER BY duration DESC;

SELECT query, calls, mean_exec_time
FROM pg_stat_statements ORDER BY mean_exec_time DESC LIMIT 10;
```

### 177. What is a sequential scan?
PostgreSQL reads the **entire table** row by row (`Seq Scan`). It's fine for small tables or when you need most rows. It's bad on a big table when you need only a few rows.

### 178. What is an index scan?
PostgreSQL uses an **index** to jump to matching rows directly (`Index Scan`), then reads those rows from the table. Best when only a **small percentage** of rows is needed. If the index has all needed columns, it can use an **Index Only Scan**.

### 179. What is a bitmap index scan?
Used when a query matches **a medium number of rows**. PostgreSQL:
1. Scans the index and builds a **bitmap** of matching table pages (`Bitmap Index Scan`).
2. Reads those pages in physical order (`Bitmap Heap Scan`).

It can also **combine several indexes** (AND/OR conditions).

### 180. How do you optimize a slow PostgreSQL query?
Step by step:
1. Run `EXPLAIN (ANALYZE, BUFFERS)`.
2. **Add the right index** (on `WHERE`, `JOIN`, `ORDER BY` columns).
3. Select only needed columns; avoid `SELECT *`.
4. Avoid functions on indexed columns (`WHERE LOWER(email)=...` → use an expression index).
5. Run `ANALYZE` so statistics are fresh.
6. Rewrite subqueries to joins / `EXISTS`, use `LIMIT`.
7. Use pagination with keyset (`WHERE id > last_id`) rather than huge `OFFSET`.
8. Tune `work_mem`, `shared_buffers`; use partitioning for huge tables.
9. Fix bloat with vacuum.

---

## Section 16: Transactions, Locking and Concurrency

### 181. What is a transaction in PostgreSQL?
A **group of SQL statements treated as one unit**: either **all succeed** or **none**.
```sql
BEGIN;
UPDATE accounts SET balance = balance - 500 WHERE id = 1;
UPDATE accounts SET balance = balance + 500 WHERE id = 2;
COMMIT;      -- or ROLLBACK to cancel both
```

### 182. Explain the ACID properties.
| Letter | Meaning | Simple example (bank transfer) |
|---|---|---|
| **A**tomicity | All or nothing | Money is either moved fully or not at all |
| **C**onsistency | Data stays valid (rules/constraints hold) | Balance never goes below the allowed limit |
| **I**solation | Transactions don't disturb each other | Two transfers at once don't mix up |
| **D**urability | Committed data survives a crash | After "success", power cut can't lose it (WAL) |

### 183. What are the different transaction isolation levels in PostgreSQL?
1. **READ UNCOMMITTED** (behaves like Read Committed in PostgreSQL)
2. **READ COMMITTED** (**default**)
3. **REPEATABLE READ**
4. **SERIALIZABLE**

PostgreSQL never allows dirty reads.

### 184. What is the difference between READ COMMITTED and REPEATABLE READ?
- **READ COMMITTED**: every **statement** sees a fresh snapshot. A second `SELECT` in the same transaction can show **new committed** data (non-repeatable read).
- **REPEATABLE READ**: one snapshot for the **whole transaction**. Repeat reads give the same result. If you try to update a row someone else changed, you get a **serialization error** and must retry.

```sql
BEGIN ISOLATION LEVEL REPEATABLE READ;
SELECT salary FROM employees WHERE employee_id = 1;
-- even if another session commits a change, this transaction still sees the old value
COMMIT;
```

### 185. What is SERIALIZABLE isolation?
The strictest level: the result is as if transactions ran **one after another**. PostgreSQL uses **SSI (Serializable Snapshot Isolation)** to detect conflicts; if one occurs, a transaction fails with an error and **the app must retry**.
```sql
BEGIN ISOLATION LEVEL SERIALIZABLE;
```

### 186. What is a deadlock in PostgreSQL?
Two (or more) transactions **wait for each other forever**.
- T1 locks row A, then wants row B.
- T2 locks row B, then wants row A.

PostgreSQL detects it after `deadlock_timeout` (1 s) and **aborts one transaction** with `ERROR: deadlock detected`.

### 187. How do you identify and resolve deadlocks?
**Identify:** check the server log (it shows the queries involved), and `pg_locks` / `pg_stat_activity`.
**Resolve / prevent:**
- Always lock rows/tables in the **same order**.
- Keep transactions **short**.
- Use `SELECT ... FOR UPDATE` carefully, `NOWAIT`, or `SKIP LOCKED`.
- Retry the failed transaction in the application.

### 188. What is the difference between row-level locks and table-level locks?
| Row-level | Table-level |
|---|---|
| Locks only specific rows | Locks the **whole table** |
| `SELECT FOR UPDATE`, `UPDATE`, `DELETE` | `LOCK TABLE`, `ALTER TABLE`, `VACUUM FULL` |
| High concurrency | Can block many sessions |

Normal reads (`SELECT`) take only a weak `ACCESS SHARE` lock and never block writes.

### 189. What is the purpose of SELECT FOR UPDATE?
Locks the selected rows so **others cannot change them** until your transaction ends. Used to avoid lost updates (e.g. booking a seat).
```sql
BEGIN;
SELECT * FROM seats WHERE id = 10 FOR UPDATE;   -- lock this seat
UPDATE seats SET booked = TRUE WHERE id = 10;
COMMIT;
```
Variants: `NOWAIT` (error instead of waiting), `SKIP LOCKED` (skip locked rows; great for job queues).

### 190. What is the difference between COMMIT and ROLLBACK?
- `COMMIT` → **save** all changes permanently.
- `ROLLBACK` → **cancel** all changes since `BEGIN`.

### 191. What is a savepoint, and how do you use it?
A **checkpoint inside a transaction** so you can undo only part of it.
```sql
BEGIN;
INSERT INTO employees (employee_id, employee_name) VALUES (20, 'Test1');
SAVEPOINT sp1;
INSERT INTO employees (employee_id, employee_name) VALUES (21, 'Test2');
ROLLBACK TO sp1;     -- undoes only Test2
COMMIT;              -- Test1 is saved
```

### 192. What is an advisory lock in PostgreSQL?
An **application-defined lock** on any number you choose; PostgreSQL doesn't link it to a table or row. Used to make sure only one worker does a job (e.g. a cron task).
```sql
SELECT pg_advisory_lock(12345);       -- wait until I get it
-- ... do exclusive work ...
SELECT pg_advisory_unlock(12345);

SELECT pg_try_advisory_lock(12345);   -- returns true/false, doesn't wait
```

---

## Section 17: Advanced PostgreSQL Features and Real-World Scenarios

### 193. What is the difference between JSON and JSONB indexing?
- `JSON` (text) can't use GIN indexes; only expression indexes are possible.
- `JSONB` supports **GIN indexes**, so containment searches (`@>`, `?`) are fast.

```sql
CREATE INDEX idx_data_gin ON products USING GIN (data);           -- whole JSONB
CREATE INDEX idx_brand    ON products ((data->>'brand'));         -- one key (B-tree)
```

### 194. How do you query nested JSONB data in PostgreSQL?
```sql
-- sample data
-- {"name":"Phone","specs":{"ram":8,"color":"black"},"tags":["new","sale"]}

SELECT data->'specs'->>'ram'           FROM products;                -- 8 (as text)
SELECT data #>> '{specs,color}'        FROM products;                -- black
SELECT * FROM products WHERE data @> '{"specs":{"ram":8}}';          -- contains
SELECT * FROM products WHERE data->'tags' ? 'sale';                  -- key/element exists
SELECT jsonb_array_elements_text(data->'tags') FROM products;        -- expand array
```
`->` returns JSON, `->>` returns text.

### 195. What is the purpose of the GIN index?
**GIN (Generalized Inverted Index)** indexes **values inside a column that contains many items**: JSONB, arrays, full-text search (`tsvector`). It maps each item → rows that contain it (like the index at the back of a book).
```sql
CREATE INDEX idx_tags ON posts USING GIN (tags);                  -- array column
SELECT * FROM posts WHERE tags @> ARRAY['postgres'];
```

### 196. What is table partitioning in PostgreSQL, and what are its types?
Splitting one **big table into smaller pieces (partitions)**. Queries only touch needed partitions (**partition pruning**), and old data can be dropped quickly.
Types:
- **RANGE** (dates, numbers)
- **LIST** (specific values, e.g. country)
- **HASH** (spread evenly)

```sql
CREATE TABLE sales (id INT, sale_date DATE, amount NUMERIC)
PARTITION BY RANGE (sale_date);

CREATE TABLE sales_2026 PARTITION OF sales
  FOR VALUES FROM ('2026-01-01') TO ('2027-01-01');
```

### 197. What is the difference between table partitioning and table inheritance?
| Declarative Partitioning | Inheritance |
|---|---|
| Modern, built-in (`PARTITION BY`) | Older, manual |
| Automatic row routing to the right partition | You must use triggers/rules to route rows |
| Partition pruning works well | Limited |
| Recommended | Rarely used now |

### 198. How do you implement full-text search in PostgreSQL?
Use `tsvector` (document) and `tsquery` (search words), plus a **GIN index**.
```sql
-- search directly
SELECT * FROM articles
WHERE to_tsvector('english', title || ' ' || body) @@ to_tsquery('english', 'postgres & index');

-- faster: store a generated column and index it
ALTER TABLE articles ADD COLUMN doc tsvector
  GENERATED ALWAYS AS (to_tsvector('english', title || ' ' || body)) STORED;
CREATE INDEX idx_doc ON articles USING GIN (doc);

SELECT * FROM articles WHERE doc @@ plainto_tsquery('english', 'postgres index');
```
It handles stemming (run/running/ran) and ranking with `ts_rank`.

### 199. How do you take database backups and restore a PostgreSQL database using pg_dump and pg_restore?
```bash
# BACKUP
pg_dump -U postgres -d company_db -F c -f company_db.dump     # custom compressed format
pg_dump -U postgres -d company_db -f company_db.sql           # plain SQL file
pg_dumpall -U postgres > all_databases.sql                    # everything incl. roles

# RESTORE
createdb -U postgres company_restore
pg_restore -U postgres -d company_restore company_db.dump     # for -F c dumps
psql -U postgres -d company_restore -f company_db.sql         # for plain SQL
```
Useful options: `-j 4` (parallel restore), `-t table` (one table), `--clean` (drop before restoring).
For large systems also learn **physical backups** (`pg_basebackup`) and **PITR** (point-in-time recovery using WAL archives).

### 200. A production application is experiencing slow database performance, high CPU usage, and multiple blocked queries. How would you investigate and resolve the issue?
Answer in a clear, step-by-step way (interviewers love this structure):

**Step 1: See what is running now**
```sql
SELECT pid, usename, state, wait_event_type, wait_event,
       now() - query_start AS runtime, query
FROM pg_stat_activity
WHERE state <> 'idle'
ORDER BY runtime DESC;
```

**Step 2: Find who is blocking whom**
```sql
SELECT pid, pg_blocking_pids(pid) AS blocked_by, query
FROM pg_stat_activity
WHERE cardinality(pg_blocking_pids(pid)) > 0;
```
Look for **long-running or "idle in transaction"** sessions holding locks.

**Step 3: Fix the immediate emergency**
```sql
SELECT pg_cancel_backend(<pid>);      -- politely cancel the query
SELECT pg_terminate_backend(<pid>);   -- kill the connection if needed
```

**Step 4: Find the heavy queries**
```sql
SELECT query, calls, total_exec_time, mean_exec_time
FROM pg_stat_statements ORDER BY total_exec_time DESC LIMIT 10;
```

**Step 5: Analyze them** with `EXPLAIN (ANALYZE, BUFFERS)`. Look for sequential scans on big tables, bad row estimates, big sorts.

**Step 6: Fix root causes**
- Add or fix indexes; rewrite bad queries.
- Run `ANALYZE`; check autovacuum and table **bloat**.
- Use a **connection pooler (PgBouncer)** if there are too many connections.
- Shorten transactions; add `statement_timeout` and `idle_in_transaction_session_timeout`.
- Tune `work_mem`, `shared_buffers`, `max_connections`.
- Check server health (CPU, RAM, disk I/O); add read replicas or caching if the load is read-heavy.

**Step 7: Prevent it**: monitoring and alerts (pg_stat_statements, Prometheus/Grafana), slow query log, regular load testing.


---

# Practical SQL Interview Round

Uses the practice database from the top of this file (`departments`, `employees`, `projects`, `employee_projects`).
Interviewers want: **(1) a correct query, (2) your logic explained, (3) edge cases** (NULLs, ties, duplicates).

### 1. Display all employees
```sql
SELECT * FROM employees;
```

### 2. Employees whose salary is greater than 50,000
```sql
SELECT * FROM employees WHERE salary > 50000;
```

### 3. Employees whose names start with the letter A
```sql
SELECT * FROM employees WHERE employee_name LIKE 'A%';
-- case-insensitive: ILIKE 'a%'
```

### 4. Employees who joined in the current year
```sql
-- Simple
SELECT * FROM employees
WHERE EXTRACT(YEAR FROM joining_date) = EXTRACT(YEAR FROM CURRENT_DATE);

-- Index-friendly (better for big tables)
SELECT * FROM employees
WHERE joining_date >= DATE_TRUNC('year', CURRENT_DATE)
  AND joining_date <  DATE_TRUNC('year', CURRENT_DATE) + INTERVAL '1 year';
```

### 5. Employees who do not belong to any department
```sql
SELECT * FROM employees WHERE department_id IS NULL;
```
Edge case: use `IS NULL`, never `= NULL`.

### 6. Highest salary in the Employees table
```sql
SELECT MAX(salary) FROM employees;
```

### 7. Second-highest salary
```sql
SELECT MAX(salary) FROM employees
WHERE salary < (SELECT MAX(salary) FROM employees);
```
Edge case: if several people share the top salary, this still returns the next *different* salary.

### 8. Top three salaries in each department
```sql
SELECT * FROM (
  SELECT employee_name, department_id, salary,
         DENSE_RANK() OVER (PARTITION BY department_id ORDER BY salary DESC) AS rnk
  FROM employees
) t
WHERE rnk <= 3;
```
Edge case: `DENSE_RANK` keeps ties; use `ROW_NUMBER` for exactly 3 rows.

### 9. Duplicate email addresses
```sql
SELECT email, COUNT(*) AS times
FROM employees
GROUP BY email
HAVING COUNT(*) > 1;
```

### 10. Count employees in each department
```sql
SELECT d.department_name, COUNT(e.employee_id) AS total
FROM departments d
LEFT JOIN employees e ON e.department_id = d.department_id
GROUP BY d.department_name;
```

### 11. Departments having more than five employees
```sql
SELECT department_id, COUNT(*) AS total
FROM employees
GROUP BY department_id
HAVING COUNT(*) > 5;
```

### 12. Employee names with their department names using JOIN
```sql
SELECT e.employee_name, d.department_name
FROM employees e
JOIN departments d ON e.department_id = d.department_id;
-- use LEFT JOIN to also show employees with no department
```

### 13. Employees who are not assigned to any project
```sql
SELECT e.*
FROM employees e
WHERE NOT EXISTS (
  SELECT 1 FROM employee_projects ep WHERE ep.employee_id = e.employee_id
);
```

### 14. Projects that have no employees
```sql
SELECT p.*
FROM projects p
LEFT JOIN employee_projects ep ON p.project_id = ep.project_id
WHERE ep.project_id IS NULL;
```

### 15. Each employee with their manager's name (SELF JOIN)
```sql
SELECT e.employee_name AS employee, m.employee_name AS manager
FROM employees e
LEFT JOIN employees m ON e.manager_id = m.employee_id;
```
`LEFT JOIN` keeps the top boss (who has no manager).

### 16. Employees earning more than their department's average salary
```sql
-- Window function way
SELECT * FROM (
  SELECT employee_name, department_id, salary,
         AVG(salary) OVER (PARTITION BY department_id) AS dept_avg
  FROM employees
) t
WHERE salary > dept_avg;

-- Correlated subquery way
SELECT e.employee_name, e.salary
FROM employees e
WHERE e.salary > (SELECT AVG(salary) FROM employees WHERE department_id = e.department_id);
```

### 17. Total salary expenditure of each department
```sql
SELECT d.department_name, COALESCE(SUM(e.salary), 0) AS total_salary
FROM departments d
LEFT JOIN employees e ON e.department_id = d.department_id
GROUP BY d.department_name;
```

### 18. Employees who have the same salary
```sql
SELECT e.*
FROM employees e
WHERE e.salary IN (
  SELECT salary FROM employees GROUP BY salary HAVING COUNT(*) > 1
)
ORDER BY e.salary;
```
Sample data returns Bob & Alice (70000) and Eve & Frank (45000).

### 19. Highest-paid employee in every department, including ties
```sql
SELECT employee_name, department_id, salary
FROM (
  SELECT employee_name, department_id, salary,
         RANK() OVER (PARTITION BY department_id ORDER BY salary DESC) AS rnk
  FROM employees
) t
WHERE rnk = 1;
```
`RANK() = 1` returns **all tied** top earners.

### 20. Employees who joined before their managers
```sql
SELECT e.employee_name, e.joining_date AS emp_date,
       m.employee_name AS manager, m.joining_date AS mgr_date
FROM employees e
JOIN employees m ON e.manager_id = m.employee_id
WHERE e.joining_date < m.joining_date;
```
Example match: Alice (2019) reports to Asha (2020).

---

# Complete Topic Coverage Checklist

Tick these off as you finish them.

- [ ] PostgreSQL introduction and architecture (Q1–10, 166)
- [ ] Database, schema and tables (Q11–15)
- [ ] Data types and type conversion (Q21–30, 109–110)
- [ ] DDL, DML, DQL, DCL and TCL (Q31–34)
- [ ] SELECT, INSERT, UPDATE and DELETE (Q35–40)
- [ ] WHERE, ORDER BY, LIMIT and OFFSET (Q41–46)
- [ ] Operators and conditions (Q47–50, 55–56)
- [ ] Aggregate and string functions (Q51–53, 96–102)
- [ ] Date and time functions (Q103–106)
- [ ] Constraints and keys (Q16–20, 57–58, 111–116)
- [ ] All types of JOINs (Q61–75)
- [ ] Subqueries and correlated queries (Q76–83)
- [ ] UNION, INTERSECT and EXCEPT (Q84–85)
- [ ] GROUP BY and HAVING (Q86–95)
- [ ] Indexes and index optimization (Q117–125, 177–180)
- [ ] Views and materialized views (Q126–130)
- [ ] Functions and stored procedures (Q131–135)
- [ ] PL/pgSQL and triggers (Q134, 136–138)
- [ ] Sequences and identity columns (Q59–60, 139–140)
- [ ] Window functions (Q141–155)
- [ ] CTEs and recursive queries (Q156–165)
- [ ] MVCC and PostgreSQL architecture (Q166–168)
- [ ] VACUUM, ANALYZE and autovacuum (Q169–173)
- [ ] EXPLAIN and query optimization (Q174–180)
- [ ] Transactions and ACID properties (Q181–182, 190–191)
- [ ] Isolation levels and concurrency (Q183–185)
- [ ] Locks and deadlocks (Q186–189, 192)
- [ ] JSON and JSONB (Q27–28, 193–194)
- [ ] GIN and full-text search (Q195, 198)
- [ ] Partitioning and inheritance (Q196–197)
- [x] Backup and restore (Q199)
- [ ] Security, roles and privileges (see bonus below)
- [ ] Replication and high availability (see bonus below)
- [ ] Monitoring and production troubleshooting (Q176, 200)

---

# Bonus: Topics in the checklist that have no numbered question

### Security, roles and privileges
```sql
CREATE ROLE report_user LOGIN PASSWORD 'StrongPass#1';     -- a role that can log in (a "user")
GRANT CONNECT ON DATABASE company_db TO report_user;
GRANT USAGE ON SCHEMA public TO report_user;
GRANT SELECT ON employees TO report_user;                  -- read-only access
REVOKE SELECT ON employees FROM report_user;               -- take it back
```
- A **role** can be a user or a group. 
- Other security points: `pg_hba.conf` (who may connect from where), SSL/TLS, **Row-Level Security** (`CREATE POLICY`), never use the `postgres` superuser in apps, least-privilege principle.

### Replication and high availability
- **Streaming (physical) replication**: a **standby** server copies the primary's WAL in real time. Standby can serve **read-only** queries and take over if the primary fails (**failover**).
- **Logical replication**: replicates selected tables (publish/subscribe); can work across versions.
- **Synchronous vs asynchronous**: synchronous waits for the standby to confirm (no data loss, slower); asynchronous doesn't (faster, tiny loss possible).
- Tools: **Patroni**, repmgr, pgBouncer, HAProxy.

---

# Important Interview Preparation Advice

1. **Understand, don't memorize.** Explain every concept in your own words with a small example.
2. **Practice on a real database daily.** Run each query in this file and change it to see what happens.
3. **Write the query, then explain it** out loud: "First I group by department, then I filter groups with HAVING..."
4. **Always mention edge cases:** NULLs, duplicates, ties (`RANK` vs `DENSE_RANK` vs `ROW_NUMBER`), empty tables.
5. **Know the classics cold:** Nth highest salary, duplicates, top N per group, JOIN types, `NOT IN` vs `NOT EXISTS`, `WHERE` vs `HAVING`, `DELETE` vs `TRUNCATE`.
6. **Be ready for "how would you make it faster?"** → `EXPLAIN ANALYZE`, indexes, rewrite, statistics.
7. **Use real examples from your projects** (even college ones) to show practical use.
8. **If you don't know, say how you'd find out** (`EXPLAIN`, docs, `pg_stat_*` views). Honest and logical beats guessing.
9. **Quick revision order for the night before:** Q42, 56, 60, 82, 90–92, 144, 151, 167, 169–170, 175, 182–185, 200 and the 20 practical queries.

Good luck with your placements! 🚀
