class Solution {
    public int maxProfit(int[] prices, int fee) {

        int profit = 0;

        int buy = prices[0];

        for (int i = 1; i < prices.length; i++) {

            // Better buying price mil gaya
            if (prices[i] < buy) {
                buy = prices[i];
            }

            // Profit possible hai
            if (prices[i] > buy + fee) {

                profit += prices[i] - buy - fee;

                // Important:
                // Sell ke baad effective buy price
                // ko adjust karna hai
                buy = prices[i] - fee;
            }
        }

        return profit;
    }
}