import java.util.HashMap;
import java.util.Arrays;

public class Set_Mismatch_Question_645 {

    public static int[] findErrorNums(int[] nums) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        int duplicate = -1;
        int missing = -1;

        for (int i = 1; i <= nums.length; i++) {

            if (hm.containsKey(i)) {

                if (hm.get(i) == 2) {
                    duplicate = i;
                }

            } else {

                missing = i;
            }
        }

        return new int[]{duplicate, missing};
    }

    public static void main(String[] args) {

        // Static Input Array
        int[] nums = {1, 2, 2, 4};

        int[] result = findErrorNums(nums);

        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Output : " + Arrays.toString(result));
    }
}