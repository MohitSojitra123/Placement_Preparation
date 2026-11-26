import java.util.HashSet;

public class Unique_Length_3_Palindromic_Subsequences_Question_1930 {

    public static boolean isPalindrom(String str) {

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {

            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static int countPalindromicSubsequence(String s) {

        HashSet<String> hs = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {

            for (int j = i + 1; j < s.length(); j++) {

                for (int k = j + 1; k < s.length(); k++) {

                    String temp = "" + s.charAt(i)
                                     + s.charAt(j)
                                     + s.charAt(k);

                    if (isPalindrom(temp)) {
                        hs.add(temp);
                    }
                }
            }
        }

        return hs.size();
    }

    public static void main(String[] args) {

        String s = "bbcbaba";

        int result = countPalindromicSubsequence(s);

        System.out.println("Number of Unique Palindromic Subsequence : " + result);
    }
}