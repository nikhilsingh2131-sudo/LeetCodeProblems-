class Solution {
    public int smallestIndex(int[] nums) {

        int n= nums.length;

        for(int i =0 ; i< n ; i++){

            int no = nums[i];
            int sum =0;

            while(no>0){
                int digit = no%10;
                sum += digit;
                no = no/10;
                
            }
            if(sum==i){
                return i;
            

            }
        }
        return -1;
    }
}