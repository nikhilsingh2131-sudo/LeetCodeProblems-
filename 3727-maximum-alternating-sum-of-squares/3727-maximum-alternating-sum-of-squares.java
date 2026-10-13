class Solution {
    public long maxAlternatingSum(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;
        long sum = 0;

        long[] squares = new long[n];

        for (int i = 0; i < n; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(squares);

        int i = 0;
        int j = n - 1;

        while (i < j) {
            sum += squares[j] - squares[i];
            i++;
            j--;
        }

        if (i == j) {
            sum += squares[i];
        }

        return sum;
    }
}
