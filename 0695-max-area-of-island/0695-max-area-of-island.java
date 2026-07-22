class Solution {

    public int maxAreaOfIsland(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int max = 0;

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                // grid[][] nahi likhenge
                // current cell check karni hai
                if (grid[i][j] == 1) {

                    // dfs area return karega
                    int area = dfs(grid, i, j);

                    max = Math.max(max, area);
                }
            }
        }

        return max;
    }

    public int dfs(int[][] grid, int r, int c) {

        // Boundary check
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
            return 0;
        }

        // Water ya already visited
        if (grid[r][c] == 0) {
            return 0;
        }

        // visited mark
        grid[r][c] = 0;

        // current cell = 1
        int area = 1;

        area += dfs(grid, r - 1, c); // up
        area += dfs(grid, r + 1, c); // down
        area += dfs(grid, r, c - 1); // left
        area += dfs(grid, r, c + 1); // right

        return area;
    }
}