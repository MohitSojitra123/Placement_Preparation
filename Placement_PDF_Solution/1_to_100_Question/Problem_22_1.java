//        A 
//      1   2 
//   B  C  D 
//  3  4  5  6 
// E  F  G  H  I

import java.util.Scanner;

public class Problem_22_1 {
    public static void main(String[] args) {
        
          Scanner sc=new Scanner(System.in);

          System.out.println("Enter N : ");
          int n=sc.nextInt();

          char ch='A';
          int count=1;


          for(int i=1; i<=n; i++){
            
            for(int space=n; space>i; space--){
                System.out.print(" ");
            }

            for(int j=1; j<=i; j++){
                   if(i%2!=0){
                       System.out.print((ch++)+" ");
                   }else{
                       System.out.print((count++)+" ");
                   }
            }
            System.out.println();
          }

    }
}
