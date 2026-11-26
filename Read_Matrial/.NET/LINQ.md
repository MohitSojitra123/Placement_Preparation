# LINQ in C# — 200 Questions Solved
### Exam + Technical Interview Guide (Basic → Intermediate → Advanced)

> Every question (1–200) is answered with an **explanation**, a **C# example**, and where useful an **Exam / Interview tip**.

---

## 📦 Common Setup (used in all examples)

```csharp
using System;
using System.Collections.Generic;
using System.Linq;

public class Employee
{
    public int Id { get; set; }
    public string Name { get; set; }
    public string Department { get; set; }
    public int DeptId { get; set; }
    public decimal Salary { get; set; }
    public string JobTitle { get; set; }
    public int? ManagerId { get; set; }
}

public class Department { public int Id { get; set; } public string Name { get; set; } }
public class Project    { public int Id { get; set; } public string Name { get; set; } public int EmployeeId { get; set; } }
public class Student    { public int Id { get; set; } public string Name { get; set; } public int Marks { get; set; } public string Grade { get; set; } public int DeptId { get; set; } }
public class Product    { public int Id { get; set; } public string Name { get; set; } public string Category { get; set; } public decimal Price { get; set; } public int Stock { get; set; } }

int[] numbers = { 5, 12, 8, 21, 50, 63, 10, 7, 12, 90 };

var employees = new List<Employee>
{
    new Employee { Id=1, Name="Amit",   Department="IT",    DeptId=1, Salary=60000, JobTitle="Developer", ManagerId=null },
    new Employee { Id=2, Name="Anita",  Department="IT",    DeptId=1, Salary=80000, JobTitle="Lead",      ManagerId=1 },
    new Employee { Id=3, Name="Bhavin", Department="HR",    DeptId=2, Salary=45000, JobTitle="Recruiter", ManagerId=1 },
    new Employee { Id=4, Name="Chirag", Department="Sales", DeptId=3, Salary=55000, JobTitle="Executive", ManagerId=2 },
    new Employee { Id=5, Name="Dhara",  Department="IT",    DeptId=1, Salary=80000, JobTitle="Developer", ManagerId=2 },
};

var departments = new List<Department>
{
    new Department { Id=1, Name="IT" }, new Department { Id=2, Name="HR" },
    new Department { Id=3, Name="Sales" }, new Department { Id=4, Name="Finance" }
};

var students = new List<Student>
{
    new Student { Id=1, Name="Ravi",  Marks=85, Grade="A", DeptId=1 },
    new Student { Id=2, Name="Sita",  Marks=72, Grade="B", DeptId=2 },
    new Student { Id=3, Name="Mohan", Marks=35, Grade="F", DeptId=1 },
    new Student { Id=4, Name="Geeta", Marks=72, Grade="B", DeptId=3 },
};
```

---

# 🟢 PART A — BASIC LEVEL (Q1–70)

## 1. LINQ Fundamentals

### Q1. What is LINQ in C#?
**LINQ (Language Integrated Query)** is a set of features in C# (introduced in C# 3.0 / .NET Framework 3.5) that lets you **query any data source using C# syntax** directly in code, with compile-time checking and IntelliSense.

```csharp
var evens = numbers.Where(n => n % 2 == 0);
```
💡 **Interview tip:** Say "LINQ gives one unified query model for objects, databases, XML, etc."

### Q2. What does LINQ stand for?
**L**anguage **IN**tegrated **Q**uery.

### Q3. Why was LINQ introduced in .NET?
Before LINQ, every data source had a different API: `foreach` loops for collections, SQL strings for databases, XPath/XQuery for XML. Problems: no compile-time type checking, SQL in strings, mixed paradigms. LINQ unified all of them into **one consistent, type-safe, declarative syntax**.

### Q4. What are the major advantages of using LINQ?
- **Unified syntax** for all data sources
- **Compile-time type safety** and IntelliSense
- **Readable, declarative** code (what, not how)
- **Less code** than loops
- **Composable**: queries can be chained and reused
- **Deferred execution** for efficiency
- Works with **lambda expressions**, anonymous types, and projections

### Q5. What types of data sources can LINQ work with?
Any `IEnumerable<T>` or `IQueryable<T>` source: arrays, `List<T>`, dictionaries, SQL Server (LINQ to SQL), Entity Framework/EF Core, XML (`XDocument`), `DataSet`/`DataTable`, JSON (after deserializing to objects), web service results, and even custom providers.

### Q6. What is LINQ to Objects?
LINQ queries against **in-memory collections** (`IEnumerable<T>`) such as arrays and lists. Executed in the CLR using delegates (`Func<>`).

```csharp
var result = new List<int>{1,2,3,4}.Where(x => x > 2).ToList(); // [3,4]
```

### Q7. What is LINQ to SQL?
A **legacy ORM** (from .NET 3.5) that maps SQL Server tables to C# classes and translates LINQ into T-SQL. Supports **SQL Server only** and is now superseded by Entity Framework.

### Q8. What is LINQ to Entities?
LINQ queries against an **Entity Framework / EF Core** `DbContext`. The query is converted to SQL for any supported database (SQL Server, PostgreSQL, MySQL, SQLite…).

```csharp
var rich = context.Employees.Where(e => e.Salary > 50000).ToList();
```

### Q9. What is LINQ to XML?
An API (`System.Xml.Linq`) to create/query/modify XML using LINQ and classes like `XDocument`, `XElement`.

```csharp
var doc = XDocument.Parse("<emps><e name='A'/><e name='B'/></emps>");
var names = doc.Descendants("e").Select(e => (string)e.Attribute("name"));
```

### Q10. What is the difference between LINQ and traditional foreach loops?

| Feature | foreach | LINQ |
|---|---|---|
| Style | Imperative (how) | Declarative (what) |
| Code length | Longer | Shorter |
| Readability | Lower for complex logic | Higher |
| Execution | Immediate | Often deferred |
| Works with DB | No | Yes (IQueryable) |

```csharp
// foreach
var list = new List<int>();
foreach (var n in numbers) if (n > 10) list.Add(n);
// LINQ
var list2 = numbers.Where(n => n > 10).ToList();
```
💡 Performance: a hand-written loop can be slightly faster in hot paths; LINQ wins on clarity.

### Q11. What namespaces are commonly required to use LINQ?
- `System.Linq` (core — required)
- `System.Collections.Generic`
- `System.Linq.Expressions` (expression trees)
- `System.Xml.Linq` (LINQ to XML)
- `Microsoft.EntityFrameworkCore` (EF Core extensions such as `ToListAsync`)

### Q12. What is System.Linq?
The namespace containing the static classes **`Enumerable`** (extension methods for `IEnumerable<T>`) and **`Queryable`** (extension methods for `IQueryable<T>`), plus `ILookup`, `IGrouping`, `IOrderedEnumerable`. Without `using System.Linq;`, methods like `Where()` won't appear.

### Q13. What is an IEnumerable<T>?
An interface (`System.Collections.Generic`) representing a **forward-only, read-only sequence** that can be iterated with `foreach`. It exposes `GetEnumerator()`. LINQ to Objects operates on it, and filtering happens **in memory**.

### Q14. What is an IQueryable<T>?
An interface (`System.Linq`) that inherits `IEnumerable<T>` and represents a **query that can be translated** by a provider (e.g., EF → SQL). It holds an **expression tree** (`Expression`) and a `Provider`.

### Q15. What is the difference between IEnumerable<T> and IQueryable<T>?

