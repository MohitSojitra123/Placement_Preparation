/*
=====================================================================
                 REGEX (REGULAR EXPRESSION) IN JAVA
=====================================================================

1. WHAT IS REGEX?
---------------------------------------------------------------------

Regex = Regular Expression

Regex is a pattern used to:

✔ Search text
✔ Validate text
✔ Find a particular pattern
✔ Extract data
✔ Replace text
✔ Split text

Simple Meaning:

"Regex tells Java what pattern we are looking for."

Example:

String:
    "Hello Java"

Pattern:
    "Java"

Meaning:
    Find "Java" inside the String.

---------------------------------------------------------------------
2. REGEX IN JAVA
---------------------------------------------------------------------

Java provides two important classes:

1) Pattern
2) Matcher

Import:

import java.util.regex.Pattern;
import java.util.regex.Matcher;

Pattern
-------
Compiles the Regular Expression.

Matcher
-------
Searches/matches the pattern against a String.

---------------------------------------------------------------------
3. IMPORTANT JAVA DIFFERENCE
---------------------------------------------------------------------

In JavaScript:

/\d+/

In Java:

"\\d+"

Why?

Because:

\

is also an escape character in Java String.

Therefore:

Regex:
\d

Java String:
"\\d"

=====================================================================
                    BASIC REGEX EXAMPLE
=====================================================================
*/

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexExample
{
    public static void main(String[] args)
    {

        String str = "Hello Java";

        Pattern pattern =
            Pattern.compile("Java");

        Matcher matcher =
            pattern.matcher(str);

        if(matcher.find())
        {
            System.out.println("Pattern Found");
        }
        else
        {
            System.out.println("Pattern Not Found");
        }
    }
}


/*
=====================================================================
                IMPORTANT REGEX SYMBOLS
=====================================================================

.       Any character

^       Start of String

$       End of String

*       Zero or more

+       One or more

?       Zero or one

{n}     Exactly n times

{n,m}   Between n and m times

{n,}    At least n times

[]      Character Set

[^]     NOT / Exclusion

()      Group

|       OR

\d      Digit

\D      Non-digit

\w      Word character

\W      Non-word character

\s      Whitespace

\S      Non-whitespace

\b      Word boundary

\B      Non-word boundary

=====================================================================
                     . SYMBOL
=====================================================================

. = Any single character

Example:

c.t

Can match:

cat
cot
cut

*/

Pattern pattern1 =
    Pattern.compile("c.t");


/*
=====================================================================
                     ^ SYMBOL
=====================================================================

^ = Start of String

Example:

^Hello

Matches:

Hello Java

Does not match:

Java Hello

*/

Pattern pattern2 =
    Pattern.compile("^Hello");


/*
=====================================================================
                     $ SYMBOL
=====================================================================

$ = End of String

Example:

Java$

Matches:

I love Java

Does not match:

Java Programming

*/

Pattern pattern3 =
    Pattern.compile("Java$");


/*
=====================================================================
                ^ AND $ TOGETHER
=====================================================================

Very important for validation.

Example:

^[0-9]+$

Meaning:

Start
 ↓
One or more digits
 ↓
End

Therefore the entire String
must contain only numbers.

=====================================================================
                     [] SYMBOL
=====================================================================

[] = Character Set

Example:

[abc]

Means:

a OR b OR c

*/

Pattern pattern4 =
    Pattern.compile("[abc]");


/*
=====================================================================
                  [a-z]
=====================================================================

Any lowercase character

*/

Pattern lowerCase =
    Pattern.compile("[a-z]");


/*
=====================================================================
                  [A-Z]
=====================================================================

Any uppercase character

*/

Pattern upperCase =
    Pattern.compile("[A-Z]");


/*
=====================================================================
                  [0-9]
=====================================================================

Any digit from 0 to 9

*/

Pattern numbers =
    Pattern.compile("[0-9]");


/*
=====================================================================
                  [^abc]
=====================================================================

Matches characters EXCEPT:

a
b
c

*/

Pattern notABC =
    Pattern.compile("[^abc]");


