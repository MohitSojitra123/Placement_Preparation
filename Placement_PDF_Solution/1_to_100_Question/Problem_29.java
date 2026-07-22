// WAP to find a quotient and reminder of 2 number (bigger number should be divided by 
// lower number) and you are not allowed to use a division and quotient operator.
// import java.util.Scanner;

// Enter First Number: 25
// Enter Second Number: 7

// Dividend : 25
// Divisor  : 7
// Quotient : 3
// Remainder: 4

import java.util.*;

public class Problem_29 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.print("Enter First Number: ");
        int num1 = sc.nextInt();   //25

        System.out.print("Enter Second Number: ");
        int num2 = sc.nextInt();  //7

        int dividend, divisor;

        if (num1 > num2) {
            dividend = num1;   //25
            divisor = num2;  // 7
        } else {
            dividend = num2;
            divisor = num1;
        }

        int quotient = 0;
        int remainder = dividend;

        while (remainder >= divisor) {
            remainder = remainder - divisor;
            quotient++;
        }

        System.out.println("Dividend : " + dividend);
        System.out.println("Divisor  : " + divisor);
        System.out.println("Quotient : " + quotient);
        System.out.println("Remainder: " + remainder);

        sc.close();
    }
}

