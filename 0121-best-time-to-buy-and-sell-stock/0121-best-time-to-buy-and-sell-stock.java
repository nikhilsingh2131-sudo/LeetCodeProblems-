class Solution {
    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;

        int max =0;

        for(int profit : prices){
            if(profit<minPrice){
                minPrice = profit;
            }

            max = Math.max(max , profit-minPrice);
        }
        return max;
    }
}