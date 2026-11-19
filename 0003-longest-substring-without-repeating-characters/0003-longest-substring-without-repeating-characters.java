class Solution {
    public int lengthOfLongestSubstring(String s) {

        int max =0;

        int left =0;
        Set<Character>set = new HashSet<>();

        for(int right =0 ; right<s.length() ; right++){
            
            while(set.contains(s.charAt(right)) && left < s.length()){
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