/*
=========================================================
             FUNCTION CURRYING IN JAVASCRIPT
=========================================================

---------------------------------------------------------
1) What is Function Currying ?
---------------------------------------------------------

Function Currying means:
Converting a function with multiple arguments
into multiple functions with single argument.

Simple Meaning:
"One argument at a time"

---------------------------------------------------------
2) Normal Function
---------------------------------------------------------

Normal function takes multiple arguments together.

Example:
add(10,20,30)

---------------------------------------------------------
3) Curried Function
---------------------------------------------------------

Curried function takes arguments one by one.

Example:
add(10)(20)(30)

---------------------------------------------------------
4) Why Currying Used ?
---------------------------------------------------------

✔ Reusable functions
✔ Cleaner code
✔ Functional programming
✔ Avoid repeated arguments
✔ Better abstraction

---------------------------------------------------------
5) When To Use Currying ?
---------------------------------------------------------

✔ React applications
✔ Functional programming
✔ Event handling
✔ Custom logger
✔ Validation
✔ API configuration
✔ Partial function reuse

---------------------------------------------------------
6) Advantages
---------------------------------------------------------

✔ Reusable code
✔ Better readability
✔ Avoid duplicate code
✔ Better function composition
✔ Easy debugging

---------------------------------------------------------
7) Disadvantages
---------------------------------------------------------

✔ Difficult for beginners
✔ Nested functions
✔ Complex syntax sometimes

=========================================================
                NORMAL FUNCTION
=========================================================
*/

console.log("================================================");
console.log("             NORMAL FUNCTION                    ");
console.log("================================================");

/*
Normal function
*/

function add(a, b, c)
{
    return a + b + c;
}

console.log(add(10, 20, 30));





/*
=========================================================
                CURRIED FUNCTION
=========================================================
*/

console.log("\n================================================");
console.log("             CURRIED FUNCTION                   ");
console.log("================================================");

/*
Currying version
*/

function curryAdd(a)
{
    return function(b)
    {
        return function(c)
        {
            return a + b + c;
        };
    };
}

console.log(curryAdd(10)(20)(30));

/*
Flow:
---------
curryAdd(10)
returns function(b)

(20)
returns function(c)

(30)
returns result
*/




/*
=========================================================
            HOW CURRYING WORKS
=========================================================
*/

console.log("\n================================================");
console.log("           HOW CURRYING WORKS                   ");
console.log("================================================");

function multiply(a)
{
    return function(b)
    {
        return a * b;
    };
}

/*
Store partially applied function
*/

let double = multiply(2);

console.log(double(5));

console.log(double(10));

/*
Why useful ?
--------------
Same function reused
*/




/*
=========================================================
           REAL WORLD EXAMPLE
=========================================================
*/

console.log("\n================================================");
console.log("            REAL WORLD EXAMPLE                  ");
console.log("================================================");

/*
Tax calculator
*/

function taxCalculator(tax)
{
    return function(amount)
    {
        return amount + (amount * tax);
    };
}

/*
Different reusable functions
*/

let gst18 = taxCalculator(0.18);

let gst5 = taxCalculator(0.05);

console.log(gst18(1000));

console.log(gst5(1000));





/*
=========================================================
            EVENT HANDLER STYLE
=========================================================
*/

console.log("\n================================================");
console.log("          EVENT HANDLER STYLE                   ");
console.log("================================================");

/*
Reusable logger
*/

function logger(type)
{
    return function(message)
    {
        console.log(`[${type}] ${message}`);
    };
}

let errorLogger = logger("ERROR");

let successLogger = logger("SUCCESS");

errorLogger("Login Failed");

successLogger("Payment Successful");





/*
=========================================================
              ARROW FUNCTION CURRYING
=========================================================
*/

console.log("\n================================================");
console.log("         ARROW FUNCTION CURRYING                ");
console.log("================================================");

/*
Modern currying
*/

const subtract = a => b => c => a - b - c;

console.log(subtract(20)(5)(2));





/*
=========================================================
           PARTIAL APPLICATION
=========================================================
*/

console.log("\n================================================");
console.log("          PARTIAL APPLICATION                   ");
console.log("================================================");

/*
Currying helps partial application
*/

function greeting(greet)
{
    return function(name)
    {
        console.log(greet + " " + name);
    };
}

let sayHello = greeting("Hello");

let sayHi = greeting("Hi");

sayHello("Mohit");

sayHi("Rahul");





/*
=========================================================
             CURRYING IN REACT STYLE
=========================================================
*/

console.log("\n================================================");
console.log("          CURRYING IN REACT                     ");
console.log("================================================");

/*
Common React style
*/

function handleClick(buttonName)
{
    return function()
    {
        console.log(buttonName + " clicked");
    };
}

let loginButton = handleClick("Login");

loginButton();





/*
=========================================================
            CURRYING vs NORMAL FUNCTION
=========================================================
*/

console.log("\n================================================");
console.log("       CURRYING vs NORMAL FUNCTION              ");
console.log("================================================");

console.log(`
Normal Function
----------------
add(10,20,30)

✔ Simple
✔ Easy
✔ Multiple arguments together

Curried Function
-----------------
add(10)(20)(30)

✔ Reusable
✔ Functional programming
✔ One argument at a time
`);





/*
=========================================================
            CURRYING BENEFITS
=========================================================
*/

console.log("\n================================================");
console.log("            CURRYING BENEFITS                   ");
console.log("================================================");

console.log(`
✔ Code reusability
✔ Cleaner code
✔ Better abstraction
✔ Reusable partial functions
✔ Functional programming support
✔ Dynamic configuration
`);





/*
=========================================================
              REAL WORLD USE CASES
=========================================================
*/

console.log("\n================================================");
console.log("            REAL WORLD USE CASES                ");
console.log("================================================");

console.log(`
✔ React event handlers
✔ Validation functions
✔ Logger systems
✔ API wrappers
✔ Authentication
✔ Tax calculations
✔ Dynamic configuration
✔ Functional utilities
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
✔ Currying returns another function
✔ One argument processed at a time
✔ Based on closures
✔ Functional programming concept
✔ Helps reusable code
`);





/*
=========================================================
              BEST PRACTICES
=========================================================
*/

console.log("\n================================================");
console.log("             BEST PRACTICES                     ");
console.log("================================================");

console.log(`
✔ Use for reusable logic
✔ Avoid too much nesting
✔ Use arrow functions for cleaner syntax
✔ Use meaningful function names
✔ Combine with closures carefully
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
Function Currying
------------------
Converts:
function(a,b,c)

Into:
function(a)(b)(c)

Main Purpose
--------------
✔ Reusability
✔ Functional programming
✔ Partial application

Most Important Point
---------------------
One argument at a time
using nested functions.
`);

console.log("\n================================================");
console.log("                 PROGRAM END                    ");
console.log("================================================");