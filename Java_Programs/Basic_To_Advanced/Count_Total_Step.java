public class Count_Total_Step {

    public static void main(String[] args) {

        int step = 34;
        int count = 0;

        while (step >= 3) {
            step -= 3;
            count++;
        }

        while (step >= 2) {
            step -= 2;
            count++;
        }

        while (step >= 1) {
            step -= 1;
            count++;
        }

        System.out.println("Minimum Jumps = " + count);
    }
}