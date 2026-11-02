class Solution {
    public int minMoves2(int[] nums) {
        int n= nums.length;
        Arrays.sort(nums);

        int ans=0;
        int medium = nums[n/2];

        for(int i=0 ;i<n ;i++){
            ans += Math.abs(nums[i]-medium);
        }

        return ans;
    }
}