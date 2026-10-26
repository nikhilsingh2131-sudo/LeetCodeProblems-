
class Solution {
    public int findShortestSubArray(int[] nums) {

        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();

        int degree = 0;
        int ans = nums.length;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            freq.put(num, freq.getOrDefault(num, 0) + 1);
            first.putIfAbsent(num, i);

            int count = freq.get(num);

            if (count > degree) {
                degree = count;
                ans = i - first.get(num) + 1;
            } else if (count == degree) {
                ans = Math.min(ans, i - first.get(num) + 1);
            }
        }

        return ans;
    }
}
