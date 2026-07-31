import java.util.*;

public class Top_K_FrequentElements_Question_347 {

    public static int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count Frequency
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        // Step 2: Max Heap based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        pq.addAll(hm.entrySet());

        // Step 3: Store Top K Elements
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().getKey();
        }

        return result;
    }

    public static void main(String[] args) {

        // Static Input
        int nums[] = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] result = topKFrequent(nums, k);

        System.out.println("Top " + k + " Frequent Elements:");

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}