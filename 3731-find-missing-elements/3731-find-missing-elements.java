class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
          max =Math.max(max , num);
          min= Math.min(min , num);
          if(!set.contains(num)){
            set.add(num);
          }
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = min ; i< max ; i++){
            if(!set.contains(i)){
             ans.add(i);
            }

        }
        return ans ;
        
    }
}