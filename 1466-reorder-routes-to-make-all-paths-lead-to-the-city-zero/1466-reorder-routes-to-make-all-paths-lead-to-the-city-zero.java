class Solution {
    public int minReorder(int n, int[][] connections) {
       

        List<int[]> [] graph = new ArrayList[n];

        for(int i =0 ; i< n ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int [] edge : connections){
            int from = edge[0];
            int to = edge[1];

            //  Original

        graph[from].add(new int[]{ to ,1});

        // Reverse traversal: to -> from
            graph[to].add(new int[]{from, 0});
        }

        boolean [] vis = new boolean[n];

        return dfs(0 ,graph , vis );

        
        
    }
    private int dfs(int city , List<int[]> [] graph , boolean [] vis ){
        vis[city] = true ;

        int flip = 0;

        for(int [] edge : graph[city]){
            int nei = edge[0];
            int dir = edge[1];

            if(!vis[nei]){
                flip += dir;
                flip += dfs(nei , graph , vis);
            }
        }
        return flip ;
    }
}