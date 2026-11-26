// WAP to Convert a Decimal to Octal and vice versa. 

import java.util.Scanner;

public class Question_8_1 {
    public static void main(String[] args) {

      Scanner sc=new Scanner(System.in);

      System.out.println("Enter Decimal Number To Convert Octal : ");
      int num=sc.nextInt();

      StringBuilder Str_Octal=new StringBuilder();

      while (num>0) {
            int reminder=num%8;
             Str_Octal.insert(0, reminder);
            num/=8;
      }
      
      System.out.println(Str_Octal.toString());

    }
}
