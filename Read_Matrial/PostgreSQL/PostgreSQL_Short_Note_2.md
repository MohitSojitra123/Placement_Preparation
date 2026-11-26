# PostgreSQL Interview Prep: All 200 Questions Answered (Simple Words + Examples)

Legend: 🟢 easy, 🟡 medium, 🔴 hard. T = Theory, P = Practical.

---

## 1. Fundamentals & Architecture (1-12)

**1. 🟢 What is PostgreSQL, and what makes it an object-relational database?**
PostgreSQL is a free, open-source database that stores data in tables (relational) and also supports "objects" like custom data types, inheritance, arrays, JSON and functions. That extra object support makes it *object-relational*.
Example: you can define your own type `CREATE TYPE address AS (city text, zip text);` and use it as a column, which a plain relational database cannot do.

**2. 🟢 Main differences between PostgreSQL and MySQL?**
- PostgreSQL has richer features: JSONB, arrays, window functions, CTEs, partial indexes, range types, extensions (PostGIS).
- PostgreSQL follows the SQL standard more strictly; MySQL is more lenient.
- PostgreSQL uses MVCC with one storage engine; MySQL has multiple engines (InnoDB, MyISAM).
- MySQL is often seen as simpler and fast for simple read-heavy apps; PostgreSQL is stronger for complex queries and data integrity.
Example: `CREATE INDEX ... WHERE active = true` (partial index) works in PostgreSQL, not in MySQL.

**3. 🟢 What does ACID stand for? How does PostgreSQL guarantee it?**
- **Atomicity**: all or nothing. **Consistency**: data always follows rules (constraints). **Isolation**: transactions don't disturb each other. **Durability**: once committed, data survives a crash.
- PostgreSQL uses the **WAL** (write-ahead log) for durability and atomicity, **MVCC** for isolation, and **constraints** for consistency.
Example: transfer money: debit A and credit B in one transaction. If the credit fails, the debit is rolled back.

**4. 🟢 What is a database cluster? How does it differ from a database?**
A *cluster* is one PostgreSQL server instance with one data directory (`PGDATA`). It contains many *databases*, plus shared things like roles and tablespaces.
Example: one cluster on port 5432 can hold databases `shop`, `hr`, and `analytics`.

**5. 🟢 What are schemas, and what is the default schema?**
A schema is a folder inside a database that groups tables, views, functions. The default is `public`.
Example: `CREATE SCHEMA sales; CREATE TABLE sales.orders(id int);` Two schemas can each have a table named `orders`.

**6. 🟡 Explain the process architecture.**
PostgreSQL uses many processes:
- **postmaster**: the main process; listens for connections and starts others.
- **backend**: one process per client connection that runs your queries.
- **checkpointer**: periodically writes dirty pages to disk.
- **bgwriter**: slowly writes dirty pages in the background to keep buffers free.
- **WAL writer**: flushes WAL records to disk.
- **autovacuum launcher**: starts workers that clean dead rows and update stats.
Example: run `SELECT pid, backend_type FROM pg_stat_activity;` to see them.

**7. 🟡 What is shared memory and `shared_buffers`?**
Shared memory is RAM that all processes use together. `shared_buffers` is the part used as PostgreSQL's data cache (table and index pages). A common starting value is about 25% of RAM.
Example: `ALTER SYSTEM SET shared_buffers = '8GB';` (needs restart).

**8. 🟡 What are tablespaces and when would you use them?**
A tablespace is a folder on disk where data files are stored. Use it to put busy tables on fast SSD and old data on cheap disks.
Example: `CREATE TABLESPACE fast LOCATION '/ssd/pgdata'; CREATE TABLE t(id int) TABLESPACE fast;`

**9. 🟡 What are OIDs, and what is `pg_catalog`?**
An OID is an internal number PostgreSQL gives to objects (tables, types, functions). `pg_catalog` is the schema holding system tables/views that describe everything in the database.
Example: `SELECT oid, relname FROM pg_class WHERE relname='employees';`

**10. 🟡 P: List all databases, schemas, and tables.**
```sql
SELECT datname FROM pg_database;                      -- databases
SELECT schema_name FROM information_schema.schemata;  -- schemas
SELECT table_schema, table_name
FROM information_schema.tables
WHERE table_schema NOT IN ('pg_catalog','information_schema');  -- tables
```

**11. 🔴 How does PostgreSQL store a row on disk (pages, tuples, TOAST)?**
Tables are split into **pages** (8 KB each). Each page holds **tuples** (rows) plus a header and an item-pointer array. A row has a header (xmin, xmax, etc.) and the data. If a value is too large (over ~2 KB), PostgreSQL moves it to a **TOAST** table, compresses or slices it, and keeps only a pointer in the main row.
Example: a 1 MB text column is stored in `pg_toast.pg_toast_<oid>`; the main row holds only a small reference.

**12. 🔴 Explain the life of a query.**
1. **Parser**: checks syntax, builds a parse tree.
2. **Rewriter**: applies rules (e.g., expands views).
3. **Planner/Optimizer**: picks the cheapest plan using statistics (which index, which join).
4. **Executor**: runs the plan and returns rows.
Example: `EXPLAIN SELECT * FROM v_active_users;` shows the view already expanded into its real tables by the rewriter.

---

## 2. psql & Basic Administration (13-20)

**13. 🟢 Connect with psql.**
`psql -h localhost -p 5432 -U postgres -d mydb`
Or with a URL: `psql postgresql://user:pass@host:5432/mydb`

**14. 🟢 Meta-commands to list tables, describe a table, list roles.**
- `\dt` list tables, `\d employees` describe a table, `\du` list roles, `\l` list databases, `\dn` schemas, `\q` quit.

**15. 🟢 Create and drop a database.**
```sql
CREATE DATABASE shop;
DROP DATABASE shop;      -- cannot drop the DB you are connected to
```
Shell: `createdb shop` / `dropdb shop`.

**16. 🟢 Run a .sql file from the command line.**
`psql -U postgres -d mydb -f script.sql` (inside psql: `\i script.sql`). Add `-v ON_ERROR_STOP=1` to stop at the first error.

**17. 🟡 Turn on timing and expanded output.**
In psql: `\timing` and `\x` (or `\x auto`). Each toggles on/off.

**18. 🟡 What is pg_hba.conf? What is postgresql.conf?**
- `pg_hba.conf`: decides **who** can connect, from **where**, to **which database**, and **how** they authenticate.
- `postgresql.conf`: main server settings (memory, logging, WAL, etc.).
Example line in pg_hba.conf: `host  mydb  appuser  10.0.0.0/24  scram-sha-256`

**19. 🟡 Reload configuration without restart.**
`SELECT pg_reload_conf();` or `pg_ctl reload` or `systemctl reload postgresql`.

**20. 🔴 Which parameters need restart vs reload?**
Check column `context` in `pg_settings`.
- **Restart needed** (`postmaster`): `shared_buffers`, `max_connections`, `wal_level`, `max_wal_senders`, `shared_preload_libraries`, `max_worker_processes`.
- **Reload only** (`sighup`): `work_mem`, `log_min_duration_statement`, `autovacuum_naptime`, `checkpoint_timeout`, `max_wal_size`.
Example: `SELECT name, context FROM pg_settings WHERE name IN ('shared_buffers','work_mem');`

---

## 3. Data Types (21-28)

**21. 🟢 Common types.**
- Numeric: `smallint, integer, bigint, numeric(p,s), real, double precision`
- Text: `char(n), varchar(n), text`
- Date/time: `date, time, timestamp, timestamptz, interval`
- Boolean: `boolean`
- Others: `uuid, json, jsonb, array, inet`

**22. 🟢 CHAR vs VARCHAR vs TEXT.**
- `CHAR(n)`: fixed length, padded with spaces. Rarely useful.
- `VARCHAR(n)`: variable, with a max length.
- `TEXT`: variable, no limit.
In PostgreSQL, all three perform about the same, so `TEXT` (with a CHECK if you need a limit) is common.

**23. 🟢 SERIAL vs IDENTITY.**
`SERIAL` is old shorthand that creates a sequence and a default. `GENERATED ... AS IDENTITY` is the SQL-standard way (PG 10+), cleaner ownership and permissions, and it can block manual values (`ALWAYS`).
```sql
CREATE TABLE t(id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY);
```

**24. 🟡 TIMESTAMP vs TIMESTAMPTZ.**
Use **TIMESTAMPTZ**. It stores an absolute moment (internally UTC) and shows it in the session time zone. Plain `timestamp` has no zone, so it causes bugs when servers or users are in different zones.

**25. 🟡 UUID and when better than integer keys.**
UUID is a 128-bit unique id. Better when ids are generated in many places (microservices, offline apps), when you don't want guessable ids in URLs, or when merging databases. Downside: bigger (16 bytes) and random UUIDs scatter index inserts (use UUIDv7/time-ordered if possible).
Example: `id uuid DEFAULT gen_random_uuid()`

**26. 🟡 ENUM types and drawbacks.**
An enum is a fixed list of allowed values: `CREATE TYPE mood AS ENUM ('sad','ok','happy');`
Drawbacks: you can add values but cannot easily remove or reorder them; harder to change than a lookup table with a foreign key.

**27. 🟡 P: Custom composite type in a table.**
```sql
CREATE TYPE address AS (street text, city text, zip text);
CREATE TABLE customers(id serial PRIMARY KEY, name text, addr address);
INSERT INTO customers(name, addr) VALUES ('Ravi', ROW('MG Road','Pune','411001'));
SELECT (addr).city FROM customers;
```

**28. 🔴 NUMERIC vs FLOAT for money? Range types?**
FLOAT is approximate (binary), so `0.1 + 0.2` gives `0.30000000000000004`. NUMERIC is exact, so it is right for money. Cost: slower.
**Range types** store a span in one value: `int4range, numrange, daterange, tstzrange`.
Example: `SELECT daterange('2026-01-01','2026-01-10') @> DATE '2026-01-05';` returns true.

---

## 4. DDL & Constraints (29-40)

