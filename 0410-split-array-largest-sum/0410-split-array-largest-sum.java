class Solution {
    public int splitArray(int[] nums, int k) {

        int min =0;
        int max =0;
        for(int n :nums){
            min = Math.max(min, n);
            max += n;
        }

        while(min<=max){
            int mid = min+(max-min)/2;

            int p=1;
            int sum=0;
              for(int num:nums){
                if(sum+num>mid){
                    p++;
                    sum=0;
                }

                sum+=num;
              }

              if(p>k){
                min = mid+1;
              }else{
                max = mid-1;
              }


        }
        return min;
    }
}