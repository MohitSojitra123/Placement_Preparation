import java.util.Arrays;

public class Alternate_Positive_Negative_Number_2 {

    public static void main(String[] args) {

        int array[] = {1, 2, -3, 3, -5, 4, 5, -2, 6, 7};

        int p_index = 0;
        int n_index = 1;

        for (int i = 0; i < array.length; i++) {

            // Positive should be at even index
            if (i % 2 == 0 && array[i] < 0) {

                for (int j = i + 1; j < array.length; j++) {

                    if (array[j] > 0) {

                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;

                        break;
                    }
                }
            }

            // Negative should be at odd index
            if (i % 2 != 0 && array[i] > 0) {

                for (int j = i + 1; j < array.length; j++) {

                    if (array[j] < 0) {

                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;

                        break;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }
}