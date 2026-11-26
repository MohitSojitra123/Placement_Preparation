import java.util.HashSet;

public class  First_Letter_to_Appear_Twice_Qestion_2351 {

    public static char repeatedCharacter(String s) {

        HashSet<Character> hs = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {

            if (hs.contains(s.charAt(i))) {
                return s.charAt(i);
            } else {
                hs.add(s.charAt(i));
            }
        }

        return '-';
    }

    public static void main(String[] args) {

        String s = "abccba";

        char result = repeatedCharacter(s);

        System.out.println("Input: " + s);
        System.out.println("First Repeated Character: " + result);
    }
}