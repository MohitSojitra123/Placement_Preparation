import java.util.HashSet;
import java.util.Arrays;

public class Longest_Consecutive_Sequence_Question_128 {

    public static int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }

        int temp_count = 1;
        int max_count = 0;
        int current = 0;

        for (int i : hs) {

            // Check whether i is the starting element
            if (!hs.contains(i - 1)) {

                current = i;
                temp_count = 1;

                // Find consecutive elements
                while (hs.contains(current + 1)) {
                    current++;
                    temp_count++;
                }
            }

            max_count = Math.max(temp_count, max_count);
        }

        return max_count;
    }

    public static void main(String[] args) {

        // Static Input
        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println("Input Array : " + Arrays.toString(nums));

        int result = longestConsecutive(nums);

        System.out.println("Longest Consecutive Sequence : " + result);
    }
}