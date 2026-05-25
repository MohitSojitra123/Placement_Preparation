// Write an interactive program to print a diamond shape. For example, if user enters
// the number 3, the diamond will be as follows:
//         *
//       * *
//     * * *
//      * *
//       *

import java.util.Scanner;

public class Program_6 {
      public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
         
           System.out.println("Enter Any Number For Diamond Pattern => ");
           int user=sc.nextInt();
           
           for(int i=1; i<=user; i++){
              for(int space=user; space>i; space--){
                  System.out.print(" ");
              }
              for(int j=1; j<=i; j++){
                System.out.print("* ");
              }
              System.out.println();
           }

           for(int i=user; i>=0; i--){
            for(int space=i; space<user; space++){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
           }

      }
}
