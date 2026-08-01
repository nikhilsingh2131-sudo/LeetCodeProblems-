class Solution {

    // Final answer store karega
    int count = 0;

    public int reversePairs(int[] nums) {

        // Pure array ko Merge Sort se divide karenge
        mergeSort(nums, 0, nums.length - 1);

        return count;
    }

    private void mergeSort(int[] nums, int left, int right) {

        // Agar sirf ek element hai to already sorted hai
        if (left >= right)
            return;

        // Mid nikal lo
        int mid = left + (right - left) / 2;

        // Left half sort karo
        mergeSort(nums, left, mid);

        // Right half sort karo
        mergeSort(nums, mid + 1, right);

        /*
            Is point par

            Left half  -> Sorted
            Right half -> Sorted

            Ab cross reverse pairs count kar sakte hain.
        */
        countPairs(nums, left, mid, right);

        /*
            Pair count karne ke baad dono sorted arrays
            ko merge kar do taaki upper recursion
            me bhi sorted array mile.
        */
        merge(nums, left, mid, right);
    }

    private void countPairs(int[] nums, int left, int mid, int right) {

        /*
            Left Part

            left ........ mid

            Right Part

            mid+1 ...... right

            Dono already sorted hain.
        */

        int j = mid + 1;

        // Left ke har element ke liye
        for (int i = left; i <= mid; i++) {

            /*
                Jab tak

                nums[i] > 2 * nums[j]

                tab tak j ko aage badhao.

                j kabhi peeche nahi aata.

                Isi wajah se overall O(n) lagta hai.
            */
            while (j <= right && nums[i] > 2L * nums[j]) {
                j++;
            }

            /*
                mid+1 se lekar j-1 tak
                saare valid pairs hain.

                Number of valid elements

                = j-(mid+1)
            */
            count += j - (mid + 1);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {

        // Temporary array
        int[] temp = new int[right - left + 1];

        // Left pointer
        int i = left;

        // Right pointer
        int j = mid + 1;

        // Temp pointer
        int k = 0;

        /*
            Dono sorted arrays ko merge karo.
        */
        while (i <= mid && j <= right) {

            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // Left me jo bach gaya
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // Right me jo bach gaya
        while (j <= right) {
            temp[k++] = nums[j++];
        }

        /*
            Temp array ko original array me
            copy kar do.
        */
        for (int p = 0; p < temp.length; p++) {
            nums[left + p] = temp[p];
        }
    }
}