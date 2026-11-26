public class Minimum_Add_To_Make_Valid_Question_921 {

    public static void main(String[] args) {

        // Static Input
        String s = "()))((";

        String original = s;

        while (s.contains("()")) {
            s = s.replace("()", "");
        }

        System.out.println("Input : " + original);
        System.out.println("Remaining String : " + s);
        System.out.println("Answer : " + s.length());
    }
}