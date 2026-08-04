public class Removing_Stars_From_a_String_Question_2390 {

    public static String removeStars(String s) {

        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '*') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        // Static Input
        String s = "leet**cod*e";

        String result = removeStars(s);

        System.out.println("Original String : " + s);
        System.out.println("Result String   : " + result);
    }
}