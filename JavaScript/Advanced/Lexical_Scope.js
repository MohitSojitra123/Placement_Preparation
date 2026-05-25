/*
=========================================================
            LEXICAL SCOPE IN JAVASCRIPT
=========================================================

---------------------------------------------------------
1) What is Scope ?
---------------------------------------------------------

Scope means:
"Where variables can be accessed in program"

Simple Meaning:
Area where variable is available.

---------------------------------------------------------
2) What is Lexical Scope ?
---------------------------------------------------------

Lexical Scope means:
Inner function can access variables
from its parent/outer function.

JavaScript determines scope
during code writing time
(not runtime).

Simple Meaning:
"Child function can access parent variables"

---------------------------------------------------------
3) Why Called Lexical Scope ?
---------------------------------------------------------

"Lexical" means:
Based on code structure/location.

Scope depends on:
✔ Where function is written
NOT
✔ Where function is called

---------------------------------------------------------
4) Main Rule of Lexical Scope
---------------------------------------------------------

Inner function can access:
✔ Its own variables
✔ Parent function variables
✔ Global variables

Outer function CANNOT access:
❌ Inner function variables

---------------------------------------------------------
5) Why Lexical Scope is Important ?
---------------------------------------------------------

✔ Base of Closure
✔ Variable security
✔ Organized code
✔ Avoid variable conflicts
✔ Helps memory management

---------------------------------------------------------
6) When To Use Lexical Scope ?
---------------------------------------------------------

✔ Nested functions
✔ Closures
✔ Callbacks
✔ Data hiding
✔ State management
✔ React hooks
✔ Module pattern

---------------------------------------------------------
7) Advantages
---------------------------------------------------------

✔ Cleaner code
✔ Better variable management
✔ Data security
✔ Avoid global pollution
✔ Closure support

---------------------------------------------------------
8) Disadvantages
---------------------------------------------------------

✔ Complex nested code
✔ Difficult debugging sometimes
✔ Memory usage in closures

=========================================================
                GLOBAL SCOPE
=========================================================
*/

console.log("================================================");
console.log("               GLOBAL SCOPE                     ");
console.log("================================================");

/*
Global variable
Accessible everywhere
*/

let globalVariable = "I am Global";

function displayGlobal()
{
    console.log(globalVariable);
}

displayGlobal();





/*
=========================================================
               FUNCTION SCOPE
=========================================================
*/

console.log("\n================================================");
console.log("              FUNCTION SCOPE                    ");
console.log("================================================");

/*
Variable accessible only inside function
*/

function test()
{
    let message = "Inside Function";

    console.log(message);
}

test();

/*
Cannot access outside
*/

/*
console.log(message);
*/




/*
=========================================================
              LEXICAL SCOPE EXAMPLE
=========================================================
*/

console.log("\n================================================");
console.log("            LEXICAL SCOPE EXAMPLE               ");
console.log("================================================");

/*
Inner function accessing outer variable
*/

function outerFunction()
{
    let outerVariable = "Outer Variable";

    function innerFunction()
    {
        console.log(outerVariable);
    }

    innerFunction();
}

outerFunction();

/*
Why works ?
-------------
Because inner function has access
to outer function variables.
*/




/*
=========================================================
           MULTI LEVEL LEXICAL SCOPE
=========================================================
*/

console.log("\n================================================");
console.log("         MULTI LEVEL LEXICAL SCOPE              ");
console.log("================================================");

let globalData = "Global";

function first()
{
    let firstData = "First";

    function second()
    {
        let secondData = "Second";

        function third()
        {
            console.log(globalData);

            console.log(firstData);

            console.log(secondData);
        }

        third();
    }

    second();
}

first();

/*
third() can access:
✔ globalData
✔ firstData
✔ secondData
*/




/*
=========================================================
          OUTER FUNCTION CANNOT ACCESS INNER
=========================================================
*/

console.log("\n================================================");
console.log("        OUTER CANNOT ACCESS INNER               ");
console.log("================================================");

function parent()
{
    let parentData = "Parent";

    function child()
    {
        let childData = "Child";

        console.log(parentData);
    }

    child();

    /*
    Error if uncomment
    */

    // console.log(childData);
}

parent();

/*
Why error ?
-------------
Outer function cannot access
inner function variables.
*/




/*
=========================================================
            LEXICAL SCOPE WITH VARIABLES
=========================================================
*/

console.log("\n================================================");
console.log("        VARIABLE SEARCHING FLOW                 ");
console.log("================================================");

/*
JavaScript searches variables:
1) Current scope
2) Parent scope
3) Global scope
*/

let username = "Global User";

function login()
{
    let username = "Local User";

    function display()
    {
        console.log(username);
    }

    display();
}

login();

/*
Output:
Local User

Nearest variable gets priority
*/




/*
=========================================================
           LEXICAL SCOPE + CLOSURE
=========================================================
*/

console.log("\n================================================");
console.log("          LEXICAL SCOPE + CLOSURE               ");
console.log("================================================");

/*
Closure based on lexical scope
*/

function counter()
{
    let count = 0;

    return function ()
    {
        count++;

        console.log(count);
    };
}

let increment = counter();

increment();

increment();

increment();

/*
Inner function remembers lexical scope
*/




/*
=========================================================
             CALLBACK + LEXICAL SCOPE
=========================================================
*/

console.log("\n================================================");
console.log("         CALLBACK + LEXICAL SCOPE               ");
console.log("================================================");

/*
setTimeout remembers variable
*/

function message()
{
    let text = "Hello JavaScript";

    setTimeout(function ()
    {
        console.log(text);

    }, 1000);
}

message();





/*
=========================================================
             BLOCK SCOPE EXAMPLE
=========================================================
*/

console.log("\n================================================");
console.log("             BLOCK SCOPE                        ");
console.log("================================================");

/*
let and const have block scope
*/

{
    let age = 22;

    console.log(age);
}

/*
Cannot access outside block
*/

/*
console.log(age);
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
✔ Closures
✔ React Hooks
✔ Event Handlers
✔ Module Pattern
✔ Authentication
✔ State Management
✔ Private Variables
✔ Callback Functions
✔ API Handling
`);





/*
=========================================================
          LEXICAL SCOPE vs DYNAMIC SCOPE
=========================================================
*/

console.log("\n================================================");
console.log("     LEXICAL SCOPE vs DYNAMIC SCOPE             ");
console.log("================================================");

console.log(`
Lexical Scope
--------------
✔ Based on code position
✔ JavaScript uses lexical scope

Dynamic Scope
--------------
✔ Based on function calling position
✔ JavaScript does NOT use this
`);





/*
=========================================================
                IMPORTANT RULES
=========================================================
*/

console.log("\n================================================");
console.log("             IMPORTANT RULES                    ");
console.log("================================================");

console.log(`
✔ Child can access parent variables
✔ Parent cannot access child variables
✔ Scope decided during writing code
✔ Closures depend on lexical scope
✔ Inner functions remember outer scope
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
✔ Avoid too much nesting
✔ Use let/const
✔ Keep scope small
✔ Avoid global variables
✔ Use closures carefully
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
Lexical Scope
--------------
Inner function can access
outer function variables.

Most Important Point
---------------------
Scope depends on where function
is written.

Main Uses
-----------
✔ Closures
✔ Callbacks
✔ State management
✔ Data hiding

Rule
------
Child accesses parent
Parent cannot access child
`);

console.log("\n================================================");
console.log("                 PROGRAM END                    ");
console.log("================================================");