/*
=====================================================================
                    * SYMBOL
=====================================================================

* = Zero or more times

Example:

co*t

Can match:

ct
cot
coot
cooot

Because:

o can occur zero or more times.

=====================================================================
                    + SYMBOL
=====================================================================

+ = One or more times

Example:

co+t

Matches:

cot
coot
cooot

Does NOT match:

ct

Because at least one 'o' is required.

=====================================================================
                    ? SYMBOL
=====================================================================

? = Zero or one time

Example:

colou?r

Matches:

color
colour

Because:

u is optional.

=====================================================================
                   {n} SYMBOL
=====================================================================

Exactly n times.

Example:

[0-9]{3}

Matches:

123
456
789

Does not completely validate:

12
1234

=====================================================================
                  {n,m} SYMBOL
=====================================================================

Minimum n
Maximum m

Example:

[0-9]{2,4}

Matches:

12
123
1234

=====================================================================
                  {n,} SYMBOL
=====================================================================

At least n times.

Example:

[0-9]{3,}

Matches:

123
1234
12345
123456

=====================================================================
                    | SYMBOL
=====================================================================

| = OR

Example:

cat|dog

Matches:

cat

OR

dog

=====================================================================
                    () SYMBOL
=====================================================================

() = Group

Example:

(abc)(123)

String:

abc123

=====================================================================
                    \d
=====================================================================

\d = Digit

In Java String:

"\\d"

Example:

*/

Pattern digitPattern =
    Pattern.compile("\\d");


/*
=====================================================================
                    \D
=====================================================================

\D = Non-digit

Java:

"\\D"

=====================================================================
                    \w
=====================================================================

\w = Word character

Generally:

A-Z
a-z
0-9
_

Java:

"\\w"

=====================================================================
                    \W
=====================================================================

\W = Non-word character

Java:

"\\W"

=====================================================================
                    \s
=====================================================================

\s = Whitespace

Java:

"\\s"

Matches:

Space
Tab
Newline

=====================================================================
                    \S
=====================================================================

\S = Non-whitespace

Java:

"\\S"

=====================================================================
                    \b
=====================================================================

\b = Word boundary

Java:

"\\b"

Useful for finding a complete word.

=====================================================================
                 ESCAPE CHARACTER
=====================================================================

Backslash:

\

is used to escape special characters.

Example:

To find an actual dot:

\\.

Java String:

"\\."

=====================================================================
                  REGEX FLAGS
=====================================================================

Java supports flags such as:

CASE_INSENSITIVE
MULTILINE
DOTALL
COMMENTS
UNICODE_CASE
UNICODE_CHARACTER_CLASS

Example:

Pattern.compile(
    "java",
    Pattern.CASE_INSENSITIVE
);

This matches:

java
Java
JAVA
jAvA

=====================================================================
                 Pattern + Matcher
=====================================================================
*/

String text = "I am learning Java";

Pattern p =
    Pattern.compile("Java");

Matcher m =
    p.matcher(text);

if(m.find())
{
    System.out.println("Found");
}


/*
=====================================================================
                    matcher.find()
=====================================================================

find() searches for the pattern
anywhere inside the String.

Example:

String:

"I love Java"

Pattern:

"Java"

find() -> true

=====================================================================
                    matcher.matches()
=====================================================================

matches() checks whether the
ENTIRE String matches the pattern.

Very important difference.

Example:

*/

Pattern p2 =
    Pattern.compile("[0-9]+");

Matcher m2 =
    p2.matcher("12345");

if(m2.matches())
{
    System.out.println("Only Numbers");
}


/*
=====================================================================
              find() vs matches()
=====================================================================

find()
------
Searches anywhere.

matches()
---------
Checks the complete String.

Example:

String:

"ABC123"

Pattern:

"[0-9]+"

find()
------
false

matches()
---------
false

Because complete String is not
only numbers.

Example:

String:

"12345"

find()
------
true

matches()
---------
true

=====================================================================
                GROUP MATCHING
=====================================================================
*/

Pattern emailPattern =
    Pattern.compile(
        "([A-Za-z0-9._%+-]+)@([A-Za-z0-9.-]+)\\.([A-Za-z]{2,})"
    );

Matcher emailMatcher =
    emailPattern.matcher("mohit@gmail.com");

if(emailMatcher.matches())
{
    System.out.println("Valid Email");

    System.out.println(
        "Username: " + emailMatcher.group(1)
    );

    System.out.println(
        "Domain: " + emailMatcher.group(2)
    );

    System.out.println(
        "Extension: " + emailMatcher.group(3)
    );
}


