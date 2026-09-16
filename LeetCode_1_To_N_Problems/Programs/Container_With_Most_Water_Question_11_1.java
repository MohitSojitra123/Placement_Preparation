import java.util.*;

public class Container_With_Most_Water_Question_11_1 {

    public static int maxArea(int[] height) {

        int ans = 0;

        for (int i = 0; i < height.length; i++) {

            for (int j = i + 1; j < height.length; j++) {

                int container_height = Math.min(height[i], height[j]);

                int size = j - i;

                ans = Math.max(ans, container_height * size);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int result = maxArea(height);

        System.out.println("Maximum Area = " + result);
    }
}