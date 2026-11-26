import java.util.Arrays;

public class Merge_Sorted_Array_Question_88_1{

    public static void main(String[] args) {

        int nums1[] = {1,2,3,0,0,0};
        int nums2[] = {2,5,6};

        int m = 3;
        int n = 3;

        int ans[] = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {

            if (nums1[i] <= nums2[j]) {
                ans[k++] = nums1[i++];
            } else {
                ans[k++] = nums2[j++];
            }
        }

        while (i < m) {
            ans[k++] = nums1[i++];
        }

        while (j < n) {
            ans[k++] = nums2[j++];
        }

        for (i = 0; i < m + n; i++) {
            nums1[i] = ans[i];
        }

        System.out.println(Arrays.toString(nums1));
    }
}