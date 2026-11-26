# BeautifulSoup (bs4): 200 Questions (Questions Only)

**Basic (1-60) · Intermediate (61-115) · Hard (116-165) · Technical Interview (166-185) · One-to-One Interview (186-200)**

---

# PART 1: BASIC LEVEL

## A. Basic Theory (1-30)

1. What is BeautifulSoup?
2. Who created BeautifulSoup, and what is the package name to install and import?
3. What is web scraping?
4. Does BeautifulSoup fetch web pages? Which libraries are used to download HTML?
5. What is a parser in BeautifulSoup?
6. Name the common parsers supported by BeautifulSoup.
7. What is the difference between `html.parser`, `lxml` and `html5lib`?
8. What happens if you do not specify a parser?
9. What is the parse tree?
10. Name the four main object types in BeautifulSoup.
11. What is a `Tag` object?
12. What is a `NavigableString`?
13. What is the `BeautifulSoup` object?
14. What is a `Comment` object?
15. How do you access and change a tag's name?
16. How do you access the attributes of a tag?
17. Why is `get()` safer than `[]` for reading attributes?
18. What is a multi-valued attribute? Give examples.
19. What is the difference between `find()` and `find_all()`?
20. What does `.string` return, and when does it return `None`?
21. What is the difference between `.string`, `.text` and `get_text()`?
22. What does `prettify()` do?
23. What is `.contents`?
24. What is `.children`, and how does it differ from `.contents`?
25. What is `.descendants`?
26. What are `.parent` and `.parents`?
27. What are siblings? Explain `.next_sibling` and `.previous_sibling`.
28. What does `soup.title` (dot notation) do?
29. What is a `ResultSet`?
30. What is the difference between BeautifulSoup and Scrapy?

## B. Basic Practical (31-60)

31. Write the commands to install BeautifulSoup, lxml and requests, and verify the installation.
32. Create a soup object from an HTML string and print the title tag and its text.
33. Write a program that fetches a web page with `requests` and prints its `<h1>` text.
34. Write a program to print all links (text and href) from a page.
35. Get all `href` values as a Python list, skipping anchors without `href`.
36. Find an element by its `id`.
37. Find all `li` tags that have the class `item`.
38. Find a `div` by multiple classes (exact class string).
39. Find tags using the `attrs` argument (for example, `data-id="2"`).
40. Print all the text of a page with a newline separator and whitespace stripped.
41. Count the number of `li` tags in a document.
42. Extract all prices (`span.price`) as integers.
43. Limit `find_all()` results to the first two matches.
44. Print the names of the children of a `ul`, skipping whitespace strings.
45. Print the parent tag name of the first `a` tag.
46. Get the next sibling `li` tag, skipping whitespace.
47. Check whether a tag has a given attribute.
48. Modify the `href` attribute of a link.
49. Change the text of an `h1` tag.
50. Delete an attribute from a tag.
51. Remove a tag completely from the tree.
52. Extract all HTML comments from a document.
53. Write the modified HTML to a file with UTF-8 encoding.
54. Parse a local HTML file.
55. Print all unique tag names present in a document.
56. Find an `a` tag by its exact text.
57. Use a CSS selector to get the text of an `h1` inside `#main`.
58. Select all list items with the class `sale` using `select()`.
59. Handle a missing tag safely without raising an `AttributeError`.
60. Print the attributes dictionary of a tag and explain the output.

---

# PART 2: INTERMEDIATE LEVEL

## C. Intermediate Theory (61-85)

