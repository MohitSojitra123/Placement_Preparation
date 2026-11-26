# 🐍🎉 The Ultimate Python Interview Bible 🎉🐍

> 🤪 *"I don't always test my code, but when I do, I do it in production."* — Nobody smart 😅

**How to read this guide** 📖
- 🧒 **Simple** = explained like you're 10 years old
- 💻 **Example** = tiny code you can run
- 🎯 **Interview** = what the interviewer wants to hear (sound smart 😎)

**Total questions covered: 500** 🚀 (none skipped, promise! 🤞)

---

# 🌱 SECTION 1: Python Basics, Variables & Operators

### 1️⃣ What is Python and what are its key features? 🐍
🧒 **Simple:** Python is an easy-to-read programming language, like writing English instructions for the computer. 🗣️
💻 **Example:**
```python
print("Hello, World! 🌍")
```
🎯 **Interview:** Python is a high-level, interpreted, dynamically typed, garbage-collected, multi-paradigm (OOP, functional, procedural) language. Key features: readable syntax, huge standard library ("batteries included"), cross-platform, large ecosystem (NumPy, Django, etc.), extensible with C.

### 2️⃣ Is Python a compiled or interpreted language? 🤔
🧒 **Simple:** Both! 🎭 Python first turns your code into "bytecode" (a mini-language), then a virtual machine runs it line by line.
💻 **Example:**
```python
import dis
dis.dis(lambda x: x + 1)   # see the bytecode 👀
```
🎯 **Interview:** The "compiled vs interpreted" label belongs to the implementation, not the language. CPython compiles source to bytecode (`.pyc`) then interprets it in the PVM. PyPy adds a JIT; Cython compiles to C.

### 3️⃣ What is the difference between Python 2 and Python 3? 👴👶
🧒 **Simple:** Python 3 is the modern, fixed version. Python 2 is the retired grandpa (ended 2020). 🪦
💻 **Example:**
```python
# Py2: print "hi"      5/2 -> 2
# Py3: print("hi")     5/2 -> 2.5
```
🎯 **Interview:** `print` is a function; `/` is true division; all strings are Unicode (`str`) with separate `bytes`; `range` is lazy; iterators replace lists in `map/filter/zip`; `input()` replaces `raw_input()`; better exception chaining; `async/await`, f-strings, type hints only in Py3.

### 4️⃣ What are Python PEPs and why are they important? 📜
🧒 **Simple:** PEP = "Python Enhancement Proposal" — a written suggestion to improve Python, like a suggestion box for the language. 📮
💻 **Example:** PEP 8 (style guide), PEP 20 (`import this` → Zen of Python 🧘).
```python
import this
```
🎯 **Interview:** PEPs are the official design documents for new features, processes and conventions. They document rationale and decisions (e.g., PEP 8 style, PEP 484 type hints, PEP 3156 asyncio, PEP 572 walrus `:=`). Knowing them shows you follow the community's standards.

### 5️⃣ How is memory managed in Python? 🧠
🧒 **Simple:** Python cleans up its own room! 🧹 It counts who's using each object and throws away what nobody uses.
💻 **Example:**
```python
a = [1, 2, 3]
b = a          # refcount = 2
del a          # refcount = 1 (still alive)
del b          # refcount = 0 -> freed 🗑️
```
🎯 **Interview:** CPython uses a private heap, `pymalloc` for small objects, **reference counting** as the primary mechanism, plus a **generational cyclic garbage collector** for reference cycles. Programmers don't manually free memory.

### 6️⃣ What is the Global Interpreter Lock (GIL)? 🔒
🧒 **Simple:** Imagine one bathroom key 🔑 for a whole office — only one thread can run Python code at a time.
💻 **Example:**
```python
import threading
# Two CPU-heavy threads won't run Python bytecode truly in parallel in CPython
```
🎯 **Interview:** The GIL is a mutex in CPython that allows only one thread to execute bytecode at a time, protecting reference counts from race conditions. It hurts CPU-bound multithreading but not I/O-bound work (GIL released during I/O). Workarounds: `multiprocessing`, C extensions, asyncio. Note: Python 3.13 introduced an experimental free-threaded build (PEP 703).

### 7️⃣ What is dynamic typing in Python? 🎭
🧒 **Simple:** You don't tell Python what type a variable is; it figures it out while running. A variable is like a sticky note 📝 that can be moved to any object.
💻 **Example:**
```python
x = 10        # int
x = "ten"     # now a str, no problem 😎
```
🎯 **Interview:** Types are bound to objects, not names, and checked at runtime. Pros: flexibility, faster dev. Cons: runtime type errors → mitigated with type hints + mypy. Python is dynamically **and strongly** typed (`"1"+1` raises `TypeError`).

### 8️⃣ What is duck typing in Python? 🦆
🧒 **Simple:** "If it walks like a duck and quacks like a duck, it's a duck!" 🦆 Python cares what an object *can do*, not what it *is*.
💻 **Example:**
```python
class Duck:  
    def speak(self): return "Quack 🦆"
class Robot: 
    def speak(self): return "Beep 🤖"
for x in (Duck(), Robot()): print(x.speak())
```
🎯 **Interview:** Behavior-based polymorphism—no common base class needed. Follows EAFP ("easier to ask forgiveness than permission"). Formalized optionally by `typing.Protocol` for static checkers.

### 9️⃣ How do you find the data type of a variable in Python? 🔍
🧒 **Simple:** Ask Python "what are you?" using `type()`.
💻 **Example:**
```python
x = 3.14
print(type(x))              # <class 'float'>
print(isinstance(x, float)) # True ✅
```
🎯 **Interview:** Prefer `isinstance()` over `type() ==` because it respects inheritance and supports tuples of types.

### 🔟 What are built-in data types in Python? 📦
🧒 **Simple:** The ready-made boxes Python gives you for storing stuff.
💻 **Example:**
```python
42, 3.14, 2+3j, "hi", True, None,
[1,2], (1,2), {1,2}, {"a":1}, b"bytes", frozenset({1})
```
🎯 **Interview:** Numeric (`int, float, complex`), sequence (`str, list, tuple, range, bytes, bytearray`), mapping (`dict`), set (`set, frozenset`), boolean (`bool`), and `NoneType`.

### 1️⃣1️⃣ What is the difference between mutable and immutable objects? 🧊🔥
🧒 **Simple:** Mutable = playdough you can reshape 🔥. Immutable = a stone statue 🗿 — to change it you make a new one.
💻 **Example:**
```python
l = [1]; l.append(2)   # same list changed ✅
s = "hi"; s += "!"     # NEW string created
```
🎯 **Interview:** Immutable objects have fixed state after creation → hashable (if contents are), thread-safe, usable as dict keys. Mutable objects can change in place → beware aliasing bugs and mutable default arguments.

### 1️⃣2️⃣ Give examples of mutable and immutable data types. 🧾
🧒 **Simple:** Lists, dicts, sets = squishy. Numbers, strings, tuples = hard.
💻 **Example:**
```python
mutable   = [list, dict, set, bytearray]
immutable = [int, float, str, tuple, frozenset, bytes, bool]
```
🎯 **Interview:** Gotcha: a tuple is immutable but can contain a mutable list → `t = ([1],); t[0].append(2)` works. That's *shallow* immutability.

### 1️⃣3️⃣ How does assignment work with mutable objects in Python? 🔗
🧒 **Simple:** `b = a` doesn't copy the cake 🍰, it gives you a second name for the *same* cake.
💻 **Example:**
```python
a = [1, 2]
b = a
b.append(3)
print(a)   # [1, 2, 3] 😱
```
🎯 **Interview:** Assignment binds a name to an object reference (no copy). Use `.copy()`, `list(a)`, `a[:]` (shallow) or `copy.deepcopy()` for independent copies. Python is "pass by object reference".

### 1️⃣4️⃣ What are local and global variables in Python? 🏠🌍
🧒 **Simple:** Local = lives inside a function (private room). Global = lives outside (the whole house).
💻 **Example:**
```python
x = "global 🌍"
def f():
    x = "local 🏠"
    print(x)
f(); print(x)
```
🎯 **Interview:** Governed by LEGB scope. Assignment inside a function makes the name local by default. Minimize globals — they hurt testability and thread safety.

### 1️⃣5️⃣ What is the `global` keyword used for? 🌐
🧒 **Simple:** It says "hey, I want to change the *outside* variable, not make a new one!"
💻 **Example:**
```python
count = 0
def inc():
    global count
    count += 1
inc(); print(count)  # 1
```
🎯 **Interview:** Required to *rebind* a module-level name inside a function. Not needed just to read or mutate (e.g., `lst.append`). Overuse = code smell.

### 1️⃣6️⃣ What is the `nonlocal` keyword used for? 🪆
🧒 **Simple:** Like `global` but for the *nearby* outer function — the one wrapping you.
💻 **Example:**
```python
def outer():
    n = 0
    def inner():
        nonlocal n
        n += 1
        return n
    return inner
c = outer(); c(); print(c())  # 2
```
🎯 **Interview:** Rebinds a variable in the nearest enclosing (non-global) scope. Essential for stateful closures/decorators.

### 1️⃣7️⃣ How do you write comments in Python? 💬
🧒 **Simple:** Start a line with `#` — Python ignores it, it's a note for humans. 🙈
💻 **Example:**
```python
# single line comment
x = 5  # inline comment
```
🎯 **Interview:** No true multi-line comment syntax; people use consecutive `#` lines (triple-quoted strings not assigned are just discarded string expressions). Good comments explain *why*, not *what*.

### 1️⃣8️⃣ What are docstrings in Python? 📚
🧒 **Simple:** A description written inside a function/class/module that tells people what it does.
💻 **Example:**
```python
def add(a, b):
    """Return the sum of a and b."""
    return a + b
print(add.__doc__)
help(add)
```
🎯 **Interview:** String literal as the first statement, stored in `__doc__`, accessible via `help()`. Used by Sphinx, IDEs, and doctest. Styles: Google, NumPy, reST (PEP 257).

### 1️⃣9️⃣ How do you check the version of Python installed? 🔢
🧒 **Simple:** Ask Python its age! 🎂
💻 **Example:**
```bash
python --version
```
```python
import sys; print(sys.version_info)
```
🎯 **Interview:** `sys.version_info` is great for compatibility checks: `if sys.version_info >= (3, 10): ...`.

### 2️⃣0️⃣ What is an indentation error in Python? 😵
🧒 **Simple:** Python uses spaces to know which lines belong together. Wrong spaces = Python gets confused. 🤷
💻 **Example:**
```python
def f():
print("oops")   # IndentationError: expected an indented block
```
🎯 **Interview:** Indentation defines blocks (no braces). Don't mix tabs and spaces (`TabError`). PEP 8: 4 spaces. Use an editor/formatter (black/ruff).

### 2️⃣1️⃣ How does Python handle integer overflow? 🎈
🧒 **Simple:** It doesn't! Python integers grow as big as your memory allows. 🎈➡️🌌
💻 **Example:**
```python
print(2 ** 1000)   # huge, works fine 😎
```
🎯 **Interview:** `int` has arbitrary precision. Overflow only occurs in fixed-width types like NumPy `int64` or `ctypes`. Cost: big ints are slower and use more memory.

### 2️⃣2️⃣ What is the difference between `/` and `//` operators? ➗
🧒 **Simple:** `/` gives the exact answer with decimals. `//` chops off the decimals (floor).
💻 **Example:**
```python
print(7 / 2)     # 3.5
print(7 // 2)    # 3
print(-7 // 2)   # -4  (floors toward -infinity!) 😮
```
🎯 **Interview:** `/` is true division (always float). `//` is floor division—rounds toward negative infinity, not zero. Relation: `a == (a//b)*b + a%b`.

### 2️⃣3️⃣ What is the modulus operator (`%`) used for? 🍕
🧒 **Simple:** It gives the leftover after dividing — pizza slices left over 🍕.
💻 **Example:**
```python
print(10 % 3)   # 1
print(7 % 2 == 0)  # even/odd check
```
🎯 **Interview:** Use cases: even/odd, circular indexing, clock arithmetic, hashing. Result takes the sign of the divisor in Python (`-7 % 3 == 2`), unlike C.

### 2️⃣4️⃣ What is the exponentiation operator in Python? 🚀
🧒 **Simple:** `**` means "to the power of".
💻 **Example:**
```python
print(2 ** 10)       # 1024
print(pow(2, 10, 7)) # modular exponent = 2
```
🎯 **Interview:** `**` is right-associative (`2**3**2 == 512`). `pow(a, b, mod)` is efficient modular exponentiation. `^` is XOR, not power!

