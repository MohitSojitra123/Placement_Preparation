// Given two integer arrays nums1 and nums2, return an array of their intersection. Each 
// element in the result must appear as many times as it shows in both arrays and you may 
// return the result in sorted order. 


// Enter size of first array: 5
// Enter elements:
// 4 9 5 4 8

// Enter size of second array: 5
// Enter elements:
// 9 4 9 8 4


// Given two integer arrays nums1 and nums2, return an array of their intersection.

import java.util.Arrays;
import java.util.Scanner;

public class Problem_35 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.print("Enter size of first array: ");
        int n1 = sc.nextInt();

        int[] nums1 = new int[n1];
        System.out.println("Enter elements:");
        for (int i = 0; i < n1; i++) {
            nums1[i] = sc.nextInt();
        }


        System.out.print("Enter size of second array: ");
        int n2 = sc.nextInt();

        int[] nums2 = new int[n2];
        System.out.println("Enter elements:");
        for (int i = 0; i < n2; i++) {
            nums2[i] = sc.nextInt();
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        int[] result = new int[Math.min(n1, n2)];
        int k = 0;

        while (i < n1 && j < n2) {

            if (nums1[i] == nums2[j]) {
                result[k++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        System.out.print("Intersection Array: ");

        for (int x = 0; x < k; x++) {
            System.out.print(result[x] + " ");
        }

        sc.close();
    }
}