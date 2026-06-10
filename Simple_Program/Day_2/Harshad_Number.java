package Day_2;

import java.util.Scanner;

public class Harshad_Number {
      public static void main(String[] args) {
        
         Scanner sc=new Scanner(System.in);

         System.out.println("Enter Number To Check Number Is hasrshad Or Not :  ");
         int n=sc.nextInt();

         int n2=n;

         int sum=0;

         while (n!=0) {
             sum+=n%10;
             n/=10; 
         }

         if(n2%sum==0){
            System.out.println("Number Is Harshad : ");
         }else{
            System.out.println("Number Is Not Harshad : ");
         }

      }
}
