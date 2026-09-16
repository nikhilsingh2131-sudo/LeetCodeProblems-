class Solution {
     int n;
     int m;
    public int numIslands(char[][] grid) {

         n = grid.length;
         m = grid[0].length ;

        int island =0;

        for(int i=0 ; i< n ; i++){
            for(int j=0; j<m ; j++){
                if(grid[i][j]=='1'){
                    dfs(grid , i , j);
                    island++;
                }
            }
        }
       return island;       
    }
    public void dfs(char[][] grid , int r , int c){
       
        if(r<0 || c<0 ||r>=n || c>=m){
            return;
        }
        
           if (grid[r][c] == '0') {
            return;
        }
     
          grid[r][c] = '0';
        

        dfs(grid , r+1 ,c);
         dfs(grid , r-1 ,c);
          dfs(grid , r ,c+1);
           dfs(grid , r ,c-1);
    }
}