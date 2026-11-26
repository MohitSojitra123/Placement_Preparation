<a id="top"></a>

<div align="center">

# 🍲 BeautifulSoup (bs4) — 200 Questions & Answers

### ✨ Every question solved with a working example ✨

![Python](https://img.shields.io/badge/Python-3.8%2B-3776AB?logo=python&logoColor=white)
![bs4](https://img.shields.io/badge/beautifulsoup4-4.12%2B-green?logo=python&logoColor=white)
![Questions](https://img.shields.io/badge/Questions-200-orange)
![Level](https://img.shields.io/badge/Level-Basic%20→%20Interview-blueviolet)
![Format](https://img.shields.io/badge/Format-GitHub%20Markdown-black?logo=markdown)

**🟢 Basic (1-60) · 🟡 Intermediate (61-115) · 🔴 Hard (116-165) · 🔵 Technical Interview (166-185) · 🟣 One-to-One Interview (186-200)**

</div>

---

## 🧭 Navigation

| # | Part | Questions | Jump |
|:-:|------|:---------:|:----:|
| 🟢 | **Part 1 — Basic** (Theory + Practical) | 1 – 60 | [Go ➜](#part1) |
| 🟡 | **Part 2 — Intermediate** (Theory + Practical) | 61 – 115 | [Go ➜](#part2) |
| 🔴 | **Part 3 — Hard** (Theory + Practical) | 116 – 165 | [Go ➜](#part3) |
| 🔵 | **Part 4 — Technical Interview** | 166 – 185 | [Go ➜](#part4) |
| 🟣 | **Part 5 — One-to-One Interview** | 186 – 200 | [Go ➜](#part5) |
| 📌 | **Cheat Sheet** | — | [Go ➜](#cheatsheet) |

### 🔖 Legend

| Icon | Meaning |
|:----:|---------|
| 📖 | Theory question |
| 💻 | Practical / coding question |
| 💡 | Tip |
| ⚠️ | Warning / common mistake |
| ✅ | Best practice |
| ❌ | What to avoid |
| 🎤 | Interview-style answer |

> [!NOTE]
> **How to use this guide:** all examples reuse the **sample document** below unless the question brings its own HTML. When an example *modifies* the tree, re-create `soup` first so results stay predictable.

---

## 🧪 Sample Document (used throughout)

```python
from bs4 import BeautifulSoup

html = """
<html>
<head><title>Book Store</title></head>
<body>
  <div id="main" class="container big">
    <h1>Welcome</h1>
    <ul id="books">
      <li class="item" data-id="1"><a href="/p/python">Python Book</a> <span class="price">10</span></li>
      <li class="item sale" data-id="2"><a href="/p/java">Java Book</a> <span class="price">25</span></li>
      <li class="item" data-id="3"><a href="/p/guide.pdf">Guide</a> <span class="price">30</span></li>
    </ul>
    <a name="top">Anchor only</a>
    <!-- footer comment -->
  </div>
</body>
</html>
"""
soup = BeautifulSoup(html, "html.parser")
```

<div align="right"><a href="#top">⬆️ back to top</a></div>

---

<a id="part1"></a>

# 🟢 PART 1 — BASIC LEVEL

## 📖 A. Basic Theory (1–30)

### 🍲 Q1 · What is BeautifulSoup?
A **Python library for parsing HTML and XML** and extracting data from them. It turns messy markup into a **tree of Python objects** you can search, navigate and modify.

```python
from bs4 import BeautifulSoup
print(BeautifulSoup("<p>Hello</p>", "html.parser").p.text)   # Hello
```

### 👨‍💻 Q2 · Who created it, and what are the install / import names?
Created by **Leonard Richardson**. The **PyPI package is `beautifulsoup4`**; the **import name is `bs4`**.

```bash
pip install beautifulsoup4
```
```python
from bs4 import BeautifulSoup
```
> [!WARNING]
> `pip install bs4` only installs a dummy wrapper that pulls in `beautifulsoup4`. Always install `beautifulsoup4`.

### 🕸️ Q3 · What is web scraping?
**Automatically extracting data from websites** (download page → parse → pick data → store). Examples: price monitoring, news headlines, job listings.

### 🌐 Q4 · Does BeautifulSoup fetch web pages?
**No.** It only *parses* text you give it. To download HTML use `requests`, `urllib`, `httpx`, `aiohttp`; for JavaScript pages use `Selenium` or `Playwright`.

```python
import requests
from bs4 import BeautifulSoup
html = requests.get("https://example.com", timeout=10).content
soup = BeautifulSoup(html, "html.parser")
```

### ⚙️ Q5 · What is a parser in BeautifulSoup?
The engine that **reads raw markup and builds the parse tree**. BeautifulSoup is a friendly API *on top of* a parser.

### 🧰 Q6 · Common parsers supported

| Parser | Usage string | Needs install? |
|--------|--------------|:--------------:|
| Python built-in | `"html.parser"` | ❌ No |
| lxml (HTML) | `"lxml"` | ✅ `pip install lxml` |
| lxml (XML) | `"xml"` or `"lxml-xml"` | ✅ lxml |
| html5lib | `"html5lib"` | ✅ `pip install html5lib` |

### ⚖️ Q7 · `html.parser` vs `lxml` vs `html5lib`

| Feature | 🐍 html.parser | ⚡ lxml | 🌍 html5lib |
|---------|---------------|--------|------------|
| Speed | Decent | **Fastest** | Slowest |
| Leniency | Moderate | Good | **Best (browser-like)** |
| Dependency | None | C library | Pure Python |
| Adds `<html><body>`? | No | Yes | Yes |

### 🤷 Q8 · What if you don't specify a parser?
bs4 **picks the best installed parser** (lxml → html5lib → html.parser) and shows a `GuessedAtParserWarning`. Results may **differ between machines** ➜ always specify one.

### 🌳 Q9 · What is the parse tree?
A **nested tree** of objects (`Tag`, `NavigableString`, …) that mirrors the HTML structure: `html → head/body → div → ul → li …`.

### 🧱 Q10 · Four main object types
1. `Tag` 2. `NavigableString` 3. `BeautifulSoup` 4. `Comment`

### 🏷️ Q11 · What is a `Tag`?
An HTML/XML element (`<li class="item">…</li>`) with a `.name`, `.attrs`, and children.
```python
li = soup.li
print(type(li), li.name)     # <class 'bs4.element.Tag'> li
```

### 🔤 Q12 · What is `NavigableString`?
A `str` subclass representing the **text inside a tag**.
```python
s = soup.h1.string
print(type(s), s)            # <class 'bs4.element.NavigableString'> Welcome
```

### 🥣 Q13 · What is the `BeautifulSoup` object?
The **root of the tree** — represents the whole document. It acts like a Tag with the special name `[document]`.
```python
print(soup.name)             # [document]
```

### 💬 Q14 · What is a `Comment`?
A `NavigableString` subclass for `<!-- … -->`.
```python
from bs4 import Comment
c = soup.find(string=lambda t: isinstance(t, Comment))
print(repr(c))               # ' footer comment '
```

### ✏️ Q15 · Access / change a tag's name
```python
tag = soup.h1
print(tag.name)   # h1
tag.name = "h2"   # renames it in the tree
print(tag)        # <h2>Welcome</h2>
```

### 🔑 Q16 · Access tag attributes
```python
li = soup.li
print(li["data-id"])        # 1
print(li.attrs)             # {'class': ['item'], 'data-id': '1'}
```

### 🛡️ Q17 · Why is `get()` safer than `[]`?
`tag["x"]` raises **`KeyError`** if missing; `tag.get("x")` returns **`None`** (or a default).
```python
a = soup.find("a", attrs={"name": "top"})
print(a.get("href"))              # None
print(a.get("href", "no-link"))   # no-link
# a["href"]  -> KeyError
```

### 🎭 Q18 · Multi-valued attributes
Attributes the HTML spec allows to hold **several space-separated values** are returned as a **list**: `class`, `rel`, `rev`, `accept-charset`, `headers`, `accesskey`, `dropzone`.
```python
print(soup.find("li", class_="sale")["class"])   # ['item', 'sale']
print(soup.li["data-id"])                         # '1'  (plain string)
```

### 🔍 Q19 · `find()` vs `find_all()`

| | `find()` | `find_all()` |
|--|---------|-------------|
| Returns | **first** match (`Tag`) or `None` | **all** matches (`ResultSet`, maybe empty) |
| Equivalent | `find_all(..., limit=1)[0]` | — |

```python
print(soup.find("li")["data-id"])            # 1
print(len(soup.find_all("li")))              # 3
```

### 🧵 Q20 · What does `.string` return?
The **single string** inside a tag. It is `None` when the tag has **more than one child** (or none). If the tag has exactly one child *tag*, it recurses into it.
```python
print(soup.h1.string)    # Welcome
print(soup.li.string)    # None  (li has <a>, text, <span>)
print(soup.title.string) # Book Store
```

### 🆚 Q21 · `.string` vs `.text` vs `get_text()`

| | Returns | Multiple children? | Options |
|--|---------|:-----------------:|---------|
| `.string` | one `NavigableString` or `None` | ❌ `None` | none |
| `.text` | all text joined (property) | ✅ | none |
| `get_text()` | all text joined (method) | ✅ | `separator`, `strip` |

```python
print(soup.li.text)                                  # Python Book 10
print(soup.li.get_text(" | ", strip=True))           # Python Book | 10
```

### 🎀 Q22 · What does `prettify()` do?
Returns the tree as an **indented, human-readable string** (one tag per line).
```python
print(soup.h1.prettify())
# <h1>
#  Welcome
# </h1>
```

### 📦 Q23 · What is `.contents`?
A **list** of a tag's direct children (tags *and* strings).
```python
print(soup.ul.contents[:2])   # ['\n', <li class="item" data-id="1">…</li>]
```

### 🚸 Q24 · `.children` vs `.contents`
`.children` is a **generator/iterator** (lazy); `.contents` is a **list** (index-able, `len()`).
```python
for child in soup.ul.children:
    if child.name:
        print(child["data-id"])   # 1 2 3
```

### 🧬 Q25 · What is `.descendants`?
A generator over **all nested children, recursively** (children, grandchildren, …).
```python
print(sum(1 for _ in soup.ul.descendants))
```

### 👪 Q26 · `.parent` and `.parents`
`.parent` = immediate parent; `.parents` = generator up to the root.
```python
a = soup.a
print(a.parent.name)                         # li
print([p.name for p in a.parents])           # ['li','ul','div','body','html','[document]']
```

### 👫 Q27 · Siblings
Elements at the same level. `.next_sibling` / `.previous_sibling` return the adjacent node — often **whitespace `'\n'`**, not a tag!
```python
first = soup.li
print(repr(first.next_sibling))              # '\n'
print(first.find_next_sibling("li")["data-id"])  # 2
```

### 🔗 Q28 · What does `soup.title` do?
Dot-notation = `find("title")` → returns only the **first** matching tag.
```python
print(soup.title)        # <title>Book Store</title>
print(soup.a)            # first <a>, same as soup.find("a")
```

### 📚 Q29 · What is a `ResultSet`?
A **list subclass** returned by `find_all()` / `select()`, holding all matches (and `.source` = the search criteria). Empty if nothing matched (never `None`).

### 🆚 Q30 · BeautifulSoup vs Scrapy

| | 🍲 BeautifulSoup | 🕷️ Scrapy |
|--|-----------------|----------|
| Type | Parsing **library** | Full scraping **framework** |
| Fetching | ❌ (use requests) | ✅ built-in |
| Concurrency | Manual | ✅ async engine |
| Pipelines/retries/export | Manual | ✅ built-in |
| Best for | Small/medium scripts, learning | Large crawlers |

<div align="right"><a href="#top">⬆️ back to top</a></div>

---

## 💻 B. Basic Practical (31–60)

### 📥 Q31 · Install BeautifulSoup, lxml, requests & verify
```bash
pip install beautifulsoup4 lxml requests
pip show beautifulsoup4
python -c "import bs4, lxml, requests; print('bs4', bs4.__version__)"
```

### 🏁 Q32 · Soup from an HTML string; print title & its text
```python
from bs4 import BeautifulSoup
soup = BeautifulSoup("<html><head><title>Hello</title></head></html>", "html.parser")
print(soup.title)          # <title>Hello</title>
print(soup.title.text)     # Hello
```

### 🌍 Q33 · Fetch a page with `requests`, print `<h1>`
```python
import requests
from bs4 import BeautifulSoup

r = requests.get("https://example.com", timeout=10)
r.raise_for_status()
soup = BeautifulSoup(r.content, "html.parser")
h1 = soup.find("h1")
print(h1.get_text(strip=True) if h1 else "No h1 found")
```

### 🔗 Q34 · Print all links (text + href)
```python
for a in soup.find_all("a"):
    print(a.get_text(strip=True), "->", a.get("href"))
# Python Book -> /p/python
# Java Book -> /p/java
# Guide -> /p/guide.pdf
# Anchor only -> None
```

### 📋 Q35 · All `href`s as a list (skip anchors without href)
```python
hrefs = [a["href"] for a in soup.find_all("a", href=True)]
print(hrefs)   # ['/p/python', '/p/java', '/p/guide.pdf']
```

### 🆔 Q36 · Find by `id`
```python
print(soup.find(id="books").name)         # ul
print(soup.select_one("#main").name)      # div
```

### 🏷️ Q37 · `li` tags with class `item`
```python
items = soup.find_all("li", class_="item")
print(len(items))     # 3
```

### 🎯 Q38 · `div` by multiple classes (exact string)
```python
print(soup.find("div", class_="container big"))   # exact string, same order
print(soup.select_one("div.container.big"))       # any order ✅ preferred
```

### 🧲 Q39 · Find with `attrs`
```python
print(soup.find_all(attrs={"data-id": "2"}))     # [<li class="item sale" data-id="2">…</li>]
print(soup.find("li", attrs={"data-id": "3"}).a.text)   # Guide
```

### 🧹 Q40 · All text, newline separated and stripped
```python
print(soup.get_text(separator="\n", strip=True))
# Book Store
# Welcome
# Python Book
# 10 ...
```

### 🔢 Q41 · Count `li` tags
```python
print(len(soup.find_all("li")))   # 3
```

### 💰 Q42 · Prices as integers
```python
prices = [int(s.text) for s in soup.select("span.price")]
print(prices)   # [10, 25, 30]
```

### ✂️ Q43 · Limit results to the first two
```python
print(soup.find_all("li", limit=2))
```

### 👶 Q44 · Names of `ul` children, skipping whitespace
```python
print([c.name for c in soup.ul.children if c.name])   # ['li', 'li', 'li']
```

### ⬆️ Q45 · Parent tag name of the first `a`
```python
print(soup.find("a").parent.name)   # li
```

### ➡️ Q46 · Next sibling `li` (skip whitespace)
```python
li = soup.find("li")
print(li.find_next_sibling("li")["data-id"])   # 2
```

### ❓ Q47 · Does a tag have an attribute?
```python
li = soup.li
print(li.has_attr("data-id"))   # True
print("href" in li.attrs)       # False
```

### 🔧 Q48 · Modify `href`
```python
a = soup.find("a")
a["href"] = "https://example.com/new"
print(a)   # <a href="https://example.com/new">Python Book</a>
```

### 📝 Q49 · Change `h1` text
```python
soup.h1.string = "Hello World"
print(soup.h1)   # <h1>Hello World</h1>
```

### 🗑️ Q50 · Delete an attribute
```python
del soup.li["data-id"]
print(soup.li)   # <li class="item"> … </li>
```

### 💥 Q51 · Remove a tag completely
```python
soup.find("span", class_="price").decompose()   # destroys it
# or: removed = tag.extract()  -> removes but returns it (reusable)
```

### 💬 Q52 · Extract all comments
```python
from bs4 import Comment
comments = soup.find_all(string=lambda t: isinstance(t, Comment))
print([c.strip() for c in comments])   # ['footer comment']
```

### 💾 Q53 · Save modified HTML as UTF-8
```python
with open("output.html", "w", encoding="utf-8") as f:
    f.write(soup.prettify())
```

### 📂 Q54 · Parse a local HTML file
```python
with open("page.html", "r", encoding="utf-8") as f:
    soup = BeautifulSoup(f, "html.parser")
```

### 🏷️ Q55 · Unique tag names
```python
print(sorted({t.name for t in soup.find_all(True)}))
# ['a','body','div','h1','head','html','li','span','title','ul']
```

### 🔤 Q56 · Find `a` by exact text
```python
print(soup.find("a", string="Java Book")["href"])   # /p/java
```

### 🎨 Q57 · CSS selector: `h1` inside `#main`
```python
print(soup.select_one("#main h1").get_text())   # Welcome
```

### 🛍️ Q58 · Select `li` with class `sale`
```python
for li in soup.select("li.sale"):
    print(li.a.text)   # Java Book
```

### 🛟 Q59 · Handle a missing tag safely
```python
h9 = soup.find("h9")
text = h9.get_text(strip=True) if h9 else "N/A"
print(text)   # N/A

# or a reusable helper
def safe_text(tag, default=""):
    return tag.get_text(strip=True) if tag else default
```
> [!TIP]
> `None.text` is what causes `AttributeError: 'NoneType' object has no attribute 'text'` — always check first.

### 🗂️ Q60 · Print the attributes dictionary & explain
```python
print(soup.find("li", class_="sale").attrs)
# {'class': ['item', 'sale'], 'data-id': '2'}
```
**Explanation:** it is a normal Python `dict`. `class` is **multi-valued → list**; `data-id` is a **plain string**.

<div align="right"><a href="#top">⬆️ back to top</a></div>

---

<a id="part2"></a>

# 🟡 PART 2 — INTERMEDIATE LEVEL

## 📖 C. Intermediate Theory (61–85)

### 🎛️ Q61 · Filter types accepted by `find_all()`

| Filter | Example |
|--------|---------|
| 🔤 String | `find_all("a")` |
| 🧩 Regex | `find_all(re.compile("^h[1-6]$"))` |
| 📋 List | `find_all(["h1", "title"])` |
| ✅ `True` | `find_all(True)` → every tag |
| 🧠 Function | `find_all(lambda t: t.has_attr("data-id"))` |
| 🏷️ Keyword attr | `find_all("a", href=True)`, `id="x"`, `class_="y"` |

### 🐍 Q62 · Why `class_` instead of `class`?
`class` is a **reserved Python keyword**, so bs4 uses `class_` (trailing underscore). Alternative: `attrs={"class": "item"}`.

### 🎭 Q63 · Class matching with multi-valued classes
`class_="item"` matches if **any one** class equals `item`. Passing a full string like `class_="item sale"` matches only the **exact attribute string in that order**.
```python
soup.find_all("li", class_="sale")        # ✅ matches 1
soup.find_all("li", class_="item sale")   # ✅ exact string
soup.find_all("li", class_="sale item")   # ❌ 0 (order differs)
soup.select("li.sale.item")               # ✅ any order
```

### 🔭 Q64 · `find_next()`, `find_previous()`, `find_all_next()`
They walk **document order** (not just siblings): `find_next(x)` first match *after* this element, `find_previous(x)` first match *before*, `find_all_next(x)` all matches after.
```python
print(soup.h1.find_next("li")["data-id"])   # 1
```

### 👴 Q65 · `find_parent()` vs `find_parents()`
`find_parent(name)` → **nearest** matching ancestor; `find_parents(name)` → **list of all** matching ancestors.
```python
print(soup.a.find_parent("ul")["id"])             # books
print([p.name for p in soup.a.find_parents("li")])# ['li']
```

### 🔀 Q66 · `.next_sibling` vs `.next_element`
`.next_sibling` stays on the **same level**. `.next_element` is whatever the parser met **next** (can go *into* children).
```python
li = soup.li
print(li.next_element.name)        # a      (first child)
print(repr(li.next_sibling))       # '\n'  (same level)
```

### 🔁 Q67 · What does `recursive=False` do?
Searches **only direct children**, not the whole subtree.
```python
soup.ul.find_all("li", recursive=False)   # 3 direct li
soup.ul.find_all("a", recursive=False)    # []  (a's are grandchildren)
```

### 🎨 Q68 · What is `select()`, which library powers it?
Runs **CSS selectors**; powered by the **Soup Sieve** library (installed with bs4 4.7+).

### ⚖️ Q69 · `find_all()` vs `select()`

| Use `find_all()` | Use `select()` |
|------------------|----------------|
| Simple name/attr filters, regex, functions | Nested paths: `div.card > h2 a` |
| Custom Python logic | Pseudo-classes: `:nth-child`, `:has`, `:not` |
| Text matching with `string=` | Anyone who knows CSS/browser DevTools |

### 🎯 Q70 · What does `select_one()` return?
The **first** matching `Tag`, or `None`.
```python
print(soup.select_one("li.sale a").text)   # Java Book
```

### 🧲 Q71 · CSS attribute selectors

| Selector | Meaning |
|----------|---------|
| `[href]` | has attribute |
| `[href="x"]` | equals |
| `[href^="/p/"]` | starts with |
| `[href$=".pdf"]` | ends with |
| `[href*="java"]` | contains |
| `[class~="sale"]` | word in whitespace list |
| `[lang\|="en"]` | equals or starts with `en-` |
| `[href="x" i]` | case-insensitive |

### 🧼 Q72 · What are `.stripped_strings`?
A generator of all strings in a tag with **whitespace stripped and empty ones skipped**.
```python
print(list(soup.li.stripped_strings))   # ['Python Book', '10']
```

### 🗑️ Q73 · `extract()` vs `decompose()` vs `clear()`

| Method | Effect | Returns |
|--------|--------|---------|
| `extract()` | Removes tag from tree (still usable) | the tag |
| `decompose()` | Destroys tag & children (frees memory) | `None` |
| `clear()` | Empties **contents**, keeps the tag itself | `None` |

### 🔄 Q74 · What does `replace_with()` do?
Replaces a tag/string with another one (or several).
```python
soup.h1.replace_with(soup.new_tag("h2"))
```

### 🎁 Q75 · `wrap()` and `unwrap()`
`wrap(tag)` puts the element **inside** a new tag; `unwrap()` removes the tag but **keeps its children**.
```python
soup.h1.wrap(soup.new_tag("header"))   # <header><h1>…</h1></header>
soup.a.unwrap()                        # keeps link text
```

### 🆕 Q76 · Create a new tag
```python
new = soup.new_tag("li", attrs={"class": "item"})
new.string = "Rust Book"
print(new)   # <li class="item">Rust Book</li>
```

### ➕ Q77 · `append()` / `insert()` / `insert_before()` / `insert_after()`

| Method | Where it puts the new node |
|--------|---------------------------|
| `append(x)` | **end** of children |
| `insert(i, x)` | at **index i** among children |
| `insert_before(x)` | **before** this tag (as sibling) |
| `insert_after(x)` | **after** this tag (as sibling) |

### 🧪 Q78 · What is `SoupStrainer`?
A filter passed as `parse_only=` so bs4 **only builds the tree for matching tags** → less memory, faster.
```python
from bs4 import SoupStrainer
only_a = SoupStrainer("a")
soup = BeautifulSoup(html, "html.parser", parse_only=only_a)
```

### 🔌 Q79 · Is `parse_only` compatible with all parsers?
**No.** It works with `html.parser` and `lxml`, but **not `html5lib`** (it always parses the entire document).

### 🖋️ Q80 · What is a formatter?
Controls **how output is escaped** by `decode()/prettify()`: `"minimal"` (default: `& < >`), `"html"` (named entities), `"html5"`, or `None` (no escaping).
```python
print(BeautifulSoup("<p>caf&eacute; &amp; tea</p>", "html.parser").p.decode(formatter="html"))
# <p>caf&eacute; &amp; tea</p>
```

### 🔠 Q81 · How does bs4 handle encodings?
It converts everything to **Unicode** internally. For `bytes` input it detects the encoding (meta tag → chardet → utf-8/windows-1252). Output via `.encode()` defaults to **UTF-8**.

### 🔡 Q82 · What is `UnicodeDammit`?
bs4's encoding-detection class.
```python
from bs4 import UnicodeDammit
d = UnicodeDammit("café".encode("utf-8"))
print(d.unicode_markup, d.original_encoding)   # café utf-8
```

### 📦 Q83 · Why `response.content` instead of `response.text`?
`.text` is decoded by `requests` using the **HTTP header guess** (often wrong → ISO-8859-1 mojibake). `.content` is raw `bytes`, letting bs4 read `<meta charset>` and choose the right encoding.

### 🔄 Q84 · `decode()` vs `encode()` on a tag
`tag.decode()` → **`str`**; `tag.encode("utf-8")` → **`bytes`**. `str(tag)` ≈ `decode()`.

### 🪄 Q85 · What does `soup.smooth()` do?
Merges **adjacent `NavigableString`** objects left over after edits (bs4 ≥ 4.8) so `.contents` is clean.
```python
p = BeautifulSoup("<p>a</p>", "html.parser").p
p.append("b"); print(p.contents)   # ['a', 'b']
p.smooth();   print(p.contents)    # ['ab']
```

<div align="right"><a href="#top">⬆️ back to top</a></div>

---

## 💻 D. Intermediate Practical (86–115)

> [!NOTE]
> Re-create `soup` from the sample document before examples that modify the tree.

### 🔢 Q86 · Heading tags h1–h6 via regex
```python
import re
print(soup.find_all(re.compile(r"^h[1-6]$")))
```

### 🔗 Q87 · Links whose `href` starts with `/p/`
```python
print([a["href"] for a in soup.find_all("a", href=re.compile(r"^/p/"))])
# or CSS: soup.select('a[href^="/p/"]')
```

### 📚 Q88 · Multiple tag names in one call
```python
print(soup.find_all(["h1", "title"]))
```

### 🧠 Q89 · Function filter: has `data-id` but no `id`
```python
def has_data_no_id(tag):
    return tag.has_attr("data-id") and not tag.has_attr("id")

print(soup.find_all(has_data_no_id))
```

### 🔎 Q90 · Tags with any `data-id`
```python
print(soup.find_all(attrs={"data-id": True}))
print(soup.select("[data-id]"))
```

### 📖 Q91 · Dict of product name → integer price
```python
products = {li.a.text: int(li.select_one(".price").text) for li in soup.select("ul#books li")}
print(products)   # {'Python Book': 10, 'Java Book': 25, 'Guide': 30}
```

### 🗃️ Q92 · List of dicts (id, name, url, price)
```python
rows = [
    {
        "id": int(li["data-id"]),
        "name": li.a.get_text(strip=True),
        "url": li.a["href"],
        "price": int(li.select_one(".price").text),
    }
    for li in soup.select("li.item")
]
print(rows[0])  # {'id': 1, 'name': 'Python Book', 'url': '/p/python', 'price': 10}
```

### 📊 Q93 · Save rows to CSV
```python
import csv
with open("books.csv", "w", newline="", encoding="utf-8") as f:
    w = csv.DictWriter(f, fieldnames=rows[0].keys())
    w.writeheader()
    w.writerows(rows)
```

### 🧾 Q94 · Pretty JSON
```python
import json
print(json.dumps(rows, indent=2, ensure_ascii=False))
```

### 🧭 Q95 · Relative → absolute URLs
```python
from urllib.parse import urljoin
base = "https://shop.example.com/store/"
for a in soup.find_all("a", href=True):
    print(urljoin(base, a["href"]))   # https://shop.example.com/p/python
```

### 🧮 Q96 · HTML table → list of rows
```python
table_html = """<table>
<tr><th>Name</th><th>Qty</th></tr>
<tr><td>Pen</td><td>5</td></tr>
<tr><td>Book</td><td>2</td></tr></table>"""
t = BeautifulSoup(table_html, "html.parser").table
data = [[c.get_text(strip=True) for c in tr.find_all(["th", "td"])] for tr in t.find_all("tr")]
print(data)   # [['Name','Qty'], ['Pen','5'], ['Book','2']]
```

### 🐼 Q97 · Table → pandas DataFrame
```python
import pandas as pd
df = pd.DataFrame(data[1:], columns=data[0])
print(df)
# shortcut: pd.read_html(table_html)[0]
```

### 🖼️ Q98 · All image sources
```python
srcs = [img["src"] for img in soup.find_all("img", src=True)]
```

### ⬇️ Q99 · Download all images into a folder
```python
import os, requests
from urllib.parse import urljoin, urlparse

os.makedirs("images", exist_ok=True)
page = "https://example.com"
soup = BeautifulSoup(requests.get(page, timeout=10).content, "html.parser")
for img in soup.find_all("img", src=True):
    url = urljoin(page, img["src"])
    name = os.path.basename(urlparse(url).path) or "image.jpg"
    r = requests.get(url, timeout=10)
    if r.ok:
        with open(os.path.join("images", name), "wb") as f:
            f.write(r.content)
```

### 🧽 Q100 · Remove `script`/`style` and get clean text
```python
for t in soup(["script", "style"]):
    t.decompose()
print(soup.get_text(" ", strip=True))
```

### ➕ Q101 · Add a new `li` to a `ul`
```python
new = soup.new_tag("li", attrs={"class": "item"})
new.string = "Rust Book"
soup.ul.append(new)
```

### ⏮️ Q102 · Insert at position 0
```python
soup.ul.insert(0, new)
```

### 🎁 Q103 · Wrap `h1` in `header`
```python
soup.h1.wrap(soup.new_tag("header"))
print(soup.header)   # <header><h1>Welcome</h1></header>
```

### 🔓 Q104 · Unwrap all links, keep text
```python
for a in soup.find_all("a"):
    a.unwrap()
print(soup.li)   # <li class="item" data-id="1">Python Book <span class="price">10</span></li>
```

### 🔁 Q105 · Replace `h1` with `h2`
```python
h2 = soup.new_tag("h2"); h2.string = soup.h1.string
soup.h1.replace_with(h2)
# simpler: soup.h1.name = "h2"
```

### 🎨 Q106 · Add a class to a tag with existing classes
```python
li = soup.li
li["class"].append("featured")   # class is a list
print(li["class"])               # ['item', 'featured']
```

### 👶 Q107 · Direct-child `li` only (CSS)
```python
print(soup.select("ul#books > li"))
```

### 2️⃣ Q108 · Second `li` (pseudo-class)
```python
print(soup.select_one("ul#books li:nth-of-type(2)").a.text)   # Java Book
```

### 📄 Q109 · Links ending in `.pdf`
```python
print(soup.select('a[href$=".pdf"]'))
```

### 🎯 Q110 · Parse only `a` tags with `SoupStrainer`
```python
from bs4 import SoupStrainer
only_a = BeautifulSoup(html, "html.parser", parse_only=SoupStrainer("a"))
print(len(only_a.find_all("a")))   # 4
```

### 📃 Q111 · Pagination loop until no items
```python
import requests
from bs4 import BeautifulSoup

page, results = 1, []
while True:
    r = requests.get(f"https://example.com/products?page={page}", timeout=10)
    soup = BeautifulSoup(r.content, "html.parser")
    items = soup.select("li.item")
    if not items:                # stop condition
        break
    results.extend(i.get_text(strip=True) for i in items)
    page += 1
print(len(results))
```

### ⏭️ Q112 · Follow the "Next" link until the last page
```python
from urllib.parse import urljoin
url = "https://example.com/page/1"
while url:
    soup = BeautifulSoup(requests.get(url, timeout=10).content, "html.parser")
    # ... extract data here ...
    nxt = soup.find("a", string="Next") or soup.select_one("a.next, a[rel~=next]")
    url = urljoin(url, nxt["href"]) if nxt and nxt.get("href") else None
```

### 🪪 Q113 · Custom User-Agent
```python
headers = {"User-Agent": "Mozilla/5.0 (compatible; MyScraper/1.0; +https://me.dev/bot)"}
r = requests.get(url, headers=headers, timeout=10)
```

### 🔐 Q114 · Use a `requests.Session`
```python
s = requests.Session()
s.headers.update(headers)            # reused for every request
r1 = s.get("https://example.com/a", timeout=10)   # keeps cookies + TCP connection
r2 = s.get("https://example.com/b", timeout=10)
```

### 🛤️ Q115 · Print ancestor path of a tag
```python
tag = soup.find("li")
path = [p.name for p in reversed(list(tag.parents)) if p.name != "[document]"]
print(" > ".join(path + [tag.name]))   # html > body > div > ul > li
```

<div align="right"><a href="#top">⬆️ back to top</a></div>

---

<a id="part3"></a>

# 🔴 PART 3 — HARD LEVEL

## 📖 E. Hard Theory (116–140)

### 🩹 Q116 · How `html.parser` handles malformed HTML vs `html5lib`
`html.parser` is **lenient but literal** — it doesn't restructure much (no `<html>/<body>` added). `html5lib` follows the **HTML5 spec like a real browser**: it always creates `html/head/body` and repairs nesting.
```python
broken = "<p>One<p>Two<b>bold"
BeautifulSoup(broken, "html.parser")   # <p>One<p>Two<b>bold</b></p></p>   (nested p!)
BeautifulSoup(broken, "html5lib")      # <html><head></head><body><p>One</p><p>Two<b>bold</b></p></body></html>
```

### 🌳 Q117 · Why can the same HTML produce different trees?
Each parser implements **different error-recovery rules**. Invalid HTML has no single "correct" tree, so `html.parser`, `lxml`, `html5lib` guess differently ➜ selectors that work on one may fail on another.
> [!TIP]
> ✅ Pin one parser per project and test against saved HTML.

### 🧬 Q118 · What is Soup Sieve and why does it matter?
**Soup Sieve** is the CSS-selector engine behind `.select()` (bs4 ≥ 4.7). It supports CSS3/4 selectors (`:has`, `:not`, `:nth-child`, `:is`, `:-soup-contains`) — which makes complex queries one line instead of nested loops.

### 🔍 Q119 · What is `:-soup-contains()`?
A Soup Sieve pseudo-class that matches elements **containing given text** (replaces deprecated `:contains()`). Variant `:-soup-contains-own()` ignores text from descendants.
```python
print(soup.select('li:-soup-contains("Java")'))
```

### 🧩 Q120 · What is the `soup.css` property?
Added in **bs4 4.12**: a namespace exposing Soup Sieve directly — `soup.css.select()`, `.select_one()`, `.iselect()` (generator), `.closest()`, `.match()`, `.filter()`, `.escape()`.
```python
for li in soup.css.iselect("li.item"):   # lazy
    print(li["data-id"])
```

### 🗞️ Q121 · XML parsing & namespaces
Use `BeautifulSoup(xml, "xml")` (needs **lxml**). Tags keep their **prefix** (`dc:creator`); tag names are **case-sensitive**; empty tags self-close; CSS selection of namespaced tags needs `namespaces={...}` (see Q147).
```python
x = BeautifulSoup("<root><Item>1</Item></root>", "xml")
print(x.find("Item").text)   # 1
```

### 🧱 Q122 · `CData`, `Doctype`, `ProcessingInstruction`, `Declaration`

| Class | Represents |
|-------|-----------|
| `CData` | `<![CDATA[ … ]]>` |
| `Doctype` | `<!DOCTYPE html>` |
| `ProcessingInstruction` | `<?php … ?>` / `<?xml-stylesheet … ?>` |
| `Declaration` | `<?xml version="1.0"?>`-style declaration |

All are `NavigableString` subclasses.

### 📝 Q123 · What counts as text in `get_text()`?
Ordinary `NavigableString` and `CData` content. **Comments, Doctype, declarations, processing instructions** are excluded — and (bs4 ≥ 4.9) so are text of `<script>`, `<style>` and `<template>` when called on a parent tag.

### 🚫 Q124 · Why does `get_text()` skip `<script>` content?
In bs4 ≥ 4.9 the strings in `<script>`/`<style>` are special subclasses (`Script`, `Stylesheet`) that parent `get_text()` ignores, because JS/CSS isn't human text. Read them from the tag itself:
```python
s = BeautifulSoup("<div><script>var a=1;</script>Hi</div>", "html.parser")
print(s.div.get_text())        # Hi
print(s.script.get_text())     # var a=1;
```

### 🎭 Q125 · What is `multi_valued_attributes`?
A constructor argument that controls which attributes are split into lists. Set to `None` to keep `class` as a plain string.
```python
s = BeautifulSoup('<p class="a b">x</p>', "html.parser", multi_valued_attributes=None)
print(s.p["class"])   # 'a b'  (string)
```

### ♊ Q126 · Duplicate attributes — `on_duplicate_attribute`
Default: the **last** value wins. Options (html.parser only): `"replace"`, `"ignore"` (keep first) or a **callable**.
```python
h = '<a href="1" href="2">x</a>'
BeautifulSoup(h, "html.parser").a["href"]                                   # '2'
BeautifulSoup(h, "html.parser", on_duplicate_attribute="ignore").a["href"]  # '1'
```

### 🧶 Q127 · Why `find_all("a", string="Book")` can fail on multi-child tags
`string=` compares against a tag's **`.string`**, which is `None` when the tag has more than one child (e.g. `<a><b>Hot</b> Book</a>`). Also match is **exact** by default.
```python
soup.select('a:-soup-contains("Book")')                 # ✅ any descendant text
soup.find_all("a", string=re.compile("Book"))           # ✅ regex (single-string tags)
soup.find_all(lambda t: t.name=="a" and "Book" in t.get_text())  # ✅ most flexible
```

### 🐘 Q128 · Memory behavior with large files
The **entire tree lives in RAM** (each node = Python object ⇒ several × file size). Reduce with:
- ✅ `SoupStrainer` / `parse_only`
- ✅ `lxml` parser, process in chunks
- ✅ `decompose()` finished tags; `soup.decompose()` at the end
- ✅ For GB-size XML use `lxml.etree.iterparse` instead

### 🧵 Q129 · Thread-safety & multiprocessing
Separate soup objects in separate threads are fine; **don't share and mutate one soup across threads**. Parsing is **CPU-bound** (GIL) → threads help only for network waiting; use **`multiprocessing`/`ProcessPoolExecutor`** for heavy parsing.

### 🕹️ Q130 · Can bs4 run JavaScript?
**No.** It sees only the HTML you provide. Options: ✅ call the site's **JSON/XHR API** (best), ✅ **Selenium / Playwright** then pass `driver.page_source` to bs4, ✅ `requests-html`/Splash.

### 📜 Q131 · Document order
The order elements appear in the **source text** (depth-first, top→bottom). `find_all()`, `.descendants`, `.next_element` all follow it.

### 🪄 Q132 · What does `soup("a")` do?
`Tag.__call__` is a **shortcut for `find_all`**: `soup("a") == soup.find_all("a")`.

### 📑 Q133 · `copy.copy(tag)` — use?
Makes a **detached deep copy** of a tag, so you can edit/insert it elsewhere without altering the original.
```python
import copy
clone = copy.copy(soup.li)
soup.ul.append(clone)
```

### 🥒 Q134 · Is a soup picklable? Good idea?
Yes (`pickle.dumps(soup)`), but ❌ **not recommended**: deep trees can hit `RecursionError`, pickles are large/slow, and unsafe to load from untrusted sources. ✅ Store the **HTML string** (`str(soup)`) and re-parse.

### 🔬 Q135 · Detect parser & encoding used
```python
print(soup.original_encoding)     # encoding detected (None if input was str)
print(soup.builder.NAME)          # 'html.parser' / 'lxml' / 'html5lib'
print(soup.builder.features)      # ['html.parser', 'html', 'strict']
```

### 🩺 Q136 · What is `bs4.diagnose.diagnose()`?
Prints a **report**: bs4/lxml/html5lib versions, and how each installed parser parses your markup. Great for debugging parser differences.
```python
from bs4.diagnose import diagnose
diagnose("<p>One<p>Two")
```

### 🚨 Q137 · Common exceptions

| Exception | Cause |
|-----------|-------|
| `AttributeError: 'NoneType'…` | `find()` returned `None` |
| `KeyError` | `tag["missing"]` |
| `TypeError` | passing `None` as markup |
| `FeatureNotFound` | parser not installed |
| `ParserRejectedMarkup` | parser can't handle the input |
| `UnicodeDecodeError` | wrong encoding |
| `RecursionError` | extremely deep nesting |
| `requests.exceptions.*` | network/HTTP issues (not bs4) |

### 🧯 Q138 · `FeatureNotFound` — cause & fix
`bs4.FeatureNotFound: Couldn't find a tree builder with the features you requested: lxml`. The parser isn't installed.
```bash
pip install lxml        # or pip install html5lib
```
(or fall back to `"html.parser"`).

### ⚖️ Q139 · Legal & ethical aspects of scraping
- ✅ Read **robots.txt** and the site's **Terms of Service**
- ✅ Prefer official **APIs**; rate-limit; identify your bot
- ❌ Don't scrape **personal data** without a lawful basis (GDPR/CCPA/IT Act)
- ❌ Don't bypass logins/paywalls/CAPTCHAs or overload servers
- ⚠️ Copyright still applies to scraped content
*(This is information, not legal advice.)*

### 🔢 Q140 · Order of results
Both `find_all()` and `select()` return results in **document order** (first in source → first in list).

<div align="right"><a href="#top">⬆️ back to top</a></div>

---

## 💻 F. Hard Practical (141–165)

### 🔤 Q141 · Direct text of a tag only (exclude nested tags)
```python
from bs4 import NavigableString

def direct_text(tag):
    return "".join(t for t in tag.contents if type(t) is NavigableString).strip()

print(direct_text(soup.li))   # ''  (text is inside <a>/<span>)
p = BeautifulSoup("<p>Hello <b>big</b> world</p>", "html.parser").p
print(direct_text(p))         # Hello  world
```
`type(t) is NavigableString` also excludes `Comment`s.

### 🔍 Q142 · `li` containing "Book" (Soup Sieve)
```python
print(soup.select('li:-soup-contains("Book")'))   # Python Book, Java Book
```

### 💵 Q143 · Items with price > 20
```python
expensive = [li.a.text for li in soup.select("li.item")
             if int(li.select_one(".price").text) > 20]
print(expensive)   # ['Java Book', 'Guide']
```

### 🪆 Q144 · `:has()` — `li` containing `a[href]`
```python
print(len(soup.select("li:has(a[href])")))   # 3
```

### 🚫 Q145 · `:not()` — items without class `sale`
```python
print([li["data-id"] for li in soup.select("li.item:not(.sale)")])   # ['1', '3']
```

### 📡 Q146 · Parse an RSS/XML feed
```python
rss = """<rss><channel>
<item><title>Post 1</title><link>https://x.com/1</link></item>
<item><title>Post 2</title><link>https://x.com/2</link></item>
</channel></rss>"""
feed = BeautifulSoup(rss, "xml")          # needs lxml
for item in feed.find_all("item"):
    print(item.title.text, item.link.text)
```

### 🏷️ Q147 · Namespaced elements `dc|creator`
```python
xml = """<rss xmlns:dc="http://purl.org/dc/elements/1.1/">
<item><dc:creator>Alice</dc:creator></item></rss>"""
s = BeautifulSoup(xml, "xml")
ns = {"dc": "http://purl.org/dc/elements/1.1/"}
print(s.select_one("dc|creator", namespaces=ns).text)   # Alice
print(s.find("creator").text)                            # Alice (find ignores prefix)
```

### 🧬 Q148 · Extract JSON-LD structured data
```python
import json
for tag in soup.find_all("script", type="application/ld+json"):
    try:
        data = json.loads(tag.string or tag.get_text())
        print(data.get("@type"), data.get("name"))
    except json.JSONDecodeError:
        continue
```

### 🌐 Q149 · Open Graph meta tags → dict
```python
og = {m["property"]: m.get("content", "")
      for m in soup.find_all("meta", property=re.compile(r"^og:"))}
print(og)   # {'og:title': '...', 'og:image': '...'}
```

### 📧 Q150 · Extract emails with regex
```python
import re
text = soup.get_text(" ")
emails = set(re.findall(r"[\w.+-]+@[\w-]+\.[\w.-]+", text))
emails |= {a["href"][7:].split("?")[0] for a in soup.select('a[href^="mailto:"]')}
```

### 🔁 Q151 · Retries with exponential backoff
```python
import time, random, requests

def fetch(url, retries=5, base=1.0):
    for attempt in range(retries):
        try:
            r = requests.get(url, timeout=10)
            if r.status_code == 200:
                return r.content
            if r.status_code in (429, 500, 502, 503, 504):
                raise requests.HTTPError(r.status_code)
            r.raise_for_status()
        except (requests.RequestException):
            time.sleep(base * 2 ** attempt + random.random())   # 1s, 2s, 4s…
    raise RuntimeError(f"Failed after {retries} tries: {url}")
```
> [!TIP]
> Alternatively mount `urllib3.util.Retry` on a `requests.Session` with `HTTPAdapter`.

### 🤖 Q152 · Check `robots.txt`
```python
from urllib.robotparser import RobotFileParser
from urllib.parse import urljoin

rp = RobotFileParser(urljoin("https://example.com", "/robots.txt"))
rp.read()
print(rp.can_fetch("MyBot", "https://example.com/products"))   # True/False
```

### 🧵 Q153 · Concurrent scraping with `ThreadPoolExecutor`
```python
from concurrent.futures import ThreadPoolExecutor, as_completed

def scrape(url):
    r = requests.get(url, timeout=10)
    s = BeautifulSoup(r.content, "html.parser")
    return url, s.title.get_text(strip=True) if s.title else None

urls = [f"https://example.com/p/{i}" for i in range(1, 11)]
with ThreadPoolExecutor(max_workers=5) as pool:
    futures = [pool.submit(scrape, u) for u in urls]
    for f in as_completed(futures):
        try: print(f.result())
        except Exception as e: print("error:", e)
```

### ⚡ Q154 · Async scraping with `aiohttp`
```python
import asyncio, aiohttp
from bs4 import BeautifulSoup

async def fetch(session, url, sem):
    async with sem, session.get(url) as r:
        return BeautifulSoup(await r.read(), "html.parser").title.get_text(strip=True)

async def main(urls):
    sem = asyncio.Semaphore(10)                 # limit concurrency
    async with aiohttp.ClientSession() as s:
        return await asyncio.gather(*(fetch(s, u, sem) for u in urls), return_exceptions=True)

print(asyncio.run(main(["https://example.com"])))
```

### 🤖 Q155 · Selenium + BeautifulSoup (JS pages)
```python
from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By

opts = webdriver.ChromeOptions(); opts.add_argument("--headless=new")
driver = webdriver.Chrome(options=opts)
try:
    driver.get("https://example.com/js-page")
    WebDriverWait(driver, 10).until(EC.presence_of_element_located((By.CSS_SELECTOR, ".item")))
    soup = BeautifulSoup(driver.page_source, "html.parser")
    print([i.get_text(strip=True) for i in soup.select(".item")])
finally:
    driver.quit()
```

### 🔑 Q156 · Log in with a session, scrape a protected page
```python
s = requests.Session()
login_page = BeautifulSoup(s.get("https://site.com/login", timeout=10).content, "html.parser")
token = login_page.find("input", {"name": "csrf_token"})["value"]
s.post("https://site.com/login",
       data={"username": "me", "password": "secret", "csrf_token": token}, timeout=10)
page = s.get("https://site.com/dashboard", timeout=10)
print(BeautifulSoup(page.content, "html.parser").h1.text)
```
> [!WARNING]
> Only log in to accounts you own and where the Terms of Service allow automation. Never hard-code passwords — use environment variables.

### 📝 Q157 · Parse a form → payload (incl. hidden tokens)
```python
form_html = """<form action="/login" method="post">
<input type="hidden" name="token" value="abc123">
<input name="user"><input name="pwd" type="password">
<select name="lang"><option value="en" selected>EN</option></select></form>"""
form = BeautifulSoup(form_html, "html.parser").form
payload = {i["name"]: i.get("value", "") for i in form.find_all("input", attrs={"name": True})}
for sel in form.find_all("select"):
    opt = sel.find("option", selected=True) or sel.find("option")
    payload[sel["name"]] = opt["value"]
print(form["action"], payload)
# /login {'token': 'abc123', 'user': '', 'pwd': '', 'lang': 'en'}
```

### 🌲 Q158 · Recursive indented outline
```python
def outline(tag, depth=0):
    print("  " * depth + tag.name)
    for child in tag.find_all(True, recursive=False):
        outline(child, depth + 1)

outline(soup.html)
# html
#   head
#     title
#   body
#     div ...
```

### 🕷️ Q159 · Simple same-domain crawler
```python
from collections import deque
from urllib.parse import urljoin, urlparse, urldefrag

def crawl(start, max_pages=50):
    domain, seen, q = urlparse(start).netloc, {start}, deque([start])
    while q and len(seen) <= max_pages:
        url = q.popleft()
        try:
            soup = BeautifulSoup(requests.get(url, timeout=10).content, "html.parser")
        except requests.RequestException:
            continue
        print("crawled:", url)
        for a in soup.find_all("a", href=True):
            link = urldefrag(urljoin(url, a["href"]))[0]
            if urlparse(link).netloc == domain and link not in seen:
                seen.add(link); q.append(link)
    return seen
```

### 🧼 Q160 · Remove all attributes from all tags
```python
for tag in soup.find_all(True):
    tag.attrs = {}
print(soup.li)   # <li><a>Python Book</a> <span>10</span></li>
```

### 🛡️ Q161 · Sanitize: whitelist tags, unwrap the rest
```python
ALLOWED = {"p", "b", "i", "a", "ul", "li", "br"}

def sanitize(html):
    s = BeautifulSoup(html, "html.parser")
    for t in s(["script", "style"]):
        t.decompose()                        # drop dangerous content entirely
    for t in s.find_all(True):
        if t.name not in ALLOWED:
            t.unwrap()                       # keep text, drop tag
        else:
            t.attrs = {k: v for k, v in t.attrs.items()
                       if t.name == "a" and k == "href" and not v.lower().startswith("javascript:")}
    return str(s)

print(sanitize('<div onclick="x()"><p>Hi <script>bad()</script><a href="javascript:x">y</a></p></div>'))
```
> [!WARNING]
> For real security (XSS) use a dedicated library like **nh3** or **bleach**.

### 🖍️ Q162 · Highlight a word with `<mark>`
```python
from bs4 import NavigableString

def highlight(soup, word):
    pat = re.compile(f"({re.escape(word)})", re.I)
    for node in soup.find_all(string=pat):
        if node.parent.name in ("script", "style", "mark"):
            continue
        parts = []
        for i, piece in enumerate(pat.split(str(node))):
            if i % 2:                          # odd index = the match
                m = soup.new_tag("mark"); m.string = piece; parts.append(m)
            elif piece:
                parts.append(NavigableString(piece))
        node.replace_with(*parts)

highlight(soup, "book")
print(soup.li.a)   # <a href="/p/python">Python <mark>Book</mark></a>
```

### 🩹 Q163 · Repair broken HTML & prettify
```python
broken = "<p>One<p>Two<b>bold"
print(BeautifulSoup(broken, "lxml").prettify())
# <html>
#  <body>
#   <p>
#    One
#   </p>
#   <p>
#    Two
#    <b>
#     bold
#    </b>
#   </p>
#  </body>
# </html>
```

### 🔬 Q164 · Compare the three parsers on broken HTML
```python
broken = "<a></p>"
for parser in ("html.parser", "lxml", "html5lib"):
    print(f"{parser:12}", BeautifulSoup(broken, parser))
# html.parser  <a></a>
# lxml         <html><body><a></a></body></html>
# html5lib     <html><head></head><body><a><p></p></a></body></html>
```

### 💾 Q165 · Cache pages on disk
```python
import hashlib, pathlib, requests

CACHE = pathlib.Path("cache"); CACHE.mkdir(exist_ok=True)

def get_html(url):
    f = CACHE / (hashlib.md5(url.encode()).hexdigest() + ".html")
    if f.exists():
        return f.read_bytes()                    # ✅ cache hit
    content = requests.get(url, timeout=10).content
    f.write_bytes(content)                       # 💾 save
    return content
```
> [!TIP]
> Library option: `requests-cache` (`CachedSession`) does this with expiry.

<div align="right"><a href="#top">⬆️ back to top</a></div>

---

<a id="part4"></a>

# 🔵 PART 4 — TECHNICAL INTERVIEW QUESTIONS

### 🕵️ Q166 · Scraper returns `None` for an element visible in the browser — why?
| # | Likely reason | Fix |
|:-:|---------------|-----|
| 1 | 🧩 **Rendered by JavaScript** — not in raw HTML | Use the XHR API, Selenium, Playwright |
| 2 | 🚧 **Blocked / different HTML** for bots (403, captcha page) | Check `r.status_code`, headers; print `r.text[:500]` |
| 3 | 🌳 **Parser difference** altered the tree | Try `lxml` / `html5lib` |
| 4 | 🎭 Wrong selector (class order, dynamic class names) | Use `select()`, partial matches |
| 5 | 🖼️ Content inside an **`<iframe>`** | Fetch the iframe `src` separately |
| 6 | ⏱️ Lazy-loaded after scroll/click | Wait / simulate scrolling |
| 7 | 🔤 Typo, case, or whitespace in text match | Use regex / `get_text(strip=True)` |

✅ First debug step: `print(soup.prettify()[:2000])` and *View Source* (not Inspect Element).

### ⚖️ Q167 · How do you choose between `find_all()` and `select()`?
- **`select()`** → structure-based queries (`div.card > a[href^="/p/"]`), pseudo-classes, you know CSS.
- **`find_all()`** → need **Python logic** (functions, regex on text, `string=`), or simple name lookups.
- Same speed class — pick the one that is **more readable**.

### 📡 Q168 · Site loads data via an XHR/JSON API — how to scrape?
1. Open DevTools ➜ **Network ➜ Fetch/XHR**, reload, find the JSON request.
2. Copy URL, params, headers (`Referer`, `Authorization`, cookies).
3. Call it directly with `requests` and read `.json()` — **no bs4 needed**.
```python
r = requests.get("https://site.com/api/products?page=1",
                 headers={"User-Agent": "MyBot/1.0", "Accept": "application/json"}, timeout=10)
for p in r.json()["items"]:
    print(p["name"], p["price"])
```
✅ Faster, cleaner, more stable than HTML parsing.

### 🛡️ Q169 · Make a scraper resilient to HTML changes
- ✅ Prefer **stable hooks**: `id`, `data-*`, `itemprop`, JSON-LD, ARIA labels — avoid auto-generated class names (`css-1x2y3`).
- ✅ Use **fallback selectors** (`try A, else B`).
- ✅ Don't depend on absolute paths (`div > div > div:nth-child(3)`).
- ✅ **Validate output** (required fields, types) and alert when empty.
- ✅ Keep selectors in **one config place**; add tests with saved HTML fixtures.
```python
def first(soup, *selectors):
    for sel in selectors:
        el = soup.select_one(sel)
        if el: return el
price = first(soup, "[itemprop=price]", ".price", "span.cost")
```

### ⏱️ Q170 · Time complexity of `find()` / `find_all()`
Both traverse the tree in document order: **O(n)** in the number of nodes below the starting tag. `find()` can **stop early** (best case O(1)), `find_all()` always scans everything (unless `limit=`). Parsing itself is also O(size of document).

### 🚀 Q171 · Speed up parsing of large documents
- ⚡ Use **`lxml`** (C-based) instead of `html.parser`/`html5lib`
- 🎯 `SoupStrainer` to build only needed tags
- 🔁 Parse **once**, reuse; avoid re-parsing inside loops
- 🧮 Use `select_one`/`limit` to stop early
- 🧵 **Multiprocessing** for CPU-bound parsing of many pages
- 📥 Pass `bytes` and `lxml.etree.iterparse` for giant XML

### 🔤 Q172 · Handle encoding problems (mojibake)
```python
r = requests.get(url, timeout=10)
soup = BeautifulSoup(r.content, "html.parser")              # ✅ bytes, let bs4 detect

# force one:
soup = BeautifulSoup(r.content, "html.parser", from_encoding="utf-8")
# or let requests guess from content:
r.encoding = r.apparent_encoding
```
For already-garbled text (`Ã©`), `ftfy.fix_text()` repairs it. ✅ Always **write files with `encoding="utf-8"`**.

### 🚷 Q173 · Avoid getting blocked
- 🐢 **Rate-limit** + random delays (`time.sleep(random.uniform(1,3))`)
- 🪪 Honest **User-Agent**, normal headers; reuse **Session/cookies**
- 🤖 Respect **robots.txt**; scrape off-peak
- 💾 **Cache** pages; don't re-fetch
- 🔁 Backoff on `429/503`; honour `Retry-After`
- 🌍 Rotating proxies only where permitted
- ✅ Best of all: use the **official API** or ask for permission

### 🧩 Q174 · How to handle CAPTCHAs
A CAPTCHA is a signal that the site doesn't want automated access.
1. ✅ Look for an **official API / data export / partnership**.
2. ✅ **Slow down** and reduce request volume so it isn't triggered.
3. ✅ Reuse a valid **human-authenticated session** at low volume.
4. ⚠️ Human-in-the-loop for occasional solves.
5. ❌ Avoid bypassing CAPTCHAs with solving services unless ToS/law clearly allow it.

### 🧪 Q175 · Unit test a scraping function
Test the **parser**, not the network: store sample HTML as a fixture and keep `parse(html)` pure.
```python
# scraper.py
def parse_products(html):
    soup = BeautifulSoup(html, "html.parser")
    return [{"name": li.a.text, "price": int(li.select_one(".price").text)}
            for li in soup.select("li.item")]

# test_scraper.py
def test_parse_products():
    html = '<ul><li class="item"><a>Pen</a><span class="price">5</span></li></ul>'
    assert parse_products(html) == [{"name": "Pen", "price": 5}]
```
Mock HTTP with `responses` / `requests-mock`; use `pytest.mark.parametrize` for edge cases (missing price, empty page).

### 🐞 Q176 · Explain & fix `'NoneType' object has no attribute 'text'`
**Cause:** `find()`/`select_one()` found nothing and returned `None`, then `.text` was called on it.
```python
# ❌ crashes
title = soup.find("h1").text

# ✅ fixes
h1 = soup.find("h1")
title = h1.text.strip() if h1 else None

# ✅ helper
def text_of(soup, css, default=""):
    el = soup.select_one(css)
    return el.get_text(strip=True) if el else default
```
Then investigate *why* it's missing (JS-rendered, blocked, wrong selector, parser).

### 🔀 Q177 · Why `find("div", class_="a b")` misses `<div class="b a">`?
With multiple classes, bs4 matches the **exact attribute string** `"a b"` literally, so the order matters. Fix with CSS selectors or two filters:
```python
soup.select("div.a.b")                                           # ✅ any order
soup.find("div", class_=lambda c: c and {"a","b"} <= set(c.split()))   # ✅ function
```

### 🪆 Q178 · Extract from deeply nested, similar-looking tags
- Anchor on a **unique container** (id / data attr / heading text), then search *relative to it*.
- Use **`recursive=False`**, child combinator `>` and `:nth-of-type`.
- Use **label → value** pattern: find the label then `find_next_sibling()`.
```python
label = soup.find("th", string="Price")
price = label.find_next_sibling("td").get_text(strip=True)

card = soup.select_one('div.product[data-id="42"]')
name = card.select_one("h2 > a").text
```

### 🔗 Q179 · Relative vs absolute URLs, `<base>`, protocol-relative
```python
from urllib.parse import urljoin
base_tag = soup.find("base", href=True)
base = urljoin(page_url, base_tag["href"]) if base_tag else page_url   # <base> overrides page URL

for a in soup.find_all("a", href=True):
    full = urljoin(base, a["href"])
# urljoin handles:  "/x" (root-relative), "x" (relative), "../x", "//cdn.com/x" (protocol-relative → uses base scheme)
```
Skip `mailto:`, `javascript:`, `#anchor`. Strip fragments with `urldefrag()`.

### ♻️ Q180 · De-duplicate scraped data
- 🔑 Pick a **natural key** (URL, SKU, ID) — normalise first (lowercase, strip, remove tracking params).
- 🧮 In memory: `set()` or `dict` keyed by ID. Pandas: `df.drop_duplicates(subset=["sku"])`.
- 🗄️ In a DB: **`UNIQUE` constraint** + `INSERT … ON CONFLICT DO NOTHING / UPDATE`.
- 🧬 For content duplicates: hash (`hashlib.sha256(text)`).
```python
seen, unique = set(), []
for r in rows:
    if r["id"] not in seen:
        seen.add(r["id"]); unique.append(r)
```

### 🗄️ Q181 · Where to store scraped data & why

| Storage | Best for |
|---------|----------|
| 📄 CSV / JSON / JSONL | Small, one-off, easy sharing |
| 🪶 **SQLite** | Single-machine projects, SQL queries, dedupe |
| 🐘 **PostgreSQL/MySQL** | Structured, large, multi-user |
| 🍃 MongoDB | Variable/nested schema |
| ☁️ S3 / GCS (+Parquet) | Raw HTML archives, big data pipelines |
| 🔎 Elasticsearch | Full-text search |

✅ Also store **raw HTML + timestamp** so you can re-parse without re-downloading.

### 🛑 Q182 · When should you NOT use BeautifulSoup?
- ❌ Page is **JS-rendered** and no API → use Playwright/Selenium (bs4 only as a helper)
- ❌ **Large-scale crawling** (millions of pages) → **Scrapy** (async, pipelines, retries)
- ❌ An **official API** or downloadable dataset exists
- ❌ Need **XPath** or maximum speed → **lxml**
- ❌ Need to **validate/execute** pages like a browser → headless browser

### 🆚 Q183 · BeautifulSoup vs lxml (XPath)

| | 🍲 BeautifulSoup | ⚡ lxml |
|--|------------------|--------|
| Ease | **Very friendly** | Steeper |
| Speed | Slower (Python wrapper) | **Much faster (C)** |
| Query | find/CSS | **XPath + CSS** |
| Bad HTML | Very tolerant (multiple parsers) | Good |
| Modifying | Easy API | Possible |
```python
# bs4
soup.select("li.item a")
# lxml XPath
from lxml import html as lh
lh.fromstring(html).xpath('//li[@class="item"]/a/text()')
```
💡 You can combine: `BeautifulSoup(html, "lxml")`.

### 📈 Q184 · Log & monitor a production scraper
- 🪵 Use `logging` (levels, rotating file, JSON logs): URL, status, duration, items found.
- 📊 Metrics: **pages/min, success rate, items per page, error counts, latency** (Prometheus/Grafana, Datadog).
- 🚨 **Alerts** when: zero items, HTTP 403/429 spike, schema validation failures.
- 💾 Save failing HTML (for debugging) and a heartbeat/last-success timestamp.
- 🔁 Retry queue / dead-letter queue for failed URLs.
```python
import logging
logging.basicConfig(level=logging.INFO, format="%(asctime)s %(levelname)s %(message)s")
log = logging.getLogger("scraper")
log.info("fetched %s status=%s items=%d", url, r.status_code, len(items))
```

### ♾️ Q185 · Scrape a page with infinite scroll
**Option A (best): find the XHR/JSON call** the scroll triggers and page through it with `?page=`/`cursor=`.

**Option B: Selenium scroll loop**
```python
import time
last = driver.execute_script("return document.body.scrollHeight")
while True:
    driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")
    time.sleep(2)
    new = driver.execute_script("return document.body.scrollHeight")
    if new == last:
        break
    last = new
soup = BeautifulSoup(driver.page_source, "html.parser")
```

<div align="right"><a href="#top">⬆️ back to top</a></div>

---

<a id="part5"></a>

# 🟣 PART 5 — ONE-TO-ONE INTERVIEW QUESTIONS

> [!NOTE]
> These are **sample answers** — adapt them with your own real projects and experience.

### 🎤 Q186 · Tell me about a project where you used BeautifulSoup
*"I built a **price-tracker**: it fetched product pages with `requests`, parsed name/price/stock with BeautifulSoup + CSS selectors, stored results in SQLite and emailed me when a price dropped. I added retries, a rate limit, logging, and unit tests using saved HTML fixtures. It ran daily on a scheduler and tracked ~500 products."*

**STAR tip:** Situation → Task → Action (tools, design) → Result (numbers).

### 🧗 Q187 · Hardest scraping problem you solved
*"A page showed prices only after JavaScript ran, so bs4 returned empty tags. I checked the Network tab, found the JSON API behind the page, called it with the right headers/cookies and parsed the JSON directly. It was 10× faster and far more stable than browser automation."*

### 🔧 Q188 · How do you debug a selector that doesn't work?
1. `print(r.status_code)` and `print(soup.prettify()[:1000])` — is the content actually there?
2. Compare **View Source** vs rendered DOM (JS?).
3. Test the selector in **DevTools console**: `document.querySelectorAll("…")`.
4. Simplify step by step: `soup.select("div")` → `div.card` → `div.card h2`.
5. Try other parsers; use `diagnose()`; check class order, whitespace, typos.

### 🧹 Q189 · Keep scraper code clean & maintainable
- 📦 Separate **fetch** / **parse** / **store** functions
- ⚙️ Selectors + config in one place; no magic strings
- 🧪 Tests with HTML fixtures; type hints; docstrings
- 🪵 Logging instead of `print`; small reusable helpers (`safe_text`)
- 🧱 `requests.Session`, retries, constants for headers & timeouts

### 💥 Q190 · Handle errors you can't predict
- Wrap each item/page in `try/except Exception`, **log with the URL + traceback**, and continue.
- ✅ Timeouts, retries with backoff, **dead-letter list** of failed URLs.
- ✅ Validate output; alert on anomalies (zero items).
- ✅ Save the raw HTML of failures to reproduce offline.

### 🤔 Q191 · Why BeautifulSoup instead of Scrapy?
*"For a small/medium job with a few pages I wanted fast development, low setup and full control — BeautifulSoup + requests gets there in minutes. For large crawls needing concurrency, pipelines and auto-throttling, I'd choose Scrapy."*

### ⚖️ Q192 · Is web scraping legal? How do you stay compliant?
It **depends on jurisdiction, the data, and how you scrape**. Public facts are generally lower risk, but ToS violations, personal data (GDPR/DPDP), copyrighted content, bypassing access controls, or harming a server can create liability. I:
- ✅ check **robots.txt + ToS**, prefer **APIs**
- ✅ rate-limit, identify my bot, avoid personal data
- ✅ get legal advice for commercial use
*(General information, not legal advice.)*

### 📚 Q193 · How do you stay updated?
Official docs & changelogs (bs4, Soup Sieve), PyPI release notes, GitHub issues, Real Python / PyCon talks, Stack Overflow, newsletters, and **building small projects** to try new tools (Playwright, httpx, Scrapy).

### 👵 Q194 · Explain BeautifulSoup to a non-technical person
*"A web page is like a messy book with no index. BeautifulSoup is a **smart highlighter + index**: it reads the page, understands its structure — headings, lists, links — and lets a program say 'give me every product name and price' in one line."* 🍲📖

### 🚨 Q195 · Your scraper suddenly stopped working — what do you do?
1. 🔍 **Check logs** — HTTP status? exceptions? zero results?
2. 🌐 Open the page manually — layout changed? login/captcha? blocked IP?
3. 💾 Compare with saved old HTML to find the **changed selector**.
4. 🔧 Fix selector / headers / rate; add fallback selectors.
5. 🧪 Add a regression test + alert so it's caught early next time.

### ✅ Q196 · Make sure scraped data is accurate
- Schema validation (`pydantic`/`cerberus`): types, ranges, required fields
- Spot-check random samples against the live site
- Compare counts (page says "120 results" vs scraped)
- Normalise (strip, currency, dates); detect duplicates & outliers
- Monitor distribution changes over time

### 💪 Q197 · Strengths & weaknesses of BeautifulSoup

| 👍 Strengths | 👎 Weaknesses |
|-------------|--------------|
| Easy, readable API | Slower than raw lxml |
| Handles broken HTML | No JavaScript execution |
| Great docs/community | Doesn't fetch pages |
| Multiple parsers, CSS selectors | No built-in concurrency/crawling |
| Great for prototyping | Memory-heavy on huge files |

### 📈 Q198 · Scale from 100 to 1 million pages
- 🏗️ Move to **Scrapy** or an async design (`aiohttp`/`httpx`)
- 📬 **Queue** (Redis/RabbitMQ/Kafka) + many **workers** (Docker/K8s)
- ⚡ `lxml` parser + `SoupStrainer`; `ProcessPoolExecutor` for CPU parsing
- 🚦 Per-domain **rate limiting**, retries, proxies (where permitted), caching, **incremental crawling**
- 🗄️ Store raw HTML in S3, structured data in Postgres/warehouse
- 📊 Monitoring + alerting + dedupe by URL hash

### 📰 Q199 · Live coding: headlines and links from a news page
```python
import requests
from bs4 import BeautifulSoup
from urllib.parse import urljoin

def get_headlines(url):
    r = requests.get(url, headers={"User-Agent": "Mozilla/5.0"}, timeout=10)
    r.raise_for_status()
    soup = BeautifulSoup(r.content, "html.parser")

    headlines = []
    for h in soup.select("h1 a, h2 a, h3 a"):          # headings that contain links
        title = h.get_text(strip=True)
        href = h.get("href")
        if title and href:
            headlines.append({"title": title, "link": urljoin(url, href)})
    return headlines

for item in get_headlines("https://example-news.com"):
    print(f"📰 {item['title']}\n   🔗 {item['link']}")
```
**Talk through it:** fetch → check status → parse bytes → CSS select → skip empty → absolute URLs → return structured data. Mention you'd adapt selectors to the real site, add retries, and respect robots.txt.

### 🔭 Q200 · Where do you see yourself using these skills next?
*"Data pipelines and analytics — collecting public data (prices, jobs, research) to feed dashboards or ML models; combining scraping with **pandas**, databases and scheduling; and expanding into **Playwright/Scrapy** and API integration for larger, production-grade systems — always with ethical, compliant practices."* 🚀

<div align="right"><a href="#top">⬆️ back to top</a></div>

---

<a id="cheatsheet"></a>

# 📌 QUICK CHEAT SHEET

| 🎯 Task | 🧪 Code |
|--------|--------|
| Create soup | `BeautifulSoup(html, "html.parser")` |
| First / all | `soup.find("a")` · `soup.find_all("a")` |
| CSS | `soup.select("div.card > a")` · `select_one()` |
| By class / id | `find_all(class_="x")` · `find(id="y")` |
| Attribute | `tag["href"]` · `tag.get("href")` |
| Text | `tag.get_text(strip=True)` |
| Parent / siblings | `tag.parent` · `find_next_sibling()` |
| Remove | `tag.decompose()` · `tag.extract()` |
| Modify | `tag["class"].append("x")` · `tag.string = "new"` |
| New tag | `soup.new_tag("li")` |
| Absolute URL | `urljoin(base, href)` |
| Pretty print | `soup.prettify()` |

### 🏆 Golden Rules
1. ✅ Always specify the **parser** and use **`timeout=`**.
2. ✅ Check for `None` before `.text` / `["attr"]`.
3. ✅ Pass **`response.content`** (bytes) to bs4.
4. ✅ Prefer **stable selectors** (`id`, `data-*`), and **APIs** when they exist.
5. ✅ Be polite: **rate-limit**, respect **robots.txt** & ToS.

<div align="center">

### 🎉 Happy Scraping! 🍲🕸️

*Made with ❤️ for BeautifulSoup learners*

</div>
