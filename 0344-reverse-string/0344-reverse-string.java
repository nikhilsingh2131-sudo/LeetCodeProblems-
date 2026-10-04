class Solution {
    public void reverseString(char[] s) {
       


        solve(s , 0 );
        
    }public void solve(char[]s , int i ){
         int n = s.length;
        if(i>=n/2){
            return;
        }

        char temp = s[i];
        s[i] = s[n-i-1];
        s[n-i-1] = temp;

        solve(s , i+1);
    }
}