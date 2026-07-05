public class CountPunctuation {
    public static void main(String[] args) {

        String str = "Hello, World! How are you? @Java #Programming.";

        int count = 0;

        for (char ch : str.toCharArray()) {

            if (!Character.isLetterOrDigit(ch) &&
                !Character.isWhitespace(ch)) {

                System.out.print(ch + " ");
                count++;
            }
        }

        System.out.println("\nTotal Punctuation Marks = " + count);
    }
}
