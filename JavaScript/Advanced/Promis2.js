
// A Promise is a special object in Javascript that represents a tsk that will finish in the future.

// a promise has 3 states
// Pending - still waiting
// Resolves (fulfilled) - task Completed
// Rejected - Something went wrong
// resolve and reject are callbacks provided by javascript

/*
=====================================================================
                        PROMISE IN JAVASCRIPT
=====================================================================

---------------------------------------------------------------------
1) WHAT IS A PROMISE?
---------------------------------------------------------------------

A Promise is a JavaScript object that represents the eventual
completion (success) or failure of an asynchronous operation.

Simple Definition:

"A Promise is a placeholder for a future value."

Promise tells us:

✔ Task completed successfully  -> resolve()
✔ Task failed                  -> reject()

---------------------------------------------------------------------
2) WHY DO WE NEED PROMISE?
---------------------------------------------------------------------

Before Promises, JavaScript used Callbacks.

Problem:

login(function(){
    getUser(function(){
        getOrders(function(){
            getPayment(function(){
                ....
            });
        });
    });
});

This creates:

❌ Callback Hell
❌ Difficult debugging
❌ Difficult error handling
❌ Nested code

Promises solve these problems.

Benefits:

✔ Cleaner code
✔ Better readability
✔ Easy error handling
✔ Chaining support

---------------------------------------------------------------------
3) REAL WORLD EXAMPLE
---------------------------------------------------------------------

Food Delivery Application

You order food.

Current State:
--------------
Pending

Food Delivered:
---------------
Resolved

Restaurant Closed:
------------------
Rejected

Promise works exactly like this.

---------------------------------------------------------------------
4) PROMISE STATES
---------------------------------------------------------------------

There are 3 States:

1) Pending
------------
Initial state
Task is running

2) Fulfilled / Resolved
------------------------
Task completed successfully

3) Rejected
------------
Task failed

Diagram:

Pending
   |
   |
   +------> Resolved
   |
   +------> Rejected

=====================================================================
                    CREATE FIRST PROMISE
=====================================================================
*/

console.log("=================================================");
console.log("         CREATE BASIC PROMISE");
console.log("=================================================");

let myPromise = new Promise(function(resolve, reject)
{
    let success = true;

    if(success)
    {
        resolve("Data Loaded Successfully");
    }
    else
    {
        reject("Data Loading Failed");
    }
});

myPromise
.then(function(result)
{
    console.log(result);
})
.catch(function(error)
{
    console.log(error);
});

/*
Output:

Data Loaded Successfully
*/

/*
=====================================================================
                UNDERSTANDING resolve()
=====================================================================

resolve() means:

✔ Task completed
✔ Success returned

Example:
*/

let promise1 = new Promise(function(resolve)
{
    resolve("Payment Successful");
});

promise1.then(function(data)
{
    console.log(data);
});

/*
Output:
Payment Successful
*/

/*
=====================================================================
                UNDERSTANDING reject()
=====================================================================

reject() means:

✔ Task failed
✔ Error occurred
*/

let promise2 = new Promise(function(resolve,reject)
{
    reject("Payment Failed");
});

promise2.catch(function(error)
{
    console.log(error);
});

/*
Output:
Payment Failed
*/

/*
=====================================================================
                    ASYNCHRONOUS PROMISE
=====================================================================

Real asynchronous example
*/

console.log("\nLoading Data...");

let asyncPromise = new Promise(function(resolve)
{
    setTimeout(function()
    {
        resolve("Data Received From Server");
    },3000);
});

asyncPromise.then(function(data)
{
    console.log(data);
});

console.log("Application Running");

/*
Output:

Loading Data...
Application Running
Data Received From Server

Explanation:

JavaScript does not wait.

Promise works asynchronously.
*/

/*
=====================================================================
                  PROMISE CHAINING
=====================================================================

One promise result passed to another.

Example:
*/

let chainPromise = new Promise(function(resolve)
{
    resolve(10);
});

chainPromise

.then(function(data)
{
    console.log(data);

    return data * 2;
})

.then(function(data)
{
    console.log(data);

    return data * 2;
})

.then(function(data)
{
    console.log(data);
});

/*
Output:

10
20
40
*/

/*
=====================================================================
                     CATCH ERROR
=====================================================================

Centralized Error Handling
*/

let errorPromise = new Promise(function(resolve,reject)
{
    reject("Server Error");
});

errorPromise

.then(function(data)
{
    console.log(data);
})

.catch(function(error)
{
    console.log("Error:", error);
});

/*
Output:

Error: Server Error
*/

/*
=====================================================================
                     FINALLY METHOD
=====================================================================

finally() always executes.

Success OR Failure
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
    console.log("Cleanup Code");
});

/*
Output:

Task Completed
Cleanup Code
*/

/*
=====================================================================
                REAL WORLD SCENARIO #1
                LOGIN SYSTEM
=====================================================================
*/

