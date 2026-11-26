// Input:
// aaabbccccdd

// Output:
// a3b2c4d2

public class Encoding_String  {

    public static void main(String[] args) {

        String str = "aaabbccccdd";

        String encoded = "";

        int count = 1;

        for (int i = 0; i < str.length() - 1; i++) {

            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                encoded = encoded + str.charAt(i) + count;
                count = 1;
            }
        }

        // Add the last character and its count
        encoded = encoded + str.charAt(str.length() - 1) + count;

        System.out.println("Original String : " + str);
        System.out.println("Encoded String  : " + encoded);
    }
}