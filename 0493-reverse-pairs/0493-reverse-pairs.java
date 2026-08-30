class Solution {
            int count =0 ;

    public int reversePairs(int[] nums) {
        

        mergeSort(nums , 0 , nums.length-1);

       

       return count;
       
        
    }

    private void mergeSort(int[]nums , int left , int right ){

        if(left>=right){
            return ;
        }
        int mid = left +(right - left)/2;

        mergeSort(nums , left , mid ) ;
        mergeSort(nums , mid+1 , right );
         merge(nums , left , mid ,right  );

         
    }

    private int merge(int[] nums , int left ,int mid , int right){

      
        int j = mid+1;

        for(int i = left ; i<= mid ; i++){
            while(j<=right && (long)nums[i]>2L*nums[j]){
                j++;
            }

            count += j-(mid+1);
        }


        int i = left;
          j = mid+1;
        int k =0;
        int [] temp = new int[right-left+1];

        while(i<=mid && j<= right){
            if(nums[i]<nums[j]){
            
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
           
        }

        while(i<=mid){
            temp[k++] = nums[i++]; 
        }

        while(j<=right){
            temp[k++] = nums[j++];
        }

        for(int x =0 ; x< temp.length ; x++ ){
            nums[x+left] = temp[x];
        }
        return count ;
    }
}