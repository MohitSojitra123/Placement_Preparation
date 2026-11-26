package HashSet;

import java.util.HashSet;

public class UniqueMorseCode {

    public static void main(String[] args) {

        String words[] = {"gin", "zen", "gig", "msg"};

        String morse[] = {
            ".-","-...","-.-.","-..",".","..-.","--.","....",
            "..",".---","-.-",".-..","--","-.","---",".--.",
            "--.-",".-.","...","-","..-","...-",".--","-..-",
            "-.--","--.."
        };

        HashSet<String> set = new HashSet<>();

        for(String word : words) {

            StringBuilder sb = new StringBuilder();

            for(char ch : word.toCharArray()) {

                sb.append(morse[ch - 'a']);
            }

            set.add(sb.toString());
        }

        System.out.println("Unique Transformations = " + set.size());
    }
}