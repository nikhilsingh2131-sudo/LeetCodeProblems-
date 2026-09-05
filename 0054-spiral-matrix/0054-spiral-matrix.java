class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer>ans = new ArrayList<>();

        int top = 0 ;
        int buttom = matrix.length-1 ;
        int left =0;
        int right = matrix[0].length-1;

        while(left<=right && top<=buttom){

            for(int i=left ; i<=right ; i++){
                ans.add(matrix[top][i]);
            }
            top++;

            for(int i = top ; i<= buttom ; i++){
                ans.add(matrix[i][right]);
            }
            right--;

            if(top<=buttom){
                for(int i = right ; i>=left ; i--){
                    ans.add(matrix[buttom][i]);
                }
                buttom--;
            }

            if(left<=right){
                for(int i=buttom ;i>=top ; i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }

        }
       return ans;
    }
}