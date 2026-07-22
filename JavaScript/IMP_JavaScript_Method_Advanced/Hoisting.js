/*
=========================================================
                HOISTING IN JAVASCRIPT
=========================================================

---------------------------------------------------------
1) What is Hoisting ?
---------------------------------------------------------

Hoisting is JavaScript behavior where:
✔ Variable declarations
✔ Function declarations

are moved to the TOP of their scope
before code execution.

Simple Meaning:
"JavaScript moves declarations upward"

---------------------------------------------------------
2) Important Point
---------------------------------------------------------

Only declaration is hoisted
NOT initialization

Example:

var x;        // hoisted
x = 10;       // not hoisted

---------------------------------------------------------
3) Why Hoisting Happens ?
---------------------------------------------------------

Before executing code:
✔ JavaScript creates memory
✔ Stores variables/functions

This phase is called:
"Memory Creation Phase"

---------------------------------------------------------
4) Hoisting Works With
---------------------------------------------------------

✔ var
✔ function declaration

Partially works with:
✔ let
✔ const

Does NOT properly work with:
✔ Function expression
✔ Arrow function

---------------------------------------------------------
5) When To Use Hoisting ?
---------------------------------------------------------

Normally:
❌ Do NOT depend heavily on hoisting

But understanding hoisting helps:
✔ Debugging
✔ Interview questions
✔ Understanding execution flow
✔ Avoiding errors

---------------------------------------------------------
6) Advantages of Hoisting
---------------------------------------------------------

✔ Function usable before declaration
✔ Flexible code writing
✔ Better understanding of JS engine

---------------------------------------------------------
7) Disadvantages of Hoisting
---------------------------------------------------------

✔ Confusing for beginners
✔ Unexpected bugs
✔ Undefined errors
✔ Temporal Dead Zone issues

---------------------------------------------------------
8) How To Avoid Hoisting Problems ?
---------------------------------------------------------

✔ Declare variables at top
✔ Use let/const
✔ Avoid var
✔ Declare before use
✔ Use proper function order

=========================================================
            MEMORY CREATION PHASE
=========================================================

JavaScript Execution Has 2 Phases:

1) Memory Creation Phase
-------------------------
✔ Variables stored
✔ Functions stored

2) Execution Phase
-------------------
✔ Code executes line by line

=========================================================
            FUNCTION DECLARATION HOISTING
=========================================================
*/

console.log("================================================");
console.log("       FUNCTION DECLARATION HOISTING            ");
console.log("================================================");

/*
Function declaration fully hoisted
*/

hello();

function hello()
{
    console.log("Working...");
}

/*
Why works ?
------------
Function declaration stored completely
during memory creation phase.
*/




/*
=========================================================
              HOW JS INTERNALLY SEES IT
=========================================================
*/

/*
JavaScript internally treats it like:

function hello()
{
    console.log("Working...");
}

hello();

*/

console.log("\n================================================");
console.log("        FUNCTION DECLARATION WORKS              ");
console.log("================================================");

function greet()
{
    console.log("Hello JavaScript");
}

greet();





/*
=========================================================
              VAR HOISTING EXAMPLE
=========================================================
*/

console.log("\n================================================");
console.log("               VAR HOISTING                     ");
console.log("================================================");

/*
var declaration hoisted
Initialization NOT hoisted
*/

console.log(a);

var a = 10;

/*
Internally:

var a;
console.log(a);
a = 10;

Output:
undefined
*/




/*
=========================================================
             let and const HOISTING
=========================================================
*/

console.log("\n================================================");
console.log("           let/const HOISTING                   ");
console.log("================================================");

/*
let and const are hoisted
BUT

stored inside:
Temporal Dead Zone (TDZ)

Access before declaration causes error
*/

/*
console.log(b);

let b = 20;
*/

/*
Output:
ReferenceError
*/

console.log("let/const cannot access before declaration");





/*
=========================================================
             ARROW FUNCTION HOISTING
=========================================================
*/

console.log("\n================================================");
console.log("          ARROW FUNCTION HOISTING               ");
console.log("================================================");

/*
Your Example
*/

try
{
    hello1();

}
catch(error)
{
    console.log(error.message);
}

