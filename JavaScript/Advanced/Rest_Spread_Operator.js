/*
=========================================================
      SPREAD OPERATOR vs REST OPERATOR IN JAVASCRIPT
=========================================================

---------------------------------------------------------
1) What are Spread and Rest Operators ?
---------------------------------------------------------

Both use same symbol:
...

BUT

Usage and behavior are different.

---------------------------------------------------------
2) Spread Operator
---------------------------------------------------------

Spread operator expands/unpacks values.

Simple Meaning:
"Spread values one by one"

Used for:
✔ Array copy
✔ Array merge
✔ Object copy
✔ Function arguments

---------------------------------------------------------
3) Rest Operator
---------------------------------------------------------

Rest operator collects multiple values
into single array.

Simple Meaning:
"Collect remaining values"

Used for:
✔ Function parameters
✔ Destructuring
✔ Variable arguments

---------------------------------------------------------
4) Main Difference
---------------------------------------------------------

Spread Operator
----------------
Expands data

Rest Operator
--------------
Collects data

---------------------------------------------------------
5) Important Point
---------------------------------------------------------

Same symbol (...)
Different behavior depends on usage position.

=========================================================
                SPREAD OPERATOR
=========================================================
*/

console.log("================================================");
console.log("            SPREAD OPERATOR                     ");
console.log("================================================");

/*
Expand array elements
*/

let numbers = [10, 20, 30];

console.log(...numbers);

/*
Output:
10 20 30
*/




/*
=========================================================
            ARRAY COPY USING SPREAD
=========================================================
*/

console.log("\n================================================");
console.log("          ARRAY COPY USING SPREAD               ");
console.log("================================================");

/*
Copy array
*/

let arr1 = [1, 2, 3];

let arr2 = [...arr1];

console.log(arr1);

console.log(arr2);

/*
Original array safe
*/




/*
=========================================================
           ARRAY MERGE USING SPREAD
=========================================================
*/

console.log("\n================================================");
console.log("         ARRAY MERGE USING SPREAD               ");
console.log("================================================");

let fruits1 = ["Apple", "Mango"];

let fruits2 = ["Banana", "Orange"];

let allFruits = [...fruits1, ...fruits2];

console.log(allFruits);





/*
=========================================================
          OBJECT COPY USING SPREAD
=========================================================
*/

console.log("\n================================================");
console.log("          OBJECT COPY USING SPREAD              ");
console.log("================================================");

let student = {

    name: "Mohit",

    age: 22
};

let copiedStudent = {

    ...student
};

console.log(copiedStudent);





/*
=========================================================
          OBJECT MERGE USING SPREAD
=========================================================
*/

console.log("\n================================================");
console.log("          OBJECT MERGE USING SPREAD             ");
console.log("================================================");

let address = {

    city: "Rajkot"
};

let details = {

    country: "India"
};

let user = {

    ...address,

    ...details
};

console.log(user);





/*
=========================================================
        FUNCTION ARGUMENT USING SPREAD
=========================================================
*/

console.log("\n================================================");
console.log("       FUNCTION ARGUMENT SPREAD                 ");
console.log("================================================");

let marks = [50, 80, 90];

function total(a, b, c)
{
    console.log(a + b + c);
}

/*
Spread array values
*/

total(...marks);





/*
=========================================================
                REST OPERATOR
=========================================================
*/

console.log("\n================================================");
console.log("             REST OPERATOR                      ");
console.log("================================================");

/*
Collect values into array
*/

function addNumbers(...numbers)
{
    console.log(numbers);
}

addNumbers(10, 20, 30, 40);





/*
=========================================================
           REST OPERATOR SUM EXAMPLE
=========================================================
*/

console.log("\n================================================");
console.log("          REST PARAMETER SUM                    ");
console.log("================================================");

function sum(...values)
{
    let total = 0;

    for(let value of values)
    {
        total += value;
    }

    console.log(total);
}

