class Solution {
    public int maxProduct(int[] nums) {

        int max =Integer.MIN_VALUE;
        int prefix = 1;

        for(int i =0 ; i<nums.length ; i++){
            prefix = prefix * nums[i];
            max = Math.max(max , prefix);
            if(nums[i]==0){
                prefix = 1;
            }
        }
        prefix = 1;
         for(int i =nums.length-1 ; i>=0; i--){
            prefix = prefix * nums[i];
            max = Math.max(max , prefix);
            if(nums[i]==0){
                prefix = 1;
            }
        }
        return max;
        
    }
}