# C# Basic to Advanced + OOP — 500 Interview Questions with Answers

> Every question is answered with: **Answer**, a short **Example**, and an **🎯 Interview Point**.
> Examples target modern C# (C# 12/.NET 8) unless noted.

## Table of Contents
1. C# Fundamentals (1–50)
2. Data Types and Operators (51–100)
3. Control Statements and Loops (101–130)
4. Methods and Parameters (131–165)
5. Arrays and Strings (166–210)
6. OOP Fundamentals (211–260)
7. Inheritance and Polymorphism (261–310)
8. Interfaces and Advanced OOP (311–350)
9. Collections (351–390)
10. Exception Handling (391–420)
11. Delegates, Events and Lambda (421–445)
12. Generics and LINQ (446–475)
13. Advanced C# and Technical Interview (476–500)

---

# Section 1 — C# Fundamentals (Q1–50)

**Q1. What is C#?**
**Answer:** C# is a modern, statically typed, object-oriented, type-safe language from Microsoft that compiles to IL and runs on the .NET runtime.
**Example:** `Console.WriteLine("Hello");`
**🎯 Interview Point:** Mention: multi-paradigm (OOP, functional features, async), garbage collected, cross-platform via .NET.

**Q2. What are the main features of C#?**
**Answer:** Type safety, OOP, garbage collection, generics, LINQ, async/await, properties, delegates/events, pattern matching, records, nullable reference types, exception handling, interoperability.
**Example:** `var evens = nums.Where(n => n % 2 == 0);` (LINQ + lambda)
**🎯 Interview Point:** Pick 4–5 and give a one-line use for each.

**Q3. What is .NET?**
**Answer:** A developer platform containing runtime (CLR), base class libraries (BCL), and tooling (SDK) to build web, desktop, mobile, cloud, and console apps.
**Example:** `dotnet new console` then `dotnet run`.
**🎯 Interview Point:** Modern .NET (5+) unifies .NET Framework, .NET Core, and Xamarin lines.

**Q4. What is the difference between C# and .NET?**
**Answer:** C# is a *language*; .NET is the *platform* (runtime + libraries). F# and VB.NET also run on .NET.
**Example:** `List<int>` is a .NET (BCL) type; `class`, `if`, `async` are C# language syntax.
**🎯 Interview Point:** "Language vs framework/runtime" is the expected one-liner.

**Q5. What is CLR?**
**Answer:** Common Language Runtime — executes IL via JIT, manages memory (GC), type safety, exceptions, security, threading.
**Example:** C# → IL (compile time) → JIT → machine code (run time).
**🎯 Interview Point:** Name its services: JIT, GC, type loader, exception handling, thread management.

**Q6. What is CTS?**
**Answer:** Common Type System defines how types are declared and used across .NET languages (value types, reference types, interfaces, delegates, enums).
**Example:** C# `int` = VB `Integer` = `System.Int32`.
**🎯 Interview Point:** CTS enables cross-language type compatibility.

