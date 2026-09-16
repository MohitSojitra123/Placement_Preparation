public class Container_With_Most_Water_Question_11_2 {

    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int max_water = 0;

        while (left < right) {

            int min_height = Math.min(height[left], height[right]);

            int size = right - left;

            int water = min_height * size;

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

            max_water = Math.max(water, max_water);
        }

        return max_water;
    }

    public static void main(String[] args) {

        // Static Input
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        // Calling method
        int result = maxArea(height);

        // Output
        System.out.println("Maximum Area = " + result);
    }
}