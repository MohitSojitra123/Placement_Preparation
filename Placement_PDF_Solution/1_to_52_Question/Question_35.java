// Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying 
// at most one element.  
// Input: nums = [4,2,3] 
// Output: true 
// Explanation: You could modify the first 4 to 1 to get a non-decreasing array. 

public class Question_35 {

    public static boolean checkPossibility(int[] nums) {

        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] > nums[i + 1]) {

                count++;

                if (count > 1) {
                    return false;
                }

                if (i == 0 || nums[i - 1] <= nums[i + 1]) {
                    nums[i] = nums[i + 1];
                }    
                else {
                    nums[i + 1] = nums[i];
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int nums[] = {4, 2, 3};

        System.out.println(checkPossibility(nums));
    }
}