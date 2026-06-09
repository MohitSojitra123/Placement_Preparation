package Day_1;
import java.util.Scanner;

class Odd_Even{
     public static void main(String[] args) {
      
           Scanner sc=new Scanner(System.in);

           System.out.println("Enter Number : ");
           int num=sc.nextInt();

           if(num%2==0){
               System.out.println("Even Number : ");
           }else{
               System.out.println("Odd  Number");
           }
          
     }
}