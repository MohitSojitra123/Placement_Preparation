// 1
// 1 2
// 1 2 3
// 1 2 3 4
// 1 2 3 4 5

import java.util.Scanner;

public class Pattern_6 {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);

        System.out.println("Enter Any Number => ");  
        int user=sc.nextInt();

        System.out.println();
        for(int i=1; i<=user; i++){
            for(int j=1; j<=i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
