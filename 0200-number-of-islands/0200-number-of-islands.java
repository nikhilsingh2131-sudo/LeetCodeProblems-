class Solution {

    public int numIslands(char[][] grid) {

        // Total rows
        int rows = grid.length;

        // Total columns
        int cols = grid[0].length;

        // Number of islands
        int islands = 0;

        // Har cell ko check karenge
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                // Agar current cell land hai
                if (grid[i][j] == '1') {

                    // Naya island mila
                    islands++;

                    // Is poore island ko visit kar do
                    dfs(grid, i, j);
                }
            }
        }

        return islands;
    }

    public void dfs(char[][] grid, int r, int c) {

        // Boundary ke bahar chale gaye
        if (r < 0 || c < 0 ||
            r >= grid.length ||
            c >= grid[0].length) {

            return;
        }

        // Water hai ya already visit ho chuka
        if (grid[r][c] == '0') {

            return;
        }

        // Current land ko water bana diya
        // Iska matlab visit ho gaya
        grid[r][c] = '0';

        // Upar
        dfs(grid, r - 1, c);

        // Neeche
        dfs(grid, r + 1, c);

        // Left
        dfs(grid, r, c - 1);

        // Right
        dfs(grid, r, c + 1);
    }
}