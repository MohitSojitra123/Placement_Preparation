import java.util.Scanner;

public class PalindromeString_Check {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);

          System.out.println("Enter String : ");
          String str=sc.nextLine();

          char str_char[]=str.toCharArray();

          int LastIndex=str_char.length-1;
          int FirstIndex=0;

          boolean IsPalindrom=true;

          while (FirstIndex<=LastIndex) {
                 if(str_char[FirstIndex]!=str_char[LastIndex]){
                     IsPalindrom=false;
                    break;
                 }else{
                      FirstIndex++;
                      LastIndex--;
                 }  
          }

          if(IsPalindrom){
            System.out.println("String  Is Palindrom : ");
          }else{
            System.out.println("String Is Not Palindrom : ");
          }


    }
}
