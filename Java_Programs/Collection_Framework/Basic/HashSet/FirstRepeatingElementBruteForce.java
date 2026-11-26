package HashSet;
public class FirstRepeatingElementBruteForce {

    public static int firstRepeating(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (arr[i] == arr[j]) {

                    return arr[i];
                }
            }
        }

        return -1;
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