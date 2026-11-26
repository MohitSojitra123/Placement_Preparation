import java.util.HashMap;

// Given two strings s1 and s2 consisting of lowercase characters, the task is to check 
// whether the two given strings are anagrams of each other or not. An anagram of a 
// string is another string that contains the same characters, only the order of characters 
// can be different. 
 
// Input: s1 = “geeks”  s2 = “kseeg” 
// Output: true 
// Explanation:  Both  the  strings  have  the  same  characters  with  same  frequency.  So, 
// they are anagrams. 
 
// Input: s1 = “allergy”  s2 = “allergic” 
// Output: false 
// Explanation: Characters in both the strings are not the same. s1 has extra characters 
// ‘y’ and s2 has extra characters ‘i’ and ‘c’, so they are not anagrams.

public class Problem_2_2 {

    public static boolean isAnagram(String str1, String str2) {

        // Remove spaces and convert to lowercase
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        // Length check
        if (str1.length() != str2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // Store frequency of characters from first string
        for (int i = 0; i < str1.length(); i++) {

            char ch = str1.charAt(i);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        // Decrease frequency using second string
        for (int i = 0; i < str2.length(); i++) {

            char ch = str2.charAt(i);

            // Character not found
            if (!map.containsKey(ch)) {
                return false;
            }

            map.put(ch, map.get(ch) - 1);

            // Remove if count becomes 0
            if (map.get(ch) == 0) {
                map.remove(ch);
            }
        }

        // If map becomes empty => anagram
        return map.isEmpty();
    }

    public static void main(String[] args) {

        String s1 = "listen";
        String s2 = "silent";

        if (isAnagram(s1, s2)) {
            System.out.println("Anagram String");
        } else {
            System.out.println("Not Anagram String");
        }
    }
}