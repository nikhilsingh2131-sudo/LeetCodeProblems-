class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];

        int ans =0;

        for(int price : prices){
            int profit = price - min ; 

            min = Math.min(min,price);
            ans = Math.max(profit  , ans);
        }
        return ans;
    }
}