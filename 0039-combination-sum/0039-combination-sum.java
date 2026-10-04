class Solution {
    List<List<Integer>> ans ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();

        dfs(0 , candidates , target , new ArrayList<>());
        return ans;
        
    }public void dfs(int start ,int[] candidates, int target , List<Integer> temp ){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return ;
        }

        if(target<0){
            return;
        }

        for(int i = start ; i<candidates.length ; i++){
            temp.add(candidates[i]);

            dfs(i , candidates ,target-candidates[i] , temp);

            temp.remove(temp.size()-1);
        }
    }
}