**29. 🟢 P: Create employees.**
```sql
CREATE TABLE employees(
  id serial PRIMARY KEY,
  name text NOT NULL,
  email text UNIQUE,
  salary numeric(10,2),
  hire_date date DEFAULT current_date
);
```

**30. 🟢 P: Add, rename, drop a column.**
```sql
ALTER TABLE employees ADD COLUMN phone text;
ALTER TABLE employees RENAME COLUMN phone TO mobile;
ALTER TABLE employees DROP COLUMN mobile;
```

**31. 🟢 DROP vs DELETE vs TRUNCATE.**
- `DROP TABLE`: removes the table itself (structure + data).
- `DELETE`: removes selected rows; can use WHERE; slow for large tables; fires row triggers; rollbackable.
- `TRUNCATE`: removes all rows quickly, keeps structure; also transactional in PostgreSQL; takes a strong lock.

**32. 🟢 PRIMARY KEY, UNIQUE, NOT NULL, CHECK.**
- PRIMARY KEY: unique + not null; one per table.
- UNIQUE: no duplicates (many allowed per table).
- NOT NULL: value required.
- CHECK: custom rule, e.g. `CHECK (age >= 18)`.

**33. 🟢 Foreign key and ON DELETE options.**
A foreign key links a column to another table's key.
- `CASCADE`: deleting parent deletes children.
- `SET NULL`: child's column becomes NULL.
- `RESTRICT`: block deleting the parent if children exist.
```sql
CREATE TABLE orders(id serial PRIMARY KEY,
  emp_id int REFERENCES employees(id) ON DELETE CASCADE);
```

**34. 🟡 P: CHECK salary > 0.**
`ALTER TABLE employees ADD CONSTRAINT salary_positive CHECK (salary > 0);`

**35. 🟡 Can UNIQUE hold multiple NULLs? Why?**
Yes. NULL means "unknown", and two unknowns are not considered equal, so they don't conflict. (PG 15+: `UNIQUE NULLS NOT DISTINCT` changes this.)

**36. 🟡 P: Composite primary key.**
```sql
CREATE TABLE enrollment(student_id int, course_id int, PRIMARY KEY (student_id, course_id));
```

**37. 🟡 Deferrable constraints.**
They are checked at COMMIT instead of after every statement. Useful for swapping unique values or inserting circular references.
```sql
ALTER TABLE t ADD CONSTRAINT fk FOREIGN KEY (p) REFERENCES t2(id) DEFERRABLE INITIALLY DEFERRED;
```

**38. 🟡 Exclusion constraint and use case.**
Like UNIQUE but with any operator: "no two rows may *overlap*". Use case: room booking without double booking.
```sql
CREATE EXTENSION btree_gist;
CREATE TABLE booking(room int, during tstzrange,
  EXCLUDE USING gist (room WITH =, during WITH &&));
```

**39. 🔴 Which ALTER TABLE rewrites the table? Safe default on huge table?**
Rewrites: changing a column type (many cases), adding a column with a *volatile* default (e.g., `random()`) and, before PG 11, any default.
Since PG 11, `ADD COLUMN x int DEFAULT 5` (constant default) is instant (metadata only). For older versions or volatile defaults: add the column with no default, backfill in small batches, then `SET DEFAULT` and `SET NOT NULL` (add `CHECK (x IS NOT NULL) NOT VALID` then `VALIDATE` first to avoid long locks).

**40. 🔴 P: Add a foreign key on a large live table with minimal locking.**
```sql
ALTER TABLE orders ADD CONSTRAINT fk_cust
  FOREIGN KEY (cust_id) REFERENCES customers(id) NOT VALID;   -- quick, no full scan
ALTER TABLE orders VALIDATE CONSTRAINT fk_cust;               -- scans, but only a light lock
```
`NOT VALID` applies the rule to new rows only; `VALIDATE` checks old rows without blocking writes.

---
## 5. DML & Basic Querying (41-52)

**41. 🟢 P: Insert one row and many rows.**
```sql
INSERT INTO employees(name,email,salary) VALUES ('Asha','asha@x.com',50000);
INSERT INTO employees(name,email,salary) VALUES
 ('Ravi','ravi@x.com',60000),('Meena','meena@x.com',55000);
```

**42. 🟢 P: Raise salaries 10% for a department.**
`UPDATE employees SET salary = salary * 1.10 WHERE dept_id = 3;`

**43. 🟢 P: Delete rows older than a date.**
`DELETE FROM logs WHERE created_at < '2025-01-01';`

**44. 🟢 P: Top 5 highest paid.**
`SELECT name, salary FROM employees ORDER BY salary DESC LIMIT 5;`

**45. 🟢 WHERE vs HAVING.**
`WHERE` filters rows *before* grouping. `HAVING` filters groups *after* aggregation.
```sql
SELECT dept_id, avg(salary) FROM employees
WHERE active = true GROUP BY dept_id HAVING avg(salary) > 50000;
```

**46. 🟢 P: LIKE, ILIKE, IN, BETWEEN, IS NULL.**
```sql
SELECT * FROM employees
WHERE name LIKE 'A%'            -- starts with A (case-sensitive)
  AND email ILIKE '%@GMAIL.com' -- case-insensitive
  AND dept_id IN (1,2,3)
  AND salary BETWEEN 40000 AND 80000
  AND manager_id IS NULL;
```

**47. 🟡 P: Upsert.**
```sql
INSERT INTO employees(email, name, salary) VALUES ('asha@x.com','Asha',70000)
ON CONFLICT (email) DO UPDATE SET salary = EXCLUDED.salary;
```
`EXCLUDED` is the row you tried to insert. Use `DO NOTHING` to skip.

**48. 🟡 P: RETURNING.**
```sql
INSERT INTO employees(name,email) VALUES ('Tia','t@x.com') RETURNING id;
UPDATE employees SET salary = salary+1000 WHERE id=1 RETURNING id, salary;
DELETE FROM employees WHERE id=2 RETURNING *;
```

**49. 🟡 P: Copy a CSV into a table.**
```sql
COPY employees(name,email,salary) FROM '/data/emp.csv' CSV HEADER;   -- server file
\copy employees(name,email,salary) FROM 'emp.csv' CSV HEADER          -- client file (psql)
```

**50. 🟡 COPY vs \copy.**
`COPY` runs on the **server**, reads files on the server, and needs superuser or `pg_read_server_files`. `\copy` is a psql command that reads the file on **your computer** and sends it to the server, so it needs only normal table permissions.

**51. 🔴 P: MERGE (PG 15+). Difference from ON CONFLICT?**
```sql
MERGE INTO stock s
USING incoming i ON s.item = i.item
WHEN MATCHED AND i.qty = 0 THEN DELETE
WHEN MATCHED THEN UPDATE SET qty = s.qty + i.qty
WHEN NOT MATCHED THEN INSERT (item, qty) VALUES (i.item, i.qty);
```
MERGE can do INSERT, UPDATE and DELETE with any join condition. `ON CONFLICT` only handles insert-or-update based on a unique index and is safer under heavy concurrency (atomic; MERGE can raise unique-violation errors in races).

**52. 🔴 P: Efficient pagination.**
OFFSET gets slower with depth because it reads and discards rows:
`SELECT * FROM posts ORDER BY id LIMIT 20 OFFSET 1000000;` (slow)
**Keyset** pagination remembers the last seen key:
`SELECT * FROM posts WHERE id > 1000020 ORDER BY id LIMIT 20;` (fast, uses index)
For multi-column sorts: `WHERE (created_at, id) > ('2026-01-01', 500) ORDER BY created_at, id LIMIT 20`.

---

## 6. Joins, Subqueries & Set Operations (53-62)

**53. 🟢 INNER, LEFT, RIGHT, FULL, CROSS JOIN.**
- INNER: only matching rows from both.
- LEFT: all left rows + matches (NULL if none).
- RIGHT: all right rows + matches.
- FULL: all rows from both sides.
- CROSS: every left row with every right row (Cartesian product).
Example: `SELECT e.name, d.name FROM employees e LEFT JOIN departments d ON d.id = e.dept_id;`

**54. 🟢 P: Employees with no department.**
```sql
SELECT e.* FROM employees e
LEFT JOIN departments d ON d.id = e.dept_id
WHERE d.id IS NULL;
```

**55. 🟢 Self join.**
A table joined to itself. Example: employee and their manager:
```sql
SELECT e.name AS employee, m.name AS manager
FROM employees e LEFT JOIN employees m ON m.id = e.manager_id;
```

**56. 🟡 P: Second highest salary, 3 ways.**
```sql
-- 1) OFFSET
SELECT DISTINCT salary FROM employees ORDER BY salary DESC LIMIT 1 OFFSET 1;
-- 2) Subquery
SELECT max(salary) FROM employees WHERE salary < (SELECT max(salary) FROM employees);
-- 3) Window function
SELECT salary FROM (SELECT salary, dense_rank() OVER (ORDER BY salary DESC) r
                    FROM employees) t WHERE r = 2 LIMIT 1;
```

**57. 🟡 IN vs EXISTS vs ANY.**
- `IN (list/subquery)`: value matches any in the set.
- `EXISTS (subquery)`: true if the subquery returns at least one row; stops at first match; handles NULLs safely.
- `= ANY (array/subquery)`: same as IN, but works with arrays and any operator (`> ANY`).
Example: `WHERE id = ANY(ARRAY[1,2,3])`.

**58. 🟡 UNION vs UNION ALL, INTERSECT, EXCEPT.**
- `UNION`: combine and remove duplicates (slower).
- `UNION ALL`: combine and keep duplicates (faster).
- `INTERSECT`: rows in both.
- `EXCEPT`: rows in the first but not the second.

**59. 🟡 Correlated subquery and rewrite.**
A subquery that uses a column from the outer query, so it runs once per outer row.
```sql
SELECT name FROM employees e
WHERE salary > (SELECT avg(salary) FROM employees WHERE dept_id = e.dept_id);
```
Rewrite with a join to a pre-aggregated table:
```sql
SELECT e.name FROM employees e
JOIN (SELECT dept_id, avg(salary) a FROM employees GROUP BY dept_id) d USING (dept_id)
WHERE e.salary > d.a;
```

