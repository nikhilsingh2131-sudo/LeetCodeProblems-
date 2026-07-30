class Solution {
    public boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();
      
      for (char ch : s.toCharArray()) {
    if (Character.isLetterOrDigit(ch)) {
        sb.append(Character.toLowerCase(ch));
    }
}

char[] arr = sb.toString().toCharArray();

    if(arr.length==1){
        return true;
    }

    int i =0;
    int j = arr.length-1;

    while(i<j){
        if(arr[i]!=arr[j]){
            return false;
        }
        i++;
        j--;
    }
        return true;
    }
}