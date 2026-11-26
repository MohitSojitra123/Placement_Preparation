public class LongestConsecutiveSimple {


    public static boolean isPresent(int[] arr, int target) {

        for (int num : arr) {

            if (num == target) {
                return true;
            }
        }

        return false;
    }

    public static int longestConsecutive(int[] arr) {

        int longest = 0;

    
        for (int i = 0; i < arr.length; i++) {

            int current = arr[i];
            int count = 1;

           
            while (isPresent(arr, current + 1)) {

                current++;
                count++;
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }

    public static void main(String[] args) {

        int[] arr = {100, 4, 200, 1, 3, 2};

        int result = longestConsecutive(arr);

        System.out.println(
            "Longest Consecutive Sequence Length = "
            + result
        );
    }
}