// Find a next lexicographical order string from a given string, if input is abc output is acb (2 
// condition must be followed 1st the string must be greater than the inputted string and the 
// outputted string must be the smallest string from all possible string. Suppose there another 
// string possible from this is acb, bac, bca, etc., but smallest is acb )


import java.util.*;

public class Problem_62 {

    static ArrayList<String> list = new ArrayList<>();

    static void permutation(String str, String ans) {

        if (str.length() == 0) {
            list.add(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            String left = str.substring(0, i);
            String right = str.substring(i + 1);

            permutation(left + right, ans + ch);
        }
    }

    public static void main(String[] args) {

        String input = "abc";

        permutation(input, "");

        Collections.sort(list);

        int index = list.indexOf(input);

        if (index == list.size() - 1) {
            System.out.println("No Next Permutation");
        } else {
            System.out.println("Next String = " + list.get(index + 1));
        }

        
    }
}