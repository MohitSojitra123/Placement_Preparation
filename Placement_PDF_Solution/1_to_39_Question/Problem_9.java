// 9 Write a program that prints the Fibonacci series up to a given number of terms using 
// recursion. 
 
// Input: n = 5 
// Output: 0 1 1 2 3 
// Input: N = 7 
// Output: 0 1 1 2 3 5 8 

import java.util.Scanner;

public class Problem_9 {

      public static int fiboo(int n){
             if(n==0 || n==1){
                return n;
             }else{
                   return fiboo(n-1)+fiboo(n-2);
             }
      }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

          int n;

          System.out.println("Enter N : ");
          n=sc.nextInt();

          for(int i=0; i<n; i++){
            System.out.print(Problem_9.fiboo(i)+" ");
          }
        
    }
}
