class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        List<List<Integer>>graph = new ArrayList<>();

        for(int i=0 ; i<=n ;i++){
            graph.add(new ArrayList<>());
        }

        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];

            boolean[] vis = new boolean[n+1];

            if(dfs(graph , vis , u ,v)){
                return edge;
            }

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return new int[0];
    }

        private boolean dfs(List<List<Integer>>graph , boolean[]vis , int curr ,int end){
            if(curr==end){
                return true;
            }

            vis[curr] = true;

            for(int nei:graph.get(curr)){

                if(!vis[nei]){ 
                if(dfs(graph , vis , nei ,end)){
                    return true;
                }
            }
            }
            return false;
    }

}