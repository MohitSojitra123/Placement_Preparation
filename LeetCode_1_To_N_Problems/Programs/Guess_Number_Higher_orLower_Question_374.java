public class Guess_Number_Higher_orLower_Question_374 {

    // Static input
    static int pickedNumber = 6;

    // Guess API
    static int guess(int num) {

        if (num > pickedNumber) {
            return -1;
        } else if (num < pickedNumber) {
            return 1;
        } else {
            return 0;
        }
    }

    static int guessNumber(int n) {

        int start = 1;
        int end = n;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        // Static input
        int n = 10;

        int result = guessNumber(n);

        System.out.println("Picked Number: " + pickedNumber);
        System.out.println("Answer: " + result);
    }
}