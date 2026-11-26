// Find if a given string can be represented from a substring by iterating the substring “n” times. 
// Input: str = "abcabcabc"  Output: true 
// Input: str = "aabaabaabaab" Output: true 
// Input: str = "abcdabc"  Output: false

public class Question_52 {

    public static boolean isRepeated(String str) {

        int n = str.length();

        for (int i = 1; i <= n / 2; i++) {

            if (n % i != 0)
                continue;

            boolean match = true;

            for (int j = i; j < n; j++) {

                if (str.charAt(j) != str.charAt(j% i)) {
                    match = false;
                    break;
                }
            }

            if (match)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        String str = "abcabcabc";

        if (isRepeated(str))
            System.out.println("true");
        else
            System.out.println("false");
    }
}