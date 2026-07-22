// Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

// Example 1:

// Input: nums = [1,2,3,1], k = 3
// Output: true
// Example 2:

// Input: nums = [1,0,1,1], k = 1
// Output: true
// Example 3:

// Input: nums = [1,2,3,1,2,3], k = 2
// Output: false

import java.util.HashSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length && j <= i + k; j++) {

                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }
}


public class Problem_3_2_Contains_Duplicate {
    
    public static void main(String[] args) {
        
           int[] nums = {1, 2, 3, 1};
        int k = 3;

        HashSet<Integer> hs = new HashSet<>();

        boolean found = false;

        for (int i = 0; i < nums.length; i++) {

            if (hs.contains(nums[i])) {
                found = true;
                break;
            }

            hs.add(nums[i]);

            if (hs.size() > k) {
                hs.remove(nums[i - k]);
            }
        }

        System.out.println(found);

    }

}
