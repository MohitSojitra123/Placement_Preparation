
// Input:
// Array = [1, 2, 3, 4, 5, 6, 7, 8]
// K = 3
// Output:
// [3, 2, 1, 6, 5, 4, 8, 7]


// Original Array

// 1 2 3 | 4 5 6 | 7 8
// ------- ------- ----
// Reverse Each Group
// 3 2 1 | 6 5 4 | 8 7


public class Reverse_Every_K_Elements {

    public static void reverseK(int arr[], int k) {

        for (int i = 0; i < arr.length; i += k) {

            int left = i;
            int right = Math.min(i + k - 1, arr.length - 1);

            while (left < right) {

                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {

        int arr[] = {1,2,3,4,5,6,7,8};
        int k = 3;

        reverseK(arr, k);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}