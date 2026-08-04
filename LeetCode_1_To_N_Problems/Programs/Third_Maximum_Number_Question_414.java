import java.util.TreeSet;

public class Third_Maximum_Number_Question_414 {

    public static void main(String[] args) {

        int nums[] = {2, 2, 3, 1};

        TreeSet<Integer> set = new TreeSet<>();

        for (int num : nums) {

            set.add(num);

            if (set.size() > 3) {
                set.pollFirst();
            }
        }

        int result;

        if (set.size() < 3) {
            result = set.last();
        } else {
            result = set.first();
        }

        System.out.println("Third Maximum Number : " + result);
    }
}