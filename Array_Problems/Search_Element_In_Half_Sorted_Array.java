public class Search_Element_In_Half_Sorted_Array {

    public static int Binary_Search_Half_Rotate_Sort_Array(
            int arr[], int start, int end, int target) {

        while (start <= end) {

            // mid must be calculated inside the loop
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (arr[start] <= arr[mid]) {

                if (arr[start] <= target && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            }
            // Right half is sorted
            else {

                if (arr[mid] < target && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int array[] = {
            2, 5, 8, 12, 15, 18, 22,
            24, 28, 30, 40, 50, 60
        };

        System.out.println(
            Binary_Search_Half_Rotate_Sort_Array(
                array, 0, array.length - 1, 12
            )
        );
    }
}