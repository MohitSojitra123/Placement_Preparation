class student{
     int age;
     student(int a){
        this.age=a;
     }

     void pass_by_reference(student obj){
          obj.age=20;
     }

}

public class Extra_1Pass_by_Reference {
     public static void main(String[] args) {
        
          student s1=new student(18);

          System.out.println("Before => " +s1.age);

          s1.pass_by_reference(s1);

          System.out.println("After =>  "+s1.age);

     }
}
