// *********
// -*******
// --*****
// ---***
// ----*

import java.util.Scanner;

public class Problem_22_2 {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

          System.out.println("Enter N : ");
          int n=sc.nextInt();

          for(int i=n; i>=1; i--){

            for(int space=n; space>i; space--){
                   System.out.print("-");
            }

            for(int j=((i*2)-1); j>=1; j--){
                System.out.print("*");
            }

            System.out.println();
          }

    }
}
