public class Find_if_Digit_Game_Can_Be_Won_Question_ {

    public static boolean canAliceWin(int[] nums) {

        int single_digit_sum = 0;
        int double_digit_sum = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < 10) {
                single_digit_sum += nums[i];
            } else {
                double_digit_sum += nums[i];
            }
        }

        return single_digit_sum != double_digit_sum;
    }

    public static void main(String[] args) {

        // Static Input
        int[] nums = {1, 2, 3, 10, 20};

        // Function Call
        boolean result = canAliceWin(nums);

        // Output
        System.out.println(result);
    }
}