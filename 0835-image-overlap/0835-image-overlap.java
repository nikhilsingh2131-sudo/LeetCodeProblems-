class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {

        int n = img1.length ; 
        int count =0;
        int max =0;

        for(int rowoff = -n+1 ; rowoff < n ; rowoff++){
            for(int coloff = -n+1 ;coloff<n; coloff++){
               count = countOverlap(img1 , img2 , rowoff ,coloff);
               max = Math.max(count , max);


            }
        }
        return max;
        
    } public int countOverlap(int[][] A, int[][] B , int rowoff , int coloff){
            int n = A.length ;

            int count =0;

            for(int i =0 ; i<n ; i++){
                for(int j=0 ; j< n ; j++){
                  int  b_i = i+rowoff ;
                  int  b_j = j+ coloff;


                    if(b_i<0 || b_i>=n|| b_j <0 || b_j >= n){
                        continue;
                    }

                   if (A[i][j] == 1 && B[b_i][b_j] == 1) {
                    count++;
                }
                }
            }
            return count;
    }
}