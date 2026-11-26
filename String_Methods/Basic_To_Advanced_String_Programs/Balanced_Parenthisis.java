public class Balanced_Parenthisis { 
     public static void main(String[] args) {
        
          String str="{}{([])}[]";


            while (str.contains("()") || str.contains("[]") || str.contains("[]")) {
                
                str=str.replace("()", "");
                str=str.replace("[]", "");
                str=str.replace("{}", "");
 
            }

          
            if(str.length()==0){
                System.out.println("Balanced parentheses : ");
            }else{
                System.out.println("Not Balanced parentheses : ");
            }


     }
}