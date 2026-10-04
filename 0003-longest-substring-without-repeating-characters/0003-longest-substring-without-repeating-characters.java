class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max =0;
        int left =0;
        Map<Character , Integer> map = new HashMap<>();

        for(int right =0; right< s.length() ; right++){
            char ch = s.charAt(right);

            while(map.containsKey(ch)){
                char leftChar = s.charAt(left);
                

                map.put(leftChar , map.getOrDefault(leftChar , 0)-1);

                if(map.get(leftChar)==0){
                    map.remove(leftChar);
                }
                left++;

            }

            map.put(ch , map.getOrDefault(ch,0)+1);

             int len = right-left+1 ;

           max = Math.max(max , len);

          
        }
        return max;
    }
}