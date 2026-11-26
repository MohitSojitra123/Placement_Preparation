import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Last_Visited_Integers_Question_2899_1{

    public static List<Integer> lastVisitedIntegers(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        LinkedList<Integer> seen = new LinkedList<>();

        int count = 0;

        for (int num : nums) {

            if (num != -1) {

                seen.addFirst(num);

                count = 0;

            } else {

                count++;

                if (count <= seen.size()) {
                    ans.add(seen.get(count - 1));
                } else {
                    ans.add(-1);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        // Static Input
        int[] nums = {1, 2, -1, -1, 3, -1};

        List<Integer> result = lastVisitedIntegers(nums);

        System.out.print("Input Array : ");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        System.out.println();

        System.out.println("Output : " + result);
    }
} 