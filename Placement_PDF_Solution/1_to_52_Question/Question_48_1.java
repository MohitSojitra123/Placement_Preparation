// Given an unsorted integer array nums, return the smallest missing positive integer. You must implement 
// an algorithm that runs in O(n) time and uses constant extra space.  
// Input: nums = [1,2,0] Output: 3

public class Question_48_1 {

    public static void main(String[] args) {

        int nums[] = {1, 2, 0};

        int missing = 1;

        while (true) {

            boolean found = false;

            for (int num : nums) {

                if (num == missing) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("First Missing Positive = " + missing);
                break;
            }

            missing++;
        }
    }
}