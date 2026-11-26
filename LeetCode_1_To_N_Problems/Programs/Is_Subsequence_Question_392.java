public class Is_Subsequence_Question_392 {

    public static boolean isSubsequence(String s, String t) {

        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {

            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        if (i == s.length()) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        // Static Input
        String s = "abc";
        String t = "ahbgdc";

        // Function call
        boolean result = isSubsequence(s, t);

        // Output
        System.out.println("Is Subsequence: " + result);
    }
}