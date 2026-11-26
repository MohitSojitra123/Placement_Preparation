import java.util.HashSet;

class containsNearbyDuplicate_219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (hs.contains(nums[i])) {
                return true;
            }

            hs.add(nums[i]);

            if (hs.size() > k) {
                hs.remove(nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};
        int k = 3;

        containsNearbyDuplicate_219 obj = new containsNearbyDuplicate_219();

        boolean result = obj.containsNearbyDuplicate(nums, k);

        System.out.println(result);
    }
}

// Simple Approach

// class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {

//     for (int i = 0; i < nums.length; i++) {
//             for (int j = i + 1; j < nums.length; j++) {

//                 if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }