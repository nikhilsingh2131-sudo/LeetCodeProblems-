class Solution {
    public int maxArea(int[] height) {

        int left =0;
        int right =height.length -1;
        int max = 0;
         int lefth =0;
         int righth =0;

        while(left<right){
             lefth = height[left];
            righth = height[right];
            int heights = Math.min(lefth , righth);
            int width = right - left ;
            int area = heights * width ;
            max = Math.max(max , area);
            if(height[left]<height[right]){
                left++;
            }else{
                right --;
            }


        }     
        return max;   
    }
}