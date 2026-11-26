import java.util.HashSet;

public class Minimum_Common_Value_Question_2540 {

    public static int getCommon(int[] nums1, int[] nums2) {

        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            hs.add(nums1[i]);
        }

        for (int j = 0; j < nums2.length; j++) {
            if (hs.contains(nums2[j])) {
                return nums2[j];
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        // Static Input
        int[] nums1 = {1, 2, 3, 6};
        int[] nums2 = {2, 3, 4, 5};

        // Method call
        int result = getCommon(nums1, nums2);

        // Output
        System.out.println("Common Element: " + result);
    }
}