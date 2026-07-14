
// word1: a b c
// word2: p q r

// merge: a p b q c r

public class Merge_Strings_Alternately {

    public static void main(String[] args) {

        String word1 = "abc";
        String word2 = "pqr";

        String result = "";

        int i = 0;
        int j = 0;


        while (i < word1.length() || j < word2.length()) {


            // Take character from first string
            if (i < word1.length()) {

                result = result + word1.charAt(i);
                i++;
            }


            // Take character from second string
            if (j < word2.length()) {

                result = result + word2.charAt(j);
                j++;
            }
        }


        System.out.println("Merged String : " + result);
    }
}