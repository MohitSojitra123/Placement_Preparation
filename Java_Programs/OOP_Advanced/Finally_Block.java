
// // If a return statement is placed inside a try block, does the finally block still run? Explain in Detailed with an Exam and
// // interview point of view

// // Response: Yes, the finally block still runs even if a return statement is placed inside a try or catch block.

// public class Finally_Block {
//    public static void main(String[] args) {
    
//       try{
        
//           int a=10;
          
//           System.out.println(a);

//           return;

//       }catch(Exception e){
//         System.out.println("Exception Occureddd : ");
//       }finally{
//         System.out.println("Finallyyy Block Executed : ");
//       }

//    }    
// }
