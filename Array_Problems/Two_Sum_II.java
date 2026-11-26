import java.util.Arrays;

public class Two_Sum_II {

    public static void main(String[] args) {

        int numbers[] = {2, 7, 11, 15};
        int target = 9;

        int result[] = twoSum(numbers, target);

        System.out.println("Indices: " + Arrays.toString(result));

        if (result[0] != -1) {
            System.out.println("Numbers: " +
                    numbers[result[0] - 1] + " + " +
                    numbers[result[1] - 1] + " = " + target);
        } else {
            System.out.println("No Pair Found");
        }
    }

    public static int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } 
            else if (sum < target) {
                left++;
            } 
            else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }
}