class Solution {
    public int missingNumber(int[] nums) {
        int n  = nums.length ;
        int ans=n;

        for(int i =0;i<nums.length;i++){
            ans ^= i;
            ans^= nums[i];
        }

        return ans;

    }
}