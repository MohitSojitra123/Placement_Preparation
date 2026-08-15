import java.util.HashMap;
import java.util.Arrays;

public class SingleN_umberII_Question_137 {

    public static int singleNumber(int[] nums) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        for (int i : hm.keySet()) {

            if (hm.get(i) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        // Static Input Array
        int[] nums = {2, 2, 3, 2};

        int result = singleNumber(nums);

        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Output : " + result);
    }
}