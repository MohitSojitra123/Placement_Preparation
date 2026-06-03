import java.util.Arrays;

class Student{
       String name;
       int roll_number;
       int marsk[];

       Student(String name,int roll_number,int size){
              this.name=name;
              this.roll_number=roll_number;
              marsk=new int[size];
       }

              Student(String name,int roll_number,int arr[]){
              this.name=name;
              this.roll_number=roll_number;
              marsk=Arrays.copyOf(arr, arr.length);
              }
}

public class Class_Inside_Array_Property_Pass_Array {
    public static void main(String[] args) {
        
        int a[]={10,20,30,40,50,60};


        Student s1=new Student("Mohit", 101, 10);
        Student s2=new Student("Mohit", 101, a);

    }
}