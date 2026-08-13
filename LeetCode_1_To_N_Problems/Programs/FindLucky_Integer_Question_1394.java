import java.util.HashMap;

public class FindLucky_Integer_Question_1394 {

    public static int findLucky(int[] arr) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            if (hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i]) + 1);
            } else {
                hm.put(arr[i], 1);
            }
        }

        int ans = -1;

        for (int i : hm.keySet()) {

            if (i == hm.get(i)) {
                ans = Math.max(ans, i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {2, 2, 3, 4};

        int result = findLucky(arr);

        System.out.println("Input  : " + java.util.Arrays.toString(arr));
        System.out.println("Output : " + result);
    }
}