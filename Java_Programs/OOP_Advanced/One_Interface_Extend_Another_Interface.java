// interface  A{
//         public void PrintA();  

//         default void DisplayA(){
//             System.out.println("Interface A Default Method :");
//         }
// }

// interface B extends A{
//         public void PrintB();  

//         default void DisplayB(){
//             System.out.println("Interface B Default Method :");
//         }
// }

// interface C extends B{
//                public void PrintC();  

//         default void DisplayC(){
//             System.out.println("Interface C Default Method :");
//         }
// }


// class D implements C{
  
//       public void PrintA() {
//           System.out.println("Print A ");   
//       }
//       public void PrintB() {
//           System.out.println("Print B ");   
//       }
//       public void PrintC() {
//           System.out.println("Print C ");   
//       }


// }


// public class One_Interface_Extend_Another_Interface {
//      public static void main(String[] args) {
        
//            D d1=new D();

//            d1.PrintA();
//            d1.PrintB();
//            d1.PrintC();

//            d1.DisplayA();
//            d1.DisplayB();
//            d1.DisplayC();

//         A a1;
//         a1=new D();
//         a1.PrintA();
//         a1.DisplayA();

//         B b1;
//         b1=new D();
//         b1.PrintA();
//         b1.PrintB();
//         b1.DisplayA();
//         b1.DisplayB();


//         C c1;
//         c1=new D();
//         c1.PrintA();
//         c1.PrintB();
//         c1.PrintC();
//         c1.DisplayA();
//         c1.DisplayB();
//         c1.DisplayC();

        

//      }
// }
