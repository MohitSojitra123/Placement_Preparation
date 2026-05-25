package HashSet;
import java.util.HashSet;

public class FirstRepeatingElementHashSet {

    public static int firstRepeating(int[] arr) {

        HashSet<Integer> set =
            new HashSet<>();

        int answer = -1;

        // Traverse from right to left
        for (int i = arr.length - 1;
             i >= 0;
             i--) {

            if (set.contains(arr[i])) {

                answer = arr[i];
            }
            else {

                set.add(arr[i]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int arr[] = {10,5,3,4,3,5,6};

        int ans = firstRepeating(arr);

        if (ans != -1) {

            System.out.println(
                "First Repeating Element = "
                + ans
            );
        }
        else {

            System.out.println(
                "No Repeating Element"
            );
        }
    }
}