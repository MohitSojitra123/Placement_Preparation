// WAP to convert a Decimal to Binary. 

import java.util.Scanner;

public class Problem_30 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a Decimal Number: ");
        int decimal = sc.nextInt();

        if (decimal == 0) {
            System.out.println("Binary = 0");
            return;
        }

        String binary = "";

        while (decimal > 0) {
            int rem = decimal % 2;
            binary = rem + binary;
            decimal /= 2;
        }

        System.out.println("Binary = " + binary);

        sc.close();
    }
}