sum(10, 20, 30);

sum(5, 5, 5, 5);





/*
=========================================================
          REST WITH NORMAL PARAMETERS
=========================================================
*/

console.log("\n================================================");
console.log("       REST WITH NORMAL PARAMETER               ");
console.log("================================================");

/*
Rest parameter always last
*/

function employee(company, ...names)
{
    console.log(company);

    console.log(names);
}

employee("TCS", "Amit", "Rahul", "Neha");





/*
=========================================================
        ARRAY DESTRUCTURING WITH REST
=========================================================
*/

console.log("\n================================================");
console.log("       ARRAY DESTRUCTURING REST                 ");
console.log("================================================");

let colors = ["Red", "Blue", "Green", "Black"];

let [first, second, ...remaining] = colors;

console.log(first);

console.log(second);

console.log(remaining);





/*
=========================================================
        OBJECT DESTRUCTURING WITH REST
=========================================================
*/

console.log("\n================================================");
console.log("      OBJECT DESTRUCTURING REST                 ");
console.log("================================================");

let product = {

    id: 1,

    name: "Laptop",

    price: 70000,

    brand: "Dell"
};

let {id, ...otherDetails} = product;

console.log(id);

console.log(otherDetails);





/*
=========================================================
          SPREAD IN ARRAY OF OBJECT
=========================================================
*/

console.log("\n================================================");
console.log("        SPREAD IN ARRAY OF OBJECT               ");
console.log("================================================");

let employees = [

    {
        id: 1,
        name: "Amit"
    },

    {
        id: 2,
        name: "Rahul"
    }
];

/*
Copy array of object
*/

let copiedEmployees = [...employees];

console.log(copiedEmployees);





/*
=========================================================
           REAL WORLD SPREAD USE CASES
=========================================================
*/

console.log("\n================================================");
console.log("         REAL WORLD SPREAD USES                 ");
console.log("================================================");

console.log(`
✔ React state update
✔ Array merge
✔ Object clone
✔ API response copy
✔ Function arguments
✔ Immutable updates
`);





/*
=========================================================
            REAL WORLD REST USE CASES
=========================================================
*/

console.log("\n================================================");
console.log("          REAL WORLD REST USES                  ");
console.log("================================================");

console.log(`
✔ Variable function arguments
✔ Data collection
✔ Remaining values
✔ Destructuring
✔ Flexible functions
`);





/*
=========================================================
         SPREAD vs REST DIFFERENCE
=========================================================
*/

console.log("\n================================================");
console.log("        SPREAD vs REST DIFFERENCE               ");
console.log("================================================");

console.log(`
SPREAD OPERATOR
----------------
✔ Expands values
✔ Unpacks array/object
✔ Used in copy/merge

Example:
...array

REST OPERATOR
--------------
✔ Collects values
✔ Packs values into array
✔ Used in parameters

Example:
function(...values)
`);





/*
=========================================================
              IMPORTANT RULES
=========================================================
*/

console.log("\n================================================");
console.log("            IMPORTANT RULES                     ");
console.log("================================================");

console.log(`
✔ Both use ... symbol
✔ Spread expands values
✔ Rest collects values
✔ Rest parameter must be last
✔ Spread useful in React
✔ Rest useful in flexible functions
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
✔ Use spread for immutable updates
✔ Use rest for flexible arguments
✔ Avoid unnecessary deep copies
✔ Use destructuring with rest
✔ Prefer spread over old methods
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
Spread Operator
----------------
Expands values

Used For
----------
✔ Array copy
✔ Object copy
✔ Merge
✔ Function arguments

Rest Operator
--------------
Collects values

Used For
----------
✔ Function parameters
✔ Remaining values
✔ Destructuring

Most Important Difference
--------------------------
Spread = Expand
Rest   = Collect
`);

console.log("\n================================================");
console.log("                 PROGRAM END                    ");
console.log("================================================");