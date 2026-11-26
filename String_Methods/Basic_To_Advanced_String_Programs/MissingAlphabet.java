public class MissingAlphabet {
    public static void main(String[] args) {

        String str = "abcdf";
        str = str.toLowerCase();

        boolean[] present = new boolean[26];

  
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                present[ch - 'a'] = true;
            }
        }

        System.out.print("Missing Characters: ");

        boolean found = false;

     
        for (int i = 0; i < 26; i++) {
            if (!present[i]) {
                System.out.print((char)(i + 'a'));
                found = true;
            }
        }

        if (!found) {
            System.out.print("None");
        }
    }
}