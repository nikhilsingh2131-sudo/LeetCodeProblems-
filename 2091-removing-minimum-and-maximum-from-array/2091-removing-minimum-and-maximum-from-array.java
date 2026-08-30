class Solution {
    public int minimumDeletions(int[] nums) {

        int n = nums.length ;
      

        int min = 0 ;
        int max = 0;


        for(int i =0 ; i<nums.length ;i++){
            if(nums[i]>nums[max]){
                max  = i;
            }
            if(nums[i]<nums[min]){
                min = i;
        }
        }

      // min/max ko order me rakhte hain
        int left = Math.min(min, max);
        int right = Math.max(min, max);

        // Case 1: Dono left se
        int case1 = right + 1;

        // Case 2: Dono right se
        int case2 = n - left;

        // Case 3: Ek left se, ek right se
        int case3 = (left + 1) + (n - right);

        return Math.min(case1, Math.min(case2, case3));
        
       
    }
}