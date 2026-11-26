import java.util.HashMap;

public class Longest_Harmonious_Subsequence_Question_594{

    public static int findLHS(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;

        // Check numbers whose difference is exactly 1
        for (int num : map.keySet()) {

            if (map.containsKey(num + 1)) {

                int length = map.get(num) + map.get(num + 1);

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        // Static Input
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};

        // Calling method
        int result = findLHS(nums);

        // Print output
        System.out.println("Longest Harmonious Subsequence Length: " + result);
    }
}