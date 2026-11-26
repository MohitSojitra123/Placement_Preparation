import java.util.HashMap;

public class First_Unique_Character_Quetion_387 {

    public static void main(String[] args) {

        String str = "leetcode";

        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (hm.containsKey(str.charAt(i))) {
                hm.put(str.charAt(i), hm.getOrDefault(str.charAt(i), 0) + 1);
            } else {
                hm.put(str.charAt(i), 1);
            }
        }

        int index = -1;

        for (int i = 0; i < str.length(); i++) {
            if (hm.get(str.charAt(i)) == 1) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            System.out.println("First Unique Character: " + str.charAt(index));
            System.out.println("Index: " + index);
        } else {
            System.out.println("No Unique Character Found");
        }
    }
}