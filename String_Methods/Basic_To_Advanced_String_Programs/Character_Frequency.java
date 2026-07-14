import java.util.HashMap;
import java.util.Map;

public class Character_Frequency {

    public static void main(String[] args) {

        String str = "programming";

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } 
            else {
                map.put(ch, 1);
            }
        }

        // Print character with frequency
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}