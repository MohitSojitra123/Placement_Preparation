public class RemoveConsonants {
    public static void main(String[] args) {
        String str = "Darshan University";
        String result = "";

        for (char ch : str.toCharArray()) {
            if ("aeiouAEIOU".indexOf(ch) != -1 || ch == ' ') {
                result += ch;
            }
        }

        System.out.println("After Removing Consonants: " + result);
    }
}