package Day_2;

import java.util.Scanner;

public class Armstrong_Number {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter Number To Ckeck Number Is Armstrong Or Not : ");
        int num=sc.nextInt();

        int temp=num;
        int count=0;

        while (temp!=0) {
              count++;
              temp/=10; 
        }

        temp=num;

        int  final_sum=0;

        while (temp!=0) {
             final_sum= final_sum + (int)(Math.pow(temp%10, count));    
             temp/=10;
        }

        if(final_sum==num){
            System.out.println("Number Is Armstrong : ");
        }else{
            System.out.println("Number Is Not Armstrong : ");
        }
        

    }
}
