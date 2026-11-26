// WAP To Convert Binary To Decimal

import java.util.Scanner;

public class Binary_To_String {
    public static void main(String[] args) {
        
         Scanner sc=new Scanner(System.in);

         System.out.println("Enter Binary Number : ");
         int binary=sc.nextInt();

         int Decimal=0;
         int power=0;

         while (binary!=0) {
                int last_digit=binary%10;
               Decimal+=last_digit*(Math.pow(2, power));
               power++;
               binary/=10;
         }

         System.out.println("Decimal Number Is : "+Decimal);

    }
}
