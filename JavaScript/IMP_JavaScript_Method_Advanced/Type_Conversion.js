/*
=========================================================
          TYPE CONVERSION IN JAVASCRIPT
=========================================================

---------------------------------------------------------
1) What is Type Conversion ?
---------------------------------------------------------

Type conversion means:
Changing one data type into another.

Simple Meaning:
"Convert value from one type to another"

---------------------------------------------------------
2) Why Type Conversion Used ?
---------------------------------------------------------

✔ User input handling
✔ API data conversion
✔ Mathematical calculations
✔ Form validation
✔ Database operations

---------------------------------------------------------
3) Types of Conversion
---------------------------------------------------------

1) Implicit Conversion
-----------------------
Automatic conversion by JavaScript

2) Explicit Conversion
-----------------------
Manual conversion by programmer

---------------------------------------------------------
4) Common Conversions
---------------------------------------------------------

✔ Character → Integer
✔ Integer → Character
✔ Integer → String
✔ String → Integer
✔ Boolean → String
✔ String → Boolean
✔ Number → Boolean
✔ Array → String

=========================================================
           CHARACTER TO INTEGER
=========================================================
*/

console.log("================================================");
console.log("          CHARACTER TO INTEGER                  ");
console.log("================================================");

/*
charCodeAt()
Returns ASCII / Unicode value
*/

let ch = "A";

let asciiValue = ch.charCodeAt(0);

console.log(asciiValue);

/*
A = 65
*/

/*
=========================================================
           INTEGER TO CHARACTER
=========================================================
*/

console.log("\n================================================");
console.log("          INTEGER TO CHARACTER                  ");
console.log("================================================");

/*
String.fromCharCode()
*/

let number = 65;

let character = String.fromCharCode(number);

console.log(character);

/*
65 = A
*/


/*
=========================================================
            INTEGER TO STRING
=========================================================
*/

console.log("\n================================================");
console.log("            INTEGER TO STRING                   ");
console.log("================================================");

/*
Method 1: toString()
*/

let num1 = 100;

let str1 = num1.toString();

console.log(str1);

console.log(typeof str1);


/*
Method 2: String()
*/

let num2 = 500;

let str2 = String(num2);

console.log(str2);

console.log(typeof str2);

/*
=========================================================
            STRING TO INTEGER
=========================================================
*/

console.log("\n================================================");
console.log("            STRING TO INTEGER                   ");
console.log("================================================");

/*
Method 1: Number()
*/

let value1 = "200";

let numValue1 = Number(value1);

console.log(numValue1);

console.log(typeof numValue1);

/*
Method 2: parseInt()
*/

let value2 = "300";

let numValue2 = parseInt(value2);

console.log(numValue2);


/*
Method 3: Unary +
*/

let value3 = "400";

let numValue3 = +value3;

console.log(numValue3);


/*
=========================================================
           STRING TO FLOAT NUMBER
=========================================================
*/

console.log("\n================================================");
console.log("          STRING TO FLOAT                       ");
console.log("================================================");

/*
parseFloat()
*/

let decimalString = "12.55";

let floatValue = parseFloat(decimalString);

console.log(floatValue);

console.log(typeof floatValue);


/*
=========================================================
           FLOAT NUMBER TO STRING
=========================================================
*/

console.log("\n================================================");
console.log("          FLOAT TO STRING                       ");
console.log("================================================");

let price = 99.99;

let priceString = String(price);

console.log(priceString);

console.log(typeof priceString);


/*
=========================================================
            BOOLEAN TO STRING
=========================================================
*/

console.log("\n================================================");
console.log("          BOOLEAN TO STRING                     ");
console.log("================================================");

let status = true;

let statusString = String(status);

console.log(statusString);

console.log(typeof statusString);


/*
=========================================================
            STRING TO BOOLEAN
=========================================================
*/

console.log("\n================================================");
console.log("          STRING TO BOOLEAN                     ");
console.log("================================================");

/*
Boolean()
*/

let text1 = "Hello";

console.log(Boolean(text1));

let text2 = "";

console.log(Boolean(text2));

/*
Empty string = false
*/


/*
=========================================================
            NUMBER TO BOOLEAN
=========================================================
*/

console.log("\n================================================");
console.log("          NUMBER TO BOOLEAN                     ");
console.log("================================================");

console.log(Boolean(1));

console.log(Boolean(0));

/*
0 = false
Non-zero = true
*/


/*
=========================================================
            BOOLEAN TO NUMBER
=========================================================
*/

console.log("\n================================================");
console.log("          BOOLEAN TO NUMBER                     ");
console.log("================================================");

/*
Number()
*/

console.log(Number(true));

console.log(Number(false));

/*
true = 1
false = 0
*/


/*
=========================================================
             ARRAY TO STRING
=========================================================
*/

console.log("\n================================================");
console.log("            ARRAY TO STRING                     ");
console.log("================================================");

