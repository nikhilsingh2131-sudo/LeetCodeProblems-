class Solution {
    public void moveZeroes(int[] nums) {
        int prev =0;

        for(int i =0 ; i< nums.length ;i++){
            if(nums[i]!=0){
                int temp = nums[prev];
                 nums[prev] = nums[i];
                 nums[i]= temp;
                 prev++;

            }
        }
        
    }
}