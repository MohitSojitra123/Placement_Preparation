// 30 Given an array of positive integers arr[] of size n, the task is to find the second 
// largest distinct element in the array. 
// Note: If the second largest element does not exist, return -1. 
// Input: arr[] = [12, 35, 1, 10, 34, 1] 
// Output: 34 
// Explanation: The largest element of the array is 35 and the second largest element 
// is 34. 
// Input: arr[] = [10, 10, 10] 
// Output: -1 
// Explanation: The largest element of the array is 10 there is no second largest 
// element

import java.util.Arrays;

public class Problem_30_2{
    public static void main(String[] args) {

        int arr[] = {12, 35, 1, 10, 34, 1};

        Arrays.sort(arr);

        int largest = arr[arr.length - 1];
        int secondLargest = -1;

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] != largest) {
                secondLargest = arr[i];
                break;
            }
        }

        System.out.println(secondLargest);
    }
}