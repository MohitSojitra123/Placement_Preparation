package Day_2;

import java.util.Scanner;

public class Fibbonacii {
    public static void main(String[] args) {
        
         Scanner sc=new Scanner(System.in);

         System.out.println("Enter Number : ");
         int n=sc.nextInt();

         int a=0;
         int b=1;
         int c=0;

         for(int i=1; i<=n; i++){
             System.out.print(a+" ");
             c=a+b;
             a=b;
             b=c;
         }

    }
}
