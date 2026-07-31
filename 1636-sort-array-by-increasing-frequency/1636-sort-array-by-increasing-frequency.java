class Solution {
    public int[] frequencySort(int[] nums) {

        Map<Integer, Integer> freq = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // int[] -> Integer[]
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        // Sort
        Arrays.sort(arr, (a, b) -> {
            if (freq.get(a).equals(freq.get(b))) {
                return b - a;              // Same frequency -> larger value first
            }
            return freq.get(a) - freq.get(b); // Smaller frequency first
        });

        // Integer[] -> int[]
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }

        return nums;
    }
}