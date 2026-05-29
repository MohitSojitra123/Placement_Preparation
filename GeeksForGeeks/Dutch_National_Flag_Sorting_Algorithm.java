import java.util.*;

class Dutch_National_Flag_Sorting_Algorithm {

    public static void sort012(int[] arr) {

        int low = 0, mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {

            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;

                low++;
                mid++;
            }
            else if (arr[mid] == 1) {
                mid++;
            }
            else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;

                high--;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 0, 1, 2};

        sort012(arr);

        System.out.println(Arrays.toString(arr));
    }
}