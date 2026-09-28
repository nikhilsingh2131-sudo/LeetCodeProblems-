class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>>ans  = new ArrayList<>();

        boolean[] used = new boolean[nums.length];

        solve(nums , ans , new ArrayList<>() , used );
        return ans ;
        
    }public void solve(int[] nums, List<List<Integer>> ans,
                      List<Integer> temp, boolean[] used ){

    if(temp.size()== nums.length ){
        ans.add(new ArrayList<>(temp));

    }

     for(int i =0 ; i <  nums.length ; i++){
         if(used[i]) {
                continue;
            }
        temp.add(nums[i]);
        used[i] = true;

        solve(nums , ans  , temp , used);
        temp.remove(temp.size() - 1);
        used[i] = false;


     }

                      }
}