// WAP to find weather given number is Ugly or not. 
// An ugly number is a positive integer which does not have a prime factor other than 2, 3, and 5. 
// Input: n = 6 Output: true Explanation: 6 = 2 × 3

import java.util.Scanner;

public class Question_2{
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
