public class TripletSumBruteForce {

    public static void findTriplet(int[] arr, int target) {

        int n = arr.length;

        for (int i = 0; i < n - 2; i++) {

            for (int j = i + 1; j < n - 1; j++) {

                for (int k = j + 1; k < n; k++) {

                    if (arr[i] + arr[j] + arr[k] == target) {

                        System.out.println(
                            "Triplet Found: "
                            + arr[i] + " "
                            + arr[j] + " "
                            + arr[k]
                        );

                        return;
                    }
                }
            }
        }

        System.out.println("No Triplet Found");
    }

    public static void main(String[] args) {

        int[] arr = {1, 4, 45, 6, 10, 8};
        int target = 22;

        findTriplet(arr, target);
    }
}
