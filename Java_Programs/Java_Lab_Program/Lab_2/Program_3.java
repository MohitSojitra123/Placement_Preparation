// Write a java program to take user input 
// ii. Through Scanner class.

import java.util.Scanner;

public class Program_3 {
   public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);

      System.out.println("Enter First Name => ");
      String fname=sc.nextLine();

      System.out.println("Enter Second Name => ");
      String sname=sc.nextLine();

      System.out.println("First Name => "+fname);

      System.out.println("Second Name => "+sname);

   }   
}
