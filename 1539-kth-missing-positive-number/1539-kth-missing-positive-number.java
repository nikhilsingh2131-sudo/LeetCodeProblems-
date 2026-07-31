class Solution {
    public int findKthPositive(int[] arr, int k) {

        int current =1; 
        int index=0;
        int count=0;

        while(count<k){
            if(index < arr.length && arr[index]==current){
                index++;
            }else{
                count++;
                if(count==k){
                    return current;
                }
            }
            current++;
        }
        return -1;
        
    }
}