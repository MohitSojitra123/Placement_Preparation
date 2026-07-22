/*
=========================================================
                 LOOPS IN JAVASCRIPT
=========================================================

---------------------------------------------------------
1) What is Loop ?
---------------------------------------------------------

A loop is used to execute code repeatedly until
a condition becomes false.

Simple Meaning:
"Repeat code multiple times"

---------------------------------------------------------
2) Why Loops are Used ?
---------------------------------------------------------

Without loop:
- Same code written many times

With loop:
✔ Less code
✔ Faster development
✔ Easy data traversal
✔ Better readability

---------------------------------------------------------
3) Types of Loops in JavaScript
---------------------------------------------------------

1) for loop
2) while loop
3) do...while loop
4) for...in loop
5) for...of loop
6) forEach loop

---------------------------------------------------------
4) When To Use Which Loop ?
---------------------------------------------------------

for loop
---------
✔ Known iteration count
✔ Best for index access

while loop
-----------
✔ Unknown iteration count
✔ Run until condition true

do...while loop
----------------
✔ Run at least one time

for...in loop
--------------
✔ Traverse object properties

for...of loop
--------------
✔ Traverse array/string values

forEach loop
-------------
✔ Array iteration
✔ Cleaner syntax

---------------------------------------------------------
5) Important Difference
---------------------------------------------------------

for...in
---------
Returns KEYS / INDEX

for...of
---------
Returns VALUES

forEach()
----------
Only works with arrays

=========================================================
                    1) FOR LOOP
=========================================================
*/

console.log("================================================");
console.log("                  FOR LOOP                       ");
console.log("================================================");

/*
Syntax:

for(initialization; condition; increment/decrement)
{
    code
}
*/

for(let i = 1; i <= 5; i++)
{
    console.log("Number:", i);
}





console.log("\n================================================");
console.log("        FOR LOOP WITH ARRAY TRAVERSAL           ");
console.log("================================================");

let numbers = [10, 20, 30, 40];

for(let i = 0; i < numbers.length; i++)
{
    console.log("Index:", i, "Value:", numbers[i]);
}





/*
=========================================================
                    2) WHILE LOOP
=========================================================
*/

console.log("\n================================================");
console.log("                 WHILE LOOP                      ");
console.log("================================================");

/*
Syntax:

while(condition)
{
    code
}
*/

let count = 1;

while(count <= 5)
{
    console.log("Count:", count);

    count++;
}





console.log("\n================================================");
console.log("      WHILE LOOP WITH ARRAY TRAVERSAL           ");
console.log("================================================");

let arr = [100, 200, 300];

let index = 0;

while(index < arr.length)
{
    console.log(arr[index]);

    index++;
}





/*
=========================================================
                  3) DO WHILE LOOP
=========================================================
*/

console.log("\n================================================");
console.log("               DO WHILE LOOP                     ");
console.log("================================================");

/*
Syntax:

do
{
    code
}
while(condition);

Important:
Runs at least one time
*/

let num = 1;

do
{
    console.log("Value:", num);

    num++;

} while(num <= 5);





console.log("\n================================================");
console.log("   DO WHILE LOOP WITH ARRAY TRAVERSAL           ");
console.log("================================================");

let prices = [500, 1000, 1500];

let i = 0;

do
{
    console.log(prices[i]);

    i++;

} while(i < prices.length);





/*
=========================================================
                    4) FOR...IN LOOP
=========================================================
*/

console.log("\n================================================");
console.log("                FOR...IN LOOP                    ");
console.log("================================================");

/*
Used for:
✔ Object traversal
✔ Returns keys/index

Syntax:

for(let key in object)
{
    code
}
*/

let student = {
    name: "Mohit",
    age: 22,
    city: "Rajkot"
};

for(let key in student)
{
    console.log("Key:", key, "Value:", student[key]);
}





console.log("\n================================================");
console.log("      FOR...IN LOOP WITH ARRAY                  ");
console.log("================================================");

/*
Returns array indexes
*/

let colors = ["Red", "Blue", "Green"];

for(let index in colors)
{
    console.log("Index:", index, "Value:", colors[index]);
}





