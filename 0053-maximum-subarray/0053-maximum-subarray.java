class Solution {
    public int maxSubArray(int[] nums) {

        int ans = nums[0];
        int sum=0;

        for(int left =0 ; left< nums.length ; left++){
         
         sum += nums[left];

         ans = Math.max(ans , sum );

        if(sum<0){
            sum =0;
        }
        }
        return ans ;
    }
}