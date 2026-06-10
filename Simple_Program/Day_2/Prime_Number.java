package Day_2;

import java.util.Scanner;

public class Prime_Number {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Number To Check Number Is Prime Or Not : ");
        int n=sc.nextInt();

        int count=0;

        for(int i=2; i<=n/2; i++){
              if(n%i==0){
                count++;
                break;
              }
        }

        if(count==0){
            System.out.println("Number Is Prime : ");
        }else{
            System.out.println("Number Is Not Prime : ");
        }

    }
}