/*
=========================================================
                    5) FOR...OF LOOP
=========================================================
*/

console.log("\n================================================");
console.log("                FOR...OF LOOP                    ");
console.log("================================================");

/*
Used for:
✔ Arrays
✔ Strings
✔ Iterable objects

Returns VALUES directly

Syntax:

for(let value of array)
{
    code
}
*/

let fruits = ["Apple", "Mango", "Banana"];

for(let value of fruits)
{
    console.log(value);
}





console.log("\n================================================");
console.log("        FOR...OF LOOP WITH STRING               ");
console.log("================================================");

let language = "JavaScript";

for(let char of language)
{
    console.log(char);
}





/*
=========================================================
                    6) forEach LOOP
=========================================================
*/

console.log("\n================================================");
console.log("                forEach LOOP                     ");
console.log("================================================");

/*
Only works with arrays

Syntax:

array.forEach(function(value,index){
    code
});
*/

let nums = [11, 22, 33, 44];

nums.forEach(function(value, index)
{
    console.log("Index:", index, "Value:", value);
});





/*
=========================================================
             ARRAY OF OBJECT TRAVERSAL
=========================================================
*/

console.log("\n================================================");
console.log("            ARRAY OF OBJECT TRAVERSAL           ");
console.log("================================================");

/*
Array containing multiple objects
*/

let employees = [

    {
        id: 1,
        name: "Amit",
        salary: 50000
    },

    {
        id: 2,
        name: "Rahul",
        salary: 60000
    },

    {
        id: 3,
        name: "Neha",
        salary: 70000
    }
];





console.log("\n================================================");
console.log("         USING FOR LOOP                         ");
console.log("================================================");

for(let i = 0; i < employees.length; i++)
{
    console.log(
        employees[i].id,
        employees[i].name,
        employees[i].salary
    );
}





console.log("\n================================================");
console.log("         USING WHILE LOOP                       ");
console.log("================================================");

let empIndex = 0;

while(empIndex < employees.length)
{
    console.log(
        employees[empIndex].name
    );

    empIndex++;
}





console.log("\n================================================");
console.log("         USING FOR...OF LOOP                    ");
console.log("================================================");

for(let employee of employees)
{
    console.log(
        employee.id,
        employee.name,
        employee.salary
    );
}





console.log("\n================================================");
console.log("         USING forEach LOOP                     ");
console.log("================================================");

employees.forEach(function(emp)
{
    console.log(
        emp.id,
        emp.name,
        emp.salary
    );
});





console.log("\n================================================");
console.log("         USING FOR...IN LOOP                    ");
console.log("================================================");

/*
for...in on array gives indexes
*/

for(let index in employees)
{
    console.log(
        employees[index].name
    );
}





/*
=========================================================
                LOOP DIFFERENCE
=========================================================
*/

console.log("\n================================================");
console.log("              LOOP DIFFERENCE                   ");
console.log("================================================");

console.log(`
for loop
---------
✔ Best for index control
✔ Flexible

while loop
-----------
✔ Best when iteration count unknown

do...while
------------
✔ Executes at least once

for...in
---------
✔ Object traversal
✔ Returns keys/index

for...of
---------
✔ Array/string traversal
✔ Returns values

forEach
--------
✔ Array only
✔ Cleaner syntax
✔ Callback based
`);





console.log("\n================================================");
console.log("              IMPORTANT NOTES                   ");
console.log("================================================");

console.log(`
✔ for...in -> keys/index
✔ for...of -> values
✔ forEach -> array only
✔ Object best traversed using for...in
✔ Array best traversed using for, for...of, forEach
✔ forEach cannot use break/continue
`);





console.log("\n================================================");
console.log("                FINAL SUMMARY                   ");
console.log("================================================");

console.log(`
Loops are used to repeat code.

Most Common:
-------------
✔ for loop
✔ for...of
✔ forEach

Object Traversal:
-----------------
✔ for...in

Array Traversal:
----------------
✔ for
✔ for...of
✔ forEach
`);

console.log("\n================================================");
console.log("                 PROGRAM END                    ");
console.log("================================================");