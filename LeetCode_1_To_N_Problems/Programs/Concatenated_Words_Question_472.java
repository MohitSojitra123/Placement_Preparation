import java.util.*;

public class Concatenated_Words_Question_472 {

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {

        Set<String> hs = new HashSet<>();
        Map<String, Boolean> hm = new HashMap<>();

        // Add all words
        for (String word : words) {
            hs.add(word);
        }

        List<String> result = new ArrayList<>();

        for (String word : words) {

            // Remove current word so it cannot use itself
            hs.remove(word);

            if (IsConactenated(word, hs, hm)) {
                result.add(word);
            }

            // Add it back
            hs.add(word);
        }

        return result;
    }

    public static boolean IsConactenated(
            String word,
            Set<String> st,
            Map<String, Boolean> hm) {

        if (hm.containsKey(word)) {
            return hm.get(word);
        }

        for (int i = 0; i < word.length() - 1; i++) {

            String prefix = word.substring(0, i + 1);
            String suffix = word.substring(i + 1);

            if (st.contains(prefix) &&
                (st.contains(suffix) ||
                 IsConactenated(suffix, st, hm))) {

                hm.put(word, true);
                return true;
            }
        }

        hm.put(word, false);
        return false;
    }

    public static void main(String[] args) {

        // Static Input
        String[] words = {
            "cat",
            "cats",
            "catsdogcats",
            "dog",
            "dogcatsdog",
            "hippopotamuses",
            "rat",
            "ratcatdogcat"
        };

        // Method call
        List<String> result =
                findAllConcatenatedWordsInADict(words);

        // Output
        System.out.println("Concatenated Words:");

        for (String word : result) {
            System.out.println(word);
        }
    }
}