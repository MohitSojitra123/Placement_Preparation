// Given the number of rows and columns, print the corresponding swastika pattern using loops. 
// Note:  The  number  of  rows  and  columns  should  be  the  same  and  an  odd  number.  This  will  generate  a 
// perfect swastika pattern.

import java.util.Scanner;

public class Question_16 {
    public static void main(String[] args) {
        
         Scanner sc=new Scanner(System.in);

         System.out.println("Enter N : ");
         int n=sc.nextInt();

         System.out.println();
         System.out.println();
         
         for(int i=1; i<=n; i++){
             for(int j=1; j<=n; j++){
                 
                if( (i==((n/2)+1) && j<=n)  || (j==((n/2)+1) && i<=n)  || (j==1 && i<=(n/2))  || (j==n && i>((n/2)+1))  || (i==1 && j>((n/2)+1))  || (i==n && j<=((n/2)+1))){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
                
                
            }
            System.out.println();
        }
        
        System.out.println();
        System.out.println();


    }
}
