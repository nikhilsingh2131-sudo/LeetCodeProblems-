class Solution {

    public int solve(int i, int j, int[] nums) {

        if (i > j)
            return 0;

        if (i == j)
            return nums[i];

        int takeI = nums[i] + Math.min(
                solve(i + 2, j, nums),
                solve(i + 1, j - 1, nums)
        );

        int takeJ = nums[j] + Math.min(
                solve(i, j - 2, nums),
                solve(i + 1, j - 1, nums)
        );

        return Math.max(takeI, takeJ);
    }

    public boolean predictTheWinner(int[] nums) {

        int totalScore = 0;
        for (int num : nums) {
            totalScore += num;
        }

        int player1 = solve(0, nums.length - 1, nums);
        int player2 = totalScore - player1;

        return player1 >= player2;
    }
}