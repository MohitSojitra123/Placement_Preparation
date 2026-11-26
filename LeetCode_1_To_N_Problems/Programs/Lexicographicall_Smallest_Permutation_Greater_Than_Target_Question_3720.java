import java.util.ArrayList;
import java.util.Collections;

public class Lexicographicall_Smallest_Permutation_Greater_Than_Target_Question_3720 {

    static ArrayList<String> arr = new ArrayList<>();

    static void find_Permutation(String s, String ans) {

        if (s.length() == 0) {
            arr.add(ans);
        } 
        else {

            for (int i = 0; i < s.length(); i++) {

                char ch = s.charAt(i);

                String left = s.substring(0, i);
                String right = s.substring(i + 1);

                find_Permutation(left + right, ans + ch);
            }
        }
    }

    static String lexGreaterPermutation(String s, String target) {

        // Clear previous permutations
        arr.clear();

        // Generate all permutations
        find_Permutation(s, "");

        // Sort permutations
        Collections.sort(arr);

        // Find smallest permutation greater than target
        for (String str : arr) {

            if (str.compareTo(target) > 0) {
                return str;
            }
        }

        return "";
    }

    public static void main(String[] args) {

        // Static Input
        String s = "abc";
        String target = "bba";

        // Call function
        String result = lexGreaterPermutation(s, target);

        // Print result
        System.out.println("s      = " + s);
        System.out.println("target = " + target);
        System.out.println("Answer = " + result);
    }
}