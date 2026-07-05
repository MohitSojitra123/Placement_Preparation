
// Rule: If a parent class has no no-argument constructor, every child constructor must explicitly invoke one of the parent's parameterized constructors using super(...).

// A child object always contains a parent object. Therefore, Java requires the parent constructor to run first. If the parent has only a parameterized constructor, the child must pass the required values using super(...) so the parent part of the object can be initialized correctly.

class Parent{
    int age;
    String name;

    Parent(int age,String name){
           this.age=age;
           this.name=name;
           System.out.println("Value Set :  parent Class Constructor : ");
    }

   void  Display(){
     System.out.println("This Is Parent Class : ");
    } 

}


class Child extends Parent{

    int Expre=0;

    Child(int age,String name,int Expirence){
        super(age,name);
        Expre=Expirence;
        System.out.println("Working Properlyyy Child Class Constructor :  : "+Expre);
    }


    void Display(){
        System.out.println("This Is Childe Class : ");
    }
}


public class Childe_Constuct_Initialize_Parent_Constructore {

   public static void main(String[] args) {
     Child ch=new Child(21, "Mohit Sojitra : ",6);
   }
    
}