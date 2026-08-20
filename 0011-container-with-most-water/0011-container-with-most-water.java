class Solution {
    public int maxArea(int[] height) {

        int left=0;
        int right =0;

        int i=0 , j=  height.length-1 ;
        int max =0;

        while(i<j){
            left =  height[i];
            right = height[j];
            int h = Math.min(left,right);
            int width = j-i;
            int area = h*width;
            max = Math.max(max, area);
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }
}