/*
=====================================================================
                 REGULAR EXPRESSION (REGEX) IN JAVASCRIPT
=====================================================================

1. WHAT IS REGEX?
---------------------------------------------------------------------

Regex = Regular Expression

A Regular Expression is a pattern used to:

✔ Search text
✔ Check whether a pattern exists
✔ Validate input
✔ Extract data
✔ Replace text
✔ Find specific characters
✔ Check email, phone, password, etc.

Simple Meaning:

Regex = "A rule/pattern for finding text"

Example:

String:
"Hello JavaScript"

Regex:
 /JavaScript/

Meaning:
Find "JavaScript" inside the string.

=====================================================================
2. HOW TO CREATE REGEX
=====================================================================

Syntax:

/pattern/flags

Example:
*/

let regex1 = /JavaScript/;

/*
JavaScript
   ↑
Pattern

Example with flag:
*/

let regex2 = /javascript/i;

/*
i = case insensitive

Therefore:

JavaScript
javascript
JAVASCRIPT
JaVaScRiPt

All can match.

=====================================================================
3. str.match() METHOD
=====================================================================

Syntax:

string.match(regex)

Example:
*/

let str = "I am learning JavaScript";

let result = str.match(/JavaScript/);

console.log(result);

/*
If match is found:

Returns an array containing the match.

If no match:

Returns null.

Example:
*/

console.log(str.match(/Python/));

/*
Output:

null
*/

/*
=====================================================================
4. SIMPLE PATTERN MATCHING
=====================================================================
*/

let message = "Hello JavaScript";

console.log(message.match(/Hello/));

console.log(message.match(/JavaScript/));

console.log(message.match(/World/));

/*
Hello       -> Match
JavaScript  -> Match
World       -> null
*/

/*
=====================================================================
5. CASE INSENSITIVE - i
=====================================================================

i means:

Ignore uppercase/lowercase difference.
*/

let language = "JavaScript";

console.log(language.match(/javascript/i));

/*
Without i:

/javascript/

does NOT match:

JavaScript

With i:

/javascript/i

matches:

JavaScript
javascript
JAVASCRIPT
*/

/*
=====================================================================
6. GLOBAL FLAG - g
=====================================================================

g = Global

Find ALL matches instead of only first match.
*/

let text = "Java Java Java";

console.log(text.match(/Java/));

console.log(text.match(/Java/g));

/*
Without g:

First match

With g:

["Java", "Java", "Java"]
*/

/*
=====================================================================
7. i + g TOGETHER
=====================================================================
*/

let text2 = "Java JAVA java JaVa";

console.log(text2.match(/java/gi));

/*
Output:

[
  "Java",
  "JAVA",
  "java",
  "JaVa"
]
*/

/*
=====================================================================
8. DOT (.)
=====================================================================

. means:

Any single character except normally a line terminator.
*/

console.log("cat".match(/c.t/));

console.log("cot".match(/c.t/));

console.log("cut".match(/c.t/));

/*
All match.

c.t

c
↓
any character
↓
t

cat
cot
cut
*/

/*
=====================================================================
9. CHARACTER SET [ ]
=====================================================================

[] means:

Match ONE character from the specified set.
*/

console.log("cat".match(/[abc]/));

/*
Matches:

a

Because a is present.

Example:
*/

console.log("dog".match(/[abc]/));

/*
No match.
*/

/*
=====================================================================
10. [a-z]
=====================================================================

Range of lowercase letters.
*/

console.log("Hello".match(/[a-z]/));

/*
Matches lowercase characters.
*/

/*
=====================================================================
11. [A-Z]
=====================================================================

Uppercase letters.
*/

console.log("Hello".match(/[A-Z]/));

/*
Matches H.
*/

/*
=====================================================================
12. [0-9]
=====================================================================

Any digit from 0 to 9.
*/

console.log("Age: 25".match(/[0-9]/));

/*
Matches:

2

Because only first matching digit is returned without g.
*/

/*
=====================================================================
13. [^ ]
=====================================================================

^ inside [] means:

NOT these characters.
*/

console.log("abc".match(/[^a]/));

/*
Matches:

b

Because b is NOT a.
*/

/*
=====================================================================
14. \d
=====================================================================

\d = digit

Same as:

[0-9]
*/

console.log("My age is 25".match(/\d/g));

/*
Output:

["2", "5"]
*/

/*
=====================================================================
15. \D
=====================================================================

\D = NOT a digit

Same concept as:

[^0-9]
*/

console.log("ABC123".match(/\D/g));

/*
Output:

["A", "B", "C"]
*/

/*
=====================================================================
16. \w
=====================================================================

\w = word character

Usually:

A-Z
a-z
0-9
_

*/

console.log("Hello_123".match(/\w/g));

/*
=====================================================================
17. \W
=====================================================================

\W = NOT a word character.
*/

console.log("Hello@123".match(/\W/g));

/*
Matches:

@
*/

/*
=====================================================================
18. \s
=====================================================================

\s = whitespace

Includes spaces, tabs, line breaks, etc.
*/

let sentence = "Hello World";

