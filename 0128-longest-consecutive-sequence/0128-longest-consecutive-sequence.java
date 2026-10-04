class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int num:nums){
            set.add(num);
        }

        int max =0;

        for(int num:set){
            int no = num;
            if(!set.contains(no-1)){
                int count =0;

                while(set.contains(no)){
                    count++;
                    no++;

                }

                max = Math.max(max, count);
            }
        }
        return max;
    }
}