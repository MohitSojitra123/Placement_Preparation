import java.util.Arrays;

public class Sorted_Squares_Question_977 {

    public static int[] sortedSquares(int[] nums) {

        int ans[] = new int[nums.length];

        int left = 0;
        int right = nums.length - 1;

        int ans_ptr = nums.length - 1;

        while (left <= right) {

            int left_square = nums[left] * nums[left];
            int right_square = nums[right] * nums[right];

            if (left_square >= right_square) {

                ans[ans_ptr] = left_square;

                left++;
                ans_ptr--;

            } else {

                ans[ans_ptr] = right_square;

                ans_ptr--;
                right--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {-9, -6, -3, -1, 3, 6, 8, 10, 12};

        System.out.println("Original Array : " + Arrays.toString(nums));

        int[] result = sortedSquares(nums);

        System.out.println("Sorted Squares  : " + Arrays.toString(result));
    }
}
