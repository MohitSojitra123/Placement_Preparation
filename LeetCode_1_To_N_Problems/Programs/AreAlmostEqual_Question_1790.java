public class AreAlmostEqual_Question_1790 {

    public static boolean areAlmostEqual(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        int count = 0;

        char first1 = 0;
        char first2 = 0;
        char second1 = 0;
        char second2 = 0;

        for (int i = 0; i < s1.length(); i++) {

            if (s1.charAt(i) != s2.charAt(i)) {

                count++;

                if (count == 1) {
                    first1 = s1.charAt(i);
                    first2 = s2.charAt(i);
                }

                if (count == 2) {
                    second1 = s1.charAt(i);
                    second2 = s2.charAt(i);
                }

                if (count > 2) {
                    return false;
                }
            }
        }

        if (count == 0) {
            return true;
        }

        if (count == 2) {
            return first1 == second2 && first2 == second1;
        }

        return false;
    }

    public static void main(String[] args) {

        // Static Input
        String s1 = "bank";
        String s2 = "kanb";

        boolean result = areAlmostEqual(s1, s2);

        System.out.println("String 1 : " + s1);
        System.out.println("String 2 : " + s2);
        System.out.println("Output   : " + result);
    }
}