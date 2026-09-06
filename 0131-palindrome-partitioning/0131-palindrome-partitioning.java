class Solution {
    List<List<String>>ans = new ArrayList<>();
    List<String> path = new ArrayList<>();


    public List<List<String>> partition(String s) {
        backtrack( s , 0);
        return ans ;
        
    }
    public void backtrack(String s , int start){
        if(start==s.length()){
            ans.add(new ArrayList<>(path));
            return ;
        }

        for(int end = start ; end <s.length();end++){
            if(isPalidrome(s , start , end)){
               path.add(s.substring(start,end+1));
               backtrack(s, end+1);
              path.remove(path.size()-1);
            }
        }
    }

    public boolean isPalidrome(String s , int left , int right){

       while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

}