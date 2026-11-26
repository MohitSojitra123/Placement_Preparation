public class Reverse_Prefix_Question_2000 {

    public static String reversePrefix(String word, char ch) {

        int left = 0;
        int right = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                right = i;
                break;
            }
        }

        char[] str = word.toCharArray();

        while (left < right) {
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;

            left++;
            right--;
        }

        String result = new String(str);

        return result;
    }

    public static void main(String[] args) {

        String word = "abcdefd";
        char ch = 'd';

        String result = reversePrefix(word, ch);

        System.out.println("Original String : " + word);
        System.out.println("Character        : " + ch);
        System.out.println("Result String    : " + result);
    }
}
