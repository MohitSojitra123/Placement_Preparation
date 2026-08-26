public class Valia_Palindrome_II_Question_ {

    public static void main(String[] args) {

        String s = "abca";

        boolean result = validPalindrome(s);

        System.out.println("String: " + s);
        System.out.println("Valid Palindrome: " + result);
    }

    public static boolean validPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {

                if (checkPalindrome(s, left + 1, right)) {
                    return true;
                }

                if (checkPalindrome(s, left, right - 1)) {
                    return true;
                }

                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    static boolean checkPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}