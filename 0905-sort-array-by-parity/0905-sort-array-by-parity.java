class Solution {
    public int[] sortArrayByParity(int[] nums) {

        for(int i = 0; i < nums.length - 1; i++) {

            if(nums[i] % 2 != 0) {

                int left = i + 1;

                while(left < nums.length && nums[left] % 2 != 0) {
                    left++;
                }

                if(left < nums.length) {
                    int temp = nums[i];
                    nums[i] = nums[left];
                    nums[left] = temp;
                }
            }
        }

        return nums;
    }
}