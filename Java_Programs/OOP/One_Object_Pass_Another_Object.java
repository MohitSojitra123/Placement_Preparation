class Studet{
    String name;
}


public class One_Object_Pass_Another_Object {
    public static void main(String[] args) {
        

        Student s1=new Student();

        s1.name="Mohit";

        Student s2=s1;

        System.out.println("S2 :"+s2.name);
        

        // s1.name="Rohit";
        s2.name="Raj";
        
        System.out.println("S2 : "+s2.name);
        
        System.out.println("S1 :  "+s1.name);
    }
}
