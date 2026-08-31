
class A{

      A(){   // 1st Rus Thissss
        System.out.println("Parent Class Constructor Runnnn : ");
      }

      void Print(){
          System.out.println("Parent Print ()  : ");
      }
}

class B extends A{

       B(){   // 2ed Run Thisssss
        System.out.println("Childe Class Constructor Runnnn : ");
       }

    //   void Print(){
    //        System.out.println("Childe Print() : ");
    //   }
}

public class Dynaminc_Method_Dispatch {
    public static void main(String[] args) {
     
          A a=new B();

          a.Print();
        
    }
}