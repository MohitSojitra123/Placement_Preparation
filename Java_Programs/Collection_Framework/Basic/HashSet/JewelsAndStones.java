package HashSet;

import java.util.HashSet;

public class JewelsAndStones {

    public static void main(String[] args) {

        String jewels = "aA";
        String stones = "aAAbbbb";

        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }

        int count = 0;

        for(int i = 0; i < stones.length(); i++) {

            char ch = stones.charAt(i);

            if(set.contains(ch)) {
                count++;
            }
        }

        System.out.println("Jewels Count = " + count);
    }
}