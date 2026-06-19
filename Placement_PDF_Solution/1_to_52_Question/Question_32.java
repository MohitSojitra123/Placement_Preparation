// Given two strings s1 and s2 consisting of lowercase characters, the task is to check whether the two given 
// strings are anagrams of each other or not. An anagram of a string is another string that contains the same 
// characters, only the order of characters can be different. 
// Input: s1 = “geeks” s2 = “kseeg” 
// Output: true 
// Explanation: Both the strings have the same characters with same frequency. So, they are anagrams. 


import java.util.HashMap;

public class Question_32 {


    public static boolean isAnagram(String s1, String s2) {

        if(s1.length() != s2.length()){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();



        for(int i = 0; i < s1.length(); i++){
            char ch = s1.charAt(i);
            map.put(
                ch,
                map.getOrDefault(ch,0) + 1
            );
        }


        for(int i = 0; i < s2.length(); i++){
            char ch = s2.charAt(i);
            if(!map.containsKey(ch)){
                return false;
            }else{
                map.put(
                    ch,
                    map.get(ch) - 1
                );
            }

            if(map.get(ch) == 0){
                map.remove(ch);
            }

        }

        return map.isEmpty();

    }


    public static void main(String[] args) {

        String s1 = "geeks";

        String s2 = "kseeg";

        System.out.println(isAnagram(s1,s2));
    }
}