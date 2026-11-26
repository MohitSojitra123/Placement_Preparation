import java.util.Stack;

public class Valid_Parenthisic_Question_20{

    public static boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '{' || ch == '(' || ch == '[') {
                st.push(ch);
            } else if (st.size() > 0 && ch == '}' && st.peek() == '{') {
                st.pop();
            } else if (st.size() > 0 && ch == ']' && st.peek() == '[') {
                st.pop();
            } else if (st.size() > 0 && ch == ')' && st.peek() == '(') {
                st.pop();
            } else {
                return false;
            }
        }

        return st.size() == 0;
    }

    public static void main(String[] args) {

        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([{}])";

        System.out.println(s1 + " -> " + isValid(s1));
        System.out.println(s2 + " -> " + isValid(s2));
        System.out.println(s3 + " -> " + isValid(s3));
        System.out.println(s4 + " -> " + isValid(s4));
    }
}