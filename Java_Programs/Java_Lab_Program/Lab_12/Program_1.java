// Write a program to demonstrate Arithmetic Exception and 
// ArrayIndexOutOfBounds Exception using try-catch block.

public class Program_1 {

    public static void main(String[] args) {

 
        try {
            int a = 10;
            int b = 0;

            int result = a / b;

            System.out.println("Result = " + result);
        }
        catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception Caught!");
            System.out.println(e);
        }


        try {
            int arr[] = {10, 20, 30};

            System.out.println(arr[5]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBounds Exception Caught!");
            System.out.println(e);
        }

        System.out.println("Program Ended Successfully.");
    }
}