import java.util.Scanner;

public class Find_Smallest_Word_In_String {
    public static void main(String[] args) {
        
           Scanner sc=new Scanner(System.in);

           System.out.println("Enter String : ");
           String str=sc.nextLine();

           String str_arr[]=str.split("\\s");

           int Smallest_length=Integer.MAX_VALUE;
           String Smallest_str="";

           for(int i=0; i<str_arr.length; i++){
               if(str_arr[i].length()<Smallest_length){
                    Smallest_str=str_arr[i];
                    Smallest_length=str_arr[i].length();
               }
           }

           System.out.println("Smallest String : "+Smallest_str);
           System.out.println("Smallest String : "+Smallest_length);

    }
}
