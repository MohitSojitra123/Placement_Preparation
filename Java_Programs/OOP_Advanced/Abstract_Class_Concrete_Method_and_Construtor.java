// // Why Are Concrete Methods Allowed?
// // The main purpose of an abstract class is to provide a base template or common logic for a family of related classes. Concrete methods inside an
// // abstract class allow you to write common logic once (ensuring code reusability and following the DRY — Don't Repeat Yourself — principle).
// // Subclasses inherit these concrete methods directly and can either use them as-is or override them if custom behavior is needed.


// // Why Does an Abstract Class Have a Constructor if It Cannot Be Instantiated?
// // While you cannot instantiate an abstract class directly using new AbstractClass(), its constructor plays a vital role during subclass object
// // creation:
// // 1. State Initialization: An abstract class can define instance variables (e.g., id, createdDate). The constructor of the abstract class initializes
// // these fields.
// // 2. Constructor Chaining (super()): When you instantiate a concrete subclass object (new SubClass()), the subclass constructor implicitly or
// // explicitly calls super() to execute the superclass (abstract class) constructor first.



// abstract class A{
    
//       int age;

//       A(int a){
//           this.age=a;
//       }

//       public abstract void Print();

//       public void Display(){
//         System.out.println("Display Method : ");
//       }

// }


// class B extends A{

//      B(int age){
//        super(age);
//      }
      
//     public void Print(){
//         System.out.println("Print Method :");
//     }

//     // Not Declare Same Method 

//     // public void Print(){
//     //     System.out.println("Print Method");
//     // }

    
//     public void Print(String str){
//         System.out.println("Print Method : "+str);
//     }



// }


// public class Abstract_Class_Concrete_Method_and_Construtor {
//     public static void main(String[] args) {
        
//         B b=new B(10);

//         b.Print();
//         b.Display();
//         System.out.println(b.age);
//         b.Print("Mohit");

//     }
// }
