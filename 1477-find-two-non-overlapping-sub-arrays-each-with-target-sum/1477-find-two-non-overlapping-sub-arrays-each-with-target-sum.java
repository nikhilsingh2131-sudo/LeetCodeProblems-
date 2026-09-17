class Solution {
    public int minSumOfLengths(int[] arr, int target) {

         int n = arr.length;
        int[] best = new int[n];

        int INF = Integer.MAX_VALUE;
        
        for (int k = 0; k < n; k++) {
            best[k] = INF;
        }

        int i =0;

        int currsum =0;
        int ans =INF;
        int minLen = INF;

        for(int j =0;j< arr.length ; j++){

            currsum+= arr[j];
            while(currsum>target){
                currsum -= arr[i];
                i++;
            }

            if(currsum==target){
                int len = j-i+1;

                  if (i > 0 && best[i - 1] != INF) {
                    ans = Math.min(ans, len + best[i - 1]);
                }

                minLen = Math.min(minLen, len);
            }

            best[j] = minLen;
        }
     return ans == INF ? -1 : ans;
        
    }
}