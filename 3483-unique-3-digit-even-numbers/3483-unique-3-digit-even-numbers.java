class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        

        for(int i =0 ; i<digits.length ; i++){
            if(digits[i]==0){
                continue;
            }
            for(int j=0;j<digits.length ; j++){
                if(i==j) continue ;

                for(int k=0 ; k<digits.length ; k++){
                    if(k==i || k==j) continue;
                    if (digits[k] % 2 != 0) continue; 

                    int num = 100*digits[i] + 10*digits[j] + 1*digits[k];

                    set.add(num);
                }
            }
            
        }
        return set.size();
     
    }
}