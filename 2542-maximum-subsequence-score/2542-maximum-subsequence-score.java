class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;

        Integer[] index = new Integer[n];

        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        Arrays.sort(index, (a, b) -> nums2[b] - nums2[a]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long sum = 0;
        long ans = 0;

        for (int i : index) {

            pq.offer(nums1[i]);
            sum += nums1[i];

            if (pq.size() > k) {
                sum -= pq.poll();
            }

            if (pq.size() == k) {
                ans = Math.max(ans, sum * nums2[i]);
            }
        }

        return ans;
    }
}