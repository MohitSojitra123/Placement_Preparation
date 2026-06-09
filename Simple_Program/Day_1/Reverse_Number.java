package Day_1;
import java.util.Scanner;

public class Reverse_Number {
    public static void main(String[] args) {
        
       Scanner sc=new Scanner(System.in);

       System.out.println("Enter Number : ");
       int num=sc.nextInt();

       int reverse_num=0;

       while (num!=0) {
           int last_digit=num%10;
           reverse_num=(reverse_num*10)+last_digit;
           num/=10;
       }

       System.out.println("Reverse Number : "+reverse_num);

         

    }
}
