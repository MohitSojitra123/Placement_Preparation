public class Reverse_Words_2 {

    public static void main(String[] args) {

        String str = "Java is easy";

        String[] words = str.split(" ");

        StringBuilder result = new StringBuilder();

        for (String word : words) {

            result.append(new StringBuilder(word).reverse());
            result.append(" ");
        }

        System.out.println(result.toString().trim());
    }
}