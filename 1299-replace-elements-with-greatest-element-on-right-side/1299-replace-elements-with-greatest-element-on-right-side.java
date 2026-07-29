class Solution {
    public int[] replaceElements(int[] arr) {
        int []ans = new int[arr.length];
        int prev = -1;

        for(int i =arr.length-1 ; i>=0 ; i--){
            ans[i] = prev;
           prev = Math.max(prev, arr[i]);

        }
        
        return ans ;
    }
}