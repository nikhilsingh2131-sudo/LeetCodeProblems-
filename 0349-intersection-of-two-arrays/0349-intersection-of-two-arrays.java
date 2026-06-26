class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();

        for(int i=0 ; i<nums1.length ; i++){
            set.add(nums1[i]);
        }

        ArrayList<Integer> res = new ArrayList<>();

        for(int i=0 ; i<nums2.length ;i++){
            if(set.contains(nums2[i])){
                res.add(nums2[i]);

                set.remove(nums2[i]);
            }
        }

        int[] ans = new int[res.size()];

        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }

        return ans;
    }
}