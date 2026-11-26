package Basic_To_Advanced_String_Peograms;
import java.util.Scanner;

class Find_Sub_String {

    static boolean Find_SubString(char ch[]) {

        int length = ch.length;
        boolean isMatch = true;

        for (int i = 1; i <= length / 2; i++) {

            // substring length must divide whole string
            if (length % i != 0) {
                continue;
            }

            isMatch = true;

            for (int j = 0; j < length; j++) {

                // CORRECT COMPARISON
                if (ch[j] != ch[j % i]) {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String : ");
        String str = sc.nextLine();

        char ch[] = str.toCharArray();

        if (Find_Sub_String.Find_SubString(ch)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }
}