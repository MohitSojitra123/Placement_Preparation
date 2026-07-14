// Check if string can be rearranged to palindrome

// Input: "aab"
// Output: true



public class Rearrange_Palindrome {

    public static void main(String[] args) {

        String str = "carrace";

        int[] freq = new int[26];


        // Count character frequency
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            freq[ch - 'a']++;
        }


        int oddCount = 0;


        // Count odd frequencies
        for (int i = 0; i < 26; i++) {

            if (freq[i] % 2 != 0) {
                oddCount++;
            }
        }


        // Check condition
        if (oddCount <= 1) {

            System.out.println("String can be rearranged into Palindrome");
        }
        else {

            System.out.println("String cannot be rearranged into Palindrome");
        }
    }
}