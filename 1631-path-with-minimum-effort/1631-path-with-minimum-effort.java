class Solution {

    class Pair {
        int effort;
        int row;
        int col;

        Pair(int effort, int row, int col) {
            this.effort = effort;
            this.row = row;
            this.col = col;
        }
    }

    public int minimumEffortPath(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        int[][] dist = new int[m][n];

        for (int[] d : dist)
            Arrays.fill(d, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.effort - b.effort);

        pq.offer(new Pair(0, 0, 0));
        dist[0][0] = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int effort = curr.effort;
            int r = curr.row;
            int c = curr.col;

            // Skip outdated entries
            if (effort > dist[r][c]) continue;

            if (r == m - 1 && c == n - 1)
                return effort;

            for (int k = 0; k < 4; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n) {

                    int edge =
                        Math.abs(heights[r][c] - heights[nr][nc]);

                    int newEffort =
                        Math.max(effort, edge);

                    if (newEffort < dist[nr][nc]) {

                        dist[nr][nc] = newEffort;

                        pq.offer(new Pair(newEffort, nr, nc));
                    }
                }
            }
        }

        return 0;
    }
}