class Solution {
    public int countKDifference(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int diff1 = nums[i] + k;
            int diff2 = nums[i] - k;

            count += map.getOrDefault(diff1, 0);
            count += map.getOrDefault(diff2, 0);
        }

        return count / 2;
    }
}