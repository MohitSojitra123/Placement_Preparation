import java.util.*;

public class Array_Each_Element_Sum_Question_3300 {

    public static int minElement(int[] nums) {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            int sum = 0;
            int temp = nums[i];

            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }

            nums[i] = sum;

            if (nums[i] < min) {
                min = nums[i];
            }
        }

        return min;
    }

    public static void main(String[] args) {

        int[] nums = {12, 34, 19, 99};

        int result = minElement(nums);

        System.out.println("Minimum Element After Digit Sum = " + result);
    }
}