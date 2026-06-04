// 4 Given an integer n, the task is to find the first n rows of Pascal’s triangle. 
// Input : N = 5 
// Output: 
//           1 
//         1   1 
//       1   2   1 
//     1   3   3   1 
//   1   4   6   4   1 

import java.util.Scanner;

public class Problem_4 {
  public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number of Rows : ");
        int n = sc.nextInt();

        int[][] arr = new int[n][];

        for (int i = 0; i < n; i++) {
            arr[i] = new int[i + 1];
        }

        for (int i = 0; i < n; i++) {

            for (int j = 0; j <= i; j++) {


                if (j == 0 || j == i) {
                    arr[i][j] = 1;
                }
                else {
                    arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
                }
            }
        }


        System.out.println("\nPascal Triangle:");

        for (int i = 0; i < n; i++) {
          
            for (int s = 0; s < n - i - 1; s++) {
                System.out.print("  ");
            }

            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "   ");
            }

            System.out.println();
        }

        sc.close();
  }
}