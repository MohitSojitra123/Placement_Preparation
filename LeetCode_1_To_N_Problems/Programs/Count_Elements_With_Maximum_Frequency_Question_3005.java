import java.util.HashMap;
import java.util.Map;

import javax.lang.model.util.Elements;

public class Count_Elements_With_Maximum_Frequency_Question_3005 {

    static int maxFrequencyElements(int[] nums) {

        int count = 0;
        int max_freq = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);

            if (hm.get(nums[i]) > max_freq) {
                max_freq = hm.get(nums[i]);
            }
        }

        for (Map.Entry<Integer, Integer> i : hm.entrySet()) {

            if (i.getValue() >= max_freq) {
                count += max_freq;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 3, 1, 4, 2};

        int result = maxFrequencyElements(nums);

        System.out.println("Maximum Frequency Elements: " + result);
    }
}