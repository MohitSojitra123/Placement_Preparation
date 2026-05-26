// word = "aaAbcBC"

// Lowercase letters: a, b, c
// Uppercase letters: A, B, C

// Special letters = a, b, c
// Answer = 3

import java.util.HashSet;

public class Count_Special_Character_Question_3120 {

    public static int fun(String word) {

        HashSet<Character> lower = new HashSet<>();
        HashSet<Character> upper = new HashSet<>();

        for (char ch : word.toCharArray()) {

            if (Character.isLowerCase(ch)) {
                lower.add(ch);
            } else if (Character.isUpperCase(ch)) {
                upper.add(ch);
            }
        }

        int count = 0;

        for (char ch : lower) {
            if (upper.contains(Character.toUpperCase(ch))) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String word = "aaAbcBC"; // Static Input

        int result = fun(word);

        System.out.println("Input: " + word);
        System.out.println("Number of Special Characters: " + result);
    }
}