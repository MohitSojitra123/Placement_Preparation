
// Left and Right Side Both Element is Less Than 

// like a 12 30 18   --> 30 
// 12 < 30 and 18 < 30 

public class Peak_Element {
    public static void main(String[] args) {

        int arr[] = {1, 3, 20, 4, 1, 0};
        int n = arr.length;

        // First element
        if (n == 1 || arr[0] > arr[1]) {
            System.out.println("Peak = " + arr[0]);
            return;
        }

        // Middle elements
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                System.out.println("Peak = " + arr[i]);
                return;
            }
        }

        // Last element
        if (arr[n - 1] > arr[n - 2]) {
            System.out.println("Peak = " + arr[n - 1]);
        }
    }
}