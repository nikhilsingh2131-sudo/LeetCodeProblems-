class Solution {
    int n ;
    public int maxPalindromes(String s, int k) {

        n = s.length();
        if(k==1){
            return n;
        }
        
        int [][]t = new int[n][n];

        for(int i =0 ;i<n ; i++){
            for(int j=0; j<n ; j++){
                t[i][j] =-1;
            }
        }

       return solve(s,k,0,k-1,t);
    }
    public int solve(String s, int k , int i , int j , int [][]t ){
        if(i>= n || j >= n){
            return 0;
        }

        if(t[i][j]!=-1){
            return t[i][j];
        }

        if(j-i+1>=k && isPalidrome(s ,i , j)){
            int take = 1 + solve(s,k,j+1 , j+k , t);
            int grow = solve(s , k , i , j+1 ,t);
            int slide = solve(s ,k , i+1 , j+1 ,t);

            return t[i][j] = Math.max(take , Math.max(grow , slide));
        }

        int grow = solve(s , k , i , j+1 ,t);
         int slide = solve(s ,k , i+1 , j+1 ,t);

         return t[i][j] = Math.max(grow, slide);
    }
    public boolean isPalidrome(String s ,int left , int right){
        while(left<= right){
            if(s.charAt(left)!= s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}