// Input:
// arr = [2,2,1,1,1,2,2]

// Output:
// 2

// n = 7
// count > 7/2
// count > 3


public class Majority_Element_Brute_1 {

    public static void main(String[] args) {

        int arr[] = {2,2,1,1,1,2,2};

        int n = arr.length;

        for (int i = 0; i < n; i++) {

            int count = 0;

            for (int j = 0; j < n; j++) {

                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count > n / 2) {
                System.out.println(arr[i]);
                return;
            }
        }
    }
}