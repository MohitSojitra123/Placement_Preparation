public class Longest_Word {
    public static void main(String[] args) {
        String str = "I am a Student of Darshan University";

        String[] words = str.split(" ");

        String longest = "";

        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }

        System.out.println("Longest Word: " + longest);
        System.out.println("Length: " + longest.length());
    }
}