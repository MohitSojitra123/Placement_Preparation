// Given an array nums with n integers, your task is to check if it could become non-decreasing 
// by modifying at most one 
// Input: nums = [4,2,3] 
// Output: true 
// Explanation: You could modify the first 4 to 1 to get a non-decreasing array. 

// Given an array nums with n integers, check if it can become
// non-decreasing by modifying at most one element.


import java.util.Scanner;

public class Problem_40 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int count = 0;

        for (int i = 0; i < n - 1; i++) {

            if (nums[i] > nums[i + 1]) {

                count++;

                if (count > 1) {
                    System.out.println(false);
                    return;
                }

                if (i == 0 || nums[i - 1] <= nums[i + 1]) {
                    nums[i] = nums[i + 1];
                } else {
                    nums[i + 1] = nums[i];
                }
            }
        }

        System.out.println(true);

        sc.close();
    }
}