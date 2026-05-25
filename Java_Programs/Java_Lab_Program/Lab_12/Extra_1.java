class A1 {
    int  age;
    String name;
}



public class Extra_1 {
public static void main(String[] args) {
    
      A1 a1=new A1();

      a1.age=20;
      a1.name="Mohit";

      A1 a2=new A1();
      a2=a1;

      System.out.println("----------------------------");
      System.out.println("a2 age : "+a2.age);
      System.out.println("a2 name :  "+a2.name);
      System.out.println("----------------------------");

      a1=null;

      System.out.println("----------------------------");
      System.out.println("a2 age : "+a2.age);
      System.out.println("a2 name :  "+a2.name);
      System.out.println("----------------------------");


      
}
    
}