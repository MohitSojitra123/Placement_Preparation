// Write a complete multi-threaded program to meet following requirements:
// a. Read matrix [A] m x n
// b. Create m number of threads
// c. Each thread computes summation of elements of one row, i.e. ith row of the matrix
// is processed by ith thread. Where 0 <= i< m.
// d. Print the results. [C]

import java.util.Scanner;

class RowSum extends Thread {

    int matrix[][];
    int row;


    public RowSum(int matrix[][], int row) {

        this.matrix = matrix;
        this.row = row;
    }

    public void run() {

        int sum = 0;

        for (int j = 0; j < matrix[row].length; j++) {

            sum = sum + matrix[row][j];
        }

        System.out.println("Sum of Row " + row + " = " + sum);
    }
}

public class Program_7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows (m): ");
        int m = sc.nextInt();

        System.out.print("Enter number of columns (n): ");
        int n = sc.nextInt();

        int matrix[][] = new int[m][n];


        System.out.println("Enter matrix elements:");

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                matrix[i][j] = sc.nextInt();
            }
        }


        RowSum threads[] = new RowSum[m];

        for (int i = 0; i < m; i++) {

            threads[i] = new RowSum(matrix, i);

            threads[i].start();
        }

        sc.close();
    }
}