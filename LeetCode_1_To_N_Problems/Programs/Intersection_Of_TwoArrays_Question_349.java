import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class Intersection_Of_TwoArrays_Question_349 {

    public static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();


        for (int i = 0; i < nums1.length; i++) {
            s1.add(nums1[i]);
        }

        for (int j = 0; j < nums2.length; j++) {
            s2.add(nums2[j]);
        }

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i : s1) {
            if (s2.contains(i)) {
                arr.add(i);
            }
        }

        int[] array1 = new int[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            array1[i] = arr.get(i);
        }

        return array1;
    }

    public static void main(String[] args) {

        // Static Input
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] result = intersection(nums1, nums2);

        System.out.println("Intersection of Two Arrays:");
        System.out.println(Arrays.toString(result));
    }
}