/*
=====================================================================
             REAL-WORLD EXAMPLE 1
             MOBILE NUMBER VALIDATION
=====================================================================

Requirement:

✔ Exactly 10 digits
✔ Only numbers

Pattern:

^[0-9]{10}$

Java:

"^[0-9]{10}$"
*/

String mobile = "9876543210";

Pattern mobilePattern =
    Pattern.compile("^[0-9]{10}$");

Matcher mobileMatcher =
    mobilePattern.matcher(mobile);

if(mobileMatcher.matches())
{
    System.out.println("Valid Mobile Number");
}
else
{
    System.out.println("Invalid Mobile Number");
}


/*
=====================================================================
             REAL-WORLD EXAMPLE 2
             USERNAME VALIDATION
=====================================================================

Requirement:

✔ Letters
✔ Numbers
✔ Underscore
✔ 3 to 15 characters

Pattern:

^[A-Za-z0-9_]{3,15}$

*/

String username = "mohit_123";

Pattern usernamePattern =
    Pattern.compile("^[A-Za-z0-9_]{3,15}$");

Matcher usernameMatcher =
    usernamePattern.matcher(username);

if(usernameMatcher.matches())
{
    System.out.println("Valid Username");
}
else
{
    System.out.println("Invalid Username");
}


/*
=====================================================================
             REAL-WORLD EXAMPLE 3
             EMAIL VALIDATION
=====================================================================
*/

String email = "mohit@gmail.com";

String emailRegex =
    "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

Pattern emailPattern2 =
    Pattern.compile(emailRegex);

Matcher emailMatcher2 =
    emailPattern2.matcher(email);

if(emailMatcher2.matches())
{
    System.out.println("Valid Email");
}
else
{
    System.out.println("Invalid Email");
}


/*
=====================================================================
             REAL-WORLD EXAMPLE 4
             PASSWORD VALIDATION
=====================================================================

Requirement:

✔ Minimum 8 characters
✔ One uppercase
✔ One lowercase
✔ One number

*/

String password = "Mohit123";

String passwordRegex =
    "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$";

Pattern passwordPattern =
    Pattern.compile(passwordRegex);

Matcher passwordMatcher =
    passwordPattern.matcher(password);

if(passwordMatcher.matches())
{
    System.out.println("Valid Password");
}
else
{
    System.out.println("Invalid Password");
}


/*
=====================================================================
             REAL-WORLD EXAMPLE 5
             FIND ALL NUMBERS
=====================================================================

String:

"I have 10 apples and 20 oranges."

Regex:

\\d+

*/

String sentence =
    "I have 10 apples and 20 oranges.";

Pattern numberPattern =
    Pattern.compile("\\d+");

Matcher numberMatcher =
    numberPattern.matcher(sentence);

while(numberMatcher.find())
{
    System.out.println(
        "Number: " + numberMatcher.group()
    );
}


/*
Output:

Number: 10
Number: 20

=====================================================================
             REAL-WORLD EXAMPLE 6
             FIND ALL WORDS
=====================================================================
*/

String sentence2 =
    "Hello Java World";

Pattern wordPattern =
    Pattern.compile("\\w+");

Matcher wordMatcher =
    wordPattern.matcher(sentence2);

while(wordMatcher.find())
{
    System.out.println(
        wordMatcher.group()
    );
}


/*
=====================================================================
             REAL-WORLD EXAMPLE 7
             FIND CAPITAL LETTERS
=====================================================================
*/

String sentence3 =
    "Hello JAVA World";

Pattern capitalPattern =
    Pattern.compile("[A-Z]+");

Matcher capitalMatcher =
    capitalPattern.matcher(sentence3);

while(capitalMatcher.find())
{
    System.out.println(
        capitalMatcher.group()
    );
}


/*
=====================================================================
             REAL-WORLD EXAMPLE 8
             REPLACE USING REGEX
=====================================================================

Use:

String.replaceAll(regex, replacement)

*/

String data =
    "Account 12345";

String result =
    data.replaceAll("\\d", "*");

System.out.println(result);

/*
Output:

Account *****

=====================================================================
             REAL-WORLD EXAMPLE 9
             REMOVE EXTRA SPACES
=====================================================================
*/

String message =
    "Hello     Java     Programming";

