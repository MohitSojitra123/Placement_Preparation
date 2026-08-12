public class Maximum_Average_Subarray_Question_643 {

    public static double findMaxAverage(int[] nums, int k) {

        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int max_sum = sum;

        for (int j = k; j < nums.length; j++) {

            sum = sum + (nums[j] - nums[j - k]);

            if (sum > max_sum) {
                max_sum = sum;
            }
        }

        return (double) max_sum / k;
    }

    public static void main(String[] args) {

        // Static Input
        int[] nums = {1, 12, -5, -6, 50, 3};

        int k = 4;

        double result = findMaxAverage(nums, k);

        System.out.println("Maximum Average : " + result);
    }
}