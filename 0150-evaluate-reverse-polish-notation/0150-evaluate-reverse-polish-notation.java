class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int ans =0;
        

        for(String t : tokens){
            if(t.equals("+")){
                int b = st.pop();
                int a = st.pop();
               st.push(a+b);
            }else if(t.equals("-")){
                int b = st.pop();
                int a = st.pop();
                st.push(a-b);
            }else if(t.equals("*")){
                int b=st.pop();
                int a = st.pop();
                st.push(a*b);
            }else if(t.equals("/")){
                int b = st.pop();
                int a = st.pop();
                st.push(a/b);
            }else{
                st.push(Integer.parseInt(t));
            }
        
    }
     return st.peek();
    }
}