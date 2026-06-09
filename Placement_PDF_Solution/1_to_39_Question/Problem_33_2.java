
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

public class Problem_33_2 {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6};
        int d = 2;

        int n = arr.length;
        d = d % n; 

        int[] result = new int[n];

        
        for (int i = d; i < n; i++) {
            result[i - d] = arr[i];
        }

       
        for (int i = 0; i < d; i++) {
            result[n - d + i] = arr[i];
        }

        System.out.println("Rotated Array: " + Arrays.toString(result));
    }
}