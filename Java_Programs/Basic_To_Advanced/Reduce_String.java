public class Reduce_String {
    public static void main(String[] args) {

        String str = "abbaca";

        boolean found;

        do {
            found = false;

            for (int i = 0; i < str.length() - 1; i++) {

                if (str.charAt(i) == str.charAt(i + 1)) {

                    str = str.substring(0, i)
                          + str.substring(i + 2);

                    found = true;
                    break;
                }
            }

        } while (found);

        System.out.println(str);
    }
}