public class Unique_Characters_2 {
    public static void main(String[] args) {
        String str = "mohit";
        boolean unique = true;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    unique = false;
                    break;
                }
            }
        }

        System.out.println(unique
                ? "All characters are unique"
                : "Duplicate characters found");
    }
}