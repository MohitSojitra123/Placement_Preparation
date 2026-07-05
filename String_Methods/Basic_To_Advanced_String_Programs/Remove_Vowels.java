public class Remove_Vowels {
    public static void main(String[] args) {
        String str = "Darshan University";

        String result = str.replaceAll("[aeiouAEIOU]", "");

        System.out.println(result);
    }
}