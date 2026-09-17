class Solution {
    public int longestConsecutive(int[] nums) {

        int n = nums.length ;
        int max =0;

        Set<Integer>set = new TreeSet<>();

        for(int num : nums){
            set.add(num);
        }
 
        for(int num:set){
           

            if(!set.contains(num-1)){
                int count =0;
               

                while(set.contains(num)){
                   num++;
                   count++;
                }

                max = Math.max(count ,max);

            }
        }
        return max;
    }
}