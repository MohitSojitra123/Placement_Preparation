import java.util.*;

public class Array_Even_Odd_Element_Store_In_Array {
    public static void main(String[] args) {

        int arr[] = {2, 4, 6, 8, 1, 3};

        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();

        for (int num : arr) {
            if (num % 2 == 0)
                even.add(num);
            else
                odd.add(num);
        }

        int result[] = new int[arr.length];
        int k = 0, e = 0, o = 0;

        while (e < even.size() && o < odd.size()) {
            result[k++] = even.get(e++);
            result[k++] = odd.get(o++);
        }

        while (e < even.size())
            result[k++] = even.get(e++);

        while (o < odd.size())
            result[k++] = odd.get(o++);

        System.out.println(Arrays.toString(result));
    }
}