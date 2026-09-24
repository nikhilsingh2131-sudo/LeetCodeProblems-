class Solution {
    public int islandPerimeter(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }

        return 0;
    }

    public int dfs(int[][] grid, int row, int col) {

        // Out of boundary
        if (row < 0 || col < 0 ||
            row >= grid.length || col >= grid[0].length) {
            return 1;
        }

        // Water
        if (grid[row][col] == 0) {
            return 1;
        }

        // Already visited
        if (grid[row][col] == 2) {
            return 0;
        }

        // Mark visited
        grid[row][col] = 2;

        int perimeter = 0;

        perimeter += dfs(grid, row + 1, col);
        perimeter += dfs(grid, row - 1, col);
        perimeter += dfs(grid, row, col + 1);
        perimeter += dfs(grid, row, col - 1);

        return perimeter;
    }
}