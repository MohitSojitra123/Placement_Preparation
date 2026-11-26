// 12 Given a string s representing an expression containing various types of brackets: {}, 
// (),  and  [],  the  task  is  to  determine  whether  the  brackets  in  the  expression  are 
// balanced  or  not.  A  balanced  expression  is  one  where  every  opening  bracket  has  a 
// corresponding closing bracket in the correct order.  
// Input: s = “[{()}]” 
// Output: true 
// Explanation:  All the brackets are well-formed.  
// Input: s = “([]” 
// Output: false 
// Explanation: The expression is not balanced as there is a missing ‘)’ at the end. 


import java.util.Scanner;
import java.util.Stack;

public class Problem_12 {

    public static boolean isBalanced(String str) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

 
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }

            else if (ch == ')' || ch == '}' || ch == ']') {

           
                if (st.isEmpty()) {
                    return false;
                }

                char top = st.peek();

       
                if ((ch == ')' && top == '(') ||
                    (ch == '}' && top == '{') ||
                    (ch == ']' && top == '[')) {

                    st.pop();
                }
                else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Expression : ");
        String str = sc.nextLine();

        System.out.println(isBalanced(str));

        sc.close();
    }
}