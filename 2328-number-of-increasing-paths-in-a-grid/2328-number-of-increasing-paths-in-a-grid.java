class Solution {
    private static final int MOD = 1000000007;
    private int helper(int grid[][], int i, int j, int prev, int dp[][]) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] <= prev) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int left = helper(grid, i, j - 1, grid[i][j], dp); 
        int right = helper(grid, i, j + 1, grid[i][j], dp); 
        int up = helper(grid, i - 1, j, grid[i][j], dp); 
        int down = helper(grid, i + 1, j, grid[i][j], dp); 
        return dp[i][j] = (1 + left + right + up + down) % MOD;
    }

    public int countPaths(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        for(int row[] : dp) Arrays.fill(row, -1);
        int result = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) result = (result + helper(grid, i, j, -1, dp)) % MOD;
        }
        return result;
    }
}