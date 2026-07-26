import java.util.HashSet;

public class Intersection_Of_Two_Arrays_2 {
    public static void main(String[] args) {

        int array1[] = {10, 20, 40, 50, 60};
        int array2[] = {10, 20, 30, 60};

        HashSet<Integer> set = new HashSet<>();

        for (int num : array1) {
            set.add(num);
        }

        for (int num : array2) {
            if (set.contains(num)) {
                System.out.print(num + " ");
            }
        }
    }
}