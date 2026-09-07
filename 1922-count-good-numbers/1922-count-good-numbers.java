class Solution {

     static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {


        long even = (n+1)/2;
        long odd = n/2;

       long ans = pow(5,even) * pow(4,odd)%MOD;

       return (int) ans ;
        
    }public long pow(long a , long b){
        long res = 1;

        while(b>0){

            if(b%2==1){
                res = res*a%MOD;
            }
            a = a*a%MOD;
            b=b/2;
        }

        return res;
    }
}