class Solution {
    public int numJewelsInStones(String jewels, String stones) {

        int [] freq = new int[128];

        for(char ch : jewels.toCharArray()){
            freq[ch]++;
        }
        
        int count =0;

        for(char ch: stones.toCharArray()){
            if(freq[ch]>0){
                count++;
            }
        }

        return count ;
    }
}