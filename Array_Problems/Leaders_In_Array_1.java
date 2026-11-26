import java.util.ArrayList;
import java.util.Collections;

public class Leaders_In_Array_1 {

    public static void main(String[] args) {

        int arr[] = {16, 17, 4, 3, 5, 2};

        ArrayList<Integer> leaders = new ArrayList<>();

        int max = arr[arr.length - 1];
        leaders.add(max);

        for (int i = arr.length - 2; i >= 0; i--) {

            if (arr[i] >= max) {
                max = arr[i];
                leaders.add(arr[i]);
            }
        }

        Collections.reverse(leaders);

        for (int num : leaders) {
            System.out.print(num + " ");
        }
    }
}