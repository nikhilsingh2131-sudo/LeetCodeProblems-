class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int n = grid.length ;
        int m = grid[0].length ;

        int max  =0;

        for(int i =0 ; i<n ; i++){
            for(int j=0 ; j<m ;j++){
                if(grid[i][j]==1){
                    int x = dfs(grid , i,j);
                    max = Math.max(max , x);
                }
            }
        }
        return max;
    }
    public int dfs(int[][] grid , int r , int c){
        int count =0;

        if(r<0 || c<0 || r>= grid.length  || c>= grid[0].length){
            return count;
        }

        if(grid[r][c]==0){
            return count;
        }

        count++;
        grid[r][c] = 0;

     count += dfs(grid , r+1 ,c) ;
      count +=dfs(grid , r-1 , c);
      count +=dfs(grid , r , c+1);
     count += dfs(grid , r , c-1);

      return count ;
    }
}