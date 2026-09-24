public class Check_If_a_Word_Occurs_As_a_Prefix_of_Any_Word_in_a_Sentence_Question_1455 {

    public static int isPrefixOfWord(String sentence, String searchWord) {

        String str_arr[] = sentence.split(" ");

        for (int i = 0; i < str_arr.length; i++) {

            if (str_arr[i].startsWith(searchWord)) {
                return i + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        String sentence = "i love eating burger";
        String searchWord = "burg";

        int result = isPrefixOfWord(sentence, searchWord);

        System.out.println("Answer: " + result);
    }
}
