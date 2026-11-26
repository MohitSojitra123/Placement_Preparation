
public class Maximum_Area_of_Longest_Diagonal_Rectangle_Question_3000 {

    public static int areaOfMaxDiagonal(int[][] dimensions) {

        double maxDiagonal = 0;
        int maxArea = 0;

        for (int[] dimension : dimensions) {

            int len = dimension[0];
            int width = dimension[1];

            double diagonal = Math.sqrt(len * len + width * width);
            int area = len * width;

            if (diagonal > maxDiagonal) {
                maxDiagonal = diagonal;
                maxArea = area;
            } 
            else if (diagonal == maxDiagonal) {
                maxArea = Math.max(area, maxArea);
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[][] dimensions = {
            {9, 3},
            {8, 6},
            {5, 12},
            {10, 2}
        };

        int result = areaOfMaxDiagonal(dimensions);

        System.out.println("Maximum Area: " + result);
    }
}
