
import java.util.*;

public class Letter_Combination_Question_17 {

    public static void main(String[] args) {

        int[] arr = {2, 3};

        String[] keypad = {
                "", "", "abc", "def",
                "ghi", "jkl", "mno",
                "pqrs", "tuv", "wxyz"
        };

        List<String> result = new ArrayList<>();

        result.add("");

        for (int digit : arr) {

            String letters = keypad[digit];

            List<String> temp = new ArrayList<>();

            for (String str : result) {

                for (char ch : letters.toCharArray()) {
                    temp.add(str + ch);
                }
            }

            result = temp;
        }

        for (String s : result) {
            System.out.print(s + " ");
        }
    }
}