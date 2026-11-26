
class Search_a_2D_Matrix_Question_74 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {

            if (matrix[row][col] == target) {
                return true;
            } 
            else if (matrix[row][col] < target) {
                row++;
            } 
            else {
                col--;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        // Static input
        int[][] matrix = {
            {1,  4,  7, 11},
            {2,  5,  8, 12},
            {3,  6,  9, 16},
            {10, 13, 14, 17}
        };

        int target = 5;

        Search_a_2D_Matrix_Question_74 obj = new Search_a_2D_Matrix_Question_74();

        boolean result = obj.searchMatrix(matrix, target);

        System.out.println("Target Found: " + result);
    }
}