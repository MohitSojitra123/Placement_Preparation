/*
===============================================================================
                    JAVA MATH CLASS - ALL METHODS DEMO
===============================================================================

✔ Covers Basic To Advanced Math Methods
✔ Covers All Static Methods
✔ Covers Overloaded Methods
✔ Covers Constants
✔ Covers Rounding Methods
✔ Covers Trigonometric Methods
✔ Covers Logarithmic Methods
✔ Covers Exponential Methods
✔ Covers Random Methods
✔ Covers Min / Max Methods
✔ Covers Absolute Methods
✔ Covers Real World Examples

PACKAGE:
java.lang.Math (Automatically Imported)

===============================================================================
*/


public class All_Math_Methods {

    public static void main(String[] args) {


        // =========================================================================
        // MATH CONSTANTS
        // =========================================================================


        System.out.println("========= MATH CONSTANTS =========");


        // 1. Math.PI

        System.out.println("\n1. Math.PI");

        System.out.println(Math.PI);



        // 2. Math.E

        System.out.println("\n2. Math.E");

        System.out.println(Math.E);





        // =========================================================================
        // BASIC METHODS
        // =========================================================================



        // 3. abs()

        System.out.println("\n3. Math.abs()");

        System.out.println(Math.abs(-100));

        System.out.println(Math.abs(-55.5));



        // 4. max()

        System.out.println("\n4. Math.max()");

        System.out.println(Math.max(20,50));

        System.out.println(Math.max(10.5,30.5));



        // 5. min()

        System.out.println("\n5. Math.min()");

        System.out.println(Math.min(20,50));

        System.out.println(Math.min(10.5,30.5));




        // =========================================================================
        // POWER AND ROOT METHODS
        // =========================================================================



        // 6. pow()

        System.out.println("\n6. Math.pow()");

        System.out.println(Math.pow(2,3));

        // 2^3 = 8




        // 7. sqrt()

        System.out.println("\n7. Math.sqrt()");

        System.out.println(Math.sqrt(25));




        // 8. cbrt()

        System.out.println("\n8. Math.cbrt()");

        System.out.println(Math.cbrt(27));




        // 9. hypot()

        System.out.println("\n9. Math.hypot()");

        System.out.println(Math.hypot(3,4));




        // =========================================================================
        // ROUNDING METHODS
        // =========================================================================



        // 10. round()

        System.out.println("\n10. Math.round()");

        System.out.println(Math.round(10.5));

        System.out.println(Math.round(10.4));





        // 11. ceil()

        System.out.println("\n11. Math.ceil()");

        System.out.println(Math.ceil(10.1));





        // 12. floor()

        System.out.println("\n12. Math.floor()");

        System.out.println(Math.floor(10.9));





        // 13. rint()

        System.out.println("\n13. Math.rint()");

        System.out.println(Math.rint(10.5));





        // =========================================================================
        // SIGN METHODS
        // =========================================================================




        // 14. signum()

        System.out.println("\n14. Math.signum()");


        System.out.println(Math.signum(-20));

        System.out.println(Math.signum(20));





        // =========================================================================
        // RANDOM METHODS
        // =========================================================================




        // 15. random()

        System.out.println("\n15. Math.random()");


        double randomNumber = Math.random();


        System.out.println(randomNumber);



        // Random Number 1-100


        int random100 = (int)(Math.random()*100)+1;


        System.out.println(random100);





        // =========================================================================
        // TRIGONOMETRIC METHODS
        // =========================================================================




        // 16. sin()


        System.out.println("\n16. Math.sin()");


        System.out.println(Math.sin(Math.PI/2));





        // 17. cos()


        System.out.println("\n17. Math.cos()");


        System.out.println(Math.cos(0));





        // 18. tan()


        System.out.println("\n18. Math.tan()");


        System.out.println(Math.tan(0));





        // 19. asin()


        System.out.println("\n19. Math.asin()");


        System.out.println(Math.asin(1));





        // 20. acos()


        System.out.println("\n20. Math.acos()");


        System.out.println(Math.acos(1));





        // 21. atan()


        System.out.println("\n21. Math.atan()");


        System.out.println(Math.atan(1));





        // 22. atan2()


        System.out.println("\n22. Math.atan2()");


        System.out.println(Math.atan2(10,5));





        // =========================================================================
        // DEGREE AND RADIAN CONVERSION
        // =========================================================================




        // 23. toDegrees()


        System.out.println("\n23. Math.toDegrees()");


        System.out.println(Math.toDegrees(Math.PI));





        // 24. toRadians()


        System.out.println("\n24. Math.toRadians()");


        System.out.println(Math.toRadians(180));






        // =========================================================================
        // LOGARITHMIC METHODS
        // =========================================================================




        // 25. log()


        System.out.println("\n25. Math.log()");


        System.out.println(Math.log(10));





        // 26. log10()


        System.out.println("\n26. Math.log10()");


        System.out.println(Math.log10(100));





        // 27. exp()


        System.out.println("\n27. Math.exp()");


        System.out.println(Math.exp(2));





        // =========================================================================
        // EXACT METHODS
        // =========================================================================




        // 28. addExact()


        System.out.println("\n28. Math.addExact()");


        System.out.println(Math.addExact(10,20));





        // 29. subtractExact()


        System.out.println("\n29. Math.subtractExact()");


        System.out.println(Math.subtractExact(20,10));





        // 30. multiplyExact()


        System.out.println("\n30. Math.multiplyExact()");


        System.out.println(Math.multiplyExact(10,5));





        // 31. incrementExact()


        System.out.println("\n31. Math.incrementExact()");


        System.out.println(Math.incrementExact(10));





        // 32. decrementExact()


        System.out.println("\n32. Math.decrementExact()");


        System.out.println(Math.decrementExact(10));





        // 33. negateExact()


        System.out.println("\n33. Math.negateExact()");


        System.out.println(Math.negateExact(10));





        // =========================================================================
        // FLOOR DIVISION METHODS
        // =========================================================================




        // 34. floorDiv()


        System.out.println("\n34. Math.floorDiv()");


        System.out.println(Math.floorDiv(10,3));





        // 35. floorMod()


        System.out.println("\n35. Math.floorMod()");


        System.out.println(Math.floorMod(10,3));






        // =========================================================================
        // COPY SIGN
        // =========================================================================




        // 36. copySign()


        System.out.println("\n36. Math.copySign()");


        System.out.println(Math.copySign(10,-1));





        // =========================================================================
        // NEXT VALUE METHODS
        // =========================================================================




        // 37. nextAfter()


        System.out.println("\n37. Math.nextAfter()");


        System.out.println(
                Math.nextAfter(1.0,2.0)
        );





        // 38. nextUp()


        System.out.println("\n38. Math.nextUp()");


        System.out.println(Math.nextUp(1.0));





        // 39. nextDown()


        System.out.println("\n39. Math.nextDown()");


        System.out.println(Math.nextDown(1.0));






        // =========================================================================
        // ULP METHOD
        // =========================================================================




        // 40. ulp()


        System.out.println("\n40. Math.ulp()");


        System.out.println(Math.ulp(10.0));






        // =========================================================================
        // FMA METHOD JAVA 9
        // =========================================================================




        // 41. fma()


        System.out.println("\n41. Math.fma()");


        System.out.println(
                Math.fma(2,3,4)
        );

        // (2*3)+4






        // =========================================================================
        // REAL WORLD EXAMPLES
        // =========================================================================



        System.out.println("\n========= REAL WORLD EXAMPLES =========");



        // =========================================================================
        // 1. Find Maximum Salary
        // =========================================================================



        int salary1 = 50000;

        int salary2 = 70000;


        System.out.println(
                "Highest Salary : "
                +
                Math.max(salary1,salary2)
        );




        // =========================================================================
        // 2. Calculate Circle Area
        // =========================================================================


        double radius = 10;


        double area =
                Math.PI * Math.pow(radius,2);



        System.out.println(
                "Circle Area : "
                +
                area
        );





        // =========================================================================
        // 3. Generate OTP
        // =========================================================================


        int otp =
                (int)(Math.random()*9000)+1000;



        System.out.println(
                "OTP : "
                +
                otp
        );





        // =========================================================================
        // 4. Distance Between Two Points
        // =========================================================================


        double distance =
                Math.hypot(5,10);



        System.out.println(
                "Distance : "
                +
                distance
        );




        System.out.println("\n======================================");

        System.out.println(
                "ALL IMPORTANT MATH METHODS COMPLETED"
        );


        System.out.println("======================================");

    }

}