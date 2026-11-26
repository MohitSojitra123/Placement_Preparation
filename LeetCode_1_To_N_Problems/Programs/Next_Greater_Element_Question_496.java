import java.util.Arrays;

public class Next_Greater_Element_Question_496{

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {

            int current_element = nums1[i];

            for (int j = 0; j < nums2.length; j++) {

                if (nums2[j] == current_element) {

                    int max_element = current_element;

                    for (int k = j + 1; k < nums2.length; k++) {

                        if (nums2[k] > max_element) {
                            max_element = nums2[k];
                            break;
                        }
                    }

                    if (max_element == current_element) {
                        ans[i] = -1;
                    } else {
                        ans[i] = max_element;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        // Static Input
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] result = nextGreaterElement(nums1, nums2);

        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("nums2: " + Arrays.toString(nums2));
        System.out.println("Next Greater Elements: " + Arrays.toString(result));
    }
}