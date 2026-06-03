/*
=========================================================
      SYNCHRONOUS & ASYNCHRONOUS PROGRAMMING IN JS
=========================================================

---------------------------------------------------------
1) What Type Of Language Is JavaScript?
---------------------------------------------------------

JavaScript is:

✔ Single Threaded
✔ Synchronous by Default
✔ Non-Blocking Language

Meaning:
JavaScript executes one task at a time
using a single call stack.

However,

JavaScript can perform asynchronous tasks
using:

✔ Callbacks
✔ Promises
✔ Async/Await
✔ Event Loop
✔ Web APIs (Browser)
✔ Node APIs (Node.js)

---------------------------------------------------------
2) What is Synchronous Programming?
---------------------------------------------------------

Synchronous Programming means:

One task executes at a time.

The next statement waits until
the current statement finishes.

Simple Meaning:

"Wait and Execute"

Flow:

Task 1 → Complete
Task 2 → Complete
Task 3 → Complete

---------------------------------------------------------
3) Real World Example of Synchronous
---------------------------------------------------------

Bank Counter

Customer 1
     ↓
Customer 2 waits
     ↓
Customer 3 waits

Until previous customer finishes.

Same concept in programming.

---------------------------------------------------------
4) Synchronous Example
---------------------------------------------------------
*/

console.log("Start");

console.log("Processing Payment");

console.log("Payment Completed");

console.log("End");

/*
Output:

Start
Processing Payment
Payment Completed
End

Each line waits for previous line.
*/

/*
=========================================================
      BLOCKING NATURE OF SYNCHRONOUS PROGRAMMING
=========================================================
*/

console.log("\nSynchronous Blocking Example");

console.log("Task Started");

for(let i = 0; i < 1000000000; i++)
{
    // Heavy processing
}

console.log("Task Finished");

/*
Problem:

The loop blocks execution.

Nothing else can execute until
the loop completes.

This is called:

✔ Blocking Execution
*/

/*
=========================================================
          WHAT IS ASYNCHRONOUS PROGRAMMING?
=========================================================

Asynchronous Programming means:

JavaScript starts a task and moves
to the next task without waiting.

Simple Meaning:

"Start and Continue"

Flow:

Task 1 Start
Task 2 Execute
Task 3 Execute
Task 1 Finish Later

---------------------------------------------------------
5) Real World Example of Asynchronous
---------------------------------------------------------

Food Delivery App

Order Pizza
      ↓
Continue Watching Movie
      ↓
Pizza Arrives Later

You don't wait near the kitchen.

Same concept in JavaScript.
*/

/*
=========================================================
         BASIC ASYNCHRONOUS EXAMPLE
=========================================================
*/

console.log("\nAsynchronous Example");

console.log("Start");

setTimeout(function()
{
    console.log("Data Loaded");
}, 3000);

console.log("End");

/*
Output:

Start
End
Data Loaded

Why?

setTimeout runs in background.
JavaScript continues execution.
*/

/*
=========================================================
        HOW ASYNCHRONOUS WORKS INTERNALLY
=========================================================

JavaScript Components:

1) Call Stack
2) Web APIs
3) Callback Queue
4) Event Loop

Flow:

setTimeout()
      ↓
Web API
      ↓
Timer Complete
      ↓
Callback Queue
      ↓
Event Loop
      ↓
Call Stack
      ↓
Execute Callback

This is how asynchronous programming works.
*/

/*
=========================================================
            SYNCHRONOUS REAL PROJECT EXAMPLE
=========================================================
*/

function makeTea()
{
    console.log("Making Tea...");
}

function drinkTea()
{
    console.log("Drinking Tea...");
}

makeTea();
drinkTea();

/*
Output:

Making Tea...
Drinking Tea...

drinkTea() waits for makeTea().
*/

/*
=========================================================
           ASYNCHRONOUS REAL PROJECT EXAMPLE
=========================================================
*/

function orderFood()
{
    setTimeout(function()
    {
        console.log("Food Delivered");
    }, 5000);
}

console.log("Food Ordered");

orderFood();

console.log("Watching Movie");

/*
Output:

Food Ordered
Watching Movie
Food Delivered

Food preparation happens later.
*/

