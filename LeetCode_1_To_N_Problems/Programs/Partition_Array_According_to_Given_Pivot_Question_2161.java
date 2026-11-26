import java.util.ArrayList;
import java.util.Arrays;

public class  Partition_Array_According_to_Given_Pivot_Question_2161 {

    public static int[] pivotArray(int[] nums, int pivot) {

        int[] ans = new int[nums.length];
        ArrayList<Integer> arr = new ArrayList<>();

        int current_index = 0;
        int pivot_count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < pivot) {
                ans[current_index++] = nums[i];

            } else if (nums[i] == pivot) {
                pivot_count++;

            } else {
                arr.add(nums[i]);
            }
        }

        for (int i = 1; i <= pivot_count; i++) {
            ans[current_index++] = pivot;
        }

        for (int i = 0; i < arr.size(); i++) {
            ans[current_index++] = arr.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        int pivot = 10;

        int[] result = pivotArray(nums, pivot);

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(nums));

        System.out.println("Pivot: " + pivot);

        System.out.println("Pivoted Array:");
        System.out.println(Arrays.toString(result));
    }
}