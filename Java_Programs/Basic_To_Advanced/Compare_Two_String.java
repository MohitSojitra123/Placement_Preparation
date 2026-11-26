import java.util.Scanner;

public class Compare_Two_String {
    public static void main(String[] args) {
           Scanner sc=new Scanner(System.in);

   System.out.println("Enter String => 1");
   String str1=sc.nextLine();

   System.out.println("Enter Strgin => 2");
   String str2=sc.nextLine();

   System.out.println("Str 1 =>  "+str1);
   System.out.println("Str 2 =>  "+str2);

   if(str1.equals(str2)){
    System.out.println("String 1 and String 2 Is equal ");
   }else{
    System.out.println("String 1 and String 2  Is Not equal ");
   }
    }
}
