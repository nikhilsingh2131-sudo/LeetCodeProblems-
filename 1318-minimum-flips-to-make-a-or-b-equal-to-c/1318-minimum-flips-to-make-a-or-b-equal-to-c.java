class Solution {
    public int minFlips(int a, int b, int c) {

        int flip =0;

        for(int i =0 ; i<32 ; i++){
           int  aBit = (a>>i)&1;
            int bBit = (b>>i)&1;
            int cBit = (c>>i)&1;

            if(cBit == 1){
                if(aBit==0 && bBit==0){
                    flip++;
                }
            }else{
                    flip += aBit+bBit;
                }
        }
        return flip ;
    }
}