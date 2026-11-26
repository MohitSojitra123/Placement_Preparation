// Write a program to check that the given number is prime or not.

import java.util.Scanner;

public class Program_4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Any Number To Check Number Is Prime Or Not => ");
        int user=sc.nextInt();

        int count=0;

        for(int i=2; i<user; i++){
               if(user%i==0){
                     count++;
               }
        }

        if(count==0){
            System.out.println("Number Is Prime => "+user);
        }else{
            System.out.println("Number Is Not Prime => "+user);
        }

    }
}
