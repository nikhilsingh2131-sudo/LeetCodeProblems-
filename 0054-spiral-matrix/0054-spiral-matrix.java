class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
       
        int m = matrix.length ;
        int n = matrix[0].length;

        List<Integer>ans = new ArrayList<>();

        int left =0;
        int right = n-1;

        int top =0;
        int buttom = m-1;

        while(top <= buttom && left<= right){

            for(int i =left ; i<=right ;i++){
                ans.add(matrix[top][i]);
            }
            top++;

            for(int i =top ; i<=buttom ; i++){
                ans.add(matrix[i][right]);
            }
            right--;

            if(top<=buttom){
                for(int i = right ; i>=left;i--){
                    ans.add(matrix[buttom][i]);
                }
                buttom--;
            }
            if(left<=right){
                for(int i = buttom ;i>=top ;i--){
                   ans.add(matrix[i][left]);
                }
                left++;
            }
            
            
        }
        return ans;
    }
}