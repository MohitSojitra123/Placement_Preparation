public class Reverse_Vowels_Question_345{

    public static String reverseVowels(String s) {

        char ch[] = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            char left_char = Character.toLowerCase(ch[left]);
            char right_char = Character.toLowerCase(ch[right]);

            if (left_char == 'a' || left_char == 'e' || left_char == 'i'
                    || left_char == 'o' || left_char == 'u') {

                if (right_char == 'a' || right_char == 'e' || right_char == 'i'
                        || right_char == 'o' || right_char == 'u') {

                    char temp = ch[left];
                    ch[left] = ch[right];
                    ch[right] = temp;

                    right--;
                    left++;

                } else {
                    right--;
                }

            } else {
                left++;
            }
        }

        String s1 = new String(ch);

        return s1;
    }

    public static void main(String[] args) {

        // Static Input
        String s = "leetcode";

        String result = reverseVowels(s);

        System.out.println("Original String : " + s);
        System.out.println("Reversed Vowels : " + result);
    }
}