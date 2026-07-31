class Solution {
    public int[] sortEvenOdd(int[] nums) {

        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        // Separate elements based on index
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0)
                even.add(nums[i]);
            else
                odd.add(nums[i]);
        }

        // Sort
        Collections.sort(even);                          // Ascending
        Collections.sort(odd, Collections.reverseOrder()); // Descending

        int e = 0, o = 0;

        // Put back into original array
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0)
                nums[i] = even.get(e++);
            else
                nums[i] = odd.get(o++);
        }

        return nums;
    }
}