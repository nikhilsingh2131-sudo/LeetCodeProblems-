class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];

        int maxfreq =0;

        int ans =0;
        int left =0;

        for(int right =0 ; right<s.length() ; right++){
            int index = s.charAt(right)-'A';
            freq[index]++;
            maxfreq = Math.max(maxfreq , freq[index]);

            int window = right-left+1;

            if(window-maxfreq>k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            ans = Math.max(ans , right-left+1);
        }
        return ans ;
    }
}