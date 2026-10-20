class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int m= g.length;
        int n = s.length ;

        Arrays.sort(g);
        Arrays.sort(s);

        int left = 0 ;
        int right = 0;

        while(left<m && right<n){
            if(g[left]<=s[right]){
             
                left++;
                right++;
            }else{
                right++;
            }
        }
        
        return left;
    }
}