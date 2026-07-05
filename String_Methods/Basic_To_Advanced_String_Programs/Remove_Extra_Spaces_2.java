public class Remove_Extra_Spaces_2{
    public static void main(String[] args) {

        String str = "   Java    is     easy   ";

        String[] words = str.trim().split("\\s+");

        String result = String.join(" ", words);

        System.out.println(result);
    }
}