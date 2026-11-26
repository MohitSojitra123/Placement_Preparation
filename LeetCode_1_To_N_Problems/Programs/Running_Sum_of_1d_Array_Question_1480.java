public class Running_Sum_of_1d_Array_Question_1480 {

    public static int[] runningSum(int[] nums) {

        int current_sum = 0;

        for (int i = 0; i < nums.length; i++) {
            current_sum += nums[i];
            nums[i] = current_sum;
        }

        return nums;
    }

    public static void main(String[] args) {

        // Static Input
        int[] nums = {1, 2, 3, 4};

        // Function call
        int[] result = runningSum(nums);

        // Print result
        System.out.print("Running Sum: ");

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}