public class Count_the_Number_of_Vowel_Strings_in_Range_Question_2586 {

    static int vowelStrings(String[] words, int left, int right) {

        int count = 0;

        for (int i = left; i <= right; i++) {

            char start = words[i].charAt(0);
            char end = words[i].charAt(words[i].length() - 1);

            if ((start == 'a' || start == 'e' || start == 'i' ||
                 start == 'o' || start == 'u') &&
                (end == 'a' || end == 'e' || end == 'i' ||
                 end == 'o' || end == 'u')) {

                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        // Static Input
        String[] words = {"are", "amy", "u", "boy", "i"};

        int left = 0;
        int right = 2;

        // Function Call
        int result = vowelStrings(words, left, right);

        // Output
        System.out.println("Answer = " + result);
    }
}