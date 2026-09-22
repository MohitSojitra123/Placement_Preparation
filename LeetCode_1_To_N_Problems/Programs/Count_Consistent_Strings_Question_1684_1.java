public class Count_Consistent_Strings_Question_1684_1{

    public static int countConsistentStrings(String allowed, String[] words) {

        boolean alpha[] = new boolean[26];

        // Mark allowed characters
        for (char ch : allowed.toCharArray()) {
            alpha[ch - 'a'] = true;
        }

        int count = 0;

        // Check every word
        for (int i = 0; i < words.length; i++) {

            boolean isvalid = true;

            for (char ch : words[i].toCharArray()) {

                if (alpha[ch - 'a'] != true) {
                    isvalid = false;
                    break;
                }
            }

            if (isvalid) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        // Static Input
        String allowed = "ab";

        String[] words = {
            "ad",
            "bd",
            "aaab",
            "baa",
            "badab"
        };

        // Calling method
        int result = countConsistentStrings(allowed, words);

        // Output
        System.out.println("Number of consistent strings: " + result);
    }
}