import java.util.HashMap;

public class Ransom_Note_Question_383 {

    public static void main(String[] args) {

        String ransomNote = "aa";
        String magazine = "aab";

        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {

            char current = magazine.charAt(i);

            hm.put(current, hm.getOrDefault(current, 0) + 1);
        }

        boolean result = true;

        for (int j = 0; j < ransomNote.length(); j++) {

            char current = ransomNote.charAt(j);

            if (hm.containsKey(current)) {

                hm.put(current, hm.get(current) - 1);

            } else {

                result = false;
                break;
            }

            if (hm.get(current) == 0) {
                hm.remove(current);
            }
        }

        System.out.println("Ransom Note : " + ransomNote);
        System.out.println("Magazine    : " + magazine);
        System.out.println("Can Construct : " + result);
    }
}