/*
Arrow function stored in variable

Only variable declaration hoisted
NOT function initialization
*/

let hello1 = () =>
{
    console.log("Working...");
};

hello1();

/*
Why error ?
-------------
During hoisting:

let hello1 exists
BUT not initialized yet

This creates:
ReferenceError
*/




/*
=========================================================
         FUNCTION EXPRESSION HOISTING
=========================================================
*/

console.log("\n================================================");
console.log("        FUNCTION EXPRESSION HOISTING            ");
console.log("================================================");

/*
Your Example
*/

try
{
    hello2();

}
catch(error)
{
    console.log(error.message);
}

/*
Function expression
*/

let hello2 = function()
{
    console.log("Working Properly...");
};

hello2();

/*
Why error ?
-------------
Function assigned to variable

Variable hoisted
Initialization not hoisted
*/




/*
=========================================================
          DIFFERENT TYPES OF FUNCTIONS
=========================================================
*/

console.log("\n================================================");
console.log("            FUNCTION TYPES                      ");
console.log("================================================");

console.log(`
1) Function Declaration
------------------------
Fully hoisted

2) Function Expression
-----------------------
Not fully hoisted

3) Arrow Function
------------------
Not fully hoisted
`);





/*
=========================================================
           FUNCTION DECLARATION EXAMPLE
=========================================================
*/

console.log("\n================================================");
console.log("         FUNCTION DECLARATION                   ");
console.log("================================================");

/*
Works before declaration
*/

sayHello();

function sayHello()
{
    console.log("Hello");
}





/*
=========================================================
          FUNCTION EXPRESSION EXAMPLE
=========================================================
*/

console.log("\n================================================");
console.log("         FUNCTION EXPRESSION                    ");
console.log("================================================");

/*
Error before declaration
*/

try
{
    test();

}
catch(error)
{
    console.log(error.message);
}

var test = function()
{
    console.log("Test");
};

/*
Output:
test is not a function

Because:
var hoisted as undefined
*/




/*
=========================================================
            TEMPORAL DEAD ZONE (TDZ)
=========================================================
*/

console.log("\n================================================");
console.log("          TEMPORAL DEAD ZONE                    ");
console.log("================================================");

/*
TDZ:
Time between variable hoisting
and initialization
*/

console.log(`
TDZ occurs with:
✔ let
✔ const

Cannot access variable before initialization
`);





/*
=========================================================
             REAL WORLD PROBLEMS
=========================================================
*/

console.log("\n================================================");
console.log("           REAL WORLD PROBLEMS                  ");
console.log("================================================");

console.log(`
Problems due to hoisting:
--------------------------
✔ Undefined values
✔ ReferenceError
✔ Bugs
✔ Difficult debugging
✔ Unexpected behavior
`);





/*
=========================================================
             HOW TO AVOID HOISTING ISSUES
=========================================================
*/

console.log("\n================================================");
console.log("         HOW TO AVOID ISSUES                    ");
console.log("================================================");

console.log(`
1) Use let and const
2) Avoid var
3) Declare before use
4) Write functions before calling
5) Use proper code structure
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
✔ Prefer const
✔ Use let when needed
✔ Avoid var
✔ Declare variables first
✔ Keep functions above usage
✔ Avoid relying on hoisting
`);





/*
=========================================================
             HOISTING DIFFERENCE TABLE
=========================================================
*/

console.log("\n================================================");
console.log("            HOISTING DIFFERENCE                 ");
console.log("================================================");

console.log(`
Function Declaration
---------------------
✔ Fully hoisted

var
----
✔ Hoisted
✔ Initialized as undefined

let
----
✔ Hoisted
❌ Cannot access before declaration

const
------
✔ Hoisted
❌ Cannot access before declaration

Arrow Function
---------------
❌ Not fully hoisted

Function Expression
-------------------
❌ Not fully hoisted
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
Hoisting
---------
JavaScript moves declarations to top
before execution.

Most Important Point
---------------------
Only declarations hoisted
NOT initialization.

Best Practice
--------------
✔ Use let/const
✔ Declare before use
✔ Avoid var
✔ Do not depend on hoisting
`);

console.log("\n================================================");
console.log("                 PROGRAM END                    ");
console.log("================================================");