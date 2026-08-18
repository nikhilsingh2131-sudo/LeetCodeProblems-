class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<List<Integer>> graph = new ArrayList<>();

        // Graph ke n nodes create karo
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Undirected graph
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        return dfs(graph, source, destination, visited);
    }

    private boolean dfs(ArrayList<List<Integer>> graph,
                        int current,
                        int destination,
                        boolean[] visited) {

        // Destination mil gaya
        if (current == destination) {
            return true;
        }

        visited[current] = true;

        // Neighbours check
        for (int nei : graph.get(current)) {

            if (!visited[nei]) {

                if (dfs(graph, nei, destination, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}