// WAP to find weather given number is Automorphic or not. 
// An automorphic number is a number whose square ends with the same digits as the number itself.  
// For example, 5 is automorphic because 5² = 25, which ends in 5.  
// Similarly, 76 is automorphic because 76² = 5776, which ends in 76.

import java.util.Scanner;

public class Question_4 {
    public static void main(String[] args) {

          Scanner sc=new Scanner(System.in);

        System.out.println("Enter Any Number To Check Number is  Automorphic or Not  : ");
        int num=sc.nextInt();

        int num_squre=num*num;

        String num_str=Integer.toString(num);
        String num_squre_str=Integer.toString(num_squre);


       String temp=num_squre_str.substring(num_squre_str.length()-num_str.length());

      if(num_str.equals(temp)){
          System.out.println("Number Is Automorphic : ");
      }else{
        System.out.println("Number Is Not Automorphic : ");
      }

        

    }
}
