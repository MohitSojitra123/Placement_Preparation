import java.util.Arrays;

public class Sort_Array_By_Parity_II_Question_922{

    public static int[] sortArrayByParityII(int[] nums) {

        int odd_ptr = 1;
        int even_ptr = 0;

        while (odd_ptr < nums.length && even_ptr < nums.length) {

            // Check even index
            if (nums[even_ptr] % 2 == 0) {
                even_ptr += 2;
            } else {

                for (int i = even_ptr + 1; i < nums.length; i++) {

                    if (nums[i] % 2 == 0) {

                        int temp = nums[i];
                        nums[i] = nums[even_ptr];
                        nums[even_ptr] = temp;

                        even_ptr += 2;
                        break;
                    }
                }
            }

            // Check odd index
            if (nums[odd_ptr] % 2 != 0) {
                odd_ptr += 2;
            } else {

                for (int i = odd_ptr + 1; i < nums.length; i++) {

                    if (nums[i] % 2 != 0) {

                        int temp = nums[i];
                        nums[i] = nums[odd_ptr];
                        nums[odd_ptr] = temp;

                        odd_ptr += 2;
                        break;
                    }
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {

        // Static Input
        int[] nums = {4, 2, 5, 7};

        System.out.println("Original Array : " + Arrays.toString(nums));

        int[] result = sortArrayByParityII(nums);

        System.out.println("Sorted Array   : " + Arrays.toString(result));
    }
}