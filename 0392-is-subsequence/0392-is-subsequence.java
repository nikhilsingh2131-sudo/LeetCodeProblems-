class Solution {
    public boolean isSubsequence(String s, String t) {

        Queue<Character> q = new LinkedList<>();

        for(char ch : s.toCharArray()){
            q.offer(ch);
        }

        for(char  ch:t.toCharArray()){
            if(!q.isEmpty() && ch == q.peek()){
                q.poll();
            }
        }
        return q.isEmpty();
    }
}