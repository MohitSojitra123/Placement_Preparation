public class Find_the_Array_Concatenation_Value_Question_2562 {

    public static long findTheArrayConcVal(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        long total = 0;

        while (left < right) {

            String str = String.valueOf(nums[left])
                        + String.valueOf(nums[right]);

            total += Long.parseLong(str);

            left++;
            right--;
        }

        // If array length is odd, add the middle element
        if (nums.length % 2 != 0) {
            total += nums[left];
        }

        return total;
    }

    public static void main(String[] args) {

        // Static Input Array
        int[] nums = {7, 52, 2, 4};

        // Calling method
        long result = findTheArrayConcVal(nums);

        // Display result
        System.out.println("Array Concatenation Value = " + result);
    }
}