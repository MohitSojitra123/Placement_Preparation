import java.util.Arrays;

public class Binary_Search_Question_704 {

    public static int search(int[] nums, int target) {

        int mid;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            mid = left + (right - left) / 2;

            if (nums[mid] == target) {

                return mid;

            } else if (nums[mid] > target) {

                right = mid - 1;

            } else {

                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        // Static input
        int[] nums = {2, 4, 6, 8, 10, 12, 14};

        int target = 10;

        int result = search(nums, target);

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        System.out.println("Index: " + result);
    }
}