**Q7. What is CLS?**
**Answer:** Common Language Specification — a *subset* of CTS rules a language must follow to be interoperable with other .NET languages.
**Example:** `[assembly: CLSCompliant(true)]` — public `uint` would trigger a warning (unsigned isn't CLS-compliant).
**🎯 Interview Point:** CLS = minimum rules for interoperability; case-only-different names are non-compliant.

**Q8. What is managed code?**
**Answer:** Code executed under CLR control (memory, security, exceptions managed).
**Example:** Any normal C# program.
**🎯 Interview Point:** Benefit: automatic GC, fewer memory leaks/buffer overruns.

**Q9. What is unmanaged code?**
**Answer:** Code that runs outside CLR (C/C++, Win32 API, COM) and manages its own memory.
**Example:** `[DllImport("user32.dll")] static extern int MessageBox(IntPtr h, string t, string c, uint type);`
**🎯 Interview Point:** Accessed through P/Invoke or COM interop; you must free native resources yourself.

**Q10. Difference between managed and unmanaged code?**
| | Managed | Unmanaged |
|---|---|---|
| Runtime | CLR | OS directly |
| Memory | GC | Manual |
| Safety | Type-safe | Not guaranteed |
| Examples | C#, F# | C, C++ |

**🎯 Interview Point:** Mention `IDisposable`/`SafeHandle` to bridge the two.

**Q11. What is an assembly in C#?**
**Answer:** The compiled unit of deployment (.dll/.exe) containing IL, metadata, manifest, and resources. Unit of versioning, security, and deployment.
**Example:** `Assembly.GetExecutingAssembly().GetName().Version`
**🎯 Interview Point:** Contains manifest + metadata + IL + resources.

**Q12. What is an executable assembly?**
**Answer:** An assembly with an entry point (`Main`) that can be run directly (.exe, or apphost + .dll in .NET Core).
**Example:** A console app project (`OutputType=Exe`).
**🎯 Interview Point:** Library = no entry point; executable = has one.

**Q13. What is a DLL?**
**Answer:** Dynamic Link Library — a reusable assembly with no entry point, loaded by other apps.
**Example:** A Class Library project outputs `MyLib.dll`.
**🎯 Interview Point:** Promotes reuse; multiple apps share it.

**Q14. Difference between .exe and .dll?**
**Answer:** `.exe` has an entry point and runs standalone; `.dll` is loaded by another process and can't run itself.
**Example:** `dotnet MyApp.dll` runs a .NET Core "exe" (it's actually a DLL + host).
**🎯 Interview Point:** In .NET Core, even apps are DLLs launched by `dotnet` or an apphost.

**Q15. What is the purpose of Main()?**
**Answer:** The program entry point where execution starts.
```csharp
class Program { static void Main() => Console.WriteLine("Start"); }
```
**🎯 Interview Point:** With top-level statements (C# 9+) the compiler generates `Main` for you.

**Q16. Different signatures of Main()?**
```csharp
static void Main()
static void Main(string[] args)
static int Main()
static int Main(string[] args)
static async Task Main(string[] args)
static async Task<int> Main(string[] args)
```
**🎯 Interview Point:** Must be `static`; return `void`, `int`, `Task`, or `Task<int>`.

**Q17. Can a C# program have multiple Main() methods?**
**Answer:** Yes in different classes, but you must pick the entry point with `<StartupObject>` (or `/main` compiler option); otherwise error CS0017.
**🎯 Interview Point:** Useful for test/demo entry points.

**Q18. What is a namespace?**
**Answer:** A logical container that organizes types and prevents name collisions.
```csharp
namespace Shop.Models { public class Order { } }
```
**🎯 Interview Point:** File-scoped namespace: `namespace Shop.Models;`.

**Q19. Why are namespaces used?**
**Answer:** Organization, avoiding naming conflicts, readability, and grouping related functionality.
**Example:** `Shop.Models.Order` vs `Shop.Reports.Order`.
**🎯 Interview Point:** Use `using` aliases to resolve conflicts: `using R = Shop.Reports;`.

**Q20. Difference between namespace and class?**
**Answer:** A namespace is a logical grouping (no instances, no members like fields); a class is a type that defines data/behavior and can be instantiated.
**🎯 Interview Point:** Namespaces can't have access modifiers; classes can.

**Q21. What are access modifiers?**
**Answer:** Keywords that control visibility: `public`, `private`, `protected`, `internal`, `protected internal`, `private protected`.
**🎯 Interview Point:** They implement *encapsulation*.

**Q22. Explain public.**
Accessible from anywhere. `public class Car { public string Name; }`
**🎯** No restriction; expose only what's needed.

**Q23. Explain private.**
Accessible only inside the containing type. `private int _speed;`
**🎯** Default for members; core of encapsulation.

**Q24. Explain protected.**
Accessible in the declaring class and derived classes.
```csharp
class A { protected int x; }
class B : A { void F() => x = 1; }
```
**🎯** Not accessible via an instance of the base class from outside.

**Q25. Explain internal.**
Accessible within the same assembly only.
`internal class Helper {}`
**🎯** Use `[InternalsVisibleTo("Tests")]` for unit testing.

**Q26. Explain protected internal.**
Accessible in the same assembly **OR** in derived classes (even other assemblies).
**🎯** It's a union (OR).

**Q27. Explain private protected.**
Accessible in derived classes **AND** in the same assembly only (C# 7.2).
**🎯** It's an intersection (AND) — narrower than `protected internal`.

**Q28. Default access modifier for a class?**
`internal` (top-level); nested classes default to `private`.
**🎯** Trick question: top-level vs nested.

**Q29. Default access modifier for class members?**
`private`. (Interface members: `public`; enum members: `public`; struct members: `private`.)
**🎯** Know the defaults for each type kind.

**Q30. What is a variable?**
A named storage location holding a value of a given type.
`int age = 25;`
**🎯** Must be definitely assigned before use.

**Q31. What is a constant?**
A compile-time fixed value declared with `const`.
`const double Pi = 3.14159;`
**🎯** Implicitly static; value is baked into calling code at compile time.

**Q32. Difference between const and readonly?**
| | const | readonly |
|---|---|---|
| Assigned | Declaration only | Declaration or constructor |
| Time | Compile time | Run time |
| Static | Implicitly | Instance or static |
| Types | Primitives/string/null | Any type |

```csharp
class C { public const int A = 1; public readonly DateTime Created = DateTime.Now; }
```
**🎯** Changing a `const` in a library requires recompiling dependents; `readonly` doesn't.

**Q33. Can a const variable be changed?**
No — compile-time error CS0131/CS0198.
**🎯** Use `static readonly` if value is computed at runtime.

**Q34. Can a readonly variable be assigned inside a constructor?**
Yes (instance readonly in instance ctor; static readonly in static ctor).
```csharp
class P { readonly int id; P(int i) { id = i; } }
```
**🎯** Also assignable in field initializers.

**Q35. What is a literal?**
A fixed value written directly in code: `10`, `3.5f`, `"hi"`, `'a'`, `true`, `null`.
**🎯** Suffixes: `f`, `d`, `m`, `L`, `UL`.

**Q36. What are identifiers?**
Names given to variables, methods, classes, etc. Must start with letter or `_`, no spaces, not a keyword (unless prefixed `@`).
`int @class = 5;`
**🎯** Case-sensitive; follow PascalCase/camelCase conventions.

**Q37. What are C# keywords?**
Reserved words with predefined meaning: `class`, `if`, `for`, `static`, `async`… There are reserved and contextual keywords (`var`, `get`, `value`).
**🎯** Contextual keywords can be identifiers outside their context.

**Q38. What is the var keyword?**
Compiler infers the type from the initializer; still statically typed.
`var list = new List<string>();`
**🎯** Not dynamic. Required for anonymous types.

**Q39. What is implicit typing?**
Letting the compiler deduce type (`var`). `var x = 10;` → `int`.
**🎯** Use when type is obvious from the right-hand side.

**Q40. Can var be declared without initialization?**
No — `var x;` is error CS0818 (compiler can't infer).
**🎯** Also can't be `null` initialised: `var x = null;` fails.

**Q41. What is dynamic?**
Type resolved at **run time**; compile-time checking is skipped.
```csharp
dynamic d = 5; d = "text"; Console.WriteLine(d.Length);
```
**🎯** Uses the DLR; errors surface as `RuntimeBinderException`.

**Q42. Difference between var and dynamic?**
| | var | dynamic |
|---|---|---|
| Binding | Compile time | Run time |
| Type change | No | Yes |
| IntelliSense | Yes | No |
| Initialization | Required | Not required |

**Q43. Difference between object, var, and dynamic?**
- `object`: static type object, needs casting to use members, boxing for value types.
- `var`: compiler-inferred specific type.
- `dynamic`: run-time resolved, no cast needed.
```csharp
object o = "hi"; // o.Length ❌ needs ((string)o).Length
dynamic d = "hi"; // d.Length ✅
```

**Q44. What is type inference?**
Compiler determining types automatically (`var`, lambdas, generic method arguments).
`var r = Max(3, 5); // T inferred as int`
**🎯** Works for generic method calls without explicit `<T>`.

**Q45. What is type casting?**
Converting a value from one type to another (implicit/explicit/helper methods like `Convert`, `Parse`).
**🎯** Know `Convert.ToInt32`, `int.Parse`, `int.TryParse` differences.

**Q46. What is implicit conversion?**
Automatic safe conversion (no data loss): `int i = 5; long l = i;`
**🎯** Widening conversions.

**Q47. What is explicit conversion?**
Cast needed because of possible data loss: `double d = 9.8; int i = (int)d; // 9`
**🎯** Truncates; may throw in `checked` context.

**Q48. What is boxing?**
Converting a value type to `object`/interface — allocates on the heap.
`int i = 10; object o = i;`
**🎯** Performance cost: allocation + GC.

**Q49. What is unboxing?**
Extracting the value type from the object: `int j = (int)o;`
**🎯** Must unbox to the *exact* original type, otherwise `InvalidCastException`.

**Q50. Boxing and unboxing with a practical example.**
```csharp
ArrayList list = new();
list.Add(10);           // boxing
int x = (int)list[0];   // unboxing
// object o = 10; long l = (long)o; // ❌ InvalidCastException
List<int> good = new(); good.Add(10); // no boxing – use generics
```
**🎯** Say: "Generics eliminated most boxing; avoid `ArrayList` and `string.Format` with value types in hot paths."

---

# Section 2 — Data Types and Operators (Q51–100)

**Q51. What are value types?**
Types storing data directly (usually on stack or inline in containing object): `int`, `double`, `bool`, `char`, `struct`, `enum`, `DateTime`.
```csharp
int a = 5; int b = a; b = 10; // a still 5
```
**🎯** Copy-by-value semantics; derive from `System.ValueType`.

**Q52. What are reference types?**
Types storing a reference to heap data: `class`, `string`, `array`, `delegate`, `interface`, `object`, `record`.
```csharp
var p1 = new Person{Name="A"}; var p2 = p1; p2.Name="B"; // p1.Name == "B"
```
**🎯** Default is `null`; GC-managed.

**Q53. Difference between value and reference types?**
| | Value | Reference |
|---|---|---|
| Storage | Stack/inline | Heap (ref on stack) |
| Assignment | Copies value | Copies reference |
| Default | 0/false | null |
| Inheritance | Can't inherit classes | Yes |

**🎯** Mention: a struct field in a class lives on the heap — "stack vs heap" is an implementation detail.

**Q54. Built-in numeric types?**
`sbyte, byte, short, ushort, int, uint, long, ulong, nint, nuint, float, double, decimal`.
**🎯** Integral vs floating-point vs decimal.

**Q55. int vs long vs short?**
`short` 16-bit (±32,767), `int` 32-bit (±2.1B), `long` 64-bit (±9.2×10¹⁸).
`short s = short.MaxValue; int i = int.MaxValue; long l = long.MaxValue;`
**🎯** Default integer literal is `int`; suffix `L` for long.

**Q56. float vs double?**
`float`: 32-bit, ~7 digits; `double`: 64-bit, ~15–17 digits. Literals: `3.5f` vs `3.5`.
**🎯** `double` is default for real literals.

**Q57. Why decimal for financial calculations?**
128-bit base-10 floating point with 28–29 significant digits — avoids binary rounding errors.
```csharp
Console.WriteLine(0.1 + 0.2 == 0.3);     // False
Console.WriteLine(0.1m + 0.2m == 0.3m);  // True
```
**🎯** Slower than double but exact for decimals fractions.

**Q58. Size of int?** 4 bytes (32 bits). `sizeof(int)` → 4.
**Q59. Size of long?** 8 bytes (64 bits).
**Q60. Size of char?** 2 bytes (16-bit UTF-16 code unit).
**🎯** Emojis need two `char`s (surrogate pair).

**Q61. What is bool?** `System.Boolean`, holds `true`/`false`; 1 byte in memory. `bool isOk = true;`
**🎯** C# doesn't allow `if (1)` — must be bool.

**Q62. What is byte?** Unsigned 8-bit (0–255). `byte b = 255;` Used for binary data/IO.
**Q63. What is sbyte?** Signed 8-bit (−128 to 127). `sbyte s = -100;` Not CLS-compliant.
**Q64. What is ushort?** Unsigned 16-bit (0–65,535). `ushort u = 60000;`
**Q65. What is uint?** Unsigned 32-bit (0–4,294,967,295). `uint u = 4000000000;`
**Q66. What is ulong?** Unsigned 64-bit (0–1.8×10¹⁹). `ulong big = 18446744073709551615UL;`
**Q67. What is nint?** Native-sized signed integer (32-bit on x86, 64-bit on x64) — `System.IntPtr` alias (C# 9). `nint n = 5;`
**Q68. What is nuint?** Native-sized unsigned integer — `UIntPtr` alias. Used in interop/low-level code.
**🎯 (Q62–68)** Unsigned types aren't CLS-compliant; overflow of unsigned in unchecked wraps around.

**Q69. What is DateTime?** Struct representing date and time (0001–9999).
```csharp
var now = DateTime.UtcNow; var next = now.AddDays(7);
```
**🎯** Prefer `DateTimeOffset` for time zones; store UTC.

**Q70. What is TimeSpan?** Struct representing a duration.
```csharp
var ts = TimeSpan.FromMinutes(90); Console.WriteLine(ts.TotalHours); // 1.5
```
**🎯** Result of subtracting two `DateTime`s.

**Q71. What is an enum?** A value type of named integral constants.
```csharp
enum Status { Pending, Active, Closed }
```
**🎯** Underlying type default `int`; use `[Flags]` for bit combos.

**Q72. How to assign values to enum members?**
```csharp
enum Level : byte { Low = 1, Medium = 5, High = 10 }
```
**🎯** Unassigned members auto-increment from previous.

**Q73. Can an enum contain duplicate values?** Yes (aliases): `enum E { A = 1, B = 1 }`. `E.A == E.B` is true.
**🎯** Legal but confusing; `ToString()` returns one of the names.

**Q74. What is a nullable value type?** A value type that can also hold `null`: `int? x = null;`
**🎯** Useful for DB columns that allow NULL.

**Q75. What is Nullable<T>?** Generic struct `System.Nullable<T>` with `HasValue` and `Value`.
```csharp
Nullable<int> n = 5; if (n.HasValue) Console.WriteLine(n.Value);
```
**🎯** `T` must be a non-nullable value type.

**Q76. int? vs Nullable<int>?** Identical; `int?` is syntactic sugar.
**🎯** One-liner answer expected.

**Q77. Null-coalescing operator ??** Returns left operand if not null, else right. `string n = input ?? "Guest";`
Also `??=`: `name ??= "Unknown";`
**🎯** Great for defaults and lazy initialization.

**Q78. Null-conditional operator ?.** Short-circuits to null if the object is null.
```csharp
int? len = person?.Name?.Length; var x = list?[0];
```
**🎯** Avoids `NullReferenceException`; result type becomes nullable.

**Q79. Null-forgiving operator !** Suppresses nullable warnings (no runtime effect). `string s = GetName()!;`
**🎯** Use sparingly: you're telling the compiler "trust me"; wrong use still causes NRE.

**Q80. == vs Equals()?**
Value types: both compare value. Reference types: `==` reference equality unless overloaded; `Equals` is virtual and can be overridden. `string` overloads both → value comparison.
```csharp
object a = "hi", b = new string("hi".ToCharArray());
Console.WriteLine(a == b);      // False (reference)
Console.WriteLine(a.Equals(b)); // True
```
**🎯** `==` on `object` is compile-time-bound, `Equals` is run-time-bound.

**Q81. Arithmetic operators:** `+ - * / %`. `10 % 3 = 1`, `10 / 3 = 3` (integer division).
**Q82. Relational operators:** `== != < > <= >=` return `bool`.
**Q83. Logical operators:** `&& || !` (and `& | ^` for bool without short-circuit). `a > 0 && b > 0`.
**Q84. Bitwise operators:** `& | ^ ~ << >> >>>`.
`5 & 3 = 1; 5 | 3 = 7; 5 ^ 3 = 6; ~5 = -6; 1 << 3 = 8`
**🎯 (81–84)** Integer division truncates; `%` sign follows dividend.

**Q85. & vs &&?** `&&` short-circuits (right side evaluated only if needed); `&` evaluates both and is also a bitwise AND on integers.
```csharp
if (obj != null && obj.IsOk) { }   // safe
```
**Q86. | vs ||?** Same idea: `||` short-circuits when left is true.
**Q87. XOR operator ^?** True when operands differ. `true ^ false = true`. Bitwise: `5 ^ 3 = 6`.
**🎯** Classic: find the unique element: `arr.Aggregate((a,b)=>a^b)`.

**Q88. Conditional operator ?:** `string r = age >= 18 ? "Adult" : "Minor";`
**🎯** Both branches must have compatible type.

**Q89. Assignment operator =** Assigns right value to left. `int a = 5;` Returns the assigned value so `a = b = 5` works.
**Q90. Compound assignment:** `+= -= *= /= %= &= |= ^= <<= >>= ??=`. `x += 5;` ≡ `x = x + 5` (x evaluated once).
**Q91. Increment/decrement:** `++` / `--` add/subtract 1.
**Q92. ++i vs i++?**
```csharp
int i = 5; int a = i++; // a=5, i=6 (post)
int j = 5; int b = ++j; // b=6, j=6 (pre)
```
**Q93. Operator precedence?** Order of evaluation: unary > `* / %` > `+ -` > shifts > relational > equality > `&` > `^` > `|` > `&&` > `||` > `??` > `?:` > assignment. `2 + 3 * 4 = 14`.
**Q94. Operator associativity?** Direction for equal precedence: most are left-to-right; assignment, `?:`, `??` are right-to-left. `a = b = c`.
**🎯 (93–94)** Use parentheses for clarity.

**Q95. Checked arithmetic?** Overflow throws `OverflowException`.
```csharp
int x = int.MaxValue; int y = checked(x + 1); // throws
```
**Q96. Unchecked arithmetic?** Overflow silently wraps (default for non-constant expressions).
```csharp
int z = unchecked(int.MaxValue + 1); // -2147483648
```
**Q97. When should checked be used?** Financial/safety-critical math, size calculations, security (array length/indexing arithmetic). Project-wide: `<CheckForOverflowUnderflow>true</CheckForOverflowUnderflow>`.
**Q98. What happens when integer overflow occurs?** In unchecked context: wraps around (two's complement). In checked: `OverflowException`. Constant expressions overflow → compile error.
**🎯 (95–98)** Famous bug class: overflow in `mid = (low + high)/2` → use `low + (high-low)/2`.

**Q99. Swap two numbers without a third variable.**
```csharp
int a = 5, b = 10;
a = a + b; b = a - b; a = a - b;          // arithmetic
// or XOR: a ^= b; b ^= a; a ^= b;
// or tuple: (a, b) = (b, a);              // best in C#
```
**🎯** Mention overflow risk of arithmetic version; tuple swap is idiomatic.

**Q100. Even or odd?**
```csharp
static bool IsEven(int n) => n % 2 == 0;     // or (n & 1) == 0
Console.WriteLine(IsEven(7) ? "Odd" : "Even");
```
**🎯** For negatives, `n % 2 == 1` fails (−3 % 2 = −1) → use `!= 0` or `& 1`.

---

# Section 3 — Control Statements and Loops (Q101–130)

**Q101. What is an if statement?** Executes a block when the condition is true.
`if (age >= 18) Console.WriteLine("Adult");`
**🎯** Condition must be `bool`.

**Q102. if-else?** Chooses between two paths.
`if (n > 0) Console.WriteLine("Pos"); else Console.WriteLine("Non-pos");`

**Q103. else-if ladder?** Multiple sequential conditions; first match wins.
```csharp
if (m >= 90) g = "A"; else if (m >= 75) g = "B"; else g = "C";
```
**🎯** Order matters; most specific first.

**Q104. Nested if?** An `if` inside another `if`.
```csharp
if (user != null) { if (user.IsActive) Run(); }
```
**🎯** Prefer guard clauses/early return to reduce nesting.

**Q105. switch statement?** Multi-way branch on a value.
```csharp
switch (day) { case 1: Console.WriteLine("Mon"); break; default: break; }
```
**🎯** No implicit fall-through in C# (each case must end with break/return/goto).

**Q106. switch vs if-else?** `switch` is cleaner for discrete values/patterns and may compile to a jump table/hash; `if-else` is better for ranges and complex boolean conditions.
**🎯** Modern `switch` supports patterns, so overlap is large.

**Q107. Switch expressions (C# 8)?**
```csharp
string name = day switch { 1 => "Mon", 2 => "Tue", _ => "Other" };
```
**🎯** Expression-bodied, exhaustive (warning if not), `_` is discard/default.

**Q108. Switch patterns?** Type, relational, property, logical patterns in switch.
```csharp
string Describe(object o) => o switch {
  int n when n < 0 => "Negative int",
  int => "Int",
  string { Length: 0 } => "Empty string",
  null => "Null",
  _ => "Other" };
decimal Rate(int a) => a switch { < 18 => 0, >= 18 and < 60 => 10, _ => 5 };
```

**Q109. for loop?** Counter-controlled loop.
`for (int i = 0; i < 5; i++) Console.WriteLine(i);`
**🎯** Best when you need the index or reverse iteration.

**Q110. while loop?** Pre-test loop.
`while (n > 0) { n /= 10; }`

**Q111. do-while loop?** Post-test loop; runs at least once.
`do { input = Read(); } while (input == "");`

**Q112. while vs do-while?** `while` checks the condition first (may run 0 times); `do-while` checks after (≥1 time).

**Q113. foreach loop?** Iterates over any `IEnumerable`.
`foreach (var s in names) Console.WriteLine(s);`
**🎯** Iteration variable is read-only; modifying the collection during iteration throws `InvalidOperationException`.

**Q114. for vs foreach?** `for`: index control, can modify elements, faster for arrays/lists in tight loops. `foreach`: cleaner, works with any enumerable, no index.
**🎯** Compiler optimizes `foreach` over arrays and `Span<T>` to be as fast as `for`.

**Q115. break?** Exits the nearest loop/switch.
`for(...) { if (x == 5) break; }`

**Q116. continue?** Skips the rest of the current iteration.
`foreach (var n in nums) { if (n % 2 == 0) continue; Console.WriteLine(n); }`

**Q117. return?** Exits the method (optionally with a value).
`int Add(int a,int b) { return a + b; }`

**Q118. Can break be used outside a loop?** No (except inside `switch`) → error CS0139.

**Q119. Can continue be used inside a switch?** Yes, if the switch is inside a loop — it continues the *loop*.
```csharp
foreach (var x in list) { switch (x) { case 0: continue; default: Console.WriteLine(x); break; } }
```

**Q120. Infinite loop?** A loop that never ends. `while (true) { }` / `for(;;){}`.
**🎯** Legit uses: servers, message pumps, game loops — always with an exit/cancellation.

**Q121. Preventing infinite loops?** Ensure the condition eventually becomes false; update loop variables; use `break`, timeouts, `CancellationToken`, max-iteration guards.
```csharp
while (!token.IsCancellationRequested) { DoWork(); }
```

**Q122. Print 1 to 100.**
`for (int i = 1; i <= 100; i++) Console.WriteLine(i);`

**Q123. Even numbers 1–100.**
`for (int i = 2; i <= 100; i += 2) Console.WriteLine(i);`

**Q124. Odd numbers 1–100.**
`for (int i = 1; i <= 100; i += 2) Console.WriteLine(i);`

**Q125. Sum 1 to N.**
```csharp
int SumN(int n) => n * (n + 1) / 2;       // O(1)
// loop: int s=0; for(int i=1;i<=n;i++) s+=i;
```
**🎯** Mention Gauss formula O(1) vs loop O(n).

**Q126. Factorial.**
```csharp
long Fact(int n) { long r = 1; for (int i = 2; i <= n; i++) r *= i; return r; }
```
**🎯** Overflows past 20!; use `BigInteger` for larger.

**Q127. Reverse a number.**
```csharp
int Reverse(int n) { int r = 0; while (n != 0) { r = r * 10 + n % 10; n /= 10; } return r; }
```
**🎯** Handle negatives and overflow.

**Q128. Palindrome number.**
```csharp
bool IsPal(int n) => n >= 0 && n == Reverse(n);
```

**Q129. Prime check.**
```csharp
bool IsPrime(int n) {
  if (n < 2) return false;
  for (int i = 2; (long)i * i <= n; i++) if (n % i == 0) return false;
  return true; }
```
**🎯** Loop to √n → O(√n). Mention Sieve of Eratosthenes for ranges.

**Q130. Fibonacci series.**
```csharp
void Fib(int count) { int a = 0, b = 1; for (int i = 0; i < count; i++) { Console.Write(a + " "); (a, b) = (b, a + b); } }
```
**🎯** Iterative O(n) vs naive recursive O(2ⁿ).

---

# Section 4 — Methods and Parameters (Q131–165)

**Q131. What is a method?** A named block of code that performs an action and can take parameters/return a value.
`static int Add(int a, int b) => a + b;`
**🎯** Promotes reuse and modularity.

**Q132. Method signature?** Method name + parameter types/order/modifiers (`ref/out/in`). **Return type is NOT part of it.**
`Add(int, int)`
**🎯** This is why you can't overload by return type only.

**Q133. Return type?** The type of value a method gives back; `void` for none.
`string GetName()`

**Q134. Method parameters?** Variables declared in the method definition that receive values. `void Greet(string name)` — `name` is a parameter.

**Q135. Arguments?** Actual values passed in a call. `Greet("Ali")` — `"Ali"` is the argument.

**Q136. Parameters vs arguments?** Parameters = placeholders in the declaration; arguments = real values at the call site.

**Q137. Method overloading?** Same name, different signatures in the same scope — compile-time polymorphism.
```csharp
int Add(int a,int b)=>a+b; double Add(double a,double b)=>a+b; int Add(int a,int b,int c)=>a+b+c;
```
**🎯** Differ by number/type/order of params, not return type.

**Q138. Method overriding?** A derived class redefines a `virtual`/`abstract` base method — runtime polymorphism.
```csharp
class A { public virtual void Show()=>Console.WriteLine("A"); }
class B : A { public override void Show()=>Console.WriteLine("B"); }
A x = new B(); x.Show(); // B
```

**Q139. Overloading vs overriding?**
| | Overloading | Overriding |
|---|---|---|
| Scope | Same class | Inheritance |
| Signature | Different | Same |
| Binding | Compile time | Run time |
| Keywords | none | virtual/override |

**Q140. Optional parameters?** Parameters with default values; may be omitted by the caller.
`void Log(string msg, string level = "Info")`
**🎯** Must come after required params; defaults are baked into the caller at compile time.

**Q141. Named parameters?** Pass arguments by name in any order.
`Log(level: "Error", msg: "Failed");`
**🎯** Improves readability for boolean flags.

**Q142. Default parameter?** Another term for the optional parameter's default value; can also be `default(T)`/`default`.
`void F(int x = default)`

**Q143. ref keyword?** Passes an argument by reference; the variable **must be initialized** before the call.
```csharp
void Inc(ref int n) => n++; int a = 5; Inc(ref a); // 6
```

**Q144. out keyword?** Passes by reference; method **must assign** it before returning; the caller needn't initialize.
```csharp
if (int.TryParse("42", out int result)) Console.WriteLine(result);
```
**🎯** `out var` / `out _` (discard) supported.

**Q145. ref vs out?**
| | ref | out |
|---|---|---|
| Init before call | Required | Not required |
| Assigned in method | Optional | Mandatory |
| Intent | In/out | Output only |

**Q146. in modifier?** Pass by reference, **read-only** inside the method (avoids copying big structs).
`double Len(in Vector3 v) => ...`
**🎯** Use for large readonly structs.

**Q147. in vs ref vs out?** `in`: read-only ref; `ref`: read/write, must be initialized; `out`: write-only, must be assigned.

**Q148. Multiple out parameters?** Yes.
`void MinMax(int[] a, out int min, out int max) { min = a.Min(); max = a.Max(); }`

**Q149. Can a method return multiple values?** Yes — via `out`, tuples, custom class/record/struct.

**Q150. How does a tuple help?**
```csharp
(int Min, int Max) MinMax(int[] a) => (a.Min(), a.Max());
var (lo, hi) = MinMax(new[]{3,1,9});
```
**🎯** `ValueTuple` — no heap allocation, named elements, deconstruction.

**Q151. What is recursion?** A method calling itself with a smaller input until a base case.
**Q152. Advantages?** Clean for tree/graph traversal, divide & conquer, backtracking; mirrors math definitions.
**Q153. Disadvantages?** Stack overflow risk, overhead per call, often slower than iteration; hard to debug.
**Q154. Recursive method?** A method with a **base case** and **recursive case**.
`int Sum(int n) => n == 0 ? 0 : n + Sum(n - 1);`
**🎯** C# doesn't guarantee tail-call optimization.

**Q155. Recursive factorial.**
`long Fact(int n) => n <= 1 ? 1 : n * Fact(n - 1);`

**Q156. Recursive Fibonacci.**
```csharp
int Fib(int n) => n <= 1 ? n : Fib(n-1) + Fib(n-2);       // O(2^n)
// memoized:
Dictionary<int,long> memo = new();
long FibM(int n) { if (n<=1) return n; if (memo.TryGetValue(n,out var v)) return v; return memo[n]=FibM(n-1)+FibM(n-2); }
```

**Q157. Largest number in array.**
```csharp
int Max(int[] a) { int m = a[0]; foreach (var x in a) if (x > m) m = x; return m; }  // or a.Max()
```

**Q158. Reverse a string.**
```csharp
string Rev(string s) { var c = s.ToCharArray(); Array.Reverse(c); return new string(c); }
```

**Q159. Count vowels.**
```csharp
int Vowels(string s) => s.Count(c => "aeiouAEIOU".Contains(c));
```

**Q160. Check palindrome (string).**
```csharp
bool IsPal(string s) { int i=0,j=s.Length-1; while(i<j) if(char.ToLower(s[i++])!=char.ToLower(s[j--])) return false; return true; }
```

**Q161. Simple interest.**
`double SI(double p, double r, double t) => p * r * t / 100;`

**Q162. Compound interest.**
`double CI(double p, double r, double n) => p * Math.Pow(1 + r/100, n) - p;`
**🎯** Use `decimal` for money.

**Q163. Can a static method access non-static members directly?** No — it has no `this`; needs an instance.
```csharp
class A { int x; static void F(){ /* x=1; ❌ */ var a=new A(); a.x=1; } }
```

**Q164. Method inside another method?** Not a regular method, but yes via **local functions** or lambdas.

**Q165. Local functions?** Methods declared inside other methods; can capture locals, support recursion, and avoid allocation (use `static` local to avoid capture).
```csharp
int Sum(int n) { return Helper(n); int Helper(int x) => x == 0 ? 0 : x + Helper(x-1); }
```
**🎯** Good for iterator/async validation: validate args eagerly, then run local iterator.

---

# Section 5 — Arrays and Strings (Q166–210)

**Q166. What is an array?** Fixed-size, zero-indexed, contiguous collection of same-type elements; a reference type (derives from `System.Array`).
`int[] a = new int[5];`

**Q167. Declare an array?** `int[] a; string[] names; int[,] grid;`
**Q168. Initialize an array?**
```csharp
int[] a = new int[3]; int[] b = {1,2,3}; var c = new[] {1,2,3}; int[] d = [1,2,3]; // C# 12
```
**Q169. Single-dimensional array?** Linear array: `int[] marks = {80,90,70};`
**Q170. Multidimensional array?** Rectangular array: `int[,] m = new int[2,3]; m[1,2]=5;`
**Q171. Jagged array?** Array of arrays; each row can have different length.
```csharp
int[][] j = new int[2][]; j[0]=new[]{1}; j[1]=new[]{1,2,3};
```
**Q172. Multidimensional vs jagged?** Rectangular single block, `[,]`, uniform; jagged `[][]` flexible, usually faster in .NET, requires per-row allocation.
**Q173. Length?** Total number of elements: `a.Length` (for `[2,3]` = 6).
**Q174. GetLength()?** Elements in a specific dimension: `m.GetLength(0)` = rows.
**Q175. Length vs GetLength()?** `Length` = total across dimensions; `GetLength(d)` = one dimension.
**Q176. Array indexing?** Zero-based access `a[0]`; C# 8 index-from-end `a[^1]` and ranges `a[1..3]`.
**Q177. Invalid index?** Throws `IndexOutOfRangeException`.
**Q178. Can size change after creation?** No. Use `Array.Resize(ref a, n)` (creates a new array) or `List<T>`.
**Q179. Copy an array?** `Array.Copy`, `Clone()`, `CopyTo`, LINQ `ToArray()`, `a[..]`.
**Q180. Array.Copy vs Clone?** `Clone()` returns `object` shallow copy of the whole array (needs cast); `Array.Copy` copies a range into an existing array of your choice.
```csharp
int[] b = (int[])a.Clone(); int[] c = new int[a.Length]; Array.Copy(a, c, a.Length);
```
**🎯** Both are *shallow* for reference-type elements.

**Q181. Sort?** `Array.Sort(a);` or `a.OrderBy(x=>x).ToArray()`; descending: `Array.Sort(a); Array.Reverse(a);`
**Q182. Reverse?** `Array.Reverse(a);`
**Q183. Max?** `a.Max()` or manual loop.
**Q184. Min?** `a.Min()`.
**Q185. Remove duplicates?** `var u = a.Distinct().ToArray();` or `new HashSet<int>(a)`.
**Q186. Find duplicates?**
```csharp
var dups = a.GroupBy(x=>x).Where(g=>g.Count()>1).Select(g=>g.Key);
var seen = new HashSet<int>(); var d = a.Where(x => !seen.Add(x)).Distinct();
```
**Q187. Second-largest?**
```csharp
int Second(int[] a){ int f=int.MinValue,s=int.MinValue; foreach(var x in a){ if(x>f){s=f;f=x;} else if(x>s&&x!=f) s=x; } return s; }
```
**🎯** Single pass O(n) beats sorting O(n log n).
**Q188. Missing number (1..n)?**
```csharp
int Missing(int[] a, int n) => n*(n+1)/2 - a.Sum();   // or XOR approach
```
**Q189. Rotate an array?**
```csharp
void RotateLeft(int[] a,int k){ k%=a.Length; Array.Reverse(a,0,k); Array.Reverse(a,k,a.Length-k); Array.Reverse(a); }
```
**🎯** Triple-reverse trick is O(n) time, O(1) space.
**Q190. Merge two arrays?** `a.Concat(b).ToArray()` or `[..a, ..b]` (C# 12).

**Q191. What is a string?** Sequence of UTF-16 `char`s; alias of `System.String`. `string s = "Hello";`
**Q192. Value or reference type?** **Reference type** with value-like behavior (immutable, `==` compares content).
**Q193. Why immutable?** Thread-safety, safe as dictionary keys (stable hash), string interning, security, caching hash code.
**Q194. What does immutability mean?** Once created, content can't change; operations return new strings.
```csharp
string s = "a"; s += "b"; // new object; the old "a" is unchanged
```
**Q195. String interning?** CLR keeps one copy of identical literals in the intern pool.
```csharp
string a = "hi", b = "hi"; Console.WriteLine(ReferenceEquals(a,b)); // True
string c = string.Intern(new string(new[]{'h','i'})); // forces the pooled instance
```
**Q196. string vs String?** `string` is the C# keyword alias for `System.String`; identical. Convention: `string` for the type, `String.Join` for static members.
**Q197. StringBuilder?** Mutable string buffer in `System.Text`.
```csharp
var sb = new StringBuilder(); for(int i=0;i<1000;i++) sb.Append(i); string r = sb.ToString();
```
**Q198. string vs StringBuilder?** `string` immutable (each change allocates); `StringBuilder` mutable, efficient for many modifications.
**Q199. When to use StringBuilder?** Loops with many concatenations, building large text/CSV/JSON. For ≤3-4 concatenations, `+` or interpolation is fine.
**Q200. String concatenation?** Joining strings: `+`, `string.Concat`, `string.Join`, interpolation.
**Q201. String interpolation?** `$"Hello {name}, total {price:C2}"` — compiled to `string.Format`/`DefaultInterpolatedStringHandler`.
**Q202. Verbatim string?** `@"C:\Temp\file.txt"` — backslashes literal, multi-line allowed, `""` for a quote.
**Q203. Raw string literal (C# 11)?**
```csharp
var json = """
  { "name": "Ali", "age": 30 }
  """;
```
**Q204. @"" vs $""?** `@` disables escape processing; `$` enables embedded expressions. Combine: `$@"..."` or `@$"..."`.
**Q205. Compare two strings?** `==`, `string.Equals(a,b,StringComparison.OrdinalIgnoreCase)`, `string.Compare`, `CompareTo`.
**Q206. Ordinal vs culture-sensitive?** Ordinal compares raw UTF-16 code values (fast, culture-independent: use for identifiers/paths); culture-sensitive uses linguistic rules (use for UI sorting).
```csharp
"ß".Equals("ss", StringComparison.InvariantCulture); // may be true
"ß".Equals("ss", StringComparison.Ordinal);          // false
```
**🎯** Famous Turkish-I bug: always specify `StringComparison`.
**Q207. String.Equals()?** Compares content; overloads accept `StringComparison`. `s1.Equals(s2, StringComparison.OrdinalIgnoreCase)`.
**Q208. Contains()?** Returns true if substring/char exists (ordinal by default). `"hello".Contains("ell")` → true. Use overload for ignore-case.
**Q209. Split a string?** `"a,b,c".Split(',')`; options: `StringSplitOptions.RemoveEmptyEntries | TrimEntries`.
**Q210. Reverse string without built-ins?**
```csharp
string Rev(string s){ var r = new char[s.Length]; for(int i=0;i<s.Length;i++) r[i]=s[s.Length-1-i]; return new string(r); }
```

---

# Section 6 — OOP Fundamentals (Q211–260)

**Q211. What is OOP?** A paradigm modeling software as objects that combine data (fields) and behavior (methods).
**🎯** Goals: reuse, maintainability, modularity, extensibility.

**Q212. Four pillars?** Encapsulation, Inheritance, Polymorphism, Abstraction.

**Q213. Encapsulation?** Bundling data with methods and hiding internal state behind controlled access.
```csharp
class Account { private decimal _bal; public void Deposit(decimal a){ if(a<=0) throw new ArgumentException(); _bal+=a; } public decimal Balance=>_bal; }
```
**Q214. Inheritance?** A class acquires members of another (`:`) → "is-a", code reuse.
`class Dog : Animal {}`
**Q215. Polymorphism?** "Many forms" — same call, different behavior (overload = compile time; override = runtime).
**Q216. Abstraction?** Exposing *what* an object does and hiding *how* — via abstract classes and interfaces.
**Q217. What is a class?** A blueprint/reference type defining fields, properties, methods, events.
`class Car { public string Model { get; set; } public void Start(){} }`
**Q218. What is an object?** A runtime instance of a class: `Car c = new Car();`
**Q219. Class vs object?** Class = template (compile time); object = concrete instance with its own state (runtime).
**Q220. What is an instance?** Synonym for an object created from a class; "instance member" belongs to the object, not the type.
**Q221. How is an object created?** `new` keyword, target-typed `new()`, reflection `Activator.CreateInstance`, factory, deserialization, DI.
`Car c = new(); `
**Q222. Constructor?** Special method with the class name, no return type, runs on object creation.
`public Car(string m){ Model = m; }`
**Q223. Default constructor?** Parameterless ctor: `public Car(){}`.
**Q224. Parameterized constructor?** Takes parameters to initialize state. `new Car("BMW")`.
**Q225. Copy constructor?** Creates an object from another of the same type (C# has no built-in; write it manually).
`public Car(Car other){ Model = other.Model; }`
**🎯** Records provide `with` expressions for non-destructive copies.
**Q226. Does C# provide a default ctor automatically?** Yes — only if you declare **no** constructors. Once you write any ctor, it's gone.
**Q227. Constructor overloading?** Yes; different parameter lists.
**Q228. Constructor inheritance?** No, constructors aren't inherited; derived must call base via `: base(...)`.
**Q229. Private constructor?** Yes — used by Singleton, static utility classes, factory methods.
```csharp
class Singleton { private Singleton(){} public static readonly Singleton Instance = new(); }
```
**Q230. Static constructor?** Parameterless, no access modifier, initializes static members once.
`static Config(){ Settings = Load(); }`
**Q231. When executed?** Automatically once, before first instance creation or first static member access (CLR-controlled timing).
**Q232. Static ctor with parameters?** No.
**Q233. Multiple static ctors?** No — only one per class.
**Q234. Destructor/finalizer?** `~ClassName()` — called by GC to release unmanaged resources; non-deterministic.
```csharp
class R { ~R(){ /* cleanup */ } }
```
**Q235. When is finalizer called?** When GC determines object is unreachable (on the finalizer thread); not guaranteed at app exit in .NET Core.
**Q236. Constructor vs destructor?** Ctor initializes, can be overloaded, has access modifiers; destructor cleans up, one per class, no params/modifiers, called by GC.
**🎯** Prefer `IDisposable` + `using` for deterministic cleanup.
**Q237. Encapsulation in real development?** Private fields + validated public API; e.g., domain entities guard invariants so invalid state can't exist.
**Q238. Why fields should be private?** To protect invariants, allow validation, change implementation without breaking callers, enable data binding/serialization that works on properties.
**Q239. Properties?** Members exposing fields via `get`/`set` accessors.
```csharp
private string _name; public string Name { get => _name; set => _name = value?.Trim() ?? ""; }
```
**Q240. Why properties over public fields?** Validation, lazy/computed logic, different get/set accessibility, binding, interface support, versioning (binary compatibility).
**Q241. Auto-implemented property?** `public string Name { get; set; }` — compiler creates a hidden backing field.
**Q242. Read-only property?** `public int Id { get; }` — set only in constructor/initializer.
**Q243. Init-only property (C# 9)?** `public string Name { get; init; }` — settable only during object initialization.
`var p = new Person { Name = "A" }; // p.Name = "B"; ❌`
**Q244. Computed property?** Value calculated each access: `public decimal Total => Price * Qty;`
**Q245. Getters and setters?** `get` returns value; `set` assigns using implicit `value` parameter.
**Q246. Private setter?** `public int Count { get; private set; }` — readable publicly, modifiable only inside class.
**Q247. Different access for get/set?** Yes — accessor must be *more restrictive* than the property: `public string X { get; protected set; }`.
**Q248. What is inheritance (detail)?** Derived class gets base's accessible members and can extend/override. Single class inheritance only.
**Q249. Single inheritance?** One base → one derived: `class B : A`.
**Q250. Multiple class inheritance in C#?** **No** — only multiple interface implementation.
**Q251. Why not?** Avoids the **diamond problem** (ambiguity of which base member to use) and complexity.
**Q252. Multilevel inheritance?** `A → B → C` chain: `class C : B`, `class B : A`.
**Q253. Hierarchical inheritance?** One base, many derived: `Dog : Animal`, `Cat : Animal`.
**Q254. Hybrid inheritance?** Mix of types (e.g., multilevel + multiple); in C# emulated with interfaces.
**Q255. Multiple inheritance via interfaces?**
```csharp
interface IFly{void Fly();} interface ISwim{void Swim();}
class Duck : IFly, ISwim { public void Fly(){} public void Swim(){} }
```
**Q256. base keyword?** Refers to base-class members/constructors.
```csharp
class B : A { public B(int x) : base(x) {} public override void Show(){ base.Show(); } }
```
**Q257. this keyword?** Refers to the current instance; disambiguates, passes self, chains ctors, declares extension methods/indexers.
`public Car(string model){ this.model = model; }`
**Q258. this vs base?** `this` = current class instance; `base` = parent class's members.
**Q259. Constructor chaining?** Calling one constructor from another using `this(...)` (same class) or `base(...)` (parent).
```csharp
public Car() : this("Unknown") {} public Car(string m){ Model=m; }
```
**🎯** Execution order: derived field initializers → base constructor → derived constructor body.
**Q260. OOP with a real-world example (ATM / Library).**
```csharp
abstract class Account { public string Id{get;} protected decimal bal; protected Account(string id){Id=id;} 
  public abstract decimal Fee { get; }
  public void Withdraw(decimal a){ if(a+Fee>bal) throw new InvalidOperationException("Insufficient"); bal-=a+Fee; } }
class Savings : Account { public Savings(string id):base(id){} public override decimal Fee => 0; }
class Current : Account { public Current(string id):base(id){} public override decimal Fee => 2; }
```
Encapsulation (protected bal), Inheritance (Savings), Polymorphism (Fee), Abstraction (Account).

---

# Section 7 — Inheritance and Polymorphism (Q261–310)

**Q261. Compile-time polymorphism?** Binding at compile time: overloading, operator overloading, generics.
**Q262. Runtime polymorphism?** Binding at run time via `virtual`/`override`, abstract and interface dispatch.
**Q263. Overloading & polymorphism?** Overloading provides static polymorphism — compiler selects the method from argument types.
**Q264. Overriding & polymorphism?** Derived behavior is selected based on the *actual* object type.
```csharp
Shape s = new Circle(); s.Draw(); // Circle.Draw
```
**Q265. Virtual method?** Base method that derived classes *may* override. `public virtual void Speak(){}`
**Q266. Overridden method?** A derived method replacing a virtual/abstract one using `override`, same signature.
**Q267. override keyword?** Extends/replaces inherited virtual, abstract, or override member. Can call `base.Method()`.
**Q268. virtual keyword?** Allows member to be overridden; not allowed with `static`, `private`, `abstract`, or `override`.
**Q269. new keyword with methods?** Hides a base member (explicit hiding, suppresses warning CS0108).
**Q270. new vs override?**
```csharp
class A { public virtual void F()=>Console.Write("A"); public void G()=>Console.Write("A"); }
class B : A { public override void F()=>Console.Write("B"); public new void G()=>Console.Write("B"); }
A x = new B(); x.F(); // B (override – runtime)
x.G();                // A (new – compile-time type)
```
**Q271. Method hiding?** Derived member with the same name hides base member; resolution depends on **reference type**.
**Q272. Base reference to derived object?** Allowed; only base members visible, but virtual calls dispatch to derived overrides.
**Q273. Upcasting?** Derived → base, implicit and safe: `Animal a = new Dog();`
**Q274. Downcasting?** Base → derived, explicit and may fail: `Dog d = (Dog)a;`
**Q275. Explicit casting?** `(Type)expr` — throws `InvalidCastException` on failure.
**Q276. as operator?** Safe cast returns `null` on failure (reference/nullable types only). `Dog d = a as Dog;`
**Q277. as vs explicit cast?** `as` → null, no exception, only reference/nullable; `(T)` → exception, works for value types & user-defined conversions.
**Q278. is operator?** Type test: `if (a is Dog)`.
**Q279. Pattern matching with is?** `if (a is Dog d && d.Age > 2) d.Bark();` / `if (o is not null)` / `x is > 5 and < 10`.
**Q280. Dynamic dispatch?** Selecting the method implementation at runtime from the object's actual type (via vtable).
**Q281. Early binding?** Compile-time method resolution (overloads, non-virtual, static).
**Q282. Late binding?** Run-time resolution: virtual methods, `dynamic`, reflection.
**Q283. Static method overridden?** No — static belongs to type; can be hidden but not overridden.
**Q284. Private method overridden?** No — not visible to derived classes.
**Q285. Sealed method overridden?** No — `sealed override` stops further overriding.
`public sealed override void F(){}`
**Q286. Sealed class?** Class that can't be inherited: `sealed class Util{}` (e.g., `string`).
**Q287. Why sealed class?** Security, design intent, and performance (JIT can devirtualize/inline calls).
**Q288. Can a sealed class be inherited?** No → error CS0509.
**Q289. Virtual constructor?** No — constructors can't be virtual; use factory method/Clone pattern.
**Q290. Virtual fields?** No — only methods, properties, indexers, events.
**Q291. Virtual properties?** Yes: `public virtual string Name {get;set;}`.
**Q292. Virtual indexers?** Yes: `public virtual int this[int i]{get=>...;}`.
**Q293. Virtual operators?** No — operators are static (static abstract/virtual in interfaces exist in C# 11 generic math only).
**Q294. Abstract method private?** No — must be accessible to derived classes (not private).
**Q295. Abstract class constructors?** Yes — called through derived constructors.
**Q296. Abstract class implemented methods?** Yes — can have concrete members.
**Q297. Instantiate abstract class?** No (CS0144); only via derived instance.
**Q298. Abstract class static members?** Yes.
**Q299. Abstract inherits abstract?** Yes — need not implement base abstract members.
**Q300. Abstract method?** Declaration without body in an abstract class; derived concrete classes must `override`.
`public abstract double Area();`
**Q301. Abstract property?** `public abstract string Name { get; }` — must be overridden.
**Q302. Abstract vs virtual?** Abstract: no body, mandatory override, only in abstract class. Virtual: has body, optional override.
**Q303. Concrete class?** Non-abstract class that fully implements everything and can be instantiated.
**Q304. Interface?** Contract of members a type must implement.
`interface IShape { double Area(); }`
**Q305. Why interfaces?** Abstraction, loose coupling, multiple inheritance of behavior, testability (mocking), DI, polymorphism across unrelated types.
**Q306. Abstract class vs interface?**
| | Abstract class | Interface |
|---|---|---|
| Inheritance | Single | Multiple |
| State (fields) | Yes | No |
| Ctors | Yes | No |
| Implementation | Yes | Default only (C# 8) |
| Use for | "is-a" with shared code | "can-do" capability |
**Q307. Interface fields?** No instance fields (only `static` members since C# 8).
**Q308. Interface properties?** Yes: `string Name { get; set; }`.
**Q309. Interface method with implementation?** Yes since C# 8 (default interface methods).
**Q310. Class implements multiple interfaces?** Yes: `class A : IA, IB, IC {}`.

---

# Section 8 — Interfaces and Advanced OOP (Q311–350)

**Q311. Explicit interface implementation?** Implementing a member with the interface name, accessible only via the interface reference.
```csharp
interface IA { void Run(); }
class C : IA { void IA.Run() => Console.WriteLine("run"); }
IA a = new C(); a.Run(); // new C().Run() ❌
```
**Q312. Why useful?** Resolves name conflicts, hides rarely-used members from the public API, allows different implementations per interface.
**Q313. Interface inherit interface?** Yes: `interface IB : IA {}`.
**Q314. Multiple interfaces inheritance?** Yes: `interface IC : IA, IB {}`.
**Q315. Same method name in two interfaces?** Yes.
**Q316. Resolving conflicts?** Explicit implementation for each.
```csharp
interface IA{void F();} interface IB{void F();}
class C: IA, IB { void IA.F()=>Console.Write("A"); void IB.F()=>Console.Write("B"); }
```
**Q317. Default interface methods?** Interface members with a body (C# 8) enabling evolution without breaking implementers.
```csharp
interface ILogger { void Log(string m); void Warn(string m) => Log("WARN: " + m); }
```
Accessible only through interface reference.
**Q318. Static interface members?** Static fields/methods (C# 8) and `static abstract` members (C# 11) for generic math.
`interface IParse<T>{ static abstract T Parse(string s); }`
**Q319. Interface properties?** Declared w/o implementation: `int Id { get; }`.
**Q320. Interface indexers?** `string this[int i] { get; set; }`.
**Q321. Dependency inversion?** Principle: high-level modules depend on abstractions, not concretions.
**Q322. Dependency injection?** Technique to *supply* dependencies from outside (usually via container) rather than creating them with `new`.
**Q323. Constructor dependencies?** The parameters a class needs to function, declared in its constructor.
**Q324. Constructor injection?** Preferred DI form — dependencies given via constructor.
```csharp
class OrderService { private readonly IRepo _repo; public OrderService(IRepo repo)=>_repo=repo; }
```
**Q325. Property injection?** Dependency set via public property (optional dependencies); risk: object in incomplete state.
**Q326. Method injection?** Dependency passed as a method parameter — when needed only for that call.
**Q327. Why DI useful?** Loose coupling, testability (inject mocks), configurability, lifetime management, SRP/OCP adherence.
**Q328. Loose coupling?** Classes know only abstractions of each other; easy to swap.
**Q329. Tight coupling?** Classes depend on concrete implementations; change ripples.
`class A { B b = new B(); }`
**Q330. Tight vs loose?** Tight: hard to test/replace, `new` inside. Loose: depend on interfaces, injected.
**Q331. Cohesion?** How strongly responsibilities inside one module belong together (high = good).
**Q332. Coupling vs cohesion?** Aim for **low coupling, high cohesion**. Coupling is between modules; cohesion is within a module.
**Q333. SOLID?** S-ingle responsibility, O-pen/closed, L-iskov substitution, I-nterface segregation, D-ependency inversion.
**Q334. SRP.** A class has one reason to change.
**Q335. OCP.** Open for extension, closed for modification.
**Q336. LSP.** Subtypes must be substitutable for base types without breaking correctness.
**Q337. ISP.** Many small client-specific interfaces beat one fat interface.
**Q338. DIP.** Depend on abstractions; inject them.
**Q339. SRP example.**
```csharp
// ❌ Invoice does calc + print + save
class InvoiceCalculator{ public decimal Total(Invoice i)=>...; }
class InvoicePrinter{ public void Print(Invoice i){} }
class InvoiceRepository{ public void Save(Invoice i){} }
```
**Q340. OCP example.**
```csharp
interface IDiscount{ decimal Apply(decimal p); }
class Seasonal:IDiscount{ public decimal Apply(decimal p)=>p*0.9m; }
class Calculator{ public decimal Price(decimal p, IDiscount d)=>d.Apply(p); } // new discounts = new classes, no edits
```
**Q341. LSP example.**
```csharp
// ❌ Square : Rectangle breaks width/height independence
// ✅ interface IShape{ double Area{get;} } Rectangle, Square implement separately
```
**Q342. ISP example.**
```csharp
interface IPrinter{void Print();} interface IScanner{void Scan();}
class BasicPrinter:IPrinter{...}   // not forced to implement Scan()
class MFP:IPrinter,IScanner{...}
```
**Q343. DIP example.**
```csharp
interface IMessageSender{ void Send(string m); }
class EmailSender:IMessageSender{...}
class Notifier{ readonly IMessageSender _s; public Notifier(IMessageSender s)=>_s=s; }
```
**Q344. Composition?** Strong "has-a"; part cannot live without whole (Car–Engine, engine created and owned by car).
**Q345. Aggregation?** Weak "has-a"; part can exist independently (Team–Player).
**Q346. Composition vs aggregation?** Lifetime ownership: composition → owner controls lifetime; aggregation → shared/independent.
**Q347. Composition over inheritance?** Less coupling, runtime flexibility, avoids fragile base class and deep hierarchies, easier testing.
**Q348. "is-a"?** Inheritance relationship: `Dog is an Animal`.
**Q349. "has-a"?** Composition/aggregation: `Car has an Engine`.
**Q350. Design a simple payment system.**
```csharp
public interface IPaymentMethod { string Name {get;} Task<PaymentResult> PayAsync(decimal amount); }
public record PaymentResult(bool Success, string TransactionId, string? Error=null);

public class CardPayment : IPaymentMethod {
  public string Name => "Card";
  public Task<PaymentResult> PayAsync(decimal a) => Task.FromResult(new PaymentResult(true, Guid.NewGuid().ToString()));
}
public class UpiPayment : IPaymentMethod { public string Name=>"UPI"; public Task<PaymentResult> PayAsync(decimal a)=>Task.FromResult(new PaymentResult(true,"U-"+Guid.NewGuid())); }

public class PaymentService {
  private readonly IEnumerable<IPaymentMethod> _methods;
  public PaymentService(IEnumerable<IPaymentMethod> methods)=>_methods=methods;
  public Task<PaymentResult> PayAsync(string method, decimal amount) {
    if (amount <= 0) throw new ArgumentOutOfRangeException(nameof(amount));
    var m = _methods.FirstOrDefault(x => x.Name == method) ?? throw new NotSupportedException(method);
    return m.PayAsync(amount); } }
```
**🎯** Highlight: OCP (add Wallet without edits), DIP (service depends on interface), SRP, polymorphism, DI list injection.

---

# Section 9 — Collections (Q351–390)

**Q351. Collection?** Object that groups/manages related items (System.Collections.*).
**Q352. Array vs collection?** Array: fixed size, fast, typed. Collections: dynamic size, richer APIs (Add/Remove/Find), various data structures.
**Q353. ArrayList?** Non-generic, `object`-based dynamic list (legacy) → boxing + no type safety.
**Q354. Why List<T> over ArrayList?** Type safety, no boxing/unboxing, better performance, compile-time checks.
**Q355. List<T>?** Generic dynamic array. `var l = new List<int>{1,2,3}; l.Add(4);`
**🎯** Amortized O(1) Add, O(1) index, O(n) insert/remove middle; set `Capacity` to avoid resizing.
**Q356. Dictionary<TKey,TValue>?** Hash-table key/value, O(1) average lookup, unique keys.
`var d = new Dictionary<string,int>{["a"]=1};`
**Q357. HashSet<T>?** Unique-element set with O(1) Add/Contains; supports union/intersect.
`var s = new HashSet<int>{1,2,2}; // 1,2`
**Q358. Queue<T>?** FIFO: `Enqueue`, `Dequeue`, `Peek`.
**Q359. Stack<T>?** LIFO: `Push`, `Pop`, `Peek`.
**Q360. List vs LinkedList?** List: array-backed, fast index/iteration/cache-friendly. LinkedList: O(1) insert/remove at a known node, no index, higher memory.
**Q361. List vs HashSet?** List: ordered, duplicates, O(n) Contains. HashSet: unordered, unique, O(1) Contains.
**Q362. Dictionary vs Hashtable?** Dictionary generic, type-safe, faster, no boxing, throws KeyNotFound; Hashtable non-generic (legacy), returns null for missing keys, some thread-safety for single writer.
**Q363. SortedList?** Key-sorted collection backed by two arrays; O(log n) lookup, O(n) insert, low memory.
**Q364. SortedDictionary?** Key-sorted via red-black tree; O(log n) insert/remove.
**Q365. SortedDictionary vs SortedList?** SortedList: less memory, faster for pre-sorted bulk loading/index access. SortedDictionary: faster random inserts/removals.
**Q366. ConcurrentDictionary?** Thread-safe dictionary in `System.Collections.Concurrent`; `GetOrAdd`, `AddOrUpdate`.
**Q367. When to use it?** Multi-threaded read/write shared cache or counters without manual locks.
```csharp
var cd = new ConcurrentDictionary<string,int>();
Parallel.For(0,100,_=>cd.AddOrUpdate("k",1,(k,v)=>v+1));
```
**Q368. IEnumerable<T>?** Basic read-only forward iteration (`GetEnumerator`); LINQ foundation.
**Q369. ICollection<T>?** Extends IEnumerable with `Count`, `Add`, `Remove`, `Contains`, `Clear`.
**Q370. IList<T>?** Extends ICollection with index access and `Insert/RemoveAt/IndexOf`.
**Q371. IEnumerable vs ICollection vs IList?** Iterate only → IEnumerable; + count/modify → ICollection; + index → IList. 🎯 Accept the least-specific interface as parameter.
**Q372. IReadOnlyCollection<T>?** Read-only with `Count`.
**Q373. IReadOnlyList<T>?** Read-only with `Count` and indexer.
**Q374. ISet<T>?** Set operations: `UnionWith`, `IntersectWith`, `ExceptWith`, `IsSubsetOf`; implemented by HashSet/SortedSet.
**Q375. IEnumerator<T>?** Iterator object with `Current`, `MoveNext()`, `Reset()`; disposable.
**Q376. Enumerator?** The object that tracks position while iterating; `foreach` uses it.
**Q377. GetEnumerator()?** Returns the enumerator; `foreach` is syntactic sugar for it.
```csharp
using var e = list.GetEnumerator(); while(e.MoveNext()) Console.WriteLine(e.Current);
```
**Q378. Deferred execution?** Query defined now, evaluated when enumerated.
```csharp
var q = nums.Where(n=>n>2); nums.Add(10); // q includes 10 when enumerated
```
**Q379. Immediate execution?** Evaluated instantly: `ToList()`, `ToArray()`, `Count()`, `Sum()`, `First()`.
**Q380. Collection initialization?** `var l = new List<int>{1,2,3}; var d = new Dictionary<int,string>{{1,"a"}};`
**Q381. Collection expression (C# 12)?** `List<int> l = [1,2,3]; int[] a = [..l, 4];`
**Q382. List pattern (C# 11)?**
```csharp
if (arr is [1, 2, ..]) ...; var r = arr switch { [] => "empty", [var x] => $"one {x}", [var f, .., var last] => $"{f}-{last}" };
```
**Q383. How Dictionary stores pairs?** Computes `GetHashCode()` → bucket index → entry array with chained collisions; resize on load.
**Q384. Duplicate keys?** `Add` throws `ArgumentException`; indexer `d[k]=v` overwrites; use `TryAdd`.
**Q385. HashSet prevents duplicates?** Uses hash code + `Equals`; `Add` returns false if present.
**Q386. Hashing conceptually?** Converts a key to an integer to jump directly to a bucket instead of scanning.
**Q387. Hash collision?** Different keys → same bucket; resolved via chaining; degrades toward O(n) if poor hash.
**Q388. Importance of GetHashCode()?** Determines bucket placement; must be stable for the key's lifetime and well distributed.
**Q389. Equals() vs GetHashCode() relationship?** Equal objects **must** return equal hash codes (reverse not required). Override both together.
```csharp
public override bool Equals(object? o)=>o is Point p && X==p.X && Y==p.Y;
public override int GetHashCode()=>HashCode.Combine(X,Y);
```
**Q390. Frequency of elements.**
```csharp
var freq = new Dictionary<int,int>();
foreach (var n in new[]{1,2,2,3,3,3}) freq[n] = freq.GetValueOrDefault(n) + 1;
foreach (var kv in freq) Console.WriteLine($"{kv.Key}:{kv.Value}");
// LINQ: nums.GroupBy(x=>x).ToDictionary(g=>g.Key,g=>g.Count());
```

---

# Section 10 — Exception Handling (Q391–420)

**Q391. Exception?** A runtime error object (derived from `System.Exception`) that disrupts normal flow.
**Q392. Exception handling?** Mechanism (`try/catch/finally/throw`) to detect and recover from errors gracefully.
**Q393. Purpose of try?** Wraps code that may throw.
**Q394. Purpose of catch?** Handles specific exception types.
**Q395. Purpose of finally?** Cleanup code that runs whether or not an exception occurred.
```csharp
try { var n = int.Parse(s); } catch (FormatException ex) { Console.WriteLine(ex.Message); } finally { Console.WriteLine("done"); }
```
**Q396. throw keyword?** Raises an exception (or rethrows in a catch). `throw new ArgumentNullException(nameof(x));`
**Q397. throw vs throw ex?** `throw;` preserves the original stack trace; `throw ex;` resets it to the current line.
**Q398. Why avoid throw ex?** Loses debugging context. Use `throw;` or wrap: `throw new CustomEx("msg", ex);`
**Q399. Multiple catch blocks?** Yes — first matching one runs.
**Q400. Ordering?** Most specific → most general; compiler errors if a general catch precedes a specific one.
```csharp
catch (FileNotFoundException){} catch (IOException){} catch (Exception){}
```
**Q401. Unhandled exception?** Propagates up the call stack; if never caught the runtime terminates the process (and logs/crash dump).
**Q402. Exception (class)?** Base class for all exceptions; has `Message`, `StackTrace`, `InnerException`, `Data`.
**Q403. Common built-ins?** `NullReferenceException`, `ArgumentException`, `InvalidOperationException`, `IndexOutOfRangeException`, `FormatException`, `DivideByZeroException`, `KeyNotFoundException`, `IOException`, `OverflowException`, `InvalidCastException`, `OperationCanceledException`, `TimeoutException`.
**Q404. NullReferenceException?** Using a member of a null reference. `string s=null; s.Length;` Prevent: null checks, `?.`, nullable reference types.
**Q405. IndexOutOfRangeException?** Index outside array bounds. `int[] a = new int[3]; a[5] = 1;` → thrown. Lists throw `ArgumentOutOfRangeException`.
**Q406. ArgumentException?** An argument is invalid. `throw new ArgumentException("Bad", nameof(x));`
**Q407. ArgumentNullException?** Argument is null: `ArgumentNullException.ThrowIfNull(x);` (.NET 6+).
**Q408. InvalidOperationException?** Method call invalid for the object's current state (e.g., modifying collection during foreach, `Dequeue` on empty queue).
**Q409. FormatException?** Wrong string format: `int.Parse("abc")`.
**Q410. DivideByZeroException?** Integer division by zero (`5/0`); floats return ∞/NaN instead.
**Q411. Custom exception?** User-defined exception specific to domain errors.
**Q412. Create custom exception?**
```csharp
public class InsufficientFundsException : Exception {
  public decimal Needed { get; }
  public InsufficientFundsException(decimal needed) : base($"Need {needed} more") => Needed = needed;
  public InsufficientFundsException(string m, Exception inner) : base(m, inner) {} }
```
**Q413. When create custom exceptions?** For domain-specific failures callers must distinguish, carrying extra data. Don't create them for flow control or when a built-in fits.
**Q414. finally with return?** Yes, `finally` still executes before the method returns.
**Q415. Can finally throw?** Yes, but it replaces any in-flight exception → avoid.
**Q416. Both try and finally return?** C# forbids `return` inside `finally` (CS0157). `try` return value is computed first; finally runs, and can't change the returned value (for value types).
**Q417. try without catch?** Yes, if there's a `finally` (`try{} finally{}`), `using` is sugar for this.
**Q418. try with only finally?** Yes — exception propagates after cleanup.
**Q419. Exception filter `when`?**
```csharp
catch (HttpRequestException ex) when (ex.StatusCode == HttpStatusCode.NotFound) { ... }
```
**🎯** Doesn't unwind the stack if the filter is false → better diagnostics.
**Q420. Production handling?** Catch only what you can handle; use global handlers/middleware; log with context (Serilog, correlation IDs); never swallow silently; use `throw;`; validate early; return Result types for expected failures; map exceptions to user-friendly responses; `ProblemDetails` in APIs; don't expose stack traces.

---

# Section 11 — Delegates, Events and Lambda (Q421–445)

**Q421. Delegate?** Type-safe function pointer/reference type holding methods with a matching signature.
`delegate int Op(int a, int b);`
**Q422. Why used?** Callbacks, events, LINQ, strategy-style behavior passing, decoupling.
**Q423. Multicast delegate?** Holds multiple methods invoked in order using `+=`/`-=`.
```csharp
Action a = ()=>Console.Write("1"); a += ()=>Console.Write("2"); a(); // 12
```
**🎯** Return value is that of the last method.
**Q424. Declare delegate?** `public delegate void Notify(string msg);`
**Q425. Delegate instance?** `Notify n = Show; n("Hi");` / `n.Invoke("Hi")`.
**Q426. Action?** Built-in delegate: no return value, up to 16 params: `Action<int,string>`.
**Q427. Func?** Returns a value; last type param is return: `Func<int,int,int> add=(a,b)=>a+b;`
**Q428. Predicate<T>?** Returns bool for one param: `Predicate<int> isEven = n=>n%2==0;`
**Q429. Action vs Func vs Predicate?** Action = void, Func = returns TResult, Predicate = `Func<T,bool>` specialization (used by `List.FindAll`).
**Q430. Lambda expression?** Anonymous function with `=>`: `x => x * x`.
**Q431. Expression lambda?** Single expression body: `n => n > 5`.
**Q432. Statement lambda?** Block body: `n => { Console.WriteLine(n); return n*2; }`
**Q433. Lambda closure?** A lambda capturing outer variables.
```csharp
int counter = 0; Action inc = () => counter++; inc(); inc(); // counter = 2
```
**🎯** Gotcha: capturing loop variables in `for`; `foreach` creates fresh variable per iteration (C# 5+). Use `static` lambdas to prevent capture.
**Q434. Anonymous method?** `delegate(int x){ return x*2; }` (C# 2) — predecessor of lambdas.
**Q435. Anonymous method vs lambda?** Lambdas are concise, support expression trees (`Expression<Func<>>`), type inference; anonymous methods can omit parameter list.
**Q436. Event?** A member that lets a class notify subscribers, built on a delegate.
`public event EventHandler? Clicked;`
**Q437. Delegate vs event?** Event restricts access: outside code can only `+=`/`-=`, cannot invoke or reassign (`=`) the delegate.
**Q438. Why can't events be invoked outside?** Encapsulation — only the publisher decides when to raise; prevents subscribers from clearing/raising others' handlers.
**Q439. Event subscription?** `button.Clicked += OnClick;`
**Q440. Unsubscription?** `button.Clicked -= OnClick;` — prevents memory leaks (publisher keeps strong reference to subscribers).
**Q441. Publisher–subscriber pattern?** Publisher raises events without knowing subscribers; subscribers register handlers → loose coupling.
**Q442. How are events implemented with delegates?** Compiler generates a private delegate field + `add`/`remove` accessors (thread-safe).
```csharp
public event Action<string>? Raised;  protected void OnRaised(string s)=>Raised?.Invoke(s);
```
**Q443. EventHandler?** Standard delegate `void EventHandler(object? sender, EventArgs e)`.
**Q444. EventHandler<TEventArgs>?** Standard generic delegate with custom data: `EventHandler<OrderEventArgs>`.
**Q445. Notification system using delegates and events.**
```csharp
public class NotificationEventArgs : EventArgs { public string Message {get;} public NotificationEventArgs(string m)=>Message=m; }

public class NotificationPublisher {
  public event EventHandler<NotificationEventArgs>? Notified;
  public void Publish(string msg)=>Notified?.Invoke(this, new NotificationEventArgs(msg));
}
public class EmailSubscriber { public void OnNotified(object? s, NotificationEventArgs e)=>Console.WriteLine($"Email: {e.Message}"); }
public class SmsSubscriber   { public void OnNotified(object? s, NotificationEventArgs e)=>Console.WriteLine($"SMS: {e.Message}"); }

var pub = new NotificationPublisher(); var em = new EmailSubscriber(); var sms = new SmsSubscriber();
pub.Notified += em.OnNotified; pub.Notified += sms.OnNotified;
pub.Publish("Order shipped");     // both notified
pub.Notified -= sms.OnNotified;   // unsubscribe
```
**🎯** Mention: null-safe invoke `?.Invoke`, unsubscribe to avoid leaks, `async` event handlers use `async void` only for events.

---

# Section 12 — Generics and LINQ (Q446–475)

**Q446. Generics?** Type parameters allow reusable, type-safe code: `List<T>`.
**Q447. Why useful?** Type safety, no boxing, reuse, performance, less casting.
**Q448. Generic class?**
```csharp
class Box<T>{ public T Value {get;set;} } var b = new Box<int>{Value=5};
```
**Q449. Generic method?** `static void Swap<T>(ref T a, ref T b){ (a,b)=(b,a); }` — `T` is inferred at the call.
**Q450. Generic interface?** `interface IRepository<T>{ T? Get(int id); void Add(T item); }`
**Q451. Generic constraints?** `where` clauses restricting the allowed type arguments so you can use members of `T`.
**Q452. where constraint?** `class Repo<T> where T : class, IEntity, new()`.
**Q453. where T : class?** T must be a reference type (non-nullable ref in nullable context).
**Q454. where T : struct?** T must be a non-nullable value type.
**Q455. where T : new()?** T must have a public parameterless ctor (`new T()` allowed); must be last constraint.
**Q456. where T : BaseClass?** T must be or derive from BaseClass.
**Q457. where T : Interface?** T must implement the interface.
```csharp
T Max<T>(T a, T b) where T : IComparable<T> => a.CompareTo(b) > 0 ? a : b;
```
**Q458. Covariance?** Use a more *derived* type than specified (`out`): `IEnumerable<string>` → `IEnumerable<object>`.
**Q459. Contravariance?** Use a more *general* type (`in`): `Action<object>` → `Action<string>`; `IComparer<object>` → `IComparer<string>`.
**Q460. Invariant generic type?** No variance: `List<string>` is not `List<object>` (would break type safety since T is used both in and out).
**Q461. LINQ?** Language Integrated Query — unified query syntax over objects, XML, SQL (EF), etc.
**Q462. Benefits?** Readable declarative code, compile-time checking, composable, one syntax for many sources.
**Q463. LINQ to Objects?** Queries over in-memory `IEnumerable<T>` (arrays, lists).
Data for examples below:
```csharp
var emps = new List<Employee>{ new("A","IT",5000), new("B","HR",4000), new("C","IT",6000) };
```
**Q464. Where()?** Filters: `emps.Where(e => e.Salary > 4500)`.
**Q465. Select()?** Projects/transforms: `emps.Select(e => e.Name)`.
**Q466. Where vs Select?** Where → *subset* of same elements (filter); Select → *transform* each element (same count).
**Q467. SelectMany()?** Flattens nested collections.
`orders.SelectMany(o => o.Items)`; `new[]{"a b","c"}.SelectMany(s=>s.Split(' '))`.
**Q468. OrderBy()?** Ascending sort: `emps.OrderBy(e=>e.Salary)`; `OrderByDescending`.
**Q469. ThenBy()?** Secondary sort: `emps.OrderBy(e=>e.Dept).ThenByDescending(e=>e.Salary)`.
**Q470. GroupBy()?** `emps.GroupBy(e=>e.Dept).Select(g=>new{Dept=g.Key,Total=g.Sum(e=>e.Salary)})`.
**Q471. Join()?** Inner join:
```csharp
var r = emps.Join(depts, e=>e.DeptId, d=>d.Id, (e,d)=>new{e.Name,d.Title});
```
**Q472. Any()?** True if any element (matches): `emps.Any(e=>e.Salary>5500)`. Prefer over `Count()>0`.
**Q473. All()?** True if every element matches (true for empty): `emps.All(e=>e.Salary>0)`.
**Q474. First() vs FirstOrDefault()?** `First` throws `InvalidOperationException` when no match; `FirstOrDefault` returns `default(T)`.
**Q475. Single() vs SingleOrDefault()?** `Single` expects exactly one (throws if 0 or >1); `SingleOrDefault` returns default for 0, throws for >1.
**🎯** Use `Single` when business rule says "exactly one"; `FirstOrDefault` when "any is fine".

---

# Section 13 — Advanced C# and Technical Interview (Q476–500)

**Q476. IEnumerable vs IQueryable?**
| | IEnumerable<T> | IQueryable<T> |
|---|---|---|
| Namespace | System.Collections.Generic | System.Linq |
| Executes | In memory (LINQ to Objects) | Translated by a provider (e.g., EF → SQL) |
| Predicate type | `Func<>` delegate | `Expression<Func<>>` tree |
| Use | In-memory data | Remote/DB queries |

```csharp
var q = db.Users.Where(u => u.Age > 18);   // IQueryable → SQL WHERE
var bad = db.Users.AsEnumerable().Where(u => u.Age > 18); // loads ALL rows, filters in memory
```
**🎯** Classic pitfall: calling `ToList()`/`AsEnumerable()` too early pulls the whole table.

**Q477. Deferred execution in LINQ?** Query isn't run until enumerated (`foreach`, `ToList`, `Count`). Re-enumerating re-runs the query; captured variables are read at execution time.
```csharp
int min = 2; var q = nums.Where(n => n > min); min = 5; // uses 5 when executed
```
**Q478. Immediate execution in LINQ?** Operators returning a scalar or materialized collection run instantly: `ToList`, `ToArray`, `ToDictionary`, `Count`, `Sum`, `Max`, `First`, `Any`.
**Q479. ToList() vs AsEnumerable()?** `ToList()` executes now and creates a new `List<T>` snapshot; `AsEnumerable()` just changes the static type to `IEnumerable<T>` (still deferred) — used to switch from DB to in-memory processing.
**Q480. Extension method?** A static method in a static class that appears as an instance method of another type, via `this` on the first parameter.
**Q481. Create one?**
```csharp
public static class StringExtensions {
  public static bool IsPalindrome(this string s) { var t = s.ToLower(); return t.SequenceEqual(t.Reverse()); } }
bool ok = "Level".IsPalindrome();
```
**Q482. Why static?** They're syntactic sugar over static method calls; no instance of the extension class exists, and the extended type isn't modified. Instance methods always win over extension methods of the same signature.
**Q483. Anonymous type?** Compiler-generated immutable class with read-only properties, created by `new { }`.
`var p = new { Name = "Ali", Age = 30 };`
**🎯** Reference type, local scope (can't be returned typed from methods), great for LINQ projections.
**Q484. Tuple?** Lightweight grouping of values: `(string Name, int Age) t = ("Ali", 30);` — `ValueTuple` struct, mutable, deconstructable.
**Q485. Tuple vs anonymous type?**
| | Tuple | Anonymous type |
|---|---|---|
| Kind | struct (ValueTuple) | class |
| Mutable | Yes | No (read-only) |
| Return from method | Yes | No (without object/dynamic) |
| Deconstruct | Yes | No |
| Names | Compile-time only | Real properties |

**Q486. Records?** Reference types (C# 9) with value-based equality, immutability friendly syntax, `with` expressions, built-in `ToString`.
```csharp
public record Person(string Name, int Age);
var p1 = new Person("A", 20); var p2 = p1 with { Age = 21 }; Console.WriteLine(p1 == new Person("A",20)); // True
```
**Q487. Class vs record?** Class: reference equality by default, mutable. Record: value equality, `with`, positional syntax, deconstruction, designed for immutable data/DTOs.
**Q488. Record struct (C# 10)?** Value-type record: `public readonly record struct Point(int X, int Y);` — value equality, no heap allocation. Plain `record struct` has mutable properties; `readonly record struct` is immutable.
**Q489. Pattern matching?** Testing a value's shape/type/properties: type, constant, relational, property, positional, logical (`and/or/not`), list patterns.
**Q490. Property pattern?**
```csharp
if (order is { Status: "Paid", Total: > 1000, Customer.Country: "IN" }) Approve();
```
**Q491. Switch expression?**
```csharp
decimal Tax(Order o) => o switch { { Total: > 10000 } => 0.18m, { Total: > 1000 } => 0.12m, _ => 0.05m };
```
**Q492. async?** Modifier enabling `await` inside a method; the compiler turns it into a state machine; returns `Task`, `Task<T>`, `ValueTask`, or `void` (only for event handlers).
**Q493. await?** Asynchronously waits for a task without blocking the thread; resumes after completion (capturing `SynchronizationContext` unless `ConfigureAwait(false)`).
```csharp
async Task<string> GetAsync(HttpClient c, string url) { var r = await c.GetAsync(url); return await r.Content.ReadAsStringAsync(); }
```
**🎯** Never use `.Result`/`.Wait()` (deadlocks); avoid `async void`.
**Q494. Task?** Represents an asynchronous operation (a promise); has status, result, exceptions, continuations, cancellation. `Task.Run`, `Task.WhenAll`, `Task.WhenAny`, `Task.Delay`.
**Q495. Task vs Thread vs ThreadPool?**
| | Thread | ThreadPool | Task |
|---|---|---|---|
| Level | OS thread (dedicated) | Pool of reusable worker threads | Higher-level abstraction on top of the pool |
| Cost | Heavy (~1 MB stack) | Cheap | Cheap |
| Result/Exceptions | Manual | Manual | Built-in (`Task<T>`, `await`) |
| Cancellation | Manual | Manual | `CancellationToken` |

**🎯** I/O-bound → `async/await` (no thread waiting); CPU-bound → `Task.Run`/`Parallel.For`; long-running dedicated work → `Thread` or `TaskCreationOptions.LongRunning`.
**Q496. CancellationToken?** Cooperative cancellation signal.
```csharp
using var cts = new CancellationTokenSource(TimeSpan.FromSeconds(5));
async Task Work(CancellationToken ct){ while(true){ ct.ThrowIfCancellationRequested(); await Task.Delay(100, ct); } }
try { await Work(cts.Token); } catch (OperationCanceledException) { Console.WriteLine("Cancelled"); }
```
**Q497. IDisposable?** Interface with `Dispose()` for deterministic release of unmanaged/expensive resources (files, DB connections, sockets).
```csharp
class Res : IDisposable { bool _d; public void Dispose(){ if(_d) return; /* free */ _d=true; GC.SuppressFinalize(this);} }
```
**🎯** Full dispose pattern with `protected virtual void Dispose(bool disposing)` + finalizer only if holding unmanaged resources directly. Also `IAsyncDisposable`.
**Q498. using statement?** Ensures `Dispose()` is called even on exceptions (compiled to try/finally).
```csharp
using (var f = File.OpenRead("a.txt")) { }   // classic
using var g = File.OpenRead("b.txt");        // using declaration (C# 8): disposed at end of scope
```
**Q499. Garbage collection & how .NET GC works?**
- **Managed heap** with **generations**: Gen 0 (new, short-lived), Gen 1 (buffer), Gen 2 (long-lived), plus **LOH** (objects ≥ 85,000 bytes) and POH.
- **Mark** reachable objects from **roots** (stack, statics, registers, handles) → **sweep/compact** (relocate survivors, update references) → survivors promoted to the next generation.
- Gen 0/1 collections are fast and frequent; Gen 2 is a full (blocking or background) GC.
- Modes: Workstation vs Server, Concurrent/Background GC.
- Finalizable objects get an extra GC cycle (finalization queue) → prefer `IDisposable`.
```csharp
GC.Collect(); // avoid in production; GC.GetTotalMemory(false); GC.GetGeneration(obj);
```
**🎯** Say: "Memory leaks in .NET are usually *rooted references*: static events, unsubscribed handlers, caches, captured closures."

**Q500. Design and implement a complete C# application using OOP, SOLID, interfaces, DI, generics, collections, LINQ, exceptions, delegates/events, async/await, and clean architecture. Explain every design decision.**

### Scenario: **Order Management System (console + DI)**
**Clean Architecture layers (dependencies point inward):**
```
Domain  (entities, value objects, domain exceptions, interfaces)    ← no dependencies
Application (use cases/services, DTOs, abstractions)                 ← depends on Domain
Infrastructure (repositories, payment gateways, notifiers)           ← depends on Application/Domain
Presentation (Program.cs, composition root / DI)                     ← depends on all, wires them
```

#### 1. Domain Layer
```csharp
// --- Domain/Entities.cs ---
namespace OrderSystem.Domain;

public interface IEntity { Guid Id { get; } }

public abstract class Entity : IEntity { public Guid Id { get; } = Guid.NewGuid(); }   // abstraction + inheritance

public enum OrderStatus { Pending, Paid, Shipped, Cancelled }

public record Money(decimal Amount, string Currency = "INR") {                        // value object (record)
    public static Money operator +(Money a, Money b) => new(a.Amount + b.Amount, a.Currency);
}

public class OrderItem {
    public string Product { get; }
    public int Quantity { get; }
    public decimal UnitPrice { get; }
    public decimal Total => Quantity * UnitPrice;                                     // computed property
    public OrderItem(string product, int qty, decimal price) {
        if (qty <= 0) throw new DomainException("Quantity must be positive");         // invariant protected (encapsulation)
        Product = product; Quantity = qty; UnitPrice = price; } }

public class Order : Entity {
    private readonly List<OrderItem> _items = new();                                  // composition: Order owns items
    public IReadOnlyList<OrderItem> Items => _items;                                  // expose read-only
    public OrderStatus Status { get; private set; } = OrderStatus.Pending;            // private setter
    public string CustomerEmail { get; }
    public decimal Total => _items.Sum(i => i.Total);                                 // LINQ

    public event EventHandler<OrderStatus>? StatusChanged;                            // event (publisher)

    public Order(string email) => CustomerEmail = email;
    public void AddItem(OrderItem item) { if (Status != OrderStatus.Pending) throw new DomainException("Order is locked"); _items.Add(item); }
    public void MarkPaid() { Status = OrderStatus.Paid; StatusChanged?.Invoke(this, Status); }
}

public class DomainException : Exception {                                           // custom exception
    public DomainException(string message) : base(message) { } }

// --- Domain/Abstractions.cs ---
public interface IRepository<T> where T : IEntity {                                   // generic + constraint
    Task AddAsync(T entity, CancellationToken ct = default);
    Task<T?> GetAsync(Guid id, CancellationToken ct = default);
    Task<IReadOnlyList<T>> FindAsync(Func<T, bool> predicate, CancellationToken ct = default);
}
```
**Decisions:** Entities hold invariants (encapsulation); `Money` is a record (value equality, immutable); `IRepository<T>` generic constraint avoids duplicate repositories; the domain has **no dependency** on frameworks.

#### 2. Application Layer
```csharp
namespace OrderSystem.Application;
using OrderSystem.Domain;

public interface IPaymentGateway { Task<bool> ChargeAsync(decimal amount, CancellationToken ct); }   // ISP: small interfaces
public interface INotifier       { Task NotifyAsync(string to, string message, CancellationToken ct); }

public record CreateOrderRequest(string Email, List<(string Product, int Qty, decimal Price)> Items);   // DTO + tuple

public class OrderService {                                                                             // SRP: orchestrates use cases only
    private readonly IRepository<Order> _repo; private readonly IPaymentGateway _pay; private readonly INotifier _notifier;
    public OrderService(IRepository<Order> repo, IPaymentGateway pay, INotifier notifier)               // constructor injection (DIP)
        => (_repo, _pay, _notifier) = (repo, pay, notifier);

    public async Task<Order> PlaceOrderAsync(CreateOrderRequest req, CancellationToken ct = default) {
        if (req is null || req.Items.Count == 0) throw new ArgumentException("Order needs items", nameof(req));
        var order = new Order(req.Email);
        foreach (var (p, q, price) in req.Items) order.AddItem(new OrderItem(p, q, price));

        order.StatusChanged += async (_, s) => await _notifier.NotifyAsync(order.CustomerEmail, $"Order {order.Id} is {s}", ct); // event + lambda

        if (!await _pay.ChargeAsync(order.Total, ct)) throw new DomainException("Payment failed");
        order.MarkPaid();
        await _repo.AddAsync(order, ct);
        return order; }

    public async Task<IEnumerable<Order>> GetHighValueOrdersAsync(decimal min, CancellationToken ct = default)
        => (await _repo.FindAsync(o => o.Total >= min, ct)).OrderByDescending(o => o.Total);              // LINQ
}
```
**Decisions:** Use case logic lives here; depends only on abstractions; async end-to-end with `CancellationToken`; the event decouples notification from order logic (observer pattern).

#### 3. Infrastructure Layer
```csharp
namespace OrderSystem.Infrastructure;
using System.Collections.Concurrent;
using OrderSystem.Domain; using OrderSystem.Application;

public class InMemoryRepository<T> : IRepository<T> where T : class, IEntity {
    private readonly ConcurrentDictionary<Guid, T> _store = new();                                         // thread-safe collection
    public Task AddAsync(T e, CancellationToken ct = default) { _store[e.Id] = e; return Task.CompletedTask; }
    public Task<T?> GetAsync(Guid id, CancellationToken ct = default) => Task.FromResult(_store.GetValueOrDefault(id));
    public Task<IReadOnlyList<T>> FindAsync(Func<T,bool> p, CancellationToken ct = default)
        => Task.FromResult<IReadOnlyList<T>>(_store.Values.Where(p).ToList()); }

public class FakePaymentGateway : IPaymentGateway {
    public async Task<bool> ChargeAsync(decimal amount, CancellationToken ct) { await Task.Delay(100, ct); return amount > 0; } }

public class ConsoleNotifier : INotifier {
    public Task NotifyAsync(string to, string msg, CancellationToken ct) { Console.WriteLine($"[Notify → {to}] {msg}"); return Task.CompletedTask; } }
```
**Decisions:** Swappable implementations (replace with EF Core/Stripe/SMTP without touching Application/Domain → OCP & DIP). `ConcurrentDictionary` for thread-safety.

#### 4. Presentation / Composition Root
```csharp
using Microsoft.Extensions.DependencyInjection;
using OrderSystem.Application; using OrderSystem.Domain; using OrderSystem.Infrastructure;

var services = new ServiceCollection()
    .AddSingleton(typeof(IRepository<>), typeof(InMemoryRepository<>))   // open-generic registration
    .AddSingleton<IPaymentGateway, FakePaymentGateway>()
    .AddSingleton<INotifier, ConsoleNotifier>()
    .AddTransient<OrderService>()
    .BuildServiceProvider();

var svc = services.GetRequiredService<OrderService>();
using var cts = new CancellationTokenSource(TimeSpan.FromSeconds(10));
try {
    var order = await svc.PlaceOrderAsync(new("ali@test.com", new() { ("Laptop", 1, 60000m), ("Mouse", 2, 500m) }), cts.Token);
    Console.WriteLine($"Order {order.Id} total {order.Total} status {order.Status}");
    foreach (var o in await svc.GetHighValueOrdersAsync(1000, cts.Token)) Console.WriteLine($"High value: {o.Id}");
}
catch (DomainException ex)       { Console.WriteLine($"Business error: {ex.Message}"); }   // expected failures
catch (OperationCanceledException) { Console.WriteLine("Cancelled"); }
catch (Exception ex)             { Console.WriteLine($"Unexpected: {ex}"); /* log + rethrow in real apps */ }
```
**Decisions:** Only the composition root knows concrete types; DI container controls lifetimes; exceptions are handled at the boundary with specific → general ordering; top-level statements keep the entry point minimal.

#### 5. Concept → Where it appears (answer this in the interview)
| Requirement | Where used | Why |
|---|---|---|
| OOP (Encapsulation/Inheritance/Polymorphism/Abstraction) | `Entity`, `Order` private state, `IPaymentGateway` implementations | Protect invariants, reuse, swap behavior |
| SOLID | SRP (OrderService vs Repository), OCP (new gateway = new class), LSP (any `IRepository<T>` works), ISP (tiny interfaces), DIP (ctor injection) | Maintainable, testable code |
| Interfaces | `IRepository<T>`, `IPaymentGateway`, `INotifier` | Contracts and mocking |
| Dependency Injection | `ServiceCollection` | Loose coupling, lifetime control |
| Generics | `IRepository<T>`, `InMemoryRepository<T>` with constraints | One repository for all entities, type-safe |
| Collections | `List`, `IReadOnlyList`, `ConcurrentDictionary` | Right structure per need |
| LINQ | `Sum`, `Where`, `OrderByDescending` | Declarative queries |
| Exceptions | `DomainException`, boundary try/catch | Distinguish business vs system errors |
| Delegates/Events | `StatusChanged` event, `Func<T,bool>` predicate | Observer pattern, flexible filtering |
| async/await | Service and repository methods, `CancellationToken` | Non-blocking I/O, cancelable ops |
| Clean Architecture | 4 layers, inward dependencies | Business rules independent of frameworks/UI/DB |

**Unit-test example (proves testability):**
```csharp
[Fact] public async Task PlaceOrder_Throws_WhenPaymentFails() {
    var svc = new OrderService(new InMemoryRepository<Order>(), new AlwaysFailGateway(), new ConsoleNotifier());
    await Assert.ThrowsAsync<DomainException>(() => svc.PlaceOrderAsync(new("a@b.c", new(){("X",1,10m)})));
}
```
**🎯 Interview Point:** Walk through: *requirements → layers → abstractions → implementation → composition root → tests → trade-offs* (e.g., "in production I'd swap in EF Core, add Polly retries for the gateway, use an outbox for notifications, and avoid `async void` in events by using a domain-event dispatcher").

---

## ✅ Quick Revision Cheat-Sheet
- **Value vs Reference**, **boxing**, **string immutability**, **const vs readonly**
- **Abstract class vs interface**, **virtual/override/new**, **SOLID**
- **IEnumerable vs IQueryable**, **deferred execution**, **Equals/GetHashCode**
- **async/await** (no `.Result`, no `async void`), **IDisposable/using**, **GC generations**
- **throw vs throw ex**, **ref/out/in**, **Task vs Thread**

*End of document — all 500 questions covered.*
