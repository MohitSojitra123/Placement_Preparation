import java.util.ArrayList;
import java.util.Arrays;

import javax.lang.model.util.Elements;

public class  Distribute_Elements_Into_Two_Arrays_I_Question_3069 {

    public static int[] resultArray(int[] nums) {

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        // First element → arr1
        arr1.add(nums[0]);

        // Second element → arr2
        arr2.add(nums[1]);

        // From third element
        for (int i = 2; i < nums.length; i++) {

            if (arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }

        // Add arr2 elements at the end of arr1
        for (int i = 0; i < arr2.size(); i++) {
            arr1.add(arr2.get(i));
        }

        // Convert ArrayList<Integer> → int[]
        int[] array = new int[arr1.size()];

        for (int i = 0; i < array.length; i++) {
            array[i] = arr1.get(i);
        }

        return array;
    }

    public static void main(String[] args) {

        // Static array input
        int[] nums = {5, 4, 3, 8};

        // Call method
        int[] result = resultArray(nums);

        // Print result
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Output : " + Arrays.toString(result));
    }
}