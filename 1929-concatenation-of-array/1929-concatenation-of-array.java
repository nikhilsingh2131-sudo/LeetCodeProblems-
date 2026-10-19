class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length ;

        int[] ans = new int[2*n];

        for(int i =0 ;i<2*n ; i++){
            int curr  = i%n;

            ans[i] = nums[curr];
        }
        return ans;
    }
}