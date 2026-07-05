public class Find_Minimum_Rotatedd_Sorted_Array_Question_153 {

    public static int findMin(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        } 
        else if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (mid != 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            } 
            else if (mid != nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } 
            else if (nums[start] <= nums[mid]) {
                start = mid + 1;
            } 
            else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        // Static Input
        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        int result = findMin(nums);

        System.out.println("Minimum Element = " + result);
    }
}