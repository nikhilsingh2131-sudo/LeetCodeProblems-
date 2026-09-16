class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int oldcol = image[sr][sc];

        if(oldcol== color){
            return image;
        }

        dfs(image , sr ,sc  ,color ,oldcol);
        return image;
        
    }
    public void dfs(int[][] image, int sr, int sc, int color , int oldcol){

        int n =image.length ;
        int m = image[0].length ;

        if(sr<0 || sc<0 || sr>=n || sc>=m){
            return;
        }

        if(image[sr][sc]!=oldcol){
            return;
        }

        image[sr][sc] = color;

        dfs(image , sr+1 ,sc , color , oldcol);
        dfs(image , sr-1 ,sc , color, oldcol);
        dfs(image , sr ,sc+1 , color , oldcol);
        dfs(image , sr ,sc-1 , color , oldcol);
    }
}