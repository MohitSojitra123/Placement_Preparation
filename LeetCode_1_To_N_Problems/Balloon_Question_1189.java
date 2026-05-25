import java.util.*;

class Solution {
    public int maxNumberOfBalloons(String text) {

        Map<Character, Integer> map = new HashMap<>();

        map.put('b', 0);
        map.put('a', 0);
        map.put('l', 0);
        map.put('o', 0);
        map.put('n', 0);

        for (int i = 0; i < text.length(); i++) {
            char temp = text.charAt(i);

            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            }
        }

        int min = map.get('b');

        min = Math.min(map.get('a'), min);
        min = Math.min(min, map.get('l') / 2);
        min = Math.min(min, map.get('o') / 2);
        min = Math.min(map.get('n'), min);

        return min;
    }
}

public class Balloon_Question_1189{
    public static void main(String[] args) {

        String text = "loonbalxballpoon";

        Solution obj = new Solution();

        int result = obj.maxNumberOfBalloons(text);

        System.out.println("Maximum number of balloons = " + result);
    }
}