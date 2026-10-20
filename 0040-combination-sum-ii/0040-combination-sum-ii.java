class Solution {
    List<List<Integer>>ans ;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans  = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(0 , candidates, target ,new ArrayList<>());
        return ans;
        
    }public void backtrack(int start , int[] candidates, int target , List<Integer> temp){
        if(target==0){
            ans.add(new ArrayList(temp));
            return;
        }

        if (start  > candidates.length-1){
            return; 
        }

      for(int i =start ; i< candidates.length ;i++){
         if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {
                break;
            }
        temp.add(candidates[i]);
        backtrack(i+1,candidates , target-candidates[i] , temp );
        temp.remove(temp.size()-1);
      }
    }
}