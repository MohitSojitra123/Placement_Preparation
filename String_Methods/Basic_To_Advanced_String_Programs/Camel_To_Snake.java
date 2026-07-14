// Camel Case : helloWorldExample
// Snake Case : hello_world_example,

public class Camel_To_Snake {

    public static void main(String[] args) {

        String str = "helloWorldExample";

        String result = "";

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // Check uppercase character
            if (ch >= 'A' && ch <= 'Z') {

                result = result + "_";

                // Convert Uppercase to Lowercase using ASCII
                ch = (char)(ch + 32);
            }

            result = result + ch;
        }

        System.out.println("Camel Case : " + str);
        System.out.println("Snake Case : " + result);
    }
}