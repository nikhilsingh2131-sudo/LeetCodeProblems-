class Solution {
    public String decodeString(String s) {

        Stack<String> st1= new Stack<>();
         Stack<Integer> st2= new Stack<>();

         int num =0 ;
         String current = "";

         for(char ch :s.toCharArray()){
            
            if(Character.isDigit(ch)){
               num = num*10+(ch-'0');
            }else if(ch == '['){
                st2.push(num);
                st1.push(current);

                num=0;
                current ="";
                
            }else if(ch ==']'){
                String prev = st1.pop();
                int repeat = st2.pop();

                String temp ="";

                for(int i =0 ;i<repeat ; i++){
                    temp += current;
                }
                current = prev + temp;
            }else{
                current += ch;
            }
         }

        return current ;
    }
}