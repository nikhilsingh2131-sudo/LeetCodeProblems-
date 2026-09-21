class Solution {

    public int removeStones(int[][] stones) {

        int n = stones.length;
        boolean[] visited = new boolean[n];

        int components = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                dfs(stones, i, visited);

                components++;
            }
        }

        return n - components;
    }

    public void dfs(int[][] stones, int i, boolean[] visited) {

        visited[i] = true;

        for (int j = 0; j < stones.length; j++) {

            if (!visited[j]) {

                // same row OR same column
                if (stones[i][0] == stones[j][0] ||
                    stones[i][1] == stones[j][1]) {

                    dfs(stones, j, visited);
                }
            }
        }
    }
}