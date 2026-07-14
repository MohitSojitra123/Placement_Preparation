import java.util.Stack;

public class Balanced_Parenthisis_2 {

    public static void main(String[] args) {

        String str = "{}{([])}[]";

        Stack<Character> stack = new Stack<>();

        boolean isBalanced = true;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            else if (ch == ')' || ch == '}' || ch == ']') {

                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {

                    isBalanced = false;
                    break;
                }
            }
        }

        if (!stack.isEmpty()) {
            isBalanced = false;
        }

        if (isBalanced) {
            System.out.println("Balanced Parentheses");
        } else {
            System.out.println("Not Balanced Parentheses");
        }
    }
}