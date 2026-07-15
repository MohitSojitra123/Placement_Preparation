// WAP to find a Fibonacci series up to n terms (n is entered by user) (iterative and recursive)

import java.util.Scanner;

public class Problem_7_1 {
    public static void main(String[] args) {
        
          Scanner sc=new Scanner(System.in);

          System.out.println("Enter N : ");
          int n=sc.nextInt();

          int a=0,b=1,c=0;

          for(int i=0; i<=n; i++){
            System.out.print(c+" ");
            a=b;
            b=c;
            c=a+b;
          }

    }
}
