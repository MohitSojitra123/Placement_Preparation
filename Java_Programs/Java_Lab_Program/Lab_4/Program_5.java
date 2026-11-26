// Write a program to check whether a year is leap year or not.[

import java.util.Scanner;

public class Program_5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter Any Year Check Year Is Leap Or Not ");
       int year=sc.nextInt();

       if((year%4 == 0 && year%100 != 0) || (year%400==0)){
          System.out.println("Year Is Lepa => "+year);
       }else{
        System.out.println("Year Is Not Leap => "+year);
       }
     
    }
}
