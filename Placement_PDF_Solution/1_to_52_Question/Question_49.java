// Given an array nums of distinct integers, return all the possible permutations. You can return the answer 
// in any order.  
// Input: nums = [1,2,3] Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]] 


import java.util.Arrays;

public class Question_49 {

    // Find next lexicographical permutation
    public static boolean nextPermutation(int[] nums) {

        int i = nums.length - 2;

        // Find first decreasing element
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // No more permutations
        if (i < 0) {
            return false;
        }

        int j = nums.length - 1;

        // Find next greater element
        while (nums[j] <= nums[i]) {
            j--;
        }

        // Swap
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        // Reverse remaining part
        int left = i + 1;
        int right = nums.length - 1;

        while (left < right) {
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        // Print first permutation
        System.out.println(Arrays.toString(nums));

        // Print remaining permutations
        while (nextPermutation(nums)) {
            System.out.println(Arrays.toString(nums));
        }
    }
}



// import java.util.*;

// public class Question_49 {

//     static List<List<Integer>> ans = new ArrayList<>();

//     public static void backtrack(int[] nums, boolean[] visited, List<Integer> temp) {

//         if (temp.size() == nums.length) {
//             ans.add(new ArrayList<>(temp));
//             return;
//         }

//         for (int i = 0; i < nums.length; i++) {

//             if (visited[i])
//                 continue;

//             visited[i] = true;
//             temp.add(nums[i]);

//             backtrack(nums, visited, temp);

//             temp.remove(temp.size() - 1);
//             visited[i] = false;
//         }
//     }

//     public static void main(String[] args) {

//         int[] nums = {1, 2, 3};

//         boolean[] visited = new boolean[nums.length];

//         backtrack(nums, visited, new ArrayList<>());

//         System.out.println(ans);
//     }
// }