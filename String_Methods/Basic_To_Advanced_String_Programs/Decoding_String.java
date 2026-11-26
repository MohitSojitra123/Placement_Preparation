// Input:
// a3b2c4d2

// Output:
// aaabbccccdd


public class Decoding_String{

    public static void main(String[] args) {

        String str = "a3b2c4d2";

        String decoded = "";

        for (int i = 0; i < str.length(); i += 2) {

            char ch = str.charAt(i);
            int count = str.charAt(i + 1) - '0';

            for (int j = 1; j <= count; j++) {
                decoded = decoded + ch;
            }
        }

        System.out.println("Encoded String : " + str);
        System.out.println("Decoded String : " + decoded);
    }
}