61. What filter types can `find_all()` accept?
62. Why is `class_` used instead of `class`?
63. How does class matching work with multi-valued classes?
64. What are `find_next()`, `find_previous()` and `find_all_next()`?
65. What is the difference between `find_parent()` and `find_parents()`?
66. What is the difference between `.next_sibling` and `.next_element`?
67. What does `recursive=False` do?
68. What is `select()`, and which library powers it?
69. When should you use `find_all()` and when `select()`?
70. What does `select_one()` return?
71. List the CSS attribute selectors supported by BeautifulSoup.
72. What are `.stripped_strings`?
73. What is the difference between `extract()`, `decompose()` and `clear()`?
74. What does `replace_with()` do?
75. What do `wrap()` and `unwrap()` do?
76. How do you create a new tag?
77. What is the difference between `append()`, `insert()`, `insert_before()` and `insert_after()`?
78. What is `SoupStrainer`?
79. Is `parse_only` compatible with all parsers?
80. What is a formatter in BeautifulSoup output?
81. How does BeautifulSoup handle character encodings?
82. What is `UnicodeDammit`?
83. Why would you pass `response.content` instead of `response.text`?
84. What is the difference between `decode()` and `encode()` on a tag?
85. What does `soup.smooth()` do?

## D. Intermediate Practical (86-115)

86. Find all heading tags (h1 to h6) using a regular expression.
87. Find all links whose `href` starts with `/p/`.
88. Find multiple tag names (`h1` and `title`) in one call.
89. Write a function filter that finds tags with a `data-id` attribute and no `id`.
90. Find all tags that have any `data-id` attribute.
91. Build a dictionary of product names and integer prices from the list items.
92. Convert the list items into a list of dictionaries (id, name, url, price).
93. Save the scraped rows to a CSV file.
94. Print the scraped rows as pretty JSON.
95. Convert relative URLs to absolute URLs.
96. Parse an HTML table into a list of rows.
97. Convert a scraped table into a pandas DataFrame.
98. Extract all image sources from a page.
99. Download all images from a page into a folder.
100. Remove all `script` and `style` tags and get clean text.
101. Add a new list item to a `ul`.
102. Insert a new item at position 0 of a list.
103. Wrap an `h1` inside a new `header` tag.
104. Unwrap all links but keep their text.
105. Replace an `h1` tag with an `h2` tag.
106. Add a class to a tag that already has classes.
107. Select only the direct children `li` of a `ul` using CSS.
108. Select the second `li` using a CSS pseudo-class.
109. Select all links ending in `.pdf`.
110. Parse only `a` tags using `SoupStrainer`.
111. Write a pagination loop that scrapes pages until no items are found.
112. Follow the "Next" link until the last page.
113. Add a custom User-Agent header to a request.
114. Use a `requests.Session` for multiple requests.
115. Print the ancestor path of a tag (for example, `html > body > div > ul > li`).

---

# PART 3: HARD LEVEL

## E. Hard Theory (116-140)

116. Explain how `html.parser` handles malformed HTML compared with `html5lib`.
117. Why can the same HTML produce different trees with different parsers?
118. What is Soup Sieve, and why does it matter?
119. What is `:-soup-contains()`?
120. What is the `soup.css` property?
121. How do XML parsing and namespaces work in BeautifulSoup?
122. What are `CData`, `Doctype`, `ProcessingInstruction` and `Declaration`?
123. How does BeautifulSoup decide what counts as text in `get_text()`?
124. Why might `get_text()` on a document skip the content of `<script>` tags?
125. What is `multi_valued_attributes`?
126. How does BeautifulSoup treat duplicate attributes (`on_duplicate_attribute`)?
127. Why can `find_all("a", string="Book")` fail on tags with multiple children?
128. How does BeautifulSoup behave in terms of memory with large files, and how can you reduce usage?
129. Is BeautifulSoup thread-safe? When would you use multiprocessing?
130. Can BeautifulSoup run JavaScript? How do you scrape JS-rendered pages?
131. Explain the concept of document order.
132. What does `soup("a")` do (the `Tag.__call__` shortcut)?
133. What is `copy.copy(tag)` used for?
134. Is a soup object picklable? Is it a good idea?
135. How can you detect which parser and encoding were used?
136. What is `bs4.diagnose.diagnose()`?
137. What exceptions are commonly encountered when using BeautifulSoup?
138. What causes `FeatureNotFound`, and how do you fix it?
139. What are the legal and ethical aspects of web scraping?
140. In what order do `find_all()` and `select()` return results?

