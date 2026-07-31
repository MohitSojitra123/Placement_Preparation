public class Find_Special_Integer_Question_1287 {

    public static int findSpecialInteger(int[] arr) {

        int count = 1;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count > arr.length / 4) {
                return arr[i];
            }
        }

        return arr[0];
    }

    public static void main(String[] args) {

        // Static Array Input
        int[] arr = {1, 2, 2, 6, 6, 6, 6, 7, 10};

        int result = findSpecialInteger(arr);

        System.out.println("Element Appearing More Than 25%: " + result);
    }
}