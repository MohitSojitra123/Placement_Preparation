import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Group_Anagrams_Question_49_2{

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> arr = new ArrayList<>();

        boolean testing[] = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {

            char Current_str[] = strs[i].toCharArray();

            Arrays.sort(Current_str);

            List<String> Temp_list = new ArrayList<>();

            Temp_list.add(strs[i]);

            if (testing[i] != true) {

                for (int j = i + 1; j < strs.length; j++) {

                    char next_str[] = strs[j].toCharArray();

                    Arrays.sort(next_str);

                    if (Arrays.equals(Current_str, next_str)) {

                        Temp_list.add(strs[j]);
                        testing[j] = true;
                    }
                }

                arr.add(Temp_list);
            }
        }

        return arr;
    }

    public static void main(String[] args) {

        // Static Input
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = groupAnagrams(strs);

        System.out.println(result);
    }
}