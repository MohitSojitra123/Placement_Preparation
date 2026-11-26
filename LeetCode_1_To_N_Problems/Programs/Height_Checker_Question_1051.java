
public class Height_Checker_Question_1051 {

    public static int heightChecker(int[] heights) {

        int array[] = new int[heights.length];

        // Copy original array
        for (int i = 0; i < array.length; i++) {
            array[i] = heights[i];
        }

        // Sort array using Bubble Sort
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights.length - 1 - i; j++) {

                if (heights[j] > heights[j + 1]) {

                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                }
            }
        }

        // Count mismatched positions
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (heights[i] != array[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        // Static input
        int heights[] = {1, 1, 4, 2, 1, 3};

        // Call method
        int result = heightChecker(heights);

        // Print output
        System.out.println("Number of students in wrong positions: " + result);
    }
}