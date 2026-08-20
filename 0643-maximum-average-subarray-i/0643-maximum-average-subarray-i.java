class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int n = nums.length;


        int sum =0;

        for(int i =0 ; i< k ; i++){
            sum += nums[i];
        }

        int max = sum;

        for(int i =1 ; i<=n-k ; i++){
            sum-=nums[i-1];
            sum+=nums[i+k-1];

            max = Math.max(max , sum);
        }
        return (double) max / k;
    }
}