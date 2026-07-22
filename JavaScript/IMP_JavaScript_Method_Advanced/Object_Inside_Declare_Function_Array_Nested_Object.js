/*
=========================================================
          OBJECT DECLARATION IN JAVASCRIPT
=========================================================

---------------------------------------------------------
1) What is Object ?
---------------------------------------------------------

Object is used to store data in:
key : value format

Example:
{
   name: "Mohit",
   age: 22
}

---------------------------------------------------------
2) Why Object is Used ?
---------------------------------------------------------

✔ Store related data
✔ Real world entities
✔ User details
✔ API response
✔ Database records

---------------------------------------------------------
3) Object Can Store
---------------------------------------------------------

✔ Variables
✔ Arrays
✔ Functions
✔ Nested objects
✔ Array of objects

---------------------------------------------------------
4) Different Ways to Declare Object
---------------------------------------------------------

1) Object Literal
2) new Object()
3) Constructor Function
4) Function Inside Object
5) Array Inside Object
6) Nested Object
7) Object Inside Array
8) Object.create()

---------------------------------------------------------
5) How To Access Object Data ?
---------------------------------------------------------

1) Dot Notation
   object.key

2) Bracket Notation
   object["key"]

=========================================================
             1) OBJECT LITERAL METHOD
=========================================================
*/

console.log("================================================");
console.log("         OBJECT LITERAL METHOD                  ");
console.log("================================================");

/*
Most common method
*/

let student = {

    name: "Mohit",

    age: 22,

    city: "Rajkot"
};

console.log(student);

/*
Access using dot notation
*/

console.log(student.name);

console.log(student.age);

/*
Access using bracket notation
*/

console.log(student["city"]);





/*
=========================================================
              2) new Object() METHOD
=========================================================
*/

console.log("\n================================================");
console.log("            new Object() METHOD                 ");
console.log("================================================");

let employee = new Object();

employee.id = 101;

employee.name = "Rahul";

employee.salary = 50000;

console.log(employee);

console.log(employee.name);





/*
=========================================================
            3) FUNCTION INSIDE OBJECT
=========================================================
*/

console.log("\n================================================");
console.log("           FUNCTION INSIDE OBJECT               ");
console.log("================================================");

/*
Object methods
*/

let user = {

    username: "Admin",

    login: function()
    {
        console.log("Login Successful");
    },

    logout()
    {
        console.log("Logout Successful");
    }
};

console.log(user.username);

user.login();

user.logout();





/*
=========================================================
              4) ARRAY INSIDE OBJECT
=========================================================
*/

console.log("\n================================================");
console.log("             ARRAY INSIDE OBJECT                ");
console.log("================================================");

let company = {

    companyName: "TCS",

    employees: ["Amit", "Rahul", "Neha"]
};

console.log(company);

/*
Access array inside object
*/

console.log(company.employees);

console.log(company.employees[0]);

console.log(company.employees[1]);





/*
=========================================================
                5) NESTED OBJECT
=========================================================
*/

console.log("\n================================================");
console.log("               NESTED OBJECT                    ");
console.log("================================================");

/*
Object inside object
*/

let person = {

    name: "Mohit",

    address: {

        city: "Rajkot",

        state: "Gujarat",

        country: "India"
    }
};

console.log(person);

/*
Access nested object
*/

console.log(person.address);

console.log(person.address.city);

console.log(person.address.state);





/*
=========================================================
           6) ARRAY OF OBJECTS
=========================================================
*/

console.log("\n================================================");
console.log("             ARRAY OF OBJECTS                   ");
console.log("================================================");

/*
Multiple objects inside array
*/

let students = [

    {
        id: 1,
        name: "Amit",
        marks: 80
    },

    {
        id: 2,
        name: "Rahul",
        marks: 90
    },

    {
        id: 3,
        name: "Neha",
        marks: 95
    }
];

console.log(students);

/*
Access array of object
*/

console.log(students[0]);

console.log(students[0].name);

console.log(students[1].marks);





