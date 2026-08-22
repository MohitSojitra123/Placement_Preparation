import java.util.*;

import javax.lang.model.util.Elements;

public class Distribute_Elements_Into_Two_Arrays_II_Question_3072 {

    public static int[] resultArray(int[] nums) {

        int n = nums.length;

        // arr1 and arr2 will store the actual elements
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        // Sorted versions used for counting greater elements
        int[] sorted1 = new int[n];
        int[] sorted2 = new int[n];

        int size1 = 0;
        int size2 = 0;

        // First element -> arr1
        arr1[size1++] = nums[0];
        sorted1[size1 - 1] = nums[0];

        // Second element -> arr2
        arr2[size2++] = nums[1];
        sorted2[size2 - 1] = nums[1];

        for (int i = 2; i < n; i++) {

            int x = nums[i];

            // Sort only the used part
            Arrays.sort(sorted1, 0, size1);
            Arrays.sort(sorted2, 0, size2);

            // Find how many elements are <= x
            int lessEqual1 = upperBound(sorted1, size1, x);
            int lessEqual2 = upperBound(sorted2, size2, x);

            // Elements greater than x
            int greater1 = size1 - lessEqual1;
            int greater2 = size2 - lessEqual2;

            if (greater1 > greater2) {

                // Put x in arr1
                arr1[size1] = x;
                sorted1[size1] = x;
                size1++;

            } else if (greater1 < greater2) {

                // Put x in arr2
                arr2[size2] = x;
                sorted2[size2] = x;
                size2++;

            } else {

                // Same greater count
                // Put in smaller array

                if (size1 <= size2) {

                    arr1[size1] = x;
                    sorted1[size1] = x;
                    size1++;

                } else {

                    arr2[size2] = x;
                    sorted2[size2] = x;
                    size2++;
                }
            }
        }

        // Create final result
        int[] result = new int[n];

        int index = 0;

        // Add arr1
        for (int i = 0; i < size1; i++) {
            result[index++] = arr1[i];
        }

        // Add arr2
        for (int i = 0; i < size2; i++) {
            result[index++] = arr2[i];
        }

        return result;
    }

    // Find first position where value > target
    public static int upperBound(int[] arr, int size, int target) {

        int left = 0;
        int right = size;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {

        // Static Input
        int[] nums = {5, 14, 3, 1, 2};

        // Call method
        int[] result = resultArray(nums);

        // Print result
        System.out.println("Result: " + Arrays.toString(result));
    }
}