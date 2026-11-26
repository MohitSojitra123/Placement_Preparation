// 25 Given 2 sorted arrays a[] and b[], each of size n, the task is to find the median of the 
// array obtained after merging a[] and b[].  
// Input: a[] = [1, 12, 15, 26, 38], b[] = [2, 13, 17, 30, 45] 
// Output: 16 
// Explanation: The middle two elements are 15 and 17,  
// so median = (15 + 17)/2 = 16

public class Problem_25 {
    public static void main(String[] args) {

        int[] a = {1, 12, 15, 26, 38};
        int[] b = {2, 13, 17, 30, 45, 50, 60};

        int[] merged = new int[a.length + b.length];

        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                merged[k++] = a[i++];
            } else {
                merged[k++] = b[j++];
            }
        }

        while (i < a.length) {
            merged[k++] = a[i++];
        }

        while (j < b.length) {
            merged[k++] = b[j++];
        }

        int size = merged.length;

        double median;

        if (size % 2 == 0) {
            median = (merged[size / 2] + merged[(size / 2) - 1]) / 2.0;
        } else {
            median = merged[size / 2];
        }

        System.out.println("Median = " + median);
    }
}