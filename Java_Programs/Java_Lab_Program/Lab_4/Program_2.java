// Write a program to check whether a number is even or odd.

import java.util.Scanner;

public class Program_2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Any Number To Check Number Is Odd Or Even => ");
        int user_number=sc.nextInt();

        if(user_number % 2 == 0 ){
             System.out.println("Number Is Even "+user_number);
        }else{
            System.out.println("Number Is Odd "+user_number);
        }
    }
}