## F. Hard Practical (141-165)

141. Write a function that returns only the direct text of a tag (excluding nested tags' text).
142. Find the `li` containing the text "Book" using Soup Sieve.
143. Find all items whose price is greater than 20.
144. Use `:has()` to select `li` elements that contain an `a` with an `href`.
145. Use `:not()` to select items that do not have the class `sale`.
146. Parse an RSS/XML feed and print each item's title and link.
147. Select namespaced elements (`dc|creator`) with the `namespaces` argument.
148. Extract JSON-LD structured data from `script` tags.
149. Extract Open Graph meta tags into a dictionary.
150. Extract all email addresses from a page using regex.
151. Write a robust request function with retries and exponential backoff.
152. Check `robots.txt` before scraping a URL.
153. Scrape many URLs concurrently using `ThreadPoolExecutor`.
154. Scrape many URLs asynchronously using `aiohttp` and BeautifulSoup.
155. Use Selenium with BeautifulSoup to scrape a JavaScript-rendered page.
156. Log in to a website using a session, then scrape a protected page.
157. Parse a form and build a payload from its input fields, including hidden tokens.
158. Walk the entire tree recursively and print an indented outline of tag names.
159. Build a simple crawler that follows same-domain links only.
160. Remove all attributes from all tags.
161. Sanitize HTML by keeping only a whitelist of tags and unwrapping the rest.
162. Highlight a word in the page by wrapping every match in `<mark>`.
163. Repair broken HTML (`<p>One<p>Two<b>bold`) and print it prettified.
164. Compare the output of `html.parser`, `lxml` and `html5lib` for the same broken HTML.
165. Cache downloaded pages on disk so they are not downloaded again.

---

# PART 4: TECHNICAL INTERVIEW QUESTIONS (166-185)

166. Your scraper returns `None` for an element you can see in the browser. What could be the reasons?
167. How do you choose between `find_all()` and `select()`?
168. How would you scrape a site that loads its data through an XHR/JSON API?
169. How do you make a scraper resilient to changes in the HTML structure?
170. What is the time complexity of `find()` and `find_all()`?
171. How do you speed up parsing of large documents?
172. How do you handle character encoding problems (mojibake)?
173. How do you avoid getting blocked while scraping?
174. How would you handle CAPTCHAs?
175. How do you unit test a scraping function?
176. Explain and fix the error `'NoneType' object has no attribute 'text'`.
177. Why does `find("div", class_="a b")` miss `<div class="b a">`, and how do you fix it?
178. How would you reliably extract data from deeply nested, similar-looking tags?
179. How do you deal with relative versus absolute URLs, including `<base>` tags and protocol-relative links?
180. How do you de-duplicate scraped data?
181. Where would you store scraped data, and why?
182. When should you NOT use BeautifulSoup?
183. Compare BeautifulSoup with lxml (XPath).
184. How do you log and monitor a production scraper?
185. How do you scrape a page with infinite scroll?

---

# PART 5: ONE-TO-ONE INTERVIEW QUESTIONS (186-200)

186. Tell me about a project where you used BeautifulSoup.
187. What was the hardest scraping problem you solved, and how?
188. How do you debug a selector that does not work?
189. How do you keep your scraper code clean and maintainable?
190. How do you handle errors you cannot predict?
191. Why did you choose BeautifulSoup instead of Scrapy?
192. Is web scraping legal? How do you stay compliant?
193. How do you stay updated and learn new tools?
194. Explain BeautifulSoup to a non-technical person.
195. What would you do if your scraper suddenly stopped working?
196. How do you make sure the data you scraped is accurate?
197. What are the strengths and weaknesses of BeautifulSoup?
198. How would you scale a scraper from 100 pages to 1 million pages?
199. Write a program live: extract all headlines and their links from a news page.
200. Where do you see yourself using these skills next?
