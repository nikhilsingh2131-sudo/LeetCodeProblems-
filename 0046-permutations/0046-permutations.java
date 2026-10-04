class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new ArrayList<>());
        return ans ; 
    }public void dfs(int[]nums ,List<Integer> temp){


        if(temp.size()==nums.length){
            ans.add(new ArrayList<>(temp));
            return ;
        }

        for(int i =0;i<nums.length ; i++){
            if(temp.contains(nums[i])){
                continue;
            }

            temp.add(nums[i]);
            dfs(nums,temp);

            temp.remove(temp.size()-1);
        }
    }
}