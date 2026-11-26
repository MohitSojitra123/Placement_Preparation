import java.util.HashSet;

public class CommonAndUncommonCharacters {
    public static void main(String[] args) {

        String str1 = "programming";
        String str2 = "gaming";

        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();

        for (char ch : str1.toCharArray()) {
            set1.add(ch);
        }

        for (char ch : str2.toCharArray()) {
            set2.add(ch);
        }

        System.out.print("Common Characters   : ");
        for (char ch : set1) {
            if (set2.contains(ch)) {
                System.out.print(ch + " ");
            }
        }

        System.out.print("\nUncommon Characters : ");

        for (char ch : set1) {
            if (!set2.contains(ch)) {
                System.out.print(ch + " ");
            }
        }

        for (char ch : set2) {
            if (!set1.contains(ch)) {
                System.out.print(ch + " ");
            }
        }
    }
}