import java.util.ArrayList;

public class Longest_Palindromic_Subsequence_Question_516 {

    static ArrayList<String> arr = new ArrayList<>();

    public static int longestPalindromeSubseq(String s) {

        arr.clear();

        find_Subsequence(s, 0, "");

        int max = 0;

        for (String str : arr) {

            if (Check_Palindrom_str(str)) {
                max = Math.max(max, str.length());
            }
        }

        return max;
    }

    static void find_Subsequence(String s, int index, String ans) {

        if (index == s.length()) {
            arr.add(ans);
            return;
        }

        // Take current character
        find_Subsequence(
            s,
            index + 1,
            ans + s.charAt(index)
        );

        // Skip current character
        find_Subsequence(
            s,
            index + 1,
            ans
        );
    }

    static boolean Check_Palindrom_str(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        // Static Input
        String s = "bbbab";

        int result = longestPalindromeSubseq(s);

        System.out.println("Input: " + s);
        System.out.println("All Subsequences: " + arr);
        System.out.println("Longest Palindromic Subsequence Length: " + result);
    }
}