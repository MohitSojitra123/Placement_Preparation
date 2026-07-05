public class Shortest_Word{
    public static void main(String[] args) {
        String str = "I am a Student of Darshan University";

        String[] words = str.split(" ");
        String shortest = words[0];

        for (String word : words) {
            if (word.length() < shortest.length()) {
                shortest = word;
            }
        }

        System.out.println("Shortest Word: " + shortest);
        System.out.println("Length: " + shortest.length());
    }
}