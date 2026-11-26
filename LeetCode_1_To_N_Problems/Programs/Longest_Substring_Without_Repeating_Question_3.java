import java.util.HashSet;

public class Longest_Substring_Without_Repeating_Question_3 {

    public static int lengthOfLongestSubstring(String s) {

        HashSet<Character> hs = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            while (hs.contains(s.charAt(right))) {
                hs.remove(s.charAt(left));
                left++;
            }

            hs.add(s.charAt(right));

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        // Static Input
        String s = "abcabcbb";

        int result = lengthOfLongestSubstring(s);

        System.out.println("Input String : " + s);
        System.out.println("Length of Longest Substring Without Repeating Characters : " + result);
    }
}