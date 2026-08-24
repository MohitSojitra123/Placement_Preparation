public class Remove_All_Adjacent_Duplicates_In_String_Question_1047 {

    public static void main(String[] args) {

        // Static Input
        String s = "abbaca";

        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (sb.length() > 0 &&
                sb.charAt(sb.length() - 1) == ch) {

                sb.deleteCharAt(sb.length() - 1);

            } else {

                sb.append(ch);
            }
        }

        // Output
        System.out.println("Input  : " + s);
        System.out.println("Output : " + sb.toString());
    }
}


// public class Reduce_String {
//     public static void main(String[] args) {

//         String str = "abbaca";

//         boolean found;

//         do {
//             found = false;

//             for (int i = 0; i < str.length() - 1; i++) {

//                 if (str.charAt(i) == str.charAt(i + 1)) {

//                     str = str.substring(0, i)
//                           + str.substring(i + 2);

//                     found = true;
//                     break;
//                 }
//             }

//         } while (found);

//         System.out.println(str);
//     }
// }