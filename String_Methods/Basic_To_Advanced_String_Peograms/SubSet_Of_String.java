package Basic_To_Advanced_String_Peograms;
import java.util.Scanner;

class   SubSet_Of_String{
       public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            
            System.out.println("Enter String : ");
            String str=sc.nextLine();

            System.out.println("\n\n");
            for(int i=0; i<str.length(); i++){
                for(int j=i+1; j<=str.length(); j++){
                    System.out.println(str.substring(i, j));
                }
            }
            System.out.println("\n\n");

       }
}