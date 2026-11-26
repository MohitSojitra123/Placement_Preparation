public class Missing_Number_Question_268 {

    public static int missingNumber(int[] nums) {

        int n = nums.length;

        int array_sum = 0;

        for (int i = 0; i < nums.length; i++) {
            array_sum += nums[i];
        }

        int real_sum = n * (n + 1) / 2;

        return real_sum - array_sum;
    }

    public static void main(String[] args) {

        // Static Input Array
        int[] nums = {3, 0, 1};

        int result = missingNumber(nums);

        System.out.println("Missing Number : " + result);
    }
}