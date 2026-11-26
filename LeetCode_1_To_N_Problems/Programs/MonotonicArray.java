public class MonotonicArray {

    public static boolean isMonotonic(int[] nums) {

        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] > nums[i + 1]) {
                increasing = false;
                System.out.println("Increasing : "+increasing);
            }

            if (nums[i] < nums[i + 1]) {
                decreasing = false;
                System.out.println("Descreasing : "+decreasing);
            }
        }

        return increasing || decreasing;
    }

    public static void main(String[] args) {

        // Static Input
        int[] nums = {1, 2, 2, 3};

        // Method Call
        boolean result = isMonotonic(nums);

        // Output
        System.out.println("Is Monotonic Array: " + result);

    }
}

