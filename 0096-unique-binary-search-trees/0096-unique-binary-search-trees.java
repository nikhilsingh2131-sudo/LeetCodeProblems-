class Solution {
    public int numTrees(int n) {
        int[] dp =new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n , dp);
        
    }public int solve(int n , int[]dp){
        if(n<=1) return 1;

        if(dp[n]!=-1) return dp[n];

        int way =0;

        for(int root =1 ; root <=n ;root ++){
            int left =solve(root-1 , dp);
            int right =solve(n-root , dp);

            way += left * right ;
        }

        return dp[n]= way ;
    }
}