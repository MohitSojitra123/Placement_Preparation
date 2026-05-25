/*
=========================================================
              JAVASCRIPT ARRAY METHODS
=========================================================

---------------------------------------------------------
1) What is Array ?
---------------------------------------------------------

Array is used to store multiple values in a single
variable.

Example:
[10,20,30]

---------------------------------------------------------
2) What is Array of Object ?
---------------------------------------------------------

Array containing multiple objects.

Example:
[
   {id:1,name:"Amit"},
   {id:2,name:"Rahul"}
]

---------------------------------------------------------
3) Why Array Methods are Used ?
---------------------------------------------------------

✔ Easy data management
✔ Traversal
✔ Filtering
✔ Searching
✔ Transformation
✔ Sorting
✔ Calculations

---------------------------------------------------------
4) Common Array Methods
---------------------------------------------------------

push()     -> Add element at end
pop()      -> Remove element from end
shift()    -> Remove first element
unshift()  -> Add element at beginning
slice()    -> Copy portion
splice()   -> Add/remove/update
map()      -> Transform array
filter()   -> Filter data
reduce()   -> Single value calculation
sort()     -> Sort elements
indexOf()  -> Find index
find()     -> Find first matching element

---------------------------------------------------------
5) Traversal Methods
---------------------------------------------------------

for
while
do...while
for...in
for...of
forEach

=========================================================
                    ARRAY METHODS
=========================================================
*/

console.log("================================================");
console.log("                 push()                         ");
console.log("================================================");

/*
Add element at END
*/

let numbers = [10, 20, 30];

numbers.push(40);

console.log(numbers);





console.log("\n================================================");
console.log("                  pop()                         ");
console.log("================================================");

/*
Remove last element
*/

let colors = ["Red", "Blue", "Green"];

colors.pop();

console.log(colors);





console.log("\n================================================");
console.log("                 shift()                        ");
console.log("================================================");

/*
Remove first element
*/

let fruits = ["Apple", "Mango", "Banana"];

fruits.shift();

console.log(fruits);





console.log("\n================================================");
console.log("                unshift()                       ");
console.log("================================================");

/*
Add element at beginning
*/

let city = ["Rajkot", "Ahmedabad"];

city.unshift("Surat");

console.log(city);





console.log("\n================================================");
console.log("                 slice()                        ");
console.log("================================================");

/*
Copy portion of array
Original array NOT changed
*/

let marks = [10, 20, 30, 40, 50];

let result1 = marks.slice(1, 4);

console.log(result1);
console.log(marks);





console.log("\n================================================");
console.log("                 splice()                       ");
console.log("================================================");

/*
Add/remove/update
Original array changes
*/

let nums = [1, 2, 3, 4];

nums.splice(1, 2);

console.log(nums);





console.log("\n================================================");
console.log("                  map()                         ");
console.log("================================================");

/*
Transform array
Returns NEW array
*/

let prices = [100, 200, 300];

let gstPrice = prices.map(function(value)
{
    return value + 18;
});

console.log(gstPrice);





console.log("\n================================================");
console.log("                 filter()                       ");
console.log("================================================");

/*
Filter matching data
*/

let age = [12, 18, 25, 15];

let adults = age.filter(function(value)
{
    return value >= 18;
});

console.log(adults);





console.log("\n================================================");
console.log("                 reduce()                       ");
console.log("================================================");

/*
Convert array into single value
*/

let values = [10, 20, 30];

let total = values.reduce(function(sum, value)
{
    return sum + value;
}, 0);

console.log(total);





console.log("\n================================================");
console.log("                  sort()                        ");
console.log("================================================");

/*
Sort elements
*/

let arr = [50, 10, 30, 20];

arr.sort(function(a, b)
{
    return a - b;
});

console.log(arr);





console.log("\n================================================");
console.log("                indexOf()                       ");
console.log("================================================");

/*
Find index of element
*/

let language = ["Java", "Python", "JS"];

console.log(language.indexOf("Python"));





console.log("\n================================================");
console.log("                  find()                        ");
console.log("================================================");

/*
Find first matching element
*/

let salary = [10000, 20000, 30000];

