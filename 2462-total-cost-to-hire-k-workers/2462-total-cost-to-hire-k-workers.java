class Solution {
    public long totalCost(int[] costs, int k, int candidates) {

        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int i = 0;
        int j = costs.length - 1;

        // Left candidates
        while (i <= j && left.size() < candidates) {
            left.offer(costs[i]);
            i++;
        }

        // Right candidates
        while (i <= j && right.size() < candidates) {
            right.offer(costs[j]);
            j--;
        }

        long ans = 0;

        for (int hired = 0; hired < k; hired++) {

            int leftMin = left.isEmpty()
                    ? Integer.MAX_VALUE
                    : left.peek();

            int rightMin = right.isEmpty()
                    ? Integer.MAX_VALUE
                    : right.peek();

            if (leftMin <= rightMin) {

                ans += left.poll();

                if (i <= j) {
                    left.offer(costs[i]);
                    i++;
                }

            } else {

                ans += right.poll();

                if (i <= j) {
                    right.offer(costs[j]);
                    j--;
                }
            }
        }

        return ans;
    }
}