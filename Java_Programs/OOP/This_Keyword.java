class student1{
     int roll_number;
     String name;
     String city;
     
     
     student1(int roll_number,String name,String city){
         this.roll_number=roll_number;
         this.name=name;
         this.city=city;
     }


}

public class This_Keyword {
    public static void main(String[] args) {
        
        
        student1 s1=new student1(101, "Mohit", "Rajkot");

        System.out.println(s1.roll_number);
        System.out.println(s1.name);
        System.out.println(s1.city);


    }
}
