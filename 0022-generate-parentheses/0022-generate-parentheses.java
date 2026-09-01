class Solution {

    private boolean valid(String s){
      int  count  =0;

      for(char ch : s.toCharArray()){
        if(ch=='('){
            count ++;
        }else{
            count--;
        }

        if(count<0){
            return false;
        }
      }

      return count==0;
    }

    public void helper(String curr ,int n ,ArrayList<String> res  ){
        if(curr.length() == 2*n){
           if(valid(curr)){
            res.add(curr);
           }
           return ;
        }

        helper(curr +"(" , n , res);
        helper(curr +")" , n ,res);
    }
    public List<String> generateParenthesis(int n) {

        ArrayList<String> res = new ArrayList<>();
      helper("" , n ,res);
      return res;
        
    }
}