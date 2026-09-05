class Solution {
    public int[] findPeakGrid(int[][] mat) {

        int n = mat.length ;
        int m = mat[0].length ;


        int left = 0;
        int right = m-1;

        while(left<=right){
            int mid = left +(right-left)/2;

            int max=0;

           for (int i = 1; i < n; i++) {
                if (mat[i][mid] > mat[max][mid]) {
                    max = i;
                }
            }

            int leftval = (mid>0)? mat[max][mid-1] : -1;
            int rightval = (mid<m-1)? mat[max][mid+1] :-1;


            if(mat[max][mid]>leftval &&
               mat[max][mid]>rightval){
                return new int[]{max , mid};
               }

               if(rightval > mat[max][mid]){
                left = mid+1;
               }else{
                right = mid-1;
               }
        }
        return new int[]{-1,-1};
    }
}