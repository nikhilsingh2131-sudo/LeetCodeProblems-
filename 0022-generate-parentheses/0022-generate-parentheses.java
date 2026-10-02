class Solution {
    public List<String> generateParenthesis(int n) { 
        List<String> ans = new ArrayList<>();

        helper( "" , n, ans);
        return ans ;
    }public void helper(String curr , int n , List<String>ans){
        if(curr.length() == 2*n){
            if(valid(curr)){
                ans.add(curr);
            }
            return ;
        }

            helper(curr+"(" , n , ans);
            helper(curr+")" , n, ans);
        }
        public boolean valid(String curr){
            int count =0 ;

            for(char ch: curr.toCharArray()){
                if(ch =='('){
                    count ++ ;
                }else{
                    count --;
                     if(count < 0){
                    return false;
                }
                }
            }
            if(count!=0){
                return false;
            }
            return true;
        }
    
}