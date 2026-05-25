/*
=========================================================
     SYNCHRONOUS vs ASYNCHRONOUS PROGRAMMING IN JS
=========================================================

---------------------------------------------------------
1) What is Programming Execution ?
---------------------------------------------------------

JavaScript executes code line by line.

There are 2 execution types:
✔ Synchronous
✔ Asynchronous

---------------------------------------------------------
2) What is Synchronous Programming ?
---------------------------------------------------------

Synchronous means:
Code executes one line at a time.

Next line waits until current line finishes.

Simple Meaning:
"Wait and execute"

---------------------------------------------------------
3) What is Asynchronous Programming ?
---------------------------------------------------------

Asynchronous means:
JavaScript does NOT wait for long tasks.

Long tasks run in background.

Simple Meaning:
"Do not wait"

---------------------------------------------------------
4) Why Asynchronous Programming Needed ?
---------------------------------------------------------

Without async:
❌ UI freeze
❌ Slow application
❌ Blocking execution

Async helps:
✔ Faster application
✔ Better performance
✔ Non-blocking behavior
✔ Smooth UI

---------------------------------------------------------
5) JavaScript Nature
---------------------------------------------------------

JavaScript is:
✔ Single Threaded
✔ Synchronous by default

BUT

Can handle asynchronous tasks using:
✔ Callbacks
✔ Promises
✔ Async/Await
✔ Event Loop

---------------------------------------------------------
6) Real World Example
---------------------------------------------------------

Synchronous:
--------------
Bank counter line

One customer at a time.

Asynchronous:
---------------
Online food order

You order food and continue other work
while food prepares.

---------------------------------------------------------
7) Where Async Used ?
---------------------------------------------------------

✔ API Calls
✔ Database
✔ File Upload
✔ Timers
✔ Fetch Data
✔ Authentication
✔ Chat Applications
✔ Payment Gateway

---------------------------------------------------------
8) Advantages of Synchronous
---------------------------------------------------------

✔ Easy to understand
✔ Predictable execution
✔ Simple debugging

---------------------------------------------------------
9) Disadvantages of Synchronous
---------------------------------------------------------

✔ Blocking code
✔ Slow performance
✔ UI freeze possible

---------------------------------------------------------
10) Advantages of Asynchronous
---------------------------------------------------------

✔ Non-blocking
✔ Better performance
✔ Faster applications
✔ Smooth user experience

---------------------------------------------------------
11) Disadvantages of Asynchronous
---------------------------------------------------------

✔ Complex debugging
✔ Callback hell
✔ Hard for beginners

=========================================================
            SYNCHRONOUS PROGRAMMING
=========================================================
*/

console.log("================================================");
console.log("         SYNCHRONOUS PROGRAMMING                ");
console.log("================================================");

/*
Line-by-line execution
*/

console.log("Step 1");

console.log("Step 2");

console.log("Step 3");

/*
Output:
Step 1
Step 2
Step 3
*/

/*
Each line waits for previous line
*/




/*
=========================================================
       SYNCHRONOUS BLOCKING EXAMPLE
=========================================================
*/

console.log("\n================================================");
console.log("        SYNCHRONOUS BLOCKING                    ");
console.log("================================================");

/*
Long loop blocks execution
*/

console.log("Start");

for(let i = 0; i < 1000000000; i++)
{
    // Heavy task
}

console.log("End");

/*
"End" waits until loop finishes
This is blocking behavior
*/




/*
=========================================================
          ASYNCHRONOUS PROGRAMMING
=========================================================
*/

console.log("\n================================================");
console.log("        ASYNCHRONOUS PROGRAMMING                ");
console.log("================================================");

/*
setTimeout is asynchronous
*/

console.log("Start");

setTimeout(function()
{
    console.log("Async Task");

}, 2000);

console.log("End");

/*
Output:
Start
End
Async Task

Why ?
------
JavaScript does NOT wait
*/




/*
=========================================================
            HOW ASYNC WORKS INTERNALLY
=========================================================
*/

console.log("\n================================================");
console.log("         HOW ASYNC WORKS                        ");
console.log("================================================");

/*
JavaScript uses:
✔ Call Stack
✔ Web APIs
✔ Callback Queue
✔ Event Loop

Flow:
1) Async task goes to Web API
2) JS continues execution
3) Completed task enters queue
4) Event loop executes callback
*/

console.log("Understanding Event Loop Important");





/*
=========================================================
              CALLBACK EXAMPLE
=========================================================
*/

console.log("\n================================================");
console.log("            CALLBACK EXAMPLE                    ");
console.log("================================================");

/*
Old async method
*/

function fetchData(callback)
{
    setTimeout(function()
    {
        callback("Data Loaded");

    }, 2000);
}