| | IEnumerable<T> | IQueryable<T> |
|---|---|---|
| Namespace | System.Collections.Generic | System.Linq |
| Uses | `Func<T,bool>` delegates | `Expression<Func<T,bool>>` expression trees |
| Filtering happens | In memory (client) | At source, e.g., database (server) |
| Best for | In-memory collections | Remote data (EF, OData) |
| Extensibility | None | Custom query providers |

```csharp
IEnumerable<Employee> a = context.Employees.Where(e => e.Salary > 50000); // runs on IQueryable (SQL WHERE)
// but if variable is typed IEnumerable BEFORE Where:
IEnumerable<Employee> all = context.Employees;
var b = all.Where(e => e.Salary > 50000); // loads ALL rows, filters in memory ❌
```

---

## 2. LINQ Query and Method Syntax

### Q16. What is LINQ Query Syntax?
SQL-like syntax using keywords `from … where … select`. The compiler converts it into method calls.

```csharp
var q = from n in numbers where n > 10 orderby n select n;
```

### Q17. What is LINQ Method Syntax?
Chaining **extension methods** with lambda expressions (also called *fluent syntax*).

```csharp
var q = numbers.Where(n => n > 10).OrderBy(n => n);
```

### Q18. Write a LINQ query to retrieve all even numbers from an integer array.
```csharp
int[] arr = { 1, 2, 3, 4, 5, 6 };
var evens = from n in arr where n % 2 == 0 select n; // 2,4,6
```

### Q19. Write the same even-number query using Method Syntax.
```csharp
var evens = arr.Where(n => n % 2 == 0); // 2,4,6
```

### Q20. Which syntax is more commonly used in modern C#: Query or Method Syntax?
**Method Syntax** — it supports *all* operators (e.g., `Take`, `Skip`, `Distinct`, `Any`, `Zip`), is more concise, and fits fluent chains. Query syntax is preferred mainly for complex **joins** and `let` clauses because it's more readable.

### Q21. Can Query Syntax and Method Syntax be combined?
Yes — wrap the query in parentheses and call methods on it.

```csharp
int count = (from n in numbers where n > 10 select n).Count();
var top3  = (from e in employees orderby e.Salary descending select e).Take(3);
```

### Q22. What is a lambda expression in LINQ?
An **anonymous function** written with `=>` (the "goes to" operator). In LINQ it is passed to operators as `Func<T,TResult>` (objects) or `Expression<Func<T,TResult>>` (IQueryable).

```csharp
Func<int,int> square = x => x * x;
```

