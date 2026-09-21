class Solution {
    public long[] resultArray(int[] nums, int k) {

         long[] ans = new long[k];

          long[]dp = new long[k];

          for(int num : nums){
            int val = num%k;

             long[]newDp = new long[k];

             newDp[val]++;

             for(int i =0 ; i<k ; i++){
               int newRem = (val*i)%k;

               newDp[newRem] += dp[i];
             }

             for(int i =0 ; i<k ; i++){
                ans[i] += newDp[i];
             }

             dp = newDp;
          }

          return ans;
        
    }
}