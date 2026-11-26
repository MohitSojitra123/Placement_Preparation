public class EndsWithManual {
    public static void main(String[] args) {

        String str = "Programming";
        String suffix = "ming";

        boolean flag = true;

        if (suffix.length() > str.length()) {
            flag = false;
        } else {

            int start = str.length() - suffix.length();

            for (int i = 0; i < suffix.length(); i++) {

                if (str.charAt(start + i) != suffix.charAt(i)) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag)
            System.out.println("Ends With");
        else
            System.out.println("Does Not End With");
    }
}

// public class EndsWithExample {
//     public static void main(String[] args) {

//         String str = "Programming";
//         String suffix = "ming";

//         if (str.endsWith(suffix)) {
//             System.out.println("String ends with " + suffix);
//         } else {
//             System.out.println("String does not end with " + suffix);
//         }
//     }
// }