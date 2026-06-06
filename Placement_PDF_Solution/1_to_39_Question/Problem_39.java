// 39 Write a program to print a below pattern. 
 
// Input: 5 
// Output: 
// 1 
// 121 
// 1*3*1 
// 1**4**1 
// 1***5***1 
 
// Input: 7 
// Output: 
// 1 
// 121 
// 1*3*1 
// 1**4**1 
// 1***5***1 
// 1****6****1 
// 1*****7*****1

import java.util.Scanner;

public class Problem_39 {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter N : ");
        int n=sc.nextInt();
        
        System.out.println();

        for(int i=1; i<=n; i++){
               for(int j=1; j<=(i*2)-1; j++){
                   if(j==1 || j==((i*2)-1)){
                      System.out.print(1);
                   }else if(i==j){
                    System.out.print(j);
                   }
                   else{
                    System.out.print("*");
                   }
               }
               System.out.println();
        }

        System.out.println();

    }
}
