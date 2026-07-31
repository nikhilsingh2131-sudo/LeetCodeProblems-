class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length ;
        int i =0 , j=0 , k= n-1;

        while(j<=k){
            if(nums[j]==1){
                j++;
            }else if(nums[j]==0){
                int temp = nums[j];
                nums[j]=nums[i];
                nums[i] = temp;
                j++;
                i++;
            }else if(nums[j]==2){
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp ;
                k--;
            }

        }
    
    }
}