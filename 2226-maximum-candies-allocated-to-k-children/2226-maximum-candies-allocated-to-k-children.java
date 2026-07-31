class Solution {
    public int maximumCandies(int[] candies, long k) {

        int max =0;

       for(int c:candies){
        max = Math.max(max,c);
       }

      int ans =0;
      int left = 1;
      int right = max;

      while(left<=right){

         int mid=left+(right-left)/2;

        long children =0;

       for(int c:candies){
        children += c/mid;
       }

       if(children>=k){
        ans = mid;

        left = mid+1;
       }else{
        right = mid-1;
       }
      }
      return ans ;

    }
}