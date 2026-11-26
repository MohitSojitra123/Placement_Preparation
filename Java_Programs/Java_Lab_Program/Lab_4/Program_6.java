// Write a program to find that given Number is palindrome or not.

import java.util.Scanner;

public class Program_6 {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);

        System.out.println("Enter Any Number To Check Number Is Palindrom Or Not => ");
        int user=sc.nextInt();

         int user2=user,last_digit=0,revese_number=0;

         while (user2!=0) {
                last_digit=user2%10;
                revese_number=(revese_number*10)+last_digit;
                user2/=10;
        }

           if(revese_number == user){
            System.out.println("Number Is Palindrome ");
           }else{
            System.out.println("Number Is Not Palindrome ");
           }


    }
}
