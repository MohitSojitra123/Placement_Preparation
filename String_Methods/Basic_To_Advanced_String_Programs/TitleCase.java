public class TitleCase {
    public static void main(String[] args) {
        String str = "i am mohit sojitra";

        String[] words = str.split(" ");
        String result = "";

        for (String word : words) {
            result += Character.toUpperCase(word.charAt(0))
                    + word.substring(1).toLowerCase() + " ";
        }

        System.out.println(result.trim());
    }
}