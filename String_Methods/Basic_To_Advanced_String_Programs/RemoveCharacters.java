// Input:
// String1 = "computer"
// String2 = "cat"

// Output:
// ompuer


// Input:
// String1 = "hello world"
// String2 = "lo"

// Output:
// he wrd

public class RemoveCharacters {

    public static void main(String[] args) {

        String str1 = "computer";
        String str2 = "cat";

        String result = "";

        for (int i = 0; i < str1.length(); i++) {

            char ch = str1.charAt(i);
            boolean found = false;

            for (int j = 0; j < str2.length(); j++) {

                if (ch == str2.charAt(j)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                result += ch;
            }
        }

        System.out.println("Original String : " + str1);
        System.out.println("Characters to Remove : " + str2);
        System.out.println("Result : " + result);
    }
}