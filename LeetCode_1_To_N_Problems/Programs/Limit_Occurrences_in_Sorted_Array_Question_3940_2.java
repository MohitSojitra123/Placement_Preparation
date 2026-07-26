import java.util.*;

public class Limit_Occurrences_in_Sorted_Array_Question_3940_2 {

    public static void main(String[] args) {

        // Static Array Input
        int[] nums = {1, 2, 3, 1, 2, 1, 2};
        int k = 2;

        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();

        // Keep only the first k occurrences of each element
        for (int num : nums) {

            int count = hm.getOrDefault(num, 0);

            if (count < k) {
                arr.add(num);
                hm.put(num, count + 1);
            }
        }

        // Convert ArrayList to Array
        int[] ans = new int[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }

        // Print Result
        System.out.print("Result Array: ");
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}