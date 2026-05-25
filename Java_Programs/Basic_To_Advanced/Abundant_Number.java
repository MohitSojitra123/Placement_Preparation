import java.util.Scanner;

public class Abundant_Number {
     public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);

          int n;

          System.out.println("Enter Any Number To Check Number Is Abundant Or Not : ");
          n=sc.nextInt();

          int Sum_of_Divisible=0;

          for(int i=1; i<n; i++){
               if(n%i==0){
                Sum_of_Divisible+=i;
               }
          }

          if(Sum_of_Divisible>n){
              System.out.println("Number Is Abundant : ");
          }else{
              System.out.println("Number IS Not Abundant : ");
          }

     }
}
