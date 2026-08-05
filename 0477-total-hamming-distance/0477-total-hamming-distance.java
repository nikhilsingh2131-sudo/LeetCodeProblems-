class Solution {
    public int totalHammingDistance(int[] nums) {

        int answer = 0;
        int n = nums.length;

        for (int bit = 0; bit < 32; bit++) {

            int ones = 0;

            for (int number : nums) {

                if (((number >> bit) & 1) == 1) {
                    ones++;
                }
            }

            int zeros = n - ones;

            answer += ones * zeros;
        }

        return answer;
    }
}