import java.util.Arrays;

public class K_Diff_Pairs_In_Array_Question_532 {

    public static void main(String[] args) {

        int nums[] = {3, 1, 4, 1, 5};
        int k = 2;

        int result = findPairs(nums, k);

        System.out.println("Number of Unique Pairs = " + result);
    }

    public static int findPairs(int[] nums, int k) {

        if (k < 0)
            return 0;

        Arrays.sort(nums);

        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {

                int diff = nums[j] - nums[i];

                if (diff == k) {
                    count++;
                    break; // Count this pair only once
                }

                if (diff > k) {
                    break; // No need to check further
                }
            }
        }

        return count;
    }
}