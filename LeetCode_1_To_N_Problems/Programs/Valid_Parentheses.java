public class Valid_Parentheses {

    public static void main(String[] args) {

        String s = "([])";

        while (s.contains("()") ||
               s.contains("[]") ||
               s.contains("{}")) {

            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
        }

        if (s.length() == 0) {
            System.out.println("Valid Parentheses");
        } else {
            System.out.println("Invalid Parentheses");
        }
    }
}