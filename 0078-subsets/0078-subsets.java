class Solution {
    List<List<Integer>> ans ;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();

        backtrack(0 ,nums , new ArrayList<>() );

        return ans ;
        
    }public void backtrack(int index , int[]nums , List<Integer>curr  ){
        if(index==nums.length ){
            ans.add(new ArrayList<>(curr));
            return ;
        }

        curr.add(nums[index]);

        backtrack(index+1 , nums , curr );

        curr.remove(curr.size()-1);

        backtrack(index+1 , nums , curr );
    }
}