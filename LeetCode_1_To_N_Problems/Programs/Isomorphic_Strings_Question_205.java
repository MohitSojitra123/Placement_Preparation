import java.util.HashMap;

public class Isomorphic_Strings_Question_205 {

    public static boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            if (hm.containsKey(s.charAt(i))) {

                if (!hm.get(s.charAt(i)).equals(t.charAt(i))) {
                    return false;
                }

            } else {

                if (hm.containsValue(t.charAt(i))) {
                    return false;
                }

                hm.put(s.charAt(i), t.charAt(i));
            }
        }

        return true;
    }

    public static void main(String[] args) {

        // Static Input
        String s = "egg";
        String t = "add";

        // Calling Method
        boolean result = isIsomorphic(s, t);

        // Printing Output
        System.out.println("String 1 : " + s);
        System.out.println("String 2 : " + t);
        System.out.println("Is Isomorphic : " + result);
    }
}