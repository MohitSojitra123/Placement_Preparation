/*
=========================================================
         ARRAY & OBJECT DESTRUCTURING IN JAVASCRIPT
=========================================================

---------------------------------------------------------
1) What is Destructuring ?
---------------------------------------------------------

Destructuring is a JavaScript feature used to extract
values from:
✔ Arrays
✔ Objects

and store them into separate variables easily.

Simple Meaning:
"Breaking data into variables"

---------------------------------------------------------
2) Why Destructuring is Used ?
---------------------------------------------------------

Without destructuring:
- Code becomes long
- Repeated access needed
- Less readable

With destructuring:
✔ Short code
✔ Cleaner code
✔ Better readability
✔ Easy variable extraction

---------------------------------------------------------
3) Types of Destructuring
---------------------------------------------------------

1) Array Destructuring
2) Object Destructuring

---------------------------------------------------------
4) When To Use Destructuring ?
---------------------------------------------------------

Use when:
✔ Working with arrays
✔ Working with objects
✔ API response handling
✔ Function parameters
✔ React props/state
✔ Swapping variables
✔ Returning multiple values

---------------------------------------------------------
5) Advantages
---------------------------------------------------------

✔ Cleaner syntax
✔ Less code
✔ Easy data extraction
✔ Improves readability
✔ Useful in React & Node.js
✔ Easier function handling

---------------------------------------------------------
6) Disadvantages
---------------------------------------------------------

✔ Confusing for beginners
✔ Undefined values possible
✔ Nested destructuring becomes complex
✔ Variable names must match in object

=========================================================
               ARRAY DESTRUCTURING
=========================================================
*/

console.log("================================================");
console.log("         ARRAY DESTRUCTURING EXAMPLES           ");
console.log("================================================");

/*
---------------------------------------------------------
Example 1 : Normal Way
---------------------------------------------------------
*/

let numbers = [10, 20, 30];

let first = numbers[0];
let second = numbers[1];
let third = numbers[2];

console.log("Normal Way:");
console.log(first);
console.log(second);
console.log(third);

/*
---------------------------------------------------------
Example 2 : Destructuring Way
---------------------------------------------------------
*/

let fruits = ["Apple", "Mango", "Banana"];

/*
Values extracted directly into variables
*/

let [fruit1, fruit2, fruit3] = fruits;

console.log("\nDestructuring Way:");
console.log(fruit1);
console.log(fruit2);
console.log(fruit3);





console.log("\n================================================");
console.log("      Example 3 : Skip Array Values             ");
console.log("================================================");

/*
Skip second value using comma
*/

let colors = ["Red", "Blue", "Green", "Yellow"];

let [color1, , color3] = colors;

console.log(color1);
console.log(color3);





console.log("\n================================================");
console.log("      Example 4 : Default Values                ");
console.log("================================================");

/*
Default value used if array value missing
*/

let data = ["Mohit"];

let [name, city = "Rajkot"] = data;

console.log(name);
console.log(city);





console.log("\n================================================");
console.log("       Example 5 : Rest Operator                ");
console.log("================================================");

/*
...rest stores remaining values
*/

let nums = [1, 2, 3, 4, 5];

let [a, b, ...remaining] = nums;

console.log(a);
console.log(b);
console.log(remaining);





console.log("\n================================================");
console.log("        Example 6 : Swap Variables              ");
console.log("================================================");

/*
Swap without third variable
*/

let x = 10;
let y = 20;

console.log("Before Swap:");
console.log(x, y);

[x, y] = [y, x];

console.log("After Swap:");
console.log(x, y);





console.log("\n================================================");
console.log("     Example 7 : Function Return Values         ");
console.log("================================================");

/*
Function returns array
*/

function getValues()
{
    return [100, 200];
}

let [value1, value2] = getValues();

console.log(value1);
console.log(value2);





/*
=========================================================
              OBJECT DESTRUCTURING
=========================================================
*/

