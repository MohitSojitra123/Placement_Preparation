import java.util.Arrays;

public class Rearrange_Element {

    public static void main(String[] args) {

        int array[] = {1, 1, 2, 3, -4, 5, -6, 1, 7, -8, -9, 3, 4, -6};

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(array));

        int left = 0;
        int right = 1;

        while (left < array.length && right < array.length) {

            // left position should contain positive
            if (array[left] < 0) {

                for (int j = left + 1; j < array.length; j++) {

                    if (array[j] >= 0) {
                        int temp = array[left];
                        array[left] = array[j];
                        array[j] = temp;
                        break;
                    }
                }
            }

            // right position should contain negative
            if (right < array.length && array[right] >= 0) {

                for (int j = right + 1; j < array.length; j++) {

                    if (array[j] < 0) {
                        int temp = array[right];
                        array[right] = array[j];
                        array[j] = temp;
                        break;
                    }
                }
            }

            left += 2;
            right += 2;
        }

        System.out.println("Rearranged Array:");
        System.out.println(Arrays.toString(array));
    }
}