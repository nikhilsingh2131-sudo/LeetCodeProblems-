class Solution {
    public String toHex(int num) {

        if(num == 0)return "0";
        String hexCode = "0123456789abcdef";
        String ans ="";

        while(num!=0){
            int rem = num&15;

            ans+=hexCode.charAt(rem);

            num>>>=4;

        }

        StringBuilder sb = new StringBuilder(ans);

        return sb.reverse().toString();
        
    }
}