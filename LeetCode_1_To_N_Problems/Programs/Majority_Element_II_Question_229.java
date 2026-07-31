import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Majority_Element_II_Question_229 {

    public static ArrayList<Integer> majorityElement(int[] nums) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();
        ArrayList<Integer> arr = new ArrayList<>();

        for (int num : nums) {

            hm.put(num, hm.getOrDefault(num, 0) + 1);

            if (hm.get(num) > nums.length / 3) {
                hs.add(num);
            }
        }

        for (int i : hs) {
            arr.add(i);
        }

        return arr;
    }

    public static void main(String[] args) {

        // Static Array Input
        int nums[] = {3, 2, 3};

        ArrayList<Integer> result = majorityElement(nums);

        System.out.println("Majority Elements (> n/3): " + result);
    }
}