// Write a Java program to create a class called Area with a static final variable PI=3.14159.
// Implement a method to calculate the area of a circle given its radius.[B]

class area{
      static final double pi=3.14159;

      area(double a){
        System.out.println("--------------------------");
        System.out.println("Area Of Circle => "+pi*(a*a));
        System.out.println("--------------------------");
      }
}

public class program_4 {
    public static void main(String[] args) {
        
           area a1=new area(10);

    }
}
