public class Max_ConsecutiveOnesIII_Question_1004 {

    public static void main(String[] args) {

        int nums[] = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        int max = 0;

        for (int i = 0; i < nums.length; i++) {

            int zero = 0;
            int count = 0;

            for (int j = i; j < nums.length; j++) {

                if (nums[j] == 0) {
                    zero++;
                }

                if (zero > k) {
                    break;
                }

                count++;
            }

            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}