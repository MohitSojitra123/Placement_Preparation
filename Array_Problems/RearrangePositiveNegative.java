import java.util.ArrayList;

public class RearrangePositiveNegative {

    public static void rearrange(int[] arr) {

        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();


        for (int num : arr) {

            if (num >= 0) {
                positive.add(num);
            }
            else {
                negative.add(num);
            }
        }

        int i = 0;
        int p = 0;
        int n = 0;

    
        while (p < positive.size() && n < negative.size()) {

            arr[i++] = positive.get(p++);
            arr[i++] = negative.get(n++);
        }


        while (p < positive.size()) {
            arr[i++] = positive.get(p++);
        }

        while (n < negative.size()) {
            arr[i++] = negative.get(n++);
        }
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, -4, -1, 4};

        rearrange(arr);

        System.out.println("Rearranged Array:");

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}