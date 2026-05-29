import java.util.*;

class Leader_Element_In_Array{

    static ArrayList<Integer> leaders(int arr[]) {

        ArrayList<Integer> Arr = new ArrayList<>();

        Arr.add(arr[arr.length - 1]);

        int max = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] >= max) {
                max = arr[i];
                Arr.add(max);
            }
        }

        Collections.reverse(Arr);

        return Arr;
    }

    public static void main(String[] args) {

        int[] arr = {16, 17, 4, 3, 5, 2};

        ArrayList<Integer> result = leaders(arr);

        System.out.println("Leaders in array:");
        
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}