import java.util.Arrays;

public class Unique_Element_Index_Return_Sorted_Array {
    public static void main(String[] args) {

        int array[] = {
            1,1,1,2,2,2,2,3,3,3,4,5,5,6,6,6,7,8,8,8,8,9,9,10,10,10,10,11,11,11,12,12,12,12,13
        };

        int unique_current_index = 0;

        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length - 1; i++) {

            if (array[i] != array[i + 1]) {
                array[unique_current_index] = array[i];
                unique_current_index++;
            }
        }

        // Add the last element
        array[unique_current_index] = array[array.length - 1];
        unique_current_index++;

        System.out.println(
            Arrays.toString(Arrays.copyOf(array, unique_current_index))
        );
    }
}