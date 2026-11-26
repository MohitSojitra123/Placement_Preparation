public class Reverse_Only_Letters_Question_917 {

    public static String reverseOnlyLetters(String s) {

        int start = 0;
        int end = s.length() - 1;

        char[] ch = s.toCharArray();

        while (start < end) {

            if ((ch[start] >= 'a' && ch[start] <= 'z') ||
                (ch[start] >= 'A' && ch[start] <= 'Z')) {

                if ((ch[end] >= 'a' && ch[end] <= 'z') ||
                    (ch[end] >= 'A' && ch[end] <= 'Z')) {

                    char temp = ch[start];
                    ch[start] = ch[end];
                    ch[end] = temp;

                    start++;
                    end--;

                } else {
                    end--;
                }

            } else {
                start++;
            }
        }

        return new String(ch);
    }

    public static void main(String[] args) {

        // Static Input
        String s = "a-bC-dEf-ghIj";

        // Method Call
        String result = reverseOnlyLetters(s);

        // Output
        System.out.println("Original String: " + s);
        System.out.println("Reversed String: " + result);
    }
}