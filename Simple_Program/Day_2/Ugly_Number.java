package Day_2;

import java.util.Scanner;

public class Ugly_Number {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Any Number To Check Number Is Ugly Or Not : ");
        int num=sc.nextInt();


        if(num<0){
            System.out.println("Number Is Not Ugly : ");
            return ;
        }

        while (num%2==0) {
               num/=2;
        }

        
        while (num%3==0) {
               num/=3;
        }

        
        while (num%5==0) {
               num/=5;
        }

        if(num==1){
            System.out.println("Number Is Ugly : ");
        }else{
            System.out.println("Number Is Not Ugly : ");
        }


    }
}
