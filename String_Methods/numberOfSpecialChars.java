public class numberOfSpecialChars {

    public static int fun(String word) {

        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        for (char ch : word.toCharArray()) {

            if (ch >= 'a' && ch <= 'z') {
                lower[ch - 'a'] = true;
            } else if (ch >= 'A' && ch <= 'Z') {
                upper[ch - 'A'] = true;
            }
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (lower[i] && upper[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String word = "aaAbcBC"; 

        int result = fun(word);

        System.out.println("Number of Special Characters: " + result);
    }
}