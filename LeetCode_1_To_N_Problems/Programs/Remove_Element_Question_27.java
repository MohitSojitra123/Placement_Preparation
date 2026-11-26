public class Remove_Element_Question_27 {
    public static void main(String[] args) {

        int[] nums = {3, 2, 2, 3};
        int val = 3;

        int p = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[p] = nums[i];
                p++;
            }
        }

        System.out.println("New Length: " + p);

        System.out.print("Modified Array: ");
        for (int i = 0; i < p; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}