/*
=========================================================
          WHY ASYNCHRONOUS PROGRAMMING NEEDED?
=========================================================

Imagine:

User clicks Login Button.

Server response takes 5 seconds.

Without async:

Application freezes.

With async:

✔ User can continue working
✔ UI remains responsive
✔ Better performance

Used in:

✔ API Calls
✔ Database Queries
✔ File Uploads
✔ Authentication
✔ Payment Gateway
✔ Chat Applications
*/

/*
=========================================================
               CALLBACK EXAMPLE
=========================================================
*/

function fetchUser(callback)
{
    setTimeout(function()
    {
        callback("User Data Loaded");
    }, 2000);
}

fetchUser(function(data)
{
    console.log(data);
});

/*
Old asynchronous technique.
*/

/*
=========================================================
                PROMISE EXAMPLE
=========================================================
*/

let promise = new Promise(function(resolve)
{
    setTimeout(function()
    {
        resolve("Data Received");
    }, 2000);
});

promise.then(function(result)
{
    console.log(result);
});

/*
Modern asynchronous technique.
*/

/*
=========================================================
              ASYNC/AWAIT EXAMPLE
=========================================================
*/

async function getData()
{
    let result = await new Promise(function(resolve)
    {
        setTimeout(function()
        {
            resolve("Async Await Data");
        }, 2000);
    });

    console.log(result);
}

getData();

/*
Most readable asynchronous approach.
*/

/*
=========================================================
         SYNCHRONOUS vs ASYNCHRONOUS
=========================================================

SYNCHRONOUS
------------------------------------------------
✔ One task at a time
✔ Blocking
✔ Easy debugging
✔ Simple code
✔ Slower for long tasks

ASYNCHRONOUS
------------------------------------------------
✔ Non-blocking
✔ Better performance
✔ Faster applications
✔ Background execution
✔ More complex
*/

/*
=========================================================
                ADVANTAGES
=========================================================

SYNCHRONOUS ADVANTAGES
------------------------------------------------
✔ Easy to understand
✔ Easy debugging
✔ Predictable execution

ASYNCHRONOUS ADVANTAGES
------------------------------------------------
✔ Better user experience
✔ Faster applications
✔ Non-blocking
✔ Suitable for APIs
✔ Suitable for database operations
✔ Suitable for real-time apps
*/

/*
=========================================================
                DISADVANTAGES
=========================================================

SYNCHRONOUS DISADVANTAGES
------------------------------------------------
❌ Blocks execution
❌ UI freeze
❌ Poor performance

ASYNCHRONOUS DISADVANTAGES
------------------------------------------------
❌ More complex
❌ Harder debugging
❌ Callback hell (old style)
*/

/*
=========================================================
                REAL WORLD USE CASES
=========================================================

SYNCHRONOUS
------------------------------------------------
✔ Mathematical calculations
✔ Data validation
✔ Small operations
✔ Local variable processing

ASYNCHRONOUS
------------------------------------------------
✔ Login System
✔ OTP Verification
✔ API Calls
✔ Database Queries
✔ File Upload
✔ Payment Processing
✔ Chat Applications
✔ Video Streaming
✔ Email Sending
*/

/*
=========================================================
                 INTERVIEW ANSWER
=========================================================

Q. Is JavaScript Synchronous or Asynchronous?

Answer:

JavaScript is a Single-Threaded and
Synchronous language by default.

However, JavaScript can perform
Asynchronous operations using:

✔ Event Loop
✔ Web APIs
✔ Callbacks
✔ Promises
✔ Async/Await

This makes JavaScript capable of
handling non-blocking operations efficiently.
*/

/*
=========================================================
                    FINAL SUMMARY
=========================================================

Synchronous
------------
Waits for current task to finish.

Example:
Making Tea → Drink Tea

Asynchronous
-------------
Does not wait for task completion.

Example:
Order Food → Watch Movie → Food Delivered

JavaScript
-----------
✔ Single Threaded
✔ Synchronous by Default
✔ Supports Asynchronous Programming

Most Common Async Features
--------------------------
✔ setTimeout()
✔ setInterval()
✔ Promise
✔ Async/Await
✔ fetch()
✔ Database Queries
*/