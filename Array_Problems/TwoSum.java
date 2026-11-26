import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int arr[], int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            int current = arr[i];

            int needed = target - current;

            // Check needed number already exists
            if (map.containsKey(needed)) {

                return new int[] { map.get(needed), i };
            }

            // Store current number and index
            map.put(current, i);
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {

        int arr[] = {2, 7, 11, 15};

        int target = 9;

        int result[] = twoSum(arr, target);

        System.out.println("Index 1 = " + result[0]);
        System.out.println("Index 2 = " + result[1]);
    }
}