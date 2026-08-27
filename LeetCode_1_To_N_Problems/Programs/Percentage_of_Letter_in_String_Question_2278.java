public class Percentage_of_Letter_in_String_Question_2278{

    static int percentageLetter(String s, char letter) {

        int array[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
        }

        int freq = array[letter - 'a'];
        int len = s.length();

        return (freq * 100) / len;
    }

    public static void main(String[] args) {

        // Static Input
        String s = "foobar";
        char letter = 'o';

        // Function Call
        int result = percentageLetter(s, letter);

        // Output
        System.out.println("String: " + s);
        System.out.println("Letter: " + letter);
        System.out.println("Percentage: " + result + "%");
    }
}