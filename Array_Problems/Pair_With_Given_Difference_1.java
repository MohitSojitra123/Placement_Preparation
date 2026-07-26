public class Pair_With_Given_Difference_1{

    public static void main(String[] args) {

        int array[] = {5, 20, 3, 2, 50, 80};
        int diff = 78;

        boolean found = false;

        for (int i = 0; i < array.length; i++) {

            for (int j = i + 1; j < array.length; j++) {

                if (Math.abs(array[i] - array[j]) == diff) {
                    System.out.println("Pair Found: " + array[i] + " " + array[j]);
                    found = true;
                    break;
                }
            }

            if (found)
                break;
        }

        if (!found) {
            System.out.println("Pair Not Found");
        }
    }
}