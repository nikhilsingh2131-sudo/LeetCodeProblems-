class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer>ans = new ArrayList<>();

        HashMap<Integer , Integer>map = new HashMap<>();

        for(int i=0 ; i<nums.length ; i++){
            if(map.containsKey(nums[i])){
                
                    ans.add(nums[i]);
                

            }

            map.put(nums[i] , map.getOrDefault(nums[i] ,0)+1);
        }
        return ans ;
        
    }
}