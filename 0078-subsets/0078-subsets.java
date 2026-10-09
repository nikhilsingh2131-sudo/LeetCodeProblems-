class Solution { 
    List<List<Integer>> ans ;
    public List<List<Integer>> subsets(int[] nums) {
        ans= new ArrayList<>();

        backtrack(0 , nums , new ArrayList<>());
        return ans ;
        
    }public void backtrack(int start , int[]nums , List<Integer>temp){
        if(start==nums.length){
            ans.add(new ArrayList<>(temp));
            return ;
        }

        temp.add(nums[start]);
        backtrack(start+1 , nums , temp);
        temp.remove(temp.size()-1);
        backtrack(start + 1, nums, temp);
    }
}