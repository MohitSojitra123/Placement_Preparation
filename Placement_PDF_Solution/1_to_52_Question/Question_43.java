// WAP for following Scenario.  
// A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time. The 
// task is to implement a method to count how many possible ways the child can run up the stairs. 

public class Question_43 {

    public static int countWays(int n) {

        if (n == 0)
            return 1;

        if (n < 0)
            return 0;

        return countWays(n - 1)
                + countWays(n - 2)
                + countWays(n - 3);
    }

    public static void main(String[] args) {

        int n = 3;

        System.out.println(countWays(n));
    }
}

// n=4
// 1 + 1 + 1 + 1
// 1 + 1 + 2
// 1 + 2 + 1
// 2 + 1 + 1
// 2 + 2
// 1 + 3
// 3 + 1

// n=3
// 1 + 1 + 1
// 1 + 2
// 2 + 1
// 3