import java.util.HashSet;

public class HashSet_TwoSum {
    public static void main(String[] args) {

        int[] arr = {2, 7, 11, 15};

        int target = 9;

        HashSet<Integer> set = new HashSet<>();

        for(int num : arr){

            int value = target - num;

            if(set.contains(value)){

                System.out.println(value + " + " + num + " = " + target);
            }

            set.add(num);
        }
    }
}