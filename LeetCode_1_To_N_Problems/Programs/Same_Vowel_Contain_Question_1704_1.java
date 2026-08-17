import java.util.*;

class Solution {
    public boolean halvesAreAlike(String s) {

        s = s.toLowerCase();
        char ch[] = s.toCharArray();

        int half = s.length() / 2;

        int left_vowel = 0;
        int right_vowel = 0;

        for (int i = 0; i < half; i++) {
            if (ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u') {
                left_vowel++;
            }
        }

        for (int j = half; j < s.length(); j++) {
            if (ch[j] == 'a' || ch[j] == 'e' || ch[j] == 'i' || ch[j] == 'o' || ch[j] == 'u') {
                right_vowel++;
            }
        }

        return left_vowel == right_vowel;
    }
}

public class Same_Vowel_Contain_Question_1704_1 {
    public static void main(String[] args) {

        Solution sol = new Solution();

        String s = "book";

        boolean result = sol.halvesAreAlike(s);

        System.out.println("Result: " + result);
    }
}