fetchData(function(result)
{
    console.log(result);
});





/*
=========================================================
              PROMISE EXAMPLE
=========================================================
*/

console.log("\n================================================");
console.log("             PROMISE EXAMPLE                    ");
console.log("================================================");

/*
Modern async handling
*/

let promise = new Promise(function(resolve)
{
    setTimeout(function()
    {
        resolve("Promise Data");

    }, 2000);
});

promise.then(function(data)
{
    console.log(data);
});





/*
=========================================================
             ASYNC/AWAIT EXAMPLE
=========================================================
*/

console.log("\n================================================");
console.log("           ASYNC/AWAIT EXAMPLE                  ");
console.log("================================================");

/*
Newest async handling
*/

async function getData()
{
    let response = await new Promise(function(resolve)
    {
        setTimeout(function()
        {
            resolve("Async/Await Data");

        }, 2000);
    });

    console.log(response);
}

getData();





/*
=========================================================
            SYNCHRONOUS REAL EXAMPLE
=========================================================
*/

console.log("\n================================================");
console.log("         SYNCHRONOUS REAL EXAMPLE               ");
console.log("================================================");

/*
One task after another
*/

function makeTea()
{
    console.log("Making Tea");
}

function drinkTea()
{
    console.log("Drinking Tea");
}

makeTea();

drinkTea();

/*
drinkTea waits for makeTea
*/




/*
=========================================================
           ASYNCHRONOUS REAL EXAMPLE
=========================================================
*/

console.log("\n================================================");
console.log("        ASYNCHRONOUS REAL EXAMPLE               ");
console.log("================================================");

/*
Food delivery style
*/

function orderFood()
{
    setTimeout(function()
    {
        console.log("Food Delivered");

    }, 3000);
}

console.log("Order Food");

orderFood();

console.log("Watch Movie");

/*
Output:
Order Food
Watch Movie
Food Delivered
*/




/*
=========================================================
           API CALL ASYNC EXAMPLE
=========================================================
*/

console.log("\n================================================");
console.log("           API CALL EXAMPLE                     ");
console.log("================================================");

/*
fetch() is asynchronous
*/

fetch("https://jsonplaceholder.typicode.com/users")

.then(function(response)
{
    return response.json();
})

.then(function(data)
{
    console.log(data);
});

console.log("Fetching Data...");

/*
JavaScript continues execution
without waiting
*/




/*
=========================================================
         SYNCHRONOUS vs ASYNCHRONOUS
=========================================================
*/

console.log("\n================================================");
console.log("     SYNCHRONOUS vs ASYNCHRONOUS                ");
console.log("================================================");

console.log(`
SYNCHRONOUS
-------------
✔ Executes line by line
✔ Blocking
✔ Slower
✔ Easier debugging

ASYNCHRONOUS
--------------
✔ Non-blocking
✔ Faster
✔ Better performance
✔ Background execution
`);





/*
=========================================================
             EVENT LOOP CONCEPT
=========================================================
*/

console.log("\n================================================");
console.log("            EVENT LOOP                          ");
console.log("================================================");

console.log(`
Event Loop checks:
✔ Is call stack empty ?

If YES:
---------
Moves callback from queue
to call stack.

This is how async works in JS.
`);





/*
=========================================================
            COMMON ASYNC FUNCTIONS
=========================================================
*/

console.log("\n================================================");
console.log("          COMMON ASYNC FUNCTIONS                ");
console.log("================================================");

console.log(`
✔ setTimeout()
✔ setInterval()
✔ fetch()
✔ Promise
✔ async/await
✔ File reading
✔ Database queries
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
Synchronous Use
----------------
✔ Simple calculations
✔ Validation
✔ Small tasks

Asynchronous Use
-----------------
✔ API calls
✔ Database
✔ Chat apps
✔ Video streaming
✔ Online payments
✔ File uploads
✔ Authentication
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
✔ JavaScript is single-threaded
✔ JS is synchronous by default
✔ Async tasks handled by browser/node
✔ Event loop manages async execution
✔ Promises and async/await modern methods
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
✔ Use async/await for readability
✔ Handle errors properly
✔ Avoid blocking code
✔ Use promises for async operations
✔ Avoid callback hell
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
Synchronous
-------------
Waits for current task to finish.

Asynchronous
--------------
Does not wait for long tasks.

Most Important Difference
---------------------------
Synchronous = Blocking
Asynchronous = Non-blocking

Modern Async Methods
---------------------
✔ Promise
✔ async/await

Most Used Async Operations
---------------------------
✔ API calls
✔ Database
✔ Timers
✔ File handling
`);

console.log("\n================================================");
console.log("                 PROGRAM END                    ");
console.log("================================================");