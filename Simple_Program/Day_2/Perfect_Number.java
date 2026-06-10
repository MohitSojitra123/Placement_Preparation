package Day_2;

import java.util.Scanner;

public class Perfect_Number {
    public static void main(String[] args) {
        
          Scanner sc=new Scanner(System.in);

          System.out.println("Enter Any Number To Check Number Is Perfect Or Not : ");
          int n=sc.nextInt();

          int sum=0;

          for(int i=1; i<n; i++){
            if(n%i==0){
                sum+=i;
            }
          }

          if(sum==n){
            System.out.println("Number Is Perfect : ");
          }else{
            System.out.println("Number Is Not Perfect : ");
          }

    }
}
