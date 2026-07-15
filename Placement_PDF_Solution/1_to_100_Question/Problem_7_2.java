// WAP to find a Fibonacci series up to n terms (n is entered by user) (iterative and recursive)

import java.util.Scanner;

public class Problem_7_2 {

      int fibonacii(int n){
             if(n==0 || n==1){
                return n;
             }
             return fibonacii(n-1)+fibonacii(n-2);
      }

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        Problem_7_2 pb=new Problem_7_2();

        System.out.println("Enter N : ");
        int num=sc.nextInt();

        for(int i=0; i<=num; i++){
            System.out.print(pb.fibonacii(i)+" ");
        }

    }
    
}
