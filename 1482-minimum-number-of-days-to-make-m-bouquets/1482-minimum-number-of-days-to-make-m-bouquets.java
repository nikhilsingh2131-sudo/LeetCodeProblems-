class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if((long) m*k >n){
            return -1;
        }

        int min=0 ;
        int max =0;

        for(int bloom : bloomDay){
            min = Math.min(min , bloom);
            max = Math.max(max , bloom);
        }

        while(min<max){
            int mid = min +(max-min)/2;

            if(possible(bloomDay , m , k , mid)){
                max  = mid;
            }else{
                min = mid+1;
            }
        }
        return min;
    }

    public boolean possible(int[] bloomDay, int m, int k ,int day){
        int boq =0;
        int flower =0;

        for(int bloom : bloomDay){
            if(bloom<=day){
                flower++;

                if(flower==k){
                    boq++;
                    flower=0;
                }
            }else{
                flower=0;
            }
        }

        return boq>=m;

    }


}