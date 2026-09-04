class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int minCap =0;
        int maxCap=0;

        for(int wei : weights){
            minCap = Math.max(minCap , wei);
            maxCap += wei;
        }

        while(minCap < maxCap){
            int mid = minCap +(maxCap-minCap)/2;

            int d=1;
            int sum =0;

            for(int wei:weights){
               if(sum + wei >mid){
                d++;
                sum=0;
               }

               sum+=wei;
            }

            if(d>days){
                minCap = mid+1;
            }else{
                maxCap = mid;
            }
        }
        return minCap;
    }
}