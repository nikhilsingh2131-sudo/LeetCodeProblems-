class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);

       int diff = arr[1] - arr[0];

       for(int i =1 ; i< arr.length ; i++){
        int x = arr[i] - arr[i-1];
        if(x!=diff) return false;
       }

        return true;
    }
}