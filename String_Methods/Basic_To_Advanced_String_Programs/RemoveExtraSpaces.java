public class RemoveExtraSpaces {

    public static void main(String[] args) {

        String str = "Java---is----a-----Programming-----Language";

        String result = "";

        boolean spaceFound = false;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (ch == '-') {

                // Add only one space
                if (!spaceFound) {
                    result = result + ch;
                    spaceFound = true;
                }

            } else {

                result = result + ch;
                spaceFound = false;
            }
        }

        System.out.println("Original String : " + str);
        System.out.println("After Removing Extra Spaces : " + result);
    }
}