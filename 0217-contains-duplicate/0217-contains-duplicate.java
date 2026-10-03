class Solution {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int num: nums){
            set.add(num);
        }

        int n = nums.length ;
        int m = set.size();

        return n != m ;
        
    }
}