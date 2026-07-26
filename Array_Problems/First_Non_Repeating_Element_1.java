import java.util.HashMap;

public class First_Non_Repeating_Element_1 {

    public static void main(String[] args) {

        int array[] = {10, 20, 30, 10, 20, 40, 50, 40};

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int num : array) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        for (int num : array) {
            if (hm.get(num) == 1) {
                System.out.println("First Non-Repeating Element = " + num);
                return;
            }
        }

        System.out.println("No Non-Repeating Element");
    }
}