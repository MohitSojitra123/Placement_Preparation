import java.util.Arrays;

public class Rearrange_Array_Elements_By_Sign_Question_2149 {

    public static int[] rearrangeArray(int[] nums) {

        int new_arr[] = new int[nums.length];

        int positive_index = 0;
        int negative_index = 1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {

                new_arr[positive_index] = nums[i];
                positive_index += 2;

            } else {

                new_arr[negative_index] = nums[i];
                negative_index += 2;
            }
        }

        return new_arr;
    }

    public static void main(String[] args) {

        int[] nums = {3, 1, -2, -5, 2, -4};

        System.out.println("Original Array : " + Arrays.toString(nums));

        int[] result = rearrangeArray(nums);

        System.out.println("Rearranged Array : " + Arrays.toString(result));
    }
}