### 2️⃣5️⃣ How do you swap two variables without a temporary variable? 🔄
🧒 **Simple:** Python lets you swap in one line like magic. ✨
💻 **Example:**
```python
a, b = 1, 2
a, b = b, a
print(a, b)  # 2 1
```
🎯 **Interview:** Uses tuple packing/unpacking: RHS tuple is built first, then unpacked. No temp variable needed (internally it's a stack rotate).

### 2️⃣6️⃣ What are membership operators in Python? 🎟️
🧒 **Simple:** `in` / `not in` — "Is this thing inside that box?"
💻 **Example:**
```python
print(3 in [1, 2, 3])        # True
print("x" not in "python")   # True
```
🎯 **Interview:** Works on any container (`__contains__`) or falls back to iteration. Complexity: O(1) for set/dict, O(n) for list/tuple/str.

### 2️⃣7️⃣ What are identity operators (`is`, `is not`) in Python? 🪪
🧒 **Simple:** Checks if two names point to the *exact same object* (same ID card), not just look alike.
💻 **Example:**
```python
a = [1]; b = [1]
print(a is b)   # False
print(a is a)   # True
```
🎯 **Interview:** Compares `id()`. Use `is` for singletons: `x is None`, `x is True`. Don't use for value comparison.

### 2️⃣8️⃣ What is the difference between `==` and `is`? ⚖️
🧒 **Simple:** `==` = "same value?" `is` = "same object?" Twins are `==` but not `is`. 👯
💻 **Example:**
```python
a = [1, 2]; b = [1, 2]
print(a == b)  # True
print(a is b)  # False
```
🎯 **Interview:** `==` calls `__eq__`; `is` compares identity. Small-int caching (-5..256) and string interning can make `is` look true by accident → never rely on it.

### 2️⃣9️⃣ What are logical operators in Python (`and`, `or`, `not`)? 🚦
🧒 **Simple:** Combine yes/no questions. `and` = both, `or` = at least one, `not` = flip.
💻 **Example:**
```python
print(True and False)  # False
print(True or False)   # True
print(not True)        # False
print("a" or "b")      # "a"  (returns operand!) 😲
```
🎯 **Interview:** `and`/`or` return one of the operands (not strictly bool). Useful for defaults: `name = user_input or "Guest"`.

### 3️⃣0️⃣ What is short-circuit evaluation in Python? ⚡
🧒 **Simple:** Python stops checking as soon as it knows the answer. Lazy but smart! 😴
💻 **Example:**
```python
def boom(): print("💥"); return True
False and boom()   # boom never runs
True or boom()     # boom never runs
```
🎯 **Interview:** Enables safe guards (`if x and x.value`) and performance. Side effects in the skipped operand don't happen.

### 3️⃣1️⃣ How do conditional statements (`if`, `elif`, `else`) work? 🔀
🧒 **Simple:** "If this, do that; else if that, do this; otherwise do the other."
💻 **Example:**
```python
n = 5
if n < 0: print("neg")
elif n == 0: print("zero")
else: print("pos ✅")
```
🎯 **Interview:** Evaluated top-down; first truthy branch runs. Truthiness: empty containers, `0`, `None`, `""` are falsy. Python 3.10 adds `match/case` for structural pattern matching.

### 3️⃣2️⃣ Can you write a ternary conditional operator in Python? 🎯
🧒 **Simple:** A one-line if/else.
💻 **Example:**
```python
age = 20
status = "adult" if age >= 18 else "minor"
```
🎯 **Interview:** Syntax: `value_if_true if condition else value_if_false`. Don't nest too deeply (readability).

### 3️⃣3️⃣ What is the difference between `while` and `for` loops? 🔁
🧒 **Simple:** `for` = "do this for each item". `while` = "keep doing this until I say stop".
💻 **Example:**
```python
for i in range(3): print(i)
n = 3
while n > 0: print(n); n -= 1
```
🎯 **Interview:** `for` iterates over an iterable (uses iterator protocol); `while` uses a condition. Prefer `for` when the number of iterations is known; `while` for condition-driven/unknown loops. Beware infinite loops.

### 3️⃣4️⃣ How does the `break` statement work? 🛑
🧒 **Simple:** Emergency exit from a loop. 🚪🏃
💻 **Example:**
```python
for i in range(10):
    if i == 3: break
    print(i)   # 0 1 2
```
🎯 **Interview:** Exits only the innermost loop and skips the loop's `else` clause.

### 3️⃣5️⃣ How does the `continue` statement work? ⏭️
🧒 **Simple:** "Skip this round, go to the next one."
💻 **Example:**
```python
for i in range(5):
    if i % 2: continue
    print(i)   # 0 2 4
```
🎯 **Interview:** Jumps to the next iteration (re-checks condition in `while`). Can often be replaced by filtering logic for clarity.

### 3️⃣6️⃣ What is the purpose of the `pass` statement? 🫥
🧒 **Simple:** "Do nothing" placeholder — because Python doesn't allow empty blocks.
💻 **Example:**
```python
class TODO: pass
def later(): pass
```
🎯 **Interview:** A no-op used for stubs. Alternatives: `...` (Ellipsis) or a docstring. Don't use it to swallow exceptions silently.

### 3️⃣7️⃣ How does the `else` block work with loops? 🤯
🧒 **Simple:** The `else` runs only if the loop finished *without* hitting `break`.
💻 **Example:**
```python
for n in [1, 3, 5]:
    if n % 2 == 0: break
else:
    print("No even found ✅")
```
🎯 **Interview:** "No-break else". Great for search loops (replaces flag variables). Also works with `while`.

### 3️⃣8️⃣ What is the `range()` function and how does it work? 📏
🧒 **Simple:** Makes a counting sequence without storing every number. 🔢
💻 **Example:**
```python
list(range(5))        # [0,1,2,3,4]
list(range(2, 10, 3)) # [2,5,8]
```
🎯 **Interview:** In Py3 it's a lazy immutable sequence object (O(1) memory, supports `len`, indexing, slicing, `in` in O(1) for ints). `range(start, stop, step)`, stop exclusive.

### 3️⃣9️⃣ How do you iterate over a dictionary in Python? 📖
🧒 **Simple:** Loop over keys, values, or both together.
💻 **Example:**
```python
d = {"a": 1, "b": 2}
for k in d: ...
for v in d.values(): ...
for k, v in d.items(): print(k, v)
```
🎯 **Interview:** Default iteration = keys. Don't modify dict size while iterating (`RuntimeError`); iterate over `list(d)` instead. Insertion order is guaranteed from Py3.7.

### 4️⃣0️⃣ How do you iterate with an index using a loop? 🔢
🧒 **Simple:** Use `enumerate()` — gives you number + item together.
💻 **Example:**
```python
for i, fruit in enumerate(["🍎", "🍌"], start=1):
    print(i, fruit)
```
🎯 **Interview:** More Pythonic than `range(len(x))`. Returns a lazy iterator of tuples.

---

# 🛠️ SECTION 2: Functions & Functional Programming

### 4️⃣1️⃣ What is a function in Python? 🧰
🧒 **Simple:** A reusable recipe 🍳 — write once, use many times.
💻 **Example:**
```python
def greet(name): return f"Hi {name} 👋"
```
🎯 **Interview:** Functions are first-class objects: can be assigned, passed, returned, and have attributes. They're instances of `function` type.

### 4️⃣2️⃣ How do you define a function using the `def` keyword? ✍️
🧒 **Simple:** `def name(inputs):` then indent the body.
💻 **Example:**
```python
def square(n):
    return n * n
print(square(4))  # 16
```
🎯 **Interview:** `def` is executed at runtime and creates a function object bound to a name. Defaults are evaluated once at definition time.

### 4️⃣3️⃣ What is the difference between parameters and arguments? 🎁
🧒 **Simple:** Parameter = the empty slot in the recipe. Argument = the actual ingredient you put in.
💻 **Example:**
```python
def f(x):   # x = parameter
    ...
f(10)       # 10 = argument
```
🎯 **Interview:** Parameters are in the definition; arguments are values passed in the call. Kinds: positional-only (`/`), positional-or-keyword, `*args`, keyword-only, `**kwargs`.

### 4️⃣4️⃣ What are positional arguments? 📍
🧒 **Simple:** Matched by *order* — first value goes to first parameter.
💻 **Example:**
```python
def sub(a, b): return a - b
print(sub(10, 3))  # 7, not -7
```
🎯 **Interview:** Order matters. Python 3.8 `def f(a, b, /)` forces positional-only.

### 4️⃣5️⃣ What are keyword arguments? 🏷️
🧒 **Simple:** You name the slot: `name=value`, so order doesn't matter.
💻 **Example:**
```python
sub(b=3, a=10)  # 7
```
🎯 **Interview:** Improve readability; must come after positional args in a call. Use `*` in def to force keyword-only: `def f(a, *, b)`.

### 4️⃣6️⃣ What are default arguments in Python? 🎚️
🧒 **Simple:** A pre-filled value used when you don't provide one.
💻 **Example:**
```python
def hello(name="friend"): print(f"Hi {name}")
hello(); hello("Sam")
```
🎯 **Interview:** Evaluated **once** at function definition. Defaults must come after non-default params. Never use mutable defaults (see next).

### 4️⃣7️⃣ What is a common pitfall with mutable default arguments? 🪤
🧒 **Simple:** The default list is created once and shared by every call — like a communal fridge 🧊 everyone keeps adding to!
💻 **Example:**
```python
def add(x, lst=[]):      # 😱 BAD
    lst.append(x); return lst
add(1); print(add(2))    # [1, 2]

def add(x, lst=None):    # ✅ GOOD
    if lst is None: lst = []
    lst.append(x); return lst
```
🎯 **Interview:** Classic gotcha. Fix: `None` sentinel. Can be used intentionally for caching/memoization but it's usually a bug.

### 4️⃣8️⃣ What are variable-length arguments (`*args`)? 🎒
🧒 **Simple:** "Give me as many extra items as you want" — collected into a tuple.
💻 **Example:**
```python
def total(*nums): return sum(nums)
print(total(1, 2, 3, 4))  # 10
```
🎯 **Interview:** `*args` collects extra positional args into a `tuple`. The `*` also unpacks in calls: `f(*[1,2,3])`.

### 4️⃣9️⃣ What are keyword variable-length arguments (`**kwargs`)? 🧳
🧒 **Simple:** Collects extra named arguments into a dictionary.
💻 **Example:**
```python
def show(**info): print(info)
show(name="Ann", age=9)  # {'name': 'Ann', 'age': 9}
```
🎯 **Interview:** Collected into a `dict`. `**d` unpacks a dict in calls. Common in wrappers/decorators to forward arguments: `def wrapper(*a, **k): return f(*a, **k)`.

### 5️⃣0️⃣ What is the return value of a function that has no return statement? 🕳️
🧒 **Simple:** It quietly returns `None` — "nothing".
💻 **Example:**
```python
def f(): pass
print(f())  # None
```
🎯 **Interview:** Implicit `return None`. Beware: `lst = lst.sort()` sets `lst` to `None`.

### 5️⃣1️⃣ Can a function return multiple values in Python? 🎁🎁
🧒 **Simple:** Yes! It secretly packs them into a tuple.
💻 **Example:**
```python
def minmax(l): return min(l), max(l)
lo, hi = minmax([3, 1, 9])
```
🎯 **Interview:** It returns a single tuple object; unpacking happens at the call site. Use `namedtuple`/dataclass for readability.

### 5️⃣2️⃣ What is an anonymous function (lambda function)? 🥷
🧒 **Simple:** A tiny nameless one-line function.
💻 **Example:**
```python
double = lambda x: x * 2
print(sorted(["bb", "a"], key=lambda s: len(s)))
```
🎯 **Interview:** `lambda args: expression`. Returns the expression's value. Common as `key=` functions and callbacks.

### 5️⃣3️⃣ What are the limitations of lambda functions? 🚧
🧒 **Simple:** Only one expression — no loops, no multiple statements, no assignments.
💻 **Example:**
```python
# lambda x: print(x); return x   ❌ SyntaxError
```
🎯 **Interview:** Single expression only, no statements/annotations, harder to debug (`<lambda>` in tracebacks), no docstring. PEP 8 says don't assign a lambda to a name; use `def`.

### 5️⃣4️⃣ What is recursion in Python? 🪞
🧒 **Simple:** A function that calls itself, like Russian nesting dolls 🪆.
💻 **Example:**
```python
def fact(n): return 1 if n <= 1 else n * fact(n - 1)
print(fact(5))  # 120
```
🎯 **Interview:** Needs a base case + progress toward it. Elegant for trees/divide-and-conquer; Python has no tail-call optimization, so deep recursion can overflow → prefer iteration.

### 5️⃣5️⃣ What is a recursive base case? 🛬
🧒 **Simple:** The "stop!" rule so the function doesn't call itself forever. ♾️🚫
💻 **Example:**
```python
def countdown(n):
    if n == 0: return "🚀"   # base case
    return countdown(n - 1)
```
🎯 **Interview:** Without it → `RecursionError`. There may be multiple base cases (e.g., Fibonacci: `n=0` and `n=1`).

### 5️⃣6️⃣ What is recursion depth limit and how do you change it? 📉
🧒 **Simple:** Python only lets functions call themselves ~1000 times to avoid crashing.
💻 **Example:**
```python
import sys
print(sys.getrecursionlimit())  # 1000
sys.setrecursionlimit(5000)
```
🎯 **Interview:** Raising it risks a real stack overflow/segfault. Better: iteration, explicit stack, or memoization.

### 5️⃣7️⃣ What are higher-order functions in Python? 🎩
🧒 **Simple:** Functions that take other functions as input or give one back.
💻 **Example:**
```python
def apply(f, x): return f(x)
print(apply(str.upper, "hi"))
```
🎯 **Interview:** Enabled by first-class functions. Examples: `map`, `filter`, `sorted(key=)`, decorators, `functools.partial`.

### 5️⃣8️⃣ What is the `map()` function and how does it work? 🗺️
🧒 **Simple:** Applies a function to every item, like a stamp 🖨️ on each page.
💻 **Example:**
```python
print(list(map(lambda x: x*2, [1, 2, 3])))  # [2,4,6]
```
🎯 **Interview:** Returns a lazy iterator in Py3. List comprehension is often more readable: `[x*2 for x in data]`.

### 5️⃣9️⃣ What is the `filter()` function and how does it work? 🧲
🧒 **Simple:** Keeps only items that pass a test ✅.
💻 **Example:**
```python
print(list(filter(lambda x: x % 2 == 0, range(6))))  # [0,2,4]
```
🎯 **Interview:** Lazy iterator; `filter(None, it)` removes falsy values. Equivalent to `[x for x in it if cond]`.

### 6️⃣0️⃣ What is the `reduce()` function and where is it located? 🧮
🧒 **Simple:** Squishes a whole list into one value by repeatedly combining items.
💻 **Example:**
```python
from functools import reduce
print(reduce(lambda a, b: a * b, [1, 2, 3, 4]))  # 24
```
🎯 **Interview:** Lives in `functools` (moved from builtins in Py3). Accepts an optional initializer. Often `sum`, `max`, `math.prod` are clearer.

### 6️⃣1️⃣ What is a list comprehension? 📝✨
🧒 **Simple:** A one-line shortcut to build a list.
💻 **Example:**
```python
squares = [x**2 for x in range(5) if x % 2 == 0]  # [0,4,16]
```
🎯 **Interview:** Syntax: `[expr for item in iterable if cond]`. Has its own scope in Py3 (loop var doesn't leak).

### 6️⃣2️⃣ What are the advantages of list comprehensions over loops? 🏆
🧒 **Simple:** Shorter, cleaner, and faster.
💻 **Example:**
```python
# loop
res = []
for x in data: res.append(x * 2)
# comprehension
res = [x * 2 for x in data]
```
🎯 **Interview:** More readable (for simple logic), faster (optimized bytecode, avoids repeated `.append` lookup), declarative. Don't use for side effects or overly complex logic.

### 6️⃣3️⃣ Can you write a nested list comprehension? 🪆
🧒 **Simple:** A comprehension inside a comprehension — great for grids.
💻 **Example:**
```python
matrix = [[1, 2], [3, 4]]
flat = [n for row in matrix for n in row]     # [1,2,3,4]
grid = [[i*j for j in range(3)] for i in range(3)]
```
🎯 **Interview:** For-clauses read left→right in the same order as nested loops. Keep to 2 levels max for readability.

### 6️⃣4️⃣ What is a dictionary comprehension? 📖✨
🧒 **Simple:** Build a dictionary in one line.
💻 **Example:**
```python
sq = {n: n**2 for n in range(4)}  # {0:0,1:1,2:4,3:9}
```
🎯 **Interview:** Useful for inverting (`{v:k for k,v in d.items()}`) and filtering dicts. Later duplicate keys overwrite earlier ones.

### 6️⃣5️⃣ What is a set comprehension? 🎪
🧒 **Simple:** Like a list comprehension but gives a set (no duplicates).
💻 **Example:**
```python
print({c.lower() for c in "HeLLo"})  # {'h','e','l','o'}
```
🎯 **Interview:** Curly braces without `key: value`. Note `{}` alone is an empty dict, not a set.

### 6️⃣6️⃣ What is a generator expression? 🏭
🧒 **Simple:** Like a list comprehension but lazy — makes values one at a time when asked.
💻 **Example:**
```python
g = (x*x for x in range(1_000_000))
print(next(g))  # 0
print(sum(x for x in range(10)))
```
🎯 **Interview:** Parentheses; returns a generator object; O(1) memory; single-use.

### 6️⃣7️⃣ What is the difference between a list comprehension and a generator expression? ⚔️
🧒 **Simple:** List = whole pizza baked now 🍕. Generator = pizza made slice by slice on demand.
💻 **Example:**
```python
import sys
print(sys.getsizeof([i for i in range(10**6)]))  # ~8 MB
print(sys.getsizeof((i for i in range(10**6))))  # ~200 bytes
```
🎯 **Interview:** List: eager, memory heavy, reusable, indexable. Generator: lazy, memory efficient, one pass, not indexable. Use generators for large/stream data.

---

# 🔤 SECTION 3: Strings, Lists, Tuples, Sets, Dicts & Collections

### 6️⃣8️⃣ What are strings in Python? 🧵
🧒 **Simple:** Text! Letters wrapped in quotes.
💻 **Example:**
```python
s = "Python 🐍"
print(len(s), s[0])
```
🎯 **Interview:** Immutable sequences of Unicode code points (`str`). Single, double, or triple quotes allowed.

### 6️⃣9️⃣ Are strings mutable or immutable in Python? 🧊
🧒 **Simple:** Immutable — you can't change a letter, you must make a new string.
💻 **Example:**
```python
s = "cat"
# s[0] = "b"  ❌ TypeError
s = "b" + s[1:]   # "bat" ✅ (new object)
```
🎯 **Interview:** Immutability enables hashing, interning, and thread safety. Repeated `+=` in loops is O(n²) → use `"".join(parts)`.

### 7️⃣0️⃣ How do you perform string slicing? 🍰🔪
🧒 **Simple:** Cut a piece of the string with `[start:stop:step]`.
💻 **Example:**
```python
s = "PYTHON"
print(s[1:4])   # YTH
print(s[::-1])  # NOHTYP (reverse 🔁)
print(s[-2:])   # ON
```
🎯 **Interview:** Stop is exclusive; out-of-range slices don't error; negative indexes count from the end; slicing creates a new object (O(k)).

### 7️⃣1️⃣ What are some common string methods (`strip`, `split`, `join`, `replace`)? 🧰
🧒 **Simple:** Built-in tools to clean, cut, glue, and swap text.
💻 **Example:**
```python
"  hi  ".strip()          # 'hi'
"a,b,c".split(",")        # ['a','b','c']
"-".join(["a","b"])       # 'a-b'
"cat".replace("c","b")    # 'bat'
```
🎯 **Interview:** All return new strings (immutability). Others: `startswith`, `find`, `casefold`, `partition`, `isdigit`. Know `join` is on the *separator* string.

### 7️⃣2️⃣ How do you format strings in Python (f-strings, `.format()`, `%`)? 🎨
🧒 **Simple:** Put variables inside text. f-strings are the easiest.
💻 **Example:**
```python
name, pi = "Ann", 3.14159
print(f"{name} likes {pi:.2f}")
print("{} likes {:.2f}".format(name, pi))
print("%s likes %.2f" % (name, pi))
```
🎯 **Interview:** f-strings (3.6+) are fastest and most readable, evaluate expressions at runtime (`f"{x=}"` debug in 3.8). Avoid f-strings for logging (lazy `%s` formatting) and SQL (injection risk!).

### 7️⃣3️⃣ What are raw strings in Python? 🥩
🧒 **Simple:** Strings where backslash is just a backslash — great for file paths and regex.
💻 **Example:**
```python
print(r"C:\new\table")   # no newline/tab surprise 😮
```
🎯 **Interview:** Prefix `r`. Can't end with an odd number of backslashes. Used heavily in regular expressions.

### 7️⃣4️⃣ What is string interning in Python? 🧊📎
🧒 **Simple:** Python reuses the same object for identical small strings to save memory.
💻 **Example:**
```python
a = "hello"; b = "hello"
print(a is b)   # True (interned)
import sys; c = sys.intern("some long str!")
```
🎯 **Interview:** CPython interns identifiers and some literals; speeds up dict key comparison (pointer check). Implementation detail—never rely on it; use `==`.

### 7️⃣5️⃣ What are lists in Python? 📋
🧒 **Simple:** An ordered shopping list you can change. 🛒
💻 **Example:**
```python
l = [1, "two", 3.0, [4]]
```
🎯 **Interview:** Dynamic arrays (over-allocated). Index O(1), append amortized O(1), insert/delete in middle O(n), `in` O(n). Heterogeneous allowed.

### 7️⃣6️⃣ How do you add elements to a list (`append`, `insert`, `extend`)? ➕
🧒 **Simple:** `append` = add at end, `insert` = add at a position, `extend` = add many.
💻 **Example:**
```python
l = [1]
l.append(2)        # [1,2]
l.insert(0, 0)     # [0,1,2]
l.extend([3, 4])   # [0,1,2,3,4]
```
🎯 **Interview:** `insert(0, x)` is O(n) → use `deque` for frequent front inserts.

### 7️⃣7️⃣ How do you remove elements from a list (`remove`, `pop`, `del`, `clear`)? ➖
🧒 **Simple:** Different ways to throw stuff out: by value, by position, or everything.
💻 **Example:**
```python
l = [1, 2, 3, 2]
l.remove(2)   # removes first 2 -> [1,3,2]
l.pop()       # removes & returns last -> 2
del l[0]      # delete by index
l.clear()     # []
```
🎯 **Interview:** `remove` raises `ValueError` if missing; `pop(i)` returns the item; `pop(0)` is O(n). Never remove while iterating forward—iterate a copy or use a comprehension.

### 7️⃣8️⃣ What is the difference between `append()` and `extend()`? 🥊
🧒 **Simple:** `append` adds ONE thing (even if it's a list). `extend` adds each item inside.
💻 **Example:**
```python
a = [1]; a.append([2, 3])   # [1, [2, 3]]
b = [1]; b.extend([2, 3])   # [1, 2, 3]
```
🎯 **Interview:** `extend` ≈ `+=` in-place and accepts any iterable. `a + b` creates a new list.

### 7️⃣9️⃣ How do you sort a list (`sort()` vs `sorted()`)? 🔃
🧒 **Simple:** `sort()` changes the list. `sorted()` gives a new sorted list.
💻 **Example:**
```python
l = [3, 1, 2]
print(sorted(l, reverse=True))  # [3,2,1]
l.sort(key=lambda x: -x)
```
🎯 **Interview:** Both use Timsort (stable, O(n log n), O(n) best case). `sort()` returns `None`. `sorted()` works on any iterable.

### 8️⃣0️⃣ How do you reverse a list? 🔁
🧒 **Simple:** Flip it!
💻 **Example:**
```python
l = [1, 2, 3]
l.reverse()          # in place
print(l[::-1])       # new list
print(list(reversed(l)))
```
🎯 **Interview:** `reversed()` returns a lazy iterator (O(1) memory); slicing makes a copy.

### 8️⃣1️⃣ What is the difference between a shallow copy and a deep copy? 🪞
🧒 **Simple:** Shallow = copy the outer box but share the inner toys 🧸. Deep = copy everything, even the toys.
💻 **Example:**
```python
import copy
a = [[1, 2], [3]]
s = copy.copy(a); d = copy.deepcopy(a)
a[0].append(99)
print(s[0])  # [1,2,99] (shared) 😱
print(d[0])  # [1,2]    (independent) ✅
```
🎯 **Interview:** Shallow copies nested objects by reference. Deep copy recursively copies and handles cycles via a memo dict. Deep copy is slower; customize via `__deepcopy__`.

### 8️⃣2️⃣ How do you use the `copy` module for cloning objects? 👯
🧒 **Simple:** `copy.copy()` for shallow, `copy.deepcopy()` for deep.
💻 **Example:**
```python
import copy
clone = copy.deepcopy(original)
```
🎯 **Interview:** Immutable objects return themselves. Classes can define `__copy__`/`__deepcopy__`. Alternatives: `list.copy()`, `dict.copy()`, slicing.

### 8️⃣3️⃣ What are tuples in Python? 📦🔒
🧒 **Simple:** A list that's locked 🔐 — can't be changed.
💻 **Example:**
```python
t = (1, 2, 3)
single = (1,)   # comma makes it a tuple!
```
🎯 **Interview:** Immutable, ordered, hashable if elements are hashable, slightly faster and smaller than lists.

### 8️⃣4️⃣ Why use tuples instead of lists? 🤷
🧒 **Simple:** When the data shouldn't change, or you need a dict key.
💻 **Example:**
```python
locations = {(12.9, 77.6): "Bangalore"}   # tuple as key ✅
```
🎯 **Interview:** Safety (immutability), hashability, performance/memory, semantic meaning (record vs. collection), constant-folding by compiler.

### 8️⃣5️⃣ What is tuple unpacking? 🎁
🧒 **Simple:** Open a package and give each item its own name.
💻 **Example:**
```python
a, b, *rest = (1, 2, 3, 4)   # a=1, b=2, rest=[3,4]
x, _ = (5, 6)                # ignore with _
```
🎯 **Interview:** Works on any iterable. Star-unpacking (PEP 3132). Number of targets must match unless `*` used.

### 8️⃣6️⃣ What is a named tuple? 🏷️📦
🧒 **Simple:** A tuple where each slot has a name — like a mini-record.
💻 **Example:**
```python
from collections import namedtuple
P = namedtuple("P", "x y")
p = P(1, 2); print(p.x, p[1])
```
🎯 **Interview:** Immutable, memory-light, supports `_asdict()`, `_replace()`. `typing.NamedTuple` adds type hints. Use dataclass if mutability needed.

### 8️⃣7️⃣ What are sets in Python? 🎲
🧒 **Simple:** A bag of unique items — no duplicates, no order.
💻 **Example:**
```python
s = {1, 2, 2, 3}   # {1,2,3}
empty = set()      # NOT {}
```
🎯 **Interview:** Hash-table based, mutable, elements must be hashable. Average O(1) add/remove/membership.

### 8️⃣8️⃣ What are the key characteristics of sets? 🔑
🧒 **Simple:** Unique, unordered, fast lookup, can't index.
💻 **Example:**
```python
s = {3, 1}
# s[0] ❌ TypeError
print(3 in s)  # fast ⚡
```
🎯 **Interview:** Unordered (no indexing/slicing), unique elements, mutable, supports math set operations, memory overhead higher than lists.

### 8️⃣9️⃣ How do you perform set operations (union, intersection, difference, symmetric difference)? ➕➖
🧒 **Simple:** Venn diagram magic. 🔵🔴
💻 **Example:**
```python
a, b = {1, 2, 3}, {3, 4}
a | b   # union {1,2,3,4}
a & b   # intersection {3}
a - b   # difference {1,2}
a ^ b   # symmetric diff {1,2,4}
```
🎯 **Interview:** Method forms (`.union()`) accept any iterable; operator forms require sets. Also `issubset`, `isdisjoint`.

### 9️⃣0️⃣ What is a frozenset? 🧊🎲
🧒 **Simple:** A set you can't change — a frozen set.
💻 **Example:**
```python
fs = frozenset([1, 2])
d = {fs: "ok"}   # hashable, can be a dict key
```
🎯 **Interview:** Immutable + hashable. Used as dict keys or as elements of another set.

### 9️⃣1️⃣ What are dictionaries in Python? 📖
🧒 **Simple:** A phonebook ☎️: look up a name (key) to get a number (value).
💻 **Example:**
```python
d = {"name": "Ann", "age": 9}
print(d["name"])
```
🎯 **Interview:** Mutable hash maps, key→value, insertion-ordered since 3.7 (language guarantee), average O(1) get/set.

### 9️⃣2️⃣ How are dictionaries implemented internally in Python? ⚙️
🧒 **Simple:** Using a hash table — a fast filing cabinet where the key's "hash" tells where to look.
💻 **Example:**
```python
print(hash("abc"))
```
🎯 **Interview:** Open addressing with a compact layout (sparse index array + dense entries array) → preserves order and saves memory. Resizes at ~2/3 load factor. Collisions resolved by probing (perturbation scheme).

### 9️⃣3️⃣ What objects can be used as dictionary keys? 🗝️
🧒 **Simple:** Only things that can't change (hashable).
💻 **Example:**
```python
{1: "a", "x": "b", (1, 2): "c"}   # ✅
# {[1]: "x"}  ❌ TypeError: unhashable
```
🎯 **Interview:** Must implement `__hash__` and `__eq__` consistently. Hash must not change during lifetime. Lists, dicts, sets are unhashable.

### 9️⃣4️⃣ How do you access values in a dictionary safely (`get()` method)? 🛟
🧒 **Simple:** `get()` doesn't crash if the key is missing — it gives a default.
💻 **Example:**
```python
d = {"a": 1}
print(d.get("b", 0))   # 0
# d["b"] -> KeyError 💥
```
🎯 **Interview:** Also `setdefault()`, `defaultdict`, or `try/except KeyError` (EAFP). Use `in` when value may legitimately be `None`.

### 9️⃣5️⃣ How do you merge two dictionaries in Python? 🧬
🧒 **Simple:** Combine two address books into one.
💻 **Example:**
```python
a, b = {"x": 1}, {"y": 2, "x": 9}
print({**a, **b})   # {'x': 9, 'y': 2}
print(a | b)        # Py3.9+
a.update(b)         # in place
```
🎯 **Interview:** Later dict wins on conflicts. `|` returns new, `|=` updates in place. `ChainMap` merges without copying.

### 9️⃣6️⃣ What is the `defaultdict` from the collections module? 🏭
🧒 **Simple:** A dictionary that auto-creates missing keys with a default value.
💻 **Example:**
```python
from collections import defaultdict
d = defaultdict(list)
d["fruits"].append("🍎")
```
🎯 **Interview:** Takes a factory callable (`int`, `list`, `set`, lambda). Implements `__missing__`. Great for grouping & counting. Beware: merely reading a missing key inserts it.

### 9️⃣7️⃣ What is an `OrderedDict`? 📚
🧒 **Simple:** A dictionary that remembers the order you added items (older times, before regular dicts did).
💻 **Example:**
```python
from collections import OrderedDict
od = OrderedDict(a=1, b=2)
od.move_to_end("a")
```
🎯 **Interview:** Regular dicts are ordered since 3.7, but `OrderedDict` still has `move_to_end`, `popitem(last=False)`, and order-sensitive equality. Good for LRU caches.

### 9️⃣8️⃣ What is a `Counter` in the collections module? 🔢
🧒 **Simple:** Counts how many times each thing appears. 🧮
💻 **Example:**
```python
from collections import Counter
c = Counter("banana")
print(c.most_common(1))  # [('a', 3)]
```
🎯 **Interview:** Dict subclass; supports arithmetic (`+`, `-`, `&`, `|`), `most_common`, `elements()`. Missing keys return 0.

### 9️⃣9️⃣ What is a `deque` and when should you use it? 🚂
🧒 **Simple:** A line you can add to or remove from at *both* ends super fast.
💻 **Example:**
```python
from collections import deque
q = deque([1, 2])
q.appendleft(0); q.pop()
```
🎯 **Interview:** Doubly-linked blocks; O(1) at both ends (list is O(n) at front). Use for queues, BFS, sliding window (`maxlen`). Indexing the middle is O(n). Thread-safe appends/pops.

### 1️⃣0️⃣0️⃣ What is the `chain` object in itertools? ⛓️
🧒 **Simple:** Glues several lists together to loop over them as one, without copying.
💻 **Example:**
```python
from itertools import chain
for x in chain([1, 2], (3,), "ab"): print(x)
```
🎯 **Interview:** Lazy iterator; O(1) extra memory. `chain.from_iterable(list_of_lists)` flattens one level.


---

# 🔄 SECTION 4: Iterators, Generators, Decorators & Closures

### 1️⃣0️⃣1️⃣ What is an iterator in Python? 🚶
🧒 **Simple:** An object that hands you one item at a time when you say "next!"
💻 **Example:**
```python
it = iter([10, 20])
print(next(it), next(it))   # 10 20
```
🎯 **Interview:** Any object implementing `__iter__()` (returns self) and `__next__()` (returns next or raises `StopIteration`). Single-pass and stateful.

### 1️⃣0️⃣2️⃣ What is the difference between an iterable and an iterator? 🧩
🧒 **Simple:** Iterable = a book 📖 (you can read it). Iterator = the bookmark 🔖 tracking where you are.
💻 **Example:**
```python
lst = [1, 2]       # iterable
it = iter(lst)     # iterator
```
🎯 **Interview:** Iterable has `__iter__` returning a fresh iterator; iterator has `__next__` and `__iter__` returning itself. A list is iterable but not an iterator; every iterator is iterable.

### 1️⃣0️⃣3️⃣ What are the `__iter__()` and `__next__()` magic methods? 🪄
🧒 **Simple:** `__iter__` = "start the tour", `__next__` = "give me the next stop".
💻 **Example:**
```python
class Count:
    def __init__(self, n): self.i, self.n = 0, n
    def __iter__(self): return self
    def __next__(self):
        if self.i >= self.n: raise StopIteration
        self.i += 1; return self.i
print(list(Count(3)))  # [1,2,3]
```
🎯 **Interview:** The `for` loop calls `iter()` once, then `next()` repeatedly until `StopIteration`.

### 1️⃣0️⃣4️⃣ How do you manually consume an iterator using `next()`? 🖐️
🧒 **Simple:** Call `next(it)` to take one item at a time.
💻 **Example:**
```python
it = iter("ab")
print(next(it), next(it))
print(next(it, "done"))   # default avoids StopIteration
```
🎯 **Interview:** Provide a default to avoid exceptions. Handy for "get first matching item": `next((x for x in data if cond), None)`.

### 1️⃣0️⃣5️⃣ What is a generator in Python? 🏭
🧒 **Simple:** A special function that can pause ⏸️ and resume ▶️, giving values one by one.
💻 **Example:**
```python
def gen():
    yield 1
    yield 2
print(list(gen()))
```
🎯 **Interview:** A function containing `yield` returns a generator iterator that preserves local state between yields. Automatically implements the iterator protocol.

### 1️⃣0️⃣6️⃣ How do you define a generator using the `yield` keyword? 🌾
🧒 **Simple:** Use `yield` instead of `return` to hand out values lazily.
💻 **Example:**
```python
def fib():
    a, b = 0, 1
    while True:
        yield a
        a, b = b, a + b
```
🎯 **Interview:** Infinite sequences possible. `yield from sub_gen()` delegates to another generator (PEP 380).

### 1️⃣0️⃣7️⃣ What are the memory benefits of using generators? 💾
🧒 **Simple:** They don't store the whole list, just the current item.
💻 **Example:**
```python
total = sum(x*x for x in range(10**7))  # tiny memory
```
🎯 **Interview:** O(1) memory vs O(n); enable streaming pipelines for huge files; lazy evaluation avoids unnecessary computation.

### 1️⃣0️⃣8️⃣ What is the difference between `return` and `yield`? 🔙🌾
🧒 **Simple:** `return` ends the function forever. `yield` pauses it and can come back.
💻 **Example:**
```python
def r(): return 1; return 2   # only 1
def y(): yield 1; yield 2     # both
```
🎯 **Interview:** `return` terminates and discards frame; `yield` suspends frame preserving state. `return` in a generator raises `StopIteration(value)`.

### 1️⃣0️⃣9️⃣ What is the `send()` method of a generator? 📨
🧒 **Simple:** Lets you push a value *into* a paused generator. Two-way chat! 💬
💻 **Example:**
```python
def echo():
    while True:
        x = yield
        print("got", x)
g = echo(); next(g); g.send("hi")
```
🎯 **Interview:** First call must be `next()` / `send(None)` ("priming"). Foundation of coroutines before `async/await`.

### 1️⃣1️⃣0️⃣ What is the `throw()` method of a generator? 🎯💥
🧒 **Simple:** Throws an error *into* the generator at the paused spot.
💻 **Example:**
```python
def g():
    try: yield 1
    except ValueError: yield "caught!"
x = g(); next(x); print(x.throw(ValueError))
```
🎯 **Interview:** Raises exception at the `yield` point; generator can catch it and continue. Used for cancellation/error signaling in coroutine frameworks.

### 1️⃣1️⃣1️⃣ What is the `close()` method of a generator? 🔒
🧒 **Simple:** Politely tells the generator "you're done, clean up".
💻 **Example:**
```python
def g():
    try: yield 1
    finally: print("cleanup 🧹")
x = g(); next(x); x.close()
```
🎯 **Interview:** Raises `GeneratorExit` at the yield. Generator must not yield again. `finally` blocks run — useful for releasing resources.

### 1️⃣1️⃣2️⃣ What are decorators in Python? 🎀
🧒 **Simple:** Gift wrap 🎁 for functions — adds extra behavior without changing the function inside.
💻 **Example:**
```python
@my_decorator
def hello(): ...
```
🎯 **Interview:** A decorator is a callable that takes a callable and returns a (usually wrapped) callable. Uses: logging, auth, caching, timing, retries.

### 1️⃣1️⃣3️⃣ How do you write a simple function decorator? ✍️
🧒 **Simple:** A function that returns a wrapper function.
💻 **Example:**
```python
def shout(fn):
    def wrapper(*a, **k):
        print("📣 calling", fn.__name__)
        return fn(*a, **k)
    return wrapper

@shout
def hi(): print("hi")
hi()
```
🎯 **Interview:** Use `*args, **kwargs` to be generic and always `return` the result. Add `functools.wraps`.

### 1️⃣1️⃣4️⃣ What is syntactic sugar in the context of decorators (`@decorator`)? 🍬
🧒 **Simple:** `@dec` is just a shortcut for typing `f = dec(f)`.
💻 **Example:**
```python
@shout
def hi(): ...
# same as: hi = shout(hi)
```
🎯 **Interview:** Applied at definition time; multiple decorators apply bottom-up.

### 1️⃣1️⃣5️⃣ How do you pass arguments to decorators? 🎁➡️🎀
🧒 **Simple:** Add one more wrapper layer — a "decorator factory".
💻 **Example:**
```python
def repeat(n):
    def deco(fn):
        def wrapper(*a, **k):
            for _ in range(n): fn(*a, **k)
        return wrapper
    return deco

@repeat(3)
def hey(): print("hey")
```
🎯 **Interview:** Three levels: factory(args) → decorator(func) → wrapper(*args). `@repeat(3)` = `hey = repeat(3)(hey)`.

### 1️⃣1️⃣6️⃣ What is `functools.wraps` and why should you use it? 🩹
🧒 **Simple:** Without it, your decorated function forgets its own name and docs. `wraps` copies them back.
💻 **Example:**
```python
from functools import wraps
def deco(fn):
    @wraps(fn)
    def wrapper(*a, **k): return fn(*a, **k)
    return wrapper
```
🎯 **Interview:** Preserves `__name__`, `__doc__`, `__module__`, `__wrapped__`, annotations. Essential for debugging, introspection, Sphinx, and Flask route names.

### 1️⃣1️⃣7️⃣ Can you chain multiple decorators on a single function? ⛓️🎀
🧒 **Simple:** Yes, stack them like layers of wrapping paper.
💻 **Example:**
```python
@a
@b
def f(): ...
# f = a(b(f))
```
🎯 **Interview:** Applied bottom-up (closest to the function first), executed outermost-first at call time. Order matters (e.g., `@login_required` vs `@cache`).

### 1️⃣1️⃣8️⃣ What are class-based decorators? 🏛️🎀
🧒 **Simple:** A decorator made using a class with `__call__`.
💻 **Example:**
```python
class CountCalls:
    def __init__(self, fn): self.fn, self.n = fn, 0
    def __call__(self, *a, **k):
        self.n += 1
        return self.fn(*a, **k)
@CountCalls
def hi(): ...
```
🎯 **Interview:** Good for keeping state naturally on `self`. Use `functools.update_wrapper(self, fn)` to preserve metadata. Doesn't bind as a method automatically (needs `__get__`).

### 1️⃣1️⃣9️⃣ What are decorators with state? 🧠🎀
🧒 **Simple:** Decorators that remember things between calls (like a counter).
💻 **Example:**
```python
def counter(fn):
    def wrapper(*a, **k):
        wrapper.calls += 1
        return fn(*a, **k)
    wrapper.calls = 0
    return wrapper
```
🎯 **Interview:** State kept via function attributes, closures with `nonlocal`, or class instances. Watch thread safety for shared state.

### 1️⃣2️⃣0️⃣ How do you use built-in decorators like `@staticmethod`, `@classmethod`, and `@property`? 🏗️
🧒 **Simple:** Special stickers on methods that change how they behave.
💻 **Example:**
```python
class C:
    @staticmethod
    def util(): ...
    @classmethod
    def make(cls): return cls()
    @property
    def x(self): return 42
```
🎯 **Interview:** `staticmethod` = no implicit arg; `classmethod` = receives class; `property` = method accessed like attribute. All are descriptors. Also `functools.cached_property`.

### 1️⃣2️⃣1️⃣ What is a closure in Python? 🎒
🧒 **Simple:** A function that *remembers* the variables from where it was born, even after that place is gone.
💻 **Example:**
```python
def make_adder(n):
    def add(x): return x + n
    return add
add5 = make_adder(5); print(add5(3))  # 8
```
🎯 **Interview:** Inner function + captured enclosing variables (cells). Basis for decorators, callbacks, partial application. Late-binding gotcha in loops.

### 1️⃣2️⃣2️⃣ What are free variables in closures? 🕊️
🧒 **Simple:** Variables used in the inner function but defined in the outer function.
💻 **Example:**
```python
def outer():
    msg = "hi"          # free variable for inner
    def inner(): print(msg)
    return inner
```
🎯 **Interview:** Names referenced in a function but not bound locally and not global. Listed in `co_freevars`.

### 1️⃣2️⃣3️⃣ How do you inspect closure variables using `__closure__`? 🔬
🧒 **Simple:** Peek inside the function's backpack.
💻 **Example:**
```python
f = make_adder(5)
print(f.__closure__[0].cell_contents)   # 5
print(f.__code__.co_freevars)           # ('n',)
```
🎯 **Interview:** `__closure__` is a tuple of `cell` objects (or `None`). Cells let multiple closures share and mutate a variable (`nonlocal`).

### 1️⃣2️⃣4️⃣ What is scope resolution (LEGB rule)? 🔭
🧒 **Simple:** The order Python searches for a variable name: nearest first.
💻 **Example:**
```python
x = "G"
def outer():
    x = "E"
    def inner():
        x = "L"; print(x)   # L
```
🎯 **Interview:** Name lookup order: Local → Enclosing → Global → Built-in. Decided at compile time per function.

### 1️⃣2️⃣5️⃣ What does LEGB stand for? 🔤
🧒 **Simple:** **L**ocal, **E**nclosing, **G**lobal, **B**uilt-in. 🧠 Mnemonic: "Little Elephants Grab Bananas" 🐘🍌
💻 **Example:** `len` → found in **B**uilt-in scope.
🎯 **Interview:** Class bodies are *not* enclosing scopes for methods — a common trap.

### 1️⃣2️⃣6️⃣ What happens if a variable is referenced before assignment in a local scope? 💣
🧒 **Simple:** Python crashes: "You're using a local variable that doesn't have a value yet!"
💻 **Example:**
```python
x = 1
def f():
    print(x)   # UnboundLocalError
    x = 2
```
🎯 **Interview:** Because assignment anywhere in the function makes the name local for the *entire* function. Fix with `global`/`nonlocal` or rename.

### 1️⃣2️⃣7️⃣ What is name mangling in Python? 🥴
🧒 **Simple:** Python secretly renames `__secret` to `_ClassName__secret` to avoid accidental clashes.
💻 **Example:**
```python
class A:
    def __init__(self): self.__x = 1
print(A()._A__x)   # 1
```
🎯 **Interview:** Applies to identifiers starting with 2 underscores (not ending with 2). Prevents name collisions in subclasses; **not** real security.

---

# 📦 SECTION 5: Modules, Packages & Exceptions

### 1️⃣2️⃣8️⃣ What are modules in Python? 📁
🧒 **Simple:** A `.py` file containing code you can reuse in other files.
💻 **Example:**
```python
# utils.py -> def hi(): ...
import utils; utils.hi()
```
🎯 **Interview:** A module is a namespace object created on import. A package is a directory of modules.

### 1️⃣2️⃣9️⃣ How do you import modules (`import`, `from ... import`, `as`)? 📥
🧒 **Simple:** Bring in someone else's code.
💻 **Example:**
```python
import math
from math import sqrt
import numpy as np
from os.path import *   # ❌ avoid
```
🎯 **Interview:** Avoid wildcard imports (namespace pollution). Order imports: stdlib, third-party, local (PEP 8).

### 1️⃣3️⃣0️⃣ What is the `sys.path` variable? 🗺️
🧒 **Simple:** The list of folders Python looks in to find modules.
💻 **Example:**
```python
import sys; print(sys.path)
```
🎯 **Interview:** Contains script dir, `PYTHONPATH`, stdlib, site-packages. Can be modified at runtime (hacky). Search order matters—shadowing stdlib names (e.g., `random.py`) is a classic bug.

### 1️⃣3️⃣1️⃣ What is the `__pycache__` directory and `.pyc` files? 🗃️
🧒 **Simple:** Python saves a pre-translated version of your file so next time it loads faster.
💻 **Example:** `__pycache__/utils.cpython-312.pyc`
🎯 **Interview:** Cached bytecode, invalidated by source mtime/hash. Only speeds up *loading*, not execution. Safe to delete; should be in `.gitignore`.

### 1️⃣3️⃣2️⃣ What is the purpose of the `__init__.py` file in a package? 🏷️
🧒 **Simple:** Marks a folder as a Python package and can run setup code.
💻 **Example:**
```python
# mypkg/__init__.py
from .core import run
__all__ = ["run"]
```
🎯 **Interview:** Executed on package import; defines the public API. Since 3.3, *namespace packages* work without it, but regular packages still use it.

### 1️⃣3️⃣3️⃣ What is the difference between absolute and relative imports? 🧭
🧒 **Simple:** Absolute = full address 🏠. Relative = "the house next door" using dots.
💻 **Example:**
```python
from mypkg.utils import f      # absolute
from .utils import f           # relative (same package)
from ..core import g           # parent package
```
🎯 **Interview:** PEP 8 prefers absolute. Relative imports only work inside packages (not top-level scripts).

### 1️⃣3️⃣4️⃣ What happens when you do `import module` multiple times? 🔁
🧒 **Simple:** Only the first import runs the file; later imports reuse the saved copy.
💻 **Example:**
```python
import m; import m   # m's code ran once
```
🎯 **Interview:** Cached in `sys.modules`. Use `importlib.reload()` to re-execute. Module-level side effects run once.

### 1️⃣3️⃣5️⃣ What is the `sys.modules` dictionary? 🗂️
🧒 **Simple:** Python's list of already-loaded modules.
💻 **Example:**
```python
import sys
print("math" in sys.modules)
```
🎯 **Interview:** Maps module names → module objects. Import system checks it first. Used for mocking/monkeypatching and handling circular imports.

### 1️⃣3️⃣6️⃣ What is the `__main__` module and `if __name__ == "__main__":` idiom? 🎬
🧒 **Simple:** Run code only when the file is run directly, not when imported.
💻 **Example:**
```python
def main(): print("running")
if __name__ == "__main__":
    main()
```
🎯 **Interview:** `__name__` is `"__main__"` for the entry script, otherwise module's name. Makes modules importable and testable.

### 1️⃣3️⃣7️⃣ How do you handle exceptions in Python (`try`, `except`, `else`, `finally`)? 🛡️
🧒 **Simple:** Try something risky; if it explodes 💥, catch the error instead of crashing.
💻 **Example:**
```python
try:
    x = 1 / 0
except ZeroDivisionError as e:
    print("oops", e)
else:
    print("no error")
finally:
    print("always 🧹")
```
🎯 **Interview:** Catch specific exceptions, never bare `except:`. EAFP style. Keep `try` blocks small.

### 1️⃣3️⃣8️⃣ What is the base class for all built-in exceptions? 👑
🧒 **Simple:** `BaseException` is the king; `Exception` is the one you usually catch.
💻 **Example:**
```python
print(ValueError.__mro__)
```
🎯 **Interview:** `BaseException` → `Exception` (normal errors) and also `KeyboardInterrupt`, `SystemExit`, `GeneratorExit`. Catch `Exception`, not `BaseException`. `ExceptionGroup` added in 3.11.

### 1️⃣3️⃣9️⃣ How do you catch multiple exceptions in a single `except` block? 🎣
🧒 **Simple:** Put them in a tuple.
💻 **Example:**
```python
try: ...
except (ValueError, TypeError) as e: print(e)
```
🎯 **Interview:** Alternatively multiple `except` blocks—first match wins, so order specific → general. `except*` (3.11) handles `ExceptionGroup`.

### 1️⃣4️⃣0️⃣ How do you get exception details using `as` or `sys.exc_info()`? 🕵️
🧒 **Simple:** Save the error in a variable to see what went wrong.
💻 **Example:**
```python
import sys, traceback
try: 1/0
except Exception as e:
    print(repr(e)); print(sys.exc_info()[0]); traceback.print_exc()
```
🎯 **Interview:** `as e` variable is deleted after the block. `e.__traceback__`, `e.args`, `e.__cause__`. Use `logging.exception()` to log traceback.

### 1️⃣4️⃣1️⃣ What is the purpose of the `else` block in a try-except statement? 🤔
🧒 **Simple:** Runs only if *no* exception happened.
💻 **Example:**
```python
try: n = int("5")
except ValueError: print("bad")
else: print("good", n)
```
🎯 **Interview:** Keeps success-only code out of `try` so you don't accidentally catch its exceptions.

### 1️⃣4️⃣2️⃣ What is the purpose of the `finally` block? 🧹
🧒 **Simple:** Always runs, error or not — perfect for cleanup.
💻 **Example:**
```python
f = open("a.txt")
try: data = f.read()
finally: f.close()
```
🎯 **Interview:** Runs even with `return`, `break`, or uncaught exception. A `return` in `finally` overrides earlier returns/exceptions (avoid!). Prefer `with`.

### 1️⃣4️⃣3️⃣ When does a `finally` block not execute? 🚫
🧒 **Simple:** If the whole program is killed abruptly.
💻 **Example:**
```python
import os
try: os._exit(1)      # no finally
finally: print("never")
```
🎯 **Interview:** Not run on `os._exit()`, hard crashes/segfaults, `kill -9`, power loss, or infinite loop/deadlock inside `try`. `sys.exit()` *does* run finally (raises `SystemExit`).

### 1️⃣4️⃣4️⃣ How do you raise an exception manually using `raise`? 🚨
🧒 **Simple:** Shout "ERROR!" yourself.
💻 **Example:**
```python
def age(n):
    if n < 0: raise ValueError("age can't be negative")
```
🎯 **Interview:** Bare `raise` inside `except` re-raises preserving traceback. Raise specific built-ins when suitable.

### 1️⃣4️⃣5️⃣ How do you define a custom exception class? 🧱
🧒 **Simple:** Make your own error type by inheriting from `Exception`.
💻 **Example:**
```python
class InsufficientFunds(Exception):
    def __init__(self, bal, amt):
        super().__init__(f"Need {amt - bal} more 💸")
```
🎯 **Interview:** Name ends in `Error`/`Exception`; build a hierarchy with a base library exception; keep them lightweight.

### 1️⃣4️⃣6️⃣ What is exception chaining (`raise ... from ...`)? 🔗
🧒 **Simple:** Keep the original error attached when you raise a new one.
💻 **Example:**
```python
try: int("x")
except ValueError as e:
    raise RuntimeError("parse failed") from e
```
🎯 **Interview:** Sets `__cause__` (explicit). Implicit chaining sets `__context__`. `from None` suppresses context.

### 1️⃣4️⃣7️⃣ What is the `assert` statement and when should you use assertions? ✅
🧒 **Simple:** A sanity check: "I bet this is true — crash if not."
💻 **Example:**
```python
assert x > 0, "x must be positive"
```
🎯 **Interview:** For internal invariants/debugging — **not** for validating user input (can be disabled). Raises `AssertionError`.

### 1️⃣4️⃣8️⃣ How do you disable assertions in Python? 🔇
🧒 **Simple:** Run Python with the `-O` flag.
💻 **Example:**
```bash
python -O script.py
```
🎯 **Interview:** `-O` removes `assert` and sets `__debug__ = False`. This is why asserts must not contain side effects or security checks.

---

# 📂 SECTION 6: Files, OS, Testing, Typing & Tooling

### 1️⃣4️⃣9️⃣ How do you open and read a file in Python? 📖
🧒 **Simple:** Open it, read it, close it.
💻 **Example:**
```python
with open("a.txt", encoding="utf-8") as f:
    text = f.read()          # whole file
    # f.readline(), for line in f
```
🎯 **Interview:** Always specify `encoding`. Iterate lines lazily for big files.

### 1️⃣5️⃣0️⃣ What are file access modes (`r`, `w`, `a`, `r+`, `b`)? 🎛️
🧒 **Simple:** How you want to use the file.
💻 **Example:**
```python
open("f", "r")   # read (default)
open("f", "w")   # write (erases!) 😱
open("f", "a")   # append
open("f", "r+")  # read+write
open("f", "rb")  # binary
```
🎯 **Interview:** Also `x` (exclusive create), `t` (text default), `w+`. `w` truncates immediately.

### 1️⃣5️⃣1️⃣ Why is using the `with` statement (context manager) recommended for file handling? 🛟
🧒 **Simple:** It closes the file for you, even if something breaks.
💻 **Example:**
```python
with open("a.txt") as f: ...
# f closed automatically
```
🎯 **Interview:** Guarantees cleanup (equivalent to try/finally), prevents resource leaks and data loss from unflushed buffers.

### 1️⃣5️⃣2️⃣ What is a context manager in Python? 🚪
🧒 **Simple:** Something that does setup when you enter `with` and cleanup when you leave.
💻 **Example:** files, locks, DB connections, `tempfile`, `decimal.localcontext`.
🎯 **Interview:** Any object implementing `__enter__` and `__exit__` (or `@contextmanager`). Foundation of RAII-like patterns in Python.

### 1️⃣5️⃣3️⃣ How do you implement a custom context manager using classes (`__enter__` and `__exit__`)? 🏗️
🧒 **Simple:** Write a class with two special methods.
💻 **Example:**
```python
class Timer:
    def __enter__(self):
        import time; self.t = time.time(); return self
    def __exit__(self, et, ev, tb):
        print("⏱️", time.time() - self.t)
        return False
with Timer(): sum(range(10**6))
```
🎯 **Interview:** `__enter__` return value binds to `as`. `__exit__` returning `True` suppresses exception.

### 1️⃣5️⃣4️⃣ How do you implement a custom context manager using generator functions (`contextlib.contextmanager`)? 🧙
🧒 **Simple:** Write a function with one `yield` — before is setup, after is cleanup.
💻 **Example:**
```python
from contextlib import contextmanager
@contextmanager
def tag(name):
    print(f"<{name}>"); 
    try: yield
    finally: print(f"</{name}>")
```
🎯 **Interview:** Wrap yield in `try/finally` so cleanup runs on exceptions. Less boilerplate than classes.

### 1️⃣5️⃣5️⃣ What are the arguments passed to the `__exit__` method of a context manager? 🚪🚶
🧒 **Simple:** Three details about any error that happened: type, value, traceback.
💻 **Example:**
```python
def __exit__(self, exc_type, exc_val, exc_tb): ...
```
🎯 **Interview:** All `None` if no exception. Return truthy to swallow the exception; falsy to propagate.

### 1️⃣5️⃣6️⃣ How do you handle CSV files in Python? 📊
🧒 **Simple:** Use the built-in `csv` module.
💻 **Example:**
```python
import csv
with open("a.csv", newline="") as f:
    for row in csv.DictReader(f): print(row["name"])
```
🎯 **Interview:** Use `newline=""`; `csv.writer`/`DictWriter`; handles quoting/escaping. For big analytics use pandas.

### 1️⃣5️⃣7️⃣ How do you handle JSON data in Python (`json.dumps` vs `json.dump`)? 🧾
🧒 **Simple:** `dumps` → makes a **s**tring. `dump` → writes to a **file**. Same for `loads`/`load`.
💻 **Example:**
```python
import json
s = json.dumps({"a": 1}, indent=2)
with open("a.json", "w") as f: json.dump({"a": 1}, f)
data = json.loads(s)
```
🎯 **Interview:** Mapping: dict↔object, list↔array, `None`↔null. Custom types need `default=` or custom encoder. Not all Python types are serializable (sets, datetime).

### 1️⃣5️⃣8️⃣ What is serialization and deserialization in Python? 📦➡️💾
🧒 **Simple:** Serialization = turning an object into text/bytes to save/send. Deserialization = turning it back.
💻 **Example:** `json`, `pickle`, `marshal`, `yaml`, `msgpack`, protobuf.
🎯 **Interview:** Aka marshalling. Choose format by interoperability, speed, security, schema evolution.

### 1️⃣5️⃣9️⃣ What is the difference between `pickle` and `json` modules? ⚔️
🧒 **Simple:** JSON is readable and universal. Pickle is Python-only and can store almost any object.
💻 **Example:**
```python
import pickle
b = pickle.dumps({1, 2})   # set works in pickle, not JSON
```
🎯 **Interview:** JSON: text, language-agnostic, safe, limited types. Pickle: binary, Python-specific, supports custom classes/functions, **insecure**.

### 1️⃣6️⃣0️⃣ What are the security risks associated with the `pickle` module? ☠️
🧒 **Simple:** Loading a bad pickle can run evil code on your computer!
💻 **Example:**
```python
# class Evil: def __reduce__(self): return (os.system, ("rm -rf /",))
```
🎯 **Interview:** `pickle.loads` on untrusted data → arbitrary code execution via `__reduce__`. Never unpickle untrusted data; use JSON, or sign data with HMAC.

### 1️⃣6️⃣1️⃣ What is the `io` module used for? 🚰
🧒 **Simple:** Tools to treat memory like a file.
💻 **Example:**
```python
import io
f = io.StringIO("a\nb"); print(f.readline())
b = io.BytesIO(b"123")
```
🎯 **Interview:** Core of Python's I/O stack: `RawIOBase`, `BufferedIOBase`, `TextIOBase`. In-memory streams are great for tests.

### 1️⃣6️⃣2️⃣ How do you work with paths using the `pathlib` module? 🧭
🧒 **Simple:** Treat paths as objects, not messy strings.
💻 **Example:**
```python
from pathlib import Path
p = Path("data") / "file.txt"
print(p.suffix, p.parent, p.exists())
p.write_text("hi"); print(p.read_text())
```
🎯 **Interview:** Cross-platform, `/` operator joins, methods: `glob`, `mkdir(parents=True, exist_ok=True)`, `resolve()`, `iterdir()`.

### 1️⃣6️⃣3️⃣ What is the difference between `os.path` and `pathlib`? 🆚
🧒 **Simple:** `os.path` = functions on strings (old school). `pathlib` = objects with methods (modern).
💻 **Example:**
```python
os.path.join("a", "b")   # old
Path("a") / "b"          # new
```
🎯 **Interview:** `pathlib` is OOP, more readable, chainable. `os.path` works with plain strings and is still ubiquitous. Use `os.fspath()` to convert.

### 1️⃣6️⃣4️⃣ How do you list directory contents using `os` or `pathlib`? 📁
🧒 **Simple:** Ask the folder what's inside.
💻 **Example:**
```python
import os; os.listdir(".")
from pathlib import Path
list(Path(".").glob("*.py"))
```
🎯 **Interview:** `os.scandir()` is faster (returns metadata). `rglob` for recursive.

### 1️⃣6️⃣5️⃣ How do you check if a file or directory exists? 🔎
🧒 **Simple:** Ask if it's there before using it.
💻 **Example:**
```python
Path("a.txt").exists(); .is_file(); .is_dir()
os.path.exists("a.txt")
```
🎯 **Interview:** Checking then using has a **race condition (TOCTOU)** → prefer try/except `FileNotFoundError`.

### 1️⃣6️⃣6️⃣ What is the `subprocess` module used for? 🖥️
🧒 **Simple:** Run other programs/commands from Python.
💻 **Example:**
```python
import subprocess
r = subprocess.run(["ls", "-l"], capture_output=True, text=True)
print(r.stdout)
```
🎯 **Interview:** Replaces `os.system`/`popen`. Use list args (avoid `shell=True` → injection). `check=True`, `timeout`, `Popen` for streaming.

### 1️⃣6️⃣7️⃣ What is the difference between `os.system` and `subprocess.run`? 🥊
🧒 **Simple:** `os.system` is a blunt tool; `subprocess.run` gives you control (output, errors, timeout).
💻 **Example:**
```python
os.system("ls")                        # returns exit code only
subprocess.run(["ls"], capture_output=True)  # captures output
```
🎯 **Interview:** `os.system` always uses shell, can't capture output, risky. `subprocess.run` is safer, flexible, recommended.

### 1️⃣6️⃣8️⃣ What is the `shutil` module used for? 🚚
🧒 **Simple:** High-level file operations: copy, move, delete folders.
💻 **Example:**
```python
import shutil
shutil.copy("a", "b"); shutil.rmtree("dir"); shutil.make_archive("bk","zip","dir")
```
🎯 **Interview:** Also `disk_usage`, `which`, `copytree`. Higher-level than `os`.

### 1️⃣6️⃣9️⃣ How do you handle environment variables using `os.environ`? 🌱
🧒 **Simple:** It's a dictionary of your computer's settings.
💻 **Example:**
```python
import os
key = os.environ.get("API_KEY", "none")
os.environ["MODE"] = "dev"
os.getenv("HOME")
```
🎯 **Interview:** Values are strings. Use for secrets/config (12-factor app). `os.environ["X"]` raises `KeyError` if missing. Never commit secrets.

### 1️⃣7️⃣0️⃣ What is the `argparse` module used for? ⌨️
🧒 **Simple:** Lets your script accept command-line options like `--name Bob`.
💻 **Example:**
```python
import argparse
p = argparse.ArgumentParser()
p.add_argument("--name", default="world")
args = p.parse_args(); print(args.name)
```
🎯 **Interview:** Auto-generates `--help`, validates types, supports subcommands. Alternatives: `click`, `typer`.

### 1️⃣7️⃣1️⃣ What is the `logging` module and what are its logging levels? 📝
🧒 **Simple:** A better `print` for recording what your app does, with importance levels.
💻 **Example:**
```python
import logging
logging.basicConfig(level=logging.INFO)
logging.warning("careful ⚠️")
```
🎯 **Interview:** Levels: `DEBUG(10) < INFO(20) < WARNING(30) < ERROR(40) < CRITICAL(50)`. Default root level is WARNING. Use `logging.getLogger(__name__)`.

### 1️⃣7️⃣2️⃣ How do you configure logging handlers and formatters? 🎛️
🧒 **Simple:** Handler = *where* logs go. Formatter = *how* they look.
💻 **Example:**
```python
import logging
log = logging.getLogger("app"); log.setLevel(logging.DEBUG)
h = logging.FileHandler("app.log")
h.setFormatter(logging.Formatter("%(asctime)s %(levelname)s %(message)s"))
log.addHandler(h)
```
🎯 **Interview:** Logger → Handler → Formatter (+ Filters). Handlers: Stream, File, Rotating, SMTP, HTTP. Propagation to parent loggers can cause duplicates. `dictConfig` for config.

### 1️⃣7️⃣3️⃣ What is the `unittest` framework in Python? 🧪
🧒 **Simple:** Built-in tool to write tests that check your code works.
💻 **Example:**
```python
import unittest
class T(unittest.TestCase):
    def test_add(self): self.assertEqual(1 + 1, 2)
unittest.main()
```
🎯 **Interview:** xUnit style: `setUp/tearDown`, assertions, test discovery, `unittest.mock`.

### 1️⃣7️⃣4️⃣ What is the `pytest` framework and why is it popular? 🏆
🧒 **Simple:** A friendlier, more powerful testing tool.
💻 **Example:**
```python
def test_add(): assert 1 + 1 == 2
```
🎯 **Interview:** Plain `assert` with rich introspection, fixtures, parametrization, plugins (`pytest-cov`, `xdist`), less boilerplate.

### 1️⃣7️⃣5️⃣ What are fixtures in pytest? 🔧
🧒 **Simple:** Reusable setup for tests (like preparing a clean kitchen before each recipe).
💻 **Example:**
```python
import pytest
@pytest.fixture
def db():
    conn = connect(); yield conn; conn.close()
def test_q(db): assert db.ok
```
🎯 **Interview:** Scopes: function/class/module/session. Dependency injection by argument name. `conftest.py` shares fixtures. Teardown via `yield`.

### 1️⃣7️⃣6️⃣ What is monkey patching in Python? 🐒🩹
🧒 **Simple:** Changing code while the program is running — like swapping a car's engine while driving! 🚗
💻 **Example:**
```python
import math
math.pi = 3        # 😈
class A: pass
A.hello = lambda self: "hi"
```
🎯 **Interview:** Dynamic modification of classes/modules at runtime. Used in tests (`unittest.mock.patch`, pytest `monkeypatch`), hotfixes, gevent. Risks: hidden behavior, hard debugging, version fragility.

### 1️⃣7️⃣7️⃣ What is type hinting in Python (PEP 484)? 🏷️
🧒 **Simple:** Labels that say what type a variable should be. Python ignores them when running; tools use them.
💻 **Example:**
```python
def add(a: int, b: int) -> int: return a + b
```
🎯 **Interview:** Annotations stored in `__annotations__`; not enforced at runtime. Used by mypy/pyright/IDEs.

### 1️⃣7️⃣8️⃣ What are the benefits of using type annotations? 🎁
🧒 **Simple:** Catch bugs early, better autocomplete, self-documenting.
💻 **Example:** `def f(x: list[str]) -> dict[str, int]: ...`
🎯 **Interview:** Static analysis, refactoring safety, IDE support, documentation, tools like pydantic/FastAPI use them at runtime.

### 1️⃣7️⃣9️⃣ What is the `typing` module (`Any`, `Union`, `Optional`, `Callable`, `TypeVar`)? 🧬
🧒 **Simple:** A toolbox of type labels.
💻 **Example:**
```python
from typing import Any, Optional, Callable, TypeVar
T = TypeVar("T")
def first(xs: list[T]) -> Optional[T]: ...
f: Callable[[int], str]
x: int | str     # 3.10+ Union
```
🎯 **Interview:** `Optional[X]` = `X | None`. `Any` disables checking. `TypeVar` = generics. Also `Protocol`, `Literal`, `TypedDict`, `Final`, `ParamSpec`.

### 1️⃣8️⃣0️⃣ What is runtime type checking and what tools support it (e.g., MyPy)? 🔍
🧒 **Simple:** Checking types for real while running, vs. just reading code beforehand.
💻 **Example:**
```bash
mypy app.py          # static
```
```python
# runtime: pydantic, typeguard, beartype, enforce
```
🎯 **Interview:** mypy/pyright/pytype are *static*. `pydantic`, `typeguard`, `beartype` enforce at *runtime*. Static checks cost nothing at runtime.

### 1️⃣8️⃣1️⃣ What is memory profiling in Python? 🧠📊
🧒 **Simple:** Measuring how much memory each part of code uses.
💻 **Example:**
```python
import tracemalloc
tracemalloc.start(); ...; print(tracemalloc.get_traced_memory())
```
🎯 **Interview:** Tools: `tracemalloc`, `memory_profiler` (`@profile`), `objgraph`, `pympler`, `sys.getsizeof` (shallow only).

### 1️⃣8️⃣2️⃣ What tools are used for profiling CPU performance in Python (`cProfile`)? ⏱️
🧒 **Simple:** Find which function is the slowpoke 🐌.
💻 **Example:**
```bash
python -m cProfile -s cumtime script.py
```
🎯 **Interview:** `cProfile` (deterministic, low overhead), `profile`, `line_profiler`, `py-spy` (sampling, attach to running process), `timeit` for micro-benchmarks, `snakeviz` to visualize.

### 1️⃣8️⃣3️⃣ What is garbage collection in Python? 🗑️♻️
🧒 **Simple:** Automatic cleanup of objects nobody uses.
💻 **Example:**
```python
import gc; gc.collect()
```
🎯 **Interview:** Two parts: reference counting (immediate) + generational cyclic GC (gen 0/1/2) for cycles.

### 1️⃣8️⃣4️⃣ How does reference counting work in Python memory management? 🔢
🧒 **Simple:** Each object has a counter of how many names use it. Zero → deleted.
💻 **Example:**
```python
import sys
a = []; print(sys.getrefcount(a))  # +1 for the argument itself
```
🎯 **Interview:** Incremented on assignment/passing, decremented on `del`/scope exit. Pros: deterministic cleanup. Cons: can't handle cycles, overhead on every op, GIL needed for thread safety.

### 1️⃣8️⃣5️⃣ How does the cyclic garbage collector work (`gc` module)? 🔄🗑️
🧒 **Simple:** It hunts for groups of objects that only point to each other and nobody else, then deletes them.
💻 **Example:**
```python
import gc
gc.get_threshold()     # (700, 10, 10)
gc.get_count()
```
🎯 **Interview:** Tracks container objects in 3 generations; young objects collected more often. Finds unreachable cycles by subtracting internal references. Can be disabled with `gc.disable()`.

### 1️⃣8️⃣6️⃣ What is a reference cycle and how does Python break it? 🔁
🧒 **Simple:** A points to B, B points to A — they keep each other alive forever.
💻 **Example:**
```python
a = {}; b = {"a": a}; a["b"] = b
del a, b   # still referenced by each other → GC cleans later
```
🎯 **Interview:** Broken by the cyclic GC (or manually with `weakref`). Since 3.4 objects with `__del__` in cycles are collectable (PEP 442).

### 1️⃣8️⃣7️⃣ What is the `sys.getrefcount()` function? 🔢
🧒 **Simple:** Shows how many references an object has.
💻 **Example:**
```python
import sys
x = []; print(sys.getrefcount(x))  # 2
```
🎯 **Interview:** Result is one higher than expected (temporary argument reference). Immortal objects in 3.12+ show huge counts.

---

# 🧵 SECTION 7: Concurrency, Threads, Processes & Asyncio

### 1️⃣8️⃣8️⃣ What is multithreading in Python? 🧵
🧒 **Simple:** Doing several things at once in the same program (sharing the same memory).
💻 **Example:**
```python
import threading
t = threading.Thread(target=print, args=("hi",)); t.start(); t.join()
```
🎯 **Interview:** Threads share memory; lightweight; best for I/O-bound work. Limited by GIL for CPU-bound code in CPython.

### 1️⃣8️⃣9️⃣ Why doesn't multithreading speed up CPU-bound tasks in CPython? 🐢
🧒 **Simple:** The GIL lets only one thread compute at a time, so threads just take turns.
💻 **Example:** Two threads each summing 10⁸ numbers take about the same time as one after the other.
🎯 **Interview:** GIL serializes bytecode execution; context switching adds overhead. Use `multiprocessing`, NumPy/C extensions that release GIL, or free-threaded Python 3.13+.

### 1️⃣9️⃣0️⃣ What is multiprocessing in Python? 👨‍👩‍👧‍👦
🧒 **Simple:** Running several separate Python programs in parallel — each has its own memory and its own GIL.
💻 **Example:**
```python
from multiprocessing import Pool
with Pool(4) as p: print(p.map(abs, [-1, -2]))
```
🎯 **Interview:** True parallelism on multiple cores. Costs: process start-up, pickling arguments, IPC, more memory. Start methods: fork, spawn, forkserver. Guard with `if __name__ == "__main__":`.

### 1️⃣9️⃣1️⃣ When should you use multithreading vs multiprocessing? 🤔
🧒 **Simple:** Waiting for stuff (internet/disk) → threads. Heavy calculating → processes.
💻 **Example:** Web scraping → threads/async. Image processing → processes.
🎯 **Interview:** I/O-bound → threading/asyncio. CPU-bound → multiprocessing. Many thousands of connections → asyncio.

### 1️⃣9️⃣2️⃣ What is the `concurrent.futures` module? 🔮
🧒 **Simple:** A simple, high-level way to run tasks in parallel and get results later ("futures").
💻 **Example:**
```python
from concurrent.futures import ThreadPoolExecutor
with ThreadPoolExecutor(4) as ex:
    print(list(ex.map(len, ["a", "bb"])))
```
🎯 **Interview:** `submit()` returns `Future`; `as_completed`, `wait`. Same API for threads and processes.

### 1️⃣9️⃣3️⃣ What is the difference between `ThreadPoolExecutor` and `ProcessPoolExecutor`? ⚔️
🧒 **Simple:** Pool of threads (shared memory, light) vs pool of processes (separate memory, parallel).
💻 **Example:**
```python
from concurrent.futures import ProcessPoolExecutor
```
🎯 **Interview:** Thread pool: I/O-bound, GIL-limited. Process pool: CPU-bound, args/results must be picklable, higher overhead.

### 1️⃣9️⃣4️⃣ What is asynchronous programming in Python (`asyncio`)? ⚡
🧒 **Simple:** One cook 👨‍🍳 starts many dishes and switches while waiting for the oven, instead of standing and waiting.
💻 **Example:**
```python
import asyncio
async def main():
    await asyncio.sleep(1); print("done")
asyncio.run(main())
```
🎯 **Interview:** Single-threaded cooperative concurrency using an event loop; ideal for high-concurrency I/O (sockets, HTTP). Blocking calls freeze the loop.

### 1️⃣9️⃣5️⃣ What are coroutines, event loops, and tasks in `asyncio`? 🎪
🧒 **Simple:** Coroutine = a pausable function. Event loop = the manager that runs them. Task = a coroutine scheduled to run.
💻 **Example:**
```python
async def work(): ...     # coroutine function
t = asyncio.create_task(work())   # Task
```
🎯 **Interview:** Calling `async def` returns a coroutine object (doesn't run until awaited/scheduled). Tasks wrap coroutines and run concurrently on the loop.

### 1️⃣9️⃣6️⃣ What is the difference between concurrency and parallelism? 🎭
🧒 **Simple:** Concurrency = juggling many tasks (one person). Parallelism = many people each doing a task at once. 🤹 vs 👯
💻 **Example:** asyncio = concurrent. multiprocessing on 4 cores = parallel.
🎯 **Interview:** Concurrency is about *structure* (dealing with many things); parallelism is about *execution* (doing many things simultaneously).

### 1️⃣9️⃣7️⃣ What is a race condition in multithreading? 🏎️💥
🧒 **Simple:** Two threads grab the same thing at the same time and mess it up.
💻 **Example:**
```python
counter = 0
def inc():
    global counter
    for _ in range(10**6): counter += 1   # not atomic!
```
🎯 **Interview:** Outcome depends on thread scheduling. `+=` is read-modify-write → not atomic. Fix: locks, queues, atomic ops, or avoid shared state.

### 1️⃣9️⃣8️⃣ How do you synchronize threads using locks (`threading.Lock`)? 🔐
🧒 **Simple:** Only the thread holding the key can enter the room.
💻 **Example:**
```python
lock = threading.Lock()
def inc():
    global counter
    with lock: counter += 1
```
🎯 **Interview:** Use `with lock`. Keep critical sections small. `RLock` for re-entrancy. Always acquire locks in consistent order.

### 1️⃣9️⃣9️⃣ What is a deadlock and how can it occur? 🪢
🧒 **Simple:** Two people each hold one chopstick and wait forever for the other's. 🥢
💻 **Example:**
```python
# T1: lock A then B   T2: lock B then A  → both stuck
```
🎯 **Interview:** Four Coffman conditions: mutual exclusion, hold-and-wait, no preemption, circular wait. Prevent with lock ordering, timeouts (`acquire(timeout=)`), or fewer locks.

### 2️⃣0️⃣0️⃣ What is a semaphore in threading? 🚦
🧒 **Simple:** A bouncer who lets only N people in at once.
💻 **Example:**
```python
sem = threading.Semaphore(3)
with sem: ...   # max 3 threads here
```
🎯 **Interview:** Counter-based limit on concurrent access (rate limiting, connection pools). `BoundedSemaphore` raises if released too many times.


### 2️⃣0️⃣1️⃣ What is a condition variable in threading? 📣
🧒 **Simple:** A way for threads to wait until someone shouts "Hey, something changed!" 🔔
💻 **Example:**
```python
cond = threading.Condition()
items = []
def consumer():
    with cond:
        while not items: cond.wait()
        print(items.pop())
def producer():
    with cond:
        items.append(1); cond.notify()
```
🎯 **Interview:** `wait()` releases the lock and sleeps; `notify()/notify_all()` wake waiters. Always re-check the condition in a `while` loop (spurious wakeups).

### 2️⃣0️⃣2️⃣ What is the `queue.Queue` class used for in multi-threading? 📬
🧒 **Simple:** A safe mailbox 📮 where threads drop and pick up messages without fighting.
💻 **Example:**
```python
from queue import Queue
q = Queue(); q.put("job"); print(q.get()); q.task_done()
```
🎯 **Interview:** Thread-safe FIFO with internal locks; `put/get` block, `maxsize` gives back-pressure; classic producer–consumer. Variants: `LifoQueue`, `PriorityQueue`, `SimpleQueue`.

### 2️⃣0️⃣3️⃣ What are pipes and queues in multiprocessing? 🚰
🧒 **Simple:** Ways for separate processes to talk. Pipe = a private phone line between two. Queue = a shared mailbox.
💻 **Example:**
```python
from multiprocessing import Pipe, Queue
a, b = Pipe(); a.send("hi"); print(b.recv())
```
🎯 **Interview:** Both pickle data. `Pipe` is faster but only 2 endpoints (duplex by default). `Queue` is multi-producer/consumer, built on pipe + locks.

### 2️⃣0️⃣4️⃣ How do you share state between processes (`Value`, `Array`, `Manager`)? 🤝
🧒 **Simple:** Processes don't share memory normally, so Python gives special shared boxes.
💻 **Example:**
```python
from multiprocessing import Value, Array, Manager
v = Value("i", 0); arr = Array("d", [1.0, 2.0])
m = Manager(); d = m.dict()
```
🎯 **Interview:** `Value/Array` use shared memory (ctypes), fast, need locks. `Manager` proxies Python objects through a server process (flexible but slower). Also `shared_memory` (3.8+).

### 2️⃣0️⃣5️⃣ What is the `async/await` syntax introduced in Python 3.5? ⏳
🧒 **Simple:** `async def` makes a pausable function; `await` says "pause here until this finishes, let others work."
💻 **Example:**
```python
async def fetch(): 
    await asyncio.sleep(1)
    return "data"
```
🎯 **Interview:** PEP 492. Native coroutines (replaced `@asyncio.coroutine` + `yield from`). `await` only allowed inside `async def`.

### 2️⃣0️⃣6️⃣ What is an event loop and how does it execute asynchronous tasks? 🎡
🧒 **Simple:** A big loop that checks "who's ready to run?" and runs them one by one.
💻 **Example:**
```python
loop = asyncio.new_event_loop()
loop.run_until_complete(main())
```
🎯 **Interview:** Single-threaded scheduler using OS selectors (epoll/kqueue/IOCP). Runs ready callbacks, polls I/O, handles timers. A blocking call stalls everything → use `run_in_executor`/`asyncio.to_thread`.

### 2️⃣0️⃣7️⃣ What is `asyncio.gather()` used for? 🧺
🧒 **Simple:** Run many async jobs at once and wait for all results together.
💻 **Example:**
```python
results = await asyncio.gather(fetch(1), fetch(2), fetch(3))
```
🎯 **Interview:** Returns results in input order; `return_exceptions=True` collects errors instead of raising first. 3.11+ `asyncio.TaskGroup` gives structured concurrency.

### 2️⃣0️⃣8️⃣ What is `asyncio.create_task()`? 🚀
🧒 **Simple:** "Start this job in the background right now."
💻 **Example:**
```python
t = asyncio.create_task(fetch())
... # do other stuff
res = await t
```
🎯 **Interview:** Schedules coroutine immediately on the loop. Keep a reference to the task (weak refs can get garbage-collected!). Supports `cancel()`.

### 2️⃣0️⃣9️⃣ What are async context managers and async iterators? 🔄⏳
🧒 **Simple:** Regular `with`/`for` but allowed to pause and wait inside.
💻 **Example:**
```python
async with session.get(url) as r: ...
async for row in cursor: ...
```
🎯 **Interview:** Use `__aenter__/__aexit__` and `__aiter__/__anext__`. Also `@asynccontextmanager` and async generators (`async def` + `yield`).

---

# 🚀 SECTION 8: Advanced Python Internals

### 2️⃣1️⃣0️⃣ What is Cython and why is it used? ⚡🐍
🧒 **Simple:** A tool that turns Python-like code into C so it runs *way* faster.
💻 **Example:**
```cython
def fib(int n):
    cdef int a = 0, b = 1
    ...
```
🎯 **Interview:** Superset of Python compiled to C extension; static typing → big speedups for numeric loops; can release GIL (`nogil`); wraps C/C++ libraries.

### 2️⃣1️⃣1️⃣ What is PyPy and how does it differ from CPython? 🏎️
🧒 **Simple:** Another Python engine with a smart "just-in-time" speed booster.
💻 **Example:** `pypy3 script.py`
🎯 **Interview:** PyPy has a tracing JIT (often 4–10× faster on pure-Python loops), different GC (not refcount), still has a GIL, weaker C-extension compatibility. CPython is the reference implementation.

### 2️⃣1️⃣2️⃣ What are abstract syntax trees (AST) in Python (`ast` module)? 🌳
🧒 **Simple:** Python turns your code into a tree of its structure before running it.
💻 **Example:**
```python
import ast
print(ast.dump(ast.parse("x = 1 + 2")))
```
🎯 **Interview:** Pipeline: source → tokens → AST → bytecode. Used by linters, formatters, code-gen, security scanners. `ast.literal_eval` safely evaluates literals.

### 2️⃣1️⃣3️⃣ What is metaprogramming in Python? 🧙‍♂️
🧒 **Simple:** Code that writes or changes code. 🪄
💻 **Example:** decorators, metaclasses, `type()`, `setattr`, `exec`, descriptors.
🎯 **Interview:** Python exposes its object model (classes are objects) enabling frameworks like Django ORM, dataclasses, SQLAlchemy, pydantic. Cost: complexity and debuggability.

### 2️⃣1️⃣4️⃣ How do you execute dynamic code using `exec()` and `eval()`? 🎬
🧒 **Simple:** `eval` runs an expression and gives a result. `exec` runs full code statements.
💻 **Example:**
```python
print(eval("2 + 3"))        # 5
exec("x = 10\nprint(x)")
```
🎯 **Interview:** `eval` → single expression returns value; `exec` → statements returns `None`. Both accept `globals`/`locals` dicts.

### 2️⃣1️⃣5️⃣ What are the security risks of `eval()` and `exec()`? ☠️
🧒 **Simple:** If a stranger gives you the text, they can run any code on your machine!
💻 **Example:**
```python
eval("__import__('os').system('rm -rf ~')")  # 💀
```
🎯 **Interview:** Arbitrary code execution/injection; restricting builtins isn't truly safe. Use `ast.literal_eval`, `json`, parsers, or sandboxes.

### 2️⃣1️⃣6️⃣ What is the `__slots__` attribute and why is it used? 🎰
🧒 **Simple:** Tells Python "this class only has these attributes" so it uses less memory.
💻 **Example:**
```python
class P:
    __slots__ = ("x", "y")
    def __init__(self, x, y): self.x, self.y = x, y
```
🎯 **Interview:** Replaces per-instance `__dict__` with fixed slots (descriptors) → lower memory & faster attribute access; prevents arbitrary new attributes.

### 2️⃣1️⃣7️⃣ How does `__slots__` affect memory usage and attribute assignment? 📉
🧒 **Simple:** Less memory per object, and you can't add random new attributes.
💻 **Example:**
```python
p = P(1, 2)
p.z = 3   # AttributeError 🚫
```
🎯 **Interview:** Can save ~40–50% for millions of small objects. No `__weakref__` unless declared. Pickle/multiple-inheritance gotchas.

### 2️⃣1️⃣8️⃣ What is the `__dict__` attribute of an object? 📒
🧒 **Simple:** A hidden dictionary where an object stores its attributes.
💻 **Example:**
```python
class A:
    def __init__(self): self.x = 1
print(A().__dict__)   # {'x': 1}
```
🎯 **Interview:** Instance `__dict__` holds instance attributes; class `__dict__` is a `mappingproxy`. Dynamic attribute add/remove works via it. Absent with `__slots__`.

### 2️⃣1️⃣9️⃣ What are descriptors in Python OOP internals? 🕹️
🧒 **Simple:** Objects that control what happens when you get/set/delete an attribute on another object.
💻 **Example:**
```python
class Positive:
    def __set_name__(self, owner, name): self.n = "_" + name
    def __get__(self, obj, t=None): return getattr(obj, self.n)
    def __set__(self, obj, v):
        if v < 0: raise ValueError
        setattr(obj, self.n, v)
```
🎯 **Interview:** Protocol: `__get__`, `__set__`, `__delete__`, `__set_name__`. Powers `property`, methods, `classmethod`, `staticmethod`, `__slots__`, ORMs.

### 2️⃣2️⃣0️⃣ What is a data descriptor vs a non-data descriptor? ⚖️
🧒 **Simple:** Data descriptor can *set*/delete too (strong boss 💪). Non-data only *gets* (weak boss).
💻 **Example:** `property` = data descriptor. Functions = non-data descriptor.
🎯 **Interview:** Data descriptors (`__set__` or `__delete__`) take precedence over instance `__dict__`; non-data descriptors can be shadowed by instance attributes.

### 2️⃣2️⃣1️⃣ How do properties (`property()`) work under the hood using descriptors? 🔧
🧒 **Simple:** `property` is a class that has `__get__`/`__set__` calling your functions.
💻 **Example:**
```python
class MyProp:
    def __init__(self, fget): self.fget = fget
    def __get__(self, obj, t=None): return self.fget(obj)
```
🎯 **Interview:** `@property` creates a data descriptor object stored in the class dict; attribute access triggers `type(obj).__dict__['x'].__get__`.

### 2️⃣2️⃣2️⃣ What is method resolution order (MRO)? 🧭
🧒 **Simple:** The order Python searches parent classes for a method.
💻 **Example:**
```python
class A: pass
class B(A): pass
print(B.__mro__)   # (B, A, object)
```
🎯 **Interview:** Linear order of classes for attribute lookup and `super()`. Ensures each class appears once and parents after children.

### 2️⃣2️⃣3️⃣ What algorithm does Python use to determine MRO (C3 linearization)? 🧮
🧒 **Simple:** A clever recipe that merges parent orders without breaking anyone's rules.
💻 **Example:** `L[C] = C + merge(L[A], L[B], [A, B])`
🎯 **Interview:** C3 guarantees monotonicity, local precedence order, and consistency; fails with `TypeError: Cannot create a consistent MRO` for inconsistent hierarchies.

### 2️⃣2️⃣4️⃣ How do you view the MRO of a class (`__mro__` or `.mro()`)? 👀
🧒 **Simple:** Just ask the class.
💻 **Example:**
```python
print(C.__mro__)
print(C.mro())
help(C)
```
🎯 **Interview:** `__mro__` is a tuple; `.mro()` returns a list and can be overridden in metaclasses.

### 2️⃣2️⃣5️⃣ What is the Diamond Problem in inheritance? 💎
🧒 **Simple:** D inherits from B and C; both inherit from A. If both override A's method, which one does D use?
💻 **Example:**
```python
class A: def hi(self): print("A")
class B(A): def hi(self): print("B")
class C(A): def hi(self): print("C")
class D(B, C): pass
D().hi()   # B
```
🎯 **Interview:** Ambiguity of inheriting the same ancestor via multiple paths; can lead to duplicate base initialization in languages like C++.

### 2️⃣2️⃣6️⃣ How does Python solve the Diamond Problem? 💎✅
🧒 **Simple:** MRO gives one clear order, and `A` appears only once.
💻 **Example:** `D.__mro__ → (D, B, C, A, object)`
🎯 **Interview:** C3 linearization + cooperative `super()` ensures each class's method runs once in a deterministic order.

### 2️⃣2️⃣7️⃣ What is the `super()` function and how does it work internally? 🦸
🧒 **Simple:** Calls the *next* class in line, not necessarily the direct parent.
💻 **Example:**
```python
class B(A):
    def hi(self):
        super().hi()
```
🎯 **Interview:** `super()` = `super(__class__, self)` (via the `__class__` cell); looks up the attribute in the MRO *after* the current class. Returns a proxy object.

### 2️⃣2️⃣8️⃣ How does `super()` resolve calls in cooperative multiple inheritance? 🤝
🧒 **Simple:** Each class calls `super()` so everyone in the chain gets a turn.
💻 **Example:**
```python
class A:
    def go(self): print("A")
class B(A):
    def go(self): print("B"); super().go()
class C(A):
    def go(self): print("C"); super().go()
class D(B, C):
    def go(self): print("D"); super().go()
D().go()   # D B C A
```
🎯 **Interview:** `super()` follows the instance's MRO, not the static parent. All classes must use `super()` and accept `*args/**kwargs` for cooperation.

### 2️⃣2️⃣9️⃣ What is monkey patching and when is it useful? 🐒🔧
🧒 **Simple:** Changing existing code at runtime without editing source — handy for tests and quick fixes.
💻 **Example:**
```python
from unittest.mock import patch
with patch("mod.func", return_value=42): ...
```
🎯 **Interview:** Useful for mocking external services, patching third-party bugs, gevent. Avoid in production; scope patches and restore them.

### 2️⃣3️⃣0️⃣ What is duck typing vs interface implementation? 🦆📜
🧒 **Simple:** Duck typing = "just have the methods." Interface = "formally promise to have these methods."
💻 **Example:**
```python
from typing import Protocol
class Speaker(Protocol):
    def speak(self) -> str: ...
```
🎯 **Interview:** Python supports implicit (duck/structural, `Protocol`) and explicit (nominal, ABC) contracts. Trade-off: flexibility vs early error detection.

### 2️⃣3️⃣1️⃣ What is defensive programming in Python? 🛡️
🧒 **Simple:** Write code assuming things will go wrong: validate inputs, handle errors.
💻 **Example:**
```python
def div(a, b):
    if b == 0: raise ValueError("b must not be 0")
    return a / b
```
🎯 **Interview:** Input validation, assertions for invariants, specific exceptions, safe defaults, logging, type hints, tests. Don't over-defend (hides bugs, clutters code). Balance with "fail fast".

### 2️⃣3️⃣2️⃣ What are Python virtual environments (`venv`, `virtualenv`)? 🏝️
🧒 **Simple:** A private sandbox with its own packages for each project.
💻 **Example:**
```bash
python -m venv .venv
source .venv/bin/activate    # Windows: .venv\Scripts\activate
```
🎯 **Interview:** `venv` is in stdlib; `virtualenv` is faster/more featureful. Creates isolated `site-packages` and a `python` symlink/copy.

### 2️⃣3️⃣3️⃣ Why should you use a virtual environment? 🧪
🧒 **Simple:** Project A needs Django 3, project B needs Django 5. Sandboxes stop them fighting!
💻 **Example:** `pip install django==3.2` in env A only.
🎯 **Interview:** Dependency isolation, reproducibility, avoids polluting system Python, no admin rights needed.

### 2️⃣3️⃣4️⃣ How do you install and manage packages using `pip`? 📦
🧒 **Simple:** `pip` is Python's app store.
💻 **Example:**
```bash
pip install requests
pip install -U requests
pip uninstall requests
pip list; pip freeze > requirements.txt
```
🎯 **Interview:** Use `python -m pip` to target correct interpreter. Pin versions, use hashes for security, consider `pip-tools`/`uv`.

### 2️⃣3️⃣5️⃣ What is a `requirements.txt` file? 📃
🧒 **Simple:** A shopping list of packages a project needs.
💻 **Example:**
```
requests==2.31.0
flask>=3.0
```
```bash
pip install -r requirements.txt
```
🎯 **Interview:** Enables reproducible installs. Separate files for dev/prod; lock transitive dependencies.

### 2️⃣3️⃣6️⃣ What is `pyproject.toml` and why is it becoming standard? 🧾
🧒 **Simple:** One config file for the project's name, dependencies, and tools.
💻 **Example:**
```toml
[project]
name = "myapp"
version = "0.1.0"
dependencies = ["requests"]
[build-system]
requires = ["hatchling"]
build-backend = "hatchling.build"
```
🎯 **Interview:** PEP 517/518/621: standard, tool-agnostic build + metadata, replaces `setup.py`/`setup.cfg`. Also holds config for black, ruff, pytest, mypy.

### 2️⃣3️⃣7️⃣ What is Poetry or Hatch in modern Python packaging? 🎭
🧒 **Simple:** Tools that manage dependencies, virtual envs, building and publishing in one.
💻 **Example:**
```bash
poetry init; poetry add requests; poetry build
hatch new myapp
```
🎯 **Interview:** Poetry: lockfile (`poetry.lock`), resolver, publish. Hatch: build backend + env/matrix manager. Alternatives: `uv`, `pdm`, `pip-tools`.

### 2️⃣3️⃣8️⃣ How do you handle timezone-aware datetimes using `datetime` and `zoneinfo`? 🌍🕐
🧒 **Simple:** Attach a timezone to a time so it means the same moment everywhere.
💻 **Example:**
```python
from datetime import datetime
from zoneinfo import ZoneInfo
now = datetime.now(ZoneInfo("Asia/Kolkata"))
utc = now.astimezone(ZoneInfo("UTC"))
```
🎯 **Interview:** `zoneinfo` (3.9+, IANA database) replaces `pytz`. Store in UTC, convert at display. Beware DST gaps/folds (`fold` attribute).

### 2️⃣3️⃣9️⃣ What is the difference between naive and aware `datetime` objects? 🆚
🧒 **Simple:** Naive = time with no timezone ("3 PM… where?"). Aware = has a timezone.
💻 **Example:**
```python
datetime.now().tzinfo            # None → naive
datetime.now(ZoneInfo("UTC")).tzinfo  # aware
```
🎯 **Interview:** Comparing/subtracting naive vs aware raises `TypeError`. Prefer aware datetimes; `datetime.utcnow()` is deprecated (returns naive).

### 2️⃣4️⃣0️⃣ What is string formatting performance comparison (f-strings vs `%` vs `.format()`)? 🏁
🧒 **Simple:** f-strings are the fastest runner. 🥇
💻 **Example:**
```python
import timeit
timeit.timeit('f"{a} {b}"', "a,b=1,2")
```
🎯 **Interview:** Typically f-string < `%` < `.format()` in time (f-strings compile to efficient bytecode). Readability usually matters more; use lazy `%s` in logging.

### 2️⃣4️⃣1️⃣ What are generators' `throw()` and `close()` use cases in asynchronous frameworks? 🧯
🧒 **Simple:** Frameworks use them to cancel a paused task or inject an error into it, and to clean up.
💻 **Example:** `task.cancel()` → raises `CancelledError` at the `await` (like `throw`).
🎯 **Interview:** Old coroutine frameworks (Twisted `inlineCallbacks`, `tornado.gen`) used `throw()` to deliver errors to coroutines; `close()` triggers `GeneratorExit` for cleanup. asyncio cancellation follows the same idea.

### 2️⃣4️⃣2️⃣ What is the `__ge__`, `__lt__`, etc. rich comparison overloading? ⚖️
🧒 **Simple:** Lets your objects work with `<`, `>`, `<=`, `>=`.
💻 **Example:**
```python
class V:
    def __init__(self, n): self.n = n
    def __lt__(self, o): return self.n < o.n
print(sorted([V(3), V(1)])[0].n)
```
🎯 **Interview:** Return `NotImplemented` for unsupported types. `sorted()` only needs `__lt__`. Use `functools.total_ordering` to fill in the rest.

### 2️⃣4️⃣3️⃣ What is the `__bool__` and `__len__` fallback for truthiness evaluation? 🤷
🧒 **Simple:** Python decides if an object is True/False by `__bool__`; if missing, by whether `__len__` is zero.
💻 **Example:**
```python
class Box:
    def __len__(self): return 0
print(bool(Box()))   # False
```
🎯 **Interview:** Order: `__bool__` → `__len__` → default `True`. `__bool__` must return a real `bool`.

### 2️⃣4️⃣4️⃣ How does Python implement hash tables for sets and dicts (collision resolution)? 🔨
🧒 **Simple:** Items are placed in slots based on their hash; if a slot is taken, Python tries another one.
💻 **Example:**
```python
print(hash("a") % 8)
```
🎯 **Interview:** Open addressing with pseudo-random probing (perturbation using hash bits). Resize at 2/3 full. Average O(1), worst O(n) with many collisions. Hash randomization (`PYTHONHASHSEED`) mitigates DoS.

### 2️⃣4️⃣5️⃣ What is the significance of immutable keys in dictionaries (hashability)? 🔑
🧒 **Simple:** If a key changed, Python couldn't find its slot anymore.
💻 **Example:**
```python
{(1, 2): "ok"}      # ✅
# {[1, 2]: "no"}    ❌
```
🎯 **Interview:** Stable hash required for lookup consistency. Equal objects must have equal hashes.

### 2️⃣4️⃣6️⃣ How do you make a custom class hashable? 🔨
🧒 **Simple:** Define `__eq__` and `__hash__` using the same fields.
💻 **Example:**
```python
class P:
    def __init__(self, x, y): self.x, self.y = x, y
    def __eq__(self, o): return (self.x, self.y) == (o.x, o.y)
    def __hash__(self): return hash((self.x, self.y))
```
🎯 **Interview:** Defining `__eq__` alone sets `__hash__ = None` (unhashable). `@dataclass(frozen=True)` auto-generates both.

### 2️⃣4️⃣7️⃣ What is the `__hash__` and `__eq__` contract in Python? 📜
🧒 **Simple:** If two things are equal, they must have the same hash.
💻 **Example:** `a == b ⟹ hash(a) == hash(b)` (the reverse need not be true).
🎯 **Interview:** Violations cause lost dict/set lookups. Hash should be computed from immutable fields only.

### 2️⃣4️⃣8️⃣ What happens if you mutate an object after using it as a dictionary key? 💥
🧒 **Simple:** Python looks in the wrong slot and the key seems to vanish! 👻
💻 **Example:**
```python
p = P(1, 2); d = {p: "x"}
p.x = 99
print(d.get(p))   # None 😱
```
🎯 **Interview:** Stored hash no longer matches the new one → lookup fails, entry becomes unreachable (memory leak-ish). Keep key fields immutable.

### 2️⃣4️⃣9️⃣ What is tail call optimization and does Python support it? 🐍🚫
🧒 **Simple:** A trick that makes certain recursive calls not use extra stack. Python does **not** do it.
💻 **Example:**
```python
def f(n, acc=1): return acc if n == 0 else f(n-1, acc*n)  # still grows stack
```
🎯 **Interview:** Guido deliberately rejected TCO (preserves tracebacks, clarity). Use loops, trampolines, or increase limit carefully.

### 2️⃣5️⃣0️⃣ How do you implement memoization in Python (`functools.lru_cache`)? 🧠💾
🧒 **Simple:** Remember answers you've already computed so you don't compute them again.
💻 **Example:**
```python
from functools import lru_cache, cache
@lru_cache(maxsize=None)
def fib(n): return n if n < 2 else fib(n-1) + fib(n-2)
print(fib(80))
```
🎯 **Interview:** Args must be hashable. `lru_cache` is thread-safe; `cache_info()`, `cache_clear()`. 3.9 adds `@cache`. Turns exponential Fibonacci to O(n).

### 2️⃣5️⃣1️⃣ What are weak references (`weakref` module) and why are they used? 🪢
🧒 **Simple:** A reference that doesn't keep the object alive — "I'll watch but won't hold on."
💻 **Example:**
```python
import weakref
class A: pass
a = A(); r = weakref.ref(a)
del a; print(r())   # None
```
🎯 **Interview:** For caches, observers, parent pointers. `WeakValueDictionary`, `WeakSet`, `weakref.finalize`. Not all built-ins (list, dict) are weak-referenceable.

### 2️⃣5️⃣2️⃣ How do weak references help prevent memory leaks in circular references? 🔁🩹
🧒 **Simple:** Child → parent link made weak so they don't hold each other forever.
💻 **Example:**
```python
class Child:
    def __init__(self, parent): self.parent = weakref.ref(parent)
```
🎯 **Interview:** Breaks strong cycles; also prevents caches/listener lists from keeping objects alive artificially.

### 2️⃣5️⃣3️⃣ What is the `gc.collect()` function and when should you call it? 🧹
🧒 **Simple:** Manually triggers a cleanup of cyclic garbage.
💻 **Example:**
```python
import gc; print(gc.collect())   # number of unreachable objects found
```
🎯 **Interview:** Rarely needed. Useful after deleting large cyclic structures, in tests/benchmarks, or after `gc.disable()` in batch jobs. Doesn't affect refcount-freed objects.

### 2️⃣5️⃣4️⃣ What is the `sys.settrace()` function used for? 🔭
🧒 **Simple:** Lets you watch every line of code as it runs — the basis of debuggers.
💻 **Example:**
```python
import sys
def tracer(frame, event, arg):
    print(event, frame.f_lineno); return tracer
sys.settrace(tracer)
```
🎯 **Interview:** Used by `pdb`, coverage.py. Very slow. 3.12 adds low-overhead `sys.monitoring`.

### 2️⃣5️⃣5️⃣ What is code coverage and how do tools measure it? 📈
🧒 **Simple:** The % of your code that tests actually ran.
💻 **Example:**
```bash
pytest --cov=myapp --cov-report=term-missing
```
🎯 **Interview:** Line, branch coverage via tracing (`sys.settrace`/C tracer/monitoring). 100% coverage ≠ bug-free; it only shows what was *executed*.

### 2️⃣5️⃣6️⃣ What is static analysis and what linters/formatters are used in Python (`flake8`, `black`, `pylint`, `ruff`)? 🧹
🧒 **Simple:** Tools that check code for mistakes/style without running it.
💻 **Example:**
```bash
black .; flake8 .; pylint app; ruff check .; mypy .
```
🎯 **Interview:** Linters find bugs/style issues (flake8, pylint, ruff). Formatters auto-style (black, ruff format, isort). Type checkers (mypy, pyright). Run in pre-commit/CI.

### 2️⃣5️⃣7️⃣ What is Ruff and why is it replacing older linters? 🦀⚡
🧒 **Simple:** A super-fast linter written in Rust that does the job of many tools at once.
💻 **Example:**
```bash
ruff check . --fix
ruff format .
```
🎯 **Interview:** 10–100× faster; implements rules from flake8, isort, pyupgrade, pycodestyle, etc.; auto-fix; single config in `pyproject.toml`.

### 2️⃣5️⃣8️⃣ How do you work with binary data using `bytes` and `bytearray`? 🔢
🧒 **Simple:** `bytes` = unchangeable raw data; `bytearray` = changeable raw data.
💻 **Example:**
```python
b = b"hi"; ba = bytearray(b); ba[0] = 72
print(b.decode("utf-8"), "é".encode("utf-8"))
```
🎯 **Interview:** Indexing gives ints (0–255). Use `memoryview` for zero-copy slicing. Always be explicit about encoding.

### 2️⃣5️⃣9️⃣ What is the `struct` module used for? 🧱
🧒 **Simple:** Converts Python values to raw bytes (like for network or file formats) and back.
💻 **Example:**
```python
import struct
data = struct.pack("<I2s", 258, b"ab")
print(struct.unpack("<I2s", data))
```
🎯 **Interview:** Format strings control byte order (`<` little, `>` big) and size. Used for binary protocols, file headers.

### 2️⃣6️⃣0️⃣ What is the `ctypes` module used for? 🔌
🧒 **Simple:** Lets Python call functions from C libraries (.dll/.so) directly.
💻 **Example:**
```python
import ctypes
libc = ctypes.CDLL("libc.so.6")
libc.printf(b"hi\n")
```
🎯 **Interview:** FFI in stdlib; no compile step; must declare `argtypes/restype`; risk of segfaults.

### 2️⃣6️⃣1️⃣ How do you call C/C++ libraries from Python using `ctypes` or `cffi`? 🌉
🧒 **Simple:** Load the library, tell Python the function's types, then call it.
💻 **Example:**
```python
lib = ctypes.CDLL("./libmath.so")
lib.add.argtypes = [ctypes.c_int, ctypes.c_int]
lib.add.restype = ctypes.c_int
print(lib.add(2, 3))
```
🎯 **Interview:** `cffi` parses C declarations (ABI/API mode, PyPy-friendly). Alternatives: Cython, pybind11, SWIG, CPython C API.

### 2️⃣6️⃣2️⃣ What is the `array` module and how does it differ from lists? 📏
🧒 **Simple:** Like a list but all items must be the same simple type, so it's compact.
💻 **Example:**
```python
from array import array
a = array("i", [1, 2, 3])
```
🎯 **Interview:** Stores raw C values (typecode) → less memory, no per-object overhead. Fewer features than NumPy arrays.

### 2️⃣6️⃣3️⃣ What is the difference between shallow and deep immutability? 🧊🧊
🧒 **Simple:** Shallow: the outer box can't change. Deep: nothing inside can change either.
💻 **Example:**
```python
t = ([1], 2)
t[0].append(9)    # allowed!  → (( [1, 9], 2)
```
🎯 **Interview:** Tuple/frozen dataclass are only shallowly immutable. Deep immutability requires immutable contents (e.g., tuple of tuples, `frozenset`, `MappingProxyType`).

### 2️⃣6️⃣4️⃣ What is a sentinel value in Python programming? 🚩
🧒 **Simple:** A special marker value meaning "nothing was provided" or "stop".
💻 **Example:**
```python
_MISSING = object()
def get(d, k, default=_MISSING):
    if default is _MISSING: ...
```
🎯 **Interview:** Use when `None` is a valid value. Also in `iter(callable, sentinel)`. Created with `object()` for unique identity.

---

# 🏛️ SECTION 9: Design Patterns, Lazy Evaluation & Circular Imports

### 2️⃣6️⃣5️⃣ How do you implement the Singleton pattern in Python? 👑
🧒 **Simple:** Make sure only ONE object of a class ever exists.
💻 **Example:**
```python
class Singleton:
    _inst = None
    def __new__(cls):
        if cls._inst is None:
            cls._inst = super().__new__(cls)
        return cls._inst
assert Singleton() is Singleton()
```
🎯 **Interview:** Ways: `__new__`, decorator, metaclass, or simply a module-level instance (Pythonic!). Mind thread safety (use a lock) and testability.

### 2️⃣6️⃣6️⃣ How do you implement the Factory pattern in Python? 🏭
🧒 **Simple:** A function that decides which class to create for you.
💻 **Example:**
```python
class Dog: ...
class Cat: ...
def pet(kind): return {"dog": Dog, "cat": Cat}[kind]()
```
🎯 **Interview:** Decouples creation from use. Variants: simple factory, factory method, abstract factory. Python's first-class classes make dict-based factories trivial.

### 2️⃣6️⃣7️⃣ How do you implement the Observer pattern in Python? 👀
🧒 **Simple:** Like YouTube subscribers 🔔 — when the channel posts, all subscribers get notified.
💻 **Example:**
```python
class Subject:
    def __init__(self): self._obs = []
    def subscribe(self, fn): self._obs.append(fn)
    def notify(self, *a): [fn(*a) for fn in self._obs]
s = Subject(); s.subscribe(print); s.notify("📢 new video!")
```
🎯 **Interview:** One-to-many dependency, decoupled publisher/subscriber. Use `weakref` to avoid leaks; related: event emitters, signals (Django), pub/sub.

### 2️⃣6️⃣8️⃣ How do you implement the Strategy pattern in Python? ♟️
🧒 **Simple:** Swap algorithms like swapping tools — pass in the function you want.
💻 **Example:**
```python
def pay(amount, strategy): return strategy(amount)
card = lambda a: f"💳 {a}"
upi = lambda a: f"📱 {a}"
print(pay(100, upi))
```
🎯 **Interview:** Python often uses plain functions instead of strategy classes. Follows the Open/Closed Principle.

### 2️⃣6️⃣9️⃣ What is the Adapter pattern and when is it used? 🔌
🧒 **Simple:** A travel plug adapter ✈️🔌 — makes one interface fit another.
💻 **Example:**
```python
class OldAPI: 
    def fetch_data(self): return "x"
class Adapter:
    def __init__(self, old): self.old = old
    def get(self): return self.old.fetch_data()
```
🎯 **Interview:** Structural pattern for integrating legacy/third-party code without modifying it; via composition (object adapter) or inheritance (class adapter).

### 2️⃣7️⃣0️⃣ What is the Decorator design pattern in OOP? 🎀🏛️
🧒 **Simple:** Wrap an object to add features dynamically, like adding toppings 🍕 to a pizza.
💻 **Example:**
```python
class Coffee: cost = lambda self: 5
class Milk:
    def __init__(self, c): self.c = c
    def cost(self): return self.c.cost() + 2
print(Milk(Coffee()).cost())  # 7
```
🎯 **Interview:** Structural pattern (GoF), same interface as wrapped object. Different from Python's `@decorator` syntax, though conceptually related (functions wrap functions).

### 2️⃣7️⃣1️⃣ What is the difference between structural design patterns and creational design patterns? 🧱 vs 🏭
🧒 **Simple:** Creational = *how objects are made*. Structural = *how objects are connected/arranged*.
💻 **Example:** Creational: Singleton, Factory, Builder, Prototype. Structural: Adapter, Decorator, Facade, Proxy, Composite, Bridge, Flyweight.
🎯 **Interview:** GoF has 3 groups: Creational (instantiation), Structural (composition of classes/objects), Behavioral (communication/responsibility).

### 2️⃣7️⃣2️⃣ What are behavioral design patterns? 🗣️
🧒 **Simple:** Patterns about how objects *talk* and share jobs.
💻 **Example:** Observer, Strategy, Command, State, Iterator, Template Method, Chain of Responsibility, Mediator, Memento, Visitor.
🎯 **Interview:** Focus on algorithms and assignment of responsibilities; reduce coupling between communicating objects.

### 2️⃣7️⃣3️⃣ How do you handle circular imports in Python? 🔄😵
🧒 **Simple:** A imports B and B imports A → loop! Fix by reorganizing.
💻 **Example:**
```python
# Fix: import inside function (lazy)
def f():
    from b import g
    return g()
```
🎯 **Interview:** Solutions: restructure (extract shared code into a third module), import the module not names (`import b`), local/lazy import, `TYPE_CHECKING` guard with string annotations, dependency inversion.

### 2️⃣7️⃣4️⃣ What is lazy evaluation and how do you achieve it in Python? 😴
🧒 **Simple:** Don't calculate until you really need the result.
💻 **Example:**
```python
squares = (x*x for x in range(10**9))   # nothing computed yet
from functools import cached_property
```
🎯 **Interview:** Tools: generators, `iter`, `range`, `map/filter/zip`, `itertools`, `cached_property`, `__getattr__` lazy loading, module `__getattr__` (PEP 562).

### 2️⃣7️⃣5️⃣ What is the purpose of `__init_subclass__`? 🧬
🧒 **Simple:** A hook that runs automatically whenever someone subclasses your class.
💻 **Example:**
```python
class Plugin:
    registry = []
    def __init_subclass__(cls, **kw):
        super().__init_subclass__(**kw)
        Plugin.registry.append(cls)
class A(Plugin): ...
print(Plugin.registry)
```
🎯 **Interview:** PEP 487 (3.6). Class customization/registration/validation without metaclasses; can accept class keyword args.

### 2️⃣7️⃣6️⃣ What is the purpose of `__new__` vs `__init__`? 🥚🐣
🧒 **Simple:** `__new__` *creates* the object (builds the house). `__init__` *sets it up* (decorates).
💻 **Example:**
```python
class A:
    def __new__(cls, *a): print("new"); return super().__new__(cls)
    def __init__(self): print("init")
A()   # new, init
```
🎯 **Interview:** `__new__` is a static method that returns the instance; `__init__` initializes it and returns `None`. Needed for immutable subclasses, singletons, caching instances.

### 2️⃣7️⃣7️⃣ When is `__new__` called instead of `__init__`? 🤔
🧒 **Simple:** It's actually called *before* `__init__`, always. You override it when you need to control creation.
💻 **Example:**
```python
class MyInt(int):
    def __new__(cls, v): return super().__new__(cls, abs(v))
print(MyInt(-5))  # 5
```
🎯 **Interview:** Both run on `cls(...)` via `type.__call__`. If `__new__` returns an instance of `cls`, `__init__` is called; otherwise it's skipped. Override `__new__` for immutable types (int, str, tuple).

### 2️⃣7️⃣8️⃣ Can `__new__` return an instance of a different class? 🎭
🧒 **Simple:** Yes! It can hand back any object.
💻 **Example:**
```python
class A:
    def __new__(cls): return "I'm a string now 🤪"
print(A())   # skips A.__init__
```
🎯 **Interview:** If the returned object isn't an instance of `cls`, `__init__` isn't called. Useful for factory-like classes, caching.

### 2️⃣7️⃣9️⃣ What is a metaclass in Python? 🦸‍♂️
🧒 **Simple:** The "class of a class" — a class that builds classes.
💻 **Example:**
```python
print(type(int))   # <class 'type'>
```
🎯 **Interview:** Default metaclass is `type`. Metaclasses control class creation: modify namespace, enforce rules, register classes. "If you wonder whether you need one, you don't" (Tim Peters).

### 2️⃣8️⃣0️⃣ How do you create a custom metaclass by inheriting from `type`? 🏗️
🧒 **Simple:** Subclass `type` and tell your class to use it.
💻 **Example:**
```python
class Meta(type):
    def __new__(mcs, name, bases, ns):
        ns["created_by"] = "Meta"
        return super().__new__(mcs, name, bases, ns)
class A(metaclass=Meta): ...
print(A.created_by)
```
🎯 **Interview:** Use `metaclass=` keyword. Resolved metaclass must be compatible across bases (metaclass conflict error).

### 2️⃣8️⃣1️⃣ What is the hook `__prepare__` in metaclasses? 🧰
🧒 **Simple:** Runs *before* the class body and gives the dictionary where class attributes are stored.
💻 **Example:**
```python
class Meta(type):
    @classmethod
    def __prepare__(mcs, name, bases):
        return {}   # could return OrderedDict or custom dict
```
🎯 **Interview:** Returns the namespace mapping used while executing the class body (PEP 3115). Allows detecting duplicate names or ordering (pre-3.6).

### 2️⃣8️⃣2️⃣ How do metaclasses control class creation? 🎛️
🧒 **Simple:** They step in at class-building time and can change the recipe.
💻 **Example:** Flow: `Meta.__prepare__` → class body executes → `Meta.__new__` → `Meta.__init__`.
🎯 **Interview:** `__new__` builds the class object; `__init__` post-processes; `__call__` controls instantiation. Used by Django models, ABCMeta, Enum.

### 2️⃣8️⃣3️⃣ What is the difference between a class decorator and a metaclass? ⚔️
🧒 **Simple:** Decorator tweaks the class *after* it's built. Metaclass changes *how* it's built.
💻 **Example:**
```python
def add_hi(cls): cls.hi = lambda s: "hi"; return cls
@add_hi
class A: ...
```
🎯 **Interview:** Class decorators are simpler, don't inherit to subclasses automatically, less magical. Metaclasses are inherited, can affect namespace and creation. Prefer decorators or `__init_subclass__` when possible.

### 2️⃣8️⃣4️⃣ What is the `abc` module and how do you define Abstract Base Classes? 🏗️
🧒 **Simple:** Tools to create classes that are blueprints and can't be used directly.
💻 **Example:**
```python
from abc import ABC, abstractmethod
class Shape(ABC):
    @abstractmethod
    def area(self): ...
```
🎯 **Interview:** Inherit `ABC` (metaclass `ABCMeta`). Subclasses must implement all abstract methods to be instantiable.

### 2️⃣8️⃣5️⃣ Can you instantiate an abstract base class directly? 🚫
🧒 **Simple:** No — Python says "this is only a blueprint!"
💻 **Example:**
```python
Shape()   # TypeError: Can't instantiate abstract class
```
🎯 **Interview:** Only if it has at least one abstract method. An ABC with no abstract methods *can* be instantiated.

### 2️⃣8️⃣6️⃣ What is the `@abstractmethod` decorator? ✍️
🧒 **Simple:** Marks a method that child classes MUST write.
💻 **Example:**
```python
class Circle(Shape):
    def area(self): return 3.14
```
🎯 **Interview:** Enforced at instantiation time. Abstract methods may still have a body callable via `super()`. Combine with `@classmethod`/`@property` (order: outer decorator first).

### 2️⃣8️⃣7️⃣ What are abstract properties in Python ABCs? 🏷️🏗️
🧒 **Simple:** A property children must define.
💻 **Example:**
```python
class A(ABC):
    @property
    @abstractmethod
    def name(self): ...
```
🎯 **Interview:** Stack `@property` then `@abstractmethod` (property outermost). `abstractproperty` is deprecated.

### 2️⃣8️⃣8️⃣ How do virtual subclasses work with ABCs (`register()` method)? 👻
🧒 **Simple:** You can declare "this class counts as a subclass" without it actually inheriting.
💻 **Example:**
```python
class Duck: ...
Shape.register(Duck)
print(issubclass(Duck, Shape))   # True
```
🎯 **Interview:** Affects `isinstance/issubclass` only—no inheritance, no MRO entry, no enforcement of abstract methods. Also `__subclasshook__` enables implicit structural checks (`collections.abc.Iterable`).


---

# 🧱 SECTION 10: Object-Oriented Programming (OOP) Fundamentals

### 2️⃣8️⃣9️⃣ What is Object-Oriented Programming (OOP)? 🧸
🧒 **Simple:** Organizing code around "things" (objects) that have data and actions, like a Dog 🐶 with a name and a bark.
💻 **Example:**
```python
class Dog:
    def __init__(self, name): self.name = name
    def bark(self): print(f"{self.name}: Woof!")
Dog("Rex").bark()
```
🎯 **Interview:** Paradigm bundling state + behavior; promotes modularity, reuse, maintainability. Python is multi-paradigm, not purely OOP-restricted.

### 2️⃣9️⃣0️⃣ What are the four core pillars of OOP? 🏛️
🧒 **Simple:** **E**ncapsulation, **A**bstraction, **I**nheritance, **P**olymorphism → "A PIE" 🥧
💻 **Example:** hide data (encapsulation), show only essentials (abstraction), reuse parents (inheritance), same method different behavior (polymorphism).
🎯 **Interview:** Be ready with one Python example for each, and mention Python's conventions (underscore privacy, ABCs, MRO, duck typing).

### 2️⃣9️⃣1️⃣ What is a class in Python OOP? 📐
🧒 **Simple:** A blueprint/cookie cutter 🍪.
💻 **Example:** `class Car: wheels = 4`
🎯 **Interview:** A class is itself an object (instance of `type`), created at runtime by executing the class body.

### 2️⃣9️⃣2️⃣ What is an object in Python OOP? 🍪
🧒 **Simple:** The actual cookie made from the cutter.
💻 **Example:** `my_car = Car()`
🎯 **Interview:** Everything in Python is an object: has identity (`id`), type, and value/state.

### 2️⃣9️⃣3️⃣ How do you define a class in Python? ✍️
🧒 **Simple:** Use `class Name:` and put methods inside.
💻 **Example:**
```python
class Person:
    """A person."""
    species = "human"
    def __init__(self, name): self.name = name
```
🎯 **Interview:** Class names use `CapWords` (PEP 8). `class A:` and `class A(object):` are the same in Py3.

### 2️⃣9️⃣4️⃣ How do you instantiate an object from a class? 🏭
🧒 **Simple:** Call the class like a function.
💻 **Example:**
```python
p = Person("Ann")
```
🎯 **Interview:** `Person("Ann")` → `type.__call__` → `__new__` → `__init__`. No `new` keyword.

### 2️⃣9️⃣5️⃣ What is the `self` parameter in class methods? 🪞
🧒 **Simple:** `self` means "me" — the specific object using the method.
💻 **Example:**
```python
class A:
    def say(self): print(id(self))
a = A(); a.say()   # same as A.say(a)
```
🎯 **Interview:** Explicit receiver passed automatically for bound methods. `obj.m()` ≡ `Class.m(obj)`.

### 2️⃣9️⃣6️⃣ Is `self` a keyword in Python? 🔑❓
🧒 **Simple:** Nope! It's just a name everybody agreed to use.
💻 **Example:** `self` can be any identifier.
🎯 **Interview:** Convention (PEP 8), not a reserved word. Keywords: `if`, `class`, `def`, etc.

### 2️⃣9️⃣7️⃣ Can you use a name other than `self` for instance methods? 🎭
🧒 **Simple:** Yes, it works... but your teammates will be mad 😡.
💻 **Example:**
```python
class A:
    def hi(this): print("works")
```
🎯 **Interview:** Works, but violates PEP 8 and hurts readability/tools. First parameter of metaclass methods is `cls`/`mcs`.

### 2️⃣9️⃣8️⃣ What is the constructor method in Python classes? 🏗️
🧒 **Simple:** `__init__` runs automatically when an object is created to set it up.
💻 **Example:**
```python
class P:
    def __init__(self, name): self.name = name
```
🎯 **Interview:** Technically `__init__` is an *initializer*; `__new__` is the true constructor. `__init__` must return `None`. Only one `__init__` (use default args / classmethods for alternatives).

### 2️⃣9️⃣9️⃣ What is the destructor method (`__del__`) and how does it behave? 💀
🧒 **Simple:** Runs when an object is about to be thrown away — but you can't predict exactly when.
💻 **Example:**
```python
class A:
    def __del__(self): print("bye 👋")
a = A(); del a
```
🎯 **Interview:** Called by the GC when refcount hits 0 (CPython) — timing not guaranteed (PyPy, cycles, interpreter shutdown). Prefer context managers or `weakref.finalize`. Exceptions in `__del__` are ignored/printed.

### 3️⃣0️⃣0️⃣ What are instance attributes? 🧍
🧒 **Simple:** Data that belongs to each individual object.
💻 **Example:**
```python
a = P("Ann"); b = P("Bob")   # separate names
```
🎯 **Interview:** Stored in instance `__dict__`; created in `__init__` usually (set all in `__init__` for clarity & hidden-class optimizations).

### 3️⃣0️⃣1️⃣ What are class attributes (static variables)? 🏫
🧒 **Simple:** Data shared by *all* objects of the class.
💻 **Example:**
```python
class Dog:
    species = "Canis"    # shared
```
🎯 **Interview:** Stored in class `__dict__`. Mutable class attributes (lists) are shared → common bug.

### 3️⃣0️⃣2️⃣ How do you access class attributes from an instance vs the class itself? 🔎
🧒 **Simple:** Both work. Instance lookup falls back to the class.
💻 **Example:**
```python
Dog.species; Dog().species
```
🎯 **Interview:** Lookup: instance dict → class (MRO). Assigning through an instance creates an instance attribute, not a class change.

### 3️⃣0️⃣3️⃣ What happens when an instance attribute shadows a class attribute? 🌑
🧒 **Simple:** The object's own value hides the class's value — only for that object.
💻 **Example:**
```python
d = Dog(); d.species = "Wolf"
print(d.species, Dog.species)   # Wolf Canis
del d.species                   # back to class value
```
🎯 **Interview:** Instance `__dict__` precedence over non-data descriptors/class attrs. `cls.attr += 1` via `self.attr += 1` creates instance attribute — classic counter bug.

### 3️⃣0️⃣4️⃣ What are instance methods? 🧑‍🔧
🧒 **Simple:** Methods that work on a specific object using `self`.
💻 **Example:**
```python
def bark(self): print(self.name)
```
🎯 **Interview:** Functions in the class become bound methods when accessed via instance (descriptor protocol).

### 3️⃣0️⃣5️⃣ What are class methods (`@classmethod`) and what is their first parameter (`cls`)? 🏫
🧒 **Simple:** Methods that work with the *class* itself, not one object.
💻 **Example:**
```python
class P:
    count = 0
    @classmethod
    def how_many(cls): return cls.count
```
🎯 **Interview:** First arg `cls` = the class (subclass if called on subclass). Common for alternative constructors.

### 3️⃣0️⃣6️⃣ When should you use a `@classmethod` instead of an instance method? 🤔
🧒 **Simple:** When you don't need a specific object but need the class (e.g., to create objects in another way).
💻 **Example:**
```python
class Date:
    def __init__(self, y, m, d): ...
    @classmethod
    def from_string(cls, s):
        y, m, d = map(int, s.split("-")); return cls(y, m, d)
```
🎯 **Interview:** Alternative constructors, factory methods, accessing/modifying class state; works correctly with inheritance (`cls`, not hardcoded name).

### 3️⃣0️⃣7️⃣ What are static methods (`@staticmethod`)? 🗿
🧒 **Simple:** A normal function that lives inside a class for organization; needs neither `self` nor `cls`.
💻 **Example:**
```python
class Math:
    @staticmethod
    def add(a, b): return a + b
```
🎯 **Interview:** No implicit first argument. Callable from class or instance.

### 3️⃣0️⃣8️⃣ When should you use a `@staticmethod`? 🧰
🧒 **Simple:** For helper functions logically related to the class but not using its data.
💻 **Example:** `Validator.is_email(s)`
🎯 **Interview:** If it doesn't touch class/instance state, consider a module-level function instead; static methods can't be overridden polymorphically w.r.t. class state.

### 3️⃣0️⃣9️⃣ What is the difference between instance methods, class methods, and static methods? 🥊
🧒 **Simple:** Instance → knows the object. Class → knows the class. Static → knows nothing.
💻 **Example:**
```python
class A:
    def i(self): ...
    @classmethod
    def c(cls): ...
    @staticmethod
    def s(): ...
```
🎯 **Interview:** Table: first arg `self` / `cls` / none; can access instance & class state / class state only / neither.

### 3️⃣1️⃣0️⃣ What is encapsulation in OOP? 💊
🧒 **Simple:** Wrapping data and methods together and hiding internal details — like a medicine capsule.
💻 **Example:**
```python
class Account:
    def __init__(self): self._balance = 0
    def deposit(self, x): self._balance += x
```
🎯 **Interview:** Controls access to state via methods/properties; protects invariants; enables changing internals without breaking users.

### 3️⃣1️⃣1️⃣ Does Python support true private members? 🔐
🧒 **Simple:** No — only "please don't touch" conventions.
💻 **Example:**
```python
a._Account__x   # still reachable
```
🎯 **Interview:** "We're all consenting adults." Single `_x` = protected by convention; `__x` = name-mangled; nothing truly enforced.

### 3️⃣1️⃣2️⃣ How does Python achieve name mangling for private attributes (`__variable`)? 🥴
🧒 **Simple:** Python renames `__x` to `_ClassName__x` inside the class.
💻 **Example:**
```python
class A:
    def __init__(self): self.__x = 1
print(A().__dict__)    # {'_A__x': 1}
```
🎯 **Interview:** Prevents accidental override in subclasses. Doesn't mangle names with trailing `__`. Not a security feature.

### 3️⃣1️⃣3️⃣ What is the convention for protected members in Python (`_variable`)? 🛡️
🧒 **Simple:** A single underscore says "internal use, hands off!"
💻 **Example:** `self._cache = {}`
🎯 **Interview:** PEP 8 convention; `from m import *` skips `_names`; subclasses may use them.

### 3️⃣1️⃣4️⃣ What are getters and setters in Python? 🔧
🧒 **Simple:** Methods to read and change an attribute safely.
💻 **Example:**
```python
def get_age(self): return self._age
def set_age(self, v): self._age = v
```
🎯 **Interview:** Un-Pythonic when trivial: use public attributes, and switch to `@property` later without changing the API.

### 3️⃣1️⃣5️⃣ How do you use the `@property` decorator to create managed attributes? 🎛️
🧒 **Simple:** Looks like a normal attribute, but runs code behind the scenes.
💻 **Example:**
```python
class Temp:
    def __init__(self, c): self._c = c
    @property
    def f(self): return self._c * 9/5 + 32
print(Temp(100).f)
```
🎯 **Interview:** Enables validation, computed values, lazy evaluation, read-only attributes with a stable interface.

### 3️⃣1️⃣6️⃣ Can you define a setter and deleter for a `@property`? ✅
🧒 **Simple:** Yes!
💻 **Example:**
```python
class P:
    @property
    def age(self): return self._age
    @age.setter
    def age(self, v):
        if v < 0: raise ValueError
        self._age = v
    @age.deleter
    def age(self): del self._age
```
🎯 **Interview:** Setter/deleter functions must have the same name as the property. Without a setter → read-only (`AttributeError`).

### 3️⃣1️⃣7️⃣ What is inheritance in OOP? 👨‍👧
🧒 **Simple:** A child class gets the abilities of its parent class for free.
💻 **Example:**
```python
class Animal: 
    def eat(self): print("nom")
class Dog(Animal): pass
Dog().eat()
```
🎯 **Interview:** "is-a" relationship; promotes reuse & polymorphism but increases coupling; favor composition when "has-a".

### 3️⃣1️⃣8️⃣ How do you implement single inheritance in Python? 👤
🧒 **Simple:** One parent in parentheses.
💻 **Example:** `class Dog(Animal): ...`
🎯 **Interview:** Simplest form; MRO is a straight line.

### 3️⃣1️⃣9️⃣ What is base class vs derived class (parent vs child class)? 👨‍👦
🧒 **Simple:** Base/parent = original. Derived/child = the one that inherits.
💻 **Example:** `Animal` (base) → `Dog` (derived)
🎯 **Interview:** Alternate terms: superclass/subclass. `Dog.__bases__` → `(Animal,)`, `Animal.__subclasses__()`.

### 3️⃣2️⃣0️⃣ How do you call a parent class method from a child class using `super()`? 📞
🧒 **Simple:** `super().method()` calls the parent's version.
💻 **Example:**
```python
class Dog(Animal):
    def eat(self):
        super().eat()
        print("wag 🐕")
```
🎯 **Interview:** Prefer `super()` over `Animal.eat(self)` (works with MRO/multiple inheritance).

### 3️⃣2️⃣1️⃣ What is method overriding? 🎭
🧒 **Simple:** Child writes its own version of a parent's method.
💻 **Example:**
```python
class Animal: 
    def speak(self): return "..."
class Dog(Animal):
    def speak(self): return "Woof"
```
🎯 **Interview:** Runtime dispatch by actual object type. Keep signature compatible (LSP). Python has no `@override` keyword before 3.12 (`typing.override` added).

### 3️⃣2️⃣2️⃣ How do you override the `__init__` method in a subclass? 🏗️
🧒 **Simple:** Write a new `__init__` and call the parent's one with `super()`.
💻 **Example:**
```python
class Dog(Animal):
    def __init__(self, name, breed):
        super().__init__(name)
        self.breed = breed
```
🎯 **Interview:** If you skip `super().__init__()`, parent attributes won't be set. Use `*args, **kwargs` for cooperative inheritance.

### 3️⃣2️⃣3️⃣ What is multiple inheritance in Python? 👨‍👩‍👧
🧒 **Simple:** A child with more than one parent.
💻 **Example:** `class Duck(Swimmer, Flyer): ...`
🎯 **Interview:** Supported; resolved by C3 MRO. Risks: diamond problem, complexity → use mixins and cooperative `super()`.

### 3️⃣2️⃣4️⃣ What is multi-level inheritance? 🪜
🧒 **Simple:** Grandparent → Parent → Child chain.
💻 **Example:** `class A: ...; class B(A): ...; class C(B): ...`
🎯 **Interview:** Deep chains → fragile, tightly coupled code.

### 3️⃣2️⃣5️⃣ What is hierarchical inheritance? 🌳
🧒 **Simple:** One parent, many children.
💻 **Example:** `class Cat(Animal)`, `class Dog(Animal)`
🎯 **Interview:** Common & natural: shared base with specialized subclasses.

### 3️⃣2️⃣6️⃣ What is hybrid inheritance? 🧬
🧒 **Simple:** A mix of two or more inheritance types (e.g., the diamond).
💻 **Example:** `class D(B, C)` where `B, C` inherit from `A`.
🎯 **Interview:** Combination of single/multiple/multilevel/hierarchical; MRO resolves it.

### 3️⃣2️⃣7️⃣ What is polymorphism in OOP? 🦎
🧒 **Simple:** "Many forms" — the same command makes different objects act differently.
💻 **Example:**
```python
for a in (Dog(), Cat()): print(a.speak())
```
🎯 **Interview:** Achieved via overriding, duck typing, operator overloading; enables writing code against abstractions.

### 3️⃣2️⃣8️⃣ What is compile-time polymorphism vs runtime polymorphism in Python? ⏱️
🧒 **Simple:** Compile-time (overloading by signature) doesn't really exist in Python; runtime (overriding/duck typing) does.
💻 **Example:**
```python
from functools import singledispatch
@singledispatch
def f(x): ...
@f.register(int)
def _(x): ...
```
🎯 **Interview:** Python has no method overloading by type; simulate with default args, `*args`, `singledispatch`, `typing.overload` (hints only). All real dispatch is at runtime.

### 3️⃣2️⃣9️⃣ How does Python achieve polymorphism through method overriding? 🎭
🧒 **Simple:** Python picks the method from the object's real class when the code runs.
💻 **Example:** `animal.speak()` → `Dog.speak` or `Cat.speak` depending on object.
🎯 **Interview:** Dynamic dispatch via attribute lookup through the MRO at call time.

### 3️⃣3️⃣0️⃣ What is operator overloading in Python? ➕🎭
🧒 **Simple:** Teaching `+`, `==`, `<` etc. how to work with your own objects.
💻 **Example:**
```python
class V:
    def __init__(s, x): s.x = x
    def __add__(s, o): return V(s.x + o.x)
```
🎯 **Interview:** Implemented via dunder methods; return `NotImplemented` for unsupported operand types to allow reflection.

### 3️⃣3️⃣1️⃣ How do you overload the `+` operator (`__add__`)? ➕
🧒 **Simple:** Define `__add__(self, other)`.
💻 **Example:**
```python
class Money:
    def __init__(s, v): s.v = v
    def __add__(s, o): return Money(s.v + o.v)
    def __repr__(s): return f"Money({s.v})"
print(Money(1) + Money(2))   # Money(3)
```
🎯 **Interview:** Also implement `__radd__` (for `sum()`, which starts with `0`) and `__iadd__` for in-place.

### 3️⃣3️⃣2️⃣ How do you overload the string representation methods (`__str__` and `__repr__`)? 🖨️
🧒 **Simple:** Decide how your object looks when printed.
💻 **Example:**
```python
class P:
    def __init__(s, n): s.n = n
    def __str__(s): return f"Person {s.n}"
    def __repr__(s): return f"P({s.n!r})"
```
🎯 **Interview:** Always define `__repr__` at least; `__str__` falls back to `__repr__`.

### 3️⃣3️⃣3️⃣ What is the difference between `__str__` and `__repr__`? 🆚
🧒 **Simple:** `__str__` = friendly text for users 😊. `__repr__` = exact text for developers 🧑‍💻.
💻 **Example:**
```python
import datetime
d = datetime.date(2024, 1, 1)
print(str(d)); print(repr(d))   # 2024-01-01  vs  datetime.date(2024, 1, 1)
```
🎯 **Interview:** `repr` should ideally be unambiguous and eval-able; used in debugging, containers (`[obj]` shows `repr`), logs.

### 3️⃣3️⃣4️⃣ Which one (`__str__` or `__repr__`) is used by the interactive shell? 🖥️
🧒 **Simple:** `__repr__`.
💻 **Example:** `>>> "hi"` shows `'hi'` (with quotes).
🎯 **Interview:** The REPL uses `repr()`; `print()` uses `str()`. `f"{x!r}"` forces repr.

### 3️⃣3️⃣5️⃣ What is composition in OOP? 🧩
🧒 **Simple:** Building objects by putting other objects inside them — a Car *has an* Engine. 🚗
💻 **Example:**
```python
class Engine: ...
class Car:
    def __init__(self): self.engine = Engine()
```
🎯 **Interview:** "has-a" with strong ownership: part's lifecycle depends on whole. More flexible than inheritance.

### 3️⃣3️⃣6️⃣ What is aggregation in OOP? 🎒
🧒 **Simple:** "Has-a" but the parts can live on their own — a Team has Players; if the team disbands, players still exist.
💻 **Example:**
```python
class Team:
    def __init__(self, players): self.players = players   # passed in
```
🎯 **Interview:** Weaker form of association; objects created externally and passed in.

### 3️⃣3️⃣7️⃣ What is the difference between composition and inheritance ("has-a" vs "is-a")? ⚔️
🧒 **Simple:** Inheritance: Dog **is an** Animal. Composition: Car **has an** Engine.
💻 **Example:** `class Car(Engine)` ❌ wrong; `self.engine = Engine()` ✅.
🎯 **Interview:** Inheritance = tight coupling, compile-time (class definition) relation. Composition = loose coupling, can swap parts at runtime.

### 3️⃣3️⃣8️⃣ When should you favor composition over inheritance? 🏆
🧒 **Simple:** Almost always, unless there's a true "is-a" relationship.
💻 **Example:** Use a `Logger` object instead of `class MyService(Logger)`.
🎯 **Interview:** Avoids fragile base class, deep hierarchies, tight coupling; easier testing/mocking; supports Strategy/Decorator patterns. GoF: "Favor object composition over class inheritance".

### 3️⃣3️⃣9️⃣ What is data abstraction in OOP? 🎩
🧒 **Simple:** Show only what's needed, hide the messy details — you drive a car without knowing the engine internals.
💻 **Example:** `list.sort()` — you don't know how, you just use it.
🎯 **Interview:** Achieved with interfaces/ABCs, clear public APIs, encapsulation. Reduces complexity.

### 3️⃣4️⃣0️⃣ How do Abstract Base Classes enforce abstraction? 👮
🧒 **Simple:** They refuse to create objects until children implement all required methods.
💻 **Example:**
```python
class Shape(ABC):
    @abstractmethod
    def area(self): ...
Shape()   # TypeError
```
🎯 **Interview:** `ABCMeta` tracks `__abstractmethods__`; checked in `object.__new__` at instantiation.

### 3️⃣4️⃣1️⃣ What is a mixin class in Python? 🍦
🧒 **Simple:** A small helper class that adds one feature to any class — like adding sprinkles 🍨.
💻 **Example:**
```python
class JsonMixin:
    def to_json(self):
        import json; return json.dumps(self.__dict__)
class User(JsonMixin): 
    def __init__(s): s.name = "Ann"
```
🎯 **Interview:** Not meant to stand alone, no state of its own (ideally), placed before the main base in the bases list. Examples: Django view mixins.

### 3️⃣4️⃣2️⃣ What is multiple inheritance used for in mixins? 🧪
🧒 **Simple:** To combine several small features into one class.
💻 **Example:** `class API(JsonMixin, LoggingMixin, BaseView): ...`
🎯 **Interview:** Composition of behaviors via MRO; must be cooperative (`super()`), avoid name clashes.

### 3️⃣4️⃣3️⃣ What is an interface in Python and how is it simulated? 🔌
🧒 **Simple:** A list of methods a class promises to have. Python has no `interface` keyword, so we pretend.
💻 **Example:**
```python
from typing import Protocol
class Flyer(Protocol):
    def fly(self) -> None: ...
```
🎯 **Interview:** Options: ABCs (nominal), `typing.Protocol` (structural), duck typing, `NotImplementedError` base methods.

### 3️⃣4️⃣4️⃣ What are magic methods (dunder methods) in Python? ✨
🧒 **Simple:** Special methods with double underscores that Python calls automatically.
💻 **Example:** `__init__`, `__str__`, `__len__`, `__add__`
🎯 **Interview:** Implement the Python data model so objects integrate with built-ins/operators. Don't call them directly; use `len(x)` not `x.__len__()`.

### 3️⃣4️⃣5️⃣ Why are they called dunder methods? 🤪
🧒 **Simple:** **D**ouble **UNDER**score → "dunder"! 🍺 (Easy to say: "dunder init")
💻 **Example:** `__init__` = "dunder init"
🎯 **Interview:** Nickname for double-underscore-delimited names; reserved for Python, don't invent your own `__foo__`.

### 3️⃣4️⃣6️⃣ What is the purpose of the `__len__` magic method? 📏
🧒 **Simple:** Makes `len(obj)` work.
💻 **Example:**
```python
class Bag:
    def __init__(s): s.items = [1, 2]
    def __len__(s): return len(s.items)
print(len(Bag()))
```
🎯 **Interview:** Must return non-negative int. Used in truthiness fallback.

### 3️⃣4️⃣7️⃣ What is the purpose of the `__getitem__` magic method? 🔍
🧒 **Simple:** Makes `obj[key]` work.
💻 **Example:**
```python
def __getitem__(self, i): return self.items[i]
```
🎯 **Interview:** Accepts ints, keys, or `slice` objects. Defining it alone makes object iterable (legacy sequence protocol) and supports `in`.

### 3️⃣4️⃣8️⃣ What is the purpose of the `__setitem__` magic method? ✏️
🧒 **Simple:** Makes `obj[key] = value` work.
💻 **Example:**
```python
def __setitem__(self, k, v): self.data[k] = v
```
🎯 **Interview:** Required for mutable mappings/sequences.

### 3️⃣4️⃣9️⃣ What is the purpose of the `__delitem__` magic method? 🗑️
🧒 **Simple:** Makes `del obj[key]` work.
💻 **Example:**
```python
def __delitem__(self, k): del self.data[k]
```
🎯 **Interview:** Part of `MutableMapping`/`MutableSequence` protocols.

### 3️⃣5️⃣0️⃣ What is the purpose of the `__iter__` and `__next__` magic methods in custom iterables? 🔁
🧒 **Simple:** Let your object be used in `for` loops.
💻 **Example:**
```python
class Rev:
    def __init__(s, d): s.d = d
    def __iter__(s): return iter(reversed(s.d))
for x in Rev([1, 2, 3]): print(x)
```
🎯 **Interview:** Prefer `__iter__` returning a generator/new iterator so the iterable is reusable; implement `__next__` only for true iterators.

### 3️⃣5️⃣1️⃣ What is the purpose of the `__contains__` magic method? 🎟️
🧒 **Simple:** Makes `x in obj` work.
💻 **Example:**
```python
def __contains__(self, item): return item in self.items
```
🎯 **Interview:** Fallback order: `__contains__` → `__iter__` → `__getitem__`.

### 3️⃣5️⃣2️⃣ What is the purpose of the `__call__` magic method? 📞
🧒 **Simple:** Lets you use an object like a function.
💻 **Example:**
```python
class Adder:
    def __init__(s, n): s.n = n
    def __call__(s, x): return x + s.n
print(Adder(5)(10))  # 15
```
🎯 **Interview:** Enables stateful callables, class-based decorators, functors, `callable(obj)` returns True.

### 3️⃣5️⃣3️⃣ How do you make an instance of a class callable like a function? ☎️
🧒 **Simple:** Add `__call__`.
💻 **Example:** `add5 = Adder(5); add5(1)`
🎯 **Interview:** Classes are callable too (via metaclass `__call__`). Callable instances keep state without closures.

### 3️⃣5️⃣4️⃣ What is the purpose of the `__enter__` and `__exit__` magic methods? 🚪
🧒 **Simple:** Make your object work with `with`.
💻 **Example:** `with Timer() as t: ...`
🎯 **Interview:** `__enter__` sets up and returns resource; `__exit__(exc_type, exc, tb)` cleans up; returning `True` suppresses the exception.

### 3️⃣5️⃣5️⃣ What is the purpose of the `__eq__` and `__ne__` magic methods? ⚖️
🧒 **Simple:** Define what `==` and `!=` mean for your objects.
💻 **Example:**
```python
def __eq__(self, o): return isinstance(o, P) and self.x == o.x
```
🎯 **Interview:** `__ne__` defaults to inverting `__eq__` in Py3. Define `__hash__` too if equal objects need to be hashable. Return `NotImplemented` for foreign types.

### 3️⃣5️⃣6️⃣ What is the purpose of the `__lt__`, `__le__`, `__gt__`, `__ge__` magic methods? 📊
🧒 **Simple:** Make `<`, `<=`, `>`, `>=` work.
💻 **Example:**
```python
def __lt__(self, o): return self.age < o.age
```
🎯 **Interview:** Enable sorting, `min/max`. Reflection: `a < b` tries `a.__lt__(b)` then `b.__gt__(a)`.

### 3️⃣5️⃣7️⃣ What is the `@functools.total_ordering` decorator? 🪄
🧒 **Simple:** Write `__eq__` and just one of `<`,`>`,`<=`,`>=` and it creates the others!
💻 **Example:**
```python
from functools import total_ordering
@total_ordering
class V:
    def __init__(s, n): s.n = n
    def __eq__(s, o): return s.n == o.n
    def __lt__(s, o): return s.n < o.n
```
🎯 **Interview:** Convenient but slightly slower than hand-written methods; dataclass `order=True` is an alternative.

### 3️⃣5️⃣8️⃣ What is the purpose of the `__add__`, `__sub__`, `__mul__`, `__truediv__` magic methods? 🧮
🧒 **Simple:** Make `+ - * /` work with your objects.
💻 **Example:**
```python
def __mul__(self, k): return Vec(self.x * k)
```
🎯 **Interview:** Also `__floordiv__`, `__mod__`, `__pow__`, `__matmul__` (`@`). Return a new object (don't mutate) for immutables.

### 3️⃣5️⃣9️⃣ What is reflected (or swapped) arithmetic operator overloading (`__radd__`, `__rsub__`, etc.)? 🔀
🧒 **Simple:** Handles `5 + obj` when the left side (5) doesn't know how to add your object.
💻 **Example:**
```python
def __radd__(self, other): return self.__add__(other)
print(sum([Money(1), Money(2)]))   # sum starts with 0 + Money
```
🎯 **Interview:** Needed for commutative operations with built-in types on the left. For subtraction/division, implement correct order.

### 3️⃣6️⃣0️⃣ When is a reflected arithmetic method called? 🪞
🧒 **Simple:** When the left operand's method returns `NotImplemented` or doesn't exist.
💻 **Example:** `1 + obj` → `int.__add__(1, obj)` → `NotImplemented` → `obj.__radd__(1)`.
🎯 **Interview:** Exception: if the right operand's type is a subclass of the left's and overrides the reflected method, it's tried first.


### 3️⃣6️⃣1️⃣ What is in-place arithmetic operator overloading (`__iadd__`, etc.)? 🔧
🧒 **Simple:** Makes `+=`, `-=` change the object itself instead of making a new one.
💻 **Example:**
```python
class Bag:
    def __init__(s): s.items = []
    def __iadd__(s, x): s.items.append(x); return s   # must return self!
b = Bag(); b += 1
```
🎯 **Interview:** If `__iadd__` is missing Python falls back to `a = a + b`. Must return the result (usually `self`). Lists mutate on `+=`, tuples don't — classic gotcha.

### 3️⃣6️⃣2️⃣ What is the purpose of the `__neg__`, `__pos__`, `__invert__` unary operators? ➖
🧒 **Simple:** Make `-obj`, `+obj`, `~obj` work.
💻 **Example:**
```python
def __neg__(self): return Vec(-self.x, -self.y)
```
🎯 **Interview:** Also `__abs__` for `abs()`. `__invert__` is bitwise NOT (`~`).

### 3️⃣6️⃣3️⃣ What is the purpose of the `__int__`, `__float__`, `__complex__` type conversion methods? 🔄
🧒 **Simple:** Let `int(obj)`, `float(obj)`, `complex(obj)` work.
💻 **Example:**
```python
class Money:
    def __init__(s, v): s.v = v
    def __int__(s): return int(s.v)
    def __float__(s): return float(s.v)
print(int(Money(9.9)))  # 9
```
🎯 **Interview:** Also `__bool__`, `__round__`, `__trunc__`. Must return the exact target type.

### 3️⃣6️⃣4️⃣ What is the purpose of the `__index__` magic method? 📍
🧒 **Simple:** Lets your object be used as a list index or in `range()`, `bin()`, `hex()`.
💻 **Example:**
```python
class N:
    def __index__(s): return 2
print([10, 20, 30][N()])   # 30
```
🎯 **Interview:** Lossless integer conversion (PEP 357); used by NumPy ints. Different from `__int__` (can be lossy).

### 3️⃣6️⃣5️⃣ What is the purpose of the `__format__` magic method? 🎨
🧒 **Simple:** Controls what happens in `f"{obj:spec}"`.
💻 **Example:**
```python
class T:
    def __format__(s, spec): return "UPPER" if spec == "u" else "normal"
print(f"{T():u}")
```
🎯 **Interview:** Receives the format spec string; called by `format()` and f-strings. Default delegates to `str()` when spec empty.

### 3️⃣6️⃣6️⃣ What is the purpose of the `__dir__` magic method? 📋
🧒 **Simple:** Controls what `dir(obj)` shows.
💻 **Example:**
```python
def __dir__(self): return ["a", "b"]
```
🎯 **Interview:** Helps autocomplete with dynamic attributes (e.g., `__getattr__`-based proxies). Result is sorted by `dir()`.

### 3️⃣6️⃣7️⃣ What is the purpose of the `__sizeof__` magic method? 📦
🧒 **Simple:** Reports how many bytes the object uses (used by `sys.getsizeof`).
💻 **Example:**
```python
import sys
print(sys.getsizeof([]))
```
🎯 **Interview:** `getsizeof` adds GC header overhead; measures *shallow* size only. For total, recurse or use `pympler.asizeof`.

### 3️⃣6️⃣8️⃣ What is the purpose of the `__copy__` and `__deepcopy__` magic methods? 👯
🧒 **Simple:** Let you customize how `copy.copy()` and `copy.deepcopy()` duplicate your object.
💻 **Example:**
```python
def __deepcopy__(self, memo):
    new = type(self)(); memo[id(self)] = new
    new.data = copy.deepcopy(self.data, memo); return new
```
🎯 **Interview:** Use `memo` to handle cycles. Useful for objects holding unpicklable/unshareable resources (locks, sockets).

### 3️⃣6️⃣9️⃣ What is the purpose of the `__getattr__` magic method? 🕵️
🧒 **Simple:** A fallback: runs when an attribute is *not found* the normal way.
💻 **Example:**
```python
class Ghost:
    def __getattr__(self, name): return f"👻 no {name}, but here's a fake"
print(Ghost().boo)
```
🎯 **Interview:** Enables proxies, delegation, lazy attributes, dynamic APIs. Must raise `AttributeError` for unknown names (so `hasattr` works).

### 3️⃣7️⃣0️⃣ When is `__getattr__` called? ⏰
🧒 **Simple:** Only after normal lookup fails.
💻 **Example:** `obj.x` → check instance dict, class, parents → fails → `__getattr__("x")`.
🎯 **Interview:** Called only on *failed* lookup (`AttributeError` from `__getattribute__`).

### 3️⃣7️⃣1️⃣ What is the purpose of the `__getattribute__` magic method? 🚪
🧒 **Simple:** Runs on **every** attribute access, always.
💻 **Example:**
```python
class Spy:
    def __getattribute__(self, n):
        print("accessing", n)
        return super().__getattribute__(n)
```
🎯 **Interview:** The primary hook; implements default lookup (descriptors, dict, MRO). Slows all attribute access; use sparingly.

### 3️⃣7️⃣2️⃣ What is the difference between `__getattr__` and `__getattribute__`? ⚔️
🧒 **Simple:** `__getattribute__` = the front door (always). `__getattr__` = the back-up door when the front fails.
💻 **Example:** See above two examples.
🎯 **Interview:** `__getattribute__` called for every access; `__getattr__` only if it raised `AttributeError`. Overriding `__getattribute__` is riskier.

### 3️⃣7️⃣3️⃣ What is a common pitfall when implementing `__getattribute__` (infinite recursion)? ♾️💥
🧒 **Simple:** If inside it you access `self.something`, it calls itself again forever!
💻 **Example:**
```python
def __getattribute__(self, n):
    return self.x          # ❌ infinite recursion
def __getattribute__(self, n):
    return super().__getattribute__(n)   # ✅
```
🎯 **Interview:** Always delegate via `object.__getattribute__(self, name)` / `super()`. Same for `__setattr__`.

### 3️⃣7️⃣4️⃣ What is the purpose of the `__setattr__` magic method? ✍️
🧒 **Simple:** Runs whenever you assign `obj.x = 5`.
💻 **Example:**
```python
def __setattr__(self, n, v):
    print("setting", n)
    super().__setattr__(n, v)
```
🎯 **Interview:** Use for validation, immutability, logging. Assigning `self.x = ...` inside it recurses—use `super().__setattr__` or `self.__dict__`.

### 3️⃣7️⃣5️⃣ What is the purpose of the `__delattr__` magic method? 🗑️
🧒 **Simple:** Runs on `del obj.x`.
💻 **Example:**
```python
def __delattr__(self, n): raise AttributeError("can't delete 🚫")
```
🎯 **Interview:** Pairs with `__setattr__` for read-only objects.

### 3️⃣7️⃣6️⃣ What is the purpose of the `__dir__` method in object customization? 🧰
🧒 **Simple:** Same as before: tells `dir()` what attributes to list — helps tools show fake/dynamic attributes.
💻 **Example:**
```python
def __dir__(self): return list(self._fields) + ["extra"]
```
🎯 **Interview:** Combine with `__getattr__` so IDEs/REPL tab-complete dynamic names.

### 3️⃣7️⃣7️⃣ How do custom descriptors work with `__get__`, `__set__`, and `__delete__`? 🧲
🧒 **Simple:** A class attribute object that intercepts access on instances.
💻 **Example:**
```python
class Typed:
    def __init__(s, t): s.t = t
    def __set_name__(s, o, n): s.n = "_" + n
    def __get__(s, obj, owner=None): return s if obj is None else getattr(obj, s.n)
    def __set__(s, obj, v):
        if not isinstance(v, s.t): raise TypeError(s.t)
        setattr(obj, s.n, v)
    def __delete__(s, obj): delattr(obj, s.n)
class P:
    age = Typed(int)
```
🎯 **Interview:** Descriptors live on the *class*; per-instance data must be stored on the instance (not on descriptor, else shared!). `__set_name__` (3.6) provides the attribute name.

### 3️⃣7️⃣8️⃣ What is a non-data descriptor (only defines `__get__`)? 👁️
🧒 **Simple:** Read-only helper; the object can override it by storing its own attribute.
💻 **Example:** Plain functions → methods; `classmethod`, `staticmethod`, `functools.cached_property`.
🎯 **Interview:** Lower priority than instance `__dict__`. That's why `cached_property` can store the computed value in the instance dict to bypass itself next time.

### 3️⃣7️⃣9️⃣ What is a data descriptor (defines `__set__` or `__delete__`)? 💪
🧒 **Simple:** A strong descriptor that wins over the instance dictionary.
💻 **Example:** `property`, `__slots__` member descriptors.
🎯 **Interview:** Takes precedence in lookup: data descriptor → instance dict → non-data descriptor/class attr.

### 3️⃣8️⃣0️⃣ What is the attribute lookup precedence in Python (descriptors vs instance dict vs class dict)? 🥇🥈🥉
🧒 **Simple:** Order Python checks when you write `obj.x`.
💻 **Example:** `obj.x` →
1. 🥇 Data descriptor on the type (MRO)
2. 🥈 Instance `__dict__`
3. 🥉 Non-data descriptor / plain class attribute
4. 🆘 `__getattr__`
🎯 **Interview:** Implemented in `object.__getattribute__`. Know this ordering for questions about `property` overriding instance attributes.

### 3️⃣8️⃣1️⃣ How does Python find an attribute on an instance? 🔍
🧒 **Simple:** Looks in the object, then the class, then parent classes (in MRO order).
💻 **Example:**
```python
class A: x = 1
class B(A): pass
print(B().x)   # found in A
```
🎯 **Interview:** `type(obj).__mro__` search for descriptors; then `obj.__dict__`; then class attributes; finally `__getattr__`. Special method lookups (`len(x)`) bypass instance dict and go via the type.

---

# 🧙 SECTION 11: Metaclasses, Dataclasses & Enums

### 3️⃣8️⃣2️⃣ What is a metaclass and how does it relate to classes and objects? 🧬
🧒 **Simple:** Object ← made by Class ← made by Metaclass (`type`). Like: cookie ← cutter ← cutter factory. 🍪🏭
💻 **Example:**
```python
print(type(5), type(type(5)), type(type))
# <class 'int'> <class 'type'> <class 'type'>
```
🎯 **Interview:** Metaclass is the class of a class. `type` is its own metaclass.

### 3️⃣8️⃣3️⃣ In Python, are classes objects themselves? 🤯
🧒 **Simple:** Yes! Classes can be passed around, stored, and modified like any object.
💻 **Example:**
```python
cls = int
print(cls("5"))      # 5
A = type("A", (), {})
```
🎯 **Interview:** First-class classes enable factories, registries, dynamic class creation, and metaprogramming.

### 3️⃣8️⃣4️⃣ What is the type of a standard Python class? 🏷️
🧒 **Simple:** `type`.
💻 **Example:**
```python
class A: pass
print(type(A))   # <class 'type'>
```
🎯 **Interview:** Default metaclass; `ABC` classes have `ABCMeta`; Enums have `EnumMeta` (`EnumType`).

### 3️⃣8️⃣5️⃣ What is the root of the class hierarchy in Python (`object`)? 👑
🧒 **Simple:** Every class secretly inherits from `object`.
💻 **Example:**
```python
print(int.__mro__)    # (<class 'int'>, <class 'object'>)
```
🎯 **Interview:** `object` provides default `__init__`, `__repr__`, `__eq__`, `__hash__`, `__getattribute__`. Everything is an instance of `object`.

### 3️⃣8️⃣6️⃣ What is the root of the type hierarchy in Python (`type`)? 🌲
🧒 **Simple:** `type` is the ultimate class-maker; every class is an instance of `type`.
💻 **Example:**
```python
print(isinstance(object, type), isinstance(type, object))   # True True
```
🎯 **Interview:** The circularity: `type` is a subclass of `object`, and `object` is an instance of `type`. Both bootstrapped by the interpreter.

### 3️⃣8️⃣7️⃣ How do you create a class dynamically using `type()` function? 🏗️⚡
🧒 **Simple:** Build a class at runtime using `type(name, bases, dict)`.
💻 **Example:**
```python
Dog = type("Dog", (object,), {"sound": "Woof", "speak": lambda s: s.sound})
print(Dog().speak())
```
🎯 **Interview:** What the `class` statement does under the hood. Used for plugin systems, ORMs, `namedtuple`, `make_dataclass`.

### 3️⃣8️⃣8️⃣ What are the arguments passed to `type(name, bases, dict)`? 🎁
🧒 **Simple:** Name of class, tuple of parents, dictionary of attributes/methods.
💻 **Example:** `type("A", (Base,), {"x": 1})`
🎯 **Interview:** `name`: str; `bases`: tuple of classes; `dict`: namespace (becomes `__dict__`, copied). With one argument `type(x)` returns the type.

### 3️⃣8️⃣9️⃣ How do you write a custom metaclass by inheriting from `type`? ✍️
🧒 **Simple:** `class Meta(type): ...` then use `metaclass=Meta`.
💻 **Example:**
```python
class UpperAttrs(type):
    def __new__(mcs, name, bases, ns):
        ns = {k if k.startswith("__") else k.upper(): v for k, v in ns.items()}
        return super().__new__(mcs, name, bases, ns)
class A(metaclass=UpperAttrs):
    x = 1
print(A.X)
```
🎯 **Interview:** Keep metaclasses small; cooperate with others via `super()`.

### 3️⃣9️⃣0️⃣ What is the role of `__new__` in a metaclass? 🥚
🧒 **Simple:** It *creates* the class object and can change its name, bases, or attributes before it exists.
💻 **Example:** See `UpperAttrs.__new__` above.
🎯 **Interview:** Signature `(mcs, name, bases, namespace, **kwargs)`. Use when you must alter namespace/bases.

### 3️⃣9️⃣1️⃣ What is the role of `__init__` in a metaclass? 🐣
🧒 **Simple:** Runs after the class is created to finish setup.
💻 **Example:**
```python
class Meta(type):
    def __init__(cls, name, bases, ns):
        super().__init__(name, bases, ns)
        cls.registry = []
```
🎯 **Interview:** Can't change name/bases/namespace anymore; good for registration and validation.

### 3️⃣9️⃣2️⃣ What is the `__call__` method in a metaclass and how does it intercept instance creation? 📞
🧒 **Simple:** Runs when you do `MyClass()`; you can control (or block/reuse) instance creation.
💻 **Example:**
```python
class Singleton(type):
    _i = {}
    def __call__(cls, *a, **k):
        if cls not in cls._i:
            cls._i[cls] = super().__call__(*a, **k)
        return cls._i[cls]
class DB(metaclass=Singleton): ...
assert DB() is DB()
```
🎯 **Interview:** `type.__call__` normally calls `__new__` then `__init__`; overriding it is the way metaclass-based Singletons work.

### 3️⃣9️⃣3️⃣ How can metaclasses be used for API validation or registration? ✅📝
🧒 **Simple:** Auto-check a class has required methods, or auto-add it to a list.
💻 **Example:**
```python
class Checked(type):
    def __init__(cls, n, b, ns):
        if b and "run" not in ns: raise TypeError(f"{n} must define run()")
        super().__init__(n, b, ns)
```
🎯 **Interview:** Used by Django models, SQLAlchemy declarative base, ABCs, plugin registries. Modern alternative: `__init_subclass__`.

### 3️⃣9️⃣4️⃣ What is the alternative to metaclasses introduced in Python 3.6 for class customization (`__init_subclass__`)? 🆕
🧒 **Simple:** A simpler hook inside the parent class that runs when subclassed.
💻 **Example:** See Q275.
🎯 **Interview:** PEP 487. Covers most registration/validation use cases without metaclass complexity (and no metaclass conflicts). Also `__set_name__`.

### 3️⃣9️⃣5️⃣ What are the advantages of `__init_subclass__` over metaclasses? 🏆
🧒 **Simple:** Easier to write, easier to read, and combines well with other libraries.
💻 **Example:** `class Base: def __init_subclass__(cls, /, tag, **kw): cls.tag = tag`
🎯 **Interview:** No metaclass conflict, less magic, easy composition, supports class keyword args (`class A(Base, tag="x")`). Metaclass still needed for `__prepare__`, `__call__`, or altering class creation deeply.

### 3️⃣9️⃣6️⃣ What is class-level encapsulation and how can it be enforced? 🏰
🧒 **Simple:** Protecting class-wide data/behavior from outside tampering.
💻 **Example:**
```python
class Config:
    __slots__ = ()
    _settings = MappingProxyType({"debug": False})
```
🎯 **Interview:** Python: conventions (`_x`, `__x`), read-only properties/descriptors, `MappingProxyType`, frozen dataclasses, metaclass-level `__setattr__` to block class attribute changes, `typing.Final` (static only).

### 3️⃣9️⃣7️⃣ What is the `@dataclass` decorator introduced in Python 3.7? 📦✨
🧒 **Simple:** Auto-writes boring boilerplate (`__init__`, `__repr__`, `__eq__`) for classes that mostly hold data.
💻 **Example:**
```python
from dataclasses import dataclass
@dataclass
class User:
    name: str
    age: int = 0
print(User("Ann"))   # User(name='Ann', age=0)
```
🎯 **Interview:** PEP 557. Uses type annotations to find fields. Options: `frozen`, `order`, `slots` (3.10), `kw_only` (3.10).

### 3️⃣9️⃣8️⃣ What are the benefits of using `@dataclass`? 🎁
🧒 **Simple:** Less typing, fewer bugs, nicer printing.
💻 **Example:** 3 lines instead of 12.
🎯 **Interview:** Auto `__init__/__repr__/__eq__`, optional ordering/hash/immutability, `asdict()`, `replace()`, defaults/factories, readable, IDE/type-checker friendly.

### 3️⃣9️⃣9️⃣ How do you make a dataclass immutable (`frozen=True`)? 🧊
🧒 **Simple:** Add `frozen=True` and attributes can't change after creation.
💻 **Example:**
```python
@dataclass(frozen=True)
class Pt:
    x: int; y: int
p = Pt(1, 2)
p.x = 5   # FrozenInstanceError
```
🎯 **Interview:** Generates `__setattr__/__delattr__` that raise; with `eq=True` also generates `__hash__` → usable as dict key. Shallow immutability only.

### 4️⃣0️⃣0️⃣ How do you define default values and default factories in dataclasses (`field(default_factory=...)`)? 🏭
🧒 **Simple:** For lists/dicts use a factory so each object gets its own copy.
💻 **Example:**
```python
from dataclasses import dataclass, field
@dataclass
class Cart:
    items: list = field(default_factory=list)
```
🎯 **Interview:** Mutable defaults (`= []`) raise `ValueError` in dataclasses (protecting you from the mutable default bug).

### 4️⃣0️⃣1️⃣ What is the `__post_init__` method in dataclasses? 🏁
🧒 **Simple:** Runs right after the auto-generated `__init__` — perfect for validation or computed fields.
💻 **Example:**
```python
@dataclass
class Rect:
    w: int; h: int
    area: int = field(init=False)
    def __post_init__(self): self.area = self.w * self.h
```
🎯 **Interview:** Also receives `InitVar` pseudo-fields. Use `field(init=False)` for derived values.

### 4️⃣0️⃣2️⃣ How do dataclasses handle ordering and comparison (`order=True`)? 📊
🧒 **Simple:** `order=True` auto-creates `<`, `>`, `<=`, `>=` comparing fields in order, like tuples.
💻 **Example:**
```python
@dataclass(order=True)
class V:
    major: int; minor: int
print(V(1, 2) < V(1, 3))   # True
```
🎯 **Interview:** `eq=True` default. Use `field(compare=False)` to exclude fields; `sort_index` trick for custom order.

### 4️⃣0️⃣3️⃣ What is the difference between namedtuples, regular classes, and dataclasses? 🆚
🧒 **Simple:** namedtuple = locked light record. Regular class = fully custom. Dataclass = customizable record with less code.
💻 **Example:** Same `Point` implemented 3 ways.
🎯 **Interview:** Namedtuple: immutable, tuple behavior (indexable, unpackable), tiny memory. Dataclass: mutable by default, methods, defaults, inheritance, type hints, `__post_init__`. Regular class: full control, more boilerplate. Also `slots=True`, `pydantic` for validation.

### 4️⃣0️⃣4️⃣ What are `TypedDict`s and when should you use them instead of classes? 🗂️
🧒 **Simple:** A dictionary whose keys and value types are described for type checkers.
💻 **Example:**
```python
from typing import TypedDict
class Movie(TypedDict):
    title: str
    year: int
m: Movie = {"title": "Up", "year": 2009}
```
🎯 **Interview:** Runtime is still a plain `dict` (no validation). Great for JSON-like data. Use classes when you need behavior/validation. `total=False`, `Required/NotRequired`.

### 4️⃣0️⃣5️⃣ What are `NamedTuple`s and how do they support type hints? 🏷️📦
🧒 **Simple:** namedtuple with types, written like a class.
💻 **Example:**
```python
from typing import NamedTuple
class P(NamedTuple):
    x: int
    y: int = 0
```
🎯 **Interview:** Class syntax supports defaults, docstrings, methods; still an immutable tuple subclass.

### 4️⃣0️⃣6️⃣ What is the `enum` module and how do you define enumerations? 🚦
🧒 **Simple:** A fixed set of named constants (like days of the week).
💻 **Example:**
```python
from enum import Enum
class Color(Enum):
    RED = 1
    GREEN = 2
print(Color.RED, Color(2), Color["RED"])
```
🎯 **Interview:** Members are singletons, hashable, comparable by identity. Prevents magic numbers. `auto()` for values; `@unique` ensures no aliases.

### 4️⃣0️⃣7️⃣ What is the difference between standard `Enum`s, `IntEnum`s, and `Flag` enums? 🏳️
🧒 **Simple:** Enum = just names. IntEnum = acts like integers too. Flag = combine options with `|`.
💻 **Example:**
```python
from enum import IntEnum, Flag, auto
class Perm(Flag):
    R = auto(); W = auto(); X = auto()
rw = Perm.R | Perm.W
class Pri(IntEnum): LOW = 1; HIGH = 2
print(Pri.LOW < Pri.HIGH, Pri.LOW == 1)
```
🎯 **Interview:** `Enum` members aren't equal to ints; `IntEnum` interoperates with ints (can cause accidental comparisons). `Flag`/`IntFlag` for bitmasks. `StrEnum` (3.11).

### 4️⃣0️⃣8️⃣ How do you iterate over members of an Enum? 🔁
🧒 **Simple:** Loop over the class.
💻 **Example:**
```python
for c in Color: print(c.name, c.value)
list(Color.__members__.items())   # includes aliases
```
🎯 **Interview:** Iteration excludes aliases; `__members__` includes them. Definition order preserved.

### 4️⃣0️⃣9️⃣ How do you implement custom methods inside an Enum? 🧰
🧒 **Simple:** Enums are classes, so just add methods.
💻 **Example:**
```python
class Planet(Enum):
    EARTH = (5.97e24, 6.37e6)
    def __init__(self, mass, radius): self.mass, self.radius = mass, radius
    @property
    def gravity(self): return 6.67e-11 * self.mass / self.radius**2
```
🎯 **Interview:** Members can carry data via `__init__`; `@classmethod` for lookups; `_missing_` hook for custom value lookup.

---

# 🎨 SECTION 12: Advanced Design Patterns

### 4️⃣1️⃣0️⃣ What is the Prototype design pattern in Python OOP? 🐑
🧒 **Simple:** Make new objects by *cloning* an existing one (like Dolly the sheep).
💻 **Example:**
```python
import copy
class Shape:
    def clone(self): return copy.deepcopy(self)
s2 = Shape().clone()
```
🎯 **Interview:** Creational; useful when construction is expensive or config-heavy. Python's `copy` module makes it trivial; decide shallow vs deep.

### 4️⃣1️⃣1️⃣ What is the Singleton pattern implementation using `__new__`? 👑
🧒 **Simple:** Store the one instance on the class and always return it.
💻 **Example:**
```python
class S:
    _inst = None
    def __new__(cls, *a, **k):
        if not cls._inst: cls._inst = super().__new__(cls)
        return cls._inst
```
🎯 **Interview:** Caveat: `__init__` runs on every `S()` call. Thread-safety → use a lock. Alternatives: module-level object, metaclass, decorator.

### 4️⃣1️⃣2️⃣ What is the Monostate (Borg) pattern in Python OOP? 🤖
🧒 **Simple:** (The question says "Monborg" — it's the **Borg** / Monostate pattern.) Many objects, but they all *share the same state*, like the Borg from Star Trek.
💻 **Example:**
```python
class Borg:
    _shared = {}
    def __init__(self): self.__dict__ = self._shared
a, b = Borg(), Borg()
a.x = 1; print(b.x)   # 1
```
🎯 **Interview:** Shares attribute dict instead of identity. Subclasses can have separate or shared state depending on where `_shared` is defined.

### 4️⃣1️⃣3️⃣ How does the Borg pattern differ from Singleton? 🆚
🧒 **Simple:** Singleton = one object. Borg = many objects with one shared brain 🧠.
💻 **Example:** `Borg() is Borg()` → `False`, but their data is the same.
🎯 **Interview:** Singleton restricts *instances*; Borg shares *state*. Borg works naturally with subclassing and doesn't need `__new__` tricks, but `is` comparison differs.

### 4️⃣1️⃣4️⃣ What is the Proxy design pattern in OOP? 🕴️
🧒 **Simple:** A stand-in object that controls access to the real one (like a receptionist).
💻 **Example:**
```python
class RealImage:
    def show(self): print("showing")
class Proxy:
    def __init__(s): s._real = None
    def show(s):
        if s._real is None: s._real = RealImage()   # lazy load
        s._real.show()
```
🎯 **Interview:** Types: virtual (lazy), protection (auth), remote, caching, logging. Same interface as subject.

### 4️⃣1️⃣5️⃣ What is the Facade design pattern in OOP? 🏢
🧒 **Simple:** One simple front door to a complicated system.
💻 **Example:**
```python
class Computer:
    def start(s): CPU().boot(); Memory().load(); Disk().read()
```
🎯 **Interview:** Structural. Simplifies a subsystem API, reduces coupling; doesn't hide subsystem (still accessible).

### 4️⃣1️⃣6️⃣ What is the Composite design pattern in OOP? 🌳
🧒 **Simple:** Treat a single item and a group of items the same way (files & folders 📁).
💻 **Example:**
```python
class File:
    def size(s): return 10
class Folder:
    def __init__(s): s.children = []
    def size(s): return sum(c.size() for c in s.children)
```
🎯 **Interview:** Tree structures with a uniform interface (leaf & composite). Good for UI trees, file systems, ASTs.

### 4️⃣1️⃣7️⃣ What is the Bridge design pattern in OOP? 🌉
🧒 **Simple:** Separate "what" from "how" so both can change independently (e.g., Shape × Color).
💻 **Example:**
```python
class Circle:
    def __init__(s, renderer): s.r = renderer
    def draw(s): s.r.render_circle()
class SVG: 
    def render_circle(s): print("svg circle")
```
🎯 **Interview:** Prefers composition to avoid class explosion (M×N subclasses → M+N). Abstraction holds a reference to an implementor.

### 4️⃣1️⃣8️⃣ What is the Flyweight design pattern in Python? 🪶
🧒 **Simple:** Share common data between many objects to save memory.
💻 **Example:**
```python
class Tree:
    _cache = {}
    def __new__(cls, kind):
        return cls._cache.setdefault(kind, super().__new__(cls))
```
🎯 **Interview:** Intrinsic (shared) vs extrinsic (per-use) state. Python tools: interning, `__slots__`, caching factories, `weakref.WeakValueDictionary`.

### 4️⃣1️⃣9️⃣ What is the Template Method design pattern in OOP? 📋
🧒 **Simple:** Parent class defines the steps of a recipe; children fill in some steps.
💻 **Example:**
```python
class Report:
    def build(s): s.header(); s.body(); s.footer()
    def header(s): print("H")
    def body(s): raise NotImplementedError
    def footer(s): print("F")
```
🎯 **Interview:** Behavioral. Inversion of control ("Hollywood principle": don't call us, we'll call you). Skeleton in base, hooks in subclasses.

### 4️⃣2️⃣0️⃣ What is the State design pattern in OOP? 🚥
🧒 **Simple:** An object changes behavior when its internal state changes (traffic light 🚦).
💻 **Example:**
```python
class Red:
    def next(s): return Green()
class Green:
    def next(s): return Yellow()
class Light:
    def __init__(s): s.state = Red()
    def change(s): s.state = s.state.next()
```
🎯 **Interview:** Replaces big `if/elif` on state with state classes; related to finite state machines; differs from Strategy by state transitions.

### 4️⃣2️⃣1️⃣ What is the Command design pattern in OOP? 🎮
🧒 **Simple:** Turn an action into an object so you can store, queue, or undo it.
💻 **Example:**
```python
class AddText:
    def __init__(s, doc, t): s.doc, s.t = doc, t
    def do(s): s.doc.append(s.t)
    def undo(s): s.doc.pop()
```
🎯 **Interview:** Enables undo/redo, queues, macros, logging. Decouples invoker from receiver. In Python, closures/callables are lightweight commands.

### 4️⃣2️⃣2️⃣ What is the Chain of Responsibility pattern in OOP? ⛓️
🧒 **Simple:** Pass a request along a chain of handlers until one handles it (like escalating a complaint 📞).
💻 **Example:**
```python
class Handler:
    def __init__(s, nxt=None): s.nxt = nxt
    def handle(s, r):
        if s.can(r): return s.do(r)
        return s.nxt.handle(r) if s.nxt else None
```
🎯 **Interview:** Decouples sender and receivers. Used in middleware (Django/Flask), event bubbling, logging handlers.

### 4️⃣2️⃣3️⃣ What is the Mediator design pattern in OOP? 🗼
🧒 **Simple:** A middleman that lets objects talk to each other so they don't need to know each other (air-traffic control ✈️).
💻 **Example:**
```python
class ChatRoom:
    def send(s, user, msg):
        for u in s.users:
            if u is not user: u.receive(msg)
```
🎯 **Interview:** Reduces many-to-many coupling to one-to-many; risk: mediator becomes a "god object".

### 4️⃣2️⃣4️⃣ What is the Memento design pattern in OOP? 📸
🧒 **Simple:** Save a snapshot of an object's state to restore later (Ctrl+Z).
💻 **Example:**
```python
class Editor:
    def save(s): return s.text
    def restore(s, m): s.text = m
```
🎯 **Interview:** Captures state without breaking encapsulation. Python: `copy.deepcopy`, `pickle`, dataclass `replace()`. Often paired with Command for undo.

### 4️⃣2️⃣5️⃣ What is the Visitor design pattern in OOP? 🧳
🧒 **Simple:** Add new operations to existing classes without changing them — a visitor comes to each object and does a job.
💻 **Example:**
```python
class Circle:
    def accept(s, v): return v.visit_circle(s)
class AreaVisitor:
    def visit_circle(s, c): return 3.14 * c.r ** 2
```
🎯 **Interview:** Double dispatch. Python alternative: `functools.singledispatch`, `ast.NodeVisitor`. Hard to add new element types.

### 4️⃣2️⃣6️⃣ What is object serialization in the context of custom classes (`__getstate__` and `__setstate__`)? 💾
🧒 **Simple:** Control exactly what gets saved and restored when pickling your object.
💻 **Example:**
```python
class Conn:
    def __init__(s): s.url = "db"; s.sock = open_socket()
    def __getstate__(s):
        d = s.__dict__.copy(); del d["sock"]; return d
    def __setstate__(s, d):
        s.__dict__.update(d); s.sock = open_socket()
```
🎯 **Interview:** Exclude unpicklable resources (sockets, locks, file handles); used by `pickle` and `copy`. `__getstate__` default behavior improved in 3.11.


### 4️⃣2️⃣7️⃣ How do `__reduce__` and `__reduce_ex__` work for pickling custom objects? 🧪
🧒 **Simple:** They tell pickle "to rebuild me, call THIS function with THESE arguments."
💻 **Example:**
```python
class P:
    def __init__(s, x): s.x = x
    def __reduce__(s): return (P, (s.x,))
```
🎯 **Interview:** Returns `(callable, args[, state, listitems, dictitems])`. `__reduce_ex__(protocol)` takes precedence and supports protocol-specific logic. This is also the **security hole** in unpickling untrusted data.

### 4️⃣2️⃣8️⃣ What is the purpose of `__slots__` regarding memory footprint in large class hierarchies? 📉
🧒 **Simple:** If you have millions of objects, slots remove the hidden per-object dictionary and save lots of RAM.
💻 **Example:**
```python
class Base:  __slots__ = ("a",)
class Child(Base): __slots__ = ("b",)   # only add NEW names
```
🎯 **Interview:** Each subclass must define `__slots__` too, otherwise it gets a `__dict__` again and the savings vanish. Empty `__slots__ = ()` in intermediate/mixin classes.

### 4️⃣2️⃣9️⃣ What are the limitations of using `__slots__` with inheritance? 🚧
🧒 **Simple:** Slots are picky when classes inherit.
💻 **Example:** Child of non-slotted parent still gets `__dict__`.
🎯 **Interview:** Don't redeclare parent's slots (wastes memory); no default values as class attributes for same name (conflict); no `__weakref__` unless added; layout conflicts in multiple inheritance; harder dynamic attrs/pickle (protocol <2).

### 4️⃣3️⃣0️⃣ How do multiple base classes with `__slots__` interact? 💥
🧒 **Simple:** Only one parent can have non-empty slots.
💻 **Example:**
```python
class A: __slots__ = ("x",)
class B: __slots__ = ("y",)
class C(A, B): pass   # TypeError: multiple bases have instance lay-out conflict
```
🎯 **Interview:** Due to C-level memory layout. Solution: at most one base with non-empty slots; others `__slots__ = ()`.

### 4️⃣3️⃣1️⃣ Can a class with `__slots__` have a `__dict__`? 🤔
🧒 **Simple:** Yes, if you list `"__dict__"` in slots.
💻 **Example:**
```python
class A:
    __slots__ = ("x", "__dict__")
a = A(); a.anything = 1   # works
```
🎯 **Interview:** Gives hybrid: fast declared attributes + dynamic ones; also add `"__weakref__"` to allow weak references. Also happens when inheriting from non-slotted class.

### 4️⃣3️⃣2️⃣ What is dynamic attribute assignment using `setattr()` and `getattr()`? 🎭
🧒 **Simple:** Set or get attributes using a name stored in a string.
💻 **Example:**
```python
class A: pass
a = A()
setattr(a, "color", "red")
print(getattr(a, "color"), getattr(a, "size", "unknown"))
```
🎯 **Interview:** Handy for config loading, serialization, plugin systems. `getattr(obj, name, default)` avoids `AttributeError`. Beware security with user-supplied names.

### 4️⃣3️⃣3️⃣ How do you check if an object has a specific attribute (`hasattr()`)? 🔎
🧒 **Simple:** Ask "do you have this?"
💻 **Example:**
```python
print(hasattr(a, "color"))   # True
```
🎯 **Interview:** Implemented by calling `getattr` and catching `AttributeError` — so it triggers properties/`__getattr__`. EAFP: try/except often preferred.

### 4️⃣3️⃣4️⃣ How do you delete an attribute dynamically (`delattr()`)? 🗑️
🧒 **Simple:** Remove an attribute by name.
💻 **Example:**
```python
delattr(a, "color")      # same as del a.color
```
🎯 **Interview:** Raises `AttributeError` if missing. Triggers `__delattr__` / descriptor `__delete__`.

### 4️⃣3️⃣5️⃣ What is a bound method vs an unbound method in Python OOP? 🔗
🧒 **Simple:** Bound = already knows which object it belongs to. "Unbound" = just the plain function (needs `self` given manually).
💻 **Example:**
```python
class A:
    def hi(self): return "hi"
a = A()
bound = a.hi            # bound method
plain = A.hi            # plain function in Py3
print(plain(a))
```
🎯 **Interview:** Python 3 removed the "unbound method" type; `Class.method` is just a function. Bound methods wrap function + instance.

### 4️⃣3️⃣6️⃣ How does a function become a bound method when accessed via an instance? 🪄
🧒 **Simple:** Functions have a hidden `__get__`; when you access via an object, it glues `self` onto the function.
💻 **Example:**
```python
import types
f = A.__dict__["hi"]
m = f.__get__(a, A)      # same as a.hi
print(isinstance(m, types.MethodType))
```
🎯 **Interview:** Functions are non-data descriptors; `__get__` returns `MethodType(func, instance)`.

### 4️⃣3️⃣7️⃣ What is the `__func__` and `__self__` attribute of a bound method? 🧷
🧒 **Simple:** `__self__` = the object it's attached to. `__func__` = the original function.
💻 **Example:**
```python
print(a.hi.__self__ is a)       # True
print(a.hi.__func__ is A.hi)    # True
```
🎯 **Interview:** For classmethods `__self__` is the class. Useful in introspection, frameworks, decorators.

### 4️⃣3️⃣8️⃣ What is method chaining in Python OOP? ⛓️
🧒 **Simple:** Calling many methods in a row on one line: `a.b().c().d()`.
💻 **Example:**
```python
text = "  Hello  ".strip().lower().replace("h", "j")
```
🎯 **Interview:** Methods return `self` (mutating objects) or new objects (immutable style like strings/pandas). Readability vs debuggability trade-off.

### 4️⃣3️⃣9️⃣ How do you implement fluent interfaces using method chaining? 🌊
🧒 **Simple:** Make each method `return self` so calls can chain.
💻 **Example:**
```python
class Query:
    def __init__(s): s.parts = []
    def select(s, c): s.parts.append(f"SELECT {c}"); return s
    def where(s, c): s.parts.append(f"WHERE {c}"); return s
    def build(s): return " ".join(s.parts)
print(Query().select("*").where("id=1").build())
```
🎯 **Interview:** Builder-pattern style (SQLAlchemy, Django ORM, pandas). Be careful with mutability — consider returning copies for safer APIs.

### 4️⃣4️⃣0️⃣ What is dependency injection in OOP and how is it done in Python? 💉
🧒 **Simple:** Give an object the things it needs from outside instead of making them inside.
💻 **Example:**
```python
class Service:
    def __init__(self, db): self.db = db     # injected
Service(FakeDB())   # easy testing 🎉
```
🎯 **Interview:** Constructor/setter/parameter injection. Easier testing, loose coupling. Python rarely needs a DI framework (duck typing, default args, `functools.partial`); libs: `dependency-injector`, FastAPI `Depends`.

### 4️⃣4️⃣1️⃣ What is inversion of control (IoC)? 🔄
🧒 **Simple:** Instead of *you* calling the framework, the *framework* calls you ("Don't call us, we'll call you").
💻 **Example:** Flask route functions; callbacks; template method.
🎯 **Interview:** A principle; DI is one technique to achieve it. Also event handlers, plugins, containers.

### 4️⃣4️⃣2️⃣ What are SOLID principles in Object-Oriented Design? 🧱
🧒 **Simple:** 5 rules for neat, flexible classes.
💻 **Example:**
- **S** — Single Responsibility
- **O** — Open/Closed
- **L** — Liskov Substitution
- **I** — Interface Segregation
- **D** — Dependency Inversion
🎯 **Interview:** Guidelines (not laws) for maintainable OOP by Robert C. Martin. Be able to explain each with an example and a violation.

### 4️⃣4️⃣3️⃣ Explain the Single Responsibility Principle (SRP) with a Python example. 🎯
🧒 **Simple:** A class should do ONE job.
💻 **Example:**
```python
# ❌ bad: Report both builds AND saves AND emails
# ✅ good:
class Report:      ...   # builds data
class ReportSaver: ...   # saves to disk
class Mailer:      ...   # sends email
```
🎯 **Interview:** "A class should have only one reason to change." Improves testing, reuse, readability.

### 4️⃣4️⃣4️⃣ Explain the Open/Closed Principle (OCP) with a Python example. 🚪
🧒 **Simple:** Add new features by adding new code, not by editing old code.
💻 **Example:**
```python
class Shape(ABC):
    @abstractmethod
    def area(s): ...
class Circle(Shape): ...
class Square(Shape): ...
def total(shapes): return sum(s.area() for s in shapes)   # never changes ✅
```
🎯 **Interview:** Open for extension, closed for modification — via polymorphism/strategy instead of `if/elif type` chains.

### 4️⃣4️⃣5️⃣ Explain the Liskov Substitution Principle (LSP) with a Python example. 🔁
🧒 **Simple:** A child must work wherever the parent works, without surprises.
💻 **Example:**
```python
class Bird:
    def move(s): ...
class Penguin(Bird):
    def fly(s): raise Exception   # ❌ if Bird has fly(), Penguin breaks the promise
```
Fix: separate `FlyingBird` / `Bird` or use composition.
🎯 **Interview:** Subtypes must honor the base contract: don't strengthen preconditions, weaken postconditions, or throw unexpected exceptions. Classic violation: `Square(Rectangle)`.

### 4️⃣4️⃣6️⃣ Explain the Interface Segregation Principle (ISP) in Python. ✂️
🧒 **Simple:** Don't force a class to implement methods it doesn't need — keep interfaces small.
💻 **Example:**
```python
class Printer(Protocol):
    def print(self): ...
class Scanner(Protocol):
    def scan(self): ...
# A BasicPrinter only implements Printer ✅
```
🎯 **Interview:** Prefer many small Protocols/ABCs over one "fat" interface; Python's duck typing and `collections.abc` mixins reflect this.

### 4️⃣4️⃣7️⃣ Explain the Dependency Inversion Principle (DIP) with a Python example. ⬆️⬇️
🧒 **Simple:** Depend on abstractions, not concrete details.
💻 **Example:**
```python
class Notifier(ABC):
    @abstractmethod
    def send(s, m): ...
class Email(Notifier): ...
class SMS(Notifier): ...
class Alert:
    def __init__(s, n: Notifier): s.n = n   # depends on abstraction ✅
```
🎯 **Interview:** High-level modules shouldn't depend on low-level ones; both depend on abstractions. DIP is the principle; DI is a technique.

### 4️⃣4️⃣8️⃣ What is the Law of Demeter (Principle of Least Knowledge) in OOP? 🤫
🧒 **Simple:** Only talk to your close friends, not strangers' friends. `a.b.c.d()` = bad.
💻 **Example:**
```python
# ❌ order.customer.address.city
# ✅ order.shipping_city()
```
🎯 **Interview:** A method should only call methods on itself, its parameters, objects it creates, or its direct components. Reduces coupling ("train wrecks").

### 4️⃣4️⃣9️⃣ What is code reuse via inheritance vs composition in large applications? ♻️
🧒 **Simple:** Inheritance reuses by "being" a thing; composition reuses by "using" a thing.
💻 **Example:** `class Report(PDFExporter)` ❌ vs `Report(exporter=PDFExporter())` ✅
🎯 **Interview:** Large systems favor composition/DI: flexible, testable, swappable at runtime. Use inheritance for true "is-a" and framework extension points.

### 4️⃣5️⃣0️⃣ What is the fragile base class problem in inheritance? 🪟💥
🧒 **Simple:** Changing a parent class can accidentally break children.
💻 **Example:**
```python
class Base:
    def add_all(s, xs):
        for x in xs: s.add(x)
    def add(s, x): ...
# Child overrides add() to count → later Base.add_all changes to call a different path → counts break
```
🎯 **Interview:** Caused by tight coupling to implementation details. Mitigate: composition, `final`/documented extension points, small hierarchies, tests.

### 4️⃣5️⃣1️⃣ How do you handle deep inheritance hierarchies effectively? 🏔️
🧒 **Simple:** Avoid them! Keep it shallow.
💻 **Example:** Replace 6-level chain with composition + a few mixins/protocols.
🎯 **Interview:** Refactor: "replace inheritance with delegation", extract classes, strategy pattern, ≤2–3 levels rule of thumb, document MRO, use ABCs for contracts.

### 4️⃣5️⃣2️⃣ What is pure object-oriented programming and why is Python considered multi-paradigm? 🎭
🧒 **Simple:** Pure OOP = everything lives in classes (like Smalltalk). Python lets you also use functions and simple scripts.
💻 **Example:** Procedural script + functional `map/filter` + classes in one file.
🎯 **Interview:** Python supports procedural, OOP, functional (first-class functions, comprehensions, `itertools`, `functools`), and some declarative styles. Though "everything is an object," you're not forced into classes.

### 4️⃣5️⃣3️⃣ Can primitive types be subclassed in Python (e.g., inheriting from `int` or `str`)? 🧬
🧒 **Simple:** Yes! Built-in types are classes.
💻 **Example:**
```python
class Celsius(float):
    def to_f(self): return self * 9/5 + 32
print(Celsius(100).to_f())
```
🎯 **Interview:** Immutable subclasses need `__new__`. Caveats: built-in methods return base types (e.g., `Celsius(1)+1` → `float`), `bool` can't be subclassed.

### 4️⃣5️⃣4️⃣ How do you override built-in behavior by subclassing built-in types? 🛠️
🧒 **Simple:** Subclass and override methods.
💻 **Example:**
```python
class LoudList(list):
    def append(s, x): print("➕", x); super().append(x)
```
🎯 **Interview:** Gotcha: C-implemented methods don't always call your overrides (e.g., `dict.update` ignores overridden `__setitem__`). Prefer `collections.UserDict/UserList/UserString` or `collections.abc` mixins.

### 4️⃣5️⃣5️⃣ What is object identity, object state, and object behavior? 🪪
🧒 **Simple:** Identity = *who* it is (ID card). State = *what it holds* (data). Behavior = *what it can do* (methods).
💻 **Example:**
```python
d = Dog("Rex")
id(d)        # identity
d.name       # state
d.bark()     # behavior
```
🎯 **Interview:** Booch's three characteristics of an object. In Python: `id()`/`is`, `__dict__`, methods.

### 4️⃣5️⃣6️⃣ What is delegation in OOP design? 🤝
🧒 **Simple:** An object hands a job over to another object.
💻 **Example:**
```python
class Printer:
    def print(s, t): print(t)
class Office:
    def __init__(s): s.p = Printer()
    def print(s, t): s.p.print(t)
```
🎯 **Interview:** Core of composition; alternative to inheritance; used in Proxy, Decorator, State, Strategy.

### 4️⃣5️⃣7️⃣ How do you implement delegation using `__getattr__`? 🪄
🧒 **Simple:** If the object doesn't have an attribute, forward the request to the inner object.
💻 **Example:**
```python
class Wrapper:
    def __init__(s, obj): s._obj = obj
    def __getattr__(s, name): return getattr(s._obj, name)
w = Wrapper([1, 2]); w.append(3)
```
🎯 **Interview:** Beware infinite recursion if `_obj` isn't set yet (e.g., during unpickling) — access via `self.__dict__`. Dunder methods (`len(w)`) bypass `__getattr__` → define explicitly.

### 4️⃣5️⃣8️⃣ What is a mixin inheritance conflict (MRO error) and how do you resolve it? ⚠️
🧒 **Simple:** Python can't decide a sensible parent order.
💻 **Example:**
```python
class A: ...
class B(A): ...
class C(A, B): ...   # TypeError: Cannot create a consistent method resolution order
```
Fix: `class C(B, A)` (children before parents).
🎯 **Interview:** C3 requires that local precedence is consistent. Resolve by reordering bases, flattening hierarchy, or using composition.

### 4️⃣5️⃣9️⃣ What is cooperative multiple inheritance and why is `super()` mandatory for it? 🤝🐍
🧒 **Simple:** All classes agree to pass the baton with `super()` so everyone runs once.
💻 **Example:** See Q228 (D → B → C → A).
🎯 **Interview:** Direct parent calls (`A.go(self)`) can run shared bases twice or skip siblings; `super()` follows MRO and ensures a single call per class. Design: accept `**kwargs`, call `super().__init__(**kwargs)`.

### 4️⃣6️⃣0️⃣ What happens if you skip calling `super()` in a multiple inheritance chain? ✂️
🧒 **Simple:** The chain breaks — later classes in the MRO never run!
💻 **Example:**
```python
class B(A):
    def go(s): print("B")     # no super() → C and A skipped
```
🎯 **Interview:** Leads to uninitialized state and missed behaviors. Document whether a class is "terminal" in the chain.

### 4️⃣6️⃣1️⃣ What is the order of execution in multiple inheritance with `super()`? 🔢
🧒 **Simple:** It follows the MRO list left-to-right.
💻 **Example:** `class D(B, C)` → `D → B → C → A → object`.
🎯 **Interview:** Print `D.__mro__` to confirm. Each `super()` call goes to the *next* in the *instance's* MRO, which is why order of base classes matters.

### 4️⃣6️⃣2️⃣ What is a proxy object pattern using `__getattr__` for lazy loading? 😴🕴️
🧒 **Simple:** A placeholder that only loads the real, heavy object the first time you use it.
💻 **Example:**
```python
class LazyProxy:
    def __init__(s, factory): s.__dict__["_f"] = factory; s.__dict__["_o"] = None
    def __getattr__(s, n):
        if s.__dict__["_o"] is None: s.__dict__["_o"] = s.__dict__["_f"]()
        return getattr(s.__dict__["_o"], n)
```
🎯 **Interview:** Delays expensive init (DB, big file). Use `__dict__` to avoid recursion. Related: `functools.cached_property`, `werkzeug.LocalProxy`.

### 4️⃣6️⃣3️⃣ What is an immutable object implementation using custom classes (`__setattr__` raising exceptions)? 🧊
🧒 **Simple:** Block any attribute change after creation.
💻 **Example:**
```python
class Frozen:
    def __init__(s, x): object.__setattr__(s, "x", x)
    def __setattr__(s, n, v): raise AttributeError("immutable 🧊")
    def __delattr__(s, n): raise AttributeError("immutable 🧊")
```
🎯 **Interview:** Use `object.__setattr__` inside `__init__`. Easier: `@dataclass(frozen=True)`, `NamedTuple`, `__slots__`. Also define `__hash__`/`__eq__`.

### 4️⃣6️⃣4️⃣ How do you implement a custom container type in Python (Sequence or Mapping protocols)? 📦
🧒 **Simple:** Implement a few special methods so your class acts like a list or dict.
💻 **Example:**
```python
from collections.abc import Sequence
class MyList(Sequence):
    def __init__(s, d): s._d = list(d)
    def __getitem__(s, i): return s._d[i]
    def __len__(s): return len(s._d)
print(list(reversed(MyList([1, 2, 3]))), 2 in MyList([1, 2]))
```
🎯 **Interview:** Inherit from `collections.abc` to get mixin methods free. Or subclass `UserList`/`UserDict`.

### 4️⃣6️⃣5️⃣ What abstract classes does the `collections.abc` module provide for custom containers? 🧰
🧒 **Simple:** Ready-made blueprints for container types.
💻 **Example:** `Iterable, Iterator, Sized, Container, Collection, Sequence, MutableSequence, Mapping, MutableMapping, Set, MutableSet, Hashable, Callable, Generator, Awaitable, ...`
🎯 **Interview:** Use for `isinstance` checks (`isinstance(x, Mapping)`) and as base classes to inherit mixin methods.

### 4️⃣6️⃣6️⃣ What methods must be implemented to satisfy `collections.abc.Sequence`? 📏
🧒 **Simple:** Just two!
💻 **Example:** `__getitem__` and `__len__`
🎯 **Interview:** Mixins provided: `__contains__`, `__iter__`, `__reversed__`, `index`, `count`. `MutableSequence` additionally needs `__setitem__`, `__delitem__`, `insert`.

### 4️⃣6️⃣7️⃣ What methods must be implemented to satisfy `collections.abc.Mapping`? 🗺️
🧒 **Simple:** Three!
💻 **Example:** `__getitem__`, `__iter__`, `__len__`
🎯 **Interview:** Mixins: `keys, items, values, get, __contains__, __eq__, __ne__`. `MutableMapping` adds `__setitem__`, `__delitem__` (gives `pop, popitem, clear, update, setdefault`).

### 4️⃣6️⃣8️⃣ What methods must be implemented to satisfy `collections.abc.Set`? 🎲
🧒 **Simple:** Three!
💻 **Example:** `__contains__`, `__iter__`, `__len__`
🎯 **Interview:** Mixins: comparison operators (`<=`, `<`, `==`...), `&`, `|`, `-`, `^`, `isdisjoint`. Need `_from_iterable` classmethod if constructor differs. `MutableSet` adds `add`, `discard`.

### 4️⃣6️⃣9️⃣ How does mixing in `collections.abc` mixin methods work automatically? 🪄
🧒 **Simple:** You write the few "abstract" basics; the base class writes the rest using them.
💻 **Example:** `Sequence.__contains__` loops with your `__getitem__`; `Mapping.get` calls your `__getitem__`.
🎯 **Interview:** Template Method pattern. Mixins are generic (maybe not optimal) — override for performance (e.g., O(1) `__contains__`).

### 4️⃣7️⃣0️⃣ What is object pooling and how do you implement an object pool pattern in Python? 🏊
🧒 **Simple:** Reuse expensive objects instead of creating new ones each time (like a library lending books 📚).
💻 **Example:**
```python
from queue import Queue
class Pool:
    def __init__(s, factory, n):
        s._q = Queue()
        for _ in range(n): s._q.put(factory())
    def acquire(s): return s._q.get()
    def release(s, o): s._q.put(o)
```
🎯 **Interview:** For DB connections, threads, sockets, GPU buffers. Use context manager to auto-release; handle reset, timeouts, health checks, thread safety (`Queue`). Libs: `SQLAlchemy` pool, `concurrent.futures`.

### 4️⃣7️⃣1️⃣ What is the difference between class-level locking and instance-level locking in thread-safe OOP? 🔐🏫
🧒 **Simple:** Class-level lock = one lock shared by all objects. Instance-level = each object has its own lock.
💻 **Example:**
```python
class A:
    _class_lock = threading.Lock()   # protects shared class data
    def __init__(s): s._lock = threading.Lock()   # protects this object's data
```
🎯 **Interview:** Use instance locks for per-object state (better concurrency); class locks for class-wide shared state (counters, registries, singleton creation). Avoid lock-ordering deadlocks.

### 4️⃣7️⃣2️⃣ How do you make thread-safe classes using reentrant locks (`threading.RLock`)? 🔁🔐
🧒 **Simple:** An RLock lets the *same thread* lock again without deadlocking itself.
💻 **Example:**
```python
class Account:
    def __init__(s): s._l = threading.RLock(); s.bal = 0
    def deposit(s, x):
        with s._l: s.bal += x
    def double(s):
        with s._l: s.deposit(s.bal)    # re-enters OK ✅
```
🎯 **Interview:** `Lock` would deadlock on nested acquisition from same thread. RLock tracks owner + recursion count. Slightly slower.

### 4️⃣7️⃣3️⃣ What is a metaclass trap or common anti-pattern in Python metaprogramming? 🪤
🧒 **Simple:** Using metaclasses (or heavy magic) when something simple would work.
💻 **Example:** Metaclass conflict: `class C(A, B)` where `A` uses `ABCMeta` and `B` uses a custom metaclass → `TypeError`.
🎯 **Interview:** Anti-patterns: metaclass for simple registration (use `__init_subclass__`), over-using `__getattr__`, hidden side effects at import time, monkey patching, global state, `eval`. "Explicit is better than implicit."

### 4️⃣7️⃣4️⃣ How do you write self-documenting code using custom docstrings and type annotations in classes? 📚
🧒 **Simple:** Clear names + type hints + docstrings = code that explains itself.
💻 **Example:**
```python
@dataclass
class Order:
    """A customer order.

    Attributes:
        items: Product IDs in the order.
        total: Total price in INR.
    """
    items: list[str]
    total: float

    def apply_discount(self, pct: float) -> "Order":
        """Return a new Order with `pct` percent discount."""
```
🎯 **Interview:** Follow PEP 257/484, use descriptive names, small functions, `Final`, `Literal`, doctests as living examples, Sphinx autodoc.

### 4️⃣7️⃣5️⃣ What is the purpose of `__init_subclass__` when creating plugin architectures? 🔌
🧒 **Simple:** Auto-register every new plugin class as soon as it's defined.
💻 **Example:**
```python
class Plugin:
    registry = {}
    def __init_subclass__(cls, name=None, **kw):
        super().__init_subclass__(**kw)
        Plugin.registry[name or cls.__name__] = cls
class CSV(Plugin, name="csv"): ...
print(Plugin.registry["csv"])
```
🎯 **Interview:** No metaclass or decorator needed; discovery happens at import time. Combine with entry points (`importlib.metadata`) for external plugins.

### 4️⃣7️⃣6️⃣ How do you implement the Null Object pattern in Python? 🕳️
🧒 **Simple:** Instead of `None`, return a "do-nothing" object that safely accepts calls.
💻 **Example:**
```python
class NullLogger:
    def info(s, *a): pass
    def error(s, *a): pass
logger = NullLogger()
logger.info("safe 😌")
```
🎯 **Interview:** Eliminates `if obj is not None` checks; follows polymorphism. Related: `contextlib.nullcontext`.

### 4️⃣7️⃣7️⃣ What is the Null Object pattern used for and how does it prevent `AttributeError`? 🛟
🧒 **Simple:** `None.something()` crashes with `AttributeError`; a Null Object has all those methods so nothing crashes.
💻 **Example:**
```python
class Null:
    def __getattr__(s, n): return s
    def __call__(s, *a, **k): return s
    def __bool__(s): return False
Null().a.b.c()   # no crash
```
🎯 **Interview:** Provides safe default behavior and removes conditionals. Trade-off: can hide bugs (silent failures), so use deliberately.

### 4️⃣7️⃣8️⃣ What is the difference between aggregation and composition regarding object lifecycles? ⏳
🧒 **Simple:** Composition: parts die with the whole (house → rooms 🏠). Aggregation: parts survive (university → professors 🎓).
💻 **Example:**
```python
class House:
    def __init__(s): s.rooms = [Room(), Room()]   # composition (created inside)
class Uni:
    def __init__(s, profs): s.profs = profs       # aggregation (passed in)
```
🎯 **Interview:** UML: filled diamond (composition), hollow diamond (aggregation). In Python, lifecycle is really governed by references/garbage collection.

### 4️⃣7️⃣9️⃣ How do you serialize object graphs with cyclic references in Python? 🔁💾
🧒 **Simple:** `pickle` handles loops automatically; `json` can't.
💻 **Example:**
```python
import pickle
a = {}; a["self"] = a
b = pickle.loads(pickle.dumps(a))
print(b["self"] is b)   # True ✅
# json.dumps(a) -> ValueError: Circular reference detected
```
🎯 **Interview:** pickle uses a memo table. For JSON: convert to IDs/references, use libraries (`jsonpickle`, `marshmallow`), or break the cycle (parent as ID).

### 4️⃣8️⃣0️⃣ What is a property factory and how can descriptors be created dynamically? 🏭🏷️
🧒 **Simple:** A function that produces properties automatically so you don't repeat yourself.
💻 **Example:**
```python
def typed_property(name, typ):
    priv = "_" + name
    def getter(s): return getattr(s, priv)
    def setter(s, v):
        if not isinstance(v, typ): raise TypeError(name)
        setattr(s, priv, v)
    return property(getter, setter)
class P:
    age = typed_property("age", int)
```
🎯 **Interview:** Avoids boilerplate; alternative to descriptor classes with `__set_name__`. Used in validation libraries and ORMs.

### 4️⃣8️⃣1️⃣ How do you inspect class definitions at runtime using the `inspect` module? 🔬
🧒 **Simple:** Ask Python to describe a class: its methods, source, parents.
💻 **Example:**
```python
import inspect
print(inspect.isclass(A), inspect.getmro(A))
print(inspect.getsource(A))
print(inspect.getdoc(A))
```
🎯 **Interview:** Tools: `isclass, ismethod, isfunction, getmro, getsource, getfile, getmodule, signature, getmembers, get_annotations`.

### 4️⃣8️⃣2️⃣ What is the `inspect.getmembers()` function used for? 🧾
🧒 **Simple:** Lists all attributes of an object as (name, value) pairs; can filter.
💻 **Example:**
```python
for name, fn in inspect.getmembers(A, inspect.isfunction): print(name)
```
🎯 **Interview:** Sorted by name; includes inherited members; predicate filters; may trigger properties/descriptors (side effects). Use `inspect.getmembers_static` (3.11) to avoid that.

### 4️⃣8️⃣3️⃣ How do you inspect function signatures and parameters programmatically using `inspect.signature()`? ✍️🔍
🧒 **Simple:** Read a function's parameter list as data.
💻 **Example:**
```python
def f(a, b=2, *args, c, **kw): ...
sig = inspect.signature(f)
for n, p in sig.parameters.items(): print(n, p.kind, p.default)
```
🎯 **Interview:** Powers FastAPI dependency injection, argument validation, decorators. `Signature.bind()` checks call compatibility. Parameter kinds: `POSITIONAL_ONLY`, `POSITIONAL_OR_KEYWORD`, `VAR_POSITIONAL`, `KEYWORD_ONLY`, `VAR_KEYWORD`.

### 4️⃣8️⃣4️⃣ What is the difference between `isinstance()` and `issubclass()` built-in functions? 🆚
🧒 **Simple:** `isinstance(obj, Class)` → is this *object* of that type? `issubclass(Class1, Class2)` → is this *class* a child of that class?
💻 **Example:**
```python
isinstance(5, int)         # True
issubclass(bool, int)      # True
isinstance(True, int)      # True 😲
```
🎯 **Interview:** Both accept tuples of classes. `issubclass` requires a class as first arg. Both consult `__instancecheck__/__subclasscheck__` of the metaclass.

### 4️⃣8️⃣5️⃣ How do `isinstance()` and `issubclass()` interact with custom metaclasses and ABC virtual subclasses? 🧬
🧒 **Simple:** Metaclasses can override how these checks answer — ABCs use that to count registered "virtual" subclasses.
💻 **Example:**
```python
class Meta(type):
    def __instancecheck__(cls, obj): return hasattr(obj, "quack")
class Duckish(metaclass=Meta): ...
class D: quack = lambda s: 1
print(isinstance(D(), Duckish))   # True
```
🎯 **Interview:** `ABCMeta.__instancecheck__/__subclasscheck__` check registry, `__subclasshook__`, and real inheritance (with caching). Enables `isinstance([], Iterable)` without inheriting.

### 4️⃣8️⃣6️⃣ What is the purpose of `__class__` assignment on an instance? 🔀
🧒 **Simple:** You can change an object's class on the fly — it becomes an instance of another class.
💻 **Example:**
```python
class A: 
    def who(s): return "A"
class B: 
    def who(s): return "B"
x = A(); x.__class__ = B
print(x.who())   # B
```
🎯 **Interview:** Used in state pattern implementations, migration/upgrade of objects, mocking. Rare and dangerous.

### 4️⃣8️⃣7️⃣ Can you change an object's class at runtime in Python? 🧙
🧒 **Simple:** Yes, with some rules.
💻 **Example:** See previous.
🎯 **Interview:** Works for heap-type (Python-defined) classes with compatible layout; fails for many built-ins.

### 4️⃣8️⃣8️⃣ What are the constraints on changing an object's class dynamically (`__class__` reassignment)? 🚧
🧒 **Simple:** The old and new classes must be "shaped" the same inside.
💻 **Example:**
```python
x = 5
x.__class__ = float   # TypeError: __class__ assignment only supported for mutable types
```
🎯 **Interview:** Both must have compatible memory layout (same `__slots__`, same C base); can't assign for built-in immutable types; `__dict__` attributes remain, so the new class's invariants may break.

### 4️⃣8️⃣9️⃣ What is an empty class stub used for in Python (`class MyClass: pass`)? 🫙
🧒 **Simple:** A placeholder or a simple bag for attributes.
💻 **Example:**
```python
class Bag: pass
b = Bag(); b.name = "Ann"; b.age = 9
```
🎯 **Interview:** Uses: TODO stubs, custom exception base, marker/sentinel types, quick namespace (`types.SimpleNamespace` is the better alternative), Protocol/ABC placeholders.

### 4️⃣9️⃣0️⃣ What is the difference between a class method factory and a static method factory? 🏭⚔️
🧒 **Simple:** A classmethod factory knows *which class* it was called on (so subclasses work); a staticmethod factory has the class name hard-coded.
💻 **Example:**
```python
class Pizza:
    @classmethod
    def margherita(cls): return cls(["mozzarella", "tomato"])   # works for subclasses ✅
    @staticmethod
    def margherita_s(): return Pizza(["mozzarella", "tomato"])  # always Pizza ❌
```
🎯 **Interview:** Prefer `@classmethod` factories for inheritance-friendly alternative constructors.

### 4️⃣9️⃣1️⃣ How do you implement read-only attributes without properties using descriptors? 🔒
🧒 **Simple:** Write a descriptor with `__get__` and a `__set__` that refuses changes.
💻 **Example:**
```python
class ReadOnly:
    def __init__(s, v): s.v = v
    def __get__(s, obj, owner=None): return s.v
    def __set__(s, obj, val): raise AttributeError("read-only 🔒")
class C:
    PI = ReadOnly(3.14)
```
🎯 **Interview:** Reusable across many attributes (DRY). Defining `__set__` makes it a data descriptor so it overrides instance dict.

### 4️⃣9️⃣2️⃣ What is the performance overhead of using properties vs direct attribute access? 🐢
🧒 **Simple:** Properties are a bit slower because a function runs each time.
💻 **Example:**
```python
import timeit
# direct attr ~ 20 ns, property ~ 60–100 ns (varies)
```
🎯 **Interview:** Typically 2–5× slower than raw attribute access, negligible except in hot loops. Use `cached_property` for expensive computations. Profile before optimizing.

### 4️⃣9️⃣3️⃣ What is the performance overhead of using `__slots__` vs standard `__dict__`? ⚡
🧒 **Simple:** Slots use less memory and are slightly faster to access.
💻 **Example:** 1M objects: ~60–100 MB (dict) vs ~40–60 MB (slots) — varies by version.
🎯 **Interview:** Creation and attribute access slightly faster; biggest win is memory. Modern CPython (3.11+) shrinks `__dict__` overhead (inline values / key-sharing), narrowing the gap. Measure it!

### 4️⃣9️⃣4️⃣ How do Python decorators interact with class methods and static methods? 🎀🏫
🧒 **Simple:** Order matters: put `@classmethod`/`@staticmethod` on the *outside* (top) and your decorator inside.
💻 **Example:**
```python
class A:
    @classmethod
    @my_decorator
    def make(cls): ...
```
🎯 **Interview:** `classmethod`/`staticmethod` objects aren't directly callable in older Python (<3.10 for staticmethod), so decorating them with a regular decorator can fail. Wrapper functions used on methods must accept `self` (via `*args`) and support descriptor binding.

### 4️⃣9️⃣5️⃣ What is a class decorator that modifies or wraps all methods of a class automatically? 🎁🏫
🧒 **Simple:** A decorator for a whole class that wraps every method (e.g., to log).
💻 **Example:**
```python
import functools
def log_all(cls):
    for name, fn in list(vars(cls).items()):
        if callable(fn) and not name.startswith("__"):
            @functools.wraps(fn)
            def wrapper(*a, _fn=fn, **k):
                print("calling", _fn.__name__)
                return _fn(*a, **k)
            setattr(cls, name, wrapper)
    return cls
@log_all
class Svc:
    def run(self): print("running")
Svc().run()
```
🎯 **Interview:** Beware closure late-binding in loops (use default args as above); skip static/class methods/properties or handle them; alternative: metaclass or `__getattribute__`.

### 4️⃣9️⃣6️⃣ How do you implement a custom exception hierarchy for an enterprise OOP application? 🏢🚨
🧒 **Simple:** Make one base error for your app, then specific child errors.
💻 **Example:**
```python
class AppError(Exception):
    """Base for all app errors."""
class ValidationError(AppError): ...
class DatabaseError(AppError): ...
class NotFoundError(DatabaseError): ...
try: ...
except AppError as e: log(e)
```
🎯 **Interview:** One root exception per library/app; carry context (error codes, messages); use exception chaining (`from e`); don't catch `Exception` broadly; map to HTTP codes at API boundary; keep hierarchy shallow.

### 4️⃣9️⃣7️⃣ What is the best practice for naming conventions in Python classes and modules (PEP 8)? 🏷️
🧒 **Simple:** Follow the naming rules everyone agreed on.
💻 **Example:**
| Thing | Style |
|---|---|
| Class | `CapWords` |
| Function/method/variable | `snake_case` |
| Constant | `UPPER_SNAKE_CASE` |
| Module/package | `short_lowercase` |
| Protected | `_leading` |
| Mangled | `__double` |
| Avoid clash with keyword | `class_` |
🎯 **Interview:** Exceptions end in `Error`; type variables `T`; max line length 79 (or 88 with Black). Consistency > preference.

### 4️⃣9️⃣8️⃣ What is the difference between public, protected, and private attributes across different programming languages compared to Python? 🌐
🧒 **Simple:** Java/C++ *enforce* privacy with keywords. Python only *suggests* privacy with underscores.
💻 **Example:**
| Level | Java/C++ | Python |
|---|---|---|
| Public | `public` | `x` |
| Protected | `protected` | `_x` (convention) |
| Private | `private` | `__x` (mangled, not enforced) |
🎯 **Interview:** Python philosophy: "We're all consenting adults." Privacy is by convention; enforcement via properties/descriptors/mangling is "soft."

### 4️⃣9️⃣9️⃣ How do you test private and protected methods in unit testing frameworks like `pytest`? 🧪🔒
🧒 **Simple:** Best way: test them through the public methods. If you *must*, call them directly.
💻 **Example:**
```python
def test_protected():
    assert Calc()._helper(2) == 4          # protected: just call it
def test_private():
    assert Calc()._Calc__secret() == 42    # mangled name
```
🎯 **Interview:** Prefer testing behavior via public API; testing privates couples tests to implementation. If a private method is complicated, extract it into its own class/module and test it publicly. Mock with `monkeypatch`/`patch.object`.

### 5️⃣0️⃣0️⃣ What is the ultimate goal of combining Python core language features with advanced Object-Oriented design principles? 🏆🎯
🧒 **Simple:** To write code that is clean, easy to change, easy to test, and fun to work with! 🎉
💻 **Example:** `dataclass` + `Protocol` + DI + composition + type hints + tests = a happy codebase 🥳
🎯 **Interview:** Goal: maintainable, scalable, testable, readable software. Use Python's strengths (duck typing, first-class functions, protocols, dataclasses, context managers) *with* SOLID, composition, and patterns **when they reduce complexity — not for their own sake**. Remember the Zen of Python: *"Simple is better than complex."* 🧘

---

# 🎓 BONUS: Last-Minute Interview Cheat Sheet 📝🔥

| 🔥 Topic | ⚡ One-line answer |
|---|---|
| GIL | Mutex allowing one thread to run Python bytecode at a time (CPython) 🔒 |
| `is` vs `==` | identity vs equality 🪪⚖️ |
| Mutable default arg | Evaluated once → use `None` sentinel 🪤 |
| `__new__` vs `__init__` | create vs initialize 🥚🐣 |
| MRO | C3 linearization; view with `.__mro__` 🧭 |
| `@staticmethod` / `@classmethod` | no implicit arg / receives `cls` 🗿🏫 |
| Shallow vs deep copy | share nested objects vs duplicate all 🪞 |
| Generator vs list comp | lazy vs eager 😴🍕 |
| Threads vs processes | I/O-bound vs CPU-bound 🧵👨‍👩‍👧 |
| `asyncio` | single-thread cooperative concurrency ⚡ |
| Descriptor precedence | data descriptor → instance dict → non-data/class attr 🥇🥈🥉 |
| `__slots__` | no `__dict__` → less memory 🎰 |
| Metaclass | class of a class; default `type` 🦸 |
| Pickle risk | arbitrary code execution on load ☠️ |
| Composition vs inheritance | has-a vs is-a 🧩 |
| SOLID | S, O, L, I, D 🧱 |

---

> 🎉 **Congratulations!** You've reached the end of all **500 questions**! 🏁
> 🧠 Now go crack that interview! May your code be bug-free and your tracebacks short. 🐍✨
>
> *"There are only two hard things in Computer Science: cache invalidation, naming things, and off-by-one errors."* 😜
