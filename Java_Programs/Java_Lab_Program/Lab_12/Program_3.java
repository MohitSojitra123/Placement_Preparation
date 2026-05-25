// Write a java program to create Custom Exception (DarshanUniException). Catch this
// exception using throw clause and print appropriate message. [A]


class DarshanUniException extends Exception {

    public DarshanUniException(String message) {
        super(message);
    }
}

public class Program_3 {

    public static void checkAge(int age) throws DarshanUniException {

        if (age < 18) {
            throw new DarshanUniException(
                "Student is not eligible for admission."
            );
        }

        System.out.println("Student is eligible for admission.");
    }

    public static void main(String[] args) {

        try {
            checkAge(16);
        }
        catch (DarshanUniException e) {

            System.out.println("Custom Exception Caught!");
            System.out.println(e.getMessage());
        }
    }
}