String cleanMessage =
    message.replaceAll("\\s+", " ");

System.out.println(cleanMessage);

/*
Output:

Hello Java Programming

=====================================================================
             REAL-WORLD EXAMPLE 10
             SPLIT USING REGEX
=====================================================================
*/

String names =
    "Amit,Rahul;Neha|Raj";

String[] nameArray =
    names.split("[,;|]");

for(String name : nameArray)
{
    System.out.println(name);
}


/*
=====================================================================
                JAVA REGEX METHODS
=====================================================================

Pattern
--------

Pattern.compile(regex)


Matcher
--------

matcher.find()
    Search pattern anywhere.

matcher.matches()
    Match complete String.

matcher.group()
    Get matched value.

matcher.group(n)
    Get captured group.


String Methods
--------------

matches()
replaceAll()
replaceFirst()
split()

=====================================================================
               IMPORTANT JAVA DIFFERENCE
=====================================================================

JavaScript:

str.match(/\d+/g)

Java:

Pattern p = Pattern.compile("\\d+");

Matcher m = p.matcher(str);

while(m.find())
{
    System.out.println(m.group());
}

---------------------------------------------------------------

JavaScript Regex:

\d

Java Regex String:

"\\d"

This is one of the most important differences
when writing Regex in Java.

=====================================================================
                COMMON REGEX CHEAT SHEET
=====================================================================

CHARACTER
------------------------------------------------------------

.       Any character
\d      Digit
\D      Non-digit
\w      Word character
\W      Non-word character
\s      Whitespace
\S      Non-whitespace

POSITION
------------------------------------------------------------

^       Start
$       End
\b      Word boundary
\B      Non-word boundary

QUANTITY
------------------------------------------------------------

*       0 or more
+       1 or more
?       0 or 1
{n}     Exactly n
{n,m}   n to m
{n,}    n or more

GROUPING
------------------------------------------------------------

[]      Character set
[^]     Exclude characters
()      Group
|       OR

JAVA IMPORTANT ESCAPING
------------------------------------------------------------

Regex       Java String

\d          "\\d"
\D          "\\D"
\w          "\\w"
\W          "\\W"
\s          "\\s"
\S          "\\S"
\.          "\\."
\b          "\\b"

=====================================================================
                  REGEX USE CASES
=====================================================================

Regex is commonly used in Java for:

✔ Form Validation
✔ Email Validation
✔ Mobile Validation
✔ Password Validation
✔ Username Validation
✔ OTP Validation
✔ Search
✔ Replace
✔ Data Extraction
✔ Log Processing
✔ File Validation
✔ URL Validation
✔ Input Validation
✔ Text Processing

=====================================================================
                    INTERVIEW QUESTIONS
=====================================================================

Q1. What is Regex?

Answer:

Regex is a pattern-matching mechanism used to
search, validate, extract, and replace text.

------------------------------------------------------------

Q2. Which classes are used for Regex in Java?

Answer:

Pattern
Matcher

------------------------------------------------------------

Q3. Difference between find() and matches()?

find()
-------
Searches for the pattern anywhere in the String.

matches()
---------
Checks whether the complete String matches
the pattern.

------------------------------------------------------------

Q4. Why do we use double backslash in Java?

Example:

"\\d"

Because:

\

is an escape character in Java String literals.

Therefore:

Regex:

\d

Must be written as:

"\\d"

------------------------------------------------------------

Q5. How to validate a 10-digit mobile number?

Pattern:

^[0-9]{10}$

Java:

Pattern.compile("^[0-9]{10}$");

=====================================================================
                       FINAL SUMMARY
=====================================================================

Regex
-----
Pattern used to search/validate text.

Java Classes
------------
✔ Pattern
✔ Matcher

Most Important Methods
----------------------
✔ find()
✔ matches()
✔ group()

Common Symbols
--------------
.       Any character
^       Start
$       End
*       0 or more
+       1 or more
?       Optional
[]      Character set
()      Group
|       OR
\d      Digit
\w      Word
\s      Space

Most Important Java Rule
------------------------

Java Regex:

"\\d"

NOT:

"\d"

Real-World Uses
---------------
✔ Email
✔ Mobile
✔ Password
✔ Username
✔ OTP
✔ Search
✔ Replace
✔ Data Extraction

=====================================================================
*/