function loginUser()
{
    return new Promise(function(resolve,reject)
    {
        let passwordCorrect = true;

        if(passwordCorrect)
        {
            resolve("Login Successful");
        }
        else
        {
            reject("Invalid Password");
        }
    });
}

loginUser()

.then(function(result)
{
    console.log(result);
})

.catch(function(error)
{
    console.log(error);
});

/*
Used in:
✔ Authentication Systems
✔ Banking Apps
✔ E-commerce Websites
*/

/*
=====================================================================
                REAL WORLD SCENARIO #2
                ONLINE PAYMENT
=====================================================================
*/

function makePayment(amount)
{
    return new Promise(function(resolve,reject)
    {
        if(amount > 0)
        {
            resolve("Payment Successful");
        }
        else
        {
            reject("Invalid Amount");
        }
    });
}

makePayment(1000)

.then(function(result)
{
    console.log(result);
})

.catch(function(error)
{
    console.log(error);
});

/*
Used in:

✔ Google Pay
✔ PhonePe
✔ Paytm
✔ Banking Applications
*/

/*
=====================================================================
                REAL WORLD SCENARIO #3
                FILE DOWNLOAD
=====================================================================
*/

function downloadFile()
{
    return new Promise(function(resolve)
    {
        setTimeout(function()
        {
            resolve("File Downloaded");
        },2000);
    });
}

downloadFile().then(function(result)
{
    console.log(result);
});

/*
Used in:

✔ PDF Download
✔ Image Download
✔ Software Download
*/

/*
=====================================================================
                REAL WORLD SCENARIO #4
                API CALL
=====================================================================

Most common Promise use.
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
fetch() automatically returns Promise
*/

/*
=====================================================================
                PROMISE.ALL()
=====================================================================

Wait for ALL promises.
*/

let p1 = Promise.resolve("HTML");

let p2 = Promise.resolve("CSS");

let p3 = Promise.resolve("JavaScript");

Promise.all([p1,p2,p3])

.then(function(result)
{
    console.log(result);
});

/*
Output:

["HTML","CSS","JavaScript"]
*/

/*
Use Case:

✔ Multiple API Calls
✔ Dashboard Loading
✔ User Profile Data
*/

/*
=====================================================================
                PROMISE.RACE()
=====================================================================

First completed promise wins.
*/

let fast = new Promise(function(resolve)
{
    setTimeout(function()
    {
        resolve("Fast Server");
    },1000);
});

let slow = new Promise(function(resolve)
{
    setTimeout(function()
    {
        resolve("Slow Server");
    },5000);
});

Promise.race([fast,slow])

.then(function(result)
{
    console.log(result);
});

/*
Output:

Fast Server
*/

/*
=====================================================================
                PROMISE.ALLSETTLED()
=====================================================================

Returns all results.

Success and failure both.
*/

let successPromise = Promise.resolve("Success");

let failPromise = Promise.reject("Failed");

Promise.allSettled([
    successPromise,
    failPromise
])

.then(function(result)
{
    console.log(result);
});

/*
Used when all results matter.
*/

/*
=====================================================================
                PROMISE.ANY()
=====================================================================

First successful promise wins.
*/

let server1 = Promise.reject("Server1 Failed");

let server2 = Promise.resolve("Server2 Success");

Promise.any([server1,server2])

.then(function(result)
{
    console.log(result);
});

/*
Output:

Server2 Success
*/

/*
=====================================================================
                PROMISE vs CALLBACK
=====================================================================

CALLBACK
---------
✔ Older technique

❌ Callback Hell
❌ Difficult Error Handling

PROMISE
---------
✔ Cleaner Code
✔ Better Readability
✔ Easy Error Handling
✔ Chaining Support

*/

/*
=====================================================================
                WHERE PROMISE IS USED?
=====================================================================

✔ API Calls
✔ Database Queries
✔ Login Authentication
✔ OTP Verification
✔ Payment Gateway
✔ Chat Applications
✔ File Upload
✔ File Download
✔ Email Sending
✔ Cloud Services
✔ React Applications
✔ Node.js Backend

*/

/*
=====================================================================
                INTERVIEW QUESTION
=====================================================================

Q. Why Promise Introduced?

Answer:

Promise was introduced to solve:

✔ Callback Hell
✔ Complex Asynchronous Code
✔ Error Handling Problems

and provide cleaner asynchronous programming.

*/

/*
=====================================================================
                    FINAL SUMMARY
=====================================================================

Promise:
---------
Object representing future success or failure.

States:
--------
1) Pending
2) Fulfilled
3) Rejected

Methods:
---------
✔ then()
✔ catch()
✔ finally()

Advanced Methods:
------------------
✔ Promise.all()
✔ Promise.race()
✔ Promise.any()
✔ Promise.allSettled()

Real World Uses:
----------------
✔ API Calls
✔ Database Operations
✔ Login Systems
✔ Payments
✔ File Upload/Download

Most Important Benefit:
-----------------------
Avoids Callback Hell and makes asynchronous code
easy to read and maintain.
=====================================================================
*/