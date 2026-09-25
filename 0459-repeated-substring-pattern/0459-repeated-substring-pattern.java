class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        for(int i =1 ; i<=n/2 ; i++){
            if(n%i==0){
                String sub = s.substring(0,i);

                String temp ="";

                for(int j =0 ; j< n/i ; j++){
                    temp += sub;
                }

                if(temp.equals(s)){
                    return true;
                }
            }
        }

       return false;

        
    }
}