### Q23. Explain: `numbers.Where(x => x > 10);`
It filters the sequence `numbers`, keeping elements **greater than 10**. For each element `x`, the lambda returns `true/false`. It returns an `IEnumerable<int>` and is **deferred** (it doesn't run until enumerated).

### Q24. What does `x => x > 10` represent?
A lambda: input parameter `x`, body `x > 10`. It is a **predicate** (`Func<int,bool>`) returning `true` when `x` is greater than 10.

### Q25. What is a predicate in LINQ?
A method/lambda that takes an element and returns **`bool`** — used for filtering/testing (`Where`, `Any`, `All`, `First`, `Count`). Type: `Func<T,bool>` (also `Predicate<T>` in `List<T>.Find`).

```csharp
Func<Employee,bool> highPaid = e => e.Salary > 50000;
var r = employees.Where(highPaid);
```

---

## 3. Filtering — Where()

### Q26. What is the purpose of Where()?
Filters a sequence, returning only elements for which the predicate is `true`. **Deferred execution**.

### Q27. Retrieve numbers greater than 50.
```csharp
var r = numbers.Where(n => n > 50); // 63, 90
```

### Q28. Retrieve numbers between 10 and 50.
```csharp
var r = numbers.Where(n => n >= 10 && n <= 50); // 12,21,50,10,12
```

### Q29. Retrieve all odd numbers.
```csharp
var odd = numbers.Where(n => n % 2 != 0); // 5,21,63,7
```
(Use `!= 0`, not `== 1`, so negative odd numbers also work.)

### Q30. Employees whose salary > ₹50,000.
```csharp
var r = employees.Where(e => e.Salary > 50000);
```

### Q31. Students whose marks > 70.
```csharp
var r = students.Where(s => s.Marks > 70);
```

### Q32. Can Where() be used multiple times?
Yes. Multiple `Where` calls behave like **AND**.

```csharp
var r = employees.Where(e => e.Salary > 50000).Where(e => e.Department == "IT");
// same as: .Where(e => e.Salary > 50000 && e.Department == "IT")
```

### Q33. What happens when Where() finds no matching element?
It returns an **empty sequence** (not null, no exception). `.ToList()` gives an empty list.

### Q34. Difference between Where() and Find()?

| | `Where()` | `Find()` |
|---|---|---|
| Defined on | `IEnumerable<T>` (extension) | `List<T>` / `Array` only |
| Returns | Sequence of **all** matches | **First** match or `default(T)` |
| Execution | Deferred | Immediate |

```csharp
var all   = employees.Where(e => e.Salary > 50000);  // many
var first = employees.Find(e => e.Salary > 50000);   // one (or null)
```

### Q35. Employees whose name starts with "A".
```csharp
var r = employees.Where(e => e.Name.StartsWith("A"));
// case-insensitive:
var r2 = employees.Where(e => e.Name.StartsWith("a", StringComparison.OrdinalIgnoreCase));
```

---

## 4. Projection — Select()

### Q36. What is the purpose of Select()?
**Transforms** each element into a new form (projection) — one input → one output.

### Q37. Difference between Where() and Select()?

| `Where` | `Select` |
|---|---|
| Filters (changes number of items) | Transforms (same number of items) |
| Returns same type `T` | Can return any type `TResult` |

```csharp
numbers.Where(n => n > 10);   // fewer items, still ints
numbers.Select(n => n * 2);   // same count, new values
```

### Q38. Retrieve only employee names.
```csharp
var names = employees.Select(e => e.Name);
```

### Q39. Retrieve only student marks.
```csharp
var marks = students.Select(s => s.Marks);
```

### Q40. Square of every number.
```csharp
var sq = numbers.Select(n => n * n);
```

### Q41. Convert every name to uppercase.
```csharp
var up = employees.Select(e => e.Name.ToUpper());
```

### Q42. What is projection in LINQ?
Projection means **shaping data** into a different form — picking specific properties, computing new values, or creating new types. `Select` and `SelectMany` are projection operators.

### Q43. Can Select() create a new anonymous object?
Yes.
```csharp
var r = employees.Select(e => new { e.Name, e.Salary });
```

### Q44. Return employee name and salary using an anonymous object.
```csharp
var r = employees.Select(e => new { EmployeeName = e.Name, e.Salary });
foreach (var x in r) Console.WriteLine($"{x.EmployeeName} - {x.Salary}");
```

### Q45. Difference between Select() and SelectMany()?

| `Select` | `SelectMany` |
|---|---|
| One→one | One→many, then **flattens** |
| Returns `IEnumerable<IEnumerable<T>>` for collection selectors | Returns flat `IEnumerable<T>` |

```csharp
var words = new[] { "hi there", "good day" };
words.Select(s => s.Split(' '));      // [["hi","there"],["good","day"]]  (nested)
words.SelectMany(s => s.Split(' '));  // ["hi","there","good","day"]      (flat)
```

---

## 5. Sorting

### Q46. What is OrderBy()?
Sorts ascending by a key. Returns `IOrderedEnumerable<T>`. **Stable** sort, deferred.

### Q47. What is OrderByDescending()?
Sorts in **descending** order by a key.

### Q48. Sort numbers ascending.
```csharp
var asc = numbers.OrderBy(n => n);
// query syntax: from n in numbers orderby n select n
```

### Q49. Sort numbers descending.
```csharp
var desc = numbers.OrderByDescending(n => n);
```

### Q50. Sort employees by salary.
```csharp
var r = employees.OrderBy(e => e.Salary);
```

### Q51. What is ThenBy()?
Adds a **secondary ascending** sort key *after* `OrderBy/OrderByDescending`.

### Q52. What is ThenByDescending()?
Adds a **secondary descending** key.

### Q53. Sort employees by department and then salary.
```csharp
var r = employees.OrderBy(e => e.Department).ThenBy(e => e.Salary);
// query: orderby e.Department, e.Salary
```

### Q54. What happens if ThenBy() is replaced by OrderBy()?
The second `OrderBy` **discards the previous ordering** and sorts the whole sequence only by the new key (stable, so ties keep the earlier order, but the department grouping is lost).

```csharp
employees.OrderBy(e => e.Department).OrderBy(e => e.Salary); // effectively sorted by Salary only
```
💡 Classic interview trap.

### Q55. Difference between OrderBy() and ThenBy()?
`OrderBy` starts a **new primary** sort. `ThenBy` is only available on `IOrderedEnumerable<T>` and refines ties of the previous sort.

---

## 6. Basic Aggregation

### Q56. Purpose of Count()?
Returns the number of elements (optionally matching a predicate). **Immediate**. Returns `int` (`LongCount` for `long`).

### Q57. Purpose of Sum()?
Adds numeric values. Returns 0 for an empty sequence.

### Q58. Purpose of Average()?
Computes the arithmetic mean. Throws `InvalidOperationException` on an **empty sequence** of non-nullable types.

### Q59. Purpose of Min()?
Returns the smallest value. Throws on empty non-nullable sequences.

### Q60. Purpose of Max()?
Returns the largest value. Throws on empty non-nullable sequences.

### Q61. Total salary of all employees.
```csharp
decimal total = employees.Sum(e => e.Salary);
```

### Q62. Average marks of students.
```csharp
double avg = students.Average(s => s.Marks);
```

### Q63. Highest salary.
```csharp
decimal max = employees.Max(e => e.Salary);
```

### Q64. Lowest marks.
```csharp
int min = students.Min(s => s.Marks);
```

### Q65. Count employees with salary > ₹50,000.
```csharp
int c = employees.Count(e => e.Salary > 50000);
```

---

## 7. Basic Element and Conversion Operations

### Q66. First() vs FirstOrDefault()?

| | `First()` | `FirstOrDefault()` |
|---|---|---|
| No match / empty | Throws `InvalidOperationException` | Returns `default(T)` (null/0) |
| Use when | Element must exist | Element may not exist |

```csharp
numbers.First(n => n > 1000);          // 💥 exception
numbers.FirstOrDefault(n => n > 1000); // 0
```

### Q67. Single() vs SingleOrDefault()?

| | `Single()` | `SingleOrDefault()` |
|---|---|---|
| 0 matches | Exception | `default` |
| 1 match | Returns it | Returns it |
| >1 matches | Exception | **Exception** |

### Q68. Purpose of ToList()?
Executes the query **immediately** and stores the results in a `List<T>`. Used to materialize/cache results.

### Q69. Purpose of ToArray()?
Executes immediately and stores results in an array `T[]`.

### Q70. First employee whose salary > ₹50,000.
```csharp
var emp = employees.FirstOrDefault(e => e.Salary > 50000);
if (emp != null) Console.WriteLine(emp.Name);
```

---

# 🟡 PART B — INTERMEDIATE LEVEL (Q71–145)

## 8. Element Operators

### Q71. Explain First() with an example.
Returns the **first element** (or first matching the predicate). Throws `InvalidOperationException` if none found.
```csharp
int a = numbers.First();            // 5
int b = numbers.First(n => n > 20); // 21
```

### Q72. Explain FirstOrDefault().
Same as `First()` but returns `default(T)` instead of throwing (0 for int, null for reference types). .NET 6+ lets you pass your own default: `FirstOrDefault(pred, -1)`.
```csharp
var e = employees.FirstOrDefault(x => x.Name == "Zed"); // null
```

### Q73. Explain Last().
Returns the **last element** (or last matching). Throws if none.
```csharp
numbers.Last();            // 90
numbers.Last(n => n < 10); // 7
```

### Q74. Explain LastOrDefault().
Like `Last()`, returns `default(T)` if no match.
```csharp
numbers.LastOrDefault(n => n > 1000); // 0
```

### Q75. Explain Single().
Returns the **only** element (matching the predicate). Throws if **zero or more than one**.
```csharp
var e = employees.Single(x => x.Id == 3); // ok
```
💡 Use for primary-key lookups where uniqueness is a business rule.

### Q76. Explain SingleOrDefault().
Returns the single element or `default` if none; **still throws if more than one**.
```csharp
var e = employees.SingleOrDefault(x => x.Id == 99); // null
```

### Q77. Explain ElementAt().
Returns the element at a **zero-based index**. Throws `ArgumentOutOfRangeException` if out of range.
```csharp
numbers.ElementAt(2); // 8
```
.NET 6+: supports `Index` e.g. `ElementAt(^1)` = last.

### Q78. Explain ElementAtOrDefault().
Returns the element at the index or `default(T)` if the index is out of range.
```csharp
numbers.ElementAtOrDefault(100); // 0
```

### Q79. What exception does First() throw on an empty sequence?
`InvalidOperationException` — message: *"Sequence contains no elements"* (or *"no matching element"* when a predicate is used).

### Q80. What exception does Single() throw when multiple elements match?
`InvalidOperationException` — *"Sequence contains more than one element"* (or *"more than one matching element"*).

---

## 9. Quantifier Operators

### Q81. What is Any()?
Returns `true` if the sequence has **at least one element** (or at least one satisfying the predicate). Short-circuits.
```csharp
numbers.Any();            // true
numbers.Any(n => n > 80); // true
```

### Q82. What is All()?
Returns `true` if **every** element satisfies the predicate.
```csharp
numbers.All(n => n > 0); // true
```

### Q83. What is Contains()?
Checks whether a value exists in the sequence (uses `EqualityComparer<T>.Default` or a supplied comparer).
```csharp
numbers.Contains(50); // true
new[]{"a","B"}.Contains("b", StringComparer.OrdinalIgnoreCase); // true
```

### Q84. Does the list contain at least one employee with salary > ₹100,000?
```csharp
bool exists = employees.Any(e => e.Salary > 100000);
```

### Q85. Check whether all students have marks > 40.
```csharp
bool allPass = students.All(s => s.Marks > 40); // false (Mohan = 35)
```

### Q86. Difference between Any() and Count() > 0?
Both tell if items exist. `Any()` **stops at the first match**; `Count()` may **traverse the entire sequence** (for non-`ICollection` sources). In EF, `Any()` → `EXISTS`, `Count() > 0` → `COUNT(*)`.

### Q87. Advantage of Any() over Count() > 0?
**Performance** (short-circuit O(1) best case vs O(n)), better SQL (`EXISTS`), and safer with lazily generated/infinite sequences.
```csharp
var infinite = Enumerable.Range(1, int.MaxValue);
infinite.Any(); // instant
// infinite.Count() > 0 → walks 2 billion items
```

### Q88. Check whether any product is out of stock.
```csharp
bool anyOut = products.Any(p => p.Stock == 0);
```

### Q89. Check whether all products have positive prices.
```csharp
bool allPositive = products.All(p => p.Price > 0);
```

### Q90. Behavior of Any() on an empty collection?
- `Any()` → **false**
- `Any(predicate)` → **false**
- Compare: `All(predicate)` on an empty collection → **true** (vacuous truth) — a famous interview trap.
```csharp
new List<int>().Any();           // false
new List<int>().All(x => x > 5); // true
```

---

## 10. Set Operators

### Q91. What is Distinct()?
Returns unique elements, removing duplicates (keeps first occurrence order).

### Q92. Remove duplicate numbers.
```csharp
var u = numbers.Distinct(); // 5,12,8,21,50,63,10,7,90
```

### Q93. What is Union()?
Returns the **distinct combination** of two sequences (A ∪ B).
```csharp
new[]{1,2,3}.Union(new[]{3,4}); // 1,2,3,4
```

### Q94. What is Intersect()?
Returns elements present in **both** sequences (A ∩ B), distinct.
```csharp
new[]{1,2,3}.Intersect(new[]{2,3,4}); // 2,3
```

### Q95. What is Except()?
Returns elements in the first sequence **not in** the second (A − B), distinct.
```csharp
new[]{1,2,3}.Except(new[]{2}); // 1,3
```

### Q96. Common elements between two arrays.
```csharp
int[] a = {1,2,3,4}, b = {3,4,5};
var common = a.Intersect(b); // 3,4
```

### Q97. Elements in first array but not in second.
```csharp
var diff = a.Except(b); // 1,2
```

### Q98. Combine two arrays without duplicates.
```csharp
var all = a.Union(b); // 1,2,3,4,5
```

### Q99. Union() vs Concat()?

| `Union` | `Concat` |
|---|---|
| Removes duplicates | Keeps duplicates |
| Slower (hashing) | Faster (simple append) |
| SQL `UNION` | SQL `UNION ALL` |
```csharp
a.Concat(b); // 1,2,3,4,3,4,5
```

### Q100. How does Distinct() determine whether two objects are equal?
It uses `EqualityComparer<T>.Default`:
- **Value types / strings**: by value.
- **Classes**: by **reference**, unless `Equals()` + `GetHashCode()` are overridden or an `IEqualityComparer<T>` is supplied.
- **Records**: value-based equality automatically.
- Anonymous types: value-based on all properties.

```csharp
class EmpComparer : IEqualityComparer<Employee>
{
    public bool Equals(Employee x, Employee y) => x.Id == y.Id;
    public int GetHashCode(Employee e) => e.Id.GetHashCode();
}
var unique = employees.Distinct(new EmpComparer());
// .NET 6+: employees.DistinctBy(e => e.Id);
```

---

## 11. Partitioning Operators

### Q101. What is Take()?
Returns the **first N** elements. `.Take(3)`. .NET 6+ also supports ranges: `Take(2..5)`.

### Q102. What is Skip()?
**Bypasses the first N** elements and returns the rest.

### Q103. Retrieve the first five employees.
```csharp
var r = employees.Take(5);
```

### Q104. Skip the first ten records and retrieve the rest.
```csharp
var r = records.Skip(10);
```

### Q105. What is TakeWhile()?
Takes elements **while the condition is true**, stops at the first failure.
```csharp
new[]{1,2,5,1,7}.TakeWhile(x => x < 5); // 1,2
```

### Q106. What is SkipWhile()?
Skips elements **while the condition is true**, then returns *all* remaining (even if later ones satisfy the condition).
```csharp
new[]{1,2,5,1,7}.SkipWhile(x => x < 5); // 5,1,7
```

### Q107. Take() vs TakeWhile()?
`Take(n)` = by **count**. `TakeWhile(pred)` = by **condition**, stops at first false. `Where` would give `1,2,1` but `TakeWhile` gives `1,2`.

### Q108. Skip() vs SkipWhile()?
`Skip(n)` = skip fixed count. `SkipWhile(pred)` = skip until predicate becomes false the first time; the rest is returned unfiltered.

### Q109. Implement pagination using Skip() and Take().
```csharp
IEnumerable<T> GetPage<T>(IEnumerable<T> source, int pageNumber, int pageSize)
    => source.Skip((pageNumber - 1) * pageSize).Take(pageSize);
```
💡 Always apply `OrderBy` before paging for deterministic results (EF requires it to avoid warnings).

### Q110. Retrieve page 3 when each page has 10 records.
```csharp
var page3 = employees.OrderBy(e => e.Id).Skip(20).Take(10); // (3-1)*10 = 20
```

---

## 12. Aggregation — Intermediate

### Q111. What is the Aggregate() method?
Applies an **accumulator function** over a sequence — like a general-purpose `reduce/fold`.
```csharp
int sum = numbers.Aggregate((acc, n) => acc + n);        // no seed
int sum2 = numbers.Aggregate(100, (acc, n) => acc + n);  // with seed
string s = numbers.Aggregate("", (acc, n) => acc + n + ","); // with seed & different type
```

### Q112. Product of all numbers using Aggregate().
```csharp
long product = new[]{1,2,3,4,5}.Aggregate(1L, (acc, n) => acc * n); // 120
```

### Q113. Find the longest string.
```csharp
var words = new[]{"cat","elephant","dog"};
var longest = words.OrderByDescending(w => w.Length).First(); // elephant
// .NET 6+: words.MaxBy(w => w.Length);
// Aggregate: words.Aggregate((a,b) => b.Length > a.Length ? b : a);
```

### Q114. Find the shortest string.
```csharp
var shortest = words.OrderBy(w => w.Length).First(); // cat
// words.MinBy(w => w.Length);
```

### Q115. Total salary of a particular department.
```csharp
decimal total = employees.Where(e => e.Department == "IT").Sum(e => e.Salary);
```

### Q116. Average salary of employees with salary > ₹40,000.
```csharp
decimal avg = employees.Where(e => e.Salary > 40000).Average(e => e.Salary);
```

### Q117. Employee with the highest salary.
```csharp
var top = employees.OrderByDescending(e => e.Salary).First();
// .NET 6+: employees.MaxBy(e => e.Salary);
```
⚠️ `employees.Max(e => e.Salary)` returns the **value**, not the employee.

### Q118. Employee with the lowest salary.
```csharp
var low = employees.OrderBy(e => e.Salary).First(); // or MinBy
```

### Q119. Second-highest salary.
```csharp
var second = employees.Select(e => e.Salary)
                      .Distinct()
                      .OrderByDescending(s => s)
                      .Skip(1)
                      .FirstOrDefault();
```
💡 `Distinct()` is essential — otherwise two people with the top salary make the "second" equal to the first.

### Q120. Third-highest salary.
```csharp
var third = employees.Select(e => e.Salary).Distinct()
                     .OrderByDescending(s => s).Skip(2).FirstOrDefault();
```

---

## 13. Grouping

### Q121. What is GroupBy()?
Groups elements by a key and returns `IEnumerable<IGrouping<TKey,TElement>>`. Deferred execution.
```csharp
var g = employees.GroupBy(e => e.Department);
```

### Q122. Group employees by department.
```csharp
foreach (var g in employees.GroupBy(e => e.Department))
{
    Console.WriteLine(g.Key);
    foreach (var e in g) Console.WriteLine("  " + e.Name);
}
```

### Q123. Count employees in each department.
```csharp
var r = employees.GroupBy(e => e.Department)
                 .Select(g => new { Dept = g.Key, Count = g.Count() });
```

### Q124. Average salary of each department.
```csharp
var r = employees.GroupBy(e => e.Department)
                 .Select(g => new { Dept = g.Key, Avg = g.Average(e => e.Salary) });
```

### Q125. Maximum salary in each department.
```csharp
var r = employees.GroupBy(e => e.Department)
                 .Select(g => new { Dept = g.Key, Max = g.Max(e => e.Salary) });
```

### Q126. Minimum salary in each department.
```csharp
var r = employees.GroupBy(e => e.Department)
                 .Select(g => new { Dept = g.Key, Min = g.Min(e => e.Salary) });
```

### Q127. Group students according to grade.
```csharp
var r = students.GroupBy(s => s.Grade);
// query: from s in students group s by s.Grade into g select g
```

### Q128. Group products according to category.
```csharp
var r = products.GroupBy(p => p.Category)
                .Select(g => new { Category = g.Key, Items = g.ToList() });
```

### Q129. Explain the structure of IGrouping<TKey,TElement>.
```csharp
public interface IGrouping<out TKey, out TElement> : IEnumerable<TElement>
{
    TKey Key { get; }
}
```
It is **a sequence of elements that share a common `Key`**. You can enumerate it, and use LINQ on it (`g.Count()`, `g.Sum()`).

### Q130. GroupBy() vs ToLookup()?

| | `GroupBy` | `ToLookup` |
|---|---|---|
| Execution | **Deferred** | **Immediate** |
| Returns | `IEnumerable<IGrouping>` | `ILookup<TKey,TElement>` |
| Key access | Only by iteration | **Indexer** `lookup["IT"]` |
| Missing key | n/a | Returns empty sequence |
| Mutability | Re-evaluated each time | Cached/immutable |
```csharp
var lookup = employees.ToLookup(e => e.Department);
foreach (var e in lookup["IT"]) Console.WriteLine(e.Name);
```

---

## 14. Joins

### Q131. What is a Join in LINQ?
Combines two sequences based on **matching keys** (like SQL JOIN). Methods: `Join`, `GroupJoin`.

### Q132. What is an Inner Join?
Returns only elements that have **matches in both** sequences; unmatched elements are dropped. `Join()` implements inner join.

### Q133. Join Employees and Departments.
```csharp
// Query syntax
var q = from e in employees
        join d in departments on e.DeptId equals d.Id
        select new { e.Name, Department = d.Name };

// Method syntax
var q2 = employees.Join(departments,
                        e => e.DeptId,
                        d => d.Id,
                        (e, d) => new { e.Name, Department = d.Name });
```

### Q134. What is GroupJoin()?
Joins two sequences and returns each outer element **with a collection of all matching inner elements** (hierarchical result). Basis for left outer join.
```csharp
var r = departments.GroupJoin(employees,
        d => d.Id, e => e.DeptId,
        (d, emps) => new { Dept = d.Name, Employees = emps });
```

### Q135. Join() vs GroupJoin()?

| `Join` | `GroupJoin` |
|---|---|
| Flat result (one row per match) | Hierarchical (outer + group of inner) |
| Inner join semantic | Keeps outer items with **no matches** (empty group) |
| Result selector gets `(outer, inner)` | Result selector gets `(outer, IEnumerable<inner>)` |

### Q136. Explain Left Outer Join in LINQ.
LINQ has no `LeftJoin` keyword (until .NET 10's `LeftJoin`). Standard pattern: **`GroupJoin` + `DefaultIfEmpty()`** — all left items are returned, with `null` for missing right items.

### Q137. Write a Left Outer Join query.
```csharp
// Query syntax
var q = from d in departments
        join e in employees on d.Id equals e.DeptId into empGroup
        from e in empGroup.DefaultIfEmpty()
        select new { Dept = d.Name, Employee = e?.Name ?? "No Employee" };

// Method syntax
var q2 = departments
    .GroupJoin(employees, d => d.Id, e => e.DeptId, (d, g) => new { d, g })
    .SelectMany(x => x.g.DefaultIfEmpty(), (x, e) => new { Dept = x.d.Name, Employee = e?.Name ?? "No Employee" });
```
Result includes **Finance → No Employee**.

### Q138. What is a Cross Join?
Cartesian product — every element of A paired with every element of B (**m × n** rows). No key.

### Q139. How can a Cross Join be implemented using LINQ?
```csharp
// Query syntax: two from clauses
var q = from a in new[]{1,2} from b in new[]{"x","y"} select new { a, b };

// Method syntax
var q2 = new[]{1,2}.SelectMany(a => new[]{"x","y"}, (a, b) => new { a, b });
// (1,x)(1,y)(2,x)(2,y)
// LINQ has no built-in CrossJoin operator — use one of the two forms above.
```

### Q140. Retrieve students along with their department names.
```csharp
var r = from s in students
        join d in departments on s.DeptId equals d.Id
        select new { s.Name, s.Marks, Department = d.Name };
```

---

## 15. SelectMany()

### Q141. What is SelectMany()?
Projects each element to a **collection** and **flattens** all collections into one sequence.

### Q142. Select() vs SelectMany()?
`Select` returns nested `IEnumerable<IEnumerable<T>>`; `SelectMany` returns flat `IEnumerable<T>`.
```csharp
var lists = new List<List<int>>{ new(){1,2}, new(){3} };
lists.Select(l => l);     // [[1,2],[3]]
lists.SelectMany(l => l); // 1,2,3
```

### Q143. Flatten a List<List<int>>.
```csharp
List<List<int>> nested = new() { new(){1,2}, new(){3,4}, new(){5} };
var flat = nested.SelectMany(x => x).ToList(); // 1,2,3,4,5
```

### Q144. Departments containing multiple employees — retrieve all employees using SelectMany().
```csharp
class Dept { public string Name; public List<Employee> Employees; }
List<Dept> depts = GetDepts();

var all = depts.SelectMany(d => d.Employees);

// with parent info
var withDept = depts.SelectMany(d => d.Employees,
                                (d, e) => new { Dept = d.Name, Employee = e.Name });
```

### Q145. When is SelectMany() useful in real-world applications?
- Flattening **one-to-many** relations (Order → OrderItems, Customer → Orders, Blog → Posts)
- Splitting text into words across many lines
- Collecting all permissions across user roles
- Cross joins / combinations
- Processing nested JSON/XML collections
```csharp
var allItems = orders.SelectMany(o => o.Items);
var words = lines.SelectMany(l => l.Split(' '));
```

---

# 🔴 PART C — HARD / ADVANCED LEVEL (Q146–200)

## 16. Deferred and Immediate Execution

### Q146. What is deferred execution in LINQ?
A LINQ query is **not executed when it is defined**, but when it is **enumerated** (`foreach`, `ToList()`, `Count()`, etc.). The query is just a *recipe*; it reads the source **at enumeration time**, so it always sees the latest data.

### Q147. What is immediate execution?
The query runs **right away** and the result is stored/returned — forced by operators that return a single value or a materialized collection.

### Q148. Which LINQ methods cause immediate execution?
- **Conversion:** `ToList()`, `ToArray()`, `ToDictionary()`, `ToHashSet()`, `ToLookup()`
- **Aggregation:** `Count()`, `Sum()`, `Average()`, `Min()`, `Max()`, `Aggregate()`
- **Element:** `First()`, `FirstOrDefault()`, `Last()`, `Single()`, `ElementAt()`
- **Quantifiers:** `Any()`, `All()`, `Contains()`, `SequenceEqual()`

Deferred ones: `Where`, `Select`, `SelectMany`, `OrderBy`, `GroupBy`, `Join`, `Skip`, `Take`, `Distinct`, `Union`, `Concat`, `Zip`…

### Q149. Does Where() immediately execute the query?
**No.** It returns a lazy iterator; the predicate runs only during enumeration.

### Q150. Does ToList() immediately execute the query?
**Yes.** It enumerates the source fully and copies the results into a `List<T>` snapshot.

### Q151. Explain the output.
```csharp
var numbers = new List<int> { 1, 3, 6, 8 };
var query = numbers.Where(x => x > 5);
numbers.Add(10);
foreach (var n in query)
    Console.WriteLine(n);
```
**Output:** `6  8  10`

**Why:** `query` is only defined at the `Where` line. `10` is added **before** enumeration; the `foreach` runs the query against the *current* list, which now contains 10. If we had written `.ToList()` on the query line, output would be only `6 8`.

### Q152. IEnumerable<T> vs a materialized List<T>?

| `IEnumerable<T>` (query) | `List<T>` (materialized) |
|---|---|
| May be lazy – recipe | Data stored in memory |
| Re-evaluated every enumeration | Snapshot, fast re-reads |
| Sees later changes | Does not |
| No `Count` property, no indexer | `Count`, indexer `[i]`, `Add`, `Remove` |
| Low memory | Uses memory |

### Q153. What problems can occur because of deferred execution?
1. **Multiple enumeration** → repeated DB calls/CPU work
2. **Stale/unexpected data** — results change if the source changes
3. **Captured variable** surprises:
   ```csharp
   int limit = 5;
   var q = numbers.Where(n => n > limit);
   limit = 50;                // q now uses 50!
   ```
4. **ObjectDisposedException** — EF query enumerated after `DbContext` disposed
5. **Exceptions appear late** (at enumeration, not at definition)
6. Side-effects in `Select` run multiple times

### Q154. How can you force immediate execution?
Call `ToList()`, `ToArray()`, `ToDictionary()`, `Count()`, `First()`, etc.
```csharp
var snapshot = numbers.Where(x => x > 5).ToList();
```

### Q155. Explain multiple enumeration in LINQ.
Enumerating the same deferred query more than once **re-executes it each time**.
```csharp
var q = context.Employees.Where(e => e.Salary > 50000);   // IQueryable
if (q.Any())                    // SQL query #1
    foreach (var e in q) { }    // SQL query #2
```
**Fix:** materialize once → `var list = q.ToList();`. Tools like ReSharper warn *"Possible multiple enumeration of IEnumerable"*.

---

## 17. Expression Trees and IQueryable

### Q156. What is an Expression Tree?
A **data structure (tree) representing code** as objects (`System.Linq.Expressions`), e.g. `Expression<Func<int,bool>> e = x => x > 5;` becomes nodes: `Lambda → GreaterThan → (Parameter x, Constant 5)`. It can be inspected, modified, translated (to SQL), or compiled (`e.Compile()`).

```csharp
Expression<Func<int,bool>> expr = x => x > 5;
var body = (BinaryExpression)expr.Body;
Console.WriteLine(body.NodeType); // GreaterThan
Func<int,bool> f = expr.Compile();
```

### Q157. Delegate vs expression tree?

| Delegate (`Func<>`) | Expression tree (`Expression<Func<>>`) |
|---|---|
| Compiled IL code (opaque) | Code as data (inspectable) |
| Can only be **executed** | Can be **analysed/translated/compiled** |
| Used by `IEnumerable` | Used by `IQueryable` |
| Fast to invoke | Needs translation/compilation |

### Q158. Why does IQueryable<T> use expression trees?
So the **provider can read the query's intent** and translate it to the target language (SQL, OData, Mongo…) instead of executing a C# delegate in memory. This allows filtering, sorting, paging **at the data source**.

### Q159. How does LINQ translate expressions into SQL?
1. Each operator (`Where`, `Select`…) on `IQueryable` appends a node to the **expression tree** (nothing executes).
2. On enumeration, the **provider** (EF Core) walks the tree through a *query translator/visitor*.
3. It maps nodes to SQL (`Where` → `WHERE`, `OrderBy` → `ORDER BY`, `Take` → `TOP/LIMIT`, `Any` → `EXISTS`, `GroupBy` → `GROUP BY`).
4. SQL is sent with **parameters** (SQL-injection safe), results are materialized into objects.

```csharp
var q = context.Employees.Where(e => e.Salary > 50000).OrderBy(e => e.Name).Take(5);
Console.WriteLine(q.ToQueryString());
// SELECT TOP(5) ... FROM Employees WHERE Salary > @p ORDER BY Name
```

### Q160. LINQ to Objects vs LINQ to Entities?

| | LINQ to Objects | LINQ to Entities |
|---|---|---|
| Source | In-memory `IEnumerable<T>` | Database via EF (`IQueryable<T>`) |
| Input type | Delegates | Expression trees |
| Executes | In CLR memory | Translated to SQL, runs in DB |
| Any C# method allowed | Yes | Only translatable ones |
| Execution | Deferred/immediate | Deferred until enumerated (DB round-trip) |

### Q161. Explain client-side vs server-side evaluation.
- **Server-side:** the part of the query translated to SQL and executed by the DB.
- **Client-side:** the part executed in your app's memory (after data is fetched), e.g. custom C# methods, or anything after `ToList()`/`AsEnumerable()`.

EF Core 3.0+ allows client evaluation **only in the final projection (`Select`)**; elsewhere it throws.
```csharp
context.Employees
    .Where(e => e.Salary > 50000)                // server (SQL WHERE)
    .AsEnumerable()                              // switch
    .Where(e => IsLuckyName(e.Name));            // client (C# method)
```

### Q162. Why should filtering preferably be performed in the database?
- **Less data over the network** (only needed rows)
- **Lower memory** in the app
- DB uses **indexes** and optimized plans
- Better **scalability** and speed

### Q163. Compare the two queries.
```csharp
// (1) Server-side filtering
context.Employees.Where(e => e.Salary > 50000).ToList();
//   SQL: SELECT * FROM Employees WHERE Salary > 50000

// (2) Client-side filtering
context.Employees.ToList().Where(e => e.Salary > 50000);
//   SQL: SELECT * FROM Employees   (loads ALL rows), then filters in memory
```
(1) `Where` is applied on `IQueryable` → becomes SQL. (2) `ToList()` runs first → entire table loaded, then `Where` runs on `IEnumerable` (LINQ to Objects).

### Q164. Which is more efficient and why?
**Query (1).** Only matching rows are fetched; the DB can use an index on `Salary`; network & memory use are minimal. Query (2) pulls the whole table (bad for millions of rows) and filters in the app.

### Q165. What happens when an EF LINQ query cannot be translated to SQL?
- **EF Core 3.0+:** throws `InvalidOperationException` — *"The LINQ expression '...' could not be translated. Either rewrite the query in a form that can be translated, or switch to client evaluation explicitly by inserting a call to 'AsEnumerable', 'AsAsyncEnumerable', 'ToList', or 'ToListAsync'."*
- **EF Core 2.x and EF6:** silently evaluated on client (hidden performance bug).

**Fixes:** use translatable members (`EF.Functions.Like`), move filter to a supported form, or deliberately switch to client evaluation after server-side filtering with `AsEnumerable()`.

---

## 18. Advanced Grouping and Aggregation

### Q166. Department with the highest average salary.
```csharp
var r = employees.GroupBy(e => e.Department)
                 .Select(g => new { Dept = g.Key, Avg = g.Average(e => e.Salary) })
                 .OrderByDescending(x => x.Avg)
                 .First();
```

### Q167. Department containing the highest-paid employee.
```csharp
var dept = employees.OrderByDescending(e => e.Salary).First().Department;
// or: employees.MaxBy(e => e.Salary)?.Department;
```

### Q168. Second-highest salary in each department.
```csharp
var r = employees.GroupBy(e => e.Department)
    .Select(g => new
    {
        Dept = g.Key,
        SecondHighest = g.Select(e => e.Salary).Distinct()
                         .OrderByDescending(s => s).Skip(1).FirstOrDefault()
    });
```

### Q169. Find duplicate employee names.
```csharp
var dups = employees.GroupBy(e => e.Name)
                    .Where(g => g.Count() > 1)
                    .Select(g => g.Key);
```

### Q170. Find duplicate records based on multiple properties.
```csharp
var dups = employees.GroupBy(e => new { e.Name, e.Department })   // anonymous composite key
                    .Where(g => g.Count() > 1)
                    .SelectMany(g => g);   // returns the actual duplicate records
```
💡 Anonymous types implement value equality, so they are perfect composite keys.

### Q171. Employees whose salary > their department's average salary.
```csharp
var r = employees.GroupBy(e => e.Department)
    .SelectMany(g =>
    {
        var avg = g.Average(e => e.Salary);
        return g.Where(e => e.Salary > avg);
    });

// Alternative (EF-friendly, uses correlated subquery)
var r2 = employees.Where(e => e.Salary >
            employees.Where(x => x.Department == e.Department).Average(x => x.Salary));
```

### Q172. Top three highest-paid employees from each department.
```csharp
var r = employees.GroupBy(e => e.Department)
                 .SelectMany(g => g.OrderByDescending(e => e.Salary).Take(3));
```

### Q173. Department having more than five employees.
```csharp
var r = employees.GroupBy(e => e.Department)
                 .Where(g => g.Count() > 5)
                 .Select(g => g.Key);
```

### Q174. Department with the maximum number of employees.
```csharp
var r = employees.GroupBy(e => e.Department)
                 .OrderByDescending(g => g.Count())
                 .Select(g => new { Dept = g.Key, Count = g.Count() })
                 .First();
```

### Q175. Highest salary for each job title.
```csharp
var r = employees.GroupBy(e => e.JobTitle)
                 .Select(g => new { Title = g.Key, MaxSalary = g.Max(e => e.Salary) });
```

---

## 19. Advanced Sorting

### Q176. Sort employees by salary descending and name ascending.
```csharp
var r = employees.OrderByDescending(e => e.Salary).ThenBy(e => e.Name);
// query: orderby e.Salary descending, e.Name
```

### Q177. Sort students by marks descending and name ascending.
```csharp
var r = students.OrderByDescending(s => s.Marks).ThenBy(s => s.Name);
```

### Q178. Sort strings by length then alphabetically.
```csharp
var r = words.OrderBy(w => w.Length).ThenBy(w => w);
```

### Q179. Implement custom sorting using OrderBy().
**Option 1 – custom key selector:**
```csharp
// "IT" first, then others alphabetically
var r = employees.OrderBy(e => e.Department == "IT" ? 0 : 1)
                 .ThenBy(e => e.Department);
```
**Option 2 – custom `IComparer<T>`:**
```csharp
class LengthComparer : IComparer<string>
{
    public int Compare(string x, string y) => x.Length.CompareTo(y.Length);
}
var r2 = words.OrderBy(w => w, new LengthComparer());
```

### Q180. How does LINQ sorting handle duplicate keys?
`OrderBy`/`OrderByDescending` are **stable sorts**: elements with equal keys **keep their original relative order**. (Unlike `List<T>.Sort()`, which is unstable.) Use `ThenBy` to break ties explicitly.

---

## 20. Anonymous Types and Projection

### Q181. Anonymous object with employee name, department, and salary.
```csharp
var r = employees.Select(e => new { e.Name, e.Department, e.Salary });
```

### Q182. Salary after a 10% increment.
```csharp
var r = employees.Select(e => new { e.Name, OldSalary = e.Salary, NewSalary = e.Salary * 1.10m });
```

### Q183. Projection containing Name, Salary, Tax, NetSalary.
```csharp
var r = employees.Select(e => new
{
    e.Name,
    e.Salary,
    Tax = e.Salary * 0.10m,
    NetSalary = e.Salary - (e.Salary * 0.10m)
});
// using let in query syntax (avoid repeated calculation):
var r2 = from e in employees
         let tax = e.Salary * 0.10m
         select new { e.Name, e.Salary, Tax = tax, NetSalary = e.Salary - tax };
```

### Q184. Nested anonymous objects.
```csharp
var r = employees.Select(e => new
{
    e.Name,
    Job = new { e.JobTitle, e.Department },
    Pay = new { e.Salary, Tax = e.Salary * 0.1m }
});
Console.WriteLine(r.First().Job.Department);
```

### Q185. Why are anonymous types commonly used with LINQ projections?
- Create **lightweight, read-only shapes** without defining a class
- Return only needed columns (efficient SQL `SELECT` of those columns)
- Type-safe with IntelliSense (`var`)
- Value-based `Equals/GetHashCode` (good for `GroupBy`, `Distinct`)
- Perfect for temporary/intermediate results

⚠️ Limitations: cannot be returned from a method as a strong type (use DTO/record/tuple), properties are read-only, scope is local.

---

## 21. Complex Joins

### Q186. Join Employees, Departments, and Projects.
```csharp
var r = from e in employees
        join d in departments on e.DeptId equals d.Id
        join p in projects on e.Id equals p.EmployeeId
        select new { Employee = e.Name, Department = d.Name, Project = p.Name };

// Method syntax
var r2 = employees
    .Join(departments, e => e.DeptId, d => d.Id, (e, d) => new { e, d })
    .Join(projects, x => x.e.Id, p => p.EmployeeId,
          (x, p) => new { Employee = x.e.Name, Department = x.d.Name, Project = p.Name });
```

### Q187. Left Outer Join between Employees and Departments.
```csharp
var r = from e in employees
        join d in departments on e.DeptId equals d.Id into deptGroup
        from d in deptGroup.DefaultIfEmpty()
        select new { Employee = e.Name, Department = d?.Name ?? "No Department" };
```
All employees appear, even those without a matching department.

### Q188. Departments that do not have any employees.
```csharp
var r = departments.Where(d => !employees.Any(e => e.DeptId == d.Id));
// Alternative with GroupJoin:
var r2 = departments.GroupJoin(employees, d => d.Id, e => e.DeptId, (d, g) => new { d, g })
                    .Where(x => !x.g.Any()).Select(x => x.d);
// Alternative with Except on keys:
var ids = departments.Select(d => d.Id).Except(employees.Select(e => e.DeptId));
```
Result: **Finance**.

### Q189. Employees not assigned to any project.
```csharp
var r = employees.Where(e => !projects.Any(p => p.EmployeeId == e.Id));
// or: employees.Where(e => !projects.Select(p => p.EmployeeId).Contains(e.Id));
```

### Q190. Self-join to find employees and their managers.
```csharp
var r = from e in employees
        join m in employees on e.ManagerId equals m.Id into mg
        from m in mg.DefaultIfEmpty()          // left join so the top boss is included
        select new { Employee = e.Name, Manager = m?.Name ?? "No Manager" };

// Method syntax (inner join – excludes employees without manager)
var r2 = employees.Join(employees, e => e.ManagerId, m => (int?)m.Id,
                        (e, m) => new { Employee = e.Name, Manager = m.Name });
```
💡 `ManagerId` is `int?`, so the key types must match: cast the other key to `int?`.

---

## 22. Advanced Practical Coding

### Q191. First non-repeating character in a string.
```csharp
string s = "swiss";
char? ch = s.GroupBy(c => c)
            .Where(g => g.Count() == 1)
            .Select(g => (char?)g.Key)
            .FirstOrDefault();                  // 'w'

// Alternative (clean)
char r = s.FirstOrDefault(c => s.Count(x => x == c) == 1);   // O(n²) but short
```
`GroupBy` preserves the order of **first appearance** of each key, so `First` gives the first non-repeating char.

### Q192. First repeating character in a string.
```csharp
string s = "programming";
var seen = new HashSet<char>();
char r = s.FirstOrDefault(c => !seen.Add(c));   // 'r' (the first char whose 2nd occurrence appears earliest)

// GroupBy version: first char (by first appearance) that occurs more than once
char r2 = s.GroupBy(c => c).Where(g => g.Count() > 1).Select(g => g.Key).FirstOrDefault();  // 'r'
```
`HashSet.Add` returns `false` when the item already exists.

### Q193. All duplicate characters in a string.
```csharp
string s = "programming";
var dups = s.GroupBy(c => c).Where(g => g.Count() > 1).Select(g => g.Key);  // r, g, m
```

### Q194. Frequency of every character.
```csharp
var freq = s.GroupBy(c => c)
            .Select(g => new { Char = g.Key, Count = g.Count() });
// As dictionary
var dict = s.GroupBy(c => c).ToDictionary(g => g.Key, g => g.Count());
```

### Q195. Frequency of every word in a sentence.
```csharp
string sentence = "the cat and the hat and the bat";
var freq = sentence.Split(' ', StringSplitOptions.RemoveEmptyEntries)
                   .GroupBy(w => w.ToLower())
                   .Select(g => new { Word = g.Key, Count = g.Count() })
                   .OrderByDescending(x => x.Count);
// the=3, and=2, cat=1, hat=1, bat=1
```

### Q196. Longest word in a sentence.
```csharp
string longest = sentence.Split(' ', StringSplitOptions.RemoveEmptyEntries)
                         .OrderByDescending(w => w.Length)
                         .First();
// .NET 6+: .MaxBy(w => w.Length)
```

### Q197. Second-longest word in a sentence.
```csharp
var words = sentence.Split(' ', StringSplitOptions.RemoveEmptyEntries).Distinct();

// Second distinct LENGTH (handles ties correctly)
int secondLen = words.Select(w => w.Length).Distinct()
                     .OrderByDescending(l => l).Skip(1).FirstOrDefault();
string second = words.FirstOrDefault(w => w.Length == secondLen);

// Simple version (by position in sorted list)
string simple = words.OrderByDescending(w => w.Length).Skip(1).FirstOrDefault();
```
💡 Mention the tie-handling difference in an interview.

### Q198. All numbers that occur more than once in an integer array.
```csharp
int[] arr = { 1, 2, 3, 2, 4, 3, 5, 3 };
var dups = arr.GroupBy(x => x).Where(g => g.Count() > 1).Select(g => g.Key); // 2, 3
```

### Q199. Intersection of three collections.
```csharp
var a = new[]{1,2,3,4,5};
var b = new[]{3,4,5,6};
var c = new[]{4,5,7};
var common = a.Intersect(b).Intersect(c);   // 4,5

// For N collections:
var lists = new[]{ a, b, c };
var commonAll = lists.Aggregate((x, y) => x.Intersect(y).ToArray());
```

### Q200. Complete query: group by department, count, average, max, min, only > 3 employees, sort by average salary descending.
```csharp
var result = employees
    .GroupBy(e => e.Department)
    .Select(g => new
    {
        Department  = g.Key,
        EmployeeCount = g.Count(),
        AverageSalary = g.Average(e => e.Salary),
        MaxSalary   = g.Max(e => e.Salary),
        MinSalary   = g.Min(e => e.Salary)
    })
    .Where(x => x.EmployeeCount > 3)
    .OrderByDescending(x => x.AverageSalary);

foreach (var d in result)
    Console.WriteLine($"{d.Department}: Count={d.EmployeeCount}, Avg={d.AverageSalary}, Max={d.MaxSalary}, Min={d.MinSalary}");
```
**Query syntax version:**
```csharp
var result2 = from e in employees
              group e by e.Department into g
              where g.Count() > 3
              let avg = g.Average(x => x.Salary)
              orderby avg descending
              select new
              {
                  Department = g.Key,
                  EmployeeCount = g.Count(),
                  AverageSalary = avg,
                  MaxSalary = g.Max(x => x.Salary),
                  MinSalary = g.Min(x => x.Salary)
              };
```
💡 Filtering with `Where` **after** grouping is the LINQ equivalent of SQL `HAVING`; `Where` **before** `GroupBy` is SQL `WHERE`.

---

# 📌 Quick Revision Cheat Sheet

| Category | Operators | Execution |
|---|---|---|
| Filtering | `Where`, `OfType` | Deferred |
| Projection | `Select`, `SelectMany` | Deferred |
| Sorting | `OrderBy`, `ThenBy`, `Reverse` | Deferred (buffers) |
| Grouping | `GroupBy` / `ToLookup` | Deferred / Immediate |
| Joins | `Join`, `GroupJoin`, `Zip` | Deferred |
| Sets | `Distinct`, `Union`, `Intersect`, `Except`, `Concat` | Deferred |
| Partitioning | `Take`, `Skip`, `TakeWhile`, `SkipWhile`, `Chunk` | Deferred |
| Element | `First`, `Last`, `Single`, `ElementAt` (+OrDefault) | Immediate |
| Quantifiers | `Any`, `All`, `Contains` | Immediate |
| Aggregates | `Count`, `Sum`, `Average`, `Min`, `Max`, `Aggregate` | Immediate |
| Conversion | `ToList`, `ToArray`, `ToDictionary`, `ToHashSet`, `AsEnumerable`, `AsQueryable` | Immediate (As* = deferred) |

## 🎯 Top Interview Traps to Remember
1. `All()` on empty sequence → **true**; `Any()` → **false**.
2. `OrderBy().OrderBy()` ≠ `OrderBy().ThenBy()`.
3. `Single()` throws for 0 **and** >1 items; `SingleOrDefault()` still throws for >1.
4. `ToList()` before `Where()` on EF = loads the **entire table**.
5. Deferred execution: results reflect the source **at enumeration time**.
6. `Union` removes duplicates; `Concat` doesn't.
7. Always use `Distinct()` when finding the Nth-highest **value**.
8. `Average/Min/Max` on empty non-nullable sequences throw `InvalidOperationException`.
9. `GroupBy` is deferred; `ToLookup` is immediate.
10. Left join = `GroupJoin` + `SelectMany` + `DefaultIfEmpty`.

---
✅ **All 200 questions covered.**
