public class Rotate_String_Question_796 {

    public static void main(String[] args) {

        String s = "abcde";
        String goal = "cdeab";

        String finalStr = s + s;

        if (s.length() == goal.length() && finalStr.contains(goal)) {
            System.out.println("Rotation");
        } else {
            System.out.println("Not Rotation");
        }
    }
}