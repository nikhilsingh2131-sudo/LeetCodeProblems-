class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n =nums.length ;

        int max =0;

        int j =0;
        int count =0;
        while(j<n){
            if(nums[j]==0){
                count=0;
            }else{
                count++;
                max = Math.max(max , count);
            }
            j++;
        }
        return max;
    }
}