import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dynamic_Regex_Function {

      public static void Pattern_Matcher(String check,String patter){
        
           Pattern patt=Pattern.compile(patter);

           Matcher mat=patt.matcher(check);

           boolean result=mat.matches();

           System.out.println("Result : "+result);

      }

    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);

        while (true) {
            
            System.out.println("Enter Pattern : ");
            String user_patt=sc.nextLine();
        

            System.out.println("Enter Check String : ");
            String user_check=sc.nextLine();
    
            Dynamic_Regex_Function.Pattern_Matcher(user_check,user_patt);
        }
    }   
}
