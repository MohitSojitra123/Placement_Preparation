/*
=========================================================
                CLOSURE IN JAVASCRIPT
=========================================================

---------------------------------------------------------
1) What is Closure ?
---------------------------------------------------------

A closure is created when:
✔ An inner function remembers variables
✔ From its outer function
✔ Even after outer function execution completed

Simple Meaning:
"Inner function remembers outer function variables"

---------------------------------------------------------
2) Definition of Closure
---------------------------------------------------------

Closure is a function that has access to:
✔ Its own scope
✔ Outer function scope
✔ Global scope

Even after outer function is finished.

---------------------------------------------------------
3) Why Closure is Needed ?
---------------------------------------------------------

✔ Data hiding
✔ Private variables
✔ Function factory
✔ State management
✔ Memory preservation
✔ Callbacks
✔ Event handling

---------------------------------------------------------
4) When To Use Closure ?
---------------------------------------------------------

Use closure when:
✔ Need private data
✔ Need persistent variables
✔ Need state management
✔ Need reusable functions
✔ Timers/callbacks
✔ React hooks
✔ Module pattern

---------------------------------------------------------
5) Real World Example
---------------------------------------------------------

Bank Account Example

Balance variable should not be directly accessible
from outside.

Closure helps:
✔ Keep balance private
✔ Allow access only through functions

---------------------------------------------------------
6) Important Point
---------------------------------------------------------

Inner function remembers outer variables
even after outer function execution completed.

---------------------------------------------------------
7) Advantages of Closure
---------------------------------------------------------

✔ Data privacy
✔ Data persistence
✔ Memory efficient
✔ Cleaner code
✔ Encapsulation
✔ Better state handling

---------------------------------------------------------
8) Disadvantages of Closure
---------------------------------------------------------

✔ More memory usage
✔ Difficult debugging
✔ Can create memory leaks
✔ Complex for beginners

---------------------------------------------------------
9) Types / Common Uses of Closure
---------------------------------------------------------

1) Basic Closure
2) Data Hiding Closure
3) Function Factory Closure
4) Counter Closure
5) Callback Closure
6) Module Pattern Closure

=========================================================
                BASIC CLOSURE EXAMPLE
=========================================================
*/

console.log("================================================");
console.log("            BASIC CLOSURE EXAMPLE               ");
console.log("================================================");

function outerFunction()
{
    let outerVariable = "I am Outer Variable";

    function innerFunction()
    {
        console.log(outerVariable);
    }

    return innerFunction;
}

/*
outerFunction execution completed
But innerFunction still remembers outerVariable
*/

let result = outerFunction();

result();





/*
=========================================================
          HOW CLOSURE WORKS STEP BY STEP
=========================================================
*/

console.log("\n================================================");
console.log("        HOW CLOSURE WORKS                       ");
console.log("================================================");

/*
Step 1:
Outer function executes

Step 2:
Inner function created

Step 3:
Inner function remembers outer variables

Step 4:
Outer function finishes

Step 5:
Inner function still accesses outer variables
*/

function parent()
{
    let name = "Mohit";

    return function ()
    {
        console.log(name);
    };
}

let child = parent();

child();





/*
=========================================================
              DATA HIDING USING CLOSURE
=========================================================
*/

console.log("\n================================================");
console.log("          DATA HIDING EXAMPLE                   ");
console.log("================================================");

/*
Private variable example
*/

function bankAccount()
{
    let balance = 1000;

    return {

        deposit: function(amount)
        {
            balance += amount;

            console.log("Updated Balance:", balance);
        },

        withdraw: function(amount)
        {
            balance -= amount;

            console.log("Remaining Balance:", balance);
        },

        checkBalance: function()
        {
            console.log("Current Balance:", balance);
        }
    };
}

let account = bankAccount();

account.checkBalance();

account.deposit(500);

account.withdraw(200);

/*
Cannot access directly
*/

console.log(account.balance);





/*
=========================================================
                COUNTER USING CLOSURE
=========================================================
*/

console.log("\n================================================");
console.log("            COUNTER EXAMPLE                     ");
console.log("================================================");

/*
Counter variable persists
*/

function counter()
{
    let count = 0;

    return function ()
    {
        count++;

        console.log("Count:", count);
    };
}

let increment = counter();

