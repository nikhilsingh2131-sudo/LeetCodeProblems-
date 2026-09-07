class Solution {
    public int thirdMax(int[] nums) {

        int n = nums.length-1;

        Arrays.sort(nums);

        int count=1;
        int ans = Integer.MIN_VALUE;

        for(int i=n-1 ; i>=0 ;i--){
            if(nums[i]==nums[i+1]){
                continue;
            }
            count++;

            if(count==3){
                return nums[i];
            }
        }
        return nums[n];
    }
}