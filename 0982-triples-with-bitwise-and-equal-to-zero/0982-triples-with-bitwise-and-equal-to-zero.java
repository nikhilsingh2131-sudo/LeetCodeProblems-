class Solution {
    public int countTriplets(int[] nums) {

        HashMap<Integer , Integer> map = new HashMap<>();

        int n = nums.length ;

        for(int i =0 ; i< n ; i++){
            for(int j =0 ; j< n ; j++){
                int andValue = nums[i] & nums[j];

                map.put(andValue , map.getOrDefault(andValue ,0)+1);
            }
        }

        int ans =0 ;

        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
            int andValue = entry.getKey();
            int freq = entry.getValue();

            for(int k =0 ; k<nums.length ; k++){

                if((andValue & nums[k])==0){
                    ans += freq;
                }
            }
        }
        return ans;
    }
}