console.log("\n================================================");
console.log("        OBJECT DESTRUCTURING EXAMPLES           ");
console.log("================================================");

/*
---------------------------------------------------------
Example 1 : Normal Object Access
---------------------------------------------------------
*/

let student = {
    name1: "Mohit",
    age: 22,
    city1: "Rajkot"
};

console.log("Normal Access:");
console.log(student.name1);
console.log(student.age);
console.log(student.city1);





console.log("\n================================================");
console.log("      Example 2 : Object Destructuring          ");
console.log("================================================");

/*
Extract object properties into variables
*/

let employee = {
    empName: "Rahul",
    salary: 50000,
    department: "IT"
};

let { empName, salary, department } = employee;

console.log(empName);
console.log(salary);
console.log(department);





console.log("\n================================================");
console.log("      Example 3 : Rename Variables              ");
console.log("================================================");

/*
Rename variable while destructuring
*/

let user = {
    username: "Admin",
    password: "12345"
};

let { username: userNameValue } = user;

console.log(userNameValue);





console.log("\n================================================");
console.log("      Example 4 : Default Values                ");
console.log("================================================");

/*
Default value if property missing
*/

let person = {
    fullName: "Amit"
};

let { fullName, country = "India" } = person;

console.log(fullName);
console.log(country);





console.log("\n================================================");
console.log("       Example 5 : Nested Object                ");
console.log("================================================");

/*
Nested object destructuring
*/

let company = {
    companyName: "TCS",

    address: {
        city: "Ahmedabad",
        state: "Gujarat"
    }
};

let {
    companyName,

    address: { city, state }

} = company;

console.log(companyName);
console.log(city);
console.log(state);





console.log("\n================================================");
console.log("       Example 6 : Function Parameters          ");
console.log("================================================");

/*
Object destructuring in function parameter
*/

function displayUser({ name2, age2 })
{
    console.log(name2);
    console.log(age2);
}

let userData = {
    name2: "Neha",
    age2: 25
};

displayUser(userData);





console.log("\n================================================");
console.log("        Example 7 : API Response Style          ");
console.log("================================================");

/*
Very common in API handling
*/

let apiResponse = {
    status: true,
    message: "Success",
    data2: {
        id: 101,
        productName: "Laptop"
    }
};

let {
    status,
    message,

    data2: { id, productName }

} = apiResponse;

console.log(status);
console.log(message);
console.log(id);
console.log(productName);





console.log("\n================================================");
console.log("        Array vs Object Destructuring           ");
console.log("================================================");

console.log(`
Array Destructuring
-------------------
✔ Based on position/index
✔ Variable name can be anything

Example:
let [a,b] = [10,20];

Object Destructuring
--------------------
✔ Based on property name
✔ Property names must match

Example:
let {name,age} = user;
`);





console.log("\n================================================");
console.log("        Real World Uses of Destructuring        ");
console.log("================================================");

console.log(`
1) React Props
2) API Response Handling
3) Database Result Handling
4) Function Parameters
5) Swapping Variables
6) Node.js Development
7) Redux State Handling
`);





console.log("\n================================================");
console.log("               Important Notes                  ");
console.log("================================================");

console.log(`
✔ Array destructuring uses order/index
✔ Object destructuring uses property names
✔ Default values possible
✔ Rest operator supported
✔ Nested destructuring possible
✔ Widely used in React and Node.js
`);





console.log("\n================================================");
console.log("                FINAL SUMMARY                   ");
console.log("================================================");

console.log(`
Destructuring
-------------
Extract values from array/object
into separate variables.

Array Destructuring
-------------------
Extract values using index position.

Object Destructuring
--------------------
Extract values using property names.

Benefits
--------
✔ Cleaner code
✔ Short syntax
✔ Better readability
✔ Easier data handling
`);

console.log("\n================================================");
console.log("                 PROGRAM END                    ");
console.log("================================================");