/*
toString()
*/

let arr = [1, 2, 3, 4];

let arrString = arr.toString();

console.log(arrString);

console.log(typeof arrString);





/*
=========================================================
             STRING TO ARRAY
=========================================================
*/

console.log("\n================================================");
console.log("            STRING TO ARRAY                     ");
console.log("================================================");

/*
split()
*/

let names = "Amit,Rahul,Neha";

let nameArray = names.split(",");

console.log(nameArray);

console.log(typeof nameArray);


/*
=========================================================
            DATE TO STRING
=========================================================
*/

console.log("\n================================================");
console.log("            DATE TO STRING                      ");
console.log("================================================");

let currentDate = new Date();

console.log(currentDate.toString());


/*
=========================================================
            STRING TO DATE
=========================================================
*/

console.log("\n================================================");
console.log("            STRING TO DATE                      ");
console.log("================================================");

let dateString = "2025-05-21";

let dateObject = new Date(dateString);

console.log(dateObject);


/*
=========================================================
            OBJECT TO STRING
=========================================================
*/

console.log("\n================================================");
console.log("            OBJECT TO STRING                    ");
console.log("================================================");

/*
JSON.stringify()
*/

let user = {

    name: "Mohit",

    age: 22
};

let userString = JSON.stringify(user);

console.log(userString);

console.log(typeof userString);


/*
=========================================================
            STRING TO OBJECT
=========================================================
*/

console.log("\n================================================");
console.log("            STRING TO OBJECT                    ");
console.log("================================================");

/*
JSON.parse()
*/

let jsonData =
'{"city":"Rajkot","state":"Gujarat"}';

let objectData = JSON.parse(jsonData);

console.log(objectData);

console.log(typeof objectData);

/*
=========================================================
             IMPLICIT CONVERSION
=========================================================
*/

console.log("\n================================================");
console.log("          IMPLICIT CONVERSION                   ");
console.log("================================================");

/*
Automatic conversion by JavaScript
*/

console.log("5" + 5);

/*
String concatenation
*/

console.log("10" - 5);

/*
Converted to number
*/

/*
=========================================================
             EXPLICIT CONVERSION
=========================================================
*/

console.log("\n================================================");
console.log("          EXPLICIT CONVERSION                   ");
console.log("================================================");

/*
Manual conversion
*/

let value = "50";

console.log(Number(value));

console.log(String(100));

console.log(Boolean(1));



/*
=========================================================
            NaN EXAMPLE
=========================================================
*/

console.log("\n================================================");
console.log("                NaN EXAMPLE                     ");
console.log("================================================");

/*
Invalid number conversion
*/

let invalid = Number("Hello");

console.log(invalid);

/*
NaN = Not a Number
*/


/*
=========================================================
          parseInt vs Number DIFFERENCE
=========================================================
*/

console.log("\n================================================");
console.log("      parseInt vs Number                        ");
console.log("================================================");

console.log(parseInt("100px"));

/*
100
*/

console.log(Number("100px"));

/*
NaN
*/


/*
=========================================================
              REAL WORLD USE CASES
=========================================================
*/

console.log("\n================================================");
console.log("            REAL WORLD USE CASES                ");
console.log("================================================");

console.log(`
✔ Form input conversion
✔ API response handling
✔ Database data conversion
✔ OTP processing
✔ Validation
✔ JSON handling
✔ Mathematical calculations
✔ Authentication systems
`);



/*
=========================================================
             MOST USED CONVERSIONS
=========================================================
*/

console.log("\n================================================");
console.log("          MOST USED CONVERSIONS                 ");
console.log("================================================");

console.log(`
✔ Number()
✔ String()
✔ Boolean()
✔ parseInt()
✔ parseFloat()
✔ JSON.stringify()
✔ JSON.parse()
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
✔ charCodeAt() gives ASCII value
✔ fromCharCode() converts number to character
✔ parseInt() converts string to integer
✔ Number() strict conversion
✔ JSON methods for object conversion
✔ Boolean conversion based on truthy/falsy
`);





/*
=========================================================
                BEST PRACTICES
=========================================================
*/

console.log("\n================================================");
console.log("              BEST PRACTICES                    ");
console.log("================================================");

console.log(`
✔ Use Number() for clean conversion
✔ Use parseInt() for integer extraction
✔ Validate before conversion
✔ Handle NaN carefully
✔ Use JSON methods for APIs
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
Character ↔ Integer
--------------------
✔ charCodeAt()
✔ fromCharCode()

String ↔ Integer
-----------------
✔ Number()
✔ parseInt()
✔ String()

Object ↔ String
----------------
✔ JSON.stringify()
✔ JSON.parse()

Most Important Methods
-----------------------
✔ Number()
✔ String()
✔ Boolean()
✔ parseInt()
✔ parseFloat()
`);

console.log("\n================================================");
console.log("                 PROGRAM END                    ");
console.log("================================================");