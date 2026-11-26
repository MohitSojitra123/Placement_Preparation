import java.util.Scanner;

public class Harshad_Number {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);

          int n;

          System.out.println("Enter N : ");
          n=sc.nextInt();

          int num=n;

          int n_sum=0;

          while(n!=0){
              int last_digit=n%10;
              n_sum+=last_digit;
              n/=10;
          }

          if(num%n_sum==0){
            System.out.println("Number Is Harshad Number : ");
          }else{
            System.out.println("Number Is Not Harshad Number : ");
          }
   
    }
}
