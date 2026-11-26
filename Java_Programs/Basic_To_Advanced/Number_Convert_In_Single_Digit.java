import java.util.Scanner;

public class Number_Convert_In_Single_Digit {
  public static void main(String args[]){
           
       Scanner sc=new Scanner(System.in);
       
       System.out.println("Enter N  : ");
       int num=sc.nextInt();

       int final_num=0;

       while (num>10) {
        final_num=0;
           while (num!=0) {
                 final_num+=num%10;
                 num/=10;
           }
            num=final_num;
       }

       System.out.println(final_num);

  }
}