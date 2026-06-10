public class Climb_Stairs_Question_70{

    public static int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }

        int first = 1;
        int second = 2;

        for (int i = 3; i <= n; i++) {
            int current = first + second;
            first = second;
            second = current;
        }

        return second;
    }

    public static void main(String[] args) {

        int n = 5; 

        System.out.println("Number of ways = " + climbStairs(n));
    }
}