**60. 🔴 LATERAL join: top 3 orders per customer.**
`LATERAL` lets the right side reference columns from the left side (like a for-each loop).
```sql
SELECT c.id, o.*
FROM customers c
CROSS JOIN LATERAL (
  SELECT * FROM orders WHERE customer_id = c.id
  ORDER BY created_at DESC LIMIT 3
) o;
```

**61. 🔴 Why does NOT IN misbehave with NULLs?**
`x NOT IN (1, 2, NULL)` becomes `x<>1 AND x<>2 AND x<>NULL`; the last part is UNKNOWN, so the result is never true and you get zero rows. Use `NOT EXISTS` instead:
`SELECT * FROM a WHERE NOT EXISTS (SELECT 1 FROM b WHERE b.id = a.id);`

**62. 🔴 Nested loop, hash, merge join.**
- **Nested loop**: for each outer row, look up inner rows. Best for small outer set + indexed inner.
- **Hash join**: build a hash table of the smaller table, probe with the larger. Best for large unsorted sets with equality joins.
- **Merge join**: sort both sides and walk them together. Best when both are already sorted (e.g., by index) or very large.
The planner chooses by estimated cost using table size, statistics, indexes, and `work_mem`.

---

## 7. Aggregates, GROUP BY, CTEs (63-72)

**63. 🟢 P: Aggregates with GROUP BY.**
```sql
SELECT dept_id, count(*), sum(salary), avg(salary), min(salary), max(salary)
FROM employees GROUP BY dept_id;
```

**64. 🟢 COUNT(*) vs COUNT(col) vs COUNT(DISTINCT col).**
- `COUNT(*)`: all rows.
- `COUNT(col)`: rows where col is NOT NULL.
- `COUNT(DISTINCT col)`: number of unique non-null values.
Example: values (1, 1, NULL) give 3, 2, 1.

**65. 🟡 P: Duplicate emails.**
`SELECT email, count(*) FROM users GROUP BY email HAVING count(*) > 1;`

**66. 🟡 P: Delete duplicates but keep one.**
```sql
DELETE FROM users a USING users b
WHERE a.email = b.email AND a.id > b.id;   -- keeps the smallest id
```
Or with `ctid`: `DELETE FROM users WHERE ctid NOT IN (SELECT min(ctid) FROM users GROUP BY email);`

**67. 🟡 P: GROUPING SETS, ROLLUP, CUBE.**
```sql
SELECT region, product, sum(amount) FROM sales GROUP BY GROUPING SETS ((region),(product),());
SELECT region, product, sum(amount) FROM sales GROUP BY ROLLUP (region, product);  -- subtotals + grand total
SELECT region, product, sum(amount) FROM sales GROUP BY CUBE (region, product);    -- all combinations
```

**68. 🟡 P: FILTER.**
```sql
SELECT count(*) AS total,
       count(*) FILTER (WHERE status='paid') AS paid,
       sum(amount) FILTER (WHERE status='refund') AS refunds
FROM orders;
```

**69. 🟡 What is a CTE? Optimization fences?**
A CTE (`WITH name AS (...)`) is a named temporary result used inside one query, for readability.
Before PG 12 they were always *materialized* (computed once, acting as a fence that blocks optimization). From PG 12, simple non-recursive CTEs used once are inlined, so no fence by default.

**70. 🟡 P: string_agg and array_agg.**
```sql
SELECT dept_id, string_agg(name, ', ' ORDER BY name) FROM employees GROUP BY dept_id;
SELECT dept_id, array_agg(id) FROM employees GROUP BY dept_id;
```

**71. 🔴 P: Recursive CTE for hierarchy.**
```sql
WITH RECURSIVE tree AS (
  SELECT id, name, manager_id, 1 AS level FROM employees WHERE manager_id IS NULL
  UNION ALL
  SELECT e.id, e.name, e.manager_id, t.level + 1
  FROM employees e JOIN tree t ON e.manager_id = t.id
)
SELECT * FROM tree ORDER BY level;
```

**72. 🔴 MATERIALIZED vs NOT MATERIALIZED CTE.**
`WITH x AS MATERIALIZED (...)`: compute once and store; use when the CTE is expensive and reused several times, or to force a fence.
`WITH x AS NOT MATERIALIZED (...)`: inline into the main query so the planner can push filters and use indexes.

---

## 8. Window Functions (73-80)

**73. 🟡 What are window functions? vs GROUP BY?**
They calculate over a set of related rows but **keep every row** in the output. GROUP BY collapses rows into one per group.
Example: `SELECT name, salary, avg(salary) OVER (PARTITION BY dept_id) FROM employees;` shows each employee and their department average.

**74. 🟡 P: Rank by salary within department.**
```sql
SELECT name, dept_id, salary,
       rank() OVER (PARTITION BY dept_id ORDER BY salary DESC) AS rnk
FROM employees;
```

**75. 🟡 ROW_NUMBER vs RANK vs DENSE_RANK.**
For salaries 100, 100, 90:
- ROW_NUMBER: 1, 2, 3 (always unique)
- RANK: 1, 1, 3 (ties share, then gap)
- DENSE_RANK: 1, 1, 2 (ties share, no gap)

**76. 🟡 P: LAG and LEAD for month-over-month change.**
```sql
SELECT month, revenue,
       revenue - lag(revenue) OVER (ORDER BY month) AS change,
       lead(revenue) OVER (ORDER BY month) AS next_month
FROM monthly_sales;
```

**77. 🟡 P: Running total.**
`SELECT day, amount, sum(amount) OVER (ORDER BY day) AS running_total FROM payments;`

**78. 🔴 Frame clauses: ROWS vs RANGE vs GROUPS.**
The frame is the set of rows around the current row used by the function.
- `ROWS`: counts physical rows: `ROWS BETWEEN 2 PRECEDING AND CURRENT ROW`.
- `RANGE`: uses value distance; rows with the same ORDER BY value (peers) are included together: `RANGE BETWEEN INTERVAL '7 days' PRECEDING AND CURRENT ROW`.
- `GROUPS`: counts groups of peer rows (PG 11+).
Default frame with ORDER BY is `RANGE UNBOUNDED PRECEDING TO CURRENT ROW`, which is why tied rows get the same running total.

**79. 🔴 P: Longest consecutive-day login streak per user.**
"Gaps and islands" trick: subtract a row number from the date; consecutive days give the same result.
```sql
WITH d AS (SELECT DISTINCT user_id, login_date::date AS dt FROM logins),
g AS (SELECT user_id, dt,
        dt - (row_number() OVER (PARTITION BY user_id ORDER BY dt))::int AS grp FROM d)
SELECT user_id, max(streak) AS longest FROM (
  SELECT user_id, grp, count(*) AS streak FROM g GROUP BY user_id, grp) s
GROUP BY user_id;
```

**80. 🔴 P: 7-day moving average.**
```sql
SELECT day, avg(amount) OVER (ORDER BY day ROWS BETWEEN 6 PRECEDING AND CURRENT ROW) AS ma7
FROM daily_sales;
```
(Use `RANGE BETWEEN INTERVAL '6 days' PRECEDING AND CURRENT ROW` if days can be missing.)

---

## 9. Indexes (81-94)

**81. 🟢 What is an index? Why can too many hurt?**
An index is a sorted lookup structure, like a book's index, that finds rows without scanning the whole table. Too many indexes slow INSERT/UPDATE/DELETE (each must update every index), use disk space, and add vacuum work.

**82. 🟢 P: Single and multi-column index.**
```sql
CREATE INDEX idx_emp_email ON employees(email);
CREATE INDEX idx_emp_dept_sal ON employees(dept_id, salary);
```

**83. 🟢 Default index type?**
B-tree.

**84. 🟡 Compare B-tree, Hash, GIN, GiST, SP-GiST, BRIN.**
- **B-tree**: general purpose; `=, <, >, BETWEEN`, sorting.
- **Hash**: only `=`; rarely needed.
- **GIN**: "many values per row": JSONB, arrays, full-text.
- **GiST**: geometric, ranges, nearest-neighbor, exclusion constraints.
- **SP-GiST**: partitioned search trees, e.g., IP addresses, phone prefixes.
- **BRIN**: tiny index for huge tables whose data is naturally ordered (e.g., time-series).

**85. 🟡 Composite index and column order.**
An index on several columns. Order matters: `(dept_id, salary)` helps queries filtering on `dept_id` or on `dept_id AND salary`, but not on `salary` alone (leftmost-prefix rule). Put equality columns first, range column last.

**86. 🟡 P: Partial and expression index.**
```sql
CREATE INDEX idx_active ON users(email) WHERE active = true;     -- partial: smaller
CREATE INDEX idx_lower_email ON users (lower(email));            -- expression
-- query must match: WHERE lower(email) = 'a@x.com'
```

**87. 🟡 Covering index (INCLUDE) and index-only scan.**
`CREATE INDEX idx ON orders(customer_id) INCLUDE (total);`
The index holds `total` too, so `SELECT total FROM orders WHERE customer_id=5` can be answered from the index alone (**index-only scan**) without visiting the table (works best when the visibility map is up to date after vacuum).

**88. 🟡 P: Create an index without blocking writes.**
`CREATE INDEX CONCURRENTLY idx_name ON orders(created_at);`
Slower, cannot run inside a transaction block, and if it fails it leaves an INVALID index that you must drop.

**89. 🟡 When will PostgreSQL ignore an index?**
- Table is small or query returns a large part of it (seq scan is cheaper).
- Function/cast on the column: `WHERE lower(email)=...` without an expression index.
- Type mismatch or leading wildcard `LIKE '%abc'`.
- Stale statistics (run ANALYZE).
- Wrong column order in a composite index.
- `random_page_cost` set too high for SSDs.

**90. 🟡 Unique indexes vs unique constraints.**
A unique constraint is implemented by a unique index; behavior is the same. Constraints are visible in table definition and can be used by foreign keys. Only unique *indexes* can be partial or on expressions.
Example: `CREATE UNIQUE INDEX ON users(email) WHERE deleted_at IS NULL;`

