class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length ;
        Map<Integer , Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0)+1);
        }

        for(int x : map.keySet()){
            if(map.get(x)>n/2){
                return x;
            }
        }
        return -1;
    }
}