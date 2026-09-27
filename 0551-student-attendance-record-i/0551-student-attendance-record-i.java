class Solution {
    public boolean checkRecord(String s) {
        int p =0;
        int a =0 ;
         int l =0;
        int maxL=0;

         for(char ch : s.toCharArray()){
            if(ch=='A'){
                a++;
                maxL = Math.max(maxL , l);
                l=0;
            }else if(ch=='P'){
                p++;
                maxL = Math.max(maxL , l);
                l=0;
            }else{
                l++;
            }
         }

         maxL = Math.max(maxL, l);
        

        return a<2 && maxL<3 ;
    }
}