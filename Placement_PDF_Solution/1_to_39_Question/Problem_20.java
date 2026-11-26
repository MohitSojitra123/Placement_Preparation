// 20 Given  a  2D  square  matrix,  find  the  sum  of  elements  in  Principal  and  Secondary 
// diagonals. For example, consider the following 4 X 4 input matrix. 
// Input: 4 
// 1 2 3 4 
// 4 3 2 1 
// 7 8 9 6 
// 6 5 4 3 
// Output: 
// Principal Diagonal: 16 
// Secondary Diagonal: 20 

import java.util.Scanner;

public class Problem_20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] matrix = new int[n][n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int principalSum = 0;
        int secondarySum = 0;

     
        for (int i = 0; i < n; i++) {
            principalSum += matrix[i][i];
            secondarySum += matrix[i][n - 1 - i];
        }

        System.out.println("Principal Diagonal: " + principalSum);
        System.out.println("Secondary Diagonal: " + secondarySum);

        sc.close();
    }
}