class Solution {
    public int reverseBits(int n) {

        int ans =0;

        for(int i =0 ; i<32; i++){
            int bits = n&1;

            ans = (ans<<1)|bits;

            n = n>>1;
        }
        return ans ;
        
    }
}