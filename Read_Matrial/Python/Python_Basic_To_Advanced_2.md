# 🐍 Python: Complete Beginner-to-Advanced Programming & Interview Guide

> **Purpose:** A practical study guide built from every topic in the supplied Python roadmap. Each chapter includes simple explanations, runnable examples, interview-ready short notes, and alternative approaches where they matter. Use Python 3.10+ unless a note says otherwise.

## 🧭 Quick Navigation

- [How to use this guide](#-how-to-use-this-guide)
- [Part 1 — Fundamentals](#part-1--python-fundamentals)
  - [1. Introduction, setup and execution](#1-introduction-setup-and-execution)
  - [2. Syntax, tokens and structure](#2-syntax-tokens-and-structure)
  - [3. Variables, references and memory basics](#3-variables-references-and-memory-basics)
  - [4. Input and output](#4-input-and-output)
  - [5. Data types](#5-data-types)
  - [6. Conversion and casting](#6-conversion-and-casting)
  - [7. Operators](#7-operators)
  - [8. Conditional statements](#8-conditional-statements)
  - [9. Loops](#9-loops)
  - [10. Strings](#10-strings)
  - [11. Lists](#11-lists)
  - [12. Tuples, sets and dictionaries](#12-tuples-sets-and-dictionaries)
- [Part 2 — Functions and core programming](#part-2--functions-and-core-programming)
  - [13. Functions](#13-functions)
  - [14. Comprehensions and unpacking](#14-comprehensions-and-unpacking)
  - [15. Recursion and problem-solving](#15-recursion-and-problem-solving)
  - [16. Object-oriented programming](#16-object-oriented-programming-oop)
  - [17. Exception handling](#17-exception-handling)
  - [18. File handling](#18-file-handling)
  - [19. Modules, packages and imports](#19-modules-packages-and-imports)
  - [20. Iterators and generators](#20-iterators-and-generators)
- [Part 3 — Intermediate and standard library](#part-3--intermediate-python-and-standard-library)
  - [21. Decorators](#21-decorators)
  - [22. Built-in function reference](#22-built-in-function-reference)
  - [23. Essential standard library](#23-essential-standard-library)
  - [24. Regular expressions](#24-regular-expressions-regex)
  - [25. Date and time](#25-date-and-time)
  - [26. Command-line programs and configuration](#26-command-line-programs-and-configuration)
  - [27. Type hints and static typing](#27-type-hints-and-static-typing)
  - [28. Memory management and internals](#28-memory-management-and-internals)
- [Interview revision sheet](#-interview-revision-sheet)
- [Practice problems](#-practice-problems)
- [Official learning links](#-official-learning-links)

## 🎯 How to use this guide

1. Read the **concept** and run the example yourself.
2. Change the input and predict the output before running it.
3. Learn the **interview short note** at the end of each chapter.
4. Solve the practice questions without copying the answer.
5. For production code, prefer readable, tested solutions over clever one-liners.

**Interview answer pattern:** define the concept → explain why it is useful → show a small example → mention one limitation or alternative.

---

# Part 1 — Python Fundamentals

## 1. Introduction, setup and execution

### What is Python?
Python is a high-level, general-purpose programming language known for readable syntax and a large standard library. It is used for automation, web backends, data analysis, AI/ML, testing, scripting and tools.

```python
name = "Asha"
print(f"Hello, {name}!")
```

### History, features, advantages and limitations
Python was created by Guido van Rossum and first released in 1991. Python 3 is the current language family; Python 2 reached end of life in 2020.

- **Features:** readable indentation-based syntax, dynamic typing, garbage collection in common implementations, multi-paradigm programming, cross-platform support, rich ecosystem.
- **Advantages:** fast development, beginner-friendly, extensive libraries, excellent scripting and data ecosystem.
- **Limitations:** often slower than compiled native code for CPU-heavy loops; runtime type errors are possible; deployment and dependency management need care.
- **Applications:** Django/FastAPI web services, pandas analysis, NumPy scientific work, ML, automation, testing, DevOps and education.

### Python vs Java vs C vs C++

| Area | Python | Java | C | C++ |
|---|---|---|---|---|
| Typical level | High-level | High-level | Lower-level/system | Systems + high-level abstractions |
| Typing | Dynamic | Static | Static | Static |
| Memory | Managed in common implementations | Garbage-collected runtime | Manual/explicit management common | Manual and RAII/smart pointers |
| Typical strength | Productivity, scripting, data | Enterprise apps, JVM ecosystem | OS/embedded/performance | Games, systems, performance |
| Execution | Commonly bytecode + VM | Bytecode + JVM/JIT | Compiled native code | Compiled native code |

There is no universally “best” language; choose by requirements, ecosystem and performance needs.

### Python 2 vs Python 3
Python 3 uses `print()` as a function, has Unicode strings by default, and has different division and library behavior in some cases. Do not start new projects in Python 2.

```python
print("Python 3")
print(5 / 2)   # 2.5
print(5 // 2)  # 2
```

### Interpreter, source code, bytecode and PVM
In CPython, source (`.py`) is parsed/compiled into bytecode, then the Python Virtual Machine executes that bytecode. Bytecode is an implementation detail, not native machine code. Other Python implementations may work differently.

**Simplified flow:** `.py source → parser/compiler → bytecode → Python runtime/VM → result`.

“Compiled vs interpreted” is not a strict either/or: CPython compiles to bytecode and then interprets it. Some runtimes use JIT compilation.

### Install and run
- Install Python 3 from the official Python website or your operating system package manager.
- On Windows, enable the launcher/PATH option if offered. Check with `py --version` or `python --version`.
- On Linux/macOS, check `python3 --version`.
- Editors: IDLE is simple; VS Code is flexible with the Python extension; PyCharm is a Python-focused IDE.
- Script mode: save `hello.py`, then run `python hello.py` or `python3 hello.py`.
- Interactive mode: type `python`/`python3` in a terminal and enter statements one at a time.
- Jupyter Notebook/Google Colab execute code in cells and are useful for exploration and data science.

### Virtual environments and pip
A virtual environment isolates project dependencies.

```bash
python -m venv .venv
# Windows PowerShell:
.venv\Scripts\Activate.ps1
# macOS/Linux:
source .venv/bin/activate
python -m pip install requests
python -m pip freeze > requirements.txt
```

Use `python -m pip` so pip belongs to the selected interpreter. Keep dependency versions reproducible for team projects.

**Interview short note 🎤:** Python is commonly described as interpreted, dynamically typed and high-level. Explain the CPython bytecode step instead of claiming the source is executed directly line-by-line. Know the difference between an interpreter, virtual environment and package manager.

## 2. Syntax, tokens and structure

Python uses indentation to define blocks. Four spaces per indentation level is the common convention.

```python
score = 82
if score >= 50:
    print("Pass")
else:
    print("Try again")
```

- **Statement:** an instruction, such as `total = 3`.
- **Expression:** code that produces a value, such as `3 + 4`.
- **Tokens:** keywords (`if`, `class`), identifiers (`total`), literals (`42`, `"hi"`), operators (`+`, `==`) and delimiters (`()`, `[]`, `:`).
- **Identifiers:** names cannot start with a digit and cannot be a keyword; names are case-sensitive (`age` differs from `Age`).
- **Naming:** `snake_case` for variables/functions, `PascalCase` for classes, `UPPER_CASE` for constants by convention.
- **Comments:** `# explanation`. Triple-quoted strings are commonly used as docstrings, but are not a special multiline-comment syntax.
- **Docstrings:** first string in a module/class/function, documenting its purpose.

```python
def area(width: float, height: float) -> float:
    """Return the area of a rectangle."""
    return width * height
```

Escape sequences: `\n` newline, `\t` tab, `\\` backslash, `\'` quote, `\"` double quote, `\r` carriage return and `\b` backspace. Raw strings such as `r"C:\new\test"` reduce backslash escaping, but cannot end in an odd number of backslashes.

Explicit line continuation uses `\`; parentheses/brackets/braces are usually cleaner. Multiple statements separated by semicolons are legal but usually less readable. `pass` is a no-op placeholder. `...` is the Ellipsis object and can be used as a placeholder in stubs or advanced code.

```python
if __name__ == "__main__":
    # Runs only when this file is executed as the main program.
    print("Run directly")
```

This convention lets a file be both imported as a module and run as a script. `__main__` is not a function; it is the module name when executed directly. Python also has soft keywords whose meaning depends on context, such as `match`/`case` in structural pattern matching.

**Interview short note 🎤:** Indentation is syntax, not decoration. Know keyword vs identifier vs literal, comment vs docstring, and why the `__main__` guard prevents demo code from running during import.

## 3. Variables, references and memory basics

A variable is a **name bound to an object**; it is not a typed storage box in the C sense. Python is dynamically typed, so a name can later refer to an object of another type.

```python
x = 10
x = "ten"              # valid dynamic rebinding
left, right = 1, 2      # unpacking
first = second = []     # both names refer to the SAME list — beware!
a, b = b, a             # swap without a temporary variable
```

Type annotations communicate expected types to humans and static checkers; they do not normally enforce types at runtime.

```python
age: int = 21
name: str = "Ravi"
```

`id(obj)` gives an identity value during that object's lifetime; `type(obj)` returns its type; `is` tests identity; `==` tests equality. Use `is None` to check for `None`.

```python
p = [1, 2]
q = p
q.append(3)
print(p)       # [1, 2, 3]
print(p is q)  # True
```

- **Mutable:** list, dict, set, bytearray; contents can change.
- **Immutable:** int, float, bool, str, tuple (although a tuple may contain a mutable object), bytes, frozenset.
- Assignment binds another name; it does not automatically copy an object.
- `del name` removes a binding; an object is reclaimed only when it is no longer reachable and implementation rules allow it.
- Scope is explained by LEGB: Local, Enclosing, Global, Built-in.

**Interview short note 🎤:** Explain aliasing with a list example. `is` is not a substitute for `==`; identity is appropriate for singletons such as `None`. Constants are conventionally uppercase, not enforced as immutable.

## 4. Input and output

`input()` always returns a string. Convert it before arithmetic.

```python
name = input("Name: ")
age = int(input("Age: "))
height = float(input("Height in metres: "))
print(name, age, height, sep=" | ", end="\n")
```

Multiple values:

```python
x, y = input("Enter two words: ").split()
a, b = map(int, input("Enter two integers: ").split())
```

`print(*objects, sep=' ', end='\n', file=None, flush=False)` writes formatted text. `sep` separates objects; `end` replaces the ending newline; `file` chooses a writable stream; `flush=True` requests immediate flushing.

```python
print("A", "B", "C", sep="-", end="!")  # A-B-C!
```

Formatting approaches:

```python
price = 19.5
print(f"Price: {price:.2f}")           # recommended for most modern code
print("Price: {:.2f}".format(price))
print("Price: %.2f" % price)            # older style
```

`str(x)` is human-readable; `repr(x)` aims to be an unambiguous/debug-friendly representation. `sys.stdout.write()` writes a string and does not automatically add a newline. `split()` returns pieces of a string; `map(int, ...)` lazily converts pieces to integers.

Read until a sentinel:

```python
while True:
    line = input("Enter value (q to stop): ")
    if line.lower() == "q":
        break
    print("You entered:", line)
```

Catch `ValueError` around conversions when input may be invalid. For a fixed number of inputs, unpacking is concise; for an unknown count, use a list comprehension.

**Interview short note 🎤:** The most common beginner bug is forgetting that `input()` returns `str`. Know f-strings, `sep`, `end`, `split`, `map`, and `str` vs `repr`.

## 5. Data types

Use `type(value)` to inspect a type and `isinstance(value, SomeType)` when checking whether a value belongs to a class or subclass.

### Main built-in types

| Type | Example | Mutable? | Key point |
|---|---|---:|---|
| `int` | `42`, `0b1010`, `0xFF` | No | Arbitrary precision in Python integers, limited by available memory |
| `float` | `3.14`, `1e-3` | No | Binary floating point may have rounding error |
| `complex` | `2 + 3j` | No | `.real` and `.imag` expose parts |
| `bool` | `True`, `False` | No | Subclass of `int`; `True == 1` is true |
| `NoneType` | `None` | N/A | Represents absence/no value |
| `str` | `"hello"` | No | Unicode text sequence |
| `list` | `[1, "a"]` | Yes | Ordered, mutable, allows duplicates |
| `tuple` | `(1, "a")` | No | Ordered, immutable container; singleton is `(1,)` |
| `range` | `range(5)` | No | Compact arithmetic sequence, commonly for loops |
| `bytes` | `b"abc"` | No | Immutable byte sequence |
| `bytearray` | `bytearray(b"abc")` | Yes | Mutable byte sequence |
| `memoryview` | `memoryview(b"abc")` | View | Exposes buffer data without necessarily copying |
| `set` | `{1, 2}` | Yes | Unique hashable values; no positional indexing |
| `frozenset` | `frozenset({1, 2})` | No | Immutable set, can be a dict key if its elements are hashable |
| `dict` | `{"id": 1}` | Yes | Insertion-ordered mapping; keys must be hashable |

### Numeric details

```python
print(7 / 2)       # 3.5: true division
print(7 // 2)      # 3: floor division
print(7 % 2)       # 1: remainder
z = 2 + 3j
print(z.real, z.imag)  # 2.0 3.0
print(0.1 + 0.2)   # commonly 0.30000000000000004
```

For decimal currency calculations, consider `decimal.Decimal` created from strings, e.g. `Decimal("0.10")`; for rational values, use `fractions.Fraction(1, 3)`. Underscores can improve numeric literal readability: `1_000_000`. Binary/octal/hex prefixes are `0b`, `0o`, `0x`.

### Truth values and None

Falsy values include `False`, `None`, numeric zero, and empty collections/strings. Most other objects are truthy. Prefer `if not items:` over `if len(items) == 0:` when checking emptiness. Use `x is None`, not `x == None`.

### Iterable, hashable and conversion concepts

- **Iterable:** can produce an iterator, e.g. list, string, dict, range. An integer is not iterable by default.
- **Hashable:** has a stable hash and equality behavior suitable for set elements/dict keys. Lists and dicts are unhashable; many immutable values are hashable, but a tuple is hashable only if all its elements are hashable.
- **Built-in vs user-defined:** `list` is built-in; `class Student: ...` defines a custom type.
- **Implicit conversion:** Python may promote numeric values in an expression, such as `2 + 3.5 → 5.5`. **Explicit conversion:** `int("12")`.
- Type hints document expected types; they do not replace runtime validation.

```python
values = [1, 2, 3]
print(isinstance(values, list))
print(isinstance(True, int))  # True: bool subclasses int
```

**Interview short note 🎤:** Be ready to compare list/tuple/set/dict, mutable/immutable, iterable/iterator, and equality/identity. Explain why `0.1 + 0.2` is not always exactly `0.3`, and use `Decimal` for decimal arithmetic where appropriate.

## 6. Conversion and casting

Conversion functions create values of another type when the input is valid.

```python
int("12")          # 12
float("3.5")       # 3.5
complex(2, 3)       # (2+3j)
str(42)             # '42'
bool(0)             # False
list("cat")        # ['c', 'a', 't']
tuple([1, 2])       # (1, 2)
set([1, 1, 2])      # {1, 2}
frozenset([1, 2])
dict([("a", 1), ("b", 2)])
bytes("hi", "utf-8")
bytearray(b"hi")
ord("A")            # 65
chr(65)              # 'A'
bin(10), oct(10), hex(10)
round(3.14159, 2)    # 3.14
abs(-9)              # 9
format(12.345, ".1f") # '12.3'
ascii("café")       # escaped representation
repr("hello\n")
```

`int("3.2")` raises `ValueError`; use `int(float("3.2"))` only if truncation is actually desired. `bool("False")` is `True` because non-empty strings are truthy; parse textual booleans explicitly. Conversion from text to bytes requires an encoding: `"hello".encode("utf-8")`; reverse with `data.decode("utf-8")`.

For collections, `list(iterable)`, `tuple(iterable)`, `set(iterable)` and `dict(pairs)` have different semantics. A set removes duplicates and does not preserve a meaningful positional order. `str.maketrans()` plus `translate()` supports character mapping/removal.

**Interview short note 🎤:** Casting can fail and may lose information (`int(3.9)` becomes `3`, truncating toward zero). Distinguish `round()` from `int()`, and distinguish text encoding from numeric conversion.

## 7. Operators

| Family | Operators | Example |
|---|---|---|
| Arithmetic | `+ - * / // % **` | `2 ** 3 == 8` |
| Comparison | `== != < > <= >=` | `age >= 18` |
| Assignment | `= += -= *= /= //= %= **=` | `n += 1` |
| Bitwise | `& | ^ ~ << >>` | `5 & 3 == 1` |
| Logical | `and or not` | `age >= 18 and active` |
| Identity | `is`, `is not` | `value is None` |
| Membership | `in`, `not in` | `"py" in "python"` |
| Conditional expression | `a if condition else b` | `label = "adult" if age >= 18 else "minor"` |
| Assignment expression | `:=` | `if (n := len(items)) > 0: ...` |

`divmod(17, 5)` returns `(3, 2)`; `pow(2, 5)` returns `32` (three-argument `pow(base, exp, mod)` can calculate modular powers); `sum`, `min`, `max` aggregate iterables.

Operator precedence matters: parentheses improve clarity. Exponentiation associates right-to-left; most arithmetic operators follow familiar precedence. `and` and `or` short-circuit and return one of their operands, not necessarily a Boolean.

```python
username = ""
shown = username or "Guest"  # 'Guest'; right side evaluated only if needed
```

`==` checks equality; `is` checks object identity. Membership on a dictionary tests keys. Operator overloading lets classes define behavior through methods such as `__add__` or `__eq__`.

**Interview short note 🎤:** Know `/` vs `//`, `==` vs `is`, bitwise vs logical operators, and short-circuit behavior. Use parentheses when precedence is not obvious.

## 8. Conditional statements

```python
score = 76
if score >= 90:
    grade = "A"
elif score >= 75:
    grade = "B"
else:
    grade = "C or below"
```

Use nested conditions only when they clarify the logic. Combine conditions with `and`, `or`, `not`. A conditional expression is useful for a short choice: `status = "pass" if score >= 50 else "fail"`. Avoid deeply nested ternaries.

**Guard clause:** return early when an invalid or special condition is detected.

```python
def divide(a, b):
    if b == 0:
        raise ValueError("b must not be zero")
    return a / b
```

### `match` / `case` (Python 3.10+)

```python
def describe(value):
    match value:
        case 0:
            return "zero"
        case [x, y]:
            return f"pair: {x}, {y}"
        case {"kind": kind, "value": v}:
            return f"{kind}: {v}"
        case _:
            return "other"
```

Pattern matching can match literals, sequences, mappings and class patterns; `_` is a wildcard. A `case ... if condition` adds a guard. It is not merely a replacement for every `if` statement.

Common errors: using `=` instead of `==`, incorrect indentation, checking conditions in the wrong order, confusing `and` with `or`, and comparing values of incompatible types.

**Interview short note 🎤:** Choose `if/elif` for ordinary Boolean conditions and `match` for structured shape/value matching. Explain truthiness and guard clauses.

## 9. Loops

`for` iterates over items; `while` repeats while a condition remains true.

```python
for i in range(1, 6):
    print(i)              # 1 through 5

n = 3
while n > 0:
    print(n)
    n -= 1
```

`range(start, stop, step)` excludes `stop`. A negative step counts backward. `break` exits the nearest loop; `continue` skips to the next iteration; `pass` does nothing. `for/else` and `while/else` execute `else` only when the loop ends without `break`.

```python
for item in [2, 4, 7]:
    if item % 2:
        print("odd found")
        break
else:
    print("no odd values")
```

Useful tools:

```python
for index, value in enumerate(["a", "b"], start=1):
    print(index, value)
for name, score in zip(["Ava", "Ben"], [90, 82]):
    print(name, score)
for value in reversed([1, 2, 3]):
    print(value)
iterator = iter([10, 20])
print(next(iterator))  # 10
```

Dictionaries: `for key in d`, `for value in d.values()`, `for key, value in d.items()`. Multidimensional lists usually need nested loops. Direct iteration is clearer when the index is unnecessary; use `enumerate()` when both are needed. Avoid modifying a collection while iterating over it; iterate over a copy or build a new collection.

**Complexity note:** one loop over `n` items is usually O(n); a nested full loop is often O(n²). Nested loops are not automatically O(n²) if the inner work is bounded or shrinks.

**Interview short note 🎤:** Know `range`, `enumerate`, `zip`, `break/continue`, and loop-`else`. Avoid infinite `while` loops by making the termination condition progress.

## 10. Strings

Strings are immutable Unicode sequences. Indexing starts at zero; negative indexes count from the end; slicing uses `[start:stop:step]` and excludes `stop`.

```python
s = "Python"
print(s[0], s[-1])       # P n
print(s[1:4])             # yth
print(s[::-1])            # nohtyP
print("ha" * 3)           # hahaha
print("Py" in s)          # True
```

Create strings with single/double quotes; triple quotes support multiline strings. Raw strings help with regular expressions and Windows-style paths. Unicode strings are `str`; bytes are a separate type.

### Common string methods

| Purpose | Methods | Example |
|---|---|---|
| Case | `capitalize`, `casefold`, `lower`, `upper`, `title`, `swapcase` | `"HELLO".lower()` |
| Search | `find`, `rfind`, `index`, `rindex`, `count` | `s.find("th")` |
| Check | `startswith`, `endswith`, `isalpha`, `isalnum`, `isascii`, `isdecimal`, `isdigit`, `isnumeric`, `isidentifier`, `islower`, `isupper`, `istitle`, `isspace`, `isprintable` | `"123".isdigit()` |
| Trim | `strip`, `lstrip`, `rstrip` | `" hi ".strip()` |
| Replace/map | `replace`, `maketrans`, `translate` | `"a-b".replace("-", " ")` |
| Split | `split`, `rsplit`, `splitlines`, `partition`, `rpartition` | `"a,b".split(",")` |
| Join/align | `join`, `center`, `ljust`, `rjust`, `zfill` | `", ".join(["a", "b"])` |
| Format | `format`, `format_map`, f-strings | `f"{3.14159:.2f}"` |
| Prefix/suffix | `removeprefix`, `removesuffix` | `"unhappy".removeprefix("un")` |
| Other | `expandtabs`, `encode` | `"a\tb".expandtabs(4)` |

`find()` returns `-1` if absent; `index()` raises `ValueError`. `split()` splits into a list; `partition()` returns a 3-item tuple. `join()` is called on the separator string. Most string methods return a new string; they do not mutate the original.

Other concepts: `len`, `ord`, `chr`, `ascii`, `repr`; `string` module constants; `re` for regex; Unicode normalization via `unicodedata.normalize()` when equivalent-looking Unicode sequences need a canonical form; tokenization divides text into meaningful units.

```python
text = "  Python,Java,Python  "
clean = text.strip()
languages = clean.split(",")
print(languages)
print(" | ".join(languages))
```

**Approaches:** use built-in methods for simple cleanup; regular expressions for patterns; a tokenizer/parser for language-like structured text. Avoid regex when a simple `split` is clearer.

**Interview short note 🎤:** Strings are immutable; slicing is end-exclusive; `find` vs `index`; `split` vs `partition`; and why `separator.join(items)` is the idiomatic way to combine many strings.

## 11. Lists

Lists are ordered, mutable sequences that can hold mixed types. They support indexing, slicing, nested lists and duplicates.

```python
numbers = [4, 1, 3]
numbers.append(8)
numbers.extend([9, 10])
numbers.insert(1, 2)
numbers.remove(3)       # removes first matching value
last = numbers.pop()    # removes and returns last item
numbers.sort()          # in-place; returns None
copy_of_numbers = numbers.copy()  # shallow copy
```

| Method | Meaning / detail |
|---|---|
| `append(x)` | Add one object as one item |
| `extend(iterable)` | Add each item from iterable |
| `insert(i, x)` | Insert before index `i` |
| `remove(x)` | Remove first matching value; `ValueError` if missing |
| `pop([i])` | Remove and return item; `IndexError` if invalid/empty |
| `clear()` | Remove all items |
| `index(x)` / `count(x)` | Find first index / count matches |
| `sort(key=None, reverse=False)` | Sort in place, stable; returns `None` |
| `reverse()` | Reverse in place |
| `copy()` | Shallow copy |

`sorted(items)` returns a new sorted list; `items.sort()` modifies the same list. `reversed(items)` returns an iterator. `any()` checks whether any element is truthy; `all()` checks whether all are truthy. Use `del`, slice assignment, unpacking, `enumerate`, `zip`, `min`, `max`, `sum`, `len` as needed.

### Comprehensions and nested lists

```python
squares = [n * n for n in range(1, 6)]
evens = [n for n in range(10) if n % 2 == 0]
matrix = [[1, 2], [3, 4]]
flat = [value for row in matrix for value in row]
```

Copy pitfalls:

```python
original = [[1], [2]]
shallow = original.copy()
shallow[0].append(99)
print(original)  # inner list shared
```

Use `copy.deepcopy()` if a recursive independent copy is required and the object graph supports it. Avoid `matrix = [[0] * 3] * 3` when you intend independent rows; use `[[0 for _ in range(3)] for _ in range(3)]`.

Sorting list of dictionaries: `students.sort(key=lambda s: s["marks"], reverse=True)`. Stack: `append`/`pop` at the end. For a queue, prefer `collections.deque` over removing from the start of a list.

**Performance:** list append is amortized O(1); searching is O(n); inserting/removing near the beginning is O(n); sorting is typically O(n log n).

**Interview short note 🎤:** `append` vs `extend`, `sort` vs `sorted`, shallow vs deep copy, list comprehension, and why `pop(0)` is inefficient for a queue.

## 12. Tuples, sets and dictionaries

### A. Tuples
Tuples are ordered, immutable sequences. A one-item tuple needs a comma: `(5,)`. Packing creates a tuple; unpacking assigns its values.

```python
point = (10, 20)
x, y = point
record = ("Mira", 91)
print(record.count(91), record.index("Mira"))
```

Tuples can be dictionary keys if every contained element is hashable. Use `collections.namedtuple()` for lightweight named fields, or `dataclasses` for many modern record-like classes. Functions can return multiple values using a tuple: `return min(values), max(values)`.

### B. Sets and frozensets
Sets store unique hashable elements. Use `set()` for an empty set; `{}` creates an empty dictionary.

```python
a = {1, 2, 3}
b = {3, 4, 5}
print(a | b)  # union
print(a & b)  # intersection
print(a - b)  # difference
print(a ^ b)  # symmetric difference
print(a.issubset(b), a.isdisjoint(b))
```

Methods include `add`, `update`, `remove` (raises if absent), `discard` (does not raise if absent), `pop` (removes an arbitrary element), `clear`, `copy`, `union`, `intersection`, `difference`, `symmetric_difference`, their `*_update` variants, `issubset`, `issuperset`, `isdisjoint`. Set comprehensions use `{expression for item in iterable}`. Sets are useful for deduplication and average-fast membership tests, but do not rely on positional order.

### C. Dictionaries
A dictionary maps hashable keys to values and preserves insertion order in modern Python.

```python
student = {"name": "Mira", "marks": 91}
print(student["name"])
print(student.get("age", "not supplied"))
student["age"] = 20
student.update({"marks": 95})
for key, value in student.items():
    print(key, value)
```

`d[key]` raises `KeyError` if missing; `get()` returns a default. `keys()`, `values()` and `items()` return dynamic views. Methods: `clear`, `copy`, `fromkeys`, `get`, `items`, `keys`, `values`, `pop`, `popitem`, `setdefault`, `update`. `popitem()` removes the last inserted pair in modern Python. Dictionary comprehensions: `{word: len(word) for word in words}`.

Merging: `{**left, **right}` works broadly; `left | right` and `left |= right` require Python 3.9+. Duplicate keys from the right-hand mapping override earlier values. Useful tools: `defaultdict` for automatic defaults, `Counter` for frequencies, `OrderedDict` for specialized ordering operations/compatibility, and `ChainMap` for layered lookups.

```python
from collections import Counter, defaultdict
print(Counter("banana"))
groups = defaultdict(list)
for name, team in [("Ava", "red"), ("Ben", "blue"), ("Kai", "red")]:
    groups[team].append(name)
```

Sort keys with `sorted(d)`; sort pairs by value with `sorted(d.items(), key=lambda pair: pair[1])`. Frequency analysis often uses `Counter`, though a regular dictionary works too.

**Interview short note 🎤:** A tuple is immutable, a set is unique-value oriented, and a dict is key/value oriented. Dict keys and set elements must be hashable. Explain `get` vs `[]`, `remove` vs `discard`, and average O(1) membership with expected caveats.

# Part 2 — Functions and Core Programming

## 13. Functions

Functions package reusable behavior. `def` defines a function; calling it executes the body. Parameters appear in the definition; arguments are values passed at the call site. A function without an explicit `return` returns `None`.

```python
def greet(name: str = "friend") -> str:
    """Build a greeting."""
    return f"Hello, {name}!"

print(greet())
print(greet("Asha"))
```

### Argument forms

```python
def report(name, /, level=1, *scores, city, **extra):
    return name, level, scores, city, extra

report("Ravi", 2, 80, 90, city="Rajkot", active=True)
```

- Positional arguments match by position; keyword arguments match by name.
- Default parameters are optional. Required parameters must be supplied.
- `*args` gathers extra positional arguments into a tuple; `**kwargs` gathers extra keyword arguments into a dict.
- `/` marks positional-only parameters; `*` can mark the boundary before keyword-only parameters.
- `f(*items)` unpacks a sequence; `f(**mapping)` unpacks a mapping.
- Parameter ordering rules matter: required positional parameters precede defaulted ones; keyword-only arguments follow `*`/`*args`.

Avoid mutable defaults:

```python
def add_item(item, items=None):
    if items is None:
        items = []
    items.append(item)
    return items
```

### Scope and behavior

LEGB means Local → Enclosing → Global → Built-in. `global` assigns to a module-level name; `nonlocal` assigns to a binding in an enclosing function. Local variables exist during a call; object lifetime depends on references and runtime management.

Functions are first-class objects: they can be stored, passed as arguments and returned. A higher-order function takes or returns a function. A pure function returns a result based only on its inputs and has no observable side effects. Closures retain references to enclosing variables.

```python
def multiplier(factor):
    def multiply(value):
        return factor * value
    return multiply

twice = multiplier(2)
print(twice(6))  # 12
```

### Lambda and functional tools

```python
numbers = [1, 2, 3, 4]
print(list(map(lambda x: x * 2, numbers)))
print(list(filter(lambda x: x % 2 == 0, numbers)))
from functools import reduce
print(reduce(lambda a, b: a + b, numbers, 0))
print(sorted([("A", 3), ("B", 1)], key=lambda row: row[1]))
```

A list comprehension is often clearer than `map`/`filter` for simple transformations. `any`/`all` short-circuit. `itertools` offers efficient iterator building blocks. `functools.partial()` pre-fills arguments; `cache`/`lru_cache` memoize calls; `wraps` preserves decorator metadata. Callable instances implement `__call__`.

### Recursion and nested functions
A recursive function calls itself and needs a base case. Nested functions help encapsulate helper logic; closures can capture state. See [Recursion](#15-recursion-and-problem-solving).

**Interview short note 🎤:** Know parameter vs argument, `return` vs `print`, `*args` vs `**kwargs`, LEGB, closure, lambda, higher-order function, and mutable-default pitfalls. Always state the base case for recursion.

## 14. Comprehensions and unpacking

Comprehensions build collections concisely; generator expressions produce values lazily.

```python
squares = [x*x for x in range(6)]
evens = [x for x in range(10) if x % 2 == 0]
labels = {x: "even" if x % 2 == 0 else "odd" for x in range(5)}
unique_lengths = {len(word) for word in ["cat", "dog", "python"]}
gen = (x*x for x in range(1_000_000))
```

Multiple loops are allowed: `[(x, y) for x in [1, 2] for y in [3, 4]]`. Conditions filter; a conditional expression chooses a value. Nested comprehensions should be used only when they remain readable.

```python
first, *middle, last = [10, 20, 30, 40]
left, right = right, left
settings = {**defaults, **overrides}
```

Sequence unpacking requires matching counts unless a starred target captures the remainder. Generator expressions generally use less memory than a list when values are consumed once, but may be less convenient for repeated access.

**Interview short note 🎤:** List comprehension creates a list immediately; generator expression yields values lazily. Use the clearest approach, not the shortest possible line.

## 15. Recursion and problem-solving

Recursion divides a problem into smaller versions of itself. Every correct recursive design needs a **base case** and progress toward that base case.

```python
def factorial(n):
    if n < 0:
        raise ValueError("n must be non-negative")
    if n <= 1:             # base case
        return 1
    return n * factorial(n - 1)
```

Other common patterns:

```python
def sum_digits(n):
    n = abs(n)
    if n < 10:
        return n
    return n % 10 + sum_digits(n // 10)

def reverse_text(s):
    if len(s) <= 1:
        return s
    return reverse_text(s[1:]) + s[0]

def is_palindrome(s):
    cleaned = "".join(ch.casefold() for ch in s if ch.isalnum())
    return cleaned == cleaned[::-1]
```

Fibonacci recursion without caching repeats work exponentially; iterative or memoized approaches are better for larger `n`.

```python
def fib(n):
    a, b = 0, 1
    result = []
    for _ in range(n):
        result.append(a)
        a, b = b, a + b
    return result
```

- **Direct recursion:** a function calls itself. **Indirect recursion:** A calls B, which eventually calls A.
- **Head/tail recursion:** conceptual classifications based on where the recursive call occurs; Python does not optimize tail recursion automatically.
- **Binary search:** on a sorted sequence, repeatedly halve the search interval; O(log n).
- **Tree traversal:** depth-first traversals are naturally recursive; iterative stack-based versions are alternatives.
- **Backtracking:** choose → explore → undo; used for permutations, combinations, Sudoku and path search.
- **Recursion depth:** deep calls may raise `RecursionError`; avoid increasing the limit as a first fix.
- **Memoization/dynamic programming:** cache repeated subproblems; use `functools.cache` for suitable pure functions.

**Approach selection:** use iteration for simple counting/accumulation and potentially deep input; recursion for naturally recursive structures; memoization when subproblems repeat; dynamic programming when state transitions can be tabulated.

**Interview short note 🎤:** State the base case, recursive step, complexity and stack-space cost. Python has no general tail-call optimization.

## 16. Object-Oriented Programming (OOP)

A class defines a type; an object is an instance. Attributes represent state; methods represent behavior. `self` refers to the current instance by convention.

```python
class Student:
    school = "Darshan University"  # class attribute

    def __init__(self, name, marks):
        self.name = name            # instance attributes
        self.marks = marks

    def passed(self):
        return self.marks >= 40

    @classmethod
    def from_text(cls, text):
        name, marks = text.split(",")
        return cls(name, int(marks))

    @staticmethod
    def passing_mark():
        return 40

s = Student("Asha", 85)
print(s.name, s.passed())
```

`__new__()` creates an instance; `__init__()` initializes it. Most classes need only `__init__`. `__dict__` often exposes instance attributes. `getattr`, `setattr`, `hasattr`, `delattr` perform dynamic attribute operations.

### Four pillars

1. **Encapsulation:** keep data and behavior together; use conventions/properties to control access. Python does not enforce private members exactly like some languages; `_name` signals internal use and `__name` triggers name mangling.
2. **Abstraction:** expose a useful interface while hiding implementation details, often with `abc`.
3. **Inheritance:** derive a class from another to reuse/extend behavior.
4. **Polymorphism:** the same operation works with different object types, often through overriding or duck typing.

### Inheritance and dispatch

Python supports single, multiple, multilevel, hierarchical and hybrid inheritance. `super()` follows the Method Resolution Order (MRO), which is important with multiple inheritance and the diamond problem. Inspect MRO with `SomeClass.mro()`.

```python
class Animal:
    def speak(self): return "sound"
class Dog(Animal):
    def speak(self): return "woof"  # overriding

print(Dog().speak())
```

Python does not support traditional signature-based method overloading in the same way as Java/C++; use default arguments, `*args`, dispatching, or `functools.singledispatch` where appropriate. **Duck typing:** if an object provides the operations required by code, its nominal class may not matter.

- **Composition vs inheritance:** composition (“has-a”) builds an object using other objects; inheritance (“is-a”) specializes a base type.
- **Association:** objects know/use each other. **Aggregation:** weak whole-part relationship. **Composition:** strong ownership/lifecycle relationship (conceptual design terms).
- **Mixin:** small class adding a reusable behavior, not usually intended as a standalone domain object.

### Dunder/special methods

| Need | Methods/examples |
|---|---|
| Representation | `__str__`, `__repr__` |
| Creation/lifecycle | `__new__`, `__init__`, `__del__` (avoid relying on `__del__` for cleanup) |
| Comparison | `__eq__`, `__ne__`, `__lt__`, `__le__`, `__gt__`, `__ge__` |
| Arithmetic | `__add__`, `__sub__`, `__mul__`, `__truediv__`, `__floordiv__`, `__mod__`, `__pow__`; reverse methods such as `__radd__`; in-place forms such as `__iadd__` |
| Container | `__len__`, `__getitem__`, `__setitem__`, `__delitem__`, `__contains__`, `__iter__` |
| Other behavior | `__call__`, `__hash__`, `__enter__`, `__exit__`, `__getattr__`, `__getattribute__`, `__setattr__`, `__format__`, `__bool__`, `__int__`, `__float__`, `__index__` |

Implement `__eq__` and `__hash__` consistently if instances are used as dictionary keys or set elements. `__getattribute__` runs for every attribute access and can easily recurse if implemented carelessly.

### Advanced OOP

- `@property` provides attribute-style access backed by a method; a setter can validate changes.
- Abstract base classes use `abc.ABC` and `@abstractmethod`; a class with unimplemented abstract methods cannot be instantiated.
- Protocols express structural interfaces for static type checkers.
- `dataclasses` generate common methods; `frozen=True` prevents normal field reassignment, but does not deep-freeze nested values.
- `__slots__` can restrict instance attributes and sometimes reduce memory, with trade-offs.
- Descriptors implement reusable attribute access behavior through `__get__`, `__set__`, `__delete__`.
- Metaclasses customize class creation; use them only when simpler patterns are insufficient.
- Class decorators transform classes. Dependency injection passes collaborators into objects rather than constructing every dependency internally.
- SOLID: Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, Dependency Inversion. Common patterns include Factory, Strategy, Adapter, Observer and Repository.

**Interview short note 🎤:** Know the four pillars, instance/class/static methods, overriding vs overloading, `super()`/MRO, composition vs inheritance, and when dataclasses/abstract classes are useful.

## 17. Exception handling

- **Syntax error:** code cannot be parsed.
- **Runtime exception:** failure during execution.
- **Logical error:** code runs but produces the wrong result.

```python
try:
    value = int(input("Number: "))
    answer = 100 / value
except ValueError:
    print("Enter a valid integer")
except ZeroDivisionError:
    print("Number must not be zero")
else:
    print(answer)             # runs if no exception occurred
finally:
    print("Finished")        # runs during normal/error flow
```

Raise errors with `raise ValueError("message")`. Re-raise the current exception with `raise`; chain a cause using `raise NewError(...) from exc`. Define custom exceptions by subclassing `Exception`.

```python
class InsufficientBalanceError(Exception):
    pass

def withdraw(balance, amount):
    if amount > balance:
        raise InsufficientBalanceError("Balance is too low")
    return balance - amount
```

`assert condition, message` is for internal assumptions/debugging, not input validation or security checks; optimized execution may disable assertions. Catch `Exception` when appropriate, not `BaseException`, which also includes system-exiting exceptions.

Common exceptions: `TypeError` (wrong operation/type), `ValueError` (right type, invalid value), `NameError`, `IndexError`, `KeyError`, `AttributeError`, `ImportError`/`ModuleNotFoundError`, `ZeroDivisionError`, `FileNotFoundError`, `PermissionError`, `RuntimeError`, `NotImplementedError`, `StopIteration`, `RecursionError`, `MemoryError`.

Best practices: catch specific errors, keep `try` blocks small, provide actionable messages, log exceptions with `logging.exception()` inside an exception handler, and use `with` for resource cleanup. Avoid bare `except:` because it can hide interrupts and unrelated failures.

**Interview short note 🎤:** Explain `try/except/else/finally`, `raise` vs `assert`, custom exceptions, and why catching all exceptions silently is dangerous.

## 18. File handling

Use `open(path, mode, encoding=...)` and prefer a context manager so the file closes even if an error occurs.

```python
from pathlib import Path
path = Path("notes.txt")
path.write_text("Hello\nPython", encoding="utf-8")
content = path.read_text(encoding="utf-8")
print(content)

with open(path, "r", encoding="utf-8") as file:
    print(file.read())
```

Modes: `r` read, `w` write/truncate, `a` append, `x` create exclusively, `b` binary, `t` text (default), `+` read/write. `read()` reads all or a requested size; `readline()` one line; `readlines()` list of lines; `write()` writes a string; `writelines()` writes strings without automatically adding separators. `tell()` reports a stream position; `seek()` changes it. UTF-8 is a sensible default for text files.

Handle `FileNotFoundError` and `PermissionError`; understand relative vs absolute paths and validate paths when users supply them. Buffering can improve I/O efficiency; `flush()` asks the stream to push buffered output onward.

### Common formats and filesystem modules

```python
import csv, json
with open("people.csv", newline="", encoding="utf-8") as f:
    rows = list(csv.DictReader(f))
with open("data.json", encoding="utf-8") as f:
    data = json.load(f)       # file object
text = json.dumps(data, indent=2)  # object -> JSON string
```

- CSV: `reader`, `writer`, `DictReader`, `DictWriter`.
- JSON: `load`/`dump` use file objects; `loads`/`dumps` use strings.
- Pickle: `dump`/`load` serialize Python objects; **never unpickle untrusted data**.
- XML: `xml.etree.ElementTree` for parsing/writing common XML.
- INI: `configparser`; TOML read-only standard parser `tomllib` is available in Python 3.11+.
- `tempfile` creates temporary files/directories; `pathlib.Path` offers object-oriented path handling; `os`/`os.path` offers operating-system operations; `shutil` copies/moves/deletes; `glob` finds matching paths; `zipfile` and `tarfile` handle archives.
- Directory traversal: `Path.iterdir()`, `Path.rglob("*.py")`, `os.walk()`.
- File metadata/permissions: `Path.stat()`, `os.chmod()` (platform-dependent semantics).
- Checksums: `hashlib.sha256(data).hexdigest()`; hashes are useful for integrity, not automatically encryption.
- Safe handling: avoid path traversal (`../`), validate destinations, use least privilege and avoid unsafe deserialization.

**Interview short note 🎤:** `with` guarantees cleanup; `w` truncates while `a` appends; `json.load` vs `json.loads`; text vs binary; and why pickle is unsafe for untrusted input.

## 19. Modules, packages and imports

A module is a Python file; a package groups modules. Importing lets code be reused.

```python
import math
from pathlib import Path as FilePath
import statistics as stats
print(math.sqrt(16), stats.mean([2, 4, 6]))
```

- `import module`, `from module import name`, and `as` aliases.
- Absolute imports start from the package root; relative imports use dots inside packages.
- `__name__` identifies the module name; `__file__` often identifies its file path; `__package__` identifies its package context.
- `__init__.py` marks a regular package and may initialize it; namespace packages can exist without it.
- `sys.path` controls import search locations; `sys.modules` caches loaded modules; `importlib` provides programmatic import tools.
- Circular imports occur when modules depend on each other during initialization; redesign dependencies or move imports to a suitable location when justified.
- `__all__` lists names exported by `from module import *`; avoid star imports in application code.

Example structure:

```text
project/
  app.py
  helpers.py
  mypackage/
    __init__.py
    validation.py
```

Use the standard library first when it meets the need; use third-party packages for extra functionality. Avoid naming your file `json.py`, `random.py` or `typing.py`, because it may shadow the standard module. Manage dependencies with `venv`, pip, pinned `requirements.txt`, and modern `pyproject.toml` metadata. Poetry and uv can manage environments/dependencies; package publishing requires project metadata and a build/upload workflow.

**Interview short note 🎤:** Module vs package, absolute vs relative imports, `__main__`, `sys.path`, import caching and circular imports are frequent interview topics.

## 20. Iterators and generators

An **iterable** can produce an iterator; an **iterator** remembers progress and implements `__iter__()` and `__next__()`. `next()` raises `StopIteration` when exhausted.

```python
items = [10, 20]
it = iter(items)
print(next(it))  # 10
print(next(it))  # 20
```

A generator function uses `yield`, pausing its state and resuming on the next request.

```python
def count_up_to(limit):
    n = 1
    while n <= limit:
        yield n
        n += 1

for number in count_up_to(3):
    print(number)
```

`yield from iterable` delegates iteration. Generator methods `send`, `throw` and `close` support advanced coroutine-like control; most beginners mainly need `yield`. Generators are lazy and memory-efficient for large streams, but are usually single-pass.

```python
squares = (n*n for n in range(1_000_000))
```

`itertools`: `count`, `cycle`, `repeat`; `chain`, `islice`, `product`, `permutations`, `combinations`, `groupby`, `accumulate`, `pairwise`, and version-dependent `batched`. `groupby` groups **consecutive** equal keys, so sort first if all equal keys should be grouped together. `functools.reduce()` folds an iterable into one value, though `sum()` is clearer for sums.

**Interview short note 🎤:** Iterable vs iterator vs generator; `return` vs `yield`; lazy evaluation; and why a generator often uses less memory than building a full list.

# Part 3 — Intermediate Python and Standard Library

## 21. Decorators

A decorator takes a function/class and returns a replacement or enhanced object. The `@decorator` syntax is shorthand for reassignment.

```python
from functools import wraps

def log_call(func):
    @wraps(func)
    def wrapper(*args, **kwargs):
        print("Calling", func.__name__)
        return func(*args, **kwargs)
    return wrapper

@log_call
def add(a, b):
    return a + b

print(add(2, 3))
```

`wraps()` preserves metadata such as the original name/docstring. A decorator with parameters usually returns a decorator factory. Multiple decorators are applied from the closest-to-function outward. Decorators can implement timing, logging, authorization, retry and parameter validation, but should preserve exceptions and avoid hiding errors.

`@property`, `@classmethod` and `@staticmethod` are built-in descriptor/decorator patterns. `functools.cache` and `lru_cache` memoize hashable call arguments; use them only when caching is semantically safe. Class decorators transform a class after its definition.

**Interview short note 🎤:** Explain functions as first-class objects, closures, wrapper functions, `*args/**kwargs`, `functools.wraps`, and decorator order.

## 22. Built-in function reference

This chapter groups the major built-ins from the roadmap. Learn the signature and return type for the functions you use regularly; use `help(name)` and official documentation for edge cases.

| Category | Functions / objects | Typical use |
|---|---|---|
| Type/reflection | `type`, `isinstance`, `issubclass`, `id`, `callable`, `object`, `vars`, `dir`, `globals`, `locals` | Inspect types, objects and namespaces |
| Conversion | `str`, `repr`, `ascii`, `bool`, `int`, `float`, `complex`, `bytes`, `bytearray`, `memoryview`, `list`, `tuple`, `set`, `frozenset`, `dict` | Convert/create values |
| Attributes | `getattr`, `setattr`, `hasattr`, `delattr` | Dynamic attribute access |
| Numeric | `abs`, `round`, `pow`, `divmod`, `sum`, `min`, `max` | Arithmetic and aggregation |
| Iteration | `len`, `range`, `enumerate`, `zip`, `map`, `filter`, `iter`, `next`, `reversed`, `sorted`, `any`, `all`, `slice` | Process iterables |
| Characters/format | `ord`, `chr`, `format`, `bin`, `oct`, `hex` | Convert character codes and formatting |
| I/O/debug | `print`, `input`, `open`, `help`, `breakpoint` | Input/output and debugging |
| Class helpers | `classmethod`, `staticmethod`, `property`, `super` | OOP behavior |
| Compilation/execution | `compile`, `eval`, `exec`, `__import__` | Dynamic execution/import; use with great care |
| Other | `hash`, `aiter`, `anext`, `NotImplemented`, `Ellipsis`, `__debug__` | Hashing, async iteration, protocol/constants |

Examples:

```python
print(any([0, "", 5]))       # True
print(all([1, True, "x"]))   # True
print(list(enumerate(["a", "b"], start=1)))
print(sorted([3, 1, 2]))
print(divmod(17, 5))
```

`math` provides `sqrt`, `ceil`, `floor`, `trunc`, `factorial`, `gcd`, `lcm`, `prod`, `comb`, `perm`, `isqrt`, logs, exponentials, trigonometry and finite/inf/NaN checks. `statistics` includes mean, median, mode/multimode, standard deviation, variance, quantiles, correlation and linear regression (availability varies by Python version). `random` includes `random`, `randint`, `randrange`, `choice`, `choices`, `sample`, `shuffle`, `uniform`, `seed`, state functions and normal-distribution functions. Use `secrets`, not `random`, for security-sensitive tokens.

`decimal.Decimal`, `localcontext`, `quantize` help decimal arithmetic; `fractions.Fraction` and `limit_denominator` represent rational values.

**Security warning ⚠️:** `eval()` and `exec()` can execute arbitrary code. Never pass untrusted input to them. Avoid dynamic import for ordinary application flow.

**Interview short note 🎤:** Learn `map` vs comprehension, `any` vs `all`, `sorted` vs `.sort`, `isinstance` vs `type`, and why `eval`/`exec` are dangerous.

## 23. Essential standard library

The standard library is included with Python and often removes the need for third-party dependencies.

| Area | Modules | Use cases |
|---|---|---|
| System/runtime | `sys`, `os`, `platform`, `site`, `sysconfig`, `atexit`, `warnings`, `traceback`, `inspect`, `gc` | Runtime info, OS integration, inspection, cleanup |
| Dates/time | `datetime`, `time`, `calendar`, `zoneinfo` | Dates, durations, time zones |
| Collections/data structures | `collections`, `array`, `heapq`, `bisect`, `queue`, `weakref` | Counters, deques, heaps, sorted search, queues, weak references |
| Functional | `itertools`, `functools`, `operator` | Iterator pipelines, caching, functional helpers |
| Files/serialization | `pathlib`, `shutil`, `glob`, `fnmatch`, `tempfile`, `fileinput`, `pickle`, `json`, `csv`, `configparser`, `tomllib`, `shelve`, `sqlite3` | Files, formats, local database |
| Text/parsing | `re`, `string`, `textwrap`, `unicodedata`, `difflib`, `codecs`, `html`, `html.parser`, `xml.etree.ElementTree`, `pprint` | Regex, Unicode, text and markup |
| Networking | `socket`, `ssl`, `urllib`, `http`, `email`, `smtplib`, `imaplib`, `ftplib`, `ipaddress`, `xmlrpc` | Network protocols and communication |
| Concurrency/processes | `threading`, `multiprocessing`, `concurrent.futures`, `subprocess`, `asyncio`, `signal`, `sched` | Threads, processes, async tasks, commands |
| Security/hashing | `hashlib`, `hmac`, `secrets`, `ssl`, `getpass`, `uuid` | Digests, secure tokens, secrets, identifiers |
| Development/testing | `logging`, `pdb`, `timeit`, `doctest`, `unittest`, `cProfile`, `pstats`, `tracemalloc`, `faulthandler` | Logs, debugging, tests, profiling |

Examples:

```python
from collections import Counter, deque
from pathlib import Path
from datetime import datetime, timezone

print(Counter("mississippi"))
queue = deque(["first", "second"])
print(queue.popleft())
print(Path(".").resolve())
print(datetime.now(timezone.utc))
```

Use `logging` instead of scattered debug prints in deployed applications. Use `timeit` for small benchmarks and profilers (`cProfile`, `tracemalloc`) to find actual bottlenecks before optimizing. Module availability and exact APIs vary with Python version; `tomllib` is in the standard library from Python 3.11.

**Interview short note 🎤:** Know `collections`, `itertools`, `functools`, `pathlib`, `json`, `re`, `datetime`, `logging`, `unittest`, `sqlite3`, `threading`, `multiprocessing` and `asyncio` at a use-case level.

## 24. Regular expressions (Regex)

Regex describes text patterns. Use raw strings such as `r"\d+"` so Python string escaping does not interfere with regex escaping.

| Pattern | Meaning |
|---|---|
| `\d` / `\D` | Digit / non-digit |
| `\w` / `\W` | Word character / non-word character |
| `\s` / `\S` | Whitespace / non-whitespace |
| `^`, `$`, `\A`, `\Z` | Anchors (line/string semantics differ by flags and API) |
| `*`, `+`, `?`, `{m,n}` | Repetition quantifiers |
| `.` | Any character except newline by default |
| `[A-Z]`, `[^0-9]` | Character set/range, negated set |
| `a|b` | Alternation |
| `(abc)` / `(?:abc)` | Capturing / non-capturing group |
| `(?P<name>...)` | Named capture group |
| `(?=...)`, `(?!...)` | Positive/negative lookahead |

```python
import re
text = "Order IDs: AB-123, CD-456"
print(re.findall(r"[A-Z]{2}-\d{3}", text))
print(re.sub(r"\d", "X", "Room 204"))
match = re.fullmatch(r"(?P<area>\d{3})-(?P<line>\d{4})", "555-0123")
if match:
    print(match.groupdict())
```

- `match()` checks from the start; `fullmatch()` requires the whole string; `search()` finds a match anywhere.
- `findall()` returns matched values; `finditer()` returns match objects.
- `sub()` replaces; `subn()` also returns replacement count; `split()` splits on a pattern; `escape()` quotes special characters.
- `compile()` reuses a pattern. Flags include `IGNORECASE`, `MULTILINE`, `DOTALL`, `VERBOSE`.
- Greedy quantifiers take as much as possible; adding `?` often makes them non-greedy.

Regex can help validate basic formats, extract text and tokenize. A regex alone is not a full email/URL/password security validator. Avoid patterns with catastrophic backtracking on untrusted long input (ReDoS). For structured data, use a proper parser.

**Interview short note 🎤:** Know `match` vs `search` vs `fullmatch`, `findall` vs `finditer`, greedy vs lazy, groups, anchors and raw strings.

## 25. Date and time

`datetime` provides `date`, `time`, `datetime`, `timedelta` and time-zone-aware values.

```python
from datetime import datetime, date, timedelta, timezone
from zoneinfo import ZoneInfo

now_utc = datetime.now(timezone.utc)
today = date.today()
next_week = today + timedelta(days=7)
print(now_utc.isoformat())
print(now_utc.strftime("%Y-%m-%d %H:%M"))
parsed = datetime.strptime("14-10-2026", "%d-%m-%Y")
india_time = now_utc.astimezone(ZoneInfo("Asia/Kolkata"))
```

- `strftime()` formats; `strptime()` parses text using a format.
- `isoformat()` and `fromisoformat()` support ISO-style representations.
- A timestamp represents a point relative to an epoch; Unix time commonly counts seconds from 1970-01-01 UTC.
- Prefer aware datetimes for instants and APIs; naive datetimes have no explicit time zone.
- UTC avoids many ambiguity issues. `zoneinfo.ZoneInfo` handles time-zone rules where data is available; daylight-saving transitions can make local times ambiguous or nonexistent.
- `time.sleep(seconds)` pauses execution; `time.perf_counter()` is useful for measuring elapsed duration. `calendar` can render calendars.
- For recurring schedules, store intended local zone and recurrence rules rather than assuming every day is exactly 24 hours.

**Interview short note 🎤:** Explain `date` vs `datetime`, `timedelta`, `strftime` vs `strptime`, naive vs aware datetime, UTC and time-zone conversion.

## 26. Command-line programs and configuration

`sys.argv` exposes command-line arguments as strings. For real tools, `argparse` gives help, validation, flags and subcommands.

```python
import argparse
parser = argparse.ArgumentParser(description="Calculate a square")
parser.add_argument("number", type=float, help="number to square")
parser.add_argument("--verbose", action="store_true")
args = parser.parse_args()
result = args.number ** 2
if args.verbose:
    print("Calculating square")
print(result)
```

Configuration options include environment variables (`os.environ`), JSON/TOML/INI files, and `.env` files through a third-party loader. Never commit secrets to source control. Use `sys.exit(code)` for process exit status; `0` usually means success, non-zero failure. Standard output is for normal results; standard error is for diagnostics. `logging` should be configured for useful level/format/output. Interactive tools can use `input`; progress bars commonly use third-party packages such as `tqdm`. Scheduling can use OS schedulers or application task systems.

**Interview short note 🎤:** `sys.argv` vs `argparse`; environment variables for deployment configuration; stdout vs stderr; and why secrets should not be hard-coded.

## 27. Type hints and static typing

Type hints make code easier to understand and allow tools such as mypy/Pyright to find likely errors. Python generally does not enforce annotations at runtime.

```python
from collections.abc import Iterable, Iterator, Callable

def average(values: Iterable[float]) -> float:
    numbers = list(values)
    if not numbers:
        raise ValueError("values cannot be empty")
    return sum(numbers) / len(numbers)

UserId = int
scores: list[int] = [80, 90]
lookup: dict[str, int] = {"Asha": 90}
maybe_name: str | None = None
```

Key types/concepts:

- `int`, `str`, `float`, `bool`; generic containers such as `list[int]`, `dict[str, int]`, `set[str]`, `frozenset[str]`, `tuple[str, int]`.
- `Optional[T]` means `T | None`; `Union[A, B]` means either; modern Python supports `A | B`.
- `Any` opts out of many static checks; `Never`/`NoReturn` describe code paths that do not return normally.
- `Literal` restricts accepted values; `TypedDict` describes dictionary keys/values; `TypeAlias` names a type expression.
- `Callable` describes callable signatures; `Protocol` describes structural behavior; `TypeVar`, `Generic`, `ParamSpec` support generic functions/classes and callable parameter typing.
- Covariance/contravariance describe how subtype relationships behave inside generic types; usually learn the intuition before advanced details.
- `Annotated` attaches metadata; `TypeGuard`/`TypeIs` help narrow types; `Self` describes the current class type; forward references refer to types defined later.
- Static checking is different from runtime validation. Validate untrusted JSON/API input explicitly, e.g. with parsing/validation code or a validation library.
- Type hints are useful for API DTOs and maintainable service boundaries.

**Interview short note 🎤:** Type hints aid tools/readability but do not automatically validate runtime data. Explain `Any` vs `object`, `Optional`, `Protocol`, and static checking vs runtime validation.

## 28. Memory management and internals

Python variables are names referring to objects. `==` checks equality; `is` checks identity. Mutable objects can change without rebinding their names; immutable objects cannot be modified in place.

- **Reference counting:** CPython tracks references and can reclaim many objects when the count reaches zero.
- **Garbage collection:** the `gc` module helps detect/reclaim unreachable reference cycles that reference counting alone cannot reclaim.
- **Weak references:** `weakref` lets code refer to supported objects without keeping them alive solely because of that reference.
- **Copying:** `copy.copy()` is shallow; `copy.deepcopy()` recursively copies many nested objects but has limits for special resources and custom classes.
- **Profiling:** `tracemalloc` tracks Python memory allocations; profile before optimizing.
- **Interning:** some implementations reuse certain immutable objects/strings as an optimization; do not rely on it for correctness.
- **CPython bytecode:** inspect with `dis`; frames/code objects/function objects represent execution structures.
- **GIL:** in conventional CPython builds, the Global Interpreter Lock limits simultaneous execution of Python bytecode by multiple threads in one interpreter. It does not mean threads are useless: they help I/O-bound work. CPU-bound work may benefit from multiprocessing or native code. Python versions/builds can differ, including optional free-threaded builds.
- **Implementations:** CPython is the reference implementation; PyPy uses a tracing JIT and can be faster for some workloads; others target different environments.

```python
import copy, dis, tracemalloc
original = [[1], [2]]
shallow = copy.copy(original)
deep = copy.deepcopy(original)

def add(a, b): return a + b
dis.dis(add)

tracemalloc.start()
data = [x*x for x in range(10_000)]
current, peak = tracemalloc.get_traced_memory()
print(current, peak)
tracemalloc.stop()
```

**Interview short note 🎤:** Names vs objects, reference counting vs cyclic GC, shallow vs deep copy, GIL implications, and how to profile rather than guess.

# 🎤 Interview Revision Sheet

## High-value comparisons

| Question | Short answer |
|---|---|
| List vs tuple | List is mutable; tuple is immutable and can be used as a key only if all members are hashable. |
| Set vs dict | Set stores unique values; dict maps unique hashable keys to values. |
| `==` vs `is` | Equality vs identity. Use `is None` for `None`. |
| `append` vs `extend` | Add one item vs add every item from an iterable. |
| `sort()` vs `sorted()` | In-place mutation returning `None` vs new sorted list. |
| `remove` vs `pop` | Remove by value vs remove-and-return by index (last by default). |
| `find` vs `index` | `find` returns `-1` if absent; `index` raises `ValueError`. |
| `break` vs `continue` vs `pass` | Exit loop; skip current iteration; do nothing. |
| `return` vs `yield` | Return finishes a function; yield pauses/resumes a generator. |
| Iterable vs iterator | Iterable can produce an iterator; iterator tracks progress and supplies next values. |
| `*args` vs `**kwargs` | Extra positional tuple vs extra keyword dictionary. |
| `@classmethod` vs `@staticmethod` | Class method receives `cls`; static method receives neither `self` nor `cls` automatically. |
| `__init__` vs `__new__` | Initialize an already-created instance vs create the instance. |
| `json.load` vs `json.loads` | Read JSON from file-like object vs parse JSON string. |
| `w` vs `a` file mode | Write/truncate vs append. |
| `match` vs `search` vs `fullmatch` | Start of string vs anywhere vs entire string. |
| Thread vs process | Threads share a process's memory; processes have separate address spaces and higher isolation/overhead. |
| Async vs threads | Async cooperatively schedules awaitable I/O; threads can run blocking I/O concurrently. |
| Type hints vs validation | Hints help static tools; runtime input still needs validation. |
| Shallow vs deep copy | Shallow copies outer container; deep copy recursively copies nested objects where supported. |

## Complexity basics

- List index: O(1); list search: O(n); insert/delete at front: O(n).
- Dict/set lookup: average O(1), worst-case can be worse.
- Sorting: typically O(n log n).
- Binary search on sorted data: O(log n).
- One full loop: O(n); nested full loops: often O(n²).
- Generator: often lowers peak memory by yielding one value at a time.

## How to answer a coding interview question

1. Restate the problem and clarify constraints.
2. Describe a straightforward approach first.
3. Improve it if needed (hash map, set, two pointers, sorting, binary search, stack/queue, recursion/DP).
4. Explain time and space complexity.
5. Test normal, empty, duplicate, boundary and invalid inputs.
6. Write readable code and state assumptions.

## Common problem-solving approaches

- **Hash map/set:** frequencies, duplicates, fast membership.
- **Two pointers:** sorted arrays, pair sums, palindrome checks.
- **Sliding window:** contiguous subarray/substring constraints.
- **Stack:** nested brackets, undo, depth-first traversal.
- **Queue/deque:** breadth-first traversal, task scheduling.
- **Binary search:** monotonic condition or sorted collection.
- **Recursion/backtracking:** trees, combinations, permutations, constraint search.
- **Dynamic programming:** overlapping subproblems and optimal substructure.
- **Built-ins:** use `Counter`, `sum`, `sorted`, `any`, etc. when they make the intent clearer.

---

# 🧪 Practice Problems

Try these before looking up solutions. They cover a range of roadmap topics.

### Beginner
1. Read two numbers and print sum, difference, product, quotient and remainder.
2. Check whether an integer is positive, negative or zero.
3. Find the largest of three numbers using `if/elif` and then using `max()`.
4. Print a multiplication table with a loop.
5. Count vowels in a string using a loop and using a comprehension.
6. Remove duplicates from a list while preserving original order.
7. Build a word-frequency dictionary from a sentence.
8. Find the second-largest unique number in a list.

### Intermediate
9. Write a palindrome checker that ignores punctuation and case.
10. Group a list of names by their first letter using `defaultdict`.
11. Read a CSV and calculate the average of a numeric column.
12. Safely parse JSON and handle malformed data.
13. Create a `BankAccount` class with deposit/withdraw validation and a custom exception.
14. Write a generator that yields Fibonacci numbers up to a limit.
15. Write a decorator that measures elapsed time and preserves metadata.
16. Validate a simple identifier with `re.fullmatch`.

### Advanced / interview
17. Implement binary search iteratively and recursively; compare complexity.
18. Solve Two Sum with a nested loop, then a dictionary; compare time/space.
19. Flatten a nested list one level and then recursively.
20. Implement a simple LRU cache or explain why `functools.lru_cache` may be better.
21. Process a large file line-by-line rather than reading the whole file.
22. Compare threads, processes and asyncio for three example workloads.
23. Profile a slow function and explain how you found the bottleneck.
24. Design a small package with tests, type hints, logging and a `pyproject.toml`.

---

# 🔗 Official learning links

- [Python Tutorial](https://docs.python.org/3/tutorial/)
- [Python Library Reference](https://docs.python.org/3/library/)
- [Built-in Functions](https://docs.python.org/3/library/functions.html)
- [Built-in Types](https://docs.python.org/3/library/stdtypes.html)
- [Python Data Model / Special Methods](https://docs.python.org/3/reference/datamodel.html)
- [Regular Expressions HOWTO](https://docs.python.org/3/howto/regex.html)
- [Typing Documentation](https://docs.python.org/3/library/typing.html)
- [Virtual Environments and Packages](https://docs.python.org/3/tutorial/venv.html)
- [PEP 8 Style Guide](https://peps.python.org/pep-0008/)

> **Version note:** Python evolves. Features such as `match/case`, `dict | dict`, `tomllib`, `TypeIs`, and newer `itertools` utilities depend on the Python version. Check the official docs for the version installed on your machine.

**Final reminder 🐍:** Interview success comes from understanding the trade-offs, writing small working examples, and explaining why you chose an approach—not memorizing every method name in isolation. 🚀
