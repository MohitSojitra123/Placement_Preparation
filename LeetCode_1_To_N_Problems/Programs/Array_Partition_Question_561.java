import java.util.*;

public class Array_Partition_Question_561 {

    public static int arrayPairSum(int[] nums) {

        Arrays.sort(nums);

        int sum = 0;

        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] nums = {1, 4, 3, 2};

        int result = arrayPairSum(nums);

        System.out.println("Maximum Sum = " + result);
    }
}