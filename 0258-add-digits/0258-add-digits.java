class Solution {
    public int addDigits(int num) {

        int n = num;
        

        while(n>=10){
            int no = n;
            int sum =0;
            while(no>0){
                sum += no%10;
                no = no/10;
            }
            n = sum ;
          
        }
        return n ;
    }
}