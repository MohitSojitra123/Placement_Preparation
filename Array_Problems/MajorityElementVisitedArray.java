public class MajorityElementVisitedArray {

    public static void main(String[] args) {

        int arr[] = {2, 2, 1, 1, 1, 2, 2};

        int n = arr.length;

        int visited[] = new int[n];

        for (int i = 0; i < n; i++) {
            visited[i] = 0;
        }

        int majorityElement = -1;

        for (int i = 0; i < n; i++) {

            if (visited[i] == -1) {
                continue;
            }

            int count = 1;

            for (int j = i + 1; j < n; j++) {

                if (arr[i] == arr[j]) {

                    count++;

                    visited[j] = -1;
                }
            }

            if (count > n / 2) {

                majorityElement = arr[i];
                break;
            }
        }

        if (majorityElement != -1) {

            System.out.println(
                "Majority Element = "
                + majorityElement
            );
        }
        else {

            System.out.println(
                "No Majority Element Found"
            );
        }
    }
}