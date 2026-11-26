// 37 Write a program to print a below pattern. 
 
// Input: 5 
// Output: 
// 1 
// 123 
// 12345 
// 1234567 
// 123456789 

import java.util.Scanner;

public class Problem_37 {
    public static void main(String[] args) {
     
          Scanner sc=new Scanner(System.in);

          System.out.println("Enter N : ");
          int n=sc.nextInt();

          for(int i=1; i<=n; i++){
            for(int j=1; j<=(i*2)-1; j++){
                System.out.print(j);
            }
            System.out.println();
          }
        
    }
}
