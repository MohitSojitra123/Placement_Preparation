// trim()              // Removes leading and trailing spaces
// replaceAll("\\s+"," ") // Replaces one or more whitespace characters with a single space


public class Remove_Extra_Spaces_1 {
    public static void main(String[] args) {

        String str = "   Java    is     easy   ";

        str = str.trim().replaceAll("\\s+", " ");

        System.out.println(str);
    }
}