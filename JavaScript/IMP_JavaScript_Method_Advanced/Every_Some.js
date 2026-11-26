/*
=========================================================
           every() and some() IN JAVASCRIPT
=========================================================

---------------------------------------------------------
1) What is every() ?
---------------------------------------------------------

every() checks whether ALL array elements satisfy
a condition or not.

If ALL elements pass:
✔ Returns true

If ANY one element fails:
✔ Returns false

Simple Meaning:
"All elements must be true"

---------------------------------------------------------
2) What is some() ?
---------------------------------------------------------

some() checks whether AT LEAST ONE element satisfies
a condition or not.

If ANY one element passes:
✔ Returns true

If NO elements pass:
✔ Returns false

Simple Meaning:
"At least one element must be true"

---------------------------------------------------------
3) Important Point
---------------------------------------------------------

✔ every() and some() work only with arrays
✔ Commonly used in array traversal
✔ Callback function used internally

---------------------------------------------------------
4) When To Use every() ?
---------------------------------------------------------

Use every() when:
✔ Validate all students passed
✔ Check all users active
✔ Verify all numbers positive
✔ Form validation

---------------------------------------------------------
5) When To Use some() ?
---------------------------------------------------------

Use some() when:
✔ Check any user admin
✔ Check any product out of stock
✔ Check any failed student
✔ Search matching data

---------------------------------------------------------
6) Difference Between every() and some()
---------------------------------------------------------

every()
---------
ALL conditions must be true

some()
--------
At least ONE condition true

=========================================================
                  every() METHOD
=========================================================
*/

console.log("================================================");
console.log("             every() EXAMPLES                   ");
console.log("================================================");

/*
Syntax:

array.every(function(value,index,array){
    return condition;
});
*/

let numbers = [10, 20, 30, 40];

/*
Check all numbers are positive
*/

let result1 = numbers.every(function(value)
{
    return value > 0;
});

console.log("All numbers positive ?");
console.log(result1);





console.log("\n================================================");
console.log("       every() FAIL CONDITION                   ");
console.log("================================================");

let nums = [10, 20, -5, 40];

/*
One value is negative
*/

let result2 = nums.every(function(value)
{
    return value > 0;
});

console.log("All numbers positive ?");
console.log(result2);





/*
=========================================================
                   some() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("              some() EXAMPLES                   ");
console.log("================================================");

/*
Syntax:

array.some(function(value,index,array){
    return condition;
});
*/

let marks = [35, 40, 80, 90];

/*
Check any student failed
*/

let result3 = marks.some(function(value)
{
    return value < 40;
});

console.log("Any student failed ?");
console.log(result3);





console.log("\n================================================");
console.log("        some() NO MATCH CONDITION               ");
console.log("================================================");

let values = [50, 60, 70];

let result4 = values.some(function(value)
{
    return value < 40;
});

console.log("Any value below 40 ?");
console.log(result4);





/*
=========================================================
              ARRAY TRAVERSAL USING every()
=========================================================
*/

console.log("\n================================================");
console.log("        ARRAY TRAVERSAL USING every()           ");
console.log("================================================");

let ages = [18, 22, 25, 30];

/*
every() traverses each element internally
*/

let allAdults = ages.every(function(age, index)
{
    console.log("Index:", index, "Value:", age);

    return age >= 18;
});

console.log("All adults ?");
console.log(allAdults);





/*
=========================================================
              ARRAY TRAVERSAL USING some()
=========================================================
*/

console.log("\n================================================");
console.log("         ARRAY TRAVERSAL USING some()           ");
console.log("================================================");

let products = [100, 200, 0, 400];

/*
Check any product out of stock
*/

let outOfStock = products.some(function(price, index)
{
    console.log("Index:", index, "Value:", price);

    return price === 0;
});

console.log("Any product out of stock ?");
console.log(outOfStock);





