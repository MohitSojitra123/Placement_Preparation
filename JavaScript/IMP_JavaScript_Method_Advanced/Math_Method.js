/*
=========================================================
           JAVASCRIPT MATH METHODS & FUNCTIONS
=========================================================

---------------------------------------------------------
1) What is Math Object ?
---------------------------------------------------------

JavaScript provides a built-in Math object
used for mathematical operations.

Simple Meaning:
"Math object helps perform calculations"

---------------------------------------------------------
2) Why Math Methods are Used ?
---------------------------------------------------------

✔ Calculations
✔ Rounding numbers
✔ Random number generation
✔ Power calculations
✔ Square root
✔ Min/Max value
✔ Trigonometry

---------------------------------------------------------
3) Important Point
---------------------------------------------------------

✔ Math is built-in object
✔ No need to create object
✔ Access using:
   Math.methodName()

Example:
Math.sqrt(25)

---------------------------------------------------------
4) Common Math Methods
---------------------------------------------------------

Math.abs()
Math.round()
Math.ceil()
Math.floor()
Math.trunc()
Math.pow()
Math.sqrt()
Math.cbrt()
Math.max()
Math.min()
Math.random()
Math.PI
Math.sin()
Math.cos()
Math.tan()
Math.log()
Math.exp()

=========================================================
                Math.abs()
=========================================================
*/

console.log("================================================");
console.log("                Math.abs()                      ");
console.log("================================================");

/*
Returns positive value
Absolute value
*/

console.log(Math.abs(-10));

console.log(Math.abs(20));





/*
=========================================================
                Math.round()
=========================================================
*/

console.log("\n================================================");
console.log("               Math.round()                     ");
console.log("================================================");

/*
Rounds to nearest integer
*/

console.log(Math.round(4.4));

console.log(Math.round(4.5));

console.log(Math.round(4.8));





/*
=========================================================
                Math.ceil()
=========================================================
*/

console.log("\n================================================");
console.log("                Math.ceil()                     ");
console.log("================================================");

/*
Rounds UP to next integer
*/

console.log(Math.ceil(4.1));

console.log(Math.ceil(4.9));





/*
=========================================================
                Math.floor()
=========================================================
*/

console.log("\n================================================");
console.log("               Math.floor()                     ");
console.log("================================================");

/*
Rounds DOWN
*/

console.log(Math.floor(4.9));

console.log(Math.floor(4.1));





/*
=========================================================
                Math.trunc()
=========================================================
*/

console.log("\n================================================");
console.log("               Math.trunc()                     ");
console.log("================================================");

/*
Removes decimal part
*/

console.log(Math.trunc(4.9));

console.log(Math.trunc(8.123));





/*
=========================================================
                Math.pow()
=========================================================
*/

console.log("\n================================================");
console.log("                Math.pow()                      ");
console.log("================================================");

/*
Power calculation
*/

console.log(Math.pow(2, 3));

console.log(Math.pow(5, 2));





/*
=========================================================
                Math.sqrt()
=========================================================
*/

console.log("\n================================================");
console.log("               Math.sqrt()                      ");
console.log("================================================");

/*
Square root
*/

console.log(Math.sqrt(25));

console.log(Math.sqrt(81));





/*
=========================================================
                Math.cbrt()
=========================================================
*/

console.log("\n================================================");
console.log("               Math.cbrt()                      ");
console.log("================================================");

/*
Cube root
*/

console.log(Math.cbrt(27));

console.log(Math.cbrt(64));





/*
=========================================================
                Math.max()
=========================================================
*/

console.log("\n================================================");
console.log("                Math.max()                      ");
console.log("================================================");

/*
Largest value
*/

console.log(Math.max(10, 50, 30, 90));





/*
=========================================================
                Math.min()
=========================================================
*/

console.log("\n================================================");
console.log("                Math.min()                      ");
console.log("================================================");

/*
Smallest value
*/

console.log(Math.min(10, 50, 30, 90));





/*
=========================================================
                Math.random()
=========================================================
*/

console.log("\n================================================");
console.log("              Math.random()                     ");
console.log("================================================");

/*
Random number between 0 and 1
*/

console.log(Math.random());

/*
Random integer 1 to 10
*/

let randomNumber =
Math.floor(Math.random() * 10) + 1;

