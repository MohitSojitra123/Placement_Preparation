public class StartsWithManual {
    public static void main(String[] args) {

        String str = "Programming";
        String prefix = "Pro";

        boolean flag = true;

        if (prefix.length() > str.length()) {
            flag = false;
        } else {

            for (int i = 0; i < prefix.length(); i++) {

                if (str.charAt(i) != prefix.charAt(i)) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag)
            System.out.println("Starts With");
        else
            System.out.println("Does Not Start With");
    }
}

// public class StartsWithExample {
//     public static void main(String[] args) {

//         String str = "Programming";
//         String prefix = "Pro";

//         if (str.startsWith(prefix)) {
//             System.out.println("String starts with " + prefix);
//         } else {
//             System.out.println("String does not start with " + prefix);
//         }
//     }
// }