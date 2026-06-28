// Given an unsorted integer array nums, return the smallest missing positive integer. You must implement 
// an algorithm that runs in O(n) time and uses constant extra space.  
// Input: nums = [1,2,0] Output: 3

import java.util.HashSet;

public class Question_48_2 {

    public static void main(String[] args) {

        int nums[] = {1, 2, 0};

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int missing = 1;

        while (set.contains(missing)) {
            missing++;
        }

        System.out.println("First Missing Positive = " + missing);
    }
}