console.log(randomNumber);





/*
=========================================================
                  Math.PI
=========================================================
*/

console.log("\n================================================");
console.log("                  Math.PI                       ");
console.log("================================================");

/*
PI value
*/

console.log(Math.PI);





/*
=========================================================
                Math.sin()
=========================================================
*/

console.log("\n================================================");
console.log("                Math.sin()                      ");
console.log("================================================");

/*
Sine value
*/

console.log(Math.sin(0));





/*
=========================================================
                Math.cos()
=========================================================
*/

console.log("\n================================================");
console.log("                Math.cos()                      ");
console.log("================================================");

/*
Cosine value
*/

console.log(Math.cos(0));





/*
=========================================================
                Math.tan()
=========================================================
*/

console.log("\n================================================");
console.log("                Math.tan()                      ");
console.log("================================================");

/*
Tangent value
*/

console.log(Math.tan(0));





/*
=========================================================
                Math.log()
=========================================================
*/

console.log("\n================================================");
console.log("                Math.log()                      ");
console.log("================================================");

/*
Natural logarithm
*/

console.log(Math.log(1));

console.log(Math.log(10));





/*
=========================================================
                Math.exp()
=========================================================
*/

console.log("\n================================================");
console.log("                Math.exp()                      ");
console.log("================================================");

/*
e power value
*/

console.log(Math.exp(1));





/*
=========================================================
                Math.sign()
=========================================================
*/

console.log("\n================================================");
console.log("                Math.sign()                     ");
console.log("================================================");

/*
Checks positive or negative
*/

console.log(Math.sign(10));

console.log(Math.sign(-10));

console.log(Math.sign(0));





/*
=========================================================
                Math.fround()
=========================================================
*/

console.log("\n================================================");
console.log("               Math.fround()                    ");
console.log("================================================");

/*
32-bit float number
*/

console.log(Math.fround(5.123456789));





/*
=========================================================
                Math.hypot()
=========================================================
*/

console.log("\n================================================");
console.log("               Math.hypot()                     ");
console.log("================================================");

/*
Square root of sum of squares
*/

console.log(Math.hypot(3, 4));





/*
=========================================================
                Math.clz32()
=========================================================
*/

console.log("\n================================================");
console.log("               Math.clz32()                     ");
console.log("================================================");

/*
Leading zero count in 32-bit binary
*/

console.log(Math.clz32(1));





/*
=========================================================
              RANDOM OTP EXAMPLE
=========================================================
*/

console.log("\n================================================");
console.log("            RANDOM OTP EXAMPLE                  ");
console.log("================================================");

/*
Generate 4 digit OTP
*/

let otp =
Math.floor(1000 + Math.random() * 9000);

console.log("OTP:", otp);





/*
=========================================================
            REAL WORLD USE CASES
=========================================================
*/

console.log("\n================================================");
console.log("            REAL WORLD USES                     ");
console.log("================================================");

console.log(`
✔ Game development
✔ OTP generation
✔ Banking calculations
✔ Animation
✔ Data analysis
✔ Scientific calculations
✔ E-commerce discounts
✔ Statistics
✔ Physics calculations
`);





/*
=========================================================
              MOST COMMON METHODS
=========================================================
*/

console.log("\n================================================");
console.log("            MOST USED METHODS                   ");
console.log("================================================");

console.log(`
Math.round()
--------------
Nearest integer

Math.ceil()
-------------
Round up

Math.floor()
--------------
Round down

Math.random()
---------------
Random number

Math.max()
------------
Largest value

Math.min()
------------
Smallest value

Math.sqrt()
-------------
Square root
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
✔ Math is built-in object
✔ No need to create object
✔ Use Math.methodName()
✔ Math.random() heavily used
✔ Math.PI for circle calculations
✔ Math methods return numbers
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
Most Important Methods
-----------------------
✔ Math.round()
✔ Math.ceil()
✔ Math.floor()
✔ Math.random()
✔ Math.max()
✔ Math.min()
✔ Math.sqrt()

Most Common Use
----------------
✔ Calculations
✔ Random values
✔ Rounding
✔ Power/root calculations
✔ Scientific operations
`);

console.log("\n================================================");
console.log("                 PROGRAM END                    ");
console.log("================================================");