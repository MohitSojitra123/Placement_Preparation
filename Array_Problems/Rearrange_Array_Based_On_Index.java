import java.util.Arrays;

class Rearrange_Array_Based_On_Index {

    public static void main(String[] args) {

        int arr[] = {2, -1, 1, 8, 5, -1, 6};

        int n = arr.length;


        int result[] = new int[n];

        Arrays.fill(result, -1);

        for(int i = 0; i < n; i++) {
            if(arr[i] >= 0 && arr[i] < n) {
                result[arr[i]] = arr[i];
            }
        }


        System.out.println(Arrays.toString(result));
    }
}