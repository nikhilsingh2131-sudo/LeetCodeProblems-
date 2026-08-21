class Solution {
    public boolean closeStrings(String word1, String word2) {

        HashMap<Character , Integer>mp1 = new HashMap<>();
        HashMap<Character , Integer>mp2 = new HashMap<>();

        for(char ch : word1.toCharArray()){
           mp1.put(ch ,mp1.getOrDefault(ch,0)+1);
        }
        for(char ch : word2.toCharArray()){
           mp2.put(ch ,mp2.getOrDefault(ch,0)+1);
        }

        if(!mp1.keySet().equals(mp2.keySet())){
            return false;
        }
        ArrayList<Integer> freq1 = new ArrayList<>(mp1.values());
        ArrayList<Integer> freq2 = new ArrayList<>(mp2.values());

        Collections.sort(freq1);
        Collections.sort(freq2);

        return freq1.equals(freq2);
    }
}