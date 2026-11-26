import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Arrays;

public class Unique_Occurrences_Question_1207{

    public static boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        HashSet<Integer> hs = new HashSet<>();

        for (Map.Entry<Integer, Integer> ele : hm.entrySet()) {

            if (hs.contains(ele.getValue())) {
                return false;
            } else {
                hs.add(ele.getValue());
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 1, 1, 3};

        System.out.println("Input Array : " + Arrays.toString(arr));

        boolean result = uniqueOccurrences(arr);

        System.out.println("Unique Occurrences : " + result);
    }
}