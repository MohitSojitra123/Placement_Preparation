import java.util.Arrays;

public class Replace_Elements_Question_1299{

    public static int[] replaceElements(int[] arr) {

        int[] new_array = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            if (i == arr.length - 1) {
                new_array[i] = -1;
            } else {

                int max_element = arr[i + 1];

                for (int j = i + 1; j < arr.length; j++) {

                    if (arr[j] > max_element) {
                        max_element = arr[j];
                    }
                }

                new_array[i] = max_element;
            }
        }

        return new_array;
    }

    public static void main(String[] args) {

  
        int[] arr = {17, 18, 5, 4, 6, 1};

        int[] result = replaceElements(arr);

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arr));

        System.out.println("Modified Array:");
        System.out.println(Arrays.toString(result));
    }
}