class Solution {
    public void nextPermutation(int[] nums) {

        int n = nums.length;

        int pivot = -1;

        // Find Pivot
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                pivot = i - 1;
                break;
            }
        }

        // Find Swap Index
        if (pivot != -1) {

            int swapidx = pivot;

            for (int i = n - 1; i > pivot; i--) {
                if (nums[i] > nums[pivot]) {
                    swapidx = i;
                    break;
                }
            }

            // Swap
            int temp = nums[pivot];
            nums[pivot] = nums[swapidx];
            nums[swapidx] = temp;
        }

        // Reverse Suffix
        reverse(nums, pivot + 1, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {

        while (left < right) {

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}