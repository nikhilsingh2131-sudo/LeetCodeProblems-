class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int []smaller = nums1.length<=nums2.length?nums1:nums2;
        int[] larger  = nums1.length <= nums2.length ? nums2 : nums1;
        int totallength = smaller.length + larger.length;

        int low = 0;
        int high = smaller.length ;
        while(low <= high){
           
            int partitionX = (low + high) / 2;

            int partitionY = (totallength+1)/2-partitionX;
           

           // left side

            int l1;

            if (partitionX == 0)
                l1 = Integer.MIN_VALUE;
            else
                l1 = smaller[partitionX - 1];

            int l2;

            if (partitionY == 0)
                l2 = Integer.MIN_VALUE;
            else
                l2 = larger[partitionY - 1];

                // right side 
                int r1;

            if (partitionX == smaller.length)
                r1 = Integer.MAX_VALUE;
            else
                r1 = smaller[partitionX];

            int r2;

            if (partitionY == larger.length)
                r2 = Integer.MAX_VALUE;
            else
                r2 = larger[partitionY];

                if(l1<=r2 && l2<=r1){
                   
                   if(totallength %2==0){
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                   }else{
                    return Math.max(l1,l2);
                   }
                }
                else if(l1>r2){
                    high = partitionX-1;
                }else{
                    low = partitionX+1;
                }


        }
        return 0;
        
    }
}