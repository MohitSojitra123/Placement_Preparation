// Write a program to create circle class with area function to find area of circle. 

import java.util.Scanner;

class Circle{
        Circle(){
            Scanner sc=new Scanner(System.in);
            Double a;
            System.out.println("Enter Value =>");
            a=sc.nextDouble();

             System.out.println("Area Of Circle => "+(3.14*(a*a)));

       }
}

public class Program_1 {
      public static void main(String[] args) {     
            Circle c1=new Circle();   
      }
}
