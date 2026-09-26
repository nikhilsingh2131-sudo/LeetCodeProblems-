class Solution {
    public String convertToBase7(int num) {

        if (num == 0) return "0";

        boolean negative = num < 0;
        num = Math.abs(num);

        StringBuilder ans = new StringBuilder();

        while(num>0){
            int rem = num%7;
           ans.insert(0,rem);
            num = num/7;
        }

        if(negative){
            ans.insert(0 , '-');

        }

        return ans.toString();
        
    }
}