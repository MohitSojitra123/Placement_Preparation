// You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, 
// such  that  i  !=  j,  and  the  sum  of  digits  of  the  number  nums[i]  is  equal  to  that  of  nums[j].    Return  the 
// maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the 
// conditions.  
// Input: nums = [18,43,36,13,7] Output: 54 
// Explanation: The pairs (i, j) that satisfy the conditions are: 
// - (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54. 
// - (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50. 
// So the maximum sum that we can obtain is 54. 

import java.util.HashMap;

public class Question_45 {

    public static int digitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum = sum + (num % 10);
            num = num / 10;
        }

        return sum;
    }

    public static void main(String[] args) {

        int nums[] = {18, 43, 36, 13, 7};

        HashMap<Integer, Integer> map = new HashMap<>();

        int maxSum = -1;

        for (int i = 0; i < nums.length; i++) {

            int sum = digitSum(nums[i]);

            if (map.containsKey(sum)) {

                int pairSum = nums[i] + map.get(sum);

                if (pairSum > maxSum) {
                    maxSum = pairSum;
                }

                // Store the larger number for this digit sum
                if (nums[i] > map.get(sum)) {
                    map.put(sum, nums[i]);
                }

            } else {
                map.put(sum, nums[i]);
            }
        }

        System.out.println("Maximum Sum = " + maxSum);

        System.out.println(map);
    }
}