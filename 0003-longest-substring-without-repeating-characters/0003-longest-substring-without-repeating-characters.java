class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();

        Set<Character> set= new HashSet<>();

        int left=0;
        int max =0;

        for(int right =0 ; right<n ; right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            int len = right-left+1;
            max = Math.max(max , len);
        }
        return max;
    }
}