/*
=========================================================
        TRAVERSAL OF ARRAY OF OBJECT
=========================================================
*/

console.log("\n================================================");
console.log("       ARRAY OF OBJECT TRAVERSAL                ");
console.log("================================================");

/*
Using for loop
*/

for(let i = 0; i < students.length; i++)
{
    console.log(
        students[i].id,
        students[i].name,
        students[i].marks
    );
}





console.log("\n================================================");
console.log("             forEach() TRAVERSAL                ");
console.log("================================================");

students.forEach(function(student)
{
    console.log(
        student.id,
        student.name,
        student.marks
    );
});





/*
=========================================================
             7) OBJECT CREATE METHOD
=========================================================
*/

console.log("\n================================================");
console.log("           Object.create() METHOD               ");
console.log("================================================");

/*
Create object using prototype
*/

let obj = {

    greet()
    {
        console.log("Hello");
    }
};

let newObj = Object.create(obj);

newObj.name = "JavaScript";

console.log(newObj.name);

newObj.greet();





/*
=========================================================
          8) CONSTRUCTOR FUNCTION OBJECT
=========================================================
*/

console.log("\n================================================");
console.log("         CONSTRUCTOR FUNCTION                   ");
console.log("================================================");

/*
Reusable object template
*/

function Mobile(brand, price)
{
    this.brand = brand;

    this.price = price;
}

let mobile1 = new Mobile("Samsung", 50000);

let mobile2 = new Mobile("Apple", 100000);

console.log(mobile1);

console.log(mobile2);





/*
=========================================================
              OBJECT ACCESS METHODS
=========================================================
*/

console.log("\n================================================");
console.log("           OBJECT ACCESS METHODS                ");
console.log("================================================");

let product = {

    productName: "Laptop",

    price: 70000
};

/*
Dot notation
*/

console.log(product.productName);

/*
Bracket notation
*/

console.log(product["price"]);





/*
=========================================================
          OBJECT KEYS VALUES ENTRIES
=========================================================
*/

console.log("\n================================================");
console.log("      Object.keys values entries                ");
console.log("================================================");

let car = {

    brand: "BMW",

    model: "X5",

    price: 9000000
};

/*
Object.keys()
*/

console.log(Object.keys(car));

/*
Object.values()
*/

console.log(Object.values(car));

/*
Object.entries()
*/

console.log(Object.entries(car));





/*
=========================================================
                NESTED ARRAY OBJECT
=========================================================
*/

console.log("\n================================================");
console.log("           NESTED ARRAY OBJECT                  ");
console.log("================================================");

let school = {

    schoolName: "ABC School",

    students: [

        {
            name: "Amit",
            marks: 90
        },

        {
            name: "Rahul",
            marks: 80
        }
    ]
};

console.log(school.schoolName);

console.log(school.students[0].name);

console.log(school.students[1].marks);





/*
=========================================================
             DIFFERENT ACCESS METHODS
=========================================================
*/

console.log("\n================================================");
console.log("           DIFFERENT ACCESS METHODS             ");
console.log("================================================");

console.log(`
1) Dot Notation
----------------
object.key

2) Bracket Notation
-------------------
object["key"]

3) Nested Access
----------------
object.inner.key

4) Array Object Access
-----------------------
array[index].key
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
✔ User details
✔ Product data
✔ API responses
✔ Database records
✔ React props/state
✔ JSON data
✔ Authentication
✔ E-commerce applications
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
✔ Object stores key-value data
✔ Object can contain functions
✔ Object can contain arrays
✔ Nested object possible
✔ Array of object heavily used in APIs
✔ Access using dot or bracket notation
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
Most Common Object Types
-------------------------
✔ Simple Object
✔ Nested Object
✔ Array of Object
✔ Function Inside Object

Most Common Access
-------------------
✔ object.key
✔ object["key"]
✔ array[index].key

Most Used In
-------------
✔ React
✔ Node.js
✔ APIs
✔ MongoDB
✔ JSON
`);

console.log("\n================================================");
console.log("                 PROGRAM END                    ");
console.log("================================================");