let found = salary.find(function(value)
{
    return value > 15000;
});

console.log(found);





/*
=========================================================
                ARRAY OF OBJECT METHODS
=========================================================
*/

console.log("\n================================================");
console.log("            ARRAY OF OBJECT                     ");
console.log("================================================");

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

console.log(employees);





console.log("\n================================================");
console.log("        map() IN ARRAY OF OBJECT                ");
console.log("================================================");

/*
Get all employee names
*/

let employeeNames = employees.map(function(emp)
{
    return emp.name;
});

console.log(employeeNames);





console.log("\n================================================");
console.log("      filter() IN ARRAY OF OBJECT               ");
console.log("================================================");

/*
Salary greater than 55000
*/

let highSalary = employees.filter(function(emp)
{
    return emp.salary > 55000;
});

console.log(highSalary);





console.log("\n================================================");
console.log("       reduce() IN ARRAY OF OBJECT              ");
console.log("================================================");

/*
Total salary
*/

let totalSalary = employees.reduce(function(sum, emp)
{
    return sum + emp.salary;
}, 0);

console.log(totalSalary);





console.log("\n================================================");
console.log("        find() IN ARRAY OF OBJECT               ");
console.log("================================================");

/*
Find employee by id
*/

let employee = employees.find(function(emp)
{
    return emp.id === 2;
});

console.log(employee);





/*
=========================================================
                     TRAVERSAL
=========================================================
*/

console.log("\n================================================");
console.log("              ARRAY TRAVERSAL                   ");
console.log("================================================");

let data = [10, 20, 30, 40];





console.log("\n================================================");
console.log("                  for LOOP                      ");
console.log("================================================");

for(let i = 0; i < data.length; i++)
{
    console.log(data[i]);
}





console.log("\n================================================");
console.log("                while LOOP                      ");
console.log("================================================");

let i = 0;

while(i < data.length)
{
    console.log(data[i]);

    i++;
}





console.log("\n================================================");
console.log("              do while LOOP                     ");
console.log("================================================");

let j = 0;

do
{
    console.log(data[j]);

    j++;

} while(j < data.length);





console.log("\n================================================");
console.log("                 for...in                       ");
console.log("================================================");

/*
Returns indexes
*/

for(let index in data)
{
    console.log(index, data[index]);
}





console.log("\n================================================");
console.log("                 for...of                       ");
console.log("================================================");

/*
Returns values
*/

for(let value of data)
{
    console.log(value);
}





console.log("\n================================================");
console.log("                 forEach()                      ");
console.log("================================================");

data.forEach(function(value, index)
{
    console.log(index, value);
});





/*
=========================================================
          ARRAY OF OBJECT TRAVERSAL
=========================================================
*/

console.log("\n================================================");
console.log("         ARRAY OF OBJECT TRAVERSAL              ");
console.log("================================================");





console.log("\n================================================");
console.log("               for LOOP                         ");
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
console.log("              for...of LOOP                     ");
console.log("================================================");

for(let emp of employees)
{
    console.log(
        emp.id,
        emp.name,
        emp.salary
    );
}





console.log("\n================================================");
console.log("              forEach LOOP                      ");
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
console.log("              METHOD DIFFERENCE                 ");
console.log("================================================");

console.log(`
push()
-------
Add at end

pop()
------
Remove from end

shift()
--------
Remove first

unshift()
----------
Add at beginning

slice()
--------
Copy portion

splice()
---------
Modify original array

map()
------
Transform array

filter()
---------
Filter matching data

reduce()
---------
Single calculated value

sort()
-------
Sort array

indexOf()
----------
Find index

find()
-------
Find first matching value
`);





console.log("\n================================================");
console.log("                FINAL SUMMARY                   ");
console.log("================================================");

console.log(`
Most Used Methods
------------------
✔ map()
✔ filter()
✔ reduce()
✔ forEach()
✔ find()

Best Traversal Loops
--------------------
✔ for
✔ for...of
✔ forEach

Array of Object
----------------
Used heavily in:
✔ React
✔ Node.js
✔ APIs
✔ Database Results
`);

console.log("\n================================================");
console.log("                 PROGRAM END                    ");
console.log("================================================");