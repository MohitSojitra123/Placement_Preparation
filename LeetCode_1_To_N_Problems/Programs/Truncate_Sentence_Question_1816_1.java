public class Truncate_Sentence_Question_1816_1{

    public static String truncateSentence(String s, int k) {

        String[] str = s.split(" ");

        String ans = "";

        for (int i = 0; i < k; i++) {

            if (i < k - 1) {
                ans += str[i] + " ";
            } else {
                ans += str[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        // Static Input
        String s = "Hello how are you Contestant";
        int k = 4;

        String result = truncateSentence(s, k);

        System.out.println("Original Sentence : " + s);
        System.out.println("k = " + k);
        System.out.println("Truncated Sentence : " + result);
    }
}