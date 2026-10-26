class Solution {
    public int diagonalSum(int[][] mat) {
        int n =mat.length ;
        int m = mat[0].length ;

     int ans =0;
     int i =0;
     int j =0;
       while(i<n && j<m){
        ans +=mat[i][j];
        i++;
        j++;
       }

       i=0;
       j=m-1;
       while(i<n && j>=0){
        if(i!=j){
        ans += mat[i][j];
        }
        i++;
        j--;
       }
        return ans ;
    }
}