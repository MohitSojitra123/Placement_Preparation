public class Ant_on_the_Boundary_Question_3028 {

    static int returnToBoundaryCount(int[] nums) {

        int sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if (sum == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        // Static Input
        int[] nums = {2, 3, -5, 4, -4};

        // Method Call
        int result = returnToBoundaryCount(nums);

        // Output
        System.out.println("Number of times returned to boundary: " + result);
    }
}