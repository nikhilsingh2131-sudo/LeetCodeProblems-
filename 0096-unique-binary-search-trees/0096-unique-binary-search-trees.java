class Solution {
    public int numTrees(int n) {
        return solve(n);
        
    }public int solve(int n){
        if(n<=1) return 1;

        int way =0;

        for(int root =1 ; root <=n ;root ++){
            int left =solve(root-1);
            int right =solve(n-root);

            way += left * right ;
        }

        return way ;
    }
}