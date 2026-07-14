public class CountPalindromeWords {

    public static void main(String[] args) {

        String str = "madam is a level test racecar";

        int count = 0;

        String word = "";


        // Extract words manually
        for (int i = 0; i <= str.length(); i++) {

            if (i < str.length() && str.charAt(i) != ' ') {

                word = word + str.charAt(i);

            } 
            else {

                if (isPalindrome(word)) {
                    count++;
                }

                word = "";
            }
        }


        System.out.println("Number of Palindromic Words : " + count);
    }


    // Check palindrome
    static boolean isPalindrome(String word) {

        int start = 0;
        int end = word.length() - 1;


        while (start < end) {

            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}