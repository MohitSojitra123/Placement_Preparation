public class String_Compression_Question_433 {

    public static void main(String[] args) {

        // Static Input
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};

        int result = compress(chars);

        System.out.println("Compressed Length: " + result);

        System.out.print("Compressed Array: ");

        for (int i = 0; i < result; i++) {
            System.out.print(chars[i] + " ");
        }
    }

    public static int compress(char[] chars) {

        int count = 1;

        StringBuilder sb = new StringBuilder();

        // Add first character
        sb.append(chars[0]);

        for (int i = 1; i < chars.length; i++) {

            if (chars[i - 1] != chars[i]) {

                // If character appears more than once
                if (count > 1) {
                    sb.append(count);
                }

                // Add new character
                sb.append(chars[i]);

                count = 1;

            } else {
                count++;
            }
        }

        // Handle last character/group
        if (count > 1) {
            sb.append(count);
        }

        // Copy compressed result back into chars array
        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }

        return sb.length();
    }
}