console.log(sentence.match(/\s/));

/*
Matches the space.
*/

/*
=====================================================================
19. \S
=====================================================================

\S = NOT whitespace
*/

console.log("Hello World".match(/\S/g));

/*
Matches non-space characters.
*/

/*
=====================================================================
20. ^ START OF STRING
=====================================================================

^ outside [] means:

String must start with this pattern.
*/

console.log("Hello World".match(/^Hello/));

console.log("World Hello".match(/^Hello/));

/*
First -> Match
Second -> No Match
*/

/*
=====================================================================
21. $ END OF STRING
=====================================================================

$ means:

String must end with the pattern.
*/

console.log("Hello World".match(/World$/));

console.log("World Hello".match(/World$/));

/*
First -> Match
Second -> No Match
*/

/*
=====================================================================
22. * ZERO OR MORE
=====================================================================

* means:

Previous character can occur:

0 times
1 time
2 times
3 times
...

Example:
*/

console.log("ct".match(/ca*t/));

console.log("cat".match(/ca*t/));

console.log("caaat".match(/ca*t/));

/*
All can match.

Because:

a* = zero or more a
*/

/*
=====================================================================
23. + ONE OR MORE
=====================================================================

+ means:

At least one occurrence.
*/

console.log("cat".match(/ca+t/));

console.log("caaat".match(/ca+t/));

console.log("ct".match(/ca+t/));

/*
cat   -> Match
caaat -> Match
ct    -> No Match
*/

/*
=====================================================================
24. ? ZERO OR ONE
=====================================================================

? means:

Optional.

Zero or one occurrence.
*/

console.log("color".match(/colou?r/));

console.log("colour".match(/colou?r/));

/*
Both match.

u is optional.
*/

/*
=====================================================================
25. {n}
=====================================================================

Exactly n occurrences.
*/

console.log("12345".match(/\d{3}/));

/*
Matches:

123
*/

/*
=====================================================================
26. {n,m}
=====================================================================

Between n and m occurrences.
*/

console.log("123456".match(/\d{2,4}/));

/*
Matches up to 4 digits.
*/

/*
=====================================================================
27. {n,}
=====================================================================

At least n occurrences.
*/

console.log("123456".match(/\d{3,}/));

/*
At least 3 digits.
*/

/*
=====================================================================
28. | OR OPERATOR
=====================================================================

| means OR.
*/

console.log("I like Java".match(/Java|Python/));

console.log("I like Python".match(/Java|Python/));

/*
Either Java OR Python.
*/

/*
=====================================================================
29. GROUPING ( )
=====================================================================

() creates a group.
*/

console.log("abcabc".match(/(abc)+/));

/*
abc
abc

Group:

(abc)

+ applies to entire group.
*/

/*
=====================================================================
30. NON-CAPTURING GROUP (?: )
=====================================================================

(?:...) creates a group without capturing it.
*/

console.log("JavaScript".match(/(?:Java)(Script)/));

/*
Useful when grouping is needed but
you don't need a captured result.
*/

/*
=====================================================================
31. ESCAPE CHARACTER \
=====================================================================

Some characters have special meanings.

To search for the actual character,
escape it.

Example:

. normally means any character.

\. means actual dot.
*/

console.log("hello.com".match(/\./));

/*
Matches:

.
*/

/*
=====================================================================
32. SPECIAL CHARACTERS
=====================================================================

Characters that commonly have special meaning:

.
*
+
?
^
$
()
[]
{}
|

Use \ before them when you want their
literal meaning.

Example:

\.
\*
\+
\?
\$
\(
\)
*/

/*
=====================================================================
33. EMAIL VALIDATION
=====================================================================

Simple practical example.
*/

let email = "test@gmail.com";

let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

console.log(emailRegex.test(email));

/*
true

NOTE:

Email regex can become extremely complex.
For normal application validation,
this simple pattern is often enough for basic checks.
*/

/*
=====================================================================
34. MOBILE NUMBER VALIDATION
=====================================================================

Example: 10 digit number
*/

let phone = "9876543210";

let phoneRegex = /^\d{10}$/;

console.log(phoneRegex.test(phone));

/*
true

Explanation:

^       = start
\d      = digit
{10}    = exactly 10 digits
$       = end
*/

/*
=====================================================================
35. ONLY NUMBERS
=====================================================================
*/

let numberText = "123456";

console.log(/^\d+$/.test(numberText));

/*
true
*/

/*
=====================================================================
36. ONLY LETTERS
=====================================================================
*/

let name = "Mohit";

console.log(/^[A-Za-z]+$/.test(name));

/*
true
*/

/*
=====================================================================
37. ONLY LETTERS AND SPACES
=====================================================================
*/

let fullName = "Mohit Patel";

console.log(/^[A-Za-z ]+$/.test(fullName));

/*
true
*/

/*
=====================================================================
38. PASSWORD VALIDATION
=====================================================================

Example:

At least:
✔ 8 characters
✔ One uppercase
✔ One lowercase
✔ One number
*/

let password = "Hello123";

let passwordRegex =
/^(?=.*[A-Z])(?=.*[a-z])(?=.*\d).{8,}$/;

