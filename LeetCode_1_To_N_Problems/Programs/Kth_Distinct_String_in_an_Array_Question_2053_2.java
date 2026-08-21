import java.util.*;

public class  Kth_Distinct_String_in_an_Array_Question_2053_2 {

    public static String kthDistinct(String[] arr, int k) {

        HashMap<String, Integer> hm = new HashMap<>();

        // Count frequency
        for (int i = 0; i < arr.length; i++) {

            if (hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i]) + 1);
            } else {
                hm.put(arr[i], 1);
            }
        }

        ArrayList<String> arr_list = new ArrayList<>();

        // Traverse original array
        for (int i = 0; i < arr.length; i++) {

            if (hm.get(arr[i]) == 1) {
                arr_list.add(arr[i]);
            }
        }

        if (arr_list.size() < k) {
            return "";
        } else {
            return arr_list.get(k - 1);
        }
    }

    public static void main(String[] args) {

        // Static Input
        String[] arr = {"d", "b", "c", "b", "c", "a"};
        int k = 2;

        // Call method
        String result = kthDistinct(arr, k);

        // Print result
        System.out.println("Kth Distinct String = " + result);
    }
}