class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five =0;
        int ten =0;
        int twenty =0;

        for(int i =0 ;i<bills.length ; i++){
            if(bills[i]==5){
                five++;
            }else if(bills[i]==10){
                if(five<=0){
                    return false;
                }else{
                    five--;
                    ten++;
                }
            }else{
                if(five>0 && ten>0){
                    twenty++;
                    five--;
                    ten--;
                    
                }else if(five>=3) {
                   five -= 3;
                   twenty++;

                }else{
                    return false;
                }
            }
        }
        return true ;
    }
}