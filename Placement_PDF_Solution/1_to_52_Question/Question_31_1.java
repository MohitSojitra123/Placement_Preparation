// Given a string S of length n, the task is to find the earliest repeated character in it. The earliest repeated 
// character  means,  the  character  that  occurs  more  than  once  and  whose  second  occurrence  has  the 
// smallest index. 
// Input: s = "geeksforgeeks"  
// Output: e  
// Explanation: e is the first element that repeats 

import java.util.HashSet;

public class Question_31_1 {
    public static void main(String[] args) {

        String s = "geeksforgeeks";

        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (set.contains(ch)) {
                System.out.println("First Repeated Character = " + ch);
                return;
            }

            set.add(ch);
        }

        System.out.println("No Repeated Character");
    }
}