class Solution {

    public void backtrack(int idx ,String digits ,StringBuilder sb ,List<String> ans , Map<Character, String>map){
        if(sb.length() == digits.length()){
            ans.add(sb.toString());
            return ;
        }

        char c = digits.charAt(idx);

        String choice = map.get(c);

        for(char ch: choice.toCharArray()){
            sb.append(ch);
            backtrack(idx+1 , digits , sb  , ans , map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {

        Map<Character, String>map = new HashMap<>();

        map.put('2' ,"abc");
        map.put('3' ,"def");
        map.put('4' ,"ghi");
        map.put('5' ,"jkl");
        map.put('6' ,"mno");
        map.put('7' ,"pqrs");
        map.put('8' ,"tuv");
        map.put('9' ,"wxyz");

        List<String> ans = new ArrayList<>();


        StringBuilder sb = new StringBuilder();

        backtrack(0,digits , sb  ,  ans , map);

        return ans ;
        
    }
}