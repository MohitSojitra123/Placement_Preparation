import java.util.HashSet;

public class Unique_Characters_1 {
    public static void main(String[] args) {
        String str = "mohit";

        HashSet<Character> set = new HashSet<>();

        boolean unique = true;

        for (char ch : str.toCharArray()) {
            if (set.contains(ch)) {
                unique = false;
                break;
            }
            set.add(ch);
        }

        if (unique)
            System.out.println("All characters are unique");
        else
            System.out.println("Duplicate characters found");
    }
}