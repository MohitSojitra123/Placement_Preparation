import java.util.Scanner;

public class Count_Number_Of_Words {
    public static void main(String[] args) {
        
         Scanner sc=new Scanner(System.in);

         System.out.println("Enter String To Count Number Of Words , Character , Space , Digit ");
         String str=sc.nextLine();

         str=str.toUpperCase();

         int Alpha=0;
         int Number=0;
         int Space=1;

         for(int i=0; i<str.length(); i++){
            char ch=str.charAt(i);     
            if(ch>='A' && ch<='Z'){
               Alpha++;
            }else if(ch>='0' && ch<='9'){
               Number++;
            }else if(ch==' '){
                Space++;
            }
         }

         System.out.println("Alphabate : "+Alpha);
         System.out.println("Number  : "+Number);
         System.out.println("Word : "+Space);

    }
}
