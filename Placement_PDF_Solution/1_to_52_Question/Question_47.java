// You  are  given  several  boxes  with  different  colors  represented  by  different  positive  numbers.  You  may 
// experience  several  rounds  to  remove  boxes  until  there  is  no  box  left.  Each  time  you  can  choose  some 
// continuous boxes with the same color, remove them and get k * k points. Return the maximum points 
// you can get.  
// Input: boxes = [1,3,2,2,2,3,4,3,1] Output: 23 
// Explanation: [1, 3, 2, 2, 2, 3, 4, 3, 1]  
// ----> [1, 3, 3, 4, 3, 1] (3*3=9 points)  
// ----> [1, 3, 3, 3, 1] (1*1=1 points)  
// ----> [1, 1] (3*3=9 points)  
// ----> [] (2*2=4 points)

public class Question_47 {

    static int[][][] dp;

    public static int solve(int[] boxes, int left, int right, int count) {

        if (left > right)
            return 0;

        if (dp[left][right][count] != 0)
            return dp[left][right][count];

        while (left < right && boxes[left] == boxes[left + 1]) {
            left++;
            count++;
        }

        int ans = (count + 1) * (count + 1)
                + solve(boxes, left + 1, right, 0);

        for (int i = left + 1; i <= right; i++) {

            if (boxes[i] == boxes[left]) {

                ans = Math.max(ans,
                        solve(boxes, left + 1, i - 1, 0)
                        + solve(boxes, i, right, count + 1));
            }
        }

        dp[left][right][count] = ans;

        return ans;
    }

    public static void main(String[] args) {

        int[] boxes = {1, 3, 2, 2, 2, 3, 4, 3, 1};

        int n = boxes.length;

        dp = new int[n][n][n];

        System.out.println("Maximum Points = " + solve(boxes, 0, n - 1, 0));
    }
}