public class Buy_and_Sale_Stock_Question_121 {

    public static int maxProfit(int[] prices) {

        int min = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < min) {
                min = prices[i];
            }

            profit = Math.max(profit, prices[i] - min);
        }

        return profit;
    }

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        int result = maxProfit(prices);

        System.out.println("Maximum Profit = " + result);
    }
}