/*
=========================================================
          call(), apply() and bind() IN JAVASCRIPT
=========================================================

---------------------------------------------------------
1) What are call(), apply(), bind() ?
---------------------------------------------------------

call(), apply(), and bind() are methods used to
control the value of "this" in JavaScript.

They help borrow functions from another object.

Simple Meaning:
"Change or set this keyword manually"

---------------------------------------------------------
2) Why They are Used ?
---------------------------------------------------------

✔ Reuse functions
✔ Control "this"
✔ Function borrowing
✔ Pass data between objects
✔ Event handling
✔ OOP concepts

---------------------------------------------------------
3) Main Difference
---------------------------------------------------------

call()
-------
Immediately invokes function
Arguments passed separately

apply()
--------
Immediately invokes function
Arguments passed as array

bind()
-------
Does NOT invoke immediately
Returns new function

---------------------------------------------------------
4) Syntax
---------------------------------------------------------

call()
-------
function.call(thisValue,arg1,arg2)

apply()
--------
function.apply(thisValue,[arg1,arg2])

bind()
-------
function.bind(thisValue)

=========================================================
                    call() METHOD
=========================================================
*/

console.log("================================================");
console.log("                call() METHOD                   ");
console.log("================================================");

/*
call() calls function immediately
Arguments passed separately
*/

let student = {
    name: "Mohit"
};

function greet(city, country)
{
    console.log(
        "Hello " +
        this.name +
        " from " +
        city +
        ", " +
        country
    );
}

/*
Set "this" manually
*/

greet.call(student, "Rajkot", "India");





console.log("\n================================================");
console.log("          FUNCTION BORROWING USING call()      ");
console.log("================================================");

/*
Reuse method from another object
*/

let employee1 = {
    name: "Amit"
};

let employee2 = {
    name: "Rahul"
};

function display()
{
    console.log("Employee:", this.name);
}

display.call(employee1);

display.call(employee2);





/*
=========================================================
                    apply() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("               apply() METHOD                   ");
console.log("================================================");

/*
apply() calls function immediately
Arguments passed inside array
*/

let user = {
    name: "Neha"
};

function details(city, age)
{
    console.log(
        this.name,
        city,
        age
    );
}

details.apply(user, ["Ahmedabad", 25]);





console.log("\n================================================");
console.log("           apply() WITH MATH.max()             ");
console.log("================================================");

/*
Useful when array data exists
*/

let numbers = [10, 50, 30, 90];

let max = Math.max.apply(null, numbers);

console.log(max);





/*
=========================================================
                    bind() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("                bind() METHOD                   ");
console.log("================================================");

/*
bind() does NOT execute immediately

Returns new function
*/

let person = {
    name: "Rahul"
};

function message(city)
{
    console.log(
        "Hello",
        this.name,
        city
    );
}

/*
bind returns function
*/

let newFunction = message.bind(person, "Surat");

/*
Execute later
*/

newFunction();





console.log("\n================================================");
console.log("             bind() REAL EXAMPLE               ");
console.log("================================================");

/*
Very common in event handling
*/

let customer = {
    name: "Aman"
};

function showName()
{
    console.log(this.name);
}

/*
Create permanent binding
*/

let bindFunction = showName.bind(customer);

bindFunction();





/*
=========================================================
                 "this" KEYWORD
=========================================================
*/

console.log("\n================================================");
console.log("              this KEYWORD                      ");
console.log("================================================");

/*
"this" refers to current object
*/

let mobile = {
    brand: "Samsung",

    displayBrand: function()
    {
        console.log(this.brand);
    }
};

mobile.displayBrand();





/*
=========================================================
            DIFFERENCE BETWEEN call/apply/bind
=========================================================
*/

console.log("\n================================================");
console.log("          call vs apply vs bind                 ");
console.log("================================================");

console.log(`
call()
-------
✔ Executes immediately
✔ Arguments separated by comma

apply()
--------
✔ Executes immediately
✔ Arguments inside array

bind()
-------
✔ Returns new function
✔ Executes later
✔ Permanent binding
`);





/*
=========================================================
                 REAL WORLD USES
=========================================================
*/

console.log("\n================================================");
console.log("              REAL WORLD USES                   ");
console.log("================================================");

console.log(`
call()
-------
✔ Function borrowing
✔ Reuse methods

apply()
--------
✔ Array arguments
✔ Math.max/min operations

bind()
-------
✔ Event handling
✔ React class components
✔ Permanent this binding
`);





/*
=========================================================
               ARRAY OF OBJECT EXAMPLE
=========================================================
*/

console.log("\n================================================");
console.log("         ARRAY OF OBJECT EXAMPLE                ");
console.log("================================================");

let employees = [

    {
        name: "Amit"
    },

    {
        name: "Rahul"
    },

    {
        name: "Neha"
    }
];

function printEmployee(company)
{
    console.log(
        this.name,
        company
    );
}

/*
Using call() in traversal
*/

employees.forEach(function(emp)
{
    printEmployee.call(emp, "TCS");
});





/*
=========================================================
                IMPORTANT NOTES
=========================================================
*/

console.log("\n================================================");
console.log("             IMPORTANT NOTES                    ");
console.log("================================================");

console.log(`
✔ call(), apply(), bind() control "this"
✔ call/apply execute immediately
✔ bind returns new function
✔ apply uses array arguments
✔ bind useful for callbacks/events
✔ Used heavily in React and JS OOP
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
call()
-------
Immediate execution
Arguments separate

apply()
--------
Immediate execution
Arguments array

bind()
-------
Returns function
Execute later

Purpose
--------
✔ Control "this"
✔ Reuse functions
✔ Function borrowing
✔ Event handling
`);

console.log("\n================================================");
console.log("                 PROGRAM END                    ");
console.log("================================================");
