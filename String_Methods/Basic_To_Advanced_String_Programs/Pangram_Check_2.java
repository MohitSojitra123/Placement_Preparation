public class Pangram_Check_2 {
    public static void main(String[] args) {

        String str = "The quick brown fox jumps over the lazy dog";

        str = str.toLowerCase();

        boolean isPangram = true;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (str.indexOf(ch) == -1) {
                isPangram = false;
                break;
            }
        }

        if (isPangram) {
            System.out.println("Pangram");
        } else {
            System.out.println("Not Pangram");
        }
    }
}