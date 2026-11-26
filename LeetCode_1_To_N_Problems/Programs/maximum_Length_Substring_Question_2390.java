import java.util.HashMap;

public class maximum_Length_Substring_Question_2390 {

    public static int maximumLengthSubstring(String s) {

        HashMap<Character, Integer> hm = new HashMap<>();

        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            hm.put(ch, hm.getOrDefault(ch, 0) + 1);

            while (hm.get(ch) > 2) {

                char leftChar = s.charAt(left);

                hm.put(leftChar, hm.get(leftChar) - 1);

                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {

        // Static Input
        String s = "bcbbbcba";

        int result = maximumLengthSubstring(s);

        System.out.println("Input String : " + s);
        System.out.println("Maximum Length Substring : " + result);
    }
}