// Write a program that prompts the user to enter three numbers. Find the largest
// number.

import java.util.Scanner;


public class Program_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: three numbers
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        System.out.print("Enter third number: ");
        double num3 = sc.nextDouble();

        double largest;

        // Logic to find the largest number
        if (num1 >= num2 && num1 >= num3) {
            largest = num1;
        } else if (num2 >= num1 && num2 >= num3) {
            largest = num2;
        } else {
            largest = num3;
        }

        // Output: display the largest number
        System.out.println("The largest number is: " + largest);

        sc.close();
    }
}
