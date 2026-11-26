// //  1. Can an abstract class implement an interface? Explain in Detailed With an Example in Real world Programming with an
// // Exam and Technical Interview point of view in java

// // Response: Yes, an abstract class can implement an interface in Java. When an abstract class implements an interface, it is not forced to
// // provide method bodies for the interface's abstract methods. Instead, it can implement some, none, or all of them, thereby deferring the
// // implementation responsibility down to its concrete subclasses


// interface A1{
//      void Print1();

//      void Print2();
// }

// abstract class B1 implements A1{
    
//     public void Display(){
//            System.out.println("Abstract Class Con-Creat Method : ");
//     }

//     public void Print1(){
//         System.out.println("Interface Print 1 Methd : ");
//     }

//     abstract void Show();

// }

// class C1 extends B1{
//        void Show(){
//         System.out.println("Show Method (Abstract Method) Provide Body in C1");
//        }

//        public void Print2(){
//         System.out.println("Print 2 Method : ");
//        }
// }


// public class Abstract_Class_Implement_Interface {
//     public static void main(String[] args) {
     
        
//         //   C1 c1=new C1();

//         //   c1.Display();
//         //   c1.Print1();
//         //   c1.Print2();
//         //   c1.Show();

//         // DMD --> Parent Class Reference Variable and Child Class Object Create

//           B1 c2=new C1();

//           c2.Display();
//           c2.Print1();
//           c2.Print2();
//           c2.Show();

        
//     }
// }