class Solution {
    public int hIndex(int[] citations) {
        int N = citations.length ;

        int left =0;
        int right = citations.length -1 ;

        int index =0 ;
        while(left<= right){
            int mid = left+(right-left)/2;

            if(citations[mid]== N- mid){
               return N-mid;
            }else if(citations[mid]<N-mid){
                left = mid+1;
            }else{
                right =  mid-1;
            }
        }
        return N - left;
    }
}