import java.util.Stack;

class Solution {
    public int lengthOfLastWord(String s) {

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            st.push(ch);
        }

        // Remove trailing spaces
        while (!st.isEmpty() && st.peek() == ' ') {
            st.pop();
        }

        int count = 0;

        // Count last word
        while (!st.isEmpty() && st.peek() != ' ') {
            st.pop();
            count++;
        }

        return count;
    }
}