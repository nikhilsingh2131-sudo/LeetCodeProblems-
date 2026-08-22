class Solution {

    public int nearestExit(char[][] maze, int[] entrance) {

        int n = maze.length;
        int m = maze[0].length;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{entrance[0], entrance[1]});

        // Mark entrance visited
        maze[entrance[0]][entrance[1]] = '+';

        int steps = 0;

        int[][] directions = {
            {-1, 0},  // up
            {1, 0},   // down
            {0, -1},  // left
            {0, 1}    // right
        };

        while (!q.isEmpty()) {

            int size = q.size();

            steps++;

            for (int i = 0; i < size; i++) {

                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];

                for (int[] dir : directions) {

                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    // Boundary check
                    if (nr < 0 || nr >= n ||
                        nc < 0 || nc >= m) {
                        continue;
                    }

                    // Wall or already visited
                    if (maze[nr][nc] == '+') {
                        continue;
                    }

                    // We found an exit
                    if (nr == 0 || nr == n - 1 ||
                        nc == 0 || nc == m - 1) {

                        return steps;
                    }

                    // Mark visited
                    maze[nr][nc] = '+';

                    q.add(new int[]{nr, nc});
                }
            }
        }

        return -1;
    }
}