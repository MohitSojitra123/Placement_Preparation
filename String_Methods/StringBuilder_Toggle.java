import java.util.Scanner;

public class StringBuilder_Toggle {
    public static void main(String[] args) {
        
         Scanner sc=new Scanner(System.in);
         
         
         System.out.println("Enter String : ");
         StringBuilder str=new StringBuilder(sc.nextLine());

         System.out.println(str);

         for(int i=0; i<str.length(); i++){
            
            if(str.charAt(i)==' '){
                continue;
            }else{   
                if(Character.isAlphabetic(str.charAt(i))){
                    
                      if(str.charAt(i)>='A' && str.charAt(i)<='Z'){
                        char ch=(char)(str.charAt(i)+32);
                         str.setCharAt(i, ch);
                      }else{
                         char ch=(char)(str.charAt(i)-32);
                         str.setCharAt(i, ch);
                      }

                }
                
            }

         }

         System.out.println(str);

    }
}
