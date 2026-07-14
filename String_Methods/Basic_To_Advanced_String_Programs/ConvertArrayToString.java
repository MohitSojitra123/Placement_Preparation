public class ConvertArrayToString {
    public static void main(String[] args) {

        String[] arr = {"abc", "def", "ghi"};

        String result = String.join("", arr);

        System.out.println(result);
    }
}