import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Find_Missing_Elements_Question_3731 {

    public static List<Integer> findMissingElements(int[] nums) {

        List<Integer> li1 = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();

        int max_num = Integer.MIN_VALUE;
        int min_num = Integer.MAX_VALUE;

        // Find minimum, maximum and store elements
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > max_num) {
                max_num = nums[i];
            }

            if (nums[i] < min_num) {
                min_num = nums[i];
            }

            hs.add(nums[i]);
        }

        // Find missing elements between min and max
        for (int i = min_num + 1; i < max_num; i++) {

            if (!hs.contains(i)) {
                li1.add(i);
            }
        }

        return li1;
    }

    public static void main(String[] args) {

        // Static Input
        int[] nums = {1, 2, 4, 6, 8};

        List<Integer> result = findMissingElements(nums);

        System.out.println("Missing Elements : " + result);
    }
}