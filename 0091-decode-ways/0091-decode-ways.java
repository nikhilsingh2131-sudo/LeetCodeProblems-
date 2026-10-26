class Solution {
    public int numDecodings(String s) {
        int ways =0 ;
        int n = s.length();
        int [] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(s , 0 , ways, dp);

       
        
    }public int solve(String s , int i , int ways , int [] dp){
        if(i==s.length()){
            return 1 ;
        }

        if(s.charAt(i)=='0'){
            return 0 ;
        }
        if(dp[i]!=-1){
            return dp[i];
        }

        ways = solve(s , i+1 , ways , dp);

        if(i+1 < s.length()){
           int num = Integer.parseInt(s.substring(i, i + 2));


            if(num<=26){
                ways += solve(s , i+2 , ways , dp);
            }
        }

        return dp[i] = ways;
    }
}