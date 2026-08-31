import java.util.ArrayList;
import java.util.List;

public class Find_Words_Containing_Character_Question_2942 {

    public static List<Integer> findWordsContaining(String[] words, char x) {

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {

            // x is a Character, so convert it into String


            // if (words[i].contains(x + "")) {
            if (words[i].contains(String.valueOf(x))) {
                arr.add(i);
            }
        }

        return arr;
    }

    public static void main(String[] args) {

        // Static Input
        String[] words = {"leet", "code", "has", "apple", "good"};
        char x = 'e';

        // Calling Method
        List<Integer> result = findWordsContaining(words, x);

        // Printing Output
        System.out.println("Words Containing '" + x + "' : " + result);
    }
}