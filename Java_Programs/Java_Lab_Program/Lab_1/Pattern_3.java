//                   *
//              *  *
//           * * *
//     *  *  *  *
//  *  *  * * *

import java.util.Scanner;

public class Pattern_3 {
    public static void main(String[] args) {
 
          Scanner sc=new Scanner(System.in);

        System.out.println("Enter Any Number => ");  
        int user=sc.nextInt();

        for(int i=1; i<=user; i++){
            for(int space=user; space>i; space--){
                System.out.print("  ");
            }

            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }

            System.out.println();
        }
        
    }
}
