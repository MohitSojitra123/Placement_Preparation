// Write a program to create basic calculator by getting 2 numbers and an operation(+,-
// ,/,*,%) from the user and apply the operation given in a string on the given numbers.

import java.util.Scanner;

public class Program_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: two numbers
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        // Input: operation
        System.out.print("Enter an operator (+, -, *, /, %): ");
        String op = sc.next();

        double result;

        // Perform operation based on user input
        switch (op) {
            case "+":
                result = num1 + num2;
                System.out.println("Result: " + result);
                break;

            case "-":
                result = num1 - num2;
                System.out.println("Result: " + result);
                break;

            case "*":
                result = num1 * num2;
                System.out.println("Result: " + result);
                break;

            case "/":
                if (num2 != 0)
                    result = num1 / num2;
                else {
                    System.out.println("Error: Division by zero!");
                    sc.close();
                    return;
                }
                System.out.println("Result: " + result);
                break;

            case "%":
                if (num2 != 0)
                    result = num1 % num2;
                else {
                    System.out.println("Error: Division by zero!");
                    sc.close();
                    return;
                }
                System.out.println("Result: " + result);
                break;

            default:
                System.out.println("Invalid operator!");
        }

        sc.close();
    }
}
