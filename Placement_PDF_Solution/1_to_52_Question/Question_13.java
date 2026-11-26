// Implement a following pattern 
// * * * * * * * 
//  *               *  
//      *      *   
//          *    
//     *         *   
//  *                * 
// * * * * * * * 

import java.util.Scanner;

class Question_13{
    public static void main(String[] args) {
 
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter N : ");
        int n=sc.nextInt();

         
         for(int i=n; i>=1; i--){
            for(int space=i; space<n; space++){
                System.out.print(" ");
            }
            for(int j=1; j<=((i*2)-1); j++){
                if( (j==1 || j==((i*2)-1))  ||  ( i==n && j<=(i*2)-1 )){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
             System.out.println();
         }
        
         for(int i=2; i<=n; i++){
            
            for(int space=i; space<n; space++){
                 System.out.print(" ");
            }

            for(int j=1; j<=((i*2)-1); j++){
                if(j==1 || (j==((i*2)-1)) || (i==n)){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }

            System.out.println();

         }
        

        
    }
}