// WAP to convert a Binary to Decimal.

import java.util.Scanner;

public class Problem_26 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a Binary Number: ");
        int binary = sc.nextInt();

        int decimal = 0;
        int power = 0;

        while (binary > 0) {

            int digit = binary % 10;

            decimal += digit * (int) Math.pow(2, power);

            power++;
            binary /= 10;
        }

        System.out.println("Decimal Number = " + decimal);

        sc.close();
    }
}