/*
=========================================================
                PROMISE IN JAVASCRIPT
=========================================================

---------------------------------------------------------
1) What is Promise ?
---------------------------------------------------------

A Promise is an object representing:
✔ Future success value
OR
✔ Failure reason

Simple Meaning:
"Promise of future result"

---------------------------------------------------------
2) Why Promise Introduced ?
---------------------------------------------------------

Before Promise:
✔ Callback used for async programming

Problem:
❌ Callback Hell
❌ Nested callbacks
❌ Difficult error handling
❌ Hard to read code

Promise solves:
✔ Cleaner async code
✔ Better error handling
✔ Chaining
✔ Readable code

---------------------------------------------------------
3) Before Promise What Was Used ?
---------------------------------------------------------

Before Promise:
✔ Callback functions used

Example:
login(function(){
    getData(function(){
        update(function(){
        });
    });
});

This is called:
"Callback Hell"

---------------------------------------------------------
4) Real World Example
---------------------------------------------------------

Food Delivery App

Promise means:
✔ Food may deliver successfully
OR
✔ Delivery may fail

States:
Pending  -> waiting
Resolved -> success
Rejected -> failed

---------------------------------------------------------
5) Promise States
---------------------------------------------------------

1) Pending
------------
Initial state

2) Fulfilled / Resolved
------------------------
Task completed successfully

3) Rejected
-------------
Task failed

---------------------------------------------------------
6) When To Use Promise ?
---------------------------------------------------------

Use Promise when:
✔ API calls
✔ Database operations
✔ File handling
✔ Timers
✔ Authentication
✔ Payment processing
✔ Async operations

---------------------------------------------------------
7) Advantages of Promise
---------------------------------------------------------

✔ Cleaner code
✔ Better readability
✔ Error handling
✔ Avoid callback hell
✔ Promise chaining
✔ Async programming easier

---------------------------------------------------------
8) Disadvantages of Promise
---------------------------------------------------------

✔ Slightly complex for beginners
✔ Nested promise possible
✔ Memory usage higher

=========================================================
                HOW TO CREATE PROMISE
=========================================================
*/

console.log("================================================");
console.log("            CREATE BASIC PROMISE                ");
console.log("================================================");

/*
Syntax:

new Promise(function(resolve,reject){

});
*/

let promise1 = new Promise(function(resolve, reject)
{
    let success = true;

    if(success)
    {
        resolve("Promise Resolved Successfully");
    }
    else
    {
        reject("Promise Rejected");
    }
});

/*
Consume Promise
*/

promise1
.then(function(result)
{
    console.log(result);
})
.catch(function(error)
{
    console.log(error);
});





/*
=========================================================
             SIMPLE PROMISE EXAMPLE
=========================================================
*/

console.log("\n================================================");
console.log("          SIMPLE PROMISE EXAMPLE                ");
console.log("================================================");

/*
Asynchronous task
*/

let promise2 = new Promise(function(resolve, reject)
{
    setTimeout(function()
    {
        resolve("Data Loaded");

    }, 2000);
});

promise2.then(function(data)
{
    console.log(data);
});





/*
=========================================================
                 PROMISE STATES
=========================================================
*/

console.log("\n================================================");
console.log("              PROMISE STATES                    ");
console.log("================================================");

let promiseState = new Promise(function(resolve, reject)
{
    let paymentSuccess = true;

    if(paymentSuccess)
    {
        resolve("Payment Successful");
    }
    else
    {
        reject("Payment Failed");
    }
});

promiseState
.then(function(message)
{
    console.log(message);
})
.catch(function(error)
{
    console.log(error);
});





/*
=========================================================
                  PROMISE CHAINING
=========================================================
*/

console.log("\n================================================");
console.log("             PROMISE CHAINING                   ");
console.log("================================================");

/*
Multiple then()
*/

let chainPromise = new Promise(function(resolve)
{
    resolve(10);
});

chainPromise

.then(function(value)
{
    console.log(value);

    return value * 2;
})

.then(function(value)
{
    console.log(value);

    return value * 2;
})

.then(function(value)
{
    console.log(value);
});





/*
=========================================================
                PROMISE ERROR HANDLING
=========================================================
*/

console.log("\n================================================");
console.log("             ERROR HANDLING                     ");
console.log("================================================");

let errorPromise = new Promise(function(resolve, reject)
{
    let error = true;

    if(error)
    {
        reject("Server Error");
    }
    else
    {
        resolve("Success");
    }
});

errorPromise

.then(function(result)
{
    console.log(result);
})

.catch(function(error)
{
    console.log("Error:", error);
});





/*
=========================================================
                finally() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("              finally() METHOD                  ");
console.log("================================================");

/*
finally() runs always
*/

let finalPromise = new Promise(function(resolve)
{
    resolve("Task Completed");
});

