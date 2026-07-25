class Solution {
    public boolean isPalindrome(String s) {

        char [] temp = new char[s.length()];

        int index =0;

        for(int i =0 ; i< s.length() ;i++){
            char ch = s.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                temp[index++]= Character.toLowerCase(ch);
            }
        }

        int left =0;
        int right = index-1;

        while(left<right){
            if(temp[left]!=temp[right]){
              return false;
            }
            left++;
            right--;
        }

        return true;
        
    }
}