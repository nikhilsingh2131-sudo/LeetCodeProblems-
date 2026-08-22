class Solution {
    public int findCircleNum(int[][] isConnected) {
            
            int n = isConnected.length;
     boolean[] visited = new boolean[n];

     int provinces = 0;

     for(int i =0 ; i< isConnected.length ; i++){
        if(!visited[i]){
            provinces++;
            dfs(i , isConnected , visited);
        }
     }
     return provinces ;

    }
    public void dfs(int city  ,int[][] isConnected, boolean[] vis ){
        vis[city] = true ;

          for (int neighbour = 0;
             neighbour < isConnected.length;
             neighbour++){
                if(isConnected[city][neighbour]==1 && !vis[neighbour]){
                    dfs(neighbour , isConnected , vis);
                }
             }
    }
}