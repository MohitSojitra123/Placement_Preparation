public class LongestCommonSuffix {

    public static void main(String[] args) {

        String arr[] = {"running", "jogging", "walking"};

        String suffix = "";

        String first = arr[0];


        // Start comparing from last character
        for (int i = 1; i <= first.length(); i++) {

            char ch = first.charAt(first.length() - i);

            boolean match = true;


            // Compare with all other strings
            for (int j = 1; j < arr.length; j++) {

                if (i > arr[j].length() ||
                    arr[j].charAt(arr[j].length() - i) != ch) {

                    match = false;
                    break;
                }
            }


            if (match) {
                suffix = ch + suffix;
            }
            else {
                break;
            }
        }


        System.out.println("Longest Common Suffix : " + suffix);
    }
}