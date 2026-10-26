
class Solution {
    public int findLengthOfLCIS(int[] nums) {

        int ans = 1;

        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            int j = i + 1;
            int no = nums[i];

            while (j < nums.length && no < nums[j]) {
                count++;
                no = nums[j];
                j++;
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }
}
