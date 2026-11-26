package HashSet;

import java.util.HashSet;

public class HappyNumber {

    public static int squareSum(int num) {

        int sum = 0;

        while(num > 0) {
            int digit = num % 10;
            sum = sum + (digit * digit);
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {

        int num = 19;

        HashSet<Integer> set = new HashSet<>();

        while(num != 1 && !set.contains(num)) {

            set.add(num);

            num = squareSum(num);
        }

        if(num == 1) {
            System.out.println("Happy Number");
        }
        else {
            System.out.println("Not Happy Number");
        }
    }
}