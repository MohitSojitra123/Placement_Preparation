import java.util.Arrays;

public class FindDuplicateNumber_Question_287 {

    public static void main(String[] args) {

        int nums[] = {1, 3, 4, 2, 2};

        Arrays.sort(nums);


        int duplicate = -1;

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] == nums[i + 1]) {
                duplicate = nums[i];
                break;
            }
        }

        System.out.println("Duplicate Number = " + duplicate);
    }
}