import java.util.Arrays;

public class Duplicate_Zeros_Question_1089{

    public static void duplicateZeros(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {

                // Shift elements to the right
                for (int j = arr.length - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }

                // Insert duplicate zero
                if (i + 1 < arr.length) {
                    arr[i + 1] = 0;
                }

                // Skip the duplicated zero
                i++;
            }
        }
    }

    public static void main(String[] args) {

        // Static Input
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};

        System.out.println("Original Array : " + Arrays.toString(arr));

        duplicateZeros(arr);

        System.out.println("After Duplicate : " + Arrays.toString(arr));
    }
}