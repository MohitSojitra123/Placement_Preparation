// WAP to Convert a Decimal to Octal and vice versa. 

import java.util.Scanner;

public class Question_8_2{
   public static void main(String[] args) {
    
      Scanner sc=new Scanner(System.in);

      System.out.println("Enter Octal Number To Convert Decimal Number : ");
      int num=sc.nextInt();

      int power=0;
      int Decimal_num=0;

      while (num>0) {
        int last_digit=num%10;
         Decimal_num+= last_digit*Math.pow(8, power); 
        num/=10;
        power++;
      }

      System.out.println("Decimal number : "+Decimal_num);

   }
}
