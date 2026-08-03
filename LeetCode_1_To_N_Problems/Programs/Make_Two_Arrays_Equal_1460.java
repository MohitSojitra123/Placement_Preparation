import java.util.HashMap;

public class Make_Two_Arrays_Equal_1460{

    public static boolean canBeEqual(int[] target, int[] arr) {

        HashMap<Integer, Integer> hm = new HashMap<>();


        for (int i = 0; i < target.length; i++) {
            hm.put(target[i], hm.getOrDefault(target[i], 0) + 1);
        }

        for (int j = 0; j < arr.length; j++) {

            if (hm.containsKey(arr[j])) {
                hm.put(arr[j], hm.getOrDefault(arr[j], 0) - 1);
            } else {
                return false;
            }

            if (hm.get(arr[j]) == 0) {
                hm.remove(arr[j]);
            }
        }

        return hm.isEmpty();
    }

    public static void main(String[] args) {

        int[] target = {1, 2, 3, 4};
        int[] arr = {2, 4, 1, 3};

        boolean result = canBeEqual(target, arr);

        System.out.println("Can Be Equal: " + result);
    }
}