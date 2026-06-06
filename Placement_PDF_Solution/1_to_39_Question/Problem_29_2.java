import java.util.HashSet;

public class Problem_29_2 {
    public static void main(String[] args) {

        int arr1[] = {1, 2, 3, 4};
        int arr2[] = {3, 4, 5, 6};

        HashSet<Integer> set = new HashSet<>();

        for (int x : arr1)
            set.add(x);

        for (int x : arr2) {
            if (set.contains(x))
                set.remove(x);
            else
                set.add(x);
        }

        System.out.println(set);
    }
}