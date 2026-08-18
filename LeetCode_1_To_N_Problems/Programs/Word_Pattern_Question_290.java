import java.util.HashMap;

public class Word_Pattern_Question_290 {

    public static boolean wordPattern(String pattern, String s) {

        HashMap<Character, String> hm = new HashMap<>();

        String str[] = s.split(" ");

        if (pattern.length() != str.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);

            if (hm.containsKey(ch)) {

                if (!hm.get(ch).equals(str[i])) {
                    return false;
                }

            } else {

                if (hm.containsValue(str[i])) {
                    return false;
                }

                hm.put(ch, str[i]);
            }
        }

        return true;
    }

    public static void main(String[] args) {

        // Static Input
        String pattern = "abba";
        String s = "dog cat cat dog";

        boolean result = wordPattern(pattern, s);

        System.out.println("Pattern : " + pattern);
        System.out.println("String  : " + s);
        System.out.println("Output  : " + result);
    }
}