**91. 🔴 Index bloat: detect and fix.**
Bloat = index pages with lots of dead or empty space after many updates/deletes. Detect with `pgstattuple` (`pgstatindex('idx')` shows `avg_leaf_density`) or bloat-estimate queries. Fix: `REINDEX INDEX CONCURRENTLY idx_name;` (PG 12+), which rebuilds without blocking writes.

**92. 🔴 B-tree page splits and fillfactor.**
When a leaf page is full and a new key must go in, PostgreSQL splits it into two pages, which adds I/O and fragmentation. `fillfactor` (default 90 for indexes, 100 for tables) leaves free space on each page so there are fewer splits. Lower it for update-heavy data: `CREATE INDEX ... WITH (fillfactor = 70);`

**93. 🔴 P: Find unused and duplicate indexes.**
```sql
-- Unused
SELECT relname, indexrelname, idx_scan FROM pg_stat_user_indexes
WHERE idx_scan = 0 ORDER BY pg_relation_size(indexrelid) DESC;
-- Duplicates (same table, same columns)
SELECT indrelid::regclass, array_agg(indexrelid::regclass)
FROM pg_index GROUP BY indrelid, indkey HAVING count(*) > 1;
```
Don't drop unique/PK indexes even if unused.

**94. 🔴 BRIN vs B-tree; physical correlation.**
BRIN stores only min/max per block range, so it is tiny (KBs instead of GBs). It works when column values are in the same order as the physical rows (high **correlation**, e.g., an ever-increasing timestamp in an append-only table). If rows are scattered randomly, BRIN can't skip blocks and becomes useless. Check `SELECT correlation FROM pg_stats WHERE tablename='logs' AND attname='created_at';` (close to 1 or -1 is good).
```sql
CREATE INDEX ON logs USING brin (created_at);
```

---
## 10. EXPLAIN & Performance Tuning (95-106)

**95. 🟡 P: How do you read EXPLAIN output?**
Read from the **innermost/most indented node** outward. Each node shows `cost=startup..total`, `rows` (estimate), `width`. Lower cost is better.
```
EXPLAIN SELECT * FROM orders WHERE customer_id = 5;
Index Scan using idx_cust on orders  (cost=0.43..8.45 rows=1 width=64)
  Index Cond: (customer_id = 5)
```
Look for: Seq Scan on big tables, big gaps between estimated and actual rows, expensive Sort/Hash nodes.

**96. 🟡 EXPLAIN vs EXPLAIN ANALYZE.**
`EXPLAIN` only **shows the plan** (estimates) and does not run the query. `EXPLAIN ANALYZE` **runs it** and adds actual time and actual rows. For INSERT/UPDATE/DELETE, wrap it: `BEGIN; EXPLAIN ANALYZE UPDATE ...; ROLLBACK;`. Add `BUFFERS` to see I/O: `EXPLAIN (ANALYZE, BUFFERS) ...`.

**97. 🟡 Seq Scan, Index Scan, Bitmap Scan, Index Only Scan.**
- **Seq Scan**: reads the whole table. Good when many rows are needed.
- **Index Scan**: walks the index, then fetches each row. Good for few rows.
- **Bitmap Scan**: collects matching row locations from the index, sorts them by page, then reads pages once. Good for a medium number of rows or combining indexes.
- **Index Only Scan**: answers from the index alone, no table visit.

**98. 🟡 Planner statistics and what ANALYZE does.**
Statistics are numbers about your data (row counts, most common values, histograms, null fraction, correlation) stored in `pg_statistic` / `pg_stats`. The planner uses them to estimate costs. `ANALYZE table;` samples the table and refreshes them. Run it after big loads.

**99. 🟡 P: Find slowest queries with pg_stat_statements.**
Add `shared_preload_libraries = 'pg_stat_statements'`, restart, then `CREATE EXTENSION pg_stat_statements;`
```sql
SELECT query, calls, total_exec_time, mean_exec_time, rows
FROM pg_stat_statements ORDER BY total_exec_time DESC LIMIT 10;
```
(Older versions use `total_time`.)

**100. 🟡 work_mem and sort spills.**
`work_mem` is memory per sort/hash operation (per node, per query, not per server). If a sort needs more, PostgreSQL writes temp files to disk ("Sort Method: external merge Disk: 50000kB"), which is much slower. Fix by raising `work_mem` for that session: `SET work_mem='256MB';`. Be careful: many connections × many nodes can exhaust RAM.

**101. 🔴 random_page_cost and effective_cache_size.**
- `random_page_cost` (default 4): how expensive a random disk read is compared with a sequential read. On SSDs set about 1.1 so index scans are favored.
- `effective_cache_size`: planner's guess of how much data is cached by PostgreSQL plus the OS (often 50-75% of RAM). Higher value makes index scans look cheaper. It does not allocate memory.

**102. 🔴 Fix bad row-count estimates.**
- `ANALYZE` the table.
- Raise detail: `ALTER TABLE t ALTER COLUMN c SET STATISTICS 500;` (default `default_statistics_target` is 100).
- For correlated columns, use **extended statistics**:
```sql
CREATE STATISTICS s1 (dependencies) ON city, zip FROM addresses;
ANALYZE addresses;
```
Example problem: planner thinks `city='Pune' AND zip='411001'` returns 1 row because it multiplies probabilities, but really it returns thousands.

**103. 🔴 P: Query slow only for certain parameters (generic vs custom plans).**
Steps: (1) get the real parameter values from logs; (2) run `EXPLAIN (ANALYZE, BUFFERS)` with those values; (3) compare with the plan for fast values; (4) check data skew in `pg_stats`.
Prepared statements use a **custom plan** for the first 5 runs, then may switch to a **generic plan** (one plan for all values), which can be bad for skewed data. Fix: `SET plan_cache_mode = force_custom_plan;` or improve statistics.

**104. 🔴 JIT compilation. When to disable?**
JIT (PG 11+) compiles parts of a query to machine code to speed up big CPU-heavy queries. For short OLTP queries the compile time (tens of ms) can cost more than it saves. Disable with `SET jit = off;` or raise `jit_above_cost` if you see "JIT: Timing" dominating `EXPLAIN ANALYZE`.

**105. 🔴 Parallel queries and settings.**
PostgreSQL can use several worker processes for one query (parallel seq scan, joins, aggregates). Settings: `max_parallel_workers_per_gather`, `max_parallel_workers`, `max_worker_processes`, `parallel_setup_cost`, `min_parallel_table_scan_size`. Look for `Gather` / `Parallel Seq Scan` in the plan.

**106. 🔴 P: Rewrite slow query with NOT EXISTS anti-join.**
Before (slow with NOT IN):
```sql
EXPLAIN ANALYZE SELECT * FROM customers
WHERE id NOT IN (SELECT customer_id FROM orders);
-- plan: Seq Scan with "SubPlan" / hashed SubPlan, can be very slow, wrong with NULLs
```
After:
```sql
EXPLAIN ANALYZE SELECT c.* FROM customers c
WHERE NOT EXISTS (SELECT 1 FROM orders o WHERE o.customer_id = c.id);
-- plan: Hash Anti Join (or Nested Loop Anti Join with index) , much faster
```
Add an index on `orders(customer_id)` for best results.

---

## 11. Transactions, MVCC & Locking (107-120)

**107. 🟢 P: BEGIN, COMMIT, ROLLBACK.**
```sql
BEGIN;
UPDATE accounts SET bal = bal - 500 WHERE id = 1;
UPDATE accounts SET bal = bal + 500 WHERE id = 2;
COMMIT;      -- or ROLLBACK; to undo everything
```

**108. 🟢 SAVEPOINT.**
A marker inside a transaction so you can roll back part of it.
```sql
BEGIN;
INSERT INTO t VALUES (1);
SAVEPOINT sp1;
INSERT INTO t VALUES (2);
ROLLBACK TO sp1;   -- undoes only the second insert
COMMIT;            -- row 1 is saved
```

**109. 🟡 MVCC; xmin and xmax.**
MVCC (Multi-Version Concurrency Control) keeps several versions of a row so readers don't block writers. Each row version has `xmin` (transaction id that created it) and `xmax` (transaction id that deleted/updated it, 0 if none). A transaction sees a version only if its snapshot says xmin is committed and xmax is not.
Example: `SELECT xmin, xmax, * FROM employees;` An UPDATE creates a new version and marks the old one with xmax.

**110. 🟡 Isolation levels. Default?**
`READ UNCOMMITTED` (acts like READ COMMITTED), `READ COMMITTED` (**default**), `REPEATABLE READ`, `SERIALIZABLE`.
Set: `BEGIN ISOLATION LEVEL REPEATABLE READ;`

**111. 🟡 Dirty, non-repeatable, phantom reads.**
- **Dirty read**: seeing another transaction's uncommitted data.
- **Non-repeatable read**: reading the same row twice and getting different values because someone committed a change between.
- **Phantom read**: running the same query twice and getting different *sets of rows* because someone inserted/deleted matching rows.
PostgreSQL: READ COMMITTED allows the last two; REPEATABLE READ prevents all three (snapshot); dirty reads never happen.

**112. 🟡 Does PostgreSQL support READ UNCOMMITTED?**
You can request it, but it behaves exactly like READ COMMITTED. Dirty reads are never allowed.

**113. 🟡 P: FOR UPDATE, SKIP LOCKED, NOWAIT.**
```sql
SELECT * FROM jobs WHERE status='new' ORDER BY id LIMIT 1 FOR UPDATE SKIP LOCKED;  -- queue workers
SELECT * FROM accounts WHERE id=1 FOR UPDATE NOWAIT;  -- error immediately if locked
```
`FOR UPDATE` locks the selected rows until the transaction ends. `SKIP LOCKED` skips rows others locked. `NOWAIT` fails instead of waiting.

