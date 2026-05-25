package Lab_9;

// Demonstrate the use of Super Keyword. [A]

class A1{

    int age=20;
    String City="Rajkot";

    A1(){
        System.out.println("A1 Class Constructor Called....");
    }

    A1(String Name){
        System.out.println("A1 Class Name : "+Name);
    }

    void A1_Function(int lucky_number){
        System.out.println("Calling Function In A1 Class....");
        System.out.println("Lucky Number Is "+lucky_number);
    }


}

class A2 extends A1{
    
    A2(){
        super("Mohit");
        System.out.println("A2 Class Constructor Called....");
    }

    void age_city(){
        System.out.println("Age : "+super.age);
        System.out.println("Age : "+super.City);
    }

    void A2_Function(int temp_number){
        System.out.println("--------------------");
        super.A1_Function(temp_number);
        System.out.println("--------------------");
    }



}

public class Program_3 {
    public static void main(String[] args) {

        A2 a2=new A2();
      
        a2.age_city();

        a2.A2_Function(23);

    }
}


