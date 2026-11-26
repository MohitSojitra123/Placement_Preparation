import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Merge_Sorted_Array_Question_88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        ArrayList<Integer> arr = new ArrayList<>();

   
        for (int i = 0; i < m; i++) {
            arr.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            arr.add(nums2[i]);
        }

        Collections.sort(arr);

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = arr.get(i);
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;

        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);

        System.out.println("Merged Array:");
        System.out.println(Arrays.toString(nums1));
    }
}