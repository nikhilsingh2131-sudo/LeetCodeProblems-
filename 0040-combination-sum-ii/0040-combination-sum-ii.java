class Solution {
    List<List<Integer>> ans = new ArrayList<>();
   
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        
      backtrack(candidates , 0 , target);
      
      return ans ;
        
    }public void backtrack(int[] candidates ,int start, int target){
        
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i =start ; i< candidates.length ; i++){

            if(start<i && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
           
            temp.add(candidates[i]);
            backtrack(candidates , i+1, target-candidates[i]);
            temp.remove(temp.size()-1);
        }
    }
}