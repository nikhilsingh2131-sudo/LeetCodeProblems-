class Solution {
    public int missingMultiple(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int i = 1; ; i++) {
            int multiple = i * k;

            if (!set.contains(multiple)) {
                return multiple;
            }
        }
    }
}