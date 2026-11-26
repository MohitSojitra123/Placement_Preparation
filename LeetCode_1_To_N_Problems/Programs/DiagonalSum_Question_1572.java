public class DiagonalSum_Question_1572 {

    public static int diagonalSum(int[][] mat) {

        int sum = 0;

        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < mat.length; j++) {

                if (i == j || i + j == mat.length - 1) {
                    sum += mat[i][j];
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        // Static Input
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Method Call
        int result = diagonalSum(mat);

        // Output
        System.out.println("Diagonal Sum = " + result);
    }
}