// 38 Write a program to print a below pattern. 
 
// Input: 5 
// Output: 
// 1 
// 121 
// 12321 
// 1234321 
// 123454321 

import java.util.Scanner;

public class Problem_38 {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter N : ");
        int n=sc.nextInt();

        int Temp=0;

        for(int i=1; i<=n; i++){
            Temp=i;
            for(int j=1; j<=(i*2)-1; j++){
                 if(j<=i){
                     System.out.print(j);
                 }else{
                    System.out.print(--Temp);
                 }
            }
            System.out.println();
        }

    }
}
