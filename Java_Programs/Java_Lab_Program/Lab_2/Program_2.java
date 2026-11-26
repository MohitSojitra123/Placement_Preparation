// Write a java program to take user input 
// i. Through Command Line Argument.
// ii. Through Scanner class.

import java.util.Scanner;

public class Program_2 {
    public static void main(String[] args) {
        
         System.out.println("First Name => "+args[0]);
         System.out.println("Second Name =>  "+args[1]);

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Your Name : ");
        String name=sc.nextLine();

        System.out.println("Name : "+name);

    }
}
