import java.util.Arrays;

public class Remove_Duplicate_Element_In_Sorted_Array {
    public static void main(String[] args) {

        int array[] = {
            1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 8,
            9, 10, 10, 10, 10, 10, 11, 12, 12, 12, 12, 12
        };

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(array));

        int current_index = 1;

        for (int i = 1; i < array.length; i++) {

            if (array[i - 1] != array[i]) {
                array[current_index] = array[i];
                current_index++;
            }
        }

        System.out.println("Array After Removing Duplicates:");

        System.out.println(Arrays.toString(
            Arrays.copyOf(array, current_index)
        ));
    }
}