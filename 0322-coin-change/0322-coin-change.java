
import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length ;
        int[][] dp = new int[coins.length][amount + 1];

        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0) {
                dp[0][t] = t / coins[0];
            } else {
                dp[0][t] = 1000000;
            }
        }

           for (int index = 1; index < n; index++){
            for(int t =0 ;t<=amount ; t++){
                 int notTake = dp[index-1][t];

                 int take = 1000000;

                  if (coins[index] <= t) {
                 take = 1 + dp[index][t- coins[index] ];
                }
                   dp[index][t] = Math.min(take, notTake);
            }
           }


        int ans = dp[n-1][amount];

        return ans >= 1000000 ? -1 : ans;
    }

}