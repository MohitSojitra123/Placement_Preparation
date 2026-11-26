import java.util.HashSet;

public class Pangram_Check {
    public static void main(String[] args) {

        String str = "The quick brown fox jumps over the lazy dog";

        HashSet<Character> set = new HashSet<>();

        str = str.toLowerCase();

        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                set.add(ch);
            }
        }

        if (set.size() == 26) {
            System.out.println("Pangram");
        } else {
            System.out.println("Not Pangram");
        }
    }
}