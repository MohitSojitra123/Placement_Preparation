public class Max_ConsecutiveOnes_Question_485 {

    public static int findMaxConsecutiveOnes(int[] nums) {

        int current_count = 0;
        int max_count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                current_count++;
            } else {

                if (current_count > max_count) {
                    max_count = current_count;
                }

                current_count = 0;
            }
        }

        // Check if the array ends with consecutive 1's
        if (current_count > max_count) {
            max_count = current_count;
        }

        return max_count;
    }

    public static void main(String[] args) {

        // Static Array Input
        int[] nums = {1, 1, 0, 1, 1, 1};

        int result = findMaxConsecutiveOnes(nums);

        System.out.println("Maximum Consecutive Ones: " + result);
    }
}