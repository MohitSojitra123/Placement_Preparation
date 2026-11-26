public class Reverse_String_Recursion {

    static void reverse(String str, int index) {

        if (index == str.length()) {
            return;
        }

        reverse(str, index + 1);

        System.out.print(str.charAt(index));
    }

    public static void main(String[] args) {

        String str = "Hello";

        reverse(str, 0);
    }
}