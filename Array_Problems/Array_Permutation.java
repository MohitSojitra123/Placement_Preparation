import java.util.Arrays;

public class Array_Permutation {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};

        findPermutations(arr, 0);
    }

    public static void findPermutations(int[] arr, int index) {

        // Base condition
        if (index == arr.length) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        // Try every element at current index
        for (int i = index; i < arr.length; i++) {

            // Swap
            swap(arr, index, i);

            // Recursively generate remaining permutations
            findPermutations(arr, index + 1);

            // Backtrack (restore original array)
            swap(arr, index, i);
        }
    }

    public static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}