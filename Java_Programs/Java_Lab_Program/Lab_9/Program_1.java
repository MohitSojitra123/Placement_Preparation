package Lab_9;

import java.util.Scanner;

// 1 Declare a class called Student having following data members:id_no, 
// no_of_subjects_registered, subject_code, subject_credits, grade_obtained and spi. 
// Define constructor and calculate_spi methods. Define main to instantiate an array for 
// objects of class student to process data of n students [A] 

class Student{

       int id_no;
       int no_of_subjects_registered;  // 5 subject
       int subject_code[];   // random
       int subject_credits[];  //  credit 5 4  3 ... etc
       double spi;
       char grade_obtained[];  // a b c
       

       Student(){
           Scanner sc=new Scanner(System.in);

          System.out.println("Enter Student Id => ");
          this.id_no=sc.nextInt();
          System.out.println("---------------------------------");
          
          System.out.println("Enter Number Of Subject => ");
          this.no_of_subjects_registered=sc.nextInt();
          System.out.println("---------------------------------");

          this.subject_code=new int [no_of_subjects_registered];
          this.subject_credits=new int[no_of_subjects_registered];
          this.grade_obtained   =new char[no_of_subjects_registered];

          for(int i=0; i<no_of_subjects_registered; i++){
                System.out.println("---------------------------------------");      
                System.out.println("Enter Student Subject Code => "+(i+1));
                subject_code[i]=sc.nextInt();
                System.out.println("---------------------------------------");      
                System.out.println("Enter Subject Credits => "+(i+1));
                subject_credits[i]=sc.nextInt();
                System.out.println("---------------------------------------");      
                System.out.println("Enter Obtained Greade => "+(i+1));
                grade_obtained[i]=sc.next().charAt(0);
                System.out.println("---------------------------------------");      
          }

        //   display data
        System.out.println("-------------------------------------"); 
        System.out.println("Student Roll Number => "+id_no);
        System.out.println("-------------------------------------"); 
        for(int i=0; i<no_of_subjects_registered; i++){
            System.out.println("-------------------------------------------");
            System.out.println("Student Subject Code => "+subject_code[i]);
            System.out.println("Student Subejct Credits => "+subject_credits[i]);
            System.out.println("Student Obtained Greade => "+grade_obtained[i]);
            System.out.println("-------------------------------------------");
        }        

    }
    //   display data
    

        int GradeToPoint(char ch){
        ch=Character.toUpperCase(ch);

        switch (ch) {
            case 'A': return 10;
            case 'B': return 8;
            case 'C': return 6;
            case 'D': return 4;
            case 'E': return 2;
            case 'F': return 0;
            default : return 0;   
        }
    }

    public double find_spi(char[] grade_obtained,int[] subject_credits){
            int totalCredits=0;
            int totalPoints=0;

            for(int i=0; i<no_of_subjects_registered; i++){
                 int points=GradeToPoint(grade_obtained[i]);
                 totalPoints+=points*subject_credits[i];
                 totalCredits+=subject_credits[i];
            }

            if (totalCredits == 0) return 0.0;
            return totalPoints/totalCredits;
    }




}

public class Program_1 {
    public static void main(String[] args) {
         Student s1=new Student();    
         System.out.println("----------------SPI------------");
         System.out.println(s1.find_spi(s1.grade_obtained,s1.subject_credits));  
         System.out.println("----------------SPI------------");
    }
}
