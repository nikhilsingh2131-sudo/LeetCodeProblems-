class Solution {
    public String longestPalindrome(String s) {

        if(s==null || s.length()<2){
            return s;
        }
        int start =0;
        int end =0;
        int max =0;
     


        for(int i =0 ; i<s.length() ; i++){
            
            int len1 = expand(s,i,i);
            int len2 = expand(s,i,i+1);

            int len = Math.max(len1 , len2);

            if(max<len){
                start = i-(len-1)/2;
                end = i+len/2;
                max = len;
            }

            }

            return s.substring(start , end+1);
        } private int expand(String s , int left ,  int right){
            while(left>=0 && right< s.length()){
                if(s.charAt(left)!=s.charAt(right)){
                    break;
                }
                left--;
                right++;
            }

            return right-left-1;
        }
}