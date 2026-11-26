public class Merge_Strings_Alternately_Question_1768 {

    public static String mergeAlternately(String word1, String word2) {

        String ans = "";

        int word1_i = 0;
        int word2_i = 0;

        while (word1_i < word1.length() && word2_i < word2.length()) {
            ans += word1.charAt(word1_i++);
            ans += word2.charAt(word2_i++);
        }

        while (word1_i < word1.length()) {
            ans += word1.charAt(word1_i++);
        }

        while (word2_i < word2.length()) {
            ans += word2.charAt(word2_i++);
        }

        return ans;
    }

    public static void main(String[] args) {

        String word1 = "abc";
        String word2 = "pqr";

        String result = mergeAlternately(word1, word2);

        System.out.println("Word1 : " + word1);
        System.out.println("Word2 : " + word2);
        System.out.println("Merged String : " + result);
    }
}