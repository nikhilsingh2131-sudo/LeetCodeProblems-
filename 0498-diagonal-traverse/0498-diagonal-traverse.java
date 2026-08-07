class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int[] ans = new int[m * n];
        int index = 0;

        // Total number of diagonals
        for (int d = 0; d < m + n - 1; d++) {

            if (d % 2 == 0) {
                // Even diagonal -> Up Right

                int row = Math.min(d, m - 1);
                int col = d - row;

                while (row >= 0 && col < n) {
                    ans[index++] = mat[row][col];

                    row--;
                    col++;
                }

            } else {
                // Odd diagonal -> Down Left

                int col = Math.min(d, n - 1);
                int row = d - col;

                while (row < m && col >= 0) {
                    ans[index++] = mat[row][col];

                    row++;
                    col--;
                }
            }
        }

        return ans;
    }
}