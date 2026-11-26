public class Single_Non_Duplicate_Question_540{

    public static void main(String[] args) {

        int nums[] = {1, 1, 2, 3, 3, 4, 4, 8, 8};

        int result = singleNonDuplicate(nums);

        System.out.println("Single Non-Duplicate Element = " + result);
    }

    public static int singleNonDuplicate(int[] nums) {

        int count = 1;

        for (int i = 0; i < nums.length; i++) {

            count = 1;

            if (nums.length - 1 == i) {
                return nums[i];
            }

            if (nums[i] == nums[i + 1]) {
                i++;
            } else {
                if (count != 2) {
                    return nums[i];
                }
            }
        }

        return nums.length == 1 ? nums[0] : -1;
    }
}