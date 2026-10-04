class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        dfs(nums , 0, ans,new ArrayList<>());

        return ans;
        
    }public void dfs(int[] nums , int i , List<List<Integer>> ans , List<Integer> temp ){

        if(i==nums.length){
            ans.add(new ArrayList<>(temp));
            return ;
        }

        temp.add(nums[i]);
        dfs(nums , i+1 , ans , temp);

        temp.remove(temp.size()-1);
        dfs(nums , i+1, ans , temp);
    }
}