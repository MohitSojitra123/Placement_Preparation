// Given an array, rotate the array to the right by k steps, where k is non-negative. 
// Example 1: 
// Input: nums = [1,2,3,4,5,6,7], k = 3 
// Output: [5,6,7,1,2,3,4] 
// Explanation: 
// rotate 1 step to the right: [7,1,2,3,4,5,6] 
// rotate 2 steps to the right: [6,7,1,2,3,4,5] 
// rotate 3 steps to the right: [5,6,7,1,2,3,4] 

import java.util.Scanner;

public class Problem_39 {

 
    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);

        System.out.println("Rotated Array:");

        for (int x : nums) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}