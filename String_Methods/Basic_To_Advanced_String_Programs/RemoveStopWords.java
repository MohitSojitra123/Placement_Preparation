// String str = "java is a powerful language and the java is easy";

// is, a, and, the

// java powerful language java easy

public class RemoveStopWords {

    public static void main(String[] args) {

        String str = "java is a powerful language and the java is easy";


        String stopWords[] = {"is", "the", "a", "and"};

        String result = "";

        String word = "";


        // Extract words manually
        for (int i = 0; i <= str.length(); i++) {

            if (i < str.length() && str.charAt(i) != ' ') {

                word = word + str.charAt(i);

            } 
            else {

                boolean isStopWord = false;


                // Check stop word
                for (int j = 0; j < stopWords.length; j++) {

                    if (word.equals(stopWords[j])) {

                        isStopWord = true;
                        break;
                    }
                }


                // Add only non-stop words
                if (!isStopWord) {

                    if (result.length() > 0) {
                        result = result + " ";
                    }

                    result = result + word;
                }


                word = "";
            }
        }


        System.out.println("Original String : " + str);
        System.out.println("After Removing Stop Words : " + result);
    }
}