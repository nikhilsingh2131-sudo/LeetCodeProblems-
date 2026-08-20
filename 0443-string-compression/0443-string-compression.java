class Solution {
    public int compress(char[] chars) {
        int n = chars.length ;
        int i =0;
        int write =0;
        while(i<n){
            char current = chars[i];
            int count =0;

            while(i<n && chars[i]==current){
                 count++;
                 i++;
            }
            chars[write++] = current ;

            if(count>1){
                String num=String.valueOf(count);
                for (char ch : num.toCharArray()) {
                    chars[write++] = ch;
                }

            }
        }
        return write;
        
    }
}