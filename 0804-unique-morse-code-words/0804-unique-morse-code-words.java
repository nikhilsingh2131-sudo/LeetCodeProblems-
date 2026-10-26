class Solution {
    public int uniqueMorseRepresentations(String[] words) {
         String[] morse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.",
            "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.."
        };

        Set<String> set = new HashSet<>();

        for(String word : words){
            String s = "";

            for(char ch : word.toCharArray()){
                s+= morse[ch-'a'];
            }

            set.add(s);
        }

        return set.size();
        
    }
}