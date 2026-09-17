class Solution {
    public int getMaximumGold(int[][] grid) {

        int n = grid.length ;
        int m = grid[0].length;
        int max=0;

        for(int i =0 ; i<n ; i++){
            for(int j =0 ; j<m ; j++){
                if(grid[i][j]!=0){
                    int count = dfs(grid , i , j);
                    max = Math.max(max , count);
                }
            }
        }
        return max;
        
    }public int dfs(int[][] grid , int r , int c){
      
        int n = grid.length ;
        int m = grid[0].length;

        if(r<0 || c<0 || r>= n || c>=m || grid[r][c] == 0){
          return 0;
        }

       int gold = grid[r][c];

       grid[r][c] = 0;

       int up = dfs(grid , r-1 , c);
       int down = dfs(grid , r+1 , c);
       int left = dfs(grid , r , c-1);;
       int right = dfs(grid , r , c+1);

       grid[r][c] = gold;

       return gold + Math.max(Math.max(up , down) , Math.max(left , right));


    }
}