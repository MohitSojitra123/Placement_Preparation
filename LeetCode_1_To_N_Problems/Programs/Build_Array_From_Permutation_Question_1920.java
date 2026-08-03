import java.util.Arrays;

public class Build_Array_From_Permutation_Question_1920{

    public static int[] buildArray(int[] nums) {

        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }

        return ans;
    }

    public static void main(String[] args) {

        // Static Input
        int[] nums = {0, 2, 1, 5, 3, 4};

        int[] result = buildArray(nums);

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(nums));

        System.out.println("Build Array from Permutation:");
        System.out.println(Arrays.toString(result));
    }
}