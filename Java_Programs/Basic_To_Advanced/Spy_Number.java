import java.util.Scanner;

public class Spy_Number {
   public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);

       System.out.println("Enter Number : ");
       int num=sc.nextInt();

       int num2=num;

       int sum_of_num=0;
       int product_of_num=1;

       while (num2!=0) {
           int last_digit=num2%10;

           sum_of_num+=last_digit;
           product_of_num*=last_digit;

           num2/=10;
       }

       if(sum_of_num==product_of_num){
        System.out.println("Number Is Spy Number : ");
       }else{
        System.out.println("Number Is Not Spy Number :");
       }

    
   }    
}
