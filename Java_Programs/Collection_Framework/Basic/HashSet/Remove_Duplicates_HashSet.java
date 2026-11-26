package HashSet;
import java.util.HashSet;

public class Remove_Duplicates_HashSet {

    public static void main(String[] args) {

        int arr[] = {1,1,2,3,4,4,5,2};

        HashSet<Integer> set = new HashSet<>();

        // Add all elements into HashSet
        for (int num : arr) {

            set.add(num);
        }

        System.out.println("Unique Elements:");

        for (int num : set) {

            System.out.print(num + " ");
        }
    }
}