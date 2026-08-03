import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Find_Difference_Of_Two_Arrays_Question_2215 {

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<List<Integer>> list1 = new ArrayList<>();

        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            s1.add(nums1[i]);
        }

        for (int j = 0; j < nums2.length; j++) {
            s2.add(nums2[j]);
        }

        List<Integer> temp1 = new ArrayList<>();

        for (int i : s1) {
            if (!s2.contains(i)) {
                temp1.add(i);
            }
        }

        List<Integer> temp2 = new ArrayList<>();

        for (int j : s2) {
            if (!s1.contains(j)) {
                temp2.add(j);
            }
        }

        list1.add(temp1);
        list1.add(temp2);

        return list1;
    }

    public static void main(String[] args) {

        // Static Input
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};

        List<List<Integer>> result = findDifference(nums1, nums2);

        System.out.println("Difference of Two Arrays:");
        System.out.println(result);
    }
}