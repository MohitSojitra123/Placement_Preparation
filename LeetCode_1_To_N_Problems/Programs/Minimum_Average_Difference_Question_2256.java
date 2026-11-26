public class Minimum_Average_Difference_Question_2256 {

    public static void main(String[] args) {

        int nums[] = {2, 5, 3, 9, 5, 3};

        long totalSum = 0;

        // Calculate Total Sum
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        long leftSum = 0;
        long minDiff = Long.MAX_VALUE;

        int answer = 0;

        for (int i = 0; i < nums.length; i++) {

            // Calculate Left Sum
            leftSum += nums[i];

            // Left Average
            long leftAvg = leftSum / (i + 1);

            // Right Sum
            long rightSum = totalSum - leftSum;

            long rightAvg;

            // Right Average
            if (i == nums.length - 1) {
                rightAvg = 0;
            } else {
                rightAvg = rightSum / (nums.length - i - 1);
            }

            // Find Difference
            long diff = Math.abs(leftAvg - rightAvg);

            // Update Minimum Difference
            if (diff < minDiff) {
                minDiff = diff;
                answer = i;
            }
        }

        System.out.println("Minimum Average Difference Index = " + answer);
    }
}