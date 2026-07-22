// You  have  n  super  washing  machines  on  a  line.  Initially,  each  washing  machine  has  some 
// dresses or is empty. 
// For each move, you could choose any m (1 <= m <= n) washing machines, and pass one dress 
// of each washing machine to one of its adjacent washing machines at the same time. 
// Given an integer array machine representing the number of dresses in each washing machine 
// from left to right on the line, return the minimum number of moves to make all the washing 
// machines have the same number of dresses. If it is not possible to do it, return -1. 
// Input: machines = [1,0,5] 
// Output: 3 
// Explanation: 
// 1st move:    1     0 <-- 5    =>    1     1     4 
// 2nd move:    1 <-- 1 <-- 4    =>    2     1     3 
// 3rd move:    2     1 <-- 3    =>    2     2     2

public class Problem_54 {

    public static void main(String[] args) {

        int machines[] = {1, 0, 5};

        int sum = 0;

        for (int i = 0; i < machines.length; i++) {
            sum += machines[i];
        }

        if (sum % machines.length != 0) {
            System.out.println(-1);
            return;
        }

        int target = sum / machines.length;

        int balance = 0;
        int moves = 0;

        for (int i = 0; i < machines.length; i++) {

            balance += machines[i] - target;

            moves = Math.max(moves,
                    Math.max(Math.abs(balance), machines[i] - target));
        }

        System.out.println("Minimum Moves = " + moves);
    }
}