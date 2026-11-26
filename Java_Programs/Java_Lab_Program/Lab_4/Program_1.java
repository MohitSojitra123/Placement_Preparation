// The marks obtained by a student in 5 different subjects are input through the
// keyboard.
// The student gets a division as per the following rules:
// I. Percentage above or equals to 60-first division
// II. Percentage between 50 to 59-second division
// III. Percentage between 40 and 49-Third division
// IV. Percentage less than 40-fail
// Write a program to calculate the division obtained by the student.

import java.util.Scanner;

class   Program_1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int marks_array[]=new int[5],sum=0;

      for(int i=0; i<marks_array.length; i++){
          System.out.println("Enter Subject "+(i+1)+" Marks => ");
          marks_array[i]=sc.nextInt();
          sum+=marks_array[i];
      }   

      double result=(sum/500.00)*100;  
      
      System.out.println("Total Percentage Is => "+result);
      
      if (result >= 60) {
          System.out.println("Result: First Division");
        } else if (result >= 50) {
            System.out.println("Result: Second Division");
        } else if (result >= 40) {
            System.out.println("Result: Third Division");
        } else {
            System.out.println("Result: Fail");
        }
    }
}