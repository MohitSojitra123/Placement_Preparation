/*
=========================================================
          JAVASCRIPT STRING METHODS
=========================================================

---------------------------------------------------------
1) What is String ?
---------------------------------------------------------

String is used to store text data.

Example:
"Hello"
'JavaScript'

---------------------------------------------------------
2) Why String Methods Used ?
---------------------------------------------------------

✔ Text manipulation
✔ Searching
✔ Replacing
✔ Formatting
✔ Validation
✔ Splitting
✔ Extracting data

---------------------------------------------------------
3) Important Point
---------------------------------------------------------

✔ Strings are immutable
✔ Original string usually not changed
✔ Methods return new string/value

---------------------------------------------------------
4) Common String Methods
---------------------------------------------------------

length
toUpperCase()
toLowerCase()
trim()
trimStart()
trimEnd()
includes()
startsWith()
endsWith()
indexOf()
lastIndexOf()
slice()
substring()
substr()
replace()
replaceAll()
split()
concat()
charAt()
charCodeAt()
repeat()
padStart()
padEnd()
match()
search()
localeCompare()
valueOf()
toString()

=========================================================
                STRING DECLARATION
=========================================================
*/

console.log("================================================");
console.log("           STRING DECLARATION                   ");
console.log("================================================");

let str = "Hello JavaScript";

console.log(str);

/*
=========================================================
                length PROPERTY
=========================================================
*/

console.log("\n================================================");
console.log("              length PROPERTY                   ");
console.log("================================================");

/*
Returns total characters
*/

console.log(str.length);

/*
=========================================================
             toUpperCase() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("           toUpperCase()                        ");
console.log("================================================");

/*
Convert into uppercase
*/

console.log(str.toUpperCase());

/*
=========================================================
             toLowerCase() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("           toLowerCase()                        ");
console.log("================================================");

/*
Convert into lowercase
*/

console.log(str.toLowerCase());

/*
=========================================================
                trim() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("                trim()                          ");
console.log("================================================");

/*
Remove spaces from both sides
*/

let text = "   JavaScript   ";

console.log(text.trim());

/*
=========================================================
              trimStart() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("             trimStart()                        ");
console.log("================================================");

/*
Remove left spaces
*/

console.log(text.trimStart());

/*
=========================================================
               trimEnd() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("              trimEnd()                         ");
console.log("================================================");

/*
Remove right spaces
*/

console.log(text.trimEnd());

/*
=========================================================
              includes() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("             includes()                         ");
console.log("================================================");

/*
Check text exists or not
*/

console.log(str.includes("Java"));

console.log(str.includes("Python"));

/*
=========================================================
            startsWith() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("           startsWith()                         ");
console.log("================================================");

/*
Check starting text
*/

console.log(str.startsWith("Hello"));

/*
=========================================================
             endsWith() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("            endsWith()                          ");
console.log("================================================");

/*
Check ending text
*/

console.log(str.endsWith("Script"));

/*
=========================================================
              indexOf() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("             indexOf()                          ");
console.log("================================================");

/*
Returns first matching index
*/

console.log(str.indexOf("Java"));

/*
=========================================================
            lastIndexOf() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("           lastIndexOf()                        ");
console.log("================================================");

/*
Returns last matching index
*/

let msg = "Hello Hello";

console.log(msg.lastIndexOf("Hello"));

/*
=========================================================
                slice() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("               slice()                          ");
console.log("================================================");

/*
Extract part of string
*/

console.log(str.slice(0, 5));

/*
=========================================================
             substring() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("            substring()                         ");
console.log("================================================");

/*
Extract string
Negative values not supported
*/

console.log(str.substring(0, 5));


/*
=========================================================
               substr() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("              substr()                          ");
console.log("================================================");

/*
Extract using start and length
Deprecated method
*/

console.log(str.substr(0, 5));



/*
=========================================================
              replace() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("             replace()                          ");
console.log("================================================");

/*
Replace first matching value
*/

console.log(str.replace("JavaScript", "JS"));



/*
=========================================================
            replaceAll() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("            replaceAll()                        ");
console.log("================================================");

/*
Replace all matching values
*/

let data = "Java Java Java";

console.log(data.replaceAll("Java", "JS"));

/*
=========================================================
                split() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("               split()                          ");
console.log("================================================");

/*
Convert string into array
*/

let skills = "HTML,CSS,JS";

console.log(skills.split(","));

/*
=========================================================
               concat() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("               concat()                         ");
console.log("================================================");

/*
Join strings
*/

let first = "Hello ";

let second = "World";

console.log(first.concat(second));

