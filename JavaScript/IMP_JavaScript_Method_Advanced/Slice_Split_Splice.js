/*
=========================================================
JavaScript slice(), split(), splice() Full Example
=========================================================

1) slice()
---------------------------------------------------------
Definition:
slice() is used to extract/copy a portion of an array
or string without changing the original data.

Use:
- Copy array elements
- Extract part of string
- Pagination
- Clone array

Syntax:
array.slice(start, end)
string.slice(start, end)

Important:
- end index is NOT included
- Original array/string does NOT change


2) split()
---------------------------------------------------------
Definition:
split() is used to convert a string into an array.

Use:
- Convert CSV data
- Separate words
- Convert characters into array
- Parse user input

Syntax:
string.split(separator)

Important:
- Works ONLY on strings
- Returns array
- Original string does NOT change


3) splice()
---------------------------------------------------------
Definition:
splice() is used to add, remove, or replace elements
inside an array.

Use:
- Delete element
- Insert element
- Update array
- Modify original array

Syntax:
array.splice(start, deleteCount, item1, item2)

Important:
- Original array CHANGES
- Works ONLY on arrays
=========================================================
*/

console.log("================================================");
console.log("                slice() Examples                ");
console.log("================================================");

/*
---------------------------------------------------------
slice() with Array
---------------------------------------------------------
*/

let numbers = [10, 20, 30, 40, 50, 60];

console.log("Original Array:");
console.log(numbers);

/*
slice(start, end)

Start from index 1
Stop before index 4
*/

let slicedArray = numbers.slice(1, 4);

console.log("slice(1,4) Result:");
console.log(slicedArray);

console.log("Original Array After slice():");
console.log(numbers);

/*
Negative Index Example
*/

let negativeSlice = numbers.slice(-3);

console.log("slice(-3) Result:");
console.log(negativeSlice);

/*
---------------------------------------------------------
slice() with String
---------------------------------------------------------
*/

let language = "JavaScript";

console.log("Original String:");
console.log(language);

let slicedString = language.slice(0, 4);

console.log("slice(0,4) Result:");
console.log(slicedString);

console.log("Original String After slice():");
console.log(language);





console.log("\n================================================");
console.log("                split() Examples                ");
console.log("================================================");

/*
---------------------------------------------------------
split() with Space
---------------------------------------------------------
*/

let fruits = "apple banana mango orange";

console.log("Original String:");
console.log(fruits);

/*
split(" ")

Split string using space
*/

let fruitsArray = fruits.split(" ");

console.log('split(" ") Result:');
console.log(fruitsArray);

/*
---------------------------------------------------------
split() with Comma
---------------------------------------------------------
*/

let colors = "red,blue,green,yellow";

console.log("Original String:");
console.log(colors);

/*
split(",")

Split string using comma
*/

let colorArray = colors.split(",");

console.log('split(",") Result:');
console.log(colorArray);

/*
---------------------------------------------------------
split() Character by Character
---------------------------------------------------------
*/

let word = "HELLO";

console.log("Original String:");
console.log(word);

/*
split("")

Convert each character into array element
*/

let characters = word.split("");

console.log('split("") Result:');
console.log(characters);





console.log("\n================================================");
console.log("               splice() Examples                ");
console.log("================================================");

/*
---------------------------------------------------------
splice() Remove Elements
---------------------------------------------------------
*/

let marks = [90, 80, 70, 60, 50];

console.log("Original Array:");
console.log(marks);

/*
splice(start, deleteCount)

Start from index 1
Remove 2 elements
*/

let removedItems = marks.splice(1, 2);

console.log("Removed Elements:");
console.log(removedItems);

console.log("Array After splice():");
console.log(marks);

/*
---------------------------------------------------------
splice() Add Elements
---------------------------------------------------------
*/

let nums = [1, 2, 5];

console.log("Original Array:");
console.log(nums);

/*
splice(2,0,3,4)

Start at index 2
Remove 0 elements
Add 3 and 4
*/

nums.splice(2, 0, 3, 4);

console.log("Array After Adding Elements:");
console.log(nums);

/*
---------------------------------------------------------
splice() Replace Elements
---------------------------------------------------------
*/

let students = ["Amit", "Rahul", "Neha"];

console.log("Original Array:");
console.log(students);

/*
splice(1,1,"Mohit")

Start from index 1
Remove 1 element
Add "Mohit"
*/

students.splice(1, 1, "Mohit");

console.log("Array After Replace:");
console.log(students);





console.log("\n================================================");
console.log("          slice vs split vs splice              ");
console.log("================================================");

console.log(`
slice()
--------
- Copy/extract data
- Works with array and string
- Original data NOT changed

split()
--------
- Convert string into array
- Works only with string
- Original string NOT changed

splice()
---------
- Add/remove/replace array elements
- Works only with array
- Original array changed
`);





console.log("\n================================================");
console.log("               Real World Examples              ");
console.log("================================================");

/*
---------------------------------------------------------
slice() Real Example
Pagination
---------------------------------------------------------
*/

let users = ["A", "B", "C", "D", "E", "F"];

let firstPage = users.slice(0, 3);

console.log("Pagination using slice():");
console.log(firstPage);

/*
---------------------------------------------------------
split() Real Example
CSV Data
---------------------------------------------------------
*/

let csvData = "Virat,Rohit,Dhoni,Sachin";

let players = csvData.split(",");

console.log("CSV split Example:");
console.log(players);

/*
---------------------------------------------------------
splice() Real Example
Delete Cart Item
---------------------------------------------------------
*/

let cart = ["Laptop", "Mouse", "Keyboard", "Mobile"];

console.log("Original Cart:");
console.log(cart);

/*
Remove Keyboard
*/

cart.splice(2, 1);

console.log("Cart After Delete:");
console.log(cart);





console.log("\n================================================");
console.log("                 Program End                    ");
console.log("================================================");