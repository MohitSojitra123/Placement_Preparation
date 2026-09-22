public class Minimum_Common_Value_Question_2540_1 {

    public static int getCommon(int[] nums1, int[] nums2) {

        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } 
            else if (nums1[i] < nums2[j]) {
                i++;
            } 
            else {
                j++;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        // Static Input
        int[] nums1 = {1, 2, 3, 6};
        int[] nums2 = {2, 3, 4, 5};

        // Calling method
        int result = getCommon(nums1, nums2);

        // Output
        System.out.println("Smallest Common Element: " + result);
    }
}