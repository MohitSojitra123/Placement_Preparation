class student{

     int roll_number;
     String name,branch;

    student(int roll_number,String name,String branch){
            this.roll_number=roll_number;
            this.name=name;
            this.branch=branch;
    }

    public void print_detail(){
         System.out.println("Roll Number => "+roll_number);
         System.out.println("Name => "+name);
         System.out.println("Branch => "+branch);
    }

    student(student s_detail){
           this.roll_number=s_detail.roll_number;
           this.name=s_detail.name;
           this.branch=s_detail.branch;
    }

}

public class Extra_1 {
    public static void main(String[] args) {
          student s1=new student(101, "Mohit", "MCA");
          System.out.println();
          s1.print_detail();   
          System.out.println();
          student s2=new student(s1);
          System.out.println();
          s2.print_detail();
          System.out.println();
    }
}
