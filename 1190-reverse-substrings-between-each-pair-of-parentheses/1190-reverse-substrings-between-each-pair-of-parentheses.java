class Solution {
    public String reverseParentheses(String s) {

        int n = s.length();
        Stack<Character> st =new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(ch == ')'){
               String temp ="";

               while(st.peek()!='('){
                temp += st.pop();
               }

               st.pop(); //(
               
               for(char c : temp.toCharArray()){
                st.push(c);


               }          
                 }else{
                    st.push(ch);
                 }

        }
         String ans = "";

        while(!st.isEmpty()) {
            ans += st.pop();
        }
        return new StringBuilder(ans).reverse().toString();
        
    }
}