finalPromise

.then(function(data)
{
    console.log(data);
})

.finally(function()
{
    console.log("Finally Executed");
});





/*
=========================================================
                REAL WORLD API EXAMPLE
=========================================================
*/

console.log("\n================================================");
console.log("             API CALL STYLE                     ");
console.log("================================================");

/*
fetch() returns promise
*/

fetch("https://jsonplaceholder.typicode.com/users")

.then(function(response)
{
    return response.json();
})

.then(function(data)
{
    console.log(data);
})

.catch(function(error)
{
    console.log(error);
});

/*
Very common in React/Node.js
*/




/*
=========================================================
             PROMISE ALL EXAMPLE
=========================================================
*/

console.log("\n================================================");
console.log("              Promise.all()                     ");
console.log("================================================");

/*
Wait for all promises
*/

let p1 = Promise.resolve("First");

let p2 = Promise.resolve("Second");

let p3 = Promise.resolve("Third");

Promise.all([p1, p2, p3])

.then(function(result)
{
    console.log(result);
});

/*
Output:
["First","Second","Third"]
*/




/*
=========================================================
             PROMISE RACE EXAMPLE
=========================================================
*/

console.log("\n================================================");
console.log("              Promise.race()                    ");
console.log("================================================");

/*
First completed promise wins
*/

let race1 = new Promise(function(resolve)
{
    setTimeout(function()
    {
        resolve("Fast");

    }, 1000);
});

let race2 = new Promise(function(resolve)
{
    setTimeout(function()
    {
        resolve("Slow");

    }, 3000);
});

Promise.race([race1, race2])

.then(function(result)
{
    console.log(result);
});





/*
=========================================================
             Promise.allSettled()
=========================================================
*/

console.log("\n================================================");
console.log("          Promise.allSettled()                  ");
console.log("================================================");

/*
Returns all promise results
*/

let promiseA = Promise.resolve("Success");

let promiseB = Promise.reject("Failed");

Promise.allSettled([promiseA, promiseB])

.then(function(result)
{
    console.log(result);
});





/*
=========================================================
                Promise.any()
=========================================================
*/

console.log("\n================================================");
console.log("              Promise.any()                     ");
console.log("================================================");

/*
First successful promise
*/

let any1 = Promise.reject("Error");

let any2 = Promise.resolve("Success");

Promise.any([any1, any2])

.then(function(result)
{
    console.log(result);
});





/*
=========================================================
                CALLBACK vs PROMISE
=========================================================
*/

console.log("\n================================================");
console.log("          CALLBACK vs PROMISE                   ");
console.log("================================================");

console.log(`
Callback
---------
✔ Old async handling
❌ Callback Hell
❌ Difficult readability

Promise
--------
✔ Cleaner code
✔ Better error handling
✔ Chaining possible
✔ Modern async handling
`);





/*
=========================================================
                TYPES OF IMPLEMENTATION
=========================================================
*/

console.log("\n================================================");
console.log("         TYPES OF IMPLEMENTATION                ");
console.log("================================================");

console.log(`
1) Basic Promise
2) Promise Chaining
3) Promise.all()
4) Promise.race()
5) Promise.any()
6) Promise.allSettled()
7) API Promise
8) Async/Await Promise
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
✔ Login Authentication
✔ API Calls
✔ Database Queries
✔ Payment Gateway
✔ File Upload
✔ Email Sending
✔ Chat Applications
✔ Online Booking
✔ React Applications
✔ Node.js Backend
`);





/*
=========================================================
                IMPORTANT METHODS
=========================================================
*/

console.log("\n================================================");
console.log("             IMPORTANT METHODS                  ");
console.log("================================================");

console.log(`
then()
-------
Handles success

catch()
--------
Handles error

finally()
----------
Runs always

resolve()
----------
Marks success

reject()
---------
Marks failure
`);





/*
=========================================================
                 IMPORTANT NOTES
=========================================================
*/

console.log("\n================================================");
console.log("              IMPORTANT NOTES                   ");
console.log("================================================");

console.log(`
✔ Promise handles asynchronous operations
✔ Promise returns future value
✔ Promise has 3 states
✔ Promise avoids callback hell
✔ Promise widely used in React & Node.js
✔ fetch() returns promise
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
Promise
--------
Object representing future success or failure.

Before Promise
---------------
Callbacks used.

Main Purpose
-------------
✔ Async programming
✔ Avoid callback hell
✔ Better readability

Most Important Methods
-----------------------
✔ then()
✔ catch()
✔ finally()

Common Uses
------------
✔ API calls
✔ Database queries
✔ Authentication
✔ Timers
✔ File handling
`);

console.log("\n================================================");
console.log("                 PROGRAM END                    ");
console.log("================================================");