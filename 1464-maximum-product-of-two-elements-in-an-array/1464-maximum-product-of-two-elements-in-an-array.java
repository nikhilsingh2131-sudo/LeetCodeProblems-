class Solution {
    public int maxProduct(int[] nums) {

        int first =0;
        int second =0; 

        int n = nums.length;

        for(int i=0 ;i< n ;i++){
            int curr = nums[i];
            if(curr>first){
                second = first;
                first = curr;
            }else if(curr>second){
                second = curr ;
            }
        }

        return (first-1)*(second-1);
        
    }
}