**114. 🟡 Row-level, table-level, advisory locks.**
- **Row-level**: lock specific rows (`FOR UPDATE`, `FOR SHARE`); taken automatically by UPDATE/DELETE.
- **Table-level**: whole table, with modes from `ACCESS SHARE` (SELECT) up to `ACCESS EXCLUSIVE` (DROP, ALTER, TRUNCATE).
- **Advisory locks**: app-defined locks on any number you choose: `SELECT pg_advisory_lock(42);` ... `pg_advisory_unlock(42);`. Good for "only one job runs at a time".

**115. 🟡 P: Find blocking and blocked queries.**
```sql
SELECT pid, pg_blocking_pids(pid) AS blocked_by, state, wait_event_type, query
FROM pg_stat_activity
WHERE cardinality(pg_blocking_pids(pid)) > 0;
```

**116. 🟡 P: Cancel vs terminate.**
`SELECT pg_cancel_backend(pid);` stops the current query only; the connection stays.
`SELECT pg_terminate_backend(pid);` kills the whole connection (rolls back its transaction).

**117. 🔴 Deadlock: detect and prevent.**
Two transactions each wait for a lock the other holds. PostgreSQL checks after `deadlock_timeout` (1 s), picks one victim, and aborts it with "deadlock detected".
Prevent: always lock rows/tables in the **same order**, keep transactions short, use `SELECT ... FOR UPDATE` upfront, and retry on failure.
Example: T1 updates row A then B; T2 updates B then A. Fix: both update A then B.

**118. 🔴 SSI and serialization failures.**
`SERIALIZABLE` in PostgreSQL uses Serializable Snapshot Isolation: transactions run on snapshots and PostgreSQL tracks read/write dependencies. If it finds a pattern that could give a result not possible in any serial order, it aborts one with error `40001 serialization_failure`. Your app must **retry** the transaction.

**119. 🔴 Transaction ID wraparound.**
Transaction ids are 32-bit (about 4 billion). Because they are compared circularly, very old rows would suddenly look "in the future" and vanish. VACUUM **freezes** old rows to prevent this. If a database gets within ~3 million of the limit, PostgreSQL stops accepting writes. Prevent by letting autovacuum run, avoiding long transactions and abandoned replication slots, and monitoring `age(datfrozenxid)`:
`SELECT datname, age(datfrozenxid) FROM pg_database ORDER BY 2 DESC;`

**120. 🔴 "Idle in transaction": why dangerous?**
A session ran `BEGIN` and then did nothing. It holds locks and a snapshot, so it blocks others, stops VACUUM from removing dead rows (causing bloat), and can hold back wraparound freezing. Fix: set `idle_in_transaction_session_timeout = '5min'` and fix the app that forgets to commit.

---

## 12. VACUUM & Maintenance (121-128)

**121. 🟢 Why does PostgreSQL need VACUUM?**
Because of MVCC, UPDATE and DELETE leave old row versions (dead tuples) behind. VACUUM marks that space reusable, updates the visibility map, and freezes old transaction ids. Without it tables bloat and eventually hit wraparound.

**122. 🟡 VACUUM vs VACUUM FULL vs ANALYZE.**
- `VACUUM`: reclaims dead space for reuse inside the table; no heavy lock; file usually doesn't shrink.
- `VACUUM FULL`: rewrites the whole table into a new file, returning space to the OS; takes an **ACCESS EXCLUSIVE lock** (blocks everything).
- `ANALYZE`: only updates statistics. (`VACUUM ANALYZE` does both.)

**123. 🟡 Autovacuum and its parameters.**
A background service that automatically runs VACUUM and ANALYZE. It triggers when dead tuples > `autovacuum_vacuum_threshold + autovacuum_vacuum_scale_factor × rows` (defaults: 50 + 0.2 × rows). Other settings: `autovacuum_max_workers`, `autovacuum_naptime`, `autovacuum_vacuum_cost_limit`, `autovacuum_analyze_scale_factor`.

**124. 🟡 Dead tuples and how to check.**
Old row versions no longer visible to any transaction.
```sql
SELECT relname, n_live_tup, n_dead_tup, last_autovacuum
FROM pg_stat_user_tables ORDER BY n_dead_tup DESC;
```

**125. 🟡 Table bloat and how to measure.**
Bloat is wasted space in a table (dead tuples and free space) making it bigger and slower. Measure with the `pgstattuple` extension: `SELECT * FROM pgstattuple('orders');` (look at `dead_tuple_percent`, `free_percent`), or with bloat-estimation queries. Fix with `VACUUM`, `pg_repack` (online), or `VACUUM FULL` (with downtime).

**126. 🔴 P: Tune autovacuum for a huge write-heavy table.**
The default 20% scale factor is too large for huge tables (200 million dead rows before triggering). Set per table:
```sql
ALTER TABLE events SET (
  autovacuum_vacuum_scale_factor = 0.01,
  autovacuum_vacuum_threshold = 10000,
  autovacuum_analyze_scale_factor = 0.005,
  autovacuum_vacuum_cost_limit = 2000);
```
Also raise `maintenance_work_mem`, `autovacuum_max_workers`, monitor with `pg_stat_progress_vacuum`, and avoid long transactions that block cleanup.

**127. 🔴 HOT update and fillfactor.**
HOT (Heap-Only Tuple): if an UPDATE changes no indexed column and the new row version fits on the **same page**, PostgreSQL doesn't touch the indexes at all, which is faster and creates less bloat. Setting `fillfactor = 80` on update-heavy tables leaves room on each page for new versions: `ALTER TABLE t SET (fillfactor = 80);`. Check `n_tup_hot_upd` in `pg_stat_user_tables`.

**128. 🔴 Visibility map and freeze map.**
The **visibility map** has 1 bit per page saying "all rows here are visible to everyone." VACUUM can skip such pages and index-only scans can avoid table visits. The **freeze map** bit says "all rows are already frozen", so anti-wraparound vacuum can skip those pages. Both are stored in `_vm` files.

---

## 13. Functions, Procedures, PL/pgSQL, Triggers, Views (129-144)

**129. 🟢 View vs materialized view.**
A **view** is a saved query; it runs each time you select from it, and stores no data. A **materialized view** stores the query result on disk, so it is fast to read but gets stale until refreshed.

**130. 🟢 P: Create view and materialized view; refresh.**
```sql
CREATE VIEW v_high_paid AS SELECT * FROM employees WHERE salary > 80000;
CREATE MATERIALIZED VIEW mv_dept_sales AS
  SELECT dept_id, sum(amount) total FROM sales GROUP BY dept_id;
REFRESH MATERIALIZED VIEW mv_dept_sales;
```

**131. 🟡 P: Simple PL/pgSQL function.**
```sql
CREATE FUNCTION add_tax(price numeric) RETURNS numeric AS $$
BEGIN
  RETURN price * 1.18;
END; $$ LANGUAGE plpgsql;
SELECT add_tax(100);   -- 118
```

**132. 🟡 Function vs procedure.**
A function returns a value and is called in a query (`SELECT fn()`). A procedure (PG 11+) is called with `CALL proc()`, may return nothing, and **can control transactions** (`COMMIT`/`ROLLBACK` inside).
```sql
CREATE PROCEDURE archive_old() LANGUAGE plpgsql AS $$
BEGIN DELETE FROM logs WHERE ts < now() - interval '90 days'; COMMIT; END $$;
CALL archive_old();
```

**133. 🟡 IMMUTABLE, STABLE, VOLATILE.**
Tell the planner how predictable a function is:
- **IMMUTABLE**: same input always gives same output (`lower()`); can be used in indexes.
- **STABLE**: same output within one query/statement (`now()`, table lookups).
- **VOLATILE** (default): can change anytime or have side effects (`random()`, `nextval()`).

**134. 🟡 P: RETURNS TABLE.**
```sql
CREATE FUNCTION top_paid(n int) RETURNS TABLE(name text, salary numeric) AS $$
  SELECT name, salary FROM employees ORDER BY salary DESC LIMIT n;
$$ LANGUAGE sql;
SELECT * FROM top_paid(3);
```

**135. 🟡 P: IF, LOOP, FOR, exception handling.**
```sql
CREATE OR REPLACE FUNCTION demo() RETURNS void AS $$
DECLARE r record; total int := 0;
BEGIN
  FOR r IN SELECT id FROM employees LOOP
    IF r.id % 2 = 0 THEN total := total + 1; END IF;
  END LOOP;
  PERFORM 1/0;                         -- error on purpose
EXCEPTION WHEN division_by_zero THEN
  RAISE NOTICE 'caught error, total=%', total;
END; $$ LANGUAGE plpgsql;
```
`LOOP ... EXIT WHEN cond; END LOOP;` is the plain loop.

**136. 🟡 Trigger: BEFORE vs AFTER vs INSTEAD OF.**
A trigger runs a function automatically on INSERT/UPDATE/DELETE.
- **BEFORE**: runs before the change; can modify or cancel the row.
- **AFTER**: runs after the change; good for auditing.
- **INSTEAD OF**: only on views; replaces the action.

**137. 🟡 P: Audit trigger.**
```sql
CREATE TABLE emp_audit(emp_id int, old_sal numeric, new_sal numeric, changed_at timestamptz DEFAULT now());
CREATE FUNCTION log_sal() RETURNS trigger AS $$
BEGIN
  INSERT INTO emp_audit(emp_id, old_sal, new_sal) VALUES (OLD.id, OLD.salary, NEW.salary);
  RETURN NEW;
END; $$ LANGUAGE plpgsql;
CREATE TRIGGER trg_sal AFTER UPDATE OF salary ON employees
FOR EACH ROW EXECUTE FUNCTION log_sal();
```

**138. 🟡 Row-level vs statement-level triggers.**
`FOR EACH ROW` fires once per affected row. `FOR EACH STATEMENT` fires once per SQL statement, even if 0 or 1000 rows change.

**139. 🟡 NEW, OLD, TG_OP.**
- `NEW`: the new row (INSERT/UPDATE).
- `OLD`: the old row (UPDATE/DELETE).
- `TG_OP`: text of the operation: 'INSERT', 'UPDATE', 'DELETE'.
Example: `IF TG_OP = 'DELETE' THEN ... END IF;`

