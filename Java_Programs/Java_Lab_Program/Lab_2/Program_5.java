// Write a program that reads a number in meters, converts it to feet, and displays the result

import java.util.Scanner;

public class Program_5 {
   public static void main(String[] args) {
 
       Scanner sc=new Scanner(System.in);

       System.out.println("Enter Meters => ");
       double user_Meters=sc.nextDouble();

      double feet=user_Meters*3.28084;

      System.out.println("Meters To Convert Feet => "+feet);
   }    
}
