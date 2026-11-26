import java.util.*;

public class SplitWord_By_Seperator_Question_2788 {

    public static List<String> splitWordsBySeparator(List<String> words, char separator) {

        List<String> r = new ArrayList<>();

        for (int i = 0; i < words.size(); i++) {

            String[] wordsArray = words.get(i).split("[" + separator + "]");

            for (String word : wordsArray) {
                if (!word.isEmpty()) {
                    r.add(word);
                }
            }
        }

        return r;
    }

    public static void main(String[] args) {

        List<String> words = Arrays.asList(
                "one.two.three",
                "four.five",
                "six"
        );

        char separator = '.';

        List<String> result = splitWordsBySeparator(words, separator);

        System.out.println("Result: " + result);
    }
}