public class Decoding_Multiple_Number {

    public static void main(String[] args) {

        String str = "a12b3";

        StringBuilder decoded = new StringBuilder();

        int i = 0;

        while (i < str.length()) {

            char ch = str.charAt(i++);
            int count = 0;

            while (i < str.length() && Character.isDigit(str.charAt(i))) {
                count = count * 10 + (str.charAt(i) - '0');
                i++;
            }

            for (int j = 0; j < count; j++) {
                decoded.append(ch);
            }
        }

        System.out.println("Encoded String : " + str);
        System.out.println("Decoded String : " + decoded);
    }
}