/*
=========================================================
                  OBJECT EXAMPLES
=========================================================
*/

console.log("\n================================================");
console.log("          OBJECT WITH every()/some()            ");
console.log("================================================");

/*
every() and some() do NOT work directly on object

Need:
Object.values()
Object.keys()
Object.entries()
*/

let student = {
    name: "Mohit",
    age: 22,
    marks: 80
};

/*
Convert object values into array
*/

let objectValues = Object.values(student);

console.log(objectValues);





console.log("\n================================================");
console.log("       every() WITH OBJECT VALUES               ");
console.log("================================================");

/*
Check all values not empty
*/

let checkObject = Object.values(student).every(function(value)
{
    return value !== "";
});

console.log("All object values valid ?");
console.log(checkObject);





console.log("\n================================================");
console.log("        some() WITH OBJECT VALUES               ");
console.log("================================================");

/*
Check any value is number
*/

let hasNumber = Object.values(student).some(function(value)
{
    return typeof value === "number";
});

console.log("Object contains number ?");
console.log(hasNumber);





/*
=========================================================
               ARRAY OF OBJECT EXAMPLES
=========================================================
*/

console.log("\n================================================");
console.log("           ARRAY OF OBJECT EXAMPLES             ");
console.log("================================================");

let employees = [

    {
        id: 1,
        name: "Amit",
        salary: 50000,
        active: true
    },

    {
        id: 2,
        name: "Rahul",
        salary: 60000,
        active: true
    },

    {
        id: 3,
        name: "Neha",
        salary: 70000,
        active: false
    }
];





console.log("\n================================================");
console.log("       every() IN ARRAY OF OBJECT               ");
console.log("================================================");

/*
Check all employees active
*/

let allActive = employees.every(function(emp)
{
    console.log(emp.name, emp.active);

    return emp.active === true;
});

console.log("All employees active ?");
console.log(allActive);





console.log("\n================================================");
console.log("        some() IN ARRAY OF OBJECT               ");
console.log("================================================");

/*
Check any employee inactive
*/

let anyInactive = employees.some(function(emp)
{
    console.log(emp.name, emp.active);

    return emp.active === false;
});

console.log("Any employee inactive ?");
console.log(anyInactive);





console.log("\n================================================");
console.log("      REAL WORLD every() EXAMPLE                ");
console.log("================================================");

/*
Form Validation
*/

let passwords = ["abc123", "test456", "demo789"];

let allStrong = passwords.every(function(password)
{
    return password.length >= 6;
});

console.log("All passwords strong ?");
console.log(allStrong);





console.log("\n================================================");
console.log("       REAL WORLD some() EXAMPLE                ");
console.log("================================================");

/*
Search banned word
*/

let comments = ["good", "nice", "spam"];

let hasSpam = comments.some(function(comment)
{
    return comment === "spam";
});

console.log("Spam detected ?");
console.log(hasSpam);





console.log("\n================================================");
console.log("          every() vs some()                     ");
console.log("================================================");

console.log(`
every()
---------
✔ All conditions true
✔ Returns false immediately if one fails

some()
--------
✔ At least one condition true
✔ Returns true immediately if one passes
`);





console.log("\n================================================");
console.log("             IMPORTANT NOTES                    ");
console.log("================================================");

console.log(`
✔ every() and some() work only on arrays
✔ Objects need Object.values()
✔ Both use callback function
✔ Both return boolean value
✔ Useful in validation and searching
`);





console.log("\n================================================");
console.log("                FINAL SUMMARY                   ");
console.log("================================================");

console.log(`
every()
---------
Checks ALL elements satisfy condition.

some()
--------
Checks AT LEAST ONE element satisfies condition.

Use Cases
----------
✔ Validation
✔ Searching
✔ Filtering conditions
✔ API response checking
✔ Form checking
`);

console.log("\n================================================");
console.log("                 PROGRAM END                    ");
console.log("================================================");