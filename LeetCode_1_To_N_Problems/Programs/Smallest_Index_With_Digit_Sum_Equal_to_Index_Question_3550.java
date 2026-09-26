
public class Smallest_Index_With_Digit_Sum_Equal_to_Index_Question_3550 {

    public static int smallestIndex(int[] nums) {

        int num = 0;
        int lastdigit = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            num = nums[i];
            lastdigit = 0;
            sum = 0;

            // Calculate sum of digits
            while (num != 0) {
                lastdigit = num % 10;
                sum += lastdigit;
                num /= 10;
            }

            // Check digit sum == index
            if (sum == i) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6};

        int result = smallestIndex(nums);

        System.out.println("Smallest Index = " + result);
    }
}
