/*class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length ;
        int m = matrix[0].length ;
        
       for(int i =0 ;i<n ;i++){
        int left =0;
        int right = m-1;

        while(left<=right){
            int mid = left+(right-left)/2;

            if(matrix[i][mid]==target){
                return true ;
            }else if(matrix[i][mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
       }
       return false;
    }
} */

// Assume as a 1D Array

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;

        int left = 0;
        int right = n * m - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int row = mid / m;
            int col = mid % m;

            if (matrix[row][col] == target) {
                return true;
            }
            else if (matrix[row][col] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return false;
    }
}