/*
=========================================================
               charAt() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("               charAt()                         ");
console.log("================================================");

/*
Get character by index
*/

console.log(str.charAt(0));

/*
=========================================================
             charCodeAt() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("            charCodeAt()                        ");
console.log("================================================");

/*
ASCII / Unicode value
*/

console.log(str.charCodeAt(0));

/*
=========================================================
               repeat() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("               repeat()                         ");
console.log("================================================");

/*
Repeat string
*/

console.log("JS ".repeat(3));

/*
=========================================================
              padStart() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("             padStart()                         ");
console.log("================================================");

/*
Add characters at beginning
*/

let num = "5";

console.log(num.padStart(4, "0"));


/*
=========================================================
               padEnd() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("              padEnd()                          ");
console.log("================================================");

/*
Add characters at end
*/

console.log(num.padEnd(4, "0"));

/*
=========================================================
                match() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("                match()                         ");
console.log("================================================");

/*
Find matching data using regex
*/

let sentence = "I love JavaScript";

console.log(sentence.match("JavaScript"));


/*
=========================================================
               search() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("               search()                         ");
console.log("================================================");

/*
Search text index
*/

console.log(sentence.search("love"));

/*
=========================================================
           localeCompare() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("          localeCompare()                       ");
console.log("================================================");

/*
Compare strings
*/

console.log("a".localeCompare("b"));





/*
=========================================================
               valueOf() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("               valueOf()                        ");
console.log("================================================");

/*
Returns primitive value
*/

console.log(str.valueOf());


/*
=========================================================
               toString() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("               toString()                       ");
console.log("================================================");

/*
Convert to string
*/

let value = 100;

console.log(value.toString());

/*
=========================================================
            TEMPLATE LITERAL EXAMPLE
=========================================================
*/

console.log("\n================================================");
console.log("          TEMPLATE LITERAL                      ");
console.log("================================================");

/*
Modern string formatting
*/

let username = "Mohit";

console.log(`Hello ${username}`);





/*
=========================================================
               STRING TRAVERSAL
=========================================================
*/

console.log("\n================================================");
console.log("             STRING TRAVERSAL                   ");
console.log("================================================");

let language = "JavaScript";

/*
for loop
*/

for(let i = 0; i < language.length; i++)
{
    console.log(language[i]);
}





console.log("\n================================================");
console.log("               for...of                         ");
console.log("================================================");

/*
for...of traversal
*/

for(let char of language)
{
    console.log(char);
}





/*
=========================================================
              REAL WORLD USE CASES
=========================================================
*/

console.log("\n================================================");
console.log("            REAL WORLD USE CASES                ");
console.log("================================================");

console.log(`
✔ Form validation
✔ Search functionality
✔ Password checking
✔ Text formatting
✔ OTP masking
✔ Email validation
✔ Data formatting
✔ Chat applications
✔ URL handling
`);


/*
=========================================================
              MOST USED METHODS
=========================================================
*/

console.log("\n================================================");
console.log("            MOST USED METHODS                   ");
console.log("================================================");

console.log(`
✔ length
✔ trim()
✔ includes()
✔ replace()
✔ split()
✔ slice()
✔ toUpperCase()
✔ toLowerCase()
`);

/*
=========================================================
              IMPORTANT NOTES
=========================================================
*/

console.log("\n================================================");
console.log("            IMPORTANT NOTES                     ");
console.log("================================================");

console.log(`
✔ Strings are immutable
✔ Methods usually return new string
✔ split() converts string to array
✔ replaceAll() replaces all matches
✔ trim() removes spaces
✔ includes() checks existence
`);

/*
=========================================================
               STRING METHOD DIFFERENCE
=========================================================
*/

console.log("\n================================================");
console.log("          METHOD DIFFERENCE                     ");
console.log("================================================");

console.log(`
slice()
--------
Supports negative index

substring()
-------------
No negative index

substr()
----------
Uses length parameter
Deprecated

replace()
-----------
Replace first occurrence

replaceAll()
--------------
Replace all occurrences
`);

/*
=========================================================
                 FINAL SUMMARY
=========================================================
*/

console.log("\n================================================");
console.log("               FINAL SUMMARY                    ");
console.log("================================================");

console.log(`
Most Important Methods
-----------------------
✔ trim()
✔ split()
✔ replace()
✔ includes()
✔ slice()
✔ toUpperCase()
✔ toLowerCase()

Most Common Uses
-----------------
✔ Validation
✔ Searching
✔ Formatting
✔ Splitting
✔ Replacing
✔ Text manipulation
`);

console.log("\n================================================");
console.log("                 PROGRAM END                    ");
console.log("================================================");