**140. 🟡 Updatable views and WITH CHECK OPTION.**
Simple views (one table, no aggregates/DISTINCT/GROUP BY) can accept INSERT/UPDATE/DELETE. `WITH CHECK OPTION` ensures changes made through the view still satisfy the view's WHERE.
```sql
CREATE VIEW pune_emp AS SELECT * FROM employees WHERE city='Pune' WITH CHECK OPTION;
-- INSERT INTO pune_emp ... city='Delhi' → error
```

**141. 🔴 P: Refresh a materialized view without blocking reads.**
```sql
CREATE UNIQUE INDEX ON mv_dept_sales(dept_id);          -- required
REFRESH MATERIALIZED VIEW CONCURRENTLY mv_dept_sales;
```

**142. 🔴 SECURITY DEFINER and risks.**
The function runs with the privileges of its **owner** instead of the caller (like `sudo`). Risks: privilege escalation, and **search_path hijacking** (an attacker creates a fake function/table in an earlier schema). Mitigate: `SET search_path = pg_catalog, public` on the function, schema-qualify names, `REVOKE ALL ... FROM PUBLIC`, and grant EXECUTE only to those who need it.

**143. 🔴 Event triggers.**
Triggers on database-level DDL events (`CREATE TABLE`, `DROP`, `ALTER`), not on row changes. Use for auditing schema changes or blocking dangerous DDL.
```sql
CREATE EVENT TRIGGER no_drop ON sql_drop EXECUTE FUNCTION block_drop();
```

**144. 🔴 LISTEN/NOTIFY and limitations.**
A simple pub/sub inside PostgreSQL: one session does `LISTEN orders;`, another does `NOTIFY orders, 'new order 42';` (or `pg_notify`).
Limits: payload max 8000 bytes; messages are **not stored** (lost if the listener is offline); delivered only on commit; a long-running listening transaction can fill the notification queue; not suitable for guaranteed delivery (use a real queue).

---
## 14. Partitioning, Inheritance, FDW, Extensions (145-154)

**145. 🟡 What is table partitioning and why use it?**
Splitting one big logical table into smaller physical tables (partitions). Benefits: faster queries via partition pruning, easy deletion of old data (drop a partition), faster maintenance (vacuum/index per partition).

**146. 🟡 P: Range-partitioned table by date.**
```sql
CREATE TABLE logs(id bigserial, created_at date NOT NULL, msg text)
PARTITION BY RANGE (created_at);
CREATE TABLE logs_2026_01 PARTITION OF logs FOR VALUES FROM ('2026-01-01') TO ('2026-02-01');
CREATE TABLE logs_2026_02 PARTITION OF logs FOR VALUES FROM ('2026-02-01') TO ('2026-03-01');
```

**147. 🟡 Range vs list vs hash partitioning.**
- **Range**: by value ranges (dates, ids). Best for time-series.
- **List**: by exact values (country, region): `FOR VALUES IN ('IN','US')`.
- **Hash**: by hash of a key, spreads data evenly: `FOR VALUES WITH (MODULUS 4, REMAINDER 0)`. Good when no natural range.

**148. 🟡 Partition pruning.**
The planner skips partitions that cannot contain the needed rows.
`EXPLAIN SELECT * FROM logs WHERE created_at = '2026-01-15';` shows only `logs_2026_01` scanned. Works best when the WHERE uses the partition key.

**149. 🔴 Limitations of declarative partitioning.**
- A primary key/unique constraint **must include the partition key columns**.
- A foreign key *to* a partitioned table is supported only in newer versions (PG 12+), with the key rules above.
- No global unique index across partitions.
- Too many partitions slow planning.
- Rows need a matching partition (or a DEFAULT partition) or the insert fails.
- Changing a partition key requires moving rows.

**150. 🔴 P: Detach and archive an old partition.**
```sql
ALTER TABLE logs DETACH PARTITION logs_2025_01 CONCURRENTLY;   -- PG 14+, minimal locking
-- then archive:
pg_dump -t logs_2025_01 mydb > logs_2025_01.sql
DROP TABLE logs_2025_01;
```
Optionally keep it as a standalone table in a cheaper tablespace.

**151. 🟡 Table inheritance vs partitioning.**
Inheritance (`CREATE TABLE child () INHERITS (parent)`) lets a child table have the parent's columns; querying the parent also reads children. It is the older, manual way: no automatic routing of inserts (needs triggers), constraints and indexes aren't inherited. Declarative partitioning is the modern replacement with automatic routing and pruning.

**152. 🟡 Foreign Data Wrapper; postgres_fdw use cases.**
FDW lets PostgreSQL query external data as if it were a local table. `postgres_fdw` connects to another PostgreSQL server. Use cases: cross-database queries, simple sharding, gradual migration, reporting across servers.
```sql
CREATE EXTENSION postgres_fdw;
CREATE SERVER remote FOREIGN DATA WRAPPER postgres_fdw OPTIONS (host 'h2', dbname 'sales');
CREATE USER MAPPING FOR current_user SERVER remote OPTIONS (user 'u', password 'p');
IMPORT FOREIGN SCHEMA public FROM SERVER remote INTO local_schema;
```

**153. 🟡 Useful extensions.**
- `pg_stat_statements`: query performance stats.
- `pgcrypto`: hashing/encryption, `gen_random_uuid()`.
- `PostGIS`: geospatial data and queries.
- `pg_trgm`: fuzzy text search and fast `LIKE '%x%'`.
- `hstore`: simple key-value column.
Others: `pg_repack`, `pgstattuple`, `btree_gist`, `uuid-ossp`, `timescaledb`.

**154. 🔴 How to shard PostgreSQL?**
- **Citus**: extension that spreads tables across worker nodes by a distribution key; mostly transparent to SQL.
- **Application-level**: the app picks the database by key (e.g., `customer_id % N`). Full control, but cross-shard queries and transactions are hard.
- **FDW + partitioning**: partitions are foreign tables on other servers. Simple but limited performance.
First try cheaper options: indexes, partitioning, read replicas, bigger hardware.

---

## 15. JSON/JSONB, Arrays, Full-Text Search (155-164)

**155. 🟢 JSON vs JSONB.**
`JSON` stores the exact text (keeps spaces, key order, duplicate keys); slow to query. `JSONB` stores a parsed binary form: faster to query, supports indexes, removes duplicate keys, doesn't keep order. Use **JSONB** almost always.

**156. 🟡 P: Query JSONB with ->, ->>, @>, #>.**
```sql
-- data: {"name":"Ravi","address":{"city":"Pune"},"tags":["a","b"]}
SELECT data -> 'address' FROM people;              -- JSON object
SELECT data ->> 'name' FROM people;                -- text 'Ravi'
SELECT * FROM people WHERE data @> '{"name":"Ravi"}';   -- contains
SELECT data #> '{address,city}' FROM people;       -- path → "Pune"
SELECT data #>> '{address,city}' FROM people;      -- path → Pune (text)
```

**157. 🟡 P: Update one key with jsonb_set.**
```sql
UPDATE people SET data = jsonb_set(data, '{address,city}', '"Mumbai"')
WHERE id = 1;
```
(Add a key with `data || '{"age":30}'`; remove with `data - 'age'`.)

**158. 🟡 P: GIN index on JSONB.**
```sql
CREATE INDEX idx_people_data ON people USING gin (data);
-- or smaller/faster for @> only:
CREATE INDEX idx_people_data2 ON people USING gin (data jsonb_path_ops);
```

**159. 🟡 P: Arrays with ANY, unnest, array_agg.**
```sql
CREATE TABLE posts(id serial, tags text[]);
INSERT INTO posts(tags) VALUES (ARRAY['sql','pg']);
SELECT * FROM posts WHERE 'pg' = ANY(tags);
SELECT id, unnest(tags) FROM posts;                       -- one row per tag
SELECT array_agg(name) FROM employees WHERE dept_id = 1;  -- rows → array
```

**160. 🟡 Full-text search: tsvector and tsquery.**
`tsvector` is a document turned into a sorted list of normalized words (stemmed, stop words removed). `tsquery` is the search expression. Match with `@@`.
```sql
SELECT to_tsvector('english','The cats are running') @@ to_tsquery('english','cat & run');  -- true
```

**161. 🟡 P: Full-text query with ranking.**
```sql
SELECT title, ts_rank(to_tsvector('english', body), q) AS rank
FROM articles, to_tsquery('english', 'postgres & index') q
WHERE to_tsvector('english', body) @@ q
ORDER BY rank DESC LIMIT 10;
-- Index: CREATE INDEX ON articles USING gin (to_tsvector('english', body));
```

**162. 🔴 pg_trgm vs full-text search for fuzzy matching.**
- **FTS**: understands words, stemming, ranking, language. Doesn't handle typos or partial words.
- **pg_trgm**: breaks text into 3-letter pieces and compares similarity, so it handles typos, partial words, and `LIKE '%abc%'` with GIN/GiST.
```sql
CREATE EXTENSION pg_trgm;
SELECT name FROM products WHERE name % 'iphnoe';   -- finds 'iphone'
SELECT similarity('iphone','iphnoe');
CREATE INDEX ON products USING gin (name gin_trgm_ops);
```
Use FTS for searching documents; trigrams for names/typos. Combine if needed.

**163. 🔴 JSONB vs relational columns.**
Use **relational columns** for core, stable, queried, joined data that needs constraints and foreign keys (user id, price, status). Use **JSONB** for flexible, sparse, or changing attributes (product specs, settings, raw API payloads). Common design: fixed columns + one JSONB `attributes` column. Downsides of JSONB: no type/FK enforcement, harder stats for the planner, bigger storage, rewriting whole value on updates.

**164. 🔴 P: jsonb_path_query (SQL/JSON path).**
```sql
-- data: {"items":[{"name":"pen","price":5},{"name":"book","price":20}]}
SELECT jsonb_path_query(data, '$.items[*] ? (@.price > 10)') FROM orders;   -- book object
SELECT * FROM orders WHERE data @? '$.items[*] ? (@.price > 10)';           -- boolean exists
```
(PG 12+.)

