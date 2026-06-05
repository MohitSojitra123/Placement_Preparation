

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