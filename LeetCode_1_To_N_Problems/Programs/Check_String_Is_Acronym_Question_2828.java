
import java.util.*;

public class Check_String_Is_Acronym_Question_2828 {

    public static boolean isAcronym(List<String> words, String s) {

        StringBuilder sb = new StringBuilder();

        for (String s1 : words) {
            char current = s1.charAt(0);
            sb.append(current);
        }

        if (sb.toString().equals(s)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        List<String> words = Arrays.asList("alice", "bob", "charlie");

        String s = "abc";

        boolean result = isAcronym(words, s);

        System.out.println("Words: " + words);
        System.out.println("String: " + s);
        System.out.println("Is Acronym: " + result);
    }
}
