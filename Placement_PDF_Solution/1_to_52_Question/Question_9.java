public class Question_9 {
    public static void main(String[] args) {

        int decimal = 255;
        String hex = decimalToHex(decimal);

        System.out.println("Decimal Number: " + decimal);
        System.out.println("Hexadecimal Number: " + hex);

        String hexadecimal = "FF";
        int decimalValue = hexToDecimal(hexadecimal);

        System.out.println("\nHexadecimal Number: " + hexadecimal);
        System.out.println("Decimal Number: " + decimalValue);
    }

    public static String decimalToHex(int num) {
        char[] hexChars = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };

        String result = "";

        while (num > 0) {
            int remainder = num % 16;
            result = hexChars[remainder] + result;
            num = num / 16;
        }

        return result;
    }

    public static int hexToDecimal(String hex) {
        int decimal = 0;
        int power = 1;

        for (int i = hex.length() - 1; i >= 0; i--) {
            char ch = hex.charAt(i);
            int value;

            if (ch >= '0' && ch <= '9') {
                value = ch - '0';
            } else {
                value = ch - 'A' + 10;
            }

            decimal += value * power;
            power *= 16;
        }

        return decimal;
    }
}
