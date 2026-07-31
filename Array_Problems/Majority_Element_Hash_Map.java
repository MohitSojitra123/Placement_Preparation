// Input:
// arr = [2,2,1,1,1,2,2]

// Output:
// 2

// n = 7
// count > 7/2
// count > 3


import java.util.HashMap;

public class Majority_Element_Hash_Map {

    public static void main(String[] args) {

        int arr[] = {2,2,1,1,1,2,2};

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > arr.length / 2) {
                System.out.println(num);
                return;
            }
        }
    }
}