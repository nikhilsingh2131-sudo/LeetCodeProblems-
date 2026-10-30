class Solution {
    public int characterReplacement(String s, int k) {

        int left =0;
        int ans =0;
        int max = 0;

        int[]freq = new int[26];

        for(int right =0 ; right<s.length() ; right++ ){
            freq[s.charAt(right) - 'A']++;

            max = Math.max(max , freq[s.charAt(right) -'A']);
            int len = right-left+1;

            if(len-max >k){
                freq[s.charAt(left)-'A']--;
                left++;
            }

            ans = Math.max(ans , right-left+1);
        }

        return ans ;
    }
}