increment();
increment();
increment();





/*
=========================================================
             FUNCTION FACTORY CLOSURE
=========================================================
*/

console.log("\n================================================");
console.log("          FUNCTION FACTORY                      ");
console.log("================================================");

/*
Create reusable customized functions
*/

function multiply(x)
{
    return function(y)
    {
        return x * y;
    };
}

let double = multiply(2);

let triple = multiply(3);

console.log(double(5));

console.log(triple(5));





/*
=========================================================
                CALLBACK CLOSURE
=========================================================
*/

console.log("\n================================================");
console.log("           CALLBACK CLOSURE                     ");
console.log("================================================");

/*
setTimeout remembers variable using closure
*/

function message()
{
    let text = "Hello JavaScript";

    setTimeout(function ()
    {
        console.log(text);

    }, 2000);
}

message();





/*
=========================================================
               LOOP + CLOSURE ISSUE
=========================================================
*/

console.log("\n================================================");
console.log("           LOOP CLOSURE PROBLEM                 ");
console.log("================================================");

/*
Using var creates issue
*/

for(var i = 1; i <= 3; i++)
{
    setTimeout(function ()
    {
        console.log(i);

    }, 1000);
}

/*
Output:
4
4
4

Because:
All callbacks share same i variable
*/




console.log("\n================================================");
console.log("         LOOP CLOSURE SOLUTION                  ");
console.log("================================================");

/*
Using let creates separate scope
*/

for(let j = 1; j <= 3; j++)
{
    setTimeout(function ()
    {
        console.log(j);

    }, 1000);
}

/*
Output:
1
2
3
*/




/*
=========================================================
             MODULE PATTERN USING CLOSURE
=========================================================
*/

console.log("\n================================================");
console.log("            MODULE PATTERN                      ");
console.log("================================================");

/*
Private/public methods
*/

function userModule()
{
    let username = "Admin";

    function privateMethod()
    {
        console.log("Private Method");
    }

    return {

        publicMethod: function ()
        {
            console.log(username);

            privateMethod();
        }
    };
}

let user = userModule();

user.publicMethod();





/*
=========================================================
                CLOSURE IN REAL WORLD
=========================================================
*/

console.log("\n================================================");
console.log("            REAL WORLD USES                     ");
console.log("================================================");

console.log(`
✔ React Hooks
✔ Event Handlers
✔ Timers
✔ API callbacks
✔ Data privacy
✔ Authentication
✔ State management
✔ Function currying
✔ Module pattern
`);





/*
=========================================================
              ADVANTAGES OF CLOSURE
=========================================================
*/

console.log("\n================================================");
console.log("          ADVANTAGES OF CLOSURE                 ");
console.log("================================================");

console.log(`
1) Data Hiding
2) Private Variables
3) State Persistence
4) Better Encapsulation
5) Memory Optimization
6) Function Reusability
`);





/*
=========================================================
            DISADVANTAGES OF CLOSURE
=========================================================
*/

console.log("\n================================================");
console.log("        DISADVANTAGES OF CLOSURE                ");
console.log("================================================");

console.log(`
1) High memory usage
2) Difficult debugging
3) Memory leaks possible
4) Complex understanding
`);





/*
=========================================================
            CLOSURE vs NORMAL FUNCTION
=========================================================
*/

console.log("\n================================================");
console.log("        CLOSURE vs NORMAL FUNCTION              ");
console.log("================================================");

console.log(`
Normal Function
----------------
Does not remember old scope after execution.

Closure
--------
Remembers outer variables after execution completed.
`);





/*
=========================================================
                 IMPORTANT NOTES
=========================================================
*/

console.log("\n================================================");
console.log("             IMPORTANT NOTES                    ");
console.log("================================================");

console.log(`
✔ Closure created automatically
✔ Inner function remembers outer variables
✔ Used heavily in async JavaScript
✔ Helps create private variables
✔ Base of many advanced JS concepts
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
Closure
--------
Function remembering outer variables
after outer function execution completed.

Main Uses
----------
✔ Data privacy
✔ State management
✔ Callbacks
✔ Timers
✔ Function factory

Most Important Feature
----------------------
Inner function remembers outer scope.
`);

console.log("\n================================================");
console.log("                 PROGRAM END                    ");
console.log("================================================");