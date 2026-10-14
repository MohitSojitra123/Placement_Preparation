# SQL Server `LIKE` Operator — Complete Interview Guide

> A to Z coverage of the `LIKE` operator in SQL Server Management Studio (SSMS) — every wildcard, every pattern combination, real-world examples, gotchas, and interview questions.

---

## 📌 Table of Contents

1. [What is LIKE?](#what-is-like)
2. [Level 1 — Basic Wildcards (% and _)](#level-1--basic-wildcards)
3. [Level 2 — Character Sets ([ ], [-], [^])](#level-2--character-sets)
4. [Level 3 — Combinations (AND / OR / NOT LIKE)](#level-3--combinations)
5. [Level 4 — Advanced Real-World Patterns](#level-4--advanced-real-world-patterns)
6. [Level 5 — Special Cases (ESCAPE, Case Sensitivity, NULL)](#level-5--special-cases)
7. [Performance Notes](#performance-notes)
8. [Interview Q&A Cheat Sheet](#interview-qa-cheat-sheet)
9. [Quick Reference Table](#quick-reference-table)

---

## What is LIKE?

`LIKE` is used in the `WHERE` clause to search for a **specified pattern** in a column, using **wildcard characters**. It returns `TRUE`/`FALSE` per row — rows matching the pattern are returned.

```sql
SELECT * FROM Employees
WHERE FirstName LIKE 'A%';
```

**Basic Syntax:**
```sql
column_name LIKE pattern [ESCAPE escape_character]
```

**Interview one-liner:**
> "`LIKE` performs pattern matching using wildcards, unlike `=` which does exact matching. It's commonly used for search features, filtering codes, validating formats, and partial text lookup."

---

## Level 1 — Basic Wildcards

SQL Server supports 4 wildcard characters total, but Level 1 focuses on the two most-used ones: `%` and `_`.

| Wildcard | Meaning |
|----------|---------|
| `%` | Matches **zero, one, or many** characters |
| `_` | Matches **exactly one** character |

### 🔹 `%` — Percent Wildcard

#### 1. Starts With
```sql
-- Find all customers whose name starts with 'A'
SELECT * FROM Customers
WHERE CustomerName LIKE 'A%';
```
✅ Matches: `Amit`, `Anjali`, `Aakash`
❌ Doesn't match: `Ravi`, `Priya`

**Real-world use:** Autocomplete search box — as user types "Ra", show all products starting with "Ra".

#### 2. Ends With
```sql
-- Find all employees whose email ends with '@gmail.com'
SELECT * FROM Employees
WHERE Email LIKE '%@gmail.com';
```
**Real-world use:** Filter customers using a specific email domain for a targeted email campaign.

#### 3. Contains
```sql
-- Find all products that contain the word 'Phone' anywhere
SELECT * FROM Products
WHERE ProductName LIKE '%Phone%';
```
✅ Matches: `Phone Case`, `Smart Phone X`, `iPhone 15`
**Real-world use:** Global search bar on an e-commerce site.

---

### 🔹 `_` (Underscore) — Single Character Wildcard

#### 1. Exactly 1 Character (in a specific spot)
```sql
SELECT * FROM Products
WHERE ProductCode LIKE 'P_1';
```
✅ Matches: `PA1`, `PB1`, `PX1` (3 characters, middle can be anything)

#### 2. Second Character is a Specific Value
```sql
-- Find names where the SECOND character is 'a'
SELECT * FROM Employees
WHERE FirstName LIKE '_a%';
```
✅ Matches: `Rahul` (R-a-h-u-l), `Manoj` (M-a-n-o-j)

#### 3. Character Position Matching
```sql
-- Third character must be 'A', rest can be anything
SELECT * FROM Products
WHERE ProductCode LIKE '__A%';
```

#### 4. Exact Length Check
```sql
-- Exactly 5-character employee codes
SELECT * FROM Employees
WHERE EmpCode LIKE '_____';   -- 5 underscores = exactly 5 chars
```
**Real-world use:** Validating that a PIN code, employee code, or product SKU has an exact fixed length without using `LEN()`.

> 💡 **Interview Trap:** `LIKE '_____'` (5 underscores) checks EXACT length = 5.
> `LIKE '%____%'` checks length **at least** 4.
> `LEN(column) = 5` is the more standard/readable way — interviewers ask this to test if you understand `_` isn't just "any character" but "exactly one position."

---

## Level 2 — Character Sets

These use `[ ]` and are **SQL Server specific** (not standard ANSI SQL — doesn't work the same in MySQL/PostgreSQL). Big interview differentiator.

| Pattern | Meaning |
|---------|---------|
| `[ABC]` | Matches ONE character that is A, B, or C |
| `[A-Z]` | Matches ONE character in range A to Z |
| `[0-9]` | Matches ONE digit |
| `[^ABC]` | Matches ONE character that is **NOT** A, B, or C |
| `[^A-Z]` | Matches ONE character **NOT** in range A-Z |

### 1. `[ABC]` — One Character From a Set
```sql
-- Names starting with A, B, or C
SELECT * FROM Customers
WHERE CustomerName LIKE '[ABC]%';
```
✅ Matches: `Amit`, `Babita`, `Chetan`
❌ Doesn't match: `David`

**Real-world use:** Filtering a report by the first letter of a surname for A–C, D–F grouped reports (like a phonebook UI).

### 2. `[A-Z]` — One Character From a Range
```sql
-- Product codes that start with a capital letter
SELECT * FROM Products
WHERE ProductCode LIKE '[A-Z]%';
```

### 3. `[0-9]` — One Digit
```sql
-- Find invalid customer names that start with a number (data quality check)
SELECT * FROM Customers
WHERE CustomerName LIKE '[0-9]%';
```
**Real-world use:** Data cleansing — flagging bad data where a "Name" field accidentally contains a number first (common in migrated/legacy data).

### 4. `[^ABC]` — NOT These Characters
```sql
-- Names that do NOT start with A, B, or C
SELECT * FROM Customers
WHERE CustomerName LIKE '[^ABC]%';
```

### 5. `[^A-Z]` — NOT In Range
```sql
-- Find rows where the first character is NOT an uppercase letter (special char/digit)
SELECT * FROM Products
WHERE ProductCode LIKE '[^A-Z]%';
```
**Real-world use:** Validation query to catch product codes that don't follow the standard "starts with a letter" business rule.

> 💡 **Interview Trap:** `[^ABC]` inside `LIKE` means NOT A/B/C **at that one character position only** — it is NOT the same as `NOT LIKE '%[ABC]%'`. Interviewers love testing this distinction.

---

## Level 3 — Combinations

### 1. `%` + `_`
```sql
-- Second character is 'a', followed by anything
SELECT * FROM Employees
WHERE FirstName LIKE '_a%';

-- Starts with 'S', 4th character is 'e'
SELECT * FROM Employees
WHERE FirstName LIKE 'S__e%';
```

### 2. `%` + `[ABC]`
```sql
-- Contains any of A, B, or C at the very start, rest is free text
SELECT * FROM Products
WHERE ProductCode LIKE '[ABC]%TAX%';
```
Meaning: starts with A/B/C **and** contains "TAX" somewhere later.

### 3. `_` + `[ABC]`
```sql
-- First char is anything, second char must be A, B, or C
SELECT * FROM Products
WHERE ProductCode LIKE '_[ABC]%';
```

### 4. `[A-Z]` + `%`
```sql
-- Must start with an uppercase letter
SELECT * FROM Products
WHERE ProductCode LIKE '[A-Z]%';
```

### 5. `[0-9]` + `%`
```sql
-- Employee codes that start with a digit (e.g., legacy migrated codes)
SELECT * FROM Employees
WHERE EmpCode LIKE '[0-9]%';
```

### 6. `AND` with LIKE
```sql
-- Active employees whose name starts with 'S' AND department is Sales
SELECT * FROM Employees
WHERE FirstName LIKE 'S%'
  AND Department = 'Sales';
```

### 7. `OR` with LIKE
```sql
-- Products that contain 'Mobile' OR 'Phone'
SELECT * FROM Products
WHERE ProductName LIKE '%Mobile%'
   OR ProductName LIKE '%Phone%';
```

### 8. `NOT LIKE`
```sql
-- Customers whose name does NOT contain 'Test' (removing dummy/test records)
SELECT * FROM Customers
WHERE CustomerName NOT LIKE '%Test%';
```
**Real-world use:** Cleaning test/dummy data before generating a production report.

---

## Level 4 — Advanced Real-World Patterns

### 1. Multiple LIKE (chained with OR)
```sql
-- Search across multiple possible spellings/variants of a company name
SELECT * FROM Vendors
WHERE VendorName LIKE '%Tata%'
   OR VendorName LIKE '%TCS%'
   OR VendorName LIKE '%Infosys%';
```

### 2. Multiple NOT LIKE (chained with AND)
```sql
-- Exclude multiple unwanted categories from a report
SELECT * FROM Products
WHERE ProductName NOT LIKE '%Sample%'
  AND ProductName NOT LIKE '%Demo%'
  AND ProductName NOT LIKE '%Test%';
```
> ⚠️ **Common mistake:** Using `OR` instead of `AND` with multiple `NOT LIKE` conditions. If you use `OR`, almost every row will match (since a row not containing "Sample" already satisfies the OR condition), defeating the purpose. **Always use `AND` when excluding multiple patterns.**

### 3. LIKE + NOT LIKE Combined
```sql
-- Products that contain 'Phone' but NOT 'Refurbished'
SELECT * FROM Products
WHERE ProductName LIKE '%Phone%'
  AND ProductName NOT LIKE '%Refurbished%';
```

### 4. Complex Position Matching
```sql
-- Vehicle registration: 2 letters + 2 digits + 2 letters + 4 digits (e.g., MH12AB1234)
SELECT * FROM Vehicles
WHERE RegistrationNumber LIKE '[A-Z][A-Z][0-9][0-9][A-Z][A-Z][0-9][0-9][0-9][0-9]';
```

### 5. Email Pattern Validation
```sql
-- Basic structural check: must contain '@' and a '.' after it, and end in valid domain
SELECT * FROM Customers
WHERE Email LIKE '%_@__%.__%'
  AND Email NOT LIKE '%@%@%';   -- reject multiple @ symbols
```
**Explanation:**
- `%_@__%.__%` → at least 1 char, then `@`, then at least 2 chars, then `.`, then at least 2 chars (basic sanity check, not full RFC validation)
- Real-world caveat: **`LIKE` is NOT a substitute for proper email validation** (that belongs in application code or regex via CLR). It's used in SQL mainly for quick data-quality flags.

```sql
-- Find likely invalid emails (missing @ symbol) — data quality check
SELECT * FROM Customers
WHERE Email NOT LIKE '%@%';
```

### 6. Phone Number Patterns
```sql
-- Indian mobile numbers: exactly 10 digits, starting with 6,7,8, or 9
SELECT * FROM Customers
WHERE Phone LIKE '[6-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'
  AND LEN(Phone) = 10;

-- Numbers with country code +91
SELECT * FROM Customers
WHERE Phone LIKE '+91[0-9]%';

-- Find corrupted phone numbers (contains non-digit characters other than +)
SELECT * FROM Customers
WHERE Phone LIKE '%[^0-9+]%';
```
**Real-world use:** Data quality audit before running an SMS marketing campaign — filter out numbers with letters, dashes, or spaces accidentally entered.

### 7. Employee Code Patterns
```sql
-- Format: EMP-0001 (EMP dash 4 digits)
SELECT * FROM Employees
WHERE EmpCode LIKE 'EMP-[0-9][0-9][0-9][0-9]';

-- Employees from IT department using code prefix "IT"
SELECT * FROM Employees
WHERE EmpCode LIKE 'IT%';

-- Codes NOT following standard format (data quality check)
SELECT * FROM Employees
WHERE EmpCode NOT LIKE 'EMP-[0-9][0-9][0-9][0-9]';
```

### 8. Product Code / SKU Patterns
```sql
-- SKU format: 2 letters (category) + 3 digits (product) + 1 letter (size) e.g., "TS100L"
SELECT * FROM Products
WHERE SKU LIKE '[A-Z][A-Z][0-9][0-9][0-9][A-Z]';

-- All electronics category codes (prefix "EL") priced with a discount code containing 'OFF'
SELECT * FROM Products
WHERE SKU LIKE 'EL%'
  AND PromoCode LIKE '%OFF%';
```

### 9. Postal / PIN Code Patterns
```sql
-- Indian PIN codes: exactly 6 digits
SELECT * FROM Addresses
WHERE PinCode LIKE '[0-9][0-9][0-9][0-9][0-9][0-9]';

-- PIN codes belonging to Delhi region (start with '11')
SELECT * FROM Addresses
WHERE PinCode LIKE '11%';

-- US ZIP codes: 5 digits, optionally + 4 digit extension (ZIP+4)
SELECT * FROM Addresses
WHERE ZipCode LIKE '[0-9][0-9][0-9][0-9][0-9]'
   OR ZipCode LIKE '[0-9][0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]';
```

---

## Level 5 — Special Cases

### 1. `ESCAPE` Clause
When your data itself contains `%` or `_` as **literal characters** (not wildcards), you need `ESCAPE` to tell SQL Server "treat this character literally."

```sql
-- Find products with an actual '%' in the name, e.g., "50% Off Combo Pack"
SELECT * FROM Products
WHERE ProductName LIKE '%50!%%' ESCAPE '!';
```
Here `!` is declared as the escape character, so `!%` means "literal percent sign," while the surrounding `%` (unescaped) still act as wildcards.

### 2. Searching for Literal `%`
```sql
-- Discount field stored as text like "10%"
SELECT * FROM Promotions
WHERE DiscountText LIKE '%1!0%%' ESCAPE '!';
```

### 3. Searching for Literal `_`
```sql
-- Usernames that contain a literal underscore, e.g., "john_doe"
SELECT * FROM Users
WHERE Username LIKE '%john!_doe%' ESCAPE '!';

-- General pattern: find any username with an underscore in it
SELECT * FROM Users
WHERE Username LIKE '%[_]%';   -- alternative: use [] to escape without ESCAPE clause
```
> 💡 **Interview Trick:** You can escape `_` or `%` by wrapping them in `[ ]` too — `[_]` and `[%]` — as an alternative to the `ESCAPE` keyword. This is SQL Server-specific.

### 4. Searching for a Literal `[` Character
```sql
-- Find text that contains a literal square bracket, e.g., "Item[1]"
SELECT * FROM Notes
WHERE Comment LIKE '%[[]%';   -- [[] means literal '['
```
Since `[` normally starts a character-set, you must wrap it as `[[]` to search for it literally.

### 5. Case Sensitivity
```sql
-- Case sensitivity depends on the COLLATION of the column/database
SELECT * FROM Employees
WHERE FirstName LIKE 'john%';   -- may match 'John' too, if collation is case-insensitive (CI)
```
- By default, most SQL Server installations use a **case-insensitive (CI)** collation (e.g., `SQL_Latin1_General_CP1_CI_AS`), so `LIKE 'john%'` will match `John`, `JOHN`, `john`.
- To force case-sensitive matching:
```sql
SELECT * FROM Employees
WHERE FirstName COLLATE SQL_Latin1_General_CP1_CS_AS LIKE 'john%';
```

### 6. Collation Impact
```sql
-- Check current database collation
SELECT DATABASEPROPERTYEX('YourDBName', 'Collation');

-- Compare column collation
SELECT COLLATION_NAME
FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_NAME = 'Employees' AND COLUMN_NAME = 'FirstName';
```
**Interview point:** `CI` = Case Insensitive, `CS` = Case Sensitive, `AS` = Accent Sensitive, `AI` = Accent Insensitive. This affects how `LIKE`, `=`, `ORDER BY`, and `GROUP BY` all behave — not just `LIKE`.

### 7. LIKE with NULL
```sql
SELECT * FROM Employees
WHERE FirstName LIKE '%A%';
```
- Rows where `FirstName IS NULL` are **never returned** by any `LIKE` comparison — `NULL LIKE anything` evaluates to `UNKNOWN`, not `TRUE`.
- Similarly, `NULL NOT LIKE anything` also evaluates to `UNKNOWN` — it does **not** return the NULL row either.

```sql
-- WRONG assumption: this does NOT return NULL rows
SELECT * FROM Employees WHERE FirstName NOT LIKE '%A%';

-- To include NULLs, you must explicitly add:
SELECT * FROM Employees
WHERE FirstName NOT LIKE '%A%' OR FirstName IS NULL;
```
> 💡 **Classic Interview Question:** "If a column has NULL values, will `NOT LIKE` return those rows?" — **Answer: No.** This trips up many candidates because they assume `NOT LIKE` is the logical opposite that would "catch everything else," but SQL's three-valued logic (`TRUE`/`FALSE`/`UNKNOWN`) excludes NULLs from both `LIKE` and `NOT LIKE`.

---

## Performance Notes

Frequently asked as a **follow-up** after LIKE syntax questions — shows real depth of understanding.

| Pattern | Index Usage | Reason |
|---------|-------------|--------|
| `LIKE 'ABC%'` | ✅ Can use index (Index Seek) | Leading characters are fixed, SQL Server can seek |
| `LIKE '%ABC'` | ❌ Cannot use index (Index/Table Scan) | Leading wildcard forces full scan |
| `LIKE '%ABC%'` | ❌ Cannot use index efficiently | Same reason — leading `%` |
| `LIKE 'A_C%'` | ✅ Can partially use index | Fixed leading character still allows seek |

```sql
-- Efficient (Index Seek possible if index exists on FirstName)
SELECT * FROM Employees WHERE FirstName LIKE 'Sam%';

-- Inefficient (forces Index/Table Scan)
SELECT * FROM Employees WHERE FirstName LIKE '%Sam%';
```

**Interview talking point:**
> "For 'contains' searches on large tables, instead of `LIKE '%text%'`, consider **Full-Text Search** (`CONTAINS`, `FREETEXT`) which uses a full-text index and is far more performant and linguistically aware (handles stemming, etc.)."

---

## Interview Q&A Cheat Sheet

**Q1: Difference between `LIKE` and `=`?**
> `=` does exact match; `LIKE` does pattern matching using wildcards (`%`, `_`, `[]`, `[^]`).

**Q2: Difference between `%` and `_`?**
> `%` matches zero or more characters; `_` matches exactly one character.

**Q3: Is `LIKE` case-sensitive in SQL Server?**
> Depends on the collation. Default collations are usually case-insensitive (CI); can be forced case-sensitive using `COLLATE ... CS_AS`.

**Q4: How do you search for a literal `%` or `_` in data?**
> Use the `ESCAPE` clause, or wrap the character in square brackets, e.g., `[%]` or `[_]`.

**Q5: Does `LIKE '%ABC'` use an index?**
> No — a leading wildcard forces a full scan since SQL Server can't seek from an unknown starting point.

**Q6: What does `NOT LIKE` return for NULL values?**
> Nothing — `NULL` compared with `LIKE` or `NOT LIKE` always evaluates to `UNKNOWN`, so NULL rows are excluded from both.

**Q7: What's the difference between `[ABC]` and `(A|B|C)` regex-style alternation?**
> `[ABC]` in SQL Server `LIKE` matches exactly **one character position** from the set — it is NOT the same as regex alternation of multi-character strings. `LIKE` has no true regex support.

**Q8: How do you find records with an exact length using LIKE?**
> `LIKE '_____'` (five underscores = exactly five characters), though `LEN(column) = 5` is more readable/standard.

**Q9: Can `LIKE` be used with numeric or date columns?**
> Not directly — SQL Server will implicitly convert to string, but it's best practice to explicitly `CAST`/`CONVERT` first, since implicit conversions can cause performance issues or unexpected results.

**Q10: How to improve performance of `%text%` searches on large tables?**
> Use **Full-Text Search** (`CONTAINS`/`FREETEXT` with a full-text index) instead of leading-wildcard `LIKE`.

**Q11: What's the real difference between `[^ABC]` and `NOT LIKE '%[ABC]%'`?**
> `[^ABC]` excludes A/B/C at **one specific character position only**. `NOT LIKE '%[ABC]%'` excludes rows where A, B, or C appears **anywhere** in the string. These are very different in scope.

**Q12: Is SQL Server LIKE ANSI SQL standard?**
> `%` and `_` are ANSI standard. The `[ ]`, `[^]`, and `[-]` character-set wildcards are **T-SQL/SQL Server-specific** — not supported the same way in MySQL (which uses regex-based approaches) or in a strictly ANSI-compliant engine.

---

## Quick Reference Table

| Pattern | Meaning | Example |
|---------|---------|---------|
| `LIKE 'A%'` | Starts with A | `Amit`, `Anjali` |
| `LIKE '%A'` | Ends with A | `India`, `Priya` |
| `LIKE '%A%'` | Contains A | `Karan`, `Sara` |
| `LIKE '_A%'` | 2nd char is A | `RAhul` (2nd char = A) |
| `LIKE '__A%'` | 3rd char is A | `xxAyy` |
| `LIKE '_____'` | Exactly 5 characters | `Sunny` |
| `LIKE '[ABC]%'` | Starts with A, B, or C | `Babu` |
| `LIKE '[A-Z]%'` | Starts with any capital A–Z | `Raj` |
| `LIKE '[0-9]%'` | Starts with a digit | `123ABC` |
| `LIKE '[^ABC]%'` | Doesn't start with A/B/C | `David` |
| `NOT LIKE '%ABC%'` | Doesn't contain ABC anywhere | — |
| `LIKE 'A%Z'` | Starts with A, ends with Z | `AtoZ` |
| `LIKE '[A-Z][0-9]%'` | Letter then digit then anything | `A1XYZ` |
| `LIKE '[A-Z][A-Z][0-9][0-9]'` | Exactly 2 letters + 2 digits | `MH12` |
| `LIKE '%[_]%'` | Contains a literal underscore | `john_doe` |
| `LIKE '%[%]%' ESCAPE...` | Contains a literal percent sign | `50% off` |

---

### 📝 Final Interview Tip

> When asked "Explain LIKE operator," structure your answer in this order for maximum impact:
> 1. Definition + basic syntax
> 2. Wildcards (`%`, `_`, `[]`, `[^]`) with quick examples
> 3. One real-world use case (search feature / data validation)
> 4. Performance caveat (leading `%` kills index usage)
> 5. One "gotcha" (NULL behavior or ESCAPE clause)
>
> This shows breadth (syntax) + depth (performance/edge cases) — exactly what interviewers are probing for.
