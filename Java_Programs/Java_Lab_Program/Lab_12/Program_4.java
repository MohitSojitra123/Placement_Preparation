// Write a Java program that divides two numbers. If Num1 or Num2 were not an integer,
// the program would throw a Number Format Exception. If Num2 were Zero, the program
// would throw an Arithmetic Exception. Display appropriate message for each exception.
// [B]

public class Program_4 {

    public static void main(String[] args) {

        // Change values to test exceptions
        String num1 = "20";
        String num2 = "0";

        try {

            // Convert String to Integer
            int a = Integer.parseInt(num1);
            int b = Integer.parseInt(num2);

            // Division
            int result = a / b;

            System.out.println("Result = " + result);
        }

        // Handle invalid integer input
        catch (NumberFormatException e) {

            System.out.println("Number Format Exception Caught!");
            System.out.println("Please enter valid integer values.");
        }

        // Handle divide by zero
        catch (ArithmeticException e) {

            System.out.println("Arithmetic Exception Caught!");
            System.out.println("Number cannot be divided by zero.");
        }

        // General Exception
        catch (Exception e) {

            System.out.println("Some Other Exception Occurred!");
            System.out.println(e);
        }

        System.out.println("Program Ended.");
    }
}