class Solution {

    class Pair {
        int node;
        int time;

        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : times) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            graph.get(u).add(new Pair(v, w));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.time - b.time);

        pq.offer(new Pair(k, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int node = curr.node;
            int time = curr.time;

            if (time > dist[node]) {
                continue;
            }

            for (Pair nei : graph.get(node)) {

                if (dist[node] + nei.time < dist[nei.node]) {

                    dist[nei.node] = dist[node] + nei.time;

                    pq.offer(new Pair(nei.node, dist[nei.node]));
                }
            }
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}