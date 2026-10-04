class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max =0;

        for(int price: prices){
            int profit = price-min;

            min = Math.min(min , price);

            max = Math.max(max , profit);

        }
        return max;
    }
}