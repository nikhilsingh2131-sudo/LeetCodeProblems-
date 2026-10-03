class Solution {

    class Pair {
        int val;
        int index;

        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    int[] ans;

    public List<Integer> countSmaller(int[] nums) {

        int n = nums.length;

        ans = new int[n];

        Pair[] arr = new Pair[n];

        for(int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        mergeSort(arr, 0, n - 1);

        List<Integer> result = new ArrayList<>();

        for(int x : ans) {
            result.add(x);
        }

        return result;
    }

    public void mergeSort(Pair[] arr, int left, int right) {

        if(left >= right)
            return;

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    public void merge(Pair[] arr, int left, int mid, int right) {

        Pair[] temp = new Pair[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        int rightCount = 0;

        while(i <= mid && j <= right) {

            if(arr[j].val < arr[i].val) {

                temp[k++] = arr[j++];

                rightCount++;

            } else {

                ans[arr[i].index] += rightCount;

                temp[k++] = arr[i++];
            }
        }

        while(i <= mid) {

            ans[arr[i].index] += rightCount;

            temp[k++] = arr[i++];
        }

        while(j <= right) {
            temp[k++] = arr[j++];
        }

        for(int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x];
        }
    }
}