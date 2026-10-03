class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max =0;

        for(int x: nums){
            set.add(x);
        }

        for(int num : set){
            if(!set.contains(num-1)){
                int count =0;
                int no = num;
                while(set.contains(no)){
                    count++;
                    no++;
                }
                max = Math.max(max , count);
            }
        }
        return max;
    }
}