---

## 16. Security & Access Control (165-172)

**165. 🟢 P: Create user and grant SELECT.**
```sql
CREATE USER report_user WITH PASSWORD 'Str0ng!pass';
GRANT CONNECT ON DATABASE shop TO report_user;
GRANT USAGE ON SCHEMA public TO report_user;
GRANT SELECT ON employees TO report_user;
```

**166. 🟢 User vs role.**
Same thing. `CREATE USER` is just `CREATE ROLE ... LOGIN`. A role can be a user (can log in) or a group (collects privileges). Roles can be members of other roles.
```sql
CREATE ROLE analysts;  GRANT SELECT ON ALL TABLES IN SCHEMA public TO analysts;
GRANT analysts TO report_user;
```

**167. 🟡 GRANT, REVOKE, default privileges.**
`GRANT` gives permission; `REVOKE` takes it away. **Default privileges** apply to *future* objects, because normal GRANTs only cover tables that already exist.
```sql
REVOKE INSERT ON employees FROM report_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT ON TABLES TO analysts;
```

**168. 🟡 Authentication methods.**
- `trust`: no password (dangerous, only for local testing).
- `md5`: old password hash; weaker.
- `scram-sha-256`: modern, secure password method (recommended).
- `cert`: client SSL certificate.
- Others: `peer` (OS user), `ldap`, `gss`, `reject`.

**169. 🟡 Enable SSL/TLS.**
In `postgresql.conf`: `ssl = on`, `ssl_cert_file='server.crt'`, `ssl_key_file='server.key'`. In `pg_hba.conf` use `hostssl` lines (e.g., `hostssl all all 0.0.0.0/0 scram-sha-256`). Reload. Client: `psql "sslmode=verify-full host=db dbname=shop"`.

**170. 🔴 Row-Level Security (RLS) and policy.**
RLS restricts which rows a user can see or change.
```sql
ALTER TABLE documents ENABLE ROW LEVEL SECURITY;
CREATE POLICY own_docs ON documents
  USING (owner = current_user)           -- which rows visible
  WITH CHECK (owner = current_user);     -- which rows can be written
```
Table owners and superusers bypass it unless `FORCE ROW LEVEL SECURITY` is set.

**171. 🔴 Prevent SQL injection.**
- Use **parameterized queries / prepared statements**; never build SQL by joining strings.
- In PL/pgSQL dynamic SQL, use `format('%I', ident)` and `format('%L', literal)` or `EXECUTE ... USING`.
- Give the app a least-privilege role (no superuser).
- Validate input and use RLS.
Bad: `"SELECT * FROM users WHERE name = '" + input + "'"` with input `' OR '1'='1`. Good: `SELECT * FROM users WHERE name = $1`.

**172. 🔴 Public schema risk; PG 15 hardening.**
Before PG 15, every user could create objects in the `public` schema, enabling attackers to plant functions/tables that trick others (search_path attacks). PG 15 removed `CREATE` on `public` from regular users (only the database owner has it). Best practice: `REVOKE CREATE ON SCHEMA public FROM PUBLIC;` on older versions, and use dedicated schemas.

---

## 17. Backup, Restore, WAL, PITR (173-180)

**173. 🟢 Logical vs physical backup.**
- **Logical** (`pg_dump`): exports SQL/data. Portable across versions and platforms, can restore single tables; slower for huge databases.
- **Physical** (`pg_basebackup`, file copy): copies the data files. Fast for big databases, supports PITR and replicas; same major version and architecture only.

**174. 🟢 P: pg_dump and pg_restore.**
```bash
pg_dump -U postgres -Fc -f shop.dump shop          # custom format backup
createdb -U postgres shop_new
pg_restore -U postgres -d shop_new -j 4 shop.dump  # restore with 4 parallel jobs
```

**175. 🟡 pg_dumpall; custom, directory, plain formats.**
`pg_dumpall` dumps the **whole cluster** (all databases + roles + tablespaces) as plain SQL. (`pg_dumpall --globals-only` for just roles.)
Formats of `pg_dump`: **plain** (`-Fp`, SQL text, restore with psql), **custom** (`-Fc`, compressed, use pg_restore, selective restore), **directory** (`-Fd`, one file per table, allows parallel dump with `-j`).

**176. 🟡 What is WAL and why does it exist?**
Write-Ahead Log: before changing a data page, PostgreSQL first writes the change to a sequential log and flushes it. After a crash it **replays the WAL** to recover. It gives durability, is faster than writing data pages immediately, and powers replication and PITR.

**177. 🟡 Checkpoint and tuning settings.**
A checkpoint flushes all dirty pages to disk and marks a recovery starting point. Settings: `checkpoint_timeout` (default 5 min), `max_wal_size`, `min_wal_size`, `checkpoint_completion_target` (spread writes, e.g., 0.9). Too-frequent checkpoints cause I/O spikes; too-rare ones lengthen crash recovery. See "checkpoints_req" in `pg_stat_bgwriter`.

**178. 🟡 P: pg_basebackup.**
`pg_basebackup -h primary -U replicator -D /backup/base -Ft -z -P -X stream`
(`-Ft` tar, `-z` gzip, `-P` progress, `-X stream` includes needed WAL.) Add `-R` to create standby config for building a replica.

**179. 🔴 PITR step by step.**
PITR restores the database to an exact moment (e.g., just before someone dropped a table).
1. Enable WAL archiving (`archive_mode=on`, `archive_command`).
2. Take regular base backups.
3. When disaster happens, stop PostgreSQL and move the damaged data directory away.
4. Restore the latest base backup into the data directory.
5. Set `restore_command = 'cp /archive/%f %p'` and `recovery_target_time = '2026-11-25 10:30:00'` in `postgresql.conf`.
6. Create an empty file `recovery.signal` in the data directory.
7. Start PostgreSQL; it replays WAL up to the target and pauses.
8. Check the data, then `SELECT pg_wal_replay_resume();` to promote and open for writes.

**180. 🔴 archive_mode and archive_command; failures.**
`archive_mode = on` makes PostgreSQL copy each completed WAL file using `archive_command`, e.g. `'test ! -f /archive/%f && cp %p /archive/%f'`. If the command **fails**, PostgreSQL keeps retrying and does **not delete that WAL**, so `pg_wal` fills the disk and the server can crash or stop. Monitor `pg_stat_archiver` (failed_count, last_failed_wal) and alert.

---

## 18. Replication, HA, Pooling, Config, Upgrades (181-190)

**181. 🟡 Streaming vs logical replication.**
- **Streaming (physical)**: copies WAL bytes to a standby, producing an exact copy of the **whole cluster**; standby is read-only; same major version.
- **Logical**: publishes row changes (INSERT/UPDATE/DELETE) per table (publication/subscription); can replicate selected tables, between different major versions, and the target stays writable.
```sql
CREATE PUBLICATION pub FOR TABLE orders;                       -- source
CREATE SUBSCRIPTION sub CONNECTION 'host=src dbname=shop' PUBLICATION pub;  -- target
```

**182. 🟡 Synchronous vs asynchronous trade-offs.**
- **Async**: primary commits without waiting for the standby; fast, but a failover can **lose** the last few transactions.
- **Sync** (`synchronous_commit`, `synchronous_standby_names`): commit waits for standby confirmation; **no data loss**, but slower and a down standby can block writes.
Choose by how much data loss you can accept (RPO).

**183. 🟡 Replication slot and risks.**
A slot makes the primary remember how much WAL a standby/subscriber still needs. Risk: if the consumer is down or slow, WAL **piles up** and can fill the disk, and it can hold back vacuum. Monitor `pg_replication_slots`, drop unused slots, and set `max_slot_wal_keep_size` (PG 13+).

**184. 🟡 Why PgBouncer? Session vs transaction pooling.**
Each PostgreSQL connection is a heavy process, so thousands of connections hurt. PgBouncer is a lightweight pooler that lets many clients share few server connections.
- **Session pooling**: a server connection is held for the whole client session. Safe for everything.
- **Transaction pooling**: a server connection is assigned only during a transaction. Much higher reuse, but you can't rely on session features (session-level `SET`, advisory locks, `LISTEN`, temp tables, and prepared statements unless supported).

**185. 🔴 Measure and reduce replication lag.**
Measure on the primary: `SELECT client_addr, write_lag, flush_lag, replay_lag, pg_wal_lsn_diff(sent_lsn, replay_lsn) AS bytes FROM pg_stat_replication;` On the standby: `SELECT now() - pg_last_xact_replay_timestamp();`
Reduce: faster network and disks on the standby, avoid long queries on the standby (recovery conflicts), tune `max_wal_senders`, `wal_compression`, reduce large bulk writes, and use more parallel apply for logical replication.

**186. 🔴 Patroni vs repmgr vs pg_auto_failover.**
- **Patroni**: most popular; uses a distributed store (etcd/Consul/ZooKeeper) for leader election; automatic failover, very robust; more components to run.
- **repmgr**: simpler tool for managing replicas and failover; witness node needed to avoid split-brain; less automatic than Patroni.
- **pg_auto_failover**: simple, uses a "monitor" node to coordinate one primary and standbys; easy setup, the monitor is a single point to protect.
For serious production, Patroni is the common choice.

**187. 🔴 Hot standby and recovery conflicts.**
A **hot standby** is a replica that accepts read-only queries while replaying WAL. A **recovery conflict** happens when replay needs to remove rows (vacuum cleanup) or lock a table that a running standby query still needs; the query is cancelled ("canceling statement due to conflict with recovery"). Fix: `hot_standby_feedback = on`, increase `max_standby_streaming_delay`, or run long reports on a dedicated replica.

**188. 🟡 P: Tune a 64 GB server.**
A reasonable starting point (then measure):
```
shared_buffers = 16GB            # ~25% of RAM
effective_cache_size = 48GB      # ~75% RAM (planner hint)
work_mem = 32MB                  # per sort/hash; depends on connections
maintenance_work_mem = 2GB       # vacuum, index builds
max_connections = 200            # use PgBouncer for more
wal_buffers = 64MB
checkpoint_completion_target = 0.9
random_page_cost = 1.1           # for SSD
```
Rule of thumb for `work_mem`: (RAM left after shared_buffers) / (max_connections × 2-3).

