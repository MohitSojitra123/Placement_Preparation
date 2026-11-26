// Write a program to find maximum no from given 3 no.(without if-else) 

import java.util.Scanner;

public class Program_3 {
     public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);

           System.out.println("Enter Value 1 => ");   
           int value1=sc.nextInt();

           System.out.println("Enter Value 2 => ");
           int value2=sc.nextInt();

           System.out.println("Enter Value 3 => ");
           int value3=sc.nextInt();

           int max=(value1 > value2 ) ?  (value1 > value3) ? value1 : value3 : (value2 > value3) ? value2 : value3 ;

           System.out.println("Max Value Is  =>  "+max);

        }

}
