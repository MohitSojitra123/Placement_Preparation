// Write a program in java if number is less than 10 and greater than 50, it generate the
// exception out of range. Else it displays the square of number. [C]
    
// Program to check number range and generate exception

class OutOfRangeException extends Exception {

    public OutOfRangeException(String message) {
        super(message);
    }
}

public class Program_5 {

    public static void checkNumber(int num) throws OutOfRangeException {

        // Check range
        if (num < 10 || num > 50) {

            throw new OutOfRangeException(
                "Number is out of range! Enter number between 10 and 50."
            );
        }

        // Display square
        int square = num * num;

        System.out.println("Square of " + num + " = " + square);
    }

    public static void main(String[] args) {

        int num = 60;

        try {

            checkNumber(num);
        }
        catch (OutOfRangeException e) {

            System.out.println("Exception Caught!");
            System.out.println(e.getMessage());
        }
    }
}