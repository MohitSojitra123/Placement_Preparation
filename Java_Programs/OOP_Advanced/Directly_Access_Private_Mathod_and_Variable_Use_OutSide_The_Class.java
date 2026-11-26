// class A{
//     private  int PIN=1234;

//     private  void DisplayPIN(){
//         System.out.println("PIN : "+PIN);
//     }

//     public  void GetPIN(){
//         System.out.println("PIN : "+PIN);
//     }

//     public  void SetPIN(int New_PIN){
//         this.PIN=New_PIN;
//         System.out.println("PIN Set SuccessFullyyyy : ");
//     }
    
// }


// public class Directly_Access_Private_Mathod_and_Variable_Use_OutSide_The_Class {
//   public static void main(String[] args) {
   
//     A a=new A();
//     // a.DisplayPIN();   // Not Access Private Method Directly 
//     // System.out.println(a.PIN);  //No Access Private Variable Directly 

    
//     a.GetPIN();
//     a.SetPIN(5678);
//     a.GetPIN();


//   }
// }