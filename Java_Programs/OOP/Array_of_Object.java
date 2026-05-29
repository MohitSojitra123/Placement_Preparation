import java.util.Scanner;

class Student{
       int roll_number;
       String name;
       float marks;
}


class Array_of_Object{
    public static void main(String args[]){
           Scanner sc=new Scanner(System.in);
        
        Student[] all_stu=new Student[3];

        for(int i=0; i<all_stu.length; i++){
             all_stu[i]=new Student();
        
             System.out.println();
             
             System.out.println("Enter Roll Number : ");
             all_stu[i].roll_number=sc.nextInt();

             System.out.println();

             System.out.println("Enter Name : ");
             all_stu[i].name=sc.nextLine();
             sc.next();

             System.out.println();
             
             System.out.println("Enter Marks : ");
             all_stu[i].marks=sc.nextFloat();
             
             System.out.println();
        
            }

        for(int i=0; i<all_stu.length; i++){
            System.out.println("Roll Number : "+all_stu[i].roll_number);
            System.out.println("Name  : "+all_stu[i].name);
            System.out.println("Marks  : "+all_stu[i].marks);
            System.out.println("\n------------------\n");
        }


    }
}