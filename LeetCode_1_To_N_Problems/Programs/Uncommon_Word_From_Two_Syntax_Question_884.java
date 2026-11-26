import java.util.*;

public class Uncommon_Word_From_Two_Syntax_Question_884 {

    public static void main(String[] args) {

        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";

        HashMap<String, Integer> map = new HashMap<>();

        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");

        for (String word : arr1) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String word : arr2) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        HashSet<String> set = new HashSet<>();

        for (String word : map.keySet()) {
            if (map.get(word) == 1) {
                set.add(word);
            }
        }

        String[] result = new String[set.size()];
        int temp = 0;

        for (String s : set) {
            result[temp++] = s;
        }

        System.out.println("Uncommon Words:");

        for (String word : result) {
            System.out.print(word + " ");
        }
    }
}