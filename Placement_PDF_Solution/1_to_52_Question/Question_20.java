// Write a program to print following pattern 
// For n=4 
// 4 4 4 4 4 4 4 
// 4 3 3 3 3 3 4 
// 4 3 2 2 2 3 4 
// 4 3 2 1 2 3 4 
// 4 3 2 2 2 3 4 
// 4 3 3 3 3 3 4 
// 4 4 4 4 4 4 4

import java.util.Scanner;

public class Question_20 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter N : ");
        int n =sc.nextInt();

        int size = 2 * n - 1;

        System.out.println();
        System.out.println();
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                
                int value = Math.max(
                    Math.abs(i - (n - 1)),
                    Math.abs(j - (n - 1))
                ) + 1;
                
                System.out.print(value + " ");
            }
            System.out.println();
        }

        
        System.out.println();
        System.out.println();
    }
}
