// Find the length of the maximum number of consecutive numbers jumbled up in an 
// array.  
// Input: arr[] = {1, 94, 93, 1000, 5, 92, 78}; 
// Output : 3  
// Explanation: The largest set of consecutive elements is 92, 93, 94.  
// Input: arr[] = {1, 5, 92, 4, 78, 6, 7}; 
// Output: 4  
// Explanation: The largest set of consecutive elements is 4, 5, 6, 7. 

import java.util.Arrays;

public class Problem_15 {

    public static int longestConsecutive(int arr[]) {

        Arrays.sort(arr);

        int count = 1;
        int max = 1;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] == arr[i - 1] + 1) {
                count++;
            } else {
                count = 1;
            }

            if (count > max) {
                max = count;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int arr[] = {1, 94, 93, 1000, 5, 92, 78};

        System.out.println("Length = " + longestConsecutive(arr));
    }
}