public class Longest_Common_Prefix {

    public static void main(String[] args) {

        String[] arr = {"flower", "flow", "flight"};

        String prefix = "";

        // Take first string as reference
        String first = arr[0];

        for (int i = 0; i < first.length(); i++) {

            char ch = first.charAt(i);

            boolean match = true;

            // Compare with remaining strings
            for (int j = 1; j < arr.length; j++) {

                if (i >= arr[j].length() || arr[j].charAt(i) != ch) {
                    match = false;
                    break;
                }
            }

            if (match) {
                prefix = prefix + ch;
            } else {
                break;
            }
        }

        System.out.println("Longest Common Prefix : " + prefix);
    }
}