**189. 🔴 Major-version upgrade options.**
- **pg_upgrade**: fast in-place upgrade; with `--link` takes minutes even for TBs, with a short downtime. Run `ANALYZE` afterward.
- **Logical replication**: build a new-version server, replicate, switch over; near-zero downtime, more setup.
- **Dump/restore** (`pg_dump | pg_restore`): simplest and cleanest, but slow for big databases and needs long downtime.
Always test on a copy first and keep a rollback plan.

**190. 🔴 How max_connections affects memory and performance.**
Each connection is a backend process using memory (a few MB at baseline, plus `work_mem` per sort/hash node and more). Too many connections cause lock contention, more context switching, and snapshot overhead, so throughput **drops**, not rises. Also shared memory is sized from `max_connections`. Keep it moderate (100-300) and use PgBouncer. A good number of *active* connections is about 2-4 × CPU cores.

---

## 19. Real-World Scenarios (191-194)

**191. 🔴 P: A production query became 100x slower. Diagnosis.**
1. **Confirm and scope**: which query, since when, all parameters or some? Use `pg_stat_statements` (compare mean time) and logs (`log_min_duration_statement`).
2. **Check what changed**: deploy, schema change, data growth, config change, new index dropped, upgrade.
3. **Look at live state**: `pg_stat_activity` for blocking locks, "idle in transaction", many connections; high CPU/IO on the server.
4. **EXPLAIN (ANALYZE, BUFFERS)** the query; compare with an old good plan. Look for plan change (index scan → seq scan), row estimate errors, sort spills, JIT overhead.
5. **Likely causes and fixes**:
   - Stale stats → `ANALYZE`.
   - Table/index bloat → vacuum, `REINDEX CONCURRENTLY`.
   - Missing/dropped index → create it `CONCURRENTLY`.
   - Generic plan with skewed parameters → `plan_cache_mode`, better stats.
   - Lock waits → find the blocker and fix the app.
   - Cache cold or memory pressure → check `shared_buffers`, OS cache.
6. **Verify** with the plan and timing, then add monitoring/alert so it's caught early.

**192. 🔴 P: Disk 95% and growing. Find cause and fix safely.**
1. **Find where it is**: `du -sh /var/lib/postgresql/*` and inside `PGDATA` check `pg_wal`, `base`, `pg_log`.
2. **If `pg_wal` is huge**: failing `archive_command` (`pg_stat_archiver`), an unused or lagging replication slot (`pg_replication_slots`), or `wal_keep_size` too high. Fix archiving; drop dead slots only after confirming they're unneeded. **Never delete WAL files by hand.**
3. **If `base` (data) is huge**: biggest tables: `SELECT relname, pg_size_pretty(pg_total_relation_size(oid)) FROM pg_class ORDER BY pg_total_relation_size(oid) DESC LIMIT 10;` Check bloat and dead tuples; check long transactions blocking vacuum.
4. **If logs are huge**: rotate/compress, lower log verbosity.
5. **Temp files**: big sorts (`temp_files` in `pg_stat_database`); tune `work_mem` or queries.
6. **Free space safely**: drop old partitions, archive old data, `VACUUM` (frees internal reuse), `pg_repack` for bloat (avoid `VACUUM FULL` since it needs extra disk space and locks), or add disk space/move a tablespace.
7. Add monitoring and alerts at 70-80%.

**193. 🔴 P: Design e-commerce schema.**
```sql
CREATE TABLE customers(
  id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  email text NOT NULL UNIQUE,
  name text NOT NULL,
  created_at timestamptz NOT NULL DEFAULT now());

CREATE TABLE products(
  id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  sku text NOT NULL UNIQUE,
  name text NOT NULL,
  price numeric(12,2) NOT NULL CHECK (price >= 0),
  stock int NOT NULL DEFAULT 0 CHECK (stock >= 0));

CREATE TABLE orders(
  id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  customer_id bigint NOT NULL REFERENCES customers(id),
  status text NOT NULL DEFAULT 'new' CHECK (status IN ('new','paid','shipped','cancelled')),
  total numeric(12,2) NOT NULL CHECK (total >= 0),
  created_at timestamptz NOT NULL DEFAULT now());

CREATE TABLE order_items(
  order_id bigint NOT NULL REFERENCES orders(id) ON DELETE CASCADE,
  product_id bigint NOT NULL REFERENCES products(id),
  qty int NOT NULL CHECK (qty > 0),
  unit_price numeric(12,2) NOT NULL,          -- price at the time of purchase
  PRIMARY KEY (order_id, product_id));

CREATE TABLE payments(
  id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  order_id bigint NOT NULL REFERENCES orders(id),
  amount numeric(12,2) NOT NULL CHECK (amount > 0),
  method text NOT NULL,
  status text NOT NULL DEFAULT 'pending',
  paid_at timestamptz);

-- Indexes (foreign keys are not indexed automatically)
CREATE INDEX ON orders(customer_id, created_at DESC);
CREATE INDEX ON order_items(product_id);
CREATE INDEX ON payments(order_id);
CREATE INDEX ON orders(created_at) WHERE status = 'new';   -- partial
```
Design points: store `unit_price` in order_items (prices change), use NUMERIC for money, TIMESTAMPTZ for time, constraints for integrity, and consider partitioning `orders` by month when it grows large.

**194. 🔴 P: Migrate a 1 TB database with near-zero downtime.**
Using **logical replication**:
1. Build the new server (same or newer version), tune it, and copy the schema: `pg_dump --schema-only | psql`.
2. On the old server set `wal_level = logical`; create a publication: `CREATE PUBLICATION mig FOR ALL TABLES;` (every table needs a primary key).
3. On the new server create the subscription; it does an initial copy of the data, then streams changes continuously.
4. Monitor lag; sync sequences (they're not replicated) just before cutover.
5. **Cutover**: stop writes (maintenance window of seconds/minutes), wait for lag = 0, copy sequence values, repoint the application (or via PgBouncer/DNS), enable writes on the new server.
6. Keep the old server as a rollback option for a while, then decommission.
Alternative for same version: physical standby via `pg_basebackup`, then promote it (very quick switchover).
Always rehearse the migration first and validate with row counts/checksums.

---

## 20. One-to-One / HR / Behavioral Interview (195-200)

Tip: use the **STAR** method: **S**ituation, **T**ask, **A**ction, **R**esult. Replace the sample details with your own real experience; be honest.

**195. 🟢 Tell me about yourself and your experience with PostgreSQL.**
Sample: "I'm a database professional with X years of experience. For the last Y years I've worked mainly with PostgreSQL: designing schemas, writing and tuning complex SQL, managing indexes and vacuum, and handling backups and replication. In my last project I supported a 500 GB production database, where I reduced slow queries by reviewing `pg_stat_statements` and adding the right indexes. I enjoy solving performance problems and I'm looking to grow into high availability and large-scale design."
Structure: present (role) → past (key achievements) → future (what you want next).

**196. 🟡 Toughest database problem you solved.**
Sample (STAR): "**Situation**: our reporting query slowed from 5 seconds to 3 minutes after data growth. **Task**: fix it without downtime. **Action**: I ran `EXPLAIN (ANALYZE, BUFFERS)`, found a sequential scan and bad row estimates, created a composite index `CONCURRENTLY`, added extended statistics, and rewrote a `NOT IN` into `NOT EXISTS`. **Result**: the query dropped to 2 seconds, CPU fell by 40%, and I documented the steps for the team."

**197. 🟡 A production incident you handled; what would you do differently?**
Sample: "Disk filled to 98% because a replication slot of a dead replica kept WAL files. I stayed calm, found it using `pg_replication_slots` and `pg_wal` size, confirmed the replica was retired, dropped the slot, and the space cleared. We then communicated to stakeholders and wrote a post-mortem. **What I'd do differently**: add disk and slot-lag monitoring with alerts at 70%, set `max_slot_wal_keep_size`, and keep a runbook so recovery is faster next time."
Key points: show calm, clear steps, communication, and learning.

**198. 🟡 How do you stay current with PostgreSQL?**
Sample: "I read the official release notes and documentation for each version, follow Planet PostgreSQL and the postgresql.org mailing lists, watch conference talks (PGConf, PGCon), and read blogs from experts. I try new features (like MERGE or logical replication improvements) in a test environment, and I'm active in learning communities and practice on side projects."

**199. 🔴 Convince a team to adopt PostgreSQL over another database, or to migrate away.**
Sample: "I'd start from the team's *needs*, not my preference. For adopting PostgreSQL: it's open source (no license cost), very reliable and ACID-compliant, rich features (JSONB, full-text search, extensions, partitioning), a large community, and runs on any cloud. I'd propose a small pilot project, share benchmarks and a cost comparison, plan training, and list risks with mitigation. For migrating *away*: I'd be honest if requirements (e.g., huge horizontal scale, specific vendor features) are better met elsewhere, and weigh migration cost and risk using data, not opinion. The goal is the best decision for the business."

**200. 🟢 Where do you see your DBA/developer career in 3 years, and what PostgreSQL skills do you want to master?**
Sample: "In three years I see myself as a senior database engineer or lead, owning the reliability and performance of critical systems and mentoring juniors. Skills I want to master: advanced performance tuning and query planning, high availability with Patroni, backup/PITR strategy, large-scale partitioning and upgrades, and automation (infrastructure as code, monitoring). I also want to contribute to design decisions and share knowledge with the team."

---

### Final quick-revision tips
1. For every theory question, give: **definition → why it matters → short example**.
2. Practice the **P** questions by typing them in a real PostgreSQL database (`psql`), not just reading.
3. Learn to read `EXPLAIN ANALYZE`, MVCC/VACUUM, indexing, and backup/PITR very well: they are the most asked topics.
4. In HR rounds, use real stories (STAR), stay honest, and show learning from mistakes.

Good luck with your interview!
