class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
         ans = new ArrayList<>();

        backtrack(candidates , target  , 0 , new ArrayList<>());
        return ans ;
    }public void backtrack(int[] candidates, int target , int start , List<Integer>temp ){

        if(target==0){
            ans.add(new ArrayList<>(temp));
            return ;
        }

        if(target<0){
            return;
        }

        for(int i = start ; i< candidates.length ; i++){
            temp.add(candidates[i]);

            backtrack(candidates , target - candidates[i] , i , temp);
            temp.remove(temp.size()-1);
        }
        
    }
}