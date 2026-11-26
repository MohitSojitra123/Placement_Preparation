//         1
//      2 2
//    3 3 3
//  4 4 4 4
// 5 5 5 5 5

import java.util.Scanner;

public class Pattern_7 {
   public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);

        System.out.println("Enter Any Number => ");  
        int user=sc.nextInt();
        
        for(int i=1;  i<=user; i++){

            for(int space=i; space<user; space++){
                System.out.print(" ");
            }

            for(int j=1; j<=i; j++){
                System.out.print(i+" ");
            }

            System.out.println();
        }
   }    
}
