import java.util.*;

public class Minimum_Operations_to_Collect_Elements_Question_2869 {

    public static void main(String[] args) {

        // Static Input
        List<Integer> nums = Arrays.asList(3, 1, 5, 4, 2);
        int k = 5;

        int result = minOperations(nums, k);

        System.out.println("Minimum Operations : " + result);
    }

    public static int minOperations(List<Integer> nums, int k) {

        // Create a Set containing numbers from 1 to k
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= k; i++) {
            set.add(i);
        }

        int count = 0;

        // Start checking elements from the last element
        for (int i = nums.size() - 1; i >= 0; i--) {

            // Count the current operation
            count++;

            // If current number is present in the set
            if (set.contains(nums.get(i))) {

                // Remove that number from the set
                set.remove(nums.get(i));

                // If all numbers from 1 to k are found
                if (set.isEmpty()) {
                    break;
                }
            }
        }

        return count;
    }
}