class Solution {
    public int longestConsecutive(int[] nums) {
        int ans =0;

        Set<Integer> set =  new HashSet<>();

        for(int i=0 ;i<nums.length ;i++){
            set.add(nums[i]);
        }

        for(int num: set){
            if(!set.contains(num-1)){
                int count =0;
                while(set.contains(num)){
                    count++;
                    num++;
                }
                ans = Math.max(ans,count);
            }

            
        }
        return ans;
    }
}