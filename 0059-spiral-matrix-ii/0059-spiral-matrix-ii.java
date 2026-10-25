class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

      int left =0;
      int right = n-1;
      int top =0;
      int buttom = n-1 ;
      int no=1;

      while(top<=buttom && left<=right){


        for(int i=left ; i<=right ; i++){
            matrix[top][i] = no;
            no++;
        }
        top++;

        for(int i = top ; i<=buttom; i++){
            matrix[i][right] = no;
            no++;
        }
        right--;

        if(top<=buttom){
            for(int i = right ;i>=left ; i--){
                matrix[buttom][i] = no;
                no++;
            }
            buttom--;
        }

        if(left<=right){
            for(int i=buttom ;i>=top ; i--){
                matrix[i][left]=no;
                no++;
            }
            left++;
        }
      }

      return matrix;
    }
}