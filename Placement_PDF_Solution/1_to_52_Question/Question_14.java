// 14 Implement a following pattern     
//        1 
//      212 
//    32123 
//  4321234 
//    32123 
//      212 
//        1 

import java.util.Scanner;

public class Question_14 {
    public static void main(String[] args) {
        
            Scanner sc=new Scanner(System.in);

        System.out.println("Enter N : ");
        int n=sc.nextInt();

        int count=0;
        
         for(int i=1; i<=n; i++){
          
            count=i;

            for(int space=i; space<n; space++){
                System.out.print(" ");
             }

             for(int j=1; j<=((i*2)-1); j++){
                 if(j<i){
                    System.out.print(count--);
                 }else if(i==j){
                    System.out.print("1");
                 }else{
                    System.out.print(++count);
                 }
             }

             System.out.println();
         }
      


         for(int i=n-1; i>=1; i--){
            
            count=i;

            for(int space=i; space<n;space++){
                System.out.print(" ");
            }

            for(int j=1; j<=((i*2)-1); j++){
                      if(j<i){
                    System.out.print(count--);
                 }else if(i==j){
                    System.out.print("1");
                 }else{
                    System.out.print(++count);
                 }
            }

            System.out.println();
         }
        

    }
}
