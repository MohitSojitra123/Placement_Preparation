// Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose 
// sum is equal to K.  
// Input: N = 4, K = 6, arr[] = {1, 5, 7, 1} Output: 2

import java.util.HashSet;

public class Question_36 {

    public static void main(String[] args) {

        int arr[] = {1, 5, 7, 1};
        int k = 6;

        HashSet<Integer> set = new HashSet<>();
        int count = 0;

        for (int num : arr) {

            int complement = k - num;

            if (set.contains(complement)) {
                count++;
            }

            set.add(num);
        }

        System.out.println("Number of pairs = " + count);
    }
}