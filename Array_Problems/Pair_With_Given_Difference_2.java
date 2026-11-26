import java.util.Arrays;

public class Pair_With_Given_Difference_2 {

    public static void main(String[] args) {

        int array[] = {5, 20, 3, 2, 50, 80};
        int diff = 78;

        Arrays.sort(array);

        int left = 0;
        int right = 1;

        while (right < array.length) {

            int currentDiff = array[right] - array[left];

            if (currentDiff == diff) {
                System.out.println("Pair Found: " + array[left] + " " + array[right]);
                return;
            } else if (currentDiff < diff) {
                right++;
            } else {
                left++;

                if (left == right) {
                    right++;
                }
            }
        }

        System.out.println("Pair Not Found");
    }
}