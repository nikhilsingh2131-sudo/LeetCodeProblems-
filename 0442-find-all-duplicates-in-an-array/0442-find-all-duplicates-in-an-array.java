class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer>ans = new ArrayList<>();
        for(int n:nums){
            nums[Math.abs(n)-1] = -nums[Math.abs(n)-1];
        }
        for(int n:nums){
            if(nums[Math.abs(n)-1]>0){
                ans.add(Math.abs(n));
                nums[Math.abs(n)-1] = -nums[Math.abs(n)-1];

            }
        }
        return ans;
    }
}