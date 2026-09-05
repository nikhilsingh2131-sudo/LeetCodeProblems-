class Solution {
    public int myAtoi(String s) {

        int n = s.length() ;

        int i =0;

        int sign=1;

        
            while(i<n && s.charAt(i)== ' '){
                i++;
            }


            if (i < n && s.charAt(i) == '-') {
                 sign = -1;
                 i++;
            } else if (i < n && s.charAt(i) == '+') {
                  i++;
            }

            long num = 0;
            while(i<n && Character.isDigit(s.charAt(i))){

                int digit = s.charAt(i)-'0';
                num = num*10 +digit;

                 //  Overflow check
            if (num * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (num * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
                
            }
       

        return (int) (num*sign);
        
    }
}