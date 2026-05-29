

public class Class_Inside_Static_Class {
    
    static class student{
             String name;
             int roll_number;
    }
    
    public static void main(String[] args) {
           

          student s1=new student();

          s1.name="mohit";
          s1.roll_number=101;

          System.out.println(s1.name);
          System.out.println(s1.roll_number);

    }
}
