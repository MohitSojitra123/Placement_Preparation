/*
=========================================================
                 CALLBACK IN JAVASCRIPT
=========================================================

---------------------------------------------------------
1) What is Callback in JavaScript ?
---------------------------------------------------------

A callback is a function passed as an argument
to another function.

The callback function is executed later after
some task is completed.

Simple Meaning:
"Call this function back later"

---------------------------------------------------------
2) Why Callback is Needed ?
---------------------------------------------------------

JavaScript is single-threaded and asynchronous.

Some operations take time:
- API calls
- Database query
- File reading
- Timer
- User events

Without callback, JavaScript would stop execution
and wait for the task to complete.

Callbacks help JavaScript:
✔ Perform tasks asynchronously
✔ Avoid blocking code execution
✔ Run function after task completion

---------------------------------------------------------
3) When To Use Callback ?
---------------------------------------------------------

Use callback when:
✔ One task depends on another task
✔ Asynchronous operation exists
✔ Need result after task completion
✔ Handling events
✔ Timers
✔ API requests
✔ Database operations

---------------------------------------------------------
4) Real World Example
---------------------------------------------------------

Example:
Food Order

1) Customer orders food
2) Restaurant prepares food
3) After food ready -> customer gets notification

The notification function is callback.

---------------------------------------------------------
5) Syntax of Callback
---------------------------------------------------------

function mainFunction(callbackFunction)
{
      callbackFunction();
}

---------------------------------------------------------
6) Important Points
---------------------------------------------------------

✔ Function can be passed like variable
✔ Callback runs later
✔ Used heavily in Node.js
✔ Base of async programming
✔ setTimeout() uses callback

---------------------------------------------------------
7) Types of Callback
---------------------------------------------------------

1) Synchronous Callback
   - Executes immediately

2) Asynchronous Callback
   - Executes later

---------------------------------------------------------
8) Problems with Callback
---------------------------------------------------------

Too many nested callbacks create:
"Callback Hell"

Example:
login(function(){
    getData(function(){
        update(function(){
        });
    });
});

This becomes difficult to read.

Because of this:
- Promise introduced
- Async/Await introduced

=========================================================
                CALLBACK EXAMPLES
=========================================================
*/





console.log("================================================");
console.log("         Example 1 : Basic Callback             ");
console.log("================================================");

/*
Function passed inside another function
*/

function greet(name)
{
    console.log("Hello " + name);
}

function processUser(callback)
{
    let username = "Mohit";

    callback(username);
}

/*
greet function passed as callback
*/

processUser(greet);





console.log("\n================================================");
console.log("     Example 2 : Synchronous Callback           ");
console.log("================================================");

/*
Callback executes immediately
*/

function add(a, b)
{
    return a + b;
}

function display(result)
{
    console.log("Result is:", result);
}

function calculate(num1, num2, callback)
{
    let sum = add(num1, num2);

    callback(sum);
}

calculate(10, 20, display);





console.log("\n================================================");
console.log("     Example 3 : Asynchronous Callback          ");
console.log("================================================");

/*
setTimeout() is asynchronous

Callback runs after 3 seconds
*/

console.log("Program Started");

setTimeout(function ()
{
    console.log("This message appears after 3 seconds");
}, 3000);

console.log("Program Ended");

/*
Output Flow:
1) Program Started
2) Program Ended
3) This message appears after 3 seconds
*/




console.log("\n================================================");
console.log("       Example 4 : Callback with Array          ");
console.log("================================================");

/*
Array forEach() uses callback internally
*/

let numbers = [10, 20, 30, 40];

numbers.forEach(function(value, index)
{
    console.log("Index:", index, "Value:", value);
});





console.log("\n================================================");
console.log("       Example 5 : Custom Callback              ");
console.log("================================================");

/*
Order Food Example
*/

function prepareFood(callback)
{
    console.log("Food preparation started...");

    setTimeout(function ()
    {
        console.log("Food is Ready");

        callback();
    }, 2000);
}

function notifyCustomer()
{
    console.log("Notify Customer: Your food is ready");
}

prepareFood(notifyCustomer);





console.log("\n================================================");
console.log("       Example 6 : Callback with Error          ");
console.log("================================================");

/*
Node.js style callback

(error, result)
*/

function divide(a, b, callback)
{
    if (b === 0)
    {
        callback("Cannot divide by zero", null);
    }
    else
    {
        callback(null, a / b);
    }
}

divide(10, 2, function(error, result)
{
    if (error)
    {
        console.log("Error:", error);
    }
    else
    {
        console.log("Division Result:", result);
    }
});





console.log("\n================================================");
console.log("          Example 7 : Callback Hell             ");
console.log("================================================");

/*
Nested callback problem
*/

setTimeout(function ()
{
    console.log("Step 1 Completed");

    setTimeout(function ()
    {
        console.log("Step 2 Completed");

        setTimeout(function ()
        {
            console.log("Step 3 Completed");

        }, 1000);

    }, 1000);

}, 1000);

/*
This structure becomes difficult to manage
This is called "Callback Hell"
*/




console.log("\n================================================");
console.log("     Example 8 : Callback Used in Events        ");
console.log("================================================");

/*
Button click example

button.addEventListener("click", function(){
      console.log("Button Clicked");
});

The function passed inside addEventListener()
is callback function.
*/

console.log("DOM event callbacks are used in browser");





console.log("\n================================================");
console.log("      Callback vs Normal Function               ");
console.log("================================================");

console.log(`
Normal Function
---------------
Function called directly

example:
greet();

Callback Function
-----------------
Function passed inside another function

example:
processUser(greet);
`);





console.log("\n================================================");
console.log("          Advantages of Callback                ");
console.log("================================================");

console.log(`
1) Handles asynchronous tasks
2) Non-blocking execution
3) Better performance
4) Used in events and APIs
5) Important in Node.js
`);





console.log("\n================================================");
console.log("        Disadvantages of Callback               ");
console.log("================================================");

console.log(`
1) Callback Hell
2) Difficult debugging
3) Nested code
4) Hard to maintain
5) Complex error handling
`);





console.log("\n================================================");
console.log("      Modern Alternatives of Callback           ");
console.log("================================================");

console.log(`
1) Promise
2) Async/Await

These solve callback hell problem
`);





console.log("\n================================================");
console.log("                FINAL SUMMARY                   ");
console.log("================================================");

console.log(`
Callback
--------
A function passed into another function
to execute later.

Need
----
Used for asynchronous programming.

Common Uses
-----------
✔ setTimeout()
✔ Events
✔ API Calls
✔ Database Queries
✔ File Handling

Important
---------
JavaScript runs tasks asynchronously using callbacks.
`);

console.log("\n================================================");
console.log("                 PROGRAM END                    ");
console.log("================================================");