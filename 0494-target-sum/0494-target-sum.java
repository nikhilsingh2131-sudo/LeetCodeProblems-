class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(0, 0, nums, target);
    }

    public int solve(int i, int sum, int[] nums, int target) {

        if (i == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        int plus = solve(i + 1, sum + nums[i], nums, target);

        int minus = solve(i + 1, sum - nums[i], nums, target);

        return plus + minus;
    }
}