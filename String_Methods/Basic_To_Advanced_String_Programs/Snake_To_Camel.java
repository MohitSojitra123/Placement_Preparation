// Snake Case : hello_world_example
// Camel Case : helloWorldExample

public class Snake_To_Camel {

    public static void main(String[] args) {

        String str = "hello_world_example";

        String result = "";

        boolean upperCaseNext = false;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // Check underscore
            if (ch == '_') {
                upperCaseNext = true;
            } 
            else {

                if (upperCaseNext) {

                    // Convert lowercase to uppercase using ASCII
                    if (ch >= 'a' && ch <= 'z') {
                        ch = (char)(ch - 32);
                    }

                    upperCaseNext = false;
                }

                result = result + ch;
            }
        }

        System.out.println("Snake Case : " + str);
        System.out.println("Camel Case : " + result);
    }
}