public class Reverse_Words_in_a_String_Question_151 {

    public static String reverseWords(String s) {

        s = s.trim();

        String str[] = s.split("\\s+");

        int left = 0;
        int right = str.length - 1;

        while (left < right) {

            String temp = str[left];
            str[left] = str[right];
            str[right] = temp;

            left++;
            right--;
        }

        String s1 = "";

        for (int i = 0; i < str.length; i++) {

            if (i == str.length - 1) {
                s1 += str[i];
            } else {
                s1 += str[i] + " ";
            }
        }

        return s1;
    }

    public static void main(String[] args) {

        // Static Input
        String s = "  hello   world  ";

        String result = reverseWords(s);

        System.out.println("Original String : " + s);
        System.out.println("Reversed Words  : " + result);
    }
}