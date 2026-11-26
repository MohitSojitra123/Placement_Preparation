// Print a following pattern  
// 1 
// 1 2 
// 1 2 3 
// 1 2 3 4 

import java.util.Scanner;

public class Problem_6 {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter num  : ");
        int num=sc.nextInt();

        for(int i=1; i<=num; i++){
            for(int j=1; j<=i; j++){
                System.out.print(j+" ");
            }
            System.out.println(" ");
        }
    }
}
