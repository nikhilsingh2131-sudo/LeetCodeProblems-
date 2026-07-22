class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;

        // Step 1: Sabhi rotten oranges queue me daal do
        // Aur fresh oranges count kar lo
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // Agar fresh orange hi nahi hai
        if (fresh == 0) {
            return 0;
        }

        int minutes = 0;

        // 4 Directions (Down, Up, Right, Left)
        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        // Jab tak queue empty nahi hoti aur fresh bache hain
        while (!q.isEmpty() && fresh > 0) {

            int size = q.size();

            // Queue ke current level ko process karo
            // Ye ek minute represent karta hai
            for (int i = 0; i < size; i++) {

                int[] curr = q.poll();

                int x = curr[0];
                int y = curr[1];

                // 4 neighbours check karo
                for (int[] d : dir) {

                    int nx = x + d[0];
                    int ny = y + d[1];

                    // Boundary ke andar hona chahiye
                    // Aur fresh orange hona chahiye
                    if (nx >= 0 && nx < m &&
                        ny >= 0 && ny < n &&
                        grid[nx][ny] == 1) {

                        // Fresh ko rotten bana do
                        grid[nx][ny] = 2;

                        // Fresh count kam karo
                        fresh--;

                        // Queue me daal do taaki next minute
                        // ye bhi apne neighbours ko infect kare
                        q.offer(new int[]{nx, ny});
                    }
                }
            }

            // Ek level complete = Ek minute
            minutes++;
        }

        // Agar abhi bhi fresh bache hain
        if (fresh > 0) {
            return -1;
        }

        return minutes;
    }
}