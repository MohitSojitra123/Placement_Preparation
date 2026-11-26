public class Longest_Palindromic_Substring_Question_5 {

    public static String longestPalindrome(String s) {

        String ans = "";

        for (int i = 0; i < s.length(); i++) {

            for (int j = i; j < s.length(); j++) {

                String temp = s.substring(i, j + 1);

                if (isPalindrome(temp)) {

                    if (temp.length() > ans.length()) {
                        ans = temp;
                    }
                }
            }
        }

        return ans;
    }

    public static boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

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

     
        String s = "babad";

        String result = longestPalindrome(s);

        System.out.println("Input  : " + s);
        System.out.println("Output : " + result);
    }
}