import java.util.HashMap;
import java.util.Map;

public class WordFrequency {

    public static void main(String[] args) {

        String paragraph = "java is easy and java is powerful";


        HashMap<String, Integer> map = new HashMap<>();

        String word = "";


        // Extract words manually
        for (int i = 0; i <= paragraph.length(); i++) {

            if (i < paragraph.length() && paragraph.charAt(i) != ' ') {

                word = word + paragraph.charAt(i);

            } 
            else {

                if (map.containsKey(word)) {

                    map.put(word, map.get(word) + 1);

                } 
                else {

                    map.put(word, 1);
                }

                word = "";
            }
        }


        // Print frequency
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


    //   map.forEach((k,v)->{
    //     System.out.println(k+" -> "+v);
    //   });

    }
}