class Solution {
    public String decodeString(String s) {
        Stack<Integer> number = new Stack<>();
        Stack<String> string = new Stack<>();

        String current ="";
        int n =0;

        for(char ch : s.toCharArray()){
            if (Character.isDigit(ch)){
                n = n*10 +(ch - '0');
            }else if(ch == '['){
                number.push(n);
                string.push(current);
                current ="";
                n=0;
            }else if(ch==']'){
                String prev = string.pop();
                int count = number.pop();
                String temp ="";

                for(int i =0 ; i<count ;i++){
                    temp += current ;
                }
                current = prev+temp;
            }else{
                current +=ch;
            }

        }
        return current;
        
    }
}