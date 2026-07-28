class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int[]freq = new int[26];
        int [] wid = new int[26];
        int left =0 ; 

        for(char ch : s1.toCharArray()){
            freq[ch-'a']++;
        }

        for(int right =0 ; right<s2.length() ; right++){
            wid[s2.charAt(right)-'a']++;

            if(right-left+1>s1.length()){
                wid[s2.charAt(left)-'a']--;
                left++;
            }

            if(Arrays.equals(freq,wid)){
                return true;
            }
        }
        return false;
        
    }
}