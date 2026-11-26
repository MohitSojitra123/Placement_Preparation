public class Palindromic_SubstringQuestion_647 {

    public static int countSubstrings(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            for (int j = i; j < s.length(); j++) {

                if (isPalindrome(s, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "aaa";

        int result = countSubstrings(s);

        System.out.println("String : " + s);
        System.out.println("Number of Palindromic Substrings : " + result);
    }
}