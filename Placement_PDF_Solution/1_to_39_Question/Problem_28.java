// 28 Write a program to print a center-aligned pyramid pattern where each row contains 
// numbers increasing from 1 up to the row number and then decreasing back to 1. 
// Input: 3 
// Output: 
//    1 
//  121 
// 12321

import java.util.Scanner;

public class Problem_28 {
    public static void main(String[] args) {
     
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter N : ");
        int n=sc.nextInt();

        System.out.println();

        
        int temp=0;

        for(int i=1; i<n; i++){
              temp=i;

              for(int space=n; space>i; space--){
                System.out.print("  ");
              }

            for(int j=1; j<=(i*2)-1; j++){
                if(j<=temp){
                    System.out.print(j+" ");
                }else{
                    System.out.print(--temp+" ");
                }
            }
            System.out.println();
        }

        System.out.println();
        
    }
}
