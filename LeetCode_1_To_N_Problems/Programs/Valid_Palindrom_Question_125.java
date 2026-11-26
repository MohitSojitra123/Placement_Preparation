public class Valid_Palindrom_Question_125 {

    public static boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {

                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        // Static Input
        String s = "A man, a plan, a canal: Panama";

        // Method Call
        boolean result = isPalindrome(s);

        // Output
        System.out.println("Input  : " + s);
        System.out.println("Output : " + result);
    }
}