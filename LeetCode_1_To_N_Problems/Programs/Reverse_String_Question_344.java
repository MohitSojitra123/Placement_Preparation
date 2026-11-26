import java.util.Arrays;

public class Reverse_String_Question_344 {

    public static void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;

        while (left <= right) {
            char ch = s[left];
            s[left] = s[right];
            s[right] = ch;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {

        char[] s = {'h', 'e', 'l', 'l', 'o'};

        System.out.println("Original Array: " + Arrays.toString(s));

        reverseString(s);

        System.out.println("Reversed Array: " + Arrays.toString(s));
    }
}