import java.util.Arrays;

public class Get_Saneaky_Number_Question_3289 {

    public static int[] getSneakyNumbers(int[] nums) {

        int result[] = new int[2];
        int count[] = new int[nums.length];
        int current_index = 0;

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;

            if (count[nums[i]] == 2) {
                result[current_index++] = nums[i];
            }

            if (current_index == 2) {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        // Static Input
        int[] nums = {0, 1, 1, 0};

        int[] result = getSneakyNumbers(nums);

        System.out.println("Sneaky Numbers: " + Arrays.toString(result));
    }
}