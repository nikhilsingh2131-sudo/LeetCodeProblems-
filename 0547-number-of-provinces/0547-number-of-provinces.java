class Solution {
    public int findCircleNum(int[][] isConnected) {
            
            int n = isConnected.length;
     boolean[] visited = new boolean[n];

     int provinces = 0;


     for(int i =0 ;i<n ;i++){
        if(!visited[i]){
            provinces++;
         dfs(isConnected, visited, i);

        }

     }

     return provinces;

    }
    public void dfs(int[][] graph , boolean[] visited , int node){
        visited[node] = true;

        for(int nei=0 ; nei< graph.length ; nei++){
            if(graph[node][nei]==1 && !visited[nei]){
                  dfs(graph, visited, nei);

            }
        }
    }
}