console.log(passwordRegex.test(password));

/*
=====================================================================
39. LOOKAHEAD
=====================================================================

(?=...)

Positive Lookahead

Means:

"Something must exist ahead."

Example:
*/

let pass = "Hello123";

console.log(
    /^(?=.*\d).+$/.test(pass)
);

/*
Meaning:

(?=.*\d)

There must be at least one digit.
*/

/*
=====================================================================
40. NEGATIVE LOOKAHEAD
=====================================================================

(?!...)

Means:

"Something must NOT exist."
*/

console.log(
    /^(?!.*password).+$/i.test("Hello123")
);

/*
String must NOT contain "password".
*/

/*
=====================================================================
41. str.match() vs regex.test()
=====================================================================

match()
---------

Used when you want the matching data.

Example:
*/

let value = "My number is 12345";

console.log(value.match(/\d+/));

/*
Returns:

["12345"]
*/

/*
test()
-------

Used when you only want:

true / false
*/

console.log(/\d+/.test(value));

/*
true
*/

/*
=====================================================================
42. str.replace() WITH REGEX
=====================================================================
*/

let replaceText = "Java Java Java";

console.log(
    replaceText.replace(/Java/g, "JavaScript")
);

/*
Output:

JavaScript JavaScript JavaScript
*/

/*
=====================================================================
43. str.search() WITH REGEX
=====================================================================

Returns index of first match.
*/

let searchText = "Hello JavaScript";

console.log(
    searchText.search(/Java/)
);

/*
Returns index.
*/

/*
=====================================================================
44. str.split() WITH REGEX
=====================================================================

Regex can also be used with split().
*/

let languages = "Java,JavaScript;Python|C#";

console.log(
    languages.split(/[,;|]/)
);

/*
Output:

[
 "Java",
 "JavaScript",
 "Python",
 "C#"
]
*/

/*
=====================================================================
45. IMPORTANT REGEX SYMBOL CHEAT SHEET
=====================================================================

.       = Any single character

^       = Start of string

$       = End of string

*       = Zero or more

+       = One or more

?       = Zero or one

{n}     = Exactly n

{n,m}   = Between n and m

{n,}    = At least n

[]      = Character set

[^]     = NOT character set

[a-z]   = Lowercase range

[A-Z]   = Uppercase range

[0-9]   = Digit range

\d      = Digit

\D      = Not digit

\w      = Word character

\W      = Not word character

\s      = Whitespace

\S      = Not whitespace

|       = OR

()      = Capturing group

(?:)    = Non-capturing group

(?=)    = Positive lookahead

(?!)    = Negative lookahead

\       = Escape special character

=====================================================================
46. REGEX FLAGS
=====================================================================

i = Ignore case

g = Global search

m = Multiline

s = Dot matches newline characters

u = Unicode mode

y = Sticky matching

d = Include match indices

Example:
*/

let flagsExample = "Java JAVA java";

console.log(
    flagsExample.match(/java/gi)
);

/*
g = find all
i = ignore case

Result:

[
 "Java",
 "JAVA",
 "java"
]
*/

/*
=====================================================================
47. REAL WORLD USE CASES
=====================================================================

Regex is commonly used for:

✔ Email validation
✔ Phone validation
✔ Password validation
✔ Username validation
✔ PIN validation
✔ OTP validation
✔ URL validation
✔ IP address validation
✔ Date validation
✔ Extract numbers
✔ Extract hashtags
✔ Search and replace
✔ Remove unwanted characters
✔ Form validation
✔ Log file processing

=====================================================================
48. IMPORTANT INTERVIEW POINT
=====================================================================

Q: What is Regex?

Answer:

Regex is a pattern-matching mechanism used to
search, validate, extract, and replace text
according to a defined pattern.

Q: What does str.match() do?

Answer:

str.match(regex) searches a string using a
regular expression and returns the matching
results, or null if no match is found.

Q: What is the difference between match() and test()?

match()
--------
Returns matching result/data.

test()
-------
Returns true or false.

=====================================================================
49. SIMPLE WAY TO LEARN REGEX
=====================================================================

Start with:

Step 1:
Literal characters

/hello/

Step 2:
Character classes

/[a-z]/
/[0-9]/

Step 3:
Shortcuts

\d
\w
\s

Step 4:
Quantifiers

*
+
?
{n}
{n,m}

Step 5:
Position

^
$

Step 6:
Groups

()
|

Step 7:
Lookahead

(?=)
(?!)

=====================================================================
FINAL SUMMARY
=====================================================================

Regex = Pattern Matching

str.match()
============
Used to find pattern inside a string.

Most Important Symbols:

.       Any character
^       Start
$       End
*       Zero or more
+       One or more
?       Optional
{n}     Exact count
[]      Character set
()      Group
|       OR
\d      Digit
\w      Word character
\s      Space
\D      Not digit
\W      Not word
\S      Not space

Most Important Flags:

i = Ignore Case
g = Global
m = Multiline
s = Dot matches newline
u = Unicode
y = Sticky

=====================================================================
*/