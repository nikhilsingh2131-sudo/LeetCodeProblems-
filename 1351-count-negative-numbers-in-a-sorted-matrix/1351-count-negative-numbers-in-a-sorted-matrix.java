class Solution {
    public int countNegatives(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int ans = 0;

        for (int i = 0; i < rows; i++) {

            int low = 0;
            int high = cols - 1;

            while (low <= high) {

                int mid = low + (high - low) / 2;

                if (grid[i][mid] < 0) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            ans += cols - low;
        }

        return ans;
    }
}