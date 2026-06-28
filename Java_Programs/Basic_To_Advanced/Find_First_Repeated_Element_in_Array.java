// Find first repeated character in string

public class Find_First_Repeated_Element_in_Array {
    public static void main(String[] args) {

        String str = "programming";

        char repeated = '\0';

        for (int i = 0; i < str.length(); i++) {

            for (int j = i + 1; j < str.length(); j++) {

                if (str.charAt(i) == str.charAt(j)) {
                    repeated = str.charAt(i);
                    break;
                }
            }

            if (repeated != '\0') {
                break;
            }
        }

        if (repeated != '\0') {
            System.out.println("First Repeated Character: " + repeated);
        } else {
            System.out.println("No Repeated Character Found");
        }
    }
}
