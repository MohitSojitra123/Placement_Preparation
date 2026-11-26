public class Check_Whether_Two_Strings_are_Almost_Equivalent_Question_2068 {

    public static boolean checkAlmostEquivalent(String word1, String word2) {

        int array[] = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            array[word1.charAt(i) - 'a']++;
            array[word2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < array.length; i++) {
            if (Math.abs(array[i]) > 3) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        // Static Input
        String word1 = "aaaa";
        String word2 = "bccb";

        // Function Call
        boolean result = checkAlmostEquivalent(word1, word2);

        // Output
        System.out.println(result);
    }
}