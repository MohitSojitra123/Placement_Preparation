
// 33 Given an array of integers arr[] of size n, the task is to rotate the array elements to 
// the left by d positions. 
 
// Input: arr[] = {1, 2, 3, 4, 5, 6}, d = 2 
// Output: {3, 4, 5, 6, 1, 2} 
// Explanation:  
// After first left rotation, arr[] becomes {2, 3, 4, 5, 6, 1}, 
// After the second rotation, arr[] becomes {3, 4, 5, 6, 1, 2} 
 
// Input: arr[] = {1, 2, 3}, d = 4 
// Output: {2, 3, 1} 
// Explanation: The array is rotated as follows: 
// After first left rotation, arr[] = {2, 3, 1} 
// After second left rotation, arr[] = {3, 1, 2} 
// After third left rotation, arr[] = {1, 2, 3} 
// After fourth left rotation, arr[] = {2, 3, 1}

import java.util.Arrays;

public class Problem_33_1 {

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    static void leftRotate(int[] arr, int d) {
        int n = arr.length;

        d = d % n;

        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6};
        int d = 2;

        leftRotate(arr, d);

        System.out.println("Rotated Array: " + Arrays.toString(arr));
    }
}