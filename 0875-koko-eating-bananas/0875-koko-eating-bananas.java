class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int  max  = 0;
          for(int p : piles){
            max = Math.max(p,max);    
        }

        int min  = 1;

        while(min<max){
            int mid = min+(max-min)/2;
            long hours =0;

            for(int p:piles){
                hours += (p + (long) mid - 1) / mid;
            }

            if(hours<=h){
               
                 max = mid;
            }else{
                min = mid+1;
            }
        }
        return min ;
    }
}