// Write a program to print prime numbers between given range. 

import java.util.Scanner;

public class Program_7 {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);

        System.out.println("Enter Starting Point => ");
        int start=sc.nextInt();

        System.out.println("Enter Ending Point => ");
        int end=sc.nextInt();

        Program_7 p7=new Program_7();
        int  result;

System.out.println("--------------- Prime Number ---------------");
        for(int i=start; i<=end; i++){
                // result=Program_7.isPrime(i);
                result=p7.isPrime(i);
               if(result == 0){
                   System.out.println(i);
               } 
        }
System.out.println("---------------------------------------------");

    }

     public static  int isPrime(int num){
          int count=0;
           for(int i=2; i<num; i++){
                if(num%i==0){
                    count++;
                }
           }
             return count;
     }

}
