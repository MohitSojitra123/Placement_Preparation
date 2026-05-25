public class Search_In_Sorted_Matrix {

    public static void main(String[] args) {

        int matrix[][] = {
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}
        };

        int target = 14;

        int row = 0;
        int col = matrix[0].length - 1;

        boolean found = false;

        while (row < matrix.length && col >= 0) {

            if (matrix[row][col] == target) {

                System.out.println("Element Found at : "
                        + row + " , " + col);

                found = true;
                break;
            }

            else if (matrix[row][col] > target) {
                col--; // decrease column
            }

            else {
                row++; // increase row
            }
        }

        if (!found) {
            System.out.println("Element Not Found");
        }
    }
}