import java.util.*;

public class Single_Number_Question_136 {

    public static int singleNumber(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (int key : map.keySet()) {
            return key;
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {4, 1, 2, 1, 2};

        int result = singleNumber(nums);

        System.out.println("Single Number = " + result);
    }
}