class Solution {

    Long dp[][];

  
    public int numDistinct(String s, String t) {

        dp = new Long[s.length()][t.length()];

       return (int) backtrack(s , t , 0, 0);
      
        
    }
    public long backtrack(String s , String t , int i , int j){

        if(j==t.length()){
           return 1;
        }

        if(i==s.length()){
           return 0;
        }

        if(dp[i][j]!=null){
            return dp[i][j];
        }

        if(s.charAt(i) == t.charAt(j)){


         return  dp[i][j] = backtrack(s,t,i+1,j+1)
            
                     + backtrack(s,t,i+1,j);
        }else{
          return  dp[i][j]= backtrack(s,t,i+1,j);
        }
        
    }
}