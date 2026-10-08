class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        int ans=0;
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        for(int num : set){
            int count =0;
            if(!set.contains(num-1)){
                while(set.contains(num)){
                    count++;
                    num++;
                }
            }
            ans = Math.max(ans , count);
        }
        return ans;
    }
}