class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();

        int max =0;
        for(int i =0 ; i<s.length() ; i++){
            char ch = s.charAt(i);

            int j=i+1;
            int count=1;
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));

            while(j<n && !set.contains(s.charAt(j))){
              set.add(s.charAt(j));
              count++;
              j++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}