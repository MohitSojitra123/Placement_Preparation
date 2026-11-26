//   * * * * *
//    * * * *
//     * * *
//      * *
//       *

import java.util.Scanner;

public class Pattern_4 {
  public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Any Number => ");  
        int user=sc.nextInt();

        for(int i=user; i>=1; i--){
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
