public class length_Of_LastWord_Question_58 {

    public static int lengthOfLastWord(String s) {

        int count = 0;

        s = s.trim();

        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) != ' ') {
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        // Static Input
        String s = "   Hello World   ";

        int result = lengthOfLastWord(s);

        System.out.println("Input String        : \"" + s + "\"");
        System.out.println("Length of Last Word : " + result);
    }
}