class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        char [][] board  = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0,n , ans , board);
        return ans;

        
    }void solve(int row , int n,List<List<String>> ans ,char [][] board){

        if(row==n){
            List<String>temp =new ArrayList<>();

            for(int i=0; i<n; i++){
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }
        

        for(int col = 0; col<n ; col++){
            if(isSafe(row ,n,  col ,board)){
                board[row][col]= 'Q';
                solve(row+1 ,n,ans,board);
                board[row][col]='.';
            }
        }
    }public boolean isSafe(int row ,int n , int col, char[][]board){

        for(int i=0; i<row ; i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }

            for(int i=row-1 , j = col-1 ; i>=0 && j>=0 ;i-- ,j--){
                if(board[i][j]=='Q'){
                    return false;
                }
            }
            // Upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
             }

             return true;
        
    }
}