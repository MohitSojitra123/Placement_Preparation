public class Counting_Words_With_a_Given_Prefix_Question_2185 {

    public static int prefixCount(String[] words, String pref) {
        int count = 0;

        for (int i = 0; i < words.length; i++) {

            if (words[i].length() >= pref.length()) {

                String Compare = words[i].substring(0, pref.length());

                if (Compare.equals(pref)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        // Static Input
        String[] words = {"pay", "attention", "practice", "attend"};
        String pref = "at";

        // Function Call
        int result = prefixCount(words, pref);

        // Print Result
        System.out.println("Words:");

        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i] + " ");
        }

        System.out.println("\nPrefix: " + pref);
        System.out.println("Prefix Count: " + result);
    }
}