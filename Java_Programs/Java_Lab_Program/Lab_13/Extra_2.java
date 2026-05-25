public class Extra_2 {
   public static void main(String[] args) {

        try{
             int a = 10;
             int b = 0;

             if(b == 0){
                 throw new Exception("Not Divide by Zero");
             }

             System.out.println(a / b);

        }catch(Exception e){
          System.out.println(e);
        }

   }    
}
