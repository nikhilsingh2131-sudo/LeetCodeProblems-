class Solution {
    public int reverseDegree(String s) {

        int n = s.length();
        int no =0;

        for(int i =0 ;i<s.length() ; i++){

            int freq = 'z'  -  s.charAt(i)+1;
            
            no += freq*(i+1); 
        }
        return no;
    }
}