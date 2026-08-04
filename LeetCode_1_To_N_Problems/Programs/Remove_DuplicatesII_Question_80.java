import java.util.Arrays;

public class Remove_DuplicatesII_Question_80 {

    public static int removeDuplicates(int[] nums) {

        int current_count = 1;
        int k = 0;
        int current_array_index = 0;

        for (int i = 0; i < nums.length; i++) {

            int temp_i = 0;
            current_count = 1;

            // Count consecutive duplicates
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    current_count++;
                    temp_i++;
                } else {
                    break;
                }
            }

            if (current_count >= 2) {

                k += 2;

                nums[current_array_index++] = nums[i];
                nums[current_array_index++] = nums[i];

                i += temp_i;

            } else {

                k += current_count;

                nums[current_array_index++] = nums[i];

                i += temp_i;
            }
        }

        return k;
    }

    public static void main(String[] args) {

        // Static Input
        int[] nums = {1, 1, 1, 2, 2, 3};

        int k = removeDuplicates(nums);

        System.out.println("Number of Elements (k): " + k);

        System.out.print("Modified Array: [");

        for (int i = 0; i < k; i++) {
            System.out.print(nums[i]);

            if (i != k - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}