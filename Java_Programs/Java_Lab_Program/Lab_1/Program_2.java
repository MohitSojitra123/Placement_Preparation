// WAP to find a sum of numbers entered by user. (E.g: 582=5+8+2=15)

import java.util.Scanner;

public class Program_2 {
     public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);

         System.out.println("Enter Any Number To Sum Individual Number =>  ");
         int user=sc.nextInt();

         int copy_number=user,last_digit=0,sum=0;

         while(copy_number!=0){
              last_digit=copy_number%10;
              sum+=last_digit;
              copy_number/=10;
         }
         System.out.println("User Input Number Is  =>  "+user+" Individual Digit Sum Is "+sum);
     }
}
