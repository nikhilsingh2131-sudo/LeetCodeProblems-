class Solution {

    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;
        int row = grid.length;
        int col = grid[0].length;

        // Rotten queue me daalo aur fresh count karo
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int minute = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty() && fresh > 0) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];

                for (int k = 0; k < 4; k++) {

                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (nr >= 0 && nr < row &&
                        nc >= 0 && nc < col &&
                        grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                        fresh--;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }

            minute++;
        }

        return fresh == 0 ? minute : -1;
    }
}