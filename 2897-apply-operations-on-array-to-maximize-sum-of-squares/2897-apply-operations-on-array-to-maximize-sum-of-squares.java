class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int []count =new int[31];
        int mod = 1000000007;

        for(int num : nums){
            for(int i =0 ; i<31 ;  i++){
                if((num&(1<<i))!=0){
                    count[i]++;
                }
            }
        }

        long ans =0;
        
        for(int i =0;i< k ; i++){
            int num=0;

            for(int j =0 ; j<31 ; j++){
                if(count[j]>0){
                    num|=(1<<j);
                    count[j]--;
                }
            }
           ans = (ans + 1L * num * num) % mod;
        }
        return (int)ans ;
    }
}