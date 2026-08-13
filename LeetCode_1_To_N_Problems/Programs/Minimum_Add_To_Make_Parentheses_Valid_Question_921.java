import java.util.Stack;

public class Minimum_Add_To_Make_Parentheses_Valid_Question_921 {

    public static int minAddToMakeValid(String s) {

        Stack<Character> st = new Stack<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                st.push('(');

            } else if (st.size() > 0 && st.peek() == '(') {

                st.pop();

            } else {

                count++;
            }
        }

        return count + st.size();
    }

    public static void main(String[] args) {

        // Static Input
        String s = "()))((";

        int result = minAddToMakeValid(s);

        System.out.println("Input  : " + s);
        System.out.println("Output : " + result);
    }
}