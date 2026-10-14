<a id="top"></a>

# 🐍 Python Complete Mastery Guide — Beginner → Interview Ready 🚀

> 😎 *"I don't always read 28 chapters of Python, but when I do, I get the job."*

Every chapter has: 📖 **Full explanation** · 💻 **Examples** · 🧭 **Different approaches** · 🎤 **Technical interview short note** · ⚠️ **Pitfalls**.

---

## 🧭 Master Navigation (click to jump!)

| # | Chapter | # | Chapter |
|---|---------|---|---------|
| 1 | [🐣 Introduction](#ch1) | 15 | [🔁 Recursion](#ch15) |
| 2 | [✍️ Syntax & Tokens](#ch2) | 16 | [🏛️ OOP](#ch16) |
| 3 | [📦 Variables & Memory](#ch3) | 17 | [💥 Exceptions](#ch17) |
| 4 | [🎙️ Input & Output](#ch4) | 18 | [📂 File Handling](#ch18) |
| 5 | [🧬 Data Types](#ch5) | 19 | [📚 Modules & Packages](#ch19) |
| 6 | [🔄 Type Conversion](#ch6) | 20 | [🚰 Iterators & Generators](#ch20) |
| 7 | [➕ Operators](#ch7) | 21 | [🎀 Decorators](#ch21) |
| 8 | [🚦 Conditionals](#ch8) | 22 | [🧰 Built-in Functions](#ch22) |
| 9 | [🎡 Loops](#ch9) | 23 | [🏪 Standard Library](#ch23) |
| 10 | [🧵 Strings](#ch10) | 24 | [🕵️ Regex](#ch24) |
| 11 | [📜 Lists](#ch11) | 25 | [⏰ Date & Time](#ch25) |
| 12 | [🧩 Tuples, Sets, Dicts](#ch12) | 26 | [⌨️ CLI & Config](#ch26) |
| 13 | [🛠️ Functions](#ch13) | 27 | [🏷️ Type Hints](#ch27) |
| 14 | [🪄 Comprehensions & Unpacking](#ch14) | 28 | [🧠 Memory & Internals](#ch28) |

🏁 Bonus: [🔥 Top 40 Interview Rapid-Fire](#rapid) · [🧾 Cheat Sheet](#cheat)

**Quick jump by part:** [Part 1 Fundamentals](#ch1) · [Part 2 Core Programming](#ch13) · [Part 3 Intermediate & Stdlib](#ch21)

---

# 🟢 PART 1 — Python Fundamentals (Beginner)

---

<a id="ch1"></a>
## 🐣 1. Introduction to Python  [⬆️ top](#top)

> 🎤 **Interview short note:** Python is a high-level, interpreted, dynamically typed, garbage-collected, multi-paradigm language. Reference implementation = **CPython**, which compiles source → **bytecode** → runs on the **PVM**. Always say "compiled to bytecode, then interpreted" — not just "interpreted".

### 📖 What is Python?
Created by **Guido van Rossum**, first released **1991**. Philosophy: readability (`import this` → *Zen of Python*). Supports procedural, OOP and functional styles.

### 🕰️ History
- 1991: Python 0.9 · 2000: Python 2.0 (list comprehensions, GC) · 2008: Python 3.0 (not backward compatible) · **Jan 2020: Python 2 end of life** · 3.x adds `match`, type hints, `asyncio`, faster interpreter, free-threaded builds.

### ✨ Features
Easy syntax · interpreted · dynamically typed · huge standard library ("batteries included") · cross-platform · extensible (C/C++) · automatic memory management · large ecosystem.

### ⚖️ Advantages / Disadvantages
| 👍 Advantages | 👎 Disadvantages |
|---|---|
| Readable, fast to develop | Slower than C/C++/Java for CPU-bound work |
| Massive libraries (NumPy, Django…) | GIL limits CPU-bound threading (CPython) |
| Great community | Higher memory use |
| Great for glue code & prototypes | Weak on mobile / low-level systems |

### 🌍 Applications
Web (Django, Flask, FastAPI) · Data science / AI (NumPy, pandas, PyTorch) · Automation & scripting · DevOps · Testing · Cybersecurity · Game dev (Pygame) · Embedded (MicroPython).

### 🥊 Python vs Java vs C vs C++
| Feature | Python | Java | C | C++ |
|---|---|---|---|---|
| Typing | Dynamic | Static | Static | Static |
| Execution | Bytecode + PVM | Bytecode + JVM (JIT) | Native compile | Native compile |
| Memory | Auto (GC) | Auto (GC) | Manual | Manual/RAII |
| Speed | Slowest | Fast | Fastest | Fastest |
| Verbosity | Low | High | Medium | High |
| Braces/Indent | Indentation | Braces | Braces | Braces |

### 🆚 Python 2 vs Python 3
| | Python 2 | Python 3 |
|---|---|---|
| print | statement `print "x"` | function `print("x")` |
| `/` on ints | floor (`5/2=2`) | true division (`2.5`) |
| Strings | `str` = bytes, `unicode` | `str` = Unicode, `bytes` separate |
| `range` | list (`xrange` lazy) | lazy range |
| Support | ❌ EOL 2020 | ✅ |

### ⚙️ Execution process
```
 source.py ──compile──▶ bytecode (.pyc in __pycache__) ──▶ PVM executes ──▶ output
```
```python
import dis
def add(a, b): return a + b
dis.dis(add)      # shows bytecode instructions
```
**Compiled vs interpreted:** C is compiled ahead-of-time to machine code; Python compiles to bytecode (implicitly) and the PVM interprets it. Python is *not purely* either.

### 🔧 Installing & tools
- **Windows:** python.org installer (✅ tick *Add to PATH*) or `winget install Python.Python.3`.
- **Linux:** `sudo apt install python3 python3-pip python3-venv`.
- **macOS:** `brew install python`.
- **Editors:** VS Code (+Python extension), PyCharm (full IDE), IDLE (bundled, basic).
- **Run:** `python file.py` · interactive: `python` (REPL, good for quick tests) vs script mode (saved `.py`, reusable).
- **Notebooks:** Jupyter (`pip install notebook`), Google Colab (free cloud, no setup).
- **Virtual env:** isolates dependencies per project.
```bash
python --version            # or python3 --version
python -m venv .venv
source .venv/bin/activate   # Windows: .venv\Scripts\activate
pip install requests
pip list && pip freeze > requirements.txt
```

### 🧭 Approaches to run code
1. REPL (experiments) 2. Script `python app.py` 3. Module `python -m package.module` 4. Notebook (data exploration) 5. IDE debugger.

### ⚠️ Pitfalls
Forgetting PATH · mixing global/venv `pip` · using `python` vs `python3` on Linux.

---

<a id="ch2"></a>
## ✍️ 2. Python Syntax, Tokens and Basic Structure  [⬆️ top](#top)

> 🎤 **Interview short note:** Python uses **indentation** (not braces) to define blocks. Tokens = keywords, identifiers, literals, operators, delimiters. Identifiers are **case-sensitive**. Use 4 spaces (PEP 8). Mixing tabs/spaces → `TabError`.

### 📖 Concepts
- **Statement**: an instruction (`x = 5`). **Expression**: evaluates to a value (`x + 1`).
- **Indentation**: block structure; consistent within a block.
- **Comments**: `# single`; no true multiline comment — use consecutive `#` or (not recommended) a bare triple-quoted string.
- **Docstring**: first string in module/class/function; accessible via `__doc__` and `help()`.
- **Tokens**: keywords (`if`, `for`), identifiers (names), literals (`10`, `"hi"`), operators (`+`), delimiters (`() [] {} , : .`).
- **Identifier rules**: letters/digits/underscore, can't start with digit, not a keyword.
- **Keywords**: `import keyword; keyword.kwlist`. **Soft keywords**: `match`, `case`, `_`, `type` (act as keywords only in context). "Reserved words" = keywords.
- **Escape sequences**: `\n` newline, `\t` tab, `\\` backslash, `\'` `\"` quotes, `\r` carriage return, `\b` backspace.
- **Line continuation**: backslash `\` or implicit inside `()[]{}`.
- **Semicolons**: allowed to put multiple statements on a line, discouraged.
- **`pass`**: placeholder no-op. **`...` (Ellipsis)**: placeholder object, also used in slicing/type hints.

### 💻 Example
```python
"""Module docstring: demo of syntax"""
import keyword

def greet(name):
    """Return a greeting."""        # docstring
    return f"Hello, {name}!"

total = 1 + 2 + \
        3                            # explicit continuation
items = [1, 2,
         3]                          # implicit continuation
a = 1; b = 2                         # semicolon (avoid)

def todo(): ...                      # Ellipsis placeholder
class Empty: pass                    # pass placeholder

print("Tab:\tX\nNew line\\ backslash \"quote\"")
print(keyword.kwlist[:5], greet.__doc__)

if __name__ == "__main__":           # runs only when executed directly
    print(greet("Python"))
```
**Why `if __name__ == "__main__"`?** When imported, `__name__` is the module name, so the block is skipped; when run directly it is `"__main__"`.

### 🧭 Approaches (multi-line strings/comments)
```python
# approach 1: many # lines
# approach 2: triple-quoted string (really a string expr; fine for docstrings)
'''not a comment technically'''
```

### ⚠️ Pitfalls
`IndentationError` · naming a variable `list`/`str` (shadows builtins) · `=` vs `==`.

---

<a id="ch3"></a>
## 📦 3. Variables, Constants and Memory Basics  [⬆️ top](#top)

> 🎤 **Interview short note:** Python variables are **names (references) bound to objects**, not boxes holding values. Every object has **identity** (`id`), **type**, **value**. `is` compares identity, `==` compares value. Mutable: list/dict/set. Immutable: int/str/tuple/frozenset/bytes.

### 📖 Concepts & 💻 Examples
```python
x = 10                      # assignment
a = b = c = 0               # same value to many names
x, y, z = 1, 2.5, "hi"      # multiple assignment (tuple unpacking)
first, *rest = [1, 2, 3, 4] # extended unpacking
x, y = y, x                 # swap (no temp!)
age: int = 25               # type annotation (not enforced at runtime)
MAX_USERS = 100             # constant BY CONVENTION (UPPER_CASE)

print(id(x), type(x), x is y)
del x                       # removes the name, not necessarily the object
```
**Dynamic typing:** `v = 1; v = "now a string"` is legal.
**Naming:** `snake_case` (variables/functions), `PascalCase` (classes), `UPPER_CASE` (constants).

### 🔍 Mutable vs immutable
```python
a = [1, 2]; b = a          # b references SAME list
b.append(3); print(a)      # [1, 2, 3]  😱
s = "hi"; t = s; t += "!"  # new string created; s unchanged
```
`is` quirk: small ints (−5…256) and some strings are cached → `a = 256; b = 256; a is b` is `True`, but don't rely on it.

### 🧭 Approaches to swap two variables
1. `a, b = b, a` ✅ idiomatic 2. temp variable 3. arithmetic `a = a+b; b = a-b; a = a-b` (numbers only) 4. XOR (ints only).

### 🔎 Scope basics
Variables created inside a function are local; module-level are global (details in [Ch 13](#ch13)).

### ⚠️ Pitfalls
No real constants (can be reassigned) · using `is` for value comparison · aliasing lists.

---

<a id="ch4"></a>
## 🎙️ 4. Input and Output  [⬆️ top](#top)

> 🎤 **Interview short note:** `input()` **always returns `str`** — convert explicitly. `print(*objs, sep=' ', end='\n', file=sys.stdout, flush=False)`. Prefer **f-strings**. `str()` is user-friendly, `repr()` is developer/unambiguous.

### 💻 Examples
```python
name = input("Name: ")
age = int(input("Age: "))
a, b = map(int, input("Two ints: ").split())
nums = list(map(int, input().split()))
x, y, z = input().split()                    # unpacking

print("a", "b", "c", sep="-", end="!\n")     # a-b-c!
print("Loading", end="", flush=True)         # flush immediately
import sys
print("error!", file=sys.stderr)
sys.stdout.write("no newline added\n")       # only accepts str, returns count

pi = 3.14159
print(f"{pi:.2f} | {42:>6} | {42:06d} | {1_000_000:,} | {0.256:.1%}")
print("{} is {}".format("Sam", 20))          # str.format
print("%s is %d" % ("Sam", 20))              # old style
print(repr("hi\n"), str("hi\n"))             # 'hi\n'  vs  hi
```
**Read until condition:**
```python
while True:
    line = input("cmd> ")
    if line == "quit": break
```
**Fast input for competitive programming:** `import sys; data = sys.stdin.readline()`.

### 🧭 Approaches to formatting
| Method | When |
|---|---|
| f-string | default (fast, readable) |
| `.format()` | templates stored separately |
| `%` | legacy / logging |
| `string.Template` | user-supplied templates (safe) |

### 🆚 `print` vs `sys.stdout.write`
`print` adds separators/newline and converts to str; `write` needs a str and adds nothing.

### ⚠️ Pitfalls
`"5" + 3` → TypeError · `int("3.5")` → ValueError (use `int(float(...))`) · `input()` raises `EOFError` at end of stdin.

---

<a id="ch5"></a>
## 🧬 5. Python Data Types  [⬆️ top](#top)

> 🎤 **Interview short note:** Everything is an object. Core built-ins: `int, float, complex, bool, str, list, tuple, range, bytes, bytearray, memoryview, set, frozenset, dict, NoneType`. `bool` is a subclass of `int`. Floats use IEEE-754 → `0.1+0.2 != 0.3`. Use `Decimal` for money. Hashable = immutable-ish → usable as dict keys / set members.

### 🔢 Numeric
```python
i = 10; big = 10**100               # int is arbitrary precision
f = 3.14; c = 2 + 3j
print(c.real, c.imag, abs(c))       # 2.0 3.0 3.605...
print(7 / 2, 7 // 2, -7 // 2, 7 % 3)   # 3.5 3 -4 1  (floor division!)
print(0.1 + 0.2 == 0.3)             # False
import math; print(math.isclose(0.1+0.2, 0.3))   # True
print(1_000_000, 0b1010, 0o17, 0xFF)            # underscores + bases
print(True + True, isinstance(True, int))       # 2 True
from decimal import Decimal; from fractions import Fraction
print(Decimal("0.1") + Decimal("0.2"))          # 0.3
print(Fraction(1, 3) + Fraction(1, 6))          # 1/2
```

### ✅ Boolean & None
Falsy: `False, None, 0, 0.0, 0j, "", [], (), {}, set(), range(0)`. Everything else truthy.
```python
x = None
print(x is None)      # ✅ correct (identity; None is a singleton)
# x == None           # ❌ works but can be fooled by __eq__
```

### 🧱 Sequence / set / mapping types
| Type | Ordered | Mutable | Duplicates | Example |
|---|---|---|---|---|
| `str` | ✅ | ❌ | ✅ | `"hi"` |
| `list` | ✅ | ✅ | ✅ | `[1,2]` |
| `tuple` | ✅ | ❌ | ✅ | `(1,2)` |
| `range` | ✅ | ❌ | – | `range(5)` |
| `bytes` | ✅ | ❌ | ✅ | `b"ab"` |
| `bytearray` | ✅ | ✅ | ✅ | `bytearray(b"ab")` |
| `set` | ❌ | ✅ | ❌ | `{1,2}` |
| `frozenset` | ❌ | ❌ | ❌ | `frozenset({1})` |
| `dict` | ✅ (3.7+ insertion) | ✅ | keys unique | `{"a":1}` |

```python
b = bytearray(b"abc"); b[0] = 65; print(b)        # bytearray(b'Abc')
m = memoryview(b"hello"); print(m[1:3].tobytes()) # b'el'  (zero-copy slice)
```

### 🧭 Type checking approaches
```python
type(5) is int                 # exact type
isinstance(True, int)          # True – respects inheritance ✅ preferred
issubclass(bool, int)          # True
```
- **Iterable:** has `__iter__` (list, str, dict, generator). Not iterable: `int`, `None`.
- **Hashable:** `hash(obj)` works → tuples of hashables ok, lists ❌.
- **Implicit conversion:** `3 + 2.0 → 5.0`. **Explicit:** `int("5")`.
- **Type hints** are for tools; **runtime types** are what `type()` shows.

### ⚠️ Pitfalls
`{}` is an empty **dict**, not set (use `set()`) · `(1)` is int, `(1,)` is tuple · float equality.

---

<a id="ch6"></a>
## 🔄 6. Type Conversion and Casting  [⬆️ top](#top)

> 🎤 **Interview short note:** Python has **implicit** (numeric promotion int→float→complex) and **explicit** conversion via constructors. Failed conversions raise `ValueError`/`TypeError`. `int()` truncates toward zero; `round()` uses **banker's rounding**.

### 💻 Examples
```python
int("42"), int(3.9), int("ff", 16), int("1010", 2)   # 42 3 255 10
float("3.5"), complex("1+2j"), str(99), bool([]), bool("False")  # last → True!
list("abc"), tuple([1,2]), set("aab"), frozenset([1,1]), dict([("a",1)])
bytes("hé", "utf-8"), bytearray(3)
ord("A"), chr(97)              # 65 'a'
bin(10), oct(10), hex(255)     # '0b1010' '0o12' '0xff'
round(2.5), round(3.5), round(3.14159, 2)  # 2 4 3.14  (banker's rounding)
abs(-5), format(3.14159, ".2f"), ascii("é"), repr("x")
"héllo".encode("utf-8").decode("utf-8")    # encode/decode
",".join(["a","b"]); "a,b".split(",")      # string <-> collection
dict(zip("ab", [1, 2]))
```
### 🛡️ Safe conversion (approaches)
```python
def to_int(s, default=None):                 # EAFP approach
    try: return int(s)
    except (ValueError, TypeError): return default

s.isdigit() and int(s)                       # LBYL approach (fails for "-5", " 5")
```
### ⚠️ Pitfalls
`bool("False")` is True · `int("3.5")` fails · `int(None)` → TypeError · string→list splits characters.

---

<a id="ch7"></a>
## ➕ 7. Operators in Python  [⬆️ top](#top)

> 🎤 **Interview short note:** Know precedence (`**` > unary > `* / // %` > `+ -` > shifts > `&` > `^` > `|` > comparisons/`in`/`is` > `not` > `and` > `or` > ternary > `:=`). `and`/`or` **short-circuit and return an operand**, not necessarily a bool. `**` is right-associative. `//` floors (toward −∞). Comparisons chain: `1 < x < 10`.

### 💻 Examples
```python
# Arithmetic
print(7 + 2, 7 - 2, 7 * 2, 7 / 2, 7 // 2, 7 % 2, 7 ** 2)   # 9 5 14 3.5 3 1 49
print(-7 // 2, -7 % 2, 2 ** 3 ** 2)                         # -4 1 512 (right-assoc)

# Comparison & chaining
x = 5; print(1 < x < 10, x != 3)

# Assignment (augmented)
x += 1; x -= 1; x *= 2; x /= 2; x //= 2; x %= 3; x **= 2

# Bitwise
a, b = 0b1100, 0b1010
print(a & b, a | b, a ^ b, ~a, a << 1, a >> 1)   # 8 14 6 -13 24 6

# Logical – short-circuit returns operands
print(0 or "default", "x" and "y", None and 1, not [])   # default y None True

# Identity vs membership
print([] is [], [] == [], 3 in [1, 2, 3], "a" not in "abc")

# Walrus  :=
data = [1, 2, 3, 4]
if (n := len(data)) > 3: print(f"long list: {n}")

# Ternary
label = "adult" if x >= 18 else "minor"

# divmod, pow, sum, min, max
print(divmod(17, 5), pow(2, 10, 1000), sum([1, 2, 3], 10), min(3, 1, 2), max("a", "c", key=ord))
```

### 🧭 Approaches – bit tricks
- Even/odd: `n & 1` vs `n % 2`
- Power of two: `n > 0 and n & (n-1) == 0`
- Swap with XOR: `a ^= b; b ^= a; a ^= b`
- Multiply by 2ᵏ: `n << k`

### 🔧 Operator overloading basics
`__add__`, `__eq__`, `__lt__`… let your class work with operators (see [Ch 16](#ch16)).

### 🧮 Unary vs binary
Unary: `-x`, `+x`, `~x`, `not x`. Binary: need two operands.

### ⚠️ Pitfalls
`is` on ints/strings · `~x == -(x+1)` · `0.1 * 3` precision · `==` vs `=` · `not a == b` means `not (a == b)`.

---

<a id="ch8"></a>
## 🚦 8. Conditional Statements  [⬆️ top](#top)

> 🎤 **Interview short note:** `if/elif/else` — first true branch wins. No `switch` before 3.10; now `match-case` does **structural pattern matching** (not just value switch). Use **guard clauses** (early return) to avoid deep nesting. Use truthiness idiomatically (`if items:`).

### 💻 Examples
```python
marks = 82
if marks >= 90: grade = "A"
elif marks >= 75: grade = "B"
else: grade = "C"

# nested + logical
if marks > 40 and (marks % 2 == 0 or marks > 80): print("ok")

# ternary (avoid nesting more than once)
g = "A" if marks >= 90 else "B" if marks >= 75 else "C"

# guard clause
def withdraw(bal, amt):
    if amt <= 0: raise ValueError("amount must be positive")
    if amt > bal: return "insufficient"
    return bal - amt

# match-case (3.10+)
def handle(cmd):
    match cmd:
        case "start" | "go":              return "starting"       # literals / OR
        case ["move", x, y]:              return f"move {x},{y}"  # sequence
        case {"type": "user", "name": n}: return f"user {n}"      # mapping
        case [first, *rest] if rest:      return f"{first}+{len(rest)}"  # guard
        case int(n) if n > 0:             return "positive int"   # class pattern
        case _:                           return "unknown"        # wildcard
print(handle(["move", 3, 4]))
```
### 🧭 Different approaches to "switch"
1. `if/elif` chain 2. **dict dispatch** `{"a": f1, "b": f2}.get(k, default)()` 3. `match-case`.

### ⚠️ Pitfalls
`if x = 5` (SyntaxError) · `if x == 1 or 2` (always True; write `x in (1, 2)`) · unreachable `case` after wildcard · `case name:` **captures** (doesn't compare); use dotted names/constants for comparison.

---

<a id="ch9"></a>
## 🎡 9. Looping Statements  [⬆️ top](#top)

> 🎤 **Interview short note:** `for` iterates any iterable (uses the iterator protocol). `while` is condition-based. `for-else`/`while-else`: **else runs only if the loop did NOT `break`**. Never mutate a list while iterating over it. Prefer `enumerate`/`zip` over index loops.

### 💻 Examples
```python
for i in range(1, 10, 2): print(i, end=" ")       # 1 3 5 7 9
for i in range(5, 0, -1): ...                      # countdown
n = 3
while n: n -= 1                                    # truthiness

for ch in "hey": ...                               # strings
for k, v in {"a": 1}.items(): ...                  # dict
for i, x in enumerate(["a", "b"], start=1): ...    # index + value
for a, b in zip([1, 2], "xy"): ...                 # parallel
for x in reversed([1, 2, 3]): ...

# nested – pattern printing
for i in range(1, 4):
    print("*" * i)
for row in [[1, 2], [3, 4]]:
    for v in row: print(v)

# break / continue / pass / for-else
for x in [2, 4, 6]:
    if x % 2: print("odd found"); break
else:
    print("all even")          # runs: no break occurred

# manual iterator
it = iter([10, 20]); print(next(it), next(it), next(it, "done"))
```
### 🧭 Approaches – iterate and remove items safely
```python
nums = [1, 2, 3, 4]
nums = [n for n in nums if n % 2]          # 1) comprehension ✅
for n in nums[:]: ...                      # 2) iterate over a copy
i = len(nums)-1                            # 3) iterate backwards and delete
```
### 🧭 Index vs direct iteration
Direct (`for x in items`) is cleaner; use `enumerate` if you need the index; `range(len(x))` only when you must modify in place.

### 📈 Complexity
Nested loops over n items = O(n²); triple = O(n³). `x in list` inside a loop hides O(n) → use a `set`.

### ⚠️ Pitfalls
Infinite `while True` without exit · modifying iterable mid-loop · off-by-one with `range` stop (exclusive).

---

<a id="ch10"></a>
## 🧵 10. Strings — Complete String Programming  [⬆️ top](#top)

> 🎤 **Interview short note:** `str` is an **immutable** sequence of Unicode code points. Every "modification" creates a new string. Build large strings with `"".join(list)` (O(n)), not `+=` in a loop. Slicing `[start:stop:step]` never raises IndexError. `casefold()` > `lower()` for caseless comparison. Strings compare lexicographically by code point.

### 📖 Fundamentals
```python
s = 'single'; d = "double"; t = """multi
line"""; e = ""
s = "Python"
print(s[0], s[-1], s[1:4], s[::-1], s[::2], s[-3:])  # P n yth nohtyP Pto hon
print("ab" + "cd", "ab" * 3, "a" in "cat", "apple" < "banana")
raw = r"C:\new\table"            # raw: backslashes literal
u = "नमस्ते 🐍"; print(len(u))    # Unicode OK
b = u.encode("utf-8"); print(b.decode("utf-8"))
# s[0] = "J" -> TypeError (immutable)
name, pi = "Sam", 3.14159
print(f"{name!r:>10} {pi:.3f} {10:08b} {255:#x} {1234567:,}")
print(f"{name=}")                 # debug form (3.8+)
```
### 🧰 String methods (with examples)
| Group | Methods | Example |
|---|---|---|
| Case | `capitalize, casefold, lower, upper, title, swapcase` | `"hELLO".swapcase()` → `Hello` |
| Search | `find, rfind, index, rindex, count` | `"banana".find("an")`→1, `.count("a")`→3 |
| Check | `startswith, endswith, isalpha, isalnum, isascii, isdecimal, isdigit, isnumeric, isidentifier, islower, isupper, istitle, isspace, isprintable` | `"²".isdigit()` True, `.isdecimal()` False |
| Trim | `strip, lstrip, rstrip` | `"xxhixx".strip("x")` → `hi` |
| Replace | `replace, translate, maketrans` | `"a-b".replace("-", "_")` |
| Split | `split, rsplit, splitlines, partition, rpartition` | `"a=b=c".partition("=")` → `('a','=','b=c')` |
| Join/align | `join, center, ljust, rjust, zfill` | `"7".zfill(3)` → `007` |
| Format | `format, format_map` | `"{a}".format_map({"a":1})` |
| Affix | `removeprefix, removesuffix` (3.9+) | `"test.py".removesuffix(".py")` |
| Other | `expandtabs, encode` | `"a\tb".expandtabs(4)` |

`find` returns −1 if missing; `index` raises `ValueError`.

### 🧩 Related tools
```python
import string, unicodedata
print(string.ascii_letters, string.digits, string.punctuation)
tr = str.maketrans("aeiou", "12345", "xyz")     # map + delete chars
print("education".translate(tr))
print(unicodedata.normalize("NFC", "e\u0301") == "\u00e9")   # True – normalization
words = "The quick  brown fox".split()           # simple tokenization
import re; print(re.findall(r"\w+", "Hi, there!"))   # regex tokenization
```
### 🧭 Classic problems – multiple approaches
**Reverse a string:** `s[::-1]` ✅ · `"".join(reversed(s))` · loop prepending · recursion.
**Palindrome:** `s == s[::-1]` · two pointers `i, j` · clean first: `c = "".join(ch.lower() for ch in s if ch.isalnum())`.
**Anagram:** `sorted(a) == sorted(b)` (O(n log n)) · `Counter(a) == Counter(b)` (O(n)).
**Count vowels:** `sum(ch in "aeiou" for ch in s.lower())`.
**First non-repeating char:** `Counter` then scan.
**Word frequency:** `Counter(text.lower().split()).most_common(3)`.

### ⚠️ Pitfalls
`+=` in loops O(n²)-ish · `split()` vs `split(" ")` differ on multiple spaces · `title()` mishandles apostrophes (`"it's"` → `It'S`) · `strip("abc")` strips a *set* of chars, not a substring.

---

<a id="ch11"></a>
## 📜 11. Lists — Complete List Programming  [⬆️ top](#top)

> 🎤 **Interview short note:** `list` = dynamic array, **mutable, ordered**. `append` O(1) amortized, `insert(0, x)`/`pop(0)`/`remove`/`in` O(n), index O(1). Assignment aliases; `copy()`/`[:]` is **shallow** — nested lists shared; use `copy.deepcopy`. `sort()` in place returns `None`; `sorted()` returns new list; sort is **stable** (Timsort).

### 📖 Fundamentals
```python
a = [1, 2, 3]; empty = []; nested = [[1, 2], [3, 4]]
a[0] = 10; a.insert(1, 99); del a[2]; a[1:3] = [7, 8, 9]   # slice assignment
print(a + [0], a * 2, [1,2] < [1,3], nested[1][0])
```
### 🧰 Methods
```python
l = [3, 1, 2]
l.append(4); l.extend([5, 6]); l.insert(0, 0)
l.remove(5)             # first match; ValueError if missing
x = l.pop(); y = l.pop(0)
l.index(2); l.count(1)
l.sort(reverse=True); l.reverse(); c = l.copy(); l.clear()
```
### 🔗 Operations / functions
```python
nums = [4, 2, 9]
len(nums), min(nums), max(nums), sum(nums)
sorted(nums, key=lambda n: -n); list(reversed(nums))
any(n > 8 for n in nums); all(n > 0 for n in nums)
first, *mid, last = [1, 2, 3, 4]                 # unpacking
people = [{"n": "A", "age": 30}, {"n": "B", "age": 25}]
people.sort(key=lambda p: p["age"])              # sort dicts
from operator import itemgetter, attrgetter
people.sort(key=itemgetter("age"))               # faster/cleaner
```
### ⚠️ Copy pitfalls
```python
import copy
m = [[0]*3]*3          # ❌ same inner list repeated 3 times!
m = [[0]*3 for _ in range(3)]   # ✅
x = [[1], [2]]; s = x.copy(); s[0].append(9); print(x)   # [[1, 9], [2]] shallow!
d = copy.deepcopy(x)   # independent
```
### 🧭 Stack & Queue approaches
```python
stack = []; stack.append(1); stack.pop()                # LIFO ✅ O(1)
from collections import deque
q = deque(); q.append(1); q.popleft()                    # FIFO ✅ O(1)
# list as queue: pop(0) is O(n) ❌
import queue; queue.Queue()                              # thread-safe
```
### 🧭 Remove duplicates (preserve order)
`list(dict.fromkeys(l))` ✅ · loop with `seen` set · `list(set(l))` (order lost).

### 🧭 Flatten nested list
`[x for row in m for x in row]` · `itertools.chain.from_iterable(m)` · recursion for arbitrary depth.

### 🧭 Find 2nd largest
`sorted(set(l))[-2]` · single pass with two variables (O(n)) · `heapq.nlargest(2, l)[-1]`.

### 🧭 Rotate list by k
`l[-k:] + l[:-k]` · `deque.rotate(k)`.

### 🧠 Performance & memory
Lists over-allocate; `sys.getsizeof`. Use `array.array`/NumPy for large numeric data; generators for streaming. Membership on big lists → use `set`.

---

<a id="ch12"></a>
## 🧩 12. Tuples, Sets and Dictionaries  [⬆️ top](#top)

> 🎤 **Interview short note:** **Tuple** immutable (but may contain mutable items), hashable if all items hashable. **Set** unordered unique hashables, O(1) average membership. **Dict** hash map, insertion-ordered since 3.7, keys must be hashable, avg O(1) get/set. `d[k]` raises `KeyError`; `d.get(k)` returns `None`. `{}` is a dict.

### A. 🧊 Tuples
```python
t = (1, 2, 3); single = (1,); packed = 1, 2; a, b = packed
nested = ((1, 2), (3, 4)); t[1:]; t.count(1); t.index(2)
def min_max(xs): return min(xs), max(xs)       # returns a tuple
lo, hi = min_max([3, 1, 2])
grid = {(0, 0): "origin"}                      # tuple as dict key
from collections import namedtuple
P = namedtuple("P", "x y"); p = P(1, 2); print(p.x, p._asdict())
```
**Tuple vs list:** tuple – fixed, hashable, slightly faster/smaller, heterogeneous records; list – dynamic, homogeneous collections. `t = ([1], 2); t[0].append(9)` is allowed!

### B. 🎯 Sets & frozensets
```python
s = {1, 2, 3}; e = set(); fs = frozenset([1, 2])
s.add(4); s.update([5, 6]); s.remove(5)    # KeyError if absent
s.discard(99)                               # silent
s.pop(); s.copy(); s.clear()
A, B = {1, 2, 3}, {3, 4}
A | B, A & B, A - B, A ^ B                  # union, intersection, difference, symmetric diff
A.union(B); A.intersection(B); A.difference(B); A.symmetric_difference(B)
A.intersection_update(B); A.difference_update(B); A.symmetric_difference_update(B)
A <= B, A >= B, A.issubset(B), A.issuperset(B), A.isdisjoint(B)
sq = {x*x for x in range(5)}                # comprehension
list(set([1, 1, 2]))                        # dedupe
```
**Why fast?** Hash table → O(1) average `in`. Set problems: common elements (`a & b`), missing numbers (`set(range(1,n+1)) - set(arr)`), unique-check (`len(s) == len(set(s))`).

### C. 🗝️ Dictionaries
```python
d = {"a": 1}; d2 = dict(a=1, b=2); d3 = dict(zip("ab", [1, 2]))
d["c"] = 3; d.update({"a": 10}); del d["a"]
d["x"]                 # KeyError
d.get("x", 0)          # 0
d.setdefault("k", []).append(1)       # insert default if missing
d.pop("c"); d.popitem()               # LIFO since 3.7
dict.fromkeys(["a", "b"], 0)          # {'a':0,'b':0} (shared default object!)
for k, v in d.items(): ...            # views: keys(), values(), items() are live
{**d, "z": 1}; d | {"y": 2}; d |= {"w": 3}     # merging (| from 3.9)
{k: v*2 for k, v in d.items()}        # comprehension
nested = {"u": {"age": 20}}; nested["u"]["age"]
```
**Sorting:** `sorted(d)` (keys), `sorted(d.items(), key=lambda kv: kv[1], reverse=True)`, `dict(sorted(...))`; `max(d, key=d.get)`.

### 🧰 `collections` power tools
```python
from collections import defaultdict, Counter, OrderedDict, ChainMap
groups = defaultdict(list)
for w in ["ant", "bee", "ape"]: groups[w[0]].append(w)
cnt = Counter("mississippi"); print(cnt.most_common(2))   # [('i',4),('s',4)]
oc = OrderedDict(a=1); oc.move_to_end("a")   # order-aware equality, move_to_end
cm = ChainMap({"a": 1}, {"a": 2, "b": 3}); print(cm["a"], cm["b"])   # 1 3 – layered lookup
```
### 🧭 Approaches – count frequency
1. `d[k] = d.get(k, 0) + 1` 2. `defaultdict(int)` 3. `Counter` ✅ 4. `if k in d` branch.
### 🧭 Approaches – group items
`setdefault` · `defaultdict(list)` ✅ · `itertools.groupby` (needs sorted input).
### 🧭 Two-sum (interview classic)
Brute force O(n²) → hash map O(n): `seen = {}; for i, x in enumerate(a): if t-x in seen: return seen[t-x], i; seen[x] = i`.

### ⚠️ Pitfalls
Mutating dict while iterating (`RuntimeError`) · unhashable keys (list) · `fromkeys` with mutable default · set ordering is not guaranteed.

---

# 🟡 PART 2 — Functions and Core Programming

---

<a id="ch13"></a>
## 🛠️ 13. Functions — All Important Concepts  [⬆️ top](#top)

> 🎤 **Interview short note:** Functions are **first-class objects** (assign, pass, return). Python is **pass-by-object-reference** ("call by assignment"): mutation is visible to the caller, rebinding is not. Scope lookup follows **LEGB** (Local → Enclosing → Global → Built-in). **Mutable default arguments are evaluated once at definition time** — the #1 gotcha. Parameter order: `positional, /, normal, *args, keyword-only, **kwargs`.

### 📖 Fundamentals
```python
def area(w, h=1):
    """Return area."""              # docstring -> area.__doc__
    return w * h
def stats(xs): return min(xs), max(xs)    # multiple values (tuple)
def hello(): print("hi")                   # no return -> None
def f(x: int) -> int: return x             # annotations (f.__annotations__)
```
**Parameters** = names in the definition; **arguments** = values passed.

### 🎯 Argument types
```python
def demo(a, b=2, *args, key=None, **kwargs):
    print(a, b, args, key, kwargs)
demo(1)                         # positional
demo(a=1, b=5)                  # keyword
demo(1, 2, 3, 4, key="k", x=9)  # *args=(3,4)  **kwargs={'x':9}
def pos_only(a, b, /, c, *, d): ...   # a,b positional-only; d keyword-only
pos_only(1, 2, 3, d=4)
nums = [1, 2]; opts = {"b": 5}
demo(*nums, **opts)             # unpacking arguments
```
**Argument ordering:** `def f(pos, /, std, *, kwonly)` → `f(1, 2, kwonly=3)`.

### 🐛 Mutable default pitfall
```python
def bad(x, acc=[]):   acc.append(x); return acc      # ❌ shared list
def good(x, acc=None):                                # ✅
    acc = [] if acc is None else acc
    acc.append(x); return acc
```
### 🔄 Pass mutable vs immutable
```python
def f(lst, n): lst.append(1); n += 1      # list mutated, int rebound locally
l, n = [], 0; f(l, n); print(l, n)        # [1] 0
```
### 🔎 Scope: LEGB, `global`, `nonlocal`
```python
x = "global"
def outer():
    x = "enclosing"
    def inner():
        nonlocal x; x = "changed"      # modifies enclosing
    inner(); return x
counter = 0
def inc():
    global counter; counter += 1       # without global -> UnboundLocalError
```
### 🧬 Nested functions & closures
```python
def make_mul(n):
    def mul(x): return x * n      # remembers n (closure cell)
    return mul
double = make_mul(2); print(double(5), double.__closure__[0].cell_contents)
```
**Late-binding gotcha:** `[lambda: i for i in range(3)]` all return 2 → fix with `lambda i=i: i`.

### 🧪 Higher-order, pure functions, first-class
Pure = same input → same output, no side effects (easy to test/cache).
```python
def apply(fn, v): return fn(v)
apply(str.upper, "hi")
```
### ⚡ Lambda & functional tools
```python
sq = lambda x: x * x                     # single expression only
list(map(lambda x: x*2, [1, 2, 3]))      # [2,4,6]
list(filter(lambda x: x % 2, range(6)))  # [1,3,5]
from functools import reduce, partial, lru_cache, cache, wraps
reduce(lambda a, b: a * b, [1, 2, 3, 4]) # 24
sorted(["bb", "a"], key=len)
pow2 = partial(pow, 2); print(pow2(5))   # 32
@lru_cache(maxsize=None)                 # memoization
def fib(n): return n if n < 2 else fib(n-1) + fib(n-2)
@cache                                   # 3.9+, unbounded
def sq2(n): return n*n
compose = lambda f, g: lambda x: f(g(x)) # function composition
class Adder:                             # callable object
    def __init__(self, n): self.n = n
    def __call__(self, x): return x + self.n
print(Adder(3)(4), callable(Adder(1)))
import itertools; list(itertools.islice(itertools.count(), 3))
```
### 🧭 Approaches: sum of list
loop · `sum()` · `reduce(add)` · recursion — `sum()` is the Pythonic answer.
### 🧭 Approaches: transform list
`map` + lambda vs list comprehension (✅ preferred for readability).

### ⚠️ Pitfalls
Forgetting `return` (gets `None`) · mutable defaults · `global` overuse · `lambda` with statements impossible · late binding.

---

<a id="ch14"></a>
## 🪄 14. Comprehensions and Unpacking  [⬆️ top](#top)

> 🎤 **Interview short note:** Comprehensions are concise, usually faster than equivalent loops, and have their **own scope**. Generator expressions are **lazy** (O(1) memory). Use comprehensions when it stays readable (≤ 2 levels). `*` unpacks iterables, `**` unpacks mappings.

```python
squares = [x*x for x in range(5)]
evens   = [x for x in range(10) if x % 2 == 0]
tags    = ["even" if x % 2 == 0 else "odd" for x in range(4)]   # if-else BEFORE for
matrix  = [[i*j for j in range(3)] for i in range(3)]           # nested
flat    = [v for row in matrix for v in row]                    # multiple for
pairs   = [(x, y) for x in range(3) for y in range(3) if x != y]
multi   = [x for x in range(50) if x % 2 == 0 if x % 5 == 0]    # multiple ifs
dsq     = {x: x*x for x in range(4)}
uniq    = {c.lower() for c in "HelLo"}
gen     = (x*x for x in range(10**9))     # no memory blow-up
print(sum(x*x for x in range(10)))        # generator expr as sole argument

# Unpacking
a, b = (1, 2); a, b = b, a
first, *middle, last = [1, 2, 3, 4, 5]
head, *_ = "hello"
merged = {**{"a": 1}, **{"b": 2}}; combo = [*[1, 2], *(3, 4)]
for i, (x, y) in enumerate([(1, 2), (3, 4)]): ...
```
### 🧭 Approaches – flatten / filter / transform
Loop+append → comprehension → `map/filter`. Use loops when logic needs multiple statements or side effects.
### 🧭 List vs generator
List: reusable, indexable, memory-heavy. Generator: single pass, memory-light.

### ⚠️ Pitfalls
Over-nesting hurts readability · comprehension variables don't leak in Py3 · a generator can be consumed only once · `{}` comprehension makes dict, `{x for ...}` makes set.

---

<a id="ch15"></a>
## 🔁 15. Recursion and Problem-Solving Patterns  [⬆️ top](#top)

> 🎤 **Interview short note:** Recursion = function calls itself with a smaller subproblem + **base case**. Python's default recursion limit ≈ **1000** (`sys.getrecursionlimit()`), raising `RecursionError`; **no tail-call optimization**. Naive Fibonacci is O(2ⁿ) → memoize to O(n) (DP). Prefer iteration for deep loops.

```python
import sys
from functools import lru_cache

def fact(n): return 1 if n <= 1 else n * fact(n - 1)           # O(n)
def fib_naive(n): return n if n < 2 else fib_naive(n-1) + fib_naive(n-2)  # O(2^n)

@lru_cache(None)
def fib(n): return n if n < 2 else fib(n-1) + fib(n-2)         # O(n)

def fib_iter(n):                                               # O(n), O(1) space ✅
    a, b = 0, 1
    for _ in range(n): a, b = b, a + b
    return a

def digit_sum(n): return 0 if n == 0 else n % 10 + digit_sum(n // 10)
def rev(s): return s if len(s) <= 1 else rev(s[1:]) + s[0]
def is_pal(s): return len(s) < 2 or (s[0] == s[-1] and is_pal(s[1:-1]))

def bsearch(a, t, lo=0, hi=None):                              # O(log n)
    hi = len(a) - 1 if hi is None else hi
    if lo > hi: return -1
    mid = (lo + hi) // 2
    if a[mid] == t: return mid
    return bsearch(a, t, mid+1, hi) if a[mid] < t else bsearch(a, t, lo, mid-1)

# Tree traversal
class Node:
    def __init__(s, v, l=None, r=None): s.v, s.l, s.r = v, l, r
def inorder(n): return inorder(n.l) + [n.v] + inorder(n.r) if n else []

# Backtracking: subsets
def subsets(nums):
    res = []
    def go(i, cur):
        if i == len(nums): res.append(cur[:]); return
        go(i+1, cur)                 # skip
        cur.append(nums[i]); go(i+1, cur); cur.pop()   # take, then undo
    go(0, []); return res
print(subsets([1, 2, 3]))

# indirect recursion
def is_even(n): return True if n == 0 else is_odd(n - 1)
def is_odd(n): return False if n == 0 else is_even(n - 1)
```
**Head vs tail recursion:** *Tail*: recursive call is the last action (`def f(n, acc=1): return acc if n<=1 else f(n-1, acc*n)`) — still no TCO in Python. *Head*: work happens after the call returns.

### 🧭 Approaches: Fibonacci (interview favorite)
1. Naive recursion O(2ⁿ) 2. Memoization (top-down DP) O(n) 3. Tabulation (bottom-up) O(n) 4. Iterative two-variable O(1) space 5. Matrix exponentiation/fast doubling O(log n).
### 🧭 Binary search
Recursive vs iterative (✅ no stack) vs `bisect.bisect_left`.
### 🧭 Recursion vs iteration
Recursion: elegant for trees/graphs/backtracking. Iteration: faster, no depth limit. Convert deep recursion with an explicit stack. `sys.setrecursionlimit(n)` is risky (can crash the interpreter).

### ⚠️ Pitfalls
Missing base case → `RecursionError` · slicing in recursion is O(n) each call · recomputing overlapping subproblems.

---

<a id="ch16"></a>
## 🏛️ 16. Object-Oriented Programming (OOP)  [⬆️ top](#top)

> 🎤 **Interview short note:** Four pillars — **Encapsulation** (hide state; `_x` convention, `__x` name-mangling, `@property`), **Abstraction** (`abc.ABC`), **Inheritance** (`super()`, MRO via C3 linearization), **Polymorphism** (overriding, duck typing). `__new__` creates, `__init__` initializes. Python has **no true private** members and **no method overloading** (last definition wins; use default args/`*args`/`singledispatch`). Prefer **composition over inheritance**.

### 📖 Classes & objects
```python
class Dog:
    species = "Canis"                     # class attribute (shared)
    def __init__(self, name):             # initializer
        self.name = name                  # instance attribute
    def speak(self): return f"{self.name}: Woof"        # instance method
    @classmethod
    def from_str(cls, s): return cls(s.title())         # alt constructor
    @staticmethod
    def is_pet(): return True                            # no self/cls
d = Dog("rex"); print(d.speak(), Dog.from_str("max").name, d.__dict__)
getattr(d, "name"); setattr(d, "age", 3); hasattr(d, "age"); delattr(d, "age")
```
| Method type | First arg | Access |
|---|---|---|
| Instance | `self` | instance + class |
| `@classmethod` | `cls` | class state, factories |
| `@staticmethod` | none | utility, no state |

`==` vs `is`: define `__eq__` (and `__hash__`) for value equality.
**`__new__` Singleton:**
```python
class S:
    _inst = None
    def __new__(cls):
        if cls._inst is None: cls._inst = super().__new__(cls)
        return cls._inst
print(S() is S())   # True
```

### 🔒 Encapsulation & Abstraction
```python
from abc import ABC, abstractmethod
class Account:
    def __init__(self, bal): self._bal = bal; self.__pin = 1234   # _protected, __private (mangled _Account__pin)
    @property
    def balance(self): return self._bal                            # read-only
    @balance.setter
    def balance(self, v):
        if v < 0: raise ValueError("negative")
        self._bal = v
class Shape(ABC):
    @abstractmethod
    def area(self): ...
# Shape() -> TypeError: can't instantiate abstract class
```
### 🧬 Inheritance & MRO
```python
class A:
    def hi(self): return "A"
class B(A):
    def hi(self): return "B>" + super().hi()
class C(A):
    def hi(self): return "C>" + super().hi()
class D(B, C): pass                      # diamond
print(D().hi(), [k.__name__ for k in D.__mro__])   # B>C>A  ['D','B','C','A','object']
```
Types: single (A→B), multiple (B,C→D), multilevel (A→B→C), hierarchical (A→B, A→C), hybrid (mix). **Diamond problem** solved by C3 MRO + cooperative `super()`.
**Mixins:** small classes adding behavior (`class JsonMixin: def to_json(self): ...`).
**Relationships:** *Association* (uses), *Aggregation* (has-a, independent lifetime), *Composition* (has-a, owns lifetime).
**Duck typing:** "if it quacks like a duck" — `def run(x): x.speak()` works for any object with `speak`.
**Overloading alternative:** `def f(a, b=None)`, `*args`, or `functools.singledispatch`.

### ✨ Dunder (special) methods
```python
class Vec:
    def __init__(self, x, y): self.x, self.y = x, y
    def __repr__(self): return f"Vec({self.x}, {self.y})"     # for devs
    def __str__(self): return f"<{self.x},{self.y}>"          # for users
    def __eq__(self, o): return (self.x, self.y) == (o.x, o.y)
    def __hash__(self): return hash((self.x, self.y))          # needed if __eq__ defined
    def __lt__(self, o): return abs(self) < abs(o)
    def __add__(self, o): return Vec(self.x+o.x, self.y+o.y)
    def __radd__(self, o): return self if o == 0 else self + o # makes sum() work
    def __iadd__(self, o): self.x += o.x; self.y += o.y; return self
    def __mul__(self, k): return Vec(self.x*k, self.y*k)
    def __abs__(self): return (self.x**2 + self.y**2) ** .5
    def __bool__(self): return bool(abs(self))
    def __len__(self): return 2
    def __getitem__(self, i): return (self.x, self.y)[i]       # indexing + iteration
    def __contains__(self, v): return v in (self.x, self.y)
    def __call__(self, k): return self * k
    def __format__(self, spec): return f"{self.x:{spec}},{self.y:{spec}}"
    def __int__(self): return int(abs(self))
class Ctx:
    def __enter__(self): print("open"); return self
    def __exit__(self, et, ev, tb): print("close"); return False   # True swallows exceptions
with Ctx(): pass
```
Also: `__ne__ __le__ __gt__ __ge__ __sub__ __truediv__ __floordiv__ __mod__ __pow__ __setitem__ __delitem__ __iter__ __del__ __float__ __index__`; attribute hooks `__getattr__` (only on missing), `__getattribute__` (always), `__setattr__`. `functools.total_ordering` fills comparisons.

### 🚀 Advanced OOP
```python
from dataclasses import dataclass, field
@dataclass(frozen=True, order=True)
class Pt:                            # frozen => immutable & hashable
    x: int
    y: int = 0
    tags: list = field(default_factory=list, compare=False)
class Slim:
    __slots__ = ("a", "b")          # no __dict__ -> less memory, fixed attrs
class Positive:                      # descriptor
    def __set_name__(s, o, n): s.n = "_" + n
    def __get__(s, o, t): return getattr(o, s.n)
    def __set__(s, o, v):
        if v <= 0: raise ValueError
        setattr(o, s.n, v)
class Item: price = Positive()
class Meta(type):                    # metaclass: class of a class
    def __new__(m, name, b, ns): ns["tag"] = name.lower(); return super().__new__(m, name, b, ns)
class Model(metaclass=Meta): pass    # Model.tag == "model"
def register(cls): cls.registered = True; return cls   # class decorator
from typing import Protocol
class Flyer(Protocol):               # structural typing (interface-like)
    def fly(self) -> str: ...
```
**Dependency injection:** pass collaborators in (`def __init__(self, repo): self.repo = repo`) → easy mocking.
**SOLID:** **S**ingle responsibility · **O**pen/closed · **L**iskov substitution · **I**nterface segregation (small Protocols) · **D**ependency inversion (depend on abstractions).
**Design patterns in Python:** Singleton (module/`__new__`), Factory (`@classmethod`/dict of classes), Strategy (pass functions), Observer (callback list), Decorator (`@wrap`), Adapter, Iterator (generators), Context Manager.

### 🧭 Approaches: inheritance vs composition
`class Car(Engine)` ❌ (is-a is false) vs `class Car: def __init__(s): s.engine = Engine()` ✅.
### 🧭 Approaches: interface
ABC (explicit, nominal) vs Protocol (structural) vs duck typing (implicit).
### 🧭 Approaches: immutable value object
`@dataclass(frozen=True)` · `NamedTuple` · class with `__slots__` + properties.

### ⚠️ Pitfalls
Class attribute mutable shared across instances (`tags = []`) · defining `__eq__` without `__hash__` makes it unhashable · forgetting `super().__init__()` · `__del__` unreliable.

---

<a id="ch17"></a>
## 💥 17. Exception Handling  [⬆️ top](#top)

> 🎤 **Interview short note:** `try/except/else/finally`: **else** runs if no exception; **finally** always runs (even on `return`). Catch **specific** exceptions; never bare `except:` (also catches `KeyboardInterrupt`/`SystemExit`). Hierarchy: `BaseException → Exception → (ValueError, TypeError, OSError, LookupError…)`. Use `raise ... from e` to chain. Python favors **EAFP** ("easier to ask forgiveness").

### 🧯 Error types
Syntax error (before running) · Runtime error (exception) · Logical error (wrong result, no crash).
```python
import logging
class AppError(Exception): pass
class InvalidAge(AppError):
    def __init__(self, age): super().__init__(f"Invalid age: {age}"); self.age = age

def parse(s):
    try:
        n = int(s)
        assert n >= 0, "must be >= 0"          # AssertionError (disabled with -O!)
    except (ValueError, TypeError) as e:        # multiple types
        logging.exception("bad input")           # logs traceback
        raise InvalidAge(s) from e               # chaining
    except AssertionError:
        raise                                    # re-raise unchanged
    else:
        return n                                 # no error occurred
    finally:
        print("cleanup always runs")             # resource cleanup

# resource cleanup – best way
with open("f.txt", "w") as f: f.write("x")      # closes even on error
# contextlib
from contextlib import suppress, contextmanager
with suppress(FileNotFoundError): open("missing")
@contextmanager
def timer():
    import time; t = time.perf_counter()
    try: yield
    finally: print(time.perf_counter() - t)
```
**Common exceptions:** `TypeError` (wrong type) · `ValueError` (right type, bad value) · `NameError` · `IndexError` · `KeyError` · `AttributeError` · `ImportError`/`ModuleNotFoundError` · `ZeroDivisionError` · `FileNotFoundError` · `PermissionError` · `RuntimeError` · `NotImplementedError` · `StopIteration` · `RecursionError` · `MemoryError`.
**Python 3.11+:** `ExceptionGroup` / `except*`, `add_note()`.

### 🧭 EAFP vs LBYL
```python
try: v = d["k"]            # EAFP ✅
except KeyError: v = None
v = d["k"] if "k" in d else None   # LBYL
```
### 🧭 Best practices
Catch narrowly · keep `try` blocks small · meaningful messages · custom hierarchy per library · log with `logging.exception` · don't use exceptions for normal flow when a cheap check exists · never `except: pass`.

### ⚠️ Pitfalls
`return` in `finally` swallows exceptions · order matters: specific `except` before general · `except Exception` hides bugs · `assert` is not for input validation.

---

<a id="ch18"></a>
## 📂 18. File Handling  [⬆️ top](#top)

> 🎤 **Interview short note:** Always use `with open(...)`. Specify `encoding="utf-8"`. Modes: `r` read, `w` truncate/write, `a` append, `x` create-exclusive, `b` binary, `t` text, `+` read/write. Iterate over the file object for large files (lazy). Prefer `pathlib`. **Never unpickle untrusted data** (arbitrary code execution).

```python
with open("a.txt", "w", encoding="utf-8") as f:
    f.write("line1\n"); f.writelines(["l2\n", "l3\n"])
with open("a.txt", encoding="utf-8") as f:
    f.read(); f.seek(0); f.readline(); f.seek(0); f.readlines(); print(f.tell())
for line in open("a.txt"): print(line.rstrip())       # memory efficient ✅
with open("img.png", "rb") as f: head = f.read(8)      # binary
try: open("nope.txt")
except FileNotFoundError: print("missing")
except PermissionError: print("denied")
print(f.closed)   # True after with; print(flush=True)/f.flush() for buffering
```
### 📊 Formats
```python
import csv, json, pickle, configparser, tomllib, tempfile, shutil, zipfile, tarfile, hashlib
from pathlib import Path

with open("d.csv", "w", newline="") as f:
    csv.writer(f).writerows([["n", "a"], ["A", 1]])
    # csv.DictWriter(f, fieldnames=[...]).writeheader()
for row in csv.DictReader(open("d.csv")): print(row["n"])

data = {"a": [1, 2]}
s = json.dumps(data, indent=2, sort_keys=True); back = json.loads(s)
json.dump(data, open("d.json", "w")); json.load(open("d.json"))
# default=str handles datetime; JSON tuples come back as lists

pickle.dump(data, open("d.pkl", "wb")); pickle.load(open("d.pkl", "rb"))

import xml.etree.ElementTree as ET
root = ET.fromstring("<a><b x='1'>hi</b></a>"); print(root.find("b").attrib, root.find("b").text)

cp = configparser.ConfigParser(); cp.read_string("[db]\nhost=x"); print(cp["db"]["host"])
cfg = tomllib.loads('title = "x"')          # read-only (3.11+); binary file via tomllib.load(open(f,"rb"))

with tempfile.TemporaryDirectory() as tmp: print(Path(tmp))

p = Path("dir") / "file.txt"
p.parent.mkdir(parents=True, exist_ok=True); p.write_text("hi"); p.read_text()
p.exists(), p.suffix, p.stem, p.resolve(), p.stat().st_size
for f in Path(".").rglob("*.py"): ...        # recursive traversal
import os; os.listdir("."); os.path.join("a", "b"); os.walk(".")
shutil.copy("a", "b"); shutil.move("a", "c"); shutil.rmtree("dir"); os.remove("f")

with zipfile.ZipFile("x.zip", "w") as z: z.write("a.txt")
with tarfile.open("x.tar.gz", "w:gz") as t: t.add("a.txt")

def sha256(path):                           # checksum in chunks
    h = hashlib.sha256()
    with open(path, "rb") as f:
        for chunk in iter(lambda: f.read(8192), b""): h.update(chunk)
    return h.hexdigest()

# Safe path validation (prevent ../ traversal & zip-slip)
base = Path("/srv/uploads").resolve()
target = (base / user_input).resolve()
if not target.is_relative_to(base): raise ValueError("path traversal")
```
### 🧭 Approaches: read file
`read()` (small) · iterate lines (large) ✅ · `readlines()` (list in memory) · `Path.read_text()` (shortest) · chunked binary reads.
### 🧭 Approaches: serialization choice
JSON (portable, safe) · CSV (tabular) · pickle (Python-only, unsafe) · SQLite/`shelve` (queryable/persistent dict).
### ⚠️ Pitfalls
`w` mode erases file · missing `newline=""` in csv on Windows · default encoding differs per OS · forgetting `with` leaks handles.

---

<a id="ch19"></a>
## 📚 19. Modules, Packages and Imports  [⬆️ top](#top)

> 🎤 **Interview short note:** A **module** = a `.py` file; a **package** = directory of modules (`__init__.py` optional since 3.3 = *namespace package*). Imports are **cached in `sys.modules`**, executed once. Search order: `sys.modules` → built-ins → `sys.path` (script dir, `PYTHONPATH`, site-packages). **Circular imports** → restructure, import inside function, or use `import x` not `from x import y`. Avoid naming files like stdlib (`random.py`).

```python
# mymath.py
__all__ = ["add"]                 # controls `from mymath import *`
def add(a, b): return a + b
if __name__ == "__main__": print(add(1, 2))

# usage
import mymath; from mymath import add; import mymath as mm; from mymath import add as plus
print(__name__, __file__, __package__)
```
```
project/
├── pkg/
│   ├── __init__.py      # may expose API: from .core import run
│   ├── core.py
│   └── sub/helpers.py   # from ..core import run   (relative)  |  from pkg.core import run (absolute ✅ preferred)
└── main.py
```
```python
import sys, importlib
print(sys.path[:2], "json" in sys.modules)
m = importlib.import_module("json"); importlib.reload(m)
```
**Stdlib vs third-party:** stdlib ships with Python; third-party via `pip` from PyPI.
```bash
pip install requests==2.32.3          # version pin
pip freeze > requirements.txt && pip install -r requirements.txt
python -m venv .venv
pip install build twine && python -m build && twine upload dist/*     # publish
uv venv && uv pip install requests    # fast modern tooling; also `poetry add requests`
```
```toml
# pyproject.toml (modern standard)
[project]
name = "mypkg"
version = "0.1.0"
dependencies = ["requests>=2.31"]
[build-system]
requires = ["setuptools>=68"]
build-backend = "setuptools.build_meta"
```
### 🧭 Approaches: dependency management
`pip + requirements.txt` (simple) · `pip-tools` (locked) · **Poetry** (resolver + publish) · **uv** (very fast, all-in-one).
### ⚠️ Pitfalls
`from x import *` pollutes namespace · shadowing stdlib · circular import `ImportError` · running package files directly breaks relative imports (use `python -m pkg.mod`).

---

<a id="ch20"></a>
## 🚰 20. Iterators, Iterables and Generators  [⬆️ top](#top)

> 🎤 **Interview short note:** **Iterable** has `__iter__` (returns iterator); **iterator** has `__iter__` + `__next__` and raises `StopIteration` when done. A **generator** (function with `yield`) is a lazy iterator that preserves local state between yields; generator expressions are the compact form. Generators are **one-shot** and memory-efficient. `yield from` delegates to a sub-iterator.

```python
it = iter([1, 2]); next(it); next(it)          # next(it) again -> StopIteration

class Countdown:                               # custom iterator
    def __init__(s, n): s.n = n
    def __iter__(s): return s
    def __next__(s):
        if s.n <= 0: raise StopIteration
        s.n -= 1; return s.n + 1
print(list(Countdown(3)))

def gen(n):                                    # generator function
    for i in range(n): yield i
def chain2(a, b): yield from a; yield from b   # delegation
def echo():                                    # send/throw/close
    got = yield "ready"
    while True: got = yield f"got {got}"
g = echo(); next(g); g.send("hi"); g.close()

def naturals():                                # infinite generator
    n = 0
    while True: yield n; n += 1
# pipeline (lazy, constant memory)
def read(lines): yield from lines
def nonempty(it): return (l for l in it if l.strip())
def upper(it): return (l.upper() for l in it)
print(list(upper(nonempty(read(["a", "", "b"])))))
```
### 🔧 itertools & functools
```python
import itertools as it, functools
list(it.islice(it.count(10, 5), 3)); list(it.islice(it.cycle("ab"), 5)); list(it.repeat("x", 3))
list(it.chain([1], [2])); list(it.product("ab", repeat=2))
list(it.permutations([1, 2, 3], 2)); list(it.combinations([1, 2, 3], 2))
[(k, list(g)) for k, g in it.groupby("aabbc")]        # input must be sorted by key!
list(it.accumulate([1, 2, 3]))                         # [1,3,6]
list(it.pairwise([1, 2, 3]))                           # 3.10+ -> [(1,2),(2,3)]
list(it.batched(range(5), 2))                          # 3.12+
functools.reduce(lambda a, b: a + b, [1, 2, 3])
```
### 🧭 Approaches: generate Fibonacci
list builder · generator (✅ lazy) · class iterator (explicit state).
### 🧭 Generator vs list
Generator: lazy, single-pass, O(1) memory, no `len`/indexing. List: eager, reusable.
### ⚠️ Pitfalls
Reusing exhausted generator (empty result) · `StopIteration` inside generators becomes `RuntimeError` (PEP 479) · `groupby` on unsorted data.

---

# 🔵 PART 3 — Intermediate Python and Standard Library

---

<a id="ch21"></a>
## 🎀 21. Decorators  [⬆️ top](#top)

> 🎤 **Interview short note:** A decorator is a callable that takes a function (or class) and returns a replacement — `@dec` is sugar for `f = dec(f)`. Built on **first-class functions + closures**. Always use **`functools.wraps`** to preserve `__name__`/`__doc__`. Decorators with arguments need **three nested levels** (factory → decorator → wrapper). Stacked decorators apply **bottom-up** (closest to the function first).

```python
import functools, time, logging

def timer(fn):                                   # basic decorator
    @functools.wraps(fn)
    def wrapper(*args, **kwargs):                # works with any signature
        t = time.perf_counter()
        try: return fn(*args, **kwargs)
        finally: print(f"{fn.__name__}: {time.perf_counter()-t:.4f}s")
    return wrapper

def repeat(n):                                   # decorator WITH arguments
    def deco(fn):
        @functools.wraps(fn)
        def wrapper(*a, **k):
            for _ in range(n): r = fn(*a, **k)
            return r
        return wrapper
    return deco

def retry(times=3, exceptions=(Exception,), delay=0.1):    # retry decorator
    def deco(fn):
        @functools.wraps(fn)
        def wrapper(*a, **k):
            for attempt in range(1, times + 1):
                try: return fn(*a, **k)
                except exceptions:
                    if attempt == times: raise
                    time.sleep(delay * 2 ** attempt)        # exponential backoff
        return wrapper
    return deco

def log_calls(fn):                                # logging decorator
    @functools.wraps(fn)
    def w(*a, **k):
        logging.info("call %s %s %s", fn.__name__, a, k); return fn(*a, **k)
    return w

def requires_role(role):                          # authorization decorator
    def deco(fn):
        @functools.wraps(fn)
        def w(user, *a, **k):
            if role not in user.get("roles", []): raise PermissionError("forbidden")
            return fn(user, *a, **k)
        return w
    return deco

def validate_types(**types):                      # parameter validation
    def deco(fn):
        @functools.wraps(fn)
        def w(**kw):
            for k, t in types.items():
                if not isinstance(kw[k], t): raise TypeError(f"{k} must be {t.__name__}")
            return fn(**kw)
        return w
    return deco

@timer
@repeat(2)               # applied first (bottom-up), timer wraps the result
def hello(name): print("hi", name)

@requires_role("admin")
def delete(user, item): return f"deleted {item}"
print(delete({"roles": ["admin"]}, "x"))
```
### 🏷️ Class decorators & on methods
```python
def singleton(cls):
    inst = {}
    @functools.wraps(cls, updated=())
    def get(*a, **k): return inst.setdefault(cls, cls(*a, **k))
    return get
@singleton
class Config: pass

class Calc:
    @staticmethod
    @timer                       # order: @staticmethod must be OUTER
    def add(a, b): return a + b
    @classmethod
    def make(cls): return cls()
    @property
    def pi(self): return 3.14
@functools.lru_cache(maxsize=128)     # memoization; fn.cache_info(), fn.cache_clear()
def sq(n): return n * n
```
### 🧩 Class-based decorator
```python
class CountCalls:
    def __init__(self, fn): functools.update_wrapper(self, fn); self.fn = fn; self.calls = 0
    def __call__(self, *a, **k): self.calls += 1; return self.fn(*a, **k)
```
### 🧭 Debugging tips
Check `fn.__wrapped__` · print the order of wrappers · forgetting to `return wrapper` → function becomes `None` · forgetting `()` on parametrized decorator (`@repeat` vs `@repeat(3)`).
### 🧭 Approaches to caching
manual dict · `lru_cache` ✅ · `cache` (unbounded) · `functools.cached_property` (per instance).

---

<a id="ch22"></a>
## 🧰 22. Python Built-in Functions — Master Reference  [⬆️ top](#top)

> 🎤 **Interview short note:** Know the *return types*: `map/filter/zip/reversed/enumerate/range` return **lazy iterables**; `sorted` returns a **list**; `sum/min/max` consume iterables; `round` uses banker's rounding; `eval`/`exec` on untrusted input = ⚠️ **arbitrary code execution**. Some "functions" (`int`, `str`, `list`, `type`, `super`, `property`) are really **classes**.

### A. 🧬 Type / object
```python
type(5); type("n", (), {})                       # 1-arg: class; 3-arg: dynamic class creation
isinstance(5, (int, str)); issubclass(bool, int)
id(x); callable(len); repr(x); str(x); ascii("é")   # '\xe9'
bool(0); int("5"); float("1.5"); complex(1, 2)
bytes(3); bytearray(b"ab"); memoryview(b"ab")
list("ab"); tuple([1]); set([1]); frozenset([1]); dict(a=1)
object()      # base class; useful as sentinel: _MISSING = object()
# classmethod / staticmethod / property / super -> see Ch 16
```
### B. 🔢 Numeric (+ modules)
```python
abs(-3); round(2.675, 2); pow(2, 3, 5); divmod(9, 4); sum([1, 2], start=10); min([], default=0); max(["a","bb"], key=len)
import math, statistics, random, decimal, fractions
math.sqrt(16); math.ceil(1.2); math.floor(1.8); math.trunc(-1.8)   # 4.0 2 1 -1
math.factorial(5); math.gcd(12, 18); math.lcm(4, 6); math.prod([2, 3]); math.comb(5, 2); math.perm(5, 2); math.isqrt(17)
math.log(8, 2); math.log10(100); math.exp(1); math.sin(math.radians(30)); math.degrees(math.pi)
math.isfinite(1); math.isinf(float("inf")); math.isnan(float("nan"))
statistics.mean([1, 2, 3]); statistics.median([1, 3, 2]); statistics.mode([1, 1, 2]); statistics.multimode([1, 1, 2, 2])
statistics.stdev([1, 2, 3]); statistics.variance([1, 2, 3]); statistics.pstdev([1, 2, 3]); statistics.pvariance([1, 2, 3])
statistics.quantiles([1, 2, 3, 4], n=4); statistics.correlation([1, 2, 3], [2, 4, 6]); statistics.linear_regression([1, 2, 3], [2, 4, 6])
random.seed(42); random.random(); random.randint(1, 6); random.randrange(0, 10, 2)
random.choice("abc"); random.choices("abc", k=5); random.sample(range(10), 3)
l = [1, 2, 3]; random.shuffle(l); random.uniform(1, 2); random.gauss(0, 1); random.normalvariate(0, 1)
st = random.getstate(); random.setstate(st)     # reproducible sequences
from decimal import Decimal, localcontext
with localcontext() as ctx: ctx.prec = 5; Decimal(1) / Decimal(3)
Decimal("2.345").quantize(Decimal("0.01"))      # rounding to cents
from fractions import Fraction; Fraction(0.333).limit_denominator(10)   # 1/3
```
> 🔐 For security tokens use `secrets`, **not** `random`.

### C. 🔁 Iteration / functional
```python
len([1]); list(range(0, 10, 3)); list(enumerate("ab", 1)); list(zip("ab", [1, 2, 3]))   # zip stops at shortest
from itertools import zip_longest; zip(*[(1, 2), (3, 4)])    # transpose; zip(strict=True) 3.10+
list(map(str.upper, "ab")); list(filter(None, [0, 1, ""]))   # filter(None) drops falsy
it = iter([1]); next(it, "end"); list(reversed([1, 2])); sorted("bca", reverse=True)
any([]); all([])       # False / True (empty!)
slice(1, 5, 2); [0, 1, 2, 3, 4, 5][slice(1, 5, 2)]
# aiter()/anext(): async iterator counterparts (3.10+) -> async for / await anext(ait)
```
### D. 🔤 String / formatting
`ord, chr, format(1234.5, ",.1f"), ascii, repr, str, bin, oct, hex` — see [Ch 6](#ch6).
### E. 📥📤 I/O
`print`, `input`, `open`, `help(len)`, `breakpoint()` (drops into `pdb`; disable with `PYTHONBREAKPOINT=0`).
### F. 🪞 Reflection
```python
dir(obj); vars(obj); globals(); locals()          # introspection
getattr(o, "x", None); setattr(o, "x", 1); hasattr(o, "x"); delattr(o, "x")
```
### G. ⚙️ Compile / exec  ⚠️
```python
eval("1 + 2")                     # expression -> value
exec("x = 5")                     # statements
code = compile("print(1)", "<s>", "exec"); exec(code)
__import__("math")                # prefer importlib.import_module
import ast; ast.literal_eval("[1, 2, {'a': 3}]")   # ✅ SAFE alternative for literals
```
**Never** `eval(input())` — attacker can run `__import__('os').system(...)`.
### H. 🧷 Other
`hash("a")` (strings are salted per process) · `id` · `callable` · `memoryview` · `object` · constants `None, True, False, NotImplemented` (return from `__eq__` to signal "not supported"), `Ellipsis` (`...`), `__debug__` (False under `-O`).

### 🧭 Approaches: transpose a matrix
`list(zip(*m))` ✅ · nested comprehension · NumPy `.T`.
### 🧭 Approaches: max by key
`max(items, key=...)` ✅ · `sorted(...)[-1]` (slower) · manual loop.
### ⚠️ Pitfalls
`round(2.5)==2` · `sum()` on strings errors (use `join`) · `min([])` raises unless `default` · `map` returns an iterator (wrap with `list`).

---

<a id="ch23"></a>
## 🏪 23. Essential Python Standard Library Modules  [⬆️ top](#top)

> 🎤 **Interview short note:** "Batteries included". Know **why** you'd pick each: `collections` (specialized containers), `itertools` (lazy combinatorics), `heapq` (priority queue), `bisect` (binary search on sorted), `pathlib` (paths), `logging` (not print), `subprocess` (run commands — avoid `shell=True` with user input), `threading` (I/O-bound), `multiprocessing` (CPU-bound, bypasses GIL), `asyncio` (many concurrent I/O tasks), `secrets` (crypto-safe), `hashlib` (SHA-256; MD5/SHA-1 are broken for security).

| Category | Modules | One-liner to remember |
|---|---|---|
| 🖥️ System & runtime | `sys, os, platform, site, sysconfig, atexit, warnings, traceback, inspect, gc` | `sys.argv`, `os.environ`, `inspect.signature(f)`, `atexit.register(cleanup)` |
| ⏰ Date/time | `datetime, time, calendar, zoneinfo` | see [Ch 25](#ch25) |
| 🧱 Data structures | `collections, array, heapq, bisect, queue, weakref` | `deque`, `heapq.heappush`, `bisect.insort` |
| ⚡ Functional | `itertools, functools, operator` | `operator.itemgetter`, `attrgetter` |
| 💾 Files & serialization | `pathlib, shutil, glob, fnmatch, tempfile, fileinput, pickle, json, csv, configparser, tomllib, shelve, sqlite3` | see [Ch 18](#ch18) |
| 📝 Text & parsing | `re, string, textwrap, unicodedata, difflib, codecs, html, html.parser, xml.etree.ElementTree, pprint` | `textwrap.dedent`, `difflib.get_close_matches` |
| 🌐 Networking | `socket, ssl, urllib, http, email, smtplib, imaplib, ftplib, ipaddress, xmlrpc` | `urllib.request.urlopen`, `ipaddress.ip_network` |
| 🧵 Concurrency | `threading, multiprocessing, concurrent.futures, subprocess, asyncio, signal, sched` | `ThreadPoolExecutor`, `asyncio.run` |
| 🔐 Security | `hashlib, hmac, secrets, ssl, getpass, uuid` | `secrets.token_hex(16)`, `hmac.compare_digest` |
| 🐞 Dev & debug | `logging, pdb, timeit, doctest, unittest, cProfile, pstats, tracemalloc, faulthandler` | `python -m timeit`, `cProfile.run` |

### 💻 Quick demos
```python
import heapq, bisect, queue, array, weakref, collections, operator
h = []; heapq.heappush(h, 3); heapq.heappush(h, 1); heapq.heappop(h)          # min-heap -> 1
heapq.nlargest(2, [5, 1, 9]); [(-x) for x in [1]]                             # max-heap trick: push -x
a = [1, 3, 5]; bisect.insort(a, 4); bisect.bisect_left(a, 3)
dq = collections.deque(maxlen=3); dq.extend(range(5))                        # keeps last 3
q = queue.Queue(); q.put(1); q.get(); array.array("i", [1, 2, 3])           # typed compact array
class Obj: pass
o = Obj(); r = weakref.ref(o); del o; print(r())                            # None (collected)

import logging
logging.basicConfig(level=logging.INFO, format="%(asctime)s %(levelname)s %(message)s")
logging.getLogger(__name__).info("hello")

import subprocess
r = subprocess.run(["ls", "-l"], capture_output=True, text=True, check=True)   # list args, no shell ✅

from concurrent.futures import ThreadPoolExecutor, ProcessPoolExecutor
with ThreadPoolExecutor(4) as ex: list(ex.map(lambda x: x*2, range(5)))

import asyncio
async def work(n): await asyncio.sleep(0.1); return n
async def main(): return await asyncio.gather(*(work(i) for i in range(3)))
print(asyncio.run(main()))

import hashlib, hmac, secrets, uuid, timeit, sqlite3, textwrap, difflib, pprint
hashlib.sha256(b"x").hexdigest(); secrets.token_urlsafe(16); uuid.uuid4()
hmac.compare_digest("a", "b")                  # constant-time compare
timeit.timeit("sum(range(100))", number=1000)
con = sqlite3.connect(":memory:"); con.execute("CREATE TABLE t(x)"); con.execute("INSERT INTO t VALUES (?)", (1,))  # ✅ parameterized
difflib.get_close_matches("appel", ["apple", "ape"])
```
### 🧭 Threading vs multiprocessing vs asyncio
| Workload | Best | Why |
|---|---|---|
| Network/disk I/O, few tasks | `threading` | GIL released while waiting |
| Many I/O tasks (10k sockets) | `asyncio` | lightweight coroutines |
| CPU-bound | `multiprocessing` / `ProcessPoolExecutor` | separate GILs |

### ⚠️ Pitfalls
`print` instead of `logging` in libraries · `pickle` from untrusted source · `shell=True` + user input = command injection · string-formatted SQL = SQL injection · `random` for passwords.

---

<a id="ch24"></a>
## 🕵️ 24. Regular Expressions (Regex)  [⬆️ top](#top)

> 🎤 **Interview short note:** Always use **raw strings** `r"..."`. `match` anchors at start; `fullmatch` requires entire string; `search` scans anywhere. Quantifiers are **greedy** by default — add `?` for lazy. Use `re.compile` for reuse. Beware **ReDoS** (catastrophic backtracking with nested quantifiers like `(a+)+$`). Don't parse HTML/nested structures with regex.

### 📖 Syntax cheat sheet
| Token | Meaning | Token | Meaning |
|---|---|---|---|
| `.` | any char except `\n` | `\d \D` | digit / non-digit |
| `\w \W` | word / non-word | `\s \S` | whitespace / non-whitespace |
| `^ $` | start / end (line with MULTILINE) | `\A \Z` | absolute start / end |
| `* + ?` | 0+, 1+, 0-or-1 | `{m,n}` | m to n |
| `*? +? ??` | lazy versions | `[a-z]` `[^a-z]` | set / negated |
| `a\|b` | alternation | `(...)` | capture group |
| `(?P<n>...)` | named group | `(?:...)` | non-capturing |
| `(?=x)` `(?!x)` | lookahead pos/neg | `(?<=x)` `(?<!x)` | lookbehind pos/neg |

### 💻 Examples
```python
import re
text = "Call 555-1234 or 555-9876. Email: a.b@x.com"
re.match(r"Call", text); re.search(r"\d{3}-\d{4}", text).group()   # '555-1234'
re.fullmatch(r"\d+", "123")
re.findall(r"\d{3}-\d{4}", text); [m.span() for m in re.finditer(r"\d+", text)]
re.sub(r"\d", "#", text); re.subn(r"\d", "#", "a1b2")             # ('a#b#', 2)
re.split(r"[,;]\s*", "a, b;c"); re.escape("a.b*c")                  # 'a\\.b\\*c'
m = re.search(r"(?P<user>[\w.]+)@(?P<dom>[\w.]+)", text); m["user"], m.groupdict()
re.sub(r"(\w+) (\w+)", r"\2 \1", "hello world")                      # backrefs -> 'world hello'
re.findall(r"<.+?>", "<a><b>")                                       # lazy -> ['<a>', '<b>']
re.findall(r"\w+(?=!)", "hi! yo")                                    # lookahead -> ['hi']
re.findall(r"(?<=\$)\d+", "$10 $20")                                 # lookbehind -> ['10','20']
pat = re.compile(r"""
    ^(?P<year>\d{4})-(?P<mon>\d{2})-(?P<day>\d{2})$    # ISO date
""", re.VERBOSE | re.IGNORECASE)
print(pat.match("2026-10-14").groupdict())
re.findall(r"^\w+", "a b\nc d", re.MULTILINE); re.search(r"a.b", "a\nb", re.DOTALL)
```
### ✅ Validation patterns (starter-level)
```python
EMAIL = r"^[\w.+-]+@[\w-]+(\.[\w-]+)+$"
PHONE = r"^\+?\d{1,3}[\s-]?\d{10}$"
URL   = r"^https?://[\w.-]+(?:/[\w./?%&=-]*)?$"
PASSWORD = r"^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[^\w\s]).{8,}$"    # lookaheads = rules
```
⚠️ Email regex can never be fully RFC-correct → send a verification mail in production.
### 🧭 Approaches: extract info
`str` methods (`split`, `partition`, `in`) for simple cases → `re` for patterns → parser (`json`, `html.parser`, BeautifulSoup) for structured data.
### ⚠️ Pitfalls
`re.match` vs `search` confusion · forgetting raw string · greedy `.*` eating too much · `\d` matches Unicode digits (use `re.ASCII`) · ReDoS on user input.

---

<a id="ch25"></a>
## ⏰ 25. Date and Time Programming  [⬆️ top](#top)

> 🎤 **Interview short note:** **Naive** datetimes have no tzinfo; **aware** ones do. Store/transport in **UTC**, convert to local for display. Use `zoneinfo.ZoneInfo` (3.9+) not manual offsets, to handle **DST**. `datetime.now(timezone.utc)` instead of deprecated `utcnow()`. Use `time.perf_counter()` for measuring durations; `time.time()` for Unix timestamps. Subtracting datetimes gives `timedelta`.

```python
from datetime import date, time, datetime, timedelta, timezone
from zoneinfo import ZoneInfo
import time as t, calendar

d = date(2026, 10, 14); tm = time(16, 30); dt = datetime(2026, 10, 14, 16, 30)
now_utc = datetime.now(timezone.utc)
ist = now_utc.astimezone(ZoneInfo("Asia/Kolkata"))          # UTC -> local
ny  = datetime(2026, 3, 8, 1, 30, tzinfo=ZoneInfo("America/New_York"))   # DST-aware

dt.strftime("%Y-%m-%d %H:%M:%S %A %b %p")                    # format -> string
datetime.strptime("14/10/2026 16:30", "%d/%m/%Y %H:%M")      # parse <- string
dt.isoformat(); datetime.fromisoformat("2026-10-14T16:30:00+05:30")   # ISO 8601 ✅ for APIs

dt + timedelta(days=30, hours=2); dt - datetime(2026, 1, 1)   # arithmetic -> timedelta
(dt - datetime(2026, 1, 1)).days; (d2 := date(2026, 12, 25)) > d    # comparison (don't mix naive & aware!)
dt.timestamp(); datetime.fromtimestamp(0, tz=timezone.utc)     # Unix time

start = t.perf_counter(); t.sleep(0.1); print(t.perf_counter() - start)  # duration
print(calendar.month(2026, 10)); calendar.isleap(2028); calendar.monthrange(2026, 2)   # (weekday_of_1st, days)

# recurring schedule: every Monday for 4 weeks
def next_mondays(start, n):
    d = start + timedelta(days=(7 - start.weekday()) % 7)
    return [d + timedelta(weeks=i) for i in range(n)]
```
### 🧭 Approaches: age calculation
```python
def age(b, today=None):
    today = today or date.today()
    return today.year - b.year - ((today.month, today.day) < (b.month, b.day))   # ✅ exact
# (today - b).days // 365  ← off by leap days
```
### 🧭 Approaches: APIs/databases
Send **ISO 8601 UTC** strings or epoch ints · store as `TIMESTAMP WITH TIME ZONE` · convert at the edges (UI).
### ⚠️ Pitfalls
Naive/aware comparison → `TypeError` · `%y` vs `%Y` · `datetime.now()` is local, not UTC · month arithmetic needs `dateutil.relativedelta` (timedelta has no months) · DST gaps/overlaps · `time.sleep` blocks the thread.

---

<a id="ch26"></a>
## ⌨️ 26. Command-Line Programming and Configuration  [⬆️ top](#top)

> 🎤 **Interview short note:** `sys.argv[0]` is the script name. Use **`argparse`** for parsing, help text, validation and subcommands. Config precedence (typical): **CLI flags > environment variables > config file > defaults**. Exit code **0 = success**, non-zero = failure (`sys.exit(1)`). Send errors to **stderr**, results to **stdout** (pipe-friendly). Never hardcode secrets — use env vars/.env (git-ignored).

```python
# cli.py
import argparse, os, sys, json, logging

def build_parser():
    p = argparse.ArgumentParser(description="Demo tool", prog="demo")
    p.add_argument("path")                                     # required positional
    p.add_argument("-n", "--count", type=int, default=1)       # optional
    p.add_argument("-v", "--verbose", action="store_true")     # flag
    p.add_argument("--mode", choices=["fast", "slow"], required=True)
    sub = p.add_subparsers(dest="cmd")                         # subcommands (git-style)
    add = sub.add_parser("add"); add.add_argument("item")
    return p

def main(argv=None):
    args = build_parser().parse_args(argv)
    logging.basicConfig(level=logging.DEBUG if args.verbose else logging.INFO)
    token = os.environ.get("API_TOKEN")                        # env var (None if unset)
    if not token:
        print("API_TOKEN missing", file=sys.stderr); return 2
    print(json.dumps({"path": args.path, "count": args.count}))
    return 0

if __name__ == "__main__":
    sys.exit(main())                                           # python cli.py a.txt --mode fast -v
```
```python
# Config files
import json, tomllib, configparser
cfg = json.load(open("c.json"))
with open("c.toml", "rb") as f: toml = tomllib.load(f)
ini = configparser.ConfigParser(); ini.read("c.ini")
# .env files: pip install python-dotenv ->  from dotenv import load_dotenv; load_dotenv()
```
**Interactive CLI:** `input()` loops, `getpass.getpass()` for passwords. **Progress bars:** `tqdm` (`for x in tqdm(items)`). **Alt frameworks:** `click`, `typer` (type-hint based). **Background/scheduling:** `cron`/systemd/Task Scheduler, `sched`, `threading.Timer`, APScheduler, Celery for distributed jobs.
**Logging config:** `logging.basicConfig(...)`, handlers (`FileHandler`, `RotatingFileHandler`), levels DEBUG<INFO<WARNING<ERROR<CRITICAL.

### 🧭 Approaches: parse arguments
`sys.argv` manual (tiny scripts) · `argparse` ✅ (stdlib) · `click`/`typer` (nicer DX) · `docopt`.
### ⚠️ Pitfalls
`os.environ["X"]` KeyError vs `.get` · all env values are strings (`"false"` is truthy!) · committing `.env` · not returning proper exit codes in CI.

---

<a id="ch27"></a>
## 🏷️ 27. Python Type Hints and Static Typing  [⬆️ top](#top)

> 🎤 **Interview short note:** Type hints are **not enforced at runtime** — they serve checkers (**mypy**, **Pyright**), IDEs and docs. Modern syntax: `list[int]`, `dict[str, int]`, `int | None` (3.10+), `X | Y` replaces `Union`. **Static checking** finds bugs before running; **runtime validation** (pydantic, manual checks) validates actual external data. `Protocol` = structural typing; `TypeVar`/`Generic` = reusable typed containers.

```python
from typing import (Any, Never, NoReturn, Literal, TypedDict, TypeAlias, Callable, Protocol,
                    TypeVar, Generic, ParamSpec, Annotated, TypeGuard, Self, Iterable, Iterator, Optional, Union)
from collections.abc import Sequence

age: int = 3; names: list[str] = []; scores: dict[str, int] = {}; pt: tuple[int, int] = (1, 2)
ids: set[int] = set(); fz: frozenset[str] = frozenset(); items: Iterable[int] = [1]
def find(x: int) -> int | None: ...                 # Optional[int] == int | None
def fail(msg: str) -> NoReturn: raise RuntimeError(msg)   # never returns
def f(x: Any) -> None: ...                           # opt-out of checking

Mode = Literal["r", "w"]                             # only these values
class User(TypedDict): name: str; age: int           # typed dict shape
Json: TypeAlias = dict[str, "Json"] | list["Json"] | str | int | None
Handler = Callable[[int, str], bool]

class SupportsClose(Protocol):                       # structural typing
    def close(self) -> None: ...

T = TypeVar("T")
def first(xs: Sequence[T]) -> T: return xs[0]        # generic function (3.12: def first[T](xs: Sequence[T]) -> T)
class Box(Generic[T]):                               # generic class
    def __init__(self, v: T) -> None: self.v = v
    def get(self) -> T: return self.v
P = ParamSpec("P")
def logged(fn: Callable[P, T]) -> Callable[P, T]: ...    # typed decorators preserve signature

class Builder:
    def set(self, v: int) -> Self: return self        # fluent API returns same subtype
def is_str_list(v: list[object]) -> TypeGuard[list[str]]: return all(isinstance(x, str) for x in v)
Meters = Annotated[float, "unit: meters"]            # metadata for tools (pydantic, FastAPI)
class Node:
    def nxt(self) -> "Node | None": ...              # forward reference (or `from __future__ import annotations`)
```
**Variance (concept):** `list[Dog]` is **not** a `list[Animal]` (invariant, because mutable); `Sequence[Dog]` **is** a `Sequence[Animal]` (covariant, read-only); `Callable` is contravariant in its parameters.
**TypeIs** (3.13): like `TypeGuard` but also narrows the negative branch.
**Tools:** `pip install mypy` → `mypy --strict app.py` · Pyright/Pylance in VS Code.
**Typed APIs / DTOs:** `@dataclass`, `TypedDict`, **Pydantic** models (runtime validation + serialization), FastAPI uses hints to build validated endpoints and OpenAPI docs.
```python
from dataclasses import dataclass
@dataclass(frozen=True, slots=True)
class UserDTO: id: int; email: str          # simple typed DTO
```
### 🧭 Approaches: gradual typing
Start with public function signatures → enable `mypy` on new modules → tighten with `--strict`.
### ⚠️ Pitfalls
Thinking hints validate input · `Optional[X]` means "can be None", **not** "optional argument" · mutable defaults still bad · `Any` silently disables checking · import cycles from annotations (use `TYPE_CHECKING` guard).

---

<a id="ch28"></a>
## 🧠 28. Python Memory Management and Internals  [⬆️ top](#top)

> 🎤 **Interview short note:** CPython memory = **reference counting** (immediate free at 0) + **cyclic garbage collector** (generational, handles reference cycles). Variables are **names → objects**. The **GIL** lets only one thread execute Python bytecode at a time → threads don't speed up CPU-bound code (use processes). Python 3.13+ has an experimental **free-threaded** (no-GIL) build. `copy.copy` = shallow, `copy.deepcopy` = recursive.

```python
import sys, gc, copy, weakref, tracemalloc, dis

a = [1, 2]; b = a
print(sys.getrefcount(a), a is b, id(a) == id(b))      # count is +1 (argument temp ref)
del b                                                    # decrement; object freed at 0

# reference cycle -> needs GC
class N: pass
x, y = N(), N(); x.o, y.o = y, x; del x, y
print(gc.collect(), gc.get_threshold(), gc.get_count())  # unreachable objects collected; gen0/1/2 thresholds

# weak references don't keep object alive
class Cache: pass
c = Cache(); w = weakref.ref(c); del c; print(w())      # None
d = weakref.WeakValueDictionary()                        # cache without leaks

# shallow vs deep
orig = [[1], [2]]; s = copy.copy(orig); dp = copy.deepcopy(orig)
orig[0].append(9); print(s[0], dp[0])                    # [1, 9] [1]

# interning / identity quirks
print(256 is 256, "hello" is "hello")                    # True (small int/ident-like str cached) — don't rely on it!
a1 = "hello world"; b1 = "hello world"; sys.intern(a1) is sys.intern(b1)   # True – force interning

# memory profiling
tracemalloc.start(); big = [i for i in range(100_000)]
cur, peak = tracemalloc.get_traced_memory(); print(cur, peak)
snap = tracemalloc.take_snapshot(); print(snap.statistics("lineno")[:1])
print(sys.getsizeof([]), sys.getsizeof(big))             # shallow size only

# bytecode / code objects / frames
def add(p, q): return p + q
dis.dis(add)                                             # LOAD_FAST, BINARY_OP, RETURN_VALUE...
print(add.__code__.co_varnames, add.__code__.co_consts, add.__code__.co_code[:4])
import inspect; print(inspect.currentframe().f_lineno)    # frame object: locals, globals, back-pointer
```
### 🧩 Execution model
1. Source → tokens → **AST** → **bytecode** (code object). 2. PVM (eval loop) runs bytecode with a **frame** per call (stack of frames = call stack). 3. Function objects bundle code + globals + defaults + closure.
### 🔒 The GIL
Protects CPython's reference counts from race conditions. **Released** during blocking I/O and in many C extensions (NumPy) → threads still useful for I/O. For CPU work: `multiprocessing`, C extensions, `concurrent.futures.ProcessPoolExecutor`, or free-threaded builds.
### 🪶 Memory-efficient processing
Generators over lists · `__slots__` · `array`/NumPy for numeric arrays · stream files line by line · chunked reads · `itertools` · `sys.intern` for many duplicate strings · pandas `category` dtype · `memoryview` for zero-copy slices.
### 🐍 Implementations
| Impl | Notes |
|---|---|
| **CPython** | reference; ref-count + GC; GIL; C-extension friendly |
| **PyPy** | JIT → often 4-10× faster for pure-Python loops; different GC; weaker C-ext compatibility |
| **Jython / IronPython** | JVM / .NET integration (lag behind versions) |
| **MicroPython** | microcontrollers |
| **Cython / Numba / mypyc** | compile Python-like code to C/machine code |

### 🧭 Approaches: find a memory leak
`tracemalloc` snapshots diff · `gc.get_objects()` counts · `objgraph` · look for unbounded caches/global lists, cycles with `__del__`, lingering closures/callbacks.
### ⚠️ Pitfalls
Relying on `is` for equality · `__del__` timing is not guaranteed · `sys.getsizeof` ignores referenced objects · deep recursion in `deepcopy` of cyclic structures is handled, but custom `__deepcopy__` mistakes leak shared state.

---

<a id="rapid"></a>
# 🔥 Top 40 Interview Rapid-Fire  [⬆️ top](#top)

| # | Question | ⚡ One-line answer |
|---|---|---|
| 1 | Is Python compiled or interpreted? | Compiled to bytecode, then interpreted by the PVM. |
| 2 | `list` vs `tuple`? | Mutable vs immutable (tuple hashable if items are). |
| 3 | `is` vs `==`? | Identity vs value equality. |
| 4 | Mutable default args? | Evaluated once; use `None` sentinel. |
| 5 | What is the GIL? | Mutex allowing one thread to run bytecode at a time in CPython. |
| 6 | `*args` / `**kwargs`? | Collect extra positional (tuple) / keyword (dict) arguments. |
| 7 | Shallow vs deep copy? | Shallow copies container only; deep copies nested objects recursively. |
| 8 | What are decorators? | Callables that wrap functions/classes to add behavior. |
| 9 | Generator vs iterator? | Generator is an iterator created via `yield`; lazy, one-shot. |
| 10 | `__init__` vs `__new__`? | `__new__` creates the instance, `__init__` initializes it. |
| 11 | What is MRO? | Method lookup order from C3 linearization (`Class.__mro__`). |
| 12 | `@staticmethod` vs `@classmethod`? | No implicit arg vs receives `cls`. |
| 13 | `__str__` vs `__repr__`? | Readable vs unambiguous/debug. |
| 14 | How does Python manage memory? | Ref counting + generational cyclic GC. |
| 15 | What is `LEGB`? | Local, Enclosing, Global, Built-in scope resolution. |
| 16 | `global` vs `nonlocal`? | Module-level binding vs enclosing-function binding. |
| 17 | What is a closure? | Inner function retaining outer variables. |
| 18 | List comprehension vs generator expression? | Eager list vs lazy iterator. |
| 19 | `append` vs `extend`? | Add one element vs add each element of an iterable. |
| 20 | `remove` vs `pop` vs `del`? | By value vs by index (returns) vs by index/slice (no return). |
| 21 | Is dict ordered? | Yes, insertion order guaranteed since 3.7. |
| 22 | Why are dict lookups fast? | Hash table, O(1) average. |
| 23 | What types can be dict keys? | Hashable (immutable-like) objects. |
| 24 | What is duck typing? | Behavior over declared type. |
| 25 | `with` statement? | Context manager protocol `__enter__/__exit__` for cleanup. |
| 26 | `try/else/finally`? | else = no error; finally = always. |
| 27 | What is `pass`? | No-op placeholder. |
| 28 | What is PEP 8? | Python style guide (4 spaces, snake_case, 79-99 col). |
| 29 | `range` in Py3? | Lazy immutable sequence, O(1) membership for ints. |
| 30 | How to make a class immutable? | `frozen=True` dataclass, `__slots__`+properties, NamedTuple. |
| 31 | `sort` vs `sorted`? | In-place returning `None` vs new list; both stable. |
| 32 | `threading` vs `multiprocessing`? | I/O-bound vs CPU-bound (bypasses GIL). |
| 33 | What is `asyncio`? | Single-thread cooperative concurrency with `async/await`. |
| 34 | What is monkey patching? | Changing classes/modules at runtime (use sparingly/tests). |
| 35 | `__slots__` purpose? | Save memory, restrict attributes. |
| 36 | `lambda` limits? | Single expression only. |
| 37 | Is Python pass-by-value or reference? | Pass-by-object-reference (assignment semantics). |
| 38 | What is a virtual env? | Isolated interpreter + packages per project. |
| 39 | `eval` danger? | Executes arbitrary code; use `ast.literal_eval`. |
| 40 | `==` on floats? | Use `math.isclose` / `Decimal`. |

### 🏋️ Coding questions to practice (with the approach cheat)
1. **Two Sum** → hash map O(n). 2. **Valid parentheses** → stack. 3. **Anagram groups** → `defaultdict(list)` keyed by `tuple(sorted(w))`. 4. **LRU cache** → `OrderedDict` / `functools.lru_cache`. 5. **Merge intervals** → sort + sweep. 6. **Reverse linked list** → iterative 3-pointer. 7. **Flatten nested list** → recursion/generator `yield from`. 8. **Fibonacci** → memo/iterative. 9. **Longest substring w/o repeat** → sliding window + set/dict. 10. **Top-K frequent** → `Counter.most_common(k)` or `heapq.nlargest`.

---

<a id="cheat"></a>
# 🧾 Final Cheat Sheet  [⬆️ top](#top)

```text
🧱 Immutable : int float complex bool str bytes tuple frozenset range NoneType
🔧 Mutable   : list dict set bytearray (+ most user classes)
⏱️ Big-O     : list[i] O(1) | list.append O(1)* | list.insert(0)/pop(0)/in O(n)
               dict/set get,set,in O(1) avg | sort O(n log n) | deque ends O(1)
🔍 Scope     : L → E → G → B
🎯 Falsy     : False None 0 0.0 0j "" [] () {} set() range(0)
🧬 MRO       : Class.__mro__ / Class.mro()
🧹 Safe code : with-statement · specific except · f-strings · pathlib · logging · venv · type hints
⚠️ Never     : bare except · mutable defaults · eval(untrusted) · pickle.load(untrusted) · shell=True+user input
```

> 🎉 **You made it!** If you can explain each 🎤 *Interview short note* from memory and code the examples without peeking — you're interview-ready. Now go break production… *responsibly* 😎🐍

[⬆️ Back to the top](#top)
