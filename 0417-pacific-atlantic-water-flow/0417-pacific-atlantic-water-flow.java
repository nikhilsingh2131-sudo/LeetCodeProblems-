class Solution {
    int n;
    int m;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> ans = new ArrayList<>();

        n = heights.length;
        m = heights[0].length;

        boolean[][] pac = new boolean[n][m];
        boolean[][] alt = new boolean[n][m];


        // -------- PACIFIC OCEAN --------

        // Left side
        for(int i = 0; i < n; i++) {
            dfs(i, 0, heights, pac);
        }

        // Top side
        for(int i = 0; i < m; i++) {
            dfs(0, i, heights, pac);
        }


        // -------- ATLANTIC OCEAN --------

        // Bottom side
        for(int i = 0; i < m; i++) {
            dfs(n - 1, i, heights, alt);
        }

        // Right side
        for(int i = 0; i < n; i++) {
            dfs(i, m - 1, heights, alt);
        }


        // -------- ANSWER --------

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                // Dono oceans se reachable
                if(pac[i][j] && alt[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }


    void dfs(int r, int c, int[][] heights, boolean[][] visited) {

        // Current cell ko visit kar diya
        visited[r][c] = true;


        int[][] dir = {
            {1, 0},     // down
            {-1, 0},    // up
            {0, 1},     // right
            {0, -1}     // left
        };


        for(int[] d : dir) {

            int nr = r + d[0];
            int nc = c + d[1];


            // Boundary check
            if(nr < 0 || nc < 0 || nr >= n || nc >= m) {
                continue;
            }


            // Already visited
            if(visited[nr][nc]) {
                continue;
            }


            // Reverse direction mein
            // next cell ki height current se >= honi chahiye
            if(heights[nr][nc] < heights[r][c]) {
                continue;
            }


            // Next cell par DFS
            dfs(nr, nc, heights, visited);
        }
    }
}