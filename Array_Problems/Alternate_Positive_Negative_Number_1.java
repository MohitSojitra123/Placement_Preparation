import java.lang.reflect.Array;
import java.util.Arrays;

class Alternate_Positive_Negative_Number_1{
    public static void main(String[] args) {

          int array[] = {1, 2, -3, 3, -5, 4, 5, -2, 6, 7};

        int ans[] = new int[array.length];

        int p_index = 0;
        int n_index = 1;

        for (int i = 0; i < array.length; i++) {

            if (array[i] > 0) {

                ans[p_index] = array[i];
                p_index += 2;

            } else {

                ans[n_index] = array[i];
                n_index += 2;
            }
        }

        System.out.println("Original Array : " + Arrays.toString(array));
        System.out.println("Result Array   : " + Arrays.toString(ans));
              
            }
        }